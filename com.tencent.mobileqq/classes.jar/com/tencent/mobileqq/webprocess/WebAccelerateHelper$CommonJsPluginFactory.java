package com.tencent.mobileqq.webprocess;

import aavt;
import aknb;
import asnj;
import athj;
import beey;
import beez;
import belw;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.List;
import zej;
import zes;
import zfn;
import zfs;
import zgm;

public class WebAccelerateHelper$CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new asnj());
    localArrayList.add(new aknb());
    localArrayList.add(new beey());
    localArrayList.add(new beez());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new zgm());
    localArrayList.add(new zfs());
    localArrayList.add(new zej());
    localArrayList.add(new zes());
    localArrayList.add(new belw());
    localArrayList.add(new athj());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new zfn());
    localArrayList.add(new aavt());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory
 * JD-Core Version:    0.7.0.1
 */