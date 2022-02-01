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
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public TavExporter(TAVComposition paramTAVComposition)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TavExporter@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentTavkitCompositionTAVComposition = paramTAVComposition;
    this.jdField_a_of_type_ComTencentTavCoreExportConfig = new ExportConfig(720, 1280);
    this.jdField_a_of_type_ComTencentTavCoreExportConfig.setVideoFrameRate(30);
  }
  
  @NonNull
  private File a(String paramString)
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
      Logger.e(this.jdField_a_of_type_JavaLangString, "export: ", paramString);
      throw new RuntimeException("创建输出文件失败", paramString);
    }
  }
  
  public void a()
  {
    AssetExportSession localAssetExportSession = this.jdField_a_of_type_ComTencentTavCoreAssetExportSession;
    if (localAssetExportSession != null)
    {
      this.jdField_a_of_type_Boolean = true;
      localAssetExportSession.cancelExport();
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
    Object localObject1 = this.jdField_a_of_type_ComTencentTavCoreAssetExportSession;
    if (localObject1 != null)
    {
      ((AssetExportSession)localObject1).cancelExport();
      this.jdField_a_of_type_ComTencentTavCoreAssetExportSession = null;
    }
    localObject1 = new TAVCompositionBuilder(this.jdField_a_of_type_ComTencentTavkitCompositionTAVComposition).buildSource();
    Object localObject2 = ((TAVSource)localObject1).getAsset();
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession = new AssetExportSession((Asset)localObject2, this.jdField_a_of_type_ComTencentTavCoreExportConfig);
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, ((Asset)localObject2).getDuration()));
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.setAudioMix(((TAVSource)localObject1).getAudioMix());
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("export composition duration: ");
    localStringBuilder.append(((Asset)localObject2).getDuration());
    Logger.i(str, localStringBuilder.toString());
    localObject2 = a(paramString);
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.setOutputFilePath(((File)localObject2).getAbsolutePath());
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.setOutputFileType("mp4");
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.setVideoComposition(((TAVSource)localObject1).getVideoComposition());
    this.jdField_a_of_type_ComTencentTavCoreAssetExportSession.exportAsynchronouslyWithCompletionHandler(new TavExporter.MyExportCallbackHandler(this, paramString));
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavExporter
 * JD-Core Version:    0.7.0.1
 */