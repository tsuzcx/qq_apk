package com.tencent.mobileqq.webprocess;

import aabq;
import aabz;
import aacu;
import aacz;
import aadt;
import abve;
import almv;
import atza;
import autn;
import bgtd;
import bgte;
import bgzx;
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
    localArrayList.add(new atza());
    localArrayList.add(new almv());
    localArrayList.add(new bgtd());
    localArrayList.add(new bgte());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new aadt());
    localArrayList.add(new aacz());
    localArrayList.add(new aabq());
    localArrayList.add(new aabz());
    localArrayList.add(new bgzx());
    localArrayList.add(new autn());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new aacu());
    localArrayList.add(new abve());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory
 * JD-Core Version:    0.7.0.1
 */