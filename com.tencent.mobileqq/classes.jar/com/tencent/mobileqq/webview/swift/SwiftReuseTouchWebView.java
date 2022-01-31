package com.tencent.mobileqq.webview.swift;

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
  public static int b;
  private static SwiftReuseTouchWebView b;
  public int a;
  private SwiftReuseTouchWebView jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView;
  private int c;
  
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
      QLog.i("SwiftReuseTouchWebView", 1, "sPool acquire:" + jdField_b_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView);
      if (jdField_b_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView != null)
      {
        localSwiftReuseTouchWebView = jdField_b_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView;
        jdField_b_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView = localSwiftReuseTouchWebView.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView;
        localSwiftReuseTouchWebView.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView = null;
        jdField_b_of_type_Int -= 1;
      }
      if (localSwiftReuseTouchWebView == null) {
        return new SwiftReuseTouchWebView(new MutableContextWrapper(paramContext));
      }
    }
    localSwiftReuseTouchWebView.clearHistory();
    localSwiftReuseTouchWebView.jdField_a_of_type_Int = 1;
    localSwiftReuseTouchWebView.c += 1;
    localSwiftReuseTouchWebView.onResume();
    ((MutableContextWrapper)localSwiftReuseTouchWebView.getContext()).setBaseContext(paramContext);
    return localSwiftReuseTouchWebView;
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Int < 4)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView = jdField_b_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView;
        jdField_b_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView = this;
        jdField_b_of_type_Int += 1;
        i = 1;
      }
      if (i != 0)
      {
        ((MutableContextWrapper)getContext()).setBaseContext(BaseApplicationImpl.sApplication);
        if (!paramBoolean)
        {
          resetForReuse();
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
    if (this.c > 3)
    {
      super.destroy();
      return;
    }
    if (!"about:blank".equals(getUrl())) {}
    try
    {
      stopLoading();
      loadUrlOriginal("about:blank");
      clearHistory();
      clearView();
      new Handler(Looper.getMainLooper()).postDelayed(new SwiftReuseTouchWebView.1(this), 1000L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView
 * JD-Core Version:    0.7.0.1
 */