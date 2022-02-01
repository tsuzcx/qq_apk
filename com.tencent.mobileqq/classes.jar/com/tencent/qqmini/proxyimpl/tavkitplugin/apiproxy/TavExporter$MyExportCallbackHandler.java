package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tav.decoder.logger.Logger;

class TavExporter$MyExportCallbackHandler
  implements AssetExportSession.ExportCallbackHandler
{
  private final String jdField_a_of_type_JavaLangString;
  
  public TavExporter$MyExportCallbackHandler(TavExporter paramTavExporter, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void handlerCallback(AssetExportSession paramAssetExportSession)
  {
    if (TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter) == null) {
      return;
    }
    switch (TavExporter.1.a[paramAssetExportSession.getStatus().ordinal()])
    {
    default: 
      return;
    case 1: 
      Logger.i(TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter), "export progress: " + paramAssetExportSession.getProgress());
      if (!TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter)) {
        TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter).a();
      }
      TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter).a(paramAssetExportSession.getProgress());
      TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter, true);
      return;
    case 2: 
      Logger.i(TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter), "export progress finished");
      TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter).a(this.jdField_a_of_type_JavaLangString);
      TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter, false);
      return;
    case 3: 
    case 4: 
      Logger.i(TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter), "export error");
      TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter).a(paramAssetExportSession);
      TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter, false);
      return;
    }
    Logger.i(TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter), "export cancel");
    if (TavExporter.b(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter))
    {
      TavExporter.b(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter, false);
      TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter).b();
    }
    TavExporter.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavExporter, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavExporter.MyExportCallbackHandler
 * JD-Core Version:    0.7.0.1
 */