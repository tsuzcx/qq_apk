package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import cooperation.comic.ui.QQComicTabBarView;
import java.util.List;

public class WebviewFragmentTabBarBuilder
{
  public static View a(Context paramContext, Intent paramIntent, List paramList, TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    int i = 0;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("tabBarStyle", 0);
    }
    if (i == 1)
    {
      paramContext = new QQComicTabBarView(paramContext);
      paramContext.a(paramIntent, paramList, paramOnTabChangeListener);
      return paramContext;
    }
    paramContext = new SwiftFragmentTabBar(paramContext);
    paramContext.a(paramList, paramOnTabChangeListener);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebviewFragmentTabBarBuilder
 * JD-Core Version:    0.7.0.1
 */