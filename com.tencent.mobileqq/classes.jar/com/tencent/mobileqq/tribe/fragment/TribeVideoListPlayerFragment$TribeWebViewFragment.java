package com.tencent.mobileqq.tribe.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import bcef;
import bdmu;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TribeVideoListPlayerFragment$TribeWebViewFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  public int a;
  public TribeVideoListPlayerFragment a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public TribeVideoListPlayerFragment$TribeWebViewFragment()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "onPageFinished: loadError = " + this.c);
    }
    if ((!this.c) && (this.jdField_a_of_type_Int != -1))
    {
      paramWebView = getActivity().getSupportFragmentManager();
      if (paramWebView != null)
      {
        paramWebView = paramWebView.getFragments();
        if ((paramWebView != null) && (paramWebView.size() > 0))
        {
          paramWebView = paramWebView.iterator();
          while (paramWebView.hasNext())
          {
            paramString = (Fragment)paramWebView.next();
            if ((paramString instanceof TribeVideoListPlayerFragment)) {
              ((TribeVideoListPlayerFragment)paramString).e(this.jdField_a_of_type_Int);
            }
          }
        }
      }
      if ((isAdded()) && (!isVisible()))
      {
        getActivity().getSupportFragmentManager().beginTransaction().show(this).commitAllowingStateLoss();
        if (this.webView != null) {
          break label172;
        }
      }
    }
    return;
    label172:
    paramWebView = "javascript:mqq.dispatchEvent(\"startShowAnim\",{\"type\":\"" + TribeVideoListPlayerFragment.a()[this.jdField_a_of_type_Int] + "\"})";
    this.webView.callJs(paramWebView);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "onProgressChanged:" + paramInt);
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "onReceivedError: errorCode=" + paramInt + "descrip=" + paramString1 + "failingUrl" + paramString2);
    }
    this.c = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.a.get(0) instanceof bdmu)) {
      if (((bdmu)this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.a.get(0)).h == 0) {
        break label161;
      }
    }
    label161:
    for (paramWebView = "" + ((bdmu)this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.a.get(0)).h;; paramWebView = "")
    {
      bcef.b(null, "dc00899", "Grp_tribe", "", "video_player", "webview_fail", 0, 0, "", "", paramWebView, "");
      return;
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.toLowerCase().contains("error")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoListPlayerFragment", 2, "onReceivedErrorTitle:" + paramString);
      }
      this.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.TribeWebViewFragment
 * JD-Core Version:    0.7.0.1
 */