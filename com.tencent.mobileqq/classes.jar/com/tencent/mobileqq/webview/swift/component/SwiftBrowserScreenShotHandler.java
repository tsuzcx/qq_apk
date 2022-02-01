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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotImageUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.Listener;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.util.WeakReferenceHandler;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import org.json.JSONArray;

public class SwiftBrowserScreenShotHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements Handler.Callback, AdapterView.OnItemClickListener, ScreenshotContentObserver.Listener
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  public Activity a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private ScreenShotShareHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper;
  ScreenshotContentObserver jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = null;
  ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  public WebViewProvider a;
  String jdField_a_of_type_JavaLangString = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  private final String jdField_c_of_type_JavaLangString = "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=openUrl&url=";
  boolean jdField_c_of_type_Boolean = false;
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper = new ScreenShotShareHelper(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a(this);
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getIntent();
    }
    String str = ((Intent)localObject).getStringExtra("url");
    if (str == null)
    {
      str = ((Intent)localObject).getStringExtra("key_params_qq");
      localObject = str;
      if (str != null) {}
    }
    for (localObject = "";; localObject = str)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a((String)localObject);
      return;
    }
  }
  
  View a()
  {
    int i = 2131379546;
    SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2);
    if ((localSwiftBrowserUIStyleHandler.a.jdField_a_of_type_Boolean) || (localSwiftBrowserUIStyleHandler.a.jdField_b_of_type_Boolean)) {
      i = 2131363879;
    }
    View localView = this.jdField_a_of_type_AndroidAppActivity.findViewById(i);
    if (localSwiftBrowserUIStyleHandler.d != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getContentView();
    }
    return localView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver.a();
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        View localView = a();
        if (localView != null) {
          localView.setDrawingCacheEnabled(false);
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = null;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "unregisterScreenshotObserver!");
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
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
          a();
          if (this.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          }
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper == null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a();
        return;
      } while (!a());
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "ScreenshotResume!");
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SwiftBrowserScreenShotHandler.1(this), 1000L);
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a() != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a().onConfigurationChanged();
      }
      paramInt = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
    } while (this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView == null);
    if (paramInt < this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
  
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->fromType:" + paramInt);
    }
    if ((!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) || (!((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->activity is not resume!");
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->begin time:" + System.currentTimeMillis());
    }
    paramString = "";
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper != null) {
      paramUri = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.c();
    }
    int i;
    for (;;)
    {
      paramUri = Uri.parse(paramUri);
      try
      {
        paramUri = paramUri.getQueryParameter("article_id");
        paramString = paramUri;
        if (paramUri == null) {
          paramString = "";
        }
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A69", "0X8006A69", 0, 0, "", paramString, "", "");
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A69", "", "", paramString, "", "");
        if (QLog.isDevelopLevel()) {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->after report time:" + System.currentTimeMillis());
        }
        paramUri = a();
        if (paramUri == null)
        {
          QLog.e("SwiftBrowserScreenShotHandler", 1, "onDetectScreenshot error, root = null");
          return;
          paramUri = "";
        }
      }
      catch (Exception paramUri)
      {
        for (;;)
        {
          paramUri.printStackTrace();
          paramUri = paramString;
        }
        paramUri.buildDrawingCache();
        paramString = paramUri.getDrawingCache();
        if (QLog.isDevelopLevel()) {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->get screenshot time:" + System.currentTimeMillis());
        }
        i = BaseApplicationImpl.getContext().getResources().getConfiguration().orientation;
        if (paramString == null) {
          break label493;
        }
      }
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8))) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = ScreenShotImageUtil.a(this.jdField_a_of_type_AndroidAppActivity.getWindow(), paramString);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a(paramInt);
      }
      if (paramInt != 1) {
        break label498;
      }
      this.jdField_a_of_type_Boolean = true;
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.arg1 = i;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->send msg_show_pad time:" + System.currentTimeMillis());
      }
    }
    for (;;)
    {
      ThreadManager.executeOnFileThread(new SwiftBrowserScreenShotHandler.3(this, paramInt));
      paramString.recycle();
      label493:
      paramUri.destroyDrawingCache();
      return;
      label498:
      if (paramInt == 2) {
        QQToast.a(BaseApplicationImpl.getContext(), 0, 2131695245, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299166));
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a(paramString1, paramString2, paramInt);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "doMultiShare->imgUrl:" + paramString + ", isGif:" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject = CookieManager.getInstance();
    ((CookieManager)localObject).setAcceptCookie(true);
    localObject = ((CookieManager)localObject).getCookie(paramString);
    if (localObject != null) {
      localBundle.putString("Cookie", (String)localObject);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a().show();
    this.jdField_b_of_type_JavaLangString = paramString;
    ThreadManager.executeOnSubThread(new SwiftBrowserScreenShotHandler.6(this, paramString, localBundle, paramBoolean));
  }
  
  public void a(JSONArray paramJSONArray)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a(paramJSONArray);
    }
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin isShow:" + paramBoolean + ", orientation:" + paramInt);
    }
    if (paramBoolean) {
      if (!this.jdField_c_of_type_Boolean) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          Object localObject2;
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getTag() instanceof Integer)))
          {
            int i = ((Integer)this.jdField_a_of_type_AndroidWidgetLinearLayout.getTag()).intValue();
            if (i != paramInt)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->orientation change old:" + i + ", new:" + paramInt);
              }
              localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363879);
              localObject2 = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2);
              if ((localObject2 != null) && (((SwiftBrowserUIStyleHandler)localObject2).d != null)) {
                ((SwiftBrowserUIStyleHandler)localObject2).d.findViewById(2131363879);
              }
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              ((RelativeLayout)localObject1).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
              this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
            }
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad create time:" + System.currentTimeMillis());
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559748, null));
            localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363879);
            localObject2 = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2);
            if ((localObject2 != null) && (((SwiftBrowserUIStyleHandler)localObject2).d != null)) {
              ((SwiftBrowserUIStyleHandler)localObject2).d.findViewById(2131363879);
            }
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(11);
            ((RelativeLayout.LayoutParams)localObject2).addRule(12);
            ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, AIOUtils.a(10.0F, BaseApplicationImpl.getContext().getResources()), AIOUtils.a(65.0F, BaseApplicationImpl.getContext().getResources()));
            ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(Integer.valueOf(paramInt));
            if (paramInt == 2)
            {
              localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377542).getLayoutParams();
              ((LinearLayout.LayoutParams)localObject1).width = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297650);
              ((LinearLayout.LayoutParams)localObject1).height = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297651);
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377542).setOnClickListener(new SwiftBrowserScreenShotHandler.4(this));
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation() != null)
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation().cancel();
            this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
          }
          ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377542)).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        } while (!QLog.isDevelopLevel());
        QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad visible time:" + System.currentTimeMillis());
        return;
        if (QLog.isDevelopLevel())
        {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin hide mScreenshotContainer:" + this.jdField_a_of_type_AndroidWidgetLinearLayout);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin hide mScreenshotContainerVisibility:" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility());
          }
        }
      } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0));
      Object localObject1 = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject1).setDuration(300L);
      ((AlphaAnimation)localObject1).setAnimationListener(new SwiftBrowserScreenShotHandler.5(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
    } while (!QLog.isDevelopLevel());
    QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad gone time:" + System.currentTimeMillis());
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver != null;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    c();
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver == null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      Object localObject = new DisplayMetrics();
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.jdField_b_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
      this.jdField_c_of_type_Int = ((DisplayMetrics)localObject).heightPixels;
      this.jdField_a_of_type_Float = ((DisplayMetrics)localObject).density;
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = new ScreenshotContentObserver(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver.a(this);
      localObject = a();
      if (localObject != null)
      {
        ((View)localObject).setDrawingCacheEnabled(true);
        ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new SwiftBrowserScreenShotHandler.2(this, (View)localObject));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "registerScreenshotObserver->mScreenWidth:" + this.jdField_b_of_type_Int + ", mScreenHeight:" + this.jdField_c_of_type_Int + ", mScreenDensity:" + this.jdField_a_of_type_Float);
      }
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.c(paramString.replace("|", "｜"));
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper == null) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.b())) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.c(BaseApplicationImpl.getContext().getResources().getString(2131695243));
  }
  
  public void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.c(paramString.replace("|", "｜"));
    }
  }
  
  public void d(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.b(paramString);
    }
  }
  
  public void e(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.e(paramString);
    }
  }
  
  public void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QRUtils.a(1, 2131695248);
      return;
    }
    paramString = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramString, true, true, true, true, true, 4);
    paramString.putExtra("EditPicType", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.b());
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "handleMessage->recv msg_show_pad time:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      a(true, paramMessage.arg1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
    }
    for (;;)
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "handleMessage->recv msg_hide_pad time:" + System.currentTimeMillis());
      }
      a(false, 0);
      continue;
      f(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->begin!");
    }
    Object localObject1 = paramView.getTag();
    if (localObject1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->tag null!");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a.action;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebView().getUrl();
        localObject1 = "";
        localObject2 = Uri.parse(str);
      }
      try
      {
        localObject2 = ((Uri)localObject2).getQueryParameter("article_id");
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1001", localException, "", "");
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1001", localException, "", "");
          if (QLog.isColorLevel())
          {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action friend!");
            continue;
            ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1002", localException, "", "");
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1002", localException, "", "");
            if (QLog.isColorLevel())
            {
              QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action qzone!");
              continue;
              ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1003", localException, "", "");
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1003", localException, "", "");
              if (QLog.isColorLevel())
              {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action wechat!");
                continue;
                ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1004", localException, "", "");
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1004", localException, "", "");
                if (QLog.isColorLevel())
                {
                  QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action wechat circle!");
                  continue;
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800787A", "0X800787A", 0, 0, localException, str, "", "");
                  ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1005", localException, "", "");
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006A1F", "", "1005", localException, "", "");
                  if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action sina weibo!");
                  }
                }
              }
            }
          }
        }
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      switch (i)
      {
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 11: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->end!");
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler
 * JD-Core Version:    0.7.0.1
 */