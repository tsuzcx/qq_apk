package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.util.Log;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.decoder.logger.Logger;
import org.json.JSONException;

class TavExporterProxy$MyExportListener
  implements TavExporter.ExportListener
{
  private final TavExporter jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter;
  
  TavExporterProxy$MyExportListener(TavExporterProxy paramTavExporterProxy, TavExporter paramTavExporter)
  {
    this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter = paramTavExporter;
  }
  
  private void a(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      paramString1 = ObjConvector.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter, paramString1, paramString2, paramObject);
      this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporterProxy.a("tav_export", paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      Logger.e(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporterProxy.jdField_a_of_type_JavaLangString, "trySubscribe: ", paramString1);
    }
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    Log.d(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporterProxy.jdField_a_of_type_JavaLangString, "onExporting() called with: progress = [" + paramFloat + "]");
    a("progress", "progress", Float.valueOf(paramFloat));
  }
  
  public void a(AssetExportSession paramAssetExportSession)
  {
    Log.d(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporterProxy.jdField_a_of_type_JavaLangString, "onExportError() called with: assetExportSession = [" + paramAssetExportSession + "]");
    a("failed", "error", paramAssetExportSession.getThrowable());
  }
  
  public void a(String paramString)
  {
    Log.d(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporterProxy.jdField_a_of_type_JavaLangString, "onExportCompleted() called with: exportPath = [" + paramString + "]");
    a("success", "outputURL", this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporterProxy.jdField_a_of_type_ComTencentQqminiSdkCoreManagerMiniAppFileManager.getWxFilePath(paramString));
  }
  
  public void b()
  {
    Logger.d(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporterProxy.jdField_a_of_type_JavaLangString, "onExportCancel() called");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavExporterProxy.MyExportListener
 * JD-Core Version:    0.7.0.1
 */