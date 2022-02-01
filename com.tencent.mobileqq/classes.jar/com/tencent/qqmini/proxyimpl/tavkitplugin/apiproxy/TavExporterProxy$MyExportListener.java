package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.util.Log;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.decoder.logger.Logger;
import org.json.JSONException;

class TavExporterProxy$MyExportListener
  implements TavExporter.ExportListener
{
  private final TavExporter b;
  
  TavExporterProxy$MyExportListener(TavExporterProxy paramTavExporterProxy, TavExporter paramTavExporter)
  {
    this.b = paramTavExporter;
  }
  
  private void a(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      paramString1 = ObjConvector.a(this.b, paramString1, paramString2, paramObject);
      this.a.a("tav_export", paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      Logger.e(this.a.a, "trySubscribe: ", paramString1);
    }
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    String str = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExporting() called with: progress = [");
    localStringBuilder.append(paramFloat);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
    a("progress", "progress", Float.valueOf(paramFloat));
  }
  
  public void a(AssetExportSession paramAssetExportSession)
  {
    String str = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExportError() called with: assetExportSession = [");
    localStringBuilder.append(paramAssetExportSession);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
    a("failed", "error", paramAssetExportSession.getThrowable());
  }
  
  public void a(String paramString)
  {
    String str = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExportCompleted() called with: exportPath = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
    a("success", "outputURL", this.a.d.getWxFilePath(paramString));
  }
  
  public void b()
  {
    Logger.d(this.a.a, "onExportCancel() called");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavExporterProxy.MyExportListener
 * JD-Core Version:    0.7.0.1
 */