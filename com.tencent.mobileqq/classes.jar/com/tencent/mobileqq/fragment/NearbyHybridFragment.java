package com.tencent.mobileqq.fragment;

import ajyc;
import akbn;
import ampe;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqib;
import aqic;
import aqid;
import aqie;
import aqif;
import aqig;
import aqih;
import aqii;
import aqij;
import aqik;
import aqil;
import aqim;
import aqin;
import aqio;
import aqip;
import aqju;
import asyz;
import aszo;
import aszr;
import atbg;
import atbp;
import atfx;
import atfy;
import atxz;
import atyj;
import atyn;
import axqw;
import bavi;
import bbev;
import bcal;
import bche;
import bcpw;
import bfng;
import bfol;
import bihe;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.ArrayList;
import mqq.manager.TicketManager;
import nam;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONArray;
import org.json.JSONObject;
import sgj;
import xem;

public class NearbyHybridFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  public static long a;
  public static SosoInterface.SosoLbsInfo a;
  public static final Runnable a;
  public static boolean m;
  protected akbn a;
  protected View.OnClickListener a;
  protected AdapterView.OnItemClickListener a;
  protected FrameLayout a;
  protected LinearLayout a;
  protected TextView a;
  public aqip a;
  public asyz a;
  public aszo a;
  protected atfy a;
  public atyj a;
  protected atyn a;
  public bfol a;
  public RefreshView a;
  public URLImageView a;
  public NearbyActivity a;
  public OverCoverFrameLayout a;
  public RedTouch a;
  public CookieManager a;
  protected String a;
  protected xem a;
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
  protected boolean g = true;
  protected boolean h;
  protected boolean i;
  protected boolean j;
  protected boolean k;
  public boolean l;
  public boolean n;
  
  static
  {
    jdField_a_of_type_JavaLangRunnable = new NearbyHybridFragment.2();
  }
  
  public NearbyHybridFragment()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Asyz = new asyz();
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Xem = new aqin(this);
    this.jdField_a_of_type_Atyn = new aqio(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aqic(this);
    this.jdField_a_of_type_Atyj = new aqid(this);
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new aqie(this);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Atfy = new aqih(this);
    this.jdField_a_of_type_Akbn = new aqii(this);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout.c()) {
      return 0;
    }
    return 1;
  }
  
  public asyz a()
  {
    return this.jdField_a_of_type_Asyz;
  }
  
  public bcal a()
  {
    return this.jdField_a_of_type_Aqip;
  }
  
  protected String a()
  {
    Object localObject1 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.tabUrl;
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      if (!((String)localObject1).contains("?")) {
        break label259;
      }
    }
    label259:
    for (localObject1 = (String)localObject1 + "&";; localObject1 = (String)localObject1 + "?")
    {
      localObject2 = (String)localObject1 + this.jdField_b_of_type_JavaLangString;
      Object localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = (String)localObject2 + ((StringBuilder)localObject3).toString();
      }
      localObject3 = atbg.a(atbg.a());
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
    if (this.jdField_a_of_type_Asyz != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      a(localStringBuilder, "sex", Integer.valueOf(this.jdField_a_of_type_Asyz.jdField_a_of_type_Int));
      a(localStringBuilder, "time", Integer.valueOf(this.jdField_a_of_type_Asyz.jdField_b_of_type_Int));
      a(localStringBuilder, "age", Integer.valueOf(this.jdField_a_of_type_Asyz.jdField_c_of_type_Int));
      a(localStringBuilder, "interest", Integer.valueOf(this.jdField_a_of_type_Asyz.jdField_d_of_type_Int));
      a(localStringBuilder, "profession", Integer.valueOf(this.jdField_a_of_type_Asyz.f));
      a(localStringBuilder, "country", this.jdField_a_of_type_Asyz.jdField_d_of_type_ArrayOfJavaLangString[0]);
      a(localStringBuilder, "province", this.jdField_a_of_type_Asyz.jdField_d_of_type_ArrayOfJavaLangString[1]);
      a(localStringBuilder, "city", this.jdField_a_of_type_Asyz.jdField_d_of_type_ArrayOfJavaLangString[2]);
      a(localStringBuilder, "contellation", Integer.valueOf(this.jdField_a_of_type_Asyz.jdField_e_of_type_Int));
      return localStringBuilder;
    }
    return null;
  }
  
  protected ArrayList<aszr> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (String)atbg.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "key_banner_enter_items", "");
    this.h = false;
    for (;;)
    {
      aszr localaszr;
      try
      {
        localObject = new JSONArray((String)localObject);
        int i1 = 0;
        if (i1 < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i1);
          localaszr = new aszr();
          localaszr.jdField_b_of_type_JavaLangString = localJSONObject.optString("iconUrl");
          localaszr.jdField_a_of_type_JavaLangString = localJSONObject.optString("jumpUrl");
          localaszr.jdField_d_of_type_JavaLangString = localJSONObject.optString("scheme");
          localaszr.jdField_e_of_type_JavaLangString = localJSONObject.optString("package");
          localaszr.jdField_c_of_type_JavaLangString = localJSONObject.optString("name");
          localaszr.jdField_a_of_type_Int = localJSONObject.optInt("id");
          localaszr.jdField_c_of_type_Int = localJSONObject.optInt("openapp");
        }
        switch (localaszr.jdField_a_of_type_Int)
        {
        case 1: 
          atbp.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "exp_op_button", localaszr.jdField_a_of_type_Int);
          localArrayList.add(localaszr);
          i1 += 1;
          continue;
          this.h = true;
          localaszr.jdField_b_of_type_Int = 6;
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
      localaszr.jdField_b_of_type_Int = 1;
      continue;
      localaszr.jdField_b_of_type_Int = 2;
      continue;
      localaszr.jdField_b_of_type_Int = 7;
      continue;
      localaszr.jdField_b_of_type_Int = 4;
      continue;
      localaszr.jdField_b_of_type_Int = 8;
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = bbev.g(BaseApplicationImpl.getContext());
    if (bool) {}
    for (String str1 = "0";; str1 = "1")
    {
      String str3 = bbev.a(BaseApplicationImpl.getContext());
      String str2 = str3;
      if (str3 == null) {
        str2 = "";
      }
      axqw.b(null, "dc00899", "grp_lbs", "", "home", "loc_time_out", 0, 0, String.valueOf(paramInt), String.valueOf(5000), str1, str2);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "reportTimeOut: isNetworkOk=" + bool + ", APN=" + str2);
      }
      return;
    }
  }
  
  public void a(aszr paramaszr)
  {
    Intent localIntent;
    int i1;
    if ((paramaszr.jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null) && (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a != null))
    {
      if (!paramaszr.jdField_a_of_type_JavaLangString.startsWith("http")) {
        break label226;
      }
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
      if ((paramaszr.jdField_a_of_type_Int != 14) && (!paramaszr.jdField_a_of_type_JavaLangString.contains("nearbyjiaoyou"))) {
        break label211;
      }
      if (TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.f)) {
        break label206;
      }
      i1 = 0;
      localIntent.putExtra("url", paramaszr.jdField_a_of_type_JavaLangString + "&areaStat=" + i1 + "&code=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.f);
      if (QLog.isDevelopLevel()) {
        QLog.i("NearbyHybridFragment", 4, " jumpByUrl url = " + this.jdField_b_of_type_JavaLangString);
      }
      label178:
      localIntent.putExtra("big_brother_source_key", "biz_src_hdsp_now");
      sgj.a(localIntent, paramaszr.jdField_a_of_type_JavaLangString);
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
        localIntent.putExtra("url", paramaszr.jdField_a_of_type_JavaLangString);
        break label178;
      } while ((!paramaszr.jdField_a_of_type_JavaLangString.startsWith("mqqapi")) && (!paramaszr.jdField_a_of_type_JavaLangString.startsWith("nowmqqapi")));
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, JumpActivity.class).setData(Uri.parse(paramaszr.jdField_a_of_type_JavaLangString)));
        return;
      }
      catch (Exception paramaszr) {}
    } while (!QLog.isColorLevel());
    QLog.w("nearby.NearbyHybridFragment", 2, "onItemClick exp" + paramaszr.toString());
  }
  
  public void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    try
    {
      CustomWebView localCustomWebView;
      JSONObject localJSONObject;
      if (this.jdField_a_of_type_Aqip == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("nearby.NearbyHybridFragment.webloading", 2, "callJsAfterLocTimeout: mAbsWebView == null");
        }
      }
      else
      {
        localCustomWebView = this.jdField_a_of_type_Aqip.getWebView();
        if (localCustomWebView != null) {
          localJSONObject = new JSONObject();
        }
      }
      label73:
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      try
      {
        localJSONObject.put("lat", paramSosoLbsInfo.a.a);
        localJSONObject.put("lng", paramSosoLbsInfo.a.b);
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
        break label73;
      }
    }
  }
  
  void a(NearbyAppInterface paramNearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        atbp.a("nearby.NearbyHybridFragment", "createWebView", new Object[] { this.jdField_a_of_type_Aqip, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, paramNearbyAppInterface });
      }
      if ((this.jdField_a_of_type_Aqip == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (paramNearbyAppInterface != null))
      {
        Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getBaseContext();
        this.jdField_a_of_type_Aqip = new aqip(this, localContext, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, paramNearbyAppInterface);
        paramNearbyAppInterface = new TouchWebView(localContext);
        paramNearbyAppInterface.setBackgroundColor(-1);
        this.jdField_a_of_type_Aqip.a(paramNearbyAppInterface);
        if (QSecFramework.a().a(1001).booleanValue()) {
          QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(83), paramNearbyAppInterface }, null);
        }
        paramNearbyAppInterface.setOnTouchListener(new aqim(this));
        long l1 = System.currentTimeMillis();
        this.jdField_a_of_type_Aqip.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l = (System.currentTimeMillis() - l1);
        if (QLog.isDevelopLevel()) {
          atbp.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l) });
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
        this.jdField_a_of_type_JavaLangString = ("&latitude=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + "&longitude=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b);
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
        localObject2 = new aqif(this);
        paramNearAnchorInfo.GetPskey((String)localObject1, 16L, new String[] { "now.qq.com" }, (WtTicketPromise)localObject2);
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
    boolean bool = bbev.g(BaseApplicationImpl.getContext());
    String str1;
    String str2;
    int i1;
    if (bool)
    {
      str1 = "0";
      String str3 = bbev.a(BaseApplicationImpl.getContext());
      str2 = str3;
      if (str3 == null) {
        str2 = "";
      }
      if (!this.l) {
        break label182;
      }
      i1 = 1;
      label49:
      if (!paramBoolean) {
        break label188;
      }
      axqw.b(null, "dc00899", "grp_lbs", "", "home", "loc_succ", i1, 0, String.valueOf(paramInt), String.valueOf(paramLong), str1, str2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "reportLocation: isSucc=" + paramBoolean + ", errCode=" + paramInt + ", timeCost=" + paramLong + ", isNetworkOk=" + bool + ", APN=" + str2 + ", isTimeOut=" + this.l);
      }
      return;
      str1 = "1";
      break;
      label182:
      i1 = 0;
      break label49;
      label188:
      axqw.b(null, "dc00899", "grp_lbs", "", "home", "loc_failed", i1, 0, String.valueOf(paramInt), String.valueOf(paramLong), str1, str2);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    this.jdField_e_of_type_Int = paramInt;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      atbp.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "exp_pub", 1);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void aT_()
  {
    super.aT_();
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
  
  protected asyz b()
  {
    int i2 = 0;
    Object localObject2 = (ampe)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(210);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
    if (localObject1 != null) {
      ((ampe)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("filter"));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "initNearbyFilter, filterMode=" + ((ampe)localObject2).a());
      }
      if (((ampe)localObject2).a() == 0) {
        break label377;
      }
      int i1 = ((Intent)localObject1).getIntExtra("filterGender", 0);
      int i4 = ((Intent)localObject1).getIntExtra("filter_time", 0);
      int i5 = ((Intent)localObject1).getIntExtra("filter_age", 0);
      int i6 = ((Intent)localObject1).getIntExtra("filter_xingzuo", 0);
      int i3 = ((Intent)localObject1).getIntExtra("filter_interest", 0);
      int i7 = ((Intent)localObject1).getIntExtra("filter_career", 0);
      Object localObject3 = ((Intent)localObject1).getStringExtra("filter_location");
      localObject2 = new asyz();
      ((asyz)localObject2).jdField_a_of_type_Int = i1;
      ((asyz)localObject2).jdField_b_of_type_Int = i4;
      ((asyz)localObject2).jdField_c_of_type_Int = i5;
      ((asyz)localObject2).jdField_e_of_type_Int = i6;
      ((asyz)localObject2).f = i7;
      if (i3 >= 0)
      {
        i1 = i3;
        if (i3 <= asyz.jdField_b_of_type_ArrayOfJavaLangString.length - 1) {}
      }
      else
      {
        i1 = 0;
      }
      ((asyz)localObject2).jdField_d_of_type_Int = i1;
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
        ((asyz)localObject2).jdField_d_of_type_ArrayOfJavaLangString[i1] = localObject1[i1];
        i1 += 1;
      }
      localObject1 = new Intent();
    }
    if (localObject1.length >= 5)
    {
      localObject1 = localObject1[4];
      ((asyz)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
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
        localObject2 = asyz.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject2 = new asyz();
      ((asyz)localObject2).jdField_a_of_type_Int = 0;
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("nearby.heart_beat", 2, "defFilter: filters.gender=" + ((asyz)localObject2).jdField_a_of_type_Int);
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
      this.n = false;
      this.l = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 500L);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 5000L);
      SosoInterface.a(new aqil(this, 3, true, false, 300000L, true, false, "NearbyNowliveTab", l1));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, "startLocation useCache timeDiff=" + l1);
    }
    e();
    axqw.b(null, "dc00899", "grp_lbs", "", "home", "loc_use_cache", 0, 0, "", "", "", "");
  }
  
  public void e()
  {
    int i1;
    if (!TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.f))
    {
      i1 = 0;
      this.jdField_b_of_type_JavaLangString = ("latitude=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + "&longitude=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + "&areaStat=" + i1 + "&code=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.f);
      if (QLog.isColorLevel()) {
        QLog.i("NearbyHybridFragment", 4, " nearbyTabLocParams = " + this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_c_of_type_JavaLangString = a();
      if (!bche.b(this.jdField_c_of_type_JavaLangString)) {
        break label216;
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
      label216:
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "onLocationSucc, !hasProxyParam:" + this.jdField_c_of_type_JavaLangString);
      }
    }
  }
  
  protected void f()
  {
    bihe.a(BaseApplicationImpl.getContext(), "nearby_shouye_preload");
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Aqip == null) {
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
        CustomWebView localCustomWebView = this.jdField_a_of_type_Aqip.getWebView();
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
    if (this.jdField_a_of_type_Aqip == null) {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewShow: mAbsWebView == null");
      }
    }
    for (;;)
    {
      return;
      CustomWebView localCustomWebView = this.jdField_a_of_type_Aqip.getWebView();
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
      label362:
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
                  QLog.w("nearby.NearbyHybridFragment.webloading", 2, "handleMessage MSG_SHOW_LOADING: isLoadingFinished=" + this.n);
                }
              } while ((this.n) || (this.jdField_d_of_type_AndroidViewView == null));
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
            while (this.j)
            {
              if (this.jdField_d_of_type_Int != 0) {
                break label362;
              }
              if ((this.h) && (!this.i) && (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null))
              {
                this.i = true;
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyHybridFragment.7(this), 2000L);
              }
              if ((!this.jdField_e_of_type_Boolean) || (this.k)) {
                break;
              }
              this.k = true;
              this.jdField_a_of_type_Aqip.a(this.jdField_c_of_type_JavaLangString);
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
          if (!bbev.g(BaseApplicationImpl.getContext())) {
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
    this.l = true;
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = atbg.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
      i1 = 1;
    }
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = new SosoInterface.SosoLbsInfo();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a = new SosoInterface.SosoLocation();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a = 0.0D;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b = 0.0D;
      i1 = 3;
    }
    QLog.d("nearby.NearbyHybridFragment.webloading", 1, "handleMessage MSG_LOCATION_TIME_OUT， locType=" + i1);
    e();
    a(i1);
    return false;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Aqip == null) {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewHide: mAbsWebView == null");
      }
    }
    for (;;)
    {
      return;
      CustomWebView localCustomWebView = this.jdField_a_of_type_Aqip.getWebView();
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
    this.jdField_a_of_type_Aqju.a(ajyc.a(2131707190)).a(new aqig(this));
    this.jdField_a_of_type_Aqju.a();
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
        if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) {
          break label179;
        }
        i1 = i2;
        label60:
        QLog.d("nearby.NearbyHybridFragment", 2, i1);
      }
    }
    else
    {
      if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo == null) || (((NearbyActivity)localObject).c() != this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.tabIndex)) {
        break label190;
      }
      localObject = (NearbyActivity)getActivity();
      if (localObject != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch((Context)localObject, ((NearbyActivity)localObject).rightViewText);
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).a();
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
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.tabIndex;
      break label60;
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(null);
  }
  
  public void m()
  {
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((atfx)localObject3).a(10);
    if (localRedTypeInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch: redTypeInfo==null");
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    Object localObject2 = "";
    Object localObject1;
    try
    {
      i1 = Integer.valueOf(localRedTypeInfo.red_content.get()).intValue();
      if (i1 <= 99) {
        break label221;
      }
      localObject1 = "99+";
    }
    catch (Exception localException4)
    {
      try
      {
        do
        {
          for (;;)
          {
            int i1;
            bool = new JSONObject((String)localObject2).optBoolean("isOfficialNotify");
            if (QLog.isColorLevel()) {
              QLog.d("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch: redType=" + i1 + ", numStr=" + (String)localObject1 + ", desc=" + (String)localObject2);
            }
            if (((bool) || (i1 == 5)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
              break;
            }
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            return;
            localObject1 = String.valueOf(i1);
          }
          localException4 = localException4;
          localObject1 = localObject2;
        } while (!QLog.isColorLevel());
        QLog.e("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch exp=", localException4);
        localObject1 = localObject2;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          localException3.printStackTrace();
          bool = false;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject1 + ajyc.a(2131707188));
        l1 = 0L;
      }
    }
    i1 = localRedTypeInfo.red_type.get();
    localObject2 = localRedTypeInfo.red_desc.get();
    for (;;)
    {
      try
      {
        boolean bool;
        label221:
        localObject2 = new JSONObject((String)localObject2);
        localObject1 = ((JSONObject)localObject2).optString("faceUrl");
        long l2;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          l2 = ((JSONObject)localObject2).optLong("uin");
          l1 = l2;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!nam.a((String)localObject1))) {
            break label461;
          }
          localObject2 = getResources().getDrawable(2130839736);
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
          localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject1).setTag(bavi.a(1000, 1000));
          ((URLDrawable)localObject1).setDecodeHandler(bavi.o);
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
          atbp.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "exp_msg", 0);
          return;
        }
        catch (Exception localException2)
        {
          long l1;
          break label453;
        }
        localException1 = localException1;
        localObject1 = "";
      }
      label453:
      continue;
      label461:
      if (l1 > 0L)
      {
        localObject1 = String.valueOf(l1);
        this.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localObject1 = ((atfx)localObject3).a((String)localObject1, 1, true);
        if (localObject1 != null) {
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap((Bitmap)localObject1);
        } else {
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(getResources().getDrawable(2130839736));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(getResources().getDrawable(2130839736));
      }
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Bfol != null) && (this.jdField_a_of_type_Bfol.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bfol = bfol.c(getActivity());
    this.jdField_a_of_type_Bfol.b(2131698810);
    this.jdField_a_of_type_Bfol.b(2131698772);
    this.jdField_a_of_type_Bfol.c(2131690596);
    this.jdField_a_of_type_Bfol.a(new aqij(this));
    this.jdField_a_of_type_Bfol.a(new aqik(this));
    this.jdField_a_of_type_Bfol.show();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Aqip == null) {
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
        CustomWebView localCustomWebView = this.jdField_a_of_type_Aqip.getWebView();
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
    this.jdField_a_of_type_Asyz = b();
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
        atbp.a("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g) });
      }
    }
    super.onCreate(paramBundle);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g);
      if (QLog.isDevelopLevel()) {
        atbp.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i) });
      }
    }
    atbg.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), true);
    long l1 = System.currentTimeMillis();
    atbg.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "nearby_enter_time", Long.valueOf(l1));
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
        atbp.a("nearby.NearbyHybridFragment", new Object[] { "onCreateView", Long.valueOf(l1) });
      }
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      if (this.g) {
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
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559327, null);
        this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379381));
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout = ((OverCoverFrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371173));
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout.setOnActionListener(this.jdField_a_of_type_Atyn);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365714);
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365702));
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379386));
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362667);
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewView.findViewById(2131363045);
        if (("Meizu".equalsIgnoreCase(Build.BRAND)) && ("M040".equalsIgnoreCase(Build.MODEL)) && (paramLayoutInflater != null)) {
          paramLayoutInflater.setVisibility(8);
        }
        paramLayoutInflater = a();
        this.jdField_a_of_type_Aszo = new aszo(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.jdField_a_of_type_Aszo.a(paramLayoutInflater);
        this.jdField_a_of_type_Aszo.a(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373072));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373071));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373073));
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setDelayBeforeScrollBack(800L);
        this.jdField_a_of_type_Aqip.mWebview.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
        this.jdField_a_of_type_Aqip.mWebview.setOnScrollChangedListener(new aqib(this));
        paramLayoutInflater = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Aqip.mWebview, 0, paramLayoutInflater);
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyHybridFragment.webloading", 2, "webView add to container:" + (System.currentTimeMillis() - l2));
        }
        this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379390);
        paramLayoutInflater = (URLImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131372589);
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mPlayGifImage = true;
        paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable("https://qpic.url.cn/feeds_pic/ajNVdqHZLLAyBjp36ialuzyODWtr9VCdVQJo0JTrkib9eDlHdRtvS90g/", paramViewGroup));
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379388);
        this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131369537);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_f_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      this.jdField_a_of_type_Aqju.b(getString(2131694528)).a(false);
      k();
      this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(this.jdField_a_of_type_Xem);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j == 0L))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j = (System.currentTimeMillis() - l1);
        if (QLog.isDevelopLevel()) {
          atbp.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j) });
        }
      }
      if (this.g)
      {
        this.g = false;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.addObserver(this.jdField_a_of_type_Akbn);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_Atfy);
        this.jdField_a_of_type_Aszo.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        m();
        this.j = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      }
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_Akbn);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_Atfy);
    this.jdField_a_of_type_Aszo.b(null);
    this.jdField_a_of_type_Aqip.d();
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
    this.jdField_a_of_type_Aqip.c();
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
        this.jdField_a_of_type_Aqip.b();
        if (!bbev.g(getActivity())) {
          bcpw.a(getActivity(), 1, ajyc.a(2131707189), 0).b(getActivity().getTitleBarHeight());
        }
        if (this.jdField_a_of_type_Aszo != null) {
          this.jdField_a_of_type_Aszo.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
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
    this.jdField_a_of_type_Aqip.mWebview.callJs(str2, new String[] { str1 });
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
    String str = bfng.a(bfng.a(bfng.a(bfng.a(bfng.a(bfng.a(bfng.a(bfng.a(bfng.a(bfng.a(bfng.a(bfng.a(bfng.a("https://nearby.qq.com/people_filter/index.html", "_wwv", "4"), "sex", String.valueOf(this.jdField_a_of_type_Asyz.jdField_a_of_type_Int)), "time", String.valueOf(this.jdField_a_of_type_Asyz.jdField_b_of_type_Int)), "age", String.valueOf(this.jdField_a_of_type_Asyz.jdField_c_of_type_Int)), "interest", String.valueOf(this.jdField_a_of_type_Asyz.jdField_d_of_type_Int)), "profession", String.valueOf(this.jdField_a_of_type_Asyz.f)), "country", String.valueOf(this.jdField_a_of_type_Asyz.jdField_d_of_type_ArrayOfJavaLangString[0])), "strCountry", this.jdField_a_of_type_Asyz.jdField_b_of_type_JavaLangString), "province", String.valueOf(this.jdField_a_of_type_Asyz.jdField_d_of_type_ArrayOfJavaLangString[1])), "strProvince", this.jdField_a_of_type_Asyz.jdField_c_of_type_JavaLangString), "city", String.valueOf(this.jdField_a_of_type_Asyz.jdField_d_of_type_ArrayOfJavaLangString[2])), "strCity", this.jdField_a_of_type_Asyz.jdField_d_of_type_JavaLangString), "contellation", String.valueOf(this.jdField_a_of_type_Asyz.jdField_e_of_type_Int));
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
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, "hideWebLoadingView:" + this.n + ", timeCostFromLoad=" + (l1 - l2) + ", timeCostFromAttach=" + (l3 - l4));
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.n = true;
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
    int i1 = ((Integer)atbg.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    long l1 = (System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L;
    if (l1 <= 0L) {
      l1 = 1L;
    }
    for (;;)
    {
      axqw.b(null, "dc00899", "grp_lbs", "", "home", "home_exp", 0, 0, "", String.valueOf(i1), "", String.valueOf(l1));
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
      atfx localatfx = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
      Object localObject = localatfx.a(11);
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
        localObject = new atxz(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
        if (((atxz)localObject).a(str)) {
          ((atxz)localObject).show();
        }
        localatfx.a(58);
        axqw.b(null, "dc00899", "grp_lbs", "", "entry", "pop_clk_red", 0, 0, String.valueOf(((Integer)atbg.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue()), "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment
 * JD-Core Version:    0.7.0.1
 */