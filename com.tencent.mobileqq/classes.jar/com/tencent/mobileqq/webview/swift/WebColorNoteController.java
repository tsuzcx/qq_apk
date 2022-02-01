package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.comic.api.IQQComicWebViewApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class WebColorNoteController
  implements IServiceInfo
{
  protected QQBrowserActivity a = null;
  private IColorNoteController b;
  private ColorNote c;
  private boolean d = true;
  
  public WebColorNoteController(@NonNull QQBrowserActivity paramQQBrowserActivity)
  {
    this.a = paramQQBrowserActivity;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      if (paramInt == 16908288) {
        QLog.d("WebColorNoteController", 2, "QQBrowserActivity getColorNote,serviceType is ColorNoteConstants.ServiceType.WEB.");
      }
      if (paramInt == 16908292) {
        QLog.d("WebColorNoteController", 2, "QQBrowserActivity getColorNote,serviceType is ColorNoteConstants.ServiceType.BODONG.");
      }
    }
  }
  
  private void a(IColorNoteSwipeLayout paramIColorNoteSwipeLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebColorNoteController", 2, "QQBrowserActivity initColorNote.");
    }
    boolean bool2 = BaseApplicationImpl.getApplication().getRuntime().isLogin();
    boolean bool1 = ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isDisableSwipeByUrl(this.a.getOriginalUrl()) ^ true;
    if (((IQQComicWebViewApi)QRoute.api(IQQComicWebViewApi.class)).isBoodoUrl(this.a.getOriginalUrl()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebColorNoteController", 2, "This is boodo url ,disable swipe.");
      }
      bool1 = false;
    }
    if ((((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isUrlBlocked(this.a.getOriginalUrl())) || (TextUtils.isEmpty(this.a.getOriginalUrl()))) {
      bool1 = false;
    }
    if (bool2)
    {
      this.b = ((IColorNoteController)QRoute.api(IColorNoteController.class));
      if (bool1) {
        this.b.init(this.a, true, false, paramIColorNoteSwipeLayout, true, true, false, 2131165829);
      } else {
        this.b.init(this.a, false, true, paramIColorNoteSwipeLayout, true, true, false, 2131165829);
      }
      this.b.attachToActivity(this.a);
      this.b.setServiceInfo(this);
      this.c = getColorNote();
      this.b.setOnColorNoteAnimFinishListener(new WebColorNoteController.1(this));
      this.b.setOnPageSwipeListener(new WebColorNoteController.2(this));
      this.b.doSetPropertiesFromWebView(this.a.getOriginalUrl());
    }
  }
  
  protected void a()
  {
    a(null);
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.d) {
      a();
    }
  }
  
  public void a(IServiceInfo paramIServiceInfo)
  {
    IColorNoteController localIColorNoteController = this.b;
    if (localIColorNoteController != null) {
      localIColorNoteController.setServiceInfo(paramIServiceInfo);
    }
  }
  
  public boolean a(String paramString)
  {
    IColorNoteController localIColorNoteController = this.b;
    return (localIColorNoteController != null) && (localIColorNoteController.shouldDisplayColorNote()) && (this.b.hasShareEntr()) && (!((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isUrlShareEntranceBlocked(paramString));
  }
  
  public void b()
  {
    if (this.d)
    {
      IColorNoteController localIColorNoteController = this.b;
      if (localIColorNoteController != null) {
        localIColorNoteController.onDestroy();
      }
    }
  }
  
  public void c()
  {
    if (this.d)
    {
      IColorNoteController localIColorNoteController = this.b;
      if (localIColorNoteController != null) {
        localIColorNoteController.onResume();
      }
    }
    if (((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isUrlSmallScreenBlocked(this.a.getOriginalUrl()))
    {
      ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this.a, 2, false);
      if (QLog.isColorLevel()) {
        QLog.d("WebColorNoteController", 2, "color note small screen invisible by doOnResume");
      }
    }
  }
  
  public void d()
  {
    if (this.d)
    {
      IColorNoteController localIColorNoteController = this.b;
      if (localIColorNoteController != null)
      {
        localIColorNoteController.onPause();
        if (this.a.getIntent().getBooleanExtra("isFromFavourite", false)) {
          this.b.addHistoryNote();
        }
      }
    }
    if (((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isUrlSmallScreenBlocked(this.a.getOriginalUrl()))
    {
      ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this.a, 2, true);
      if (QLog.isColorLevel()) {
        QLog.d("WebColorNoteController", 2, "color note small screen visible by doOnPause");
      }
    }
  }
  
  protected void e()
  {
    this.d = true;
  }
  
  protected void f()
  {
    this.d = false;
  }
  
  public boolean g()
  {
    IColorNoteController localIColorNoteController = this.b;
    return (localIColorNoteController != null) && ((localIColorNoteController.isColorNoteExist()) || (this.b.isSwipeBackExit()));
  }
  
  public ColorNote getColorNote()
  {
    Object localObject9 = this.a.getIntent();
    Object localObject5 = this.a.getCurrentWebViewFragment();
    Object localObject7 = "";
    Object localObject4;
    Object localObject8;
    if ((localObject5 != null) && (((WebViewFragment)localObject5).getAppRuntime() != null))
    {
      localObject4 = (Share)((WebViewFragment)localObject5).getShare();
      Object localObject1;
      if (!TextUtils.isEmpty(((Share)localObject4).d())) {
        localObject1 = ((Share)localObject4).d();
      }
      for (;;)
      {
        break;
        localObject1 = localObject7;
        if (((WebViewFragment)localObject5).getSwiftTitleUI() != null) {
          try
          {
            localObject1 = ((WebViewFragment)localObject5).getSwiftTitleUI().h();
          }
          catch (Exception localException1)
          {
            QLog.e("WebColorNoteController", 2, "fragment.mSwiftTitleUI.getTitle()", localException1);
            localObject2 = localObject7;
          }
        }
      }
      localObject5 = ((Share)localObject4).e();
      localObject7 = ((Share)localObject4).f();
      localObject4 = localObject7;
      if (TextUtils.isEmpty((CharSequence)localObject7)) {
        localObject4 = ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).getWebViewIconUrl(this.a.getOriginalUrl());
      }
      localObject8 = localObject4;
      localObject4 = localObject5;
      localObject7 = localObject2;
    }
    else
    {
      localObject4 = null;
      localObject8 = localObject4;
    }
    Object localObject2 = this.c;
    if ((localObject2 != null) && (((ColorNote)localObject2).isTitleAndPicValid()))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject7)) {
        this.c.mMainTitle = ((String)localObject7);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        this.c.mSubTitle = ((String)localObject4);
      }
      if (!TextUtils.isEmpty(localObject8)) {
        this.c.mPicUrl = localObject8;
      }
      return this.c;
    }
    localObject2 = this.a.getHostWebView();
    JSONObject localJSONObject = new JSONObject();
    if (localObject2 != null) {
      try
      {
        localJSONObject.put("key_scroll_y", ((WebView)localObject2).getWebScrollY());
      }
      catch (JSONException localJSONException)
      {
        QLog.e("WebColorNoteController", 1, localJSONException, new Object[0]);
      }
    }
    Object localObject3 = this.a.getOriginalUrl();
    localObject5 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject5 = ((Intent)localObject9).getStringExtra("subType");
    }
    if (localObject5 != null)
    {
      localObject3 = localObject5;
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {}
    }
    else
    {
      localObject3 = "unregistered service sub type";
    }
    if (TextUtils.isEmpty((CharSequence)localObject4))
    {
      localObject4 = this.a.getOriginalUrl();
      try
      {
        localObject5 = new URL((String)localObject4);
        if (!TextUtils.isEmpty(((URL)localObject5).getHost()))
        {
          localObject5 = ((URL)localObject5).getHost();
          localObject4 = localObject5;
        }
      }
      catch (Exception localException2)
      {
        QLog.e("WebColorNoteController", 1, localException2, new Object[0]);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QLog.e("WebColorNoteController", 1, localMalformedURLException, new Object[0]);
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.e("WebColorNoteController", 1, localRuntimeException, new Object[0]);
      }
    }
    Object localObject6 = this.a.getOriginalUrl();
    localObject9 = (IQQComicWebViewApi)QRoute.api(IQQComicWebViewApi.class);
    int i;
    if (((IQQComicWebViewApi)localObject9).isBoodoUrl((String)localObject6))
    {
      localObject3 = ((IQQComicWebViewApi)localObject9).addUrlField(((IQQComicWebViewApi)localObject9).replaceUrlFieldValueReg(((IQQComicWebViewApi)localObject9).addUrlField((String)localObject6, "from", "1041001"), "from", "1041001"), "openFromColorTab", "1");
      if (QLog.isColorLevel())
      {
        localObject9 = new StringBuilder();
        ((StringBuilder)localObject9).append("isBoodoUlr,serviceType is ColorNoteConstants.ServiceType.BODONG, original url is ");
        ((StringBuilder)localObject9).append((String)localObject6);
        ((StringBuilder)localObject9).append(", new url is ");
        ((StringBuilder)localObject9).append((String)localObject3);
        QLog.d("WebColorNoteController", 2, ((StringBuilder)localObject9).toString());
      }
      i = 16908292;
    }
    else
    {
      i = 16908288;
    }
    a(i);
    localObject6 = this.b;
    if (localObject6 != null)
    {
      localObject3 = ((IColorNoteController)localObject6).onGetColorNote(i, (String)localObject3, (String)localObject7, (String)localObject4, localObject8, localJSONObject.toString().getBytes());
      this.c = ((ColorNote)localObject3);
      return localObject3;
    }
    localObject3 = new ColorNote.Builder().a(i).a((String)localObject3).b((String)localObject7).c((String)localObject4).d(localObject8).a(localJSONObject.toString().getBytes()).a();
    this.c = ((ColorNote)localObject3);
    return localObject3;
  }
  
  public boolean h()
  {
    if (this.d)
    {
      IColorNoteController localIColorNoteController = this.b;
      if (localIColorNoteController != null)
      {
        localIColorNoteController.exitAnimation();
        return true;
      }
    }
    return false;
  }
  
  public IColorNoteController i()
  {
    return this.b;
  }
  
  public void j()
  {
    IColorNoteController localIColorNoteController = this.b;
    if (localIColorNoteController != null)
    {
      if (!localIColorNoteController.isColorNoteExist())
      {
        if (this.b.canAddColorNote())
        {
          this.b.insertColorNote();
          this.a.finish();
          return;
        }
        this.b.onCannotAdd();
        return;
      }
      this.b.deleteColorNote();
    }
  }
  
  public boolean k()
  {
    IColorNoteController localIColorNoteController = this.b;
    return (localIColorNoteController != null) && (localIColorNoteController.isColorNoteExist());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebColorNoteController
 * JD-Core Version:    0.7.0.1
 */