package com.tencent.tav.core;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.Surface;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
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
  CMTime startTime = new CMTime(0L);
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
    int j;
    AssetWriterInput localAssetWriterInput;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      j = 0;
      if (!bool) {
        break;
      }
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
      if (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriter.AssetWriterStatus.AssetWriterStatusCompleted) {
        j = 1;
      }
      i &= j;
    }
    if (i != 0)
    {
      this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled;
      return;
    }
    localIterator = this.inputs.iterator();
    i = 1;
    while (localIterator.hasNext())
    {
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
      if ((this.inputStatusHashMap.get(localAssetWriterInput) != AssetWriter.AssetWriterStatus.AssetWriterStatusWriting) && (this.inputStatusHashMap.get(localAssetWriterInput) != AssetWriter.AssetWriterStatus.AssetWriterStatusCompleted)) {
        j = 0;
      } else {
        j = 1;
      }
      i &= j;
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
    while (localIterator.hasNext())
    {
      localAssetWriterInput = (AssetWriterInput)localIterator.next();
      if (this.inputStatusHashMap.get(localAssetWriterInput) == AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled) {
        this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled;
      }
    }
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
  
  public void cancelWriting()
  {
    Object localObject = this.encoderWriter;
    if (localObject != null)
    {
      ((EncoderWriter)localObject).stop();
      this.encoderWriter = null;
    }
    localObject = this.inputs.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AssetWriterInput localAssetWriterInput = (AssetWriterInput)((Iterator)localObject).next();
      this.inputStatusHashMap.put(localAssetWriterInput, AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled);
    }
    this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusCancelled;
  }
  
  public Surface createInputSurface()
  {
    EncoderWriter localEncoderWriter = this.encoderWriter;
    if (localEncoderWriter != null) {
      return localEncoderWriter.createInputSurface();
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
    Object localObject = this.encoderWriter;
    if (localObject != null)
    {
      ((EncoderWriter)localObject).stop();
      this.encoderWriter = null;
    }
    this.status = AssetWriter.AssetWriterStatus.AssetWriterStatusCompleted;
    localObject = this.renderContext;
    if (localObject != null)
    {
      ((RenderContext)localObject).release();
      this.renderContext = null;
    }
    localObject = this.rendSurface;
    if (localObject != null)
    {
      ((Surface)localObject).release();
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
    if (this.renderContext == null)
    {
      EncoderWriter localEncoderWriter = this.encoderWriter;
      if (localEncoderWriter != null)
      {
        this.rendSurface = localEncoderWriter.createInputSurface();
        this.renderContext = new RenderContext(this.encoderWriter.getOutWidth(), this.encoderWriter.getOutHeight(), this.rendSurface);
        this.renderContext.setParams(this.renderContextParams);
      }
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
    RenderContext localRenderContext = this.renderContext;
    if (localRenderContext != null) {
      localRenderContext.setParams(paramRenderContextParams);
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
      Logger.e("AssetWriter", "startWriting: ", localException);
      this.inputStatusHashMap.clear();
      EncoderWriter localEncoderWriter = this.encoderWriter;
      if (localEncoderWriter != null)
      {
        localEncoderWriter.stop();
        this.encoderWriter = null;
      }
    }
    return false;
  }
  
  public void statusChanged(AssetWriterInput paramAssetWriterInput, AssetWriter.AssetWriterStatus paramAssetWriterStatus)
  {
    this.inputStatusHashMap.put(paramAssetWriterInput, paramAssetWriterStatus);
    paramAssetWriterInput = this.status;
    updateAssetStatus();
    paramAssetWriterStatus = this.status;
    if ((paramAssetWriterInput != paramAssetWriterStatus) && (paramAssetWriterStatus == AssetWriter.AssetWriterStatus.AssetWriterStatusWriting))
    {
      paramAssetWriterInput = this.inputs.iterator();
      while (paramAssetWriterInput.hasNext()) {
        paramAssetWriterStatus = (AssetWriterInput)paramAssetWriterInput.next();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriter
 * JD-Core Version:    0.7.0.1
 */