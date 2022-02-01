package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TenDocWebViewPool
{
  public static HashMap<String, Integer> a = null;
  private static List<TouchWebView> b = new ArrayList();
  private static final byte[] c = new byte[0];
  private static int d = 1;
  private static volatile TenDocWebViewPool e = null;
  
  private TenDocWebViewPool()
  {
    b = new ArrayList();
  }
  
  public static TenDocWebViewPool a()
  {
    if (e == null) {
      try
      {
        if (e == null) {
          e = new TenDocWebViewPool();
        }
      }
      finally {}
    }
    return e;
  }
  
  public static void a(String paramString, TouchWebView paramTouchWebView)
  {
    try
    {
      if (a == null) {
        a = new HashMap();
      }
      if (paramString != null)
      {
        Integer localInteger = (Integer)a.get(paramString);
        if (localInteger == null)
        {
          a.put(paramString, Integer.valueOf(1));
        }
        else
        {
          int i = localInteger.intValue();
          a.put(paramString, Integer.valueOf(i + 1));
        }
      }
      ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).sendDocsDataBack(paramString, paramTouchWebView);
      return;
    }
    finally {}
  }
  
  public TouchWebView a(Context paramContext)
  {
    byte[] arrayOfByte = c;
    TouchWebView localTouchWebView = null;
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tendocpreload getWebView =  ");
      ((StringBuilder)localObject).append(b.size());
      QLog.e("TenDocWebViewPool", 1, ((StringBuilder)localObject).toString());
      if (b.size() > 0)
      {
        localTouchWebView = (TouchWebView)b.get(0);
        b.remove(0);
        localObject = (ViewGroup)localTouchWebView.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(localTouchWebView);
        }
        ((MutableContextWrapper)localTouchWebView.getContext()).setBaseContext(paramContext);
      }
      return localTouchWebView;
    }
    finally {}
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    QLog.i("TenDocWebViewPool", 1, "tendocpreload recycleWebView  ");
    if (paramTouchWebView != null)
    {
      ??? = (ViewGroup)paramTouchWebView.getParent();
      if (??? != null) {
        ((ViewGroup)???).removeView(paramTouchWebView);
      }
      synchronized (c)
      {
        if ((paramTouchWebView instanceof SwiftReuseTouchWebView))
        {
          Context localContext = paramTouchWebView.getContext();
          if ((localContext instanceof MutableContextWrapper)) {
            ((MutableContextWrapper)localContext).setBaseContext(BaseApplication.getContext());
          }
          if (b.size() < d)
          {
            QLog.i("TenDocWebViewPool", 1, "tendocpreload recycleWebView  ");
            b.add(paramTouchWebView);
          }
          else
          {
            paramTouchWebView.destroy();
          }
        }
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("tendocpreload init");
    ((StringBuilder)???).append(c());
    QLog.i("TenDocWebViewPool", 1, ((StringBuilder)???).toString());
    synchronized (c)
    {
      if (!c())
      {
        ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).webAcceleratorSmartSchedule();
        QLog.i("TenDocWebViewPool", 1, "init");
        SwiftReuseTouchWebView localSwiftReuseTouchWebView = SwiftReuseTouchWebView.b(BaseApplication.getContext());
        localSwiftReuseTouchWebView.setWebViewClient(new TenDocWebViewPool.WebViewClientImpl(this));
        localSwiftReuseTouchWebView.setWebChromeClient(new TenDocWebViewPool.WebChromeClientImpl(this));
        b.add(localSwiftReuseTouchWebView);
      }
      TenDocWebPreLoadHelper.a = paramString;
      return;
    }
  }
  
  public List<TouchWebView> b()
  {
    return b;
  }
  
  public boolean b(String paramString)
  {
    if ((c()) && (!TextUtils.isEmpty(paramString)))
    {
      TouchWebView localTouchWebView = (TouchWebView)b().get(0);
      localTouchWebView.setWebViewClient(new TenDocWebViewPool.WebViewClientImpl(this));
      localTouchWebView.setWebChromeClient(new TenDocWebViewPool.WebChromeClientImpl(this));
      localTouchWebView.loadUrlOriginal(paramString);
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    return b.size() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocWebViewPool
 * JD-Core Version:    0.7.0.1
 */