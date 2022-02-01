package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import bics;
import com.tencent.mobileqq.widget.TabBarView;
import java.util.List;

public class SwiftFragmentTabBar
  extends TabBarView
{
  public SwiftFragmentTabBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(List<WebViewTabBarData> paramList, bics parambics)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      super.a(((WebViewTabBarData)paramList.get(i)).tabName);
      i += 1;
    }
    super.setOnTabChangeListener(parambics);
    super.setSelectedTab(0, false);
    super.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFragmentTabBar
 * JD-Core Version:    0.7.0.1
 */