package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import java.util.List;

public class SwiftFragmentTabBar
  extends TabBarView
{
  public SwiftFragmentTabBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(List paramList, TabBarView.OnTabChangeListener paramOnTabChangeListener)
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
    super.setOnTabChangeListener(paramOnTabChangeListener);
    super.setSelectedTab(0, false);
    super.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFragmentTabBar
 * JD-Core Version:    0.7.0.1
 */