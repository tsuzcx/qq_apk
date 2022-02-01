package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.comic.ui.QQComicTabBarView;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;

public class WebviewFragmentTabBarBuilder
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_web_view_tab_bar_map.yml", version=3)
  public static HashMap<String, Class<? extends IWebViewTabBar>> a = new HashMap();
  
  static
  {
    a.put("1", QQComicTabBarView.class);
  }
  
  public static View a(Context paramContext, Intent paramIntent, List<WebViewTabBarData> paramList, TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    int i;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("tabBarStyle", 0);
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tab bar style =");
      ((StringBuilder)localObject1).append(i);
      QLog.i("WebviewFragmentTabBarBuilder", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = String.valueOf(i);
    Object localObject2;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (a.containsKey(localObject1)))
    {
      localObject1 = (Class)a.get(localObject1);
      try
      {
        localObject1 = ((Class)localObject1).getDeclaredConstructor(new Class[] { Context.class });
        ((Constructor)localObject1).setAccessible(true);
        localObject1 = (IWebViewTabBar)((Constructor)localObject1).newInstance(new Object[] { paramContext });
      }
      catch (Throwable localThrowable)
      {
        QLog.e("WebviewFragmentTabBarBuilder", 1, "createTabBar By nameSpace Fail,", localThrowable);
      }
    }
    else
    {
      localObject2 = null;
    }
    Object localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = new SwiftFragmentTabBar(paramContext);
    }
    ((IWebViewTabBar)localObject3).a(paramIntent, paramList, paramOnTabChangeListener);
    return ((IWebViewTabBar)localObject3).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebviewFragmentTabBarBuilder
 * JD-Core Version:    0.7.0.1
 */