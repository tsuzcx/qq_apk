package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.io.File;
import java.io.IOException;

public class TavExporter
{
  private final String a;
  private final ExportConfig b;
  private final TAVComposition c;
  private AssetExportSession d;
  private TavExporter.ExportListener e;
  private volatile boolean f;
  private volatile boolean g;
  
  public TavExporter(TAVComposition paramTAVComposition)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TavExporter@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.a = localStringBuilder.toString();
    this.c = paramTAVComposition;
    this.b = new ExportConfig(720, 1280);
    this.b.setVideoFrameRate(30);
  }
  
  @NonNull
  private File b(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString;
    }
    try
    {
      if (paramString.createNewFile()) {
        return paramString;
      }
      throw new RuntimeException("创建输出文件失败");
    }
    catch (IOException paramString)
    {
      Logger.e(this.a, "export: ", paramString);
      throw new RuntimeException("创建输出文件失败", paramString);
    }
  }
  
  public void a()
  {
    AssetExportSession localAssetExportSession = this.d;
    if (localAssetExportSession != null)
    {
      this.f = true;
      localAssetExportSession.cancelExport();
    }
    this.g = false;
  }
  
  public void a(int paramInt)
  {
    this.b.setVideoBitRate(paramInt);
  }
  
  public void a(TavExporter.ExportListener paramExportListener)
  {
    this.e = paramExportListener;
  }
  
  public void a(CGSize paramCGSize)
  {
    this.b.setOutputSize((int)paramCGSize.width, (int)paramCGSize.height);
  }
  
  public void a(String paramString)
  {
    Object localObject1 = this.d;
    if (localObject1 != null)
    {
      ((AssetExportSession)localObject1).cancelExport();
      this.d = null;
    }
    localObject1 = new TAVCompositionBuilder(this.c).buildSource();
    Object localObject2 = ((TAVSource)localObject1).getAsset();
    this.d = new AssetExportSession((Asset)localObject2, this.b);
    this.d.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, ((Asset)localObject2).getDuration()));
    this.d.setAudioMix(((TAVSource)localObject1).getAudioMix());
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("export composition duration: ");
    localStringBuilder.append(((Asset)localObject2).getDuration());
    Logger.i(str, localStringBuilder.toString());
    localObject2 = b(paramString);
    this.d.setOutputFilePath(((File)localObject2).getAbsolutePath());
    this.d.setOutputFileType("mp4");
    this.d.setVideoComposition(((TAVSource)localObject1).getVideoComposition());
    this.d.exportAsynchronouslyWithCompletionHandler(new TavExporter.MyExportCallbackHandler(this, paramString));
    this.g = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavExporter
 * JD-Core Version:    0.7.0.1
 */