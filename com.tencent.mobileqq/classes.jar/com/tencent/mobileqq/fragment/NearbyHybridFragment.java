package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqstory.shareGroup.infocard.view.CircleImageView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.RefreshView.OnRefreshListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.nearby.NearPeopleFilters;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.EnterItem;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.OnItemClickListener;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.home.INearbyTabInfo;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.INearbyProcObserver;
import com.tencent.mobileqq.nearby.redtouch.INearbyOfficalReportHelper;
import com.tencent.mobileqq.nearby.redtouch.INearbyRecommendPeopleInfo;
import com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedNum;
import com.tencent.mobileqq.nearby.widget.NearbyActivityDialog;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu.OnItemClickListener;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout.OnActionListener;
import com.tencent.mobileqq.nearby.widget.OverlapLayout;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyPeople;

public class NearbyHybridFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  protected static long a = 0L;
  protected static SosoLbsInfo a;
  public static final Runnable a;
  public static boolean k = false;
  protected View.OnClickListener a;
  protected View a;
  protected FrameLayout a;
  protected LinearLayout a;
  protected TextView a;
  protected RefreshView.OnRefreshListener a;
  public RefreshView a;
  protected URLImageView a;
  public NearbyActivity a;
  protected NearbyObserver a;
  public NearbyHybridFragment.NearbyWebViewBuilder a;
  protected NearPeopleFilters a;
  protected NearbyFragmentEnterAdapter.OnItemClickListener a;
  protected NearbyFragmentEnterAdapter a;
  protected INearbyProcObserver a;
  NearbyPublishMenu.OnItemClickListener jdField_a_of_type_ComTencentMobileqqNearbyWidgetNearbyPublishMenu$OnItemClickListener = new NearbyHybridFragment.12(this);
  protected OverCoverFrameLayout.OnActionListener a;
  public OverCoverFrameLayout a;
  protected OverlapLayout a;
  protected RedTouch a;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  protected ActionSheet a;
  protected String a;
  protected boolean a;
  protected long b;
  protected View b;
  protected LinearLayout b;
  public String b;
  protected int c;
  protected long c;
  protected View c;
  protected String c;
  int d;
  protected long d;
  protected View d;
  protected String d;
  protected long e;
  protected View e;
  String e;
  protected boolean e;
  protected boolean f;
  protected boolean g = false;
  protected boolean h = false;
  protected boolean i = false;
  protected boolean j = false;
  protected boolean l = false;
  
  static
  {
    jdField_a_of_type_JavaLangRunnable = new NearbyHybridFragment.2();
  }
  
  public NearbyHybridFragment()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters = new NearPeopleFilters();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener = new NearbyHybridFragment.8(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout$OnActionListener = new NearbyHybridFragment.9(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new NearbyHybridFragment.11(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter$OnItemClickListener = new NearbyHybridFragment.13(this);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqNearbyIpcINearbyProcObserver = new NearbyHybridFragment.17(this);
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver = new NearbyHybridFragment.18(this);
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void a(Drawable paramDrawable)
  {
    URLImageView localURLImageView = new URLImageView(getBaseActivity());
    localURLImageView.setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.b(30.0F, getBaseActivity().getResources()), AIOUtils.b(30.0F, getBaseActivity().getResources())));
    localURLImageView.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.addView(localURLImageView);
  }
  
  private void a(INearbyRedDotCustomInfo paramINearbyRedDotCustomInfo)
  {
    NearbyHandler localNearbyHandler = (NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getBusinessHandler(NearbyConstants.jdField_a_of_type_JavaLangString);
    if (!((INearbyRecommendPeopleInfo)QRoute.api(INearbyRecommendPeopleInfo.class)).getLatestRecommendMsgid().equals(paramINearbyRedDotCustomInfo.getRecommendPeopleMsgId())) {
      localNearbyHandler.a(paramINearbyRedDotCustomInfo.getRecommendPeopleMsgId());
    }
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addAvatarImg,avatarUrl =  ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("NearbyRecommend", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (FrameLayout)getBaseActivity().getLayoutInflater().inflate(2131559489, null);
    CircleImageView localCircleImageView = (CircleImageView)((FrameLayout)localObject).findViewById(2131368502);
    localCircleImageView.setBorderColor(-11382188);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mFailedDrawable = paramDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(URLDrawableDecodeHandler.a(1000, 1000));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.n);
    localCircleImageView.setImageDrawable(paramString);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.addView((View)localObject);
  }
  
  private void u()
  {
    if ((((INearbyRecommendPeopleInfo)QRoute.api(INearbyRecommendPeopleInfo.class)).getLatestRecommendList() != null) && (this.m))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.removeAllViews();
      int m = 0;
      Iterator localIterator = ((INearbyRecommendPeopleInfo)QRoute.api(INearbyRecommendPeopleInfo.class)).getLatestRecommendList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (oidb_0x8dd.NearbyPeople)localIterator.next();
        if (m >= 3) {
          return;
        }
        localObject = ((oidb_0x8dd.NearbyPeople)localObject).bytes_picture_face.get().toStringUtf8();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          a((String)localObject, getResources().getDrawable(2130840321));
          m += 1;
        }
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout.c()) {
      return 0;
    }
    return 1;
  }
  
  public NearPeopleFilters a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters;
  }
  
  public AbsWebView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder;
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo.getTabUrl();
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (((String)localObject1).contains("?"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    Object localObject3 = a();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject3 = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getUrlJsonToStr(((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getNearbyTabUrlParams());
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append((String)localObject3);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    int m = b();
    localObject1 = localObject2;
    if (m != -1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("&initTab=");
      ((StringBuilder)localObject1).append(m);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (this.jdField_d_of_type_Long != 0L)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&_t=");
      ((StringBuilder)localObject2).append(this.jdField_d_of_type_Long);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getUrl, url=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  protected StringBuilder a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      a(localStringBuilder, "sex", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.a()));
      a(localStringBuilder, "time", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.b()));
      a(localStringBuilder, "age", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.c()));
      a(localStringBuilder, "interest", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.d()));
      a(localStringBuilder, "profession", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.f()));
      a(localStringBuilder, "country", this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.a()[0]);
      a(localStringBuilder, "province", this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.a()[1]);
      a(localStringBuilder, "city", this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.a()[2]);
      a(localStringBuilder, "contellation", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.e()));
      return localStringBuilder;
    }
    return null;
  }
  
  protected ArrayList<NearbyFragmentEnterAdapter.EnterItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getCurrentAccountUin(), "key_banner_enter_items", "");
    int m = 0;
    this.jdField_f_of_type_Boolean = false;
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        Object localObject2;
        NearbyFragmentEnterAdapter.EnterItem localEnterItem;
        if (m < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optJSONObject(m);
          localEnterItem = new NearbyFragmentEnterAdapter.EnterItem();
          localEnterItem.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("iconUrl");
          localEnterItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("jumpUrl");
          localEnterItem.jdField_d_of_type_JavaLangString = ((JSONObject)localObject2).optString("scheme");
          localEnterItem.jdField_e_of_type_JavaLangString = ((JSONObject)localObject2).optString("package");
          localEnterItem.jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).optString("name");
          localEnterItem.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("id");
          localEnterItem.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("openapp");
        }
        switch (localEnterItem.jdField_a_of_type_Int)
        {
        case 6: 
          localEnterItem.jdField_b_of_type_Int = 8;
          break;
        case 5: 
          localEnterItem.jdField_b_of_type_Int = 4;
          break;
        case 4: 
          localEnterItem.jdField_b_of_type_Int = 7;
          break;
        case 3: 
          localEnterItem.jdField_b_of_type_Int = 2;
          break;
        case 2: 
          localEnterItem.jdField_b_of_type_Int = 1;
          break;
        case 1: 
          this.jdField_f_of_type_Boolean = true;
          localEnterItem.jdField_b_of_type_Int = 6;
          NearbyUtils.b((AppInterface)this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface, "exp_op_button", localEnterItem.jdField_a_of_type_Int);
          localArrayList.add(localEnterItem);
          m += 1;
          continue;
          return localArrayList;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getBannerItems:");
          ((StringBuilder)localObject2).append(localException.toString());
          QLog.e("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext());
    Object localObject;
    if (bool) {
      localObject = "0";
    } else {
      localObject = "1";
    }
    String str2 = NetworkUtil.getApn(BaseApplicationImpl.getContext());
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "home", "loc_time_out", 0, 0, String.valueOf(paramInt), String.valueOf(5000), (String)localObject, str1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportTimeOut: isNetworkOk=");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", APN=");
      ((StringBuilder)localObject).append(str1);
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(NearbyFragmentEnterAdapter.EnterItem paramEnterItem)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void a(INearbyAppInterface paramINearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("nearby.NearbyHybridFragment", "createWebView", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, paramINearbyAppInterface });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (paramINearbyAppInterface != null))
      {
        Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getBaseContext();
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder = new NearbyHybridFragment.NearbyWebViewBuilder(this, localContext, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, (AppInterface)paramINearbyAppInterface);
        paramINearbyAppInterface = new TouchWebView(localContext);
        paramINearbyAppInterface.setBackgroundColor(-1);
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a(paramINearbyAppInterface);
        if (QSecFramework.a().a(1001).booleanValue()) {
          QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(83), paramINearbyAppInterface }, null);
        }
        paramINearbyAppInterface.setOnTouchListener(new NearbyHybridFragment.6(this));
        long l1 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitTime = (System.currentTimeMillis() - l1);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitTime) });
        }
        if (QLog.isColorLevel())
        {
          paramINearbyAppInterface = new StringBuilder();
          paramINearbyAppInterface.append("init webView time:");
          paramINearbyAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitTime);
          QLog.i("nearby.NearbyHybridFragment.webloading", 2, paramINearbyAppInterface.toString());
        }
        this.jdField_c_of_type_Boolean = true;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(SosoLbsInfo paramSosoLbsInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 380	com/tencent/mobileqq/fragment/NearbyHybridFragment:jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder	Lcom/tencent/mobileqq/fragment/NearbyHybridFragment$NearbyWebViewBuilder;
    //   4: ifnonnull +20 -> 24
    //   7: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +183 -> 193
    //   13: ldc_w 423
    //   16: iconst_2
    //   17: ldc_w 684
    //   20: invokestatic 687	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: aload_0
    //   25: getfield 380	com/tencent/mobileqq/fragment/NearbyHybridFragment:jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder	Lcom/tencent/mobileqq/fragment/NearbyHybridFragment$NearbyWebViewBuilder;
    //   28: invokevirtual 691	com/tencent/mobileqq/fragment/NearbyHybridFragment$NearbyWebViewBuilder:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +95 -> 128
    //   36: new 499	org/json/JSONObject
    //   39: dup
    //   40: invokespecial 692	org/json/JSONObject:<init>	()V
    //   43: astore_3
    //   44: aload_3
    //   45: ldc_w 694
    //   48: aload_1
    //   49: getfield 700	com/tencent/mobileqq/soso/location/data/SosoLbsInfo:mLocation	Lcom/tencent/mobileqq/soso/location/data/SosoLocation;
    //   52: getfield 706	com/tencent/mobileqq/soso/location/data/SosoLocation:mLat02	D
    //   55: invokevirtual 710	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   58: pop
    //   59: aload_3
    //   60: ldc_w 712
    //   63: aload_1
    //   64: getfield 700	com/tencent/mobileqq/soso/location/data/SosoLbsInfo:mLocation	Lcom/tencent/mobileqq/soso/location/data/SosoLocation;
    //   67: getfield 715	com/tencent/mobileqq/soso/location/data/SosoLocation:mLon02	D
    //   70: invokevirtual 710	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   73: pop
    //   74: ldc_w 717
    //   77: aload_3
    //   78: aconst_null
    //   79: invokestatic 723	com/tencent/mobileqq/webview/swift/WebViewPlugin:toJsScript	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)Ljava/lang/String;
    //   82: astore_1
    //   83: aload_2
    //   84: aload_1
    //   85: invokevirtual 728	com/tencent/biz/pubaccount/CustomWebView:callJs	(Ljava/lang/String;)V
    //   88: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +97 -> 188
    //   94: new 235	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   101: astore_2
    //   102: aload_2
    //   103: ldc_w 730
    //   106: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_2
    //   111: aload_1
    //   112: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: ldc_w 423
    //   119: iconst_2
    //   120: aload_2
    //   121: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: return
    //   128: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +57 -> 188
    //   134: ldc_w 423
    //   137: iconst_2
    //   138: ldc_w 732
    //   141: invokestatic 687	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: return
    //   145: astore_1
    //   146: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +39 -> 188
    //   152: new 235	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   159: astore_2
    //   160: aload_2
    //   161: ldc_w 734
    //   164: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_2
    //   169: aload_1
    //   170: invokevirtual 543	java/lang/Exception:toString	()Ljava/lang/String;
    //   173: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc_w 423
    //   180: iconst_2
    //   181: aload_2
    //   182: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: return
    //   189: astore_1
    //   190: goto -116 -> 74
    //   193: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	NearbyHybridFragment
    //   0	194	1	paramSosoLbsInfo	SosoLbsInfo
    //   31	151	2	localObject	Object
    //   43	35	3	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	23	145	java/lang/Exception
    //   24	32	145	java/lang/Exception
    //   36	44	145	java/lang/Exception
    //   74	127	145	java/lang/Exception
    //   128	144	145	java/lang/Exception
    //   44	74	189	java/lang/Exception
  }
  
  protected void a(ilive_feeds_near_anchor.NearAnchorInfo paramNearAnchorInfo)
  {
    Object localObject2;
    Object localObject1;
    if ((paramNearAnchorInfo != null) && (paramNearAnchorInfo.jump_type.get() != 1))
    {
      if (paramNearAnchorInfo.jump_type.get() == 2)
      {
        localObject2 = String.format("nowmqqapi://now/openroom?src_type=app&version=1&fromid=10006&roomid=%d&first=1&startsrc=fujin7", new Object[] { Integer.valueOf(paramNearAnchorInfo.root_roomid.get()) });
        localObject1 = localObject2;
        if (paramNearAnchorInfo.cover_url.has())
        {
          paramNearAnchorInfo = paramNearAnchorInfo.cover_url.get().toStringUtf8();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("&coverurl=");
          ((StringBuilder)localObject1).append(paramNearAnchorInfo);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        paramNearAnchorInfo = null;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
        if (localObject2 != null) {
          paramNearAnchorInfo = ((Intent)localObject2).getStringExtra("big_brother_source_key");
        }
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, JumpActivity.class);
        if (!TextUtils.isEmpty(paramNearAnchorInfo)) {
          ((Intent)localObject2).putExtra("big_brother_source_key", paramNearAnchorInfo);
        }
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity((Intent)localObject2);
        if (QLog.isColorLevel())
        {
          paramNearAnchorInfo = new StringBuilder();
          paramNearAnchorInfo.append("jump from nearby|uri:");
          paramNearAnchorInfo.append((String)localObject1);
          QLog.d("nearby.NearbyHybridFragmentQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, paramNearAnchorInfo.toString());
        }
      }
    }
    else
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getNearbyProcManager().a() + 1;
      this.jdField_a_of_type_JavaLangString = "";
      if (jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo != null)
      {
        paramNearAnchorInfo = new StringBuilder();
        paramNearAnchorInfo.append("&latitude=");
        paramNearAnchorInfo.append(jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat02);
        paramNearAnchorInfo.append("&longitude=");
        paramNearAnchorInfo.append(jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon02);
        this.jdField_a_of_type_JavaLangString = paramNearAnchorInfo.toString();
      }
      if (m != -1)
      {
        paramNearAnchorInfo = new StringBuilder();
        paramNearAnchorInfo.append(this.jdField_a_of_type_JavaLangString);
        paramNearAnchorInfo.append("&gender=");
        if (m == 2) {
          m = 2;
        } else {
          m = 1;
        }
        paramNearAnchorInfo.append(m);
        this.jdField_a_of_type_JavaLangString = paramNearAnchorInfo.toString();
      }
      if ((NowLiveFragment.jdField_b_of_type_JavaLangString != null) && (NowLiveFragment.jdField_b_of_type_JavaLangString.length() > 0))
      {
        paramNearAnchorInfo = this.jdField_a_of_type_ComTencentSmttSdkCookieManager;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("p_skey=");
        ((StringBuilder)localObject1).append(NowLiveFragment.jdField_b_of_type_JavaLangString);
        paramNearAnchorInfo.setCookie("now.qq.com", ((StringBuilder)localObject1).toString());
        if (QLog.isColorLevel())
        {
          paramNearAnchorInfo = new StringBuilder();
          paramNearAnchorInfo.append("now.qq.com pskey : ");
          paramNearAnchorInfo.append(NowLiveFragment.jdField_b_of_type_JavaLangString);
          QLog.i("nearby.NearbyHybridFragment", 2, paramNearAnchorInfo.toString());
        }
        CookieSyncManager.getInstance().sync();
        i();
        return;
      }
      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com") != null)
      {
        paramNearAnchorInfo = this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com");
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("now.qq.com cookie : ");
          ((StringBuilder)localObject1).append(paramNearAnchorInfo);
          QLog.i("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject1).toString());
        }
        if (paramNearAnchorInfo.contains("p_skey"))
        {
          i();
          return;
        }
      }
      NowLiveFragment.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("pskey", "");
      long l1 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getLong("pskey_t", 0L);
      if ((NowLiveFragment.jdField_b_of_type_JavaLangString != null) && (NowLiveFragment.jdField_b_of_type_JavaLangString.length() > 0) && (System.currentTimeMillis() - l1 < 21600000L))
      {
        paramNearAnchorInfo = this.jdField_a_of_type_ComTencentSmttSdkCookieManager;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("p_skey=");
        ((StringBuilder)localObject1).append(NowLiveFragment.jdField_b_of_type_JavaLangString);
        paramNearAnchorInfo.setCookie("now.qq.com", ((StringBuilder)localObject1).toString());
        CookieSyncManager.getInstance().sync();
        i();
        return;
      }
      paramNearAnchorInfo = new NearbyHybridFragment.14(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramNearAnchorInfo, 1000L);
      paramNearAnchorInfo = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getManager(2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getCurrentAccountUin();
      localObject2 = new NearbyHybridFragment.15(this);
      paramNearAnchorInfo.getPskey((String)localObject1, 16L, new String[] { "now.qq.com" }, (WtTicketPromise)localObject2);
    }
  }
  
  protected void a(StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    paramStringBuilder.append("&");
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("=");
    paramStringBuilder.append(paramObject);
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_Int = paramInt;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      NearbyUtils.b((AppInterface)this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface, "exp_pub", 1);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void aR_()
  {
    super.aR_();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  protected int b()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
    if (localIntent != null) {
      return localIntent.getIntExtra("nearby_main_init_tab", -1);
    }
    return -1;
  }
  
  protected NearPeopleFilters b()
  {
    Object localObject2 = (NearbyDataManager)this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getManager(NearbyConstants.jdField_b_of_type_Int);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
    if (localObject1 != null) {
      ((NearbyDataManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("filter"));
    } else {
      localObject1 = new Intent();
    }
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("initNearbyFilter, filterMode=");
      ((StringBuilder)localObject3).append(((NearbyDataManager)localObject2).a());
      QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject3).toString());
    }
    int m = ((NearbyDataManager)localObject2).a();
    int n = 0;
    String str2;
    String str1;
    if (m != 0)
    {
      m = ((Intent)localObject1).getIntExtra("filterGender", 0);
      int i2 = ((Intent)localObject1).getIntExtra("filter_time", 0);
      int i3 = ((Intent)localObject1).getIntExtra("filter_age", 0);
      int i4 = ((Intent)localObject1).getIntExtra("filter_xingzuo", 0);
      int i1 = ((Intent)localObject1).getIntExtra("filter_interest", 0);
      int i5 = ((Intent)localObject1).getIntExtra("filter_career", 0);
      str2 = ((Intent)localObject1).getStringExtra("filter_location");
      localObject3 = new NearPeopleFilters();
      ((NearPeopleFilters)localObject3).a(m);
      ((NearPeopleFilters)localObject3).b(i2);
      ((NearPeopleFilters)localObject3).c(i3);
      ((NearPeopleFilters)localObject3).e(i4);
      ((NearPeopleFilters)localObject3).f(i5);
      if (i1 >= 0)
      {
        m = i1;
        if (i1 <= NearPeopleFilters.jdField_b_of_type_ArrayOfJavaLangString.length - 1) {}
      }
      else
      {
        m = 0;
      }
      ((NearPeopleFilters)localObject3).d(m);
      localObject2 = new String[5];
      localObject2[0] = "0";
      localObject2[1] = "0";
      localObject2[2] = "0";
      localObject2[3] = "0";
      str1 = "不限";
      localObject2[4] = "不限";
      localObject1 = localObject3;
      if (TextUtils.isEmpty(str2)) {
        break label489;
      }
    }
    try
    {
      localObject1 = str2.split("\\|");
      localObject2 = localObject1;
    }
    catch (Exception localException)
    {
      label333:
      label489:
      break label333;
    }
    localObject1 = localObject3;
    if (localObject2.length >= 4)
    {
      m = n;
      while (m < 4)
      {
        ((NearPeopleFilters)localObject3).a()[m] = localObject2[m];
        m += 1;
      }
      localObject1 = str1;
      if (localObject2.length >= 5) {
        localObject1 = localObject2[4];
      }
      ((NearPeopleFilters)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
      return localObject3;
      localObject2 = NearPeopleFilters.a(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getCurrentAccountUin());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new NearPeopleFilters();
        ((NearPeopleFilters)localObject2).a(0);
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("defFilter: filters.gender=");
          ((StringBuilder)localObject1).append(((NearPeopleFilters)localObject2).a());
          QLog.d("nearby.heart_beat", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
    }
    return localObject1;
  }
  
  public void b()
  {
    QLog.d("nearby.NearbyHybridFragment.webloading", 1, "checkLocation");
    if ((Build.VERSION.SDK_INT >= 23) && (getBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      QLog.e("nearby.NearbyHybridFragment.webloading", 1, "ACCESS_FINE_LOCATION permission not granted!");
      this.jdField_c_of_type_Int = 1;
      return;
    }
    long l1 = System.currentTimeMillis() - jdField_a_of_type_Long;
    if ((jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo != null) && (l1 <= 300000L))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startLocation useCache timeDiff=");
        localStringBuilder.append(l1);
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, localStringBuilder.toString());
      }
      c();
      ReportController.b(null, "dc00899", "grp_lbs", "", "home", "loc_use_cache", 0, 0, "", "", "", "");
      return;
    }
    l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, "send [MSG_SHOW_LOADING | MSG_LOCATION_TIME_OUT] before startLocation");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    this.l = false;
    this.j = false;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 500L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 5000L);
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new NearbyHybridFragment.3(this, 3, true, false, 300000L, true, false, "NearbyNowliveTab", l1));
  }
  
  public void c()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void e()
  {
    ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplicationImpl.getContext(), "nearby_shouye_preload");
  }
  
  public void f()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewRefresh: mAbsWebView == null");
      }
      return;
    }
    Object localObject2 = ((NearbyHybridFragment.NearbyWebViewBuilder)localObject1).getWebView();
    if (localObject2 != null)
    {
      localObject1 = WebViewPlugin.toJsScript("qbrowserPullDown", null, null);
      ((CustomWebView)localObject2).callJs((String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("notifyWebViewRefresh:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject2).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewRefresh, webView==null");
    }
  }
  
  public void g()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewShow: mAbsWebView == null");
      }
      return;
    }
    localObject1 = ((NearbyHybridFragment.NearbyWebViewBuilder)localObject1).getWebView();
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject2).put("hidden", false);
      label52:
      localObject2 = WebViewPlugin.toJsScript("qbrowserVisibilityChangeV2", (JSONObject)localObject2, null);
      ((CustomWebView)localObject1).callJs((String)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyWebViewShow:");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject1).toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.w("nearby.NearbyHybridFragment", 2, "notifyWebViewShow, webView==null");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public void h()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewHide: mAbsWebView == null");
      }
      return;
    }
    localObject1 = ((NearbyHybridFragment.NearbyWebViewBuilder)localObject1).getWebView();
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject2).put("hidden", true);
      label52:
      localObject2 = WebViewPlugin.toJsScript("qbrowserVisibilityChangeV2", (JSONObject)localObject2, null);
      ((CustomWebView)localObject1).callJs((String)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyWebViewHide:");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject1).toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.w("nearby.NearbyHybridFragment", 2, "notifyWebViewHide, webView==null");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int n = paramMessage.what;
    int m = 2;
    if (n != 1) {
      if (n != 3)
      {
        if ((n != 5) && (n != 6))
        {
          if (n != 7) {
            return false;
          }
          this.j = true;
          if (jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo == null)
          {
            jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getNearbyLastLocation(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getCurrentAccountUin());
            m = 1;
          }
          if (jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo == null)
          {
            jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo = new SosoLbsInfo();
            jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation = new SosoLocation();
            jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat02 = 0.0D;
            jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon02 = 0.0D;
            m = 3;
          }
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage MSG_LOCATION_TIME_OUT， locType=");
          paramMessage.append(m);
          QLog.d("nearby.NearbyHybridFragment.webloading", 1, paramMessage.toString());
          c();
          a(m);
          return false;
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage MSG_SHOW_LOADING: isLoadingFinished=");
          paramMessage.append(this.l);
          QLog.w("nearby.NearbyHybridFragment.webloading", 2, paramMessage.toString());
        }
        if (this.l) {
          break label604;
        }
        paramMessage = this.jdField_c_of_type_AndroidViewView;
        if (paramMessage == null) {
          break label604;
        }
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
        paramMessage = this.jdField_d_of_type_AndroidViewView;
        if (paramMessage != null) {
          paramMessage.setVisibility(8);
        }
        paramMessage = this.jdField_e_of_type_AndroidViewView;
        if (paramMessage == null) {
          break label604;
        }
        paramMessage.setVisibility(8);
        return false;
      }
    }
    if (paramMessage.what == 5)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage attach-locationEnd cost=");
        paramMessage.append(System.currentTimeMillis() - this.jdField_c_of_type_Long);
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, paramMessage.toString());
      }
    }
    else if (paramMessage.what == 6)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage attach-viewInitEnd cost=");
        paramMessage.append(System.currentTimeMillis() - this.jdField_c_of_type_Long);
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, paramMessage.toString());
      }
    }
    else if ((paramMessage.what == 1) && (QLog.isColorLevel())) {
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, "handleMessage MSG_INIT");
    }
    if (this.h)
    {
      m = this.jdField_c_of_type_Int;
      if (m == 0)
      {
        if ((this.jdField_f_of_type_Boolean) && (!this.g) && (jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo != null))
        {
          this.g = true;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyHybridFragment.7(this), 2000L);
        }
        if ((this.jdField_b_of_type_Boolean) && (!this.i))
        {
          this.i = true;
          this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a(this.jdField_c_of_type_JavaLangString);
          return false;
        }
      }
      else if (m == 1)
      {
        if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
        {
          paramMessage = this.jdField_e_of_type_AndroidViewView;
          if (paramMessage != null) {
            paramMessage.setVisibility(0);
          }
          paramMessage = this.jdField_c_of_type_AndroidViewView;
          if (paramMessage != null) {
            paramMessage.setVisibility(8);
          }
          paramMessage = this.jdField_d_of_type_AndroidViewView;
          if (paramMessage != null)
          {
            paramMessage.setVisibility(8);
            return false;
          }
        }
        else
        {
          paramMessage = this.jdField_e_of_type_AndroidViewView;
          if (paramMessage != null) {
            paramMessage.setVisibility(8);
          }
          paramMessage = this.jdField_c_of_type_AndroidViewView;
          if (paramMessage != null) {
            paramMessage.setVisibility(8);
          }
          paramMessage = this.jdField_d_of_type_AndroidViewView;
          if (paramMessage != null) {
            paramMessage.setVisibility(0);
          }
        }
      }
    }
    label604:
    return false;
  }
  
  protected void i()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(NearbyActivity.nearByTabUrl);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("&_t=");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
  }
  
  protected void j()
  {
    k();
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a(HardCodeUtil.a(2131707229)).a(new NearbyHybridFragment.16(this));
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
  }
  
  public void k()
  {
    Object localObject = (NearbyActivity)getBaseActivity();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateRightBtnRedTouch, selectIdx=");
      int n = -1;
      int m;
      if (localObject == null) {
        m = -1;
      } else {
        m = ((NearbyActivity)localObject).getCurrentIndex();
      }
      localStringBuilder.append(m);
      localStringBuilder.append(", selfIdx=");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo == null) {
        m = n;
      } else {
        m = this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo.getTabIndex();
      }
      localStringBuilder.append(m);
      QLog.d("nearby.NearbyHybridFragment", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo != null) && (((NearbyActivity)localObject).getCurrentIndex() == this.jdField_a_of_type_ComTencentMobileqqNearbyHomeINearbyTabInfo.getTabIndex()))
    {
      localObject = (NearbyActivity)getActivity();
      if (localObject != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch((Context)localObject, ((NearbyActivity)localObject).rightViewText);
          this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.b(53).a();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getNearbyProcManager().a(9);
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
      if (localObject != null) {
        ((RedTouch)localObject).a(null);
      }
    }
  }
  
  public void l()
  {
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (getBaseActivity() != null))
    {
      if (getBaseActivity().isFinishing()) {
        return;
      }
      INearbyProcManager localINearbyProcManager = this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getNearbyProcManager();
      Object localObject2 = localINearbyProcManager.a(10);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch: redTypeInfo==null");
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      int m;
      try
      {
        m = Integer.valueOf(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.get()).intValue();
        String str;
        if (m > 99)
        {
          str = "99+";
          break label141;
        }
        try
        {
          str = String.valueOf(m);
        }
        catch (Exception localException1) {}
        if (!QLog.isColorLevel()) {
          break label138;
        }
      }
      catch (Exception localException2)
      {
        m = 0;
      }
      QLog.e("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch exp=", localException2);
      label138:
      Object localObject1 = "";
      label141:
      int n = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get();
      INearbyRedDotCustomInfo localINearbyRedDotCustomInfo = (INearbyRedDotCustomInfo)QRoute.api(INearbyRedDotCustomInfo.class);
      localINearbyRedDotCustomInfo.parse((BusinessInfoCheckUpdate.RedTypeInfo)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateUnReadMsgRedTouch: redType=");
        ((StringBuilder)localObject2).append(n);
        ((StringBuilder)localObject2).append(", numStr=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject2).toString());
      }
      if (((localINearbyRedDotCustomInfo.getIsOfficialNotify()) || (n == 5)) && (m > 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if ((m == 1) && (localINearbyRedDotCustomInfo.getIsOfficialNotify()) && (!TextUtils.isEmpty(localINearbyRedDotCustomInfo.getContentMsg())))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localINearbyRedDotCustomInfo.getContentMsg());
          if (localINearbyRedDotCustomInfo.getContentType() == 2) {
            a(localINearbyRedDotCustomInfo);
          }
        }
        else
        {
          localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(HardCodeUtil.a(2131707227));
          ((TextView)localObject2).setText(localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.removeAllViews();
        if ((!TextUtils.isEmpty(localINearbyRedDotCustomInfo.getFaceUrl())) && (HttpUtil.isValidUrl(localINearbyRedDotCustomInfo.getFaceUrl())))
        {
          localObject1 = getResources().getDrawable(2130840321);
          a(localINearbyRedDotCustomInfo.getFaceUrl(), (Drawable)localObject1);
        }
        else if (localINearbyRedDotCustomInfo.getUin() > 0L)
        {
          localObject1 = String.valueOf(localINearbyRedDotCustomInfo.getUin());
          this.jdField_d_of_type_JavaLangString = ((String)localObject1);
          localObject1 = localINearbyProcManager.a((String)localObject1, 1, true);
          localObject2 = new URLImageView(getBaseActivity());
          ((URLImageView)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.b(30.0F, getBaseActivity().getResources()), AIOUtils.b(30.0F, getBaseActivity().getResources())));
          if ((localObject1 != null) && (((Bitmap)localObject1).getByteCount() > 0)) {
            ((URLImageView)localObject2).setImageBitmap((Bitmap)localObject1);
          } else {
            ((URLImageView)localObject2).setImageDrawable(getResources().getDrawable(2130840321));
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.addView((View)localObject2);
        }
        else
        {
          a(getResources().getDrawable(2130840321));
        }
        localObject1 = localINearbyProcManager.a();
        if ((m == 1) && (((NearbyRedNum)localObject1).jdField_d_of_type_Int == 1)) {
          u();
        }
        ((INearbyOfficalReportHelper)QRoute.api(INearbyOfficalReportHelper.class)).reportNearByRedDotEvent(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface, "home", "news_slip_exp");
        NearbyUtils.b((AppInterface)this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface, "exp_msg", 0);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "!isOfficialNotify && redType != RedTouch.RED_TOUCH_NUM) || TextUtils.isEmpty(numStr)");
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void m()
  {
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(getBaseActivity());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131698740);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131698738);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new NearbyHybridFragment.19(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new NearbyHybridFragment.20(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  protected void n()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewSheetDismiss: mAbsWebView == null");
      }
      return;
    }
    Object localObject2 = ((NearbyHybridFragment.NearbyWebViewBuilder)localObject1).getWebView();
    if (localObject2 != null)
    {
      localObject1 = WebViewPlugin.toJsScript("closeFilterAndExitSheet", null, null);
      ((CustomWebView)localObject2).callJs((String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ActionSheet onDissmiss:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject2).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("nearby.NearbyHybridFragment", 2, "ActionSheet onDissmiss, webView==null");
    }
  }
  
  protected void o()
  {
    String str = URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://nearby.qq.com/people_filter/index.html", "_wwv", "4"), "sex", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.a())), "time", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.b())), "age", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.c())), "interest", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.d())), "profession", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.f())), "country", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.a()[0])), "strCountry", this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_b_of_type_JavaLangString), "province", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.a()[1])), "strProvince", this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_c_of_type_JavaLangString), "city", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.a()[2])), "strCity", this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_d_of_type_JavaLangString), "contellation", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.e()));
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", str);
    getBaseActivity().startActivity((Intent)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jump2FilterSettingPage:");
      ((StringBuilder)localObject).append(str);
      QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters = b();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getmLastTabIndex() == 0) {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("onAttach, mLastTabIndex=");
      paramActivity.append(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getmLastTabIndex());
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, paramActivity.toString());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    NearbyActivity localNearbyActivity = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity;
    if ((localNearbyActivity != null) && (localNearbyActivity.mOnCreateMilliTimeStamp == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp) });
      }
    }
    super.onCreate(paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity;
    if ((paramBundle != null) && (paramBundle.onCreateTime == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.onCreateTime = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.onCreateTime) });
      }
    }
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setObtainLocAllowed(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getAccount(), true);
    long l1 = System.currentTimeMillis();
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getAccount(), "nearby_enter_time", Long.valueOf(l1));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, "onCreateView");
    }
    q();
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {
      l1 = System.currentTimeMillis();
    } else {
      l1 = 0L;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("nearby.NearbyHybridFragment", new Object[] { "onCreateView", Long.valueOf(l1) });
    }
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_e_of_type_Boolean) {
      b();
    }
    if (this.jdField_f_of_type_AndroidViewView == null)
    {
      long l2 = System.currentTimeMillis();
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface);
      CookieSyncManager.createInstance(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
      if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("total createWebView time:");
        paramViewGroup.append(System.currentTimeMillis() - l2);
        QLog.i("nearby.NearbyHybridFragment.webloading", 2, paramViewGroup.toString());
      }
      this.jdField_f_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559482, null);
      this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.jdField_f_of_type_AndroidViewView.findViewById(2131381056));
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout = ((OverCoverFrameLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131372234));
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout.setOnActionListener(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout$OnActionListener);
      this.jdField_a_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131366275);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131366264));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131381062));
      this.jdField_b_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131362835);
      paramLayoutInflater = this.jdField_f_of_type_AndroidViewView.findViewById(2131363396);
      if (("Meizu".equalsIgnoreCase(Build.BRAND)) && ("M040".equalsIgnoreCase(Build.MODEL)) && (paramLayoutInflater != null)) {
        paramLayoutInflater.setVisibility(8);
      }
      paramLayoutInflater = a();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter = new NearbyFragmentEnterAdapter(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a(paramLayoutInflater);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter$OnItemClickListener);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131374285));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout = ((OverlapLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131374284));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131374286));
      this.jdField_a_of_type_ComTencentBizUiRefreshView.setDelayBeforeScrollBack(800L);
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.mWebview.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.mWebview.setOnScrollChangedListener(new NearbyHybridFragment.1(this));
      paramLayoutInflater = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.mWebview, 0, paramLayoutInflater);
      if (QLog.isColorLevel())
      {
        paramLayoutInflater = new StringBuilder();
        paramLayoutInflater.append("webView add to container:");
        paramLayoutInflater.append(System.currentTimeMillis() - l2);
        QLog.i("nearby.NearbyHybridFragment.webloading", 2, paramLayoutInflater.toString());
      }
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381067);
      paramLayoutInflater = (URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131373727);
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup.mLoadingDrawable = URLDrawableHelperConstants.a;
      paramViewGroup.mPlayGifImage = true;
      paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLAyBjp36ialuzyODWtr9VCdVQJo0JTrkib9eDlHdRtvS90g/", paramViewGroup));
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381064);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370421);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(getString(2131694387)).a(false);
    j();
    this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(this.jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.mViewInflateTime == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mViewInflateTime = (System.currentTimeMillis() - l1);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mViewInflateTime) });
      }
    }
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
      this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.addNearbyProcObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcINearbyProcObserver);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface);
      l();
      this.h = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
    return this.jdField_f_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
    this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.removeNearbyProcObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcINearbyProcObserver);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.b(null);
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.d();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyHybridFragment", 2, "onDestroyView");
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHiddenChanged: hidden=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      h();
      r();
      localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
      if (localObject != null) {
        ((RedTouch)localObject).a((BusinessInfoCheckUpdate.RedTypeInfo)null);
      }
    }
    else
    {
      g();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.i("nearby.NearbyHybridFragment", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.i("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject).toString());
    }
    q();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.b();
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
      QQToast.a(getBaseActivity(), 1, HardCodeUtil.a(2131707228), 0).b(getBaseActivity().getTitleBarHeight());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter;
    if (localObject != null) {
      ((NearbyFragmentEnterAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface);
    }
    k();
    l();
    if (this.jdField_c_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("nearby.NearbyHybridFragment", 2, "onResume, re checkLocation");
      }
      b();
    }
    localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
    String str1 = ((SharedPreferences)localObject).getString("nearby_now_delete_success_js_param", "");
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = ((SharedPreferences)localObject).getString("nearby_now_delete_success_js_callback", "");
      if (!TextUtils.isEmpty(str2))
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.mWebview.callJs(str2, new String[] { str1 });
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("nearby_now_delete_success_js_param", "");
        ((SharedPreferences.Editor)localObject).remove("nearby_now_delete_success_js_param").commit();
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    e();
  }
  
  public void p()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_e_of_type_Long;
    long l3 = System.currentTimeMillis();
    long l4 = this.jdField_c_of_type_Long;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideWebLoadingView:");
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append(", timeCostFromLoad=");
      ((StringBuilder)localObject).append(l1 - l2);
      ((StringBuilder)localObject).append(", timeCostFromAttach=");
      ((StringBuilder)localObject).append(l3 - l4);
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.l = true;
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.jdField_d_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.jdField_e_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  public void q()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment.duration", 2, "resetUserBrowseTime");
    }
  }
  
  public void r()
  {
    int m = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    long l2 = (System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 1L;
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "home", "home_exp", 0, 0, "", String.valueOf(m), "", String.valueOf(l1));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportUserBroseTime: d2[gender]=");
      localStringBuilder.append(m);
      localStringBuilder.append(", d4[duration]=");
      localStringBuilder.append(l1);
      QLog.d("nearby.NearbyHybridFragment.duration", 2, localStringBuilder.toString());
    }
  }
  
  public void s()
  {
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getNearbyProcManager();
      Object localObject2 = ((INearbyProcManager)localObject1).a(11);
      String str;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleNearbyActivityTip, dotInfo=");
        if (localObject2 == null) {
          str = "";
        } else {
          str = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get();
        }
        localStringBuilder.append(str);
        localStringBuilder.append(", isFinish=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing());
        QLog.d("nearby.redpoint", 2, localStringBuilder.toString());
      }
      if ((localObject2 != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()))
      {
        str = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get();
        localObject2 = new NearbyActivityDialog((AppInterface)this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
        if (((NearbyActivityDialog)localObject2).a(str)) {
          ((NearbyActivityDialog)localObject2).show();
        }
        ((INearbyProcManager)localObject1).a(58);
        ReportController.b(null, "dc00899", "grp_lbs", "", "entry", "pop_clk_red", 0, 0, String.valueOf(((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue()), "", "", "");
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleNearbyActivityTip, exp=");
      ((StringBuilder)localObject1).append(localException.toString());
      QLog.d("nearby.redpoint", 1, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment
 * JD-Core Version:    0.7.0.1
 */