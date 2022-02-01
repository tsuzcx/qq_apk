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
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  public Activity a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  ScreenshotContentObserver jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = null;
  ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private IScreenShotShareHelper jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper = ((IScreenShotShareHelperFactory)QRoute.api(IScreenShotShareHelperFactory.class)).createScreenShotShareHelper(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper.a(this);
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider;
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper.a((String)localObject1);
  }
  
  View a()
  {
    SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2);
    int i;
    if ((!localSwiftBrowserUIStyleHandler.a.jdField_a_of_type_Boolean) && (!localSwiftBrowserUIStyleHandler.a.jdField_b_of_type_Boolean)) {
      i = 2131378893;
    } else {
      i = 2131363807;
    }
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.findViewById(i);
    if (localSwiftBrowserUIStyleHandler.d != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getContentView();
    }
    return localObject;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper.a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    c();
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
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
        if (paramBundle != null) {
          paramBundle.h();
        }
        paramInt = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
        paramBundle = this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
        if (paramBundle != null)
        {
          if (paramInt < this.jdField_a_of_type_Int)
          {
            paramBundle.setMove(true);
            return;
          }
          paramBundle.setMove(false);
        }
      }
      else
      {
        b();
        paramBundle = this.jdField_a_of_type_AndroidOsHandler;
        if (paramBundle != null) {
          paramBundle.removeCallbacksAndMessages(null);
        }
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
        if (paramBundle != null) {
          paramBundle.a();
        }
      }
    }
    else if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "ScreenshotResume!");
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SwiftBrowserScreenShotHandler.1(this), 1000L);
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
    paramUri = this.jdField_a_of_type_AndroidAppActivity;
    if (((paramUri instanceof QBaseActivity)) && (((QBaseActivity)paramUri).isResume()))
    {
      if (QLog.isDevelopLevel())
      {
        paramUri = new StringBuilder();
        paramUri.append("onDetectScreenshot->begin time:");
        paramUri.append(System.currentTimeMillis());
        QLog.d("SwiftBrowserScreenShotHandler", 2, paramUri.toString());
      }
      paramUri = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
      if (paramUri != null) {
        paramUri = paramUri.c();
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
      paramUri = a();
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
      int i = BaseApplicationImpl.getContext().getResources().getConfiguration().orientation;
      if (paramString != null)
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if ((localObject == null) || (((LinearLayout)localObject).getVisibility() == 8)) {
            this.jdField_a_of_type_AndroidGraphicsBitmap = null;
          }
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((IScreenShotImageUtil)QRoute.api(IScreenShotImageUtil.class)).getScreenShotBitmap(this.jdField_a_of_type_AndroidAppActivity.getWindow(), paramString);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
          if (localObject != null) {
            ((IScreenShotShareHelper)localObject).a(paramInt);
          }
          if (paramInt == 1)
          {
            this.jdField_a_of_type_Boolean = true;
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).arg1 = i;
            this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
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
            QQToast.a(BaseApplicationImpl.getContext(), 0, 2131695241, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168));
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
    IScreenShotShareHelper localIScreenShotShareHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
    if (localIScreenShotShareHelper != null) {
      localIScreenShotShareHelper.a(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    IScreenShotShareHelper localIScreenShotShareHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper.a().show();
    this.jdField_b_of_type_JavaLangString = paramString;
    ThreadManager.executeOnSubThread(new SwiftBrowserScreenShotHandler.6(this, paramString, (Bundle)localObject1, paramBoolean));
  }
  
  public void a(JSONArray paramJSONArray)
  {
    IScreenShotShareHelper localIScreenShotShareHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
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
      if (this.jdField_c_of_type_Boolean) {
        return;
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      Object localObject2;
      if ((localObject1 != null) && ((((LinearLayout)localObject1).getTag() instanceof Integer)))
      {
        int i = ((Integer)this.jdField_a_of_type_AndroidWidgetLinearLayout.getTag()).intValue();
        if (i != paramInt)
        {
          if (QLog.isDevelopLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("showScreenshotPad->orientation change old:");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(", new:");
            ((StringBuilder)localObject1).append(paramInt);
            QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363807);
          localObject2 = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2);
          if ((localObject2 != null) && (((SwiftBrowserUIStyleHandler)localObject2).d != null)) {
            ((SwiftBrowserUIStyleHandler)localObject2).d.findViewById(2131363807);
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          ((RelativeLayout)localObject1).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("showScreenshotPad->pad create time:");
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559624, null));
        localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363807);
        localObject2 = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2);
        if ((localObject2 != null) && (((SwiftBrowserUIStyleHandler)localObject2).d != null)) {
          ((SwiftBrowserUIStyleHandler)localObject2).d.findViewById(2131363807);
        }
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, AIOUtils.b(10.0F, BaseApplicationImpl.getContext().getResources()), AIOUtils.b(65.0F, BaseApplicationImpl.getContext().getResources()));
        ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(Integer.valueOf(paramInt));
        if (paramInt == 2)
        {
          localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376984).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).width = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297641);
          ((LinearLayout.LayoutParams)localObject1).height = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297642);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376984).setOnClickListener(new SwiftBrowserScreenShotHandler.4(this));
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation() != null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation().cancel();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
      }
      ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376984)).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
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
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject1).toString());
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("showScreenshotPad->begin hide mScreenshotContainerVisibility:");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility());
          QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject1).toString());
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if ((localObject1 != null) && (((LinearLayout)localObject1).getVisibility() == 0))
      {
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setAnimationListener(new SwiftBrowserScreenShotHandler.5(this));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
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
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver != null;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver;
    if (localObject != null)
    {
      ((ScreenshotContentObserver)localObject).a();
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        localObject = a();
        if (localObject != null) {
          ((View)localObject).setDrawingCacheEnabled(false);
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = null;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "unregisterScreenshotObserver!");
      }
    }
  }
  
  public void b(String paramString)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver == null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      localObject = new DisplayMetrics();
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
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("registerScreenshotObserver->mScreenWidth:");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(", mScreenHeight:");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
        ((StringBuilder)localObject).append(", mScreenDensity:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Float);
        QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
      if (localObject != null)
      {
        ((IScreenShotShareHelper)localObject).c(paramString.replace("|", "｜"));
        return;
      }
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
    if ((paramString != null) && (TextUtils.isEmpty(paramString.b())) && (this.jdField_a_of_type_AndroidAppActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper.c(BaseApplicationImpl.getContext().getResources().getString(2131695239));
    }
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      IScreenShotShareHelper localIScreenShotShareHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
      if (localIScreenShotShareHelper != null) {
        localIScreenShotShareHelper.c(paramString.replace("|", "｜"));
      }
    }
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      IScreenShotShareHelper localIScreenShotShareHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
      if (localIScreenShotShareHelper != null) {
        localIScreenShotShareHelper.b(paramString);
      }
    }
  }
  
  public void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      IScreenShotShareHelper localIScreenShotShareHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper;
      if (localIScreenShotShareHelper != null) {
        localIScreenShotShareHelper.e(paramString);
      }
    }
  }
  
  public void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QRUtils.a(1, 2131695244);
      return;
    }
    paramString = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.jdField_a_of_type_AndroidAppActivity, paramString, true, true, true, true, true, 4);
    paramString.putExtra("EditPicType", this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIScreenShotShareHelper.b());
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return false;
        }
        f(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    a(true, paramMessage.arg1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
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
      int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).a.action;
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider;
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
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 9)
            {
              if (i != 10)
              {
                if (i == 12)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler
 * JD-Core Version:    0.7.0.1
 */