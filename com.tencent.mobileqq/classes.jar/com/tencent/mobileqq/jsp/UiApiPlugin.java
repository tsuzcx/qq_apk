package com.tencent.mobileqq.jsp;

import aciy;
import ajed;
import ajjy;
import anad;
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
import anfc;
import aphp;
import aqsz;
import aqtd;
import aqte;
import aqtf;
import aqtg;
import aqth;
import aqti;
import aqtj;
import aqtl;
import aqtm;
import aqtn;
import aqto;
import aqtp;
import aqtq;
import aqtr;
import aqts;
import aqtu;
import atmp;
import atmq;
import avwf;
import awqx;
import awrn;
import axfs;
import axoa;
import azkd;
import azvv;
import baaw;
import bacc;
import bace;
import bacm;
import bahj;
import baig;
import bale;
import balh;
import batm;
import bato;
import batr;
import bazb;
import bazo;
import bbac;
import bbcj;
import bbcm;
import bbdc;
import bbek;
import bbel;
import bben;
import bbeq;
import bber;
import bbeu;
import bbmy;
import bcdu;
import begr;
import begw;
import begy;
import begz;
import bemi;
import beml;
import bezd;
import bfas;
import bgmw;
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
import mkw;
import mmi;
import mpl;
import mpw;
import mqq.app.BaseActivity;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import urp;
import vjw;
import vvp;
import wis;
import wpa;
import xcv;
import xdt;

