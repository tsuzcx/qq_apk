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
  public Handler a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = null;
  private ColorRingPlayer jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer = null;
  private WebViewProvider jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider = null;
  boolean jdField_a_of_type_Boolean = false;
  
  public SwiftBrowserMiscHandler()
  {
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, SwiftBrowserMiscHandler.ScreenShotCallback paramScreenShotCallback)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider;
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
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer;
        if (paramBundle != null) {
          paramBundle.e();
        }
        if (this.jdField_a_of_type_Boolean)
        {
          ThreadManager.executeOnFileThread(new SwiftBrowserMiscHandler.2(this));
          this.jdField_a_of_type_Boolean = false;
        }
      }
      else
      {
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer;
        if (paramBundle != null) {
          paramBundle.g();
        }
      }
    }
    else
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer;
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
          if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer != null)
          {
            paramMessage = (Bundle)paramMessage.obj;
            this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer.a(paramMessage.getString("callbackId"));
            return true;
          }
        }
        else
        {
          paramMessage = (Bundle)paramMessage.obj;
          localObject = this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer;
          if (localObject != null)
          {
            ((ColorRingPlayer)localObject).a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getInt("status"), paramMessage.getString("callbackId"));
            return true;
          }
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider;
        if (localObject != null)
        {
          if (((WebViewProvider)localObject).getComponentProvider() == null) {
            return false;
          }
          localObject = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(2);
          if ((localObject != null) && (((SwiftBrowserUIStyleHandler)localObject).d != null))
          {
            if (this.jdField_a_of_type_AndroidViewViewGroup == null)
            {
              localObject = (RelativeLayout)((SwiftBrowserUIStyleHandler)localObject).d.findViewById(2131363807);
              this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131561883, null));
              RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
              localLayoutParams.addRule(12);
              ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
              this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new SwiftBrowserMiscHandler.1(this));
            }
            if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer == null) {
              this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer = new ColorRingPlayer(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_AndroidViewViewGroup);
            }
            this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer.h();
            paramMessage = (Bundle)paramMessage.obj;
            this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getString("callbackId"));
            return true;
          }
        }
        else
        {
          return false;
        }
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null)
    {
      i = paramMessage.arg1;
      if ((i & 0x2) == 0) {
        i = 1;
      } else {
        i = 0;
      }
      paramMessage = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(2);
      if (i != 0)
      {
        paramMessage.a.a.setVisibility(0);
        return true;
      }
      paramMessage.a.a.setVisibility(8);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler
 * JD-Core Version:    0.7.0.1
 */