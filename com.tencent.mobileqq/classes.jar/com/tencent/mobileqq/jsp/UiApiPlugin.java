package com.tencent.mobileqq.jsp;

import actn;
import ajsf;
import ajyc;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anql;
import anvl;
import aqbc;
import arnv;
import arnz;
import aroa;
import arob;
import aroc;
import arod;
import aroe;
import arof;
import aroh;
import aroi;
import aroj;
import arok;
import arol;
import arom;
import aron;
import aroo;
import aroq;
import aukn;
import auko;
import awvy;
import axqw;
import axrl;
import ayfv;
import ayog;
import balg;
import bawz;
import bbca;
import bbdh;
import bbdj;
import bbdr;
import bbio;
import bbjn;
import bbmo;
import bbmr;
import bbwg;
import bbwi;
import bbwl;
import bcbv;
import bcci;
import bcdb;
import bcfj;
import bcfm;
import bcgc;
import bchk;
import bchl;
import bchn;
import bchq;
import bchr;
import bchu;
import bcpw;
import bdhv;
import bfol;
import bfoq;
import bfos;
import bfot;
import bfuc;
import bfuf;
import bggu;
import bgij;
import bhvn;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidEntry;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneJumpQBrowserInterface;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.BaseActivity;
import mqq.app.NewIntent;
import mvv;
import mxh;
import nam;
import nax;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vel;
import vws;
import wim;
import wxu;
import xed;
import xlv;
import xmt;

public class UiApiPlugin
  extends WebViewPlugin
  implements DialogInterface.OnCancelListener, View.OnClickListener, bfoq, bfos, bfot
{
  public static volatile BroadcastReceiver a;
  public static ResultReceiver a;
  public static CopyOnWriteArrayList<WeakReference<UiApiPlugin>> a;
  public static AtomicBoolean a;
  static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public static AtomicLong a;
  public static volatile BroadcastReceiver b;
  public static AtomicBoolean b;
  public static volatile BroadcastReceiver c;
  public static AtomicBoolean c;
  public int a;
  public ProgressDialog a;
  public View a;
  public ImageView a;
  public anql a;
  public bfol a;
  bfuc jdField_a_of_type_Bfuc = null;
  public RefreshView a;
  public MiniMsgUser a;
  public String a;
  WeakReference<UiApiPlugin> jdField_a_of_type_JavaLangRefWeakReference = null;
  public wxu a;
  public xed a;
  public boolean a;
  int b;
  protected ProgressDialog b;
  public View b;
  public ImageView b;
  public String b;
  public boolean b;
  public int c;
  public ImageView c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  protected String e;
  public boolean e;
  public String f;
  public boolean f;
  public String g;
  public boolean g;
  public String h;
  public boolean h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  }
  
  public UiApiPlugin()
  {
    this.jdField_a_of_type_Wxu = null;
    this.jdField_a_of_type_Anql = new arnv(this);
    this.jdField_c_of_type_Int = -1;
    this.mPluginNameSpace = "ui";
  }
  
  static int a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      n = paramJSONObject.getInt(paramString);
      return n;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        int n = Color.parseColor(paramJSONObject.getString(paramString));
        return n;
      }
      catch (Exception paramJSONObject) {}
    }
    return 0;
  }
  
  public static Intent a(Context paramContext, Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    paramMap = new Intent("android.intent.action.MAIN");
    paramMap.setClassName(paramContext, ShortcutGuideActivity.class.getName());
    paramMap.addCategory("android.intent.category.LAUNCHER");
    paramMap.putExtra("from", paramString2);
    paramMap.putExtra("url", paramString1);
    return paramMap;
  }
  
  private IMiniMsgUnreadCallback a()
  {
    return new aroo(this);
  }
  
  private MiniMsgUser.IMiniMsgActionCallback a()
  {
    return new aroq(this);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramString1);
      if (paramString2 != null) {
        localJSONObject.put("resultData", paramString2);
      }
      if (paramString3 != null) {
        localJSONObject.put("message", paramString3);
      }
      if (paramString4 != null) {
        localJSONObject.put("extras", paramString4);
      }
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "getCallBackResult json error!");
      }
    }
    return "{\"result\":\"-1\",\"message\":\"getCallBackResult json error!\"}";
  }
  
  public static String a(xlv paramxlv)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramxlv != null) {}
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type", "init");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isShowBottomBar", paramxlv.jdField_a_of_type_Boolean);
      localJSONObject.put("barHeight", paramxlv.jdField_a_of_type_Int);
      ((JSONObject)localObject1).put("data", localJSONObject);
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    catch (JSONException paramxlv)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.d("UiApiPlugin", 2, "getSetBottomBarCallBackResult json error!");
    }
    return null;
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, long paramLong, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfString.length;
    if ((i1 == 0) || (i1 != paramArrayOfInt.length) || (paramLong == -1L))
    {
      paramActivity.setResult(-1, new Intent().putExtra("ret", 4));
      paramActivity.finish();
      return;
    }
    GetOpenidProto.GetOpenidReq localGetOpenidReq = new GetOpenidProto.GetOpenidReq();
    localGetOpenidReq.appid.set(paramLong);
    int n = 0;
    if (n < i1)
    {
      GetOpenidProto.GetOpenidEntry localGetOpenidEntry = new GetOpenidProto.GetOpenidEntry();
      for (;;)
      {
        int i2;
        try
        {
          localGetOpenidEntry.id.set(Long.parseLong(paramArrayOfString[n], 10));
          i2 = paramArrayOfInt[n];
          if (i2 == 0)
          {
            localGetOpenidEntry.type.set(0);
            localGetOpenidReq.list.add(localGetOpenidEntry);
            n += 1;
          }
        }
        catch (NumberFormatException paramAppInterface)
        {
          paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin error"));
          paramActivity.finish();
          return;
        }
        if (i2 == 1)
        {
          localGetOpenidEntry.type.set(1);
        }
        else
        {
          if (i2 != 3000) {
            break label215;
          }
          localGetOpenidEntry.type.set(2);
        }
      }
      label215:
      paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin type error"));
      paramActivity.finish();
      return;
    }
    paramArrayOfString = new NewIntent(BaseApplicationImpl.getContext(), mxh.class);
    paramArrayOfString.setWithouLogin(true);
    paramArrayOfString.putExtra("cmd", "CommCompSvr.get_openid");
    paramArrayOfString.putExtra("data", localGetOpenidReq.toByteArray());
    paramArrayOfString.setObserver(new arnz(paramActivity));
    paramAppInterface.startServlet(paramArrayOfString);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (bbio.a(paramActivity, new String[] { paramString1 }))
    {
      bcpw.a(paramActivity, 2131692214, 0).b(paramActivity.getResources().getDimensionPixelSize(2131298865));
      paramActivity = a("-4", null, "createShortcut exsit!", paramString3);
      axqw.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -2, "", "", "", "");
      callJs(paramString5, new String[] { paramActivity });
      return;
    }
    ThreadManagerV2.excute(new UiApiPlugin.22(this, paramActivity, paramString4, paramString1, paramString2, paramString3, paramString5), 128, null, true);
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.remove("openWithWebBundle");
      paramBundle.remove("real_url");
      paramBundle.remove("preload_url");
      paramBundle.remove("bundle_data");
    }
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    label168:
    label181:
    label373:
    for (;;)
    {
      int n;
      try
      {
        paramString2 = BitmapFactory.decodeResource(paramContext.getResources(), 2130840058);
        if (paramString2 == null) {
          break label373;
        }
        n = bbdh.a(paramContext);
        if (n == paramString2.getWidth()) {
          break label373;
        }
        if (bbmr.jdField_c_of_type_Boolean) {
          break label168;
        }
        paramString2 = bbmo.a().a(paramString2, n);
        if (paramString2 != null) {
          break label181;
        }
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "createShortcut.failed, icon is null.");
        }
        return false;
      }
      catch (OutOfMemoryError paramString2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString2));
        }
        paramString2 = null;
        continue;
      }
      try
      {
        paramString2 = nam.a(paramContext, paramString2, "GET", null, null);
        if (paramString2 == null) {
          return false;
        }
      }
      catch (IOException paramString2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString2));
          }
          paramString2 = null;
        }
        try
        {
          paramString2 = BitmapFactory.decodeByteArray(paramString2, 0, paramString2.length);
        }
        catch (OutOfMemoryError paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString2));
          }
          paramString2 = null;
        }
      }
      continue;
      paramString2 = Bitmap.createScaledBitmap(paramString2, n, n, false);
      continue;
      bbmo.a().a(paramIntent);
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = (ShortcutManager)paramContext.getSystemService("shortcut");
        if ((localObject != null) && (((ShortcutManager)localObject).isRequestPinShortcutSupported()))
        {
          paramContext = new ShortcutInfo.Builder(paramContext, "QQ" + paramString1).setIcon(Icon.createWithBitmap(paramString2)).setShortLabel(paramString1).setIntent(paramIntent).build();
          try
          {
            ((ShortcutManager)localObject).requestPinShortcut(paramContext, null);
            return true;
          }
          catch (Exception paramContext)
          {
            QLog.i("UiApiPlugin", 1, "requestPinShortcut exception", paramContext);
            return false;
          }
        }
      }
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
      ((Intent)localObject).putExtra("android.intent.extra.shortcut.NAME", paramString1);
      ((Intent)localObject).putExtra("android.intent.extra.shortcut.ICON", paramString2);
      ((Intent)localObject).putExtra("duplicate", false);
      ((Intent)localObject).setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      paramContext.sendOrderedBroadcast((Intent)localObject, null);
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "createShortcut.finish.");
      }
      return true;
    }
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "unRegisterReceiver");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if ((jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver);
      jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if ((jdField_c_of_type_AndroidContentBroadcastReceiver != null) && (jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(jdField_c_of_type_AndroidContentBroadcastReceiver);
      jdField_c_of_type_AndroidContentBroadcastReceiver = null;
    }
    if ((jdField_b_of_type_AndroidContentBroadcastReceiver != null) && (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(jdField_b_of_type_AndroidContentBroadcastReceiver);
      jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void g()
  {
    jdField_c_of_type_AndroidContentBroadcastReceiver = new aron(this);
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "initX5LogUploadReceiver!");
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("upload_x5_log");
      BaseApplicationImpl.getApplication().registerReceiver(jdField_c_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UiApiPlugin", 1, "register receiver error:" + localException.toString());
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      if ((this.jdField_a_of_type_Boolean) && (paramInt == 0)) {
        callJs(this.jdField_b_of_type_JavaLangString, new String[] { "2", Integer.toString(paramInt) });
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfol.dismiss();
      return;
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { "0", Integer.toString(paramInt) });
      continue;
      callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(paramInt));
    }
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    int n = -1;
    if ("1".equals(paramString)) {
      n = 2130843254;
    }
    do
    {
      return n;
      if ("2".equals(paramString)) {
        return 2130843253;
      }
      if ("3".equals(paramString)) {
        return 2130839757;
      }
      if ("4".equals(paramString)) {
        return 2130839111;
      }
      if ("5".equals(paramString)) {
        return 2130843299;
      }
      if ("7".equals(paramString))
      {
        if (paramBoolean) {
          return 2130842002;
        }
        return 2130842005;
      }
      if ("8".equals(paramString))
      {
        if (paramBoolean) {
          return 2130849062;
        }
        return 2130849066;
      }
      if ("9".equals(paramString)) {
        return 2130838579;
      }
      if ("10".equals(paramString)) {
        return 2130849201;
      }
      if ("11".equals(paramString)) {
        return 2130849200;
      }
      if ("14".equals(paramString)) {
        return 2130849140;
      }
    } while (!"15".equals(paramString));
    return 2130849141;
  }
  
  public Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public bchq a()
  {
    bcci localbcci = this.mRuntime.a(this.mRuntime.a());
    if ((localbcci != null) && ((localbcci instanceof bchq))) {
      return (bchq)localbcci;
    }
    return null;
  }
  
  public bchu a()
  {
    bcci localbcci = this.mRuntime.a(this.mRuntime.a());
    if ((localbcci != null) && ((localbcci instanceof bchu))) {
      return (bchu)localbcci;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      Drawable localDrawable = this.jdField_c_of_type_AndroidWidgetImageView.getDrawable();
      if (localDrawable != null)
      {
        localDrawable = bbdr.a(localDrawable, paramInt);
        if (localDrawable != null) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject = null;
    arob localarob = null;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Activity localActivity = this.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    RelativeLayout localRelativeLayout;
    label200:
    do
    {
      do
      {
        return;
        localRelativeLayout = (RelativeLayout)localActivity.findViewById(2131375327);
        switch (paramInt)
        {
        }
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
            break label200;
          }
          if (paramBoolean2) {
            break;
          }
          localRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
          this.jdField_a_of_type_AndroidWidgetImageView = null;
          this.jdField_b_of_type_AndroidWidgetImageView = null;
          return;
          Drawable localDrawable = localActivity.getResources().getDrawable(2130843975);
          localObject = localDrawable;
          if (!TextUtils.isEmpty(paramString))
          {
            localarob = new arob(this, paramString);
            localObject = localDrawable;
          }
        }
      } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
      if (paramBoolean1) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localarob);
        this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localActivity.getResources().getDrawable(2130849288));
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localarob);
      paramString = new RelativeLayout(localActivity);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      paramString.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(bawz.a(localBaseApplication, 8.0F), bawz.a(localBaseApplication, 8.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, bawz.a(localBaseApplication, 4.0F), bawz.a(localBaseApplication, 4.0F), 0);
      paramString.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(bawz.a(localBaseApplication, 36.0F), bawz.a(localBaseApplication, 36.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131375449);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, bawz.a(localBaseApplication, 4.0F), 0);
    } while (localRelativeLayout == null);
    localRelativeLayout.addView(paramString, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      if ("my_emoji_clk".equals(paramString2)) {
        if (("11".equals(paramString1)) && (paramActivity != null))
        {
          paramString2 = paramActivity.getIntent();
          Intent localIntent = new Intent(paramActivity, EmosmActivity.class);
          localIntent.putExtra("key_emojimall_detail_chat_type", paramString2.getIntExtra("key_emojimall_detail_chat_type", -1));
          localIntent.putExtra("key_emojimall_detail_chat_uin", paramString2.getStringExtra("key_emojimall_detail_chat_uin"));
          localIntent.putExtra("emojimall_src", paramString2.getIntExtra("emojimall_src", 1));
          paramActivity.startActivity(localIntent);
        }
      }
    }
    for (;;)
    {
      if ("10".equals(paramString1)) {
        axqw.b(null, "CliOper", "", "", "ep_mall", "Clk_ep_search", 0, 0, "", "", "", "");
      }
      return;
      QLog.e("UiApiPlugin", 1, "handleDoubleRightBtnClickEvent, my_emoji_clk, activity = null or iconid != my dressup");
      continue;
      callJs(paramString2, new String[] { "" });
      continue;
      QLog.e("UiApiPlugin", 1, "handleDoubleRightBtnClickEvent, callback null, iconId=" + paramString1);
    }
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    int n;
    label170:
    label177:
    label247:
    do
    {
      do
      {
        boolean bool;
        int i2;
        do
        {
          int i1;
          do
          {
            do
            {
              return;
              n = paramIntent.getIntExtra("mode", 0);
              bool = paramIntent.getBooleanExtra("exclude", false);
              i1 = paramIntent.getIntExtra("number", 0);
              i2 = paramIntent.getIntExtra("sender", 0);
              if (QLog.isColorLevel()) {
                if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
                  break label170;
                }
              }
              for (paramContext = this.jdField_a_of_type_JavaLangRefWeakReference.toString();; paramContext = "null")
              {
                QLog.d("UiApiPlugin", 2, String.format("plugin %s (mSequence: %d): onReceive , mode: %d, exclude: %b, number: %d, sender: %d", new Object[] { paramContext, Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(n), Boolean.valueOf(bool), Integer.valueOf(i1), Integer.valueOf(i2) }));
                paramContext = this.mRuntime.a();
                if ((paramContext == null) || (paramContext.isFinishing())) {
                  break;
                }
                if (i1 <= 0) {
                  break label247;
                }
                if (i2 != this.jdField_b_of_type_Int) {
                  break label177;
                }
                if (bool) {
                  break;
                }
                paramContext.finish();
                return;
              }
              if ((this.jdField_b_of_type_Int < i2 - i1) || (this.jdField_b_of_type_Int >= i2)) {
                break;
              }
            } while ((n != 0) && (n != 2));
            paramContext.finish();
            return;
          } while ((this.jdField_b_of_type_Int <= i2) || (this.jdField_b_of_type_Int > i1 + i2) || ((n != 0) && (n != 1)));
          paramContext.finish();
          return;
          if (i2 != this.jdField_b_of_type_Int) {
            break;
          }
        } while (bool);
        paramContext.finish();
        return;
        if (i2 <= this.jdField_b_of_type_Int) {
          break;
        }
      } while ((n != 0) && (n != 2));
      paramContext.finish();
      return;
    } while ((n != 0) && (n != 1));
    paramContext.finish();
  }
  
  protected void a(File paramFile)
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    Object localObject = paramFile.getAbsolutePath();
    paramFile = new Bundle();
    paramFile.putInt("forward_type", 1);
    paramFile.putString("forward_urldrawable_thumb_url", (String)localObject);
    paramFile.putString("forward_filepath", (String)localObject);
    paramFile.putString("forward_extra", (String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramFile);
    aqbc.a(localActivity, (Intent)localObject, 18);
  }
  
  public void a(String paramString)
  {
    int i2 = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    do
    {
      return;
      if (this.jdField_a_of_type_Bfol != null)
      {
        if (this.jdField_a_of_type_Bfol.isShowing()) {
          this.jdField_a_of_type_Bfol.dismiss();
        }
        if (paramString.equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_Bfol.show();
          return;
        }
      }
      localObject1 = this.mRuntime.a();
    } while (localObject1 == null);
    for (;;)
    {
      int i4;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject1 = bfol.a((Context)localObject1);
        Object localObject2 = localJSONObject.optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((bfol)localObject1).a((CharSequence)localObject2);
        }
        localObject2 = localJSONObject.optJSONArray("items");
        int i3 = localJSONObject.optInt("selected", -1);
        this.jdField_a_of_type_Boolean = false;
        String str = localJSONObject.optString("close");
        if (TextUtils.isEmpty(str)) {
          break label398;
        }
        this.jdField_a_of_type_Boolean = true;
        ((bfol)localObject1).a(str, 3);
        n = 1;
        i1 = n;
        if (localObject2 != null)
        {
          i1 = n;
          if (((JSONArray)localObject2).length() > 0)
          {
            i4 = ((JSONArray)localObject2).length();
            i1 = i2;
            if (i3 >= 0)
            {
              i1 = i2;
              if (i3 < i4)
              {
                i1 = 0;
                if (i1 >= i4) {
                  break label409;
                }
                str = ((JSONArray)localObject2).getString(i1);
                if (i1 != i3) {
                  break label403;
                }
                bool = true;
                ((bfol)localObject1).a(str, bool);
                i1 += 1;
                continue;
              }
            }
            if (i1 >= i4) {
              break label409;
            }
            ((bfol)localObject1).c(((JSONArray)localObject2).getString(i1));
            i1 += 1;
            continue;
          }
        }
        localObject2 = localJSONObject.optString("cancel");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((bfol)localObject1).d((CharSequence)localObject2);
        }
        ((bfol)localObject1).a(this);
        ((bfol)localObject1).a(this);
        ((bfol)localObject1).setOnCancelListener(this);
        ((bfol)localObject1).a(this);
        this.jdField_a_of_type_Bfol = ((bfol)localObject1);
        this.jdField_b_of_type_JavaLangString = localJSONObject.optString("onclick");
        this.jdField_a_of_type_Int = i1;
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Bfol.show();
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("UiApiPlugin", 2, "showActionSheet error:" + paramString.getMessage());
      return;
      label398:
      int n = 0;
      continue;
      label403:
      boolean bool = false;
      continue;
      label409:
      int i1 = n + i4;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).optString("rowKey");
      ((JSONObject)localObject2).optString("articleId");
      ((JSONObject)localObject2).optBoolean("isAccountDerelict");
      ((JSONObject)localObject2).optLong("publisherUin");
      String str1 = ((JSONObject)localObject2).optString("commentID");
      String str2 = ((JSONObject)localObject2).optString("subCommentID");
      String str3 = ((JSONObject)localObject2).optString("isAwesome");
      Object localObject1 = ((JSONObject)localObject2).optString("onCommentSend");
      String str4 = ((JSONObject)localObject2).optString("onCommentLike");
      String str5 = ((JSONObject)localObject2).optString("onCommentDelete");
      String str6 = ((JSONObject)localObject2).optString("onPanelClose");
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("rowKey", paramString);
      ((Bundle)localObject2).putString("commentId", str1);
      ((Bundle)localObject2).putString("subCommentId", str2);
      ((Bundle)localObject2).putString("isAwesome", str3);
      ((Bundle)localObject2).putString("onCommentSend", (String)localObject1);
      ((Bundle)localObject2).putString("onCommentLike", str4);
      ((Bundle)localObject2).putString("onCommentDelete", str5);
      ((Bundle)localObject2).putString("onPanelClose", str6);
      ((Bundle)localObject2).putInt("seq", paramInt);
      localObject1 = new AnchorData();
      ((AnchorData)localObject1).jdField_a_of_type_JavaLangString = str1;
      ((AnchorData)localObject1).jdField_b_of_type_JavaLangString = str2;
      ((AnchorData)localObject1).jdField_a_of_type_Boolean = "1".equals(str3);
      QLog.i("UiApiPlugin", 1, "anchorData commentId:" + str1 + " ,subCommentId :" + str2);
      ReadInJoyAtlasCommentFragment.a((Activity)this.mRuntime.a().getContext(), paramString, null, null, null, (AnchorData)localObject1, false, false, (Bundle)localObject2);
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString));
    }
  }
  
  protected final void a(String paramString1, String paramString2)
  {
    aukn localaukn = this.mRuntime.a().getEntityManagerFactory(this.mRuntime.a().getAccount()).createEntityManager();
    TroopInfo localTroopInfo = (TroopInfo)localaukn.a(TroopInfo.class, paramString1);
    localaukn.a();
    int n;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.mRuntime.a().getAccount())) {
        break label116;
      }
      n = 0;
    }
    for (;;)
    {
      axqw.b(null, "P_CliOper", "Grp_flower", "", "mber", paramString2, 0, 0, paramString1, n + "", "", "");
      return;
      label116:
      if (localTroopInfo.isAdmin()) {
        n = 1;
      } else {
        n = 2;
      }
    }
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", paramString);
      localJSONObject.put("options", paramJSONObject);
      callJs("javascript:mqq.dispatchEvent(\"miniAIOEvent\"," + localJSONObject.toString() + ");");
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("UiApiPlugin", 1, paramString, new Object[0]);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    Intent localIntent;
    Object localObject3;
    do
    {
      return;
      localIntent = localActivity.getIntent();
      localObject3 = this.mRuntime.a();
    } while (localObject3 == null);
    for (;;)
    {
      JSONObject localJSONObject2;
      String str3;
      JSONObject localJSONObject1;
      label131:
      boolean bool4;
      label245:
      int n;
      label522:
      try
      {
        localJSONObject2 = new JSONObject(paramString);
        str3 = localJSONObject2.optString("url");
        if (!paramBoolean) {
          break label576;
        }
        localJSONObject1 = localJSONObject2;
        if (localJSONObject1 == null) {
          break label2607;
        }
        paramString = localJSONObject1.optString("businessId");
      }
      catch (Exception paramString)
      {
        label371:
        QLog.e("UiApiPlugin", 1, "convert json exception", paramString);
        label396:
        return;
      }
      Object localObject1 = null;
      Object localObject2;
      if (localIntent != null)
      {
        localObject2 = localIntent.getStringExtra("big_brother_ref_source_key");
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localIntent.getStringExtra("big_brother_source_key");
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = paramString;
        bool4 = localJSONObject2.optBoolean("force_no_reload");
        if ((TextUtils.isEmpty(str3)) || (localJSONObject1 == null) || (!localJSONObject1.has("style"))) {
          break;
        }
        localObject2 = null;
        paramString = (String)localObject2;
        if (!localActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
        {
          paramString = (String)localObject2;
          if (!localActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity"))
          {
            paramString = (String)localObject2;
            if (!localJSONObject1.optBoolean("useNewConfig", false)) {
              paramString = localActivity.getIntent().getExtras();
            }
          }
        }
        if (paramString == null)
        {
          localObject2 = new Bundle();
          if (((Bundle)localObject2).containsKey("startOpenPageTime")) {
            ((Bundle)localObject2).putLong("startOpenPageTime", System.currentTimeMillis());
          }
          n = localJSONObject1.optInt("style");
          if ((str3.startsWith("https://y.qq.com/m/mqq/musicsearch/index.html")) && (str3.contains("entry=aio"))) {
            ((Bundle)localObject2).remove("hide_left_button");
          }
          if (!Boolean.valueOf(localJSONObject2.optBoolean("is_native", true)).booleanValue()) {
            break label2565;
          }
          PluginJumpManager.getInstance().updateConfig(this.mRuntime.a());
          PluginJumpManager.getInstance().loadConfig();
          if (!(localActivity instanceof BaseActivity)) {
            break label847;
          }
          if (PluginJumpManager.getInstance().openView(localActivity, str3, String.valueOf(n))) {
            break;
          }
          break label2565;
          switch (localJSONObject1.optInt("navigationBarStyle"))
          {
          case 1: 
            ((Bundle)localObject2).putBoolean("hide_title_left_arrow", localJSONObject1.optBoolean("hideLeftArrow", false));
            n = localJSONObject1.optInt("target");
            if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
            {
              paramString = new Intent(((BasePluginActivity)localActivity).getOutActivity(), QQBrowserActivity.class);
              paramString.putExtra("big_brother_source_key", str1);
              paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
              paramString.putExtras((Bundle)localObject2);
              paramString.putExtra("url", str3);
              paramString.setFlags(0);
              if (n == 1) {
                paramString.putExtra("articalChannelId", 0);
              }
              localActivity.startActivityForResult(paramString, 100);
              switch (localJSONObject1.optInt("animation"))
              {
              case 0: 
              case 1: 
                localActivity.overridePendingTransition(0, 0);
                return;
                label576:
                localJSONObject1 = localJSONObject2.optJSONObject("options");
              }
            }
            break;
          }
        }
      }
      label847:
      label2525:
      label2546:
      do
      {
        String str2;
        for (;;)
        {
          str1 = localIntent.getStringExtra("big_brother_source_key");
          break;
          paramString.remove("title");
          paramString.remove("leftViewText");
          paramString.remove("post_data");
          paramString.remove("options");
          paramString.remove("isOpeningQunApp");
          paramString.remove("isTransparentTitleAndClickable");
          a(paramString);
          boolean bool2 = false;
          boolean bool3 = false;
          try
          {
            localObject2 = Uri.parse(((WebView)localObject3).getUrl());
            boolean bool1 = bool3;
            paramBoolean = bool2;
            if (localObject2 != null)
            {
              bool1 = bool3;
              paramBoolean = bool2;
              if (((Uri)localObject2).isHierarchical())
              {
                paramBoolean = "1".equals(((Uri)localObject2).getQueryParameter("__iscomic"));
                bool1 = "1".equals(((Uri)localObject2).getQueryParameter("__useCampusNotice"));
              }
            }
            if ((paramBoolean) && (!bool1))
            {
              paramString.remove("uintype");
              QLog.d("UiApiPlugin", 1, "remove campus notice");
            }
            localObject2 = paramString;
            if (!paramString.containsKey("insertPluginsArray")) {
              break label245;
            }
            localObject3 = paramString.get("insertPluginsArray");
            localObject2 = paramString;
            if (!(localObject3 instanceof String[])) {
              break label245;
            }
            localObject3 = (String[])localObject3;
            n = 0;
            for (;;)
            {
              localObject2 = paramString;
              if (n >= localObject3.length) {
                break;
              }
              if ("gdtReportPlugin".equals(localObject3[n])) {
                localObject3[n] = null;
              }
              n += 1;
            }
          }
          catch (Exception localException)
          {
            QLog.e("UiApiPlugin", 1, "open url exception", localException);
            str2 = paramString;
          }
        }
        if (PluginJumpManager.getInstance().openView(localActivity, str3, String.valueOf(n)))
        {
          return;
          str2.putBoolean("hide_more_button", false);
          str2.putBoolean("hide_operation_bar", true);
          break label371;
          str2.putBoolean("hide_more_button", true);
          str2.putBoolean("hide_operation_bar", true);
          break label371;
          str2.putBoolean("hide_more_button", false);
          str2.putBoolean("hide_operation_bar", false);
          str2.putString("webStyle", "");
          break label371;
          str2.putBoolean("hide_more_button", true);
          str2.putBoolean("hide_operation_bar", false);
          str2.putString("webStyle", "");
          break label371;
          str2.putBoolean("hide_left_button", true);
          str2.putBoolean("show_right_close_button", true);
          break label371;
          str2.putBoolean("isTransparentTitleAndClickable", true);
          break label396;
          if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity"))
          {
            paramString = new Intent(localActivity, QQBrowserActivity.class);
            paramString.putExtra("big_brother_source_key", str1);
            paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
            paramString.putExtras(str2);
            paramString.putExtra("url", str3);
            paramString.setFlags(0);
            localActivity.startActivityForResult(paramString, 100);
            break label522;
          }
          if ((localActivity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.fragment.VipComicWebFragmentActivity")) || (localActivity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.media.VipComicMediaPlayActivity")))
          {
            paramString = new Intent();
            paramString.putExtra("big_brother_source_key", str1);
            paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
            str2.remove("activityNoTitle");
            paramString.putExtras(str2);
            paramString.putExtra("url", str3);
            paramString.setFlags(0);
            if (bggu.a(str3, paramString))
            {
              paramString.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
              localActivity.startActivityForResult(paramString, 100);
              break label522;
            }
            bggu.a(localActivity, paramString, 100);
            break label522;
          }
          if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQH5BrowserActivity"))
          {
            paramString = new Intent(localActivity, QQBrowserActivity.class);
            paramString.putExtra("big_brother_source_key", str1);
            paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
            paramString.putExtras(str2);
            paramString.putExtra("url", str3);
            paramString.setFlags(0);
            localActivity.startActivityForResult(paramString, 100);
            break label522;
          }
          if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity"))
          {
            paramString = new Intent(localActivity, QQBrowserActivity.class);
            paramString.putExtra("big_brother_source_key", str1);
            paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
            str2.remove("isFullScreen");
            str2.remove("isTransparentTitle");
            paramString.putExtras(str2);
            paramString.putExtra("url", str3);
            paramString.setFlags(0);
            localActivity.startActivityForResult(paramString, 100);
            break label522;
          }
          if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity"))
          {
            paramString = new Intent(localActivity, QQBrowserActivity.class);
            paramString.putExtra("big_brother_source_key", str1);
            paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
            paramString.putExtras(str2);
            paramString.putExtra("url", str3);
            localActivity.startActivityForResult(paramString, 100);
            break label522;
          }
          if (localActivity.getClass().getName().equalsIgnoreCase("cooperation.qwallet.plugin.QWalletPluginProxyActivity"))
          {
            paramString = new Intent(localActivity, QQBrowserActivity.class);
            paramString.putExtra("big_brother_source_key", str1);
            paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
            paramString.putExtras(str2);
            paramString.putExtra("url", str3);
            localActivity.startActivityForResult(paramString, 100);
            break label522;
          }
          if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.microapp.appbrand.ui.AppBrandUI"))
          {
            paramString = new Intent(localActivity, QQBrowserActivity.class);
            paramString.putExtra("big_brother_source_key", str1);
            paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
            paramString.putExtras(str2);
            paramString.putExtra("url", str3);
            localActivity.startActivityForResult(paramString, 100);
            break label522;
          }
          if ((localActivity.getClass().getName().equalsIgnoreCase("cooperation.qqreader.ui.ReaderContentPageActivity")) || (localActivity.getClass().getName().equalsIgnoreCase("com.qqreader.pureader.SSReaderActivity")) || (localActivity.getClass().getName().equalsIgnoreCase("cooperation.qqreader.shadow.ReaderSingleTaskProxyActivity"))) {
            if (!(localActivity instanceof BasePluginActivity)) {
              break label2546;
            }
          }
          for (paramString = ((BasePluginActivity)localActivity).getOutActivity();; paramString = localActivity)
          {
            paramString = new Intent(paramString, QQBrowserActivity.class);
            paramString.putExtra("big_brother_source_key", str1);
            paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
            paramString.putExtras(str2);
            paramString.putExtra("url", str3);
            paramString.setFlags(0);
            if (n == 1) {
              paramString.putExtra("articalChannelId", 0);
            }
            localActivity.startActivityForResult(paramString, 100);
            break;
            if (localActivity.getClass().getName().equalsIgnoreCase("cooperation.liveroom.LiveRoomProxyActivity"))
            {
              paramString = new Intent(localActivity, QQBrowserActivity.class);
              paramString.putExtra("big_brother_source_key", str1);
              paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
              paramString.putExtras(str2);
              paramString.putExtra("url", str3);
              localActivity.startActivityForResult(paramString, 100);
              break;
            }
            if ((localActivity instanceof NearbyActivity))
            {
              paramString = new Intent(localActivity, QQBrowserActivity.class);
              paramString.putExtra("big_brother_source_key", str1);
              paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
              paramString.putExtras(str2);
              paramString.putExtra("url", str3);
              localActivity.startActivityForResult(paramString, 100);
              break;
            }
            str2.remove("BusinessFeedData");
            if (localJSONObject1.optBoolean("useApolloBrowser", false))
            {
              ApolloUtil.a(localActivity, null, "other", str3, this.mRuntime.a());
              return;
            }
            if (((localActivity instanceof ApolloFloatActivity)) || ((localActivity instanceof ApolloGameActivity)) || (localJSONObject1.optBoolean("useQQBrowser", false)))
            {
              paramString = new Intent(localActivity, QQBrowserActivity.class);
              paramString.putExtra("big_brother_source_key", "biz_src_zf_lmx");
            }
            for (;;)
            {
              if (ayfv.a(str3))
              {
                paramString = new Intent(localActivity, TeamWorkDocEditBrowserActivity.class);
                paramString.addFlags(603979776);
                paramString = TeamWorkDocEditBrowserActivity.a(paramString, str3, localActivity);
              }
              if (localJSONObject1.optBoolean("isOpeningQunApp"))
              {
                str2.putBoolean("isOpeningQunApp", localJSONObject1.optBoolean("isOpeningQunApp"));
                str2.putInt("appid", localJSONObject1.optInt("appid"));
                localJSONObject2 = localJSONObject1.optJSONObject("extraParams");
                if (localJSONObject2 != null)
                {
                  str2.putString("extraParams", localJSONObject2.toString());
                  str2.putInt("troopid", localJSONObject2.optInt("gc"));
                }
              }
              paramString.putExtra("force_no_reload", bool4);
              paramString.putExtra("startOpenPageTime", System.currentTimeMillis());
              paramString.putExtras(str2);
              paramString.putExtra("big_brother_source_key", str1);
              paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
              paramString.putExtra("url", str3);
              paramString.setFlags(0);
              if (n == 1) {
                paramString.putExtra("articalChannelId", 0);
              }
              if (!bggu.a(str3, paramString)) {
                break label2525;
              }
              paramString.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
              bgij.a(localActivity, paramString, "com.qqcomic.activity.media.VipComicMediaPlayActivity", null);
              break;
              if ((localActivity instanceof QzoneJumpQBrowserInterface))
              {
                paramString = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
              }
              else if ((localActivity instanceof EcshopWebActivity))
              {
                paramString = new Intent(localActivity, BusinessBrowser.class);
                paramString.putExtra("jump_from", 2);
              }
              else if ((localActivity instanceof ReadInJoyArticleDetailActivity))
              {
                paramString = new Intent(localActivity, ReadInJoyArticleDetailActivity.class);
                str2.remove("click_time");
                str2.remove("available_memory");
              }
              else if ((localActivity instanceof PublicFragmentActivityForTool))
              {
                paramString = new Intent(localActivity, QQBrowserActivity.class);
              }
              else if (localJSONObject1.optBoolean("QzoneUseQQBrowser", false))
              {
                paramString = new Intent(localActivity, QQBrowserActivity.class);
                paramString.putExtra("big_brother_source_key", str1);
                str2.remove("isTransparentTitle");
                str2.remove("hide_more_button");
                str2.remove("hide_left_button");
              }
              else if ((localActivity instanceof SpringHbTranslucentBrowserActivity))
              {
                paramString = new Intent(localActivity, QQBrowserActivity.class);
                paramString.putExtra("big_brother_source_key", str1);
                paramString.putExtra("big_brother_ref_source_key", (String)localObject1);
                paramString.putExtras(str2);
                paramString.putExtra("url", str3);
              }
              else
              {
                paramString = new Intent(localActivity, localActivity.getClass());
                paramString.putExtra("big_brother_source_key", str1);
              }
            }
            localActivity.startActivityForResult(paramString, 100);
            break;
            localActivity.overridePendingTransition(2130772278, 0);
            return;
          }
          break label131;
        }
        for (;;)
        {
          if (paramString == null) {
            break label2612;
          }
          str1 = paramString;
          break;
          switch (n)
          {
          }
          break label371;
          break label396;
          return;
          paramString = null;
        }
      } while (localIntent != null);
      label2565:
      label2607:
      label2612:
      String str1 = null;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      a(paramJSONObject, null, new aroc(this, paramJSONObject));
    }
  }
  
  public void a(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    if (paramJSONObject != null) {
      a(paramJSONObject, paramJsBridgeListener, null);
    }
  }
  
  public void a(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    int n;
    String str1;
    String str2;
    String str3;
    boolean bool2;
    int i1;
    label148:
    do
    {
      return;
      n = paramJSONObject.optInt("iconID");
      str1 = paramJSONObject.optString("title");
      str2 = paramJSONObject.optString("callback");
      str3 = paramJSONObject.optString("color");
      bool2 = paramJSONObject.optBoolean("hidden");
      i1 = paramJSONObject.optInt("cornerID");
      if ((localActivity instanceof AbsBaseWebViewActivity))
      {
        int i2 = paramJSONObject.optInt("navIconUseDefault", -1);
        if (i2 >= 0)
        {
          paramJSONObject = (bcfj)super.getBrowserComponent(2);
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.jdField_a_of_type_Bcfm;
            if (1 != i2) {
              break label148;
            }
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          paramJSONObject.z = bool1;
          ((AbsBaseWebViewActivity)localActivity).a(str2, str1, str3, bool2, n, i1, paramJsBridgeListener, paramOnClickListener);
          return;
        }
      }
      paramJSONObject = this.mRuntime.a(this.mRuntime.a());
      if ((paramJSONObject != null) && ((paramJSONObject instanceof bchu)))
      {
        ((bchu)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener, null);
        return;
      }
      if ((paramJSONObject != null) && ((paramJSONObject instanceof bchk)))
      {
        ((bchk)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener);
        return;
      }
      if ((paramJSONObject != null) && ((paramJSONObject instanceof bchl)))
      {
        ((bchl)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener);
        return;
      }
    } while ((paramJSONObject == null) || (!(paramJSONObject instanceof bchn)));
    ((bchn)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener, this.mRuntime.a().hashCode());
  }
  
  public void a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    String str1 = paramJSONObject.optString("callback");
    if (paramString == null)
    {
      paramJSONObject = new JSONObject();
      try
      {
        paramJSONObject.put("code", paramInt);
        callJs(str1, new String[] { paramJSONObject.toString() });
        return;
      }
      catch (JSONException paramJSONObject)
      {
        callJs(str1, new String[] { "{\"code\":" + paramInt + "}" });
        return;
      }
    }
    String str2 = paramJSONObject.optString("text");
    Object localObject = paramJSONObject.optString("textColor");
    paramInt = paramJSONObject.optInt("x");
    int n = paramJSONObject.optInt("y");
    Rect localRect = new Rect(paramInt, n, paramJSONObject.optInt("width") + paramInt, paramJSONObject.optInt("height") + n);
    paramJSONObject = (JSONObject)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject = "#FF000000";
    }
    localObject = new ArrayList(1);
    ((ArrayList)localObject).add(str2);
    awvy.a(this.mRuntime.a(), paramString, str2, (List)localObject, paramJSONObject, localRect, new arol(this, str1));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_g_of_type_Boolean) {}
    do
    {
      return;
      if (!paramBoolean) {
        break label241;
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        break;
      }
      localObject3 = BaseApplicationImpl.getContext();
      localObject2 = this.mRuntime.a();
    } while ((localObject2 == null) || (((Activity)localObject2).isFinishing()));
    Object localObject1 = new TextView((Context)localObject2);
    ((TextView)localObject1).setText(2131690832);
    ((TextView)localObject1).setBackgroundResource(2130849546);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setMaxWidth(bawz.a((Context)localObject3, 100.0F));
    ((TextView)localObject1).setMinWidth(bawz.a((Context)localObject3, 52.0F));
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setTextColor(((Context)localObject3).getResources().getColor(2131166848));
    ((TextView)localObject1).setTextSize(1, 17.0F);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, bawz.a((Context)localObject3, 36.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131375449);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((TextView)localObject1).setOnClickListener(this);
    Object localObject2 = (RelativeLayout)((Activity)localObject2).findViewById(2131375327);
    if (localObject2 != null) {
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    }
    this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
    label197:
    for (this.jdField_g_of_type_Boolean = true;; this.jdField_g_of_type_Boolean = false)
    {
      localObject1 = this.mRuntime.a();
      if ((localObject1 == null) || (((WebViewFragment)localObject1).jdField_a_of_type_Bcbv == null)) {
        break;
      }
      ((WebViewFragment)localObject1).jdField_a_of_type_Bcbv.e(paramBoolean);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break label197;
      label241:
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    View localView;
    do
    {
      return;
      localView = ((Activity)localObject).findViewById(2131375327);
    } while (localView == null);
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (int n = ImmersiveUtils.getStatusBarHeight((Context)localObject) + 0;; n = 0)
    {
      localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      n += localView.getMeasuredHeight();
      if ((!this.jdField_d_of_type_Boolean) && (paramBoolean))
      {
        localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -n);
        ((TranslateAnimation)localObject).setDuration(paramInt);
        ((TranslateAnimation)localObject).setInterpolator(new LinearInterpolator());
        ((TranslateAnimation)localObject).setFillAfter(true);
        ((TranslateAnimation)localObject).setAnimationListener(new aroh(this, localView, localView.getTop() - n, localView.getBottom() - n));
        localView.startAnimation((Animation)localObject);
        this.jdField_d_of_type_Boolean = true;
        return;
      }
      if ((!this.jdField_d_of_type_Boolean) || (paramBoolean)) {
        break;
      }
      localObject = new TranslateAnimation(0.0F, 0.0F, -n, 0.0F);
      ((TranslateAnimation)localObject).setDuration(paramInt);
      ((TranslateAnimation)localObject).setInterpolator(new LinearInterpolator());
      ((TranslateAnimation)localObject).setFillAfter(true);
      ((TranslateAnimation)localObject).setAnimationListener(new aroi(this, localView, localView.getTop() + n, n + localView.getBottom()));
      localView.setVisibility(0);
      localView.startAnimation((Animation)localObject);
      this.jdField_d_of_type_Boolean = false;
      return;
    }
  }
  
  void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localObject == null) || (localActivity == null) || (localActivity.isFinishing())) {
      callJs4OpenApiIfNeeded("setPullDown", -100, "recode_failed_native_error");
    }
    do
    {
      return;
      localObject = (View)((WebView)localObject).getParent();
    } while (!(localObject instanceof RefreshView));
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)localObject);
    this.jdField_h_of_type_Boolean = false;
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView = localActivity.findViewById(2131363422);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Xed = this.jdField_a_of_type_ComTencentBizUiRefreshView.jdField_a_of_type_Xed;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Xed.setHeaderBgColor(-16777216);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setBackgroundColor(-16777216);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(new aroa(this));
        callJs4OpenApiIfNeeded("setPullDown", 0, "[]");
        return;
        this.jdField_a_of_type_Xed.setHeaderBgColor(paramInt1);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setBackgroundColor(paramInt2);
      }
    }
    callJs4OpenApiIfNeeded("setPullDown", 0, "already initPullDown");
  }
  
  protected void a(byte[] paramArrayOfByte, String paramString)
  {
    paramString = ajsf.aW + "diskcache/Image_" + paramString;
    bbdj.a(paramArrayOfByte, paramString);
    a(new File(paramString));
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      do
      {
        return false;
        if (paramString2.equals("g_appstore_myapp"))
        {
          QLog.d("UiApiPlugin", 1, "open troopApp manager error,TroopProxyActivity已在725下架");
          return true;
        }
      } while ((TextUtils.isEmpty(paramString1)) || (!paramString1.matches("\\d+")));
      if (paramString2.equals("g_flower"))
      {
        startActivityForResult(balg.a(this.mRuntime.a(), paramString1, "web"), (byte)10);
        a(paramString1, "exp");
        return true;
      }
      if (paramString2.equals("g_proceeding")) {
        return true;
      }
      if (paramString2.equals("g_homework"))
      {
        if (this.jdField_a_of_type_Wxu == null)
        {
          this.jdField_a_of_type_Wxu = wxu.a();
          this.jdField_a_of_type_Wxu.a();
        }
        this.jdField_a_of_type_Wxu.a(paramString1, paramString2);
        return true;
      }
      if (paramString2.equals("g_org"))
      {
        paramString1 = "mqqapi://group/openOrg?troopUin=" + paramString1;
        paramString2 = new Intent();
        paramString2.setData(Uri.parse(paramString1));
        paramString2.setAction("android.intent.action.VIEW");
        this.mRuntime.a().startActivity(paramString2);
        return true;
      }
      if (paramString2.equals("g_troop_reward"))
      {
        if (this.jdField_a_of_type_Wxu == null)
        {
          this.jdField_a_of_type_Wxu = wxu.a();
          this.jdField_a_of_type_Wxu.a();
        }
        this.jdField_a_of_type_Wxu.a(paramString1, paramString2);
        return true;
      }
      if (paramString2.equals("g_background"))
      {
        if (bbjn.q(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin())) {
          TroopPicEffectsEditActivity.a(this.mRuntime.a(), paramString1, paramString1);
        }
        for (;;)
        {
          return true;
          bbjn.z(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin());
          paramString2 = new Intent(this.mRuntime.a(), TroopPicEffectGuidePicActivity.class);
          paramString2.putExtra("friendUin", paramString1);
          paramString2.putExtra("troopUin", paramString1);
          paramString2.putExtra("isFromTroopApp", true);
          this.mRuntime.a().startActivity(paramString2);
        }
      }
    } while ((TextUtils.isEmpty(paramString3)) || (!paramString3.startsWith("mqqapi://groupopenapp/openapp")));
    if ("group_story".equals(paramString2))
    {
      paramString1 = vws.a(null, paramString3, null);
      vel.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      paramString2 = new Intent(this.mRuntime.a(), JumpActivity.class);
      paramString2.setData(Uri.parse(paramString1));
      this.mRuntime.a().startActivity(paramString2);
      return true;
      paramString1 = paramString3;
      if ("group_album".equals(paramString2)) {
        paramString1 = paramString3.replace("$UNREADNUM$", "1");
      }
    }
  }
  
  public void ak_()
  {
    Object localObject = this.mRuntime.a();
    if ((localObject instanceof PublicFragmentActivity))
    {
      localObject = ((PublicFragmentActivity)localObject).a();
      if ((localObject instanceof TribeVideoListPlayerFragment)) {
        ((TribeVideoListPlayerFragment)localObject).a(this.jdField_a_of_type_Bfol);
      }
    }
  }
  
  void b()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentBizUiRefreshView != null) {
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(null);
      }
    }
  }
  
  public void b(int paramInt)
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = paramInt;
    localMiniMsgUserParam.accessType = 3;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.isNeedBackConversation = true;
    localMiniMsgUserParam.unreadCallback = a();
    localMiniMsgUserParam.actionCallback = a();
    this.mRuntime.a();
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "mini_msg uiApiPlugin initMiniMsgUser = ");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(this.mRuntime.a(), localMiniMsgUserParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
  }
  
  public void b(String paramString)
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
    if ((localObject != null) && ((localObject instanceof bchr)))
    {
      localObject = ((bchr)localObject).a();
      Bundle localBundle = new Bundle();
      localBundle.putString("title", ((xmt)localObject).b());
      localBundle.putString("desc", ((xmt)localObject).c());
      localBundle.putString("detail_url", ((xmt)localObject).a());
      localBundle.putString("cover_url", ((xmt)localObject).e());
      localBundle.putInt("article_id", ((xmt)localObject).a());
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(((xmt)localObject).d());
      localBundle.putStringArrayList("image_url", localArrayList);
      localBundle.putString("source_name", ((xmt)localObject).f());
      if (a() != null)
      {
        if (!bhvn.a(this.mRuntime.a(), a(), localBundle, null, 0)) {
          break label189;
        }
        if (!TextUtils.isEmpty(paramString)) {
          callJs(paramString, new String[] { "true" });
        }
      }
    }
    return;
    label189:
    if (!TextUtils.isEmpty(paramString)) {
      callJs(paramString, new String[] { "false" });
    }
    wim.a(1, 2131689512);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "showPopupMenu: context is null");
      }
    }
    Object localObject1;
    float f1;
    JSONArray localJSONArray;
    for (;;)
    {
      return;
      localObject1 = this.mRuntime.a(this.mRuntime.a());
      if ((localObject1 != null) && ((localObject1 instanceof bchu))) {
        localObject1 = ((bchu)localObject1).a();
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("UiApiPlugin", 2, "showPopupMenu: Can not get TitleBar");
          return;
          if ((localObject1 != null) && ((localObject1 instanceof bchk)))
          {
            localObject1 = ((bchk)localObject1).a();
          }
          else if ((localObject1 != null) && ((localObject1 instanceof bchn)))
          {
            localObject1 = ((bchn)localObject1).a(this.mRuntime.a().hashCode());
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("UiApiPlugin", 2, "showPopupMenu: activity has not implement WebUiMethodInterface");
            return;
          }
        }
      }
      f1 = localActivity.getResources().getDisplayMetrics().density;
      if (this.jdField_a_of_type_Bfuc != null)
      {
        if (!this.jdField_a_of_type_Bfuc.isShowing()) {
          this.jdField_a_of_type_Bfuc.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131298619) - localActivity.getResources().getDimensionPixelSize(2131298615), localActivity.getResources().getDimensionPixelSize(2131298616));
        }
      }
      else
      {
        Drawable localDrawable = localActivity.getResources().getDrawable(2130839237);
        try
        {
          localJSONArray = paramJSONObject.optJSONArray("list");
          if (localJSONArray == null)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("UiApiPlugin", 2, "showPopupMenu: list is null");
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("UiApiPlugin", 2, "showPopupMenu Exception: " + localException.getMessage());
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfuc = bfuc.a(localActivity, localArrayList, new arod(this, paramJSONObject, localActivity));
      this.jdField_a_of_type_Bfuc.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131298619) - localActivity.getResources().getDimensionPixelSize(2131298615), localActivity.getResources().getDimensionPixelSize(2131298616));
      return;
      int n = 0;
      while (n < localJSONArray.length())
      {
        Object localObject2 = localJSONArray.optJSONObject(n);
        bfuf localbfuf = new bfuf();
        localbfuf.jdField_a_of_type_Int = Integer.parseInt(((JSONObject)localObject2).optString("id"));
        localbfuf.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("itemContent");
        localbfuf.jdField_c_of_type_JavaLangString = localbfuf.jdField_a_of_type_JavaLangString;
        localbfuf.jdField_b_of_type_Int = 2130849668;
        localObject2 = ((JSONObject)localObject2).optString("itemUrl");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((int)(71.0F * f1));
          localURLDrawableOptions.mRequestHeight = ((int)(94.0F * f1));
          localURLDrawableOptions.mLoadingDrawable = localException;
          localURLDrawableOptions.mFailedDrawable = localException;
          localbfuf.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        }
        localArrayList.add(localbfuf);
        n += 1;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bfuc.isShowing()) {
      this.jdField_a_of_type_Bfuc.dismiss();
    }
  }
  
  protected void c(String paramString)
  {
    Object localObject1 = this.mRuntime.a();
    if ((localObject1 == null) || (((Activity)localObject1).isFinishing())) {
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      bcpw.a(this.mRuntime.a().getApplication(), 1, ajyc.a(2131715847), 0).a();
      return;
    }
    if (this.jdField_b_of_type_AndroidAppProgressDialog == null)
    {
      this.jdField_b_of_type_AndroidAppProgressDialog = new ProgressDialog((Context)localObject1, 2131755791);
      this.jdField_b_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_b_of_type_AndroidAppProgressDialog.show();
      this.jdField_b_of_type_AndroidAppProgressDialog.setContentView(2131559386);
      ((TextView)this.jdField_b_of_type_AndroidAppProgressDialog.findViewById(2131371557)).setText(ajyc.a(2131715849));
    }
    for (;;)
    {
      localObject2 = new File(ayog.d(paramString));
      if (!((File)localObject2).exists()) {
        break;
      }
      this.jdField_b_of_type_AndroidAppProgressDialog.dismiss();
      a((File)localObject2);
      return;
      this.jdField_b_of_type_AndroidAppProgressDialog.show();
    }
    localObject1 = new Bundle();
    Object localObject2 = new bbwg(paramString, (File)localObject2);
    ((bbwg)localObject2).d = 60L;
    ((bbwi)this.mRuntime.a().getManager(47)).a(1).a((bbwg)localObject2, new aroj(this, paramString), (Bundle)localObject1);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    Object localObject3 = this.mRuntime.a();
    if ((localObject3 == null) || (((Activity)localObject3).isFinishing())) {}
    while (paramJSONObject == null) {
      return;
    }
    Object localObject2 = paramJSONObject.optString("title");
    bcci localbcci;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localbcci = this.mRuntime.a(this.mRuntime.a());
      if ((localbcci != null) && ((localbcci instanceof bchn))) {
        ((bchn)localbcci).a((String)localObject2, this.mRuntime.a().hashCode());
      }
    }
    else
    {
      label97:
      localObject2 = paramJSONObject.optString("callback");
    }
    for (;;)
    {
      try
      {
        if (this.mRuntime != null) {
          break label411;
        }
        paramJSONObject = null;
        if (paramJSONObject == null) {
          break;
        }
        localObject3 = paramJSONObject.getPluginEngine();
        paramJSONObject = paramJSONObject.getUrl();
        if ((localObject3 != null) && (!TextUtils.isEmpty(paramJSONObject)))
        {
          boolean bool = ((WebViewPluginEngine)localObject3).a().a(paramJSONObject, "ui.setLeftCloseHandler");
          if (bool) {
            this.jdField_e_of_type_JavaLangString = ((String)localObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, new Object[] { "setLeftCloseHandler url:", paramJSONObject, " hasRight:", Boolean.valueOf(bool) });
          }
        }
        localObject2 = new HashMap(2);
        if (paramJSONObject != null) {
          break label422;
        }
        paramJSONObject = (JSONObject)localObject1;
      }
      catch (Exception paramJSONObject)
      {
        label241:
        QLog.e("UiApiPlugin", 1, new Object[] { "e:", paramJSONObject.toString() });
        return;
      }
      ((HashMap)localObject2).put("host", localObject1);
      if (paramJSONObject == null)
      {
        paramJSONObject = "";
        ((HashMap)localObject2).put("path", paramJSONObject);
        axrl.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actWvCloseHandle", true, 0L, 0L, (HashMap)localObject2, null);
        return;
        if ((localbcci != null) && ((localbcci instanceof bchk)))
        {
          ((bchk)localbcci).a((String)localObject2);
          break label97;
        }
        if ((localbcci instanceof WebViewFragment))
        {
          if (bcgc.a()) {
            break label97;
          }
          localObject3 = (WebViewFragment)localbcci;
          if ((((WebViewFragment)localObject3).jdField_a_of_type_Bcbv == null) || (((WebViewFragment)localObject3).jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView == null)) {
            break label97;
          }
          ((WebViewFragment)localObject3).jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          break label97;
        }
        localObject3 = (TextView)((Activity)localObject3).findViewById(2131368429);
        if (localObject3 == null) {
          break label97;
        }
        ((TextView)localObject3).setText((CharSequence)localObject2);
        break label97;
        label411:
        paramJSONObject = this.mRuntime.a();
        continue;
        label422:
        paramJSONObject = Uri.parse(paramJSONObject);
      }
      while (paramJSONObject != null)
      {
        localObject1 = paramJSONObject.getHost();
        break;
        paramJSONObject = paramJSONObject.getPath();
        break label241;
      }
      localObject1 = "";
    }
  }
  
  void d()
  {
    jdField_a_of_type_AndroidContentBroadcastReceiver = new arom(this);
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "initExitWebViewReceiver!");
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE");
      BaseApplicationImpl.getApplication().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("UiApiPlugin", 1, "register receiver error:" + localException.toString());
      }
    }
  }
  
  protected void d(String paramString)
  {
    String str;
    try
    {
      paramString = new JSONObject(paramString);
      str = paramString.optString("imageData");
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = ajsf.aW + "diskcache/Image_" + bdhv.d(str);
        bbdj.a(bbca.decode(str, 0), (String)localObject1);
        a(paramString, (String)localObject1, 0);
        return;
      }
      str = paramString.optString("imageUrl");
      localObject1 = this.mRuntime.a();
      if ((localObject1 == null) || (((Activity)localObject1).isFinishing())) {
        return;
      }
      if (!AppNetConnInfo.isNetSupport())
      {
        a(paramString, null, -2);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("UiApiPlugin", 1, "mergeTextToImage exception e = ", paramString);
      return;
    }
    Object localObject2 = new File(ayog.d(str));
    if (((File)localObject2).exists())
    {
      a(paramString, ayog.d(str), 0);
      return;
    }
    Object localObject1 = new Bundle();
    localObject2 = new bbwg(str, (File)localObject2);
    ((bbwg)localObject2).d = 60L;
    ((bbwi)this.mRuntime.a().getManager(47)).a(1).a((bbwg)localObject2, new arok(this, str, paramString), (Bundle)localObject1);
  }
  
  public void d(JSONObject paramJSONObject)
  {
    Activity localActivity;
    WebViewFragment localWebViewFragment;
    String str1;
    String str2;
    String str3;
    Object localObject1;
    Object localObject2;
    boolean bool;
    if (paramJSONObject != null)
    {
      localActivity = this.mRuntime.a();
      localWebViewFragment = this.mRuntime.a();
      if (localWebViewFragment == null) {
        break label439;
      }
      str1 = paramJSONObject.optString("iconID1");
      paramJSONObject.optString("schemeType1");
      str2 = paramJSONObject.optString("_sharedCallbackID1");
      str3 = paramJSONObject.optString("voiceStr1");
      localObject1 = paramJSONObject.optString("iconID2");
      paramJSONObject.optString("schemeType2");
      localObject2 = paramJSONObject.optString("_sharedCallbackID2");
      String str4 = paramJSONObject.optString("voiceStr2");
      localWebViewFragment.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramJSONObject = (bcfj)super.getBrowserComponent(2);
      if ((paramJSONObject == null) || (!paramJSONObject.jdField_a_of_type_Bcfm.z) || ("1000".equals(ThemeUtil.getCurrentThemeId()))) {
        break label334;
      }
      bool = true;
      this.jdField_e_of_type_Int = a((String)localObject1, bool);
      if (paramJSONObject == null) {
        break label339;
      }
      paramJSONObject.a(localWebViewFragment.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView, false, this.jdField_e_of_type_Int, this.jdField_e_of_type_Int);
      label181:
      localWebViewFragment.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str4);
      localWebViewFragment.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aroe(this, localActivity, (String)localObject1, (String)localObject2));
      localObject1 = (RelativeLayout)localActivity.findViewById(2131375327);
      if (this.jdField_c_of_type_AndroidWidgetImageView == null) {
        break label357;
      }
      ((RelativeLayout)localObject1).removeView(this.jdField_c_of_type_AndroidWidgetImageView);
      label246:
      this.jdField_d_of_type_Int = a(str1, bool);
      if (paramJSONObject == null) {
        break label425;
      }
      paramJSONObject.a(this.jdField_c_of_type_AndroidWidgetImageView, false, this.jdField_d_of_type_Int, this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(str3);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new arof(this, localActivity, str1, str2));
      localWebViewFragment.jdField_a_of_type_Bcbv.e(false);
      ((RelativeLayout)localObject1).addView(this.jdField_c_of_type_AndroidWidgetImageView);
      return;
      label334:
      bool = false;
      break;
      label339:
      localWebViewFragment.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_e_of_type_Int);
      break label181;
      label357:
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131375449);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = bawz.a(localActivity.getApplicationContext(), 10.0F);
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label246;
      label425:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(this.jdField_d_of_type_Int);
    }
    label439:
    QLog.e("UiApiPlugin", 1, "setDoubleRightButton, not support " + localActivity);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Wxu == null) {
      this.jdField_a_of_type_Wxu = wxu.a();
    }
    this.jdField_a_of_type_Wxu.e();
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L) {
      this.jdField_e_of_type_JavaLangString = null;
    }
    label299:
    label613:
    do
    {
      int i1;
      do
      {
        int n;
        do
        {
          for (;;)
          {
            return false;
            if ((paramLong == 8589934597L) || (paramLong == 512L))
            {
              callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=true;d.dispatchEvent(e)}catch(err){}}(document);");
            }
            else if ((paramLong == 2L) || (paramLong == 256L))
            {
              callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);");
            }
            else if (paramLong == 16L)
            {
              this.jdField_e_of_type_JavaLangString = null;
            }
            else
            {
              if ((paramLong != 8589934601L) && (paramLong != 8589934602L)) {
                break;
              }
              if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
              {
                callJs(this.jdField_e_of_type_JavaLangString, new String[] { "" });
                return true;
              }
              if ((this.mOpenApiListeners != null) && (this.mOpenApiListeners.containsKey("setLeftButton")))
              {
                callJs4OpenApiIfNeeded("setLeftButton", 0, "");
                return true;
              }
              if (paramLong == 8589934601L)
              {
                if (this.jdField_c_of_type_Int == -1)
                {
                  this.jdField_c_of_type_Int = 0;
                  paramString = this.mRuntime.a();
                  if ((paramString != null) && ((paramString instanceof QQBrowserActivity)))
                  {
                    Object localObject2 = paramString.getIntent();
                    localObject1 = a();
                    if ((localObject1 != null) && ((((bchu)localObject1).a() & 0x200000) == 0L) && (!((Intent)localObject2).getBooleanExtra("show_right_close_button", false)))
                    {
                      localObject2 = (TextView)paramString.findViewById(2131368457);
                      if ((localObject2 == null) || (((TextView)localObject2).getVisibility() != 0) || (!paramString.getString(2131690832).equals(((TextView)localObject2).getText()))) {
                        break label299;
                      }
                    }
                  }
                }
                while (this.jdField_c_of_type_Int == 0)
                {
                  return false;
                  if ((((bchu)localObject1).a() & 0x4) == 0L) {
                    this.jdField_c_of_type_Int = 1;
                  }
                }
                paramString = paramMap.get("target");
                if (!(paramString instanceof Integer)) {
                  return false;
                }
                n = ((Integer)paramString).intValue();
                if ((n != 1) && (n != 3)) {
                  return false;
                }
                paramString = this.mRuntime.a();
                if (paramString != null)
                {
                  n = paramString.copyBackForwardList().getCurrentIndex();
                  if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, "web history current index:" + n);
                  }
                  if (n > 1) {
                    a(true);
                  } else {
                    a(false);
                  }
                }
              }
            }
          }
          if (paramLong != 8589934600L) {
            break;
          }
          n = ((Integer)paramMap.get("requestCode")).intValue();
          i1 = ((Integer)paramMap.get("resultCode")).intValue();
          if (n == 14) {
            for (;;)
            {
              try
              {
                localObject1 = new JSONObject();
                paramString = "";
                if (i1 == -1) {
                  paramString = ((Intent)paramMap.get("data")).getStringExtra("data");
                }
                if (!TextUtils.isEmpty(paramString)) {
                  break label613;
                }
                ((JSONObject)localObject1).put("result", -2);
                ((JSONObject)localObject1).put("data", "");
                callJs(this.jdField_h_of_type_JavaLangString, new String[] { ((JSONObject)localObject1).toString() });
              }
              catch (Exception paramString)
              {
                callJs(this.jdField_h_of_type_JavaLangString, new String[] { "" });
                QLog.e("UiApiPlugin", 1, "mOpenCustomWebViewCallback call back exception e = ", paramString);
              }
              break;
              ((JSONObject)localObject1).put("result", 0);
              ((JSONObject)localObject1).put("data", paramString);
            }
          }
        } while (n != 18);
        paramString = this.mRuntime.a();
      } while ((i1 != -1) || (paramString == null) || (paramString.isFinishing()));
      Object localObject1 = actn.a(new Intent(paramString, SplashActivity.class), null);
      paramMap = (Intent)paramMap.get("data");
      if (paramMap != null)
      {
        ((Intent)localObject1).putExtras(new Bundle(paramMap.getExtras()));
        paramString.startActivity((Intent)localObject1);
      }
      return true;
    } while ((paramLong != 8589934615L) || (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)));
    callJs(this.jdField_e_of_type_JavaLangString, new String[] { "" });
    return true;
  }
  
  /* Error */
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 99
    //   2: aload_3
    //   3: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +17388 -> 17394
    //   9: aload_0
    //   10: aload 4
    //   12: aload_1
    //   13: invokevirtual 2297	com/tencent/mobileqq/jsp/UiApiPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   16: ldc_w 2299
    //   19: aload 4
    //   21: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifeq +199 -> 223
    //   27: aload 5
    //   29: arraylength
    //   30: ifle +193 -> 223
    //   33: new 109	org/json/JSONObject
    //   36: dup
    //   37: aload 5
    //   39: iconst_0
    //   40: aaload
    //   41: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   50: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   53: astore 4
    //   55: aload 5
    //   57: ldc_w 2301
    //   60: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: astore_1
    //   64: aload 5
    //   66: ldc_w 2303
    //   69: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_2
    //   73: aload 5
    //   75: ldc 150
    //   77: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload 5
    //   83: ldc_w 1380
    //   86: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 5
    //   91: aload 4
    //   93: ifnull +91 -> 184
    //   96: aload_1
    //   97: invokestatic 2308	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   100: ifeq +84 -> 184
    //   103: aload_2
    //   104: invokestatic 2308	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   107: ifeq +77 -> 184
    //   110: new 125	android/content/Intent
    //   113: dup
    //   114: aload 4
    //   116: ldc_w 2310
    //   119: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   122: astore 4
    //   124: aload 4
    //   126: ldc_w 1716
    //   129: aload_1
    //   130: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   133: pop
    //   134: aload 4
    //   136: ldc_w 2303
    //   139: aload_2
    //   140: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   143: pop
    //   144: ldc_w 2312
    //   147: aload_3
    //   148: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +25 -> 176
    //   154: aload 4
    //   156: ldc_w 2314
    //   159: bipush 8
    //   161: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   164: pop
    //   165: aload 4
    //   167: ldc_w 1380
    //   170: aload 5
    //   172: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   175: pop
    //   176: aload_0
    //   177: aload 4
    //   179: bipush 9
    //   181: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   184: iconst_1
    //   185: ireturn
    //   186: astore_1
    //   187: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq -6 -> 184
    //   193: ldc_w 2316
    //   196: iconst_2
    //   197: new 497	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 2318
    //   207: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: goto -36 -> 184
    //   223: ldc_w 2320
    //   226: aload 4
    //   228: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +164 -> 395
    //   234: aload 5
    //   236: arraylength
    //   237: ifle +158 -> 395
    //   240: new 109	org/json/JSONObject
    //   243: dup
    //   244: aload 5
    //   246: iconst_0
    //   247: aaload
    //   248: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   251: astore_2
    //   252: aload_2
    //   253: ldc_w 1337
    //   256: invokevirtual 2323	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   259: lstore 10
    //   261: aload_2
    //   262: ldc_w 2325
    //   265: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   268: istore 6
    //   270: aload_2
    //   271: ldc_w 2327
    //   274: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   277: astore_1
    //   278: aload_2
    //   279: ldc_w 1380
    //   282: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: astore_2
    //   286: aload_0
    //   287: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   290: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   293: new 497	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   300: lload 10
    //   302: invokevirtual 2330	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: ldc_w 371
    //   308: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: bipush 9
    //   316: invokestatic 2335	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   319: astore_3
    //   320: aload_3
    //   321: ldc_w 2337
    //   324: aload_1
    //   325: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   328: pop
    //   329: aload_3
    //   330: ldc_w 2339
    //   333: iload 6
    //   335: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   338: pop
    //   339: aload_3
    //   340: ldc_w 1380
    //   343: aload_2
    //   344: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   347: pop
    //   348: aload_0
    //   349: aload_3
    //   350: bipush 8
    //   352: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   355: goto -171 -> 184
    //   358: astore_1
    //   359: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -178 -> 184
    //   365: ldc_w 2316
    //   368: iconst_2
    //   369: new 497	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 2341
    //   379: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_1
    //   383: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: goto -208 -> 184
    //   395: ldc_w 2343
    //   398: aload 4
    //   400: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   403: ifeq +297 -> 700
    //   406: aload 5
    //   408: arraylength
    //   409: ifle +291 -> 700
    //   412: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   415: ifeq +30 -> 445
    //   418: ldc 191
    //   420: iconst_2
    //   421: new 497	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 2348
    //   431: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 5
    //   436: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload_0
    //   446: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   449: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   452: invokevirtual 1023	com/tencent/biz/pubaccount/CustomWebView:getContext	()Landroid/content/Context;
    //   455: astore_1
    //   456: aload_1
    //   457: ifnonnull +5 -> 462
    //   460: iconst_1
    //   461: ireturn
    //   462: new 109	org/json/JSONObject
    //   465: dup
    //   466: aload 5
    //   468: iconst_0
    //   469: aaload
    //   470: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   473: astore_2
    //   474: aload_2
    //   475: ldc_w 1435
    //   478: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   481: astore_3
    //   482: aload_2
    //   483: ldc 201
    //   485: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   488: tableswitch	default:+16965 -> 17453, 0:+24->512, 1:+178->666
    //   513: ldc_w 2350
    //   516: iconst_1
    //   517: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   520: istore 8
    //   522: aload_3
    //   523: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   526: ifne -342 -> 184
    //   529: iconst_2
    //   530: istore 7
    //   532: iload 7
    //   534: istore 6
    //   536: iload 8
    //   538: tableswitch	default:+16918 -> 17456, 0:+103->641, 1:+109->647, 2:+115->653, 3:+121->659, 4:+42->580, 5:+42->580, 6:+103->641
    //   581: iload 6
    //   583: aload_3
    //   584: iconst_0
    //   585: invokestatic 1967	bcpw:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lbcpw;
    //   588: aload_1
    //   589: invokevirtual 423	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   592: ldc_w 350
    //   595: invokevirtual 356	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   598: invokevirtual 359	bcpw:b	(I)Landroid/widget/Toast;
    //   601: pop
    //   602: goto -418 -> 184
    //   605: astore_1
    //   606: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   609: ifeq -425 -> 184
    //   612: ldc 191
    //   614: iconst_2
    //   615: new 497	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   622: ldc_w 2352
    //   625: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: aload_1
    //   629: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: goto -454 -> 184
    //   641: iconst_0
    //   642: istore 6
    //   644: goto -64 -> 580
    //   647: iconst_2
    //   648: istore 6
    //   650: goto -70 -> 580
    //   653: iconst_1
    //   654: istore 6
    //   656: goto -76 -> 580
    //   659: bipush 6
    //   661: istore 6
    //   663: goto -83 -> 580
    //   666: aload_3
    //   667: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   670: ifne -486 -> 184
    //   673: aload_1
    //   674: iconst_0
    //   675: aload_3
    //   676: iconst_0
    //   677: invokestatic 1967	bcpw:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lbcpw;
    //   680: iconst_0
    //   681: invokevirtual 2354	bcpw:a	(I)Landroid/widget/Toast;
    //   684: astore_1
    //   685: aload_1
    //   686: bipush 23
    //   688: iconst_0
    //   689: iconst_0
    //   690: invokevirtual 2359	android/widget/Toast:setGravity	(III)V
    //   693: aload_1
    //   694: invokevirtual 2360	android/widget/Toast:show	()V
    //   697: goto -513 -> 184
    //   700: ldc_w 2362
    //   703: aload 4
    //   705: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   708: ifeq +109 -> 817
    //   711: new 109	org/json/JSONObject
    //   714: dup
    //   715: aload 5
    //   717: iconst_0
    //   718: aaload
    //   719: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   722: ldc_w 2364
    //   725: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   728: astore_1
    //   729: aload_1
    //   730: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   733: ifeq +5 -> 738
    //   736: iconst_1
    //   737: ireturn
    //   738: aload_0
    //   739: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   742: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   745: astore_2
    //   746: new 125	android/content/Intent
    //   749: dup
    //   750: aload_2
    //   751: ldc_w 2279
    //   754: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   757: aconst_null
    //   758: invokestatic 2284	actn:a	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   761: astore_3
    //   762: aload_3
    //   763: ldc_w 2366
    //   766: aload_1
    //   767: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   770: pop
    //   771: aload_3
    //   772: ldc_w 1237
    //   775: iconst_1
    //   776: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   779: pop
    //   780: aload_3
    //   781: ldc_w 2368
    //   784: iconst_1
    //   785: invokevirtual 553	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   788: pop
    //   789: aload_2
    //   790: aload_3
    //   791: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   794: goto -610 -> 184
    //   797: astore_1
    //   798: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   801: ifeq -617 -> 184
    //   804: ldc 191
    //   806: iconst_2
    //   807: ldc_w 2370
    //   810: aload_1
    //   811: invokestatic 2372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   814: goto -630 -> 184
    //   817: ldc_w 2374
    //   820: aload 4
    //   822: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   825: ifeq +231 -> 1056
    //   828: new 109	org/json/JSONObject
    //   831: dup
    //   832: aload 5
    //   834: iconst_0
    //   835: aaload
    //   836: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   839: astore_3
    //   840: aload_3
    //   841: ldc_w 2364
    //   844: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   847: astore 4
    //   849: aload 4
    //   851: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   854: ifeq +5 -> 859
    //   857: iconst_1
    //   858: ireturn
    //   859: aload_3
    //   860: ldc_w 2376
    //   863: ldc_w 2377
    //   866: invokestatic 1964	ajyc:a	(I)Ljava/lang/String;
    //   869: invokevirtual 2380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   872: astore 5
    //   874: aload_3
    //   875: ldc_w 2382
    //   878: ldc_w 2384
    //   881: invokevirtual 2380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   884: astore 14
    //   886: aload_0
    //   887: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   890: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   893: astore_1
    //   894: new 125	android/content/Intent
    //   897: dup
    //   898: aload_1
    //   899: ldc_w 2279
    //   902: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   905: aconst_null
    //   906: invokestatic 2284	actn:a	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   909: astore_2
    //   910: aload_2
    //   911: ldc_w 2366
    //   914: aload 4
    //   916: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   919: pop
    //   920: aload_2
    //   921: ldc_w 1237
    //   924: iconst_1
    //   925: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   928: pop
    //   929: aload_2
    //   930: ldc_w 2376
    //   933: aload 5
    //   935: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   938: pop
    //   939: aload_2
    //   940: ldc_w 2382
    //   943: aload 14
    //   945: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   948: pop
    //   949: aload_3
    //   950: ldc 201
    //   952: iconst_0
    //   953: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   956: istore 6
    //   958: iload 6
    //   960: iconst_1
    //   961: if_icmpne +65 -> 1026
    //   964: aload_3
    //   965: ldc_w 2386
    //   968: invokevirtual 921	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   971: astore_3
    //   972: aload_3
    //   973: ifnull +15 -> 988
    //   976: aload_2
    //   977: ldc_w 2388
    //   980: aload_3
    //   981: invokevirtual 2389	org/json/JSONArray:toString	()Ljava/lang/String;
    //   984: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   987: pop
    //   988: aload_2
    //   989: ldc_w 2391
    //   992: iload 6
    //   994: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   997: pop
    //   998: aload_1
    //   999: aload_2
    //   1000: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1003: goto -819 -> 184
    //   1006: astore_1
    //   1007: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1010: ifeq -826 -> 184
    //   1013: ldc 191
    //   1015: iconst_2
    //   1016: ldc_w 2393
    //   1019: aload_1
    //   1020: invokestatic 2372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1023: goto -839 -> 184
    //   1026: iload 6
    //   1028: iconst_2
    //   1029: if_icmpne -41 -> 988
    //   1032: aload_2
    //   1033: ldc_w 2395
    //   1036: aload_3
    //   1037: ldc_w 2386
    //   1040: ldc_w 2396
    //   1043: invokestatic 1964	ajyc:a	(I)Ljava/lang/String;
    //   1046: invokevirtual 2380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1049: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1052: pop
    //   1053: goto -65 -> 988
    //   1056: ldc_w 2398
    //   1059: aload 4
    //   1061: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1064: ifeq +50 -> 1114
    //   1067: new 109	org/json/JSONObject
    //   1070: dup
    //   1071: aload 5
    //   1073: iconst_0
    //   1074: aaload
    //   1075: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1078: ldc_w 1435
    //   1081: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1084: astore_1
    //   1085: aload_1
    //   1086: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1089: ifne -905 -> 184
    //   1092: aload_0
    //   1093: aload_0
    //   1094: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   1097: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   1100: aload_1
    //   1101: invokestatic 2403	asfe:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/app/ProgressDialog;
    //   1104: putfield 2405	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1107: goto -923 -> 184
    //   1110: astore_1
    //   1111: goto -927 -> 184
    //   1114: ldc_w 2407
    //   1117: aload 4
    //   1119: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1122: ifeq +52 -> 1174
    //   1125: aload_0
    //   1126: getfield 2405	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1129: ifnull -945 -> 184
    //   1132: aload_0
    //   1133: getfield 2405	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1136: invokevirtual 2408	android/app/ProgressDialog:isShowing	()Z
    //   1139: ifeq -955 -> 184
    //   1142: aload_0
    //   1143: getfield 2405	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1146: invokevirtual 1999	android/app/ProgressDialog:dismiss	()V
    //   1149: aload_0
    //   1150: aconst_null
    //   1151: putfield 2405	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1154: goto -970 -> 184
    //   1157: astore_1
    //   1158: aload_0
    //   1159: aconst_null
    //   1160: putfield 2405	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1163: goto -979 -> 184
    //   1166: astore_1
    //   1167: aload_0
    //   1168: aconst_null
    //   1169: putfield 2405	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1172: aload_1
    //   1173: athrow
    //   1174: ldc_w 2410
    //   1177: aload 4
    //   1179: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1182: ifeq +41 -> 1223
    //   1185: aload 5
    //   1187: arraylength
    //   1188: iconst_1
    //   1189: if_icmpne -1005 -> 184
    //   1192: aload_1
    //   1193: getfield 2413	com/tencent/mobileqq/webview/swift/JsBridgeListener:jdField_a_of_type_Boolean	Z
    //   1196: ifeq +15 -> 1211
    //   1199: aload_0
    //   1200: aload 5
    //   1202: iconst_0
    //   1203: aaload
    //   1204: iconst_1
    //   1205: invokevirtual 2415	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   1208: goto -1024 -> 184
    //   1211: aload_0
    //   1212: aload 5
    //   1214: iconst_0
    //   1215: aaload
    //   1216: iconst_0
    //   1217: invokevirtual 2415	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   1220: goto -1036 -> 184
    //   1223: ldc_w 2417
    //   1226: aload 4
    //   1228: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1231: ifeq +82 -> 1313
    //   1234: aload_0
    //   1235: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   1238: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   1241: instanceof 2419
    //   1244: ifeq +26 -> 1270
    //   1247: aload_1
    //   1248: aload_0
    //   1249: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   1252: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   1255: checkcast 2419	mqq/app/AppActivity
    //   1258: invokevirtual 2422	mqq/app/AppActivity:isResume	()Z
    //   1261: invokestatic 857	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1264: invokevirtual 2425	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1267: goto -1083 -> 184
    //   1270: aload_0
    //   1271: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   1274: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   1277: ifnonnull +25 -> 1302
    //   1280: invokestatic 2428	arkn:a	()Z
    //   1283: ifne +19 -> 1302
    //   1286: aload_1
    //   1287: invokestatic 2433	arkt:a	()Larkt;
    //   1290: invokevirtual 2435	arkt:b	()Z
    //   1293: invokestatic 857	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1296: invokevirtual 2425	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1299: goto -1115 -> 184
    //   1302: aload_1
    //   1303: iconst_0
    //   1304: invokestatic 857	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1307: invokevirtual 2425	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1310: goto -1126 -> 184
    //   1313: ldc_w 2437
    //   1316: aload 4
    //   1318: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1321: ifeq +50 -> 1371
    //   1324: aload 5
    //   1326: arraylength
    //   1327: iconst_1
    //   1328: if_icmpne +43 -> 1371
    //   1331: aload_0
    //   1332: new 109	org/json/JSONObject
    //   1335: dup
    //   1336: aload 5
    //   1338: iconst_0
    //   1339: aaload
    //   1340: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1343: aload_1
    //   1344: aconst_null
    //   1345: invokevirtual 1375	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Landroid/view/View$OnClickListener;)V
    //   1348: goto -1164 -> 184
    //   1351: astore_1
    //   1352: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1355: ifeq -1171 -> 184
    //   1358: ldc 191
    //   1360: iconst_2
    //   1361: ldc_w 2439
    //   1364: aload_1
    //   1365: invokestatic 2372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1368: goto -1184 -> 184
    //   1371: ldc_w 2441
    //   1374: aload 4
    //   1376: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1379: ifeq +119 -> 1498
    //   1382: aload 5
    //   1384: arraylength
    //   1385: iconst_1
    //   1386: if_icmpne +112 -> 1498
    //   1389: aload_0
    //   1390: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   1393: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   1396: astore_2
    //   1397: aload_2
    //   1398: ifnull +16069 -> 17467
    //   1401: aload_2
    //   1402: invokevirtual 725	android/app/Activity:isFinishing	()Z
    //   1405: ifeq +6 -> 1411
    //   1408: goto +16059 -> 17467
    //   1411: new 109	org/json/JSONObject
    //   1414: dup
    //   1415: aload 5
    //   1417: iconst_0
    //   1418: aaload
    //   1419: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1422: astore_2
    //   1423: aload_0
    //   1424: aload_2
    //   1425: ldc_w 2443
    //   1428: invokevirtual 1204	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1431: invokevirtual 2445	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1434: aload_0
    //   1435: aload_2
    //   1436: ldc_w 2447
    //   1439: invokevirtual 1204	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1442: aload_1
    //   1443: invokevirtual 2449	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1446: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1449: ifeq -1265 -> 184
    //   1452: ldc 191
    //   1454: iconst_2
    //   1455: iconst_2
    //   1456: anewarray 843	java/lang/Object
    //   1459: dup
    //   1460: iconst_0
    //   1461: ldc_w 2441
    //   1464: aastore
    //   1465: dup
    //   1466: iconst_1
    //   1467: aload_2
    //   1468: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1471: aastore
    //   1472: invokestatic 2054	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1475: goto -1291 -> 184
    //   1478: astore_1
    //   1479: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1482: ifeq -1298 -> 184
    //   1485: ldc 191
    //   1487: iconst_2
    //   1488: ldc_w 2451
    //   1491: aload_1
    //   1492: invokestatic 2372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1495: goto -1311 -> 184
    //   1498: ldc_w 2453
    //   1501: aload 4
    //   1503: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1506: ifeq +71 -> 1577
    //   1509: aload 5
    //   1511: arraylength
    //   1512: iconst_1
    //   1513: if_icmpne +64 -> 1577
    //   1516: aload_0
    //   1517: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   1520: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   1523: astore_2
    //   1524: aload_2
    //   1525: ifnull +15944 -> 17469
    //   1528: aload_2
    //   1529: invokevirtual 725	android/app/Activity:isFinishing	()Z
    //   1532: ifeq +6 -> 1538
    //   1535: goto +15934 -> 17469
    //   1538: aload_0
    //   1539: new 109	org/json/JSONObject
    //   1542: dup
    //   1543: aload 5
    //   1545: iconst_0
    //   1546: aaload
    //   1547: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1550: aload_1
    //   1551: invokevirtual 2449	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1554: goto -1370 -> 184
    //   1557: astore_1
    //   1558: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1561: ifeq -1377 -> 184
    //   1564: ldc 191
    //   1566: iconst_2
    //   1567: ldc_w 2455
    //   1570: aload_1
    //   1571: invokestatic 2372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1574: goto -1390 -> 184
    //   1577: ldc_w 2457
    //   1580: aload 4
    //   1582: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1585: ifeq +109 -> 1694
    //   1588: aload 5
    //   1590: arraylength
    //   1591: iconst_1
    //   1592: if_icmpne +102 -> 1694
    //   1595: aload_0
    //   1596: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   1599: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   1602: astore_1
    //   1603: aload_1
    //   1604: ifnull +15867 -> 17471
    //   1607: aload_1
    //   1608: invokevirtual 725	android/app/Activity:isFinishing	()Z
    //   1611: ifeq +6 -> 1617
    //   1614: goto +15857 -> 17471
    //   1617: new 109	org/json/JSONObject
    //   1620: dup
    //   1621: aload 5
    //   1623: iconst_0
    //   1624: aaload
    //   1625: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1628: astore_1
    //   1629: aload_1
    //   1630: ldc_w 2459
    //   1633: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1636: istore 6
    //   1638: aload_1
    //   1639: ldc_w 2461
    //   1642: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1645: istore 12
    //   1647: aload_1
    //   1648: ldc_w 1380
    //   1651: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1654: astore_2
    //   1655: aload_0
    //   1656: iload 6
    //   1658: iload 12
    //   1660: aload_1
    //   1661: ldc_w 2463
    //   1664: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1667: aload_2
    //   1668: invokevirtual 2465	com/tencent/mobileqq/jsp/UiApiPlugin:a	(IZZLjava/lang/String;)V
    //   1671: goto -1487 -> 184
    //   1674: astore_1
    //   1675: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1678: ifeq -1494 -> 184
    //   1681: ldc 191
    //   1683: iconst_2
    //   1684: ldc_w 2455
    //   1687: aload_1
    //   1688: invokestatic 2372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1691: goto -1507 -> 184
    //   1694: ldc_w 2227
    //   1697: aload 4
    //   1699: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1702: ifeq +70 -> 1772
    //   1705: aload 5
    //   1707: arraylength
    //   1708: iconst_1
    //   1709: if_icmpne +63 -> 1772
    //   1712: aload_0
    //   1713: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   1716: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   1719: astore_1
    //   1720: aload_1
    //   1721: ifnull +15752 -> 17473
    //   1724: aload_1
    //   1725: invokevirtual 725	android/app/Activity:isFinishing	()Z
    //   1728: ifeq +6 -> 1734
    //   1731: goto +15742 -> 17473
    //   1734: aload_0
    //   1735: new 109	org/json/JSONObject
    //   1738: dup
    //   1739: aload 5
    //   1741: iconst_0
    //   1742: aaload
    //   1743: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1746: invokevirtual 2445	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1749: goto -1565 -> 184
    //   1752: astore_1
    //   1753: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1756: ifeq -1572 -> 184
    //   1759: ldc 191
    //   1761: iconst_2
    //   1762: ldc_w 2467
    //   1765: aload_1
    //   1766: invokestatic 2372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1769: goto -1585 -> 184
    //   1772: ldc_w 2469
    //   1775: aload 4
    //   1777: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1780: ifeq +83 -> 1863
    //   1783: aload 5
    //   1785: arraylength
    //   1786: iconst_1
    //   1787: if_icmpne +76 -> 1863
    //   1790: aload_0
    //   1791: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   1794: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   1797: astore_1
    //   1798: aload_1
    //   1799: ifnull +15676 -> 17475
    //   1802: aload_1
    //   1803: invokevirtual 725	android/app/Activity:isFinishing	()Z
    //   1806: ifeq +6 -> 1812
    //   1809: goto +15666 -> 17475
    //   1812: aload_0
    //   1813: new 109	org/json/JSONObject
    //   1816: dup
    //   1817: aload 5
    //   1819: iconst_0
    //   1820: aaload
    //   1821: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1824: invokevirtual 2471	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Lorg/json/JSONObject;)V
    //   1827: goto -1643 -> 184
    //   1830: astore_1
    //   1831: ldc 191
    //   1833: iconst_1
    //   1834: new 497	java/lang/StringBuilder
    //   1837: dup
    //   1838: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   1841: ldc_w 2473
    //   1844: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1847: aload_1
    //   1848: invokestatic 2476	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1851: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1854: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1857: invokestatic 613	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1860: goto -1676 -> 184
    //   1863: ldc_w 636
    //   1866: aload 4
    //   1868: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1871: ifeq +21 -> 1892
    //   1874: aload 5
    //   1876: arraylength
    //   1877: iconst_1
    //   1878: if_icmpne +14 -> 1892
    //   1881: aload_0
    //   1882: aload 5
    //   1884: iconst_0
    //   1885: aaload
    //   1886: invokevirtual 2477	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;)V
    //   1889: goto -1705 -> 184
    //   1892: ldc_w 2479
    //   1895: aload 4
    //   1897: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1900: ifeq +174 -> 2074
    //   1903: aload 5
    //   1905: arraylength
    //   1906: iconst_1
    //   1907: if_icmpne +167 -> 2074
    //   1910: new 109	org/json/JSONObject
    //   1913: dup
    //   1914: aload 5
    //   1916: iconst_0
    //   1917: aaload
    //   1918: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1921: astore_2
    //   1922: aload_2
    //   1923: ldc_w 2481
    //   1926: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1929: astore_1
    //   1930: aload_0
    //   1931: aload_2
    //   1932: ldc_w 1380
    //   1935: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1938: putfield 2482	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1941: aload_0
    //   1942: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   1945: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1948: ifnonnull +5 -> 1953
    //   1951: iconst_1
    //   1952: ireturn
    //   1953: aload_0
    //   1954: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   1957: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1960: invokevirtual 2033	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1963: astore_2
    //   1964: new 125	android/content/Intent
    //   1967: dup
    //   1968: aload_0
    //   1969: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   1972: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   1975: ldc_w 2484
    //   1978: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1981: ldc 150
    //   1983: ldc_w 373
    //   1986: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1989: astore_3
    //   1990: aload_1
    //   1991: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1994: ifeq +48 -> 2042
    //   1997: aload_0
    //   1998: getfield 2482	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2001: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2004: ifeq +38 -> 2042
    //   2007: aload_3
    //   2008: ldc_w 2486
    //   2011: iconst_1
    //   2012: invokevirtual 553	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2015: pop
    //   2016: aload_0
    //   2017: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2020: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   2023: ifnonnull +5 -> 2028
    //   2026: iconst_1
    //   2027: ireturn
    //   2028: aload_0
    //   2029: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2032: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   2035: aload_3
    //   2036: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2039: goto -1855 -> 184
    //   2042: aload_3
    //   2043: ldc_w 2481
    //   2046: aload_1
    //   2047: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2050: ldc_w 2488
    //   2053: aload_2
    //   2054: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2057: ldc_w 2490
    //   2060: iconst_1
    //   2061: invokevirtual 553	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2064: pop
    //   2065: aload_0
    //   2066: aload_3
    //   2067: iconst_3
    //   2068: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2071: goto -1887 -> 184
    //   2074: ldc_w 2492
    //   2077: aload 4
    //   2079: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2082: ifeq +243 -> 2325
    //   2085: aload 5
    //   2087: arraylength
    //   2088: iconst_1
    //   2089: if_icmpne +236 -> 2325
    //   2092: new 109	org/json/JSONObject
    //   2095: dup
    //   2096: aload 5
    //   2098: iconst_0
    //   2099: aaload
    //   2100: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2103: astore 4
    //   2105: aload 4
    //   2107: ldc_w 2481
    //   2110: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2113: astore_1
    //   2114: aload 4
    //   2116: ldc_w 2494
    //   2119: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2122: astore_2
    //   2123: aload 4
    //   2125: ldc 201
    //   2127: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2130: astore_3
    //   2131: aload_0
    //   2132: aload 4
    //   2134: ldc_w 1380
    //   2137: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2140: putfield 2496	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2143: aload_0
    //   2144: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2147: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2150: ifnonnull +5 -> 2155
    //   2153: iconst_1
    //   2154: ireturn
    //   2155: aload_0
    //   2156: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2159: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2162: invokevirtual 2033	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   2165: astore 4
    //   2167: new 125	android/content/Intent
    //   2170: dup
    //   2171: aload_0
    //   2172: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2175: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   2178: ldc_w 2498
    //   2181: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2184: ldc_w 2500
    //   2187: iconst_4
    //   2188: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2191: ldc_w 2501
    //   2194: invokevirtual 1327	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2197: astore 5
    //   2199: aload_1
    //   2200: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2203: ifeq +73 -> 2276
    //   2206: aload_0
    //   2207: getfield 2496	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2210: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2213: ifeq +63 -> 2276
    //   2216: aload_0
    //   2217: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2220: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   2223: ifnonnull +5 -> 2228
    //   2226: iconst_1
    //   2227: ireturn
    //   2228: aload_0
    //   2229: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2232: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   2235: aload 5
    //   2237: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2240: goto -2056 -> 184
    //   2243: astore_1
    //   2244: ldc 191
    //   2246: iconst_1
    //   2247: new 497	java/lang/StringBuilder
    //   2250: dup
    //   2251: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   2254: ldc_w 2503
    //   2257: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2260: aload_1
    //   2261: invokevirtual 968	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2264: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2267: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2270: invokestatic 613	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2273: goto -2089 -> 184
    //   2276: aload 5
    //   2278: ldc_w 2481
    //   2281: aload_1
    //   2282: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2285: ldc 201
    //   2287: aload_3
    //   2288: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2291: ldc_w 2494
    //   2294: aload_2
    //   2295: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2298: ldc_w 2488
    //   2301: aload 4
    //   2303: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2306: ldc_w 2490
    //   2309: iconst_1
    //   2310: invokevirtual 553	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2313: pop
    //   2314: aload_0
    //   2315: aload 5
    //   2317: bipush 17
    //   2319: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2322: goto -2138 -> 184
    //   2325: ldc_w 2505
    //   2328: aload 4
    //   2330: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2333: ifeq +102 -> 2435
    //   2336: aload 5
    //   2338: arraylength
    //   2339: iconst_1
    //   2340: if_icmpne +95 -> 2435
    //   2343: new 109	org/json/JSONObject
    //   2346: dup
    //   2347: aload 5
    //   2349: iconst_0
    //   2350: aaload
    //   2351: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2354: ldc_w 1380
    //   2357: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2360: astore_1
    //   2361: aload_0
    //   2362: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2365: aload_0
    //   2366: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2369: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   2372: invokevirtual 699	bcdb:a	(Landroid/app/Activity;)Lbcci;
    //   2375: astore_2
    //   2376: aload_2
    //   2377: ifnull +23 -> 2400
    //   2380: aload_2
    //   2381: instanceof 1798
    //   2384: ifeq +16 -> 2400
    //   2387: aload_2
    //   2388: checkcast 1798	bchr
    //   2391: invokeinterface 1801 1 0
    //   2396: aload_1
    //   2397: putfield 2508	xmt:u	Ljava/lang/String;
    //   2400: aload_1
    //   2401: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2404: ifne -2220 -> 184
    //   2407: aload_0
    //   2408: iconst_2
    //   2409: invokevirtual 2509	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   2412: checkcast 1396	bcfj
    //   2415: astore_1
    //   2416: aload_1
    //   2417: ifnull -2233 -> 184
    //   2420: aload_1
    //   2421: invokevirtual 2511	bcfj:g	()V
    //   2424: goto -2240 -> 184
    //   2427: astore_1
    //   2428: aload_1
    //   2429: invokevirtual 2514	org/json/JSONException:printStackTrace	()V
    //   2432: goto -2248 -> 184
    //   2435: ldc_w 2516
    //   2438: aload 4
    //   2440: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2443: ifeq +42 -> 2485
    //   2446: aload 5
    //   2448: arraylength
    //   2449: iconst_1
    //   2450: if_icmpne +35 -> 2485
    //   2453: aload_0
    //   2454: new 109	org/json/JSONObject
    //   2457: dup
    //   2458: aload 5
    //   2460: iconst_0
    //   2461: aaload
    //   2462: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2465: ldc_w 1380
    //   2468: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2471: putfield 2047	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2474: goto -2290 -> 184
    //   2477: astore_1
    //   2478: aload_1
    //   2479: invokevirtual 2514	org/json/JSONException:printStackTrace	()V
    //   2482: goto -2298 -> 184
    //   2485: ldc_w 2518
    //   2488: aload 4
    //   2490: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2493: ifeq +78 -> 2571
    //   2496: aload 5
    //   2498: arraylength
    //   2499: iconst_1
    //   2500: if_icmpne +71 -> 2571
    //   2503: new 109	org/json/JSONObject
    //   2506: dup
    //   2507: aload 5
    //   2509: iconst_0
    //   2510: aaload
    //   2511: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2514: ldc_w 1380
    //   2517: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2520: astore_1
    //   2521: aload_0
    //   2522: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2525: aload_0
    //   2526: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2529: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   2532: invokevirtual 699	bcdb:a	(Landroid/app/Activity;)Lbcci;
    //   2535: astore_2
    //   2536: aload_2
    //   2537: ifnull -2353 -> 184
    //   2540: aload_2
    //   2541: instanceof 1798
    //   2544: ifeq -2360 -> 184
    //   2547: aload_2
    //   2548: checkcast 1798	bchr
    //   2551: invokeinterface 1801 1 0
    //   2556: aload_1
    //   2557: invokevirtual 2519	xmt:a	(Ljava/lang/String;)V
    //   2560: goto -2376 -> 184
    //   2563: astore_1
    //   2564: aload_1
    //   2565: invokevirtual 2514	org/json/JSONException:printStackTrace	()V
    //   2568: goto -2384 -> 184
    //   2571: ldc_w 2521
    //   2574: aload 4
    //   2576: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2579: ifeq +111 -> 2690
    //   2582: aload 5
    //   2584: arraylength
    //   2585: iconst_1
    //   2586: if_icmpne +104 -> 2690
    //   2589: new 109	org/json/JSONObject
    //   2592: dup
    //   2593: aload 5
    //   2595: iconst_0
    //   2596: aaload
    //   2597: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2600: ldc_w 1380
    //   2603: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2606: astore_1
    //   2607: aload_0
    //   2608: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2611: aload_0
    //   2612: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2615: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   2618: invokevirtual 699	bcdb:a	(Landroid/app/Activity;)Lbcci;
    //   2621: astore_2
    //   2622: aload_2
    //   2623: ifnull +23 -> 2646
    //   2626: aload_2
    //   2627: instanceof 1798
    //   2630: ifeq +16 -> 2646
    //   2633: aload_2
    //   2634: checkcast 1798	bchr
    //   2637: invokeinterface 1801 1 0
    //   2642: aload_1
    //   2643: putfield 2523	xmt:q	Ljava/lang/String;
    //   2646: aconst_null
    //   2647: ldc_w 367
    //   2650: ldc_w 2525
    //   2653: ldc_w 371
    //   2656: ldc_w 2527
    //   2659: ldc_w 2527
    //   2662: iconst_0
    //   2663: iconst_0
    //   2664: ldc_w 371
    //   2667: ldc_w 371
    //   2670: ldc_w 371
    //   2673: ldc_w 371
    //   2676: invokestatic 824	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2679: goto -2495 -> 184
    //   2682: astore_1
    //   2683: aload_1
    //   2684: invokevirtual 2514	org/json/JSONException:printStackTrace	()V
    //   2687: goto -41 -> 2646
    //   2690: ldc_w 2529
    //   2693: aload 4
    //   2695: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2698: ifeq +111 -> 2809
    //   2701: aload 5
    //   2703: arraylength
    //   2704: iconst_1
    //   2705: if_icmpne +104 -> 2809
    //   2708: new 109	org/json/JSONObject
    //   2711: dup
    //   2712: aload 5
    //   2714: iconst_0
    //   2715: aaload
    //   2716: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2719: ldc_w 1380
    //   2722: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2725: astore_1
    //   2726: aload_0
    //   2727: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2730: aload_0
    //   2731: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2734: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   2737: invokevirtual 699	bcdb:a	(Landroid/app/Activity;)Lbcci;
    //   2740: astore_2
    //   2741: aload_2
    //   2742: ifnull +23 -> 2765
    //   2745: aload_2
    //   2746: instanceof 1798
    //   2749: ifeq +16 -> 2765
    //   2752: aload_2
    //   2753: checkcast 1798	bchr
    //   2756: invokeinterface 1801 1 0
    //   2761: aload_1
    //   2762: putfield 2532	xmt:r	Ljava/lang/String;
    //   2765: aconst_null
    //   2766: ldc_w 367
    //   2769: ldc_w 2525
    //   2772: ldc_w 371
    //   2775: ldc_w 2534
    //   2778: ldc_w 2534
    //   2781: iconst_0
    //   2782: iconst_0
    //   2783: ldc_w 371
    //   2786: ldc_w 371
    //   2789: ldc_w 371
    //   2792: ldc_w 371
    //   2795: invokestatic 824	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2798: goto -2614 -> 184
    //   2801: astore_1
    //   2802: aload_1
    //   2803: invokevirtual 2514	org/json/JSONException:printStackTrace	()V
    //   2806: goto -41 -> 2765
    //   2809: ldc_w 2536
    //   2812: aload 4
    //   2814: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2817: ifeq +111 -> 2928
    //   2820: aload 5
    //   2822: arraylength
    //   2823: iconst_1
    //   2824: if_icmpne +104 -> 2928
    //   2827: new 109	org/json/JSONObject
    //   2830: dup
    //   2831: aload 5
    //   2833: iconst_0
    //   2834: aaload
    //   2835: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2838: ldc_w 1380
    //   2841: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2844: astore_1
    //   2845: aload_0
    //   2846: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2849: aload_0
    //   2850: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2853: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   2856: invokevirtual 699	bcdb:a	(Landroid/app/Activity;)Lbcci;
    //   2859: astore_2
    //   2860: aload_2
    //   2861: ifnull +23 -> 2884
    //   2864: aload_2
    //   2865: instanceof 1798
    //   2868: ifeq +16 -> 2884
    //   2871: aload_2
    //   2872: checkcast 1798	bchr
    //   2875: invokeinterface 1801 1 0
    //   2880: aload_1
    //   2881: putfield 2539	xmt:s	Ljava/lang/String;
    //   2884: aconst_null
    //   2885: ldc_w 367
    //   2888: ldc_w 2525
    //   2891: ldc_w 371
    //   2894: ldc_w 2541
    //   2897: ldc_w 2541
    //   2900: iconst_0
    //   2901: iconst_0
    //   2902: ldc_w 371
    //   2905: ldc_w 371
    //   2908: ldc_w 371
    //   2911: ldc_w 371
    //   2914: invokestatic 824	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2917: goto -2733 -> 184
    //   2920: astore_1
    //   2921: aload_1
    //   2922: invokevirtual 2514	org/json/JSONException:printStackTrace	()V
    //   2925: goto -41 -> 2884
    //   2928: ldc_w 2543
    //   2931: aload 4
    //   2933: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2936: ifeq +111 -> 3047
    //   2939: aload 5
    //   2941: arraylength
    //   2942: iconst_1
    //   2943: if_icmpne +104 -> 3047
    //   2946: new 109	org/json/JSONObject
    //   2949: dup
    //   2950: aload 5
    //   2952: iconst_0
    //   2953: aaload
    //   2954: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2957: ldc_w 1380
    //   2960: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2963: astore_1
    //   2964: aload_0
    //   2965: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2968: aload_0
    //   2969: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   2972: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   2975: invokevirtual 699	bcdb:a	(Landroid/app/Activity;)Lbcci;
    //   2978: astore_2
    //   2979: aload_2
    //   2980: ifnull +23 -> 3003
    //   2983: aload_2
    //   2984: instanceof 1798
    //   2987: ifeq +16 -> 3003
    //   2990: aload_2
    //   2991: checkcast 1798	bchr
    //   2994: invokeinterface 1801 1 0
    //   2999: aload_1
    //   3000: putfield 2546	xmt:t	Ljava/lang/String;
    //   3003: aconst_null
    //   3004: ldc_w 367
    //   3007: ldc_w 2525
    //   3010: ldc_w 371
    //   3013: ldc_w 2548
    //   3016: ldc_w 2548
    //   3019: iconst_0
    //   3020: iconst_0
    //   3021: ldc_w 371
    //   3024: ldc_w 371
    //   3027: ldc_w 371
    //   3030: ldc_w 371
    //   3033: invokestatic 824	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3036: goto -2852 -> 184
    //   3039: astore_1
    //   3040: aload_1
    //   3041: invokevirtual 2514	org/json/JSONException:printStackTrace	()V
    //   3044: goto -41 -> 3003
    //   3047: ldc_w 2550
    //   3050: aload 4
    //   3052: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3055: ifeq +301 -> 3356
    //   3058: aload 5
    //   3060: arraylength
    //   3061: iconst_1
    //   3062: if_icmpne +294 -> 3356
    //   3065: new 109	org/json/JSONObject
    //   3068: dup
    //   3069: aload 5
    //   3071: iconst_0
    //   3072: aaload
    //   3073: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3076: astore_3
    //   3077: aload_0
    //   3078: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   3081: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   3084: astore 5
    //   3086: aload 5
    //   3088: ifnull +14393 -> 17481
    //   3091: aload 5
    //   3093: invokevirtual 725	android/app/Activity:isFinishing	()Z
    //   3096: ifeq +6 -> 3102
    //   3099: goto +14382 -> 17481
    //   3102: aload_3
    //   3103: ldc_w 909
    //   3106: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3109: astore 14
    //   3111: aload_3
    //   3112: ldc_w 1435
    //   3115: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3118: astore 15
    //   3120: aload_3
    //   3121: ldc_w 2552
    //   3124: iconst_1
    //   3125: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3128: istore 12
    //   3130: aload_3
    //   3131: ldc_w 2554
    //   3134: iconst_1
    //   3135: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3138: istore 13
    //   3140: aload_3
    //   3141: ldc_w 2556
    //   3144: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3147: astore_2
    //   3148: aload_3
    //   3149: ldc_w 2558
    //   3152: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3155: astore_1
    //   3156: aload_3
    //   3157: ldc_w 1380
    //   3160: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3163: astore_3
    //   3164: aload 5
    //   3166: iconst_0
    //   3167: invokestatic 2563	bbcv:a	(Landroid/content/Context;I)Lbbgg;
    //   3170: astore 4
    //   3172: aload 4
    //   3174: aload 14
    //   3176: invokevirtual 2569	bbgg:setTitle	(Ljava/lang/String;)Lbbgg;
    //   3179: pop
    //   3180: aload 4
    //   3182: aload 15
    //   3184: invokevirtual 2573	bbgg:setMessage	(Ljava/lang/CharSequence;)Lbbgg;
    //   3187: pop
    //   3188: aload 4
    //   3190: invokevirtual 2577	bbgg:getMessageTextView	()Landroid/widget/TextView;
    //   3193: invokevirtual 2581	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   3196: astore 14
    //   3198: aload 14
    //   3200: instanceof 2583
    //   3203: ifeq +41 -> 3244
    //   3206: aload 14
    //   3208: checkcast 2583	android/view/ViewGroup$MarginLayoutParams
    //   3211: ldc_w 2584
    //   3214: invokestatic 2589	bbkx:a	(F)I
    //   3217: putfield 2592	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   3220: aload 14
    //   3222: checkcast 2583	android/view/ViewGroup$MarginLayoutParams
    //   3225: ldc_w 2584
    //   3228: invokestatic 2589	bbkx:a	(F)I
    //   3231: putfield 2593	android/view/ViewGroup$MarginLayoutParams:rightMargin	I
    //   3234: aload 4
    //   3236: invokevirtual 2577	bbgg:getMessageTextView	()Landroid/widget/TextView;
    //   3239: aload 14
    //   3241: invokevirtual 2594	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   3244: new 2596	arog
    //   3247: dup
    //   3248: aload_0
    //   3249: aload_3
    //   3250: invokespecial 2597	arog:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   3253: astore 14
    //   3255: iload 13
    //   3257: ifeq +28 -> 3285
    //   3260: aload_1
    //   3261: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3264: ifeq +14186 -> 17450
    //   3267: aload 5
    //   3269: ldc_w 2598
    //   3272: invokevirtual 2240	android/app/Activity:getString	(I)Ljava/lang/String;
    //   3275: astore_1
    //   3276: aload 4
    //   3278: aload_1
    //   3279: aload 14
    //   3281: invokevirtual 2602	bbgg:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbbgg;
    //   3284: pop
    //   3285: iload 12
    //   3287: ifeq +28 -> 3315
    //   3290: aload_2
    //   3291: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3294: ifeq +14151 -> 17445
    //   3297: aload 5
    //   3299: ldc_w 2603
    //   3302: invokevirtual 2240	android/app/Activity:getString	(I)Ljava/lang/String;
    //   3305: astore_1
    //   3306: aload 4
    //   3308: aload_1
    //   3309: aload 14
    //   3311: invokevirtual 2606	bbgg:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbbgg;
    //   3314: pop
    //   3315: aload_3
    //   3316: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3319: ifne +17 -> 3336
    //   3322: aload 4
    //   3324: new 2608	arop
    //   3327: dup
    //   3328: aload_0
    //   3329: aload_3
    //   3330: invokespecial 2609	arop:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   3333: invokevirtual 2610	bbgg:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   3336: aload 4
    //   3338: invokevirtual 2611	bbgg:show	()V
    //   3341: goto -3157 -> 184
    //   3344: astore_1
    //   3345: goto -3161 -> 184
    //   3348: astore_1
    //   3349: aload_1
    //   3350: invokevirtual 2514	org/json/JSONException:printStackTrace	()V
    //   3353: goto -3169 -> 184
    //   3356: ldc_w 2613
    //   3359: aload 4
    //   3361: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3364: ifeq +399 -> 3763
    //   3367: aload 5
    //   3369: arraylength
    //   3370: iconst_1
    //   3371: if_icmpne +392 -> 3763
    //   3374: new 109	org/json/JSONObject
    //   3377: dup
    //   3378: aload 5
    //   3380: iconst_0
    //   3381: aaload
    //   3382: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3385: astore_2
    //   3386: aload_2
    //   3387: ldc_w 2615
    //   3390: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3393: astore_3
    //   3394: aload_2
    //   3395: ldc_w 2617
    //   3398: invokevirtual 1204	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3401: astore_2
    //   3402: ldc_w 2619
    //   3405: aload_3
    //   3406: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3409: ifeq +106 -> 3515
    //   3412: aload_2
    //   3413: ldc_w 2301
    //   3416: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3419: astore_2
    //   3420: aload_2
    //   3421: invokestatic 2308	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3424: ifeq +66 -> 3490
    //   3427: new 125	android/content/Intent
    //   3430: dup
    //   3431: invokespecial 227	android/content/Intent:<init>	()V
    //   3434: astore_3
    //   3435: aload_3
    //   3436: getstatic 2622	cooperation/troop/TroopFileProxyActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3439: aload_2
    //   3440: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3443: pop
    //   3444: aload_0
    //   3445: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   3448: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   3451: aload_3
    //   3452: aload_0
    //   3453: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   3456: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   3459: invokevirtual 1698	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3462: invokestatic 2625	cooperation/troop/TroopFileProxyActivity:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)V
    //   3465: aload_1
    //   3466: ldc_w 2627
    //   3469: invokevirtual 2425	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3472: goto -3288 -> 184
    //   3475: astore_2
    //   3476: aload_2
    //   3477: invokevirtual 2514	org/json/JSONException:printStackTrace	()V
    //   3480: aload_1
    //   3481: ldc_w 2629
    //   3484: invokevirtual 2425	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3487: goto -3303 -> 184
    //   3490: aload_1
    //   3491: ldc_w 2629
    //   3494: invokevirtual 2425	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3497: goto -3313 -> 184
    //   3500: astore_2
    //   3501: aload_2
    //   3502: invokevirtual 2630	java/lang/Exception:printStackTrace	()V
    //   3505: aload_1
    //   3506: ldc_w 2629
    //   3509: invokevirtual 2425	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3512: goto -3328 -> 184
    //   3515: ldc_w 2632
    //   3518: aload_3
    //   3519: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3522: ifeq +71 -> 3593
    //   3525: aload_2
    //   3526: ldc_w 2301
    //   3529: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3532: astore_2
    //   3533: aload_2
    //   3534: invokestatic 2308	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3537: ifeq +46 -> 3583
    //   3540: invokestatic 2637	bgyf:a	()Lbgyf;
    //   3543: astore_3
    //   3544: aload_3
    //   3545: aload_0
    //   3546: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   3549: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   3552: invokevirtual 1698	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3555: putfield 2638	bgyf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3558: aload_0
    //   3559: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   3562: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   3565: aload_3
    //   3566: aload_2
    //   3567: aconst_null
    //   3568: iconst_0
    //   3569: iconst_0
    //   3570: invokestatic 2643	bgxy:a	(Landroid/app/Activity;Lbgyf;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3573: aload_1
    //   3574: ldc_w 2627
    //   3577: invokevirtual 2425	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3580: goto -3396 -> 184
    //   3583: aload_1
    //   3584: ldc_w 2629
    //   3587: invokevirtual 2425	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3590: goto -3406 -> 184
    //   3593: ldc_w 2645
    //   3596: aload_3
    //   3597: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3600: ifeq +66 -> 3666
    //   3603: aload_0
    //   3604: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   3607: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   3610: astore_3
    //   3611: aload_2
    //   3612: ldc_w 2301
    //   3615: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3618: astore_2
    //   3619: aload_3
    //   3620: ifnull -3436 -> 184
    //   3623: aload_2
    //   3624: invokestatic 2308	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3627: ifeq -3443 -> 184
    //   3630: new 125	android/content/Intent
    //   3633: dup
    //   3634: aload_3
    //   3635: ldc_w 2647
    //   3638: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3641: astore 4
    //   3643: aload 4
    //   3645: ldc_w 1716
    //   3648: aload_2
    //   3649: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3652: pop
    //   3653: aload_3
    //   3654: aload 4
    //   3656: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3659: aload_3
    //   3660: invokevirtual 241	android/app/Activity:finish	()V
    //   3663: goto -3479 -> 184
    //   3666: ldc_w 2649
    //   3669: aload_3
    //   3670: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3673: ifeq -3489 -> 184
    //   3676: aload_0
    //   3677: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   3680: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   3683: astore_3
    //   3684: aload_2
    //   3685: ldc_w 2301
    //   3688: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3691: astore 4
    //   3693: aload_2
    //   3694: ldc_w 2303
    //   3697: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3700: astore_2
    //   3701: aload_3
    //   3702: ifnull -3518 -> 184
    //   3705: aload 4
    //   3707: invokestatic 2308	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3710: ifeq -3526 -> 184
    //   3713: aload_2
    //   3714: invokestatic 2308	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3717: ifeq -3533 -> 184
    //   3720: new 125	android/content/Intent
    //   3723: dup
    //   3724: aload_3
    //   3725: ldc_w 2310
    //   3728: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3731: astore 5
    //   3733: aload 5
    //   3735: ldc_w 1716
    //   3738: aload 4
    //   3740: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3743: pop
    //   3744: aload 5
    //   3746: ldc_w 2303
    //   3749: aload_2
    //   3750: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3753: pop
    //   3754: aload_3
    //   3755: aload 5
    //   3757: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3760: goto -3576 -> 184
    //   3763: ldc_w 2650
    //   3766: aload 4
    //   3768: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3771: ifeq +874 -> 4645
    //   3774: aload 5
    //   3776: arraylength
    //   3777: iconst_1
    //   3778: if_icmpne +867 -> 4645
    //   3781: aload_0
    //   3782: ldc_w 371
    //   3785: putfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3788: new 109	org/json/JSONObject
    //   3791: dup
    //   3792: aload 5
    //   3794: iconst_0
    //   3795: aaload
    //   3796: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3799: astore_1
    //   3800: aload_1
    //   3801: ifnull +826 -> 4627
    //   3804: aload_0
    //   3805: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   3808: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   3811: astore_3
    //   3812: aload_1
    //   3813: ldc_w 2654
    //   3816: ldc_w 2656
    //   3819: invokevirtual 2380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3822: astore 14
    //   3824: aload_1
    //   3825: ldc_w 2481
    //   3828: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3831: astore 4
    //   3833: aload_1
    //   3834: ldc_w 1071
    //   3837: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3840: astore 15
    //   3842: aload_1
    //   3843: ldc_w 2658
    //   3846: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3849: astore 5
    //   3851: aload_1
    //   3852: ldc_w 1380
    //   3855: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3858: astore_2
    //   3859: aload_1
    //   3860: ldc_w 1193
    //   3863: iconst_m1
    //   3864: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3867: istore 6
    //   3869: new 109	org/json/JSONObject
    //   3872: dup
    //   3873: aload 15
    //   3875: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3878: astore_1
    //   3879: aload_0
    //   3880: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   3883: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   3886: astore 15
    //   3888: aload 15
    //   3890: ifnull +16 -> 3906
    //   3893: aload_1
    //   3894: ldc_w 2660
    //   3897: aload 15
    //   3899: invokevirtual 1219	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   3902: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3905: pop
    //   3906: ldc_w 2662
    //   3909: aload 14
    //   3911: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3914: ifeq +164 -> 4078
    //   3917: new 400	android/os/Bundle
    //   3920: dup
    //   3921: invokespecial 870	android/os/Bundle:<init>	()V
    //   3924: astore_2
    //   3925: aload_2
    //   3926: ldc_w 1071
    //   3929: aload_1
    //   3930: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3933: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3936: aload_2
    //   3937: ldc_w 2658
    //   3940: aload 5
    //   3942: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3945: ldc_w 2664
    //   3948: aload 4
    //   3950: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3953: ifeq +95 -> 4048
    //   3956: new 2666	azea
    //   3959: dup
    //   3960: aload_3
    //   3961: checkcast 2668	com/tencent/mobileqq/app/BaseActivity
    //   3964: aload_2
    //   3965: invokespecial 2671	azea:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   3968: aload_3
    //   3969: invokevirtual 2673	azea:a	(Landroid/app/Activity;)V
    //   3972: goto -3788 -> 184
    //   3975: astore_1
    //   3976: ldc_w 371
    //   3979: astore_2
    //   3980: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3983: ifeq +22 -> 4005
    //   3986: ldc 191
    //   3988: iconst_2
    //   3989: ldc_w 2675
    //   3992: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3995: ldc 191
    //   3997: iconst_2
    //   3998: aload_1
    //   3999: invokestatic 459	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4002: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4005: aload_2
    //   4006: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4009: ifne -3825 -> 184
    //   4012: aload_0
    //   4013: aload_2
    //   4014: iconst_1
    //   4015: anewarray 334	java/lang/String
    //   4018: dup
    //   4019: iconst_0
    //   4020: ldc_w 2677
    //   4023: aastore
    //   4024: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4027: goto -3843 -> 184
    //   4030: astore_1
    //   4031: aconst_null
    //   4032: astore_1
    //   4033: goto -233 -> 3800
    //   4036: astore_1
    //   4037: new 109	org/json/JSONObject
    //   4040: dup
    //   4041: invokespecial 168	org/json/JSONObject:<init>	()V
    //   4044: astore_1
    //   4045: goto -166 -> 3879
    //   4048: ldc_w 2679
    //   4051: aload 4
    //   4053: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4056: ifeq -3872 -> 184
    //   4059: new 2681	azfy
    //   4062: dup
    //   4063: aload_3
    //   4064: checkcast 2668	com/tencent/mobileqq/app/BaseActivity
    //   4067: aload_2
    //   4068: invokespecial 2682	azfy:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   4071: aload_3
    //   4072: invokevirtual 2683	azfy:a	(Landroid/app/Activity;)V
    //   4075: goto -3891 -> 184
    //   4078: ldc_w 2656
    //   4081: aload 14
    //   4083: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4086: ifeq +331 -> 4417
    //   4089: new 125	android/content/Intent
    //   4092: dup
    //   4093: invokespecial 227	android/content/Intent:<init>	()V
    //   4096: astore 14
    //   4098: ldc_w 2685
    //   4101: aload 4
    //   4103: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4106: ifeq +119 -> 4225
    //   4109: aload 14
    //   4111: new 2687	android/content/ComponentName
    //   4114: dup
    //   4115: aload_0
    //   4116: invokevirtual 1835	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   4119: aload 4
    //   4121: invokespecial 2688	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4124: invokevirtual 2692	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4127: pop
    //   4128: aload 14
    //   4130: ldc_w 2694
    //   4133: invokestatic 1124	java/lang/System:currentTimeMillis	()J
    //   4136: invokevirtual 1340	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   4139: pop
    //   4140: aload 14
    //   4142: ldc_w 1071
    //   4145: aload_1
    //   4146: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4149: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4152: pop
    //   4153: aload_0
    //   4154: aload 5
    //   4156: putfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4159: aload 5
    //   4161: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4164: ifeq +208 -> 4372
    //   4167: aload_3
    //   4168: aload 14
    //   4170: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   4173: goto +13310 -> 17483
    //   4176: ldc_w 2696
    //   4179: invokevirtual 138	java/lang/Class:getName	()Ljava/lang/String;
    //   4182: aload 4
    //   4184: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4187: ifeq -4003 -> 184
    //   4190: aload_0
    //   4191: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   4194: ifnonnull +17 -> 4211
    //   4197: aload_0
    //   4198: invokestatic 1679	wxu:a	()Lwxu;
    //   4201: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   4204: aload_0
    //   4205: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   4208: invokevirtual 1680	wxu:a	()V
    //   4211: aload_0
    //   4212: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   4215: invokevirtual 2698	wxu:c	()V
    //   4218: goto -4034 -> 184
    //   4221: astore_1
    //   4222: goto -242 -> 3980
    //   4225: ldc_w 2700
    //   4228: aload 4
    //   4230: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4233: ifeq +78 -> 4311
    //   4236: aload 14
    //   4238: new 2687	android/content/ComponentName
    //   4241: dup
    //   4242: aload_3
    //   4243: aload 4
    //   4245: invokespecial 2688	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4248: invokevirtual 2692	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4251: pop
    //   4252: aload 14
    //   4254: ldc_w 2702
    //   4257: iconst_0
    //   4258: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4261: pop
    //   4262: aload 14
    //   4264: ldc_w 1115
    //   4267: invokestatic 1124	java/lang/System:currentTimeMillis	()J
    //   4270: invokevirtual 1340	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   4273: pop
    //   4274: aload 14
    //   4276: getstatic 2706	bgrs:l	Ljava/lang/String;
    //   4279: iconst_1
    //   4280: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4283: pop
    //   4284: aload 14
    //   4286: getstatic 2707	bgrs:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   4289: ldc_w 2064
    //   4292: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4295: pop
    //   4296: aload 14
    //   4298: getstatic 2708	bgrs:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4301: ldc_w 2481
    //   4304: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4307: pop
    //   4308: goto -168 -> 4140
    //   4311: ldc_w 2710
    //   4314: aload 4
    //   4316: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4319: ifeq +34 -> 4353
    //   4322: aload 14
    //   4324: new 2687	android/content/ComponentName
    //   4327: dup
    //   4328: aload_3
    //   4329: aload 4
    //   4331: invokespecial 2688	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4334: invokevirtual 2692	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4337: pop
    //   4338: aload 14
    //   4340: ldc_w 2712
    //   4343: ldc_w 1842
    //   4346: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4349: pop
    //   4350: goto -210 -> 4140
    //   4353: aload 14
    //   4355: new 2687	android/content/ComponentName
    //   4358: dup
    //   4359: aload_3
    //   4360: aload 4
    //   4362: invokespecial 2688	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4365: invokevirtual 2692	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4368: pop
    //   4369: goto -229 -> 4140
    //   4372: aload_0
    //   4373: aload 14
    //   4375: iconst_4
    //   4376: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4379: aload_2
    //   4380: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4383: ifne +13100 -> 17483
    //   4386: aload_0
    //   4387: aload_2
    //   4388: iconst_1
    //   4389: anewarray 334	java/lang/String
    //   4392: dup
    //   4393: iconst_0
    //   4394: ldc_w 634
    //   4397: aastore
    //   4398: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4401: goto +13082 -> 17483
    //   4404: aload_3
    //   4405: ldc_w 2713
    //   4408: ldc_w 2714
    //   4411: invokevirtual 1196	android/app/Activity:overridePendingTransition	(II)V
    //   4414: goto -238 -> 4176
    //   4417: ldc_w 2716
    //   4420: aload 14
    //   4422: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4425: ifeq -4241 -> 184
    //   4428: aload 4
    //   4430: ldc_w 2718
    //   4433: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4436: ifeq +88 -> 4524
    //   4439: aload_1
    //   4440: ldc_w 2720
    //   4443: iconst_0
    //   4444: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4447: iconst_1
    //   4448: if_icmpne -4264 -> 184
    //   4451: aload_0
    //   4452: aload 5
    //   4454: putfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4457: aload_1
    //   4458: ldc 150
    //   4460: ldc_w 371
    //   4463: invokevirtual 2380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4466: astore_2
    //   4467: aload_0
    //   4468: aload_3
    //   4469: aload_0
    //   4470: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   4473: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   4476: aload_1
    //   4477: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4480: iconst_4
    //   4481: aload_2
    //   4482: invokestatic 2725	azcd:a	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;BLjava/lang/String;)V
    //   4485: aload_3
    //   4486: ldc_w 2713
    //   4489: ldc_w 2714
    //   4492: invokevirtual 1196	android/app/Activity:overridePendingTransition	(II)V
    //   4495: ldc_w 371
    //   4498: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4501: ifne -4317 -> 184
    //   4504: aload_0
    //   4505: ldc_w 371
    //   4508: iconst_1
    //   4509: anewarray 334	java/lang/String
    //   4512: dup
    //   4513: iconst_0
    //   4514: ldc_w 634
    //   4517: aastore
    //   4518: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4521: goto -4337 -> 184
    //   4524: aload 4
    //   4526: ldc_w 2727
    //   4529: invokevirtual 138	java/lang/Class:getName	()Ljava/lang/String;
    //   4532: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4535: ifeq -4351 -> 184
    //   4538: new 125	android/content/Intent
    //   4541: dup
    //   4542: invokespecial 227	android/content/Intent:<init>	()V
    //   4545: astore 14
    //   4547: aload 14
    //   4549: new 2687	android/content/ComponentName
    //   4552: dup
    //   4553: aload_3
    //   4554: aload 4
    //   4556: invokespecial 2688	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4559: invokevirtual 2692	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4562: pop
    //   4563: aload 14
    //   4565: ldc_w 1071
    //   4568: aload_1
    //   4569: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4572: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4575: pop
    //   4576: aload_0
    //   4577: aload 5
    //   4579: putfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4582: aload_0
    //   4583: aload 14
    //   4585: iconst_4
    //   4586: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4589: aload_2
    //   4590: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4593: ifne +12914 -> 17507
    //   4596: aload_0
    //   4597: aload_2
    //   4598: iconst_1
    //   4599: anewarray 334	java/lang/String
    //   4602: dup
    //   4603: iconst_0
    //   4604: ldc_w 634
    //   4607: aastore
    //   4608: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4611: goto +12896 -> 17507
    //   4614: aload_3
    //   4615: ldc_w 2713
    //   4618: ldc_w 2714
    //   4621: invokevirtual 1196	android/app/Activity:overridePendingTransition	(II)V
    //   4624: goto -4440 -> 184
    //   4627: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4630: ifeq -4446 -> 184
    //   4633: ldc 191
    //   4635: iconst_2
    //   4636: ldc_w 2729
    //   4639: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4642: goto -4458 -> 184
    //   4645: ldc_w 2731
    //   4648: aload 4
    //   4650: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4653: ifeq +1942 -> 6595
    //   4656: aload 5
    //   4658: arraylength
    //   4659: iconst_1
    //   4660: if_icmpne +1935 -> 6595
    //   4663: new 109	org/json/JSONObject
    //   4666: dup
    //   4667: aload 5
    //   4669: iconst_0
    //   4670: aaload
    //   4671: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4674: astore_2
    //   4675: aload_0
    //   4676: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   4679: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   4682: astore 4
    //   4684: aload 4
    //   4686: instanceof 1181
    //   4689: ifne +5 -> 4694
    //   4692: iconst_1
    //   4693: ireturn
    //   4694: aload_0
    //   4695: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   4698: invokevirtual 1512	bcdb:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4701: astore_3
    //   4702: aload_3
    //   4703: ifnonnull +5 -> 4708
    //   4706: iconst_1
    //   4707: ireturn
    //   4708: aload_2
    //   4709: ldc_w 2733
    //   4712: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4715: ifeq +103 -> 4818
    //   4718: aload_2
    //   4719: ldc_w 2735
    //   4722: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4725: ifeq +93 -> 4818
    //   4728: aload_2
    //   4729: ldc_w 2735
    //   4732: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4735: ifeq +83 -> 4818
    //   4738: aload_2
    //   4739: ldc_w 2733
    //   4742: invokestatic 2737	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4745: istore 6
    //   4747: aload_0
    //   4748: iconst_2
    //   4749: invokespecial 1394	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4752: checkcast 1396	bcfj
    //   4755: astore_1
    //   4756: aload_1
    //   4757: ifnull +25 -> 4782
    //   4760: aload_1
    //   4761: getfield 2738	bcfj:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   4764: ifnull +18 -> 4782
    //   4767: aload_1
    //   4768: iload 6
    //   4770: putfield 2739	bcfj:jdField_a_of_type_Int	I
    //   4773: aload_1
    //   4774: getfield 2738	bcfj:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   4777: iload 6
    //   4779: invokevirtual 2740	android/view/View:setBackgroundColor	(I)V
    //   4782: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4785: ifeq +33 -> 4818
    //   4788: ldc 191
    //   4790: iconst_2
    //   4791: new 497	java/lang/StringBuilder
    //   4794: dup
    //   4795: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   4798: ldc_w 2742
    //   4801: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4804: iload 6
    //   4806: invokestatic 2745	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   4809: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4812: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4815: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4818: aload_2
    //   4819: ldc_w 2747
    //   4822: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4825: ifeq +71 -> 4896
    //   4828: aload_2
    //   4829: ldc_w 2747
    //   4832: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4835: istore 12
    //   4837: iload 12
    //   4839: ifne +57 -> 4896
    //   4842: aload_0
    //   4843: iconst_2
    //   4844: invokespecial 1394	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4847: checkcast 1396	bcfj
    //   4850: astore_1
    //   4851: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4854: ifeq +30 -> 4884
    //   4857: ldc 191
    //   4859: iconst_2
    //   4860: new 497	java/lang/StringBuilder
    //   4863: dup
    //   4864: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   4867: ldc_w 2749
    //   4870: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4873: iload 12
    //   4875: invokevirtual 2752	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4878: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4881: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4884: aload_1
    //   4885: ifnull +11 -> 4896
    //   4888: aload_1
    //   4889: getfield 2755	bcfj:jdField_a_of_type_Bcsc	Lbcsc;
    //   4892: iconst_0
    //   4893: invokevirtual 2758	bcsc:a	(Z)V
    //   4896: aload_2
    //   4897: ldc_w 2760
    //   4900: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4903: ifeq +72 -> 4975
    //   4906: aload_2
    //   4907: ldc_w 2760
    //   4910: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4913: istore 6
    //   4915: aload 4
    //   4917: ldc_w 2236
    //   4920: invokevirtual 730	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4923: checkcast 1470	android/widget/TextView
    //   4926: astore_1
    //   4927: aload 4
    //   4929: ldc_w 2761
    //   4932: invokevirtual 730	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4935: checkcast 708	android/widget/ImageView
    //   4938: astore 5
    //   4940: aload_1
    //   4941: ifnull +34 -> 4975
    //   4944: aload 5
    //   4946: ifnull +29 -> 4975
    //   4949: iload 6
    //   4951: iconst_1
    //   4952: if_icmpne +1104 -> 6056
    //   4955: aload 5
    //   4957: invokevirtual 712	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   4960: ifnull +1045 -> 6005
    //   4963: aload 5
    //   4965: iconst_0
    //   4966: invokevirtual 752	android/widget/ImageView:setVisibility	(I)V
    //   4969: aload_1
    //   4970: bipush 8
    //   4972: invokevirtual 2762	android/widget/TextView:setVisibility	(I)V
    //   4975: aload_2
    //   4976: ldc_w 2764
    //   4979: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4982: ifeq +23 -> 5005
    //   4985: aload_2
    //   4986: ldc_w 2764
    //   4989: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4992: iconst_1
    //   4993: if_icmpne +12538 -> 17531
    //   4996: iconst_1
    //   4997: istore 12
    //   4999: aload_3
    //   5000: iload 12
    //   5002: invokevirtual 2766	com/tencent/mobileqq/webview/swift/WebViewFragment:h	(Z)V
    //   5005: aload_2
    //   5006: ldc_w 2768
    //   5009: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5012: ifeq +129 -> 5141
    //   5015: aload_2
    //   5016: ldc_w 2770
    //   5019: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5022: ifeq +119 -> 5141
    //   5025: aload_2
    //   5026: ldc_w 2772
    //   5029: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5032: ifeq +109 -> 5141
    //   5035: aload_2
    //   5036: ldc_w 2774
    //   5039: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5042: ifeq +99 -> 5141
    //   5045: aload_2
    //   5046: ldc_w 2776
    //   5049: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5052: ifeq +89 -> 5141
    //   5055: aload_2
    //   5056: ldc_w 2768
    //   5059: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5062: astore_1
    //   5063: aload_2
    //   5064: ldc_w 2770
    //   5067: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   5070: istore 6
    //   5072: aload_2
    //   5073: ldc_w 2772
    //   5076: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   5079: istore 7
    //   5081: aload_2
    //   5082: ldc_w 2774
    //   5085: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   5088: istore 8
    //   5090: aload_2
    //   5091: ldc_w 2776
    //   5094: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   5097: istore 9
    //   5099: aload_3
    //   5100: getfield 2779	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bcfj	Lbcfj;
    //   5103: ifnull +38 -> 5141
    //   5106: aload_3
    //   5107: getfield 2779	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bcfj	Lbcfj;
    //   5110: getfield 2782	bcfj:c	Landroid/view/ViewGroup;
    //   5113: instanceof 1598
    //   5116: ifeq +25 -> 5141
    //   5119: aload_3
    //   5120: getfield 2779	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bcfj	Lbcfj;
    //   5123: getfield 2782	bcfj:c	Landroid/view/ViewGroup;
    //   5126: checkcast 1598	com/tencent/biz/ui/RefreshView
    //   5129: aload_1
    //   5130: iload 6
    //   5132: iload 7
    //   5134: iload 8
    //   5136: iload 9
    //   5138: invokevirtual 2785	com/tencent/biz/ui/RefreshView:a	(Ljava/lang/String;IIII)V
    //   5141: aload_2
    //   5142: ldc_w 2787
    //   5145: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5148: ifeq +45 -> 5193
    //   5151: aload_2
    //   5152: ldc_w 2787
    //   5155: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5158: astore_1
    //   5159: aload_3
    //   5160: getfield 2779	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bcfj	Lbcfj;
    //   5163: ifnull +30 -> 5193
    //   5166: aload_3
    //   5167: getfield 2779	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bcfj	Lbcfj;
    //   5170: getfield 2782	bcfj:c	Landroid/view/ViewGroup;
    //   5173: instanceof 1598
    //   5176: ifeq +17 -> 5193
    //   5179: aload_3
    //   5180: getfield 2779	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bcfj	Lbcfj;
    //   5183: getfield 2782	bcfj:c	Landroid/view/ViewGroup;
    //   5186: checkcast 1598	com/tencent/biz/ui/RefreshView
    //   5189: aload_1
    //   5190: invokevirtual 2788	com/tencent/biz/ui/RefreshView:a	(Ljava/lang/String;)V
    //   5193: aload_3
    //   5194: invokevirtual 2790	com/tencent/mobileqq/webview/swift/WebViewFragment:f	()Z
    //   5197: ifne +146 -> 5343
    //   5200: aload_2
    //   5201: ldc_w 2792
    //   5204: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5207: ifeq +136 -> 5343
    //   5210: aload_2
    //   5211: ldc_w 2792
    //   5214: invokestatic 2737	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5217: istore 7
    //   5219: aload 4
    //   5221: ldc_w 726
    //   5224: invokevirtual 730	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   5227: astore 5
    //   5229: aload 5
    //   5231: ifnull +112 -> 5343
    //   5234: aconst_null
    //   5235: astore_1
    //   5236: aload_0
    //   5237: invokevirtual 2794	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbchq;
    //   5240: ifnull +832 -> 6072
    //   5243: aload_0
    //   5244: invokevirtual 2794	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbchq;
    //   5247: invokeinterface 2797 1 0
    //   5252: astore_1
    //   5253: iload 7
    //   5255: iconst_m1
    //   5256: if_icmpne +916 -> 6172
    //   5259: aload 5
    //   5261: invokevirtual 2800	android/view/View:getPaddingTop	()I
    //   5264: istore 6
    //   5266: aload 5
    //   5268: invokevirtual 2803	android/view/View:getPaddingBottom	()I
    //   5271: istore 7
    //   5273: aload 5
    //   5275: invokevirtual 2806	android/view/View:getPaddingLeft	()I
    //   5278: istore 8
    //   5280: aload 5
    //   5282: invokevirtual 2809	android/view/View:getPaddingRight	()I
    //   5285: istore 9
    //   5287: aload 5
    //   5289: ldc_w 2810
    //   5292: invokevirtual 2811	android/view/View:setBackgroundResource	(I)V
    //   5295: aload 5
    //   5297: iload 8
    //   5299: iload 6
    //   5301: iload 9
    //   5303: iload 7
    //   5305: invokevirtual 2814	android/view/View:setPadding	(IIII)V
    //   5308: aload_1
    //   5309: ifnull +7 -> 5316
    //   5312: aload_1
    //   5313: invokevirtual 2817	com/tencent/mobileqq/widget/WebViewProgressBar:a	()V
    //   5316: aload_3
    //   5317: getfield 2819	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5320: ifnull +23 -> 5343
    //   5323: aload_3
    //   5324: invokevirtual 2821	com/tencent/mobileqq/webview/swift/WebViewFragment:d	()Z
    //   5327: ifeq +769 -> 6096
    //   5330: aload_3
    //   5331: getfield 2819	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5334: iconst_4
    //   5335: invokevirtual 1524	android/view/View:setVisibility	(I)V
    //   5338: aload_3
    //   5339: iconst_0
    //   5340: invokevirtual 2823	com/tencent/mobileqq/webview/swift/WebViewFragment:j	(Z)V
    //   5343: aload_2
    //   5344: ldc_w 1390
    //   5347: iconst_m1
    //   5348: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5351: istore 6
    //   5353: aload_0
    //   5354: iconst_2
    //   5355: invokespecial 1394	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5358: checkcast 1396	bcfj
    //   5361: astore_1
    //   5362: iload 6
    //   5364: iflt +98 -> 5462
    //   5367: aload_1
    //   5368: ifnull +94 -> 5462
    //   5371: aload_1
    //   5372: getfield 1399	bcfj:jdField_a_of_type_Bcfm	Lbcfm;
    //   5375: astore 5
    //   5377: iconst_1
    //   5378: iload 6
    //   5380: if_icmpne +12157 -> 17537
    //   5383: iconst_1
    //   5384: istore 12
    //   5386: aload 5
    //   5388: iload 12
    //   5390: putfield 1404	bcfm:z	Z
    //   5393: aload_0
    //   5394: getfield 2160	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5397: ifeq +23 -> 5420
    //   5400: aload_1
    //   5401: aload_1
    //   5402: getfield 2824	bcfj:jdField_a_of_type_Bcbv	Lbcbv;
    //   5405: getfield 2149	bcbv:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   5408: iconst_0
    //   5409: aload_0
    //   5410: getfield 2160	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5413: aload_0
    //   5414: getfield 2160	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5417: invokevirtual 2163	bcfj:a	(Landroid/view/View;ZII)V
    //   5420: aload_0
    //   5421: getfield 2173	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5424: ifeq +20 -> 5444
    //   5427: aload_1
    //   5428: aload_0
    //   5429: getfield 706	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   5432: iconst_0
    //   5433: aload_0
    //   5434: getfield 2173	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5437: aload_0
    //   5438: getfield 2173	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5441: invokevirtual 2163	bcfj:a	(Landroid/view/View;ZII)V
    //   5444: aload_1
    //   5445: aload_1
    //   5446: getfield 2824	bcfj:jdField_a_of_type_Bcbv	Lbcbv;
    //   5449: getfield 2090	bcbv:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   5452: iconst_1
    //   5453: ldc_w 2825
    //   5456: ldc_w 2826
    //   5459: invokevirtual 2163	bcfj:a	(Landroid/view/View;ZII)V
    //   5462: aload_2
    //   5463: ldc_w 2828
    //   5466: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5469: ifeq +22 -> 5491
    //   5472: aload_2
    //   5473: ldc_w 2828
    //   5476: invokestatic 2737	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5479: istore 6
    //   5481: iload 6
    //   5483: iconst_m1
    //   5484: if_icmpne +939 -> 6423
    //   5487: aload_3
    //   5488: invokevirtual 2831	com/tencent/mobileqq/webview/swift/WebViewFragment:H	()V
    //   5491: aload_2
    //   5492: ldc_w 2833
    //   5495: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5498: ifeq +14 -> 5512
    //   5501: aload_3
    //   5502: aload_2
    //   5503: ldc_w 2833
    //   5506: invokevirtual 2836	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5509: invokevirtual 2837	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(Z)V
    //   5512: aload_2
    //   5513: ldc_w 2839
    //   5516: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5519: ifeq +25 -> 5544
    //   5522: aload_2
    //   5523: ldc_w 2839
    //   5526: invokevirtual 2836	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5529: ifeq +952 -> 6481
    //   5532: aload_3
    //   5533: aload_3
    //   5534: invokevirtual 2840	com/tencent/mobileqq/webview/swift/WebViewFragment:a	()J
    //   5537: ldc2_w 2841
    //   5540: land
    //   5541: invokevirtual 2844	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(J)V
    //   5544: aload_2
    //   5545: ldc_w 2846
    //   5548: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5551: ifeq +22 -> 5573
    //   5554: aload_2
    //   5555: ldc_w 2846
    //   5558: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5561: astore 5
    //   5563: aload 4
    //   5565: checkcast 1181	com/tencent/mobileqq/activity/QQBrowserActivity
    //   5568: aload 5
    //   5570: invokevirtual 2848	com/tencent/mobileqq/activity/QQBrowserActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   5573: aload_2
    //   5574: ldc_w 2850
    //   5577: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5580: ifeq +49 -> 5629
    //   5583: aload_2
    //   5584: ldc_w 2850
    //   5587: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   5590: istore 12
    //   5592: sipush 800
    //   5595: istore 6
    //   5597: aload_2
    //   5598: ldc_w 2852
    //   5601: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5604: ifeq +17 -> 5621
    //   5607: aload_2
    //   5608: ldc_w 2852
    //   5611: invokevirtual 2856	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   5614: ldc2_w 2857
    //   5617: dmul
    //   5618: d2i
    //   5619: istore 6
    //   5621: aload_0
    //   5622: iload 12
    //   5624: iload 6
    //   5626: invokevirtual 2860	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZI)V
    //   5629: aload_2
    //   5630: ldc_w 2862
    //   5633: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5636: ifeq +44 -> 5680
    //   5639: aload_2
    //   5640: ldc_w 2862
    //   5643: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5646: istore 6
    //   5648: aload_1
    //   5649: ifnull +31 -> 5680
    //   5652: iload 6
    //   5654: ifne +842 -> 6496
    //   5657: aload_1
    //   5658: getfield 1399	bcfj:jdField_a_of_type_Bcfm	Lbcfm;
    //   5661: iconst_0
    //   5662: putfield 2863	bcfm:jdField_d_of_type_Boolean	Z
    //   5665: aload_1
    //   5666: getfield 1399	bcfj:jdField_a_of_type_Bcfm	Lbcfm;
    //   5669: iconst_1
    //   5670: invokestatic 857	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5673: putfield 2866	bcfm:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   5676: aload_1
    //   5677: invokevirtual 2868	bcfj:j	()V
    //   5680: aload_2
    //   5681: ldc_w 2870
    //   5684: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5687: ifeq +26 -> 5713
    //   5690: aload_2
    //   5691: ldc_w 2870
    //   5694: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5697: istore 6
    //   5699: aload_1
    //   5700: ifnull +13 -> 5713
    //   5703: iload 6
    //   5705: iconst_1
    //   5706: if_icmpne +7 -> 5713
    //   5709: aload_1
    //   5710: invokevirtual 2872	bcfj:h	()V
    //   5713: aload_2
    //   5714: ldc_w 2874
    //   5717: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5720: ifeq +18 -> 5738
    //   5723: aload_2
    //   5724: ldc_w 2874
    //   5727: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5730: iconst_1
    //   5731: if_icmpne +7 -> 5738
    //   5734: aload_1
    //   5735: invokevirtual 2876	bcfj:i	()V
    //   5738: aload_2
    //   5739: ldc_w 2878
    //   5742: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5745: ifeq +63 -> 5808
    //   5748: aload_2
    //   5749: ldc_w 2878
    //   5752: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5755: istore 6
    //   5757: aload_0
    //   5758: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   5761: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   5764: astore 5
    //   5766: aload 5
    //   5768: ifnull +40 -> 5808
    //   5771: aload 5
    //   5773: instanceof 1323
    //   5776: ifeq +32 -> 5808
    //   5779: aload 4
    //   5781: checkcast 1323	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   5784: invokevirtual 2880	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   5787: checkcast 2882	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   5790: astore 4
    //   5792: aload 4
    //   5794: ifnull +14 -> 5808
    //   5797: iload 6
    //   5799: iconst_1
    //   5800: if_icmpne +724 -> 6524
    //   5803: aload 4
    //   5805: invokevirtual 2884	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:l	()V
    //   5808: aload_2
    //   5809: ldc_w 2886
    //   5812: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5815: ifeq +23 -> 5838
    //   5818: aload_2
    //   5819: ldc_w 2886
    //   5822: iconst_0
    //   5823: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5826: istore 12
    //   5828: aload_1
    //   5829: ifnull +9 -> 5838
    //   5832: aload_1
    //   5833: iload 12
    //   5835: invokevirtual 2888	bcfj:c	(Z)V
    //   5838: aload_2
    //   5839: ldc_w 2890
    //   5842: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5845: ifeq +38 -> 5883
    //   5848: aload_2
    //   5849: ldc_w 2890
    //   5852: iconst_0
    //   5853: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5856: istore 12
    //   5858: aload_1
    //   5859: ifnull +24 -> 5883
    //   5862: aload_1
    //   5863: getfield 2824	bcfj:jdField_a_of_type_Bcbv	Lbcbv;
    //   5866: getfield 2891	bcbv:jdField_a_of_type_Bcfm	Lbcfm;
    //   5869: getfield 2893	bcfm:l	Z
    //   5872: iload 12
    //   5874: if_icmpeq +9 -> 5883
    //   5877: aload_1
    //   5878: iload 12
    //   5880: invokevirtual 2895	bcfj:d	(Z)V
    //   5883: aload_2
    //   5884: ldc_w 2897
    //   5887: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5890: ifeq -5706 -> 184
    //   5893: aload_1
    //   5894: ifnull -5710 -> 184
    //   5897: aload_2
    //   5898: ldc_w 2897
    //   5901: iconst_0
    //   5902: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5905: ifeq +632 -> 6537
    //   5908: aload_3
    //   5909: invokevirtual 2790	com/tencent/mobileqq/webview/swift/WebViewFragment:f	()Z
    //   5912: ifne -5728 -> 184
    //   5915: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5918: ifeq +12 -> 5930
    //   5921: ldc 191
    //   5923: iconst_4
    //   5924: ldc_w 2899
    //   5927: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5930: aload_1
    //   5931: getfield 1399	bcfj:jdField_a_of_type_Bcfm	Lbcfm;
    //   5934: iconst_1
    //   5935: putfield 2900	bcfm:jdField_a_of_type_Boolean	Z
    //   5938: aload_0
    //   5939: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   5942: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   5945: invokevirtual 2904	android/app/Activity:getWindow	()Landroid/view/Window;
    //   5948: sipush 1024
    //   5951: sipush 1024
    //   5954: invokevirtual 2908	android/view/Window:setFlags	(II)V
    //   5957: aload_3
    //   5958: invokevirtual 2911	com/tencent/mobileqq/webview/swift/WebViewFragment:D	()V
    //   5961: aload_3
    //   5962: iconst_0
    //   5963: invokevirtual 2913	com/tencent/mobileqq/webview/swift/WebViewFragment:g	(Z)V
    //   5966: goto -5782 -> 184
    //   5969: astore_1
    //   5970: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5973: ifeq -5789 -> 184
    //   5976: ldc 191
    //   5978: iconst_4
    //   5979: new 497	java/lang/StringBuilder
    //   5982: dup
    //   5983: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   5986: ldc_w 2915
    //   5989: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5992: aload_1
    //   5993: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5996: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5999: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6002: goto -5818 -> 184
    //   6005: aload 5
    //   6007: bipush 8
    //   6009: invokevirtual 752	android/widget/ImageView:setVisibility	(I)V
    //   6012: aload_1
    //   6013: iconst_0
    //   6014: invokevirtual 2762	android/widget/TextView:setVisibility	(I)V
    //   6017: goto -1042 -> 4975
    //   6020: astore_1
    //   6021: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6024: ifeq -5840 -> 184
    //   6027: ldc 191
    //   6029: iconst_4
    //   6030: new 497	java/lang/StringBuilder
    //   6033: dup
    //   6034: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   6037: ldc_w 2915
    //   6040: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6043: aload_1
    //   6044: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6047: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6050: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6053: goto -5869 -> 184
    //   6056: aload_1
    //   6057: bipush 8
    //   6059: invokevirtual 2762	android/widget/TextView:setVisibility	(I)V
    //   6062: aload 5
    //   6064: bipush 8
    //   6066: invokevirtual 752	android/widget/ImageView:setVisibility	(I)V
    //   6069: goto -1094 -> 4975
    //   6072: aload_0
    //   6073: iconst_2
    //   6074: invokespecial 1394	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   6077: checkcast 1396	bcfj
    //   6080: astore 14
    //   6082: aload 14
    //   6084: ifnull -831 -> 5253
    //   6087: aload 14
    //   6089: getfield 2918	bcfj:jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar	Lcom/tencent/mobileqq/widget/WebViewProgressBar;
    //   6092: astore_1
    //   6093: goto -840 -> 5253
    //   6096: iconst_0
    //   6097: invokestatic 2922	com/tencent/mobileqq/theme/ThemeUtil:isDefaultOrDIYTheme	(Z)Z
    //   6100: ifeq +24 -> 6124
    //   6103: aload_3
    //   6104: getfield 2819	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6107: ldc_w 2923
    //   6110: invokevirtual 2811	android/view/View:setBackgroundResource	(I)V
    //   6113: aload_3
    //   6114: getfield 2819	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6117: iconst_0
    //   6118: invokevirtual 1524	android/view/View:setVisibility	(I)V
    //   6121: goto -783 -> 5338
    //   6124: aload_3
    //   6125: getfield 2819	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6128: invokestatic 583	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6131: invokevirtual 2924	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   6134: ldc_w 2925
    //   6137: invokevirtual 1500	android/content/res/Resources:getColor	(I)I
    //   6140: invokevirtual 2740	android/view/View:setBackgroundColor	(I)V
    //   6143: iconst_0
    //   6144: invokestatic 583	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6147: invokevirtual 2924	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   6150: ldc_w 2925
    //   6153: invokevirtual 1500	android/content/res/Resources:getColor	(I)I
    //   6156: aload_0
    //   6157: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   6160: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   6163: invokevirtual 2904	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6166: invokestatic 2930	axmt:a	(ZILandroid/view/Window;)V
    //   6169: goto -56 -> 6113
    //   6172: aload 5
    //   6174: iconst_0
    //   6175: invokevirtual 2811	android/view/View:setBackgroundResource	(I)V
    //   6178: ldc_w 1611
    //   6181: istore 6
    //   6183: aload_2
    //   6184: ldc_w 2932
    //   6187: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6190: ifeq +15 -> 6205
    //   6193: aload_2
    //   6194: ldc_w 2932
    //   6197: invokestatic 2737	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6200: bipush 24
    //   6202: ishl
    //   6203: istore 6
    //   6205: iload 7
    //   6207: iload 6
    //   6209: ior
    //   6210: istore 8
    //   6212: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6215: ifeq +61 -> 6276
    //   6218: ldc 191
    //   6220: iconst_2
    //   6221: new 497	java/lang/StringBuilder
    //   6224: dup
    //   6225: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   6228: ldc_w 2934
    //   6231: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6234: iload 6
    //   6236: invokestatic 2745	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   6239: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6242: ldc_w 2936
    //   6245: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6248: iload 7
    //   6250: invokestatic 2745	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   6253: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6256: ldc_w 2938
    //   6259: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6262: iload 8
    //   6264: invokestatic 2745	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   6267: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6270: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6273: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6276: aload 5
    //   6278: iload 8
    //   6280: invokevirtual 2740	android/view/View:setBackgroundColor	(I)V
    //   6283: aload_1
    //   6284: ifnull +13 -> 6297
    //   6287: aload_1
    //   6288: ldc_w 1611
    //   6291: iload 7
    //   6293: ior
    //   6294: invokevirtual 2941	com/tencent/mobileqq/widget/WebViewProgressBar:setCustomColor	(I)V
    //   6297: aload_3
    //   6298: invokevirtual 2821	com/tencent/mobileqq/webview/swift/WebViewFragment:d	()Z
    //   6301: ifeq +24 -> 6325
    //   6304: aload_3
    //   6305: getfield 2819	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6308: ifnonnull +71 -> 6379
    //   6311: aload_3
    //   6312: iconst_1
    //   6313: invokevirtual 2943	com/tencent/mobileqq/webview/swift/WebViewFragment:k	(Z)V
    //   6316: aload_3
    //   6317: iconst_1
    //   6318: invokevirtual 2945	com/tencent/mobileqq/webview/swift/WebViewFragment:l	(Z)V
    //   6321: aload_3
    //   6322: invokevirtual 2947	com/tencent/mobileqq/webview/swift/WebViewFragment:F	()V
    //   6325: aload_3
    //   6326: getfield 2819	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6329: ifnull -986 -> 5343
    //   6332: aload_2
    //   6333: ldc_w 2949
    //   6336: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6339: ifeq +51 -> 6390
    //   6342: aload_2
    //   6343: ldc_w 2949
    //   6346: invokestatic 2737	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6349: istore 6
    //   6351: aload_3
    //   6352: getfield 2819	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6355: iload 6
    //   6357: invokevirtual 2740	android/view/View:setBackgroundColor	(I)V
    //   6360: iconst_1
    //   6361: iload 6
    //   6363: aload_0
    //   6364: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   6367: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   6370: invokevirtual 2904	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6373: invokestatic 2930	axmt:a	(ZILandroid/view/Window;)V
    //   6376: goto -1033 -> 5343
    //   6379: aload_3
    //   6380: getfield 2819	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6383: iconst_0
    //   6384: invokevirtual 1524	android/view/View:setVisibility	(I)V
    //   6387: goto -62 -> 6325
    //   6390: aload_3
    //   6391: getfield 2819	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6394: iload 8
    //   6396: invokevirtual 2740	android/view/View:setBackgroundColor	(I)V
    //   6399: iconst_1
    //   6400: iload 8
    //   6402: aload_0
    //   6403: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   6406: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   6409: invokevirtual 2904	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6412: invokestatic 2930	axmt:a	(ZILandroid/view/Window;)V
    //   6415: aload_3
    //   6416: iconst_1
    //   6417: invokevirtual 2823	com/tencent/mobileqq/webview/swift/WebViewFragment:j	(Z)V
    //   6420: goto -1077 -> 5343
    //   6423: aload_3
    //   6424: ldc_w 1611
    //   6427: iload 6
    //   6429: ior
    //   6430: invokevirtual 2951	com/tencent/mobileqq/webview/swift/WebViewFragment:d	(I)V
    //   6433: aload_2
    //   6434: ldc_w 2953
    //   6437: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6440: ifeq +11103 -> 17543
    //   6443: aload_2
    //   6444: ldc_w 2953
    //   6447: invokestatic 2737	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6450: istore 7
    //   6452: iload 7
    //   6454: iconst_m1
    //   6455: if_icmpeq +11088 -> 17543
    //   6458: ldc_w 1611
    //   6461: iload 7
    //   6463: ior
    //   6464: istore 6
    //   6466: aload_3
    //   6467: iload 6
    //   6469: invokevirtual 2955	com/tencent/mobileqq/webview/swift/WebViewFragment:e	(I)V
    //   6472: aload_0
    //   6473: iload 6
    //   6475: invokevirtual 2957	com/tencent/mobileqq/jsp/UiApiPlugin:a	(I)V
    //   6478: goto -987 -> 5491
    //   6481: aload_3
    //   6482: aload_3
    //   6483: invokevirtual 2840	com/tencent/mobileqq/webview/swift/WebViewFragment:a	()J
    //   6486: ldc2_w 2245
    //   6489: lor
    //   6490: invokevirtual 2844	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(J)V
    //   6493: goto -949 -> 5544
    //   6496: iload 6
    //   6498: iconst_1
    //   6499: if_icmpne -823 -> 5676
    //   6502: aload_1
    //   6503: getfield 1399	bcfj:jdField_a_of_type_Bcfm	Lbcfm;
    //   6506: iconst_1
    //   6507: putfield 2863	bcfm:jdField_d_of_type_Boolean	Z
    //   6510: aload_1
    //   6511: getfield 1399	bcfj:jdField_a_of_type_Bcfm	Lbcfm;
    //   6514: iconst_0
    //   6515: invokestatic 857	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6518: putfield 2866	bcfm:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   6521: goto -845 -> 5676
    //   6524: iload 6
    //   6526: ifne -718 -> 5808
    //   6529: aload 4
    //   6531: invokevirtual 2959	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:m	()V
    //   6534: goto -726 -> 5808
    //   6537: aload_3
    //   6538: invokevirtual 2790	com/tencent/mobileqq/webview/swift/WebViewFragment:f	()Z
    //   6541: ifeq -6357 -> 184
    //   6544: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6547: ifeq +12 -> 6559
    //   6550: ldc 191
    //   6552: iconst_4
    //   6553: ldc_w 2961
    //   6556: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6559: aload_1
    //   6560: getfield 1399	bcfj:jdField_a_of_type_Bcfm	Lbcfm;
    //   6563: iconst_0
    //   6564: putfield 2900	bcfm:jdField_a_of_type_Boolean	Z
    //   6567: aload_0
    //   6568: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   6571: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   6574: invokevirtual 2904	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6577: sipush 1024
    //   6580: invokevirtual 2964	android/view/Window:clearFlags	(I)V
    //   6583: aload_3
    //   6584: invokevirtual 2967	com/tencent/mobileqq/webview/swift/WebViewFragment:E	()V
    //   6587: aload_3
    //   6588: iconst_1
    //   6589: invokevirtual 2913	com/tencent/mobileqq/webview/swift/WebViewFragment:g	(Z)V
    //   6592: goto -6408 -> 184
    //   6595: ldc_w 2969
    //   6598: aload 4
    //   6600: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6603: ifeq +484 -> 7087
    //   6606: aload 5
    //   6608: arraylength
    //   6609: iconst_1
    //   6610: if_icmpgt +477 -> 7087
    //   6613: new 109	org/json/JSONObject
    //   6616: dup
    //   6617: aload 5
    //   6619: iconst_0
    //   6620: aaload
    //   6621: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6624: astore_1
    //   6625: aload_0
    //   6626: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   6629: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   6632: instanceof 1181
    //   6635: ifne +5 -> 6640
    //   6638: iconst_1
    //   6639: ireturn
    //   6640: new 2971	xmd
    //   6643: dup
    //   6644: invokespecial 2972	xmd:<init>	()V
    //   6647: astore_2
    //   6648: aload_1
    //   6649: ldc_w 2974
    //   6652: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6655: ifeq +18 -> 6673
    //   6658: aload_2
    //   6659: aload_1
    //   6660: ldc_w 2974
    //   6663: invokestatic 2737	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6666: ldc_w 1611
    //   6669: ior
    //   6670: putfield 2975	xmd:jdField_a_of_type_Int	I
    //   6673: aload_1
    //   6674: ldc_w 1380
    //   6677: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6680: ifeq +14 -> 6694
    //   6683: aload_2
    //   6684: aload_1
    //   6685: ldc_w 1380
    //   6688: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6691: putfield 2976	xmd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6694: aload_1
    //   6695: ldc_w 2978
    //   6698: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6701: ifeq +176 -> 6877
    //   6704: aload_2
    //   6705: new 1453	java/util/ArrayList
    //   6708: dup
    //   6709: invokespecial 1850	java/util/ArrayList:<init>	()V
    //   6712: putfield 2981	xmd:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6715: aload_1
    //   6716: ldc_w 2978
    //   6719: invokevirtual 921	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6722: astore_3
    //   6723: aload_3
    //   6724: invokevirtual 936	org/json/JSONArray:length	()I
    //   6727: istore 7
    //   6729: iconst_0
    //   6730: istore 6
    //   6732: iload 6
    //   6734: iload 7
    //   6736: if_icmpge +141 -> 6877
    //   6739: aload_3
    //   6740: iload 6
    //   6742: invokevirtual 2984	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6745: astore 4
    //   6747: new 2986	xmc
    //   6750: dup
    //   6751: invokespecial 2987	xmc:<init>	()V
    //   6754: astore 5
    //   6756: aload 4
    //   6758: ldc_w 1435
    //   6761: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6764: ifeq +16 -> 6780
    //   6767: aload 5
    //   6769: aload 4
    //   6771: ldc_w 1435
    //   6774: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6777: putfield 2988	xmc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6780: aload 4
    //   6782: ldc_w 1905
    //   6785: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6788: ifeq +16 -> 6804
    //   6791: aload 5
    //   6793: aload 4
    //   6795: ldc_w 1905
    //   6798: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6801: putfield 2989	xmc:jdField_a_of_type_Int	I
    //   6804: aload 4
    //   6806: ldc_w 2991
    //   6809: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6812: ifeq +16 -> 6828
    //   6815: aload 5
    //   6817: aload 4
    //   6819: ldc_w 2991
    //   6822: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6825: putfield 2992	xmc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6828: aload 4
    //   6830: ldc_w 1437
    //   6833: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6836: ifeq +20 -> 6856
    //   6839: aload 5
    //   6841: aload 4
    //   6843: ldc_w 1437
    //   6846: invokestatic 2737	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6849: ldc_w 1611
    //   6852: ior
    //   6853: putfield 2993	xmc:jdField_b_of_type_Int	I
    //   6856: aload_2
    //   6857: getfield 2981	xmd:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6860: aload 5
    //   6862: invokeinterface 1950 2 0
    //   6867: pop
    //   6868: iload 6
    //   6870: iconst_1
    //   6871: iadd
    //   6872: istore 6
    //   6874: goto -142 -> 6732
    //   6877: aload_1
    //   6878: ldc_w 2995
    //   6881: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6884: ifeq +78 -> 6962
    //   6887: aload_2
    //   6888: new 1453	java/util/ArrayList
    //   6891: dup
    //   6892: invokespecial 1850	java/util/ArrayList:<init>	()V
    //   6895: putfield 2997	xmd:b	Ljava/util/List;
    //   6898: aload_1
    //   6899: ldc_w 2995
    //   6902: invokevirtual 921	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6905: astore_1
    //   6906: aload_1
    //   6907: invokevirtual 936	org/json/JSONArray:length	()I
    //   6910: istore 7
    //   6912: iconst_0
    //   6913: istore 6
    //   6915: iload 6
    //   6917: iload 7
    //   6919: if_icmpge +43 -> 6962
    //   6922: aload_1
    //   6923: iload 6
    //   6925: invokevirtual 2984	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6928: ldc 156
    //   6930: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6933: ifeq +10621 -> 17554
    //   6936: aload_1
    //   6937: iload 6
    //   6939: invokevirtual 2984	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6942: ldc 156
    //   6944: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6947: astore_3
    //   6948: aload_2
    //   6949: getfield 2997	xmd:b	Ljava/util/List;
    //   6952: aload_3
    //   6953: invokeinterface 1950 2 0
    //   6958: pop
    //   6959: goto +10595 -> 17554
    //   6962: aload_0
    //   6963: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   6966: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6969: astore_1
    //   6970: aload_1
    //   6971: ifnull +10469 -> 17440
    //   6974: aload_1
    //   6975: invokevirtual 2032	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6978: astore_1
    //   6979: aload_1
    //   6980: ifnull +10460 -> 17440
    //   6983: aload_1
    //   6984: ldc_w 2999
    //   6987: invokevirtual 3002	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6990: astore_1
    //   6991: aload_1
    //   6992: ifnull +10448 -> 17440
    //   6995: aload_1
    //   6996: instanceof 207
    //   6999: ifeq +10441 -> 17440
    //   7002: aload_1
    //   7003: checkcast 207	xlv
    //   7006: astore_1
    //   7007: aload_1
    //   7008: ifnull -6824 -> 184
    //   7011: aload_1
    //   7012: aload_2
    //   7013: invokevirtual 3005	xlv:a	(Lxmd;)V
    //   7016: aload_2
    //   7017: getfield 2976	xmd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7020: ifnull -6836 -> 184
    //   7023: aload_1
    //   7024: invokestatic 3007	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lxlv;)Ljava/lang/String;
    //   7027: astore_1
    //   7028: aload_1
    //   7029: ifnull -6845 -> 184
    //   7032: aload_0
    //   7033: aload_2
    //   7034: getfield 2976	xmd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7037: iconst_1
    //   7038: anewarray 334	java/lang/String
    //   7041: dup
    //   7042: iconst_0
    //   7043: aload_1
    //   7044: aastore
    //   7045: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7048: goto -6864 -> 184
    //   7051: astore_1
    //   7052: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7055: ifeq -6871 -> 184
    //   7058: ldc 191
    //   7060: iconst_4
    //   7061: new 497	java/lang/StringBuilder
    //   7064: dup
    //   7065: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   7068: ldc_w 3009
    //   7071: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7074: aload_1
    //   7075: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7078: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7081: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7084: goto -6900 -> 184
    //   7087: ldc_w 3011
    //   7090: aload 4
    //   7092: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7095: ifeq +176 -> 7271
    //   7098: aload 5
    //   7100: arraylength
    //   7101: iconst_1
    //   7102: if_icmpgt +169 -> 7271
    //   7105: new 109	org/json/JSONObject
    //   7108: dup
    //   7109: aload 5
    //   7111: iconst_0
    //   7112: aaload
    //   7113: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7116: astore_1
    //   7117: aload_0
    //   7118: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   7121: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   7124: instanceof 1181
    //   7127: ifne +5 -> 7132
    //   7130: iconst_1
    //   7131: ireturn
    //   7132: aload_1
    //   7133: ldc_w 3012
    //   7136: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7139: ifeq -6955 -> 184
    //   7142: aload_1
    //   7143: ldc_w 3012
    //   7146: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   7149: istore 12
    //   7151: aload_1
    //   7152: ldc_w 3014
    //   7155: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7158: ifeq +10276 -> 17434
    //   7161: aload_1
    //   7162: ldc_w 3014
    //   7165: invokevirtual 2856	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   7168: ldc2_w 2857
    //   7171: dmul
    //   7172: d2i
    //   7173: istore 6
    //   7175: aload_0
    //   7176: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   7179: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7182: astore_1
    //   7183: aload_1
    //   7184: ifnull +10245 -> 17429
    //   7187: aload_1
    //   7188: invokevirtual 2032	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   7191: astore_1
    //   7192: aload_1
    //   7193: ifnull +10236 -> 17429
    //   7196: aload_1
    //   7197: ldc_w 2999
    //   7200: invokevirtual 3002	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   7203: astore_1
    //   7204: aload_1
    //   7205: ifnull +10224 -> 17429
    //   7208: aload_1
    //   7209: instanceof 207
    //   7212: ifeq +10217 -> 17429
    //   7215: aload_1
    //   7216: checkcast 207	xlv
    //   7219: astore_1
    //   7220: aload_1
    //   7221: ifnull -7037 -> 184
    //   7224: aload_1
    //   7225: iload 12
    //   7227: iload 6
    //   7229: invokevirtual 3015	xlv:a	(ZI)V
    //   7232: goto -7048 -> 184
    //   7235: astore_1
    //   7236: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7239: ifeq -7055 -> 184
    //   7242: ldc 191
    //   7244: iconst_4
    //   7245: new 497	java/lang/StringBuilder
    //   7248: dup
    //   7249: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   7252: ldc_w 3017
    //   7255: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7258: aload_1
    //   7259: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7262: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7265: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7268: goto -7084 -> 184
    //   7271: ldc_w 3019
    //   7274: aload 4
    //   7276: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7279: ifeq +226 -> 7505
    //   7282: aload 5
    //   7284: arraylength
    //   7285: iconst_1
    //   7286: if_icmpgt +219 -> 7505
    //   7289: new 109	org/json/JSONObject
    //   7292: dup
    //   7293: aload 5
    //   7295: iconst_0
    //   7296: aaload
    //   7297: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7300: astore_1
    //   7301: aload_0
    //   7302: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   7305: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   7308: instanceof 1181
    //   7311: ifne +5 -> 7316
    //   7314: iconst_1
    //   7315: ireturn
    //   7316: new 2986	xmc
    //   7319: dup
    //   7320: invokespecial 2987	xmc:<init>	()V
    //   7323: astore_2
    //   7324: aload_1
    //   7325: ldc_w 1435
    //   7328: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7331: ifeq +14 -> 7345
    //   7334: aload_2
    //   7335: aload_1
    //   7336: ldc_w 1435
    //   7339: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7342: putfield 2988	xmc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7345: aload_1
    //   7346: ldc_w 1905
    //   7349: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7352: ifeq +14 -> 7366
    //   7355: aload_2
    //   7356: aload_1
    //   7357: ldc_w 1905
    //   7360: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7363: putfield 2989	xmc:jdField_a_of_type_Int	I
    //   7366: aload_1
    //   7367: ldc_w 2991
    //   7370: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7373: ifeq +14 -> 7387
    //   7376: aload_2
    //   7377: aload_1
    //   7378: ldc_w 2991
    //   7381: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7384: putfield 2992	xmc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7387: aload_1
    //   7388: ldc_w 1437
    //   7391: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7394: ifeq +18 -> 7412
    //   7397: aload_2
    //   7398: aload_1
    //   7399: ldc_w 1437
    //   7402: invokestatic 2737	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   7405: ldc_w 1611
    //   7408: ior
    //   7409: putfield 2993	xmc:jdField_b_of_type_Int	I
    //   7412: aload_0
    //   7413: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   7416: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7419: astore_1
    //   7420: aload_1
    //   7421: ifnull +10003 -> 17424
    //   7424: aload_1
    //   7425: invokevirtual 2032	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   7428: astore_1
    //   7429: aload_1
    //   7430: ifnull +9994 -> 17424
    //   7433: aload_1
    //   7434: ldc_w 2999
    //   7437: invokevirtual 3002	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   7440: astore_1
    //   7441: aload_1
    //   7442: ifnull +9982 -> 17424
    //   7445: aload_1
    //   7446: instanceof 207
    //   7449: ifeq +9975 -> 17424
    //   7452: aload_1
    //   7453: checkcast 207	xlv
    //   7456: astore_1
    //   7457: aload_1
    //   7458: ifnull -7274 -> 184
    //   7461: aload_1
    //   7462: aload_2
    //   7463: invokevirtual 3022	xlv:a	(Lxmc;)V
    //   7466: goto -7282 -> 184
    //   7469: astore_1
    //   7470: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7473: ifeq -7289 -> 184
    //   7476: ldc 191
    //   7478: iconst_4
    //   7479: new 497	java/lang/StringBuilder
    //   7482: dup
    //   7483: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   7486: ldc_w 3024
    //   7489: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7492: aload_1
    //   7493: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7496: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7499: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7502: goto -7318 -> 184
    //   7505: ldc_w 3026
    //   7508: aload 4
    //   7510: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7513: ifeq +110 -> 7623
    //   7516: aload 5
    //   7518: arraylength
    //   7519: iconst_1
    //   7520: if_icmpgt +103 -> 7623
    //   7523: aload 5
    //   7525: arraylength
    //   7526: iconst_1
    //   7527: if_icmpne +22 -> 7549
    //   7530: new 109	org/json/JSONObject
    //   7533: dup
    //   7534: aload 5
    //   7536: iconst_0
    //   7537: aaload
    //   7538: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7541: ldc_w 3028
    //   7544: iconst_0
    //   7545: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7548: pop
    //   7549: aload_0
    //   7550: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   7553: aload_0
    //   7554: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   7557: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   7560: invokevirtual 699	bcdb:a	(Landroid/app/Activity;)Lbcci;
    //   7563: astore_1
    //   7564: aload_1
    //   7565: ifnull -7381 -> 184
    //   7568: aload_1
    //   7569: instanceof 3030
    //   7572: ifeq -7388 -> 184
    //   7575: aload_1
    //   7576: checkcast 3030	bchv
    //   7579: invokeinterface 3031 1 0
    //   7584: goto -7400 -> 184
    //   7587: astore_1
    //   7588: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7591: ifeq -7407 -> 184
    //   7594: ldc 191
    //   7596: iconst_4
    //   7597: new 497	java/lang/StringBuilder
    //   7600: dup
    //   7601: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   7604: ldc_w 3033
    //   7607: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7610: aload_1
    //   7611: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7614: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7617: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7620: goto -7436 -> 184
    //   7623: ldc_w 3035
    //   7626: aload 4
    //   7628: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7631: ifeq +195 -> 7826
    //   7634: aload 5
    //   7636: arraylength
    //   7637: iconst_1
    //   7638: if_icmpne +188 -> 7826
    //   7641: new 109	org/json/JSONObject
    //   7644: dup
    //   7645: aload 5
    //   7647: iconst_0
    //   7648: aaload
    //   7649: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7652: astore_1
    //   7653: aload_1
    //   7654: ldc_w 831
    //   7657: iconst_0
    //   7658: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7661: istore 6
    //   7663: aload_1
    //   7664: ldc_w 839
    //   7667: iconst_0
    //   7668: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7671: istore 7
    //   7673: aload_1
    //   7674: ldc_w 833
    //   7677: iconst_0
    //   7678: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   7681: istore 12
    //   7683: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7686: ifeq +48 -> 7734
    //   7689: ldc 191
    //   7691: iconst_2
    //   7692: new 497	java/lang/StringBuilder
    //   7695: dup
    //   7696: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   7699: ldc_w 3037
    //   7702: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7705: aload_1
    //   7706: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7709: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7712: ldc_w 3039
    //   7715: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7718: aload_0
    //   7719: getfield 97	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   7722: invokevirtual 844	java/lang/Object:toString	()Ljava/lang/String;
    //   7725: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7728: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7731: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7734: invokestatic 296	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7737: new 125	android/content/Intent
    //   7740: dup
    //   7741: ldc_w 2104
    //   7744: invokespecial 130	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   7747: ldc_w 831
    //   7750: iload 6
    //   7752: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7755: ldc_w 833
    //   7758: iload 12
    //   7760: invokevirtual 553	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7763: ldc_w 839
    //   7766: iload 7
    //   7768: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7771: ldc_w 841
    //   7774: aload_0
    //   7775: getfield 848	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Int	I
    //   7778: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7781: ldc_w 2106
    //   7784: invokevirtual 3044	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   7787: goto -7603 -> 184
    //   7790: astore_1
    //   7791: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7794: ifeq -7610 -> 184
    //   7797: ldc 191
    //   7799: iconst_4
    //   7800: new 497	java/lang/StringBuilder
    //   7803: dup
    //   7804: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   7807: ldc_w 3046
    //   7810: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7813: aload_1
    //   7814: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7817: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7820: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7823: goto -7639 -> 184
    //   7826: ldc_w 3048
    //   7829: aload 4
    //   7831: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7834: ifeq +258 -> 8092
    //   7837: aload 5
    //   7839: arraylength
    //   7840: iconst_1
    //   7841: if_icmpne +251 -> 8092
    //   7844: aload_0
    //   7845: aconst_null
    //   7846: putfield 3050	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7849: new 109	org/json/JSONObject
    //   7852: dup
    //   7853: aload 5
    //   7855: iconst_0
    //   7856: aaload
    //   7857: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7860: astore_3
    //   7861: aload_3
    //   7862: ldc_w 1331
    //   7865: invokevirtual 2323	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   7868: lstore 10
    //   7870: aload_3
    //   7871: ldc_w 3052
    //   7874: bipush 13
    //   7876: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7879: istore 6
    //   7881: aload_3
    //   7882: ldc_w 3054
    //   7885: iconst_0
    //   7886: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7889: istore 7
    //   7891: aload_3
    //   7892: ldc_w 1380
    //   7895: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7898: astore_1
    //   7899: aload_0
    //   7900: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   7903: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   7906: astore_2
    //   7907: aload_2
    //   7908: ifnull +10 -> 7918
    //   7911: aload_2
    //   7912: invokevirtual 3057	com/tencent/common/app/AppInterface:isLogin	()Z
    //   7915: ifne +20 -> 7935
    //   7918: aload_0
    //   7919: aload_1
    //   7920: iconst_1
    //   7921: anewarray 334	java/lang/String
    //   7924: dup
    //   7925: iconst_0
    //   7926: ldc_w 3059
    //   7929: aastore
    //   7930: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7933: iconst_1
    //   7934: ireturn
    //   7935: aload_3
    //   7936: ldc_w 2366
    //   7939: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7942: astore_3
    //   7943: aload_3
    //   7944: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7947: ifne +31 -> 7978
    //   7950: aload_3
    //   7951: aload_2
    //   7952: invokevirtual 1034	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   7955: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7958: ifne +20 -> 7978
    //   7961: aload_0
    //   7962: aload_1
    //   7963: iconst_1
    //   7964: anewarray 334	java/lang/String
    //   7967: dup
    //   7968: iconst_0
    //   7969: ldc_w 3061
    //   7972: aastore
    //   7973: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7976: iconst_1
    //   7977: ireturn
    //   7978: aload_0
    //   7979: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   7982: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   7985: astore_2
    //   7986: aload_2
    //   7987: ifnull -7803 -> 184
    //   7990: aload_0
    //   7991: aload_1
    //   7992: putfield 3050	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7995: new 125	android/content/Intent
    //   7998: dup
    //   7999: aload_2
    //   8000: ldc_w 3063
    //   8003: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8006: astore_1
    //   8007: aload_1
    //   8008: ldc_w 872
    //   8011: bipush 16
    //   8013: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8016: pop
    //   8017: aload_1
    //   8018: ldc_w 3052
    //   8021: iload 6
    //   8023: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8026: pop
    //   8027: aload_1
    //   8028: ldc_w 1331
    //   8031: lload 10
    //   8033: invokevirtual 1340	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   8036: pop
    //   8037: aload_1
    //   8038: ldc_w 3054
    //   8041: iload 7
    //   8043: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8046: pop
    //   8047: aload_0
    //   8048: aload_1
    //   8049: iconst_5
    //   8050: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   8053: goto -7869 -> 184
    //   8056: astore_1
    //   8057: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8060: ifeq -7876 -> 184
    //   8063: ldc 191
    //   8065: iconst_4
    //   8066: new 497	java/lang/StringBuilder
    //   8069: dup
    //   8070: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8073: ldc_w 3065
    //   8076: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8079: aload_1
    //   8080: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8083: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8086: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8089: goto -7905 -> 184
    //   8092: ldc_w 3067
    //   8095: aload 4
    //   8097: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8100: ifeq +269 -> 8369
    //   8103: aload 5
    //   8105: arraylength
    //   8106: iconst_1
    //   8107: if_icmpne +262 -> 8369
    //   8110: aload_0
    //   8111: aconst_null
    //   8112: putfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8115: new 109	org/json/JSONObject
    //   8118: dup
    //   8119: aload 5
    //   8121: iconst_0
    //   8122: aaload
    //   8123: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8126: astore_3
    //   8127: aload_0
    //   8128: aload_3
    //   8129: ldc_w 2366
    //   8132: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   8135: putfield 3069	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   8138: aload_3
    //   8139: ldc_w 3071
    //   8142: iconst_0
    //   8143: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   8146: istore 6
    //   8148: aload_0
    //   8149: aload_3
    //   8150: ldc_w 3073
    //   8153: iconst_0
    //   8154: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8157: putfield 3075	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   8160: aload_3
    //   8161: ldc_w 1380
    //   8164: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   8167: astore_1
    //   8168: aload_0
    //   8169: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   8172: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   8175: astore_2
    //   8176: aload_2
    //   8177: ifnull +10 -> 8187
    //   8180: aload_2
    //   8181: invokevirtual 3057	com/tencent/common/app/AppInterface:isLogin	()Z
    //   8184: ifne +20 -> 8204
    //   8187: aload_0
    //   8188: aload_1
    //   8189: iconst_1
    //   8190: anewarray 334	java/lang/String
    //   8193: dup
    //   8194: iconst_0
    //   8195: ldc_w 3077
    //   8198: aastore
    //   8199: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8202: iconst_1
    //   8203: ireturn
    //   8204: aload_0
    //   8205: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   8208: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   8211: astore_2
    //   8212: aload_2
    //   8213: ifnull -8029 -> 184
    //   8216: iload 6
    //   8218: ifne -8034 -> 184
    //   8221: aload_3
    //   8222: ldc_w 909
    //   8225: aload_2
    //   8226: ldc_w 3078
    //   8229: invokevirtual 2240	android/app/Activity:getString	(I)Ljava/lang/String;
    //   8232: invokevirtual 2380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8235: astore_3
    //   8236: aload_0
    //   8237: aload_1
    //   8238: putfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8241: aload_0
    //   8242: getfield 3075	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   8245: ifeq +101 -> 8346
    //   8248: new 125	android/content/Intent
    //   8251: dup
    //   8252: aload_2
    //   8253: ldc_w 3080
    //   8256: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8259: astore_1
    //   8260: aload_1
    //   8261: ldc_w 3082
    //   8264: iconst_1
    //   8265: invokevirtual 553	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8268: pop
    //   8269: aload_1
    //   8270: ldc_w 3084
    //   8273: aload_0
    //   8274: getfield 3069	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   8277: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8280: pop
    //   8281: aload_1
    //   8282: ldc_w 3086
    //   8285: aload_3
    //   8286: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8289: pop
    //   8290: aload_0
    //   8291: aload_1
    //   8292: bipush 7
    //   8294: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   8297: aload_2
    //   8298: ldc_w 3087
    //   8301: ldc_w 3088
    //   8304: invokevirtual 1196	android/app/Activity:overridePendingTransition	(II)V
    //   8307: goto -8123 -> 184
    //   8310: astore_1
    //   8311: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8314: ifeq -8130 -> 184
    //   8317: ldc 191
    //   8319: iconst_4
    //   8320: new 497	java/lang/StringBuilder
    //   8323: dup
    //   8324: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8327: ldc_w 3090
    //   8330: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8333: aload_1
    //   8334: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8337: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8340: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8343: goto -8159 -> 184
    //   8346: aload_2
    //   8347: aload_0
    //   8348: getfield 3069	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   8351: bipush 14
    //   8353: invokestatic 2335	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   8356: astore_1
    //   8357: aload_1
    //   8358: ldc_w 3092
    //   8361: aload_3
    //   8362: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8365: pop
    //   8366: goto -76 -> 8290
    //   8369: ldc_w 3094
    //   8372: aload 4
    //   8374: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8377: ifeq +126 -> 8503
    //   8380: aload 5
    //   8382: arraylength
    //   8383: iconst_1
    //   8384: if_icmpne +119 -> 8503
    //   8387: new 109	org/json/JSONObject
    //   8390: dup
    //   8391: aload 5
    //   8393: iconst_0
    //   8394: aaload
    //   8395: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8398: astore_1
    //   8399: aload_1
    //   8400: ldc_w 3096
    //   8403: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8406: ifeq -8222 -> 184
    //   8409: aload_1
    //   8410: ldc_w 3096
    //   8413: invokevirtual 2836	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8416: istore 12
    //   8418: aload_0
    //   8419: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   8422: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   8425: invokevirtual 3097	com/tencent/biz/pubaccount/CustomWebView:getParent	()Landroid/view/ViewParent;
    //   8428: checkcast 1523	android/view/View
    //   8431: astore_1
    //   8432: aload_1
    //   8433: ifnonnull +5 -> 8438
    //   8436: iconst_1
    //   8437: ireturn
    //   8438: aload_1
    //   8439: instanceof 1598
    //   8442: ifne +5 -> 8447
    //   8445: iconst_1
    //   8446: ireturn
    //   8447: aload_0
    //   8448: aload_1
    //   8449: checkcast 1598	com/tencent/biz/ui/RefreshView
    //   8452: putfield 1600	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8455: aload_0
    //   8456: getfield 1600	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8459: iload 12
    //   8461: invokevirtual 3098	com/tencent/biz/ui/RefreshView:a	(Z)V
    //   8464: goto -8280 -> 184
    //   8467: astore_1
    //   8468: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8471: ifeq -8287 -> 184
    //   8474: ldc 191
    //   8476: iconst_4
    //   8477: new 497	java/lang/StringBuilder
    //   8480: dup
    //   8481: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8484: ldc_w 3100
    //   8487: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8490: aload_1
    //   8491: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8494: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8497: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8500: goto -8316 -> 184
    //   8503: ldc_w 3102
    //   8506: aload 4
    //   8508: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8511: ifeq +443 -> 8954
    //   8514: aload 5
    //   8516: arraylength
    //   8517: iconst_1
    //   8518: if_icmpne +436 -> 8954
    //   8521: aconst_null
    //   8522: astore 4
    //   8524: aconst_null
    //   8525: astore_3
    //   8526: iconst_1
    //   8527: istore 7
    //   8529: aload_3
    //   8530: astore_2
    //   8531: aload 4
    //   8533: astore_1
    //   8534: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8537: ifeq +37 -> 8574
    //   8540: aload_3
    //   8541: astore_2
    //   8542: aload 4
    //   8544: astore_1
    //   8545: ldc 191
    //   8547: iconst_1
    //   8548: new 497	java/lang/StringBuilder
    //   8551: dup
    //   8552: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8555: ldc_w 3104
    //   8558: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8561: aload 5
    //   8563: iconst_0
    //   8564: aaload
    //   8565: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8568: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8571: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8574: aload_3
    //   8575: astore_2
    //   8576: aload 4
    //   8578: astore_1
    //   8579: new 109	org/json/JSONObject
    //   8582: dup
    //   8583: aload 5
    //   8585: iconst_0
    //   8586: aaload
    //   8587: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8590: astore 15
    //   8592: aload_3
    //   8593: astore_2
    //   8594: aload 4
    //   8596: astore_1
    //   8597: aload 15
    //   8599: ldc_w 909
    //   8602: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8605: astore 5
    //   8607: aload_3
    //   8608: astore_2
    //   8609: aload 4
    //   8611: astore_1
    //   8612: aload 15
    //   8614: ldc_w 2991
    //   8617: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8620: astore 14
    //   8622: aload_3
    //   8623: astore_2
    //   8624: aload 4
    //   8626: astore_1
    //   8627: aload 15
    //   8629: ldc_w 1380
    //   8632: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8635: astore_3
    //   8636: iload 7
    //   8638: istore 6
    //   8640: aload_3
    //   8641: astore_2
    //   8642: aload_3
    //   8643: astore_1
    //   8644: aload 5
    //   8646: invokevirtual 3105	java/lang/String:length	()I
    //   8649: ifle +71 -> 8720
    //   8652: aload_3
    //   8653: astore_2
    //   8654: aload_3
    //   8655: astore_1
    //   8656: aload_0
    //   8657: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   8660: invokevirtual 1512	bcdb:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   8663: astore 4
    //   8665: aload 4
    //   8667: ifnull +219 -> 8886
    //   8670: aload_3
    //   8671: astore_2
    //   8672: aload_3
    //   8673: astore_1
    //   8674: aload 4
    //   8676: getfield 3106	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bcfm	Lbcfm;
    //   8679: ifnull +207 -> 8886
    //   8682: aload_3
    //   8683: astore_2
    //   8684: aload_3
    //   8685: astore_1
    //   8686: aload 4
    //   8688: getfield 3106	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bcfm	Lbcfm;
    //   8691: getfield 3108	bcfm:E	Z
    //   8694: ifeq +75 -> 8769
    //   8697: aload_3
    //   8698: astore_2
    //   8699: aload_3
    //   8700: astore_1
    //   8701: aload 4
    //   8703: aload 5
    //   8705: iconst_m1
    //   8706: aload 14
    //   8708: ldc_w 3110
    //   8711: invokevirtual 138	java/lang/Class:getName	()Ljava/lang/String;
    //   8714: invokevirtual 3113	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   8717: iconst_0
    //   8718: istore 6
    //   8720: aload_3
    //   8721: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8724: ifne -8540 -> 184
    //   8727: aload_0
    //   8728: aload_3
    //   8729: iconst_1
    //   8730: anewarray 334	java/lang/String
    //   8733: dup
    //   8734: iconst_0
    //   8735: new 497	java/lang/StringBuilder
    //   8738: dup
    //   8739: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8742: ldc_w 3115
    //   8745: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8748: iload 6
    //   8750: invokevirtual 1063	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8753: ldc_w 1433
    //   8756: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8759: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8762: aastore
    //   8763: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8766: goto -8582 -> 184
    //   8769: aload_3
    //   8770: astore_2
    //   8771: aload_3
    //   8772: astore_1
    //   8773: aload 4
    //   8775: getfield 3106	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bcfm	Lbcfm;
    //   8778: getfield 3117	bcfm:D	Z
    //   8781: ifeq -64 -> 8717
    //   8784: aload_3
    //   8785: astore_2
    //   8786: aload_3
    //   8787: astore_1
    //   8788: new 400	android/os/Bundle
    //   8791: dup
    //   8792: invokespecial 870	android/os/Bundle:<init>	()V
    //   8795: astore 14
    //   8797: aload_3
    //   8798: astore_2
    //   8799: aload_3
    //   8800: astore_1
    //   8801: aload 14
    //   8803: ldc_w 3119
    //   8806: aload 5
    //   8808: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8811: aload_3
    //   8812: astore_2
    //   8813: aload_3
    //   8814: astore_1
    //   8815: aload 4
    //   8817: aload 14
    //   8819: invokevirtual 3121	com/tencent/mobileqq/webview/swift/WebViewFragment:d	(Landroid/os/Bundle;)V
    //   8822: goto -105 -> 8717
    //   8825: astore_3
    //   8826: aload_2
    //   8827: astore_1
    //   8828: ldc 191
    //   8830: iconst_1
    //   8831: ldc_w 3123
    //   8834: aload_3
    //   8835: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8838: aload_2
    //   8839: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8842: ifne -8658 -> 184
    //   8845: aload_0
    //   8846: aload_2
    //   8847: iconst_1
    //   8848: anewarray 334	java/lang/String
    //   8851: dup
    //   8852: iconst_0
    //   8853: new 497	java/lang/StringBuilder
    //   8856: dup
    //   8857: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8860: ldc_w 3115
    //   8863: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8866: iconst_1
    //   8867: invokevirtual 1063	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8870: ldc_w 1433
    //   8873: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8876: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8879: aastore
    //   8880: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8883: goto -8699 -> 184
    //   8886: aload_3
    //   8887: astore_2
    //   8888: aload_3
    //   8889: astore_1
    //   8890: ldc 191
    //   8892: iconst_1
    //   8893: ldc_w 3125
    //   8896: invokestatic 613	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8899: iload 7
    //   8901: istore 6
    //   8903: goto -183 -> 8720
    //   8906: astore_2
    //   8907: aload_1
    //   8908: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8911: ifne +41 -> 8952
    //   8914: aload_0
    //   8915: aload_1
    //   8916: iconst_1
    //   8917: anewarray 334	java/lang/String
    //   8920: dup
    //   8921: iconst_0
    //   8922: new 497	java/lang/StringBuilder
    //   8925: dup
    //   8926: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8929: ldc_w 3115
    //   8932: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8935: iconst_1
    //   8936: invokevirtual 1063	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8939: ldc_w 1433
    //   8942: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8945: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8948: aastore
    //   8949: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8952: aload_2
    //   8953: athrow
    //   8954: ldc_w 1590
    //   8957: aload 4
    //   8959: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8962: ifeq +275 -> 9237
    //   8965: aload 5
    //   8967: arraylength
    //   8968: iconst_1
    //   8969: if_icmpne +268 -> 9237
    //   8972: new 109	org/json/JSONObject
    //   8975: dup
    //   8976: aload 5
    //   8978: iconst_0
    //   8979: aaload
    //   8980: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8983: astore_1
    //   8984: aload_1
    //   8985: ldc_w 3096
    //   8988: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8991: ifeq +135 -> 9126
    //   8994: aload_1
    //   8995: ldc_w 3096
    //   8998: invokevirtual 2836	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   9001: istore 13
    //   9003: iconst_0
    //   9004: istore 12
    //   9006: aload_1
    //   9007: ldc 150
    //   9009: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9012: astore_2
    //   9013: aload_1
    //   9014: ldc_w 3127
    //   9017: ldc_w 1611
    //   9020: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9023: istore 6
    //   9025: aload_1
    //   9026: ldc_w 3129
    //   9029: ldc_w 1611
    //   9032: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9035: istore 7
    //   9037: ldc_w 3131
    //   9040: aload_2
    //   9041: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9044: ifeq +6 -> 9050
    //   9047: iconst_1
    //   9048: istore 12
    //   9050: iload 13
    //   9052: aload_0
    //   9053: getfield 3133	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   9056: if_icmpeq -8872 -> 184
    //   9059: iload 13
    //   9061: ifeq +58 -> 9119
    //   9064: aload_0
    //   9065: iload 12
    //   9067: iload 6
    //   9069: iload 7
    //   9071: invokevirtual 3135	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZII)V
    //   9074: aload_0
    //   9075: iload 13
    //   9077: putfield 3133	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   9080: goto -8896 -> 184
    //   9083: astore_1
    //   9084: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   9087: ifeq -8903 -> 184
    //   9090: ldc 191
    //   9092: iconst_4
    //   9093: new 497	java/lang/StringBuilder
    //   9096: dup
    //   9097: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   9100: ldc_w 3100
    //   9103: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9106: aload_1
    //   9107: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9110: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9113: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9116: goto -8932 -> 184
    //   9119: aload_0
    //   9120: invokevirtual 3137	com/tencent/mobileqq/jsp/UiApiPlugin:b	()V
    //   9123: goto -49 -> 9074
    //   9126: aload_1
    //   9127: ldc_w 3139
    //   9130: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9133: ifeq -8949 -> 184
    //   9136: aload_0
    //   9137: getfield 1602	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   9140: ifeq -8956 -> 184
    //   9143: aload_0
    //   9144: iconst_0
    //   9145: putfield 1602	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   9148: aload_1
    //   9149: ldc_w 3139
    //   9152: invokevirtual 2836	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   9155: istore 12
    //   9157: invokestatic 296	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9160: invokevirtual 3140	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   9163: astore_2
    //   9164: iload 12
    //   9166: ifeq +44 -> 9210
    //   9169: aload_0
    //   9170: getfield 1610	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Xed	Lxed;
    //   9173: iconst_0
    //   9174: aload_1
    //   9175: ldc_w 1435
    //   9178: aload_2
    //   9179: ldc_w 3141
    //   9182: invokevirtual 3142	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   9185: invokevirtual 2380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   9188: invokeinterface 3145 3 0
    //   9193: aload_0
    //   9194: getfield 1600	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   9197: ifnull -9013 -> 184
    //   9200: aload_0
    //   9201: getfield 1600	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   9204: invokevirtual 3146	com/tencent/biz/ui/RefreshView:b	()V
    //   9207: goto -9023 -> 184
    //   9210: aload_0
    //   9211: getfield 1610	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Xed	Lxed;
    //   9214: iconst_1
    //   9215: aload_1
    //   9216: ldc_w 1435
    //   9219: aload_2
    //   9220: ldc_w 3147
    //   9223: invokevirtual 3142	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   9226: invokevirtual 2380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   9229: invokeinterface 3145 3 0
    //   9234: goto -41 -> 9193
    //   9237: ldc_w 3149
    //   9240: aload 4
    //   9242: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9245: ifeq +192 -> 9437
    //   9248: aload 5
    //   9250: arraylength
    //   9251: iconst_1
    //   9252: if_icmpne +185 -> 9437
    //   9255: new 109	org/json/JSONObject
    //   9258: dup
    //   9259: aload 5
    //   9261: iconst_0
    //   9262: aaload
    //   9263: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9266: astore_2
    //   9267: aload_2
    //   9268: ldc_w 3151
    //   9271: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9274: istore 6
    //   9276: aload_2
    //   9277: ldc 156
    //   9279: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9282: astore_1
    //   9283: aload_2
    //   9284: ldc 170
    //   9286: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9289: istore 7
    //   9291: aload_0
    //   9292: aload_2
    //   9293: ldc_w 1380
    //   9296: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9299: putfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9302: new 125	android/content/Intent
    //   9305: dup
    //   9306: getstatic 3155	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   9309: ldc_w 3157
    //   9312: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   9315: astore_2
    //   9316: aload_2
    //   9317: ldc_w 3159
    //   9320: iload 6
    //   9322: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9325: pop
    //   9326: aload_2
    //   9327: ldc_w 3161
    //   9330: aload_1
    //   9331: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9334: pop
    //   9335: aload_2
    //   9336: ldc_w 3163
    //   9339: iload 7
    //   9341: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9344: pop
    //   9345: aload_2
    //   9346: ldc_w 3165
    //   9349: bipush 6
    //   9351: invokevirtual 3168	android/content/Intent:putExtra	(Ljava/lang/String;B)Landroid/content/Intent;
    //   9354: pop
    //   9355: aload_0
    //   9356: aload_2
    //   9357: bipush 6
    //   9359: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   9362: goto -9178 -> 184
    //   9365: astore_1
    //   9366: aload_1
    //   9367: invokevirtual 2514	org/json/JSONException:printStackTrace	()V
    //   9370: aload_0
    //   9371: getfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9374: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9377: ifne -9193 -> 184
    //   9380: aload_0
    //   9381: aload_0
    //   9382: getfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9385: iconst_1
    //   9386: anewarray 334	java/lang/String
    //   9389: dup
    //   9390: iconst_0
    //   9391: ldc_w 3170
    //   9394: aastore
    //   9395: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9398: goto -9214 -> 184
    //   9401: astore_1
    //   9402: aload_1
    //   9403: invokevirtual 2630	java/lang/Exception:printStackTrace	()V
    //   9406: aload_0
    //   9407: getfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9410: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9413: ifne -9229 -> 184
    //   9416: aload_0
    //   9417: aload_0
    //   9418: getfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9421: iconst_1
    //   9422: anewarray 334	java/lang/String
    //   9425: dup
    //   9426: iconst_0
    //   9427: ldc_w 3170
    //   9430: aastore
    //   9431: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9434: goto -9250 -> 184
    //   9437: ldc_w 3172
    //   9440: aload 4
    //   9442: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9445: ifeq +250 -> 9695
    //   9448: aload_0
    //   9449: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   9452: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   9455: astore_1
    //   9456: aload_0
    //   9457: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   9460: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   9463: astore_2
    //   9464: aload_1
    //   9465: ifnull -9281 -> 184
    //   9468: aload_2
    //   9469: ifnull -9285 -> 184
    //   9472: aconst_null
    //   9473: astore_2
    //   9474: aload_2
    //   9475: astore_1
    //   9476: new 109	org/json/JSONObject
    //   9479: dup
    //   9480: aload 5
    //   9482: iconst_0
    //   9483: aaload
    //   9484: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9487: astore_3
    //   9488: aload_2
    //   9489: astore_1
    //   9490: aload_3
    //   9491: ldc_w 1380
    //   9494: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9497: astore_2
    //   9498: aload_2
    //   9499: astore_1
    //   9500: aload_3
    //   9501: ldc_w 2366
    //   9504: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9507: invokestatic 3176	atbn:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9510: astore 4
    //   9512: aload_2
    //   9513: astore_1
    //   9514: aload_3
    //   9515: ldc_w 3178
    //   9518: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9521: astore 5
    //   9523: aload_2
    //   9524: astore_1
    //   9525: aload_3
    //   9526: ldc_w 3180
    //   9529: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   9532: istore 7
    //   9534: iconst_0
    //   9535: istore 6
    //   9537: aload_2
    //   9538: astore_1
    //   9539: aload_3
    //   9540: ldc_w 3182
    //   9543: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9546: ifeq +14 -> 9560
    //   9549: aload_2
    //   9550: astore_1
    //   9551: aload_3
    //   9552: ldc_w 3182
    //   9555: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   9558: istore 6
    //   9560: aload_2
    //   9561: astore_1
    //   9562: new 400	android/os/Bundle
    //   9565: dup
    //   9566: invokespecial 870	android/os/Bundle:<init>	()V
    //   9569: astore_3
    //   9570: aload_2
    //   9571: astore_1
    //   9572: aload_3
    //   9573: ldc_w 2366
    //   9576: aload 4
    //   9578: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9581: aload 5
    //   9583: ifnull +14 -> 9597
    //   9586: aload_2
    //   9587: astore_1
    //   9588: aload_3
    //   9589: ldc_w 3178
    //   9592: aload 5
    //   9594: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9597: aload_2
    //   9598: astore_1
    //   9599: aload_3
    //   9600: ldc_w 3184
    //   9603: iload 7
    //   9605: invokevirtual 876	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9608: aload_2
    //   9609: astore_1
    //   9610: aload_3
    //   9611: ldc_w 1069
    //   9614: ldc_w 3172
    //   9617: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9620: aload_2
    //   9621: astore_1
    //   9622: aload_3
    //   9623: ldc_w 3182
    //   9626: iload 6
    //   9628: invokevirtual 876	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9631: aload_2
    //   9632: astore_1
    //   9633: ldc_w 3186
    //   9636: aload_2
    //   9637: aload_0
    //   9638: getfield 93	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Anql	Lanql;
    //   9641: getfield 3191	anql:key	I
    //   9644: aload_3
    //   9645: invokestatic 3196	anqp:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9648: astore_3
    //   9649: aload_2
    //   9650: astore_1
    //   9651: invokestatic 3201	anvl:a	()Lanvl;
    //   9654: aload_3
    //   9655: invokevirtual 3202	anvl:a	(Landroid/os/Bundle;)V
    //   9658: goto -9474 -> 184
    //   9661: astore_2
    //   9662: aload_1
    //   9663: ifnull -9479 -> 184
    //   9666: aload_0
    //   9667: aload_1
    //   9668: iconst_1
    //   9669: anewarray 334	java/lang/String
    //   9672: dup
    //   9673: iconst_0
    //   9674: ldc_w 3204
    //   9677: iconst_1
    //   9678: anewarray 843	java/lang/Object
    //   9681: dup
    //   9682: iconst_0
    //   9683: aload_2
    //   9684: aastore
    //   9685: invokestatic 861	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9688: aastore
    //   9689: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9692: goto -9508 -> 184
    //   9695: ldc_w 3206
    //   9698: aload 4
    //   9700: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9703: ifeq +403 -> 10106
    //   9706: aload_0
    //   9707: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   9710: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   9713: astore_1
    //   9714: aload_0
    //   9715: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   9718: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   9721: astore_2
    //   9722: aload_1
    //   9723: ifnull -9539 -> 184
    //   9726: aload_2
    //   9727: ifnull -9543 -> 184
    //   9730: aconst_null
    //   9731: astore_2
    //   9732: aconst_null
    //   9733: astore 4
    //   9735: aload_2
    //   9736: astore_1
    //   9737: new 109	org/json/JSONObject
    //   9740: dup
    //   9741: aload 5
    //   9743: iconst_0
    //   9744: aaload
    //   9745: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9748: astore 14
    //   9750: aload_2
    //   9751: astore_1
    //   9752: aload 14
    //   9754: ldc_w 1380
    //   9757: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9760: astore_3
    //   9761: aload_3
    //   9762: astore_1
    //   9763: aload 14
    //   9765: ldc_w 2366
    //   9768: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9771: invokestatic 3176	atbn:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9774: astore_2
    //   9775: aload_3
    //   9776: astore_1
    //   9777: aload 14
    //   9779: ldc_w 2364
    //   9782: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9785: astore 5
    //   9787: aload_3
    //   9788: astore_1
    //   9789: aload 14
    //   9791: ldc_w 3208
    //   9794: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9797: astore 15
    //   9799: iconst_0
    //   9800: istore 12
    //   9802: aload_3
    //   9803: astore_1
    //   9804: aload 5
    //   9806: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9809: ifne +7612 -> 17421
    //   9812: iconst_1
    //   9813: istore 12
    //   9815: aload 5
    //   9817: astore_2
    //   9818: aload_3
    //   9819: astore_1
    //   9820: aload 14
    //   9822: ldc_w 3178
    //   9825: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9828: astore 5
    //   9830: aload_3
    //   9831: astore_1
    //   9832: aload 14
    //   9834: ldc_w 3180
    //   9837: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9840: istore 6
    //   9842: aload_3
    //   9843: astore_1
    //   9844: aload 14
    //   9846: ldc_w 3210
    //   9849: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9852: istore 7
    //   9854: aload_3
    //   9855: astore_1
    //   9856: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9859: ifeq +35 -> 9894
    //   9862: aload_3
    //   9863: astore_1
    //   9864: ldc 191
    //   9866: iconst_2
    //   9867: new 497	java/lang/StringBuilder
    //   9870: dup
    //   9871: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   9874: ldc_w 3212
    //   9877: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9880: aload 14
    //   9882: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9885: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9888: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9891: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9894: aload_3
    //   9895: astore_1
    //   9896: aload_2
    //   9897: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9900: ifne +178 -> 10078
    //   9903: aload_3
    //   9904: astore_1
    //   9905: new 400	android/os/Bundle
    //   9908: dup
    //   9909: invokespecial 870	android/os/Bundle:<init>	()V
    //   9912: astore 14
    //   9914: aload_3
    //   9915: astore_1
    //   9916: aload 14
    //   9918: ldc_w 3180
    //   9921: iload 6
    //   9923: invokevirtual 876	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9926: aload_3
    //   9927: astore_1
    //   9928: aload 14
    //   9930: ldc_w 2366
    //   9933: aload_2
    //   9934: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9937: aload_3
    //   9938: astore_1
    //   9939: aload 14
    //   9941: ldc_w 3214
    //   9944: iload 12
    //   9946: invokevirtual 1177	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   9949: aload_3
    //   9950: astore_1
    //   9951: aload 14
    //   9953: ldc_w 1069
    //   9956: ldc_w 3206
    //   9959: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9962: aload_3
    //   9963: astore_1
    //   9964: aload 14
    //   9966: ldc_w 3210
    //   9969: iload 7
    //   9971: invokevirtual 876	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9974: aload_3
    //   9975: astore_1
    //   9976: aload 5
    //   9978: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9981: ifne +15 -> 9996
    //   9984: aload_3
    //   9985: astore_1
    //   9986: aload 14
    //   9988: ldc_w 3178
    //   9991: aload 5
    //   9993: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9996: aload_3
    //   9997: astore_1
    //   9998: aload 15
    //   10000: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10003: ifne +15 -> 10018
    //   10006: aload_3
    //   10007: astore_1
    //   10008: aload 14
    //   10010: ldc_w 3208
    //   10013: aload 15
    //   10015: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   10018: aload_3
    //   10019: astore_1
    //   10020: ldc_w 3186
    //   10023: aload_3
    //   10024: aload_0
    //   10025: getfield 93	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Anql	Lanql;
    //   10028: getfield 3191	anql:key	I
    //   10031: aload 14
    //   10033: invokestatic 3196	anqp:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   10036: astore_2
    //   10037: aload_3
    //   10038: astore_1
    //   10039: invokestatic 3201	anvl:a	()Lanvl;
    //   10042: aload_2
    //   10043: invokevirtual 3202	anvl:a	(Landroid/os/Bundle;)V
    //   10046: aload_3
    //   10047: astore_1
    //   10048: aload 4
    //   10050: astore_2
    //   10051: aload_2
    //   10052: ifnull -9868 -> 184
    //   10055: aload_1
    //   10056: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10059: ifne -9875 -> 184
    //   10062: aload_0
    //   10063: aload_1
    //   10064: iconst_1
    //   10065: anewarray 334	java/lang/String
    //   10068: dup
    //   10069: iconst_0
    //   10070: aload_2
    //   10071: aastore
    //   10072: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10075: goto -9891 -> 184
    //   10078: ldc_w 3216
    //   10081: astore_2
    //   10082: aload_3
    //   10083: astore_1
    //   10084: goto -33 -> 10051
    //   10087: astore_2
    //   10088: ldc_w 3204
    //   10091: iconst_1
    //   10092: anewarray 843	java/lang/Object
    //   10095: dup
    //   10096: iconst_0
    //   10097: aload_2
    //   10098: aastore
    //   10099: invokestatic 861	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10102: astore_2
    //   10103: goto -52 -> 10051
    //   10106: ldc_w 3218
    //   10109: aload 4
    //   10111: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10114: ifeq +196 -> 10310
    //   10117: aconst_null
    //   10118: astore_2
    //   10119: aload_2
    //   10120: astore_1
    //   10121: new 109	org/json/JSONObject
    //   10124: dup
    //   10125: aload 5
    //   10127: iconst_0
    //   10128: aaload
    //   10129: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10132: astore_3
    //   10133: aload_2
    //   10134: astore_1
    //   10135: aload_3
    //   10136: ldc_w 1380
    //   10139: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10142: astore_2
    //   10143: aload_2
    //   10144: astore_1
    //   10145: aload_3
    //   10146: ldc_w 3096
    //   10149: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   10152: ifeq -9968 -> 184
    //   10155: aload_2
    //   10156: astore_1
    //   10157: aload_3
    //   10158: ldc_w 3096
    //   10161: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   10164: istore 12
    //   10166: aload_2
    //   10167: astore_1
    //   10168: aload_0
    //   10169: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   10172: aload_0
    //   10173: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   10176: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   10179: invokevirtual 699	bcdb:a	(Landroid/app/Activity;)Lbcci;
    //   10182: astore_3
    //   10183: aload_3
    //   10184: ifnull +83 -> 10267
    //   10187: aload_2
    //   10188: astore_1
    //   10189: aload_3
    //   10190: instanceof 3220
    //   10193: ifeq +74 -> 10267
    //   10196: aload_2
    //   10197: astore_1
    //   10198: aload_3
    //   10199: checkcast 3220	bcho
    //   10202: astore_3
    //   10203: iload 12
    //   10205: ifne +56 -> 10261
    //   10208: iconst_1
    //   10209: istore 12
    //   10211: aload_2
    //   10212: astore_1
    //   10213: aload_3
    //   10214: iload 12
    //   10216: invokeinterface 3221 2 0
    //   10221: goto -10037 -> 184
    //   10224: astore_2
    //   10225: aload_1
    //   10226: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10229: ifne -10045 -> 184
    //   10232: aload_0
    //   10233: aload_1
    //   10234: iconst_1
    //   10235: anewarray 334	java/lang/String
    //   10238: dup
    //   10239: iconst_0
    //   10240: ldc_w 3204
    //   10243: iconst_1
    //   10244: anewarray 843	java/lang/Object
    //   10247: dup
    //   10248: iconst_0
    //   10249: aload_2
    //   10250: aastore
    //   10251: invokestatic 861	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10254: aastore
    //   10255: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10258: goto -10074 -> 184
    //   10261: iconst_0
    //   10262: istore 12
    //   10264: goto -53 -> 10211
    //   10267: aload_2
    //   10268: astore_1
    //   10269: aload_0
    //   10270: iconst_m1
    //   10271: invokespecial 1394	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   10274: checkcast 3223	bces
    //   10277: astore_3
    //   10278: aload_3
    //   10279: ifnull -10095 -> 184
    //   10282: iload 12
    //   10284: ifne +20 -> 10304
    //   10287: iconst_1
    //   10288: istore 12
    //   10290: aload_2
    //   10291: astore_1
    //   10292: aload_3
    //   10293: ldc_w 3225
    //   10296: iload 12
    //   10298: invokevirtual 3226	bces:a	(Ljava/lang/String;Z)V
    //   10301: goto -10117 -> 184
    //   10304: iconst_0
    //   10305: istore 12
    //   10307: goto -17 -> 10290
    //   10310: ldc_w 3228
    //   10313: aload 4
    //   10315: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10318: ifeq +196 -> 10514
    //   10321: aconst_null
    //   10322: astore_2
    //   10323: aload_2
    //   10324: astore_1
    //   10325: new 109	org/json/JSONObject
    //   10328: dup
    //   10329: aload 5
    //   10331: iconst_0
    //   10332: aaload
    //   10333: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10336: astore_3
    //   10337: aload_2
    //   10338: astore_1
    //   10339: aload_3
    //   10340: ldc_w 1380
    //   10343: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10346: astore_2
    //   10347: aload_2
    //   10348: astore_1
    //   10349: aload_3
    //   10350: ldc_w 3096
    //   10353: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   10356: ifeq -10172 -> 184
    //   10359: aload_2
    //   10360: astore_1
    //   10361: aload_3
    //   10362: ldc_w 3096
    //   10365: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   10368: istore 12
    //   10370: aload_2
    //   10371: astore_1
    //   10372: aload_0
    //   10373: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   10376: aload_0
    //   10377: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   10380: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   10383: invokevirtual 699	bcdb:a	(Landroid/app/Activity;)Lbcci;
    //   10386: astore_3
    //   10387: aload_3
    //   10388: ifnull +83 -> 10471
    //   10391: aload_2
    //   10392: astore_1
    //   10393: aload_3
    //   10394: instanceof 3220
    //   10397: ifeq +74 -> 10471
    //   10400: aload_2
    //   10401: astore_1
    //   10402: aload_3
    //   10403: checkcast 3220	bcho
    //   10406: astore_3
    //   10407: iload 12
    //   10409: ifne +56 -> 10465
    //   10412: iconst_1
    //   10413: istore 12
    //   10415: aload_2
    //   10416: astore_1
    //   10417: aload_3
    //   10418: iload 12
    //   10420: invokeinterface 3230 2 0
    //   10425: goto -10241 -> 184
    //   10428: astore_2
    //   10429: aload_1
    //   10430: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10433: ifne -10249 -> 184
    //   10436: aload_0
    //   10437: aload_1
    //   10438: iconst_1
    //   10439: anewarray 334	java/lang/String
    //   10442: dup
    //   10443: iconst_0
    //   10444: ldc_w 3204
    //   10447: iconst_1
    //   10448: anewarray 843	java/lang/Object
    //   10451: dup
    //   10452: iconst_0
    //   10453: aload_2
    //   10454: aastore
    //   10455: invokestatic 861	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10458: aastore
    //   10459: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10462: goto -10278 -> 184
    //   10465: iconst_0
    //   10466: istore 12
    //   10468: goto -53 -> 10415
    //   10471: aload_2
    //   10472: astore_1
    //   10473: aload_0
    //   10474: iconst_m1
    //   10475: invokespecial 1394	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   10478: checkcast 3223	bces
    //   10481: astore_3
    //   10482: aload_3
    //   10483: ifnull -10299 -> 184
    //   10486: iload 12
    //   10488: ifne +20 -> 10508
    //   10491: iconst_1
    //   10492: istore 12
    //   10494: aload_2
    //   10495: astore_1
    //   10496: aload_3
    //   10497: ldc_w 3232
    //   10500: iload 12
    //   10502: invokevirtual 3226	bces:a	(Ljava/lang/String;Z)V
    //   10505: goto -10321 -> 184
    //   10508: iconst_0
    //   10509: istore 12
    //   10511: goto -17 -> 10494
    //   10514: ldc_w 3234
    //   10517: aload 4
    //   10519: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10522: ifeq +74 -> 10596
    //   10525: new 109	org/json/JSONObject
    //   10528: dup
    //   10529: aload 5
    //   10531: iconst_0
    //   10532: aaload
    //   10533: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10536: astore_1
    //   10537: new 3236	akgd
    //   10540: dup
    //   10541: invokespecial 3237	akgd:<init>	()V
    //   10544: aload_1
    //   10545: ldc_w 3239
    //   10548: invokevirtual 921	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   10551: invokevirtual 3242	akgd:a	(Lorg/json/JSONArray;)V
    //   10554: goto -10370 -> 184
    //   10557: astore_1
    //   10558: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10561: ifeq -10377 -> 184
    //   10564: ldc 191
    //   10566: iconst_2
    //   10567: new 497	java/lang/StringBuilder
    //   10570: dup
    //   10571: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   10574: ldc_w 3244
    //   10577: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10580: aload 5
    //   10582: iconst_0
    //   10583: aaload
    //   10584: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10587: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10590: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10593: goto -10409 -> 184
    //   10596: ldc_w 3246
    //   10599: aload 4
    //   10601: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10604: ifeq +154 -> 10758
    //   10607: new 109	org/json/JSONObject
    //   10610: dup
    //   10611: aload 5
    //   10613: iconst_0
    //   10614: aaload
    //   10615: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10618: ldc_w 1380
    //   10621: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10624: astore_1
    //   10625: new 3236	akgd
    //   10628: dup
    //   10629: invokespecial 3237	akgd:<init>	()V
    //   10632: astore 4
    //   10634: new 109	org/json/JSONObject
    //   10637: dup
    //   10638: invokespecial 168	org/json/JSONObject:<init>	()V
    //   10641: astore_2
    //   10642: new 933	org/json/JSONArray
    //   10645: dup
    //   10646: invokespecial 3247	org/json/JSONArray:<init>	()V
    //   10649: astore_3
    //   10650: aload 4
    //   10652: invokevirtual 3250	akgd:a	()Ljava/util/ArrayList;
    //   10655: astore 4
    //   10657: iconst_0
    //   10658: istore 6
    //   10660: iload 6
    //   10662: aload 4
    //   10664: invokevirtual 3253	java/util/ArrayList:size	()I
    //   10667: if_icmpge +24 -> 10691
    //   10670: aload_3
    //   10671: aload 4
    //   10673: iload 6
    //   10675: invokevirtual 3255	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   10678: invokevirtual 3258	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   10681: pop
    //   10682: iload 6
    //   10684: iconst_1
    //   10685: iadd
    //   10686: istore 6
    //   10688: goto -28 -> 10660
    //   10691: aload_2
    //   10692: ldc_w 3239
    //   10695: aload_3
    //   10696: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   10699: pop
    //   10700: aload_0
    //   10701: aload_1
    //   10702: iconst_1
    //   10703: anewarray 334	java/lang/String
    //   10706: dup
    //   10707: iconst_0
    //   10708: aload_2
    //   10709: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10712: aastore
    //   10713: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10716: goto -10532 -> 184
    //   10719: astore_1
    //   10720: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10723: ifeq -10539 -> 184
    //   10726: ldc 191
    //   10728: iconst_2
    //   10729: new 497	java/lang/StringBuilder
    //   10732: dup
    //   10733: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   10736: ldc_w 3260
    //   10739: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10742: aload 5
    //   10744: iconst_0
    //   10745: aaload
    //   10746: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10749: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10752: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10755: goto -10571 -> 184
    //   10758: ldc_w 3262
    //   10761: aload 4
    //   10763: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10766: ifeq +221 -> 10987
    //   10769: aload_0
    //   10770: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   10773: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   10776: astore 14
    //   10778: aload_0
    //   10779: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   10782: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   10785: astore_1
    //   10786: aload 14
    //   10788: ifnull -10604 -> 184
    //   10791: aload_1
    //   10792: ifnull -10608 -> 184
    //   10795: aconst_null
    //   10796: astore_1
    //   10797: aconst_null
    //   10798: astore 4
    //   10800: new 109	org/json/JSONObject
    //   10803: dup
    //   10804: aload 5
    //   10806: iconst_0
    //   10807: aaload
    //   10808: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10811: astore_3
    //   10812: aload_3
    //   10813: ldc_w 1380
    //   10816: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10819: astore_2
    //   10820: aload_2
    //   10821: astore_1
    //   10822: aload_3
    //   10823: ifnull +155 -> 10978
    //   10826: new 400	android/os/Bundle
    //   10829: dup
    //   10830: invokespecial 870	android/os/Bundle:<init>	()V
    //   10833: astore 5
    //   10835: aload 5
    //   10837: ldc_w 3264
    //   10840: aload_3
    //   10841: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10844: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   10847: aload 14
    //   10849: invokevirtual 1098	java/lang/Object:getClass	()Ljava/lang/Class;
    //   10852: invokevirtual 138	java/lang/Class:getName	()Ljava/lang/String;
    //   10855: ldc_w 3266
    //   10858: invokevirtual 1103	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   10861: istore 12
    //   10863: aload 4
    //   10865: astore_2
    //   10866: aload_1
    //   10867: astore_3
    //   10868: iload 12
    //   10870: ifeq +41 -> 10911
    //   10873: aconst_null
    //   10874: aload 14
    //   10876: new 109	org/json/JSONObject
    //   10879: dup
    //   10880: aload 5
    //   10882: ldc_w 3264
    //   10885: invokevirtual 3267	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10888: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10891: ldc_w 3269
    //   10894: ldc_w 371
    //   10897: invokevirtual 2380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10900: invokestatic 3273	sdc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   10903: invokestatic 3278	sgj:a	(Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;)V
    //   10906: aload_1
    //   10907: astore_3
    //   10908: aload 4
    //   10910: astore_2
    //   10911: aload_2
    //   10912: ifnull -10728 -> 184
    //   10915: aload_3
    //   10916: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10919: ifne -10735 -> 184
    //   10922: aload_0
    //   10923: aload_3
    //   10924: iconst_1
    //   10925: anewarray 334	java/lang/String
    //   10928: dup
    //   10929: iconst_0
    //   10930: aload_2
    //   10931: aastore
    //   10932: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10935: goto -10751 -> 184
    //   10938: astore_2
    //   10939: ldc 191
    //   10941: iconst_2
    //   10942: ldc_w 3280
    //   10945: aload_2
    //   10946: invokestatic 2372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10949: aload 4
    //   10951: astore_2
    //   10952: aload_1
    //   10953: astore_3
    //   10954: goto -43 -> 10911
    //   10957: astore_2
    //   10958: ldc_w 3204
    //   10961: iconst_1
    //   10962: anewarray 843	java/lang/Object
    //   10965: dup
    //   10966: iconst_0
    //   10967: aload_2
    //   10968: aastore
    //   10969: invokestatic 861	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10972: astore_2
    //   10973: aload_1
    //   10974: astore_3
    //   10975: goto -64 -> 10911
    //   10978: ldc_w 3216
    //   10981: astore_2
    //   10982: aload_1
    //   10983: astore_3
    //   10984: goto -73 -> 10911
    //   10987: ldc_w 3282
    //   10990: aload 4
    //   10992: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10995: ifeq +330 -> 11325
    //   10998: aconst_null
    //   10999: ldc_w 367
    //   11002: ldc_w 369
    //   11005: ldc_w 371
    //   11008: ldc_w 373
    //   11011: ldc_w 3284
    //   11014: iconst_0
    //   11015: iconst_1
    //   11016: iconst_0
    //   11017: aload 5
    //   11019: iconst_0
    //   11020: aaload
    //   11021: ldc_w 371
    //   11024: ldc_w 371
    //   11027: ldc_w 371
    //   11030: invokestatic 380	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11033: aload_0
    //   11034: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   11037: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   11040: astore 14
    //   11042: aload_0
    //   11043: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   11046: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   11049: astore_1
    //   11050: aload 14
    //   11052: ifnull -10868 -> 184
    //   11055: aload_1
    //   11056: ifnull -10872 -> 184
    //   11059: aconst_null
    //   11060: astore_3
    //   11061: aconst_null
    //   11062: astore 4
    //   11064: aload 4
    //   11066: astore_1
    //   11067: aload_3
    //   11068: astore_2
    //   11069: new 109	org/json/JSONObject
    //   11072: dup
    //   11073: aload 5
    //   11075: iconst_0
    //   11076: aaload
    //   11077: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11080: astore 5
    //   11082: aload 4
    //   11084: astore_1
    //   11085: aload_3
    //   11086: astore_2
    //   11087: aload 5
    //   11089: ldc_w 1380
    //   11092: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11095: astore_3
    //   11096: aload 4
    //   11098: astore_1
    //   11099: aload_3
    //   11100: astore_2
    //   11101: aload 5
    //   11103: ldc 180
    //   11105: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11108: astore 4
    //   11110: aload 4
    //   11112: astore_1
    //   11113: aload_3
    //   11114: astore_2
    //   11115: aload 5
    //   11117: ldc_w 1069
    //   11120: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11123: astore 15
    //   11125: aload 4
    //   11127: astore_1
    //   11128: aload_3
    //   11129: astore_2
    //   11130: aload 5
    //   11132: ldc 221
    //   11134: invokevirtual 1204	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   11137: astore 5
    //   11139: aload 4
    //   11141: astore_1
    //   11142: aload_3
    //   11143: astore_2
    //   11144: ldc_w 373
    //   11147: aload 15
    //   11149: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11152: ifeq +6262 -> 17414
    //   11155: aload 5
    //   11157: ifnull +6257 -> 17414
    //   11160: aload 4
    //   11162: astore_1
    //   11163: aload_3
    //   11164: astore_2
    //   11165: aload 5
    //   11167: ldc_w 909
    //   11170: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11173: astore 15
    //   11175: aload 4
    //   11177: astore_1
    //   11178: aload_3
    //   11179: astore_2
    //   11180: aload 5
    //   11182: ldc_w 2991
    //   11185: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11188: astore 16
    //   11190: aload 4
    //   11192: astore_1
    //   11193: aload_3
    //   11194: astore_2
    //   11195: aload 5
    //   11197: ldc 156
    //   11199: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11202: astore 5
    //   11204: aload 4
    //   11206: astore_1
    //   11207: aload_3
    //   11208: astore_2
    //   11209: aload 15
    //   11211: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11214: ifne +67 -> 11281
    //   11217: aload 4
    //   11219: astore_1
    //   11220: aload_3
    //   11221: astore_2
    //   11222: aload 5
    //   11224: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11227: ifne +54 -> 11281
    //   11230: aload 4
    //   11232: astore_1
    //   11233: aload_3
    //   11234: astore_2
    //   11235: aload_0
    //   11236: aload 14
    //   11238: aload 15
    //   11240: aload 16
    //   11242: aload 4
    //   11244: aload 5
    //   11246: aload_3
    //   11247: invokespecial 3286	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11250: aconst_null
    //   11251: astore_1
    //   11252: aload_3
    //   11253: astore_2
    //   11254: aload_1
    //   11255: ifnull -11071 -> 184
    //   11258: aload_2
    //   11259: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11262: ifne -11078 -> 184
    //   11265: aload_0
    //   11266: aload_2
    //   11267: iconst_1
    //   11268: anewarray 334	java/lang/String
    //   11271: dup
    //   11272: iconst_0
    //   11273: aload_1
    //   11274: aastore
    //   11275: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11278: goto -11094 -> 184
    //   11281: aload 4
    //   11283: astore_1
    //   11284: aload_3
    //   11285: astore_2
    //   11286: ldc_w 2677
    //   11289: aconst_null
    //   11290: ldc_w 3288
    //   11293: aload 4
    //   11295: invokestatic 365	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11298: astore 4
    //   11300: aload 4
    //   11302: astore_1
    //   11303: aload_3
    //   11304: astore_2
    //   11305: goto -51 -> 11254
    //   11308: astore_3
    //   11309: ldc_w 3290
    //   11312: aconst_null
    //   11313: aload_3
    //   11314: invokevirtual 611	java/lang/Exception:toString	()Ljava/lang/String;
    //   11317: aload_1
    //   11318: invokestatic 365	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11321: astore_1
    //   11322: goto -68 -> 11254
    //   11325: ldc_w 3292
    //   11328: aload 4
    //   11330: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11333: ifeq +295 -> 11628
    //   11336: aload 5
    //   11338: arraylength
    //   11339: ifle +289 -> 11628
    //   11342: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11345: ifeq +33 -> 11378
    //   11348: ldc_w 3294
    //   11351: iconst_2
    //   11352: new 497	java/lang/StringBuilder
    //   11355: dup
    //   11356: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   11359: ldc_w 3296
    //   11362: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11365: aload 5
    //   11367: iconst_0
    //   11368: aaload
    //   11369: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11372: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11375: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11378: new 109	org/json/JSONObject
    //   11381: dup
    //   11382: aload 5
    //   11384: iconst_0
    //   11385: aaload
    //   11386: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11389: ldc 156
    //   11391: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11394: astore_3
    //   11395: aload_3
    //   11396: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11399: ifne -11215 -> 184
    //   11402: aload_3
    //   11403: ldc_w 3298
    //   11406: invokevirtual 3302	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   11409: astore_1
    //   11410: new 2056	java/util/HashMap
    //   11413: dup
    //   11414: invokespecial 3303	java/util/HashMap:<init>	()V
    //   11417: astore_2
    //   11418: aload_1
    //   11419: arraylength
    //   11420: iconst_1
    //   11421: if_icmple -11237 -> 184
    //   11424: aload_1
    //   11425: iconst_1
    //   11426: aaload
    //   11427: ldc_w 3305
    //   11430: invokevirtual 3302	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   11433: astore_1
    //   11434: iconst_0
    //   11435: istore 6
    //   11437: aload_1
    //   11438: arraylength
    //   11439: istore 7
    //   11441: iload 6
    //   11443: iload 7
    //   11445: if_icmpge +49 -> 11494
    //   11448: aload_1
    //   11449: iload 6
    //   11451: aaload
    //   11452: bipush 61
    //   11454: invokevirtual 3308	java/lang/String:indexOf	(I)I
    //   11457: istore 8
    //   11459: iload 8
    //   11461: iconst_m1
    //   11462: if_icmpeq +6101 -> 17563
    //   11465: aload_2
    //   11466: aload_1
    //   11467: iload 6
    //   11469: aaload
    //   11470: iconst_0
    //   11471: iload 8
    //   11473: invokevirtual 3312	java/lang/String:substring	(II)Ljava/lang/String;
    //   11476: aload_1
    //   11477: iload 6
    //   11479: aaload
    //   11480: iload 8
    //   11482: iconst_1
    //   11483: iadd
    //   11484: invokevirtual 3314	java/lang/String:substring	(I)Ljava/lang/String;
    //   11487: invokevirtual 2062	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   11490: pop
    //   11491: goto +6072 -> 17563
    //   11494: aload_3
    //   11495: ldc_w 1720
    //   11498: invokevirtual 1135	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11501: ifeq +102 -> 11603
    //   11504: aload_2
    //   11505: ldc_w 1337
    //   11508: invokevirtual 3315	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11511: checkcast 334	java/lang/String
    //   11514: astore_1
    //   11515: aload_2
    //   11516: ldc 201
    //   11518: invokevirtual 3315	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11521: checkcast 334	java/lang/String
    //   11524: astore_2
    //   11525: aload_0
    //   11526: aload_1
    //   11527: aload_2
    //   11528: aload_3
    //   11529: invokevirtual 3317	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   11532: ifne -11348 -> 184
    //   11535: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11538: ifeq +13 -> 11551
    //   11541: ldc_w 3294
    //   11544: iconst_2
    //   11545: ldc_w 2410
    //   11548: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11551: aload_0
    //   11552: aload 5
    //   11554: iconst_0
    //   11555: aaload
    //   11556: iconst_0
    //   11557: invokevirtual 2415	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   11560: goto -11376 -> 184
    //   11563: astore_1
    //   11564: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11567: ifeq -11383 -> 184
    //   11570: ldc_w 3294
    //   11573: iconst_2
    //   11574: new 497	java/lang/StringBuilder
    //   11577: dup
    //   11578: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   11581: ldc_w 3319
    //   11584: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11587: aload 5
    //   11589: iconst_0
    //   11590: aaload
    //   11591: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11594: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11597: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11600: goto -11416 -> 184
    //   11603: aload_2
    //   11604: ldc_w 3084
    //   11607: invokevirtual 3315	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11610: checkcast 334	java/lang/String
    //   11613: astore_1
    //   11614: aload_2
    //   11615: ldc_w 3321
    //   11618: invokevirtual 3315	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11621: checkcast 334	java/lang/String
    //   11624: astore_2
    //   11625: goto -100 -> 11525
    //   11628: ldc_w 3323
    //   11631: aload 4
    //   11633: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11636: ifeq +66 -> 11702
    //   11639: aload 5
    //   11641: arraylength
    //   11642: ifle +60 -> 11702
    //   11645: aload_0
    //   11646: new 109	org/json/JSONObject
    //   11649: dup
    //   11650: aload 5
    //   11652: iconst_0
    //   11653: aaload
    //   11654: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11657: invokevirtual 3325	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;)V
    //   11660: goto -11476 -> 184
    //   11663: astore_1
    //   11664: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11667: ifeq -11483 -> 184
    //   11670: ldc 191
    //   11672: iconst_2
    //   11673: new 497	java/lang/StringBuilder
    //   11676: dup
    //   11677: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   11680: ldc_w 3327
    //   11683: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11686: aload 5
    //   11688: iconst_0
    //   11689: aaload
    //   11690: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11693: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11696: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11699: goto -11515 -> 184
    //   11702: ldc_w 3329
    //   11705: aload 4
    //   11707: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11710: ifeq +10 -> 11720
    //   11713: aload_0
    //   11714: invokevirtual 3330	com/tencent/mobileqq/jsp/UiApiPlugin:c	()V
    //   11717: goto -11533 -> 184
    //   11720: ldc_w 3332
    //   11723: aload 4
    //   11725: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11728: ifeq +72 -> 11800
    //   11731: aload 5
    //   11733: arraylength
    //   11734: ifle +66 -> 11800
    //   11737: aload_0
    //   11738: new 109	org/json/JSONObject
    //   11741: dup
    //   11742: aload 5
    //   11744: iconst_0
    //   11745: aaload
    //   11746: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11749: ldc_w 1380
    //   11752: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11755: invokevirtual 3334	com/tencent/mobileqq/jsp/UiApiPlugin:b	(Ljava/lang/String;)V
    //   11758: goto -11574 -> 184
    //   11761: astore_1
    //   11762: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11765: ifeq -11581 -> 184
    //   11768: ldc 191
    //   11770: iconst_2
    //   11771: new 497	java/lang/StringBuilder
    //   11774: dup
    //   11775: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   11778: ldc_w 3244
    //   11781: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11784: aload 5
    //   11786: iconst_0
    //   11787: aaload
    //   11788: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11791: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11794: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11797: goto -11613 -> 184
    //   11800: ldc_w 3336
    //   11803: aload 4
    //   11805: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11808: ifeq +112 -> 11920
    //   11811: new 109	org/json/JSONObject
    //   11814: dup
    //   11815: aload 5
    //   11817: iconst_0
    //   11818: aaload
    //   11819: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11822: astore_1
    //   11823: aload_0
    //   11824: invokevirtual 2231	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbchu;
    //   11827: astore_2
    //   11828: aload_2
    //   11829: ifnull -11645 -> 184
    //   11832: aload_2
    //   11833: aload_1
    //   11834: invokeinterface 3337 2 0
    //   11839: goto -11655 -> 184
    //   11842: astore_1
    //   11843: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11846: ifeq -11662 -> 184
    //   11849: ldc 191
    //   11851: iconst_2
    //   11852: new 497	java/lang/StringBuilder
    //   11855: dup
    //   11856: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   11859: ldc_w 3339
    //   11862: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11865: aload_1
    //   11866: invokevirtual 3340	org/json/JSONException:toString	()Ljava/lang/String;
    //   11869: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11872: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11875: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11878: goto -11694 -> 184
    //   11881: astore_1
    //   11882: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11885: ifeq -11701 -> 184
    //   11888: ldc 191
    //   11890: iconst_2
    //   11891: new 497	java/lang/StringBuilder
    //   11894: dup
    //   11895: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   11898: ldc_w 3339
    //   11901: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11904: aload_1
    //   11905: invokevirtual 611	java/lang/Exception:toString	()Ljava/lang/String;
    //   11908: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11911: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11914: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11917: goto -11733 -> 184
    //   11920: ldc_w 3342
    //   11923: aload 4
    //   11925: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11928: ifeq +194 -> 12122
    //   11931: aload 5
    //   11933: arraylength
    //   11934: ifle +188 -> 12122
    //   11937: new 109	org/json/JSONObject
    //   11940: dup
    //   11941: aload 5
    //   11943: iconst_0
    //   11944: aaload
    //   11945: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11948: ldc_w 1380
    //   11951: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11954: astore_1
    //   11955: aload_1
    //   11956: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11959: ifeq +14 -> 11973
    //   11962: ldc 191
    //   11964: iconst_1
    //   11965: ldc_w 3344
    //   11968: invokestatic 613	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11971: iconst_1
    //   11972: ireturn
    //   11973: new 109	org/json/JSONObject
    //   11976: dup
    //   11977: invokespecial 168	org/json/JSONObject:<init>	()V
    //   11980: astore_2
    //   11981: new 109	org/json/JSONObject
    //   11984: dup
    //   11985: invokespecial 168	org/json/JSONObject:<init>	()V
    //   11988: astore_3
    //   11989: aload_0
    //   11990: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   11993: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   11996: invokevirtual 349	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   11999: ldc_w 350
    //   12002: invokevirtual 356	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   12005: istore 7
    //   12007: iload 7
    //   12009: istore 6
    //   12011: invokestatic 1530	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   12014: iconst_1
    //   12015: if_icmpne +18 -> 12033
    //   12018: iload 7
    //   12020: aload_0
    //   12021: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   12024: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   12027: invokestatic 1533	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   12030: iadd
    //   12031: istore 6
    //   12033: aload_3
    //   12034: ldc_w 1447
    //   12037: iload 6
    //   12039: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   12042: pop
    //   12043: aload_2
    //   12044: ldc_w 1429
    //   12047: iconst_0
    //   12048: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   12051: pop
    //   12052: aload_2
    //   12053: ldc 178
    //   12055: ldc_w 3346
    //   12058: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   12061: pop
    //   12062: aload_2
    //   12063: ldc 221
    //   12065: aload_3
    //   12066: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   12069: pop
    //   12070: aload_0
    //   12071: aload_1
    //   12072: iconst_1
    //   12073: anewarray 334	java/lang/String
    //   12076: dup
    //   12077: iconst_0
    //   12078: aload_2
    //   12079: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12082: aastore
    //   12083: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12086: goto -11902 -> 184
    //   12089: astore_1
    //   12090: ldc 191
    //   12092: iconst_1
    //   12093: new 497	java/lang/StringBuilder
    //   12096: dup
    //   12097: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   12100: ldc_w 3348
    //   12103: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12106: aload_1
    //   12107: invokestatic 2476	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   12110: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12113: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12116: invokestatic 613	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   12119: goto -11935 -> 184
    //   12122: ldc_w 3350
    //   12125: aload 4
    //   12127: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12130: ifeq +78 -> 12208
    //   12133: new 109	org/json/JSONObject
    //   12136: dup
    //   12137: aload 5
    //   12139: iconst_0
    //   12140: aaload
    //   12141: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12144: astore_1
    //   12145: aload_1
    //   12146: ldc_w 1337
    //   12149: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12152: astore_2
    //   12153: aload_0
    //   12154: aload_1
    //   12155: ldc_w 1380
    //   12158: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12161: putfield 3352	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   12164: aload_0
    //   12165: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   12168: ifnonnull +17 -> 12185
    //   12171: aload_0
    //   12172: invokestatic 1679	wxu:a	()Lwxu;
    //   12175: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   12178: aload_0
    //   12179: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   12182: invokevirtual 1680	wxu:a	()V
    //   12185: aload_0
    //   12186: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   12189: aload_2
    //   12190: new 3354	aror
    //   12193: dup
    //   12194: aload_0
    //   12195: aload_2
    //   12196: invokespecial 3355	aror:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   12199: invokevirtual 3358	wxu:a	(Ljava/lang/String;Lwxw;)V
    //   12202: goto -12018 -> 184
    //   12205: astore_1
    //   12206: iconst_1
    //   12207: ireturn
    //   12208: ldc_w 3360
    //   12211: aload 4
    //   12213: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12216: ifeq +441 -> 12657
    //   12219: aload 5
    //   12221: arraylength
    //   12222: iconst_1
    //   12223: if_icmpne +434 -> 12657
    //   12226: new 109	org/json/JSONObject
    //   12229: dup
    //   12230: aload 5
    //   12232: iconst_0
    //   12233: aaload
    //   12234: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12237: astore_3
    //   12238: aload_3
    //   12239: ldc_w 3362
    //   12242: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12245: astore 4
    //   12247: aload_3
    //   12248: ldc_w 3364
    //   12251: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12254: astore_1
    //   12255: aload_1
    //   12256: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12259: ifeq +22 -> 12281
    //   12262: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12265: ifeq +5307 -> 17572
    //   12268: ldc_w 3366
    //   12271: iconst_2
    //   12272: ldc_w 3368
    //   12275: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12278: goto +5294 -> 17572
    //   12281: aload_0
    //   12282: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   12285: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   12288: astore_2
    //   12289: aload_2
    //   12290: ifnull +10 -> 12300
    //   12293: aload_2
    //   12294: invokevirtual 3372	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lnks;
    //   12297: ifnonnull +22 -> 12319
    //   12300: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12303: ifeq +5271 -> 17574
    //   12306: ldc_w 3366
    //   12309: iconst_2
    //   12310: ldc_w 3374
    //   12313: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12316: goto +5258 -> 17574
    //   12319: aload_2
    //   12320: invokevirtual 3372	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lnks;
    //   12323: getfield 3377	nks:jdField_a_of_type_Int	I
    //   12326: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12329: astore_2
    //   12330: aload_3
    //   12331: ldc_w 3071
    //   12334: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   12337: istore 6
    //   12339: iload 6
    //   12341: iconst_1
    //   12342: if_icmpne +226 -> 12568
    //   12345: new 3379	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   12348: dup
    //   12349: invokespecial 3380	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   12352: astore_3
    //   12353: aload_3
    //   12354: getfield 3383	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12357: sipush 1814
    //   12360: invokevirtual 272	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12363: aload_3
    //   12364: getfield 3386	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12367: bipush 48
    //   12369: invokevirtual 272	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12372: aload_1
    //   12373: invokevirtual 3389	java/lang/String:getBytes	()[B
    //   12376: arraylength
    //   12377: bipush 6
    //   12379: iadd
    //   12380: invokestatic 3395	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   12383: astore 4
    //   12385: aload 4
    //   12387: aload_2
    //   12388: invokevirtual 2254	java/lang/Integer:intValue	()I
    //   12391: invokevirtual 3397	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   12394: pop
    //   12395: aload 4
    //   12397: aload_1
    //   12398: invokevirtual 3389	java/lang/String:getBytes	()[B
    //   12401: arraylength
    //   12402: i2s
    //   12403: invokevirtual 3401	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   12406: pop
    //   12407: aload 4
    //   12409: aload_1
    //   12410: invokevirtual 3389	java/lang/String:getBytes	()[B
    //   12413: invokevirtual 3404	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   12416: pop
    //   12417: aload_3
    //   12418: getfield 3408	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12421: aload 4
    //   12423: invokevirtual 3411	java/nio/ByteBuffer:array	()[B
    //   12426: invokestatic 3417	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12429: invokevirtual 3422	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   12432: new 290	mqq/app/NewIntent
    //   12435: dup
    //   12436: aload_0
    //   12437: invokevirtual 1835	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   12440: ldc_w 298
    //   12443: invokespecial 301	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12446: astore_2
    //   12447: new 400	android/os/Bundle
    //   12450: dup
    //   12451: invokespecial 870	android/os/Bundle:<init>	()V
    //   12454: astore 4
    //   12456: aload 4
    //   12458: ldc_w 3364
    //   12461: aload_1
    //   12462: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   12465: aload_2
    //   12466: aload 4
    //   12468: invokevirtual 3423	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   12471: pop
    //   12472: aload_2
    //   12473: ldc_w 306
    //   12476: ldc_w 3425
    //   12479: invokevirtual 309	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12482: pop
    //   12483: aload_2
    //   12484: ldc 221
    //   12486: aload_3
    //   12487: invokevirtual 3426	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   12490: invokevirtual 316	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12493: pop
    //   12494: aload_2
    //   12495: ldc_w 3428
    //   12498: iconst_1
    //   12499: invokevirtual 3429	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12502: pop
    //   12503: aload_2
    //   12504: new 3431	aros
    //   12507: dup
    //   12508: aload_0
    //   12509: invokespecial 3432	aros:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   12512: invokevirtual 325	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   12515: aload_0
    //   12516: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   12519: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   12522: aload_2
    //   12523: invokevirtual 331	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12526: goto -12342 -> 184
    //   12529: astore_1
    //   12530: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12533: ifeq -12349 -> 184
    //   12536: ldc 191
    //   12538: iconst_2
    //   12539: new 497	java/lang/StringBuilder
    //   12542: dup
    //   12543: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   12546: ldc_w 3434
    //   12549: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12552: aload 5
    //   12554: iconst_0
    //   12555: aaload
    //   12556: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12559: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12562: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12565: goto -12381 -> 184
    //   12568: iload 6
    //   12570: ifne -12386 -> 184
    //   12573: aload_0
    //   12574: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   12577: ifnonnull +17 -> 12594
    //   12580: aload_0
    //   12581: invokestatic 1679	wxu:a	()Lwxu;
    //   12584: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   12587: aload_0
    //   12588: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   12591: invokevirtual 1680	wxu:a	()V
    //   12594: aload_0
    //   12595: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   12598: aload_2
    //   12599: aload_1
    //   12600: aload 4
    //   12602: new 3436	arot
    //   12605: dup
    //   12606: aload_0
    //   12607: aload_2
    //   12608: aload_1
    //   12609: invokespecial 3439	arot:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;)V
    //   12612: invokevirtual 3442	wxu:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lwxw;)V
    //   12615: goto -12431 -> 184
    //   12618: astore_1
    //   12619: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12622: ifeq -12438 -> 184
    //   12625: ldc 191
    //   12627: iconst_2
    //   12628: new 497	java/lang/StringBuilder
    //   12631: dup
    //   12632: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   12635: ldc_w 3444
    //   12638: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12641: aload 5
    //   12643: iconst_0
    //   12644: aaload
    //   12645: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12648: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12651: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12654: goto -12470 -> 184
    //   12657: ldc_w 3446
    //   12660: aload 4
    //   12662: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12665: ifeq +455 -> 13120
    //   12668: aload 5
    //   12670: arraylength
    //   12671: iconst_1
    //   12672: if_icmpne +448 -> 13120
    //   12675: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12678: ifeq +33 -> 12711
    //   12681: ldc_w 3366
    //   12684: iconst_2
    //   12685: new 497	java/lang/StringBuilder
    //   12688: dup
    //   12689: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   12692: ldc_w 3448
    //   12695: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12698: aload 5
    //   12700: iconst_0
    //   12701: aaload
    //   12702: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12705: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12708: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12711: new 109	org/json/JSONObject
    //   12714: dup
    //   12715: aload 5
    //   12717: iconst_0
    //   12718: aaload
    //   12719: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12722: astore_3
    //   12723: aload_3
    //   12724: ldc_w 3362
    //   12727: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12730: astore_1
    //   12731: aload_3
    //   12732: ldc_w 3364
    //   12735: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12738: astore_2
    //   12739: aload_3
    //   12740: ldc_w 3450
    //   12743: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12746: astore_3
    //   12747: aload_2
    //   12748: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12751: ifne +10 -> 12761
    //   12754: aload_3
    //   12755: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12758: ifeq +49 -> 12807
    //   12761: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12764: ifeq +4812 -> 17576
    //   12767: ldc_w 3366
    //   12770: iconst_2
    //   12771: new 497	java/lang/StringBuilder
    //   12774: dup
    //   12775: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   12778: ldc_w 3452
    //   12781: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12784: aload_3
    //   12785: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12788: ldc_w 3454
    //   12791: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12794: aload_2
    //   12795: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12798: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12801: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12804: goto +4772 -> 17576
    //   12807: aload_0
    //   12808: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   12811: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   12814: astore 4
    //   12816: aload 4
    //   12818: ifnull +11 -> 12829
    //   12821: aload 4
    //   12823: invokevirtual 3372	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lnks;
    //   12826: ifnonnull +22 -> 12848
    //   12829: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12832: ifeq +4746 -> 17578
    //   12835: ldc_w 3366
    //   12838: iconst_2
    //   12839: ldc_w 3456
    //   12842: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12845: goto +4733 -> 17578
    //   12848: aload 4
    //   12850: invokevirtual 3372	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lnks;
    //   12853: getfield 3377	nks:jdField_a_of_type_Int	I
    //   12856: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12859: astore 4
    //   12861: new 3379	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   12864: dup
    //   12865: invokespecial 3380	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   12868: astore 14
    //   12870: aload 14
    //   12872: getfield 3383	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12875: sipush 1814
    //   12878: invokevirtual 272	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12881: aload 14
    //   12883: getfield 3386	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12886: bipush 48
    //   12888: invokevirtual 272	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12891: aload_3
    //   12892: invokevirtual 3389	java/lang/String:getBytes	()[B
    //   12895: arraylength
    //   12896: bipush 6
    //   12898: iadd
    //   12899: invokestatic 3395	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   12902: astore 15
    //   12904: aload 15
    //   12906: aload 4
    //   12908: invokevirtual 2254	java/lang/Integer:intValue	()I
    //   12911: invokevirtual 3397	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   12914: pop
    //   12915: aload 15
    //   12917: aload_3
    //   12918: invokevirtual 3389	java/lang/String:getBytes	()[B
    //   12921: arraylength
    //   12922: i2s
    //   12923: invokevirtual 3401	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   12926: pop
    //   12927: aload 15
    //   12929: aload_3
    //   12930: invokevirtual 3389	java/lang/String:getBytes	()[B
    //   12933: invokevirtual 3404	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   12936: pop
    //   12937: aload 14
    //   12939: getfield 3408	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12942: aload 15
    //   12944: invokevirtual 3411	java/nio/ByteBuffer:array	()[B
    //   12947: invokestatic 3417	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12950: invokevirtual 3422	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   12953: new 290	mqq/app/NewIntent
    //   12956: dup
    //   12957: aload_0
    //   12958: invokevirtual 1835	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   12961: ldc_w 298
    //   12964: invokespecial 301	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12967: astore_3
    //   12968: aload_3
    //   12969: new 400	android/os/Bundle
    //   12972: dup
    //   12973: invokespecial 870	android/os/Bundle:<init>	()V
    //   12976: invokevirtual 3423	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   12979: pop
    //   12980: aload_3
    //   12981: ldc_w 306
    //   12984: ldc_w 3425
    //   12987: invokevirtual 309	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12990: pop
    //   12991: aload_3
    //   12992: ldc 221
    //   12994: aload 14
    //   12996: invokevirtual 3426	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   12999: invokevirtual 316	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   13002: pop
    //   13003: aload_3
    //   13004: ldc_w 3428
    //   13007: iconst_1
    //   13008: invokevirtual 3429	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   13011: pop
    //   13012: aload_3
    //   13013: new 3458	arou
    //   13016: dup
    //   13017: aload_0
    //   13018: aload 4
    //   13020: aload_2
    //   13021: aload_1
    //   13022: invokespecial 3461	arou:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V
    //   13025: invokevirtual 325	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   13028: aload_0
    //   13029: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   13032: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   13035: aload_3
    //   13036: invokevirtual 331	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   13039: goto -12855 -> 184
    //   13042: astore_1
    //   13043: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13046: ifeq -12862 -> 184
    //   13049: ldc 191
    //   13051: iconst_2
    //   13052: new 497	java/lang/StringBuilder
    //   13055: dup
    //   13056: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13059: ldc_w 3434
    //   13062: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13065: aload 5
    //   13067: iconst_0
    //   13068: aaload
    //   13069: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13072: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13075: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13078: goto -12894 -> 184
    //   13081: astore_1
    //   13082: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13085: ifeq -12901 -> 184
    //   13088: ldc 191
    //   13090: iconst_2
    //   13091: new 497	java/lang/StringBuilder
    //   13094: dup
    //   13095: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13098: ldc_w 3444
    //   13101: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13104: aload 5
    //   13106: iconst_0
    //   13107: aaload
    //   13108: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13111: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13114: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13117: goto -12933 -> 184
    //   13120: ldc_w 3463
    //   13123: aload 4
    //   13125: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13128: ifeq +200 -> 13328
    //   13131: aload_0
    //   13132: new 109	org/json/JSONObject
    //   13135: dup
    //   13136: aload 5
    //   13138: iconst_0
    //   13139: aaload
    //   13140: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13143: ldc_w 1380
    //   13146: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13149: putfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   13152: aload_0
    //   13153: invokevirtual 2231	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbchu;
    //   13156: astore_1
    //   13157: aload_1
    //   13158: ifnull -12974 -> 184
    //   13161: aload_1
    //   13162: invokeinterface 3465 1 0
    //   13167: istore 6
    //   13169: aload_0
    //   13170: aload_0
    //   13171: getfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   13174: iconst_1
    //   13175: anewarray 334	java/lang/String
    //   13178: dup
    //   13179: iconst_0
    //   13180: new 497	java/lang/StringBuilder
    //   13183: dup
    //   13184: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13187: ldc_w 3467
    //   13190: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13193: iload 6
    //   13195: invokevirtual 1063	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13198: ldc_w 1433
    //   13201: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13204: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13207: aastore
    //   13208: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13211: goto -13027 -> 184
    //   13214: astore_1
    //   13215: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13218: ifeq -13034 -> 184
    //   13221: aload_0
    //   13222: aload_0
    //   13223: getfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   13226: iconst_1
    //   13227: anewarray 334	java/lang/String
    //   13230: dup
    //   13231: iconst_0
    //   13232: ldc_w 3469
    //   13235: aastore
    //   13236: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13239: ldc 191
    //   13241: iconst_2
    //   13242: new 497	java/lang/StringBuilder
    //   13245: dup
    //   13246: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13249: ldc_w 3471
    //   13252: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13255: aload_1
    //   13256: invokevirtual 3340	org/json/JSONException:toString	()Ljava/lang/String;
    //   13259: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13262: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13265: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13268: goto -13084 -> 184
    //   13271: astore_1
    //   13272: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13275: ifeq -13091 -> 184
    //   13278: aload_0
    //   13279: aload_0
    //   13280: getfield 2652	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   13283: iconst_1
    //   13284: anewarray 334	java/lang/String
    //   13287: dup
    //   13288: iconst_0
    //   13289: ldc_w 3469
    //   13292: aastore
    //   13293: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13296: ldc 191
    //   13298: iconst_2
    //   13299: new 497	java/lang/StringBuilder
    //   13302: dup
    //   13303: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13306: ldc_w 3471
    //   13309: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13312: aload_1
    //   13313: invokevirtual 611	java/lang/Exception:toString	()Ljava/lang/String;
    //   13316: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13319: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13322: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13325: goto -13141 -> 184
    //   13328: ldc_w 3473
    //   13331: aload 4
    //   13333: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13336: ifeq +135 -> 13471
    //   13339: aload 5
    //   13341: arraylength
    //   13342: iconst_1
    //   13343: if_icmpgt +128 -> 13471
    //   13346: ldc_w 371
    //   13349: astore_1
    //   13350: aload 5
    //   13352: arraylength
    //   13353: iconst_1
    //   13354: if_icmpne +4051 -> 17405
    //   13357: new 109	org/json/JSONObject
    //   13360: dup
    //   13361: aload 5
    //   13363: iconst_0
    //   13364: aaload
    //   13365: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13368: astore_3
    //   13369: aload_3
    //   13370: ldc_w 909
    //   13373: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13376: astore_2
    //   13377: aload_2
    //   13378: astore_1
    //   13379: aload_3
    //   13380: ldc_w 1382
    //   13383: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   13386: ifeq +4019 -> 17405
    //   13389: aload_3
    //   13390: ldc_w 1382
    //   13393: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13396: astore_1
    //   13397: aload_0
    //   13398: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   13401: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   13404: astore_3
    //   13405: aload_3
    //   13406: ifnull -13222 -> 184
    //   13409: aload_3
    //   13410: instanceof 1323
    //   13413: ifeq -13229 -> 184
    //   13416: aload_3
    //   13417: checkcast 1323	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13420: invokevirtual 2880	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13423: checkcast 2882	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13426: iconst_0
    //   13427: aload_2
    //   13428: aload_1
    //   13429: invokevirtual 3476	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   13432: goto -13248 -> 184
    //   13435: astore_1
    //   13436: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13439: ifeq -13255 -> 184
    //   13442: ldc 191
    //   13444: iconst_4
    //   13445: new 497	java/lang/StringBuilder
    //   13448: dup
    //   13449: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13452: ldc_w 3478
    //   13455: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13458: aload_1
    //   13459: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13462: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13465: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13468: goto -13284 -> 184
    //   13471: ldc_w 3480
    //   13474: aload 4
    //   13476: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13479: ifeq +256 -> 13735
    //   13482: aload 5
    //   13484: arraylength
    //   13485: iconst_1
    //   13486: if_icmpgt +249 -> 13735
    //   13489: aload 5
    //   13491: arraylength
    //   13492: iconst_1
    //   13493: if_icmpne -13309 -> 184
    //   13496: new 109	org/json/JSONObject
    //   13499: dup
    //   13500: aload 5
    //   13502: iconst_0
    //   13503: aaload
    //   13504: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13507: astore_1
    //   13508: aload_1
    //   13509: ldc_w 3096
    //   13512: iconst_m1
    //   13513: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13516: istore 6
    //   13518: aload_1
    //   13519: ldc_w 3184
    //   13522: iconst_m1
    //   13523: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13526: istore 7
    //   13528: aload_0
    //   13529: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   13532: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   13535: astore_1
    //   13536: aload_1
    //   13537: ifnull -13353 -> 184
    //   13540: aload_1
    //   13541: instanceof 1323
    //   13544: ifeq -13360 -> 184
    //   13547: aload_1
    //   13548: checkcast 1323	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13551: invokevirtual 2880	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13554: checkcast 2882	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13557: astore_1
    //   13558: aload_1
    //   13559: ifnull -13375 -> 184
    //   13562: iload 7
    //   13564: iconst_1
    //   13565: if_icmpne +134 -> 13699
    //   13568: aload_1
    //   13569: iconst_0
    //   13570: putfield 3481	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13573: aload_1
    //   13574: iconst_1
    //   13575: invokevirtual 3482	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   13578: iload 6
    //   13580: iconst_1
    //   13581: if_icmpne +136 -> 13717
    //   13584: aload_1
    //   13585: iconst_0
    //   13586: putfield 3481	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13589: aload_1
    //   13590: iconst_1
    //   13591: invokevirtual 3483	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:d	(Z)V
    //   13594: goto -13410 -> 184
    //   13597: astore_1
    //   13598: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13601: ifeq -13417 -> 184
    //   13604: ldc 191
    //   13606: iconst_4
    //   13607: new 497	java/lang/StringBuilder
    //   13610: dup
    //   13611: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13614: ldc_w 3485
    //   13617: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13620: aload_1
    //   13621: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13624: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13627: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13630: goto -13446 -> 184
    //   13633: astore_2
    //   13634: ldc 191
    //   13636: iconst_1
    //   13637: new 497	java/lang/StringBuilder
    //   13640: dup
    //   13641: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13644: ldc_w 3487
    //   13647: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13650: aload_2
    //   13651: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13654: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13657: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13660: iconst_m1
    //   13661: istore 6
    //   13663: goto -145 -> 13518
    //   13666: astore_1
    //   13667: iconst_m1
    //   13668: istore 7
    //   13670: ldc 191
    //   13672: iconst_1
    //   13673: new 497	java/lang/StringBuilder
    //   13676: dup
    //   13677: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13680: ldc_w 3489
    //   13683: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13686: aload_1
    //   13687: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13690: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13693: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13696: goto -168 -> 13528
    //   13699: iload 7
    //   13701: ifne -123 -> 13578
    //   13704: aload_1
    //   13705: iconst_1
    //   13706: putfield 3481	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13709: aload_1
    //   13710: iconst_0
    //   13711: invokevirtual 3482	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   13714: goto -136 -> 13578
    //   13717: iload 6
    //   13719: ifne -13535 -> 184
    //   13722: aload_1
    //   13723: iconst_1
    //   13724: putfield 3481	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13727: aload_1
    //   13728: iconst_0
    //   13729: invokevirtual 3483	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:d	(Z)V
    //   13732: goto -13548 -> 184
    //   13735: ldc_w 3491
    //   13738: aload 4
    //   13740: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13743: ifeq +168 -> 13911
    //   13746: aload 5
    //   13748: arraylength
    //   13749: iconst_1
    //   13750: if_icmpgt +161 -> 13911
    //   13753: aload 5
    //   13755: arraylength
    //   13756: iconst_1
    //   13757: if_icmpne -13573 -> 184
    //   13760: aload 5
    //   13762: arraylength
    //   13763: iconst_1
    //   13764: if_icmpne -13580 -> 184
    //   13767: new 109	org/json/JSONObject
    //   13770: dup
    //   13771: aload 5
    //   13773: iconst_0
    //   13774: aaload
    //   13775: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13778: ldc_w 3493
    //   13781: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13784: astore_1
    //   13785: aload_0
    //   13786: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   13789: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   13792: astore_2
    //   13793: aload_2
    //   13794: ifnull -13610 -> 184
    //   13797: aload_2
    //   13798: instanceof 1323
    //   13801: ifeq -13617 -> 184
    //   13804: aload_2
    //   13805: checkcast 1323	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13808: invokevirtual 2880	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13811: checkcast 2882	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13814: astore_3
    //   13815: ldc_w 642
    //   13818: aload_1
    //   13819: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13822: ifeq +61 -> 13883
    //   13825: aload_2
    //   13826: ldc_w 3495
    //   13829: invokevirtual 3496	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13832: checkcast 3498	android/view/inputmethod/InputMethodManager
    //   13835: aload_3
    //   13836: invokevirtual 3501	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13839: iconst_0
    //   13840: invokevirtual 3505	android/view/inputmethod/InputMethodManager:showSoftInput	(Landroid/view/View;I)Z
    //   13843: pop
    //   13844: goto -13660 -> 184
    //   13847: astore_1
    //   13848: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13851: ifeq -13667 -> 184
    //   13854: ldc 191
    //   13856: iconst_4
    //   13857: new 497	java/lang/StringBuilder
    //   13860: dup
    //   13861: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13864: ldc_w 3507
    //   13867: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13870: aload_1
    //   13871: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13874: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13877: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13880: goto -13696 -> 184
    //   13883: aload_2
    //   13884: ldc_w 3495
    //   13887: invokevirtual 3496	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13890: checkcast 3498	android/view/inputmethod/InputMethodManager
    //   13893: aload_2
    //   13894: invokevirtual 2904	android/app/Activity:getWindow	()Landroid/view/Window;
    //   13897: invokevirtual 3510	android/view/Window:getDecorView	()Landroid/view/View;
    //   13900: invokevirtual 3514	android/view/View:getWindowToken	()Landroid/os/IBinder;
    //   13903: iconst_0
    //   13904: invokevirtual 3518	android/view/inputmethod/InputMethodManager:hideSoftInputFromWindow	(Landroid/os/IBinder;I)Z
    //   13907: pop
    //   13908: goto -13724 -> 184
    //   13911: ldc_w 3520
    //   13914: aload 4
    //   13916: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13919: ifeq +96 -> 14015
    //   13922: aload 5
    //   13924: arraylength
    //   13925: iconst_1
    //   13926: if_icmpgt +89 -> 14015
    //   13929: aload 5
    //   13931: arraylength
    //   13932: iconst_1
    //   13933: if_icmpne -13749 -> 184
    //   13936: new 109	org/json/JSONObject
    //   13939: dup
    //   13940: aload 5
    //   13942: iconst_0
    //   13943: aaload
    //   13944: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13947: ldc_w 1380
    //   13950: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13953: astore_1
    //   13954: aload_1
    //   13955: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13958: ifne -13774 -> 184
    //   13961: aload_0
    //   13962: aload_1
    //   13963: iconst_1
    //   13964: anewarray 334	java/lang/String
    //   13967: dup
    //   13968: iconst_0
    //   13969: ldc_w 3522
    //   13972: aastore
    //   13973: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13976: goto -13792 -> 184
    //   13979: astore_1
    //   13980: invokestatic 2346	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13983: ifeq -13799 -> 184
    //   13986: ldc 191
    //   13988: iconst_4
    //   13989: new 497	java/lang/StringBuilder
    //   13992: dup
    //   13993: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13996: ldc_w 3524
    //   13999: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14002: aload_1
    //   14003: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14006: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14009: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14012: goto -13828 -> 184
    //   14015: ldc_w 3526
    //   14018: aload 4
    //   14020: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14023: ifeq +114 -> 14137
    //   14026: aload 5
    //   14028: arraylength
    //   14029: ifle +108 -> 14137
    //   14032: new 109	org/json/JSONObject
    //   14035: dup
    //   14036: aload 5
    //   14038: iconst_0
    //   14039: aaload
    //   14040: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14043: astore_3
    //   14044: aload_0
    //   14045: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14048: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   14051: astore_1
    //   14052: aload_0
    //   14053: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14056: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   14059: astore_2
    //   14060: aload_3
    //   14061: ldc_w 2366
    //   14064: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14067: astore_3
    //   14068: aload_3
    //   14069: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14072: ifne -13888 -> 184
    //   14075: aload_1
    //   14076: ifnull -13892 -> 184
    //   14079: aload_2
    //   14080: ifnull -13896 -> 184
    //   14083: aload_1
    //   14084: new 3528	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   14087: dup
    //   14088: aload_3
    //   14089: bipush 90
    //   14091: invokespecial 3530	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   14094: invokestatic 3535	com/tencent/mobileqq/activity/ProfileActivity:b	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)V
    //   14097: goto -13913 -> 184
    //   14100: astore_1
    //   14101: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14104: ifeq -13920 -> 184
    //   14107: ldc_w 2316
    //   14110: iconst_2
    //   14111: new 497	java/lang/StringBuilder
    //   14114: dup
    //   14115: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   14118: ldc_w 3537
    //   14121: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14124: aload_1
    //   14125: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14128: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14131: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14134: goto -13950 -> 184
    //   14137: ldc_w 3539
    //   14140: aload 4
    //   14142: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14145: ifeq +96 -> 14241
    //   14148: aload 5
    //   14150: arraylength
    //   14151: ifle +90 -> 14241
    //   14154: new 109	org/json/JSONObject
    //   14157: dup
    //   14158: aload 5
    //   14160: iconst_0
    //   14161: aaload
    //   14162: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14165: ldc_w 3541
    //   14168: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14171: istore 6
    //   14173: aload_0
    //   14174: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14177: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   14180: astore_1
    //   14181: aload_1
    //   14182: ifnull -13998 -> 184
    //   14185: aload_1
    //   14186: instanceof 1323
    //   14189: ifeq -14005 -> 184
    //   14192: aload_1
    //   14193: checkcast 1323	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   14196: iload 6
    //   14198: invokevirtual 3542	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	(I)V
    //   14201: goto -14017 -> 184
    //   14204: astore_1
    //   14205: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14208: ifeq -14024 -> 184
    //   14211: ldc_w 2316
    //   14214: iconst_2
    //   14215: new 497	java/lang/StringBuilder
    //   14218: dup
    //   14219: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   14222: ldc_w 3544
    //   14225: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14228: aload_1
    //   14229: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14232: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14235: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14238: goto -14054 -> 184
    //   14241: ldc_w 3546
    //   14244: aload 4
    //   14246: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14249: ifeq +267 -> 14516
    //   14252: aload 5
    //   14254: arraylength
    //   14255: ifle +261 -> 14516
    //   14258: new 109	org/json/JSONObject
    //   14261: dup
    //   14262: aload 5
    //   14264: iconst_0
    //   14265: aaload
    //   14266: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14269: astore_3
    //   14270: aload_3
    //   14271: ldc_w 3548
    //   14274: iconst_0
    //   14275: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14278: iconst_1
    //   14279: if_icmpne +176 -> 14455
    //   14282: iconst_1
    //   14283: istore 12
    //   14285: aload_3
    //   14286: ldc_w 3550
    //   14289: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14292: istore 6
    //   14294: aload_3
    //   14295: ldc_w 3552
    //   14298: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14301: istore 7
    //   14303: aload_3
    //   14304: ldc_w 3554
    //   14307: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14310: istore 8
    //   14312: aload_3
    //   14313: ldc_w 3556
    //   14316: iconst_1
    //   14317: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14320: iconst_1
    //   14321: if_icmpne +140 -> 14461
    //   14324: iconst_1
    //   14325: istore 13
    //   14327: aload_3
    //   14328: ldc_w 3558
    //   14331: aconst_null
    //   14332: invokevirtual 2380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14335: astore_1
    //   14336: aload_3
    //   14337: ldc_w 3560
    //   14340: aconst_null
    //   14341: invokevirtual 2380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14344: astore_2
    //   14345: aload_3
    //   14346: ldc_w 1380
    //   14349: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14352: astore_3
    //   14353: aload_0
    //   14354: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14357: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   14360: astore 5
    //   14362: aload_0
    //   14363: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14366: invokevirtual 1512	bcdb:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   14369: astore 4
    //   14371: aload_0
    //   14372: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14375: aload 5
    //   14377: invokevirtual 699	bcdb:a	(Landroid/app/Activity;)Lbcci;
    //   14380: astore 5
    //   14382: aload 4
    //   14384: ifnull +83 -> 14467
    //   14387: aload 4
    //   14389: getfield 2779	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bcfj	Lbcfj;
    //   14392: ifnull +75 -> 14467
    //   14395: aload 4
    //   14397: getfield 2779	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bcfj	Lbcfj;
    //   14400: iload 12
    //   14402: iload 6
    //   14404: iload 7
    //   14406: iload 8
    //   14408: iload 13
    //   14410: aload_1
    //   14411: aload_2
    //   14412: aload_3
    //   14413: invokevirtual 3563	bcfj:a	(ZIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   14416: goto -14232 -> 184
    //   14419: astore_1
    //   14420: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14423: ifeq -14239 -> 184
    //   14426: ldc 191
    //   14428: iconst_2
    //   14429: new 497	java/lang/StringBuilder
    //   14432: dup
    //   14433: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   14436: ldc_w 3565
    //   14439: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14442: aload_1
    //   14443: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14446: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14449: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14452: goto -14268 -> 184
    //   14455: iconst_0
    //   14456: istore 12
    //   14458: goto -173 -> 14285
    //   14461: iconst_0
    //   14462: istore 13
    //   14464: goto -137 -> 14327
    //   14467: aload 5
    //   14469: ifnull -14285 -> 184
    //   14472: aload 5
    //   14474: instanceof 1420
    //   14477: ifeq -14293 -> 184
    //   14480: aload 5
    //   14482: checkcast 1420	bchn
    //   14485: iload 12
    //   14487: iload 6
    //   14489: iload 7
    //   14491: iload 8
    //   14493: iload 13
    //   14495: aload_1
    //   14496: aload_2
    //   14497: aload_3
    //   14498: aload_0
    //   14499: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14502: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14505: invokevirtual 1423	java/lang/Object:hashCode	()I
    //   14508: invokeinterface 3568 10 0
    //   14513: goto -14329 -> 184
    //   14516: ldc_w 3570
    //   14519: aload 4
    //   14521: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14524: ifeq +162 -> 14686
    //   14527: aload 5
    //   14529: arraylength
    //   14530: ifle +156 -> 14686
    //   14533: new 109	org/json/JSONObject
    //   14536: dup
    //   14537: aload 5
    //   14539: iconst_0
    //   14540: aaload
    //   14541: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14544: ldc_w 1069
    //   14547: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14550: istore 6
    //   14552: aload_0
    //   14553: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14556: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14559: astore_2
    //   14560: aload_2
    //   14561: ifnull -14377 -> 184
    //   14564: iload 6
    //   14566: ifne +24 -> 14590
    //   14569: aload_2
    //   14570: invokevirtual 3573	com/tencent/biz/pubaccount/CustomWebView:reload	()V
    //   14573: goto -14389 -> 184
    //   14576: astore_1
    //   14577: ldc 191
    //   14579: iconst_2
    //   14580: ldc_w 3575
    //   14583: aload_1
    //   14584: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14587: goto -14403 -> 184
    //   14590: aload_0
    //   14591: iconst_4
    //   14592: invokevirtual 2509	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   14595: checkcast 3577	bcet
    //   14598: astore_1
    //   14599: aload_1
    //   14600: ifnull -14416 -> 184
    //   14603: aload_2
    //   14604: invokevirtual 3580	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   14607: astore_2
    //   14608: aload_1
    //   14609: getfield 3583	bcet:a	Lxmt;
    //   14612: ifnonnull +28 -> 14640
    //   14615: aload_1
    //   14616: new 1803	xmt
    //   14619: dup
    //   14620: aload_0
    //   14621: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14624: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   14627: aload_0
    //   14628: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14631: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   14634: invokespecial 3586	xmt:<init>	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;)V
    //   14637: putfield 3583	bcet:a	Lxmt;
    //   14640: iload 6
    //   14642: iconst_1
    //   14643: if_icmpne +20 -> 14663
    //   14646: aload_1
    //   14647: bipush 6
    //   14649: aload_2
    //   14650: new 400	android/os/Bundle
    //   14653: dup
    //   14654: invokespecial 870	android/os/Bundle:<init>	()V
    //   14657: invokevirtual 3589	bcet:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   14660: goto -14476 -> 184
    //   14663: iload 6
    //   14665: iconst_2
    //   14666: if_icmpne -14482 -> 184
    //   14669: aload_1
    //   14670: bipush 11
    //   14672: aload_2
    //   14673: new 400	android/os/Bundle
    //   14676: dup
    //   14677: invokespecial 870	android/os/Bundle:<init>	()V
    //   14680: invokevirtual 3589	bcet:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   14683: goto -14499 -> 184
    //   14686: ldc_w 3591
    //   14689: aload 4
    //   14691: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14694: ifeq +62 -> 14756
    //   14697: new 125	android/content/Intent
    //   14700: dup
    //   14701: aload_0
    //   14702: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14705: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   14708: ldc_w 3593
    //   14711: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   14714: astore_1
    //   14715: aload_1
    //   14716: ldc_w 3595
    //   14719: aload 5
    //   14721: iconst_0
    //   14722: aaload
    //   14723: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14726: pop
    //   14727: aload_0
    //   14728: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14731: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   14734: aload_1
    //   14735: sipush 11533
    //   14738: invokevirtual 1191	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   14741: aload_0
    //   14742: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14745: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   14748: iconst_0
    //   14749: iconst_0
    //   14750: invokevirtual 1196	android/app/Activity:overridePendingTransition	(II)V
    //   14753: goto -14569 -> 184
    //   14756: ldc_w 3597
    //   14759: aload 4
    //   14761: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14764: ifeq +177 -> 14941
    //   14767: new 109	org/json/JSONObject
    //   14770: dup
    //   14771: aload 5
    //   14773: iconst_0
    //   14774: aaload
    //   14775: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14778: astore_2
    //   14779: aload_2
    //   14780: ldc 156
    //   14782: ldc_w 371
    //   14785: invokevirtual 2380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14788: astore_1
    //   14789: aload_0
    //   14790: aload_2
    //   14791: ldc_w 1380
    //   14794: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14797: putfield 2275	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   14800: aload_1
    //   14801: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14804: ifeq +65 -> 14869
    //   14807: new 109	org/json/JSONObject
    //   14810: dup
    //   14811: invokespecial 168	org/json/JSONObject:<init>	()V
    //   14814: astore_1
    //   14815: aload_1
    //   14816: ldc 170
    //   14818: iconst_m1
    //   14819: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14822: pop
    //   14823: aload_1
    //   14824: ldc 221
    //   14826: ldc_w 371
    //   14829: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   14832: pop
    //   14833: aload_0
    //   14834: aload_0
    //   14835: getfield 2275	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   14838: iconst_1
    //   14839: anewarray 334	java/lang/String
    //   14842: dup
    //   14843: iconst_0
    //   14844: aload_1
    //   14845: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14848: aastore
    //   14849: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14852: goto -14668 -> 184
    //   14855: astore_1
    //   14856: ldc 191
    //   14858: iconst_1
    //   14859: ldc_w 3599
    //   14862: aload_1
    //   14863: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14866: goto -14682 -> 184
    //   14869: aload_2
    //   14870: ldc_w 3601
    //   14873: iconst_0
    //   14874: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14877: istore 6
    //   14879: new 125	android/content/Intent
    //   14882: dup
    //   14883: invokespecial 227	android/content/Intent:<init>	()V
    //   14886: astore_2
    //   14887: iload 6
    //   14889: ifne +38 -> 14927
    //   14892: aload_2
    //   14893: invokestatic 583	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14896: ldc_w 1181
    //   14899: invokevirtual 3605	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14902: pop
    //   14903: aload_2
    //   14904: ldc 156
    //   14906: aload_1
    //   14907: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14910: pop
    //   14911: aload_0
    //   14912: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14915: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   14918: aload_2
    //   14919: bipush 14
    //   14921: invokevirtual 1191	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   14924: goto -14740 -> 184
    //   14927: aload_2
    //   14928: invokestatic 583	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14931: ldc_w 3607
    //   14934: invokevirtual 3605	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14937: pop
    //   14938: goto -35 -> 14903
    //   14941: ldc_w 3609
    //   14944: aload 4
    //   14946: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14949: ifeq +61 -> 15010
    //   14952: new 109	org/json/JSONObject
    //   14955: dup
    //   14956: aload 5
    //   14958: iconst_0
    //   14959: aaload
    //   14960: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14963: ldc 221
    //   14965: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14968: astore_1
    //   14969: aload_0
    //   14970: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   14973: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   14976: iconst_m1
    //   14977: new 125	android/content/Intent
    //   14980: dup
    //   14981: invokespecial 227	android/content/Intent:<init>	()V
    //   14984: ldc 221
    //   14986: aload_1
    //   14987: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14990: invokevirtual 238	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   14993: goto -14809 -> 184
    //   14996: astore_1
    //   14997: ldc 191
    //   14999: iconst_1
    //   15000: ldc_w 3611
    //   15003: aload_1
    //   15004: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15007: goto -14823 -> 184
    //   15010: ldc_w 3613
    //   15013: aload 4
    //   15015: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15018: ifne -14834 -> 184
    //   15021: ldc_w 3615
    //   15024: aload 4
    //   15026: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15029: ifeq +99 -> 15128
    //   15032: new 109	org/json/JSONObject
    //   15035: dup
    //   15036: aload 5
    //   15038: iconst_0
    //   15039: aaload
    //   15040: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15043: astore_2
    //   15044: aload_2
    //   15045: ldc_w 1380
    //   15048: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15051: astore_1
    //   15052: aload_2
    //   15053: ldc_w 3184
    //   15056: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15059: iconst_0
    //   15060: iconst_0
    //   15061: invokestatic 3620	bbwc:a	(Ljava/lang/String;ZZ)Lbbwd;
    //   15064: astore_2
    //   15065: new 109	org/json/JSONObject
    //   15068: dup
    //   15069: invokespecial 168	org/json/JSONObject:<init>	()V
    //   15072: astore_3
    //   15073: aload_3
    //   15074: ldc 170
    //   15076: aload_2
    //   15077: getfield 3623	bbwd:jdField_a_of_type_Int	I
    //   15080: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15083: pop
    //   15084: aload_3
    //   15085: ldc 156
    //   15087: aload_2
    //   15088: getfield 3624	bbwd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15091: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   15094: pop
    //   15095: aload_0
    //   15096: aload_1
    //   15097: iconst_1
    //   15098: anewarray 334	java/lang/String
    //   15101: dup
    //   15102: iconst_0
    //   15103: aload_3
    //   15104: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15107: aastore
    //   15108: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15111: goto -14927 -> 184
    //   15114: astore_1
    //   15115: ldc 191
    //   15117: iconst_1
    //   15118: ldc_w 3626
    //   15121: aload_1
    //   15122: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15125: goto -14941 -> 184
    //   15128: ldc_w 3628
    //   15131: aload 4
    //   15133: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15136: ifeq +221 -> 15357
    //   15139: new 109	org/json/JSONObject
    //   15142: dup
    //   15143: aload 5
    //   15145: iconst_0
    //   15146: aaload
    //   15147: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15150: astore_2
    //   15151: aload_2
    //   15152: ldc_w 1380
    //   15155: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15158: astore_1
    //   15159: aload_2
    //   15160: ldc 201
    //   15162: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   15165: istore 6
    //   15167: aload_2
    //   15168: ldc_w 3184
    //   15171: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15174: astore_2
    //   15175: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15178: ifeq +40 -> 15218
    //   15181: ldc 191
    //   15183: iconst_2
    //   15184: new 497	java/lang/StringBuilder
    //   15187: dup
    //   15188: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   15191: ldc_w 3630
    //   15194: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15197: iload 6
    //   15199: invokevirtual 1063	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15202: ldc_w 3632
    //   15205: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15208: aload_2
    //   15209: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15212: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15215: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15218: aload_2
    //   15219: iconst_0
    //   15220: iconst_1
    //   15221: invokestatic 3620	bbwc:a	(Ljava/lang/String;ZZ)Lbbwd;
    //   15224: astore_3
    //   15225: new 109	org/json/JSONObject
    //   15228: dup
    //   15229: invokespecial 168	org/json/JSONObject:<init>	()V
    //   15232: astore 4
    //   15234: aload_3
    //   15235: getfield 3623	bbwd:jdField_a_of_type_Int	I
    //   15238: iconst_1
    //   15239: if_icmpne +46 -> 15285
    //   15242: aload 4
    //   15244: ldc 170
    //   15246: iconst_2
    //   15247: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15250: pop
    //   15251: aload_0
    //   15252: aload_1
    //   15253: iconst_1
    //   15254: anewarray 334	java/lang/String
    //   15257: dup
    //   15258: iconst_0
    //   15259: aload 4
    //   15261: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15264: aastore
    //   15265: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15268: goto -15084 -> 184
    //   15271: astore_1
    //   15272: ldc 191
    //   15274: iconst_1
    //   15275: ldc_w 3634
    //   15278: aload_1
    //   15279: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15282: goto -15098 -> 184
    //   15285: aload_3
    //   15286: getfield 3623	bbwd:jdField_a_of_type_Int	I
    //   15289: iconst_4
    //   15290: if_icmpne +32 -> 15322
    //   15293: aload 4
    //   15295: ldc 170
    //   15297: iconst_0
    //   15298: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15301: pop
    //   15302: aload_0
    //   15303: aload_1
    //   15304: iconst_1
    //   15305: anewarray 334	java/lang/String
    //   15308: dup
    //   15309: iconst_0
    //   15310: aload 4
    //   15312: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15315: aastore
    //   15316: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15319: goto -15135 -> 184
    //   15322: new 3636	bbwb
    //   15325: dup
    //   15326: aload_0
    //   15327: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   15330: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   15333: aload_0
    //   15334: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   15337: invokevirtual 1019	bcdb:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   15340: aload_1
    //   15341: iload 6
    //   15343: aload_2
    //   15344: aload_3
    //   15345: getfield 3623	bbwd:jdField_a_of_type_Int	I
    //   15348: invokespecial 3639	bbwb:<init>	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Ljava/lang/String;ILjava/lang/String;I)V
    //   15351: invokevirtual 3640	bbwb:show	()V
    //   15354: goto -15170 -> 184
    //   15357: ldc_w 3642
    //   15360: aload 4
    //   15362: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15365: ifeq +93 -> 15458
    //   15368: new 109	org/json/JSONObject
    //   15371: dup
    //   15372: aload 5
    //   15374: iconst_0
    //   15375: aaload
    //   15376: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15379: astore_2
    //   15380: aload_2
    //   15381: ldc_w 1380
    //   15384: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15387: astore_1
    //   15388: aload_2
    //   15389: ldc_w 3184
    //   15392: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15395: astore_2
    //   15396: new 109	org/json/JSONObject
    //   15399: dup
    //   15400: invokespecial 168	org/json/JSONObject:<init>	()V
    //   15403: astore_3
    //   15404: aload_3
    //   15405: ldc 170
    //   15407: invokestatic 3643	bbwc:a	()I
    //   15410: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15413: pop
    //   15414: aload_3
    //   15415: ldc 156
    //   15417: aload_2
    //   15418: invokestatic 3644	bbwc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15421: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   15424: pop
    //   15425: aload_0
    //   15426: aload_1
    //   15427: iconst_1
    //   15428: anewarray 334	java/lang/String
    //   15431: dup
    //   15432: iconst_0
    //   15433: aload_3
    //   15434: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15437: aastore
    //   15438: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15441: goto -15257 -> 184
    //   15444: astore_1
    //   15445: ldc 191
    //   15447: iconst_1
    //   15448: ldc_w 3626
    //   15451: aload_1
    //   15452: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15455: goto -15271 -> 184
    //   15458: ldc_w 3646
    //   15461: aload 4
    //   15463: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15466: ifeq +128 -> 15594
    //   15469: new 109	org/json/JSONObject
    //   15472: dup
    //   15473: aload 5
    //   15475: iconst_0
    //   15476: aaload
    //   15477: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15480: astore_1
    //   15481: aload_1
    //   15482: ldc_w 3096
    //   15485: invokevirtual 2836	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   15488: istore 12
    //   15490: aload_1
    //   15491: ldc_w 3648
    //   15494: invokevirtual 1204	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   15497: astore_1
    //   15498: aload_1
    //   15499: ifnull -15315 -> 184
    //   15502: aload_1
    //   15503: ldc_w 1439
    //   15506: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15509: istore 6
    //   15511: aload_1
    //   15512: ldc_w 1441
    //   15515: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15518: istore 7
    //   15520: new 1443	android/graphics/Rect
    //   15523: dup
    //   15524: iload 6
    //   15526: iload 7
    //   15528: aload_1
    //   15529: ldc_w 1445
    //   15532: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15535: iload 6
    //   15537: iadd
    //   15538: aload_1
    //   15539: ldc_w 1447
    //   15542: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15545: iload 7
    //   15547: iadd
    //   15548: invokespecial 1449	android/graphics/Rect:<init>	(IIII)V
    //   15551: astore_1
    //   15552: aload_0
    //   15553: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   15556: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   15559: astore_2
    //   15560: aload_2
    //   15561: instanceof 1349
    //   15564: ifeq -15380 -> 184
    //   15567: aload_2
    //   15568: checkcast 1349	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity
    //   15571: aload_1
    //   15572: iload 12
    //   15574: invokevirtual 3651	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity:a	(Landroid/graphics/Rect;Z)V
    //   15577: goto -15393 -> 184
    //   15580: astore_1
    //   15581: ldc 191
    //   15583: iconst_1
    //   15584: ldc_w 3653
    //   15587: aload_1
    //   15588: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15591: goto -15407 -> 184
    //   15594: ldc_w 3655
    //   15597: aload 4
    //   15599: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15602: ifeq +56 -> 15658
    //   15605: new 109	org/json/JSONObject
    //   15608: dup
    //   15609: aload 5
    //   15611: iconst_0
    //   15612: aaload
    //   15613: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15616: astore_1
    //   15617: aload_1
    //   15618: ifnonnull +21 -> 15639
    //   15621: iconst_1
    //   15622: ireturn
    //   15623: astore_1
    //   15624: ldc 191
    //   15626: iconst_1
    //   15627: ldc_w 3657
    //   15630: aload_1
    //   15631: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15634: aconst_null
    //   15635: astore_1
    //   15636: goto -19 -> 15617
    //   15639: invokestatic 3663	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   15642: new 3665	com/tencent/mobileqq/jsp/UiApiPlugin$8
    //   15645: dup
    //   15646: aload_0
    //   15647: aload_1
    //   15648: invokespecial 3666	com/tencent/mobileqq/jsp/UiApiPlugin$8:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Lorg/json/JSONObject;)V
    //   15651: invokevirtual 3672	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   15654: pop
    //   15655: goto -15471 -> 184
    //   15658: ldc_w 3674
    //   15661: aload 4
    //   15663: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15666: ifeq +117 -> 15783
    //   15669: new 109	org/json/JSONObject
    //   15672: dup
    //   15673: aload 5
    //   15675: iconst_0
    //   15676: aaload
    //   15677: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15680: astore_1
    //   15681: aload_0
    //   15682: aload_1
    //   15683: ldc_w 1380
    //   15686: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15689: putfield 3676	com/tencent/mobileqq/jsp/UiApiPlugin:j	Ljava/lang/String;
    //   15692: aload_1
    //   15693: ldc_w 3364
    //   15696: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15699: astore_2
    //   15700: aload_1
    //   15701: ldc_w 3678
    //   15704: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15707: astore_3
    //   15708: aload_1
    //   15709: ldc_w 3680
    //   15712: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15715: astore 4
    //   15717: aload_1
    //   15718: ldc_w 3682
    //   15721: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15724: astore 5
    //   15726: aload_1
    //   15727: ldc_w 3684
    //   15730: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   15733: istore 6
    //   15735: aload_0
    //   15736: aload_0
    //   15737: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   15740: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   15743: iconst_3
    //   15744: aload_2
    //   15745: aload_3
    //   15746: sipush 3016
    //   15749: iload 6
    //   15751: aload 4
    //   15753: aload 5
    //   15755: aconst_null
    //   15756: aconst_null
    //   15757: aconst_null
    //   15758: invokestatic 3689	com/tencent/mobileqq/activity/AddFriendLogicActivity:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   15761: bipush 16
    //   15763: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   15766: goto -15582 -> 184
    //   15769: astore_1
    //   15770: ldc 191
    //   15772: iconst_1
    //   15773: ldc_w 3691
    //   15776: aload_1
    //   15777: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15780: goto -15596 -> 184
    //   15783: ldc_w 3693
    //   15786: aload 4
    //   15788: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15791: ifeq +178 -> 15969
    //   15794: new 109	org/json/JSONObject
    //   15797: dup
    //   15798: aload 5
    //   15800: iconst_0
    //   15801: aaload
    //   15802: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15805: astore_3
    //   15806: aload_3
    //   15807: ldc_w 3695
    //   15810: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15813: astore_1
    //   15814: aload_3
    //   15815: ldc_w 2112
    //   15818: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15821: astore_2
    //   15822: aload_3
    //   15823: ldc_w 2125
    //   15826: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15829: astore_3
    //   15830: aload_1
    //   15831: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15834: ifne +69 -> 15903
    //   15837: new 866	java/io/File
    //   15840: dup
    //   15841: aload_1
    //   15842: invokespecial 1644	java/io/File:<init>	(Ljava/lang/String;)V
    //   15845: astore_1
    //   15846: aload_1
    //   15847: invokevirtual 1998	java/io/File:exists	()Z
    //   15850: ifne +45 -> 15895
    //   15853: aload_0
    //   15854: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   15857: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   15860: invokevirtual 1959	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15863: iconst_1
    //   15864: ldc_w 3696
    //   15867: invokestatic 1964	ajyc:a	(I)Ljava/lang/String;
    //   15870: iconst_0
    //   15871: invokestatic 1967	bcpw:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lbcpw;
    //   15874: invokevirtual 1970	bcpw:a	()Landroid/widget/Toast;
    //   15877: pop
    //   15878: goto -15694 -> 184
    //   15881: astore_1
    //   15882: ldc 191
    //   15884: iconst_1
    //   15885: ldc_w 3698
    //   15888: aload_1
    //   15889: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15892: goto -15708 -> 184
    //   15895: aload_0
    //   15896: aload_1
    //   15897: invokevirtual 1646	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/io/File;)V
    //   15900: goto -15716 -> 184
    //   15903: aload_2
    //   15904: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15907: ifne +19 -> 15926
    //   15910: aload_0
    //   15911: aload_2
    //   15912: iconst_0
    //   15913: invokestatic 2121	bbca:decode	(Ljava/lang/String;I)[B
    //   15916: aload_2
    //   15917: invokestatic 2115	bdhv:d	(Ljava/lang/String;)Ljava/lang/String;
    //   15920: invokevirtual 3700	com/tencent/mobileqq/jsp/UiApiPlugin:a	([BLjava/lang/String;)V
    //   15923: goto -15739 -> 184
    //   15926: aload_3
    //   15927: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15930: ifne +11 -> 15941
    //   15933: aload_0
    //   15934: aload_3
    //   15935: invokevirtual 3702	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Ljava/lang/String;)V
    //   15938: goto -15754 -> 184
    //   15941: aload_0
    //   15942: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   15945: invokevirtual 1031	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   15948: invokevirtual 1959	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15951: iconst_1
    //   15952: ldc_w 3703
    //   15955: invokestatic 1964	ajyc:a	(I)Ljava/lang/String;
    //   15958: iconst_0
    //   15959: invokestatic 1967	bcpw:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lbcpw;
    //   15962: invokevirtual 1970	bcpw:a	()Landroid/widget/Toast;
    //   15965: pop
    //   15966: goto -15782 -> 184
    //   15969: ldc_w 3705
    //   15972: aload 4
    //   15974: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15977: ifeq +44 -> 16021
    //   15980: aload_0
    //   15981: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   15984: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   15987: iconst_m1
    //   15988: new 125	android/content/Intent
    //   15991: dup
    //   15992: invokespecial 227	android/content/Intent:<init>	()V
    //   15995: ldc_w 3707
    //   15998: aload 5
    //   16000: iconst_0
    //   16001: aaload
    //   16002: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   16005: invokevirtual 238	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   16008: aload_0
    //   16009: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   16012: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   16015: invokevirtual 241	android/app/Activity:finish	()V
    //   16018: goto -15834 -> 184
    //   16021: ldc_w 3709
    //   16024: aload 4
    //   16026: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16029: ifeq +13 -> 16042
    //   16032: aload_0
    //   16033: aload 5
    //   16035: iconst_0
    //   16036: aaload
    //   16037: invokevirtual 3711	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Ljava/lang/String;)V
    //   16040: iconst_1
    //   16041: ireturn
    //   16042: ldc_w 3713
    //   16045: aload 4
    //   16047: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16050: ifeq +102 -> 16152
    //   16053: aload 5
    //   16055: arraylength
    //   16056: iconst_1
    //   16057: if_icmpne +95 -> 16152
    //   16060: new 109	org/json/JSONObject
    //   16063: dup
    //   16064: aload 5
    //   16066: iconst_0
    //   16067: aaload
    //   16068: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16071: astore_1
    //   16072: aload_1
    //   16073: ldc_w 1380
    //   16076: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16079: astore_2
    //   16080: new 3715	baps
    //   16083: dup
    //   16084: aload_1
    //   16085: ldc_w 3717
    //   16088: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16091: aload_1
    //   16092: ldc_w 3719
    //   16095: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16098: aload_1
    //   16099: ldc_w 3721
    //   16102: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16105: aload_1
    //   16106: ldc_w 3723
    //   16109: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16112: aload_1
    //   16113: ldc_w 3725
    //   16116: invokevirtual 2323	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   16119: invokespecial 3728	baps:<init>	(IIIIJ)V
    //   16122: aload_0
    //   16123: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   16126: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   16129: new 3730	arox
    //   16132: dup
    //   16133: aload_0
    //   16134: aload_2
    //   16135: invokespecial 3731	arox:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   16138: invokevirtual 3734	baps:a	(Landroid/app/Activity;Lbapw;)V
    //   16141: goto -15957 -> 184
    //   16144: astore_1
    //   16145: aload_1
    //   16146: invokevirtual 2514	org/json/JSONException:printStackTrace	()V
    //   16149: goto -15965 -> 184
    //   16152: ldc_w 3736
    //   16155: aload 4
    //   16157: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16160: ifeq +102 -> 16262
    //   16163: new 109	org/json/JSONObject
    //   16166: dup
    //   16167: aload 5
    //   16169: iconst_0
    //   16170: aaload
    //   16171: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16174: ldc_w 1380
    //   16177: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16180: astore_1
    //   16181: new 109	org/json/JSONObject
    //   16184: dup
    //   16185: invokespecial 168	org/json/JSONObject:<init>	()V
    //   16188: astore_2
    //   16189: aload_0
    //   16190: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   16193: invokevirtual 690	bcdb:a	()Landroid/app/Activity;
    //   16196: astore_3
    //   16197: aload_3
    //   16198: ifnonnull +5 -> 16203
    //   16201: iconst_1
    //   16202: ireturn
    //   16203: aload_3
    //   16204: invokestatic 3739	bkur:a	(Landroid/app/Activity;)V
    //   16207: aload_2
    //   16208: ldc_w 3741
    //   16211: invokestatic 3742	bkur:b	()Z
    //   16214: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   16217: pop
    //   16218: aload_2
    //   16219: ldc_w 3744
    //   16222: getstatic 3745	bkur:jdField_a_of_type_Int	I
    //   16225: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   16228: pop
    //   16229: aload_0
    //   16230: aload_1
    //   16231: iconst_1
    //   16232: anewarray 334	java/lang/String
    //   16235: dup
    //   16236: iconst_0
    //   16237: aload_2
    //   16238: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   16241: aastore
    //   16242: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   16245: goto -16061 -> 184
    //   16248: astore_1
    //   16249: ldc 191
    //   16251: iconst_1
    //   16252: ldc_w 3747
    //   16255: aload_1
    //   16256: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16259: goto -16075 -> 184
    //   16262: ldc_w 3749
    //   16265: aload 4
    //   16267: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16270: ifeq +137 -> 16407
    //   16273: new 109	org/json/JSONObject
    //   16276: dup
    //   16277: aload 5
    //   16279: iconst_0
    //   16280: aaload
    //   16281: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16284: astore_2
    //   16285: aload_2
    //   16286: ldc_w 3751
    //   16289: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16292: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16295: astore_1
    //   16296: aload_2
    //   16297: ldc_w 1380
    //   16300: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16303: astore_2
    //   16304: aload_1
    //   16305: invokevirtual 2254	java/lang/Integer:intValue	()I
    //   16308: iconst_1
    //   16309: if_icmpne +77 -> 16386
    //   16312: iconst_1
    //   16313: invokestatic 3754	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	(Z)V
    //   16316: new 109	org/json/JSONObject
    //   16319: dup
    //   16320: invokespecial 168	org/json/JSONObject:<init>	()V
    //   16323: astore_1
    //   16324: aload_1
    //   16325: ldc 170
    //   16327: ldc_w 3139
    //   16330: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   16333: pop
    //   16334: invokestatic 3755	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	()Z
    //   16337: ifeq +64 -> 16401
    //   16340: iconst_1
    //   16341: istore 6
    //   16343: aload_1
    //   16344: ldc_w 3751
    //   16347: iload 6
    //   16349: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   16352: pop
    //   16353: aload_0
    //   16354: aload_2
    //   16355: iconst_1
    //   16356: anewarray 334	java/lang/String
    //   16359: dup
    //   16360: iconst_0
    //   16361: aload_1
    //   16362: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   16365: aastore
    //   16366: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   16369: goto -16185 -> 184
    //   16372: astore_1
    //   16373: ldc 191
    //   16375: iconst_1
    //   16376: ldc_w 3757
    //   16379: aload_1
    //   16380: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16383: goto -16199 -> 184
    //   16386: aload_1
    //   16387: invokevirtual 2254	java/lang/Integer:intValue	()I
    //   16390: iconst_2
    //   16391: if_icmpne -75 -> 16316
    //   16394: iconst_0
    //   16395: invokestatic 3754	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	(Z)V
    //   16398: goto -82 -> 16316
    //   16401: iconst_2
    //   16402: istore 6
    //   16404: goto -61 -> 16343
    //   16407: ldc_w 3759
    //   16410: aload 4
    //   16412: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16415: ifeq +166 -> 16581
    //   16418: new 109	org/json/JSONObject
    //   16421: dup
    //   16422: aload 5
    //   16424: iconst_0
    //   16425: aaload
    //   16426: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16429: astore 4
    //   16431: aload 4
    //   16433: ldc_w 3761
    //   16436: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16439: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16442: astore_1
    //   16443: aload 4
    //   16445: ldc_w 3763
    //   16448: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16451: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16454: astore_2
    //   16455: aload 4
    //   16457: ldc_w 3765
    //   16460: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16463: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16466: astore_3
    //   16467: aload 4
    //   16469: ldc_w 1380
    //   16472: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16475: astore 4
    //   16477: ldc 191
    //   16479: iconst_1
    //   16480: new 497	java/lang/StringBuilder
    //   16483: dup
    //   16484: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   16487: ldc_w 3767
    //   16490: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16493: aload_1
    //   16494: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16497: ldc_w 3769
    //   16500: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16503: aload_2
    //   16504: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16507: ldc_w 3771
    //   16510: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16513: aload_3
    //   16514: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16517: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16520: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16523: aload_0
    //   16524: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   16527: ifnonnull +17 -> 16544
    //   16530: aload_0
    //   16531: invokestatic 1679	wxu:a	()Lwxu;
    //   16534: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   16537: aload_0
    //   16538: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   16541: invokevirtual 1680	wxu:a	()V
    //   16544: aload_0
    //   16545: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   16548: aload_1
    //   16549: aload_2
    //   16550: aload_3
    //   16551: new 3773	arnw
    //   16554: dup
    //   16555: aload_0
    //   16556: aload 4
    //   16558: invokespecial 3774	arnw:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   16561: invokevirtual 3777	wxu:a	(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lwxw;)V
    //   16564: goto -16380 -> 184
    //   16567: astore_1
    //   16568: ldc 191
    //   16570: iconst_1
    //   16571: ldc_w 3779
    //   16574: aload_1
    //   16575: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16578: goto -16394 -> 184
    //   16581: ldc_w 3781
    //   16584: aload 4
    //   16586: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16589: ifeq +139 -> 16728
    //   16592: new 109	org/json/JSONObject
    //   16595: dup
    //   16596: aload 5
    //   16598: iconst_0
    //   16599: aaload
    //   16600: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16603: astore_3
    //   16604: aload_3
    //   16605: ldc_w 3783
    //   16608: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16611: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16614: astore_1
    //   16615: aload_3
    //   16616: ldc_w 3763
    //   16619: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16622: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16625: astore_2
    //   16626: aload_3
    //   16627: ldc_w 2366
    //   16630: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16633: astore_3
    //   16634: ldc 191
    //   16636: iconst_1
    //   16637: new 497	java/lang/StringBuilder
    //   16640: dup
    //   16641: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   16644: ldc_w 3785
    //   16647: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16650: aload_1
    //   16651: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16654: ldc_w 3787
    //   16657: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16660: aload_2
    //   16661: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16664: ldc_w 3789
    //   16667: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16670: aload_3
    //   16671: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16674: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16677: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16680: aload_0
    //   16681: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   16684: ifnonnull +17 -> 16701
    //   16687: aload_0
    //   16688: invokestatic 1679	wxu:a	()Lwxu;
    //   16691: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   16694: aload_0
    //   16695: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   16698: invokevirtual 1680	wxu:a	()V
    //   16701: aload_0
    //   16702: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   16705: aload_1
    //   16706: aload_2
    //   16707: aload_3
    //   16708: invokevirtual 3792	wxu:a	(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V
    //   16711: goto -16527 -> 184
    //   16714: astore_1
    //   16715: ldc 191
    //   16717: iconst_1
    //   16718: ldc_w 3794
    //   16721: aload_1
    //   16722: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16725: goto -16541 -> 184
    //   16728: ldc_w 3796
    //   16731: aload 4
    //   16733: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16736: ifeq +139 -> 16875
    //   16739: new 109	org/json/JSONObject
    //   16742: dup
    //   16743: aload 5
    //   16745: iconst_0
    //   16746: aaload
    //   16747: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16750: astore_3
    //   16751: aload_3
    //   16752: ldc_w 3783
    //   16755: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16758: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16761: astore_1
    //   16762: aload_3
    //   16763: ldc_w 2366
    //   16766: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16769: astore_2
    //   16770: aload_3
    //   16771: ldc_w 3763
    //   16774: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16777: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16780: astore_3
    //   16781: ldc 191
    //   16783: iconst_1
    //   16784: new 497	java/lang/StringBuilder
    //   16787: dup
    //   16788: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   16791: ldc_w 3798
    //   16794: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16797: aload_1
    //   16798: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16801: ldc_w 3789
    //   16804: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16807: aload_2
    //   16808: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16811: ldc_w 3787
    //   16814: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16817: aload_3
    //   16818: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16821: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16824: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16827: aload_0
    //   16828: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   16831: ifnonnull +17 -> 16848
    //   16834: aload_0
    //   16835: invokestatic 1679	wxu:a	()Lwxu;
    //   16838: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   16841: aload_0
    //   16842: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   16845: invokevirtual 1680	wxu:a	()V
    //   16848: aload_0
    //   16849: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   16852: aload_1
    //   16853: aload_2
    //   16854: aload_3
    //   16855: invokevirtual 3801	wxu:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V
    //   16858: goto -16674 -> 184
    //   16861: astore_1
    //   16862: ldc 191
    //   16864: iconst_1
    //   16865: ldc_w 3803
    //   16868: aload_1
    //   16869: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16872: goto -16688 -> 184
    //   16875: ldc_w 3805
    //   16878: aload 4
    //   16880: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16883: ifeq +252 -> 17135
    //   16886: new 109	org/json/JSONObject
    //   16889: dup
    //   16890: aload 5
    //   16892: iconst_0
    //   16893: aaload
    //   16894: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16897: astore 4
    //   16899: aload 4
    //   16901: ldc_w 3807
    //   16904: iconst_1
    //   16905: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   16908: ifne +41 -> 16949
    //   16911: aload 4
    //   16913: aload 4
    //   16915: ldc_w 1380
    //   16918: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16921: new 3809	arnx
    //   16924: dup
    //   16925: aload_0
    //   16926: invokespecial 3810	arnx:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   16929: invokestatic 3815	sfn:a	(Lorg/json/JSONObject;Ljava/lang/String;Lryg;)V
    //   16932: goto -16748 -> 184
    //   16935: astore_1
    //   16936: ldc 191
    //   16938: iconst_1
    //   16939: ldc_w 3817
    //   16942: aload_1
    //   16943: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16946: goto -16762 -> 184
    //   16949: aload 4
    //   16951: ldc_w 970
    //   16954: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16957: pop
    //   16958: aload 4
    //   16960: ldc_w 972
    //   16963: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16966: pop
    //   16967: aload 4
    //   16969: ldc_w 974
    //   16972: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   16975: pop
    //   16976: aload 4
    //   16978: ldc_w 980
    //   16981: invokevirtual 984	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   16984: pop2
    //   16985: aload 4
    //   16987: ldc_w 992
    //   16990: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16993: astore_1
    //   16994: aload 4
    //   16996: ldc_w 994
    //   16999: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17002: astore_2
    //   17003: aload 4
    //   17005: ldc_w 996
    //   17008: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17011: astore_3
    //   17012: aload 4
    //   17014: ldc_w 998
    //   17017: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17020: astore 4
    //   17022: new 2056	java/util/HashMap
    //   17025: dup
    //   17026: invokespecial 3303	java/util/HashMap:<init>	()V
    //   17029: astore 14
    //   17031: aload 14
    //   17033: ldc_w 992
    //   17036: aload_1
    //   17037: invokeinterface 3818 3 0
    //   17042: pop
    //   17043: aload 14
    //   17045: ldc_w 994
    //   17048: aload_2
    //   17049: invokeinterface 3818 3 0
    //   17054: pop
    //   17055: aload 14
    //   17057: ldc_w 996
    //   17060: aload_3
    //   17061: invokeinterface 3818 3 0
    //   17066: pop
    //   17067: aload 14
    //   17069: ldc_w 998
    //   17072: aload 4
    //   17074: invokeinterface 3818 3 0
    //   17079: pop
    //   17080: aload_0
    //   17081: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   17084: ifnonnull +17 -> 17101
    //   17087: aload_0
    //   17088: invokestatic 1679	wxu:a	()Lwxu;
    //   17091: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   17094: aload_0
    //   17095: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   17098: invokevirtual 1680	wxu:a	()V
    //   17101: new 3820	arny
    //   17104: dup
    //   17105: aload_0
    //   17106: aload 14
    //   17108: invokespecial 3823	arny:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/util/Map;)V
    //   17111: astore_1
    //   17112: aload_0
    //   17113: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wxu	Lwxu;
    //   17116: aload_1
    //   17117: invokevirtual 3826	wxu:a	(Lwxw;)I
    //   17120: istore 6
    //   17122: aload_0
    //   17123: aload 5
    //   17125: iconst_0
    //   17126: aaload
    //   17127: iload 6
    //   17129: invokevirtual 3827	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;I)V
    //   17132: goto -16948 -> 184
    //   17135: ldc_w 3829
    //   17138: aload 4
    //   17140: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17143: ifeq -16959 -> 184
    //   17146: new 109	org/json/JSONObject
    //   17149: dup
    //   17150: aload 5
    //   17152: iconst_0
    //   17153: aaload
    //   17154: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17157: astore_1
    //   17158: aload_1
    //   17159: ldc_w 1069
    //   17162: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17165: astore_2
    //   17166: aload_0
    //   17167: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbcdb;
    //   17170: invokevirtual 1512	bcdb:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   17173: astore_3
    //   17174: aload_1
    //   17175: ldc_w 3831
    //   17178: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   17181: istore 6
    //   17183: aload_1
    //   17184: ldc_w 909
    //   17187: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17190: astore 4
    //   17192: aload_1
    //   17193: ldc_w 1091
    //   17196: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17199: astore 5
    //   17201: aload_1
    //   17202: ldc_w 3833
    //   17205: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   17208: istore 7
    //   17210: ldc_w 3012
    //   17213: aload_2
    //   17214: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17217: ifeq +104 -> 17321
    //   17220: aload_3
    //   17221: aload 4
    //   17223: putfield 3834	com/tencent/mobileqq/webview/swift/WebViewFragment:r	Ljava/lang/String;
    //   17226: aload_3
    //   17227: iload 6
    //   17229: putfield 3837	com/tencent/mobileqq/webview/swift/WebViewFragment:n	I
    //   17232: aload_3
    //   17233: iload 7
    //   17235: putfield 3840	com/tencent/mobileqq/webview/swift/WebViewFragment:o	I
    //   17238: aload_3
    //   17239: aload 5
    //   17241: putfield 3841	com/tencent/mobileqq/webview/swift/WebViewFragment:s	Ljava/lang/String;
    //   17244: iload 7
    //   17246: iconst_1
    //   17247: if_icmpne +62 -> 17309
    //   17250: aload_0
    //   17251: iload 6
    //   17253: invokevirtual 3843	com/tencent/mobileqq/jsp/UiApiPlugin:b	(I)V
    //   17256: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17259: ifeq -17075 -> 184
    //   17262: ldc 191
    //   17264: iconst_2
    //   17265: new 497	java/lang/StringBuilder
    //   17268: dup
    //   17269: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   17272: ldc_w 3845
    //   17275: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17278: aload_1
    //   17279: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   17282: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17285: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17288: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17291: goto -17107 -> 184
    //   17294: astore_1
    //   17295: ldc 191
    //   17297: iconst_1
    //   17298: aload_1
    //   17299: iconst_0
    //   17300: anewarray 843	java/lang/Object
    //   17303: invokestatic 1080	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   17306: goto -17122 -> 184
    //   17309: aload_3
    //   17310: invokevirtual 3847	com/tencent/mobileqq/webview/swift/WebViewFragment:q	()V
    //   17313: aload_3
    //   17314: iconst_1
    //   17315: invokevirtual 3848	com/tencent/mobileqq/webview/swift/WebViewFragment:e	(Z)V
    //   17318: goto -62 -> 17256
    //   17321: ldc_w 3850
    //   17324: aload_2
    //   17325: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17328: ifeq +11 -> 17339
    //   17331: aload_3
    //   17332: iconst_0
    //   17333: invokevirtual 3848	com/tencent/mobileqq/webview/swift/WebViewFragment:e	(Z)V
    //   17336: goto -80 -> 17256
    //   17339: ldc_w 3751
    //   17342: aload_2
    //   17343: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17346: ifeq +27 -> 17373
    //   17349: aload_3
    //   17350: aload 4
    //   17352: putfield 3834	com/tencent/mobileqq/webview/swift/WebViewFragment:r	Ljava/lang/String;
    //   17355: aload_0
    //   17356: getfield 1793	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser	Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUser;
    //   17359: ifnull -103 -> 17256
    //   17362: aload_0
    //   17363: getfield 1793	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser	Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUser;
    //   17366: aconst_null
    //   17367: invokevirtual 3853	com/tencent/mobileqq/activity/miniaio/MiniMsgUser:onClick	(Landroid/view/View;)V
    //   17370: goto -114 -> 17256
    //   17373: ldc_w 3855
    //   17376: aload_2
    //   17377: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17380: ifeq -124 -> 17256
    //   17383: invokestatic 3860	com/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient:getInstance	()Lcom/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient;
    //   17386: iload 6
    //   17388: invokevirtual 3863	com/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient:clearBusiness	(I)V
    //   17391: goto -135 -> 17256
    //   17394: iconst_0
    //   17395: ireturn
    //   17396: astore_2
    //   17397: goto -6439 -> 10958
    //   17400: astore 15
    //   17402: goto -13496 -> 3906
    //   17405: aload_1
    //   17406: astore_2
    //   17407: ldc_w 371
    //   17410: astore_1
    //   17411: goto -4014 -> 13397
    //   17414: aconst_null
    //   17415: astore_1
    //   17416: aload_3
    //   17417: astore_2
    //   17418: goto -6164 -> 11254
    //   17421: goto -7603 -> 9818
    //   17424: aconst_null
    //   17425: astore_1
    //   17426: goto -9969 -> 7457
    //   17429: aconst_null
    //   17430: astore_1
    //   17431: goto -10211 -> 7220
    //   17434: iconst_0
    //   17435: istore 6
    //   17437: goto -10262 -> 7175
    //   17440: aconst_null
    //   17441: astore_1
    //   17442: goto -10435 -> 7007
    //   17445: aload_2
    //   17446: astore_1
    //   17447: goto -14141 -> 3306
    //   17450: goto -14174 -> 3276
    //   17453: goto -17269 -> 184
    //   17456: iload 7
    //   17458: istore 6
    //   17460: goto -16880 -> 580
    //   17463: astore_1
    //   17464: goto -17280 -> 184
    //   17467: iconst_1
    //   17468: ireturn
    //   17469: iconst_1
    //   17470: ireturn
    //   17471: iconst_1
    //   17472: ireturn
    //   17473: iconst_1
    //   17474: ireturn
    //   17475: iconst_1
    //   17476: ireturn
    //   17477: astore_1
    //   17478: goto -17294 -> 184
    //   17481: iconst_1
    //   17482: ireturn
    //   17483: iload 6
    //   17485: tableswitch	default:+19 -> 17504, 1001:+-13081->4404
    //   17505: <illegal opcode>
    //   17506: <illegal opcode>
    //   17507: iload 6
    //   17509: tableswitch	default:+19 -> 17528, 1001:+-12895->4614
    //   17529: newarray 慢⁤污潬慣楴湯
    //   17531: iconst_0
    //   17532: istore 12
    //   17534: goto -12535 -> 4999
    //   17537: iconst_0
    //   17538: istore 12
    //   17540: goto -12154 -> 5386
    //   17543: iload 6
    //   17545: ldc_w 1611
    //   17548: ior
    //   17549: istore 6
    //   17551: goto -11085 -> 6466
    //   17554: iload 6
    //   17556: iconst_1
    //   17557: iadd
    //   17558: istore 6
    //   17560: goto -10645 -> 6915
    //   17563: iload 6
    //   17565: iconst_1
    //   17566: iadd
    //   17567: istore 6
    //   17569: goto -6128 -> 11441
    //   17572: iconst_1
    //   17573: ireturn
    //   17574: iconst_1
    //   17575: ireturn
    //   17576: iconst_1
    //   17577: ireturn
    //   17578: iconst_1
    //   17579: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	17580	0	this	UiApiPlugin
    //   0	17580	1	paramJsBridgeListener	JsBridgeListener
    //   0	17580	2	paramString1	String
    //   0	17580	3	paramString2	String
    //   0	17580	4	paramString3	String
    //   0	17580	5	paramVarArgs	String[]
    //   268	17300	6	n	int
    //   530	16927	7	i1	int
    //   520	13972	8	i2	int
    //   5097	205	9	i3	int
    //   259	7773	10	l1	long
    //   1645	15894	12	bool1	boolean
    //   3138	11356	13	bool2	boolean
    //   884	16223	14	localObject1	Object
    //   3118	9825	15	localObject2	Object
    //   17400	1	15	localJSONException	JSONException
    //   11188	53	16	str	String
    // Exception table:
    //   from	to	target	type
    //   33	91	186	org/json/JSONException
    //   96	176	186	org/json/JSONException
    //   176	184	186	org/json/JSONException
    //   240	355	358	org/json/JSONException
    //   445	456	605	org/json/JSONException
    //   462	512	605	org/json/JSONException
    //   512	529	605	org/json/JSONException
    //   580	602	605	org/json/JSONException
    //   666	697	605	org/json/JSONException
    //   711	736	797	org/json/JSONException
    //   738	794	797	org/json/JSONException
    //   828	857	1006	org/json/JSONException
    //   859	958	1006	org/json/JSONException
    //   964	972	1006	org/json/JSONException
    //   976	988	1006	org/json/JSONException
    //   988	1003	1006	org/json/JSONException
    //   1032	1053	1006	org/json/JSONException
    //   1067	1107	1110	org/json/JSONException
    //   1142	1149	1157	java/lang/Exception
    //   1142	1149	1166	finally
    //   1331	1348	1351	org/json/JSONException
    //   1389	1397	1478	org/json/JSONException
    //   1401	1408	1478	org/json/JSONException
    //   1411	1475	1478	org/json/JSONException
    //   1516	1524	1557	org/json/JSONException
    //   1528	1535	1557	org/json/JSONException
    //   1538	1554	1557	org/json/JSONException
    //   1595	1603	1674	org/json/JSONException
    //   1607	1614	1674	org/json/JSONException
    //   1617	1671	1674	org/json/JSONException
    //   1712	1720	1752	org/json/JSONException
    //   1724	1731	1752	org/json/JSONException
    //   1734	1749	1752	org/json/JSONException
    //   1790	1798	1830	java/lang/Exception
    //   1802	1809	1830	java/lang/Exception
    //   1812	1827	1830	java/lang/Exception
    //   2092	2153	2243	org/json/JSONException
    //   2155	2226	2243	org/json/JSONException
    //   2228	2240	2243	org/json/JSONException
    //   2276	2322	2243	org/json/JSONException
    //   2343	2376	2427	org/json/JSONException
    //   2380	2400	2427	org/json/JSONException
    //   2400	2416	2427	org/json/JSONException
    //   2420	2424	2427	org/json/JSONException
    //   2453	2474	2477	org/json/JSONException
    //   2503	2536	2563	org/json/JSONException
    //   2540	2560	2563	org/json/JSONException
    //   2589	2622	2682	org/json/JSONException
    //   2626	2646	2682	org/json/JSONException
    //   2708	2741	2801	org/json/JSONException
    //   2745	2765	2801	org/json/JSONException
    //   2827	2860	2920	org/json/JSONException
    //   2864	2884	2920	org/json/JSONException
    //   2946	2979	3039	org/json/JSONException
    //   2983	3003	3039	org/json/JSONException
    //   3336	3341	3344	java/lang/Exception
    //   3065	3086	3348	org/json/JSONException
    //   3091	3099	3348	org/json/JSONException
    //   3102	3244	3348	org/json/JSONException
    //   3244	3255	3348	org/json/JSONException
    //   3260	3276	3348	org/json/JSONException
    //   3276	3285	3348	org/json/JSONException
    //   3290	3306	3348	org/json/JSONException
    //   3306	3315	3348	org/json/JSONException
    //   3315	3336	3348	org/json/JSONException
    //   3336	3341	3348	org/json/JSONException
    //   3374	3472	3475	org/json/JSONException
    //   3490	3497	3475	org/json/JSONException
    //   3515	3580	3475	org/json/JSONException
    //   3583	3590	3475	org/json/JSONException
    //   3593	3619	3475	org/json/JSONException
    //   3623	3663	3475	org/json/JSONException
    //   3666	3701	3475	org/json/JSONException
    //   3705	3760	3475	org/json/JSONException
    //   3374	3472	3500	java/lang/Exception
    //   3490	3497	3500	java/lang/Exception
    //   3515	3580	3500	java/lang/Exception
    //   3583	3590	3500	java/lang/Exception
    //   3593	3619	3500	java/lang/Exception
    //   3623	3663	3500	java/lang/Exception
    //   3666	3701	3500	java/lang/Exception
    //   3705	3760	3500	java/lang/Exception
    //   3804	3869	3975	java/lang/Exception
    //   3869	3879	3975	java/lang/Exception
    //   3879	3888	3975	java/lang/Exception
    //   3893	3906	3975	java/lang/Exception
    //   3906	3972	3975	java/lang/Exception
    //   4037	4045	3975	java/lang/Exception
    //   4048	4075	3975	java/lang/Exception
    //   4078	4140	3975	java/lang/Exception
    //   4140	4159	3975	java/lang/Exception
    //   4225	4308	3975	java/lang/Exception
    //   4311	4350	3975	java/lang/Exception
    //   4353	4369	3975	java/lang/Exception
    //   4417	4521	3975	java/lang/Exception
    //   4524	4589	3975	java/lang/Exception
    //   3788	3800	4030	org/json/JSONException
    //   3869	3879	4036	org/json/JSONException
    //   4159	4173	4221	java/lang/Exception
    //   4176	4211	4221	java/lang/Exception
    //   4211	4218	4221	java/lang/Exception
    //   4372	4401	4221	java/lang/Exception
    //   4404	4414	4221	java/lang/Exception
    //   4589	4611	4221	java/lang/Exception
    //   4614	4624	4221	java/lang/Exception
    //   4663	4692	5969	org/json/JSONException
    //   4694	4702	5969	org/json/JSONException
    //   4708	4756	5969	org/json/JSONException
    //   4760	4782	5969	org/json/JSONException
    //   4782	4818	5969	org/json/JSONException
    //   4818	4837	5969	org/json/JSONException
    //   4842	4884	5969	org/json/JSONException
    //   4888	4896	5969	org/json/JSONException
    //   4896	4940	5969	org/json/JSONException
    //   4955	4975	5969	org/json/JSONException
    //   4975	4996	5969	org/json/JSONException
    //   4999	5005	5969	org/json/JSONException
    //   5005	5141	5969	org/json/JSONException
    //   5141	5193	5969	org/json/JSONException
    //   5193	5229	5969	org/json/JSONException
    //   5236	5253	5969	org/json/JSONException
    //   5259	5308	5969	org/json/JSONException
    //   5312	5316	5969	org/json/JSONException
    //   5316	5338	5969	org/json/JSONException
    //   5338	5343	5969	org/json/JSONException
    //   5343	5362	5969	org/json/JSONException
    //   5371	5377	5969	org/json/JSONException
    //   5386	5420	5969	org/json/JSONException
    //   5420	5444	5969	org/json/JSONException
    //   5444	5462	5969	org/json/JSONException
    //   5462	5481	5969	org/json/JSONException
    //   5487	5491	5969	org/json/JSONException
    //   5491	5512	5969	org/json/JSONException
    //   5512	5544	5969	org/json/JSONException
    //   5544	5573	5969	org/json/JSONException
    //   5573	5592	5969	org/json/JSONException
    //   5597	5621	5969	org/json/JSONException
    //   5621	5629	5969	org/json/JSONException
    //   5629	5648	5969	org/json/JSONException
    //   5657	5676	5969	org/json/JSONException
    //   5676	5680	5969	org/json/JSONException
    //   5680	5699	5969	org/json/JSONException
    //   5709	5713	5969	org/json/JSONException
    //   5713	5738	5969	org/json/JSONException
    //   5738	5766	5969	org/json/JSONException
    //   5771	5792	5969	org/json/JSONException
    //   5803	5808	5969	org/json/JSONException
    //   5808	5828	5969	org/json/JSONException
    //   5832	5838	5969	org/json/JSONException
    //   5838	5858	5969	org/json/JSONException
    //   5862	5883	5969	org/json/JSONException
    //   5883	5893	5969	org/json/JSONException
    //   5897	5930	5969	org/json/JSONException
    //   5930	5966	5969	org/json/JSONException
    //   6005	6017	5969	org/json/JSONException
    //   6056	6069	5969	org/json/JSONException
    //   6072	6082	5969	org/json/JSONException
    //   6087	6093	5969	org/json/JSONException
    //   6096	6113	5969	org/json/JSONException
    //   6113	6121	5969	org/json/JSONException
    //   6124	6169	5969	org/json/JSONException
    //   6172	6178	5969	org/json/JSONException
    //   6183	6205	5969	org/json/JSONException
    //   6212	6276	5969	org/json/JSONException
    //   6276	6283	5969	org/json/JSONException
    //   6287	6297	5969	org/json/JSONException
    //   6297	6325	5969	org/json/JSONException
    //   6325	6376	5969	org/json/JSONException
    //   6379	6387	5969	org/json/JSONException
    //   6390	6420	5969	org/json/JSONException
    //   6423	6452	5969	org/json/JSONException
    //   6466	6478	5969	org/json/JSONException
    //   6481	6493	5969	org/json/JSONException
    //   6502	6521	5969	org/json/JSONException
    //   6529	6534	5969	org/json/JSONException
    //   6537	6559	5969	org/json/JSONException
    //   6559	6592	5969	org/json/JSONException
    //   4663	4692	6020	java/lang/Exception
    //   4694	4702	6020	java/lang/Exception
    //   4708	4756	6020	java/lang/Exception
    //   4760	4782	6020	java/lang/Exception
    //   4782	4818	6020	java/lang/Exception
    //   4818	4837	6020	java/lang/Exception
    //   4842	4884	6020	java/lang/Exception
    //   4888	4896	6020	java/lang/Exception
    //   4896	4940	6020	java/lang/Exception
    //   4955	4975	6020	java/lang/Exception
    //   4975	4996	6020	java/lang/Exception
    //   4999	5005	6020	java/lang/Exception
    //   5005	5141	6020	java/lang/Exception
    //   5141	5193	6020	java/lang/Exception
    //   5193	5229	6020	java/lang/Exception
    //   5236	5253	6020	java/lang/Exception
    //   5259	5308	6020	java/lang/Exception
    //   5312	5316	6020	java/lang/Exception
    //   5316	5338	6020	java/lang/Exception
    //   5338	5343	6020	java/lang/Exception
    //   5343	5362	6020	java/lang/Exception
    //   5371	5377	6020	java/lang/Exception
    //   5386	5420	6020	java/lang/Exception
    //   5420	5444	6020	java/lang/Exception
    //   5444	5462	6020	java/lang/Exception
    //   5462	5481	6020	java/lang/Exception
    //   5487	5491	6020	java/lang/Exception
    //   5491	5512	6020	java/lang/Exception
    //   5512	5544	6020	java/lang/Exception
    //   5544	5573	6020	java/lang/Exception
    //   5573	5592	6020	java/lang/Exception
    //   5597	5621	6020	java/lang/Exception
    //   5621	5629	6020	java/lang/Exception
    //   5629	5648	6020	java/lang/Exception
    //   5657	5676	6020	java/lang/Exception
    //   5676	5680	6020	java/lang/Exception
    //   5680	5699	6020	java/lang/Exception
    //   5709	5713	6020	java/lang/Exception
    //   5713	5738	6020	java/lang/Exception
    //   5738	5766	6020	java/lang/Exception
    //   5771	5792	6020	java/lang/Exception
    //   5803	5808	6020	java/lang/Exception
    //   5808	5828	6020	java/lang/Exception
    //   5832	5838	6020	java/lang/Exception
    //   5838	5858	6020	java/lang/Exception
    //   5862	5883	6020	java/lang/Exception
    //   5883	5893	6020	java/lang/Exception
    //   5897	5930	6020	java/lang/Exception
    //   5930	5966	6020	java/lang/Exception
    //   6005	6017	6020	java/lang/Exception
    //   6056	6069	6020	java/lang/Exception
    //   6072	6082	6020	java/lang/Exception
    //   6087	6093	6020	java/lang/Exception
    //   6096	6113	6020	java/lang/Exception
    //   6113	6121	6020	java/lang/Exception
    //   6124	6169	6020	java/lang/Exception
    //   6172	6178	6020	java/lang/Exception
    //   6183	6205	6020	java/lang/Exception
    //   6212	6276	6020	java/lang/Exception
    //   6276	6283	6020	java/lang/Exception
    //   6287	6297	6020	java/lang/Exception
    //   6297	6325	6020	java/lang/Exception
    //   6325	6376	6020	java/lang/Exception
    //   6379	6387	6020	java/lang/Exception
    //   6390	6420	6020	java/lang/Exception
    //   6423	6452	6020	java/lang/Exception
    //   6466	6478	6020	java/lang/Exception
    //   6481	6493	6020	java/lang/Exception
    //   6502	6521	6020	java/lang/Exception
    //   6529	6534	6020	java/lang/Exception
    //   6537	6559	6020	java/lang/Exception
    //   6559	6592	6020	java/lang/Exception
    //   6613	6638	7051	org/json/JSONException
    //   6640	6673	7051	org/json/JSONException
    //   6673	6694	7051	org/json/JSONException
    //   6694	6729	7051	org/json/JSONException
    //   6739	6780	7051	org/json/JSONException
    //   6780	6804	7051	org/json/JSONException
    //   6804	6828	7051	org/json/JSONException
    //   6828	6856	7051	org/json/JSONException
    //   6856	6868	7051	org/json/JSONException
    //   6877	6912	7051	org/json/JSONException
    //   6922	6959	7051	org/json/JSONException
    //   6962	6970	7051	org/json/JSONException
    //   6974	6979	7051	org/json/JSONException
    //   6983	6991	7051	org/json/JSONException
    //   6995	7007	7051	org/json/JSONException
    //   7011	7028	7051	org/json/JSONException
    //   7032	7048	7051	org/json/JSONException
    //   7105	7130	7235	org/json/JSONException
    //   7132	7175	7235	org/json/JSONException
    //   7175	7183	7235	org/json/JSONException
    //   7187	7192	7235	org/json/JSONException
    //   7196	7204	7235	org/json/JSONException
    //   7208	7220	7235	org/json/JSONException
    //   7224	7232	7235	org/json/JSONException
    //   7289	7314	7469	org/json/JSONException
    //   7316	7345	7469	org/json/JSONException
    //   7345	7366	7469	org/json/JSONException
    //   7366	7387	7469	org/json/JSONException
    //   7387	7412	7469	org/json/JSONException
    //   7412	7420	7469	org/json/JSONException
    //   7424	7429	7469	org/json/JSONException
    //   7433	7441	7469	org/json/JSONException
    //   7445	7457	7469	org/json/JSONException
    //   7461	7466	7469	org/json/JSONException
    //   7523	7549	7587	org/json/JSONException
    //   7549	7564	7587	org/json/JSONException
    //   7568	7584	7587	org/json/JSONException
    //   7641	7734	7790	org/json/JSONException
    //   7734	7787	7790	org/json/JSONException
    //   7844	7907	8056	org/json/JSONException
    //   7911	7918	8056	org/json/JSONException
    //   7918	7933	8056	org/json/JSONException
    //   7935	7976	8056	org/json/JSONException
    //   7978	7986	8056	org/json/JSONException
    //   7990	8053	8056	org/json/JSONException
    //   8110	8176	8310	org/json/JSONException
    //   8180	8187	8310	org/json/JSONException
    //   8187	8202	8310	org/json/JSONException
    //   8204	8212	8310	org/json/JSONException
    //   8221	8290	8310	org/json/JSONException
    //   8290	8307	8310	org/json/JSONException
    //   8346	8366	8310	org/json/JSONException
    //   8387	8432	8467	org/json/JSONException
    //   8438	8445	8467	org/json/JSONException
    //   8447	8464	8467	org/json/JSONException
    //   8534	8540	8825	org/json/JSONException
    //   8545	8574	8825	org/json/JSONException
    //   8579	8592	8825	org/json/JSONException
    //   8597	8607	8825	org/json/JSONException
    //   8612	8622	8825	org/json/JSONException
    //   8627	8636	8825	org/json/JSONException
    //   8644	8652	8825	org/json/JSONException
    //   8656	8665	8825	org/json/JSONException
    //   8674	8682	8825	org/json/JSONException
    //   8686	8697	8825	org/json/JSONException
    //   8701	8717	8825	org/json/JSONException
    //   8773	8784	8825	org/json/JSONException
    //   8788	8797	8825	org/json/JSONException
    //   8801	8811	8825	org/json/JSONException
    //   8815	8822	8825	org/json/JSONException
    //   8890	8899	8825	org/json/JSONException
    //   8534	8540	8906	finally
    //   8545	8574	8906	finally
    //   8579	8592	8906	finally
    //   8597	8607	8906	finally
    //   8612	8622	8906	finally
    //   8627	8636	8906	finally
    //   8644	8652	8906	finally
    //   8656	8665	8906	finally
    //   8674	8682	8906	finally
    //   8686	8697	8906	finally
    //   8701	8717	8906	finally
    //   8773	8784	8906	finally
    //   8788	8797	8906	finally
    //   8801	8811	8906	finally
    //   8815	8822	8906	finally
    //   8828	8838	8906	finally
    //   8890	8899	8906	finally
    //   8972	9003	9083	org/json/JSONException
    //   9006	9037	9083	org/json/JSONException
    //   9037	9047	9083	org/json/JSONException
    //   9050	9059	9083	org/json/JSONException
    //   9064	9074	9083	org/json/JSONException
    //   9074	9080	9083	org/json/JSONException
    //   9119	9123	9083	org/json/JSONException
    //   9126	9164	9083	org/json/JSONException
    //   9169	9193	9083	org/json/JSONException
    //   9193	9207	9083	org/json/JSONException
    //   9210	9234	9083	org/json/JSONException
    //   9255	9362	9365	org/json/JSONException
    //   9255	9362	9401	java/lang/Exception
    //   9476	9488	9661	java/lang/Exception
    //   9490	9498	9661	java/lang/Exception
    //   9500	9512	9661	java/lang/Exception
    //   9514	9523	9661	java/lang/Exception
    //   9525	9534	9661	java/lang/Exception
    //   9539	9549	9661	java/lang/Exception
    //   9551	9560	9661	java/lang/Exception
    //   9562	9570	9661	java/lang/Exception
    //   9572	9581	9661	java/lang/Exception
    //   9588	9597	9661	java/lang/Exception
    //   9599	9608	9661	java/lang/Exception
    //   9610	9620	9661	java/lang/Exception
    //   9622	9631	9661	java/lang/Exception
    //   9633	9649	9661	java/lang/Exception
    //   9651	9658	9661	java/lang/Exception
    //   9737	9750	10087	java/lang/Exception
    //   9752	9761	10087	java/lang/Exception
    //   9763	9775	10087	java/lang/Exception
    //   9777	9787	10087	java/lang/Exception
    //   9789	9799	10087	java/lang/Exception
    //   9804	9812	10087	java/lang/Exception
    //   9820	9830	10087	java/lang/Exception
    //   9832	9842	10087	java/lang/Exception
    //   9844	9854	10087	java/lang/Exception
    //   9856	9862	10087	java/lang/Exception
    //   9864	9894	10087	java/lang/Exception
    //   9896	9903	10087	java/lang/Exception
    //   9905	9914	10087	java/lang/Exception
    //   9916	9926	10087	java/lang/Exception
    //   9928	9937	10087	java/lang/Exception
    //   9939	9949	10087	java/lang/Exception
    //   9951	9962	10087	java/lang/Exception
    //   9964	9974	10087	java/lang/Exception
    //   9976	9984	10087	java/lang/Exception
    //   9986	9996	10087	java/lang/Exception
    //   9998	10006	10087	java/lang/Exception
    //   10008	10018	10087	java/lang/Exception
    //   10020	10037	10087	java/lang/Exception
    //   10039	10046	10087	java/lang/Exception
    //   10121	10133	10224	java/lang/Exception
    //   10135	10143	10224	java/lang/Exception
    //   10145	10155	10224	java/lang/Exception
    //   10157	10166	10224	java/lang/Exception
    //   10168	10183	10224	java/lang/Exception
    //   10189	10196	10224	java/lang/Exception
    //   10198	10203	10224	java/lang/Exception
    //   10213	10221	10224	java/lang/Exception
    //   10269	10278	10224	java/lang/Exception
    //   10292	10301	10224	java/lang/Exception
    //   10325	10337	10428	java/lang/Exception
    //   10339	10347	10428	java/lang/Exception
    //   10349	10359	10428	java/lang/Exception
    //   10361	10370	10428	java/lang/Exception
    //   10372	10387	10428	java/lang/Exception
    //   10393	10400	10428	java/lang/Exception
    //   10402	10407	10428	java/lang/Exception
    //   10417	10425	10428	java/lang/Exception
    //   10473	10482	10428	java/lang/Exception
    //   10496	10505	10428	java/lang/Exception
    //   10525	10554	10557	org/json/JSONException
    //   10607	10657	10719	org/json/JSONException
    //   10660	10682	10719	org/json/JSONException
    //   10691	10716	10719	org/json/JSONException
    //   10873	10906	10938	java/lang/Exception
    //   10826	10863	10957	java/lang/Exception
    //   10939	10949	10957	java/lang/Exception
    //   11069	11082	11308	java/lang/Exception
    //   11087	11096	11308	java/lang/Exception
    //   11101	11110	11308	java/lang/Exception
    //   11115	11125	11308	java/lang/Exception
    //   11130	11139	11308	java/lang/Exception
    //   11144	11155	11308	java/lang/Exception
    //   11165	11175	11308	java/lang/Exception
    //   11180	11190	11308	java/lang/Exception
    //   11195	11204	11308	java/lang/Exception
    //   11209	11217	11308	java/lang/Exception
    //   11222	11230	11308	java/lang/Exception
    //   11235	11250	11308	java/lang/Exception
    //   11286	11300	11308	java/lang/Exception
    //   11378	11434	11563	org/json/JSONException
    //   11437	11441	11563	org/json/JSONException
    //   11448	11459	11563	org/json/JSONException
    //   11465	11491	11563	org/json/JSONException
    //   11494	11525	11563	org/json/JSONException
    //   11525	11551	11563	org/json/JSONException
    //   11551	11560	11563	org/json/JSONException
    //   11603	11625	11563	org/json/JSONException
    //   11645	11660	11663	org/json/JSONException
    //   11737	11758	11761	org/json/JSONException
    //   11811	11828	11842	org/json/JSONException
    //   11832	11839	11842	org/json/JSONException
    //   11811	11828	11881	java/lang/Exception
    //   11832	11839	11881	java/lang/Exception
    //   11937	11971	12089	java/lang/Exception
    //   11973	12007	12089	java/lang/Exception
    //   12011	12033	12089	java/lang/Exception
    //   12033	12086	12089	java/lang/Exception
    //   12133	12185	12205	java/lang/Exception
    //   12185	12202	12205	java/lang/Exception
    //   12226	12278	12529	org/json/JSONException
    //   12281	12289	12529	org/json/JSONException
    //   12293	12300	12529	org/json/JSONException
    //   12300	12316	12529	org/json/JSONException
    //   12319	12339	12529	org/json/JSONException
    //   12345	12526	12529	org/json/JSONException
    //   12573	12594	12529	org/json/JSONException
    //   12594	12615	12529	org/json/JSONException
    //   12226	12278	12618	java/lang/Exception
    //   12281	12289	12618	java/lang/Exception
    //   12293	12300	12618	java/lang/Exception
    //   12300	12316	12618	java/lang/Exception
    //   12319	12339	12618	java/lang/Exception
    //   12345	12526	12618	java/lang/Exception
    //   12573	12594	12618	java/lang/Exception
    //   12594	12615	12618	java/lang/Exception
    //   12711	12761	13042	org/json/JSONException
    //   12761	12804	13042	org/json/JSONException
    //   12807	12816	13042	org/json/JSONException
    //   12821	12829	13042	org/json/JSONException
    //   12829	12845	13042	org/json/JSONException
    //   12848	13039	13042	org/json/JSONException
    //   12711	12761	13081	java/lang/Exception
    //   12761	12804	13081	java/lang/Exception
    //   12807	12816	13081	java/lang/Exception
    //   12821	12829	13081	java/lang/Exception
    //   12829	12845	13081	java/lang/Exception
    //   12848	13039	13081	java/lang/Exception
    //   13131	13157	13214	org/json/JSONException
    //   13161	13211	13214	org/json/JSONException
    //   13131	13157	13271	java/lang/Exception
    //   13161	13211	13271	java/lang/Exception
    //   13350	13377	13435	org/json/JSONException
    //   13379	13397	13435	org/json/JSONException
    //   13397	13405	13435	org/json/JSONException
    //   13409	13432	13435	org/json/JSONException
    //   13489	13508	13597	org/json/JSONException
    //   13508	13518	13597	org/json/JSONException
    //   13518	13528	13597	org/json/JSONException
    //   13528	13536	13597	org/json/JSONException
    //   13540	13558	13597	org/json/JSONException
    //   13568	13578	13597	org/json/JSONException
    //   13584	13594	13597	org/json/JSONException
    //   13634	13660	13597	org/json/JSONException
    //   13670	13696	13597	org/json/JSONException
    //   13704	13714	13597	org/json/JSONException
    //   13722	13732	13597	org/json/JSONException
    //   13508	13518	13633	java/lang/Exception
    //   13518	13528	13666	java/lang/Exception
    //   13753	13793	13847	org/json/JSONException
    //   13797	13844	13847	org/json/JSONException
    //   13883	13908	13847	org/json/JSONException
    //   13936	13976	13979	org/json/JSONException
    //   14032	14075	14100	org/json/JSONException
    //   14083	14097	14100	org/json/JSONException
    //   14154	14181	14204	org/json/JSONException
    //   14185	14201	14204	org/json/JSONException
    //   14258	14282	14419	org/json/JSONException
    //   14285	14324	14419	org/json/JSONException
    //   14327	14382	14419	org/json/JSONException
    //   14387	14416	14419	org/json/JSONException
    //   14472	14513	14419	org/json/JSONException
    //   14533	14560	14576	org/json/JSONException
    //   14569	14573	14576	org/json/JSONException
    //   14590	14599	14576	org/json/JSONException
    //   14603	14640	14576	org/json/JSONException
    //   14646	14660	14576	org/json/JSONException
    //   14669	14683	14576	org/json/JSONException
    //   14767	14852	14855	java/lang/Exception
    //   14869	14887	14855	java/lang/Exception
    //   14892	14903	14855	java/lang/Exception
    //   14903	14924	14855	java/lang/Exception
    //   14927	14938	14855	java/lang/Exception
    //   14952	14993	14996	java/lang/Exception
    //   15032	15111	15114	java/lang/Exception
    //   15139	15218	15271	java/lang/Exception
    //   15218	15268	15271	java/lang/Exception
    //   15285	15319	15271	java/lang/Exception
    //   15322	15354	15271	java/lang/Exception
    //   15368	15441	15444	java/lang/Exception
    //   15469	15498	15580	java/lang/Exception
    //   15502	15577	15580	java/lang/Exception
    //   15605	15617	15623	java/lang/Exception
    //   15669	15766	15769	java/lang/Exception
    //   15794	15878	15881	java/lang/Exception
    //   15895	15900	15881	java/lang/Exception
    //   15903	15923	15881	java/lang/Exception
    //   15926	15938	15881	java/lang/Exception
    //   15941	15966	15881	java/lang/Exception
    //   16060	16141	16144	org/json/JSONException
    //   16163	16197	16248	java/lang/Exception
    //   16203	16245	16248	java/lang/Exception
    //   16273	16316	16372	org/json/JSONException
    //   16316	16340	16372	org/json/JSONException
    //   16343	16369	16372	org/json/JSONException
    //   16386	16398	16372	org/json/JSONException
    //   16418	16544	16567	org/json/JSONException
    //   16544	16564	16567	org/json/JSONException
    //   16592	16701	16714	org/json/JSONException
    //   16701	16711	16714	org/json/JSONException
    //   16739	16848	16861	org/json/JSONException
    //   16848	16858	16861	org/json/JSONException
    //   16886	16932	16935	org/json/JSONException
    //   16949	17101	16935	org/json/JSONException
    //   17101	17132	16935	org/json/JSONException
    //   17146	17244	17294	java/lang/Exception
    //   17250	17256	17294	java/lang/Exception
    //   17256	17291	17294	java/lang/Exception
    //   17309	17318	17294	java/lang/Exception
    //   17321	17336	17294	java/lang/Exception
    //   17339	17370	17294	java/lang/Exception
    //   17373	17391	17294	java/lang/Exception
    //   10800	10820	17396	java/lang/Exception
    //   3879	3888	17400	org/json/JSONException
    //   3893	3906	17400	org/json/JSONException
    //   1234	1267	17463	java/lang/Throwable
    //   1270	1299	17463	java/lang/Throwable
    //   1302	1310	17463	java/lang/Throwable
    //   1910	1951	17477	org/json/JSONException
    //   1953	2026	17477	org/json/JSONException
    //   2028	2039	17477	org/json/JSONException
    //   2042	2071	17477	org/json/JSONException
  }
  
  public void onActivityReady()
  {
    if ((jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (QbSdk.getTbsVersion(this.mRuntime.a()) >= 44001)) {
      g();
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {}
    try
    {
      d();
      if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (jdField_a_of_type_AndroidContentBroadcastReceiver != null))
      {
        this.jdField_b_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_JavaLangRefWeakReference);
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "put current UiApiPlugin into sUiApiPluginReferences: " + this.jdField_a_of_type_JavaLangRefWeakReference.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "error:" + localException.toString());
        }
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 13) {
      if (paramIntent != null) {}
    }
    Object localObject4;
    Object localObject3;
    label565:
    Object localObject2;
    int n;
    boolean bool1;
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
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      Object localObject1;
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return;
                              localObject1 = paramIntent.getStringExtra("result");
                              callJs(paramIntent.getStringExtra("callback"), new String[] { localObject1 });
                              return;
                              if (paramByte != 3) {
                                break;
                              }
                            } while (paramIntent == null);
                            localObject1 = paramIntent.getStringExtra("scanResult");
                            if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
                              break;
                            }
                            localObject4 = paramIntent.getStringExtra("callback_url");
                            localObject3 = paramIntent.getStringExtra("name");
                          } while ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty((CharSequence)localObject3)));
                          localObject4 = ((String)localObject4).split("#");
                          localStringBuilder = new StringBuilder(localObject4[0]);
                          if (localObject4[0].contains("?")) {}
                          for (paramIntent = "&";; paramIntent = "?")
                          {
                            paramIntent = localStringBuilder.append(paramIntent).append((String)localObject3).append("=").append(URLEncoder.encode((String)localObject1));
                            if (localObject4.length > 1) {
                              paramIntent.append("#").append(localObject4[1]);
                            }
                            if (this.mRuntime.a() == null) {
                              break;
                            }
                            this.mRuntime.a().loadUrl(paramIntent.toString());
                            return;
                          }
                          localObject3 = this.jdField_c_of_type_JavaLangString;
                          if (localObject1 == null) {}
                          for (paramIntent = "''";; paramIntent = nax.a((String)localObject1))
                          {
                            callJs((String)localObject3, new String[] { paramIntent });
                            return;
                          }
                          if (paramByte != 17) {
                            break;
                          }
                        } while (paramIntent == null);
                        paramInt = paramIntent.getIntExtra("ret_code", -1);
                        localObject3 = paramIntent.getStringExtra("ocr_result");
                        localObject4 = new JSONObject();
                        try
                        {
                          if (TextUtils.isEmpty((CharSequence)localObject3)) {
                            paramInt = -1;
                          }
                          ((JSONObject)localObject4).put("retCode", paramInt);
                          localObject1 = localObject3;
                          if (TextUtils.isEmpty((CharSequence)localObject3)) {
                            localObject1 = "";
                          }
                          ((JSONObject)localObject4).put("result", localObject1);
                        }
                        catch (JSONException localJSONException1)
                        {
                          for (;;)
                          {
                            localJSONException1.printStackTrace();
                            continue;
                            paramIntent = "?";
                          }
                          callJs(this.jdField_d_of_type_JavaLangString, new String[] { ((JSONObject)localObject4).toString() });
                          return;
                        }
                        if (QLog.isColorLevel()) {
                          QLog.i("UiApiPlugin", 2, "scanForOCR CODE_OCRCODE result: " + ((JSONObject)localObject4).toString());
                        }
                        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
                          break label565;
                        }
                        localObject3 = paramIntent.getStringExtra("callback_url");
                        localObject1 = paramIntent.getStringExtra("name");
                      } while ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject1)));
                      localObject3 = ((String)localObject3).split("#");
                      StringBuilder localStringBuilder = new StringBuilder(localObject3[0]);
                      if (!localObject3[0].contains("?")) {
                        break;
                      }
                      paramIntent = "&";
                      paramIntent = localStringBuilder.append(paramIntent).append((String)localObject1).append("=").append(URLEncoder.encode(((JSONObject)localObject4).toString()));
                      if (localObject3.length > 1) {
                        paramIntent.append("#").append(localObject3[1]);
                      }
                    } while (this.mRuntime.a() == null);
                    this.mRuntime.a().loadUrl(paramIntent.toString());
                    return;
                    if (paramByte != 4) {
                      break;
                    }
                  } while (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString));
                  if (paramInt == -1)
                  {
                    if (paramIntent == null) {}
                    for (paramIntent = "";; paramIntent = paramIntent.getStringExtra("result"))
                    {
                      paramIntent = "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + paramIntent + "}}";
                      callJs(this.jdField_f_of_type_JavaLangString, new String[] { paramIntent });
                      return;
                    }
                  }
                  callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{\"code\":-1}" });
                  return;
                  if (paramByte != 5) {
                    break;
                  }
                } while (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString));
                if (paramInt == -1)
                {
                  paramInt = paramIntent.getIntExtra("ret", 4);
                  if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, "select contact ret:" + paramInt);
                  }
                  localObject2 = new JSONObject();
                  for (;;)
                  {
                    try
                    {
                      ((JSONObject)localObject2).put("ret", paramInt);
                      if (paramInt == 0)
                      {
                        localObject3 = paramIntent.getStringArrayExtra("openids");
                        paramIntent = paramIntent.getIntArrayExtra("types");
                        if ((localObject3 != null) && (paramIntent != null) && (localObject3.length == paramIntent.length))
                        {
                          n = localObject3.length;
                          localObject4 = new JSONArray();
                          paramInt = 0;
                          if (paramInt < n)
                          {
                            ((JSONArray)localObject4).put(new JSONObject().put("type", paramIntent[paramInt]).put("openID", localObject3[paramInt]));
                            paramInt += 1;
                            continue;
                          }
                          ((JSONObject)localObject2).put("contacts", localObject4);
                        }
                        callJs(this.jdField_g_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
                        return;
                      }
                    }
                    catch (JSONException paramIntent)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("UiApiPlugin", 2, "select contact result json exception", paramIntent);
                      }
                      callJs(this.jdField_g_of_type_JavaLangString, new String[] { "{\"ret\":4}" });
                      return;
                    }
                    ((JSONObject)localObject2).put("errMsg", paramIntent.getStringExtra("errMsg"));
                  }
                }
                callJs(this.jdField_g_of_type_JavaLangString, new String[] { "{\"ret\":3}" });
                return;
                if (paramByte != 7) {
                  break;
                }
              } while (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString));
              if (paramInt == -1)
              {
                paramInt = paramIntent.getIntExtra("ret", 0);
                if (QLog.isColorLevel()) {
                  QLog.d("UiApiPlugin", 2, "select Member ret:" + paramInt);
                }
                localObject2 = new JSONObject();
                for (;;)
                {
                  try
                  {
                    ((JSONObject)localObject2).put("ret", paramInt);
                    if (paramInt == 0)
                    {
                      ((JSONObject)localObject2).put("selectMore", this.jdField_b_of_type_Boolean);
                      ((JSONObject)localObject2).put("uin", this.k);
                      ((JSONObject)localObject2).put("uinType", "0");
                      localObject3 = new JSONArray();
                      if (this.jdField_b_of_type_Boolean)
                      {
                        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
                        paramInt = 0;
                        if (paramInt < paramIntent.size())
                        {
                          localObject4 = (ResultRecord)paramIntent.get(paramInt);
                          ((JSONArray)localObject3).put(new JSONObject().put("memUin", ((ResultRecord)localObject4).jdField_a_of_type_JavaLangString).put("nick", ((ResultRecord)localObject4).jdField_b_of_type_JavaLangString));
                          paramInt += 1;
                          continue;
                        }
                      }
                      else
                      {
                        localObject4 = paramIntent.getStringExtra("member_uin");
                        paramIntent = paramIntent.getStringExtra("member_display_name");
                        ((JSONArray)localObject3).put(new JSONObject().put("memUin", localObject4).put("nick", paramIntent));
                      }
                      ((JSONObject)localObject2).put("selectUins", localObject3);
                      callJs(this.jdField_f_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
                      return;
                    }
                  }
                  catch (JSONException paramIntent)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("UiApiPlugin", 2, "select contact result json exception", paramIntent);
                    }
                    callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{\"ret\":3,\"errMsg\":\"Json Parse Error\"}" });
                    return;
                  }
                  ((JSONObject)localObject2).put("errMsg", paramIntent.getStringExtra("errMsg"));
                }
              }
              callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{\"ret\":1,\"errMsg\":\"User cancle\"}" });
              return;
              if (paramByte != 6) {
                break;
              }
            } while (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString));
            if (paramInt == -1)
            {
              callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{'retcode' : 0}" });
              return;
            }
            paramInt = paramIntent.getIntExtra("retCode", -1);
            callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{'retcode' : " + paramInt + "}" });
            return;
            if ((paramByte != 8) && (paramByte != 9)) {
              break;
            }
          } while ((paramInt != -1) || (paramIntent == null));
          bool1 = paramIntent.getBooleanExtra("key_troop_fee_notify_js_data_changed", false);
          paramIntent = paramIntent.getStringExtra("callback");
        } while (!bool1);
        callJs(paramIntent, new String[] { "{}" });
        return;
        if (paramByte != 10) {
          break;
        }
      } while ((paramInt != -1) && (paramIntent == null));
      balg.a(this.mRuntime.a(), paramIntent, null);
      a(paramIntent.getStringExtra("troop_uin"), "send_page");
      return;
      if (paramByte != 11) {
        break label1898;
      }
      localObject2 = null;
      bool1 = false;
      if (paramIntent != null)
      {
        localObject2 = paramIntent.getStringExtra("callback");
        bool1 = paramIntent.getBooleanExtra("isOpenApi", false);
      }
      localObject3 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject2 = this.l;
      boolean bool2 = this.jdField_c_of_type_Boolean;
      bool1 = bool2;
      localObject3 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      bool1 = bool2;
      localObject3 = localObject2;
      if (bool2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("UiApiPlugin", 2, "groupOrganizationView no callback");
    return;
    this.l = null;
    this.jdField_c_of_type_Boolean = false;
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("UiApiPlugin", 2, "groupOrganization result intent=null");
      }
      if (bool1)
      {
        callJs4OpenApiIfNeeded("groupOrganizationView", -100, "{ret:4}");
        return;
      }
      callJs((String)localObject3, new String[] { "{ret:4}" });
      return;
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        n = paramIntent.getIntExtra("ret", 5);
        ((JSONObject)localObject2).put("ret", n);
        localObject4 = paramIntent.getStringExtra("errMsg");
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          ((JSONObject)localObject2).put("errMsg", localObject4);
        }
        if (n != 0) {
          break label2228;
        }
        paramIntent = paramIntent.getStringArrayExtra("result");
        localObject4 = new JSONArray();
        int i1 = paramIntent.length;
        paramInt = 0;
        if (paramInt < i1)
        {
          ((JSONArray)localObject4).put(paramIntent[paramInt]);
          paramInt += 1;
          continue;
        }
        ((JSONObject)localObject2).put("openIDArr", localObject4);
      }
      catch (JSONException paramIntent)
      {
        label1807:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("UiApiPlugin", 2, "groupOrganization error", paramIntent);
        if (!bool1) {
          break label1881;
        }
      }
      callJs4OpenApiIfNeeded("groupOrganizationView", paramInt, ((JSONObject)localObject2).toString());
      return;
      callJs4OpenApiIfNeeded("groupOrganizationView", -100, "{ret:4}");
      return;
      label1881:
      label1898:
      do
      {
        paramInt = -100;
        break label1807;
        do
        {
          callJs((String)localObject3, new String[] { ((JSONObject)localObject2).toString() });
          return;
          callJs((String)localObject3, new String[] { "{ret:4}" });
          return;
          if (paramByte == 12)
          {
            paramInt = paramIntent.getIntExtra("cGroupOption", -1);
            localObject2 = paramIntent.getStringExtra("troop_uin");
            if (paramIntent.getBooleanExtra("isSetFee", false)) {
              paramInt = 4;
            }
            for (;;)
            {
              paramIntent = new JSONObject();
              try
              {
                paramIntent.put("gc", localObject2);
                paramIntent.put("ret", 0);
                paramIntent.put("joinType", paramInt);
                callJs(this.m, new String[] { paramIntent.toString() });
                return;
                switch (paramInt)
                {
                default: 
                  paramInt = -1;
                  break;
                case 1: 
                  paramInt = 0;
                  break;
                case 2: 
                  paramInt = 1;
                  break;
                case 3: 
                  paramInt = 5;
                  break;
                case 4: 
                  paramInt = 3;
                  break;
                case 5: 
                  paramInt = 2;
                }
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  localJSONException2.printStackTrace();
                }
              }
            }
          }
          if (paramByte == 15)
          {
            if (TextUtils.isEmpty(this.i)) {
              break;
            }
            str = this.i;
            localObject3 = new StringBuilder().append("{'result' : ");
            if (paramInt == -1) {}
            for (paramIntent = "true";; paramIntent = "false")
            {
              callJs(str, new String[] { paramIntent + "}" });
              return;
            }
          }
          if ((paramByte != 16) || (TextUtils.isEmpty(this.j))) {
            break;
          }
          String str = this.j;
          localObject3 = new StringBuilder().append("{'result' : ");
          if (paramInt == -1) {}
          for (paramIntent = "true";; paramIntent = "false")
          {
            callJs(str, new String[] { paramIntent + "}" });
            return;
          }
        } while (!bool1);
      } while (n != 0);
      label2228:
      paramInt = 0;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { "1", Integer.toString(this.jdField_a_of_type_Int) });
      return;
    }
    callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(this.jdField_a_of_type_Int));
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      paramView = this.mRuntime.a();
      if (paramView != null) {
        paramView.finish();
      }
    }
  }
  
  public void onCreate()
  {
    anvl.a().a(this.jdField_a_of_type_Anql);
  }
  
  public void onDestroy()
  {
    if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "remove current UiApiPlugin from sUiApiPluginReferences: " + this.jdField_a_of_type_JavaLangRefWeakReference.toString());
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(this.jdField_a_of_type_JavaLangRefWeakReference);
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    if ((this.jdField_a_of_type_Bfol != null) && (this.jdField_a_of_type_Bfol.isShowing())) {
      this.jdField_a_of_type_Bfol.dismiss();
    }
    if (this.jdField_a_of_type_Wxu != null) {
      this.jdField_a_of_type_Wxu.b();
    }
    anvl.a().b(this.jdField_a_of_type_Anql);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.destroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = null;
    }
    super.onDestroy();
  }
  
  public void onDismiss()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { "1", Integer.toString(this.jdField_a_of_type_Int) });
      return;
    }
    callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin
 * JD-Core Version:    0.7.0.1
 */