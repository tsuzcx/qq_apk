package com.tencent.mobileqq.webprocess;

import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.biz.webviewplugin.PtloginPlugin;
import com.tencent.biz.webviewplugin.QzoneWebViewOfflinePlugin;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.antiphing.AntiphingHandler;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webview.WebSecurityPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import java.util.ArrayList;
import java.util.List;

public class WebAccelerateHelper$CommonJsPluginFactory
{
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new AntiphingHandler());
    localArrayList.add(new WebSecurityPlugin());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new WebSoPlugin());
    localArrayList.add(new ReportPlugin());
    localArrayList.add(new OfflinePlugin());
    localArrayList.add(new PtloginPlugin());
    localArrayList.add(new WebViewJumpPlugin());
    localArrayList.add(new EventApiPlugin());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new QzoneWebViewOfflinePlugin());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory
 * JD-Core Version:    0.7.0.1
 */