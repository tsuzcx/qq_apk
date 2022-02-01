package com.tencent.tav.core;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.Surface;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.CodecHelper;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AssetWriter
  implements AssetWriterInput.StatusListener, IContextCreate
{
  public static final int MAX_BIT_RATE = 8000000;
  private static final String TAG = "AssetWriter";
  private List<Integer> availableMediaTypes;
  private String directoryForTemporaryFiles;
  private ExportConfig encodeOption;
  private EncoderWriter encoderWriter;
  private CMTime endTime = new CMTime(9223372036854775807L);
  private int errCode;
  private HashMap<AssetWriterInput, AssetWriter.AssetWriterStatus> inputStatusHashMap = new HashMap();
  private List<AssetWriterInput> inputs = new ArrayList();
  private List<MetadataItem> metadata;
  private String outputFileType;
  private Surface rendSurface;
  private RenderContext renderContext;
  private RenderContextParams renderContextParams;
  private boolean shouldOptimizeForNetworkUse;
  private CMTime startTime = new CMTime(0L);
  private AssetWriter.AssetWriterStatus status;
  private String videoOutputPath;
  
  public AssetWriter(String paramString1, String paramString2)
  {
    this.videoOutputPath = paramString1;
    this.outputFileType = paramString2;
  }
  
  private void updateAssetStatus()
  {
    Iterator localIterator = this.inputs.iterator();
    int i = 1;
    AssetWriterInput localAssetWriterInput;
    int j;
    if (localIterator.hasNext())
    {
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
      if (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriter.AssetWriterStatus.AssetWriterStatusCompleted) {}
      for (j = 1;; j = 0)
      {
        i = j & i;
        break;
      }
    }
    if (i != 0) {
      this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled;
    }
    do
    {
      return;
      while (!localIterator.hasNext())
      {
        localIterator = this.inputs.iterator();
        i = 1;
        if (localIterator.hasNext())
        {
          localAssetWriterInput = (AssetWriterInput)localIterator.next();
          if ((this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriter.AssetWriterStatus.AssetWriterStatusWriting) || (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriter.AssetWriterStatus.AssetWriterStatusCompleted)) {}
          for (j = 1;; j = 0)
          {
            i = j & i;
            break;
          }
        }
        if (i != 0)
        {
          this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusWriting;
          return;
        }
        localIterator = this.inputs.iterator();
        while (localIterator.hasNext())
        {
          localAssetWriterInput = (AssetWriterInput)localIterator.next();
          if (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriter.AssetWriterStatus.AssetWriterStatusFailed)
          {
            this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusFailed;
            return;
          }
        }
        localIterator = this.inputs.iterator();
      }
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
    } while (this.inputStatusHashMap.get(localAssetWriterInput) != AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled);
    this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled;
  }
  
  public void addInput(@NonNull AssetWriterInput paramAssetWriterInput)
  {
    if (canAddInput(paramAssetWriterInput))
    {
      this.inputs.add(paramAssetWriterInput);
      paramAssetWriterInput.addStatusListener(this);
    }
  }
  
  public boolean canAddInput(@NonNull AssetWriterInput paramAssetWriterInput)
  {
    Iterator localIterator = this.inputs.iterator();
    while (localIterator.hasNext()) {
      if (((AssetWriterInput)localIterator.next()).getMediaType() == paramAssetWriterInput.getMediaType()) {
        return false;
      }
    }
    return true;
  }
  
  public boolean canApplyOutputSettings(HashMap<String, Object> paramHashMap, int paramInt)
  {
    int j = 2;
    int i = -1;
    boolean bool = true;
    String str;
    label55:
    label100:
    int k;
    if (paramInt == 1)
    {
      if (paramHashMap.containsKey("mime"))
      {
        str = (String)paramHashMap.get("mime");
        if (!paramHashMap.containsKey("width")) {
          break label150;
        }
        paramInt = ((Integer)paramHashMap.get("width")).intValue();
        if (paramHashMap.containsKey("height")) {
          i = ((Integer)paramHashMap.get("height")).intValue();
        }
        if (!paramHashMap.containsKey("frame-rate")) {
          break label155;
        }
        j = ((Integer)paramHashMap.get("frame-rate")).intValue();
        if (!paramHashMap.containsKey("bitrate")) {
          break label162;
        }
      }
      label150:
      label155:
      label162:
      for (k = ((Integer)paramHashMap.get("bitrate")).intValue();; k = 8000000)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label169;
        }
        return CodecHelper.checkVideoOutSupported(paramInt, i, j, k, str);
        str = "video/avc";
        break;
        paramInt = -1;
        break label55;
        j = 30;
        break label100;
      }
      label169:
      return (paramInt > 0) && (i > 0);
    }
    if (paramInt == 2)
    {
      if (paramHashMap.containsKey("mime"))
      {
        str = (String)paramHashMap.get("mime");
        paramInt = j;
        if (paramHashMap.containsKey("aac-profile")) {
          paramInt = ((Integer)paramHashMap.get("aac-profile")).intValue();
        }
        if (!paramHashMap.containsKey("bitrate")) {
          break label325;
        }
        i = ((Integer)paramHashMap.get("bitrate")).intValue();
        label253:
        if (!paramHashMap.containsKey("channel-count")) {
          break label331;
        }
        j = ((Integer)paramHashMap.get("channel-count")).intValue();
        label276:
        if (!paramHashMap.containsKey("sample-rate")) {
          break label337;
        }
      }
      label325:
      label331:
      label337:
      for (k = ((Integer)paramHashMap.get("sample-rate")).intValue();; k = 44100)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label344;
        }
        return CodecHelper.checkAudioOutSupported(i, j, k, str);
        str = "audio/mp4a-latm";
        break;
        i = 8000000;
        break label253;
        j = 1;
        break label276;
      }
      label344:
      if ((paramInt > 0) && (i > 0) && (j > 0) && (k > 0)) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return false;
  }
  
  public void cancelWriting()
  {
    if (this.encoderWriter != null)
    {
      this.encoderWriter.stop();
      this.encoderWriter = null;
    }
    Iterator localIterator = this.inputs.iterator();
    while (localIterator.hasNext())
    {
      AssetWriterInput localAssetWriterInput = (AssetWriterInput)localIterator.next();
      this.inputStatusHashMap.put(localAssetWriterInput, AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled);
    }
    this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled;
  }
  
  public Surface createInputSurface()
  {
    if (this.encoderWriter != null) {
      return this.encoderWriter.createInputSurface();
    }
    return null;
  }
  
  public EncoderWriter encoderWriter()
  {
    return this.encoderWriter;
  }
  
  public void endSessionAtSourceTime(CMTime paramCMTime)
  {
    this.endTime = paramCMTime;
  }
  
  public boolean finishWriting()
  {
    if (this.encoderWriter != null)
    {
      this.encoderWriter.stop();
      this.encoderWriter = null;
    }
    this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusCompleted;
    if (this.renderContext != null)
    {
      this.renderContext.release();
      this.renderContext = null;
    }
    if (this.rendSurface != null)
    {
      this.rendSurface.release();
      this.rendSurface = null;
    }
    return true;
  }
  
  public List<Integer> getAvailableMediaTypes()
  {
    return this.availableMediaTypes;
  }
  
  public String getDirectoryForTemporaryFiles()
  {
    return this.directoryForTemporaryFiles;
  }
  
  public int getErrCode()
  {
    return this.errCode;
  }
  
  public List<AssetWriterInput> getInputs()
  {
    return this.inputs;
  }
  
  public List<MetadataItem> getMetadata()
  {
    return this.metadata;
  }
  
  public String getOutputFileType()
  {
    return this.outputFileType;
  }
  
  public RenderContextParams getRenderContextParams()
  {
    return this.renderContextParams;
  }
  
  public AssetWriter.AssetWriterStatus getStatus()
  {
    return this.status;
  }
  
  public String getVideoOutputPath()
  {
    return this.videoOutputPath;
  }
  
  public boolean isShouldOptimizeForNetworkUse()
  {
    return this.shouldOptimizeForNetworkUse;
  }
  
  public RenderContext renderContext()
  {
    if ((this.renderContext == null) && (this.encoderWriter != null))
    {
      this.rendSurface = this.encoderWriter.createInputSurface();
      this.renderContext = new RenderContext(this.encoderWriter.getOutWidth(), this.encoderWriter.getOutHeight(), this.rendSurface);
      this.renderContext.setParams(this.renderContextParams);
    }
    return this.renderContext;
  }
  
  public void setDirectoryForTemporaryFiles(String paramString)
  {
    this.directoryForTemporaryFiles = paramString;
  }
  
  public void setEncodeOption(ExportConfig paramExportConfig)
  {
    this.encodeOption = paramExportConfig;
  }
  
  public void setMetadata(List<MetadataItem> paramList)
  {
    this.metadata = paramList;
  }
  
  public void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    this.renderContextParams = paramRenderContextParams;
    if (this.renderContext != null) {
      this.renderContext.setParams(paramRenderContextParams);
    }
  }
  
  public void setShouldOptimizeForNetworkUse(boolean paramBoolean)
  {
    this.shouldOptimizeForNetworkUse = paramBoolean;
  }
  
  public void startSessionAtSourceTime(CMTime paramCMTime)
  {
    this.startTime = paramCMTime;
  }
  
  @RequiresApi(api=18)
  public boolean startWriting()
  {
    if (this.videoOutputPath == null) {
      return false;
    }
    cancelWriting();
    try
    {
      this.encoderWriter = new EncoderWriter(this.videoOutputPath);
      this.encoderWriter.setEncodeOption(this.encodeOption);
      Iterator localIterator = this.inputs.iterator();
      while (localIterator.hasNext()) {
        ((AssetWriterInput)localIterator.next()).initConfig(this);
      }
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.inputStatusHashMap.clear();
      if (this.encoderWriter != null)
      {
        this.encoderWriter.stop();
        this.encoderWriter = null;
      }
      return false;
    }
  }
  
  public void statusChanged(AssetWriterInput paramAssetWriterInput, AssetWriter.AssetWriterStatus paramAssetWriterStatus)
  {
    this.inputStatusHashMap.put(paramAssetWriterInput, paramAssetWriterStatus);
    paramAssetWriterInput = this.status;
    updateAssetStatus();
    if ((paramAssetWriterInput != this.status) && (this.status == AssetWriter.AssetWriterStatus.AssetWriterStatusWriting))
    {
      paramAssetWriterInput = this.inputs.iterator();
      while (paramAssetWriterInput.hasNext()) {
        paramAssetWriterStatus = (AssetWriterInput)paramAssetWriterInput.next();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriter
 * JD-Core Version:    0.7.0.1
 */