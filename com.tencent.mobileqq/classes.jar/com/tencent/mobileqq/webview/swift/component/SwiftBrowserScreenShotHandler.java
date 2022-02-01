package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.Listener;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.api.IScreenShotImageUtil;
import com.tencent.mobileqq.kandian.biz.share.api.IScreenShotShareHelper;
import com.tencent.mobileqq.kandian.biz.share.api.IScreenShotShareHelperFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.util.WeakReferenceHandler;
import org.json.JSONArray;

public class SwiftBrowserScreenShotHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements Handler.Callback, AdapterView.OnItemClickListener, ScreenshotContentObserver.Listener
{
  public Activity a;
  public WebViewProvider c;
  ElasticHorScrView d;
  int e;
  ScreenshotContentObserver f = null;
  LinearLayout g = null;
  Bitmap h = null;
  String i = null;
  int j = 0;
  int k = 0;
  float l = 0.0F;
  boolean m = false;
  boolean n = false;
  boolean o = false;
  String p;
  Handler q = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private final String r = "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=openUrl&url=";
  private IScreenShotShareHelper s;
  
  private void f()
  {
    this.s = ((IScreenShotShareHelperFactory)QRoute.api(IScreenShotShareHelperFactory.class)).createScreenShotShareHelper(this.a);
    this.s.a(this);
    Object localObject2 = this.a.getIntent();
    Object localObject1 = this.c;
    if (localObject1 != null) {
      localObject2 = ((WebViewProvider)localObject1).getIntent();
    }
    String str = ((Intent)localObject2).getStringExtra("url");
    localObject1 = str;
    if (str == null)
    {
      localObject2 = ((Intent)localObject2).getStringExtra("key_params_qq");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    this.s.a((String)localObject1);
  }
  
  public void a()
  {
    super.a();
    this.a = this.b.b();
    this.c = this.b.c();
    f();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 9) {
            return;
          }
          a(paramBundle.getString("url", ""));
          return;
        }
        paramBundle = this.s;
        if (paramBundle != null) {
          paramBundle.k();
        }
        paramInt = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
        paramBundle = this.d;
        if (paramBundle != null)
        {
          if (paramInt < this.e)
          {
            paramBundle.setMove(true);
            return;
          }
          paramBundle.setMove(false);
        }
      }
      else
      {
        c();
        paramBundle = this.q;
        if (paramBundle != null) {
          paramBundle.removeCallbacksAndMessages(null);
        }
        paramBundle = this.s;
        if (paramBundle != null) {
          paramBundle.a();
        }
      }
    }
    else if (e())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "ScreenshotResume!");
      }
      this.q.postDelayed(new SwiftBrowserScreenShotHandler.1(this), 1000L);
    }
  }
  
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramUri = new StringBuilder();
      paramUri.append("onDetectScreenshot->fromType:");
      paramUri.append(paramInt);
      QLog.d("SwiftBrowserScreenShotHandler", 2, paramUri.toString());
    }
    paramUri = this.a;
    if (((paramUri instanceof QBaseActivity)) && (((QBaseActivity)paramUri).isResume()))
    {
      if (QLog.isDevelopLevel())
      {
        paramUri = new StringBuilder();
        paramUri.append("onDetectScreenshot->begin time:");
        paramUri.append(System.currentTimeMillis());
        QLog.d("SwiftBrowserScreenShotHandler", 2, paramUri.toString());
      }
      paramUri = this.s;
      if (paramUri != null) {
        paramUri = paramUri.m();
      } else {
        paramUri = "";
      }
      paramUri = Uri.parse(paramUri);
      try
      {
        paramUri = paramUri.getQueryParameter("article_id");
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
        paramUri = "";
      }
      paramString = paramUri;
      if (paramUri == null) {
        paramString = "";
      }
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A69", "0X8006A69", 0, 0, "", paramString, "", "");
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A69", "", "", paramString, "", "");
      if (QLog.isDevelopLevel())
      {
        paramUri = new StringBuilder();
        paramUri.append("onDetectScreenshot->after report time:");
        paramUri.append(System.currentTimeMillis());
        QLog.d("SwiftBrowserScreenShotHandler", 2, paramUri.toString());
      }
      paramUri = d();
      if (paramUri == null)
      {
        QLog.e("SwiftBrowserScreenShotHandler", 1, "onDetectScreenshot error, root = null");
        return;
      }
      paramUri.buildDrawingCache();
      paramString = paramUri.getDrawingCache();
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDetectScreenshot->get screenshot time:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject).toString());
      }
      int i1 = BaseApplicationImpl.getContext().getResources().getConfiguration().orientation;
      if (paramString != null)
      {
        localObject = this.h;
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          localObject = this.g;
          if ((localObject == null) || (((LinearLayout)localObject).getVisibility() == 8)) {
            this.h = null;
          }
        }
        this.h = ((IScreenShotImageUtil)QRoute.api(IScreenShotImageUtil.class)).getScreenShotBitmap(this.a.getWindow(), paramString);
        if (this.h != null)
        {
          localObject = this.s;
          if (localObject != null) {
            ((IScreenShotShareHelper)localObject).a(paramInt);
          }
          if (paramInt == 1)
          {
            this.m = true;
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).arg1 = i1;
            this.q.sendMessage((Message)localObject);
            if (QLog.isDevelopLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("onDetectScreenshot->send msg_show_pad time:");
              ((StringBuilder)localObject).append(System.currentTimeMillis());
              QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject).toString());
            }
          }
          else if (paramInt == 2)
          {
            QQToast.makeText(BaseApplicationImpl.getContext(), 0, 2131892975, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920));
          }
          ThreadManager.executeOnFileThread(new SwiftBrowserScreenShotHandler.3(this, paramInt));
        }
        paramString.recycle();
      }
      paramUri.destroyDrawingCache();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->activity is not resume!");
    }
  }
  
  public void a(String paramString)
  {
    IScreenShotShareHelper localIScreenShotShareHelper = this.s;
    if (localIScreenShotShareHelper != null) {
      localIScreenShotShareHelper.a(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    IScreenShotShareHelper localIScreenShotShareHelper = this.s;
    if (localIScreenShotShareHelper != null) {
      localIScreenShotShareHelper.a(paramString1, paramString2, paramInt);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doMultiShare->imgUrl:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", isGif:");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = new Bundle();
    Object localObject2 = CookieManager.getInstance();
    ((CookieManager)localObject2).setAcceptCookie(true);
    localObject2 = ((CookieManager)localObject2).getCookie(paramString);
    if (localObject2 != null) {
      ((Bundle)localObject1).putString("Cookie", (String)localObject2);
    }
    this.s.o().show();
    this.p = paramString;
    ThreadManager.executeOnSubThread(new SwiftBrowserScreenShotHandler.6(this, paramString, (Bundle)localObject1, paramBoolean));
  }
  
  public void a(JSONArray paramJSONArray)
  {
    IScreenShotShareHelper localIScreenShotShareHelper = this.s;
    if (localIScreenShotShareHelper != null) {
      localIScreenShotShareHelper.a(paramJSONArray);
    }
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    Object localObject1;
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showScreenshotPad->begin isShow:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", orientation:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      if (this.o) {
        return;
      }
      localObject1 = this.g;
      Object localObject2;
      if ((localObject1 != null) && ((((LinearLayout)localObject1).getTag() instanceof Integer)))
      {
        int i1 = ((Integer)this.g.getTag()).intValue();
        if (i1 != paramInt)
        {
          if (QLog.isDevelopLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("showScreenshotPad->orientation change old:");
            ((StringBuilder)localObject1).append(i1);
            ((StringBuilder)localObject1).append(", new:");
            ((StringBuilder)localObject1).append(paramInt);
            QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = (RelativeLayout)this.a.findViewById(2131429740);
          localObject2 = (SwiftBrowserUIStyleHandler)this.b.d().a(2);
          if ((localObject2 != null) && (((SwiftBrowserUIStyleHandler)localObject2).x != null)) {
            ((SwiftBrowserUIStyleHandler)localObject2).x.findViewById(2131429740);
          }
          this.g.setVisibility(8);
          ((RelativeLayout)localObject1).removeView(this.g);
          this.g = null;
        }
      }
      if (this.g == null)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("showScreenshotPad->pad create time:");
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject1).toString());
        }
        this.g = ((LinearLayout)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131625653, null));
        localObject1 = (RelativeLayout)this.a.findViewById(2131429740);
        localObject2 = (SwiftBrowserUIStyleHandler)this.b.d().a(2);
        if ((localObject2 != null) && (((SwiftBrowserUIStyleHandler)localObject2).x != null)) {
          ((SwiftBrowserUIStyleHandler)localObject2).x.findViewById(2131429740);
        }
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, AIOUtils.b(10.0F, BaseApplicationImpl.getContext().getResources()), AIOUtils.b(65.0F, BaseApplicationImpl.getContext().getResources()));
        ((RelativeLayout)localObject1).addView(this.g, (ViewGroup.LayoutParams)localObject2);
        this.g.setTag(Integer.valueOf(paramInt));
        if (paramInt == 2)
        {
          localObject1 = (LinearLayout.LayoutParams)this.g.findViewById(2131445348).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).width = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298306);
          ((LinearLayout.LayoutParams)localObject1).height = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298307);
        }
        this.g.findViewById(2131445348).setOnClickListener(new SwiftBrowserScreenShotHandler.4(this));
      }
      if (this.g.getAnimation() != null)
      {
        this.g.getAnimation().cancel();
        this.g.clearAnimation();
      }
      ((ImageView)this.g.findViewById(2131445348)).setImageBitmap(this.h);
      this.g.setVisibility(0);
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showScreenshotPad->pad visible time:");
        ((StringBuilder)localObject1).append(System.currentTimeMillis());
        QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showScreenshotPad->begin hide mScreenshotContainer:");
        ((StringBuilder)localObject1).append(this.g);
        QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject1).toString());
        if (this.g != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("showScreenshotPad->begin hide mScreenshotContainerVisibility:");
          ((StringBuilder)localObject1).append(this.g.getVisibility());
          QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject1).toString());
        }
      }
      localObject1 = this.g;
      if ((localObject1 != null) && (((LinearLayout)localObject1).getVisibility() == 0))
      {
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setAnimationListener(new SwiftBrowserScreenShotHandler.5(this));
        this.g.startAnimation((Animation)localObject1);
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("showScreenshotPad->pad gone time:");
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
  
  public String b()
  {
    return this.s.b();
  }
  
  public void b(String paramString)
  {
    Object localObject;
    if ((this.f == null) && (this.a != null))
    {
      localObject = new DisplayMetrics();
      this.a.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.j = ((DisplayMetrics)localObject).widthPixels;
      this.k = ((DisplayMetrics)localObject).heightPixels;
      this.l = ((DisplayMetrics)localObject).density;
      this.f = new ScreenshotContentObserver(this.a, this.j, this.k);
      this.f.a(this);
      localObject = d();
      if (localObject != null)
      {
        ((View)localObject).setDrawingCacheEnabled(true);
        ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new SwiftBrowserScreenShotHandler.2(this, (View)localObject));
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("registerScreenshotObserver->mScreenWidth:");
        ((StringBuilder)localObject).append(this.j);
        ((StringBuilder)localObject).append(", mScreenHeight:");
        ((StringBuilder)localObject).append(this.k);
        ((StringBuilder)localObject).append(", mScreenDensity:");
        ((StringBuilder)localObject).append(this.l);
        QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.s;
      if (localObject != null)
      {
        ((IScreenShotShareHelper)localObject).c(paramString.replace("|", "｜"));
        return;
      }
    }
    paramString = this.s;
    if ((paramString != null) && (TextUtils.isEmpty(paramString.l())) && (this.a != null)) {
      this.s.c(BaseApplicationImpl.getContext().getResources().getString(2131892973));
    }
  }
  
  public void c()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      ((ScreenshotContentObserver)localObject).a();
      if (this.a != null)
      {
        localObject = d();
        if (localObject != null) {
          ((View)localObject).setDrawingCacheEnabled(false);
        }
      }
      this.f = null;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "unregisterScreenshotObserver!");
      }
    }
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      IScreenShotShareHelper localIScreenShotShareHelper = this.s;
      if (localIScreenShotShareHelper != null) {
        localIScreenShotShareHelper.c(paramString.replace("|", "｜"));
      }
    }
  }
  
  View d()
  {
    SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = (SwiftBrowserUIStyleHandler)this.b.d().a(2);
    int i1;
    if ((!localSwiftBrowserUIStyleHandler.f.a) && (!localSwiftBrowserUIStyleHandler.f.b)) {
      i1 = 2131447595;
    } else {
      i1 = 2131429740;
    }
    Object localObject = this.a.findViewById(i1);
    if (localSwiftBrowserUIStyleHandler.x != null) {
      localObject = this.c.getContentView();
    }
    return localObject;
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      IScreenShotShareHelper localIScreenShotShareHelper = this.s;
      if (localIScreenShotShareHelper != null) {
        localIScreenShotShareHelper.b(paramString);
      }
    }
  }
  
  public void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      IScreenShotShareHelper localIScreenShotShareHelper = this.s;
      if (localIScreenShotShareHelper != null) {
        localIScreenShotShareHelper.f(paramString);
      }
    }
  }
  
  public boolean e()
  {
    return this.f != null;
  }
  
  public void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QRUtils.a(1, 2131892978);
      return;
    }
    paramString = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.a, paramString, true, true, true, true, true, 4);
    paramString.putExtra("EditPicType", this.s.n());
    this.a.startActivity(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return false;
        }
        f(this.i);
        return true;
      }
      if (QLog.isDevelopLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage->recv msg_hide_pad time:");
        paramMessage.append(System.currentTimeMillis());
        QLog.d("SwiftBrowserScreenShotHandler", 2, paramMessage.toString());
      }
      a(false, 0);
      return true;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage->recv msg_show_pad time:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("SwiftBrowserScreenShotHandler", 2, localStringBuilder.toString());
    }
    this.q.removeMessages(2);
    a(true, paramMessage.arg1);
    this.q.sendEmptyMessageDelayed(2, 3000L);
    return true;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->begin!");
    }
    Object localObject = paramView.getTag();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->tag null!");
      }
    }
    else
    {
      int i1 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).c.action;
      localObject = this.c;
      if (localObject != null)
      {
        String str3 = ((WebViewProvider)localObject).getWebView().getUrl();
        localObject = Uri.parse(str3);
        String str1;
        try
        {
          localObject = ((Uri)localObject).getQueryParameter("article_id");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          str1 = "";
        }
        String str2 = str1;
        if (str1 == null) {
          str2 = "";
        }
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 9)
            {
              if (i1 != 10)
              {
                if (i1 == 12)
                {
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800787A", "0X800787A", 0, 0, str2, str3, "", "");
                  ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1005", str2, "", "");
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1005", str2, "", "");
                  if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action sina weibo!");
                  }
                }
              }
              else
              {
                ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1004", str2, "", "");
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1004", str2, "", "");
                if (QLog.isColorLevel()) {
                  QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action wechat circle!");
                }
              }
            }
            else
            {
              ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1003", str2, "", "");
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1003", str2, "", "");
              if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action wechat!");
              }
            }
          }
          else
          {
            ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1002", str2, "", "");
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1002", str2, "", "");
            if (QLog.isColorLevel()) {
              QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action qzone!");
            }
          }
        }
        else
        {
          ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1001", str2, "", "");
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1001", str2, "", "");
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action friend!");
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->end!");
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler
 * JD-Core Version:    0.7.0.1
 */