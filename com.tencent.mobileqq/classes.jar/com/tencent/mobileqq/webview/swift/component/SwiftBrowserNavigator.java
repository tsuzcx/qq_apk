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
  private static ArrayList<INavigationProcess> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList = SwiftBrowserNavigatorInjectUtil.a();
  }
  
  public boolean a(Intent paramIntent)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    String str = paramIntent.getStringExtra("url");
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((INavigationProcess)localIterator.next()).a(paramIntent, localActivity, str)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b(Intent paramIntent)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    String str = paramIntent.getStringExtra("url");
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((INavigationProcess)localIterator.next()).b(paramIntent, localActivity, str)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserNavigator
 * JD-Core Version:    0.7.0.1
 */