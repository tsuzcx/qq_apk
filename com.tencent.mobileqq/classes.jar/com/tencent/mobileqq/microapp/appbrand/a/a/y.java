package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import bdnn;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.microapp.appbrand.page.WebViewEventListener;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.util.WeakReference;
import org.json.JSONObject;

public final class y
  implements Handler.Callback, WebViewEventListener
{
  public com.tencent.mobileqq.microapp.appbrand.a a;
  com.tencent.mobileqq.microapp.app.a b;
  com.tencent.mobileqq.microapp.widget.f c;
  DialogInterface.OnDismissListener d = new aa(this);
  DialogInterface.OnDismissListener e = new ab(this);
  private BaseActivity f;
  private List g;
  private ConcurrentLinkedQueue h;
  private ConcurrentLinkedQueue i;
  private Handler j;
  private boolean k;
  private boolean l;
  
  public y(BaseActivity paramBaseActivity, com.tencent.mobileqq.microapp.appbrand.a parama)
  {
    this.f = paramBaseActivity;
    this.a = parama;
    this.g = new ArrayList();
    this.b = parama.e.getAuthorizeCenter(parama.a);
    this.h = new ConcurrentLinkedQueue();
    this.i = new ConcurrentLinkedQueue();
    this.j = new Handler(Looper.getMainLooper(), this);
  }
  
  private String b(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    int m = this.b.a(paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("JsPluginEngine", 2, "handleNativeRequest authFlag=" + m + ",eventName=" + paramString1 + "，jsonParams=" + paramString2 + ",webview=" + paramBaseAppBrandWebview + ",callbackId=" + paramInt);
    }
    if (m == 2)
    {
      paramBaseAppBrandWebview = c(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
      if ((com.tencent.mobileqq.microapp.app.a.b(paramString1, paramString2)) && (this.h.size() > 0)) {
        this.j.obtainMessage(1).sendToTarget();
      }
      return paramBaseAppBrandWebview;
    }
    d(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
    return "";
  }
  
  private String c(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a(paramString1)) {
        return locala.a(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("JsPluginEngine", 2, "handleNativeRequest fail,event not support! eventName=" + paramString1 + "，jsonParams=" + paramString2 + ",webview=" + paramBaseAppBrandWebview + ",callbackId=" + paramInt);
    }
    b(paramBaseAppBrandWebview, paramString1, null, paramInt);
    return "";
  }
  
  private void d(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    if (this.b.a(paramString1, paramString2) <= System.currentTimeMillis() / 1000L) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JsPluginEngine", 2, "handleNativeRequest bAuth=" + bool + ",isPause=" + this.l);
      }
      if (!bool) {
        break;
      }
      paramBaseAppBrandWebview = new y.a(this, paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
      this.h.offer(paramBaseAppBrandWebview);
      if ((!this.l) && ((this.c == null) || (!this.c.isShowing())))
      {
        paramBaseAppBrandWebview = this.j.obtainMessage(2);
        Bundle localBundle = new Bundle();
        localBundle.putString("key_event_name", paramString1);
        localBundle.putString("key_params", paramString2);
        paramBaseAppBrandWebview.setData(localBundle);
        paramBaseAppBrandWebview.sendToTarget();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("JsPluginEngine", 2, "handleNativeRequest callbackJsEventFail");
    }
    b(paramBaseAppBrandWebview, paramString1, null, paramInt);
    this.j.obtainMessage(1).sendToTarget();
  }
  
  private void g()
  {
    this.j.removeMessages(1);
    this.j.removeMessages(2);
    this.j.removeMessages(3);
    this.j.removeMessages(4);
  }
  
  public String a(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBaseAppBrandWebview == null) || (this.k))
    {
      if (QLog.isColorLevel()) {
        QLog.w("JsPluginEngine", 2, "handleNativeRequest fail eventName=" + paramString1 + "，jsonParams=" + paramString2 + ",webview=" + paramBaseAppBrandWebview + ",callbackId=" + paramInt + ",isDestory=" + this.k);
      }
      return "";
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      BaseActivity localBaseActivity = this.a.d;
      String str;
      if (localBaseActivity != null)
      {
        str = com.tencent.mobileqq.microapp.app.a.d(paramString1, paramString2);
        if (bdnn.a(str)) {
          break label228;
        }
        if (localBaseActivity.checkSelfPermission(str) != 0) {
          break label179;
        }
      }
      label179:
      for (int m = 1; m == 0; m = 0)
      {
        localBaseActivity.requestPermissions(new z(this, paramString1, paramString2, paramBaseAppBrandWebview, paramInt), 1, new String[] { str });
        return "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("JsPluginEngine", 2, str + " has granted permission!!!");
      }
      return b(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
      label228:
      return b(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
    }
    return b(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
  }
  
  public void a()
  {
    this.g.add(new bj());
    this.g.add(new av());
    this.g.add(new ba());
    this.g.add(new am());
    this.g.add(new bd());
    this.g.add(new u());
    this.g.add(new d());
    this.g.add(new as());
    this.g.add(new ac());
    this.g.add(new aj());
    this.g.add(new f());
    this.g.add(new b());
    this.g.add(new ay());
    this.g.add(new au());
  }
  
  public void a(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString, JSONObject paramJSONObject)
  {
    if (paramBaseAppBrandWebview == null) {
      return;
    }
    paramString = "WeixinJSBridge.subscribeHandler(\"" + paramString + "\", " + paramJSONObject + "," + paramBaseAppBrandWebview.pageWebviewId + ")";
    if (QLog.isColorLevel()) {
      QLog.d("JsPluginEngine", 2, "callJs jsStr=" + paramString);
    }
    paramBaseAppBrandWebview.evaluteJs(paramString);
  }
  
  public void a(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (paramBaseAppBrandWebview != null)
    {
      paramString = com.tencent.mobileqq.microapp.b.a.a(paramString, paramJSONObject);
      if (paramString == null) {
        break label27;
      }
    }
    label27:
    for (paramString = paramString.toString();; paramString = "")
    {
      paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, paramString);
      return;
    }
  }
  
  public void a(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    if (paramBaseAppBrandWebview != null)
    {
      paramString1 = com.tencent.mobileqq.microapp.b.a.a(paramString1, paramJSONObject, paramString2);
      if (paramString1 == null) {
        break label29;
      }
    }
    label29:
    for (paramString1 = paramString1.toString();; paramString1 = "")
    {
      paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, paramString1);
      return;
    }
  }
  
  public BaseActivity b()
  {
    return this.f;
  }
  
  public void b(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    a(paramBaseAppBrandWebview, paramString, paramJSONObject, null, paramInt);
  }
  
  public void c()
  {
    this.l = false;
    this.k = false;
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(this);
    }
  }
  
  public void d()
  {
    this.l = false;
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    this.j.obtainMessage(1).sendToTarget();
    this.j.obtainMessage(4).sendToTarget();
  }
  
  public void e()
  {
    this.l = true;
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    g();
  }
  
  public void f()
  {
    this.l = true;
    this.k = true;
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a();
    }
    this.g.clear();
    this.h.clear();
    g();
    if (this.c != null)
    {
      this.c.setOnDismissListener(null);
      this.c.dismiss();
      this.c = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JsPluginEngine", 2, "handleMessage what=" + paramMessage.what + ",isDestory=" + this.k);
    }
    if ((this.k) || (this.l)) {}
    label625:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          Object localObject;
          y.a locala;
          switch (paramMessage.what)
          {
          default: 
            return false;
          case 1: 
            localObject = this.h.iterator();
            if ((paramMessage.arg1 != 3) && (paramMessage.arg1 != 2)) {
              break;
            }
            paramMessage = (String)paramMessage.obj;
            if (TextUtils.isEmpty(paramMessage)) {
              break;
            }
            if (paramMessage.equals("scope.camera")) {
              a(this.a.i, "onCameraNeedAuthCancel", null);
            }
            while (((Iterator)localObject).hasNext())
            {
              locala = (y.a)((Iterator)localObject).next();
              if (paramMessage.equals(com.tencent.mobileqq.microapp.app.a.c(locala.a, locala.b)))
              {
                ((Iterator)localObject).remove();
                b((BaseAppBrandWebview)locala.c.get(), locala.a, null, locala.d);
              }
            }
          case 3: 
            if (this.c == null)
            {
              this.c = new com.tencent.mobileqq.microapp.widget.f(this.f);
              this.c.setOnDismissListener(this.d);
            }
            localObject = paramMessage.getData();
            this.c.a((Bundle)localObject);
            paramMessage = com.tencent.mobileqq.microapp.app.a.d(paramMessage.getData().getString("key_event_name", ""), paramMessage.getData().getString("key_params", ""));
            paramMessage = (String)com.tencent.mobileqq.microapp.app.a.d.get(paramMessage);
            this.c.a("权限设置", paramMessage, "拒绝", "#FF000000", "去设置", "#FF000000", true, null);
            return false;
          case 2: 
            if (this.c == null)
            {
              this.c = new com.tencent.mobileqq.microapp.widget.f(this.f);
              this.c.setOnDismissListener(this.e);
            }
            paramMessage = paramMessage.getData();
            this.c.a(paramMessage);
            localObject = com.tencent.mobileqq.microapp.app.a.c(paramMessage.getString("key_event_name", ""), paramMessage.getString("key_params", ""));
            paramMessage = (Message)localObject;
            if (localObject != null)
            {
              paramMessage = (Message)localObject;
              if (com.tencent.mobileqq.microapp.app.a.b.containsKey(localObject)) {
                paramMessage = (String)com.tencent.mobileqq.microapp.app.a.b.get(localObject);
              }
            }
            this.c.a(this.a.c.c + "申请以下权限", paramMessage, "拒绝", "#FF000000", "允许", "#FF000000", true, null);
            return false;
          case 4: 
            localObject = this.i.iterator();
            if ((paramMessage.arg1 != 3) && (paramMessage.arg1 != 2)) {
              break label625;
            }
            paramMessage = (String)paramMessage.obj;
            if (!TextUtils.isEmpty(paramMessage))
            {
              if (paramMessage.equals("android.permission.CAMERA")) {
                a(this.a.i, "onCameraNeedAuthCancel", null);
              }
              while (((Iterator)localObject).hasNext())
              {
                locala = (y.a)((Iterator)localObject).next();
                if (paramMessage.equals(com.tencent.mobileqq.microapp.app.a.c.get(locala.a)))
                {
                  ((Iterator)localObject).remove();
                  b((BaseAppBrandWebview)locala.c.get(), locala.a, null, locala.d);
                }
              }
            }
            break;
          }
        }
        paramMessage = (y.a)this.i.peek();
      } while (paramMessage == null);
      this.h.remove(paramMessage);
      a(paramMessage.a, paramMessage.b, (BaseAppBrandWebview)paramMessage.c.get(), paramMessage.d);
      return false;
      paramMessage = (y.a)this.h.peek();
    } while (paramMessage == null);
    this.h.remove(paramMessage);
    a(paramMessage.a, paramMessage.b, (BaseAppBrandWebview)paramMessage.c.get(), paramMessage.d);
    return false;
  }
  
  public void onWebViewEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JsPluginEngine", 4, "onWebViewEvent eventName=" + paramString1 + ",jsonParams=" + paramString2 + ",webviewIds=" + paramString3 + ",appId=" + paramString4 + ",pageWebviewId=" + paramInt);
    }
    this.a.a(paramString1, paramString2, paramInt);
  }
  
  public String onWebViewNativeRequest(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JsPluginEngine", 4, "onWebViewNativeRequest eventName=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt);
    }
    return a(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.y
 * JD-Core Version:    0.7.0.1
 */