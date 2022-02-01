package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import java.util.List;

public abstract interface IWebViewTabBar
{
  public abstract void a(Intent paramIntent, List<WebViewTabBarData> paramList, TabBarView.OnTabChangeListener paramOnTabChangeListener);
  
  public abstract View getTabBarView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.IWebViewTabBar
 * JD-Core Version:    0.7.0.1
 */