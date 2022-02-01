package com.tencent.mobileqq.kandian.biz.search.searchresult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.URLUtil;
import java.net.URLDecoder;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class KDSearchResultFragment$3
  extends KDSearchResultWebviewBuilder
{
  View a;
  IX5WebChromeClient.CustomViewCallback b;
  View c;
  int d;
  int e;
  FrameLayout f;
  
  KDSearchResultFragment$3(KDSearchResultFragment paramKDSearchResultFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView);
  }
  
  private boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mContext == null) {
        return false;
      }
      try
      {
        Object localObject1 = this.mContext.getPackageManager();
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_kandian_search_download");
        ((Intent)localObject2).setData(Uri.parse(paramString));
        if (!((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 131072).isEmpty())
        {
          this.mContext.startActivity((Intent)localObject2);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("open url: ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.i("KDSearchResultFragment", 2, ((StringBuilder)localObject1).toString());
          return true;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("cant open url: ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.i("KDSearchResultFragment", 2, ((StringBuilder)localObject1).toString());
        return false;
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("open url error: url=");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(", exception=");
        ((StringBuilder)localObject2).append(localException);
        QLog.e("KDSearchResultFragment", 2, ((StringBuilder)localObject2).toString());
      }
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    try
    {
      paramString = Uri.parse(paramString).getScheme();
      bool1 = bool2;
      if (!"http".equals(paramString))
      {
        bool1 = bool2;
        if (!"https".equals(paramString))
        {
          boolean bool3 = "jsbridge".equals(paramString);
          bool1 = bool2;
          if (!bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public View getVideoLoadingProgressView()
  {
    if (this.c == null) {
      this.c = LayoutInflater.from(this.mContext).inflate(2131629632, null);
    }
    return this.c;
  }
  
  public void onHideCustomView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("KDSearchResultFragment", 2, "hide custom view called");
    }
    Object localObject;
    if (this.b != null)
    {
      localObject = this.a;
      if (localObject != null)
      {
        if (this.f == null) {
          return;
        }
        ((View)localObject).setKeepScreenOn(false);
        this.b.onCustomViewHidden();
      }
    }
    try
    {
      this.f.removeAllViews();
      if ((this.f.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.f.getParent()).removeView(this.f);
      }
      label89:
      localObject = this.g.getActivity();
      if (localObject != null)
      {
        ((Activity)localObject).getWindow().setFlags(this.e, 1024);
        ((Activity)localObject).setRequestedOrientation(this.d);
      }
      this.f = null;
      this.a = null;
      this.b = null;
      this.c = null;
      return;
    }
    catch (Exception localException)
    {
      break label89;
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    KDSearchResultFragment.a(this.g, true);
    if ((KDSearchResultFragment.b(this.g) != null) && (KDSearchResultFragment.b(this.g).d() != 2)) {
      KDSearchResultFragment.b(this.g).a((byte)2);
    }
    this.g.a.setVisibility(8);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    paramWebView = KDSearchResultFragment.a(this.g, paramString);
    KDSearchResultFragment.c(this.g).setText(paramWebView);
    KDSearchResultFragment.b(this.g, paramWebView);
    if ((KDSearchResultFragment.b(this.g) != null) && (KDSearchResultFragment.b(this.g).d() != 0)) {
      KDSearchResultFragment.b(this.g).a((byte)0);
    }
    this.g.a.setVisibility(0);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge")))
    {
      localObject1 = paramString.split("\\?");
      if ((localObject1.length == 2) && (!TextUtils.isEmpty(localObject1[1])))
      {
        localObject1 = localObject1[1].split("#");
        if (localObject1.length == 2)
        {
          int i = 0;
          if (!TextUtils.isEmpty(localObject1[0]))
          {
            String[] arrayOfString = localObject1[0].split("=");
            if (arrayOfString.length % 2 == 0) {
              for (localObject1 = paramString;; localObject1 = localObject3)
              {
                int j = i + 1;
                Object localObject2 = localObject1;
                if (j >= arrayOfString.length) {
                  break;
                }
                localObject2 = localObject1;
                if ("p".equals(arrayOfString[i]))
                {
                  localObject2 = localObject1;
                  if (!TextUtils.isEmpty(arrayOfString[j])) {
                    try
                    {
                      JSONObject localJSONObject = new JSONObject(URLDecoder.decode(arrayOfString[j]));
                      localObject2 = localObject1;
                      if (localJSONObject.has("url")) {
                        localObject2 = localJSONObject.getString("url");
                      }
                    }
                    catch (JSONException localJSONException)
                    {
                      localJSONException.printStackTrace();
                      localObject3 = localObject1;
                      break;
                    }
                  }
                }
                i += 2;
              }
            }
          }
        }
      }
    }
    Object localObject3 = paramString;
    if (b(paramString))
    {
      a(paramString);
      return true;
    }
    if (KDSearchResultFragment.c(this.g, (String)localObject3))
    {
      localObject1 = KDSearchResultFragment.a(this.g, (String)localObject3);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramWebView = URLUtil.a((String)localObject3, "searchbox", "native");
        KDSearchResultFragment.c(this.g).setText((CharSequence)localObject1);
        KDSearchResultFragment.b(this.g, (String)localObject1);
        paramString = KDSearchResultFragment.d(this.g, paramWebView);
        if (paramString != null)
        {
          this.mWebview.loadUrl(paramWebView, paramString);
          return true;
        }
        KDSearchResultFragment.d(this.g).loadUrl(paramWebView);
        return true;
      }
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KDSearchResultFragment", 2, "show custom view called");
    }
    FragmentActivity localFragmentActivity = this.g.getActivity();
    if (paramCustomViewCallback != null)
    {
      if (localFragmentActivity == null) {
        return;
      }
      if (this.b != null)
      {
        paramCustomViewCallback.onCustomViewHidden();
        return;
      }
      this.d = localFragmentActivity.getRequestedOrientation();
      Window localWindow = localFragmentActivity.getWindow();
      if ((localWindow != null) && (localWindow.getAttributes() != null))
      {
        if (localWindow.getDecorView() == null) {
          return;
        }
        this.e = (localWindow.getAttributes().flags & 0x400);
        this.f = new FrameLayout(this.mContext);
        this.f.setBackgroundColor(-16777216);
        ((ViewGroup)localWindow.getDecorView()).addView(this.f, new ViewGroup.LayoutParams(-1, -1));
        localWindow.setFlags(1024, 1024);
        localFragmentActivity.setRequestedOrientation(paramInt);
        this.f.addView(paramView);
        this.a = paramView;
        this.b = paramCustomViewCallback;
        this.f.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.searchresult.KDSearchResultFragment.3
 * JD-Core Version:    0.7.0.1
 */