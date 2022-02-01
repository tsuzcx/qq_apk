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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.vastrash.ColorRingPlayer;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
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
  
  public void a(int paramInt1, int paramInt2, SwiftBrowserMiscHandler.ScreenShotCallback paramScreenShotCallback)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider == null)) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebView();
      if (localCustomWebView != null) {
        break;
      }
    } while (paramScreenShotCallback == null);
    paramScreenShotCallback.a("");
    return;
    ThreadManager.post(new SwiftBrowserMiscHandler.3(this, ScreenShotUtil.a(localCustomWebView, paramInt1, paramInt2), paramScreenShotCallback), 8, null, true);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer == null);
        this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer.f();
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer == null);
      this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer.g();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer.e();
      }
    } while (!this.jdField_a_of_type_Boolean);
    ThreadManager.executeOnFileThread(new SwiftBrowserMiscHandler.2(this));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i;
    boolean bool;
    switch (paramMessage.what)
    {
    case 1: 
    case 2: 
    default: 
      return false;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null)
      {
        i = paramMessage.arg1;
        if ((i & 0x1) != 0) {
          break label118;
        }
        bool = true;
        label66:
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.setBottomBarVisible(bool);
        if ((i & 0x2) != 0) {
          break label123;
        }
        i = 1;
        label84:
        paramMessage = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(2);
        if (i == 0) {
          break label128;
        }
        paramMessage.a.a.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      return true;
      label118:
      bool = false;
      break label66;
      label123:
      i = 0;
      break label84;
      label128:
      paramMessage.a.a.setVisibility(8);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider() == null)) {
        break;
      }
      Object localObject = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(2);
      if ((localObject != null) && (((SwiftBrowserUIStyleHandler)localObject).d != null))
      {
        if (this.jdField_a_of_type_AndroidViewViewGroup == null)
        {
          localObject = (RelativeLayout)((SwiftBrowserUIStyleHandler)localObject).d.findViewById(2131363879);
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131562050, null));
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
        continue;
        paramMessage = (Bundle)paramMessage.obj;
        if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getInt("status"), paramMessage.getString("callbackId"));
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer != null)
          {
            paramMessage = (Bundle)paramMessage.obj;
            this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer.a(paramMessage.getString("callbackId"));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler
 * JD-Core Version:    0.7.0.1
 */