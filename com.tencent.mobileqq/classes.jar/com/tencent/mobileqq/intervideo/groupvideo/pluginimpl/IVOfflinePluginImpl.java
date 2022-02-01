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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVOfflineInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import nhe;
import nko;
import nks;

public class IVOfflinePluginImpl
  implements IVOfflineInterface
{
  private String TAG = "IVOfflinePluginImpl";
  private boolean ex;
  private long initTime;
  private boolean isCheckModel;
  private boolean isDestroy;
  private Context mApplicationContext;
  private nhe mAuthConfig;
  private String mBid;
  private String mBusinessId;
  private Handler mCheckupHandler;
  private ArrayList<String> mExBusinessIdList;
  private int mOfflineLoadMode = 0;
  private WebView mWebView;
  
  public IVOfflinePluginImpl(Context paramContext, WebView paramWebView)
  {
    this.mApplicationContext = paramContext;
    nko.a(paramContext);
    this.mWebView = paramWebView;
    this.mAuthConfig = nhe.a(true);
    initHandler();
    this.initTime = System.currentTimeMillis();
  }
  
  private boolean checkModel()
  {
    if ((!this.isCheckModel) && (this.mBusinessId != null) && (this.mAuthConfig != null))
    {
      this.isCheckModel = true;
      Object localObject1 = this.mAuthConfig.a("ex_offline", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(",");
        Object localObject2 = Build.BRAND;
        String str2 = Build.MODEL;
        String str1 = Build.VERSION.RELEASE;
        localObject2 = new StringBuilder((String)localObject2);
        ((StringBuilder)localObject2).append(" ").append(str2);
        str2 = ((StringBuilder)localObject2).toString().toLowerCase();
        str1 = (" " + str1).toLowerCase();
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
    return false;
  }
  
  private void checkOfflineUp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!isCheckUpByNative(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "checkOfflineUp.");
    }
    nko.a(paramString, ((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null), new IVOfflinePluginImpl.1(this));
  }
  
  private void checkOfflineUpNotCallback(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!isCheckUpByNative(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "checkOfflineUpNotCallback.");
    }
    nko.a(paramString, ((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null), new IVOfflinePluginImpl.3(this));
  }
  
  private String checkOfflineUrl(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "checkOfflineUrl");
    }
    if ((TextUtils.isEmpty(paramString)) || (!Uri.parse(paramString).isHierarchical())) {}
    for (;;)
    {
      return paramString;
      try
      {
        this.mBusinessId = Uri.parse(paramString).getQueryParameter("_bid");
        if (this.mBid == null) {
          this.mBid = this.mBusinessId;
        }
        if (TextUtils.isEmpty(this.mBusinessId))
        {
          this.mBusinessId = this.mAuthConfig.b(paramString);
          if (this.mBid == null) {
            this.mBid = this.mBusinessId;
          }
          if (!TextUtils.isEmpty(this.mBusinessId))
          {
            String str1 = nko.a(paramString, "_bid=" + this.mBusinessId);
            if (checkModel()) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i(this.TAG, 2, "checkOfflineUrl:");
            }
            return str1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          String str2 = paramString;
        }
      }
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  private void initHandler()
  {
    this.mCheckupHandler = new IVOfflinePluginImpl.2(this);
  }
  
  private boolean isCheckUpByNative(String paramString)
  {
    Object localObject2 = "0";
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("_duck");
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = this.mAuthConfig.c(paramString);
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("1")))
      {
        if (QLog.isColorLevel()) {
          QLog.i("webviewLoadUrl", 4, "1 checkOfflineUp _duck=1");
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("QQBrowserActivity", 2, "checkOfflineUpr:url parse exception:" + paramString);
          localObject1 = localObject2;
        }
      }
    }
    return true;
  }
  
  private void reloadCurrentUrl()
  {
    if (this.mWebView != null)
    {
      this.mWebView.loadUrl(this.mWebView.getUrl());
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
    if (!nko.a(this.mApplicationContext, paramString, new IVOfflinePluginImpl.4(this, l)))
    {
      this.mWebView.loadUrl(paramString);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "transToLocalUrl: return false");
      }
    }
  }
  
  public boolean isOfflineUrl(String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (TextUtils.isEmpty(this.mBusinessId))
    {
      checkOfflineUrl(paramString);
      if (TextUtils.isEmpty(this.mBusinessId)) {
        break label68;
      }
    }
    label68:
    for (bool1 = bool2;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "isOfflineUrl = " + bool1);
      }
      return bool1;
    }
  }
  
  public void onDestroy()
  {
    this.isDestroy = true;
  }
  
  public WebResourceResponse shouldInterceptRequest(String paramString)
  {
    int i = 0;
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "shouldInterceptRequest");
    }
    if ((this.ex) || (TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http"))) {}
    label285:
    do
    {
      for (;;)
      {
        return null;
        if ((!TextUtils.isEmpty(this.mBusinessId)) || ((!TextUtils.isEmpty(paramString)) && (paramString.contains("_bid="))))
        {
          if (checkModel())
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i(this.TAG, 2, "checkModel, return null");
            return null;
          }
          try
          {
            String str1 = Uri.parse(paramString).getQueryParameter("_bid");
            str2 = str1;
            if (TextUtils.isEmpty(str1)) {
              str2 = this.mBusinessId;
            }
            if (!TextUtils.isEmpty(str2)) {
              if ((TextUtils.isEmpty(this.mBusinessId)) || (!str2.equals(this.mBusinessId)))
              {
                checkOfflineUpNotCallback(paramString);
                if (this.mExBusinessIdList == null) {
                  this.mExBusinessIdList = new ArrayList();
                }
                int m = this.mExBusinessIdList.size();
                i = 0;
                int j = k;
                if (i < m)
                {
                  if (str2.equals(this.mExBusinessIdList.get(i))) {
                    j = 1;
                  }
                }
                else
                {
                  if (j == 0) {
                    this.mExBusinessIdList.add(str2);
                  }
                  if ((j != 0) || (nko.c(str2))) {
                    break label285;
                  }
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d(this.TAG, 2, "verifySign fail to reload");
                  return null;
                }
              }
            }
          }
          catch (Exception localException)
          {
            String str2;
            for (;;)
            {
              localException.printStackTrace();
              Object localObject = null;
              continue;
              i += 1;
            }
            i = 1;
            if (((this.mOfflineLoadMode == 3) || (i != 0)) && (!nko.a(str2, paramString)))
            {
              reloadCurrentUrl();
              if (QLog.isColorLevel())
              {
                QLog.d(this.TAG, 2, "shouldInterceptRequest verify single fail to reload");
                return null;
              }
            }
            else
            {
              paramString = nko.a(str2, paramString);
              if (paramString == null)
              {
                if (QLog.isColorLevel())
                {
                  QLog.d(this.TAG, 2, "shouldInterceptRequest return null");
                  return null;
                }
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d(this.TAG, 2, "shouldInterceptRequest , return local value");
                }
                return new WebResourceResponse(paramString.jdField_a_of_type_JavaLangString, "utf-8", paramString.jdField_a_of_type_JavaIoInputStream);
              }
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "empty bid, shouldInterceptRequest return null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl
 * JD-Core Version:    0.7.0.1
 */