package com.tencent.mobileqq.minigame.publicaccount;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.web.QQGameWebViewBuilder;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;

public class MiniGamePublicAccountWebViewBuilder
  extends QQGameWebViewBuilder
{
  public MiniGamePublicAccountWebViewBuilder(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView);
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    super.bindJavaScript(paramArrayList);
    paramArrayList.add(new MiniGamePublicAccountWebViewJsPlugin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */