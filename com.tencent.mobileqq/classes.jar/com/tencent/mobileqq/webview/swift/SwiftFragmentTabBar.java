package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import java.util.List;

@KeepClassConstructor
public class SwiftFragmentTabBar
  extends TabBarView
  implements IWebViewTabBar
{
  public SwiftFragmentTabBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(Intent paramIntent, List<WebViewTabBarData> paramList, TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    if (paramList != null)
    {
      if (paramList.size() < 1) {
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
  
  public View getTabBarView()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFragmentTabBar
 * JD-Core Version:    0.7.0.1
 */