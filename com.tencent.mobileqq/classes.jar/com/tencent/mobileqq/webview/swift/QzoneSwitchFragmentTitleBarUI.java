package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.ui.WebViewTopTabHelper;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import org.json.JSONObject;

@KeepClassConstructor
public class QzoneSwitchFragmentTitleBarUI
  extends SwiftIphoneTitleBarUI
{
  public QzoneSwitchFragmentTitleBarUI(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    super(paramSwiftBrowserUIStyleHandler);
  }
  
  public int a(RadioGroup paramRadioGroup)
  {
    if ((paramRadioGroup != null) && ((paramRadioGroup instanceof WebViewTopTabView)))
    {
      int i = 0;
      while (i < paramRadioGroup.getChildCount())
      {
        if (((RadioButton)paramRadioGroup.getChildAt(i)).isChecked()) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(SwiftIphoneTitleBarUI.SubTabParam paramSubTabParam)
  {
    if (paramSubTabParam != null)
    {
      this.N = new WebViewTopTabView(BaseApplicationImpl.getContext());
      this.N.setButtonNum(paramSubTabParam.b, paramSubTabParam.a);
      this.N.setButtonText(paramSubTabParam.e);
      this.N.setButtonBackgroundResource(2130853469, 2130853470, 2130853471);
      this.N.setButtonTextColorStateList(2131168436);
      this.N.setLeftAndRightPaddingByDp(10);
      a(this.b.E);
      int i = -1;
      try
      {
        this.q.removeAllViews();
        this.q.addView(this.N, new RelativeLayout.LayoutParams(-2, -1));
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      if (this.a.i.getIntent().getBooleanExtra("topTabSwitchFragment", false))
      {
        this.N.setOnCheckedChangeListener(new QzoneSwitchFragmentTitleBarUI.1(this));
        if (((QQBrowserActivity)this.a.i).oldTabSelectIndex != -1) {
          this.N.setSelectedTab(((QQBrowserActivity)this.a.i).oldTabSelectIndex);
        } else {
          this.N.setSelectedTab(this.a.i.getIntent().getIntExtra("topTabSelectIndex", 0));
        }
      }
      if (this.O != null) {
        this.O.a(paramSubTabParam.d, true);
      }
      TouchWebView localTouchWebView = this.a.l();
      if ((localTouchWebView != null) && (!TextUtils.isEmpty(paramSubTabParam.c)))
      {
        String str;
        if (TextUtils.isEmpty(paramSubTabParam.d))
        {
          str = "the subTabCallback isEmpty";
        }
        else
        {
          str = "ok";
          i = 0;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("code", i);
          localJSONObject.put("message", str);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        localTouchWebView.callJs(paramSubTabParam.c, new String[] { localJSONObject.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.QzoneSwitchFragmentTitleBarUI
 * JD-Core Version:    0.7.0.1
 */