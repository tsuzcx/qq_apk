package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.appbrand.page.WebViewEventListener;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.microapp.widget.d;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.util.WeakReference;
import org.json.JSONObject;

public final class f
  implements Handler.Callback, WebViewEventListener
{
  public com.tencent.mobileqq.microapp.appbrand.a a;
  com.tencent.mobileqq.microapp.app.a b;
  d c;
  DialogInterface.OnDismissListener d = new h(this);
  DialogInterface.OnDismissListener e = new i(this);
  private BaseActivity f;
  private List g;
  private ConcurrentLinkedQueue h;
  private ConcurrentLinkedQueue i;
  private Handler j;
  private boolean k;
  private boolean l;
  
  public f(BaseActivity paramBaseActivity, com.tencent.mobileqq.microapp.appbrand.a parama)
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleNativeRequest authFlag=");
      localStringBuilder.append(m);
      localStringBuilder.append(",eventName=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("，jsonParams=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",webview=");
      localStringBuilder.append(paramBaseAppBrandWebview);
      localStringBuilder.append(",callbackId=");
      localStringBuilder.append(paramInt);
      QLog.d("JsPluginEngine", 2, localStringBuilder.toString());
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
    Object localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.a(paramString1)) {
        return locala.a(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNativeRequest fail,event not support! eventName=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("，jsonParams=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",webview=");
      ((StringBuilder)localObject).append(paramBaseAppBrandWebview);
      ((StringBuilder)localObject).append(",callbackId=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("JsPluginEngine", 2, ((StringBuilder)localObject).toString());
    }
    b(paramBaseAppBrandWebview, paramString1, null, paramInt);
    return "";
  }
  
  private void d(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    boolean bool;
    if (this.b.a(paramString1, paramString2) <= System.currentTimeMillis() / 1000L) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNativeRequest bAuth=");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(",isPause=");
      ((StringBuilder)localObject).append(this.l);
      QLog.d("JsPluginEngine", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      paramBaseAppBrandWebview = new f.a(this, paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
      this.h.offer(paramBaseAppBrandWebview);
      if (!this.l)
      {
        paramBaseAppBrandWebview = this.c;
        if ((paramBaseAppBrandWebview == null) || (!paramBaseAppBrandWebview.isShowing()))
        {
          paramBaseAppBrandWebview = this.j.obtainMessage(2);
          localObject = new Bundle();
          ((Bundle)localObject).putString("key_event_name", paramString1);
          ((Bundle)localObject).putString("key_params", paramString2);
          paramBaseAppBrandWebview.setData((Bundle)localObject);
          paramBaseAppBrandWebview.sendToTarget();
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("JsPluginEngine", 2, "handleNativeRequest callbackJsEventFail");
      }
      b(paramBaseAppBrandWebview, paramString1, null, paramInt);
      this.j.obtainMessage(1).sendToTarget();
    }
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
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString1)) && (paramBaseAppBrandWebview != null) && (!this.k))
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        Object localObject2 = this.a.d;
        if (localObject2 != null)
        {
          localObject1 = com.tencent.mobileqq.microapp.app.a.d(paramString1, paramString2);
          if (!StringUtil.isEmpty((String)localObject1))
          {
            int m;
            if (((BaseActivity)localObject2).checkSelfPermission((String)localObject1) == 0) {
              m = 1;
            } else {
              m = 0;
            }
            if (m == 0)
            {
              ((BaseActivity)localObject2).requestPermissions(new g(this, paramString1, paramString2, paramBaseAppBrandWebview, paramInt), 1, new String[] { localObject1 });
              return "";
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(" has granted permission!!!");
              QLog.d("JsPluginEngine", 2, ((StringBuilder)localObject2).toString());
            }
            return b(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
          }
          return b(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
        }
        return "";
      }
      return b(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleNativeRequest fail eventName=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("，jsonParams=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(",webview=");
      ((StringBuilder)localObject1).append(paramBaseAppBrandWebview);
      ((StringBuilder)localObject1).append(",callbackId=");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",isDestory=");
      ((StringBuilder)localObject1).append(this.k);
      QLog.w("JsPluginEngine", 2, ((StringBuilder)localObject1).toString());
    }
    return "";
  }
  
  public void a()
  {
    this.g.add(new b());
    this.g.add(new j());
  }
  
  public void a(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString, JSONObject paramJSONObject)
  {
    if (paramBaseAppBrandWebview == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\", ");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append(",");
    localStringBuilder.append(paramBaseAppBrandWebview.pageWebviewId);
    localStringBuilder.append(")");
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("callJs jsStr=");
      paramJSONObject.append(paramString);
      QLog.d("JsPluginEngine", 2, paramJSONObject.toString());
    }
    paramBaseAppBrandWebview.evaluteJs(paramString);
  }
  
  public void a(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (paramBaseAppBrandWebview != null)
    {
      paramString = c.a(paramString, paramJSONObject);
      if (paramString != null) {
        paramString = paramString.toString();
      } else {
        paramString = "";
      }
      paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  public void a(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    if (paramBaseAppBrandWebview != null)
    {
      paramString1 = c.a(paramString1, paramJSONObject, paramString2);
      if (paramString1 != null) {
        paramString1 = paramString1.toString();
      } else {
        paramString1 = "";
      }
      paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, paramString1);
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
    Object localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    this.g.clear();
    this.h.clear();
    g();
    localObject = this.c;
    if (localObject != null)
    {
      ((d)localObject).setOnDismissListener(null);
      this.c.dismiss();
      this.c = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleMessage what=");
      ((StringBuilder)localObject1).append(paramMessage.what);
      ((StringBuilder)localObject1).append(",isDestory=");
      ((StringBuilder)localObject1).append(this.k);
      QLog.d("JsPluginEngine", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.k)
    {
      if (this.l) {
        return false;
      }
      int m = paramMessage.what;
      Object localObject2;
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 4) {
              return false;
            }
            localObject1 = this.i.iterator();
            if ((paramMessage.arg1 != 3) && (paramMessage.arg1 != 2))
            {
              paramMessage = (f.a)this.i.peek();
              if (paramMessage != null)
              {
                this.h.remove(paramMessage);
                a(paramMessage.a, paramMessage.b, (BaseAppBrandWebview)paramMessage.c.get(), paramMessage.d);
                return false;
              }
            }
            else
            {
              paramMessage = (String)paramMessage.obj;
              if (!TextUtils.isEmpty(paramMessage))
              {
                if (paramMessage.equals("android.permission.CAMERA")) {
                  a(this.a.i, "onCameraNeedAuthCancel", null);
                }
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (f.a)((Iterator)localObject1).next();
                  if (paramMessage.equals(com.tencent.mobileqq.microapp.app.a.c.get(((f.a)localObject2).a)))
                  {
                    ((Iterator)localObject1).remove();
                    b((BaseAppBrandWebview)((f.a)localObject2).c.get(), ((f.a)localObject2).a, null, ((f.a)localObject2).d);
                  }
                }
              }
            }
          }
          else
          {
            if (this.c == null)
            {
              this.c = new d(this.f);
              this.c.setOnDismissListener(this.d);
            }
            localObject1 = paramMessage.getData();
            this.c.a((Bundle)localObject1);
            paramMessage = com.tencent.mobileqq.microapp.app.a.d(paramMessage.getData().getString("key_event_name", ""), paramMessage.getData().getString("key_params", ""));
            paramMessage = (String)com.tencent.mobileqq.microapp.app.a.d.get(paramMessage);
            this.c.a("权限设置", paramMessage, "拒绝", "#FF000000", "去设置", "#FF000000", true, null);
            return false;
          }
        }
        else
        {
          if (this.c == null)
          {
            this.c = new d(this.f);
            this.c.setOnDismissListener(this.e);
          }
          paramMessage = paramMessage.getData();
          this.c.a(paramMessage);
          localObject1 = com.tencent.mobileqq.microapp.app.a.c(paramMessage.getString("key_event_name", ""), paramMessage.getString("key_params", ""));
          paramMessage = (Message)localObject1;
          if (localObject1 != null)
          {
            paramMessage = (Message)localObject1;
            if (com.tencent.mobileqq.microapp.app.a.b.containsKey(localObject1)) {
              paramMessage = (String)com.tencent.mobileqq.microapp.app.a.b.get(localObject1);
            }
          }
          localObject1 = this.c;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.a.c.c);
          ((StringBuilder)localObject2).append("申请以下权限");
          ((d)localObject1).a(((StringBuilder)localObject2).toString(), paramMessage, "拒绝", "#FF000000", "允许", "#FF000000", true, null);
          return false;
        }
      }
      else
      {
        localObject1 = this.h.iterator();
        if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 2))
        {
          paramMessage = (String)paramMessage.obj;
          if (!TextUtils.isEmpty(paramMessage))
          {
            if (paramMessage.equals("scope.camera")) {
              a(this.a.i, "onCameraNeedAuthCancel", null);
            }
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (f.a)((Iterator)localObject1).next();
              if (paramMessage.equals(com.tencent.mobileqq.microapp.app.a.c(((f.a)localObject2).a, ((f.a)localObject2).b)))
              {
                ((Iterator)localObject1).remove();
                b((BaseAppBrandWebview)((f.a)localObject2).c.get(), ((f.a)localObject2).a, null, ((f.a)localObject2).d);
              }
            }
          }
        }
        paramMessage = (f.a)this.h.peek();
        if (paramMessage != null)
        {
          this.h.remove(paramMessage);
          a(paramMessage.a, paramMessage.b, (BaseAppBrandWebview)paramMessage.c.get(), paramMessage.d);
        }
      }
    }
    return false;
  }
  
  public void onWebViewEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWebViewEvent eventName=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",jsonParams=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",webviewIds=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(",appId=");
      localStringBuilder.append(paramString4);
      localStringBuilder.append(",pageWebviewId=");
      localStringBuilder.append(paramInt);
      QLog.d("JsPluginEngine", 4, localStringBuilder.toString());
    }
    this.a.a(paramString1, paramString2, paramInt);
  }
  
  public String onWebViewNativeRequest(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWebViewNativeRequest eventName=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",jsonParams=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",callbackId=");
      localStringBuilder.append(paramInt);
      QLog.d("JsPluginEngine", 4, localStringBuilder.toString());
    }
    return a(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.f
 * JD-Core Version:    0.7.0.1
 */