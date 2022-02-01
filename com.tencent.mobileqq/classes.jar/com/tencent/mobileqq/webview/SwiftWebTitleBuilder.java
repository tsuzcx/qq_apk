package com.tencent.mobileqq.webview;

import android.content.Intent;
import com.tencent.comic.ui.QQComicTitleBarView;
import com.tencent.mobileqq.qcircle.api.hybird.QCircleTitleBarView;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webview.swift.QzoneSwitchFragmentTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class SwiftWebTitleBuilder
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_browser_title_map.yml", version=4)
  public static final HashMap<String, Class<? extends SwiftIphoneTitleBarUI>> a = new HashMap();
  
  static
  {
    a.put("4", QCircleTitleBarView.class);
    a.put("2", QzoneSwitchFragmentTitleBarUI.class);
    a.put("1", QQComicTitleBarView.class);
  }
  
  public static SwiftIphoneTitleBarUI a(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    int i;
    if ((paramSwiftBrowserUIStyleHandler.a != null) && (paramSwiftBrowserUIStyleHandler.a.getIntent() != null)) {
      i = paramSwiftBrowserUIStyleHandler.a.getIntent().getIntExtra("titleBarStyle", 0);
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("title bar style is");
      ((StringBuilder)localObject).append(i);
      QLog.i("SwiftWebTitleBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (Class)a.get(String.valueOf(i));
    if (localObject == null) {
      return new SwiftIphoneTitleBarUI(paramSwiftBrowserUIStyleHandler);
    }
    try
    {
      localObject = ((Class)localObject).getDeclaredConstructor(new Class[] { SwiftBrowserUIStyleHandler.class });
      ((Constructor)localObject).setAccessible(true);
      localObject = (SwiftIphoneTitleBarUI)((Constructor)localObject).newInstance(new Object[] { paramSwiftBrowserUIStyleHandler });
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    return new SwiftIphoneTitleBarUI(paramSwiftBrowserUIStyleHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.SwiftWebTitleBuilder
 * JD-Core Version:    0.7.0.1
 */