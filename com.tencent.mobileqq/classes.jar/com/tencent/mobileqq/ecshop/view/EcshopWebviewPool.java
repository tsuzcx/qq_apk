package com.tencent.mobileqq.ecshop.view;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class EcshopWebviewPool
{
  private static volatile EcshopWebviewPool a;
  private HashMap<String, EcshopWebview> b = new HashMap();
  private byte[] c = new byte[0];
  private Handler d = new Handler(Looper.getMainLooper());
  
  public static EcshopWebviewPool a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new EcshopWebviewPool();
        }
      }
      finally {}
    }
    return a;
  }
  
  public EcshopWebview a(Context paramContext, String paramString)
  {
    label182:
    for (;;)
    {
      try
      {
        Object localObject;
        synchronized (this.c)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("【getWebView】= ");
            ((StringBuilder)localObject).append(this.b.size());
            ((StringBuilder)localObject).append(" preLoadUrl: ");
            ((StringBuilder)localObject).append(paramString);
            QLog.i("Ecshop_EcshopWebviewPool", 2, ((StringBuilder)localObject).toString());
          }
          if (this.b.size() > 0)
          {
            paramString = (EcshopWebview)this.b.get(paramString);
          }
          else
          {
            localObject = EcshopWebview.b(paramContext);
            if (StringUtil.isEmpty(paramString)) {
              break label182;
            }
            this.b.put(paramString, localObject);
            break label182;
          }
          if (paramString != null)
          {
            localObject = (ViewGroup)paramString.getParent();
            if (localObject != null) {
              ((ViewGroup)localObject).removeView(paramString);
            }
            ((MutableContextWrapper)paramString.getContext()).setBaseContext(paramContext);
          }
          else
          {
            paramString = EcshopWebview.b(paramContext);
          }
          return paramString;
        }
        paramString = (String)localObject;
      }
      catch (Throwable paramString)
      {
        QLog.e("Ecshop_EcshopWebviewPool", 1, QLog.getStackTraceString(paramString));
        return EcshopWebview.b(paramContext);
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString)
  {
    QLog.i("Ecshop_EcshopWebviewPool", 2, "ecshop recycleWebView  ");
    this.b.clear();
    paramTouchWebView = this.d;
    if (paramTouchWebView != null) {
      paramTouchWebView.removeCallbacksAndMessages(null);
    }
  }
  
  public boolean a(String paramString)
  {
    return (!StringUtil.isEmpty(paramString)) && (this.b.containsKey(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopWebviewPool
 * JD-Core Version:    0.7.0.1
 */