public class UiApiPlugin
  extends WebViewPlugin
  implements DialogInterface.OnCancelListener, View.OnClickListener, begw, begy, begz
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
  public anad a;
  public ProgressDialog a;
  public View a;
  public ImageView a;
  public begr a;
  bemi jdField_a_of_type_Bemi = null;
  public RefreshView a;
  public MiniMsgUser a;
  public String a;
  WeakReference<UiApiPlugin> jdField_a_of_type_JavaLangRefWeakReference = null;
  public wis a;
  public wpa a;
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
    this.jdField_a_of_type_Wis = null;
    this.jdField_a_of_type_Anad = new aqsz(this);
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
    return new aqts(this);
  }
  
  private MiniMsgUser.IMiniMsgActionCallback a()
  {
    return new aqtu(this);
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
  
  public static String a(xcv paramxcv)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramxcv != null) {}
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type", "init");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isShowBottomBar", paramxcv.jdField_a_of_type_Boolean);
      localJSONObject.put("barHeight", paramxcv.jdField_a_of_type_Int);
      ((JSONObject)localObject1).put("data", localJSONObject);
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    catch (JSONException paramxcv)
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
    paramArrayOfString = new NewIntent(BaseApplicationImpl.getContext(), mmi.class);
    paramArrayOfString.setWithouLogin(true);
    paramArrayOfString.putExtra("cmd", "CommCompSvr.get_openid");
    paramArrayOfString.putExtra("data", localGetOpenidReq.toByteArray());
    paramArrayOfString.setObserver(new aqtd(paramActivity));
    paramAppInterface.startServlet(paramArrayOfString);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (bahj.a(paramActivity, new String[] { paramString1 }))
    {
      bbmy.a(paramActivity, 2131626628, 0).b(paramActivity.getResources().getDimensionPixelSize(2131167766));
      paramActivity = a("-4", null, "createShortcut exsit!", paramString3);
      awqx.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -2, "", "", "", "");
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
        paramString2 = BitmapFactory.decodeResource(paramContext.getResources(), 2130839762);
        if (paramString2 == null) {
          break label373;
        }
        n = bacc.a(paramContext);
        if (n == paramString2.getWidth()) {
          break label373;
        }
        if (balh.jdField_c_of_type_Boolean) {
          break label168;
        }
        paramString2 = bale.a().a(paramString2, n);
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
        paramString2 = mpl.a(paramContext, paramString2, "GET", null, null);
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
      bale.a().a(paramIntent);
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
    jdField_c_of_type_AndroidContentBroadcastReceiver = new aqtr(this);
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
      this.jdField_a_of_type_Begr.dismiss();
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
      n = 2130843171;
    }
    do
    {
      return n;
      if ("2".equals(paramString)) {
        return 2130843170;
      }
      if ("3".equals(paramString)) {
        return 2130839708;
      }
      if ("4".equals(paramString)) {
        return 2130839083;
      }
      if ("5".equals(paramString)) {
        return 2130843216;
      }
      if ("7".equals(paramString))
      {
        if (paramBoolean) {
          return 2130841909;
        }
        return 2130841912;
      }
      if ("8".equals(paramString))
      {
        if (paramBoolean) {
          return 2130848837;
        }
        return 2130848841;
      }
      if ("9".equals(paramString)) {
        return 2130838572;
      }
      if ("10".equals(paramString)) {
        return 2130848966;
      }
      if ("11".equals(paramString)) {
        return 2130848965;
      }
      if ("14".equals(paramString)) {
        return 2130848912;
      }
    } while (!"15".equals(paramString));
    return 2130848913;
  }
  
  public Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public bbeq a()
  {
    bazo localbazo = this.mRuntime.a(this.mRuntime.a());
    if ((localbazo != null) && ((localbazo instanceof bbeq))) {
      return (bbeq)localbazo;
    }
    return null;
  }
  
  public bbeu a()
  {
    bazo localbazo = this.mRuntime.a(this.mRuntime.a());
    if ((localbazo != null) && ((localbazo instanceof bbeu))) {
      return (bbeu)localbazo;
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
        localDrawable = bacm.a(localDrawable, paramInt);
        if (localDrawable != null) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject = null;
    aqtf localaqtf = null;
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
        localRelativeLayout = (RelativeLayout)localActivity.findViewById(2131309578);
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
          Drawable localDrawable = localActivity.getResources().getDrawable(2130843895);
          localObject = localDrawable;
          if (!TextUtils.isEmpty(paramString))
          {
            localaqtf = new aqtf(this, paramString);
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
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localaqtf);
        this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localActivity.getResources().getDrawable(2130849053));
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localaqtf);
      paramString = new RelativeLayout(localActivity);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      paramString.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(azvv.a(localBaseApplication, 8.0F), azvv.a(localBaseApplication, 8.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, azvv.a(localBaseApplication, 4.0F), azvv.a(localBaseApplication, 4.0F), 0);
      paramString.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(azvv.a(localBaseApplication, 36.0F), azvv.a(localBaseApplication, 36.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131309694);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, azvv.a(localBaseApplication, 4.0F), 0);
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
        awqx.b(null, "CliOper", "", "", "ep_mall", "Clk_ep_search", 0, 0, "", "", "", "");
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
    aphp.a(localActivity, (Intent)localObject, 18);
  }
  
  public void a(String paramString)
  {
    int i2 = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    do
    {
      return;
      if (this.jdField_a_of_type_Begr != null)
      {
        if (this.jdField_a_of_type_Begr.isShowing()) {
          this.jdField_a_of_type_Begr.dismiss();
        }
        if (paramString.equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_Begr.show();
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
        localObject1 = begr.a((Context)localObject1);
        Object localObject2 = localJSONObject.optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((begr)localObject1).a((CharSequence)localObject2);
        }
        localObject2 = localJSONObject.optJSONArray("items");
        int i3 = localJSONObject.optInt("selected", -1);
        this.jdField_a_of_type_Boolean = false;
        String str = localJSONObject.optString("close");
        if (TextUtils.isEmpty(str)) {
          break label398;
        }
        this.jdField_a_of_type_Boolean = true;
        ((begr)localObject1).a(str, 3);
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
                ((begr)localObject1).a(str, bool);
                i1 += 1;
                continue;
              }
            }
            if (i1 >= i4) {
              break label409;
            }
            ((begr)localObject1).c(((JSONArray)localObject2).getString(i1));
            i1 += 1;
            continue;
          }
        }
        localObject2 = localJSONObject.optString("cancel");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((begr)localObject1).d((CharSequence)localObject2);
        }
        ((begr)localObject1).a(this);
        ((begr)localObject1).a(this);
        ((begr)localObject1).setOnCancelListener(this);
        ((begr)localObject1).a(this);
        this.jdField_a_of_type_Begr = ((begr)localObject1);
        this.jdField_b_of_type_JavaLangString = localJSONObject.optString("onclick");
        this.jdField_a_of_type_Int = i1;
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Begr.show();
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
    atmp localatmp = this.mRuntime.a().getEntityManagerFactory(this.mRuntime.a().getAccount()).createEntityManager();
    TroopInfo localTroopInfo = (TroopInfo)localatmp.a(TroopInfo.class, paramString1);
    localatmp.a();
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
      awqx.b(null, "P_CliOper", "Grp_flower", "", "mber", paramString2, 0, 0, paramString1, n + "", "", "");
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
            if (bezd.a(str3, paramString))
            {
              paramString.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
              localActivity.startActivityForResult(paramString, 100);
              break label522;
            }
            bezd.a(localActivity, paramString, 100);
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
              if (axfs.a(str3))
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
              if (!bezd.a(str3, paramString)) {
                break label2525;
              }
              paramString.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
              bfas.a(localActivity, paramString, "com.qqcomic.activity.media.VipComicMediaPlayActivity", null);
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
            localActivity.overridePendingTransition(2130772277, 0);
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
      a(paramJSONObject, null, new aqtg(this, paramJSONObject));
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
          paramJSONObject = (bbcj)super.getBrowserComponent(2);
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.jdField_a_of_type_Bbcm;
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
      if ((paramJSONObject != null) && ((paramJSONObject instanceof bbeu)))
      {
        ((bbeu)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener, null);
        return;
      }
      if ((paramJSONObject != null) && ((paramJSONObject instanceof bbek)))
      {
        ((bbek)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener);
        return;
      }
      if ((paramJSONObject != null) && ((paramJSONObject instanceof bbel)))
      {
        ((bbel)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener);
        return;
      }
    } while ((paramJSONObject == null) || (!(paramJSONObject instanceof bben)));
    ((bben)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener, this.mRuntime.a().hashCode());
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
    avwf.a(this.mRuntime.a(), paramString, str2, (List)localObject, paramJSONObject, localRect, new aqtp(this, str1));
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
    ((TextView)localObject1).setText(2131625271);
    ((TextView)localObject1).setBackgroundResource(2130849311);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setMaxWidth(azvv.a((Context)localObject3, 100.0F));
    ((TextView)localObject1).setMinWidth(azvv.a((Context)localObject3, 52.0F));
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setTextColor(((Context)localObject3).getResources().getColor(2131101254));
    ((TextView)localObject1).setTextSize(1, 17.0F);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, azvv.a((Context)localObject3, 36.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131309694);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((TextView)localObject1).setOnClickListener(this);
    Object localObject2 = (RelativeLayout)((Activity)localObject2).findViewById(2131309578);
    if (localObject2 != null) {
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    }
    this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
    label197:
    for (this.jdField_g_of_type_Boolean = true;; this.jdField_g_of_type_Boolean = false)
    {
      localObject1 = this.mRuntime.a();
      if ((localObject1 == null) || (((WebViewFragment)localObject1).jdField_a_of_type_Bazb == null)) {
        break;
      }
      ((WebViewFragment)localObject1).jdField_a_of_type_Bazb.e(paramBoolean);
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
      localView = ((Activity)localObject).findViewById(2131309578);
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
        ((TranslateAnimation)localObject).setAnimationListener(new aqtl(this, localView, localView.getTop() - n, localView.getBottom() - n));
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
      ((TranslateAnimation)localObject).setAnimationListener(new aqtm(this, localView, localView.getTop() + n, n + localView.getBottom()));
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
      this.jdField_b_of_type_AndroidViewView = localActivity.findViewById(2131297876);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Wpa = this.jdField_a_of_type_ComTencentBizUiRefreshView.jdField_a_of_type_Wpa;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Wpa.setHeaderBgColor(-16777216);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setBackgroundColor(-16777216);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(new aqte(this));
        callJs4OpenApiIfNeeded("setPullDown", 0, "[]");
        return;
        this.jdField_a_of_type_Wpa.setHeaderBgColor(paramInt1);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setBackgroundColor(paramInt2);
      }
    }
    callJs4OpenApiIfNeeded("setPullDown", 0, "already initPullDown");
  }
  
  protected void a(byte[] paramArrayOfByte, String paramString)
  {
    paramString = ajed.aU + "diskcache/Image_" + paramString;
    bace.a(paramArrayOfByte, paramString);
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
        startActivityForResult(azkd.a(this.mRuntime.a(), paramString1, "web"), (byte)10);
        a(paramString1, "exp");
        return true;
      }
      if (paramString2.equals("g_proceeding")) {
        return true;
      }
      if (paramString2.equals("g_homework"))
      {
        if (this.jdField_a_of_type_Wis == null)
        {
          this.jdField_a_of_type_Wis = wis.a();
          this.jdField_a_of_type_Wis.a();
        }
        this.jdField_a_of_type_Wis.a(paramString1, paramString2);
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
        if (this.jdField_a_of_type_Wis == null)
        {
          this.jdField_a_of_type_Wis = wis.a();
          this.jdField_a_of_type_Wis.a();
        }
        this.jdField_a_of_type_Wis.a(paramString1, paramString2);
        return true;
      }
      if (paramString2.equals("g_background"))
      {
        if (baig.q(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin())) {
          TroopPicEffectsEditActivity.a(this.mRuntime.a(), paramString1, paramString1);
        }
        for (;;)
        {
          return true;
          baig.z(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin());
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
      paramString1 = vjw.a(null, paramString3, null);
      urp.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
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
  
  public void an_()
  {
    Object localObject = this.mRuntime.a();
    if ((localObject instanceof PublicFragmentActivity))
    {
      localObject = ((PublicFragmentActivity)localObject).a();
      if ((localObject instanceof TribeVideoListPlayerFragment)) {
        ((TribeVideoListPlayerFragment)localObject).a(this.jdField_a_of_type_Begr);
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
    if ((localObject != null) && ((localObject instanceof bber)))
    {
      localObject = ((bber)localObject).a();
      Bundle localBundle = new Bundle();
      localBundle.putString("title", ((xdt)localObject).b());
      localBundle.putString("desc", ((xdt)localObject).c());
      localBundle.putString("detail_url", ((xdt)localObject).a());
      localBundle.putString("cover_url", ((xdt)localObject).e());
      localBundle.putInt("article_id", ((xdt)localObject).a());
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(((xdt)localObject).d());
      localBundle.putStringArrayList("image_url", localArrayList);
      localBundle.putString("source_name", ((xdt)localObject).f());
      if (a() != null)
      {
        if (!bgmw.a(this.mRuntime.a(), a(), localBundle, null, 0)) {
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
    vvp.a(1, 2131623975);
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
      if ((localObject1 != null) && ((localObject1 instanceof bbeu))) {
        localObject1 = ((bbeu)localObject1).a();
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
          if ((localObject1 != null) && ((localObject1 instanceof bbek)))
          {
            localObject1 = ((bbek)localObject1).a();
          }
          else if ((localObject1 != null) && ((localObject1 instanceof bben)))
          {
            localObject1 = ((bben)localObject1).a(this.mRuntime.a().hashCode());
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
      if (this.jdField_a_of_type_Bemi != null)
      {
        if (!this.jdField_a_of_type_Bemi.isShowing()) {
          this.jdField_a_of_type_Bemi.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131167526) - localActivity.getResources().getDimensionPixelSize(2131167522), localActivity.getResources().getDimensionPixelSize(2131167523));
        }
      }
      else
      {
        Drawable localDrawable = localActivity.getResources().getDrawable(2130839213);
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
      this.jdField_a_of_type_Bemi = bemi.a(localActivity, localArrayList, new aqth(this, paramJSONObject, localActivity));
      this.jdField_a_of_type_Bemi.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131167526) - localActivity.getResources().getDimensionPixelSize(2131167522), localActivity.getResources().getDimensionPixelSize(2131167523));
      return;
      int n = 0;
      while (n < localJSONArray.length())
      {
        Object localObject2 = localJSONArray.optJSONObject(n);
        beml localbeml = new beml();
        localbeml.jdField_a_of_type_Int = Integer.parseInt(((JSONObject)localObject2).optString("id"));
        localbeml.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("itemContent");
        localbeml.jdField_c_of_type_JavaLangString = localbeml.jdField_a_of_type_JavaLangString;
        localbeml.jdField_b_of_type_Int = 2130849432;
        localObject2 = ((JSONObject)localObject2).optString("itemUrl");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((int)(71.0F * f1));
          localURLDrawableOptions.mRequestHeight = ((int)(94.0F * f1));
          localURLDrawableOptions.mLoadingDrawable = localException;
          localURLDrawableOptions.mFailedDrawable = localException;
          localbeml.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        }
        localArrayList.add(localbeml);
        n += 1;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bemi.isShowing()) {
      this.jdField_a_of_type_Bemi.dismiss();
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
      bbmy.a(this.mRuntime.a().getApplication(), 1, ajjy.a(2131650056), 0).a();
      return;
    }
    if (this.jdField_b_of_type_AndroidAppProgressDialog == null)
    {
      this.jdField_b_of_type_AndroidAppProgressDialog = new ProgressDialog((Context)localObject1, 2131690181);
      this.jdField_b_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_b_of_type_AndroidAppProgressDialog.show();
      this.jdField_b_of_type_AndroidAppProgressDialog.setContentView(2131493818);
      ((TextView)this.jdField_b_of_type_AndroidAppProgressDialog.findViewById(2131305861)).setText(ajjy.a(2131650058));
    }
    for (;;)
    {
      localObject2 = new File(axoa.d(paramString));
      if (!((File)localObject2).exists()) {
        break;
      }
      this.jdField_b_of_type_AndroidAppProgressDialog.dismiss();
      a((File)localObject2);
      return;
      this.jdField_b_of_type_AndroidAppProgressDialog.show();
    }
    localObject1 = new Bundle();
    Object localObject2 = new batm(paramString, (File)localObject2);
    ((batm)localObject2).d = 60L;
    ((bato)this.mRuntime.a().getManager(47)).a(1).a((batm)localObject2, new aqtn(this, paramString), (Bundle)localObject1);
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
    bazo localbazo;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localbazo = this.mRuntime.a(this.mRuntime.a());
      if ((localbazo != null) && ((localbazo instanceof bben))) {
        ((bben)localbazo).a((String)localObject2, this.mRuntime.a().hashCode());
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
        awrn.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actWvCloseHandle", true, 0L, 0L, (HashMap)localObject2, null);
        return;
        if ((localbazo != null) && ((localbazo instanceof bbek)))
        {
          ((bbek)localbazo).a((String)localObject2);
          break label97;
        }
        if ((localbazo instanceof WebViewFragment))
        {
          if (bbdc.a()) {
            break label97;
          }
          localObject3 = (WebViewFragment)localbazo;
          if ((((WebViewFragment)localObject3).jdField_a_of_type_Bazb == null) || (((WebViewFragment)localObject3).jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView == null)) {
            break label97;
          }
          ((WebViewFragment)localObject3).jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          break label97;
        }
        localObject3 = (TextView)((Activity)localObject3).findViewById(2131302804);
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
    jdField_a_of_type_AndroidContentBroadcastReceiver = new aqtq(this);
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
        localObject1 = ajed.aU + "diskcache/Image_" + bcdu.d(str);
        bace.a(baaw.decode(str, 0), (String)localObject1);
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
    Object localObject2 = new File(axoa.d(str));
    if (((File)localObject2).exists())
    {
      a(paramString, axoa.d(str), 0);
      return;
    }
    Object localObject1 = new Bundle();
    localObject2 = new batm(str, (File)localObject2);
    ((batm)localObject2).d = 60L;
    ((bato)this.mRuntime.a().getManager(47)).a(1).a((batm)localObject2, new aqto(this, str, paramString), (Bundle)localObject1);
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
      localWebViewFragment.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramJSONObject = (bbcj)super.getBrowserComponent(2);
      if ((paramJSONObject == null) || (!paramJSONObject.jdField_a_of_type_Bbcm.z) || ("1000".equals(ThemeUtil.getCurrentThemeId()))) {
        break label334;
      }
      bool = true;
      this.jdField_e_of_type_Int = a((String)localObject1, bool);
      if (paramJSONObject == null) {
        break label339;
      }
      paramJSONObject.a(localWebViewFragment.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView, false, this.jdField_e_of_type_Int, this.jdField_e_of_type_Int);
      label181:
      localWebViewFragment.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str4);
      localWebViewFragment.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aqti(this, localActivity, (String)localObject1, (String)localObject2));
      localObject1 = (RelativeLayout)localActivity.findViewById(2131309578);
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
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new aqtj(this, localActivity, str1, str2));
      localWebViewFragment.jdField_a_of_type_Bazb.e(false);
      ((RelativeLayout)localObject1).addView(this.jdField_c_of_type_AndroidWidgetImageView);
      return;
      label334:
      bool = false;
      break;
      label339:
      localWebViewFragment.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_e_of_type_Int);
      break label181;
      label357:
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131309694);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = azvv.a(localActivity.getApplicationContext(), 10.0F);
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
    if (this.jdField_a_of_type_Wis == null) {
      this.jdField_a_of_type_Wis = wis.a();
    }
    this.jdField_a_of_type_Wis.e();
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
                    if ((localObject1 != null) && ((((bbeu)localObject1).a() & 0x200000) == 0L) && (!((Intent)localObject2).getBooleanExtra("show_right_close_button", false)))
                    {
                      localObject2 = (TextView)paramString.findViewById(2131302832);
                      if ((localObject2 == null) || (((TextView)localObject2).getVisibility() != 0) || (!paramString.getString(2131625271).equals(((TextView)localObject2).getText()))) {
                        break label299;
                      }
                    }
                  }
                }
                while (this.jdField_c_of_type_Int == 0)
                {
                  return false;
                  if ((((bbeu)localObject1).a() & 0x4) == 0L) {
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
      Object localObject1 = aciy.a(new Intent(paramString, SplashActivity.class), null);
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
    //   6: ifeq +17346 -> 17352
    //   9: aload_0
    //   10: aload 4
    //   12: aload_1
    //   13: invokevirtual 2295	com/tencent/mobileqq/jsp/UiApiPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   16: ldc_w 2297
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
    //   47: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   50: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   53: astore 4
    //   55: aload 5
    //   57: ldc_w 2299
    //   60: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: astore_1
    //   64: aload 5
    //   66: ldc_w 2301
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
    //   97: invokestatic 2306	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   100: ifeq +84 -> 184
    //   103: aload_2
    //   104: invokestatic 2306	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   107: ifeq +77 -> 184
    //   110: new 125	android/content/Intent
    //   113: dup
    //   114: aload 4
    //   116: ldc_w 2308
    //   119: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   122: astore 4
    //   124: aload 4
    //   126: ldc_w 1716
    //   129: aload_1
    //   130: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   133: pop
    //   134: aload 4
    //   136: ldc_w 2301
    //   139: aload_2
    //   140: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   143: pop
    //   144: ldc_w 2310
    //   147: aload_3
    //   148: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +25 -> 176
    //   154: aload 4
    //   156: ldc_w 2312
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
    //   193: ldc_w 2314
    //   196: iconst_2
    //   197: new 497	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 2316
    //   207: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: goto -36 -> 184
    //   223: ldc_w 2318
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
    //   256: invokevirtual 2321	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   259: lstore 10
    //   261: aload_2
    //   262: ldc_w 2323
    //   265: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   268: istore 6
    //   270: aload_2
    //   271: ldc_w 2325
    //   274: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   277: astore_1
    //   278: aload_2
    //   279: ldc_w 1380
    //   282: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: astore_2
    //   286: aload_0
    //   287: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   290: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   293: new 497	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   300: lload 10
    //   302: invokevirtual 2328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: ldc_w 371
    //   308: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: bipush 9
    //   316: invokestatic 2333	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   319: astore_3
    //   320: aload_3
    //   321: ldc_w 2335
    //   324: aload_1
    //   325: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   328: pop
    //   329: aload_3
    //   330: ldc_w 2337
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
    //   365: ldc_w 2314
    //   368: iconst_2
    //   369: new 497	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 2339
    //   379: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_1
    //   383: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: goto -208 -> 184
    //   395: ldc_w 2341
    //   398: aload 4
    //   400: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   403: ifeq +293 -> 696
    //   406: aload 5
    //   408: arraylength
    //   409: ifle +287 -> 696
    //   412: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   415: ifeq +30 -> 445
    //   418: ldc 191
    //   420: iconst_2
    //   421: new 497	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 2346
    //   431: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 5
    //   436: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload_0
    //   446: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   449: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   452: astore_1
    //   453: aload_1
    //   454: ifnonnull +5 -> 459
    //   457: iconst_1
    //   458: ireturn
    //   459: new 109	org/json/JSONObject
    //   462: dup
    //   463: aload 5
    //   465: iconst_0
    //   466: aaload
    //   467: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   470: astore_2
    //   471: aload_2
    //   472: ldc_w 1435
    //   475: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: astore_3
    //   479: aload_2
    //   480: ldc 201
    //   482: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   485: tableswitch	default:+16926 -> 17411, 0:+23->508, 1:+177->662
    //   509: ldc_w 2348
    //   512: iconst_1
    //   513: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   516: istore 8
    //   518: aload_3
    //   519: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   522: ifne -338 -> 184
    //   525: iconst_2
    //   526: istore 7
    //   528: iload 7
    //   530: istore 6
    //   532: iload 8
    //   534: tableswitch	default:+16880 -> 17414, 0:+103->637, 1:+109->643, 2:+115->649, 3:+121->655, 4:+42->576, 5:+42->576, 6:+103->637
    //   577: iload 6
    //   579: aload_3
    //   580: iconst_0
    //   581: invokestatic 1967	bbmy:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lbbmy;
    //   584: aload_1
    //   585: invokevirtual 423	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   588: ldc_w 350
    //   591: invokevirtual 356	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   594: invokevirtual 359	bbmy:b	(I)Landroid/widget/Toast;
    //   597: pop
    //   598: goto -414 -> 184
    //   601: astore_1
    //   602: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   605: ifeq -421 -> 184
    //   608: ldc 191
    //   610: iconst_2
    //   611: new 497	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 2350
    //   621: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_1
    //   625: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   634: goto -450 -> 184
    //   637: iconst_0
    //   638: istore 6
    //   640: goto -64 -> 576
    //   643: iconst_2
    //   644: istore 6
    //   646: goto -70 -> 576
    //   649: iconst_1
    //   650: istore 6
    //   652: goto -76 -> 576
    //   655: bipush 6
    //   657: istore 6
    //   659: goto -83 -> 576
    //   662: aload_3
    //   663: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   666: ifne -482 -> 184
    //   669: aload_1
    //   670: iconst_0
    //   671: aload_3
    //   672: iconst_0
    //   673: invokestatic 1967	bbmy:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lbbmy;
    //   676: iconst_0
    //   677: invokevirtual 2352	bbmy:a	(I)Landroid/widget/Toast;
    //   680: astore_1
    //   681: aload_1
    //   682: bipush 23
    //   684: iconst_0
    //   685: iconst_0
    //   686: invokevirtual 2357	android/widget/Toast:setGravity	(III)V
    //   689: aload_1
    //   690: invokevirtual 2358	android/widget/Toast:show	()V
    //   693: goto -509 -> 184
    //   696: ldc_w 2360
    //   699: aload 4
    //   701: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   704: ifeq +109 -> 813
    //   707: new 109	org/json/JSONObject
    //   710: dup
    //   711: aload 5
    //   713: iconst_0
    //   714: aaload
    //   715: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   718: ldc_w 2362
    //   721: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   724: astore_1
    //   725: aload_1
    //   726: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   729: ifeq +5 -> 734
    //   732: iconst_1
    //   733: ireturn
    //   734: aload_0
    //   735: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   738: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   741: astore_2
    //   742: new 125	android/content/Intent
    //   745: dup
    //   746: aload_2
    //   747: ldc_w 2279
    //   750: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   753: aconst_null
    //   754: invokestatic 2284	aciy:a	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   757: astore_3
    //   758: aload_3
    //   759: ldc_w 2364
    //   762: aload_1
    //   763: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   766: pop
    //   767: aload_3
    //   768: ldc_w 1237
    //   771: iconst_1
    //   772: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   775: pop
    //   776: aload_3
    //   777: ldc_w 2366
    //   780: iconst_1
    //   781: invokevirtual 553	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   784: pop
    //   785: aload_2
    //   786: aload_3
    //   787: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   790: goto -606 -> 184
    //   793: astore_1
    //   794: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   797: ifeq -613 -> 184
    //   800: ldc 191
    //   802: iconst_2
    //   803: ldc_w 2368
    //   806: aload_1
    //   807: invokestatic 2370	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   810: goto -626 -> 184
    //   813: ldc_w 2372
    //   816: aload 4
    //   818: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   821: ifeq +231 -> 1052
    //   824: new 109	org/json/JSONObject
    //   827: dup
    //   828: aload 5
    //   830: iconst_0
    //   831: aaload
    //   832: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   835: astore_3
    //   836: aload_3
    //   837: ldc_w 2362
    //   840: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   843: astore 4
    //   845: aload 4
    //   847: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   850: ifeq +5 -> 855
    //   853: iconst_1
    //   854: ireturn
    //   855: aload_3
    //   856: ldc_w 2374
    //   859: ldc_w 2375
    //   862: invokestatic 1964	ajjy:a	(I)Ljava/lang/String;
    //   865: invokevirtual 2378	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   868: astore 5
    //   870: aload_3
    //   871: ldc_w 2380
    //   874: ldc_w 2382
    //   877: invokevirtual 2378	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   880: astore 14
    //   882: aload_0
    //   883: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   886: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   889: astore_1
    //   890: new 125	android/content/Intent
    //   893: dup
    //   894: aload_1
    //   895: ldc_w 2279
    //   898: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   901: aconst_null
    //   902: invokestatic 2284	aciy:a	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   905: astore_2
    //   906: aload_2
    //   907: ldc_w 2364
    //   910: aload 4
    //   912: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   915: pop
    //   916: aload_2
    //   917: ldc_w 1237
    //   920: iconst_1
    //   921: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   924: pop
    //   925: aload_2
    //   926: ldc_w 2374
    //   929: aload 5
    //   931: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   934: pop
    //   935: aload_2
    //   936: ldc_w 2380
    //   939: aload 14
    //   941: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   944: pop
    //   945: aload_3
    //   946: ldc 201
    //   948: iconst_0
    //   949: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   952: istore 6
    //   954: iload 6
    //   956: iconst_1
    //   957: if_icmpne +65 -> 1022
    //   960: aload_3
    //   961: ldc_w 2384
    //   964: invokevirtual 921	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   967: astore_3
    //   968: aload_3
    //   969: ifnull +15 -> 984
    //   972: aload_2
    //   973: ldc_w 2386
    //   976: aload_3
    //   977: invokevirtual 2387	org/json/JSONArray:toString	()Ljava/lang/String;
    //   980: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   983: pop
    //   984: aload_2
    //   985: ldc_w 2389
    //   988: iload 6
    //   990: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   993: pop
    //   994: aload_1
    //   995: aload_2
    //   996: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   999: goto -815 -> 184
    //   1002: astore_1
    //   1003: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1006: ifeq -822 -> 184
    //   1009: ldc 191
    //   1011: iconst_2
    //   1012: ldc_w 2391
    //   1015: aload_1
    //   1016: invokestatic 2370	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1019: goto -835 -> 184
    //   1022: iload 6
    //   1024: iconst_2
    //   1025: if_icmpne -41 -> 984
    //   1028: aload_2
    //   1029: ldc_w 2393
    //   1032: aload_3
    //   1033: ldc_w 2384
    //   1036: ldc_w 2394
    //   1039: invokestatic 1964	ajjy:a	(I)Ljava/lang/String;
    //   1042: invokevirtual 2378	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1045: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1048: pop
    //   1049: goto -65 -> 984
    //   1052: ldc_w 2396
    //   1055: aload 4
    //   1057: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1060: ifeq +50 -> 1110
    //   1063: new 109	org/json/JSONObject
    //   1066: dup
    //   1067: aload 5
    //   1069: iconst_0
    //   1070: aaload
    //   1071: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1074: ldc_w 1435
    //   1077: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1080: astore_1
    //   1081: aload_1
    //   1082: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1085: ifne -901 -> 184
    //   1088: aload_0
    //   1089: aload_0
    //   1090: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1093: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   1096: aload_1
    //   1097: invokestatic 2401	arjc:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/app/ProgressDialog;
    //   1100: putfield 2403	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1103: goto -919 -> 184
    //   1106: astore_1
    //   1107: goto -923 -> 184
    //   1110: ldc_w 2405
    //   1113: aload 4
    //   1115: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1118: ifeq +52 -> 1170
    //   1121: aload_0
    //   1122: getfield 2403	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1125: ifnull -941 -> 184
    //   1128: aload_0
    //   1129: getfield 2403	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1132: invokevirtual 2406	android/app/ProgressDialog:isShowing	()Z
    //   1135: ifeq -951 -> 184
    //   1138: aload_0
    //   1139: getfield 2403	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1142: invokevirtual 1999	android/app/ProgressDialog:dismiss	()V
    //   1145: aload_0
    //   1146: aconst_null
    //   1147: putfield 2403	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1150: goto -966 -> 184
    //   1153: astore_1
    //   1154: aload_0
    //   1155: aconst_null
    //   1156: putfield 2403	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1159: goto -975 -> 184
    //   1162: astore_1
    //   1163: aload_0
    //   1164: aconst_null
    //   1165: putfield 2403	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1168: aload_1
    //   1169: athrow
    //   1170: ldc_w 2408
    //   1173: aload 4
    //   1175: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1178: ifeq +41 -> 1219
    //   1181: aload 5
    //   1183: arraylength
    //   1184: iconst_1
    //   1185: if_icmpne -1001 -> 184
    //   1188: aload_1
    //   1189: getfield 2411	com/tencent/mobileqq/webview/swift/JsBridgeListener:jdField_a_of_type_Boolean	Z
    //   1192: ifeq +15 -> 1207
    //   1195: aload_0
    //   1196: aload 5
    //   1198: iconst_0
    //   1199: aaload
    //   1200: iconst_1
    //   1201: invokevirtual 2413	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   1204: goto -1020 -> 184
    //   1207: aload_0
    //   1208: aload 5
    //   1210: iconst_0
    //   1211: aaload
    //   1212: iconst_0
    //   1213: invokevirtual 2413	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   1216: goto -1032 -> 184
    //   1219: ldc_w 2415
    //   1222: aload 4
    //   1224: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1227: ifeq +50 -> 1277
    //   1230: aload_0
    //   1231: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1234: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   1237: instanceof 2417
    //   1240: ifeq +26 -> 1266
    //   1243: aload_1
    //   1244: aload_0
    //   1245: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1248: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   1251: checkcast 2417	mqq/app/AppActivity
    //   1254: invokevirtual 2420	mqq/app/AppActivity:isResume	()Z
    //   1257: invokestatic 857	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1260: invokevirtual 2423	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1263: goto -1079 -> 184
    //   1266: aload_1
    //   1267: iconst_0
    //   1268: invokestatic 857	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1271: invokevirtual 2423	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1274: goto -1090 -> 184
    //   1277: ldc_w 2425
    //   1280: aload 4
    //   1282: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1285: ifeq +50 -> 1335
    //   1288: aload 5
    //   1290: arraylength
    //   1291: iconst_1
    //   1292: if_icmpne +43 -> 1335
    //   1295: aload_0
    //   1296: new 109	org/json/JSONObject
    //   1299: dup
    //   1300: aload 5
    //   1302: iconst_0
    //   1303: aaload
    //   1304: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1307: aload_1
    //   1308: aconst_null
    //   1309: invokevirtual 1375	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Landroid/view/View$OnClickListener;)V
    //   1312: goto -1128 -> 184
    //   1315: astore_1
    //   1316: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1319: ifeq -1135 -> 184
    //   1322: ldc 191
    //   1324: iconst_2
    //   1325: ldc_w 2427
    //   1328: aload_1
    //   1329: invokestatic 2370	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1332: goto -1148 -> 184
    //   1335: ldc_w 2429
    //   1338: aload 4
    //   1340: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1343: ifeq +119 -> 1462
    //   1346: aload 5
    //   1348: arraylength
    //   1349: iconst_1
    //   1350: if_icmpne +112 -> 1462
    //   1353: aload_0
    //   1354: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1357: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   1360: astore_2
    //   1361: aload_2
    //   1362: ifnull +16059 -> 17421
    //   1365: aload_2
    //   1366: invokevirtual 725	android/app/Activity:isFinishing	()Z
    //   1369: ifeq +6 -> 1375
    //   1372: goto +16049 -> 17421
    //   1375: new 109	org/json/JSONObject
    //   1378: dup
    //   1379: aload 5
    //   1381: iconst_0
    //   1382: aaload
    //   1383: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1386: astore_2
    //   1387: aload_0
    //   1388: aload_2
    //   1389: ldc_w 2431
    //   1392: invokevirtual 1204	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1395: invokevirtual 2433	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1398: aload_0
    //   1399: aload_2
    //   1400: ldc_w 2435
    //   1403: invokevirtual 1204	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1406: aload_1
    //   1407: invokevirtual 2437	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1410: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1413: ifeq -1229 -> 184
    //   1416: ldc 191
    //   1418: iconst_2
    //   1419: iconst_2
    //   1420: anewarray 843	java/lang/Object
    //   1423: dup
    //   1424: iconst_0
    //   1425: ldc_w 2429
    //   1428: aastore
    //   1429: dup
    //   1430: iconst_1
    //   1431: aload_2
    //   1432: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1435: aastore
    //   1436: invokestatic 2054	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1439: goto -1255 -> 184
    //   1442: astore_1
    //   1443: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1446: ifeq -1262 -> 184
    //   1449: ldc 191
    //   1451: iconst_2
    //   1452: ldc_w 2439
    //   1455: aload_1
    //   1456: invokestatic 2370	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1459: goto -1275 -> 184
    //   1462: ldc_w 2441
    //   1465: aload 4
    //   1467: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1470: ifeq +71 -> 1541
    //   1473: aload 5
    //   1475: arraylength
    //   1476: iconst_1
    //   1477: if_icmpne +64 -> 1541
    //   1480: aload_0
    //   1481: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1484: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   1487: astore_2
    //   1488: aload_2
    //   1489: ifnull +15934 -> 17423
    //   1492: aload_2
    //   1493: invokevirtual 725	android/app/Activity:isFinishing	()Z
    //   1496: ifeq +6 -> 1502
    //   1499: goto +15924 -> 17423
    //   1502: aload_0
    //   1503: new 109	org/json/JSONObject
    //   1506: dup
    //   1507: aload 5
    //   1509: iconst_0
    //   1510: aaload
    //   1511: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1514: aload_1
    //   1515: invokevirtual 2437	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1518: goto -1334 -> 184
    //   1521: astore_1
    //   1522: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1525: ifeq -1341 -> 184
    //   1528: ldc 191
    //   1530: iconst_2
    //   1531: ldc_w 2443
    //   1534: aload_1
    //   1535: invokestatic 2370	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1538: goto -1354 -> 184
    //   1541: ldc_w 2445
    //   1544: aload 4
    //   1546: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1549: ifeq +109 -> 1658
    //   1552: aload 5
    //   1554: arraylength
    //   1555: iconst_1
    //   1556: if_icmpne +102 -> 1658
    //   1559: aload_0
    //   1560: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1563: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   1566: astore_1
    //   1567: aload_1
    //   1568: ifnull +15857 -> 17425
    //   1571: aload_1
    //   1572: invokevirtual 725	android/app/Activity:isFinishing	()Z
    //   1575: ifeq +6 -> 1581
    //   1578: goto +15847 -> 17425
    //   1581: new 109	org/json/JSONObject
    //   1584: dup
    //   1585: aload 5
    //   1587: iconst_0
    //   1588: aaload
    //   1589: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1592: astore_1
    //   1593: aload_1
    //   1594: ldc_w 2447
    //   1597: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1600: istore 6
    //   1602: aload_1
    //   1603: ldc_w 2449
    //   1606: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1609: istore 12
    //   1611: aload_1
    //   1612: ldc_w 1380
    //   1615: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1618: astore_2
    //   1619: aload_0
    //   1620: iload 6
    //   1622: iload 12
    //   1624: aload_1
    //   1625: ldc_w 2451
    //   1628: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1631: aload_2
    //   1632: invokevirtual 2453	com/tencent/mobileqq/jsp/UiApiPlugin:a	(IZZLjava/lang/String;)V
    //   1635: goto -1451 -> 184
    //   1638: astore_1
    //   1639: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1642: ifeq -1458 -> 184
    //   1645: ldc 191
    //   1647: iconst_2
    //   1648: ldc_w 2443
    //   1651: aload_1
    //   1652: invokestatic 2370	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1655: goto -1471 -> 184
    //   1658: ldc_w 2227
    //   1661: aload 4
    //   1663: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1666: ifeq +70 -> 1736
    //   1669: aload 5
    //   1671: arraylength
    //   1672: iconst_1
    //   1673: if_icmpne +63 -> 1736
    //   1676: aload_0
    //   1677: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1680: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   1683: astore_1
    //   1684: aload_1
    //   1685: ifnull +15742 -> 17427
    //   1688: aload_1
    //   1689: invokevirtual 725	android/app/Activity:isFinishing	()Z
    //   1692: ifeq +6 -> 1698
    //   1695: goto +15732 -> 17427
    //   1698: aload_0
    //   1699: new 109	org/json/JSONObject
    //   1702: dup
    //   1703: aload 5
    //   1705: iconst_0
    //   1706: aaload
    //   1707: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1710: invokevirtual 2433	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1713: goto -1529 -> 184
    //   1716: astore_1
    //   1717: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1720: ifeq -1536 -> 184
    //   1723: ldc 191
    //   1725: iconst_2
    //   1726: ldc_w 2455
    //   1729: aload_1
    //   1730: invokestatic 2370	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1733: goto -1549 -> 184
    //   1736: ldc_w 2457
    //   1739: aload 4
    //   1741: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1744: ifeq +83 -> 1827
    //   1747: aload 5
    //   1749: arraylength
    //   1750: iconst_1
    //   1751: if_icmpne +76 -> 1827
    //   1754: aload_0
    //   1755: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1758: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   1761: astore_1
    //   1762: aload_1
    //   1763: ifnull +15666 -> 17429
    //   1766: aload_1
    //   1767: invokevirtual 725	android/app/Activity:isFinishing	()Z
    //   1770: ifeq +6 -> 1776
    //   1773: goto +15656 -> 17429
    //   1776: aload_0
    //   1777: new 109	org/json/JSONObject
    //   1780: dup
    //   1781: aload 5
    //   1783: iconst_0
    //   1784: aaload
    //   1785: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1788: invokevirtual 2459	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Lorg/json/JSONObject;)V
    //   1791: goto -1607 -> 184
    //   1794: astore_1
    //   1795: ldc 191
    //   1797: iconst_1
    //   1798: new 497	java/lang/StringBuilder
    //   1801: dup
    //   1802: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   1805: ldc_w 2461
    //   1808: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1811: aload_1
    //   1812: invokestatic 2464	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1815: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1821: invokestatic 613	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1824: goto -1640 -> 184
    //   1827: ldc_w 636
    //   1830: aload 4
    //   1832: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1835: ifeq +21 -> 1856
    //   1838: aload 5
    //   1840: arraylength
    //   1841: iconst_1
    //   1842: if_icmpne +14 -> 1856
    //   1845: aload_0
    //   1846: aload 5
    //   1848: iconst_0
    //   1849: aaload
    //   1850: invokevirtual 2465	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;)V
    //   1853: goto -1669 -> 184
    //   1856: ldc_w 2467
    //   1859: aload 4
    //   1861: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1864: ifeq +174 -> 2038
    //   1867: aload 5
    //   1869: arraylength
    //   1870: iconst_1
    //   1871: if_icmpne +167 -> 2038
    //   1874: new 109	org/json/JSONObject
    //   1877: dup
    //   1878: aload 5
    //   1880: iconst_0
    //   1881: aaload
    //   1882: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1885: astore_2
    //   1886: aload_2
    //   1887: ldc_w 2469
    //   1890: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1893: astore_1
    //   1894: aload_0
    //   1895: aload_2
    //   1896: ldc_w 1380
    //   1899: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1902: putfield 2470	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1905: aload_0
    //   1906: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1909: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1912: ifnonnull +5 -> 1917
    //   1915: iconst_1
    //   1916: ireturn
    //   1917: aload_0
    //   1918: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1921: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1924: invokevirtual 2033	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1927: astore_2
    //   1928: new 125	android/content/Intent
    //   1931: dup
    //   1932: aload_0
    //   1933: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1936: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   1939: ldc_w 2472
    //   1942: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1945: ldc 150
    //   1947: ldc_w 373
    //   1950: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1953: astore_3
    //   1954: aload_1
    //   1955: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1958: ifeq +48 -> 2006
    //   1961: aload_0
    //   1962: getfield 2470	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1965: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1968: ifeq +38 -> 2006
    //   1971: aload_3
    //   1972: ldc_w 2474
    //   1975: iconst_1
    //   1976: invokevirtual 553	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1979: pop
    //   1980: aload_0
    //   1981: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1984: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   1987: ifnonnull +5 -> 1992
    //   1990: iconst_1
    //   1991: ireturn
    //   1992: aload_0
    //   1993: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   1996: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   1999: aload_3
    //   2000: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2003: goto -1819 -> 184
    //   2006: aload_3
    //   2007: ldc_w 2469
    //   2010: aload_1
    //   2011: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2014: ldc_w 2476
    //   2017: aload_2
    //   2018: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2021: ldc_w 2478
    //   2024: iconst_1
    //   2025: invokevirtual 553	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2028: pop
    //   2029: aload_0
    //   2030: aload_3
    //   2031: iconst_3
    //   2032: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2035: goto -1851 -> 184
    //   2038: ldc_w 2480
    //   2041: aload 4
    //   2043: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2046: ifeq +243 -> 2289
    //   2049: aload 5
    //   2051: arraylength
    //   2052: iconst_1
    //   2053: if_icmpne +236 -> 2289
    //   2056: new 109	org/json/JSONObject
    //   2059: dup
    //   2060: aload 5
    //   2062: iconst_0
    //   2063: aaload
    //   2064: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2067: astore 4
    //   2069: aload 4
    //   2071: ldc_w 2469
    //   2074: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2077: astore_1
    //   2078: aload 4
    //   2080: ldc_w 2482
    //   2083: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2086: astore_2
    //   2087: aload 4
    //   2089: ldc 201
    //   2091: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2094: astore_3
    //   2095: aload_0
    //   2096: aload 4
    //   2098: ldc_w 1380
    //   2101: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2104: putfield 2484	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2107: aload_0
    //   2108: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2111: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2114: ifnonnull +5 -> 2119
    //   2117: iconst_1
    //   2118: ireturn
    //   2119: aload_0
    //   2120: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2123: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2126: invokevirtual 2033	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   2129: astore 4
    //   2131: new 125	android/content/Intent
    //   2134: dup
    //   2135: aload_0
    //   2136: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2139: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   2142: ldc_w 2486
    //   2145: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2148: ldc_w 2488
    //   2151: iconst_4
    //   2152: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2155: ldc_w 2489
    //   2158: invokevirtual 1327	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2161: astore 5
    //   2163: aload_1
    //   2164: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2167: ifeq +73 -> 2240
    //   2170: aload_0
    //   2171: getfield 2484	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2174: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2177: ifeq +63 -> 2240
    //   2180: aload_0
    //   2181: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2184: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   2187: ifnonnull +5 -> 2192
    //   2190: iconst_1
    //   2191: ireturn
    //   2192: aload_0
    //   2193: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2196: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   2199: aload 5
    //   2201: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2204: goto -2020 -> 184
    //   2207: astore_1
    //   2208: ldc 191
    //   2210: iconst_1
    //   2211: new 497	java/lang/StringBuilder
    //   2214: dup
    //   2215: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   2218: ldc_w 2491
    //   2221: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2224: aload_1
    //   2225: invokevirtual 968	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2228: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2231: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2234: invokestatic 613	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2237: goto -2053 -> 184
    //   2240: aload 5
    //   2242: ldc_w 2469
    //   2245: aload_1
    //   2246: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2249: ldc 201
    //   2251: aload_3
    //   2252: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2255: ldc_w 2482
    //   2258: aload_2
    //   2259: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2262: ldc_w 2476
    //   2265: aload 4
    //   2267: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2270: ldc_w 2478
    //   2273: iconst_1
    //   2274: invokevirtual 553	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2277: pop
    //   2278: aload_0
    //   2279: aload 5
    //   2281: bipush 17
    //   2283: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2286: goto -2102 -> 184
    //   2289: ldc_w 2493
    //   2292: aload 4
    //   2294: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2297: ifeq +102 -> 2399
    //   2300: aload 5
    //   2302: arraylength
    //   2303: iconst_1
    //   2304: if_icmpne +95 -> 2399
    //   2307: new 109	org/json/JSONObject
    //   2310: dup
    //   2311: aload 5
    //   2313: iconst_0
    //   2314: aaload
    //   2315: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2318: ldc_w 1380
    //   2321: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2324: astore_1
    //   2325: aload_0
    //   2326: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2329: aload_0
    //   2330: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2333: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   2336: invokevirtual 699	bbac:a	(Landroid/app/Activity;)Lbazo;
    //   2339: astore_2
    //   2340: aload_2
    //   2341: ifnull +23 -> 2364
    //   2344: aload_2
    //   2345: instanceof 1798
    //   2348: ifeq +16 -> 2364
    //   2351: aload_2
    //   2352: checkcast 1798	bber
    //   2355: invokeinterface 1801 1 0
    //   2360: aload_1
    //   2361: putfield 2496	xdt:u	Ljava/lang/String;
    //   2364: aload_1
    //   2365: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2368: ifne -2184 -> 184
    //   2371: aload_0
    //   2372: iconst_2
    //   2373: invokevirtual 2497	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   2376: checkcast 1396	bbcj
    //   2379: astore_1
    //   2380: aload_1
    //   2381: ifnull -2197 -> 184
    //   2384: aload_1
    //   2385: invokevirtual 2499	bbcj:g	()V
    //   2388: goto -2204 -> 184
    //   2391: astore_1
    //   2392: aload_1
    //   2393: invokevirtual 2502	org/json/JSONException:printStackTrace	()V
    //   2396: goto -2212 -> 184
    //   2399: ldc_w 2504
    //   2402: aload 4
    //   2404: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2407: ifeq +42 -> 2449
    //   2410: aload 5
    //   2412: arraylength
    //   2413: iconst_1
    //   2414: if_icmpne +35 -> 2449
    //   2417: aload_0
    //   2418: new 109	org/json/JSONObject
    //   2421: dup
    //   2422: aload 5
    //   2424: iconst_0
    //   2425: aaload
    //   2426: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2429: ldc_w 1380
    //   2432: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2435: putfield 2047	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2438: goto -2254 -> 184
    //   2441: astore_1
    //   2442: aload_1
    //   2443: invokevirtual 2502	org/json/JSONException:printStackTrace	()V
    //   2446: goto -2262 -> 184
    //   2449: ldc_w 2506
    //   2452: aload 4
    //   2454: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2457: ifeq +78 -> 2535
    //   2460: aload 5
    //   2462: arraylength
    //   2463: iconst_1
    //   2464: if_icmpne +71 -> 2535
    //   2467: new 109	org/json/JSONObject
    //   2470: dup
    //   2471: aload 5
    //   2473: iconst_0
    //   2474: aaload
    //   2475: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2478: ldc_w 1380
    //   2481: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2484: astore_1
    //   2485: aload_0
    //   2486: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2489: aload_0
    //   2490: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2493: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   2496: invokevirtual 699	bbac:a	(Landroid/app/Activity;)Lbazo;
    //   2499: astore_2
    //   2500: aload_2
    //   2501: ifnull -2317 -> 184
    //   2504: aload_2
    //   2505: instanceof 1798
    //   2508: ifeq -2324 -> 184
    //   2511: aload_2
    //   2512: checkcast 1798	bber
    //   2515: invokeinterface 1801 1 0
    //   2520: aload_1
    //   2521: invokevirtual 2507	xdt:a	(Ljava/lang/String;)V
    //   2524: goto -2340 -> 184
    //   2527: astore_1
    //   2528: aload_1
    //   2529: invokevirtual 2502	org/json/JSONException:printStackTrace	()V
    //   2532: goto -2348 -> 184
    //   2535: ldc_w 2509
    //   2538: aload 4
    //   2540: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2543: ifeq +111 -> 2654
    //   2546: aload 5
    //   2548: arraylength
    //   2549: iconst_1
    //   2550: if_icmpne +104 -> 2654
    //   2553: new 109	org/json/JSONObject
    //   2556: dup
    //   2557: aload 5
    //   2559: iconst_0
    //   2560: aaload
    //   2561: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2564: ldc_w 1380
    //   2567: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2570: astore_1
    //   2571: aload_0
    //   2572: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2575: aload_0
    //   2576: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2579: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   2582: invokevirtual 699	bbac:a	(Landroid/app/Activity;)Lbazo;
    //   2585: astore_2
    //   2586: aload_2
    //   2587: ifnull +23 -> 2610
    //   2590: aload_2
    //   2591: instanceof 1798
    //   2594: ifeq +16 -> 2610
    //   2597: aload_2
    //   2598: checkcast 1798	bber
    //   2601: invokeinterface 1801 1 0
    //   2606: aload_1
    //   2607: putfield 2511	xdt:q	Ljava/lang/String;
    //   2610: aconst_null
    //   2611: ldc_w 367
    //   2614: ldc_w 2513
    //   2617: ldc_w 371
    //   2620: ldc_w 2515
    //   2623: ldc_w 2515
    //   2626: iconst_0
    //   2627: iconst_0
    //   2628: ldc_w 371
    //   2631: ldc_w 371
    //   2634: ldc_w 371
    //   2637: ldc_w 371
    //   2640: invokestatic 824	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2643: goto -2459 -> 184
    //   2646: astore_1
    //   2647: aload_1
    //   2648: invokevirtual 2502	org/json/JSONException:printStackTrace	()V
    //   2651: goto -41 -> 2610
    //   2654: ldc_w 2517
    //   2657: aload 4
    //   2659: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2662: ifeq +111 -> 2773
    //   2665: aload 5
    //   2667: arraylength
    //   2668: iconst_1
    //   2669: if_icmpne +104 -> 2773
    //   2672: new 109	org/json/JSONObject
    //   2675: dup
    //   2676: aload 5
    //   2678: iconst_0
    //   2679: aaload
    //   2680: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2683: ldc_w 1380
    //   2686: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2689: astore_1
    //   2690: aload_0
    //   2691: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2694: aload_0
    //   2695: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2698: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   2701: invokevirtual 699	bbac:a	(Landroid/app/Activity;)Lbazo;
    //   2704: astore_2
    //   2705: aload_2
    //   2706: ifnull +23 -> 2729
    //   2709: aload_2
    //   2710: instanceof 1798
    //   2713: ifeq +16 -> 2729
    //   2716: aload_2
    //   2717: checkcast 1798	bber
    //   2720: invokeinterface 1801 1 0
    //   2725: aload_1
    //   2726: putfield 2520	xdt:r	Ljava/lang/String;
    //   2729: aconst_null
    //   2730: ldc_w 367
    //   2733: ldc_w 2513
    //   2736: ldc_w 371
    //   2739: ldc_w 2522
    //   2742: ldc_w 2522
    //   2745: iconst_0
    //   2746: iconst_0
    //   2747: ldc_w 371
    //   2750: ldc_w 371
    //   2753: ldc_w 371
    //   2756: ldc_w 371
    //   2759: invokestatic 824	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2762: goto -2578 -> 184
    //   2765: astore_1
    //   2766: aload_1
    //   2767: invokevirtual 2502	org/json/JSONException:printStackTrace	()V
    //   2770: goto -41 -> 2729
    //   2773: ldc_w 2524
    //   2776: aload 4
    //   2778: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2781: ifeq +111 -> 2892
    //   2784: aload 5
    //   2786: arraylength
    //   2787: iconst_1
    //   2788: if_icmpne +104 -> 2892
    //   2791: new 109	org/json/JSONObject
    //   2794: dup
    //   2795: aload 5
    //   2797: iconst_0
    //   2798: aaload
    //   2799: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2802: ldc_w 1380
    //   2805: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2808: astore_1
    //   2809: aload_0
    //   2810: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2813: aload_0
    //   2814: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2817: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   2820: invokevirtual 699	bbac:a	(Landroid/app/Activity;)Lbazo;
    //   2823: astore_2
    //   2824: aload_2
    //   2825: ifnull +23 -> 2848
    //   2828: aload_2
    //   2829: instanceof 1798
    //   2832: ifeq +16 -> 2848
    //   2835: aload_2
    //   2836: checkcast 1798	bber
    //   2839: invokeinterface 1801 1 0
    //   2844: aload_1
    //   2845: putfield 2527	xdt:s	Ljava/lang/String;
    //   2848: aconst_null
    //   2849: ldc_w 367
    //   2852: ldc_w 2513
    //   2855: ldc_w 371
    //   2858: ldc_w 2529
    //   2861: ldc_w 2529
    //   2864: iconst_0
    //   2865: iconst_0
    //   2866: ldc_w 371
    //   2869: ldc_w 371
    //   2872: ldc_w 371
    //   2875: ldc_w 371
    //   2878: invokestatic 824	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2881: goto -2697 -> 184
    //   2884: astore_1
    //   2885: aload_1
    //   2886: invokevirtual 2502	org/json/JSONException:printStackTrace	()V
    //   2889: goto -41 -> 2848
    //   2892: ldc_w 2531
    //   2895: aload 4
    //   2897: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2900: ifeq +111 -> 3011
    //   2903: aload 5
    //   2905: arraylength
    //   2906: iconst_1
    //   2907: if_icmpne +104 -> 3011
    //   2910: new 109	org/json/JSONObject
    //   2913: dup
    //   2914: aload 5
    //   2916: iconst_0
    //   2917: aaload
    //   2918: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2921: ldc_w 1380
    //   2924: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2927: astore_1
    //   2928: aload_0
    //   2929: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2932: aload_0
    //   2933: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   2936: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   2939: invokevirtual 699	bbac:a	(Landroid/app/Activity;)Lbazo;
    //   2942: astore_2
    //   2943: aload_2
    //   2944: ifnull +23 -> 2967
    //   2947: aload_2
    //   2948: instanceof 1798
    //   2951: ifeq +16 -> 2967
    //   2954: aload_2
    //   2955: checkcast 1798	bber
    //   2958: invokeinterface 1801 1 0
    //   2963: aload_1
    //   2964: putfield 2534	xdt:t	Ljava/lang/String;
    //   2967: aconst_null
    //   2968: ldc_w 367
    //   2971: ldc_w 2513
    //   2974: ldc_w 371
    //   2977: ldc_w 2536
    //   2980: ldc_w 2536
    //   2983: iconst_0
    //   2984: iconst_0
    //   2985: ldc_w 371
    //   2988: ldc_w 371
    //   2991: ldc_w 371
    //   2994: ldc_w 371
    //   2997: invokestatic 824	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3000: goto -2816 -> 184
    //   3003: astore_1
    //   3004: aload_1
    //   3005: invokevirtual 2502	org/json/JSONException:printStackTrace	()V
    //   3008: goto -41 -> 2967
    //   3011: ldc_w 2538
    //   3014: aload 4
    //   3016: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3019: ifeq +301 -> 3320
    //   3022: aload 5
    //   3024: arraylength
    //   3025: iconst_1
    //   3026: if_icmpne +294 -> 3320
    //   3029: new 109	org/json/JSONObject
    //   3032: dup
    //   3033: aload 5
    //   3035: iconst_0
    //   3036: aaload
    //   3037: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3040: astore_3
    //   3041: aload_0
    //   3042: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   3045: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   3048: astore 5
    //   3050: aload 5
    //   3052: ifnull +14383 -> 17435
    //   3055: aload 5
    //   3057: invokevirtual 725	android/app/Activity:isFinishing	()Z
    //   3060: ifeq +6 -> 3066
    //   3063: goto +14372 -> 17435
    //   3066: aload_3
    //   3067: ldc_w 909
    //   3070: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3073: astore 14
    //   3075: aload_3
    //   3076: ldc_w 1435
    //   3079: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3082: astore 15
    //   3084: aload_3
    //   3085: ldc_w 2540
    //   3088: iconst_1
    //   3089: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3092: istore 12
    //   3094: aload_3
    //   3095: ldc_w 2542
    //   3098: iconst_1
    //   3099: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3102: istore 13
    //   3104: aload_3
    //   3105: ldc_w 2544
    //   3108: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3111: astore_2
    //   3112: aload_3
    //   3113: ldc_w 2546
    //   3116: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3119: astore_1
    //   3120: aload_3
    //   3121: ldc_w 1380
    //   3124: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3127: astore_3
    //   3128: aload 5
    //   3130: iconst_0
    //   3131: invokestatic 2551	babr:a	(Landroid/content/Context;I)Lbafb;
    //   3134: astore 4
    //   3136: aload 4
    //   3138: aload 14
    //   3140: invokevirtual 2557	bafb:setTitle	(Ljava/lang/String;)Lbafb;
    //   3143: pop
    //   3144: aload 4
    //   3146: aload 15
    //   3148: invokevirtual 2561	bafb:setMessage	(Ljava/lang/CharSequence;)Lbafb;
    //   3151: pop
    //   3152: aload 4
    //   3154: invokevirtual 2565	bafb:getMessageTextView	()Landroid/widget/TextView;
    //   3157: invokevirtual 2569	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   3160: astore 14
    //   3162: aload 14
    //   3164: instanceof 2571
    //   3167: ifeq +41 -> 3208
    //   3170: aload 14
    //   3172: checkcast 2571	android/view/ViewGroup$MarginLayoutParams
    //   3175: ldc_w 2572
    //   3178: invokestatic 2577	bajq:a	(F)I
    //   3181: putfield 2580	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   3184: aload 14
    //   3186: checkcast 2571	android/view/ViewGroup$MarginLayoutParams
    //   3189: ldc_w 2572
    //   3192: invokestatic 2577	bajq:a	(F)I
    //   3195: putfield 2581	android/view/ViewGroup$MarginLayoutParams:rightMargin	I
    //   3198: aload 4
    //   3200: invokevirtual 2565	bafb:getMessageTextView	()Landroid/widget/TextView;
    //   3203: aload 14
    //   3205: invokevirtual 2582	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   3208: new 2584	aqtk
    //   3211: dup
    //   3212: aload_0
    //   3213: aload_3
    //   3214: invokespecial 2585	aqtk:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   3217: astore 14
    //   3219: iload 13
    //   3221: ifeq +28 -> 3249
    //   3224: aload_1
    //   3225: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3228: ifeq +14180 -> 17408
    //   3231: aload 5
    //   3233: ldc_w 2586
    //   3236: invokevirtual 2240	android/app/Activity:getString	(I)Ljava/lang/String;
    //   3239: astore_1
    //   3240: aload 4
    //   3242: aload_1
    //   3243: aload 14
    //   3245: invokevirtual 2590	bafb:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbafb;
    //   3248: pop
    //   3249: iload 12
    //   3251: ifeq +28 -> 3279
    //   3254: aload_2
    //   3255: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3258: ifeq +14145 -> 17403
    //   3261: aload 5
    //   3263: ldc_w 2591
    //   3266: invokevirtual 2240	android/app/Activity:getString	(I)Ljava/lang/String;
    //   3269: astore_1
    //   3270: aload 4
    //   3272: aload_1
    //   3273: aload 14
    //   3275: invokevirtual 2594	bafb:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbafb;
    //   3278: pop
    //   3279: aload_3
    //   3280: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3283: ifne +17 -> 3300
    //   3286: aload 4
    //   3288: new 2596	aqtt
    //   3291: dup
    //   3292: aload_0
    //   3293: aload_3
    //   3294: invokespecial 2597	aqtt:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   3297: invokevirtual 2598	bafb:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   3300: aload 4
    //   3302: invokevirtual 2599	bafb:show	()V
    //   3305: goto -3121 -> 184
    //   3308: astore_1
    //   3309: goto -3125 -> 184
    //   3312: astore_1
    //   3313: aload_1
    //   3314: invokevirtual 2502	org/json/JSONException:printStackTrace	()V
    //   3317: goto -3133 -> 184
    //   3320: ldc_w 2601
    //   3323: aload 4
    //   3325: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3328: ifeq +399 -> 3727
    //   3331: aload 5
    //   3333: arraylength
    //   3334: iconst_1
    //   3335: if_icmpne +392 -> 3727
    //   3338: new 109	org/json/JSONObject
    //   3341: dup
    //   3342: aload 5
    //   3344: iconst_0
    //   3345: aaload
    //   3346: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3349: astore_2
    //   3350: aload_2
    //   3351: ldc_w 2603
    //   3354: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3357: astore_3
    //   3358: aload_2
    //   3359: ldc_w 2605
    //   3362: invokevirtual 1204	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3365: astore_2
    //   3366: ldc_w 2607
    //   3369: aload_3
    //   3370: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3373: ifeq +106 -> 3479
    //   3376: aload_2
    //   3377: ldc_w 2299
    //   3380: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3383: astore_2
    //   3384: aload_2
    //   3385: invokestatic 2306	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3388: ifeq +66 -> 3454
    //   3391: new 125	android/content/Intent
    //   3394: dup
    //   3395: invokespecial 227	android/content/Intent:<init>	()V
    //   3398: astore_3
    //   3399: aload_3
    //   3400: getstatic 2610	cooperation/troop/TroopFileProxyActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3403: aload_2
    //   3404: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3407: pop
    //   3408: aload_0
    //   3409: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   3412: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   3415: aload_3
    //   3416: aload_0
    //   3417: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   3420: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   3423: invokevirtual 1698	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3426: invokestatic 2613	cooperation/troop/TroopFileProxyActivity:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)V
    //   3429: aload_1
    //   3430: ldc_w 2615
    //   3433: invokevirtual 2423	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3436: goto -3252 -> 184
    //   3439: astore_2
    //   3440: aload_2
    //   3441: invokevirtual 2502	org/json/JSONException:printStackTrace	()V
    //   3444: aload_1
    //   3445: ldc_w 2617
    //   3448: invokevirtual 2423	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3451: goto -3267 -> 184
    //   3454: aload_1
    //   3455: ldc_w 2617
    //   3458: invokevirtual 2423	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3461: goto -3277 -> 184
    //   3464: astore_2
    //   3465: aload_2
    //   3466: invokevirtual 2618	java/lang/Exception:printStackTrace	()V
    //   3469: aload_1
    //   3470: ldc_w 2617
    //   3473: invokevirtual 2423	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3476: goto -3292 -> 184
    //   3479: ldc_w 2620
    //   3482: aload_3
    //   3483: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3486: ifeq +71 -> 3557
    //   3489: aload_2
    //   3490: ldc_w 2299
    //   3493: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3496: astore_2
    //   3497: aload_2
    //   3498: invokestatic 2306	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3501: ifeq +46 -> 3547
    //   3504: invokestatic 2625	bfpy:a	()Lbfpy;
    //   3507: astore_3
    //   3508: aload_3
    //   3509: aload_0
    //   3510: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   3513: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   3516: invokevirtual 1698	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3519: putfield 2626	bfpy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3522: aload_0
    //   3523: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   3526: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   3529: aload_3
    //   3530: aload_2
    //   3531: aconst_null
    //   3532: iconst_0
    //   3533: iconst_0
    //   3534: invokestatic 2631	bfpr:a	(Landroid/app/Activity;Lbfpy;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3537: aload_1
    //   3538: ldc_w 2615
    //   3541: invokevirtual 2423	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3544: goto -3360 -> 184
    //   3547: aload_1
    //   3548: ldc_w 2617
    //   3551: invokevirtual 2423	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3554: goto -3370 -> 184
    //   3557: ldc_w 2633
    //   3560: aload_3
    //   3561: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3564: ifeq +66 -> 3630
    //   3567: aload_0
    //   3568: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   3571: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   3574: astore_3
    //   3575: aload_2
    //   3576: ldc_w 2299
    //   3579: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3582: astore_2
    //   3583: aload_3
    //   3584: ifnull -3400 -> 184
    //   3587: aload_2
    //   3588: invokestatic 2306	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3591: ifeq -3407 -> 184
    //   3594: new 125	android/content/Intent
    //   3597: dup
    //   3598: aload_3
    //   3599: ldc_w 2635
    //   3602: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3605: astore 4
    //   3607: aload 4
    //   3609: ldc_w 1716
    //   3612: aload_2
    //   3613: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3616: pop
    //   3617: aload_3
    //   3618: aload 4
    //   3620: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3623: aload_3
    //   3624: invokevirtual 241	android/app/Activity:finish	()V
    //   3627: goto -3443 -> 184
    //   3630: ldc_w 2637
    //   3633: aload_3
    //   3634: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3637: ifeq -3453 -> 184
    //   3640: aload_0
    //   3641: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   3644: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   3647: astore_3
    //   3648: aload_2
    //   3649: ldc_w 2299
    //   3652: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3655: astore 4
    //   3657: aload_2
    //   3658: ldc_w 2301
    //   3661: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3664: astore_2
    //   3665: aload_3
    //   3666: ifnull -3482 -> 184
    //   3669: aload 4
    //   3671: invokestatic 2306	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3674: ifeq -3490 -> 184
    //   3677: aload_2
    //   3678: invokestatic 2306	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3681: ifeq -3497 -> 184
    //   3684: new 125	android/content/Intent
    //   3687: dup
    //   3688: aload_3
    //   3689: ldc_w 2308
    //   3692: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3695: astore 5
    //   3697: aload 5
    //   3699: ldc_w 1716
    //   3702: aload 4
    //   3704: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3707: pop
    //   3708: aload 5
    //   3710: ldc_w 2301
    //   3713: aload_2
    //   3714: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3717: pop
    //   3718: aload_3
    //   3719: aload 5
    //   3721: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3724: goto -3540 -> 184
    //   3727: ldc_w 2638
    //   3730: aload 4
    //   3732: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3735: ifeq +874 -> 4609
    //   3738: aload 5
    //   3740: arraylength
    //   3741: iconst_1
    //   3742: if_icmpne +867 -> 4609
    //   3745: aload_0
    //   3746: ldc_w 371
    //   3749: putfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3752: new 109	org/json/JSONObject
    //   3755: dup
    //   3756: aload 5
    //   3758: iconst_0
    //   3759: aaload
    //   3760: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3763: astore_1
    //   3764: aload_1
    //   3765: ifnull +826 -> 4591
    //   3768: aload_0
    //   3769: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   3772: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   3775: astore_3
    //   3776: aload_1
    //   3777: ldc_w 2642
    //   3780: ldc_w 2644
    //   3783: invokevirtual 2378	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3786: astore 14
    //   3788: aload_1
    //   3789: ldc_w 2469
    //   3792: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3795: astore 4
    //   3797: aload_1
    //   3798: ldc_w 1071
    //   3801: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3804: astore 15
    //   3806: aload_1
    //   3807: ldc_w 2646
    //   3810: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3813: astore 5
    //   3815: aload_1
    //   3816: ldc_w 1380
    //   3819: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3822: astore_2
    //   3823: aload_1
    //   3824: ldc_w 1193
    //   3827: iconst_m1
    //   3828: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3831: istore 6
    //   3833: new 109	org/json/JSONObject
    //   3836: dup
    //   3837: aload 15
    //   3839: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3842: astore_1
    //   3843: aload_0
    //   3844: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   3847: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   3850: astore 15
    //   3852: aload 15
    //   3854: ifnull +16 -> 3870
    //   3857: aload_1
    //   3858: ldc_w 2648
    //   3861: aload 15
    //   3863: invokevirtual 1219	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   3866: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3869: pop
    //   3870: ldc_w 2650
    //   3873: aload 14
    //   3875: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3878: ifeq +164 -> 4042
    //   3881: new 400	android/os/Bundle
    //   3884: dup
    //   3885: invokespecial 870	android/os/Bundle:<init>	()V
    //   3888: astore_2
    //   3889: aload_2
    //   3890: ldc_w 1071
    //   3893: aload_1
    //   3894: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3897: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3900: aload_2
    //   3901: ldc_w 2646
    //   3904: aload 5
    //   3906: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3909: ldc_w 2652
    //   3912: aload 4
    //   3914: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3917: ifeq +95 -> 4012
    //   3920: new 2654	aydq
    //   3923: dup
    //   3924: aload_3
    //   3925: checkcast 2656	com/tencent/mobileqq/app/BaseActivity
    //   3928: aload_2
    //   3929: invokespecial 2659	aydq:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   3932: aload_3
    //   3933: invokevirtual 2661	aydq:a	(Landroid/app/Activity;)V
    //   3936: goto -3752 -> 184
    //   3939: astore_1
    //   3940: ldc_w 371
    //   3943: astore_2
    //   3944: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3947: ifeq +22 -> 3969
    //   3950: ldc 191
    //   3952: iconst_2
    //   3953: ldc_w 2663
    //   3956: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3959: ldc 191
    //   3961: iconst_2
    //   3962: aload_1
    //   3963: invokestatic 459	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3966: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3969: aload_2
    //   3970: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3973: ifne -3789 -> 184
    //   3976: aload_0
    //   3977: aload_2
    //   3978: iconst_1
    //   3979: anewarray 334	java/lang/String
    //   3982: dup
    //   3983: iconst_0
    //   3984: ldc_w 2665
    //   3987: aastore
    //   3988: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3991: goto -3807 -> 184
    //   3994: astore_1
    //   3995: aconst_null
    //   3996: astore_1
    //   3997: goto -233 -> 3764
    //   4000: astore_1
    //   4001: new 109	org/json/JSONObject
    //   4004: dup
    //   4005: invokespecial 168	org/json/JSONObject:<init>	()V
    //   4008: astore_1
    //   4009: goto -166 -> 3843
    //   4012: ldc_w 2667
    //   4015: aload 4
    //   4017: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4020: ifeq -3836 -> 184
    //   4023: new 2669	ayfn
    //   4026: dup
    //   4027: aload_3
    //   4028: checkcast 2656	com/tencent/mobileqq/app/BaseActivity
    //   4031: aload_2
    //   4032: invokespecial 2670	ayfn:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   4035: aload_3
    //   4036: invokevirtual 2671	ayfn:a	(Landroid/app/Activity;)V
    //   4039: goto -3855 -> 184
    //   4042: ldc_w 2644
    //   4045: aload 14
    //   4047: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4050: ifeq +331 -> 4381
    //   4053: new 125	android/content/Intent
    //   4056: dup
    //   4057: invokespecial 227	android/content/Intent:<init>	()V
    //   4060: astore 14
    //   4062: ldc_w 2673
    //   4065: aload 4
    //   4067: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4070: ifeq +119 -> 4189
    //   4073: aload 14
    //   4075: new 2675	android/content/ComponentName
    //   4078: dup
    //   4079: aload_0
    //   4080: invokevirtual 1835	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   4083: aload 4
    //   4085: invokespecial 2676	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4088: invokevirtual 2680	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4091: pop
    //   4092: aload 14
    //   4094: ldc_w 2682
    //   4097: invokestatic 1124	java/lang/System:currentTimeMillis	()J
    //   4100: invokevirtual 1340	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   4103: pop
    //   4104: aload 14
    //   4106: ldc_w 1071
    //   4109: aload_1
    //   4110: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4113: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4116: pop
    //   4117: aload_0
    //   4118: aload 5
    //   4120: putfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4123: aload 5
    //   4125: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4128: ifeq +208 -> 4336
    //   4131: aload_3
    //   4132: aload 14
    //   4134: invokevirtual 815	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   4137: goto +13300 -> 17437
    //   4140: ldc_w 2684
    //   4143: invokevirtual 138	java/lang/Class:getName	()Ljava/lang/String;
    //   4146: aload 4
    //   4148: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4151: ifeq -3967 -> 184
    //   4154: aload_0
    //   4155: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   4158: ifnonnull +17 -> 4175
    //   4161: aload_0
    //   4162: invokestatic 1679	wis:a	()Lwis;
    //   4165: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   4168: aload_0
    //   4169: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   4172: invokevirtual 1680	wis:a	()V
    //   4175: aload_0
    //   4176: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   4179: invokevirtual 2686	wis:c	()V
    //   4182: goto -3998 -> 184
    //   4185: astore_1
    //   4186: goto -242 -> 3944
    //   4189: ldc_w 2688
    //   4192: aload 4
    //   4194: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4197: ifeq +78 -> 4275
    //   4200: aload 14
    //   4202: new 2675	android/content/ComponentName
    //   4205: dup
    //   4206: aload_3
    //   4207: aload 4
    //   4209: invokespecial 2676	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4212: invokevirtual 2680	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4215: pop
    //   4216: aload 14
    //   4218: ldc_w 2690
    //   4221: iconst_0
    //   4222: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4225: pop
    //   4226: aload 14
    //   4228: ldc_w 1115
    //   4231: invokestatic 1124	java/lang/System:currentTimeMillis	()J
    //   4234: invokevirtual 1340	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   4237: pop
    //   4238: aload 14
    //   4240: getstatic 2694	bfka:l	Ljava/lang/String;
    //   4243: iconst_1
    //   4244: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4247: pop
    //   4248: aload 14
    //   4250: getstatic 2695	bfka:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   4253: ldc_w 2064
    //   4256: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4259: pop
    //   4260: aload 14
    //   4262: getstatic 2696	bfka:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4265: ldc_w 2469
    //   4268: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4271: pop
    //   4272: goto -168 -> 4104
    //   4275: ldc_w 2698
    //   4278: aload 4
    //   4280: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4283: ifeq +34 -> 4317
    //   4286: aload 14
    //   4288: new 2675	android/content/ComponentName
    //   4291: dup
    //   4292: aload_3
    //   4293: aload 4
    //   4295: invokespecial 2676	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4298: invokevirtual 2680	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4301: pop
    //   4302: aload 14
    //   4304: ldc_w 2700
    //   4307: ldc_w 1842
    //   4310: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4313: pop
    //   4314: goto -210 -> 4104
    //   4317: aload 14
    //   4319: new 2675	android/content/ComponentName
    //   4322: dup
    //   4323: aload_3
    //   4324: aload 4
    //   4326: invokespecial 2676	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4329: invokevirtual 2680	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4332: pop
    //   4333: goto -229 -> 4104
    //   4336: aload_0
    //   4337: aload 14
    //   4339: iconst_4
    //   4340: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4343: aload_2
    //   4344: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4347: ifne +13090 -> 17437
    //   4350: aload_0
    //   4351: aload_2
    //   4352: iconst_1
    //   4353: anewarray 334	java/lang/String
    //   4356: dup
    //   4357: iconst_0
    //   4358: ldc_w 634
    //   4361: aastore
    //   4362: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4365: goto +13072 -> 17437
    //   4368: aload_3
    //   4369: ldc_w 2701
    //   4372: ldc_w 2702
    //   4375: invokevirtual 1196	android/app/Activity:overridePendingTransition	(II)V
    //   4378: goto -238 -> 4140
    //   4381: ldc_w 2704
    //   4384: aload 14
    //   4386: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4389: ifeq -4205 -> 184
    //   4392: aload 4
    //   4394: ldc_w 2706
    //   4397: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4400: ifeq +88 -> 4488
    //   4403: aload_1
    //   4404: ldc_w 2708
    //   4407: iconst_0
    //   4408: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4411: iconst_1
    //   4412: if_icmpne -4228 -> 184
    //   4415: aload_0
    //   4416: aload 5
    //   4418: putfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4421: aload_1
    //   4422: ldc 150
    //   4424: ldc_w 371
    //   4427: invokevirtual 2378	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4430: astore_2
    //   4431: aload_0
    //   4432: aload_3
    //   4433: aload_0
    //   4434: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   4437: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   4440: aload_1
    //   4441: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4444: iconst_4
    //   4445: aload_2
    //   4446: invokestatic 2713	aybu:a	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;BLjava/lang/String;)V
    //   4449: aload_3
    //   4450: ldc_w 2701
    //   4453: ldc_w 2702
    //   4456: invokevirtual 1196	android/app/Activity:overridePendingTransition	(II)V
    //   4459: ldc_w 371
    //   4462: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4465: ifne -4281 -> 184
    //   4468: aload_0
    //   4469: ldc_w 371
    //   4472: iconst_1
    //   4473: anewarray 334	java/lang/String
    //   4476: dup
    //   4477: iconst_0
    //   4478: ldc_w 634
    //   4481: aastore
    //   4482: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4485: goto -4301 -> 184
    //   4488: aload 4
    //   4490: ldc_w 2715
    //   4493: invokevirtual 138	java/lang/Class:getName	()Ljava/lang/String;
    //   4496: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4499: ifeq -4315 -> 184
    //   4502: new 125	android/content/Intent
    //   4505: dup
    //   4506: invokespecial 227	android/content/Intent:<init>	()V
    //   4509: astore 14
    //   4511: aload 14
    //   4513: new 2675	android/content/ComponentName
    //   4516: dup
    //   4517: aload_3
    //   4518: aload 4
    //   4520: invokespecial 2676	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4523: invokevirtual 2680	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4526: pop
    //   4527: aload 14
    //   4529: ldc_w 1071
    //   4532: aload_1
    //   4533: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4536: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4539: pop
    //   4540: aload_0
    //   4541: aload 5
    //   4543: putfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4546: aload_0
    //   4547: aload 14
    //   4549: iconst_4
    //   4550: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4553: aload_2
    //   4554: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4557: ifne +12902 -> 17459
    //   4560: aload_0
    //   4561: aload_2
    //   4562: iconst_1
    //   4563: anewarray 334	java/lang/String
    //   4566: dup
    //   4567: iconst_0
    //   4568: ldc_w 634
    //   4571: aastore
    //   4572: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4575: goto +12884 -> 17459
    //   4578: aload_3
    //   4579: ldc_w 2701
    //   4582: ldc_w 2702
    //   4585: invokevirtual 1196	android/app/Activity:overridePendingTransition	(II)V
    //   4588: goto -4404 -> 184
    //   4591: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4594: ifeq -4410 -> 184
    //   4597: ldc 191
    //   4599: iconst_2
    //   4600: ldc_w 2717
    //   4603: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4606: goto -4422 -> 184
    //   4609: ldc_w 2719
    //   4612: aload 4
    //   4614: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4617: ifeq +1942 -> 6559
    //   4620: aload 5
    //   4622: arraylength
    //   4623: iconst_1
    //   4624: if_icmpne +1935 -> 6559
    //   4627: new 109	org/json/JSONObject
    //   4630: dup
    //   4631: aload 5
    //   4633: iconst_0
    //   4634: aaload
    //   4635: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4638: astore_2
    //   4639: aload_0
    //   4640: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   4643: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   4646: astore 4
    //   4648: aload 4
    //   4650: instanceof 1181
    //   4653: ifne +5 -> 4658
    //   4656: iconst_1
    //   4657: ireturn
    //   4658: aload_0
    //   4659: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   4662: invokevirtual 1512	bbac:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4665: astore_3
    //   4666: aload_3
    //   4667: ifnonnull +5 -> 4672
    //   4670: iconst_1
    //   4671: ireturn
    //   4672: aload_2
    //   4673: ldc_w 2721
    //   4676: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4679: ifeq +103 -> 4782
    //   4682: aload_2
    //   4683: ldc_w 2723
    //   4686: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4689: ifeq +93 -> 4782
    //   4692: aload_2
    //   4693: ldc_w 2723
    //   4696: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4699: ifeq +83 -> 4782
    //   4702: aload_2
    //   4703: ldc_w 2721
    //   4706: invokestatic 2725	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4709: istore 6
    //   4711: aload_0
    //   4712: iconst_2
    //   4713: invokespecial 1394	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4716: checkcast 1396	bbcj
    //   4719: astore_1
    //   4720: aload_1
    //   4721: ifnull +25 -> 4746
    //   4724: aload_1
    //   4725: getfield 2726	bbcj:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   4728: ifnull +18 -> 4746
    //   4731: aload_1
    //   4732: iload 6
    //   4734: putfield 2727	bbcj:jdField_a_of_type_Int	I
    //   4737: aload_1
    //   4738: getfield 2726	bbcj:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   4741: iload 6
    //   4743: invokevirtual 2728	android/view/View:setBackgroundColor	(I)V
    //   4746: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4749: ifeq +33 -> 4782
    //   4752: ldc 191
    //   4754: iconst_2
    //   4755: new 497	java/lang/StringBuilder
    //   4758: dup
    //   4759: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   4762: ldc_w 2730
    //   4765: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4768: iload 6
    //   4770: invokestatic 2733	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   4773: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4776: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4779: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4782: aload_2
    //   4783: ldc_w 2735
    //   4786: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4789: ifeq +71 -> 4860
    //   4792: aload_2
    //   4793: ldc_w 2735
    //   4796: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4799: istore 12
    //   4801: iload 12
    //   4803: ifne +57 -> 4860
    //   4806: aload_0
    //   4807: iconst_2
    //   4808: invokespecial 1394	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4811: checkcast 1396	bbcj
    //   4814: astore_1
    //   4815: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4818: ifeq +30 -> 4848
    //   4821: ldc 191
    //   4823: iconst_2
    //   4824: new 497	java/lang/StringBuilder
    //   4827: dup
    //   4828: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   4831: ldc_w 2737
    //   4834: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4837: iload 12
    //   4839: invokevirtual 2740	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4842: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4845: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4848: aload_1
    //   4849: ifnull +11 -> 4860
    //   4852: aload_1
    //   4853: getfield 2743	bbcj:jdField_a_of_type_Bbpa	Lbbpa;
    //   4856: iconst_0
    //   4857: invokevirtual 2746	bbpa:a	(Z)V
    //   4860: aload_2
    //   4861: ldc_w 2748
    //   4864: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4867: ifeq +72 -> 4939
    //   4870: aload_2
    //   4871: ldc_w 2748
    //   4874: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4877: istore 6
    //   4879: aload 4
    //   4881: ldc_w 2236
    //   4884: invokevirtual 730	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4887: checkcast 1470	android/widget/TextView
    //   4890: astore_1
    //   4891: aload 4
    //   4893: ldc_w 2749
    //   4896: invokevirtual 730	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4899: checkcast 708	android/widget/ImageView
    //   4902: astore 5
    //   4904: aload_1
    //   4905: ifnull +34 -> 4939
    //   4908: aload 5
    //   4910: ifnull +29 -> 4939
    //   4913: iload 6
    //   4915: iconst_1
    //   4916: if_icmpne +1104 -> 6020
    //   4919: aload 5
    //   4921: invokevirtual 712	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   4924: ifnull +1045 -> 5969
    //   4927: aload 5
    //   4929: iconst_0
    //   4930: invokevirtual 752	android/widget/ImageView:setVisibility	(I)V
    //   4933: aload_1
    //   4934: bipush 8
    //   4936: invokevirtual 2750	android/widget/TextView:setVisibility	(I)V
    //   4939: aload_2
    //   4940: ldc_w 2752
    //   4943: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4946: ifeq +23 -> 4969
    //   4949: aload_2
    //   4950: ldc_w 2752
    //   4953: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4956: iconst_1
    //   4957: if_icmpne +12526 -> 17483
    //   4960: iconst_1
    //   4961: istore 12
    //   4963: aload_3
    //   4964: iload 12
    //   4966: invokevirtual 2754	com/tencent/mobileqq/webview/swift/WebViewFragment:h	(Z)V
    //   4969: aload_2
    //   4970: ldc_w 2756
    //   4973: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4976: ifeq +129 -> 5105
    //   4979: aload_2
    //   4980: ldc_w 2758
    //   4983: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4986: ifeq +119 -> 5105
    //   4989: aload_2
    //   4990: ldc_w 2760
    //   4993: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4996: ifeq +109 -> 5105
    //   4999: aload_2
    //   5000: ldc_w 2762
    //   5003: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5006: ifeq +99 -> 5105
    //   5009: aload_2
    //   5010: ldc_w 2764
    //   5013: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5016: ifeq +89 -> 5105
    //   5019: aload_2
    //   5020: ldc_w 2756
    //   5023: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5026: astore_1
    //   5027: aload_2
    //   5028: ldc_w 2758
    //   5031: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   5034: istore 6
    //   5036: aload_2
    //   5037: ldc_w 2760
    //   5040: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   5043: istore 7
    //   5045: aload_2
    //   5046: ldc_w 2762
    //   5049: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   5052: istore 8
    //   5054: aload_2
    //   5055: ldc_w 2764
    //   5058: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   5061: istore 9
    //   5063: aload_3
    //   5064: getfield 2767	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bbcj	Lbbcj;
    //   5067: ifnull +38 -> 5105
    //   5070: aload_3
    //   5071: getfield 2767	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bbcj	Lbbcj;
    //   5074: getfield 2770	bbcj:c	Landroid/view/ViewGroup;
    //   5077: instanceof 1598
    //   5080: ifeq +25 -> 5105
    //   5083: aload_3
    //   5084: getfield 2767	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bbcj	Lbbcj;
    //   5087: getfield 2770	bbcj:c	Landroid/view/ViewGroup;
    //   5090: checkcast 1598	com/tencent/biz/ui/RefreshView
    //   5093: aload_1
    //   5094: iload 6
    //   5096: iload 7
    //   5098: iload 8
    //   5100: iload 9
    //   5102: invokevirtual 2773	com/tencent/biz/ui/RefreshView:a	(Ljava/lang/String;IIII)V
    //   5105: aload_2
    //   5106: ldc_w 2775
    //   5109: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5112: ifeq +45 -> 5157
    //   5115: aload_2
    //   5116: ldc_w 2775
    //   5119: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5122: astore_1
    //   5123: aload_3
    //   5124: getfield 2767	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bbcj	Lbbcj;
    //   5127: ifnull +30 -> 5157
    //   5130: aload_3
    //   5131: getfield 2767	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bbcj	Lbbcj;
    //   5134: getfield 2770	bbcj:c	Landroid/view/ViewGroup;
    //   5137: instanceof 1598
    //   5140: ifeq +17 -> 5157
    //   5143: aload_3
    //   5144: getfield 2767	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bbcj	Lbbcj;
    //   5147: getfield 2770	bbcj:c	Landroid/view/ViewGroup;
    //   5150: checkcast 1598	com/tencent/biz/ui/RefreshView
    //   5153: aload_1
    //   5154: invokevirtual 2776	com/tencent/biz/ui/RefreshView:a	(Ljava/lang/String;)V
    //   5157: aload_3
    //   5158: invokevirtual 2778	com/tencent/mobileqq/webview/swift/WebViewFragment:f	()Z
    //   5161: ifne +146 -> 5307
    //   5164: aload_2
    //   5165: ldc_w 2780
    //   5168: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5171: ifeq +136 -> 5307
    //   5174: aload_2
    //   5175: ldc_w 2780
    //   5178: invokestatic 2725	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5181: istore 7
    //   5183: aload 4
    //   5185: ldc_w 726
    //   5188: invokevirtual 730	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   5191: astore 5
    //   5193: aload 5
    //   5195: ifnull +112 -> 5307
    //   5198: aconst_null
    //   5199: astore_1
    //   5200: aload_0
    //   5201: invokevirtual 2782	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbbeq;
    //   5204: ifnull +832 -> 6036
    //   5207: aload_0
    //   5208: invokevirtual 2782	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbbeq;
    //   5211: invokeinterface 2785 1 0
    //   5216: astore_1
    //   5217: iload 7
    //   5219: iconst_m1
    //   5220: if_icmpne +916 -> 6136
    //   5223: aload 5
    //   5225: invokevirtual 2788	android/view/View:getPaddingTop	()I
    //   5228: istore 6
    //   5230: aload 5
    //   5232: invokevirtual 2791	android/view/View:getPaddingBottom	()I
    //   5235: istore 7
    //   5237: aload 5
    //   5239: invokevirtual 2794	android/view/View:getPaddingLeft	()I
    //   5242: istore 8
    //   5244: aload 5
    //   5246: invokevirtual 2797	android/view/View:getPaddingRight	()I
    //   5249: istore 9
    //   5251: aload 5
    //   5253: ldc_w 2798
    //   5256: invokevirtual 2799	android/view/View:setBackgroundResource	(I)V
    //   5259: aload 5
    //   5261: iload 8
    //   5263: iload 6
    //   5265: iload 9
    //   5267: iload 7
    //   5269: invokevirtual 2802	android/view/View:setPadding	(IIII)V
    //   5272: aload_1
    //   5273: ifnull +7 -> 5280
    //   5276: aload_1
    //   5277: invokevirtual 2805	com/tencent/mobileqq/widget/WebViewProgressBar:a	()V
    //   5280: aload_3
    //   5281: getfield 2807	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5284: ifnull +23 -> 5307
    //   5287: aload_3
    //   5288: invokevirtual 2809	com/tencent/mobileqq/webview/swift/WebViewFragment:d	()Z
    //   5291: ifeq +769 -> 6060
    //   5294: aload_3
    //   5295: getfield 2807	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5298: iconst_4
    //   5299: invokevirtual 1524	android/view/View:setVisibility	(I)V
    //   5302: aload_3
    //   5303: iconst_0
    //   5304: invokevirtual 2811	com/tencent/mobileqq/webview/swift/WebViewFragment:j	(Z)V
    //   5307: aload_2
    //   5308: ldc_w 1390
    //   5311: iconst_m1
    //   5312: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5315: istore 6
    //   5317: aload_0
    //   5318: iconst_2
    //   5319: invokespecial 1394	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5322: checkcast 1396	bbcj
    //   5325: astore_1
    //   5326: iload 6
    //   5328: iflt +98 -> 5426
    //   5331: aload_1
    //   5332: ifnull +94 -> 5426
    //   5335: aload_1
    //   5336: getfield 1399	bbcj:jdField_a_of_type_Bbcm	Lbbcm;
    //   5339: astore 5
    //   5341: iconst_1
    //   5342: iload 6
    //   5344: if_icmpne +12145 -> 17489
    //   5347: iconst_1
    //   5348: istore 12
    //   5350: aload 5
    //   5352: iload 12
    //   5354: putfield 1404	bbcm:z	Z
    //   5357: aload_0
    //   5358: getfield 2160	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5361: ifeq +23 -> 5384
    //   5364: aload_1
    //   5365: aload_1
    //   5366: getfield 2812	bbcj:jdField_a_of_type_Bazb	Lbazb;
    //   5369: getfield 2149	bazb:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   5372: iconst_0
    //   5373: aload_0
    //   5374: getfield 2160	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5377: aload_0
    //   5378: getfield 2160	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5381: invokevirtual 2163	bbcj:a	(Landroid/view/View;ZII)V
    //   5384: aload_0
    //   5385: getfield 2173	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5388: ifeq +20 -> 5408
    //   5391: aload_1
    //   5392: aload_0
    //   5393: getfield 706	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   5396: iconst_0
    //   5397: aload_0
    //   5398: getfield 2173	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5401: aload_0
    //   5402: getfield 2173	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5405: invokevirtual 2163	bbcj:a	(Landroid/view/View;ZII)V
    //   5408: aload_1
    //   5409: aload_1
    //   5410: getfield 2812	bbcj:jdField_a_of_type_Bazb	Lbazb;
    //   5413: getfield 2090	bazb:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   5416: iconst_1
    //   5417: ldc_w 2813
    //   5420: ldc_w 2814
    //   5423: invokevirtual 2163	bbcj:a	(Landroid/view/View;ZII)V
    //   5426: aload_2
    //   5427: ldc_w 2816
    //   5430: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5433: ifeq +22 -> 5455
    //   5436: aload_2
    //   5437: ldc_w 2816
    //   5440: invokestatic 2725	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5443: istore 6
    //   5445: iload 6
    //   5447: iconst_m1
    //   5448: if_icmpne +939 -> 6387
    //   5451: aload_3
    //   5452: invokevirtual 2819	com/tencent/mobileqq/webview/swift/WebViewFragment:H	()V
    //   5455: aload_2
    //   5456: ldc_w 2821
    //   5459: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5462: ifeq +14 -> 5476
    //   5465: aload_3
    //   5466: aload_2
    //   5467: ldc_w 2821
    //   5470: invokevirtual 2824	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5473: invokevirtual 2825	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(Z)V
    //   5476: aload_2
    //   5477: ldc_w 2827
    //   5480: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5483: ifeq +25 -> 5508
    //   5486: aload_2
    //   5487: ldc_w 2827
    //   5490: invokevirtual 2824	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5493: ifeq +952 -> 6445
    //   5496: aload_3
    //   5497: aload_3
    //   5498: invokevirtual 2828	com/tencent/mobileqq/webview/swift/WebViewFragment:a	()J
    //   5501: ldc2_w 2829
    //   5504: land
    //   5505: invokevirtual 2832	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(J)V
    //   5508: aload_2
    //   5509: ldc_w 2834
    //   5512: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5515: ifeq +22 -> 5537
    //   5518: aload_2
    //   5519: ldc_w 2834
    //   5522: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5525: astore 5
    //   5527: aload 4
    //   5529: checkcast 1181	com/tencent/mobileqq/activity/QQBrowserActivity
    //   5532: aload 5
    //   5534: invokevirtual 2836	com/tencent/mobileqq/activity/QQBrowserActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   5537: aload_2
    //   5538: ldc_w 2838
    //   5541: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5544: ifeq +49 -> 5593
    //   5547: aload_2
    //   5548: ldc_w 2838
    //   5551: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   5554: istore 12
    //   5556: sipush 800
    //   5559: istore 6
    //   5561: aload_2
    //   5562: ldc_w 2840
    //   5565: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5568: ifeq +17 -> 5585
    //   5571: aload_2
    //   5572: ldc_w 2840
    //   5575: invokevirtual 2844	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   5578: ldc2_w 2845
    //   5581: dmul
    //   5582: d2i
    //   5583: istore 6
    //   5585: aload_0
    //   5586: iload 12
    //   5588: iload 6
    //   5590: invokevirtual 2848	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZI)V
    //   5593: aload_2
    //   5594: ldc_w 2850
    //   5597: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5600: ifeq +44 -> 5644
    //   5603: aload_2
    //   5604: ldc_w 2850
    //   5607: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5610: istore 6
    //   5612: aload_1
    //   5613: ifnull +31 -> 5644
    //   5616: iload 6
    //   5618: ifne +842 -> 6460
    //   5621: aload_1
    //   5622: getfield 1399	bbcj:jdField_a_of_type_Bbcm	Lbbcm;
    //   5625: iconst_0
    //   5626: putfield 2851	bbcm:jdField_d_of_type_Boolean	Z
    //   5629: aload_1
    //   5630: getfield 1399	bbcj:jdField_a_of_type_Bbcm	Lbbcm;
    //   5633: iconst_1
    //   5634: invokestatic 857	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5637: putfield 2854	bbcm:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   5640: aload_1
    //   5641: invokevirtual 2856	bbcj:j	()V
    //   5644: aload_2
    //   5645: ldc_w 2858
    //   5648: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5651: ifeq +26 -> 5677
    //   5654: aload_2
    //   5655: ldc_w 2858
    //   5658: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5661: istore 6
    //   5663: aload_1
    //   5664: ifnull +13 -> 5677
    //   5667: iload 6
    //   5669: iconst_1
    //   5670: if_icmpne +7 -> 5677
    //   5673: aload_1
    //   5674: invokevirtual 2860	bbcj:h	()V
    //   5677: aload_2
    //   5678: ldc_w 2862
    //   5681: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5684: ifeq +18 -> 5702
    //   5687: aload_2
    //   5688: ldc_w 2862
    //   5691: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5694: iconst_1
    //   5695: if_icmpne +7 -> 5702
    //   5698: aload_1
    //   5699: invokevirtual 2864	bbcj:i	()V
    //   5702: aload_2
    //   5703: ldc_w 2866
    //   5706: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5709: ifeq +63 -> 5772
    //   5712: aload_2
    //   5713: ldc_w 2866
    //   5716: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5719: istore 6
    //   5721: aload_0
    //   5722: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   5725: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   5728: astore 5
    //   5730: aload 5
    //   5732: ifnull +40 -> 5772
    //   5735: aload 5
    //   5737: instanceof 1323
    //   5740: ifeq +32 -> 5772
    //   5743: aload 4
    //   5745: checkcast 1323	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   5748: invokevirtual 2868	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   5751: checkcast 2870	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   5754: astore 4
    //   5756: aload 4
    //   5758: ifnull +14 -> 5772
    //   5761: iload 6
    //   5763: iconst_1
    //   5764: if_icmpne +724 -> 6488
    //   5767: aload 4
    //   5769: invokevirtual 2872	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:l	()V
    //   5772: aload_2
    //   5773: ldc_w 2874
    //   5776: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5779: ifeq +23 -> 5802
    //   5782: aload_2
    //   5783: ldc_w 2874
    //   5786: iconst_0
    //   5787: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5790: istore 12
    //   5792: aload_1
    //   5793: ifnull +9 -> 5802
    //   5796: aload_1
    //   5797: iload 12
    //   5799: invokevirtual 2876	bbcj:c	(Z)V
    //   5802: aload_2
    //   5803: ldc_w 2878
    //   5806: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5809: ifeq +38 -> 5847
    //   5812: aload_2
    //   5813: ldc_w 2878
    //   5816: iconst_0
    //   5817: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5820: istore 12
    //   5822: aload_1
    //   5823: ifnull +24 -> 5847
    //   5826: aload_1
    //   5827: getfield 2812	bbcj:jdField_a_of_type_Bazb	Lbazb;
    //   5830: getfield 2879	bazb:jdField_a_of_type_Bbcm	Lbbcm;
    //   5833: getfield 2881	bbcm:l	Z
    //   5836: iload 12
    //   5838: if_icmpeq +9 -> 5847
    //   5841: aload_1
    //   5842: iload 12
    //   5844: invokevirtual 2883	bbcj:d	(Z)V
    //   5847: aload_2
    //   5848: ldc_w 2885
    //   5851: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5854: ifeq -5670 -> 184
    //   5857: aload_1
    //   5858: ifnull -5674 -> 184
    //   5861: aload_2
    //   5862: ldc_w 2885
    //   5865: iconst_0
    //   5866: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5869: ifeq +632 -> 6501
    //   5872: aload_3
    //   5873: invokevirtual 2778	com/tencent/mobileqq/webview/swift/WebViewFragment:f	()Z
    //   5876: ifne -5692 -> 184
    //   5879: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5882: ifeq +12 -> 5894
    //   5885: ldc 191
    //   5887: iconst_4
    //   5888: ldc_w 2887
    //   5891: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5894: aload_1
    //   5895: getfield 1399	bbcj:jdField_a_of_type_Bbcm	Lbbcm;
    //   5898: iconst_1
    //   5899: putfield 2888	bbcm:jdField_a_of_type_Boolean	Z
    //   5902: aload_0
    //   5903: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   5906: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   5909: invokevirtual 2892	android/app/Activity:getWindow	()Landroid/view/Window;
    //   5912: sipush 1024
    //   5915: sipush 1024
    //   5918: invokevirtual 2896	android/view/Window:setFlags	(II)V
    //   5921: aload_3
    //   5922: invokevirtual 2899	com/tencent/mobileqq/webview/swift/WebViewFragment:D	()V
    //   5925: aload_3
    //   5926: iconst_0
    //   5927: invokevirtual 2901	com/tencent/mobileqq/webview/swift/WebViewFragment:g	(Z)V
    //   5930: goto -5746 -> 184
    //   5933: astore_1
    //   5934: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5937: ifeq -5753 -> 184
    //   5940: ldc 191
    //   5942: iconst_4
    //   5943: new 497	java/lang/StringBuilder
    //   5946: dup
    //   5947: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   5950: ldc_w 2903
    //   5953: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5956: aload_1
    //   5957: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5960: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5963: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5966: goto -5782 -> 184
    //   5969: aload 5
    //   5971: bipush 8
    //   5973: invokevirtual 752	android/widget/ImageView:setVisibility	(I)V
    //   5976: aload_1
    //   5977: iconst_0
    //   5978: invokevirtual 2750	android/widget/TextView:setVisibility	(I)V
    //   5981: goto -1042 -> 4939
    //   5984: astore_1
    //   5985: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5988: ifeq -5804 -> 184
    //   5991: ldc 191
    //   5993: iconst_4
    //   5994: new 497	java/lang/StringBuilder
    //   5997: dup
    //   5998: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   6001: ldc_w 2903
    //   6004: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6007: aload_1
    //   6008: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6011: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6014: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6017: goto -5833 -> 184
    //   6020: aload_1
    //   6021: bipush 8
    //   6023: invokevirtual 2750	android/widget/TextView:setVisibility	(I)V
    //   6026: aload 5
    //   6028: bipush 8
    //   6030: invokevirtual 752	android/widget/ImageView:setVisibility	(I)V
    //   6033: goto -1094 -> 4939
    //   6036: aload_0
    //   6037: iconst_2
    //   6038: invokespecial 1394	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   6041: checkcast 1396	bbcj
    //   6044: astore 14
    //   6046: aload 14
    //   6048: ifnull -831 -> 5217
    //   6051: aload 14
    //   6053: getfield 2906	bbcj:jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar	Lcom/tencent/mobileqq/widget/WebViewProgressBar;
    //   6056: astore_1
    //   6057: goto -840 -> 5217
    //   6060: iconst_0
    //   6061: invokestatic 2910	com/tencent/mobileqq/theme/ThemeUtil:isDefaultOrDIYTheme	(Z)Z
    //   6064: ifeq +24 -> 6088
    //   6067: aload_3
    //   6068: getfield 2807	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6071: ldc_w 2911
    //   6074: invokevirtual 2799	android/view/View:setBackgroundResource	(I)V
    //   6077: aload_3
    //   6078: getfield 2807	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6081: iconst_0
    //   6082: invokevirtual 1524	android/view/View:setVisibility	(I)V
    //   6085: goto -783 -> 5302
    //   6088: aload_3
    //   6089: getfield 2807	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6092: invokestatic 583	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6095: invokevirtual 2912	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   6098: ldc_w 2913
    //   6101: invokevirtual 1500	android/content/res/Resources:getColor	(I)I
    //   6104: invokevirtual 2728	android/view/View:setBackgroundColor	(I)V
    //   6107: iconst_0
    //   6108: invokestatic 583	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6111: invokevirtual 2912	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   6114: ldc_w 2913
    //   6117: invokevirtual 1500	android/content/res/Resources:getColor	(I)I
    //   6120: aload_0
    //   6121: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   6124: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   6127: invokevirtual 2892	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6130: invokestatic 2918	awnu:a	(ZILandroid/view/Window;)V
    //   6133: goto -56 -> 6077
    //   6136: aload 5
    //   6138: iconst_0
    //   6139: invokevirtual 2799	android/view/View:setBackgroundResource	(I)V
    //   6142: ldc_w 1611
    //   6145: istore 6
    //   6147: aload_2
    //   6148: ldc_w 2920
    //   6151: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6154: ifeq +15 -> 6169
    //   6157: aload_2
    //   6158: ldc_w 2920
    //   6161: invokestatic 2725	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6164: bipush 24
    //   6166: ishl
    //   6167: istore 6
    //   6169: iload 7
    //   6171: iload 6
    //   6173: ior
    //   6174: istore 8
    //   6176: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6179: ifeq +61 -> 6240
    //   6182: ldc 191
    //   6184: iconst_2
    //   6185: new 497	java/lang/StringBuilder
    //   6188: dup
    //   6189: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   6192: ldc_w 2922
    //   6195: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6198: iload 6
    //   6200: invokestatic 2733	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   6203: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6206: ldc_w 2924
    //   6209: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6212: iload 7
    //   6214: invokestatic 2733	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   6217: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6220: ldc_w 2926
    //   6223: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6226: iload 8
    //   6228: invokestatic 2733	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   6231: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6234: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6237: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6240: aload 5
    //   6242: iload 8
    //   6244: invokevirtual 2728	android/view/View:setBackgroundColor	(I)V
    //   6247: aload_1
    //   6248: ifnull +13 -> 6261
    //   6251: aload_1
    //   6252: ldc_w 1611
    //   6255: iload 7
    //   6257: ior
    //   6258: invokevirtual 2929	com/tencent/mobileqq/widget/WebViewProgressBar:setCustomColor	(I)V
    //   6261: aload_3
    //   6262: invokevirtual 2809	com/tencent/mobileqq/webview/swift/WebViewFragment:d	()Z
    //   6265: ifeq +24 -> 6289
    //   6268: aload_3
    //   6269: getfield 2807	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6272: ifnonnull +71 -> 6343
    //   6275: aload_3
    //   6276: iconst_1
    //   6277: invokevirtual 2931	com/tencent/mobileqq/webview/swift/WebViewFragment:k	(Z)V
    //   6280: aload_3
    //   6281: iconst_1
    //   6282: invokevirtual 2933	com/tencent/mobileqq/webview/swift/WebViewFragment:l	(Z)V
    //   6285: aload_3
    //   6286: invokevirtual 2935	com/tencent/mobileqq/webview/swift/WebViewFragment:F	()V
    //   6289: aload_3
    //   6290: getfield 2807	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6293: ifnull -986 -> 5307
    //   6296: aload_2
    //   6297: ldc_w 2937
    //   6300: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6303: ifeq +51 -> 6354
    //   6306: aload_2
    //   6307: ldc_w 2937
    //   6310: invokestatic 2725	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6313: istore 6
    //   6315: aload_3
    //   6316: getfield 2807	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6319: iload 6
    //   6321: invokevirtual 2728	android/view/View:setBackgroundColor	(I)V
    //   6324: iconst_1
    //   6325: iload 6
    //   6327: aload_0
    //   6328: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   6331: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   6334: invokevirtual 2892	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6337: invokestatic 2918	awnu:a	(ZILandroid/view/Window;)V
    //   6340: goto -1033 -> 5307
    //   6343: aload_3
    //   6344: getfield 2807	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6347: iconst_0
    //   6348: invokevirtual 1524	android/view/View:setVisibility	(I)V
    //   6351: goto -62 -> 6289
    //   6354: aload_3
    //   6355: getfield 2807	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   6358: iload 8
    //   6360: invokevirtual 2728	android/view/View:setBackgroundColor	(I)V
    //   6363: iconst_1
    //   6364: iload 8
    //   6366: aload_0
    //   6367: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   6370: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   6373: invokevirtual 2892	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6376: invokestatic 2918	awnu:a	(ZILandroid/view/Window;)V
    //   6379: aload_3
    //   6380: iconst_1
    //   6381: invokevirtual 2811	com/tencent/mobileqq/webview/swift/WebViewFragment:j	(Z)V
    //   6384: goto -1077 -> 5307
    //   6387: aload_3
    //   6388: ldc_w 1611
    //   6391: iload 6
    //   6393: ior
    //   6394: invokevirtual 2939	com/tencent/mobileqq/webview/swift/WebViewFragment:d	(I)V
    //   6397: aload_2
    //   6398: ldc_w 2941
    //   6401: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6404: ifeq +11091 -> 17495
    //   6407: aload_2
    //   6408: ldc_w 2941
    //   6411: invokestatic 2725	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6414: istore 7
    //   6416: iload 7
    //   6418: iconst_m1
    //   6419: if_icmpeq +11076 -> 17495
    //   6422: ldc_w 1611
    //   6425: iload 7
    //   6427: ior
    //   6428: istore 6
    //   6430: aload_3
    //   6431: iload 6
    //   6433: invokevirtual 2943	com/tencent/mobileqq/webview/swift/WebViewFragment:e	(I)V
    //   6436: aload_0
    //   6437: iload 6
    //   6439: invokevirtual 2945	com/tencent/mobileqq/jsp/UiApiPlugin:a	(I)V
    //   6442: goto -987 -> 5455
    //   6445: aload_3
    //   6446: aload_3
    //   6447: invokevirtual 2828	com/tencent/mobileqq/webview/swift/WebViewFragment:a	()J
    //   6450: ldc2_w 2245
    //   6453: lor
    //   6454: invokevirtual 2832	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(J)V
    //   6457: goto -949 -> 5508
    //   6460: iload 6
    //   6462: iconst_1
    //   6463: if_icmpne -823 -> 5640
    //   6466: aload_1
    //   6467: getfield 1399	bbcj:jdField_a_of_type_Bbcm	Lbbcm;
    //   6470: iconst_1
    //   6471: putfield 2851	bbcm:jdField_d_of_type_Boolean	Z
    //   6474: aload_1
    //   6475: getfield 1399	bbcj:jdField_a_of_type_Bbcm	Lbbcm;
    //   6478: iconst_0
    //   6479: invokestatic 857	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6482: putfield 2854	bbcm:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   6485: goto -845 -> 5640
    //   6488: iload 6
    //   6490: ifne -718 -> 5772
    //   6493: aload 4
    //   6495: invokevirtual 2947	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:m	()V
    //   6498: goto -726 -> 5772
    //   6501: aload_3
    //   6502: invokevirtual 2778	com/tencent/mobileqq/webview/swift/WebViewFragment:f	()Z
    //   6505: ifeq -6321 -> 184
    //   6508: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6511: ifeq +12 -> 6523
    //   6514: ldc 191
    //   6516: iconst_4
    //   6517: ldc_w 2949
    //   6520: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6523: aload_1
    //   6524: getfield 1399	bbcj:jdField_a_of_type_Bbcm	Lbbcm;
    //   6527: iconst_0
    //   6528: putfield 2888	bbcm:jdField_a_of_type_Boolean	Z
    //   6531: aload_0
    //   6532: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   6535: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   6538: invokevirtual 2892	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6541: sipush 1024
    //   6544: invokevirtual 2952	android/view/Window:clearFlags	(I)V
    //   6547: aload_3
    //   6548: invokevirtual 2955	com/tencent/mobileqq/webview/swift/WebViewFragment:E	()V
    //   6551: aload_3
    //   6552: iconst_1
    //   6553: invokevirtual 2901	com/tencent/mobileqq/webview/swift/WebViewFragment:g	(Z)V
    //   6556: goto -6372 -> 184
    //   6559: ldc_w 2957
    //   6562: aload 4
    //   6564: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6567: ifeq +484 -> 7051
    //   6570: aload 5
    //   6572: arraylength
    //   6573: iconst_1
    //   6574: if_icmpgt +477 -> 7051
    //   6577: new 109	org/json/JSONObject
    //   6580: dup
    //   6581: aload 5
    //   6583: iconst_0
    //   6584: aaload
    //   6585: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6588: astore_1
    //   6589: aload_0
    //   6590: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   6593: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   6596: instanceof 1181
    //   6599: ifne +5 -> 6604
    //   6602: iconst_1
    //   6603: ireturn
    //   6604: new 2959	xdd
    //   6607: dup
    //   6608: invokespecial 2960	xdd:<init>	()V
    //   6611: astore_2
    //   6612: aload_1
    //   6613: ldc_w 2962
    //   6616: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6619: ifeq +18 -> 6637
    //   6622: aload_2
    //   6623: aload_1
    //   6624: ldc_w 2962
    //   6627: invokestatic 2725	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6630: ldc_w 1611
    //   6633: ior
    //   6634: putfield 2963	xdd:jdField_a_of_type_Int	I
    //   6637: aload_1
    //   6638: ldc_w 1380
    //   6641: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6644: ifeq +14 -> 6658
    //   6647: aload_2
    //   6648: aload_1
    //   6649: ldc_w 1380
    //   6652: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6655: putfield 2964	xdd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6658: aload_1
    //   6659: ldc_w 2966
    //   6662: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6665: ifeq +176 -> 6841
    //   6668: aload_2
    //   6669: new 1453	java/util/ArrayList
    //   6672: dup
    //   6673: invokespecial 1850	java/util/ArrayList:<init>	()V
    //   6676: putfield 2969	xdd:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6679: aload_1
    //   6680: ldc_w 2966
    //   6683: invokevirtual 921	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6686: astore_3
    //   6687: aload_3
    //   6688: invokevirtual 936	org/json/JSONArray:length	()I
    //   6691: istore 7
    //   6693: iconst_0
    //   6694: istore 6
    //   6696: iload 6
    //   6698: iload 7
    //   6700: if_icmpge +141 -> 6841
    //   6703: aload_3
    //   6704: iload 6
    //   6706: invokevirtual 2972	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6709: astore 4
    //   6711: new 2974	xdc
    //   6714: dup
    //   6715: invokespecial 2975	xdc:<init>	()V
    //   6718: astore 5
    //   6720: aload 4
    //   6722: ldc_w 1435
    //   6725: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6728: ifeq +16 -> 6744
    //   6731: aload 5
    //   6733: aload 4
    //   6735: ldc_w 1435
    //   6738: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6741: putfield 2976	xdc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6744: aload 4
    //   6746: ldc_w 1905
    //   6749: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6752: ifeq +16 -> 6768
    //   6755: aload 5
    //   6757: aload 4
    //   6759: ldc_w 1905
    //   6762: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6765: putfield 2977	xdc:jdField_a_of_type_Int	I
    //   6768: aload 4
    //   6770: ldc_w 2979
    //   6773: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6776: ifeq +16 -> 6792
    //   6779: aload 5
    //   6781: aload 4
    //   6783: ldc_w 2979
    //   6786: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6789: putfield 2980	xdc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6792: aload 4
    //   6794: ldc_w 1437
    //   6797: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6800: ifeq +20 -> 6820
    //   6803: aload 5
    //   6805: aload 4
    //   6807: ldc_w 1437
    //   6810: invokestatic 2725	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6813: ldc_w 1611
    //   6816: ior
    //   6817: putfield 2981	xdc:jdField_b_of_type_Int	I
    //   6820: aload_2
    //   6821: getfield 2969	xdd:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6824: aload 5
    //   6826: invokeinterface 1950 2 0
    //   6831: pop
    //   6832: iload 6
    //   6834: iconst_1
    //   6835: iadd
    //   6836: istore 6
    //   6838: goto -142 -> 6696
    //   6841: aload_1
    //   6842: ldc_w 2983
    //   6845: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6848: ifeq +78 -> 6926
    //   6851: aload_2
    //   6852: new 1453	java/util/ArrayList
    //   6855: dup
    //   6856: invokespecial 1850	java/util/ArrayList:<init>	()V
    //   6859: putfield 2985	xdd:b	Ljava/util/List;
    //   6862: aload_1
    //   6863: ldc_w 2983
    //   6866: invokevirtual 921	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6869: astore_1
    //   6870: aload_1
    //   6871: invokevirtual 936	org/json/JSONArray:length	()I
    //   6874: istore 7
    //   6876: iconst_0
    //   6877: istore 6
    //   6879: iload 6
    //   6881: iload 7
    //   6883: if_icmpge +43 -> 6926
    //   6886: aload_1
    //   6887: iload 6
    //   6889: invokevirtual 2972	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6892: ldc 156
    //   6894: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6897: ifeq +10609 -> 17506
    //   6900: aload_1
    //   6901: iload 6
    //   6903: invokevirtual 2972	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6906: ldc 156
    //   6908: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6911: astore_3
    //   6912: aload_2
    //   6913: getfield 2985	xdd:b	Ljava/util/List;
    //   6916: aload_3
    //   6917: invokeinterface 1950 2 0
    //   6922: pop
    //   6923: goto +10583 -> 17506
    //   6926: aload_0
    //   6927: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   6930: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6933: astore_1
    //   6934: aload_1
    //   6935: ifnull +10463 -> 17398
    //   6938: aload_1
    //   6939: invokevirtual 2032	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6942: astore_1
    //   6943: aload_1
    //   6944: ifnull +10454 -> 17398
    //   6947: aload_1
    //   6948: ldc_w 2987
    //   6951: invokevirtual 2990	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6954: astore_1
    //   6955: aload_1
    //   6956: ifnull +10442 -> 17398
    //   6959: aload_1
    //   6960: instanceof 207
    //   6963: ifeq +10435 -> 17398
    //   6966: aload_1
    //   6967: checkcast 207	xcv
    //   6970: astore_1
    //   6971: aload_1
    //   6972: ifnull -6788 -> 184
    //   6975: aload_1
    //   6976: aload_2
    //   6977: invokevirtual 2993	xcv:a	(Lxdd;)V
    //   6980: aload_2
    //   6981: getfield 2964	xdd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6984: ifnull -6800 -> 184
    //   6987: aload_1
    //   6988: invokestatic 2995	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lxcv;)Ljava/lang/String;
    //   6991: astore_1
    //   6992: aload_1
    //   6993: ifnull -6809 -> 184
    //   6996: aload_0
    //   6997: aload_2
    //   6998: getfield 2964	xdd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7001: iconst_1
    //   7002: anewarray 334	java/lang/String
    //   7005: dup
    //   7006: iconst_0
    //   7007: aload_1
    //   7008: aastore
    //   7009: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7012: goto -6828 -> 184
    //   7015: astore_1
    //   7016: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7019: ifeq -6835 -> 184
    //   7022: ldc 191
    //   7024: iconst_4
    //   7025: new 497	java/lang/StringBuilder
    //   7028: dup
    //   7029: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   7032: ldc_w 2997
    //   7035: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7038: aload_1
    //   7039: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7042: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7045: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7048: goto -6864 -> 184
    //   7051: ldc_w 2999
    //   7054: aload 4
    //   7056: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7059: ifeq +176 -> 7235
    //   7062: aload 5
    //   7064: arraylength
    //   7065: iconst_1
    //   7066: if_icmpgt +169 -> 7235
    //   7069: new 109	org/json/JSONObject
    //   7072: dup
    //   7073: aload 5
    //   7075: iconst_0
    //   7076: aaload
    //   7077: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7080: astore_1
    //   7081: aload_0
    //   7082: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   7085: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   7088: instanceof 1181
    //   7091: ifne +5 -> 7096
    //   7094: iconst_1
    //   7095: ireturn
    //   7096: aload_1
    //   7097: ldc_w 3000
    //   7100: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7103: ifeq -6919 -> 184
    //   7106: aload_1
    //   7107: ldc_w 3000
    //   7110: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   7113: istore 12
    //   7115: aload_1
    //   7116: ldc_w 3002
    //   7119: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7122: ifeq +10270 -> 17392
    //   7125: aload_1
    //   7126: ldc_w 3002
    //   7129: invokevirtual 2844	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   7132: ldc2_w 2845
    //   7135: dmul
    //   7136: d2i
    //   7137: istore 6
    //   7139: aload_0
    //   7140: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   7143: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7146: astore_1
    //   7147: aload_1
    //   7148: ifnull +10239 -> 17387
    //   7151: aload_1
    //   7152: invokevirtual 2032	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   7155: astore_1
    //   7156: aload_1
    //   7157: ifnull +10230 -> 17387
    //   7160: aload_1
    //   7161: ldc_w 2987
    //   7164: invokevirtual 2990	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   7167: astore_1
    //   7168: aload_1
    //   7169: ifnull +10218 -> 17387
    //   7172: aload_1
    //   7173: instanceof 207
    //   7176: ifeq +10211 -> 17387
    //   7179: aload_1
    //   7180: checkcast 207	xcv
    //   7183: astore_1
    //   7184: aload_1
    //   7185: ifnull -7001 -> 184
    //   7188: aload_1
    //   7189: iload 12
    //   7191: iload 6
    //   7193: invokevirtual 3003	xcv:a	(ZI)V
    //   7196: goto -7012 -> 184
    //   7199: astore_1
    //   7200: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7203: ifeq -7019 -> 184
    //   7206: ldc 191
    //   7208: iconst_4
    //   7209: new 497	java/lang/StringBuilder
    //   7212: dup
    //   7213: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   7216: ldc_w 3005
    //   7219: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7222: aload_1
    //   7223: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7226: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7229: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7232: goto -7048 -> 184
    //   7235: ldc_w 3007
    //   7238: aload 4
    //   7240: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7243: ifeq +226 -> 7469
    //   7246: aload 5
    //   7248: arraylength
    //   7249: iconst_1
    //   7250: if_icmpgt +219 -> 7469
    //   7253: new 109	org/json/JSONObject
    //   7256: dup
    //   7257: aload 5
    //   7259: iconst_0
    //   7260: aaload
    //   7261: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7264: astore_1
    //   7265: aload_0
    //   7266: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   7269: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   7272: instanceof 1181
    //   7275: ifne +5 -> 7280
    //   7278: iconst_1
    //   7279: ireturn
    //   7280: new 2974	xdc
    //   7283: dup
    //   7284: invokespecial 2975	xdc:<init>	()V
    //   7287: astore_2
    //   7288: aload_1
    //   7289: ldc_w 1435
    //   7292: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7295: ifeq +14 -> 7309
    //   7298: aload_2
    //   7299: aload_1
    //   7300: ldc_w 1435
    //   7303: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7306: putfield 2976	xdc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7309: aload_1
    //   7310: ldc_w 1905
    //   7313: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7316: ifeq +14 -> 7330
    //   7319: aload_2
    //   7320: aload_1
    //   7321: ldc_w 1905
    //   7324: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7327: putfield 2977	xdc:jdField_a_of_type_Int	I
    //   7330: aload_1
    //   7331: ldc_w 2979
    //   7334: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7337: ifeq +14 -> 7351
    //   7340: aload_2
    //   7341: aload_1
    //   7342: ldc_w 2979
    //   7345: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7348: putfield 2980	xdc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7351: aload_1
    //   7352: ldc_w 1437
    //   7355: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7358: ifeq +18 -> 7376
    //   7361: aload_2
    //   7362: aload_1
    //   7363: ldc_w 1437
    //   7366: invokestatic 2725	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   7369: ldc_w 1611
    //   7372: ior
    //   7373: putfield 2981	xdc:jdField_b_of_type_Int	I
    //   7376: aload_0
    //   7377: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   7380: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7383: astore_1
    //   7384: aload_1
    //   7385: ifnull +9997 -> 17382
    //   7388: aload_1
    //   7389: invokevirtual 2032	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   7392: astore_1
    //   7393: aload_1
    //   7394: ifnull +9988 -> 17382
    //   7397: aload_1
    //   7398: ldc_w 2987
    //   7401: invokevirtual 2990	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   7404: astore_1
    //   7405: aload_1
    //   7406: ifnull +9976 -> 17382
    //   7409: aload_1
    //   7410: instanceof 207
    //   7413: ifeq +9969 -> 17382
    //   7416: aload_1
    //   7417: checkcast 207	xcv
    //   7420: astore_1
    //   7421: aload_1
    //   7422: ifnull -7238 -> 184
    //   7425: aload_1
    //   7426: aload_2
    //   7427: invokevirtual 3010	xcv:a	(Lxdc;)V
    //   7430: goto -7246 -> 184
    //   7433: astore_1
    //   7434: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7437: ifeq -7253 -> 184
    //   7440: ldc 191
    //   7442: iconst_4
    //   7443: new 497	java/lang/StringBuilder
    //   7446: dup
    //   7447: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   7450: ldc_w 3012
    //   7453: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7456: aload_1
    //   7457: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7460: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7463: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7466: goto -7282 -> 184
    //   7469: ldc_w 3014
    //   7472: aload 4
    //   7474: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7477: ifeq +110 -> 7587
    //   7480: aload 5
    //   7482: arraylength
    //   7483: iconst_1
    //   7484: if_icmpgt +103 -> 7587
    //   7487: aload 5
    //   7489: arraylength
    //   7490: iconst_1
    //   7491: if_icmpne +22 -> 7513
    //   7494: new 109	org/json/JSONObject
    //   7497: dup
    //   7498: aload 5
    //   7500: iconst_0
    //   7501: aaload
    //   7502: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7505: ldc_w 3016
    //   7508: iconst_0
    //   7509: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7512: pop
    //   7513: aload_0
    //   7514: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   7517: aload_0
    //   7518: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   7521: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   7524: invokevirtual 699	bbac:a	(Landroid/app/Activity;)Lbazo;
    //   7527: astore_1
    //   7528: aload_1
    //   7529: ifnull -7345 -> 184
    //   7532: aload_1
    //   7533: instanceof 3018
    //   7536: ifeq -7352 -> 184
    //   7539: aload_1
    //   7540: checkcast 3018	bbev
    //   7543: invokeinterface 3019 1 0
    //   7548: goto -7364 -> 184
    //   7551: astore_1
    //   7552: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7555: ifeq -7371 -> 184
    //   7558: ldc 191
    //   7560: iconst_4
    //   7561: new 497	java/lang/StringBuilder
    //   7564: dup
    //   7565: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   7568: ldc_w 3021
    //   7571: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7574: aload_1
    //   7575: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7578: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7581: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7584: goto -7400 -> 184
    //   7587: ldc_w 3023
    //   7590: aload 4
    //   7592: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7595: ifeq +195 -> 7790
    //   7598: aload 5
    //   7600: arraylength
    //   7601: iconst_1
    //   7602: if_icmpne +188 -> 7790
    //   7605: new 109	org/json/JSONObject
    //   7608: dup
    //   7609: aload 5
    //   7611: iconst_0
    //   7612: aaload
    //   7613: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7616: astore_1
    //   7617: aload_1
    //   7618: ldc_w 831
    //   7621: iconst_0
    //   7622: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7625: istore 6
    //   7627: aload_1
    //   7628: ldc_w 839
    //   7631: iconst_0
    //   7632: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7635: istore 7
    //   7637: aload_1
    //   7638: ldc_w 833
    //   7641: iconst_0
    //   7642: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   7645: istore 12
    //   7647: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7650: ifeq +48 -> 7698
    //   7653: ldc 191
    //   7655: iconst_2
    //   7656: new 497	java/lang/StringBuilder
    //   7659: dup
    //   7660: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   7663: ldc_w 3025
    //   7666: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7669: aload_1
    //   7670: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7673: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7676: ldc_w 3027
    //   7679: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7682: aload_0
    //   7683: getfield 97	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   7686: invokevirtual 844	java/lang/Object:toString	()Ljava/lang/String;
    //   7689: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7692: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7695: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7698: invokestatic 296	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7701: new 125	android/content/Intent
    //   7704: dup
    //   7705: ldc_w 2104
    //   7708: invokespecial 130	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   7711: ldc_w 831
    //   7714: iload 6
    //   7716: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7719: ldc_w 833
    //   7722: iload 12
    //   7724: invokevirtual 553	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7727: ldc_w 839
    //   7730: iload 7
    //   7732: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7735: ldc_w 841
    //   7738: aload_0
    //   7739: getfield 848	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Int	I
    //   7742: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7745: ldc_w 2106
    //   7748: invokevirtual 3032	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   7751: goto -7567 -> 184
    //   7754: astore_1
    //   7755: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7758: ifeq -7574 -> 184
    //   7761: ldc 191
    //   7763: iconst_4
    //   7764: new 497	java/lang/StringBuilder
    //   7767: dup
    //   7768: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   7771: ldc_w 3034
    //   7774: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7777: aload_1
    //   7778: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7781: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7784: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7787: goto -7603 -> 184
    //   7790: ldc_w 3036
    //   7793: aload 4
    //   7795: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7798: ifeq +258 -> 8056
    //   7801: aload 5
    //   7803: arraylength
    //   7804: iconst_1
    //   7805: if_icmpne +251 -> 8056
    //   7808: aload_0
    //   7809: aconst_null
    //   7810: putfield 3038	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7813: new 109	org/json/JSONObject
    //   7816: dup
    //   7817: aload 5
    //   7819: iconst_0
    //   7820: aaload
    //   7821: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7824: astore_3
    //   7825: aload_3
    //   7826: ldc_w 1331
    //   7829: invokevirtual 2321	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   7832: lstore 10
    //   7834: aload_3
    //   7835: ldc_w 3040
    //   7838: bipush 13
    //   7840: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7843: istore 6
    //   7845: aload_3
    //   7846: ldc_w 3042
    //   7849: iconst_0
    //   7850: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7853: istore 7
    //   7855: aload_3
    //   7856: ldc_w 1380
    //   7859: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7862: astore_1
    //   7863: aload_0
    //   7864: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   7867: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   7870: astore_2
    //   7871: aload_2
    //   7872: ifnull +10 -> 7882
    //   7875: aload_2
    //   7876: invokevirtual 3045	com/tencent/common/app/AppInterface:isLogin	()Z
    //   7879: ifne +20 -> 7899
    //   7882: aload_0
    //   7883: aload_1
    //   7884: iconst_1
    //   7885: anewarray 334	java/lang/String
    //   7888: dup
    //   7889: iconst_0
    //   7890: ldc_w 3047
    //   7893: aastore
    //   7894: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7897: iconst_1
    //   7898: ireturn
    //   7899: aload_3
    //   7900: ldc_w 2364
    //   7903: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7906: astore_3
    //   7907: aload_3
    //   7908: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7911: ifne +31 -> 7942
    //   7914: aload_3
    //   7915: aload_2
    //   7916: invokevirtual 1034	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   7919: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7922: ifne +20 -> 7942
    //   7925: aload_0
    //   7926: aload_1
    //   7927: iconst_1
    //   7928: anewarray 334	java/lang/String
    //   7931: dup
    //   7932: iconst_0
    //   7933: ldc_w 3049
    //   7936: aastore
    //   7937: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7940: iconst_1
    //   7941: ireturn
    //   7942: aload_0
    //   7943: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   7946: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   7949: astore_2
    //   7950: aload_2
    //   7951: ifnull -7767 -> 184
    //   7954: aload_0
    //   7955: aload_1
    //   7956: putfield 3038	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7959: new 125	android/content/Intent
    //   7962: dup
    //   7963: aload_2
    //   7964: ldc_w 3051
    //   7967: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7970: astore_1
    //   7971: aload_1
    //   7972: ldc_w 872
    //   7975: bipush 16
    //   7977: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7980: pop
    //   7981: aload_1
    //   7982: ldc_w 3040
    //   7985: iload 6
    //   7987: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7990: pop
    //   7991: aload_1
    //   7992: ldc_w 1331
    //   7995: lload 10
    //   7997: invokevirtual 1340	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   8000: pop
    //   8001: aload_1
    //   8002: ldc_w 3042
    //   8005: iload 7
    //   8007: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8010: pop
    //   8011: aload_0
    //   8012: aload_1
    //   8013: iconst_5
    //   8014: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   8017: goto -7833 -> 184
    //   8020: astore_1
    //   8021: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8024: ifeq -7840 -> 184
    //   8027: ldc 191
    //   8029: iconst_4
    //   8030: new 497	java/lang/StringBuilder
    //   8033: dup
    //   8034: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8037: ldc_w 3053
    //   8040: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8043: aload_1
    //   8044: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8047: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8050: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8053: goto -7869 -> 184
    //   8056: ldc_w 3055
    //   8059: aload 4
    //   8061: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8064: ifeq +269 -> 8333
    //   8067: aload 5
    //   8069: arraylength
    //   8070: iconst_1
    //   8071: if_icmpne +262 -> 8333
    //   8074: aload_0
    //   8075: aconst_null
    //   8076: putfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8079: new 109	org/json/JSONObject
    //   8082: dup
    //   8083: aload 5
    //   8085: iconst_0
    //   8086: aaload
    //   8087: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8090: astore_3
    //   8091: aload_0
    //   8092: aload_3
    //   8093: ldc_w 2364
    //   8096: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   8099: putfield 3057	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   8102: aload_3
    //   8103: ldc_w 3059
    //   8106: iconst_0
    //   8107: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   8110: istore 6
    //   8112: aload_0
    //   8113: aload_3
    //   8114: ldc_w 3061
    //   8117: iconst_0
    //   8118: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8121: putfield 3063	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   8124: aload_3
    //   8125: ldc_w 1380
    //   8128: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   8131: astore_1
    //   8132: aload_0
    //   8133: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   8136: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   8139: astore_2
    //   8140: aload_2
    //   8141: ifnull +10 -> 8151
    //   8144: aload_2
    //   8145: invokevirtual 3045	com/tencent/common/app/AppInterface:isLogin	()Z
    //   8148: ifne +20 -> 8168
    //   8151: aload_0
    //   8152: aload_1
    //   8153: iconst_1
    //   8154: anewarray 334	java/lang/String
    //   8157: dup
    //   8158: iconst_0
    //   8159: ldc_w 3065
    //   8162: aastore
    //   8163: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8166: iconst_1
    //   8167: ireturn
    //   8168: aload_0
    //   8169: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   8172: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   8175: astore_2
    //   8176: aload_2
    //   8177: ifnull -7993 -> 184
    //   8180: iload 6
    //   8182: ifne -7998 -> 184
    //   8185: aload_3
    //   8186: ldc_w 909
    //   8189: aload_2
    //   8190: ldc_w 3066
    //   8193: invokevirtual 2240	android/app/Activity:getString	(I)Ljava/lang/String;
    //   8196: invokevirtual 2378	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8199: astore_3
    //   8200: aload_0
    //   8201: aload_1
    //   8202: putfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8205: aload_0
    //   8206: getfield 3063	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   8209: ifeq +101 -> 8310
    //   8212: new 125	android/content/Intent
    //   8215: dup
    //   8216: aload_2
    //   8217: ldc_w 3068
    //   8220: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8223: astore_1
    //   8224: aload_1
    //   8225: ldc_w 3070
    //   8228: iconst_1
    //   8229: invokevirtual 553	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8232: pop
    //   8233: aload_1
    //   8234: ldc_w 3072
    //   8237: aload_0
    //   8238: getfield 3057	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   8241: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8244: pop
    //   8245: aload_1
    //   8246: ldc_w 3074
    //   8249: aload_3
    //   8250: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8253: pop
    //   8254: aload_0
    //   8255: aload_1
    //   8256: bipush 7
    //   8258: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   8261: aload_2
    //   8262: ldc_w 3075
    //   8265: ldc_w 3076
    //   8268: invokevirtual 1196	android/app/Activity:overridePendingTransition	(II)V
    //   8271: goto -8087 -> 184
    //   8274: astore_1
    //   8275: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8278: ifeq -8094 -> 184
    //   8281: ldc 191
    //   8283: iconst_4
    //   8284: new 497	java/lang/StringBuilder
    //   8287: dup
    //   8288: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8291: ldc_w 3078
    //   8294: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8297: aload_1
    //   8298: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8301: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8304: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8307: goto -8123 -> 184
    //   8310: aload_2
    //   8311: aload_0
    //   8312: getfield 3057	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   8315: bipush 14
    //   8317: invokestatic 2333	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   8320: astore_1
    //   8321: aload_1
    //   8322: ldc_w 3080
    //   8325: aload_3
    //   8326: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8329: pop
    //   8330: goto -76 -> 8254
    //   8333: ldc_w 3082
    //   8336: aload 4
    //   8338: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8341: ifeq +120 -> 8461
    //   8344: aload 5
    //   8346: arraylength
    //   8347: iconst_1
    //   8348: if_icmpne +113 -> 8461
    //   8351: new 109	org/json/JSONObject
    //   8354: dup
    //   8355: aload 5
    //   8357: iconst_0
    //   8358: aaload
    //   8359: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8362: astore_1
    //   8363: aload_1
    //   8364: ldc_w 3084
    //   8367: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8370: ifeq -8186 -> 184
    //   8373: aload_1
    //   8374: ldc_w 3084
    //   8377: invokevirtual 2824	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8380: istore 12
    //   8382: aload_0
    //   8383: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   8386: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   8389: invokevirtual 3085	com/tencent/biz/pubaccount/CustomWebView:getParent	()Landroid/view/ViewParent;
    //   8392: checkcast 1523	android/view/View
    //   8395: astore_1
    //   8396: aload_1
    //   8397: instanceof 1598
    //   8400: ifne +5 -> 8405
    //   8403: iconst_1
    //   8404: ireturn
    //   8405: aload_0
    //   8406: aload_1
    //   8407: checkcast 1598	com/tencent/biz/ui/RefreshView
    //   8410: putfield 1600	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8413: aload_0
    //   8414: getfield 1600	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8417: iload 12
    //   8419: invokevirtual 3086	com/tencent/biz/ui/RefreshView:a	(Z)V
    //   8422: goto -8238 -> 184
    //   8425: astore_1
    //   8426: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8429: ifeq -8245 -> 184
    //   8432: ldc 191
    //   8434: iconst_4
    //   8435: new 497	java/lang/StringBuilder
    //   8438: dup
    //   8439: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8442: ldc_w 3088
    //   8445: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8448: aload_1
    //   8449: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8452: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8455: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8458: goto -8274 -> 184
    //   8461: ldc_w 3090
    //   8464: aload 4
    //   8466: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8469: ifeq +443 -> 8912
    //   8472: aload 5
    //   8474: arraylength
    //   8475: iconst_1
    //   8476: if_icmpne +436 -> 8912
    //   8479: aconst_null
    //   8480: astore 4
    //   8482: aconst_null
    //   8483: astore_3
    //   8484: iconst_1
    //   8485: istore 7
    //   8487: aload_3
    //   8488: astore_2
    //   8489: aload 4
    //   8491: astore_1
    //   8492: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8495: ifeq +37 -> 8532
    //   8498: aload_3
    //   8499: astore_2
    //   8500: aload 4
    //   8502: astore_1
    //   8503: ldc 191
    //   8505: iconst_1
    //   8506: new 497	java/lang/StringBuilder
    //   8509: dup
    //   8510: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8513: ldc_w 3092
    //   8516: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8519: aload 5
    //   8521: iconst_0
    //   8522: aaload
    //   8523: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8526: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8529: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8532: aload_3
    //   8533: astore_2
    //   8534: aload 4
    //   8536: astore_1
    //   8537: new 109	org/json/JSONObject
    //   8540: dup
    //   8541: aload 5
    //   8543: iconst_0
    //   8544: aaload
    //   8545: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8548: astore 15
    //   8550: aload_3
    //   8551: astore_2
    //   8552: aload 4
    //   8554: astore_1
    //   8555: aload 15
    //   8557: ldc_w 909
    //   8560: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8563: astore 5
    //   8565: aload_3
    //   8566: astore_2
    //   8567: aload 4
    //   8569: astore_1
    //   8570: aload 15
    //   8572: ldc_w 2979
    //   8575: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8578: astore 14
    //   8580: aload_3
    //   8581: astore_2
    //   8582: aload 4
    //   8584: astore_1
    //   8585: aload 15
    //   8587: ldc_w 1380
    //   8590: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8593: astore_3
    //   8594: iload 7
    //   8596: istore 6
    //   8598: aload_3
    //   8599: astore_2
    //   8600: aload_3
    //   8601: astore_1
    //   8602: aload 5
    //   8604: invokevirtual 3093	java/lang/String:length	()I
    //   8607: ifle +71 -> 8678
    //   8610: aload_3
    //   8611: astore_2
    //   8612: aload_3
    //   8613: astore_1
    //   8614: aload_0
    //   8615: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   8618: invokevirtual 1512	bbac:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   8621: astore 4
    //   8623: aload 4
    //   8625: ifnull +219 -> 8844
    //   8628: aload_3
    //   8629: astore_2
    //   8630: aload_3
    //   8631: astore_1
    //   8632: aload 4
    //   8634: getfield 3094	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bbcm	Lbbcm;
    //   8637: ifnull +207 -> 8844
    //   8640: aload_3
    //   8641: astore_2
    //   8642: aload_3
    //   8643: astore_1
    //   8644: aload 4
    //   8646: getfield 3094	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bbcm	Lbbcm;
    //   8649: getfield 3096	bbcm:E	Z
    //   8652: ifeq +75 -> 8727
    //   8655: aload_3
    //   8656: astore_2
    //   8657: aload_3
    //   8658: astore_1
    //   8659: aload 4
    //   8661: aload 5
    //   8663: iconst_m1
    //   8664: aload 14
    //   8666: ldc_w 3098
    //   8669: invokevirtual 138	java/lang/Class:getName	()Ljava/lang/String;
    //   8672: invokevirtual 3101	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   8675: iconst_0
    //   8676: istore 6
    //   8678: aload_3
    //   8679: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8682: ifne -8498 -> 184
    //   8685: aload_0
    //   8686: aload_3
    //   8687: iconst_1
    //   8688: anewarray 334	java/lang/String
    //   8691: dup
    //   8692: iconst_0
    //   8693: new 497	java/lang/StringBuilder
    //   8696: dup
    //   8697: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8700: ldc_w 3103
    //   8703: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8706: iload 6
    //   8708: invokevirtual 1063	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8711: ldc_w 1433
    //   8714: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8717: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8720: aastore
    //   8721: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8724: goto -8540 -> 184
    //   8727: aload_3
    //   8728: astore_2
    //   8729: aload_3
    //   8730: astore_1
    //   8731: aload 4
    //   8733: getfield 3094	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bbcm	Lbbcm;
    //   8736: getfield 3105	bbcm:D	Z
    //   8739: ifeq -64 -> 8675
    //   8742: aload_3
    //   8743: astore_2
    //   8744: aload_3
    //   8745: astore_1
    //   8746: new 400	android/os/Bundle
    //   8749: dup
    //   8750: invokespecial 870	android/os/Bundle:<init>	()V
    //   8753: astore 14
    //   8755: aload_3
    //   8756: astore_2
    //   8757: aload_3
    //   8758: astore_1
    //   8759: aload 14
    //   8761: ldc_w 3107
    //   8764: aload 5
    //   8766: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8769: aload_3
    //   8770: astore_2
    //   8771: aload_3
    //   8772: astore_1
    //   8773: aload 4
    //   8775: aload 14
    //   8777: invokevirtual 3109	com/tencent/mobileqq/webview/swift/WebViewFragment:d	(Landroid/os/Bundle;)V
    //   8780: goto -105 -> 8675
    //   8783: astore_3
    //   8784: aload_2
    //   8785: astore_1
    //   8786: ldc 191
    //   8788: iconst_1
    //   8789: ldc_w 3111
    //   8792: aload_3
    //   8793: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8796: aload_2
    //   8797: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8800: ifne -8616 -> 184
    //   8803: aload_0
    //   8804: aload_2
    //   8805: iconst_1
    //   8806: anewarray 334	java/lang/String
    //   8809: dup
    //   8810: iconst_0
    //   8811: new 497	java/lang/StringBuilder
    //   8814: dup
    //   8815: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8818: ldc_w 3103
    //   8821: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8824: iconst_1
    //   8825: invokevirtual 1063	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8828: ldc_w 1433
    //   8831: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8834: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8837: aastore
    //   8838: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8841: goto -8657 -> 184
    //   8844: aload_3
    //   8845: astore_2
    //   8846: aload_3
    //   8847: astore_1
    //   8848: ldc 191
    //   8850: iconst_1
    //   8851: ldc_w 3113
    //   8854: invokestatic 613	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8857: iload 7
    //   8859: istore 6
    //   8861: goto -183 -> 8678
    //   8864: astore_2
    //   8865: aload_1
    //   8866: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8869: ifne +41 -> 8910
    //   8872: aload_0
    //   8873: aload_1
    //   8874: iconst_1
    //   8875: anewarray 334	java/lang/String
    //   8878: dup
    //   8879: iconst_0
    //   8880: new 497	java/lang/StringBuilder
    //   8883: dup
    //   8884: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   8887: ldc_w 3103
    //   8890: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8893: iconst_1
    //   8894: invokevirtual 1063	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8897: ldc_w 1433
    //   8900: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8903: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8906: aastore
    //   8907: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8910: aload_2
    //   8911: athrow
    //   8912: ldc_w 1590
    //   8915: aload 4
    //   8917: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8920: ifeq +275 -> 9195
    //   8923: aload 5
    //   8925: arraylength
    //   8926: iconst_1
    //   8927: if_icmpne +268 -> 9195
    //   8930: new 109	org/json/JSONObject
    //   8933: dup
    //   8934: aload 5
    //   8936: iconst_0
    //   8937: aaload
    //   8938: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8941: astore_1
    //   8942: aload_1
    //   8943: ldc_w 3084
    //   8946: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8949: ifeq +135 -> 9084
    //   8952: aload_1
    //   8953: ldc_w 3084
    //   8956: invokevirtual 2824	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8959: istore 13
    //   8961: iconst_0
    //   8962: istore 12
    //   8964: aload_1
    //   8965: ldc 150
    //   8967: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8970: astore_2
    //   8971: aload_1
    //   8972: ldc_w 3115
    //   8975: ldc_w 1611
    //   8978: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   8981: istore 6
    //   8983: aload_1
    //   8984: ldc_w 3117
    //   8987: ldc_w 1611
    //   8990: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   8993: istore 7
    //   8995: ldc_w 3119
    //   8998: aload_2
    //   8999: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9002: ifeq +6 -> 9008
    //   9005: iconst_1
    //   9006: istore 12
    //   9008: iload 13
    //   9010: aload_0
    //   9011: getfield 3121	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   9014: if_icmpeq -8830 -> 184
    //   9017: iload 13
    //   9019: ifeq +58 -> 9077
    //   9022: aload_0
    //   9023: iload 12
    //   9025: iload 6
    //   9027: iload 7
    //   9029: invokevirtual 3123	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZII)V
    //   9032: aload_0
    //   9033: iload 13
    //   9035: putfield 3121	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   9038: goto -8854 -> 184
    //   9041: astore_1
    //   9042: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   9045: ifeq -8861 -> 184
    //   9048: ldc 191
    //   9050: iconst_4
    //   9051: new 497	java/lang/StringBuilder
    //   9054: dup
    //   9055: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   9058: ldc_w 3088
    //   9061: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9064: aload_1
    //   9065: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9068: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9071: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9074: goto -8890 -> 184
    //   9077: aload_0
    //   9078: invokevirtual 3125	com/tencent/mobileqq/jsp/UiApiPlugin:b	()V
    //   9081: goto -49 -> 9032
    //   9084: aload_1
    //   9085: ldc_w 3127
    //   9088: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9091: ifeq -8907 -> 184
    //   9094: aload_0
    //   9095: getfield 1602	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   9098: ifeq -8914 -> 184
    //   9101: aload_0
    //   9102: iconst_0
    //   9103: putfield 1602	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   9106: aload_1
    //   9107: ldc_w 3127
    //   9110: invokevirtual 2824	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   9113: istore 12
    //   9115: invokestatic 296	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9118: invokevirtual 3128	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   9121: astore_2
    //   9122: iload 12
    //   9124: ifeq +44 -> 9168
    //   9127: aload_0
    //   9128: getfield 1610	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wpa	Lwpa;
    //   9131: iconst_0
    //   9132: aload_1
    //   9133: ldc_w 1435
    //   9136: aload_2
    //   9137: ldc_w 3129
    //   9140: invokevirtual 3130	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   9143: invokevirtual 2378	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   9146: invokeinterface 3133 3 0
    //   9151: aload_0
    //   9152: getfield 1600	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   9155: ifnull -8971 -> 184
    //   9158: aload_0
    //   9159: getfield 1600	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   9162: invokevirtual 3134	com/tencent/biz/ui/RefreshView:b	()V
    //   9165: goto -8981 -> 184
    //   9168: aload_0
    //   9169: getfield 1610	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wpa	Lwpa;
    //   9172: iconst_1
    //   9173: aload_1
    //   9174: ldc_w 1435
    //   9177: aload_2
    //   9178: ldc_w 3135
    //   9181: invokevirtual 3130	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   9184: invokevirtual 2378	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   9187: invokeinterface 3133 3 0
    //   9192: goto -41 -> 9151
    //   9195: ldc_w 3137
    //   9198: aload 4
    //   9200: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9203: ifeq +192 -> 9395
    //   9206: aload 5
    //   9208: arraylength
    //   9209: iconst_1
    //   9210: if_icmpne +185 -> 9395
    //   9213: new 109	org/json/JSONObject
    //   9216: dup
    //   9217: aload 5
    //   9219: iconst_0
    //   9220: aaload
    //   9221: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9224: astore_2
    //   9225: aload_2
    //   9226: ldc_w 3139
    //   9229: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9232: istore 6
    //   9234: aload_2
    //   9235: ldc 156
    //   9237: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9240: astore_1
    //   9241: aload_2
    //   9242: ldc 170
    //   9244: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9247: istore 7
    //   9249: aload_0
    //   9250: aload_2
    //   9251: ldc_w 1380
    //   9254: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9257: putfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9260: new 125	android/content/Intent
    //   9263: dup
    //   9264: getstatic 3143	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   9267: ldc_w 3145
    //   9270: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   9273: astore_2
    //   9274: aload_2
    //   9275: ldc_w 3147
    //   9278: iload 6
    //   9280: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9283: pop
    //   9284: aload_2
    //   9285: ldc_w 3149
    //   9288: aload_1
    //   9289: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9292: pop
    //   9293: aload_2
    //   9294: ldc_w 3151
    //   9297: iload 7
    //   9299: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9302: pop
    //   9303: aload_2
    //   9304: ldc_w 3153
    //   9307: bipush 6
    //   9309: invokevirtual 3156	android/content/Intent:putExtra	(Ljava/lang/String;B)Landroid/content/Intent;
    //   9312: pop
    //   9313: aload_0
    //   9314: aload_2
    //   9315: bipush 6
    //   9317: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   9320: goto -9136 -> 184
    //   9323: astore_1
    //   9324: aload_1
    //   9325: invokevirtual 2502	org/json/JSONException:printStackTrace	()V
    //   9328: aload_0
    //   9329: getfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9332: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9335: ifne -9151 -> 184
    //   9338: aload_0
    //   9339: aload_0
    //   9340: getfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9343: iconst_1
    //   9344: anewarray 334	java/lang/String
    //   9347: dup
    //   9348: iconst_0
    //   9349: ldc_w 3158
    //   9352: aastore
    //   9353: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9356: goto -9172 -> 184
    //   9359: astore_1
    //   9360: aload_1
    //   9361: invokevirtual 2618	java/lang/Exception:printStackTrace	()V
    //   9364: aload_0
    //   9365: getfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9368: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9371: ifne -9187 -> 184
    //   9374: aload_0
    //   9375: aload_0
    //   9376: getfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9379: iconst_1
    //   9380: anewarray 334	java/lang/String
    //   9383: dup
    //   9384: iconst_0
    //   9385: ldc_w 3158
    //   9388: aastore
    //   9389: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9392: goto -9208 -> 184
    //   9395: ldc_w 3160
    //   9398: aload 4
    //   9400: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9403: ifeq +250 -> 9653
    //   9406: aload_0
    //   9407: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   9410: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   9413: astore_1
    //   9414: aload_0
    //   9415: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   9418: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   9421: astore_2
    //   9422: aload_1
    //   9423: ifnull -9239 -> 184
    //   9426: aload_2
    //   9427: ifnull -9243 -> 184
    //   9430: aconst_null
    //   9431: astore_2
    //   9432: aload_2
    //   9433: astore_1
    //   9434: new 109	org/json/JSONObject
    //   9437: dup
    //   9438: aload 5
    //   9440: iconst_0
    //   9441: aaload
    //   9442: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9445: astore_3
    //   9446: aload_2
    //   9447: astore_1
    //   9448: aload_3
    //   9449: ldc_w 1380
    //   9452: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9455: astore_2
    //   9456: aload_2
    //   9457: astore_1
    //   9458: aload_3
    //   9459: ldc_w 2364
    //   9462: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9465: invokestatic 3164	asfj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9468: astore 4
    //   9470: aload_2
    //   9471: astore_1
    //   9472: aload_3
    //   9473: ldc_w 3166
    //   9476: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9479: astore 5
    //   9481: aload_2
    //   9482: astore_1
    //   9483: aload_3
    //   9484: ldc_w 3168
    //   9487: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   9490: istore 7
    //   9492: iconst_0
    //   9493: istore 6
    //   9495: aload_2
    //   9496: astore_1
    //   9497: aload_3
    //   9498: ldc_w 3170
    //   9501: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9504: ifeq +14 -> 9518
    //   9507: aload_2
    //   9508: astore_1
    //   9509: aload_3
    //   9510: ldc_w 3170
    //   9513: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   9516: istore 6
    //   9518: aload_2
    //   9519: astore_1
    //   9520: new 400	android/os/Bundle
    //   9523: dup
    //   9524: invokespecial 870	android/os/Bundle:<init>	()V
    //   9527: astore_3
    //   9528: aload_2
    //   9529: astore_1
    //   9530: aload_3
    //   9531: ldc_w 2364
    //   9534: aload 4
    //   9536: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9539: aload 5
    //   9541: ifnull +14 -> 9555
    //   9544: aload_2
    //   9545: astore_1
    //   9546: aload_3
    //   9547: ldc_w 3166
    //   9550: aload 5
    //   9552: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9555: aload_2
    //   9556: astore_1
    //   9557: aload_3
    //   9558: ldc_w 3172
    //   9561: iload 7
    //   9563: invokevirtual 876	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9566: aload_2
    //   9567: astore_1
    //   9568: aload_3
    //   9569: ldc_w 1069
    //   9572: ldc_w 3160
    //   9575: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9578: aload_2
    //   9579: astore_1
    //   9580: aload_3
    //   9581: ldc_w 3170
    //   9584: iload 6
    //   9586: invokevirtual 876	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9589: aload_2
    //   9590: astore_1
    //   9591: ldc_w 3174
    //   9594: aload_2
    //   9595: aload_0
    //   9596: getfield 93	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Anad	Lanad;
    //   9599: getfield 3179	anad:key	I
    //   9602: aload_3
    //   9603: invokestatic 3184	anah:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9606: astore_3
    //   9607: aload_2
    //   9608: astore_1
    //   9609: invokestatic 3189	anfc:a	()Lanfc;
    //   9612: aload_3
    //   9613: invokevirtual 3190	anfc:a	(Landroid/os/Bundle;)V
    //   9616: goto -9432 -> 184
    //   9619: astore_2
    //   9620: aload_1
    //   9621: ifnull -9437 -> 184
    //   9624: aload_0
    //   9625: aload_1
    //   9626: iconst_1
    //   9627: anewarray 334	java/lang/String
    //   9630: dup
    //   9631: iconst_0
    //   9632: ldc_w 3192
    //   9635: iconst_1
    //   9636: anewarray 843	java/lang/Object
    //   9639: dup
    //   9640: iconst_0
    //   9641: aload_2
    //   9642: aastore
    //   9643: invokestatic 861	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9646: aastore
    //   9647: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9650: goto -9466 -> 184
    //   9653: ldc_w 3194
    //   9656: aload 4
    //   9658: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9661: ifeq +403 -> 10064
    //   9664: aload_0
    //   9665: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   9668: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   9671: astore_1
    //   9672: aload_0
    //   9673: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   9676: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   9679: astore_2
    //   9680: aload_1
    //   9681: ifnull -9497 -> 184
    //   9684: aload_2
    //   9685: ifnull -9501 -> 184
    //   9688: aconst_null
    //   9689: astore_2
    //   9690: aconst_null
    //   9691: astore 4
    //   9693: aload_2
    //   9694: astore_1
    //   9695: new 109	org/json/JSONObject
    //   9698: dup
    //   9699: aload 5
    //   9701: iconst_0
    //   9702: aaload
    //   9703: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9706: astore 14
    //   9708: aload_2
    //   9709: astore_1
    //   9710: aload 14
    //   9712: ldc_w 1380
    //   9715: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9718: astore_3
    //   9719: aload_3
    //   9720: astore_1
    //   9721: aload 14
    //   9723: ldc_w 2364
    //   9726: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9729: invokestatic 3164	asfj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9732: astore_2
    //   9733: aload_3
    //   9734: astore_1
    //   9735: aload 14
    //   9737: ldc_w 2362
    //   9740: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9743: astore 5
    //   9745: aload_3
    //   9746: astore_1
    //   9747: aload 14
    //   9749: ldc_w 3196
    //   9752: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9755: astore 15
    //   9757: iconst_0
    //   9758: istore 12
    //   9760: aload_3
    //   9761: astore_1
    //   9762: aload 5
    //   9764: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9767: ifne +7612 -> 17379
    //   9770: iconst_1
    //   9771: istore 12
    //   9773: aload 5
    //   9775: astore_2
    //   9776: aload_3
    //   9777: astore_1
    //   9778: aload 14
    //   9780: ldc_w 3166
    //   9783: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9786: astore 5
    //   9788: aload_3
    //   9789: astore_1
    //   9790: aload 14
    //   9792: ldc_w 3168
    //   9795: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9798: istore 6
    //   9800: aload_3
    //   9801: astore_1
    //   9802: aload 14
    //   9804: ldc_w 3198
    //   9807: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9810: istore 7
    //   9812: aload_3
    //   9813: astore_1
    //   9814: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9817: ifeq +35 -> 9852
    //   9820: aload_3
    //   9821: astore_1
    //   9822: ldc 191
    //   9824: iconst_2
    //   9825: new 497	java/lang/StringBuilder
    //   9828: dup
    //   9829: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   9832: ldc_w 3200
    //   9835: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9838: aload 14
    //   9840: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9843: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9846: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9849: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9852: aload_3
    //   9853: astore_1
    //   9854: aload_2
    //   9855: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9858: ifne +178 -> 10036
    //   9861: aload_3
    //   9862: astore_1
    //   9863: new 400	android/os/Bundle
    //   9866: dup
    //   9867: invokespecial 870	android/os/Bundle:<init>	()V
    //   9870: astore 14
    //   9872: aload_3
    //   9873: astore_1
    //   9874: aload 14
    //   9876: ldc_w 3168
    //   9879: iload 6
    //   9881: invokevirtual 876	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9884: aload_3
    //   9885: astore_1
    //   9886: aload 14
    //   9888: ldc_w 2364
    //   9891: aload_2
    //   9892: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9895: aload_3
    //   9896: astore_1
    //   9897: aload 14
    //   9899: ldc_w 3202
    //   9902: iload 12
    //   9904: invokevirtual 1177	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   9907: aload_3
    //   9908: astore_1
    //   9909: aload 14
    //   9911: ldc_w 1069
    //   9914: ldc_w 3194
    //   9917: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9920: aload_3
    //   9921: astore_1
    //   9922: aload 14
    //   9924: ldc_w 3198
    //   9927: iload 7
    //   9929: invokevirtual 876	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9932: aload_3
    //   9933: astore_1
    //   9934: aload 5
    //   9936: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9939: ifne +15 -> 9954
    //   9942: aload_3
    //   9943: astore_1
    //   9944: aload 14
    //   9946: ldc_w 3166
    //   9949: aload 5
    //   9951: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9954: aload_3
    //   9955: astore_1
    //   9956: aload 15
    //   9958: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9961: ifne +15 -> 9976
    //   9964: aload_3
    //   9965: astore_1
    //   9966: aload 14
    //   9968: ldc_w 3196
    //   9971: aload 15
    //   9973: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9976: aload_3
    //   9977: astore_1
    //   9978: ldc_w 3174
    //   9981: aload_3
    //   9982: aload_0
    //   9983: getfield 93	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Anad	Lanad;
    //   9986: getfield 3179	anad:key	I
    //   9989: aload 14
    //   9991: invokestatic 3184	anah:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9994: astore_2
    //   9995: aload_3
    //   9996: astore_1
    //   9997: invokestatic 3189	anfc:a	()Lanfc;
    //   10000: aload_2
    //   10001: invokevirtual 3190	anfc:a	(Landroid/os/Bundle;)V
    //   10004: aload_3
    //   10005: astore_1
    //   10006: aload 4
    //   10008: astore_2
    //   10009: aload_2
    //   10010: ifnull -9826 -> 184
    //   10013: aload_1
    //   10014: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10017: ifne -9833 -> 184
    //   10020: aload_0
    //   10021: aload_1
    //   10022: iconst_1
    //   10023: anewarray 334	java/lang/String
    //   10026: dup
    //   10027: iconst_0
    //   10028: aload_2
    //   10029: aastore
    //   10030: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10033: goto -9849 -> 184
    //   10036: ldc_w 3204
    //   10039: astore_2
    //   10040: aload_3
    //   10041: astore_1
    //   10042: goto -33 -> 10009
    //   10045: astore_2
    //   10046: ldc_w 3192
    //   10049: iconst_1
    //   10050: anewarray 843	java/lang/Object
    //   10053: dup
    //   10054: iconst_0
    //   10055: aload_2
    //   10056: aastore
    //   10057: invokestatic 861	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10060: astore_2
    //   10061: goto -52 -> 10009
    //   10064: ldc_w 3206
    //   10067: aload 4
    //   10069: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10072: ifeq +196 -> 10268
    //   10075: aconst_null
    //   10076: astore_2
    //   10077: aload_2
    //   10078: astore_1
    //   10079: new 109	org/json/JSONObject
    //   10082: dup
    //   10083: aload 5
    //   10085: iconst_0
    //   10086: aaload
    //   10087: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10090: astore_3
    //   10091: aload_2
    //   10092: astore_1
    //   10093: aload_3
    //   10094: ldc_w 1380
    //   10097: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10100: astore_2
    //   10101: aload_2
    //   10102: astore_1
    //   10103: aload_3
    //   10104: ldc_w 3084
    //   10107: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   10110: ifeq -9926 -> 184
    //   10113: aload_2
    //   10114: astore_1
    //   10115: aload_3
    //   10116: ldc_w 3084
    //   10119: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   10122: istore 12
    //   10124: aload_2
    //   10125: astore_1
    //   10126: aload_0
    //   10127: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   10130: aload_0
    //   10131: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   10134: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   10137: invokevirtual 699	bbac:a	(Landroid/app/Activity;)Lbazo;
    //   10140: astore_3
    //   10141: aload_3
    //   10142: ifnull +83 -> 10225
    //   10145: aload_2
    //   10146: astore_1
    //   10147: aload_3
    //   10148: instanceof 3208
    //   10151: ifeq +74 -> 10225
    //   10154: aload_2
    //   10155: astore_1
    //   10156: aload_3
    //   10157: checkcast 3208	bbeo
    //   10160: astore_3
    //   10161: iload 12
    //   10163: ifne +56 -> 10219
    //   10166: iconst_1
    //   10167: istore 12
    //   10169: aload_2
    //   10170: astore_1
    //   10171: aload_3
    //   10172: iload 12
    //   10174: invokeinterface 3209 2 0
    //   10179: goto -9995 -> 184
    //   10182: astore_2
    //   10183: aload_1
    //   10184: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10187: ifne -10003 -> 184
    //   10190: aload_0
    //   10191: aload_1
    //   10192: iconst_1
    //   10193: anewarray 334	java/lang/String
    //   10196: dup
    //   10197: iconst_0
    //   10198: ldc_w 3192
    //   10201: iconst_1
    //   10202: anewarray 843	java/lang/Object
    //   10205: dup
    //   10206: iconst_0
    //   10207: aload_2
    //   10208: aastore
    //   10209: invokestatic 861	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10212: aastore
    //   10213: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10216: goto -10032 -> 184
    //   10219: iconst_0
    //   10220: istore 12
    //   10222: goto -53 -> 10169
    //   10225: aload_2
    //   10226: astore_1
    //   10227: aload_0
    //   10228: iconst_m1
    //   10229: invokespecial 1394	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   10232: checkcast 3211	bbbs
    //   10235: astore_3
    //   10236: aload_3
    //   10237: ifnull -10053 -> 184
    //   10240: iload 12
    //   10242: ifne +20 -> 10262
    //   10245: iconst_1
    //   10246: istore 12
    //   10248: aload_2
    //   10249: astore_1
    //   10250: aload_3
    //   10251: ldc_w 3213
    //   10254: iload 12
    //   10256: invokevirtual 3214	bbbs:a	(Ljava/lang/String;Z)V
    //   10259: goto -10075 -> 184
    //   10262: iconst_0
    //   10263: istore 12
    //   10265: goto -17 -> 10248
    //   10268: ldc_w 3216
    //   10271: aload 4
    //   10273: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10276: ifeq +196 -> 10472
    //   10279: aconst_null
    //   10280: astore_2
    //   10281: aload_2
    //   10282: astore_1
    //   10283: new 109	org/json/JSONObject
    //   10286: dup
    //   10287: aload 5
    //   10289: iconst_0
    //   10290: aaload
    //   10291: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10294: astore_3
    //   10295: aload_2
    //   10296: astore_1
    //   10297: aload_3
    //   10298: ldc_w 1380
    //   10301: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10304: astore_2
    //   10305: aload_2
    //   10306: astore_1
    //   10307: aload_3
    //   10308: ldc_w 3084
    //   10311: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   10314: ifeq -10130 -> 184
    //   10317: aload_2
    //   10318: astore_1
    //   10319: aload_3
    //   10320: ldc_w 3084
    //   10323: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   10326: istore 12
    //   10328: aload_2
    //   10329: astore_1
    //   10330: aload_0
    //   10331: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   10334: aload_0
    //   10335: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   10338: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   10341: invokevirtual 699	bbac:a	(Landroid/app/Activity;)Lbazo;
    //   10344: astore_3
    //   10345: aload_3
    //   10346: ifnull +83 -> 10429
    //   10349: aload_2
    //   10350: astore_1
    //   10351: aload_3
    //   10352: instanceof 3208
    //   10355: ifeq +74 -> 10429
    //   10358: aload_2
    //   10359: astore_1
    //   10360: aload_3
    //   10361: checkcast 3208	bbeo
    //   10364: astore_3
    //   10365: iload 12
    //   10367: ifne +56 -> 10423
    //   10370: iconst_1
    //   10371: istore 12
    //   10373: aload_2
    //   10374: astore_1
    //   10375: aload_3
    //   10376: iload 12
    //   10378: invokeinterface 3218 2 0
    //   10383: goto -10199 -> 184
    //   10386: astore_2
    //   10387: aload_1
    //   10388: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10391: ifne -10207 -> 184
    //   10394: aload_0
    //   10395: aload_1
    //   10396: iconst_1
    //   10397: anewarray 334	java/lang/String
    //   10400: dup
    //   10401: iconst_0
    //   10402: ldc_w 3192
    //   10405: iconst_1
    //   10406: anewarray 843	java/lang/Object
    //   10409: dup
    //   10410: iconst_0
    //   10411: aload_2
    //   10412: aastore
    //   10413: invokestatic 861	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10416: aastore
    //   10417: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10420: goto -10236 -> 184
    //   10423: iconst_0
    //   10424: istore 12
    //   10426: goto -53 -> 10373
    //   10429: aload_2
    //   10430: astore_1
    //   10431: aload_0
    //   10432: iconst_m1
    //   10433: invokespecial 1394	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   10436: checkcast 3211	bbbs
    //   10439: astore_3
    //   10440: aload_3
    //   10441: ifnull -10257 -> 184
    //   10444: iload 12
    //   10446: ifne +20 -> 10466
    //   10449: iconst_1
    //   10450: istore 12
    //   10452: aload_2
    //   10453: astore_1
    //   10454: aload_3
    //   10455: ldc_w 3220
    //   10458: iload 12
    //   10460: invokevirtual 3214	bbbs:a	(Ljava/lang/String;Z)V
    //   10463: goto -10279 -> 184
    //   10466: iconst_0
    //   10467: istore 12
    //   10469: goto -17 -> 10452
    //   10472: ldc_w 3222
    //   10475: aload 4
    //   10477: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10480: ifeq +74 -> 10554
    //   10483: new 109	org/json/JSONObject
    //   10486: dup
    //   10487: aload 5
    //   10489: iconst_0
    //   10490: aaload
    //   10491: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10494: astore_1
    //   10495: new 3224	ajrt
    //   10498: dup
    //   10499: invokespecial 3225	ajrt:<init>	()V
    //   10502: aload_1
    //   10503: ldc_w 3227
    //   10506: invokevirtual 921	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   10509: invokevirtual 3230	ajrt:a	(Lorg/json/JSONArray;)V
    //   10512: goto -10328 -> 184
    //   10515: astore_1
    //   10516: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10519: ifeq -10335 -> 184
    //   10522: ldc 191
    //   10524: iconst_2
    //   10525: new 497	java/lang/StringBuilder
    //   10528: dup
    //   10529: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   10532: ldc_w 3232
    //   10535: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10538: aload 5
    //   10540: iconst_0
    //   10541: aaload
    //   10542: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10545: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10548: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10551: goto -10367 -> 184
    //   10554: ldc_w 3234
    //   10557: aload 4
    //   10559: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10562: ifeq +154 -> 10716
    //   10565: new 109	org/json/JSONObject
    //   10568: dup
    //   10569: aload 5
    //   10571: iconst_0
    //   10572: aaload
    //   10573: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10576: ldc_w 1380
    //   10579: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10582: astore_1
    //   10583: new 3224	ajrt
    //   10586: dup
    //   10587: invokespecial 3225	ajrt:<init>	()V
    //   10590: astore 4
    //   10592: new 109	org/json/JSONObject
    //   10595: dup
    //   10596: invokespecial 168	org/json/JSONObject:<init>	()V
    //   10599: astore_2
    //   10600: new 933	org/json/JSONArray
    //   10603: dup
    //   10604: invokespecial 3235	org/json/JSONArray:<init>	()V
    //   10607: astore_3
    //   10608: aload 4
    //   10610: invokevirtual 3238	ajrt:a	()Ljava/util/ArrayList;
    //   10613: astore 4
    //   10615: iconst_0
    //   10616: istore 6
    //   10618: iload 6
    //   10620: aload 4
    //   10622: invokevirtual 3241	java/util/ArrayList:size	()I
    //   10625: if_icmpge +24 -> 10649
    //   10628: aload_3
    //   10629: aload 4
    //   10631: iload 6
    //   10633: invokevirtual 3243	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   10636: invokevirtual 3246	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   10639: pop
    //   10640: iload 6
    //   10642: iconst_1
    //   10643: iadd
    //   10644: istore 6
    //   10646: goto -28 -> 10618
    //   10649: aload_2
    //   10650: ldc_w 3227
    //   10653: aload_3
    //   10654: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   10657: pop
    //   10658: aload_0
    //   10659: aload_1
    //   10660: iconst_1
    //   10661: anewarray 334	java/lang/String
    //   10664: dup
    //   10665: iconst_0
    //   10666: aload_2
    //   10667: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10670: aastore
    //   10671: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10674: goto -10490 -> 184
    //   10677: astore_1
    //   10678: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10681: ifeq -10497 -> 184
    //   10684: ldc 191
    //   10686: iconst_2
    //   10687: new 497	java/lang/StringBuilder
    //   10690: dup
    //   10691: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   10694: ldc_w 3248
    //   10697: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10700: aload 5
    //   10702: iconst_0
    //   10703: aaload
    //   10704: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10707: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10710: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10713: goto -10529 -> 184
    //   10716: ldc_w 3250
    //   10719: aload 4
    //   10721: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10724: ifeq +221 -> 10945
    //   10727: aload_0
    //   10728: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   10731: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   10734: astore 14
    //   10736: aload_0
    //   10737: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   10740: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   10743: astore_1
    //   10744: aload 14
    //   10746: ifnull -10562 -> 184
    //   10749: aload_1
    //   10750: ifnull -10566 -> 184
    //   10753: aconst_null
    //   10754: astore_1
    //   10755: aconst_null
    //   10756: astore 4
    //   10758: new 109	org/json/JSONObject
    //   10761: dup
    //   10762: aload 5
    //   10764: iconst_0
    //   10765: aaload
    //   10766: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10769: astore_3
    //   10770: aload_3
    //   10771: ldc_w 1380
    //   10774: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10777: astore_2
    //   10778: aload_2
    //   10779: astore_1
    //   10780: aload_3
    //   10781: ifnull +155 -> 10936
    //   10784: new 400	android/os/Bundle
    //   10787: dup
    //   10788: invokespecial 870	android/os/Bundle:<init>	()V
    //   10791: astore 5
    //   10793: aload 5
    //   10795: ldc_w 3252
    //   10798: aload_3
    //   10799: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10802: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   10805: aload 14
    //   10807: invokevirtual 1098	java/lang/Object:getClass	()Ljava/lang/Class;
    //   10810: invokevirtual 138	java/lang/Class:getName	()Ljava/lang/String;
    //   10813: ldc_w 3254
    //   10816: invokevirtual 1103	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   10819: istore 12
    //   10821: aload 4
    //   10823: astore_2
    //   10824: aload_1
    //   10825: astore_3
    //   10826: iload 12
    //   10828: ifeq +41 -> 10869
    //   10831: aconst_null
    //   10832: aload 14
    //   10834: new 109	org/json/JSONObject
    //   10837: dup
    //   10838: aload 5
    //   10840: ldc_w 3252
    //   10843: invokevirtual 3255	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10846: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10849: ldc_w 3257
    //   10852: ldc_w 371
    //   10855: invokevirtual 2378	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10858: invokestatic 3261	rqk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   10861: invokestatic 3266	rtr:a	(Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;)V
    //   10864: aload_1
    //   10865: astore_3
    //   10866: aload 4
    //   10868: astore_2
    //   10869: aload_2
    //   10870: ifnull -10686 -> 184
    //   10873: aload_3
    //   10874: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10877: ifne -10693 -> 184
    //   10880: aload_0
    //   10881: aload_3
    //   10882: iconst_1
    //   10883: anewarray 334	java/lang/String
    //   10886: dup
    //   10887: iconst_0
    //   10888: aload_2
    //   10889: aastore
    //   10890: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10893: goto -10709 -> 184
    //   10896: astore_2
    //   10897: ldc 191
    //   10899: iconst_2
    //   10900: ldc_w 3268
    //   10903: aload_2
    //   10904: invokestatic 2370	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10907: aload 4
    //   10909: astore_2
    //   10910: aload_1
    //   10911: astore_3
    //   10912: goto -43 -> 10869
    //   10915: astore_2
    //   10916: ldc_w 3192
    //   10919: iconst_1
    //   10920: anewarray 843	java/lang/Object
    //   10923: dup
    //   10924: iconst_0
    //   10925: aload_2
    //   10926: aastore
    //   10927: invokestatic 861	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10930: astore_2
    //   10931: aload_1
    //   10932: astore_3
    //   10933: goto -64 -> 10869
    //   10936: ldc_w 3204
    //   10939: astore_2
    //   10940: aload_1
    //   10941: astore_3
    //   10942: goto -73 -> 10869
    //   10945: ldc_w 3270
    //   10948: aload 4
    //   10950: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10953: ifeq +330 -> 11283
    //   10956: aconst_null
    //   10957: ldc_w 367
    //   10960: ldc_w 369
    //   10963: ldc_w 371
    //   10966: ldc_w 373
    //   10969: ldc_w 3272
    //   10972: iconst_0
    //   10973: iconst_1
    //   10974: iconst_0
    //   10975: aload 5
    //   10977: iconst_0
    //   10978: aaload
    //   10979: ldc_w 371
    //   10982: ldc_w 371
    //   10985: ldc_w 371
    //   10988: invokestatic 380	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10991: aload_0
    //   10992: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   10995: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   10998: astore 14
    //   11000: aload_0
    //   11001: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   11004: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   11007: astore_1
    //   11008: aload 14
    //   11010: ifnull -10826 -> 184
    //   11013: aload_1
    //   11014: ifnull -10830 -> 184
    //   11017: aconst_null
    //   11018: astore_3
    //   11019: aconst_null
    //   11020: astore 4
    //   11022: aload 4
    //   11024: astore_1
    //   11025: aload_3
    //   11026: astore_2
    //   11027: new 109	org/json/JSONObject
    //   11030: dup
    //   11031: aload 5
    //   11033: iconst_0
    //   11034: aaload
    //   11035: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11038: astore 5
    //   11040: aload 4
    //   11042: astore_1
    //   11043: aload_3
    //   11044: astore_2
    //   11045: aload 5
    //   11047: ldc_w 1380
    //   11050: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11053: astore_3
    //   11054: aload 4
    //   11056: astore_1
    //   11057: aload_3
    //   11058: astore_2
    //   11059: aload 5
    //   11061: ldc 180
    //   11063: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11066: astore 4
    //   11068: aload 4
    //   11070: astore_1
    //   11071: aload_3
    //   11072: astore_2
    //   11073: aload 5
    //   11075: ldc_w 1069
    //   11078: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11081: astore 15
    //   11083: aload 4
    //   11085: astore_1
    //   11086: aload_3
    //   11087: astore_2
    //   11088: aload 5
    //   11090: ldc 221
    //   11092: invokevirtual 1204	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   11095: astore 5
    //   11097: aload 4
    //   11099: astore_1
    //   11100: aload_3
    //   11101: astore_2
    //   11102: ldc_w 373
    //   11105: aload 15
    //   11107: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11110: ifeq +6262 -> 17372
    //   11113: aload 5
    //   11115: ifnull +6257 -> 17372
    //   11118: aload 4
    //   11120: astore_1
    //   11121: aload_3
    //   11122: astore_2
    //   11123: aload 5
    //   11125: ldc_w 909
    //   11128: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11131: astore 15
    //   11133: aload 4
    //   11135: astore_1
    //   11136: aload_3
    //   11137: astore_2
    //   11138: aload 5
    //   11140: ldc_w 2979
    //   11143: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11146: astore 16
    //   11148: aload 4
    //   11150: astore_1
    //   11151: aload_3
    //   11152: astore_2
    //   11153: aload 5
    //   11155: ldc 156
    //   11157: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11160: astore 5
    //   11162: aload 4
    //   11164: astore_1
    //   11165: aload_3
    //   11166: astore_2
    //   11167: aload 15
    //   11169: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11172: ifne +67 -> 11239
    //   11175: aload 4
    //   11177: astore_1
    //   11178: aload_3
    //   11179: astore_2
    //   11180: aload 5
    //   11182: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11185: ifne +54 -> 11239
    //   11188: aload 4
    //   11190: astore_1
    //   11191: aload_3
    //   11192: astore_2
    //   11193: aload_0
    //   11194: aload 14
    //   11196: aload 15
    //   11198: aload 16
    //   11200: aload 4
    //   11202: aload 5
    //   11204: aload_3
    //   11205: invokespecial 3274	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11208: aconst_null
    //   11209: astore_1
    //   11210: aload_3
    //   11211: astore_2
    //   11212: aload_1
    //   11213: ifnull -11029 -> 184
    //   11216: aload_2
    //   11217: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11220: ifne -11036 -> 184
    //   11223: aload_0
    //   11224: aload_2
    //   11225: iconst_1
    //   11226: anewarray 334	java/lang/String
    //   11229: dup
    //   11230: iconst_0
    //   11231: aload_1
    //   11232: aastore
    //   11233: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11236: goto -11052 -> 184
    //   11239: aload 4
    //   11241: astore_1
    //   11242: aload_3
    //   11243: astore_2
    //   11244: ldc_w 2665
    //   11247: aconst_null
    //   11248: ldc_w 3276
    //   11251: aload 4
    //   11253: invokestatic 365	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11256: astore 4
    //   11258: aload 4
    //   11260: astore_1
    //   11261: aload_3
    //   11262: astore_2
    //   11263: goto -51 -> 11212
    //   11266: astore_3
    //   11267: ldc_w 3278
    //   11270: aconst_null
    //   11271: aload_3
    //   11272: invokevirtual 611	java/lang/Exception:toString	()Ljava/lang/String;
    //   11275: aload_1
    //   11276: invokestatic 365	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11279: astore_1
    //   11280: goto -68 -> 11212
    //   11283: ldc_w 3280
    //   11286: aload 4
    //   11288: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11291: ifeq +295 -> 11586
    //   11294: aload 5
    //   11296: arraylength
    //   11297: ifle +289 -> 11586
    //   11300: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11303: ifeq +33 -> 11336
    //   11306: ldc_w 3282
    //   11309: iconst_2
    //   11310: new 497	java/lang/StringBuilder
    //   11313: dup
    //   11314: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   11317: ldc_w 3284
    //   11320: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11323: aload 5
    //   11325: iconst_0
    //   11326: aaload
    //   11327: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11330: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11333: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11336: new 109	org/json/JSONObject
    //   11339: dup
    //   11340: aload 5
    //   11342: iconst_0
    //   11343: aaload
    //   11344: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11347: ldc 156
    //   11349: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11352: astore_3
    //   11353: aload_3
    //   11354: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11357: ifne -11173 -> 184
    //   11360: aload_3
    //   11361: ldc_w 3286
    //   11364: invokevirtual 3290	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   11367: astore_1
    //   11368: new 2056	java/util/HashMap
    //   11371: dup
    //   11372: invokespecial 3291	java/util/HashMap:<init>	()V
    //   11375: astore_2
    //   11376: aload_1
    //   11377: arraylength
    //   11378: iconst_1
    //   11379: if_icmple -11195 -> 184
    //   11382: aload_1
    //   11383: iconst_1
    //   11384: aaload
    //   11385: ldc_w 3293
    //   11388: invokevirtual 3290	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   11391: astore_1
    //   11392: iconst_0
    //   11393: istore 6
    //   11395: aload_1
    //   11396: arraylength
    //   11397: istore 7
    //   11399: iload 6
    //   11401: iload 7
    //   11403: if_icmpge +49 -> 11452
    //   11406: aload_1
    //   11407: iload 6
    //   11409: aaload
    //   11410: bipush 61
    //   11412: invokevirtual 3296	java/lang/String:indexOf	(I)I
    //   11415: istore 8
    //   11417: iload 8
    //   11419: iconst_m1
    //   11420: if_icmpeq +6095 -> 17515
    //   11423: aload_2
    //   11424: aload_1
    //   11425: iload 6
    //   11427: aaload
    //   11428: iconst_0
    //   11429: iload 8
    //   11431: invokevirtual 3300	java/lang/String:substring	(II)Ljava/lang/String;
    //   11434: aload_1
    //   11435: iload 6
    //   11437: aaload
    //   11438: iload 8
    //   11440: iconst_1
    //   11441: iadd
    //   11442: invokevirtual 3302	java/lang/String:substring	(I)Ljava/lang/String;
    //   11445: invokevirtual 2062	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   11448: pop
    //   11449: goto +6066 -> 17515
    //   11452: aload_3
    //   11453: ldc_w 1720
    //   11456: invokevirtual 1135	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11459: ifeq +102 -> 11561
    //   11462: aload_2
    //   11463: ldc_w 1337
    //   11466: invokevirtual 3303	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11469: checkcast 334	java/lang/String
    //   11472: astore_1
    //   11473: aload_2
    //   11474: ldc 201
    //   11476: invokevirtual 3303	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11479: checkcast 334	java/lang/String
    //   11482: astore_2
    //   11483: aload_0
    //   11484: aload_1
    //   11485: aload_2
    //   11486: aload_3
    //   11487: invokevirtual 3305	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   11490: ifne -11306 -> 184
    //   11493: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11496: ifeq +13 -> 11509
    //   11499: ldc_w 3282
    //   11502: iconst_2
    //   11503: ldc_w 2408
    //   11506: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11509: aload_0
    //   11510: aload 5
    //   11512: iconst_0
    //   11513: aaload
    //   11514: iconst_0
    //   11515: invokevirtual 2413	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   11518: goto -11334 -> 184
    //   11521: astore_1
    //   11522: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11525: ifeq -11341 -> 184
    //   11528: ldc_w 3282
    //   11531: iconst_2
    //   11532: new 497	java/lang/StringBuilder
    //   11535: dup
    //   11536: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   11539: ldc_w 3307
    //   11542: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11545: aload 5
    //   11547: iconst_0
    //   11548: aaload
    //   11549: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11552: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11555: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11558: goto -11374 -> 184
    //   11561: aload_2
    //   11562: ldc_w 3072
    //   11565: invokevirtual 3303	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11568: checkcast 334	java/lang/String
    //   11571: astore_1
    //   11572: aload_2
    //   11573: ldc_w 3309
    //   11576: invokevirtual 3303	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11579: checkcast 334	java/lang/String
    //   11582: astore_2
    //   11583: goto -100 -> 11483
    //   11586: ldc_w 3311
    //   11589: aload 4
    //   11591: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11594: ifeq +66 -> 11660
    //   11597: aload 5
    //   11599: arraylength
    //   11600: ifle +60 -> 11660
    //   11603: aload_0
    //   11604: new 109	org/json/JSONObject
    //   11607: dup
    //   11608: aload 5
    //   11610: iconst_0
    //   11611: aaload
    //   11612: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11615: invokevirtual 3313	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;)V
    //   11618: goto -11434 -> 184
    //   11621: astore_1
    //   11622: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11625: ifeq -11441 -> 184
    //   11628: ldc 191
    //   11630: iconst_2
    //   11631: new 497	java/lang/StringBuilder
    //   11634: dup
    //   11635: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   11638: ldc_w 3315
    //   11641: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11644: aload 5
    //   11646: iconst_0
    //   11647: aaload
    //   11648: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11651: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11654: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11657: goto -11473 -> 184
    //   11660: ldc_w 3317
    //   11663: aload 4
    //   11665: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11668: ifeq +10 -> 11678
    //   11671: aload_0
    //   11672: invokevirtual 3318	com/tencent/mobileqq/jsp/UiApiPlugin:c	()V
    //   11675: goto -11491 -> 184
    //   11678: ldc_w 3320
    //   11681: aload 4
    //   11683: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11686: ifeq +72 -> 11758
    //   11689: aload 5
    //   11691: arraylength
    //   11692: ifle +66 -> 11758
    //   11695: aload_0
    //   11696: new 109	org/json/JSONObject
    //   11699: dup
    //   11700: aload 5
    //   11702: iconst_0
    //   11703: aaload
    //   11704: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11707: ldc_w 1380
    //   11710: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11713: invokevirtual 3322	com/tencent/mobileqq/jsp/UiApiPlugin:b	(Ljava/lang/String;)V
    //   11716: goto -11532 -> 184
    //   11719: astore_1
    //   11720: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11723: ifeq -11539 -> 184
    //   11726: ldc 191
    //   11728: iconst_2
    //   11729: new 497	java/lang/StringBuilder
    //   11732: dup
    //   11733: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   11736: ldc_w 3232
    //   11739: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11742: aload 5
    //   11744: iconst_0
    //   11745: aaload
    //   11746: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11749: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11752: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11755: goto -11571 -> 184
    //   11758: ldc_w 3324
    //   11761: aload 4
    //   11763: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11766: ifeq +112 -> 11878
    //   11769: new 109	org/json/JSONObject
    //   11772: dup
    //   11773: aload 5
    //   11775: iconst_0
    //   11776: aaload
    //   11777: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11780: astore_1
    //   11781: aload_0
    //   11782: invokevirtual 2231	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbbeu;
    //   11785: astore_2
    //   11786: aload_2
    //   11787: ifnull -11603 -> 184
    //   11790: aload_2
    //   11791: aload_1
    //   11792: invokeinterface 3325 2 0
    //   11797: goto -11613 -> 184
    //   11800: astore_1
    //   11801: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11804: ifeq -11620 -> 184
    //   11807: ldc 191
    //   11809: iconst_2
    //   11810: new 497	java/lang/StringBuilder
    //   11813: dup
    //   11814: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   11817: ldc_w 3327
    //   11820: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11823: aload_1
    //   11824: invokevirtual 3328	org/json/JSONException:toString	()Ljava/lang/String;
    //   11827: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11830: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11833: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11836: goto -11652 -> 184
    //   11839: astore_1
    //   11840: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11843: ifeq -11659 -> 184
    //   11846: ldc 191
    //   11848: iconst_2
    //   11849: new 497	java/lang/StringBuilder
    //   11852: dup
    //   11853: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   11856: ldc_w 3327
    //   11859: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11862: aload_1
    //   11863: invokevirtual 611	java/lang/Exception:toString	()Ljava/lang/String;
    //   11866: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11869: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11872: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11875: goto -11691 -> 184
    //   11878: ldc_w 3330
    //   11881: aload 4
    //   11883: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11886: ifeq +194 -> 12080
    //   11889: aload 5
    //   11891: arraylength
    //   11892: ifle +188 -> 12080
    //   11895: new 109	org/json/JSONObject
    //   11898: dup
    //   11899: aload 5
    //   11901: iconst_0
    //   11902: aaload
    //   11903: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11906: ldc_w 1380
    //   11909: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11912: astore_1
    //   11913: aload_1
    //   11914: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11917: ifeq +14 -> 11931
    //   11920: ldc 191
    //   11922: iconst_1
    //   11923: ldc_w 3332
    //   11926: invokestatic 613	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11929: iconst_1
    //   11930: ireturn
    //   11931: new 109	org/json/JSONObject
    //   11934: dup
    //   11935: invokespecial 168	org/json/JSONObject:<init>	()V
    //   11938: astore_2
    //   11939: new 109	org/json/JSONObject
    //   11942: dup
    //   11943: invokespecial 168	org/json/JSONObject:<init>	()V
    //   11946: astore_3
    //   11947: aload_0
    //   11948: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   11951: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   11954: invokevirtual 349	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   11957: ldc_w 350
    //   11960: invokevirtual 356	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   11963: istore 7
    //   11965: iload 7
    //   11967: istore 6
    //   11969: invokestatic 1530	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   11972: iconst_1
    //   11973: if_icmpne +18 -> 11991
    //   11976: iload 7
    //   11978: aload_0
    //   11979: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   11982: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   11985: invokestatic 1533	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   11988: iadd
    //   11989: istore 6
    //   11991: aload_3
    //   11992: ldc_w 1447
    //   11995: iload 6
    //   11997: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   12000: pop
    //   12001: aload_2
    //   12002: ldc_w 1429
    //   12005: iconst_0
    //   12006: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   12009: pop
    //   12010: aload_2
    //   12011: ldc 178
    //   12013: ldc_w 3334
    //   12016: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   12019: pop
    //   12020: aload_2
    //   12021: ldc 221
    //   12023: aload_3
    //   12024: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   12027: pop
    //   12028: aload_0
    //   12029: aload_1
    //   12030: iconst_1
    //   12031: anewarray 334	java/lang/String
    //   12034: dup
    //   12035: iconst_0
    //   12036: aload_2
    //   12037: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12040: aastore
    //   12041: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12044: goto -11860 -> 184
    //   12047: astore_1
    //   12048: ldc 191
    //   12050: iconst_1
    //   12051: new 497	java/lang/StringBuilder
    //   12054: dup
    //   12055: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   12058: ldc_w 3336
    //   12061: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12064: aload_1
    //   12065: invokestatic 2464	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   12068: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12071: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12074: invokestatic 613	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   12077: goto -11893 -> 184
    //   12080: ldc_w 3338
    //   12083: aload 4
    //   12085: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12088: ifeq +78 -> 12166
    //   12091: new 109	org/json/JSONObject
    //   12094: dup
    //   12095: aload 5
    //   12097: iconst_0
    //   12098: aaload
    //   12099: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12102: astore_1
    //   12103: aload_1
    //   12104: ldc_w 1337
    //   12107: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12110: astore_2
    //   12111: aload_0
    //   12112: aload_1
    //   12113: ldc_w 1380
    //   12116: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12119: putfield 3340	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   12122: aload_0
    //   12123: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   12126: ifnonnull +17 -> 12143
    //   12129: aload_0
    //   12130: invokestatic 1679	wis:a	()Lwis;
    //   12133: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   12136: aload_0
    //   12137: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   12140: invokevirtual 1680	wis:a	()V
    //   12143: aload_0
    //   12144: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   12147: aload_2
    //   12148: new 3342	aqtv
    //   12151: dup
    //   12152: aload_0
    //   12153: aload_2
    //   12154: invokespecial 3343	aqtv:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   12157: invokevirtual 3346	wis:a	(Ljava/lang/String;Lwiu;)V
    //   12160: goto -11976 -> 184
    //   12163: astore_1
    //   12164: iconst_1
    //   12165: ireturn
    //   12166: ldc_w 3348
    //   12169: aload 4
    //   12171: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12174: ifeq +441 -> 12615
    //   12177: aload 5
    //   12179: arraylength
    //   12180: iconst_1
    //   12181: if_icmpne +434 -> 12615
    //   12184: new 109	org/json/JSONObject
    //   12187: dup
    //   12188: aload 5
    //   12190: iconst_0
    //   12191: aaload
    //   12192: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12195: astore_3
    //   12196: aload_3
    //   12197: ldc_w 3350
    //   12200: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12203: astore 4
    //   12205: aload_3
    //   12206: ldc_w 3352
    //   12209: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12212: astore_1
    //   12213: aload_1
    //   12214: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12217: ifeq +22 -> 12239
    //   12220: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12223: ifeq +5301 -> 17524
    //   12226: ldc_w 3354
    //   12229: iconst_2
    //   12230: ldc_w 3356
    //   12233: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12236: goto +5288 -> 17524
    //   12239: aload_0
    //   12240: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   12243: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   12246: astore_2
    //   12247: aload_2
    //   12248: ifnull +10 -> 12258
    //   12251: aload_2
    //   12252: invokevirtual 3360	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lmzr;
    //   12255: ifnonnull +22 -> 12277
    //   12258: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12261: ifeq +5265 -> 17526
    //   12264: ldc_w 3354
    //   12267: iconst_2
    //   12268: ldc_w 3362
    //   12271: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12274: goto +5252 -> 17526
    //   12277: aload_2
    //   12278: invokevirtual 3360	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lmzr;
    //   12281: getfield 3365	mzr:jdField_a_of_type_Int	I
    //   12284: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12287: astore_2
    //   12288: aload_3
    //   12289: ldc_w 3059
    //   12292: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   12295: istore 6
    //   12297: iload 6
    //   12299: iconst_1
    //   12300: if_icmpne +226 -> 12526
    //   12303: new 3367	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   12306: dup
    //   12307: invokespecial 3368	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   12310: astore_3
    //   12311: aload_3
    //   12312: getfield 3371	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12315: sipush 1814
    //   12318: invokevirtual 272	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12321: aload_3
    //   12322: getfield 3374	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12325: bipush 48
    //   12327: invokevirtual 272	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12330: aload_1
    //   12331: invokevirtual 3377	java/lang/String:getBytes	()[B
    //   12334: arraylength
    //   12335: bipush 6
    //   12337: iadd
    //   12338: invokestatic 3383	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   12341: astore 4
    //   12343: aload 4
    //   12345: aload_2
    //   12346: invokevirtual 2254	java/lang/Integer:intValue	()I
    //   12349: invokevirtual 3385	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   12352: pop
    //   12353: aload 4
    //   12355: aload_1
    //   12356: invokevirtual 3377	java/lang/String:getBytes	()[B
    //   12359: arraylength
    //   12360: i2s
    //   12361: invokevirtual 3389	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   12364: pop
    //   12365: aload 4
    //   12367: aload_1
    //   12368: invokevirtual 3377	java/lang/String:getBytes	()[B
    //   12371: invokevirtual 3392	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   12374: pop
    //   12375: aload_3
    //   12376: getfield 3396	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12379: aload 4
    //   12381: invokevirtual 3399	java/nio/ByteBuffer:array	()[B
    //   12384: invokestatic 3405	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12387: invokevirtual 3410	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   12390: new 290	mqq/app/NewIntent
    //   12393: dup
    //   12394: aload_0
    //   12395: invokevirtual 1835	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   12398: ldc_w 298
    //   12401: invokespecial 301	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12404: astore_2
    //   12405: new 400	android/os/Bundle
    //   12408: dup
    //   12409: invokespecial 870	android/os/Bundle:<init>	()V
    //   12412: astore 4
    //   12414: aload 4
    //   12416: ldc_w 3352
    //   12419: aload_1
    //   12420: invokevirtual 882	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   12423: aload_2
    //   12424: aload 4
    //   12426: invokevirtual 3411	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   12429: pop
    //   12430: aload_2
    //   12431: ldc_w 306
    //   12434: ldc_w 3413
    //   12437: invokevirtual 309	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12440: pop
    //   12441: aload_2
    //   12442: ldc 221
    //   12444: aload_3
    //   12445: invokevirtual 3414	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   12448: invokevirtual 316	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12451: pop
    //   12452: aload_2
    //   12453: ldc_w 3416
    //   12456: iconst_1
    //   12457: invokevirtual 3417	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12460: pop
    //   12461: aload_2
    //   12462: new 3419	aqtw
    //   12465: dup
    //   12466: aload_0
    //   12467: invokespecial 3420	aqtw:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   12470: invokevirtual 325	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   12473: aload_0
    //   12474: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   12477: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   12480: aload_2
    //   12481: invokevirtual 331	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12484: goto -12300 -> 184
    //   12487: astore_1
    //   12488: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12491: ifeq -12307 -> 184
    //   12494: ldc 191
    //   12496: iconst_2
    //   12497: new 497	java/lang/StringBuilder
    //   12500: dup
    //   12501: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   12504: ldc_w 3422
    //   12507: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12510: aload 5
    //   12512: iconst_0
    //   12513: aaload
    //   12514: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12517: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12520: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12523: goto -12339 -> 184
    //   12526: iload 6
    //   12528: ifne -12344 -> 184
    //   12531: aload_0
    //   12532: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   12535: ifnonnull +17 -> 12552
    //   12538: aload_0
    //   12539: invokestatic 1679	wis:a	()Lwis;
    //   12542: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   12545: aload_0
    //   12546: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   12549: invokevirtual 1680	wis:a	()V
    //   12552: aload_0
    //   12553: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   12556: aload_2
    //   12557: aload_1
    //   12558: aload 4
    //   12560: new 3424	aqtx
    //   12563: dup
    //   12564: aload_0
    //   12565: aload_2
    //   12566: aload_1
    //   12567: invokespecial 3427	aqtx:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;)V
    //   12570: invokevirtual 3430	wis:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lwiu;)V
    //   12573: goto -12389 -> 184
    //   12576: astore_1
    //   12577: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12580: ifeq -12396 -> 184
    //   12583: ldc 191
    //   12585: iconst_2
    //   12586: new 497	java/lang/StringBuilder
    //   12589: dup
    //   12590: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   12593: ldc_w 3432
    //   12596: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12599: aload 5
    //   12601: iconst_0
    //   12602: aaload
    //   12603: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12606: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12609: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12612: goto -12428 -> 184
    //   12615: ldc_w 3434
    //   12618: aload 4
    //   12620: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12623: ifeq +455 -> 13078
    //   12626: aload 5
    //   12628: arraylength
    //   12629: iconst_1
    //   12630: if_icmpne +448 -> 13078
    //   12633: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12636: ifeq +33 -> 12669
    //   12639: ldc_w 3354
    //   12642: iconst_2
    //   12643: new 497	java/lang/StringBuilder
    //   12646: dup
    //   12647: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   12650: ldc_w 3436
    //   12653: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12656: aload 5
    //   12658: iconst_0
    //   12659: aaload
    //   12660: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12663: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12666: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12669: new 109	org/json/JSONObject
    //   12672: dup
    //   12673: aload 5
    //   12675: iconst_0
    //   12676: aaload
    //   12677: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12680: astore_3
    //   12681: aload_3
    //   12682: ldc_w 3350
    //   12685: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12688: astore_1
    //   12689: aload_3
    //   12690: ldc_w 3352
    //   12693: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12696: astore_2
    //   12697: aload_3
    //   12698: ldc_w 3438
    //   12701: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12704: astore_3
    //   12705: aload_2
    //   12706: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12709: ifne +10 -> 12719
    //   12712: aload_3
    //   12713: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12716: ifeq +49 -> 12765
    //   12719: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12722: ifeq +4806 -> 17528
    //   12725: ldc_w 3354
    //   12728: iconst_2
    //   12729: new 497	java/lang/StringBuilder
    //   12732: dup
    //   12733: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   12736: ldc_w 3440
    //   12739: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12742: aload_3
    //   12743: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12746: ldc_w 3442
    //   12749: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12752: aload_2
    //   12753: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12756: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12759: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12762: goto +4766 -> 17528
    //   12765: aload_0
    //   12766: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   12769: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   12772: astore 4
    //   12774: aload 4
    //   12776: ifnull +11 -> 12787
    //   12779: aload 4
    //   12781: invokevirtual 3360	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lmzr;
    //   12784: ifnonnull +22 -> 12806
    //   12787: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12790: ifeq +4740 -> 17530
    //   12793: ldc_w 3354
    //   12796: iconst_2
    //   12797: ldc_w 3444
    //   12800: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12803: goto +4727 -> 17530
    //   12806: aload 4
    //   12808: invokevirtual 3360	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lmzr;
    //   12811: getfield 3365	mzr:jdField_a_of_type_Int	I
    //   12814: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12817: astore 4
    //   12819: new 3367	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   12822: dup
    //   12823: invokespecial 3368	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   12826: astore 14
    //   12828: aload 14
    //   12830: getfield 3371	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12833: sipush 1814
    //   12836: invokevirtual 272	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12839: aload 14
    //   12841: getfield 3374	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12844: bipush 48
    //   12846: invokevirtual 272	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12849: aload_3
    //   12850: invokevirtual 3377	java/lang/String:getBytes	()[B
    //   12853: arraylength
    //   12854: bipush 6
    //   12856: iadd
    //   12857: invokestatic 3383	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   12860: astore 15
    //   12862: aload 15
    //   12864: aload 4
    //   12866: invokevirtual 2254	java/lang/Integer:intValue	()I
    //   12869: invokevirtual 3385	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   12872: pop
    //   12873: aload 15
    //   12875: aload_3
    //   12876: invokevirtual 3377	java/lang/String:getBytes	()[B
    //   12879: arraylength
    //   12880: i2s
    //   12881: invokevirtual 3389	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   12884: pop
    //   12885: aload 15
    //   12887: aload_3
    //   12888: invokevirtual 3377	java/lang/String:getBytes	()[B
    //   12891: invokevirtual 3392	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   12894: pop
    //   12895: aload 14
    //   12897: getfield 3396	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12900: aload 15
    //   12902: invokevirtual 3399	java/nio/ByteBuffer:array	()[B
    //   12905: invokestatic 3405	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12908: invokevirtual 3410	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   12911: new 290	mqq/app/NewIntent
    //   12914: dup
    //   12915: aload_0
    //   12916: invokevirtual 1835	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   12919: ldc_w 298
    //   12922: invokespecial 301	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12925: astore_3
    //   12926: aload_3
    //   12927: new 400	android/os/Bundle
    //   12930: dup
    //   12931: invokespecial 870	android/os/Bundle:<init>	()V
    //   12934: invokevirtual 3411	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   12937: pop
    //   12938: aload_3
    //   12939: ldc_w 306
    //   12942: ldc_w 3413
    //   12945: invokevirtual 309	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12948: pop
    //   12949: aload_3
    //   12950: ldc 221
    //   12952: aload 14
    //   12954: invokevirtual 3414	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   12957: invokevirtual 316	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12960: pop
    //   12961: aload_3
    //   12962: ldc_w 3416
    //   12965: iconst_1
    //   12966: invokevirtual 3417	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12969: pop
    //   12970: aload_3
    //   12971: new 3446	aqty
    //   12974: dup
    //   12975: aload_0
    //   12976: aload 4
    //   12978: aload_2
    //   12979: aload_1
    //   12980: invokespecial 3449	aqty:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V
    //   12983: invokevirtual 325	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   12986: aload_0
    //   12987: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   12990: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   12993: aload_3
    //   12994: invokevirtual 331	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12997: goto -12813 -> 184
    //   13000: astore_1
    //   13001: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13004: ifeq -12820 -> 184
    //   13007: ldc 191
    //   13009: iconst_2
    //   13010: new 497	java/lang/StringBuilder
    //   13013: dup
    //   13014: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13017: ldc_w 3422
    //   13020: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13023: aload 5
    //   13025: iconst_0
    //   13026: aaload
    //   13027: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13030: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13033: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13036: goto -12852 -> 184
    //   13039: astore_1
    //   13040: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13043: ifeq -12859 -> 184
    //   13046: ldc 191
    //   13048: iconst_2
    //   13049: new 497	java/lang/StringBuilder
    //   13052: dup
    //   13053: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13056: ldc_w 3432
    //   13059: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13062: aload 5
    //   13064: iconst_0
    //   13065: aaload
    //   13066: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13069: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13072: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13075: goto -12891 -> 184
    //   13078: ldc_w 3451
    //   13081: aload 4
    //   13083: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13086: ifeq +200 -> 13286
    //   13089: aload_0
    //   13090: new 109	org/json/JSONObject
    //   13093: dup
    //   13094: aload 5
    //   13096: iconst_0
    //   13097: aaload
    //   13098: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13101: ldc_w 1380
    //   13104: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13107: putfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   13110: aload_0
    //   13111: invokevirtual 2231	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbbeu;
    //   13114: astore_1
    //   13115: aload_1
    //   13116: ifnull -12932 -> 184
    //   13119: aload_1
    //   13120: invokeinterface 3453 1 0
    //   13125: istore 6
    //   13127: aload_0
    //   13128: aload_0
    //   13129: getfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   13132: iconst_1
    //   13133: anewarray 334	java/lang/String
    //   13136: dup
    //   13137: iconst_0
    //   13138: new 497	java/lang/StringBuilder
    //   13141: dup
    //   13142: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13145: ldc_w 3455
    //   13148: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13151: iload 6
    //   13153: invokevirtual 1063	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13156: ldc_w 1433
    //   13159: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13162: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13165: aastore
    //   13166: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13169: goto -12985 -> 184
    //   13172: astore_1
    //   13173: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13176: ifeq -12992 -> 184
    //   13179: aload_0
    //   13180: aload_0
    //   13181: getfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   13184: iconst_1
    //   13185: anewarray 334	java/lang/String
    //   13188: dup
    //   13189: iconst_0
    //   13190: ldc_w 3457
    //   13193: aastore
    //   13194: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13197: ldc 191
    //   13199: iconst_2
    //   13200: new 497	java/lang/StringBuilder
    //   13203: dup
    //   13204: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13207: ldc_w 3459
    //   13210: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13213: aload_1
    //   13214: invokevirtual 3328	org/json/JSONException:toString	()Ljava/lang/String;
    //   13217: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13220: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13223: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13226: goto -13042 -> 184
    //   13229: astore_1
    //   13230: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13233: ifeq -13049 -> 184
    //   13236: aload_0
    //   13237: aload_0
    //   13238: getfield 2640	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   13241: iconst_1
    //   13242: anewarray 334	java/lang/String
    //   13245: dup
    //   13246: iconst_0
    //   13247: ldc_w 3457
    //   13250: aastore
    //   13251: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13254: ldc 191
    //   13256: iconst_2
    //   13257: new 497	java/lang/StringBuilder
    //   13260: dup
    //   13261: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13264: ldc_w 3459
    //   13267: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13270: aload_1
    //   13271: invokevirtual 611	java/lang/Exception:toString	()Ljava/lang/String;
    //   13274: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13277: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13280: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13283: goto -13099 -> 184
    //   13286: ldc_w 3461
    //   13289: aload 4
    //   13291: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13294: ifeq +135 -> 13429
    //   13297: aload 5
    //   13299: arraylength
    //   13300: iconst_1
    //   13301: if_icmpgt +128 -> 13429
    //   13304: ldc_w 371
    //   13307: astore_1
    //   13308: aload 5
    //   13310: arraylength
    //   13311: iconst_1
    //   13312: if_icmpne +4051 -> 17363
    //   13315: new 109	org/json/JSONObject
    //   13318: dup
    //   13319: aload 5
    //   13321: iconst_0
    //   13322: aaload
    //   13323: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13326: astore_3
    //   13327: aload_3
    //   13328: ldc_w 909
    //   13331: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13334: astore_2
    //   13335: aload_2
    //   13336: astore_1
    //   13337: aload_3
    //   13338: ldc_w 1382
    //   13341: invokevirtual 1094	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   13344: ifeq +4019 -> 17363
    //   13347: aload_3
    //   13348: ldc_w 1382
    //   13351: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13354: astore_1
    //   13355: aload_0
    //   13356: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   13359: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   13362: astore_3
    //   13363: aload_3
    //   13364: ifnull -13180 -> 184
    //   13367: aload_3
    //   13368: instanceof 1323
    //   13371: ifeq -13187 -> 184
    //   13374: aload_3
    //   13375: checkcast 1323	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13378: invokevirtual 2868	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13381: checkcast 2870	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13384: iconst_0
    //   13385: aload_2
    //   13386: aload_1
    //   13387: invokevirtual 3464	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   13390: goto -13206 -> 184
    //   13393: astore_1
    //   13394: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13397: ifeq -13213 -> 184
    //   13400: ldc 191
    //   13402: iconst_4
    //   13403: new 497	java/lang/StringBuilder
    //   13406: dup
    //   13407: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13410: ldc_w 3466
    //   13413: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13416: aload_1
    //   13417: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13420: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13423: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13426: goto -13242 -> 184
    //   13429: ldc_w 3468
    //   13432: aload 4
    //   13434: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13437: ifeq +256 -> 13693
    //   13440: aload 5
    //   13442: arraylength
    //   13443: iconst_1
    //   13444: if_icmpgt +249 -> 13693
    //   13447: aload 5
    //   13449: arraylength
    //   13450: iconst_1
    //   13451: if_icmpne -13267 -> 184
    //   13454: new 109	org/json/JSONObject
    //   13457: dup
    //   13458: aload 5
    //   13460: iconst_0
    //   13461: aaload
    //   13462: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13465: astore_1
    //   13466: aload_1
    //   13467: ldc_w 3084
    //   13470: iconst_m1
    //   13471: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13474: istore 6
    //   13476: aload_1
    //   13477: ldc_w 3172
    //   13480: iconst_m1
    //   13481: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13484: istore 7
    //   13486: aload_0
    //   13487: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   13490: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   13493: astore_1
    //   13494: aload_1
    //   13495: ifnull -13311 -> 184
    //   13498: aload_1
    //   13499: instanceof 1323
    //   13502: ifeq -13318 -> 184
    //   13505: aload_1
    //   13506: checkcast 1323	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13509: invokevirtual 2868	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13512: checkcast 2870	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13515: astore_1
    //   13516: aload_1
    //   13517: ifnull -13333 -> 184
    //   13520: iload 7
    //   13522: iconst_1
    //   13523: if_icmpne +134 -> 13657
    //   13526: aload_1
    //   13527: iconst_0
    //   13528: putfield 3469	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13531: aload_1
    //   13532: iconst_1
    //   13533: invokevirtual 3470	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   13536: iload 6
    //   13538: iconst_1
    //   13539: if_icmpne +136 -> 13675
    //   13542: aload_1
    //   13543: iconst_0
    //   13544: putfield 3469	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13547: aload_1
    //   13548: iconst_1
    //   13549: invokevirtual 3471	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:d	(Z)V
    //   13552: goto -13368 -> 184
    //   13555: astore_1
    //   13556: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13559: ifeq -13375 -> 184
    //   13562: ldc 191
    //   13564: iconst_4
    //   13565: new 497	java/lang/StringBuilder
    //   13568: dup
    //   13569: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13572: ldc_w 3473
    //   13575: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13578: aload_1
    //   13579: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13582: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13585: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13588: goto -13404 -> 184
    //   13591: astore_2
    //   13592: ldc 191
    //   13594: iconst_1
    //   13595: new 497	java/lang/StringBuilder
    //   13598: dup
    //   13599: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13602: ldc_w 3475
    //   13605: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13608: aload_2
    //   13609: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13612: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13615: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13618: iconst_m1
    //   13619: istore 6
    //   13621: goto -145 -> 13476
    //   13624: astore_1
    //   13625: iconst_m1
    //   13626: istore 7
    //   13628: ldc 191
    //   13630: iconst_1
    //   13631: new 497	java/lang/StringBuilder
    //   13634: dup
    //   13635: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13638: ldc_w 3477
    //   13641: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13644: aload_1
    //   13645: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13648: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13651: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13654: goto -168 -> 13486
    //   13657: iload 7
    //   13659: ifne -123 -> 13536
    //   13662: aload_1
    //   13663: iconst_1
    //   13664: putfield 3469	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13667: aload_1
    //   13668: iconst_0
    //   13669: invokevirtual 3470	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   13672: goto -136 -> 13536
    //   13675: iload 6
    //   13677: ifne -13493 -> 184
    //   13680: aload_1
    //   13681: iconst_1
    //   13682: putfield 3469	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13685: aload_1
    //   13686: iconst_0
    //   13687: invokevirtual 3471	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:d	(Z)V
    //   13690: goto -13506 -> 184
    //   13693: ldc_w 3479
    //   13696: aload 4
    //   13698: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13701: ifeq +168 -> 13869
    //   13704: aload 5
    //   13706: arraylength
    //   13707: iconst_1
    //   13708: if_icmpgt +161 -> 13869
    //   13711: aload 5
    //   13713: arraylength
    //   13714: iconst_1
    //   13715: if_icmpne -13531 -> 184
    //   13718: aload 5
    //   13720: arraylength
    //   13721: iconst_1
    //   13722: if_icmpne -13538 -> 184
    //   13725: new 109	org/json/JSONObject
    //   13728: dup
    //   13729: aload 5
    //   13731: iconst_0
    //   13732: aaload
    //   13733: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13736: ldc_w 3481
    //   13739: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13742: astore_1
    //   13743: aload_0
    //   13744: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   13747: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   13750: astore_2
    //   13751: aload_2
    //   13752: ifnull -13568 -> 184
    //   13755: aload_2
    //   13756: instanceof 1323
    //   13759: ifeq -13575 -> 184
    //   13762: aload_2
    //   13763: checkcast 1323	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13766: invokevirtual 2868	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13769: checkcast 2870	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13772: astore_3
    //   13773: ldc_w 642
    //   13776: aload_1
    //   13777: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13780: ifeq +61 -> 13841
    //   13783: aload_2
    //   13784: ldc_w 3483
    //   13787: invokevirtual 3484	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13790: checkcast 3486	android/view/inputmethod/InputMethodManager
    //   13793: aload_3
    //   13794: invokevirtual 3489	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13797: iconst_0
    //   13798: invokevirtual 3493	android/view/inputmethod/InputMethodManager:showSoftInput	(Landroid/view/View;I)Z
    //   13801: pop
    //   13802: goto -13618 -> 184
    //   13805: astore_1
    //   13806: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13809: ifeq -13625 -> 184
    //   13812: ldc 191
    //   13814: iconst_4
    //   13815: new 497	java/lang/StringBuilder
    //   13818: dup
    //   13819: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13822: ldc_w 3495
    //   13825: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13828: aload_1
    //   13829: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13832: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13835: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13838: goto -13654 -> 184
    //   13841: aload_2
    //   13842: ldc_w 3483
    //   13845: invokevirtual 3484	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13848: checkcast 3486	android/view/inputmethod/InputMethodManager
    //   13851: aload_2
    //   13852: invokevirtual 2892	android/app/Activity:getWindow	()Landroid/view/Window;
    //   13855: invokevirtual 3498	android/view/Window:getDecorView	()Landroid/view/View;
    //   13858: invokevirtual 3502	android/view/View:getWindowToken	()Landroid/os/IBinder;
    //   13861: iconst_0
    //   13862: invokevirtual 3506	android/view/inputmethod/InputMethodManager:hideSoftInputFromWindow	(Landroid/os/IBinder;I)Z
    //   13865: pop
    //   13866: goto -13682 -> 184
    //   13869: ldc_w 3508
    //   13872: aload 4
    //   13874: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13877: ifeq +96 -> 13973
    //   13880: aload 5
    //   13882: arraylength
    //   13883: iconst_1
    //   13884: if_icmpgt +89 -> 13973
    //   13887: aload 5
    //   13889: arraylength
    //   13890: iconst_1
    //   13891: if_icmpne -13707 -> 184
    //   13894: new 109	org/json/JSONObject
    //   13897: dup
    //   13898: aload 5
    //   13900: iconst_0
    //   13901: aaload
    //   13902: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13905: ldc_w 1380
    //   13908: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13911: astore_1
    //   13912: aload_1
    //   13913: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13916: ifne -13732 -> 184
    //   13919: aload_0
    //   13920: aload_1
    //   13921: iconst_1
    //   13922: anewarray 334	java/lang/String
    //   13925: dup
    //   13926: iconst_0
    //   13927: ldc_w 3510
    //   13930: aastore
    //   13931: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13934: goto -13750 -> 184
    //   13937: astore_1
    //   13938: invokestatic 2344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13941: ifeq -13757 -> 184
    //   13944: ldc 191
    //   13946: iconst_4
    //   13947: new 497	java/lang/StringBuilder
    //   13950: dup
    //   13951: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   13954: ldc_w 3512
    //   13957: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13960: aload_1
    //   13961: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13964: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13967: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13970: goto -13786 -> 184
    //   13973: ldc_w 3514
    //   13976: aload 4
    //   13978: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13981: ifeq +114 -> 14095
    //   13984: aload 5
    //   13986: arraylength
    //   13987: ifle +108 -> 14095
    //   13990: new 109	org/json/JSONObject
    //   13993: dup
    //   13994: aload 5
    //   13996: iconst_0
    //   13997: aaload
    //   13998: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14001: astore_3
    //   14002: aload_0
    //   14003: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14006: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   14009: astore_1
    //   14010: aload_0
    //   14011: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14014: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   14017: astore_2
    //   14018: aload_3
    //   14019: ldc_w 2364
    //   14022: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14025: astore_3
    //   14026: aload_3
    //   14027: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14030: ifne -13846 -> 184
    //   14033: aload_1
    //   14034: ifnull -13850 -> 184
    //   14037: aload_2
    //   14038: ifnull -13854 -> 184
    //   14041: aload_1
    //   14042: new 3516	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   14045: dup
    //   14046: aload_3
    //   14047: bipush 90
    //   14049: invokespecial 3518	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   14052: invokestatic 3523	com/tencent/mobileqq/activity/ProfileActivity:b	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)V
    //   14055: goto -13871 -> 184
    //   14058: astore_1
    //   14059: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14062: ifeq -13878 -> 184
    //   14065: ldc_w 2314
    //   14068: iconst_2
    //   14069: new 497	java/lang/StringBuilder
    //   14072: dup
    //   14073: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   14076: ldc_w 3525
    //   14079: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14082: aload_1
    //   14083: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14086: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14089: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14092: goto -13908 -> 184
    //   14095: ldc_w 3527
    //   14098: aload 4
    //   14100: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14103: ifeq +96 -> 14199
    //   14106: aload 5
    //   14108: arraylength
    //   14109: ifle +90 -> 14199
    //   14112: new 109	org/json/JSONObject
    //   14115: dup
    //   14116: aload 5
    //   14118: iconst_0
    //   14119: aaload
    //   14120: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14123: ldc_w 3529
    //   14126: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14129: istore 6
    //   14131: aload_0
    //   14132: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14135: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   14138: astore_1
    //   14139: aload_1
    //   14140: ifnull -13956 -> 184
    //   14143: aload_1
    //   14144: instanceof 1323
    //   14147: ifeq -13963 -> 184
    //   14150: aload_1
    //   14151: checkcast 1323	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   14154: iload 6
    //   14156: invokevirtual 3530	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	(I)V
    //   14159: goto -13975 -> 184
    //   14162: astore_1
    //   14163: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14166: ifeq -13982 -> 184
    //   14169: ldc_w 2314
    //   14172: iconst_2
    //   14173: new 497	java/lang/StringBuilder
    //   14176: dup
    //   14177: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   14180: ldc_w 3532
    //   14183: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14186: aload_1
    //   14187: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14190: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14193: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14196: goto -14012 -> 184
    //   14199: ldc_w 3534
    //   14202: aload 4
    //   14204: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14207: ifeq +267 -> 14474
    //   14210: aload 5
    //   14212: arraylength
    //   14213: ifle +261 -> 14474
    //   14216: new 109	org/json/JSONObject
    //   14219: dup
    //   14220: aload 5
    //   14222: iconst_0
    //   14223: aaload
    //   14224: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14227: astore_3
    //   14228: aload_3
    //   14229: ldc_w 3536
    //   14232: iconst_0
    //   14233: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14236: iconst_1
    //   14237: if_icmpne +176 -> 14413
    //   14240: iconst_1
    //   14241: istore 12
    //   14243: aload_3
    //   14244: ldc_w 3538
    //   14247: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14250: istore 6
    //   14252: aload_3
    //   14253: ldc_w 3540
    //   14256: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14259: istore 7
    //   14261: aload_3
    //   14262: ldc_w 3542
    //   14265: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14268: istore 8
    //   14270: aload_3
    //   14271: ldc_w 3544
    //   14274: iconst_1
    //   14275: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14278: iconst_1
    //   14279: if_icmpne +140 -> 14419
    //   14282: iconst_1
    //   14283: istore 13
    //   14285: aload_3
    //   14286: ldc_w 3546
    //   14289: aconst_null
    //   14290: invokevirtual 2378	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14293: astore_1
    //   14294: aload_3
    //   14295: ldc_w 3548
    //   14298: aconst_null
    //   14299: invokevirtual 2378	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14302: astore_2
    //   14303: aload_3
    //   14304: ldc_w 1380
    //   14307: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14310: astore_3
    //   14311: aload_0
    //   14312: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14315: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   14318: astore 5
    //   14320: aload_0
    //   14321: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14324: invokevirtual 1512	bbac:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   14327: astore 4
    //   14329: aload_0
    //   14330: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14333: aload 5
    //   14335: invokevirtual 699	bbac:a	(Landroid/app/Activity;)Lbazo;
    //   14338: astore 5
    //   14340: aload 4
    //   14342: ifnull +83 -> 14425
    //   14345: aload 4
    //   14347: getfield 2767	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bbcj	Lbbcj;
    //   14350: ifnull +75 -> 14425
    //   14353: aload 4
    //   14355: getfield 2767	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_Bbcj	Lbbcj;
    //   14358: iload 12
    //   14360: iload 6
    //   14362: iload 7
    //   14364: iload 8
    //   14366: iload 13
    //   14368: aload_1
    //   14369: aload_2
    //   14370: aload_3
    //   14371: invokevirtual 3551	bbcj:a	(ZIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   14374: goto -14190 -> 184
    //   14377: astore_1
    //   14378: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14381: ifeq -14197 -> 184
    //   14384: ldc 191
    //   14386: iconst_2
    //   14387: new 497	java/lang/StringBuilder
    //   14390: dup
    //   14391: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   14394: ldc_w 3553
    //   14397: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14400: aload_1
    //   14401: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14404: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14407: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14410: goto -14226 -> 184
    //   14413: iconst_0
    //   14414: istore 12
    //   14416: goto -173 -> 14243
    //   14419: iconst_0
    //   14420: istore 13
    //   14422: goto -137 -> 14285
    //   14425: aload 5
    //   14427: ifnull -14243 -> 184
    //   14430: aload 5
    //   14432: instanceof 1420
    //   14435: ifeq -14251 -> 184
    //   14438: aload 5
    //   14440: checkcast 1420	bben
    //   14443: iload 12
    //   14445: iload 6
    //   14447: iload 7
    //   14449: iload 8
    //   14451: iload 13
    //   14453: aload_1
    //   14454: aload_2
    //   14455: aload_3
    //   14456: aload_0
    //   14457: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14460: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14463: invokevirtual 1423	java/lang/Object:hashCode	()I
    //   14466: invokeinterface 3556 10 0
    //   14471: goto -14287 -> 184
    //   14474: ldc_w 3558
    //   14477: aload 4
    //   14479: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14482: ifeq +162 -> 14644
    //   14485: aload 5
    //   14487: arraylength
    //   14488: ifle +156 -> 14644
    //   14491: new 109	org/json/JSONObject
    //   14494: dup
    //   14495: aload 5
    //   14497: iconst_0
    //   14498: aaload
    //   14499: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14502: ldc_w 1069
    //   14505: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14508: istore 6
    //   14510: aload_0
    //   14511: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14514: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14517: astore_2
    //   14518: aload_2
    //   14519: ifnull -14335 -> 184
    //   14522: iload 6
    //   14524: ifne +24 -> 14548
    //   14527: aload_2
    //   14528: invokevirtual 3561	com/tencent/biz/pubaccount/CustomWebView:reload	()V
    //   14531: goto -14347 -> 184
    //   14534: astore_1
    //   14535: ldc 191
    //   14537: iconst_2
    //   14538: ldc_w 3563
    //   14541: aload_1
    //   14542: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14545: goto -14361 -> 184
    //   14548: aload_0
    //   14549: iconst_4
    //   14550: invokevirtual 2497	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   14553: checkcast 3565	bbbt
    //   14556: astore_1
    //   14557: aload_1
    //   14558: ifnull -14374 -> 184
    //   14561: aload_2
    //   14562: invokevirtual 3568	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   14565: astore_2
    //   14566: aload_1
    //   14567: getfield 3571	bbbt:a	Lxdt;
    //   14570: ifnonnull +28 -> 14598
    //   14573: aload_1
    //   14574: new 1803	xdt
    //   14577: dup
    //   14578: aload_0
    //   14579: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14582: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   14585: aload_0
    //   14586: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14589: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   14592: invokespecial 3574	xdt:<init>	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;)V
    //   14595: putfield 3571	bbbt:a	Lxdt;
    //   14598: iload 6
    //   14600: iconst_1
    //   14601: if_icmpne +20 -> 14621
    //   14604: aload_1
    //   14605: bipush 6
    //   14607: aload_2
    //   14608: new 400	android/os/Bundle
    //   14611: dup
    //   14612: invokespecial 870	android/os/Bundle:<init>	()V
    //   14615: invokevirtual 3577	bbbt:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   14618: goto -14434 -> 184
    //   14621: iload 6
    //   14623: iconst_2
    //   14624: if_icmpne -14440 -> 184
    //   14627: aload_1
    //   14628: bipush 11
    //   14630: aload_2
    //   14631: new 400	android/os/Bundle
    //   14634: dup
    //   14635: invokespecial 870	android/os/Bundle:<init>	()V
    //   14638: invokevirtual 3577	bbbt:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   14641: goto -14457 -> 184
    //   14644: ldc_w 3579
    //   14647: aload 4
    //   14649: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14652: ifeq +62 -> 14714
    //   14655: new 125	android/content/Intent
    //   14658: dup
    //   14659: aload_0
    //   14660: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14663: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   14666: ldc_w 3581
    //   14669: invokespecial 799	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   14672: astore_1
    //   14673: aload_1
    //   14674: ldc_w 3583
    //   14677: aload 5
    //   14679: iconst_0
    //   14680: aaload
    //   14681: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14684: pop
    //   14685: aload_0
    //   14686: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14689: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   14692: aload_1
    //   14693: sipush 11533
    //   14696: invokevirtual 1191	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   14699: aload_0
    //   14700: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14703: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   14706: iconst_0
    //   14707: iconst_0
    //   14708: invokevirtual 1196	android/app/Activity:overridePendingTransition	(II)V
    //   14711: goto -14527 -> 184
    //   14714: ldc_w 3585
    //   14717: aload 4
    //   14719: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14722: ifeq +177 -> 14899
    //   14725: new 109	org/json/JSONObject
    //   14728: dup
    //   14729: aload 5
    //   14731: iconst_0
    //   14732: aaload
    //   14733: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14736: astore_2
    //   14737: aload_2
    //   14738: ldc 156
    //   14740: ldc_w 371
    //   14743: invokevirtual 2378	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14746: astore_1
    //   14747: aload_0
    //   14748: aload_2
    //   14749: ldc_w 1380
    //   14752: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14755: putfield 2275	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   14758: aload_1
    //   14759: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14762: ifeq +65 -> 14827
    //   14765: new 109	org/json/JSONObject
    //   14768: dup
    //   14769: invokespecial 168	org/json/JSONObject:<init>	()V
    //   14772: astore_1
    //   14773: aload_1
    //   14774: ldc 170
    //   14776: iconst_m1
    //   14777: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14780: pop
    //   14781: aload_1
    //   14782: ldc 221
    //   14784: ldc_w 371
    //   14787: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   14790: pop
    //   14791: aload_0
    //   14792: aload_0
    //   14793: getfield 2275	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   14796: iconst_1
    //   14797: anewarray 334	java/lang/String
    //   14800: dup
    //   14801: iconst_0
    //   14802: aload_1
    //   14803: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14806: aastore
    //   14807: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14810: goto -14626 -> 184
    //   14813: astore_1
    //   14814: ldc 191
    //   14816: iconst_1
    //   14817: ldc_w 3587
    //   14820: aload_1
    //   14821: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14824: goto -14640 -> 184
    //   14827: aload_2
    //   14828: ldc_w 3589
    //   14831: iconst_0
    //   14832: invokevirtual 926	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14835: istore 6
    //   14837: new 125	android/content/Intent
    //   14840: dup
    //   14841: invokespecial 227	android/content/Intent:<init>	()V
    //   14844: astore_2
    //   14845: iload 6
    //   14847: ifne +38 -> 14885
    //   14850: aload_2
    //   14851: invokestatic 583	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14854: ldc_w 1181
    //   14857: invokevirtual 3593	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14860: pop
    //   14861: aload_2
    //   14862: ldc 156
    //   14864: aload_1
    //   14865: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14868: pop
    //   14869: aload_0
    //   14870: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14873: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   14876: aload_2
    //   14877: bipush 14
    //   14879: invokevirtual 1191	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   14882: goto -14698 -> 184
    //   14885: aload_2
    //   14886: invokestatic 583	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14889: ldc_w 3595
    //   14892: invokevirtual 3593	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14895: pop
    //   14896: goto -35 -> 14861
    //   14899: ldc_w 3597
    //   14902: aload 4
    //   14904: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14907: ifeq +61 -> 14968
    //   14910: new 109	org/json/JSONObject
    //   14913: dup
    //   14914: aload 5
    //   14916: iconst_0
    //   14917: aaload
    //   14918: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14921: ldc 221
    //   14923: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14926: astore_1
    //   14927: aload_0
    //   14928: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   14931: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   14934: iconst_m1
    //   14935: new 125	android/content/Intent
    //   14938: dup
    //   14939: invokespecial 227	android/content/Intent:<init>	()V
    //   14942: ldc 221
    //   14944: aload_1
    //   14945: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14948: invokevirtual 238	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   14951: goto -14767 -> 184
    //   14954: astore_1
    //   14955: ldc 191
    //   14957: iconst_1
    //   14958: ldc_w 3599
    //   14961: aload_1
    //   14962: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14965: goto -14781 -> 184
    //   14968: ldc_w 3601
    //   14971: aload 4
    //   14973: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14976: ifne -14792 -> 184
    //   14979: ldc_w 3603
    //   14982: aload 4
    //   14984: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14987: ifeq +99 -> 15086
    //   14990: new 109	org/json/JSONObject
    //   14993: dup
    //   14994: aload 5
    //   14996: iconst_0
    //   14997: aaload
    //   14998: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15001: astore_2
    //   15002: aload_2
    //   15003: ldc_w 1380
    //   15006: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15009: astore_1
    //   15010: aload_2
    //   15011: ldc_w 3172
    //   15014: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15017: iconst_0
    //   15018: iconst_0
    //   15019: invokestatic 3608	bati:a	(Ljava/lang/String;ZZ)Lbatj;
    //   15022: astore_2
    //   15023: new 109	org/json/JSONObject
    //   15026: dup
    //   15027: invokespecial 168	org/json/JSONObject:<init>	()V
    //   15030: astore_3
    //   15031: aload_3
    //   15032: ldc 170
    //   15034: aload_2
    //   15035: getfield 3611	batj:jdField_a_of_type_Int	I
    //   15038: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15041: pop
    //   15042: aload_3
    //   15043: ldc 156
    //   15045: aload_2
    //   15046: getfield 3612	batj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15049: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   15052: pop
    //   15053: aload_0
    //   15054: aload_1
    //   15055: iconst_1
    //   15056: anewarray 334	java/lang/String
    //   15059: dup
    //   15060: iconst_0
    //   15061: aload_3
    //   15062: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15065: aastore
    //   15066: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15069: goto -14885 -> 184
    //   15072: astore_1
    //   15073: ldc 191
    //   15075: iconst_1
    //   15076: ldc_w 3614
    //   15079: aload_1
    //   15080: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15083: goto -14899 -> 184
    //   15086: ldc_w 3616
    //   15089: aload 4
    //   15091: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15094: ifeq +221 -> 15315
    //   15097: new 109	org/json/JSONObject
    //   15100: dup
    //   15101: aload 5
    //   15103: iconst_0
    //   15104: aaload
    //   15105: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15108: astore_2
    //   15109: aload_2
    //   15110: ldc_w 1380
    //   15113: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15116: astore_1
    //   15117: aload_2
    //   15118: ldc 201
    //   15120: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   15123: istore 6
    //   15125: aload_2
    //   15126: ldc_w 3172
    //   15129: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15132: astore_2
    //   15133: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15136: ifeq +40 -> 15176
    //   15139: ldc 191
    //   15141: iconst_2
    //   15142: new 497	java/lang/StringBuilder
    //   15145: dup
    //   15146: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   15149: ldc_w 3618
    //   15152: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15155: iload 6
    //   15157: invokevirtual 1063	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15160: ldc_w 3620
    //   15163: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15166: aload_2
    //   15167: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15170: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15173: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15176: aload_2
    //   15177: iconst_0
    //   15178: iconst_1
    //   15179: invokestatic 3608	bati:a	(Ljava/lang/String;ZZ)Lbatj;
    //   15182: astore_3
    //   15183: new 109	org/json/JSONObject
    //   15186: dup
    //   15187: invokespecial 168	org/json/JSONObject:<init>	()V
    //   15190: astore 4
    //   15192: aload_3
    //   15193: getfield 3611	batj:jdField_a_of_type_Int	I
    //   15196: iconst_1
    //   15197: if_icmpne +46 -> 15243
    //   15200: aload 4
    //   15202: ldc 170
    //   15204: iconst_2
    //   15205: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15208: pop
    //   15209: aload_0
    //   15210: aload_1
    //   15211: iconst_1
    //   15212: anewarray 334	java/lang/String
    //   15215: dup
    //   15216: iconst_0
    //   15217: aload 4
    //   15219: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15222: aastore
    //   15223: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15226: goto -15042 -> 184
    //   15229: astore_1
    //   15230: ldc 191
    //   15232: iconst_1
    //   15233: ldc_w 3622
    //   15236: aload_1
    //   15237: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15240: goto -15056 -> 184
    //   15243: aload_3
    //   15244: getfield 3611	batj:jdField_a_of_type_Int	I
    //   15247: iconst_4
    //   15248: if_icmpne +32 -> 15280
    //   15251: aload 4
    //   15253: ldc 170
    //   15255: iconst_0
    //   15256: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15259: pop
    //   15260: aload_0
    //   15261: aload_1
    //   15262: iconst_1
    //   15263: anewarray 334	java/lang/String
    //   15266: dup
    //   15267: iconst_0
    //   15268: aload 4
    //   15270: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15273: aastore
    //   15274: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15277: goto -15093 -> 184
    //   15280: new 3624	bath
    //   15283: dup
    //   15284: aload_0
    //   15285: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   15288: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   15291: aload_0
    //   15292: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   15295: invokevirtual 1019	bbac:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   15298: aload_1
    //   15299: iload 6
    //   15301: aload_2
    //   15302: aload_3
    //   15303: getfield 3611	batj:jdField_a_of_type_Int	I
    //   15306: invokespecial 3627	bath:<init>	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Ljava/lang/String;ILjava/lang/String;I)V
    //   15309: invokevirtual 3628	bath:show	()V
    //   15312: goto -15128 -> 184
    //   15315: ldc_w 3630
    //   15318: aload 4
    //   15320: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15323: ifeq +93 -> 15416
    //   15326: new 109	org/json/JSONObject
    //   15329: dup
    //   15330: aload 5
    //   15332: iconst_0
    //   15333: aaload
    //   15334: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15337: astore_2
    //   15338: aload_2
    //   15339: ldc_w 1380
    //   15342: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15345: astore_1
    //   15346: aload_2
    //   15347: ldc_w 3172
    //   15350: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15353: astore_2
    //   15354: new 109	org/json/JSONObject
    //   15357: dup
    //   15358: invokespecial 168	org/json/JSONObject:<init>	()V
    //   15361: astore_3
    //   15362: aload_3
    //   15363: ldc 170
    //   15365: invokestatic 3631	bati:a	()I
    //   15368: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15371: pop
    //   15372: aload_3
    //   15373: ldc 156
    //   15375: aload_2
    //   15376: invokestatic 3632	bati:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15379: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   15382: pop
    //   15383: aload_0
    //   15384: aload_1
    //   15385: iconst_1
    //   15386: anewarray 334	java/lang/String
    //   15389: dup
    //   15390: iconst_0
    //   15391: aload_3
    //   15392: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15395: aastore
    //   15396: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15399: goto -15215 -> 184
    //   15402: astore_1
    //   15403: ldc 191
    //   15405: iconst_1
    //   15406: ldc_w 3614
    //   15409: aload_1
    //   15410: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15413: goto -15229 -> 184
    //   15416: ldc_w 3634
    //   15419: aload 4
    //   15421: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15424: ifeq +128 -> 15552
    //   15427: new 109	org/json/JSONObject
    //   15430: dup
    //   15431: aload 5
    //   15433: iconst_0
    //   15434: aaload
    //   15435: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15438: astore_1
    //   15439: aload_1
    //   15440: ldc_w 3084
    //   15443: invokevirtual 2824	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   15446: istore 12
    //   15448: aload_1
    //   15449: ldc_w 3636
    //   15452: invokevirtual 1204	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   15455: astore_1
    //   15456: aload_1
    //   15457: ifnull -15273 -> 184
    //   15460: aload_1
    //   15461: ldc_w 1439
    //   15464: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15467: istore 6
    //   15469: aload_1
    //   15470: ldc_w 1441
    //   15473: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15476: istore 7
    //   15478: new 1443	android/graphics/Rect
    //   15481: dup
    //   15482: iload 6
    //   15484: iload 7
    //   15486: aload_1
    //   15487: ldc_w 1445
    //   15490: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15493: iload 6
    //   15495: iadd
    //   15496: aload_1
    //   15497: ldc_w 1447
    //   15500: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15503: iload 7
    //   15505: iadd
    //   15506: invokespecial 1449	android/graphics/Rect:<init>	(IIII)V
    //   15509: astore_1
    //   15510: aload_0
    //   15511: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   15514: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   15517: astore_2
    //   15518: aload_2
    //   15519: instanceof 1349
    //   15522: ifeq -15338 -> 184
    //   15525: aload_2
    //   15526: checkcast 1349	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity
    //   15529: aload_1
    //   15530: iload 12
    //   15532: invokevirtual 3639	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity:a	(Landroid/graphics/Rect;Z)V
    //   15535: goto -15351 -> 184
    //   15538: astore_1
    //   15539: ldc 191
    //   15541: iconst_1
    //   15542: ldc_w 3641
    //   15545: aload_1
    //   15546: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15549: goto -15365 -> 184
    //   15552: ldc_w 3643
    //   15555: aload 4
    //   15557: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15560: ifeq +56 -> 15616
    //   15563: new 109	org/json/JSONObject
    //   15566: dup
    //   15567: aload 5
    //   15569: iconst_0
    //   15570: aaload
    //   15571: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15574: astore_1
    //   15575: aload_1
    //   15576: ifnonnull +21 -> 15597
    //   15579: iconst_1
    //   15580: ireturn
    //   15581: astore_1
    //   15582: ldc 191
    //   15584: iconst_1
    //   15585: ldc_w 3645
    //   15588: aload_1
    //   15589: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15592: aconst_null
    //   15593: astore_1
    //   15594: goto -19 -> 15575
    //   15597: invokestatic 3651	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   15600: new 3653	com/tencent/mobileqq/jsp/UiApiPlugin$8
    //   15603: dup
    //   15604: aload_0
    //   15605: aload_1
    //   15606: invokespecial 3654	com/tencent/mobileqq/jsp/UiApiPlugin$8:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Lorg/json/JSONObject;)V
    //   15609: invokevirtual 3660	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   15612: pop
    //   15613: goto -15429 -> 184
    //   15616: ldc_w 3662
    //   15619: aload 4
    //   15621: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15624: ifeq +117 -> 15741
    //   15627: new 109	org/json/JSONObject
    //   15630: dup
    //   15631: aload 5
    //   15633: iconst_0
    //   15634: aaload
    //   15635: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15638: astore_1
    //   15639: aload_0
    //   15640: aload_1
    //   15641: ldc_w 1380
    //   15644: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15647: putfield 3664	com/tencent/mobileqq/jsp/UiApiPlugin:j	Ljava/lang/String;
    //   15650: aload_1
    //   15651: ldc_w 3352
    //   15654: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15657: astore_2
    //   15658: aload_1
    //   15659: ldc_w 3666
    //   15662: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15665: astore_3
    //   15666: aload_1
    //   15667: ldc_w 3668
    //   15670: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15673: astore 4
    //   15675: aload_1
    //   15676: ldc_w 3670
    //   15679: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15682: astore 5
    //   15684: aload_1
    //   15685: ldc_w 3672
    //   15688: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   15691: istore 6
    //   15693: aload_0
    //   15694: aload_0
    //   15695: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   15698: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   15701: iconst_3
    //   15702: aload_2
    //   15703: aload_3
    //   15704: sipush 3016
    //   15707: iload 6
    //   15709: aload 4
    //   15711: aload 5
    //   15713: aconst_null
    //   15714: aconst_null
    //   15715: aconst_null
    //   15716: invokestatic 3677	com/tencent/mobileqq/activity/AddFriendLogicActivity:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   15719: bipush 16
    //   15721: invokevirtual 1666	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   15724: goto -15540 -> 184
    //   15727: astore_1
    //   15728: ldc 191
    //   15730: iconst_1
    //   15731: ldc_w 3679
    //   15734: aload_1
    //   15735: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15738: goto -15554 -> 184
    //   15741: ldc_w 3681
    //   15744: aload 4
    //   15746: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15749: ifeq +178 -> 15927
    //   15752: new 109	org/json/JSONObject
    //   15755: dup
    //   15756: aload 5
    //   15758: iconst_0
    //   15759: aaload
    //   15760: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15763: astore_3
    //   15764: aload_3
    //   15765: ldc_w 3683
    //   15768: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15771: astore_1
    //   15772: aload_3
    //   15773: ldc_w 2112
    //   15776: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15779: astore_2
    //   15780: aload_3
    //   15781: ldc_w 2125
    //   15784: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15787: astore_3
    //   15788: aload_1
    //   15789: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15792: ifne +69 -> 15861
    //   15795: new 866	java/io/File
    //   15798: dup
    //   15799: aload_1
    //   15800: invokespecial 1644	java/io/File:<init>	(Ljava/lang/String;)V
    //   15803: astore_1
    //   15804: aload_1
    //   15805: invokevirtual 1998	java/io/File:exists	()Z
    //   15808: ifne +45 -> 15853
    //   15811: aload_0
    //   15812: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   15815: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   15818: invokevirtual 1959	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15821: iconst_1
    //   15822: ldc_w 3684
    //   15825: invokestatic 1964	ajjy:a	(I)Ljava/lang/String;
    //   15828: iconst_0
    //   15829: invokestatic 1967	bbmy:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lbbmy;
    //   15832: invokevirtual 1970	bbmy:a	()Landroid/widget/Toast;
    //   15835: pop
    //   15836: goto -15652 -> 184
    //   15839: astore_1
    //   15840: ldc 191
    //   15842: iconst_1
    //   15843: ldc_w 3686
    //   15846: aload_1
    //   15847: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15850: goto -15666 -> 184
    //   15853: aload_0
    //   15854: aload_1
    //   15855: invokevirtual 1646	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/io/File;)V
    //   15858: goto -15674 -> 184
    //   15861: aload_2
    //   15862: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15865: ifne +19 -> 15884
    //   15868: aload_0
    //   15869: aload_2
    //   15870: iconst_0
    //   15871: invokestatic 2121	baaw:decode	(Ljava/lang/String;I)[B
    //   15874: aload_2
    //   15875: invokestatic 2115	bcdu:d	(Ljava/lang/String;)Ljava/lang/String;
    //   15878: invokevirtual 3688	com/tencent/mobileqq/jsp/UiApiPlugin:a	([BLjava/lang/String;)V
    //   15881: goto -15697 -> 184
    //   15884: aload_3
    //   15885: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15888: ifne +11 -> 15899
    //   15891: aload_0
    //   15892: aload_3
    //   15893: invokevirtual 3690	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Ljava/lang/String;)V
    //   15896: goto -15712 -> 184
    //   15899: aload_0
    //   15900: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   15903: invokevirtual 1031	bbac:a	()Lcom/tencent/common/app/AppInterface;
    //   15906: invokevirtual 1959	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15909: iconst_1
    //   15910: ldc_w 3691
    //   15913: invokestatic 1964	ajjy:a	(I)Ljava/lang/String;
    //   15916: iconst_0
    //   15917: invokestatic 1967	bbmy:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lbbmy;
    //   15920: invokevirtual 1970	bbmy:a	()Landroid/widget/Toast;
    //   15923: pop
    //   15924: goto -15740 -> 184
    //   15927: ldc_w 3693
    //   15930: aload 4
    //   15932: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15935: ifeq +44 -> 15979
    //   15938: aload_0
    //   15939: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   15942: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   15945: iconst_m1
    //   15946: new 125	android/content/Intent
    //   15949: dup
    //   15950: invokespecial 227	android/content/Intent:<init>	()V
    //   15953: ldc_w 3695
    //   15956: aload 5
    //   15958: iconst_0
    //   15959: aaload
    //   15960: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   15963: invokevirtual 238	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   15966: aload_0
    //   15967: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   15970: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   15973: invokevirtual 241	android/app/Activity:finish	()V
    //   15976: goto -15792 -> 184
    //   15979: ldc_w 3697
    //   15982: aload 4
    //   15984: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15987: ifeq +13 -> 16000
    //   15990: aload_0
    //   15991: aload 5
    //   15993: iconst_0
    //   15994: aaload
    //   15995: invokevirtual 3699	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Ljava/lang/String;)V
    //   15998: iconst_1
    //   15999: ireturn
    //   16000: ldc_w 3701
    //   16003: aload 4
    //   16005: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16008: ifeq +102 -> 16110
    //   16011: aload 5
    //   16013: arraylength
    //   16014: iconst_1
    //   16015: if_icmpne +95 -> 16110
    //   16018: new 109	org/json/JSONObject
    //   16021: dup
    //   16022: aload 5
    //   16024: iconst_0
    //   16025: aaload
    //   16026: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16029: astore_1
    //   16030: aload_1
    //   16031: ldc_w 1380
    //   16034: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16037: astore_2
    //   16038: new 3703	azoo
    //   16041: dup
    //   16042: aload_1
    //   16043: ldc_w 3705
    //   16046: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16049: aload_1
    //   16050: ldc_w 3707
    //   16053: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16056: aload_1
    //   16057: ldc_w 3709
    //   16060: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16063: aload_1
    //   16064: ldc_w 3711
    //   16067: invokevirtual 113	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16070: aload_1
    //   16071: ldc_w 3713
    //   16074: invokevirtual 2321	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   16077: invokespecial 3716	azoo:<init>	(IIIIJ)V
    //   16080: aload_0
    //   16081: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   16084: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   16087: new 3718	aqub
    //   16090: dup
    //   16091: aload_0
    //   16092: aload_2
    //   16093: invokespecial 3719	aqub:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   16096: invokevirtual 3722	azoo:a	(Landroid/app/Activity;Lazos;)V
    //   16099: goto -15915 -> 184
    //   16102: astore_1
    //   16103: aload_1
    //   16104: invokevirtual 2502	org/json/JSONException:printStackTrace	()V
    //   16107: goto -15923 -> 184
    //   16110: ldc_w 3724
    //   16113: aload 4
    //   16115: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16118: ifeq +102 -> 16220
    //   16121: new 109	org/json/JSONObject
    //   16124: dup
    //   16125: aload 5
    //   16127: iconst_0
    //   16128: aaload
    //   16129: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16132: ldc_w 1380
    //   16135: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16138: astore_1
    //   16139: new 109	org/json/JSONObject
    //   16142: dup
    //   16143: invokespecial 168	org/json/JSONObject:<init>	()V
    //   16146: astore_2
    //   16147: aload_0
    //   16148: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   16151: invokevirtual 690	bbac:a	()Landroid/app/Activity;
    //   16154: astore_3
    //   16155: aload_3
    //   16156: ifnonnull +5 -> 16161
    //   16159: iconst_1
    //   16160: ireturn
    //   16161: aload_3
    //   16162: invokestatic 3727	bjeh:a	(Landroid/app/Activity;)V
    //   16165: aload_2
    //   16166: ldc_w 3729
    //   16169: invokestatic 3731	bjeh:b	()Z
    //   16172: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   16175: pop
    //   16176: aload_2
    //   16177: ldc_w 3733
    //   16180: getstatic 3734	bjeh:jdField_a_of_type_Int	I
    //   16183: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   16186: pop
    //   16187: aload_0
    //   16188: aload_1
    //   16189: iconst_1
    //   16190: anewarray 334	java/lang/String
    //   16193: dup
    //   16194: iconst_0
    //   16195: aload_2
    //   16196: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   16199: aastore
    //   16200: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   16203: goto -16019 -> 184
    //   16206: astore_1
    //   16207: ldc 191
    //   16209: iconst_1
    //   16210: ldc_w 3736
    //   16213: aload_1
    //   16214: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16217: goto -16033 -> 184
    //   16220: ldc_w 3738
    //   16223: aload 4
    //   16225: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16228: ifeq +137 -> 16365
    //   16231: new 109	org/json/JSONObject
    //   16234: dup
    //   16235: aload 5
    //   16237: iconst_0
    //   16238: aaload
    //   16239: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16242: astore_2
    //   16243: aload_2
    //   16244: ldc_w 3740
    //   16247: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16250: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16253: astore_1
    //   16254: aload_2
    //   16255: ldc_w 1380
    //   16258: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16261: astore_2
    //   16262: aload_1
    //   16263: invokevirtual 2254	java/lang/Integer:intValue	()I
    //   16266: iconst_1
    //   16267: if_icmpne +77 -> 16344
    //   16270: iconst_1
    //   16271: invokestatic 3743	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	(Z)V
    //   16274: new 109	org/json/JSONObject
    //   16277: dup
    //   16278: invokespecial 168	org/json/JSONObject:<init>	()V
    //   16281: astore_1
    //   16282: aload_1
    //   16283: ldc 170
    //   16285: ldc_w 3127
    //   16288: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   16291: pop
    //   16292: invokestatic 3744	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	()Z
    //   16295: ifeq +64 -> 16359
    //   16298: iconst_1
    //   16299: istore 6
    //   16301: aload_1
    //   16302: ldc_w 3740
    //   16305: iload 6
    //   16307: invokevirtual 219	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   16310: pop
    //   16311: aload_0
    //   16312: aload_2
    //   16313: iconst_1
    //   16314: anewarray 334	java/lang/String
    //   16317: dup
    //   16318: iconst_0
    //   16319: aload_1
    //   16320: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   16323: aastore
    //   16324: invokevirtual 384	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   16327: goto -16143 -> 184
    //   16330: astore_1
    //   16331: ldc 191
    //   16333: iconst_1
    //   16334: ldc_w 3746
    //   16337: aload_1
    //   16338: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16341: goto -16157 -> 184
    //   16344: aload_1
    //   16345: invokevirtual 2254	java/lang/Integer:intValue	()I
    //   16348: iconst_2
    //   16349: if_icmpne -75 -> 16274
    //   16352: iconst_0
    //   16353: invokestatic 3743	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	(Z)V
    //   16356: goto -82 -> 16274
    //   16359: iconst_2
    //   16360: istore 6
    //   16362: goto -61 -> 16301
    //   16365: ldc_w 3748
    //   16368: aload 4
    //   16370: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16373: ifeq +166 -> 16539
    //   16376: new 109	org/json/JSONObject
    //   16379: dup
    //   16380: aload 5
    //   16382: iconst_0
    //   16383: aaload
    //   16384: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16387: astore 4
    //   16389: aload 4
    //   16391: ldc_w 3750
    //   16394: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16397: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16400: astore_1
    //   16401: aload 4
    //   16403: ldc_w 3752
    //   16406: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16409: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16412: astore_2
    //   16413: aload 4
    //   16415: ldc_w 3754
    //   16418: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16421: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16424: astore_3
    //   16425: aload 4
    //   16427: ldc_w 1380
    //   16430: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16433: astore 4
    //   16435: ldc 191
    //   16437: iconst_1
    //   16438: new 497	java/lang/StringBuilder
    //   16441: dup
    //   16442: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   16445: ldc_w 3756
    //   16448: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16451: aload_1
    //   16452: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16455: ldc_w 3758
    //   16458: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16461: aload_2
    //   16462: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16465: ldc_w 3760
    //   16468: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16471: aload_3
    //   16472: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16475: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16478: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16481: aload_0
    //   16482: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   16485: ifnonnull +17 -> 16502
    //   16488: aload_0
    //   16489: invokestatic 1679	wis:a	()Lwis;
    //   16492: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   16495: aload_0
    //   16496: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   16499: invokevirtual 1680	wis:a	()V
    //   16502: aload_0
    //   16503: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   16506: aload_1
    //   16507: aload_2
    //   16508: aload_3
    //   16509: new 3762	aqta
    //   16512: dup
    //   16513: aload_0
    //   16514: aload 4
    //   16516: invokespecial 3763	aqta:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   16519: invokevirtual 3766	wis:a	(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lwiu;)V
    //   16522: goto -16338 -> 184
    //   16525: astore_1
    //   16526: ldc 191
    //   16528: iconst_1
    //   16529: ldc_w 3768
    //   16532: aload_1
    //   16533: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16536: goto -16352 -> 184
    //   16539: ldc_w 3770
    //   16542: aload 4
    //   16544: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16547: ifeq +139 -> 16686
    //   16550: new 109	org/json/JSONObject
    //   16553: dup
    //   16554: aload 5
    //   16556: iconst_0
    //   16557: aaload
    //   16558: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16561: astore_3
    //   16562: aload_3
    //   16563: ldc_w 3772
    //   16566: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16569: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16572: astore_1
    //   16573: aload_3
    //   16574: ldc_w 3752
    //   16577: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16580: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16583: astore_2
    //   16584: aload_3
    //   16585: ldc_w 2364
    //   16588: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16591: astore_3
    //   16592: ldc 191
    //   16594: iconst_1
    //   16595: new 497	java/lang/StringBuilder
    //   16598: dup
    //   16599: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   16602: ldc_w 3774
    //   16605: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16608: aload_1
    //   16609: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16612: ldc_w 3776
    //   16615: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16618: aload_2
    //   16619: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16622: ldc_w 3778
    //   16625: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16628: aload_3
    //   16629: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16632: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16635: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16638: aload_0
    //   16639: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   16642: ifnonnull +17 -> 16659
    //   16645: aload_0
    //   16646: invokestatic 1679	wis:a	()Lwis;
    //   16649: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   16652: aload_0
    //   16653: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   16656: invokevirtual 1680	wis:a	()V
    //   16659: aload_0
    //   16660: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   16663: aload_1
    //   16664: aload_2
    //   16665: aload_3
    //   16666: invokevirtual 3781	wis:a	(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V
    //   16669: goto -16485 -> 184
    //   16672: astore_1
    //   16673: ldc 191
    //   16675: iconst_1
    //   16676: ldc_w 3783
    //   16679: aload_1
    //   16680: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16683: goto -16499 -> 184
    //   16686: ldc_w 3785
    //   16689: aload 4
    //   16691: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16694: ifeq +139 -> 16833
    //   16697: new 109	org/json/JSONObject
    //   16700: dup
    //   16701: aload 5
    //   16703: iconst_0
    //   16704: aaload
    //   16705: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16708: astore_3
    //   16709: aload_3
    //   16710: ldc_w 3772
    //   16713: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16716: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16719: astore_1
    //   16720: aload_3
    //   16721: ldc_w 2364
    //   16724: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16727: astore_2
    //   16728: aload_3
    //   16729: ldc_w 3752
    //   16732: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16735: invokestatic 852	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16738: astore_3
    //   16739: ldc 191
    //   16741: iconst_1
    //   16742: new 497	java/lang/StringBuilder
    //   16745: dup
    //   16746: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   16749: ldc_w 3787
    //   16752: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16755: aload_1
    //   16756: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16759: ldc_w 3778
    //   16762: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16765: aload_2
    //   16766: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16769: ldc_w 3776
    //   16772: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16775: aload_3
    //   16776: invokevirtual 2197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16779: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16782: invokestatic 1016	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16785: aload_0
    //   16786: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   16789: ifnonnull +17 -> 16806
    //   16792: aload_0
    //   16793: invokestatic 1679	wis:a	()Lwis;
    //   16796: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   16799: aload_0
    //   16800: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   16803: invokevirtual 1680	wis:a	()V
    //   16806: aload_0
    //   16807: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   16810: aload_1
    //   16811: aload_2
    //   16812: aload_3
    //   16813: invokevirtual 3790	wis:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V
    //   16816: goto -16632 -> 184
    //   16819: astore_1
    //   16820: ldc 191
    //   16822: iconst_1
    //   16823: ldc_w 3792
    //   16826: aload_1
    //   16827: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16830: goto -16646 -> 184
    //   16833: ldc_w 3794
    //   16836: aload 4
    //   16838: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16841: ifeq +252 -> 17093
    //   16844: new 109	org/json/JSONObject
    //   16847: dup
    //   16848: aload 5
    //   16850: iconst_0
    //   16851: aaload
    //   16852: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16855: astore 4
    //   16857: aload 4
    //   16859: ldc_w 3796
    //   16862: iconst_1
    //   16863: invokevirtual 1109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   16866: ifne +41 -> 16907
    //   16869: aload 4
    //   16871: aload 4
    //   16873: ldc_w 1380
    //   16876: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16879: new 3798	aqtb
    //   16882: dup
    //   16883: aload_0
    //   16884: invokespecial 3799	aqtb:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   16887: invokestatic 3804	rsv:a	(Lorg/json/JSONObject;Ljava/lang/String;Lrlp;)V
    //   16890: goto -16706 -> 184
    //   16893: astore_1
    //   16894: ldc 191
    //   16896: iconst_1
    //   16897: ldc_w 3806
    //   16900: aload_1
    //   16901: invokestatic 1200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16904: goto -16720 -> 184
    //   16907: aload 4
    //   16909: ldc_w 970
    //   16912: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16915: pop
    //   16916: aload 4
    //   16918: ldc_w 972
    //   16921: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16924: pop
    //   16925: aload 4
    //   16927: ldc_w 974
    //   16930: invokevirtual 978	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   16933: pop
    //   16934: aload 4
    //   16936: ldc_w 980
    //   16939: invokevirtual 984	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   16942: pop2
    //   16943: aload 4
    //   16945: ldc_w 992
    //   16948: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16951: astore_1
    //   16952: aload 4
    //   16954: ldc_w 994
    //   16957: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16960: astore_2
    //   16961: aload 4
    //   16963: ldc_w 996
    //   16966: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16969: astore_3
    //   16970: aload 4
    //   16972: ldc_w 998
    //   16975: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16978: astore 4
    //   16980: new 2056	java/util/HashMap
    //   16983: dup
    //   16984: invokespecial 3291	java/util/HashMap:<init>	()V
    //   16987: astore 14
    //   16989: aload 14
    //   16991: ldc_w 992
    //   16994: aload_1
    //   16995: invokeinterface 3807 3 0
    //   17000: pop
    //   17001: aload 14
    //   17003: ldc_w 994
    //   17006: aload_2
    //   17007: invokeinterface 3807 3 0
    //   17012: pop
    //   17013: aload 14
    //   17015: ldc_w 996
    //   17018: aload_3
    //   17019: invokeinterface 3807 3 0
    //   17024: pop
    //   17025: aload 14
    //   17027: ldc_w 998
    //   17030: aload 4
    //   17032: invokeinterface 3807 3 0
    //   17037: pop
    //   17038: aload_0
    //   17039: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   17042: ifnonnull +17 -> 17059
    //   17045: aload_0
    //   17046: invokestatic 1679	wis:a	()Lwis;
    //   17049: putfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   17052: aload_0
    //   17053: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   17056: invokevirtual 1680	wis:a	()V
    //   17059: new 3809	aqtc
    //   17062: dup
    //   17063: aload_0
    //   17064: aload 14
    //   17066: invokespecial 3812	aqtc:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/util/Map;)V
    //   17069: astore_1
    //   17070: aload_0
    //   17071: getfield 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Wis	Lwis;
    //   17074: aload_1
    //   17075: invokevirtual 3815	wis:a	(Lwiu;)I
    //   17078: istore 6
    //   17080: aload_0
    //   17081: aload 5
    //   17083: iconst_0
    //   17084: aaload
    //   17085: iload 6
    //   17087: invokevirtual 3816	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;I)V
    //   17090: goto -16906 -> 184
    //   17093: ldc_w 3818
    //   17096: aload 4
    //   17098: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17101: ifeq -16917 -> 184
    //   17104: new 109	org/json/JSONObject
    //   17107: dup
    //   17108: aload 5
    //   17110: iconst_0
    //   17111: aaload
    //   17112: invokespecial 904	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17115: astore_1
    //   17116: aload_1
    //   17117: ldc_w 1069
    //   17120: invokevirtual 117	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17123: astore_2
    //   17124: aload_0
    //   17125: getfield 685	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbbac;
    //   17128: invokevirtual 1512	bbac:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   17131: astore_3
    //   17132: aload_1
    //   17133: ldc_w 3820
    //   17136: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   17139: istore 6
    //   17141: aload_1
    //   17142: ldc_w 909
    //   17145: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17148: astore 4
    //   17150: aload_1
    //   17151: ldc_w 1091
    //   17154: invokevirtual 912	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17157: astore 5
    //   17159: aload_1
    //   17160: ldc_w 3822
    //   17163: invokevirtual 1130	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   17166: istore 7
    //   17168: ldc_w 3000
    //   17171: aload_2
    //   17172: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17175: ifeq +104 -> 17279
    //   17178: aload_3
    //   17179: aload 4
    //   17181: putfield 3823	com/tencent/mobileqq/webview/swift/WebViewFragment:r	Ljava/lang/String;
    //   17184: aload_3
    //   17185: iload 6
    //   17187: putfield 3826	com/tencent/mobileqq/webview/swift/WebViewFragment:n	I
    //   17190: aload_3
    //   17191: iload 7
    //   17193: putfield 3829	com/tencent/mobileqq/webview/swift/WebViewFragment:o	I
    //   17196: aload_3
    //   17197: aload 5
    //   17199: putfield 3830	com/tencent/mobileqq/webview/swift/WebViewFragment:s	Ljava/lang/String;
    //   17202: iload 7
    //   17204: iconst_1
    //   17205: if_icmpne +62 -> 17267
    //   17208: aload_0
    //   17209: iload 6
    //   17211: invokevirtual 3832	com/tencent/mobileqq/jsp/UiApiPlugin:b	(I)V
    //   17214: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17217: ifeq -17033 -> 184
    //   17220: ldc 191
    //   17222: iconst_2
    //   17223: new 497	java/lang/StringBuilder
    //   17226: dup
    //   17227: invokespecial 498	java/lang/StringBuilder:<init>	()V
    //   17230: ldc_w 3834
    //   17233: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17236: aload_1
    //   17237: invokevirtual 183	org/json/JSONObject:toString	()Ljava/lang/String;
    //   17240: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17243: invokevirtual 505	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17246: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17249: goto -17065 -> 184
    //   17252: astore_1
    //   17253: ldc 191
    //   17255: iconst_1
    //   17256: aload_1
    //   17257: iconst_0
    //   17258: anewarray 843	java/lang/Object
    //   17261: invokestatic 1080	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   17264: goto -17080 -> 184
    //   17267: aload_3
    //   17268: invokevirtual 3836	com/tencent/mobileqq/webview/swift/WebViewFragment:q	()V
    //   17271: aload_3
    //   17272: iconst_1
    //   17273: invokevirtual 3837	com/tencent/mobileqq/webview/swift/WebViewFragment:e	(Z)V
    //   17276: goto -62 -> 17214
    //   17279: ldc_w 3839
    //   17282: aload_2
    //   17283: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17286: ifeq +11 -> 17297
    //   17289: aload_3
    //   17290: iconst_0
    //   17291: invokevirtual 3837	com/tencent/mobileqq/webview/swift/WebViewFragment:e	(Z)V
    //   17294: goto -80 -> 17214
    //   17297: ldc_w 3740
    //   17300: aload_2
    //   17301: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17304: ifeq +27 -> 17331
    //   17307: aload_3
    //   17308: aload 4
    //   17310: putfield 3823	com/tencent/mobileqq/webview/swift/WebViewFragment:r	Ljava/lang/String;
    //   17313: aload_0
    //   17314: getfield 1793	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser	Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUser;
    //   17317: ifnull -103 -> 17214
    //   17320: aload_0
    //   17321: getfield 1793	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser	Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUser;
    //   17324: aconst_null
    //   17325: invokevirtual 3842	com/tencent/mobileqq/activity/miniaio/MiniMsgUser:onClick	(Landroid/view/View;)V
    //   17328: goto -114 -> 17214
    //   17331: ldc_w 3844
    //   17334: aload_2
    //   17335: invokevirtual 646	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17338: ifeq -124 -> 17214
    //   17341: invokestatic 3849	com/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient:getInstance	()Lcom/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient;
    //   17344: iload 6
    //   17346: invokevirtual 3852	com/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient:clearBusiness	(I)V
    //   17349: goto -135 -> 17214
    //   17352: iconst_0
    //   17353: ireturn
    //   17354: astore_2
    //   17355: goto -6439 -> 10916
    //   17358: astore 15
    //   17360: goto -13490 -> 3870
    //   17363: aload_1
    //   17364: astore_2
    //   17365: ldc_w 371
    //   17368: astore_1
    //   17369: goto -4014 -> 13355
    //   17372: aconst_null
    //   17373: astore_1
    //   17374: aload_3
    //   17375: astore_2
    //   17376: goto -6164 -> 11212
    //   17379: goto -7603 -> 9776
    //   17382: aconst_null
    //   17383: astore_1
    //   17384: goto -9963 -> 7421
    //   17387: aconst_null
    //   17388: astore_1
    //   17389: goto -10205 -> 7184
    //   17392: iconst_0
    //   17393: istore 6
    //   17395: goto -10256 -> 7139
    //   17398: aconst_null
    //   17399: astore_1
    //   17400: goto -10429 -> 6971
    //   17403: aload_2
    //   17404: astore_1
    //   17405: goto -14135 -> 3270
    //   17408: goto -14168 -> 3240
    //   17411: goto -17227 -> 184
    //   17414: iload 7
    //   17416: istore 6
    //   17418: goto -16842 -> 576
    //   17421: iconst_1
    //   17422: ireturn
    //   17423: iconst_1
    //   17424: ireturn
    //   17425: iconst_1
    //   17426: ireturn
    //   17427: iconst_1
    //   17428: ireturn
    //   17429: iconst_1
    //   17430: ireturn
    //   17431: astore_1
    //   17432: goto -17248 -> 184
    //   17435: iconst_1
    //   17436: ireturn
    //   17437: iload 6
    //   17439: tableswitch	default:+17 -> 17456, 1001:+-13071->4368
    //   17457: <illegal opcode>
    //   17458: <illegal opcode>
    //   17459: iload 6
    //   17461: tableswitch	default:+19 -> 17480, 1001:+-12883->4578
    //   17481: newarray ऱ⁣䔣䙃䘱7ल⁣㠣㤱䈸2ळ⁣㠣㤱䈸1ऴ⁣䐣䐰䙆0व⁣䐣䔲䘱2श⁣䐣䔱䘰1ष⁣䐣䔱䘰0स⁣䐣䔲䘱1ह⁣䐣䔵䘳3र⁣䐣䐱䕆Eॡ⁣䐣䔷䘵4ॢ⁣䐣䔸䘵4ॣ⁣䐣䔷䘴3।⁣䐣䔹䘶4॥⁣䔣䔱䙂6०⁣䔣䔳䙃6१⁣䔣䙂䘱8२⁣䌣䐶䔷9३⁣䔣䙂䘱7४⁣䔣䙅䘳8५⁣䘣䘱䘵9६⁣䘣䘳䘶9७⁣䘣䘴䘶8८⁣䘣䘷䘸9९⁣㤣䄸䈹9॰⁣䐣䐱䕆Cॱ⁣䐣䔲䔰Cॲ⁣䈣䍄䑃8ॳ⁣䘣䘱䘵8ॴ⁣䘣䘳䘶8ॵ⁣䐣䔶䔱7ॶ⁣䐣䔷䔱7ॷ⁣䈣䌸䌱1ॸ⁣䘣䘷䘹9ॹ⁣䔣䔲䐷Eॺ⁣䔣䔳䐷Fु⁣䘣䙅䕄Fू⁣䘣䔰䑄6ृ⁣䘣䔰䑃6ॄ⁣䔣䕅䑂8ॅ⁣䘣䘶䐰2ॆ⁣䘣䙅䔹2े⁣䘣䔶䑆2ै⁣䘣䕃䉄9ॉ⁣䘣䙄䌳Fॊ⁣䘣䙃䌲Fो⁣䈣㥁㈷6ौ⁣䌣䉅㘸F्⁣䘣䕂㤱0ॎ⁣䘣䕃䄷3ॏ⁣䈣㠱㉁1ॐ⁣䈣㠰㉁1॑⁣䈣㠰㉂1॒⁣䘣䑂㡄3॓⁣䘣䙄䙃A॔⁣䘣䙁䙁A††††††††
    //   17483: iconst_0
    //   17484: istore 12
    //   17486: goto -12523 -> 4963
    //   17489: iconst_0
    //   17490: istore 12
    //   17492: goto -12142 -> 5350
    //   17495: iload 6
    //   17497: ldc_w 1611
    //   17500: ior
    //   17501: istore 6
    //   17503: goto -11073 -> 6430
    //   17506: iload 6
    //   17508: iconst_1
    //   17509: iadd
    //   17510: istore 6
    //   17512: goto -10633 -> 6879
    //   17515: iload 6
    //   17517: iconst_1
    //   17518: iadd
    //   17519: istore 6
    //   17521: goto -6122 -> 11399
    //   17524: iconst_1
    //   17525: ireturn
    //   17526: iconst_1
    //   17527: ireturn
    //   17528: iconst_1
    //   17529: ireturn
    //   17530: iconst_1
    //   17531: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	17532	0	this	UiApiPlugin
    //   0	17532	1	paramJsBridgeListener	JsBridgeListener
    //   0	17532	2	paramString1	String
    //   0	17532	3	paramString2	String
    //   0	17532	4	paramString3	String
    //   0	17532	5	paramVarArgs	String[]
    //   268	17252	6	n	int
    //   526	16889	7	i1	int
    //   516	13934	8	i2	int
    //   5061	205	9	i3	int
    //   259	7737	10	l1	long
    //   1609	15882	12	bool1	boolean
    //   3102	11350	13	bool2	boolean
    //   880	16185	14	localObject1	Object
    //   3082	9819	15	localObject2	Object
    //   17358	1	15	localJSONException	JSONException
    //   11146	53	16	str	String
    // Exception table:
    //   from	to	target	type
    //   33	91	186	org/json/JSONException
    //   96	176	186	org/json/JSONException
    //   176	184	186	org/json/JSONException
    //   240	355	358	org/json/JSONException
    //   445	453	601	org/json/JSONException
    //   459	508	601	org/json/JSONException
    //   508	525	601	org/json/JSONException
    //   576	598	601	org/json/JSONException
    //   662	693	601	org/json/JSONException
    //   707	732	793	org/json/JSONException
    //   734	790	793	org/json/JSONException
    //   824	853	1002	org/json/JSONException
    //   855	954	1002	org/json/JSONException
    //   960	968	1002	org/json/JSONException
    //   972	984	1002	org/json/JSONException
    //   984	999	1002	org/json/JSONException
    //   1028	1049	1002	org/json/JSONException
    //   1063	1103	1106	org/json/JSONException
    //   1138	1145	1153	java/lang/Exception
    //   1138	1145	1162	finally
    //   1295	1312	1315	org/json/JSONException
    //   1353	1361	1442	org/json/JSONException
    //   1365	1372	1442	org/json/JSONException
    //   1375	1439	1442	org/json/JSONException
    //   1480	1488	1521	org/json/JSONException
    //   1492	1499	1521	org/json/JSONException
    //   1502	1518	1521	org/json/JSONException
    //   1559	1567	1638	org/json/JSONException
    //   1571	1578	1638	org/json/JSONException
    //   1581	1635	1638	org/json/JSONException
    //   1676	1684	1716	org/json/JSONException
    //   1688	1695	1716	org/json/JSONException
    //   1698	1713	1716	org/json/JSONException
    //   1754	1762	1794	java/lang/Exception
    //   1766	1773	1794	java/lang/Exception
    //   1776	1791	1794	java/lang/Exception
    //   2056	2117	2207	org/json/JSONException
    //   2119	2190	2207	org/json/JSONException
    //   2192	2204	2207	org/json/JSONException
    //   2240	2286	2207	org/json/JSONException
    //   2307	2340	2391	org/json/JSONException
    //   2344	2364	2391	org/json/JSONException
    //   2364	2380	2391	org/json/JSONException
    //   2384	2388	2391	org/json/JSONException
    //   2417	2438	2441	org/json/JSONException
    //   2467	2500	2527	org/json/JSONException
    //   2504	2524	2527	org/json/JSONException
    //   2553	2586	2646	org/json/JSONException
    //   2590	2610	2646	org/json/JSONException
    //   2672	2705	2765	org/json/JSONException
    //   2709	2729	2765	org/json/JSONException
    //   2791	2824	2884	org/json/JSONException
    //   2828	2848	2884	org/json/JSONException
    //   2910	2943	3003	org/json/JSONException
    //   2947	2967	3003	org/json/JSONException
    //   3300	3305	3308	java/lang/Exception
    //   3029	3050	3312	org/json/JSONException
    //   3055	3063	3312	org/json/JSONException
    //   3066	3208	3312	org/json/JSONException
    //   3208	3219	3312	org/json/JSONException
    //   3224	3240	3312	org/json/JSONException
    //   3240	3249	3312	org/json/JSONException
    //   3254	3270	3312	org/json/JSONException
    //   3270	3279	3312	org/json/JSONException
    //   3279	3300	3312	org/json/JSONException
    //   3300	3305	3312	org/json/JSONException
    //   3338	3436	3439	org/json/JSONException
    //   3454	3461	3439	org/json/JSONException
    //   3479	3544	3439	org/json/JSONException
    //   3547	3554	3439	org/json/JSONException
    //   3557	3583	3439	org/json/JSONException
    //   3587	3627	3439	org/json/JSONException
    //   3630	3665	3439	org/json/JSONException
    //   3669	3724	3439	org/json/JSONException
    //   3338	3436	3464	java/lang/Exception
    //   3454	3461	3464	java/lang/Exception
    //   3479	3544	3464	java/lang/Exception
    //   3547	3554	3464	java/lang/Exception
    //   3557	3583	3464	java/lang/Exception
    //   3587	3627	3464	java/lang/Exception
    //   3630	3665	3464	java/lang/Exception
    //   3669	3724	3464	java/lang/Exception
    //   3768	3833	3939	java/lang/Exception
    //   3833	3843	3939	java/lang/Exception
    //   3843	3852	3939	java/lang/Exception
    //   3857	3870	3939	java/lang/Exception
    //   3870	3936	3939	java/lang/Exception
    //   4001	4009	3939	java/lang/Exception
    //   4012	4039	3939	java/lang/Exception
    //   4042	4104	3939	java/lang/Exception
    //   4104	4123	3939	java/lang/Exception
    //   4189	4272	3939	java/lang/Exception
    //   4275	4314	3939	java/lang/Exception
    //   4317	4333	3939	java/lang/Exception
    //   4381	4485	3939	java/lang/Exception
    //   4488	4553	3939	java/lang/Exception
    //   3752	3764	3994	org/json/JSONException
    //   3833	3843	4000	org/json/JSONException
    //   4123	4137	4185	java/lang/Exception
    //   4140	4175	4185	java/lang/Exception
    //   4175	4182	4185	java/lang/Exception
    //   4336	4365	4185	java/lang/Exception
    //   4368	4378	4185	java/lang/Exception
    //   4553	4575	4185	java/lang/Exception
    //   4578	4588	4185	java/lang/Exception
    //   4627	4656	5933	org/json/JSONException
    //   4658	4666	5933	org/json/JSONException
    //   4672	4720	5933	org/json/JSONException
    //   4724	4746	5933	org/json/JSONException
    //   4746	4782	5933	org/json/JSONException
    //   4782	4801	5933	org/json/JSONException
    //   4806	4848	5933	org/json/JSONException
    //   4852	4860	5933	org/json/JSONException
    //   4860	4904	5933	org/json/JSONException
    //   4919	4939	5933	org/json/JSONException
    //   4939	4960	5933	org/json/JSONException
    //   4963	4969	5933	org/json/JSONException
    //   4969	5105	5933	org/json/JSONException
    //   5105	5157	5933	org/json/JSONException
    //   5157	5193	5933	org/json/JSONException
    //   5200	5217	5933	org/json/JSONException
    //   5223	5272	5933	org/json/JSONException
    //   5276	5280	5933	org/json/JSONException
    //   5280	5302	5933	org/json/JSONException
    //   5302	5307	5933	org/json/JSONException
    //   5307	5326	5933	org/json/JSONException
    //   5335	5341	5933	org/json/JSONException
    //   5350	5384	5933	org/json/JSONException
    //   5384	5408	5933	org/json/JSONException
    //   5408	5426	5933	org/json/JSONException
    //   5426	5445	5933	org/json/JSONException
    //   5451	5455	5933	org/json/JSONException
    //   5455	5476	5933	org/json/JSONException
    //   5476	5508	5933	org/json/JSONException
    //   5508	5537	5933	org/json/JSONException
    //   5537	5556	5933	org/json/JSONException
    //   5561	5585	5933	org/json/JSONException
    //   5585	5593	5933	org/json/JSONException
    //   5593	5612	5933	org/json/JSONException
    //   5621	5640	5933	org/json/JSONException
    //   5640	5644	5933	org/json/JSONException
    //   5644	5663	5933	org/json/JSONException
    //   5673	5677	5933	org/json/JSONException
    //   5677	5702	5933	org/json/JSONException
    //   5702	5730	5933	org/json/JSONException
    //   5735	5756	5933	org/json/JSONException
    //   5767	5772	5933	org/json/JSONException
    //   5772	5792	5933	org/json/JSONException
    //   5796	5802	5933	org/json/JSONException
    //   5802	5822	5933	org/json/JSONException
    //   5826	5847	5933	org/json/JSONException
    //   5847	5857	5933	org/json/JSONException
    //   5861	5894	5933	org/json/JSONException
    //   5894	5930	5933	org/json/JSONException
    //   5969	5981	5933	org/json/JSONException
    //   6020	6033	5933	org/json/JSONException
    //   6036	6046	5933	org/json/JSONException
    //   6051	6057	5933	org/json/JSONException
    //   6060	6077	5933	org/json/JSONException
    //   6077	6085	5933	org/json/JSONException
    //   6088	6133	5933	org/json/JSONException
    //   6136	6142	5933	org/json/JSONException
    //   6147	6169	5933	org/json/JSONException
    //   6176	6240	5933	org/json/JSONException
    //   6240	6247	5933	org/json/JSONException
    //   6251	6261	5933	org/json/JSONException
    //   6261	6289	5933	org/json/JSONException
    //   6289	6340	5933	org/json/JSONException
    //   6343	6351	5933	org/json/JSONException
    //   6354	6384	5933	org/json/JSONException
    //   6387	6416	5933	org/json/JSONException
    //   6430	6442	5933	org/json/JSONException
    //   6445	6457	5933	org/json/JSONException
    //   6466	6485	5933	org/json/JSONException
    //   6493	6498	5933	org/json/JSONException
    //   6501	6523	5933	org/json/JSONException
    //   6523	6556	5933	org/json/JSONException
    //   4627	4656	5984	java/lang/Exception
    //   4658	4666	5984	java/lang/Exception
    //   4672	4720	5984	java/lang/Exception
    //   4724	4746	5984	java/lang/Exception
    //   4746	4782	5984	java/lang/Exception
    //   4782	4801	5984	java/lang/Exception
    //   4806	4848	5984	java/lang/Exception
    //   4852	4860	5984	java/lang/Exception
    //   4860	4904	5984	java/lang/Exception
    //   4919	4939	5984	java/lang/Exception
    //   4939	4960	5984	java/lang/Exception
    //   4963	4969	5984	java/lang/Exception
    //   4969	5105	5984	java/lang/Exception
    //   5105	5157	5984	java/lang/Exception
    //   5157	5193	5984	java/lang/Exception
    //   5200	5217	5984	java/lang/Exception
    //   5223	5272	5984	java/lang/Exception
    //   5276	5280	5984	java/lang/Exception
    //   5280	5302	5984	java/lang/Exception
    //   5302	5307	5984	java/lang/Exception
    //   5307	5326	5984	java/lang/Exception
    //   5335	5341	5984	java/lang/Exception
    //   5350	5384	5984	java/lang/Exception
    //   5384	5408	5984	java/lang/Exception
    //   5408	5426	5984	java/lang/Exception
    //   5426	5445	5984	java/lang/Exception
    //   5451	5455	5984	java/lang/Exception
    //   5455	5476	5984	java/lang/Exception
    //   5476	5508	5984	java/lang/Exception
    //   5508	5537	5984	java/lang/Exception
    //   5537	5556	5984	java/lang/Exception
    //   5561	5585	5984	java/lang/Exception
    //   5585	5593	5984	java/lang/Exception
    //   5593	5612	5984	java/lang/Exception
    //   5621	5640	5984	java/lang/Exception
    //   5640	5644	5984	java/lang/Exception
    //   5644	5663	5984	java/lang/Exception
    //   5673	5677	5984	java/lang/Exception
    //   5677	5702	5984	java/lang/Exception
    //   5702	5730	5984	java/lang/Exception
    //   5735	5756	5984	java/lang/Exception
    //   5767	5772	5984	java/lang/Exception
    //   5772	5792	5984	java/lang/Exception
    //   5796	5802	5984	java/lang/Exception
    //   5802	5822	5984	java/lang/Exception
    //   5826	5847	5984	java/lang/Exception
    //   5847	5857	5984	java/lang/Exception
    //   5861	5894	5984	java/lang/Exception
    //   5894	5930	5984	java/lang/Exception
    //   5969	5981	5984	java/lang/Exception
    //   6020	6033	5984	java/lang/Exception
    //   6036	6046	5984	java/lang/Exception
    //   6051	6057	5984	java/lang/Exception
    //   6060	6077	5984	java/lang/Exception
    //   6077	6085	5984	java/lang/Exception
    //   6088	6133	5984	java/lang/Exception
    //   6136	6142	5984	java/lang/Exception
    //   6147	6169	5984	java/lang/Exception
    //   6176	6240	5984	java/lang/Exception
    //   6240	6247	5984	java/lang/Exception
    //   6251	6261	5984	java/lang/Exception
    //   6261	6289	5984	java/lang/Exception
    //   6289	6340	5984	java/lang/Exception
    //   6343	6351	5984	java/lang/Exception
    //   6354	6384	5984	java/lang/Exception
    //   6387	6416	5984	java/lang/Exception
    //   6430	6442	5984	java/lang/Exception
    //   6445	6457	5984	java/lang/Exception
    //   6466	6485	5984	java/lang/Exception
    //   6493	6498	5984	java/lang/Exception
    //   6501	6523	5984	java/lang/Exception
    //   6523	6556	5984	java/lang/Exception
    //   6577	6602	7015	org/json/JSONException
    //   6604	6637	7015	org/json/JSONException
    //   6637	6658	7015	org/json/JSONException
    //   6658	6693	7015	org/json/JSONException
    //   6703	6744	7015	org/json/JSONException
    //   6744	6768	7015	org/json/JSONException
    //   6768	6792	7015	org/json/JSONException
    //   6792	6820	7015	org/json/JSONException
    //   6820	6832	7015	org/json/JSONException
    //   6841	6876	7015	org/json/JSONException
    //   6886	6923	7015	org/json/JSONException
    //   6926	6934	7015	org/json/JSONException
    //   6938	6943	7015	org/json/JSONException
    //   6947	6955	7015	org/json/JSONException
    //   6959	6971	7015	org/json/JSONException
    //   6975	6992	7015	org/json/JSONException
    //   6996	7012	7015	org/json/JSONException
    //   7069	7094	7199	org/json/JSONException
    //   7096	7139	7199	org/json/JSONException
    //   7139	7147	7199	org/json/JSONException
    //   7151	7156	7199	org/json/JSONException
    //   7160	7168	7199	org/json/JSONException
    //   7172	7184	7199	org/json/JSONException
    //   7188	7196	7199	org/json/JSONException
    //   7253	7278	7433	org/json/JSONException
    //   7280	7309	7433	org/json/JSONException
    //   7309	7330	7433	org/json/JSONException
    //   7330	7351	7433	org/json/JSONException
    //   7351	7376	7433	org/json/JSONException
    //   7376	7384	7433	org/json/JSONException
    //   7388	7393	7433	org/json/JSONException
    //   7397	7405	7433	org/json/JSONException
    //   7409	7421	7433	org/json/JSONException
    //   7425	7430	7433	org/json/JSONException
    //   7487	7513	7551	org/json/JSONException
    //   7513	7528	7551	org/json/JSONException
    //   7532	7548	7551	org/json/JSONException
    //   7605	7698	7754	org/json/JSONException
    //   7698	7751	7754	org/json/JSONException
    //   7808	7871	8020	org/json/JSONException
    //   7875	7882	8020	org/json/JSONException
    //   7882	7897	8020	org/json/JSONException
    //   7899	7940	8020	org/json/JSONException
    //   7942	7950	8020	org/json/JSONException
    //   7954	8017	8020	org/json/JSONException
    //   8074	8140	8274	org/json/JSONException
    //   8144	8151	8274	org/json/JSONException
    //   8151	8166	8274	org/json/JSONException
    //   8168	8176	8274	org/json/JSONException
    //   8185	8254	8274	org/json/JSONException
    //   8254	8271	8274	org/json/JSONException
    //   8310	8330	8274	org/json/JSONException
    //   8351	8403	8425	org/json/JSONException
    //   8405	8422	8425	org/json/JSONException
    //   8492	8498	8783	org/json/JSONException
    //   8503	8532	8783	org/json/JSONException
    //   8537	8550	8783	org/json/JSONException
    //   8555	8565	8783	org/json/JSONException
    //   8570	8580	8783	org/json/JSONException
    //   8585	8594	8783	org/json/JSONException
    //   8602	8610	8783	org/json/JSONException
    //   8614	8623	8783	org/json/JSONException
    //   8632	8640	8783	org/json/JSONException
    //   8644	8655	8783	org/json/JSONException
    //   8659	8675	8783	org/json/JSONException
    //   8731	8742	8783	org/json/JSONException
    //   8746	8755	8783	org/json/JSONException
    //   8759	8769	8783	org/json/JSONException
    //   8773	8780	8783	org/json/JSONException
    //   8848	8857	8783	org/json/JSONException
    //   8492	8498	8864	finally
    //   8503	8532	8864	finally
    //   8537	8550	8864	finally
    //   8555	8565	8864	finally
    //   8570	8580	8864	finally
    //   8585	8594	8864	finally
    //   8602	8610	8864	finally
    //   8614	8623	8864	finally
    //   8632	8640	8864	finally
    //   8644	8655	8864	finally
    //   8659	8675	8864	finally
    //   8731	8742	8864	finally
    //   8746	8755	8864	finally
    //   8759	8769	8864	finally
    //   8773	8780	8864	finally
    //   8786	8796	8864	finally
    //   8848	8857	8864	finally
    //   8930	8961	9041	org/json/JSONException
    //   8964	8995	9041	org/json/JSONException
    //   8995	9005	9041	org/json/JSONException
    //   9008	9017	9041	org/json/JSONException
    //   9022	9032	9041	org/json/JSONException
    //   9032	9038	9041	org/json/JSONException
    //   9077	9081	9041	org/json/JSONException
    //   9084	9122	9041	org/json/JSONException
    //   9127	9151	9041	org/json/JSONException
    //   9151	9165	9041	org/json/JSONException
    //   9168	9192	9041	org/json/JSONException
    //   9213	9320	9323	org/json/JSONException
    //   9213	9320	9359	java/lang/Exception
    //   9434	9446	9619	java/lang/Exception
    //   9448	9456	9619	java/lang/Exception
    //   9458	9470	9619	java/lang/Exception
    //   9472	9481	9619	java/lang/Exception
    //   9483	9492	9619	java/lang/Exception
    //   9497	9507	9619	java/lang/Exception
    //   9509	9518	9619	java/lang/Exception
    //   9520	9528	9619	java/lang/Exception
    //   9530	9539	9619	java/lang/Exception
    //   9546	9555	9619	java/lang/Exception
    //   9557	9566	9619	java/lang/Exception
    //   9568	9578	9619	java/lang/Exception
    //   9580	9589	9619	java/lang/Exception
    //   9591	9607	9619	java/lang/Exception
    //   9609	9616	9619	java/lang/Exception
    //   9695	9708	10045	java/lang/Exception
    //   9710	9719	10045	java/lang/Exception
    //   9721	9733	10045	java/lang/Exception
    //   9735	9745	10045	java/lang/Exception
    //   9747	9757	10045	java/lang/Exception
    //   9762	9770	10045	java/lang/Exception
    //   9778	9788	10045	java/lang/Exception
    //   9790	9800	10045	java/lang/Exception
    //   9802	9812	10045	java/lang/Exception
    //   9814	9820	10045	java/lang/Exception
    //   9822	9852	10045	java/lang/Exception
    //   9854	9861	10045	java/lang/Exception
    //   9863	9872	10045	java/lang/Exception
    //   9874	9884	10045	java/lang/Exception
    //   9886	9895	10045	java/lang/Exception
    //   9897	9907	10045	java/lang/Exception
    //   9909	9920	10045	java/lang/Exception
    //   9922	9932	10045	java/lang/Exception
    //   9934	9942	10045	java/lang/Exception
    //   9944	9954	10045	java/lang/Exception
    //   9956	9964	10045	java/lang/Exception
    //   9966	9976	10045	java/lang/Exception
    //   9978	9995	10045	java/lang/Exception
    //   9997	10004	10045	java/lang/Exception
    //   10079	10091	10182	java/lang/Exception
    //   10093	10101	10182	java/lang/Exception
    //   10103	10113	10182	java/lang/Exception
    //   10115	10124	10182	java/lang/Exception
    //   10126	10141	10182	java/lang/Exception
    //   10147	10154	10182	java/lang/Exception
    //   10156	10161	10182	java/lang/Exception
    //   10171	10179	10182	java/lang/Exception
    //   10227	10236	10182	java/lang/Exception
    //   10250	10259	10182	java/lang/Exception
    //   10283	10295	10386	java/lang/Exception
    //   10297	10305	10386	java/lang/Exception
    //   10307	10317	10386	java/lang/Exception
    //   10319	10328	10386	java/lang/Exception
    //   10330	10345	10386	java/lang/Exception
    //   10351	10358	10386	java/lang/Exception
    //   10360	10365	10386	java/lang/Exception
    //   10375	10383	10386	java/lang/Exception
    //   10431	10440	10386	java/lang/Exception
    //   10454	10463	10386	java/lang/Exception
    //   10483	10512	10515	org/json/JSONException
    //   10565	10615	10677	org/json/JSONException
    //   10618	10640	10677	org/json/JSONException
    //   10649	10674	10677	org/json/JSONException
    //   10831	10864	10896	java/lang/Exception
    //   10784	10821	10915	java/lang/Exception
    //   10897	10907	10915	java/lang/Exception
    //   11027	11040	11266	java/lang/Exception
    //   11045	11054	11266	java/lang/Exception
    //   11059	11068	11266	java/lang/Exception
    //   11073	11083	11266	java/lang/Exception
    //   11088	11097	11266	java/lang/Exception
    //   11102	11113	11266	java/lang/Exception
    //   11123	11133	11266	java/lang/Exception
    //   11138	11148	11266	java/lang/Exception
    //   11153	11162	11266	java/lang/Exception
    //   11167	11175	11266	java/lang/Exception
    //   11180	11188	11266	java/lang/Exception
    //   11193	11208	11266	java/lang/Exception
    //   11244	11258	11266	java/lang/Exception
    //   11336	11392	11521	org/json/JSONException
    //   11395	11399	11521	org/json/JSONException
    //   11406	11417	11521	org/json/JSONException
    //   11423	11449	11521	org/json/JSONException
    //   11452	11483	11521	org/json/JSONException
    //   11483	11509	11521	org/json/JSONException
    //   11509	11518	11521	org/json/JSONException
    //   11561	11583	11521	org/json/JSONException
    //   11603	11618	11621	org/json/JSONException
    //   11695	11716	11719	org/json/JSONException
    //   11769	11786	11800	org/json/JSONException
    //   11790	11797	11800	org/json/JSONException
    //   11769	11786	11839	java/lang/Exception
    //   11790	11797	11839	java/lang/Exception
    //   11895	11929	12047	java/lang/Exception
    //   11931	11965	12047	java/lang/Exception
    //   11969	11991	12047	java/lang/Exception
    //   11991	12044	12047	java/lang/Exception
    //   12091	12143	12163	java/lang/Exception
    //   12143	12160	12163	java/lang/Exception
    //   12184	12236	12487	org/json/JSONException
    //   12239	12247	12487	org/json/JSONException
    //   12251	12258	12487	org/json/JSONException
    //   12258	12274	12487	org/json/JSONException
    //   12277	12297	12487	org/json/JSONException
    //   12303	12484	12487	org/json/JSONException
    //   12531	12552	12487	org/json/JSONException
    //   12552	12573	12487	org/json/JSONException
    //   12184	12236	12576	java/lang/Exception
    //   12239	12247	12576	java/lang/Exception
    //   12251	12258	12576	java/lang/Exception
    //   12258	12274	12576	java/lang/Exception
    //   12277	12297	12576	java/lang/Exception
    //   12303	12484	12576	java/lang/Exception
    //   12531	12552	12576	java/lang/Exception
    //   12552	12573	12576	java/lang/Exception
    //   12669	12719	13000	org/json/JSONException
    //   12719	12762	13000	org/json/JSONException
    //   12765	12774	13000	org/json/JSONException
    //   12779	12787	13000	org/json/JSONException
    //   12787	12803	13000	org/json/JSONException
    //   12806	12997	13000	org/json/JSONException
    //   12669	12719	13039	java/lang/Exception
    //   12719	12762	13039	java/lang/Exception
    //   12765	12774	13039	java/lang/Exception
    //   12779	12787	13039	java/lang/Exception
    //   12787	12803	13039	java/lang/Exception
    //   12806	12997	13039	java/lang/Exception
    //   13089	13115	13172	org/json/JSONException
    //   13119	13169	13172	org/json/JSONException
    //   13089	13115	13229	java/lang/Exception
    //   13119	13169	13229	java/lang/Exception
    //   13308	13335	13393	org/json/JSONException
    //   13337	13355	13393	org/json/JSONException
    //   13355	13363	13393	org/json/JSONException
    //   13367	13390	13393	org/json/JSONException
    //   13447	13466	13555	org/json/JSONException
    //   13466	13476	13555	org/json/JSONException
    //   13476	13486	13555	org/json/JSONException
    //   13486	13494	13555	org/json/JSONException
    //   13498	13516	13555	org/json/JSONException
    //   13526	13536	13555	org/json/JSONException
    //   13542	13552	13555	org/json/JSONException
    //   13592	13618	13555	org/json/JSONException
    //   13628	13654	13555	org/json/JSONException
    //   13662	13672	13555	org/json/JSONException
    //   13680	13690	13555	org/json/JSONException
    //   13466	13476	13591	java/lang/Exception
    //   13476	13486	13624	java/lang/Exception
    //   13711	13751	13805	org/json/JSONException
    //   13755	13802	13805	org/json/JSONException
    //   13841	13866	13805	org/json/JSONException
    //   13894	13934	13937	org/json/JSONException
    //   13990	14033	14058	org/json/JSONException
    //   14041	14055	14058	org/json/JSONException
    //   14112	14139	14162	org/json/JSONException
    //   14143	14159	14162	org/json/JSONException
    //   14216	14240	14377	org/json/JSONException
    //   14243	14282	14377	org/json/JSONException
    //   14285	14340	14377	org/json/JSONException
    //   14345	14374	14377	org/json/JSONException
    //   14430	14471	14377	org/json/JSONException
    //   14491	14518	14534	org/json/JSONException
    //   14527	14531	14534	org/json/JSONException
    //   14548	14557	14534	org/json/JSONException
    //   14561	14598	14534	org/json/JSONException
    //   14604	14618	14534	org/json/JSONException
    //   14627	14641	14534	org/json/JSONException
    //   14725	14810	14813	java/lang/Exception
    //   14827	14845	14813	java/lang/Exception
    //   14850	14861	14813	java/lang/Exception
    //   14861	14882	14813	java/lang/Exception
    //   14885	14896	14813	java/lang/Exception
    //   14910	14951	14954	java/lang/Exception
    //   14990	15069	15072	java/lang/Exception
    //   15097	15176	15229	java/lang/Exception
    //   15176	15226	15229	java/lang/Exception
    //   15243	15277	15229	java/lang/Exception
    //   15280	15312	15229	java/lang/Exception
    //   15326	15399	15402	java/lang/Exception
    //   15427	15456	15538	java/lang/Exception
    //   15460	15535	15538	java/lang/Exception
    //   15563	15575	15581	java/lang/Exception
    //   15627	15724	15727	java/lang/Exception
    //   15752	15836	15839	java/lang/Exception
    //   15853	15858	15839	java/lang/Exception
    //   15861	15881	15839	java/lang/Exception
    //   15884	15896	15839	java/lang/Exception
    //   15899	15924	15839	java/lang/Exception
    //   16018	16099	16102	org/json/JSONException
    //   16121	16155	16206	java/lang/Exception
    //   16161	16203	16206	java/lang/Exception
    //   16231	16274	16330	org/json/JSONException
    //   16274	16298	16330	org/json/JSONException
    //   16301	16327	16330	org/json/JSONException
    //   16344	16356	16330	org/json/JSONException
    //   16376	16502	16525	org/json/JSONException
    //   16502	16522	16525	org/json/JSONException
    //   16550	16659	16672	org/json/JSONException
    //   16659	16669	16672	org/json/JSONException
    //   16697	16806	16819	org/json/JSONException
    //   16806	16816	16819	org/json/JSONException
    //   16844	16890	16893	org/json/JSONException
    //   16907	17059	16893	org/json/JSONException
    //   17059	17090	16893	org/json/JSONException
    //   17104	17202	17252	java/lang/Exception
    //   17208	17214	17252	java/lang/Exception
    //   17214	17249	17252	java/lang/Exception
    //   17267	17276	17252	java/lang/Exception
    //   17279	17294	17252	java/lang/Exception
    //   17297	17328	17252	java/lang/Exception
    //   17331	17349	17252	java/lang/Exception
    //   10758	10778	17354	java/lang/Exception
    //   3843	3852	17358	org/json/JSONException
    //   3857	3870	17358	org/json/JSONException
    //   1874	1915	17431	org/json/JSONException
    //   1917	1990	17431	org/json/JSONException
    //   1992	2003	17431	org/json/JSONException
    //   2006	2035	17431	org/json/JSONException
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
                          for (paramIntent = "''";; paramIntent = mpw.a((String)localObject1))
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
      azkd.a(this.mRuntime.a(), paramIntent, null);
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
    anfc.a().a(this.jdField_a_of_type_Anad);
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
    if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing())) {
      this.jdField_a_of_type_Begr.dismiss();
    }
    if (this.jdField_a_of_type_Wis != null) {
      this.jdField_a_of_type_Wis.b();
    }
    anfc.a().b(this.jdField_a_of_type_Anad);
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