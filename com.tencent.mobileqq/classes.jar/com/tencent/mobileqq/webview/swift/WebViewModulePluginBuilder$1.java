package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessForWebPlugin;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.WebSecurityPluginV2;
import java.util.ArrayList;
import java.util.List;

final class WebViewModulePluginBuilder$1
  extends CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new WebSecurityPluginV2());
    localArrayList.add(new EventApiPlugin());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new TogetherBusinessForWebPlugin());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewModulePluginBuilder.1
 * JD-Core Version:    0.7.0.1
 */