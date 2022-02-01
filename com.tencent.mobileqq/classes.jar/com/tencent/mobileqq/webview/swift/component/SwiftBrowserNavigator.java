package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.INavigationProcess;
import com.tencent.mobileqq.webview.swift.injector.SwiftBrowserNavigatorInjectUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class SwiftBrowserNavigator
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  private static ArrayList<INavigationProcess> a = SwiftBrowserNavigatorInjectUtil.a();
  
  public boolean a(Intent paramIntent)
  {
    Activity localActivity = this.b.b();
    String str = paramIntent.getStringExtra("url");
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      if (((INavigationProcess)localIterator.next()).a(paramIntent, localActivity, str)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b(Intent paramIntent)
  {
    Activity localActivity = this.b.b();
    String str = paramIntent.getStringExtra("url");
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      if (((INavigationProcess)localIterator.next()).b(paramIntent, localActivity, str)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserNavigator
 * JD-Core Version:    0.7.0.1
 */