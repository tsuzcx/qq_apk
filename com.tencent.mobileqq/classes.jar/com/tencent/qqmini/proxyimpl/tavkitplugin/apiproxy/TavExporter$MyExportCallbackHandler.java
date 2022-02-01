package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tav.decoder.logger.Logger;

class TavExporter$MyExportCallbackHandler
  implements AssetExportSession.ExportCallbackHandler
{
  private final String b;
  
  public TavExporter$MyExportCallbackHandler(TavExporter paramTavExporter, String paramString)
  {
    this.b = paramString;
  }
  
  public void handlerCallback(AssetExportSession paramAssetExportSession)
  {
    if (TavExporter.a(this.a) == null) {
      return;
    }
    int i = TavExporter.1.a[paramAssetExportSession.getStatus().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 4))
        {
          if (i != 5) {
            return;
          }
          Logger.i(TavExporter.b(this.a), "export cancel");
          if (TavExporter.d(this.a))
          {
            TavExporter.b(this.a, false);
            TavExporter.a(this.a).b();
          }
          TavExporter.a(this.a, false);
          return;
        }
        Logger.i(TavExporter.b(this.a), "export error");
        TavExporter.a(this.a).a(paramAssetExportSession);
        TavExporter.a(this.a, false);
        return;
      }
      Logger.i(TavExporter.b(this.a), "export progress finished");
      TavExporter.a(this.a).a(this.b);
      TavExporter.a(this.a, false);
      return;
    }
    String str = TavExporter.b(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("export progress: ");
    localStringBuilder.append(paramAssetExportSession.getProgress());
    Logger.i(str, localStringBuilder.toString());
    if (!TavExporter.c(this.a)) {
      TavExporter.a(this.a).a();
    }
    TavExporter.a(this.a).a(paramAssetExportSession.getProgress());
    TavExporter.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavExporter.MyExportCallbackHandler
 * JD-Core Version:    0.7.0.1
 */