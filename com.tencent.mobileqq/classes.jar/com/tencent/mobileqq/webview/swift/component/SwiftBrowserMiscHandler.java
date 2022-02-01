package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.vastrash.ColorRingPlayer;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.WeakReferenceHandler;

public class SwiftBrowserMiscHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements Handler.Callback
{
  boolean a = false;
  public Handler c = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private ViewGroup d = null;
  private ColorRingPlayer e = null;
  private QQBrowserActivity f = null;
  private WebViewProvider g = null;
  
  public void a()
  {
    if ((this.b.b() instanceof QQBrowserActivity))
    {
      this.f = ((QQBrowserActivity)this.b.b());
      this.g = this.b.c();
    }
  }
  
  public void a(int paramInt1, int paramInt2, SwiftBrowserMiscHandler.ScreenShotCallback paramScreenShotCallback)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      Object localObject = this.g;
      if (localObject == null) {
        return;
      }
      localObject = ((WebViewProvider)localObject).getWebView();
      if (localObject == null)
      {
        if (paramScreenShotCallback != null) {
          paramScreenShotCallback.a("");
        }
        return;
      }
      ThreadManager.post(new SwiftBrowserMiscHandler.3(this, ScreenShotUtil.a((WebView)localObject, paramInt1, paramInt2), paramScreenShotCallback), 8, null, true);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        paramBundle = this.e;
        if (paramBundle != null) {
          paramBundle.e();
        }
        if (this.a)
        {
          ThreadManager.executeOnFileThread(new SwiftBrowserMiscHandler.2(this));
          this.a = false;
        }
      }
      else
      {
        paramBundle = this.e;
        if (paramBundle != null) {
          paramBundle.g();
        }
      }
    }
    else
    {
      paramBundle = this.e;
      if (paramBundle != null) {
        paramBundle.f();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      Object localObject;
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 5) {
            return false;
          }
          if (this.e != null)
          {
            paramMessage = (Bundle)paramMessage.obj;
            this.e.a(paramMessage.getString("callbackId"));
            return true;
          }
        }
        else
        {
          paramMessage = (Bundle)paramMessage.obj;
          localObject = this.e;
          if (localObject != null)
          {
            ((ColorRingPlayer)localObject).a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getInt("status"), paramMessage.getString("callbackId"));
            return true;
          }
        }
      }
      else
      {
        localObject = this.g;
        if (localObject != null)
        {
          if (((WebViewProvider)localObject).getComponentProvider() == null) {
            return false;
          }
          localObject = (SwiftBrowserUIStyleHandler)this.g.getComponentProvider().a(2);
          if ((localObject != null) && (((SwiftBrowserUIStyleHandler)localObject).x != null))
          {
            if (this.d == null)
            {
              localObject = (RelativeLayout)((SwiftBrowserUIStyleHandler)localObject).x.findViewById(2131429740);
              this.d = ((ViewGroup)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131628301, null));
              RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
              localLayoutParams.addRule(12);
              ((RelativeLayout)localObject).addView(this.d, localLayoutParams);
              this.d.setOnTouchListener(new SwiftBrowserMiscHandler.1(this));
            }
            if (this.e == null) {
              this.e = new ColorRingPlayer(this.f, this.d);
            }
            this.e.h();
            paramMessage = (Bundle)paramMessage.obj;
            this.e.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getString("callbackId"));
            return true;
          }
        }
        else
        {
          return false;
        }
      }
    }
    else if (this.g != null)
    {
      i = paramMessage.arg1;
      if ((i & 0x2) == 0) {
        i = 1;
      } else {
        i = 0;
      }
      paramMessage = (SwiftBrowserUIStyleHandler)this.g.getComponentProvider().a(2);
      if (i != 0)
      {
        paramMessage.g.h.setVisibility(0);
        return true;
      }
      paramMessage.g.h.setVisibility(8);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler
 * JD-Core Version:    0.7.0.1
 */