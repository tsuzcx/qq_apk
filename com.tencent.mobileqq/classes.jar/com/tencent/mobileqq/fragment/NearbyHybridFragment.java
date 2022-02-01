package com.tencent.mobileqq.fragment;

import aakw;
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
import android.support.v4.app.FragmentActivity;
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
import anvx;
import anzr;
import anzs;
import aqww;
import auwo;
import auwp;
import auwq;
import auwr;
import auws;
import auwt;
import auwu;
import auwv;
import auww;
import auwx;
import auwy;
import auwz;
import auxa;
import auxb;
import auxc;
import auyp;
import axnu;
import axoc;
import axoj;
import axom;
import axon;
import axqc;
import axql;
import axut;
import axuu;
import ayme;
import aymf;
import aymg;
import aymi;
import aynk;
import aynu;
import ayny;
import bdla;
import bgxc;
import bidf;
import bijv;
import bkyp;
import bkzi;
import bmux;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqstory.shareGroup.infocard.view.CircleImageView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout;
import com.tencent.mobileqq.nearby.widget.OverlapLayout;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyPeople;
import uuc;

public class NearbyHybridFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  public static long a;
  public static SosoInterface.SosoLbsInfo a;
  public static final Runnable a;
  public static boolean n;
  protected aakw a;
  protected View.OnClickListener a;
  protected FrameLayout a;
  protected LinearLayout a;
  protected TextView a;
  protected anzs a;
  public auxc a;
  public axnu a;
  public axoj a;
  protected axon a;
  protected axuu a;
  public aynu a;
  protected ayny a;
  public bkzi a;
  public RefreshView a;
  public URLImageView a;
  public NearbyActivity a;
  public OverCoverFrameLayout a;
  protected OverlapLayout a;
  public RedTouch a;
  public CookieManager a;
  protected String a;
  protected long b;
  public View b;
  public LinearLayout b;
  public String b;
  public long c;
  public View c;
  protected String c;
  public int d;
  protected long d;
  public View d;
  public String d;
  protected boolean d;
  int jdField_e_of_type_Int = 0;
  public long e;
  public View e;
  String jdField_e_of_type_JavaLangString = "";
  public View f;
  protected boolean h = true;
  protected boolean i;
  protected boolean j;
  protected boolean k;
  protected boolean l;
  public boolean m;
  public boolean o;
  
  static
  {
    jdField_a_of_type_JavaLangRunnable = new NearbyHybridFragment.2();
  }
  
  public NearbyHybridFragment()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Axnu = new axnu();
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Aakw = new auxa(this);
    this.jdField_a_of_type_Ayny = new auxb(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new auwp(this);
    this.jdField_a_of_type_Aynu = new auwq(this);
    this.jdField_a_of_type_Axon = new auwr(this);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Axuu = new auwu(this);
    this.jdField_a_of_type_Anzs = new auwv(this);
  }
  
  private void a(Drawable paramDrawable)
  {
    URLImageView localURLImageView = new URLImageView(getActivity());
    localURLImageView.setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.dp2px(30.0F, getActivity().getResources()), AIOUtils.dp2px(30.0F, getActivity().getResources())));
    localURLImageView.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.addView(localURLImageView);
  }
  
  private void a(aymg paramaymg)
  {
    anzr localanzr = (anzr)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(axoc.jdField_c_of_type_Int);
    if (!aymf.a().equals(paramaymg.jdField_c_of_type_JavaLangString)) {
      localanzr.a(paramaymg.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommend", 2, "addAvatarImg,avatarUrl =  " + paramString);
    }
    FrameLayout localFrameLayout = (FrameLayout)getActivity().getLayoutInflater().inflate(2131559540, null);
    CircleImageView localCircleImageView = (CircleImageView)localFrameLayout.findViewById(2131368542);
    localCircleImageView.setBorderColor(-11382188);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mFailedDrawable = paramDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(bgxc.a(1000, 1000));
    paramString.setDecodeHandler(bgxc.p);
    localCircleImageView.setImageDrawable(paramString);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.addView(localFrameLayout);
  }
  
  private void u()
  {
    int i1;
    if ((aymf.a() != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.removeAllViews();
      Iterator localIterator = aymf.a().iterator();
      i1 = 0;
      if (localIterator.hasNext())
      {
        localObject = (oidb_0x8dd.NearbyPeople)localIterator.next();
        if (i1 < 3) {
          break label56;
        }
      }
    }
    return;
    label56:
    Object localObject = ((oidb_0x8dd.NearbyPeople)localObject).bytes_picture_face.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      a((String)localObject, getResources().getDrawable(2130840348));
      i1 += 1;
    }
    for (;;)
    {
      break;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout.c()) {
      return 0;
    }
    return 1;
  }
  
  public axnu a()
  {
    return this.jdField_a_of_type_Axnu;
  }
  
  public bidf a()
  {
    return this.jdField_a_of_type_Auxc;
  }
  
  protected String a()
  {
    Object localObject1 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo.tabUrl;
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      if (!((String)localObject1).contains("?")) {
        break label265;
      }
    }
    label265:
    for (localObject1 = (String)localObject1 + "&";; localObject1 = (String)localObject1 + "?")
    {
      localObject2 = (String)localObject1 + this.jdField_b_of_type_JavaLangString;
      Object localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = (String)localObject2 + ((StringBuilder)localObject3).toString();
      }
      localObject3 = axqc.a(axqc.a());
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = (String)localObject1 + (String)localObject3;
      }
      int i1 = b();
      localObject1 = localObject2;
      if (i1 != -1) {
        localObject1 = (String)localObject2 + "&initTab=" + i1;
      }
      localObject2 = localObject1;
      if (this.jdField_d_of_type_Long != 0L) {
        localObject2 = (String)localObject1 + "&_t=" + this.jdField_d_of_type_Long;
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "getUrl, url=" + (String)localObject2);
      }
      return localObject2;
    }
  }
  
  protected StringBuilder a()
  {
    if (this.jdField_a_of_type_Axnu != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      a(localStringBuilder, "sex", Integer.valueOf(this.jdField_a_of_type_Axnu.jdField_a_of_type_Int));
      a(localStringBuilder, "time", Integer.valueOf(this.jdField_a_of_type_Axnu.jdField_b_of_type_Int));
      a(localStringBuilder, "age", Integer.valueOf(this.jdField_a_of_type_Axnu.jdField_c_of_type_Int));
      a(localStringBuilder, "interest", Integer.valueOf(this.jdField_a_of_type_Axnu.jdField_d_of_type_Int));
      a(localStringBuilder, "profession", Integer.valueOf(this.jdField_a_of_type_Axnu.f));
      a(localStringBuilder, "country", this.jdField_a_of_type_Axnu.jdField_d_of_type_ArrayOfJavaLangString[0]);
      a(localStringBuilder, "province", this.jdField_a_of_type_Axnu.jdField_d_of_type_ArrayOfJavaLangString[1]);
      a(localStringBuilder, "city", this.jdField_a_of_type_Axnu.jdField_d_of_type_ArrayOfJavaLangString[2]);
      a(localStringBuilder, "contellation", Integer.valueOf(this.jdField_a_of_type_Axnu.jdField_e_of_type_Int));
      return localStringBuilder;
    }
    return null;
  }
  
  protected ArrayList<axom> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (String)axqc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "key_banner_enter_items", "");
    this.i = false;
    for (;;)
    {
      axom localaxom;
      try
      {
        localObject = new JSONArray((String)localObject);
        int i1 = 0;
        if (i1 < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i1);
          localaxom = new axom();
          localaxom.jdField_b_of_type_JavaLangString = localJSONObject.optString("iconUrl");
          localaxom.jdField_a_of_type_JavaLangString = localJSONObject.optString("jumpUrl");
          localaxom.jdField_d_of_type_JavaLangString = localJSONObject.optString("scheme");
          localaxom.jdField_e_of_type_JavaLangString = localJSONObject.optString("package");
          localaxom.jdField_c_of_type_JavaLangString = localJSONObject.optString("name");
          localaxom.jdField_a_of_type_Int = localJSONObject.optInt("id");
          localaxom.jdField_c_of_type_Int = localJSONObject.optInt("openapp");
        }
        switch (localaxom.jdField_a_of_type_Int)
        {
        case 1: 
          axql.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "exp_op_button", localaxom.jdField_a_of_type_Int);
          localArrayList.add(localaxom);
          i1 += 1;
          continue;
          this.i = true;
          localaxom.jdField_b_of_type_Int = 6;
          continue;
          return localArrayList;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("nearby.NearbyHybridFragment", 2, "getBannerItems:" + localException.toString());
        }
      }
      localaxom.jdField_b_of_type_Int = 1;
      continue;
      localaxom.jdField_b_of_type_Int = 2;
      continue;
      localaxom.jdField_b_of_type_Int = 7;
      continue;
      localaxom.jdField_b_of_type_Int = 4;
      continue;
      localaxom.jdField_b_of_type_Int = 8;
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext());
    if (bool) {}
    for (String str1 = "0";; str1 = "1")
    {
      String str3 = NetworkUtil.getApn(BaseApplicationImpl.getContext());
      String str2 = str3;
      if (str3 == null) {
        str2 = "";
      }
      bdla.b(null, "dc00899", "grp_lbs", "", "home", "loc_time_out", 0, 0, String.valueOf(paramInt), String.valueOf(5000), str1, str2);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "reportTimeOut: isNetworkOk=" + bool + ", APN=" + str2);
      }
      return;
    }
  }
  
  public void a(axom paramaxom)
  {
    Intent localIntent;
    int i1;
    if ((paramaxom.jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null) && (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation != null))
    {
      if (!paramaxom.jdField_a_of_type_JavaLangString.startsWith("http")) {
        break label226;
      }
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
      if ((paramaxom.jdField_a_of_type_Int != 14) && (!paramaxom.jdField_a_of_type_JavaLangString.contains("nearbyjiaoyou"))) {
        break label211;
      }
      if (TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.cityCode)) {
        break label206;
      }
      i1 = 0;
      localIntent.putExtra("url", paramaxom.jdField_a_of_type_JavaLangString + "&areaStat=" + i1 + "&code=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.cityCode);
      if (QLog.isDevelopLevel()) {
        QLog.i("NearbyHybridFragment", 4, " jumpByUrl url = " + this.jdField_b_of_type_JavaLangString);
      }
      label178:
      localIntent.putExtra("big_brother_source_key", "biz_src_hdsp_now");
      uuc.a(localIntent, paramaxom.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
    }
    label206:
    label211:
    label226:
    do
    {
      do
      {
        return;
        i1 = 1;
        break;
        localIntent.putExtra("url", paramaxom.jdField_a_of_type_JavaLangString);
        break label178;
      } while ((!paramaxom.jdField_a_of_type_JavaLangString.startsWith("mqqapi")) && (!paramaxom.jdField_a_of_type_JavaLangString.startsWith("nowmqqapi")));
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, JumpActivity.class).setData(Uri.parse(paramaxom.jdField_a_of_type_JavaLangString)));
        return;
      }
      catch (Exception paramaxom) {}
    } while (!QLog.isColorLevel());
    QLog.w("nearby.NearbyHybridFragment", 2, "onItemClick exp" + paramaxom.toString());
  }
  
  public void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    try
    {
      CustomWebView localCustomWebView;
      JSONObject localJSONObject;
      if (this.jdField_a_of_type_Auxc == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("nearby.NearbyHybridFragment.webloading", 2, "callJsAfterLocTimeout: mAbsWebView == null");
        }
      }
      else
      {
        localCustomWebView = this.jdField_a_of_type_Auxc.getWebView();
        if (localCustomWebView != null) {
          localJSONObject = new JSONObject();
        }
      }
      label74:
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      try
      {
        localJSONObject.put("lat", paramSosoLbsInfo.mLocation.mLat02);
        localJSONObject.put("lng", paramSosoLbsInfo.mLocation.mLon02);
        paramSosoLbsInfo = WebViewPlugin.toJsScript("onNearbyLocationChange", localJSONObject, null);
        localCustomWebView.callJs(paramSosoLbsInfo);
        if (QLog.isColorLevel())
        {
          QLog.d("nearby.NearbyHybridFragment.webloading", 2, "callJsAfterLocTimeout:" + paramSosoLbsInfo);
          return;
          paramSosoLbsInfo = paramSosoLbsInfo;
          if (QLog.isColorLevel())
          {
            QLog.e("nearby.NearbyHybridFragment.webloading", 2, "callJsAfterLocTimeout, exp=" + paramSosoLbsInfo.toString());
            return;
            if (QLog.isColorLevel())
            {
              QLog.w("nearby.NearbyHybridFragment.webloading", 2, "callJsAfterLocTimeout, webView==null");
              return;
            }
          }
        }
      }
      catch (Exception paramSosoLbsInfo)
      {
        break label74;
      }
    }
  }
  
  void a(NearbyAppInterface paramNearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        axql.a("nearby.NearbyHybridFragment", "createWebView", new Object[] { this.jdField_a_of_type_Auxc, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, paramNearbyAppInterface });
      }
      if ((this.jdField_a_of_type_Auxc == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (paramNearbyAppInterface != null))
      {
        Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getBaseContext();
        this.jdField_a_of_type_Auxc = new auxc(this, localContext, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, paramNearbyAppInterface);
        paramNearbyAppInterface = new TouchWebView(localContext);
        paramNearbyAppInterface.setBackgroundColor(-1);
        this.jdField_a_of_type_Auxc.a(paramNearbyAppInterface);
        if (QSecFramework.a().a(1001).booleanValue()) {
          QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(83), paramNearbyAppInterface }, null);
        }
        paramNearbyAppInterface.setOnTouchListener(new auwz(this));
        long l1 = System.currentTimeMillis();
        this.jdField_a_of_type_Auxc.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l = (System.currentTimeMillis() - l1);
        if (QLog.isDevelopLevel()) {
          axql.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l) });
        }
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyHybridFragment.webloading", 2, "init webView time:" + this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l);
        }
        this.jdField_f_of_type_Boolean = true;
      }
      return;
    }
    finally {}
  }
  
  public void a(ilive_feeds_near_anchor.NearAnchorInfo paramNearAnchorInfo)
  {
    int i1;
    if ((paramNearAnchorInfo == null) || (paramNearAnchorInfo.jump_type.get() == 1))
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a() + 1;
      this.jdField_a_of_type_JavaLangString = "";
      if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null) {
        this.jdField_a_of_type_JavaLangString = ("&latitude=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat02 + "&longitude=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon02);
      }
      if (i1 != -1)
      {
        paramNearAnchorInfo = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&gender=");
        if (i1 == 2)
        {
          i1 = 2;
          this.jdField_a_of_type_JavaLangString = i1;
        }
      }
      else
      {
        if ((NowLiveFragment.jdField_b_of_type_JavaLangString == null) || (NowLiveFragment.jdField_b_of_type_JavaLangString.length() <= 0)) {
          break label233;
        }
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + NowLiveFragment.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyHybridFragment", 2, "now.qq.com pskey : " + NowLiveFragment.jdField_b_of_type_JavaLangString);
        }
        CookieSyncManager.getInstance().sync();
        j();
      }
    }
    label233:
    Object localObject1;
    do
    {
      do
      {
        return;
        i1 = 1;
        break;
        if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com") != null)
        {
          paramNearAnchorInfo = this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com");
          if (QLog.isColorLevel()) {
            QLog.i("nearby.NearbyHybridFragment", 2, "now.qq.com cookie : " + paramNearAnchorInfo);
          }
          if (paramNearAnchorInfo.contains("p_skey"))
          {
            j();
            return;
          }
        }
        NowLiveFragment.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("pskey", "");
        long l1 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getLong("pskey_t", 0L);
        if ((NowLiveFragment.jdField_b_of_type_JavaLangString != null) && (NowLiveFragment.jdField_b_of_type_JavaLangString.length() > 0) && (System.currentTimeMillis() - l1 < 21600000L))
        {
          this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + NowLiveFragment.jdField_b_of_type_JavaLangString);
          CookieSyncManager.getInstance().sync();
          j();
          return;
        }
        paramNearAnchorInfo = new NearbyHybridFragment.14(this);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramNearAnchorInfo, 1000L);
        paramNearAnchorInfo = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(2);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin();
        localObject2 = new auws(this);
        paramNearAnchorInfo.getPskey((String)localObject1, 16L, new String[] { "now.qq.com" }, (WtTicketPromise)localObject2);
        return;
      } while (paramNearAnchorInfo.jump_type.get() != 2);
      Object localObject2 = String.format("nowmqqapi://now/openroom?src_type=app&version=1&fromid=10006&roomid=%d&first=1&startsrc=fujin7", new Object[] { Integer.valueOf(paramNearAnchorInfo.root_roomid.get()) });
      localObject1 = localObject2;
      if (paramNearAnchorInfo.cover_url.has())
      {
        paramNearAnchorInfo = paramNearAnchorInfo.cover_url.get().toStringUtf8();
        localObject1 = (String)localObject2 + "&coverurl=" + paramNearAnchorInfo;
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
    } while (!QLog.isColorLevel());
    QLog.d("nearby.NearbyHybridFragmentQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "jump from nearby|uri:" + (String)localObject1);
  }
  
  protected void a(StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    paramStringBuilder.append("&").append(paramString).append("=").append(paramObject);
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    boolean bool = NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext());
    String str1;
    String str2;
    int i1;
    if (bool)
    {
      str1 = "0";
      String str3 = NetworkUtil.getApn(BaseApplicationImpl.getContext());
      str2 = str3;
      if (str3 == null) {
        str2 = "";
      }
      if (!this.m) {
        break label183;
      }
      i1 = 1;
      label49:
      if (!paramBoolean) {
        break label189;
      }
      bdla.b(null, "dc00899", "grp_lbs", "", "home", "loc_succ", i1, 0, String.valueOf(paramInt), String.valueOf(paramLong), str1, str2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "reportLocation: isSucc=" + paramBoolean + ", errCode=" + paramInt + ", timeCost=" + paramLong + ", isNetworkOk=" + bool + ", APN=" + str2 + ", isTimeOut=" + this.m);
      }
      return;
      str1 = "1";
      break;
      label183:
      i1 = 0;
      break label49;
      label189:
      bdla.b(null, "dc00899", "grp_lbs", "", "home", "loc_failed", i1, 0, String.valueOf(paramInt), String.valueOf(paramLong), str1, str2);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    this.jdField_e_of_type_Int = paramInt;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      axql.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "exp_pub", 1);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void aC_()
  {
    super.aC_();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  protected int b()
  {
    int i1 = -1;
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
    if (localIntent != null) {
      i1 = localIntent.getIntExtra("nearby_main_init_tab", -1);
    }
    return i1;
  }
  
  protected axnu b()
  {
    int i2 = 0;
    Object localObject2 = (aqww)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(axoc.f);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
    if (localObject1 != null) {
      ((aqww)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("filter"));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "initNearbyFilter, filterMode=" + ((aqww)localObject2).a());
      }
      if (((aqww)localObject2).a() == 0) {
        break label377;
      }
      int i1 = ((Intent)localObject1).getIntExtra("filterGender", 0);
      int i4 = ((Intent)localObject1).getIntExtra("filter_time", 0);
      int i5 = ((Intent)localObject1).getIntExtra("filter_age", 0);
      int i6 = ((Intent)localObject1).getIntExtra("filter_xingzuo", 0);
      int i3 = ((Intent)localObject1).getIntExtra("filter_interest", 0);
      int i7 = ((Intent)localObject1).getIntExtra("filter_career", 0);
      Object localObject3 = ((Intent)localObject1).getStringExtra("filter_location");
      localObject2 = new axnu();
      ((axnu)localObject2).jdField_a_of_type_Int = i1;
      ((axnu)localObject2).jdField_b_of_type_Int = i4;
      ((axnu)localObject2).jdField_c_of_type_Int = i5;
      ((axnu)localObject2).jdField_e_of_type_Int = i6;
      ((axnu)localObject2).f = i7;
      if (i3 >= 0)
      {
        i1 = i3;
        if (i3 <= axnu.jdField_b_of_type_ArrayOfJavaLangString.length - 1) {}
      }
      else
      {
        i1 = 0;
      }
      ((axnu)localObject2).jdField_d_of_type_Int = i1;
      localObject1 = new String[5];
      localObject1[0] = "0";
      localObject1[1] = "0";
      localObject1[2] = "0";
      localObject1[3] = "0";
      localObject1[4] = "不限";
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label362;
      }
      try
      {
        localObject3 = ((String)localObject3).split("\\|");
        localObject1 = localObject3;
      }
      catch (Exception localException)
      {
        label298:
        break label298;
      }
      if (localObject1.length < 4) {
        break label362;
      }
      i1 = i2;
      while (i1 < 4)
      {
        ((axnu)localObject2).jdField_d_of_type_ArrayOfJavaLangString[i1] = localObject1[i1];
        i1 += 1;
      }
      localObject1 = new Intent();
    }
    if (localObject1.length >= 5)
    {
      localObject1 = localObject1[4];
      ((axnu)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      label362:
      localObject1 = localObject2;
    }
    label377:
    do
    {
      do
      {
        return localObject1;
        localObject1 = "不限";
        break;
        localObject2 = axnu.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject2 = new axnu();
      ((axnu)localObject2).jdField_a_of_type_Int = 0;
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("nearby.heart_beat", 2, "defFilter: filters.gender=" + ((axnu)localObject2).jdField_a_of_type_Int);
    return localObject2;
  }
  
  public void d()
  {
    QLog.d("nearby.NearbyHybridFragment.webloading", 1, "checkLocation");
    if ((Build.VERSION.SDK_INT >= 23) && (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      QLog.e("nearby.NearbyHybridFragment.webloading", 1, "ACCESS_FINE_LOCATION permission not granted!");
      this.jdField_d_of_type_Int = 1;
      return;
    }
    long l1 = System.currentTimeMillis() - jdField_a_of_type_Long;
    if ((jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) || (l1 > 300000L))
    {
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.w("nearby.NearbyHybridFragment.webloading", 2, "send [MSG_SHOW_LOADING | MSG_LOCATION_TIME_OUT] before startLocation");
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
      this.o = false;
      this.m = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 500L);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 5000L);
      SosoInterface.startLocation(new auwy(this, 3, true, false, 300000L, true, false, "NearbyNowliveTab", l1));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, "startLocation useCache timeDiff=" + l1);
    }
    e();
    bdla.b(null, "dc00899", "grp_lbs", "", "home", "loc_use_cache", 0, 0, "", "", "", "");
  }
  
  public void e()
  {
    int i1;
    if (!TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.cityCode))
    {
      i1 = 0;
      this.jdField_b_of_type_JavaLangString = ("latitude=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat02 + "&longitude=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon02 + "&areaStat=" + i1 + "&code=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.cityCode);
      if (QLog.isColorLevel()) {
        QLog.i("NearbyHybridFragment", 4, " nearbyTabLocParams = " + this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_c_of_type_JavaLangString = a();
      if (!bijv.b(this.jdField_c_of_type_JavaLangString)) {
        break label217;
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "onLocationSucc, hasProxyParam");
      }
      ThreadManager.postImmediately(new NearbyHybridFragment.4(this), null, false);
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyHybridFragment.5(this), 500L);
      return;
      i1 = 1;
      break;
      label217:
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "onLocationSucc, !hasProxyParam:" + this.jdField_c_of_type_JavaLangString);
      }
    }
  }
  
  protected void f()
  {
    bmux.a(BaseApplicationImpl.getContext(), "nearby_shouye_preload");
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Auxc == null) {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewRefresh: mAbsWebView == null");
      }
    }
    do
    {
      String str;
      do
      {
        return;
        CustomWebView localCustomWebView = this.jdField_a_of_type_Auxc.getWebView();
        if (localCustomWebView == null) {
          break;
        }
        str = WebViewPlugin.toJsScript("qbrowserPullDown", null, null);
        localCustomWebView.callJs(str);
      } while (!QLog.isColorLevel());
      QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewRefresh:" + str);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewRefresh, webView==null");
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Auxc == null) {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewShow: mAbsWebView == null");
      }
    }
    for (;;)
    {
      return;
      CustomWebView localCustomWebView = this.jdField_a_of_type_Auxc.getWebView();
      Object localObject;
      if (localCustomWebView != null) {
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("hidden", false);
        label53:
        localObject = WebViewPlugin.toJsScript("qbrowserVisibilityChangeV2", (JSONObject)localObject, null);
        localCustomWebView.callJs((String)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewShow:" + (String)localObject);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("nearby.NearbyHybridFragment", 2, "notifyWebViewShow, webView==null");
        return;
      }
      catch (Exception localException)
      {
        break label53;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = 2;
    switch (paramMessage.what)
    {
    case 2: 
    case 4: 
    default: 
    case 3: 
    case 1: 
    case 5: 
    case 6: 
      label366:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                if (QLog.isColorLevel()) {
                  QLog.w("nearby.NearbyHybridFragment.webloading", 2, "handleMessage MSG_SHOW_LOADING: isLoadingFinished=" + this.o);
                }
              } while ((this.o) || (this.jdField_d_of_type_AndroidViewView == null));
              if (this.jdField_d_of_type_AndroidViewView != null) {
                this.jdField_d_of_type_AndroidViewView.setVisibility(0);
              }
              if (this.jdField_e_of_type_AndroidViewView != null) {
                this.jdField_e_of_type_AndroidViewView.setVisibility(8);
              }
            } while (this.jdField_f_of_type_AndroidViewView == null);
            this.jdField_f_of_type_AndroidViewView.setVisibility(8);
            return false;
            if (paramMessage.what == 5) {
              if (QLog.isColorLevel()) {
                QLog.d("nearby.NearbyHybridFragment.webloading", 2, "handleMessage attach-locationEnd cost=" + (System.currentTimeMillis() - this.jdField_c_of_type_Long));
              }
            }
            while (this.k)
            {
              if (this.jdField_d_of_type_Int != 0) {
                break label366;
              }
              if ((this.i) && (!this.j) && (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null))
              {
                this.j = true;
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyHybridFragment.7(this), 2000L);
              }
              if ((!this.jdField_e_of_type_Boolean) || (this.l)) {
                break;
              }
              this.l = true;
              this.jdField_a_of_type_Auxc.a(this.jdField_c_of_type_JavaLangString);
              return false;
              if (paramMessage.what == 6)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("nearby.NearbyHybridFragment.webloading", 2, "handleMessage attach-viewInitEnd cost=" + (System.currentTimeMillis() - this.jdField_c_of_type_Long));
                }
              }
              else if ((paramMessage.what == 1) && (QLog.isColorLevel())) {
                QLog.d("nearby.NearbyHybridFragment.webloading", 2, "handleMessage MSG_INIT");
              }
            }
          } while (this.jdField_d_of_type_Int != 1);
          if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) {
            break;
          }
          if (this.jdField_f_of_type_AndroidViewView != null) {
            this.jdField_f_of_type_AndroidViewView.setVisibility(0);
          }
          if (this.jdField_d_of_type_AndroidViewView != null) {
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          }
        } while (this.jdField_e_of_type_AndroidViewView == null);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        return false;
        if (this.jdField_f_of_type_AndroidViewView != null) {
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        }
        if (this.jdField_d_of_type_AndroidViewView != null) {
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        }
      } while (this.jdField_e_of_type_AndroidViewView == null);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      return false;
    }
    this.m = true;
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = axqc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
      i1 = 1;
    }
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = new SosoInterface.SosoLbsInfo();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation = new SosoInterface.SosoLocation();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat02 = 0.0D;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon02 = 0.0D;
      i1 = 3;
    }
    QLog.d("nearby.NearbyHybridFragment.webloading", 1, "handleMessage MSG_LOCATION_TIME_OUT， locType=" + i1);
    e();
    a(i1);
    return false;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Auxc == null) {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewHide: mAbsWebView == null");
      }
    }
    for (;;)
    {
      return;
      CustomWebView localCustomWebView = this.jdField_a_of_type_Auxc.getWebView();
      Object localObject;
      if (localCustomWebView != null) {
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("hidden", true);
        label53:
        localObject = WebViewPlugin.toJsScript("qbrowserVisibilityChangeV2", (JSONObject)localObject, null);
        localCustomWebView.callJs((String)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewHide:" + (String)localObject);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("nearby.NearbyHybridFragment", 2, "notifyWebViewHide, webView==null");
        return;
      }
      catch (Exception localException)
      {
        break label53;
      }
    }
  }
  
  protected void j()
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    String str = NearbyActivity.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_JavaLangString + "&_t=" + System.currentTimeMillis();
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
  }
  
  protected void k()
  {
    l();
    this.jdField_a_of_type_Auyp.a(anvx.a(2131706665)).a(new auwt(this));
    this.jdField_a_of_type_Auyp.a();
  }
  
  public void l()
  {
    int i2 = -1;
    Object localObject = (NearbyActivity)getActivity();
    int i1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateRightBtnRedTouch, selectIdx=");
      if (localObject == null)
      {
        i1 = -1;
        localStringBuilder = localStringBuilder.append(i1).append(", selfIdx=");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo != null) {
          break label179;
        }
        i1 = i2;
        label60:
        QLog.d("nearby.NearbyHybridFragment", 2, i1);
      }
    }
    else
    {
      if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo == null) || (((NearbyActivity)localObject).c() != this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo.tabIndex)) {
        break label190;
      }
      localObject = (NearbyActivity)getActivity();
      if (localObject != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch((Context)localObject, ((NearbyActivity)localObject).rightViewText);
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b(53).a();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(9);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
      }
    }
    label179:
    label190:
    while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null)
    {
      return;
      i1 = ((NearbyActivity)localObject).c();
      break;
      i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo.tabIndex;
      break label60;
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(null);
  }
  
  public void m()
  {
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    axut localaxut = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    Object localObject2 = localaxut.a(10);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch: redTypeInfo==null");
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    int i1 = 0;
    for (;;)
    {
      try
      {
        i2 = Integer.valueOf(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.get()).intValue();
        if (i2 <= 99) {
          continue;
        }
        str = "99+";
        i1 = i2;
      }
      catch (Exception localException)
      {
        int i2;
        String str;
        aymg localaymg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch exp=", localException);
        Object localObject1 = "";
        continue;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if ((i1 != 1) || (!localaymg.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(localaymg.jdField_a_of_type_JavaLangString))) {
          continue;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localaymg.jdField_a_of_type_JavaLangString);
        if (localaymg.jdField_b_of_type_Int != 2) {
          continue;
        }
        a(localaymg);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.removeAllViews();
        if ((TextUtils.isEmpty(localaymg.jdField_d_of_type_JavaLangString)) || (!HttpUtil.isValidUrl(localaymg.jdField_d_of_type_JavaLangString))) {
          continue;
        }
        localObject1 = getResources().getDrawable(2130840348);
        a(localaymg.jdField_d_of_type_JavaLangString, (Drawable)localObject1);
        localObject1 = localaxut.a();
        if ((i1 != 1) || (((aymi)localObject1).jdField_d_of_type_Int != 1)) {
          continue;
        }
        u();
        ayme.a().a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "home", "news_slip_exp");
        axql.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "exp_msg", 0);
        if (i1 <= 1) {
          return;
        }
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject1 + anvx.a(2131706663));
        continue;
        if (localaymg.jdField_a_of_type_Long <= 0L) {
          continue;
        }
        localObject1 = String.valueOf(localaymg.jdField_a_of_type_Long);
        this.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localObject1 = localaxut.a((String)localObject1, 1, true);
        localObject2 = new URLImageView(getActivity());
        ((URLImageView)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.dp2px(30.0F, getActivity().getResources()), AIOUtils.dp2px(30.0F, getActivity().getResources())));
        if ((localObject1 == null) || (((Bitmap)localObject1).getByteCount() <= 0)) {
          continue;
        }
        ((URLImageView)localObject2).setImageBitmap((Bitmap)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.addView((View)localObject2);
        continue;
        ((URLImageView)localObject2).setImageDrawable(getResources().getDrawable(2130840348));
        continue;
        a(getResources().getDrawable(2130840348));
        continue;
      }
      i2 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get();
      localaymg = new aymg();
      localaymg.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch: redType=" + i2 + ", numStr=" + str);
      }
      if (((localaymg.jdField_b_of_type_Boolean) || (i2 == 5)) && (i1 > 0) && (!TextUtils.isEmpty(str))) {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "!isOfficialNotify && redType != RedTouch.RED_TOUCH_NUM) || TextUtils.isEmpty(numStr)");
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      str = String.valueOf(i2);
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bkzi = bkzi.c(getActivity());
    this.jdField_a_of_type_Bkzi.b(2131698391);
    this.jdField_a_of_type_Bkzi.b(2131698389);
    this.jdField_a_of_type_Bkzi.c(2131690697);
    this.jdField_a_of_type_Bkzi.a(new auww(this));
    this.jdField_a_of_type_Bkzi.a(new auwx(this));
    this.jdField_a_of_type_Bkzi.show();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Auxc == null) {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewSheetDismiss: mAbsWebView == null");
      }
    }
    do
    {
      String str;
      do
      {
        return;
        CustomWebView localCustomWebView = this.jdField_a_of_type_Auxc.getWebView();
        if (localCustomWebView == null) {
          break;
        }
        str = WebViewPlugin.toJsScript("closeFilterAndExitSheet", null, null);
        localCustomWebView.callJs(str);
      } while (!QLog.isColorLevel());
      QLog.d("nearby.NearbyHybridFragment", 2, "ActionSheet onDissmiss:" + str);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("nearby.NearbyHybridFragment", 2, "ActionSheet onDissmiss, webView==null");
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
    this.jdField_a_of_type_Axnu = b();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int == 0) {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, "onAttach, mLastTabIndex=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        axql.a("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g) });
      }
    }
    super.onCreate(paramBundle);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g);
      if (QLog.isDevelopLevel()) {
        axql.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i) });
      }
    }
    axqc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), true);
    long l1 = System.currentTimeMillis();
    axqc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "nearby_enter_time", Long.valueOf(l1));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, "onCreateView");
    }
    r();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      if (QLog.isColorLevel()) {
        axql.a("nearby.NearbyHybridFragment", new Object[] { "onCreateView", Long.valueOf(l1) });
      }
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      if (this.h) {
        d();
      }
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        long l2 = System.currentTimeMillis();
        a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        CookieSyncManager.createInstance(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyHybridFragment.webloading", 2, "total createWebView time:" + (System.currentTimeMillis() - l2));
        }
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559533, null);
        this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381379));
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout = ((OverCoverFrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372346));
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout.setOnActionListener(this.jdField_a_of_type_Ayny);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366222);
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366209));
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381387));
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362845);
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewView.findViewById(2131363384);
        if (("Meizu".equalsIgnoreCase(Build.BRAND)) && ("M040".equalsIgnoreCase(Build.MODEL)) && (paramLayoutInflater != null)) {
          paramLayoutInflater.setVisibility(8);
        }
        paramLayoutInflater = a();
        this.jdField_a_of_type_Axoj = new axoj(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.jdField_a_of_type_Axoj.a(paramLayoutInflater);
        this.jdField_a_of_type_Axoj.a(this.jdField_a_of_type_Axon);
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131374407));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout = ((OverlapLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131374406));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374408));
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setDelayBeforeScrollBack(800L);
        this.jdField_a_of_type_Auxc.mWebview.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
        this.jdField_a_of_type_Auxc.mWebview.setOnScrollChangedListener(new auwo(this));
        paramLayoutInflater = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Auxc.mWebview, 0, paramLayoutInflater);
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyHybridFragment.webloading", 2, "webView add to container:" + (System.currentTimeMillis() - l2));
        }
        this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381392);
        paramLayoutInflater = (URLImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131373857);
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        paramViewGroup.mPlayGifImage = true;
        paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLAyBjp36ialuzyODWtr9VCdVQJo0JTrkib9eDlHdRtvS90g/", paramViewGroup));
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381389);
        this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370504);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_f_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      this.jdField_a_of_type_Auyp.b(getString(2131694218)).a(false);
      k();
      this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(this.jdField_a_of_type_Aakw);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j == 0L))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j = (System.currentTimeMillis() - l1);
        if (QLog.isDevelopLevel()) {
          axql.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j) });
        }
      }
      if (this.h)
      {
        this.h = false;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.addObserver(this.jdField_a_of_type_Anzs);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_Axuu);
        this.jdField_a_of_type_Axoj.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        m();
        this.k = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      }
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_Anzs);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_Axuu);
    this.jdField_a_of_type_Axoj.b(null);
    this.jdField_a_of_type_Auxc.d();
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
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyHybridFragment", 2, "onHiddenChanged: hidden=" + paramBoolean);
    }
    if (paramBoolean)
    {
      i();
      s();
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)null);
      }
      return;
    }
    h();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyHybridFragment", 2, "onPause:" + this.jdField_d_of_type_Boolean);
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Auxc.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.jdField_f_of_type_Boolean) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyHybridFragment", 2, "onResume:" + this.jdField_d_of_type_Boolean);
        }
        r();
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_Auxc.b();
        if (!NetworkUtil.isNetworkAvailable(getActivity())) {
          QQToast.a(getActivity(), 1, anvx.a(2131706664), 0).b(getActivity().getTitleBarHeight());
        }
        if (this.jdField_a_of_type_Axoj != null) {
          this.jdField_a_of_type_Axoj.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        }
        l();
        m();
        if (this.jdField_d_of_type_Int == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("nearby.NearbyHybridFragment", 2, "onResume, re checkLocation");
          }
          d();
        }
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
        str1 = ((SharedPreferences)localObject).getString("nearby_now_delete_success_js_param", "");
      } while (TextUtils.isEmpty(str1));
      str2 = ((SharedPreferences)localObject).getString("nearby_now_delete_success_js_callback", "");
    } while (TextUtils.isEmpty(str2));
    this.jdField_a_of_type_Auxc.mWebview.callJs(str2, new String[] { str1 });
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("nearby_now_delete_success_js_param", "");
    ((SharedPreferences.Editor)localObject).remove("nearby_now_delete_success_js_param").commit();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    f();
  }
  
  public void p()
  {
    String str = bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a("https://nearby.qq.com/people_filter/index.html", "_wwv", "4"), "sex", String.valueOf(this.jdField_a_of_type_Axnu.jdField_a_of_type_Int)), "time", String.valueOf(this.jdField_a_of_type_Axnu.jdField_b_of_type_Int)), "age", String.valueOf(this.jdField_a_of_type_Axnu.jdField_c_of_type_Int)), "interest", String.valueOf(this.jdField_a_of_type_Axnu.jdField_d_of_type_Int)), "profession", String.valueOf(this.jdField_a_of_type_Axnu.f)), "country", String.valueOf(this.jdField_a_of_type_Axnu.jdField_d_of_type_ArrayOfJavaLangString[0])), "strCountry", this.jdField_a_of_type_Axnu.jdField_b_of_type_JavaLangString), "province", String.valueOf(this.jdField_a_of_type_Axnu.jdField_d_of_type_ArrayOfJavaLangString[1])), "strProvince", this.jdField_a_of_type_Axnu.jdField_c_of_type_JavaLangString), "city", String.valueOf(this.jdField_a_of_type_Axnu.jdField_d_of_type_ArrayOfJavaLangString[2])), "strCity", this.jdField_a_of_type_Axnu.jdField_d_of_type_JavaLangString), "contellation", String.valueOf(this.jdField_a_of_type_Axnu.jdField_e_of_type_Int));
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    getActivity().startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment", 2, "jump2FilterSettingPage:" + str);
    }
  }
  
  public void q()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_e_of_type_Long;
    long l3 = System.currentTimeMillis();
    long l4 = this.jdField_c_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, "hideWebLoadingView:" + this.o + ", timeCostFromLoad=" + (l1 - l2) + ", timeCostFromAttach=" + (l3 - l4));
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.o = true;
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_f_of_type_AndroidViewView != null) {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void r()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment.duration", 2, "resetUserBrowseTime");
    }
  }
  
  public void s()
  {
    int i1 = ((Integer)axqc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    long l1 = (System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L;
    if (l1 <= 0L) {
      l1 = 1L;
    }
    for (;;)
    {
      bdla.b(null, "dc00899", "grp_lbs", "", "home", "home_exp", 0, 0, "", String.valueOf(i1), "", String.valueOf(l1));
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.duration", 2, "reportUserBroseTime: d2[gender]=" + i1 + ", d4[duration]=" + l1);
      }
      return;
    }
  }
  
  public void t()
  {
    try
    {
      axut localaxut = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
      Object localObject = localaxut.a(11);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("handleNearbyActivityTip, dotInfo=");
        if (localObject != null) {
          break label184;
        }
      }
      label184:
      for (String str = "";; str = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.get())
      {
        QLog.d("nearby.redpoint", 2, str + ", isFinish=" + this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing());
        if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing())) {
          break;
        }
        str = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.get();
        localObject = new aynk(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
        if (((aynk)localObject).a(str)) {
          ((aynk)localObject).show();
        }
        localaxut.a(58);
        bdla.b(null, "dc00899", "grp_lbs", "", "entry", "pop_clk_red", 0, 0, String.valueOf(((Integer)axqc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue()), "", "", "");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("nearby.redpoint", 1, "handleNearbyActivityTip, exp=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment
 * JD-Core Version:    0.7.0.1
 */