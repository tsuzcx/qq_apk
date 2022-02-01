package cooperation.qzone.webviewwrapper;

import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.biz.webviewplugin.PtloginPlugin;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.antiphing.AntiphingHandler;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webview.swift.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.ArrayList;
import java.util.List;

final class QzoneWebViewBaseBuilder$1
  extends CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new AntiphingHandler());
    localArrayList.add(new OfflinePlugin());
    localArrayList.add(new ReportPlugin());
    localArrayList.add(new PtloginPlugin());
    localArrayList.add(new WebViewJumpPlugin());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new EventApiPlugin());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add((WebViewPlugin)((IMiniAppService)QRoute.api(IMiniAppService.class)).createMiniAppWebViewPlugin());
    localArrayList.add((WebViewPlugin)((IQzoneWebViewPluginHelper)QRoute.api(IQzoneWebViewPluginHelper.class)).getQzoneWebViewOfflinePlugin());
    localArrayList.add(new QzoneWebMusicJsPlugin());
    localArrayList.add(new WebSoPlugin());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder.1
 * JD-Core Version:    0.7.0.1
 */