package com.tencent.mobileqq.webprocess;

import aarc;
import aarl;
import aasg;
import aasl;
import aatf;
import acll;
import amkw;
import avep;
import avzm;
import bidt;
import bidu;
import bikp;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.List;

public class WebAccelerateHelper$CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new avep());
    localArrayList.add(new amkw());
    localArrayList.add(new bidt());
    localArrayList.add(new bidu());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new aatf());
    localArrayList.add(new aasl());
    localArrayList.add(new aarc());
    localArrayList.add(new aarl());
    localArrayList.add(new bikp());
    localArrayList.add(new avzm());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new aasg());
    localArrayList.add(new acll());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory
 * JD-Core Version:    0.7.0.1
 */