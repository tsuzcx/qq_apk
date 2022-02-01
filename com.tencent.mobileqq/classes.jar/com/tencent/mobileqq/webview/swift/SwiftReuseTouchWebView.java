package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import mqq.app.MobileQQ;

public class SwiftReuseTouchWebView
  extends TouchWebView
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static SwiftReuseTouchWebView b;
  public static int c = 0;
  private SwiftReuseTouchWebView jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView;
  public int b;
  private int d = 0;
  
  private SwiftReuseTouchWebView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = 0;
  }
  
  public static SwiftReuseTouchWebView a(Context paramContext)
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sPool acquire:");
        ((StringBuilder)localObject1).append(jdField_b_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView);
        QLog.i("SwiftReuseTouchWebView", 1, ((StringBuilder)localObject1).toString());
        if (jdField_b_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView != null)
        {
          localObject1 = jdField_b_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView;
          jdField_b_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView = ((SwiftReuseTouchWebView)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView;
          ((SwiftReuseTouchWebView)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView = null;
          c -= 1;
          if (localObject1 == null) {
            return new SwiftReuseTouchWebView(new MutableContextWrapper(paramContext));
          }
          ((SwiftReuseTouchWebView)localObject1).clearHistory();
          ((SwiftReuseTouchWebView)localObject1).jdField_b_of_type_Int = 1;
          ((SwiftReuseTouchWebView)localObject1).d += 1;
          ((SwiftReuseTouchWebView)localObject1).onResume();
          ((MutableContextWrapper)((SwiftReuseTouchWebView)localObject1).getContext()).setBaseContext(paramContext);
          return localObject1;
        }
      }
      Object localObject1 = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        int j = c;
        i = 1;
        if (j < 4)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView = jdField_b_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView;
          jdField_b_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView = this;
          c += 1;
          if (i != 0)
          {
            ((MutableContextWrapper)getContext()).setBaseContext(MobileQQ.sMobileQQ);
            if (!paramBoolean)
            {
              resetForReuse();
              onPause();
            }
            return;
          }
          super.destroy();
          return;
        }
      }
      int i = 0;
    }
  }
  
  public boolean canGoBack()
  {
    if (1 == this.jdField_b_of_type_Int)
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
    if (!"about:blank".equals(getUrl())) {
      try
      {
        stopLoading();
        loadUrlOriginal("about:blank");
        clearHistory();
        clearView();
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("destroy error:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("SwiftReuseTouchWebView", 1, localStringBuilder.toString());
      }
    }
    new Handler(Looper.getMainLooper()).postDelayed(new SwiftReuseTouchWebView.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView
 * JD-Core Version:    0.7.0.1
 */