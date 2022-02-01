package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.HtmlOffline.MyWebResourceResponse;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVOfflineInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class IVOfflinePluginImpl
  implements IVOfflineInterface
{
  private String TAG = "IVOfflinePluginImpl";
  private boolean ex = false;
  private long initTime;
  private boolean isCheckModel = false;
  private boolean isDestroy = false;
  private Context mApplicationContext;
  private AuthorizeConfig mAuthConfig;
  private String mBid;
  private String mBusinessId;
  private Handler mCheckupHandler;
  private ArrayList<String> mExBusinessIdList;
  private int mOfflineLoadMode = 0;
  private WebView mWebView;
  
  public IVOfflinePluginImpl(Context paramContext, WebView paramWebView)
  {
    this.mApplicationContext = paramContext;
    HtmlOffline.a(paramContext);
    this.mWebView = paramWebView;
    this.mAuthConfig = AuthorizeConfig.a(true);
    initHandler();
    this.initTime = System.currentTimeMillis();
  }
  
  private boolean checkModel()
  {
    if ((!this.isCheckModel) && (this.mBusinessId != null))
    {
      Object localObject1 = this.mAuthConfig;
      if (localObject1 != null)
      {
        this.isCheckModel = true;
        localObject1 = ((AuthorizeConfig)localObject1).c("ex_offline", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = ((String)localObject1).split(",");
          Object localObject2 = Build.BRAND;
          String str2 = Build.MODEL;
          String str1 = Build.VERSION.RELEASE;
          localObject2 = new StringBuilder((String)localObject2);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(str2);
          str2 = ((StringBuilder)localObject2).toString().toLowerCase();
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(str1);
          str1 = ((StringBuilder)localObject2).toString().toLowerCase();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            localObject2 = localObject1[i].toLowerCase();
            if ((((String)localObject2).contains(str2)) && (str1.startsWith((String)localObject2)))
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "*****checkOfflineUrl: in ex offline");
              }
              this.mBusinessId = null;
              this.ex = true;
              return true;
            }
            i += 1;
          }
        }
      }
    }
    return false;
  }
  
  private void checkOfflineUp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!isCheckUpByNative(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "checkOfflineUp.");
    }
    HtmlOffline.a(paramString, ((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null), new IVOfflinePluginImpl.1(this));
  }
  
  private void checkOfflineUpNotCallback(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!isCheckUpByNative(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "checkOfflineUpNotCallback.");
    }
    HtmlOffline.a(paramString, ((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null), new IVOfflinePluginImpl.3(this));
  }
  
  private String checkOfflineUrl(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "checkOfflineUrl");
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (!Uri.parse(paramString).isHierarchical()) {
        return paramString;
      }
      try
      {
        this.mBusinessId = Uri.parse(paramString).getQueryParameter("_bid");
        if (this.mBid == null) {
          this.mBid = this.mBusinessId;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (TextUtils.isEmpty(this.mBusinessId))
      {
        this.mBusinessId = this.mAuthConfig.b(paramString);
        if (this.mBid == null) {
          this.mBid = this.mBusinessId;
        }
        if (!TextUtils.isEmpty(this.mBusinessId))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("_bid=");
          ((StringBuilder)localObject).append(this.mBusinessId);
          localObject = HtmlOffline.a(paramString, ((StringBuilder)localObject).toString());
          break label156;
        }
      }
      Object localObject = paramString;
      label156:
      if (checkModel()) {
        return paramString;
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "checkOfflineUrl:");
      }
      return localObject;
    }
    return paramString;
  }
  
  @SuppressLint({"HandlerLeak"})
  private void initHandler()
  {
    this.mCheckupHandler = new IVOfflinePluginImpl.2(this);
  }
  
  private boolean isCheckUpByNative(String paramString)
  {
    Object localObject1;
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("_duck");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkOfflineUpr:url parse exception:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.i("QQBrowserActivity", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = "0";
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.mAuthConfig.c(paramString);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("1")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("webviewLoadUrl", 4, "1 checkOfflineUp _duck=1");
      }
      return false;
    }
    return true;
  }
  
  private void reloadCurrentUrl()
  {
    WebView localWebView = this.mWebView;
    if (localWebView != null)
    {
      localWebView.loadUrl(localWebView.getUrl());
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "reloadCurrentUrl");
      }
    }
  }
  
  public void asyncLoadUrl(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "asyncLoadUrl...");
    }
    long l = System.currentTimeMillis();
    if (!HtmlOffline.a(this.mApplicationContext, paramString, new IVOfflinePluginImpl.4(this, l)))
    {
      this.mWebView.loadUrl(paramString);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "transToLocalUrl: return false");
      }
    }
  }
  
  public boolean isOfflineUrl(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(this.mBusinessId);
    boolean bool1 = true;
    if (bool2)
    {
      checkOfflineUrl(paramString);
      bool1 = true ^ TextUtils.isEmpty(this.mBusinessId);
    }
    if (QLog.isColorLevel())
    {
      paramString = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isOfflineUrl = ");
      localStringBuilder.append(bool1);
      QLog.i(paramString, 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    this.isDestroy = true;
  }
  
  public WebResourceResponse shouldInterceptRequest(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "shouldInterceptRequest");
    }
    if ((!this.ex) && (!TextUtils.isEmpty(paramString)))
    {
      if (!paramString.startsWith("http")) {
        return null;
      }
      if ((TextUtils.isEmpty(this.mBusinessId)) && ((TextUtils.isEmpty(paramString)) || (!paramString.contains("_bid="))))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "empty bid, shouldInterceptRequest return null");
        }
        return null;
      }
      if (checkModel())
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "checkModel, return null");
        }
        return null;
      }
      CharSequence localCharSequence;
      try
      {
        String str = Uri.parse(paramString).getQueryParameter("_bid");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localCharSequence = null;
      }
      Object localObject = localCharSequence;
      if (TextUtils.isEmpty(localCharSequence)) {
        localObject = this.mBusinessId;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      boolean bool = TextUtils.isEmpty(this.mBusinessId);
      int k = 1;
      int m = 0;
      int j;
      if ((!bool) && (((String)localObject).equals(this.mBusinessId)))
      {
        j = 0;
      }
      else
      {
        checkOfflineUpNotCallback(paramString);
        if (this.mExBusinessIdList == null) {
          this.mExBusinessIdList = new ArrayList();
        }
        int n = this.mExBusinessIdList.size();
        j = 0;
        int i;
        for (;;)
        {
          i = m;
          if (j >= n) {
            break;
          }
          if (((String)localObject).equals(this.mExBusinessIdList.get(j)))
          {
            i = 1;
            break;
          }
          j += 1;
        }
        if (i == 0) {
          this.mExBusinessIdList.add(localObject);
        }
        j = k;
        if (i == 0)
        {
          j = k;
          if (!HtmlOffline.h((String)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "verifySign fail to reload");
            }
            return null;
          }
        }
      }
      if (((this.mOfflineLoadMode == 3) || (j != 0)) && (!HtmlOffline.c((String)localObject, paramString)))
      {
        reloadCurrentUrl();
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "shouldInterceptRequest verify single fail to reload");
        }
        return null;
      }
      paramString = HtmlOffline.b((String)localObject, paramString);
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "shouldInterceptRequest return null");
        }
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "shouldInterceptRequest , return local value");
      }
      return new WebResourceResponse(paramString.a, "utf-8", paramString.b);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl
 * JD-Core Version:    0.7.0.1
 */