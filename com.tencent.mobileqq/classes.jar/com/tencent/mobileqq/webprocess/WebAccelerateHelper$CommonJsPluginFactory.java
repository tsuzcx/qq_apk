package com.tencent.mobileqq.webprocess;

import ahhs;
import airb;
import aqst;
import armm;
import bcbo;
import bcbp;
import bcim;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.List;
import xlb;
import xlk;
import xmf;
import xmk;
import xne;
import zcf;

public class WebAccelerateHelper$CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new aqst());
    localArrayList.add(new airb());
    localArrayList.add(new bcbo());
    localArrayList.add(new bcbp());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new xne());
    localArrayList.add(new xmk());
    localArrayList.add(new xlb());
    localArrayList.add(new xlk());
    localArrayList.add(new bcim());
    localArrayList.add(new armm());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new xmf());
    localArrayList.add(new zcf());
    localArrayList.add(new ahhs());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory
 * JD-Core Version:    0.7.0.1
 */