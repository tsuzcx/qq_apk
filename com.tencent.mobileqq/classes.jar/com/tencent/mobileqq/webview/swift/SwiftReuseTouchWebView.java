package com.tencent.mobileqq.webview.swift;

import akut;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;

public class SwiftReuseTouchWebView
  extends TouchWebView
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static SwiftReuseTouchWebView b;
  public static int c;
  public int a;
  private SwiftReuseTouchWebView jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView;
  private int d;
  
  private SwiftReuseTouchWebView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
  }
  
  public static SwiftReuseTouchWebView a(Context paramContext)
  {
    SwiftReuseTouchWebView localSwiftReuseTouchWebView = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (b != null)
      {
        localSwiftReuseTouchWebView = b;
        b = localSwiftReuseTouchWebView.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView;
        localSwiftReuseTouchWebView.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView = null;
        c -= 1;
      }
      if (localSwiftReuseTouchWebView == null) {
        return new SwiftReuseTouchWebView(new MutableContextWrapper(paramContext));
      }
    }
    localSwiftReuseTouchWebView.clearHistory();
    localSwiftReuseTouchWebView.jdField_a_of_type_Int = 1;
    localSwiftReuseTouchWebView.d += 1;
    localSwiftReuseTouchWebView.onResume();
    ((MutableContextWrapper)localSwiftReuseTouchWebView.getContext()).setBaseContext(paramContext);
    return localSwiftReuseTouchWebView;
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 0;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (c < 4)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView = b;
        b = this;
        c += 1;
        i = 1;
      }
      if (i != 0)
      {
        ((MutableContextWrapper)getContext()).setBaseContext(BaseApplicationImpl.sApplication);
        if (!paramBoolean)
        {
          a();
          onPause();
        }
        return;
      }
    }
    super.destroy();
  }
  
  public boolean canGoBack()
  {
    if (1 == this.jdField_a_of_type_Int)
    {
      Object localObject = copyBackForwardList();
      if ((localObject != null) && (((WebBackForwardList)localObject).getSize() > 0))
      {
        localObject = ((WebBackForwardList)localObject).getItemAtIndex(0);
        if ((localObject != null) && ("about:blank".equals(((WebHistoryItem)localObject).getUrl()))) {
          return super.canGoBackOrForward(-2);
        }
      }
      return super.canGoBack();
    }
    return super.canGoBack();
  }
  
  public void destroy()
  {
    if (this.d > 3)
    {
      super.destroy();
      return;
    }
    if (!"about:blank".equals(getUrl())) {}
    try
    {
      stopLoading();
      a("about:blank");
      clearHistory();
      clearView();
      new Handler(Looper.getMainLooper()).postDelayed(new akut(this), 1000L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("SwiftReuseTouchWebView", 1, "destroy error:" + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView
 * JD-Core Version:    0.7.0.1
 */