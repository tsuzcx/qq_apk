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
  private TavExporter.ExportListener jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter$ExportListener;
  private AssetExportSession jdField_a_of_type_ComTencentTavCoreAssetExportSession;
  private final ExportConfig jdField_a_of_type_ComTencentTavCoreExportConfig;
  private final TAVComposition jdField_a_of_type_ComTencentTavkitCompositionTAVComposition;
  private final String jdField_a_of_type_JavaLangString = "TavExporter@" + Integer.toHexString(hashCode());
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public TavExporter(TAVComposition paramTAVComposition)
  {
    this.jdField_a_of_type_ComTencentTavkitCompositionTAVComposition = paramTAVComposition;
    this.jdField_a_of_type_ComTencentTavCoreExportConfig = new ExportConfig(720, 1280);
    this.jdField_a_of_type_ComTencentTavCoreExportConfig.setVideoFrameRate(30);
  }
  
  @NonNull
  private File a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {}
    for (;;)
    {
      return paramString;
      try
      {
        if (paramString.createNewFile()) {
          continue;
        }
        throw new RuntimeException("创建输出文件失败");
      }
      catch (IOException paramString)
      {
        Logger.e(this.jdField_a_of_type_JavaLangString, "export: ", paramString);
        throw new RuntimeException("创建输出文件失败", paramString);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTavCoreAssetExportSession != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.cancelExport();
    }
    this.b = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentTavCoreExportConfig.setVideoBitRate(paramInt);
  }
  
  public void a(TavExporter.ExportListener paramExportListener)
  {
    this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter$ExportListener = paramExportListener;
  }
  
  public void a(CGSize paramCGSize)
  {
    this.jdField_a_of_type_ComTencentTavCoreExportConfig.setOutputSize((int)paramCGSize.width, (int)paramCGSize.height);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentTavCoreAssetExportSession != null)
    {
      this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.cancelExport();
      this.jdField_a_of_type_ComTencentTavCoreAssetExportSession = null;
    }
    TAVSource localTAVSource = new TAVCompositionBuilder(this.jdField_a_of_type_ComTencentTavkitCompositionTAVComposition).buildSource();
    Object localObject = localTAVSource.getAsset();
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession = new AssetExportSession((Asset)localObject, this.jdField_a_of_type_ComTencentTavCoreExportConfig);
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, ((Asset)localObject).getDuration()));
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.setAudioMix(localTAVSource.getAudioMix());
    Logger.i(this.jdField_a_of_type_JavaLangString, "export composition duration: " + ((Asset)localObject).getDuration());
    localObject = a(paramString);
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.setOutputFilePath(((File)localObject).getAbsolutePath());
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.setOutputFileType("mp4");
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.setVideoComposition(localTAVSource.getVideoComposition());
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.exportAsynchronouslyWithCompletionHandler(new TavExporter.MyExportCallbackHandler(this, paramString));
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavExporter
 * JD-Core Version:    0.7.0.1
 */