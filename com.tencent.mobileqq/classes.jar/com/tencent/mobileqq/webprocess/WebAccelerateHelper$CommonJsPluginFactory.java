package com.tencent.mobileqq.webprocess;

import ahhu;
import aird;
import aqsr;
import armk;
import bcba;
import bcbb;
import bchy;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.List;
import xle;
import xln;
import xmi;
import xmn;
import xnh;
import zci;

public class WebAccelerateHelper$CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new aqsr());
    localArrayList.add(new aird());
    localArrayList.add(new bcba());
    localArrayList.add(new bcbb());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new xnh());
    localArrayList.add(new xmn());
    localArrayList.add(new xle());
    localArrayList.add(new xln());
    localArrayList.add(new bchy());
    localArrayList.add(new armk());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new xmi());
    localArrayList.add(new zci());
    localArrayList.add(new ahhu());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory
 * JD-Core Version:    0.7.0.1
 */