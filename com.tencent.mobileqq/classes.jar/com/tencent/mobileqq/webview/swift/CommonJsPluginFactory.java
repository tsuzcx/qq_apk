package com.tencent.mobileqq.webview.swift;

import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.biz.webviewplugin.PtloginPlugin;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.gamecenter.wadl.biz.jsplugin.GameCenterInterruptPlugin;
import com.tencent.gdtad.web.GdtWebReportPlugin;
import com.tencent.mobileqq.antiphing.AntiphingHandler;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webview.WebForceHttpsPlugin;
import com.tencent.mobileqq.webview.WebSecurityPluginV2;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommonJsPluginFactory
{
  public static final String TAG = "CommonJsPluginFactory";
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_common_js_plugin.yml", version=2)
  public static ArrayList<Class<? extends WebViewPlugin>> sCommonJsPluginList = new ArrayList();
  
  static
  {
    sCommonJsPluginList.add(GameCenterInterruptPlugin.class);
    sCommonJsPluginList.add(AntiphingHandler.class);
    sCommonJsPluginList.add(WebForceHttpsPlugin.class);
    sCommonJsPluginList.add(WebSecurityPluginV2.class);
    sCommonJsPluginList.add(VasWebReport.class);
    sCommonJsPluginList.add(WebSoPlugin.class);
    sCommonJsPluginList.add(ReportPlugin.class);
    sCommonJsPluginList.add(OfflinePlugin.class);
    sCommonJsPluginList.add(PtloginPlugin.class);
    sCommonJsPluginList.add(WebViewJumpPlugin.class);
    sCommonJsPluginList.add(EventApiPlugin.class);
    sCommonJsPluginList.add(UiApiPlugin.class);
    sCommonJsPluginList.add(OpenCenterPlugin.class);
    sCommonJsPluginList.add(MiniAppPlugin.class);
    sCommonJsPluginList.add(QzoneWebViewOfflinePlugin.class);
    sCommonJsPluginList.add(GdtWebReportPlugin.class);
  }
  
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = sCommonJsPluginList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Class)localIterator.next()).newInstance());
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CommonJsPluginFactory", 1, "getCommonJsPlugin Fail,", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.CommonJsPluginFactory
 * JD-Core Version:    0.7.0.1
 */