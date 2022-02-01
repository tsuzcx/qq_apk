package com.tencent.mobileqq.webprocess;

import abbc;
import abbl;
import abcg;
import abcl;
import abdf;
import acur;
import amgh;
import auub;
import avob;
import bhma;
import bhmb;
import bhta;
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
    localArrayList.add(new auub());
    localArrayList.add(new amgh());
    localArrayList.add(new bhma());
    localArrayList.add(new bhmb());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new abdf());
    localArrayList.add(new abcl());
    localArrayList.add(new abbc());
    localArrayList.add(new abbl());
    localArrayList.add(new bhta());
    localArrayList.add(new avob());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new abcg());
    localArrayList.add(new acur());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory
 * JD-Core Version:    0.7.0.1
 */