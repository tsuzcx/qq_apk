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
  public static int c = 0;
  private static final Object e = new Object();
  private static SwiftReuseTouchWebView f;
  public int b = 0;
  private SwiftReuseTouchWebView d;
  private int g = 0;
  
  private SwiftReuseTouchWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static SwiftReuseTouchWebView b(Context paramContext)
  {
    for (;;)
    {
      synchronized (e)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sPool acquire:");
        ((StringBuilder)localObject1).append(f);
        QLog.i("SwiftReuseTouchWebView", 1, ((StringBuilder)localObject1).toString());
        if (f != null)
        {
          localObject1 = f;
          f = ((SwiftReuseTouchWebView)localObject1).d;
          ((SwiftReuseTouchWebView)localObject1).d = null;
          c -= 1;
          if (localObject1 == null) {
            return new SwiftReuseTouchWebView(new MutableContextWrapper(paramContext));
          }
          ((SwiftReuseTouchWebView)localObject1).clearHistory();
          ((SwiftReuseTouchWebView)localObject1).b = 1;
          ((SwiftReuseTouchWebView)localObject1).g += 1;
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
      synchronized (e)
      {
        int j = c;
        i = 1;
        if (j < 4)
        {
          this.d = f;
          f = this;
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
    if (1 == this.b)
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
    if (this.g > 3)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView
 * JD-Core Version:    0.7.0.1
 */