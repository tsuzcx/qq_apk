package com.tencent.mobileqq.vashealth;

import aciy;
import ajed;
import ajjy;
import akij;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import awii;
import awqx;
import baaf;
import badq;
import barc;
import bard;
import bare;
import barf;
import barg;
import barh;
import barj;
import bark;
import barl;
import barm;
import baro;
import barp;
import bbac;
import bbms;
import bbmy;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.richmedia.MX3FlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import kzy;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import ndt;
import org.json.JSONArray;
import org.json.JSONObject;
import qcn;
import qht;
import qhw;

public class HealthBusinessPlugin
  extends WebViewPlugin
{
  public static HashMap<String, JSONObject> a;
  static List<String> jdField_a_of_type_JavaUtilList;
  public static HashMap<String, HealthBusinessPlugin.UploadThread> b;
  static HashMap<String, Double> c;
  public int a;
  public Point a;
  Uri jdField_a_of_type_AndroidNetUri;
  public Handler a;
  public FrameLayout a;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  baro jdField_a_of_type_Baro = null;
  bbms jdField_a_of_type_Bbms;
  RefreshView jdField_a_of_type_ComTencentBizUiRefreshView;
  public TouchWebView a;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  public Runnable a;
  String jdField_a_of_type_JavaLangString;
  qht jdField_a_of_type_Qht = null;
  qhw jdField_a_of_type_Qhw;
  public boolean a;
  public int b;
  public Point b;
  public Handler b;
  public Runnable b;
  String b;
  public boolean b;
  public int c;
  public Handler c;
  public boolean c;
  public int d;
  public HashMap<String, TVK_IMediaPlayer> d = new HashMap();
  public boolean d;
  public int e;
  public HashMap<String, FrameLayout> e;
  boolean e;
  public int f;
  public HashMap<String, barp> f;
  public boolean f;
  public int g;
  HashMap<String, Timer> g = new HashMap();
  public int h;
  HashMap<String, Long> h = new HashMap();
  public int i;
  public int j;
  public int k;
  public int l;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public HealthBusinessPlugin()
  {
    this.jdField_e_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_f_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point();
    this.jdField_b_of_type_AndroidGraphicsPoint = new Point();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_b_of_type_AndroidOsHandler = new barl(this);
    this.jdField_f_of_type_Boolean = false;
    this.mPluginNameSpace = "healthSport";
  }
  
  int a(JSONObject paramJSONObject)
  {
    Object localObject2 = this.mRuntime.a();
    int n = 1;
    int i2 = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar((Context)localObject2);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(((Context)localObject2).getResources().getDrawable(2130840064));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
    double d1;
    double d2;
    double d3;
    double d4;
    String str;
    int m;
    try
    {
      d1 = paramJSONObject.getDouble("top");
      d2 = paramJSONObject.getDouble("left");
      d3 = paramJSONObject.getDouble("width");
      d4 = paramJSONObject.getDouble("height");
      str = paramJSONObject.getString("vid");
      localObject3 = this.mRuntime.a().getResources().getDisplayMetrics();
      m = i2;
    }
    catch (Exception paramJSONObject)
    {
      int i3;
      label164:
      QLog.d("HealthBusinessPlugin", 1, "AddView Err:");
      return -6;
    }
    try
    {
      i1 = paramJSONObject.optInt("needCheckWiFi");
      m = i2;
      n = i1;
      i2 = paramJSONObject.optInt("needMute");
      m = i2;
      n = i1;
      i3 = paramJSONObject.optInt("needCountdown");
      m = i3;
      n = i1;
    }
    catch (Exception paramJSONObject)
    {
      if (!QLog.isColorLevel()) {
        break label229;
      }
      QLog.d("HealthBusinessPlugin", 2, "optional Err");
      i2 = 1;
      i1 = m;
      m = i2;
      i2 = i1;
      break label164;
      if (!QLog.isColorLevel()) {
        break label261;
      }
      QLog.d("HealthBusinessPlugin", 2, "addView Function");
      float f1 = this.mRuntime.a().getResources().getDisplayMetrics().density;
      localObject5 = new FrameLayout.LayoutParams((int)(f1 * d3), (int)(f1 * d4));
      ((FrameLayout.LayoutParams)localObject5).topMargin = ((int)(f1 * d1));
      ((FrameLayout.LayoutParams)localObject5).leftMargin = ((int)(f1 * d2));
      this.mRuntime.a();
      if ((d3 != 0.0D) && (d4 != 0.0D)) {
        break label349;
      }
      return -1;
      if (!this.d.containsKey(str)) {
        break label364;
      }
      return -2;
      if (this.d.size() != 3) {
        break label378;
      }
      return -4;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      TVK_SDKMgr.setDebugEnable(true);
      if (!TVK_SDKMgr.isInstalled(this.mRuntime.a().getApplication())) {
        break label468;
      }
      for (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();; this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory())
      {
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
        }
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) {
          break;
        }
        paramJSONObject = Toast.makeText(this.mRuntime.a().getApplication(), ajjy.a(2131639654), 1);
        paramJSONObject.setGravity(17, 0, 0);
        paramJSONObject.show();
        return -1;
        if (badq.b(BaseApplication.getContext()) == 1) {}
        ThreadManager.post(new HealthBusinessPlugin.7(this), 5, null, true);
      }
      localIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.mRuntime.a());
      localObject4 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.mRuntime.a(), localIVideoViewBase);
      ((TVK_IMediaPlayer)localObject4).setLoopback(true);
      this.jdField_a_of_type_JavaLangRunnable = new HealthBusinessPlugin.8(this);
      this.jdField_b_of_type_JavaLangRunnable = new HealthBusinessPlugin.9(this);
      a((TVK_IMediaPlayer)localObject4);
      localObject6 = new TVK_UserInfo();
      ((TVK_UserInfo)localObject6).setLoginCookie("");
      ((TVK_UserInfo)localObject6).setUin(this.mRuntime.a().getCurrentAccountUin());
      paramJSONObject = new HashMap();
      paramJSONObject.put("shouq_bus_type", "shouq_sport_sdk");
      TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, str, "");
      localTVK_PlayerVideoInfo.setPlayType(8);
      localTVK_PlayerVideoInfo.setReportInfoMap(paramJSONObject);
      if ((WifiManager)this.mRuntime.a().getSystemService("wifi") != null) {
        break label1024;
      }
      localObject1 = "msd";
      paramJSONObject = (JSONObject)localObject1;
      if (!QLog.isColorLevel()) {
        break label704;
      }
      QLog.d("HealthBusinessPlugin", 2, "no wifi");
      paramJSONObject = (JSONObject)localObject1;
      for (;;)
      {
        ((TVK_IMediaPlayer)localObject4).openMediaPlayer(this.mRuntime.a(), (TVK_UserInfo)localObject6, localTVK_PlayerVideoInfo, paramJSONObject, 0L, 0L);
        if (QLog.isColorLevel()) {
          QLog.d("HealthBusinessPlugin", 2, "sDensity:" + f1);
        }
        localObject6 = (FrameLayout)LayoutInflater.from((Context)localObject2).inflate(2131494533, null);
        paramJSONObject = new barp();
        paramJSONObject.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((FrameLayout)localObject6).findViewById(2131307409));
        paramJSONObject.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((FrameLayout)localObject6).findViewById(2131307408));
        paramJSONObject.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)localObject6).findViewById(2131307407));
        paramJSONObject.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)localObject6).findViewById(2131307410));
        paramJSONObject.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)((FrameLayout)localObject6).findViewById(2131310010));
        paramJSONObject.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)localObject6).findViewById(2131307411));
        paramJSONObject.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((FrameLayout)localObject6).findViewById(2131307406));
        localObject1 = new FrameLayout((Context)localObject2);
        ((FrameLayout)localObject1).addView((View)localIVideoViewBase);
        ((FrameLayout)localObject1).addView((View)localObject6);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject5);
        this.jdField_e_of_type_JavaUtilHashMap.put(str, localObject1);
        this.jdField_f_of_type_JavaUtilHashMap.put(str, paramJSONObject);
        if (this.d == null) {
          this.d = new HashMap();
        }
        localObject5 = this.d.keySet().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (String)((Iterator)localObject5).next();
          ((TVK_IMediaPlayer)this.d.get(localObject6)).pause();
        }
        localObject1 = "hd";
        paramJSONObject = (JSONObject)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("HealthBusinessPlugin", 2, "wifi");
          paramJSONObject = (JSONObject)localObject1;
        }
      }
      this.d.put(str, localObject4);
      this.h.put(str, Long.valueOf(0L));
      this.jdField_c_of_type_AndroidOsHandler = new Handler();
      paramJSONObject.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      if (i2 != 0) {
        break label1676;
      }
    }
    paramJSONObject = ((ConnectivityManager)((Context)localObject2).getSystemService("connectivity")).getNetworkInfo(1);
    if ((paramJSONObject != null) && (paramJSONObject.getState() == NetworkInfo.State.DISCONNECTED) && (n == 1)) {
      return -5;
    }
    label229:
    label364:
    label378:
    IVideoViewBase localIVideoViewBase;
    label261:
    label349:
    Object localObject1;
    label468:
    ((TVK_IMediaPlayer)this.d.get(str)).setOutputMute(false);
    label704:
    paramJSONObject.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    label1024:
    paramJSONObject.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(((Context)localObject2).getResources().getDrawable(2130845277));
    paramJSONObject.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new bard(this, str, (Context)localObject2));
    new FrameLayout.LayoutParams(aciy.a(45.0F, ((Context)localObject2).getResources()), aciy.a(43.0F, ((Context)localObject2).getResources())).gravity = 85;
    paramJSONObject.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bare(this, str, paramJSONObject));
    n = this.mRuntime.a().getResources().getDisplayMetrics().widthPixels;
    int i1 = (int)(((DisplayMetrics)localObject3).density * d3 * 0.7D);
    i2 = (int)(((DisplayMetrics)localObject3).density * d3 * 0.15D);
    QLog.d("HealthBusinessPlugin", 1, "screen width:" + (n - 200) / 2);
    Object localObject3 = new FrameLayout.LayoutParams(i1, aciy.a(20.0F, ((Context)localObject2).getResources()));
    Object localObject4 = new FrameLayout.LayoutParams(i2, aciy.a(20.0F, ((Context)localObject2).getResources()));
    Object localObject5 = new FrameLayout.LayoutParams(i2, aciy.a(20.0F, ((Context)localObject2).getResources()));
    Object localObject6 = new FrameLayout.LayoutParams(aciy.a(60.0F, ((Context)localObject2).getResources()), aciy.a(60.0F, ((Context)localObject2).getResources()));
    ((FrameLayout.LayoutParams)localObject3).gravity = 81;
    ((FrameLayout.LayoutParams)localObject4).gravity = 83;
    ((FrameLayout.LayoutParams)localObject5).gravity = 85;
    ((FrameLayout.LayoutParams)localObject6).gravity = 17;
    qcn.a(paramJSONObject.jdField_b_of_type_AndroidWidgetTextView, ((TVK_IMediaPlayer)this.d.get(str)).getCurrentPostion());
    ((FrameLayout)localObject1).setBackgroundColor(-16777216);
    ((FrameLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetProgressBar, (ViewGroup.LayoutParams)localObject6);
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "add seekbar");
    }
    paramJSONObject.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_f_of_type_Boolean = false;
    paramJSONObject.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new barf(this, str));
    this.jdField_a_of_type_Qht = new qht();
    this.jdField_a_of_type_Qhw = new qhw((Context)localObject2);
    new FrameLayout.LayoutParams(-2, aciy.a(43.0F, ((Context)localObject2).getResources())).gravity = 85;
    qcn.a(paramJSONObject.jdField_a_of_type_AndroidWidgetTextView, ((TVK_IMediaPlayer)this.d.get(str)).getDuration());
    if (m == 1) {
      paramJSONObject.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      a(paramJSONObject.jdField_a_of_type_AndroidWidgetTextView, str, paramJSONObject.jdField_b_of_type_AndroidWidgetTextView, paramJSONObject.jdField_c_of_type_AndroidWidgetTextView, paramJSONObject.jdField_a_of_type_AndroidWidgetSeekBar);
      localObject2 = new barg(this);
      this.mRuntime.a().setOnTouchListener((View.OnTouchListener)localObject2);
      paramJSONObject.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      paramJSONObject.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new barh(this, paramJSONObject, localIVideoViewBase, (FrameLayout)localObject1));
      return 0;
      label1676:
      ((TVK_IMediaPlayer)this.d.get(str)).setOutputMute(true);
      paramJSONObject.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramJSONObject.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(((Context)localObject2).getResources().getDrawable(2130845276));
      break;
      paramJSONObject.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  SharedPreferences a()
  {
    String str2 = this.mRuntime.a().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "nologin";
    }
    return this.mRuntime.a().getApplication().getSharedPreferences(str1 + "_health", 0);
  }
  
  void a()
  {
    Intent localIntent = null;
    Object localObject = null;
    if (kzy.b(BaseApplicationImpl.getContext())) {}
    for (;;)
    {
      return;
      File localFile = new File(ajed.ba);
      boolean bool;
      if (localFile.exists()) {
        bool = true;
      }
      for (;;)
      {
        if ((bool) && (localFile.canWrite())) {
          if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
          {
            QLog.e("HealthBusinessPlugin", 1, "temp ids lost!");
            return;
            bool = localFile.mkdirs();
          }
          else
          {
            if (this.mRuntime == null) {}
            while ((localObject != null) && (!((Activity)localObject).isFinishing()))
            {
              localIntent = new Intent();
              this.jdField_a_of_type_AndroidNetUri = FileProvider7Helper.setSystemCapture((Context)localObject, new File(ajed.ba + System.currentTimeMillis() + ".jpg"), localIntent);
              startActivityForResult(localIntent, (byte)2);
              return;
              localObject = this.mRuntime.a();
            }
            break;
          }
        }
      }
      if (this.mRuntime == null) {}
      for (localObject = localIntent; (localObject != null) && (!((Activity)localObject).isFinishing()); localObject = this.mRuntime.a())
      {
        bbmy.a((Context)localObject, 2131630858, 1).b(((BaseActivity)localObject).getTitleBarHeight());
        return;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HealthBusinessPlugin", 2, paramInt1 + "|" + paramInt2 + "|" + paramInt3);
    }
    Object localObject = NewFlowCameraActivity.class;
    if (awii.d(awii.c)) {
      localObject = MX3FlowCameraActivity.class;
    }
    localObject = new Intent(this.mRuntime.a(), (Class)localObject);
    ((Intent)localObject).putExtra("from_type", 1);
    ((Intent)localObject).putExtra("enable_front", true);
    ((Intent)localObject).putExtra("enable_local_video", true);
    ((Intent)localObject).putExtra("set_user_callback", "com.tencent.mobileqq.vashealth.VideoCallBack");
    ((Intent)localObject).putExtra("flow_camera_video_mode", true);
    ((Intent)localObject).putExtra("flow_camera_capture_mode", false);
    ((Intent)localObject).putExtra("ignore_dpc_duration", true);
    ((Intent)localObject).putExtra("video_duration", paramInt4);
    ((Intent)localObject).putExtra("short_video_refer", "From_HealthBusiness");
    ((Intent)localObject).putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
    ((Intent)localObject).putExtra("size_before_compress", paramInt1);
    ((Intent)localObject).putExtra("size_after_compress", paramInt3);
    ((Intent)localObject).putExtra("duration_max", paramInt2);
    ((Intent)localObject).putExtra("activity_start_time", SystemClock.elapsedRealtime());
    startActivityForResult((Intent)localObject, (byte)3);
  }
  
  void a(TextView paramTextView1, String paramString, TextView paramTextView2, TextView paramTextView3, SeekBar paramSeekBar)
  {
    if ((this.jdField_a_of_type_Qht == null) || (this.jdField_a_of_type_Qhw == null) || (paramTextView1 == null)) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
    paramTextView1 = new WeakReference(paramTextView1);
    Timer localTimer = new Timer();
    localTimer.schedule(new HealthBusinessPlugin.17(this, paramTextView1, paramString, paramTextView2, paramTextView3, paramSeekBar), 0L, 1000L);
    this.g.put(paramString, localTimer);
  }
  
  void a(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    paramTVK_IMediaPlayer.setOnVideoPreparedListener(new barj(this));
    paramTVK_IMediaPlayer.setOnCompletionListener(new bark(this));
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("source", "none");
      dispatchJsEvent("healthSport_uploadProgress", paramString, localJSONObject);
      if (QLog.isColorLevel()) {
        QLog.i("HealthBusinessPlugin", 2, "UploadProgress:" + paramString.toString());
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("HealthBusinessPlugin", 2, "UploadProgress Err");
    }
  }
  
  /* Error */
  void a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, Bundle paramBundle, HealthBusinessPlugin.UploadThread paramUploadThread)
  {
    // Byte code:
    //   0: invokestatic 682	java/lang/System:currentTimeMillis	()J
    //   3: lstore 15
    //   5: aload 6
    //   7: aload_3
    //   8: aload 4
    //   10: ldc_w 860
    //   13: aload_0
    //   14: getfield 862	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_e_of_type_Boolean	Z
    //   17: invokestatic 867	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Laynd;
    //   20: astore 6
    //   22: aload 6
    //   24: ifnull +1691 -> 1715
    //   27: aload_2
    //   28: invokestatic 872	bace:a	(Ljava/lang/String;)J
    //   31: lstore 11
    //   33: lload 11
    //   35: ldc2_w 873
    //   38: lcmp
    //   39: ifle +449 -> 488
    //   42: ldc2_w 873
    //   45: lstore 9
    //   47: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +47 -> 97
    //   53: ldc 213
    //   55: iconst_2
    //   56: new 401	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 876
    //   66: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 6
    //   71: getfield 880	aynd:h	Ljava/lang/String;
    //   74: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc_w 882
    //   80: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 6
    //   85: getfield 884	aynd:d	Ljava/lang/String;
    //   88: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: ldc_w 886
    //   100: aload 6
    //   102: getfield 880	aynd:h	Ljava/lang/String;
    //   105: invokevirtual 889	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifeq +387 -> 495
    //   111: aload 6
    //   113: getfield 891	aynd:f	Ljava/lang/String;
    //   116: astore_2
    //   117: iconst_1
    //   118: istore 8
    //   120: iload 8
    //   122: ifeq +1524 -> 1646
    //   125: aconst_null
    //   126: astore 6
    //   128: aconst_null
    //   129: astore 7
    //   131: new 893	java/net/URL
    //   134: dup
    //   135: aload_1
    //   136: invokespecial 894	java/net/URL:<init>	(Ljava/lang/String;)V
    //   139: invokevirtual 898	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   142: checkcast 900	java/net/HttpURLConnection
    //   145: astore_1
    //   146: aload_1
    //   147: sipush 5000
    //   150: invokevirtual 903	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   153: aload_1
    //   154: sipush 30000
    //   157: invokevirtual 906	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   160: aload_1
    //   161: iconst_1
    //   162: invokevirtual 909	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   165: aload_1
    //   166: iconst_1
    //   167: invokevirtual 912	java/net/HttpURLConnection:setDoInput	(Z)V
    //   170: aload_1
    //   171: iconst_0
    //   172: invokevirtual 915	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   175: aload_1
    //   176: ldc_w 917
    //   179: invokevirtual 920	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   182: aload_1
    //   183: ldc_w 922
    //   186: ldc_w 924
    //   189: invokevirtual 928	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_1
    //   193: ldc_w 930
    //   196: new 401	java/lang/StringBuilder
    //   199: dup
    //   200: ldc_w 932
    //   203: invokespecial 933	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   206: ldc_w 935
    //   209: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: getstatic 940	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   215: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 935
    //   221: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: getstatic 945	android/os/Build:DEVICE	Ljava/lang/String;
    //   227: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc_w 935
    //   233: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: getstatic 948	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   239: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc_w 935
    //   245: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc_w 950
    //   251: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokevirtual 928	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload_1
    //   261: ldc_w 952
    //   264: ldc_w 954
    //   267: invokevirtual 928	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_1
    //   271: ldc_w 956
    //   274: new 401	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 958
    //   284: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_3
    //   288: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc_w 960
    //   294: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 4
    //   299: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokevirtual 928	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: new 962	java/io/DataOutputStream
    //   311: dup
    //   312: aload_1
    //   313: invokevirtual 966	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   316: invokespecial 969	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   319: astore_3
    //   320: new 971	java/lang/StringBuffer
    //   323: dup
    //   324: invokespecial 972	java/lang/StringBuffer:<init>	()V
    //   327: astore 4
    //   329: aload 4
    //   331: ldc_w 974
    //   334: invokevirtual 977	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   337: pop
    //   338: aload 4
    //   340: aload_2
    //   341: invokevirtual 977	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   344: pop
    //   345: aload 4
    //   347: ldc_w 979
    //   350: invokevirtual 977	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   353: pop
    //   354: aload 4
    //   356: aload 5
    //   358: ldc_w 981
    //   361: invokeinterface 982 2 0
    //   366: checkcast 498	java/lang/String
    //   369: invokevirtual 977	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   372: pop
    //   373: aload_3
    //   374: aload 4
    //   376: invokevirtual 983	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   379: invokevirtual 987	java/lang/String:getBytes	()[B
    //   382: invokevirtual 993	java/io/OutputStream:write	([B)V
    //   385: aload_3
    //   386: invokevirtual 996	java/io/OutputStream:flush	()V
    //   389: aload_3
    //   390: invokevirtual 999	java/io/OutputStream:close	()V
    //   393: new 971	java/lang/StringBuffer
    //   396: dup
    //   397: invokespecial 972	java/lang/StringBuffer:<init>	()V
    //   400: astore 4
    //   402: new 1001	java/io/BufferedReader
    //   405: dup
    //   406: new 1003	java/io/InputStreamReader
    //   409: dup
    //   410: aload_1
    //   411: invokevirtual 1007	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   414: invokespecial 1010	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   417: invokespecial 1013	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   420: astore_3
    //   421: aload_3
    //   422: invokevirtual 1016	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   425: astore 6
    //   427: aload 6
    //   429: ifnull +1124 -> 1553
    //   432: aload 4
    //   434: aload 6
    //   436: invokevirtual 977	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   439: ldc_w 1018
    //   442: invokevirtual 977	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   445: pop
    //   446: goto -25 -> 421
    //   449: astore_2
    //   450: aload_1
    //   451: astore 6
    //   453: ldc 213
    //   455: iconst_2
    //   456: new 401	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 1020
    //   466: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload_2
    //   470: invokevirtual 1023	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: aload_1
    //   480: ifnull +7 -> 487
    //   483: aload_1
    //   484: invokevirtual 1026	java/net/HttpURLConnection:disconnect	()V
    //   487: return
    //   488: lload 11
    //   490: lstore 9
    //   492: goto -445 -> 47
    //   495: aload 6
    //   497: getfield 891	aynd:f	Ljava/lang/String;
    //   500: ifnull +1215 -> 1715
    //   503: aload 6
    //   505: getfield 1027	aynd:c	Ljava/lang/String;
    //   508: invokestatic 1032	bach:a	(Ljava/lang/String;)[B
    //   511: astore 18
    //   513: aload_2
    //   514: invokestatic 1035	apck:a	(Ljava/lang/String;)[B
    //   517: astore 19
    //   519: new 401	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   526: ldc_w 1037
    //   529: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload 6
    //   534: getfield 1038	aynd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   537: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: ldc_w 1040
    //   543: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload 6
    //   548: getfield 1041	aynd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   551: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: ldc_w 1043
    //   557: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: astore 20
    //   565: aload_0
    //   566: getfield 862	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_e_of_type_Boolean	Z
    //   569: ifeq +15 -> 584
    //   572: aload 20
    //   574: ldc_w 1045
    //   577: ldc_w 1047
    //   580: invokevirtual 1051	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   583: pop
    //   584: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +44 -> 631
    //   590: ldc 213
    //   592: iconst_2
    //   593: new 401	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 1053
    //   603: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload 20
    //   608: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: ldc_w 1055
    //   614: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload 6
    //   619: getfield 891	aynd:f	Ljava/lang/String;
    //   622: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   631: new 1057	java/io/RandomAccessFile
    //   634: dup
    //   635: aload_2
    //   636: ldc_w 1059
    //   639: invokespecial 1061	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   642: astore 17
    //   644: lconst_0
    //   645: lstore 13
    //   647: lload 9
    //   649: lload 13
    //   651: lsub
    //   652: l2i
    //   653: istore 8
    //   655: aload 17
    //   657: astore_2
    //   658: invokestatic 641	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   661: invokestatic 1065	mpl:a	(Landroid/content/Context;)Z
    //   664: ifeq +1086 -> 1750
    //   667: aload 17
    //   669: astore_2
    //   670: aload 18
    //   672: aload 19
    //   674: aload 20
    //   676: lload 11
    //   678: aload 17
    //   680: lload 13
    //   682: iload 8
    //   684: invokestatic 1070	aync:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   687: lstore 13
    //   689: aload 17
    //   691: astore_2
    //   692: aload 7
    //   694: getfield 1073	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_Boolean	Z
    //   697: iconst_1
    //   698: if_icmpne +198 -> 896
    //   701: aload 17
    //   703: astore_2
    //   704: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   707: ifeq +15 -> 722
    //   710: aload 17
    //   712: astore_2
    //   713: ldc 213
    //   715: iconst_2
    //   716: ldc_w 1075
    //   719: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: aload 17
    //   724: astore_2
    //   725: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   728: aload 7
    //   730: getfield 1076	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   733: invokeinterface 1081 2 0
    //   738: ifeq +20 -> 758
    //   741: aload 17
    //   743: astore_2
    //   744: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   747: aload 7
    //   749: getfield 1076	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   752: invokeinterface 1084 2 0
    //   757: pop
    //   758: aload 17
    //   760: astore_2
    //   761: getstatic 61	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   764: aload 7
    //   766: getfield 1076	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   769: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   772: ifnull +18 -> 790
    //   775: aload 17
    //   777: astore_2
    //   778: getstatic 61	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   781: aload 7
    //   783: getfield 1076	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   786: invokevirtual 1086	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   789: pop
    //   790: aload 17
    //   792: astore_2
    //   793: getstatic 59	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   796: aload 7
    //   798: getfield 1076	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   801: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   804: ifnull +18 -> 822
    //   807: aload 17
    //   809: astore_2
    //   810: getstatic 59	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   813: aload 7
    //   815: getfield 1076	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   818: invokevirtual 1086	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   821: pop
    //   822: aload 17
    //   824: astore_2
    //   825: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   828: ifeq +39 -> 867
    //   831: aload 17
    //   833: astore_2
    //   834: ldc 213
    //   836: iconst_2
    //   837: new 401	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   844: ldc_w 1088
    //   847: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   853: invokeinterface 1089 1 0
    //   858: invokevirtual 562	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   861: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   867: aload 17
    //   869: ifnull -382 -> 487
    //   872: aload 17
    //   874: invokevirtual 1090	java/io/RandomAccessFile:close	()V
    //   877: return
    //   878: astore_1
    //   879: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq -395 -> 487
    //   885: ldc 213
    //   887: iconst_2
    //   888: aload_1
    //   889: invokestatic 1094	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   892: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   895: return
    //   896: aload 17
    //   898: astore_2
    //   899: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   902: ifeq +76 -> 978
    //   905: aload 17
    //   907: astore_2
    //   908: ldc 213
    //   910: iconst_2
    //   911: new 401	java/lang/StringBuilder
    //   914: dup
    //   915: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   918: ldc_w 1096
    //   921: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: lload 13
    //   926: l2d
    //   927: lload 11
    //   929: l2d
    //   930: ddiv
    //   931: invokevirtual 1099	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   934: ldc_w 1101
    //   937: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   943: invokeinterface 1089 1 0
    //   948: invokevirtual 562	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   951: ldc_w 1103
    //   954: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   960: iconst_0
    //   961: invokeinterface 1106 2 0
    //   966: checkcast 498	java/lang/String
    //   969: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   978: aload 17
    //   980: astore_2
    //   981: getstatic 61	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   984: aload 7
    //   986: getfield 1076	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   989: lload 13
    //   991: l2d
    //   992: lload 11
    //   994: l2d
    //   995: ddiv
    //   996: invokestatic 1111	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   999: invokevirtual 477	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1002: pop
    //   1003: lload 13
    //   1005: ldc2_w 1112
    //   1008: lcmp
    //   1009: ifne +74 -> 1083
    //   1012: iconst_1
    //   1013: istore 8
    //   1015: iload 8
    //   1017: ifne +403 -> 1420
    //   1020: aload 17
    //   1022: astore_2
    //   1023: ldc 213
    //   1025: iconst_1
    //   1026: new 401	java/lang/StringBuilder
    //   1029: dup
    //   1030: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   1033: ldc_w 1115
    //   1036: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: invokestatic 682	java/lang/System:currentTimeMillis	()J
    //   1042: lload 15
    //   1044: lsub
    //   1045: invokevirtual 685	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1048: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 718	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1054: iconst_1
    //   1055: istore 8
    //   1057: aload 17
    //   1059: astore_2
    //   1060: aload 6
    //   1062: getfield 891	aynd:f	Ljava/lang/String;
    //   1065: astore 6
    //   1067: aload 17
    //   1069: ifnull +637 -> 1706
    //   1072: aload 17
    //   1074: invokevirtual 1090	java/io/RandomAccessFile:close	()V
    //   1077: aload 6
    //   1079: astore_2
    //   1080: goto -960 -> 120
    //   1083: aload 17
    //   1085: astore_2
    //   1086: new 154	org/json/JSONObject
    //   1089: dup
    //   1090: invokespecial 837	org/json/JSONObject:<init>	()V
    //   1093: astore 21
    //   1095: aload 17
    //   1097: astore_2
    //   1098: new 1117	org/json/JSONArray
    //   1101: dup
    //   1102: invokespecial 1118	org/json/JSONArray:<init>	()V
    //   1105: astore 22
    //   1107: iconst_0
    //   1108: istore 8
    //   1110: aload 17
    //   1112: astore_2
    //   1113: iload 8
    //   1115: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1118: invokeinterface 1089 1 0
    //   1123: if_icmpge +239 -> 1362
    //   1126: aload 17
    //   1128: astore_2
    //   1129: new 154	org/json/JSONObject
    //   1132: dup
    //   1133: invokespecial 837	org/json/JSONObject:<init>	()V
    //   1136: astore 23
    //   1138: aload 17
    //   1140: astore_2
    //   1141: aload 23
    //   1143: ldc_w 1120
    //   1146: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1149: iload 8
    //   1151: invokeinterface 1106 2 0
    //   1156: invokevirtual 844	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1159: pop
    //   1160: aload 17
    //   1162: astore_2
    //   1163: getstatic 61	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1166: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1169: iload 8
    //   1171: invokeinterface 1106 2 0
    //   1176: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1179: ifnull +99 -> 1278
    //   1182: aload 17
    //   1184: astore_2
    //   1185: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1188: ifeq +42 -> 1230
    //   1191: aload 17
    //   1193: astore_2
    //   1194: ldc 213
    //   1196: iconst_2
    //   1197: new 401	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   1204: ldc_w 1122
    //   1207: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: getstatic 61	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1213: aload 7
    //   1215: getfield 1076	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1218: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1221: invokevirtual 1023	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1224: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1227: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1230: aload 17
    //   1232: astore_2
    //   1233: aload 23
    //   1235: ldc_w 1124
    //   1238: getstatic 61	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1241: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1244: iload 8
    //   1246: invokeinterface 1106 2 0
    //   1251: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1254: invokevirtual 844	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1257: pop
    //   1258: aload 17
    //   1260: astore_2
    //   1261: aload 22
    //   1263: aload 23
    //   1265: invokevirtual 1127	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1268: pop
    //   1269: iload 8
    //   1271: iconst_1
    //   1272: iadd
    //   1273: istore 8
    //   1275: goto -165 -> 1110
    //   1278: aload 17
    //   1280: astore_2
    //   1281: aload 23
    //   1283: ldc_w 1124
    //   1286: iconst_0
    //   1287: invokevirtual 1130	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1290: pop
    //   1291: goto -33 -> 1258
    //   1294: astore 7
    //   1296: aload 17
    //   1298: astore 6
    //   1300: aload 6
    //   1302: astore_2
    //   1303: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1306: ifeq +36 -> 1342
    //   1309: aload 6
    //   1311: astore_2
    //   1312: ldc 213
    //   1314: iconst_2
    //   1315: new 401	java/lang/StringBuilder
    //   1318: dup
    //   1319: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   1322: ldc_w 1132
    //   1325: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: aload 7
    //   1330: invokestatic 1094	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1333: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1339: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1342: aload 6
    //   1344: ifnull +352 -> 1696
    //   1347: aload 6
    //   1349: invokevirtual 1090	java/io/RandomAccessFile:close	()V
    //   1352: ldc_w 352
    //   1355: astore_2
    //   1356: iconst_0
    //   1357: istore 8
    //   1359: goto -1239 -> 120
    //   1362: aload 17
    //   1364: astore_2
    //   1365: aload 21
    //   1367: ldc_w 1134
    //   1370: iconst_0
    //   1371: invokevirtual 1130	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1374: pop
    //   1375: aload 17
    //   1377: astore_2
    //   1378: aload 21
    //   1380: ldc_w 1136
    //   1383: aload 22
    //   1385: invokevirtual 844	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1388: pop
    //   1389: aload 17
    //   1391: astore_2
    //   1392: aload_0
    //   1393: aload 21
    //   1395: invokevirtual 853	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1398: invokevirtual 1138	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/lang/String;)V
    //   1401: ldc2_w 873
    //   1404: lload 13
    //   1406: ladd
    //   1407: lload 11
    //   1409: lcmp
    //   1410: ifle +329 -> 1739
    //   1413: lload 11
    //   1415: lstore 9
    //   1417: goto +308 -> 1725
    //   1420: aload 17
    //   1422: astore_2
    //   1423: ldc 213
    //   1425: iconst_1
    //   1426: new 401	java/lang/StringBuilder
    //   1429: dup
    //   1430: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   1433: ldc_w 1140
    //   1436: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: aload 20
    //   1441: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: ldc_w 1142
    //   1447: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: aload 6
    //   1452: getfield 891	aynd:f	Ljava/lang/String;
    //   1455: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1461: invokestatic 668	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1464: iconst_0
    //   1465: istore 8
    //   1467: goto -410 -> 1057
    //   1470: astore_2
    //   1471: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1474: ifeq +13 -> 1487
    //   1477: ldc 213
    //   1479: iconst_2
    //   1480: aload_2
    //   1481: invokestatic 1094	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1484: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1487: aload 6
    //   1489: astore_2
    //   1490: goto -1370 -> 120
    //   1493: astore_2
    //   1494: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1497: ifeq +13 -> 1510
    //   1500: ldc 213
    //   1502: iconst_2
    //   1503: aload_2
    //   1504: invokestatic 1094	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1507: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1510: ldc_w 352
    //   1513: astore_2
    //   1514: iconst_0
    //   1515: istore 8
    //   1517: goto -1397 -> 120
    //   1520: astore_1
    //   1521: aconst_null
    //   1522: astore_2
    //   1523: aload_2
    //   1524: ifnull +7 -> 1531
    //   1527: aload_2
    //   1528: invokevirtual 1090	java/io/RandomAccessFile:close	()V
    //   1531: aload_1
    //   1532: athrow
    //   1533: astore_2
    //   1534: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1537: ifeq -6 -> 1531
    //   1540: ldc 213
    //   1542: iconst_2
    //   1543: aload_2
    //   1544: invokestatic 1094	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1547: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1550: goto -19 -> 1531
    //   1553: aload 4
    //   1555: invokevirtual 983	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1558: astore 4
    //   1560: ldc 213
    //   1562: iconst_1
    //   1563: new 401	java/lang/StringBuilder
    //   1566: dup
    //   1567: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   1570: ldc_w 1144
    //   1573: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1576: aload_2
    //   1577: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: ldc_w 1146
    //   1583: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1586: aload 5
    //   1588: ldc_w 981
    //   1591: invokeinterface 982 2 0
    //   1596: checkcast 498	java/lang/String
    //   1599: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: ldc_w 1148
    //   1605: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: aload 4
    //   1610: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1616: invokestatic 718	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1619: aload_3
    //   1620: invokevirtual 1149	java/io/BufferedReader:close	()V
    //   1623: aload_1
    //   1624: ifnull -1137 -> 487
    //   1627: aload_1
    //   1628: invokevirtual 1026	java/net/HttpURLConnection:disconnect	()V
    //   1631: return
    //   1632: astore_2
    //   1633: aload 6
    //   1635: astore_1
    //   1636: aload_1
    //   1637: ifnull +7 -> 1644
    //   1640: aload_1
    //   1641: invokevirtual 1026	java/net/HttpURLConnection:disconnect	()V
    //   1644: aload_2
    //   1645: athrow
    //   1646: ldc 213
    //   1648: iconst_1
    //   1649: new 401	java/lang/StringBuilder
    //   1652: dup
    //   1653: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   1656: ldc_w 1151
    //   1659: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1662: aload_2
    //   1663: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1669: invokestatic 668	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1672: return
    //   1673: astore_2
    //   1674: goto -38 -> 1636
    //   1677: astore_2
    //   1678: aload 7
    //   1680: astore_1
    //   1681: goto -1231 -> 450
    //   1684: astore_1
    //   1685: goto -162 -> 1523
    //   1688: astore 7
    //   1690: aconst_null
    //   1691: astore 6
    //   1693: goto -393 -> 1300
    //   1696: ldc_w 352
    //   1699: astore_2
    //   1700: iconst_0
    //   1701: istore 8
    //   1703: goto -1583 -> 120
    //   1706: aload 6
    //   1708: astore_2
    //   1709: goto -1589 -> 120
    //   1712: goto -1065 -> 647
    //   1715: ldc_w 352
    //   1718: astore_2
    //   1719: iconst_0
    //   1720: istore 8
    //   1722: goto -1602 -> 120
    //   1725: lload 13
    //   1727: lload 11
    //   1729: lcmp
    //   1730: iflt -18 -> 1712
    //   1733: iconst_0
    //   1734: istore 8
    //   1736: goto -721 -> 1015
    //   1739: ldc2_w 873
    //   1742: lload 13
    //   1744: ladd
    //   1745: lstore 9
    //   1747: goto -22 -> 1725
    //   1750: iconst_1
    //   1751: istore 8
    //   1753: goto -738 -> 1015
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1756	0	this	HealthBusinessPlugin
    //   0	1756	1	paramString1	String
    //   0	1756	2	paramString2	String
    //   0	1756	3	paramString3	String
    //   0	1756	4	paramString4	String
    //   0	1756	5	paramMap	Map<String, String>
    //   0	1756	6	paramBundle	Bundle
    //   0	1756	7	paramUploadThread	HealthBusinessPlugin.UploadThread
    //   118	1634	8	m	int
    //   45	1701	9	l1	long
    //   31	1697	11	l2	long
    //   645	1098	13	l3	long
    //   3	1040	15	l4	long
    //   642	779	17	localRandomAccessFile	java.io.RandomAccessFile
    //   511	160	18	arrayOfByte1	byte[]
    //   517	156	19	arrayOfByte2	byte[]
    //   563	877	20	str	String
    //   1093	301	21	localJSONObject1	JSONObject
    //   1105	279	22	localJSONArray	JSONArray
    //   1136	146	23	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   146	421	449	java/lang/Exception
    //   421	427	449	java/lang/Exception
    //   432	446	449	java/lang/Exception
    //   1553	1623	449	java/lang/Exception
    //   872	877	878	java/io/IOException
    //   658	667	1294	java/lang/Exception
    //   670	689	1294	java/lang/Exception
    //   692	701	1294	java/lang/Exception
    //   704	710	1294	java/lang/Exception
    //   713	722	1294	java/lang/Exception
    //   725	741	1294	java/lang/Exception
    //   744	758	1294	java/lang/Exception
    //   761	775	1294	java/lang/Exception
    //   778	790	1294	java/lang/Exception
    //   793	807	1294	java/lang/Exception
    //   810	822	1294	java/lang/Exception
    //   825	831	1294	java/lang/Exception
    //   834	867	1294	java/lang/Exception
    //   899	905	1294	java/lang/Exception
    //   908	978	1294	java/lang/Exception
    //   981	1003	1294	java/lang/Exception
    //   1023	1054	1294	java/lang/Exception
    //   1060	1067	1294	java/lang/Exception
    //   1086	1095	1294	java/lang/Exception
    //   1098	1107	1294	java/lang/Exception
    //   1113	1126	1294	java/lang/Exception
    //   1129	1138	1294	java/lang/Exception
    //   1141	1160	1294	java/lang/Exception
    //   1163	1182	1294	java/lang/Exception
    //   1185	1191	1294	java/lang/Exception
    //   1194	1230	1294	java/lang/Exception
    //   1233	1258	1294	java/lang/Exception
    //   1261	1269	1294	java/lang/Exception
    //   1281	1291	1294	java/lang/Exception
    //   1365	1375	1294	java/lang/Exception
    //   1378	1389	1294	java/lang/Exception
    //   1392	1401	1294	java/lang/Exception
    //   1423	1464	1294	java/lang/Exception
    //   1072	1077	1470	java/io/IOException
    //   1347	1352	1493	java/io/IOException
    //   631	644	1520	finally
    //   1527	1531	1533	java/io/IOException
    //   131	146	1632	finally
    //   453	479	1632	finally
    //   146	421	1673	finally
    //   421	427	1673	finally
    //   432	446	1673	finally
    //   1553	1623	1673	finally
    //   131	146	1677	java/lang/Exception
    //   658	667	1684	finally
    //   670	689	1684	finally
    //   692	701	1684	finally
    //   704	710	1684	finally
    //   713	722	1684	finally
    //   725	741	1684	finally
    //   744	758	1684	finally
    //   761	775	1684	finally
    //   778	790	1684	finally
    //   793	807	1684	finally
    //   810	822	1684	finally
    //   825	831	1684	finally
    //   834	867	1684	finally
    //   899	905	1684	finally
    //   908	978	1684	finally
    //   981	1003	1684	finally
    //   1023	1054	1684	finally
    //   1060	1067	1684	finally
    //   1086	1095	1684	finally
    //   1098	1107	1684	finally
    //   1113	1126	1684	finally
    //   1129	1138	1684	finally
    //   1141	1160	1684	finally
    //   1163	1182	1684	finally
    //   1185	1191	1684	finally
    //   1194	1230	1684	finally
    //   1233	1258	1684	finally
    //   1261	1269	1684	finally
    //   1281	1291	1684	finally
    //   1303	1309	1684	finally
    //   1312	1342	1684	finally
    //   1365	1375	1684	finally
    //   1378	1389	1684	finally
    //   1392	1401	1684	finally
    //   1423	1464	1684	finally
    //   631	644	1688	java/lang/Exception
  }
  
  void a(List<String> paramList)
  {
    SharedPreferences localSharedPreferences = a();
    Object localObject = localSharedPreferences.getString(this.jdField_a_of_type_JavaLangString, null);
    if (localObject == null) {}
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        localJSONArray = new JSONArray();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str))
        {
          localJSONArray.put(str);
          continue;
          localObject = new JSONObject((String)localObject);
        }
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HealthBusinessPlugin", 2, paramList, new Object[0]);
        }
        return;
      }
    }
    ((JSONObject)localObject).put("imgList", localJSONArray);
    localSharedPreferences.edit().putString(this.jdField_a_of_type_JavaLangString, ((JSONObject)localObject).toString()).commit();
  }
  
  int b(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "Video pluck...");
    }
    this.jdField_e_of_type_Int = 0;
    Object localObject = null;
    try
    {
      paramJSONObject = paramJSONObject.optString("vid");
      if (paramJSONObject == null) {
        return -1;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.d("HealthBusinessPlugin", 1, "pluckVideo Err:" + paramJSONObject.toString());
        paramJSONObject = (JSONObject)localObject;
      }
      if (this.d != null)
      {
        if ("".equals(paramJSONObject))
        {
          paramJSONObject = this.d.keySet().iterator();
          while (paramJSONObject.hasNext())
          {
            localObject = (String)paramJSONObject.next();
            if (((TVK_IMediaPlayer)this.d.get(localObject)).getPlayedTime() >= 3L) {
              this.h.put(localObject, Long.valueOf(((TVK_IMediaPlayer)this.d.get(localObject)).getPlayedTime()));
            }
            QLog.d("HealthBusinessPlugin", 1, "time to upload:" + ((TVK_IMediaPlayer)this.d.get(localObject)).getPlayedTime());
            awqx.b(null, "dc00899", "yundong", "", "yundong_shipin", "", 0, 0, String.valueOf((int)(((TVK_IMediaPlayer)this.d.get(localObject)).getPlayedTime() / 1000L)), "", (String)localObject, "");
            this.h.remove(localObject);
            ((Timer)this.g.get(localObject)).cancel();
            FrameLayout localFrameLayout = (FrameLayout)this.jdField_e_of_type_JavaUtilHashMap.get(localObject);
            ((ViewGroup)localFrameLayout.getParent()).removeView(localFrameLayout);
            this.jdField_e_of_type_JavaUtilHashMap.remove(localObject);
            this.jdField_f_of_type_JavaUtilHashMap.remove(localObject);
            this.g.remove(localObject);
            this.h.remove(localObject);
          }
          this.d.clear();
          return 0;
        }
        if (!this.d.containsKey(paramJSONObject)) {
          return -3;
        }
        if (((TVK_IMediaPlayer)this.d.get(paramJSONObject)).getPlayedTime() >= 3L) {
          this.h.put(paramJSONObject, Long.valueOf(((TVK_IMediaPlayer)this.d.get(paramJSONObject)).getPlayedTime()));
        }
        QLog.d("HealthBusinessPlugin", 1, "time to upload:" + String.valueOf((int)(((TVK_IMediaPlayer)this.d.get(paramJSONObject)).getPlayedTime() / 1000L)));
        awqx.b(null, "dc00899", "yundong", "", "yundong_shipin", "", 0, 0, String.valueOf((int)(((TVK_IMediaPlayer)this.d.get(paramJSONObject)).getPlayedTime() / 1000L)), "", paramJSONObject, "");
        this.h.remove(paramJSONObject);
        ((Timer)this.g.get(paramJSONObject)).cancel();
        localObject = (FrameLayout)this.jdField_e_of_type_JavaUtilHashMap.get(paramJSONObject);
        ((ViewGroup)((FrameLayout)localObject).getParent()).removeView((View)localObject);
        this.d.remove(paramJSONObject);
        this.jdField_e_of_type_JavaUtilHashMap.remove(paramJSONObject);
        this.jdField_f_of_type_JavaUtilHashMap.remove(paramJSONObject);
        this.g.remove(paramJSONObject);
        this.h.remove(paramJSONObject);
        return 0;
      }
      if (this.jdField_c_of_type_AndroidOsHandler != null)
      {
        this.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_c_of_type_AndroidOsHandler = null;
      }
    }
    return -6;
  }
  
  int c(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_Boolean = false;
    try
    {
      paramJSONObject = paramJSONObject.getString("vid");
      if (paramJSONObject == null) {
        return -1;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.d("HealthBusinessPlugin", 1, "playVideo Err:" + paramJSONObject.toString());
        paramJSONObject = null;
      }
      if (!this.d.containsKey(paramJSONObject)) {
        return -3;
      }
      Iterator localIterator = this.d.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ImageView localImageView = (ImageView)((FrameLayout)this.jdField_e_of_type_JavaUtilHashMap.get(str)).findViewById(2131307409);
        if (str.equals(paramJSONObject)) {
          ((TVK_IMediaPlayer)this.d.get(paramJSONObject)).start();
        }
        for (;;)
        {
          localImageView.setVisibility(4);
          break;
          ((TVK_IMediaPlayer)this.d.get(paramJSONObject)).pause();
        }
      }
    }
    return 0;
  }
  
  int d(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_Boolean = true;
    ImageView localImageView = null;
    try
    {
      paramJSONObject = paramJSONObject.getString("vid");
      if (paramJSONObject == null) {
        return -1;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.d("HealthBusinessPlugin", 1, "pauseVideo Err:" + paramJSONObject.toString());
        paramJSONObject = localImageView;
      }
      if (!this.d.containsKey(paramJSONObject)) {
        return -3;
      }
      localImageView = (ImageView)((FrameLayout)this.jdField_e_of_type_JavaUtilHashMap.get(paramJSONObject)).findViewById(2131307409);
      localImageView.setImageResource(2130847991);
      localImageView.setVisibility(0);
      ((TVK_IMediaPlayer)this.d.get(paramJSONObject)).pause();
      this.jdField_a_of_type_Boolean = true;
    }
    return 0;
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if ((!this.mRuntime.a().getUrl().contains("qq.com")) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return null;
      if ((paramLong == 8L) && (paramString.startsWith("http://qqsport/")) && (paramString.length() > 16))
      {
        paramString = paramString.substring(15);
        try
        {
          paramString = new File(URLDecoder.decode(paramString, "utf-8"));
          if ((paramString.exists()) || (paramString.isFile()))
          {
            paramString = new WebResourceResponse("image/*", "utf-8", new FileInputStream(paramString));
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject1;
    int m;
    int n;
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      paramString2 = paramJsBridgeListener.optString("callback");
      localObject1 = paramJsBridgeListener.optString("groupID");
      if ("openPhoto".equals(paramString3))
      {
        if (TextUtils.isEmpty(paramString2)) {
          return true;
        }
        int i1 = paramJsBridgeListener.optInt("maxSelect");
        int i2 = paramJsBridgeListener.optInt("min_width", 200);
        int i3 = paramJsBridgeListener.optInt("min_height", 200);
        int i4 = paramJsBridgeListener.optInt("max_gif_size", 8388608);
        if (!paramJsBridgeListener.has("opType")) {
          break label3095;
        }
        m = paramJsBridgeListener.getInt("opType");
        paramJsBridgeListener = new ArrayList();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis() / 1000L);
        }
        for (;;)
        {
          this.jdField_b_of_type_JavaLangString = paramString2;
          n = i1;
          if (i1 == 0) {
            n = 6;
          }
          paramString2 = this.mRuntime.a();
          if (paramString2 != null) {
            break;
          }
          return true;
          this.jdField_a_of_type_JavaLangString = ((String)localObject1);
          paramString1 = a().getString((String)localObject1, null);
          if (!TextUtils.isEmpty(paramString1))
          {
            paramString1 = new JSONObject(paramString1).getJSONArray("imgList");
            paramJsBridgeListener.clear();
            n = 0;
            while (n < paramString1.length())
            {
              paramJsBridgeListener.add(paramString1.getString(n));
              n += 1;
            }
          }
        }
        if (m == 0)
        {
          paramString3 = new Intent();
          paramString3.setClass(paramString2, PhotoListActivity.class);
          paramString3.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramJsBridgeListener);
          paramString3.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString2.getClass().getName());
          paramString3.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          paramString3.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
          paramString3.putExtra("PhotoConst.MAXUM_SELECTED_NUM", n);
          paramString3.getExtras().remove("forward_type");
          paramString3.putExtra("album_enter_directly", true);
          paramString3.putExtra("ALBUM_ID", baaf.jdField_b_of_type_JavaLangString);
          paramString3.putExtra("ALBUM_NAME", baaf.c);
          paramString1 = this.mRuntime.a().getAccount();
          paramJsBridgeListener = paramString1;
          if (paramString1 == null) {
            paramJsBridgeListener = "";
          }
          paramString3.putExtra("PhotoConst.MY_UIN", paramJsBridgeListener);
          paramString3.putExtra("from_health", true);
          paramString3.putExtra("min_height", i3);
          paramString3.putExtra("min_width", i2);
          paramString3.putExtra("max_gif_size", i4);
          startActivityForResult(paramString3, (byte)1);
          baaf.a(paramString2, false, true);
        }
        else if (m == 1)
        {
          a();
        }
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      QLog.e("HealthBusinessPlugin", 1, "[handleJsRequest] error=", paramJsBridgeListener);
    }
    if ("getPicture".equals(paramString3))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return true;
      }
      paramString1 = this.mRuntime.a().getAccount();
      paramJsBridgeListener = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramJsBridgeListener = "nologin";
      }
      paramJsBridgeListener = this.mRuntime.a().getApplication().getSharedPreferences(paramJsBridgeListener + "_health", 0).getString((String)localObject1, null);
      if (TextUtils.isEmpty(paramJsBridgeListener))
      {
        paramJsBridgeListener = new JSONObject();
        paramJsBridgeListener.put("msg", "group id not found!");
        super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      }
      else
      {
        if (this.jdField_a_of_type_Bbms == null)
        {
          paramString1 = this.mRuntime.a();
          this.jdField_a_of_type_Bbms = new bbms(paramString1, paramString1.getResources().getDimensionPixelSize(2131167766));
          this.jdField_a_of_type_Bbms.c(2131628457);
        }
        if (!this.jdField_a_of_type_Bbms.isShowing()) {
          this.jdField_a_of_type_Bbms.show();
        }
        ThreadManager.post(new HealthBusinessPlugin.3(this, paramJsBridgeListener, paramString2), 5, null, true);
      }
    }
    else
    {
      Object localObject2;
      if ("deletePicture".equals(paramString3))
      {
        paramString1 = a();
        if (TextUtils.isEmpty(paramString2)) {
          return true;
        }
        paramJsBridgeListener = paramJsBridgeListener.optString("path");
        if ((TextUtils.isEmpty(paramJsBridgeListener)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label3103;
        }
        paramVarArgs = paramString1.getString((String)localObject1, null);
        paramString3 = new JSONArray();
        if (!TextUtils.isEmpty(paramVarArgs))
        {
          paramVarArgs = new JSONObject(paramVarArgs);
          localObject2 = paramVarArgs.getJSONArray("imgList");
          m = 0;
          label815:
          if (m < ((JSONArray)localObject2).length())
          {
            if (paramJsBridgeListener.equals(((JSONArray)localObject2).getString(m))) {
              break label3105;
            }
            paramString3.put(((JSONArray)localObject2).getString(m));
            break label3105;
          }
          paramVarArgs.put("imgList", paramString3);
          paramString1.edit().putString((String)localObject1, paramVarArgs.toString()).commit();
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("msg", "success.");
          super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
        }
      }
      else if ("uploadGroup".equals(paramString3))
      {
        if (TextUtils.isEmpty(paramString2)) {
          return true;
        }
        paramString1 = paramJsBridgeListener.optString("feedID");
        paramString3 = paramJsBridgeListener.optString("tag", ajjy.a(2131639655));
        paramVarArgs = paramJsBridgeListener.optString("cat", ajjy.a(2131639656));
        this.jdField_e_of_type_Boolean = paramJsBridgeListener.optBoolean("need_https", false);
        paramJsBridgeListener = this.mRuntime.a().getApplication().getSharedPreferences("groupid_feedid", 0).edit();
        paramJsBridgeListener.putString((String)localObject1, paramString1);
        paramJsBridgeListener.commit();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramString1))) {
          break label3114;
        }
        if (jdField_a_of_type_JavaUtilList.contains(localObject1))
        {
          if (!QLog.isColorLevel()) {
            break label3116;
          }
          QLog.i("HealthBusinessPlugin", 2, "group enqueued.");
          break label3116;
        }
        jdField_a_of_type_JavaUtilList.add(localObject1);
        localObject2 = a().getString((String)localObject1, null);
        paramJsBridgeListener = new ArrayList();
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("msg", "group id not found.");
          super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
          return true;
        }
        paramString2 = new JSONObject((String)localObject2);
        bool = paramString2.has("imgList");
        if (bool)
        {
          paramString2 = paramString2.getJSONArray("imgList");
          m = 0;
          label1203:
          if (m < paramString2.length())
          {
            localObject2 = paramString2.getString(m);
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).startsWith("http")) || (((String)localObject2).equals("error"))) {
              break label3118;
            }
            paramJsBridgeListener.add(paramString2.getString(m));
            break label3118;
          }
        }
        else
        {
          paramJsBridgeListener.add(paramString2.getString("video_dir"));
        }
        if ((this.mRuntime.a() instanceof BaseActivity))
        {
          paramJsBridgeListener = new HealthBusinessPlugin.UploadThread(this, (BaseActivity)this.mRuntime.a(), paramJsBridgeListener, paramString1, (String)localObject1, bool, paramString3, paramVarArgs);
          jdField_b_of_type_JavaUtilHashMap.put(localObject1, paramJsBridgeListener);
          ThreadManager.post(paramJsBridgeListener, 5, null, false);
        }
      }
      else if ("deleteGroup".equals(paramString3))
      {
        if (TextUtils.isEmpty(paramString2)) {
          return true;
        }
        paramJsBridgeListener = a();
        paramString1 = paramJsBridgeListener.getString((String)localObject1, null);
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("video_dir")))
        {
          paramString1 = new File(new JSONObject(paramString1).getString("thumb_dir"));
          if ((paramString1.exists()) && (paramString1.isFile())) {
            paramString1.delete();
          }
        }
        paramString1 = new JSONObject();
        bool = paramJsBridgeListener.edit().remove((String)localObject1).commit();
        paramJsBridgeListener = this.mRuntime.a().getApplication().getSharedPreferences("groupid_feedid", 0);
        if (paramJsBridgeListener == null) {
          break label3150;
        }
        m = 1;
        break label3127;
        label1494:
        if ((n & m) == 0) {
          break label3138;
        }
        paramJsBridgeListener.edit().remove((String)localObject1).commit();
        break label3138;
        label1524:
        paramString1.put("msg", paramJsBridgeListener);
        super.callJs(paramString2, new String[] { paramString1.toString() });
      }
      else if ("shortVideo".equals(paramString3))
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.jdField_b_of_type_JavaLangString = paramString2;
        }
        a(paramJsBridgeListener.optInt("sizeBeforeCompress", 104857600), paramJsBridgeListener.optInt("durationMax", 180) * 1000, paramJsBridgeListener.optInt("sizeAfterCompress", 10485760), paramJsBridgeListener.optInt("durationRecord", 20));
      }
      else if ("getVideoInfo".equals(paramString3))
      {
        if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label3169;
        }
        paramJsBridgeListener = a().getString((String)localObject1, null);
        if (paramJsBridgeListener == null) {
          return true;
        }
        ThreadManager.post(new HealthBusinessPlugin.4(this, paramJsBridgeListener, paramString2), 5, null, true);
      }
      else if ("uploadVideoCount".equals(paramString3))
      {
        paramJsBridgeListener = new JSONObject();
        try
        {
          paramJsBridgeListener.put("retCode", 0);
          paramJsBridgeListener.put("videoCount", jdField_a_of_type_JavaUtilList.size());
          if (QLog.isColorLevel()) {
            QLog.i("HealthBusinessPlugin", 2, "videoCount:" + jdField_a_of_type_JavaUtilList.size());
          }
          super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramJsBridgeListener.put("retCode", -1);
            paramJsBridgeListener.put("videoCount", 0);
          }
        }
      }
      else if ("uploadVideoList".equals(paramString3))
      {
        paramJsBridgeListener = new JSONObject();
        paramString1 = new JSONArray();
        m = 0;
        while (m < jdField_a_of_type_JavaUtilList.size())
        {
          paramString3 = new JSONObject();
          paramString3.put("groupID", jdField_a_of_type_JavaUtilList.get(m));
          paramString3.put("feedID", this.mRuntime.a().getApplication().getSharedPreferences("groupid_feedid", 0).getString((String)jdField_a_of_type_JavaUtilList.get(m), ""));
          paramVarArgs = (String)jdField_a_of_type_JavaUtilList.get(m);
          localObject1 = new JSONObject(a().getString(paramVarArgs, null));
          paramVarArgs = ((JSONObject)localObject1).getString("video_dir");
          localObject1 = ((JSONObject)localObject1).optString("thumb_dir");
          localObject2 = new File(paramVarArgs);
          if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
            paramString3.put("videoSize", ((File)localObject2).length() / 1024L);
          }
          paramString3.put("videoPath", paramVarArgs);
          paramString3.put("thumbData", localObject1);
          paramString3.put("videoID", paramVarArgs);
          if (Build.VERSION.SDK_INT >= 10)
          {
            localObject1 = new MediaMetadataRetriever();
            ((MediaMetadataRetriever)localObject1).setDataSource(paramVarArgs);
            paramVarArgs = ((MediaMetadataRetriever)localObject1).extractMetadata(9);
            ((MediaMetadataRetriever)localObject1).release();
            paramString3.put("videoDuration", String.valueOf(Long.parseLong(paramVarArgs) / 1000L));
          }
          paramString1.put(paramString3);
          m += 1;
        }
        paramJsBridgeListener.put("retCode", 0);
        paramJsBridgeListener.put("data", paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("HealthBusinessPlugin", 2, "uploadVideoList:" + paramJsBridgeListener.toString());
        }
        super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      }
      else
      {
        if ("deleteUploadVideo".equals(paramString3))
        {
          paramString1 = new JSONObject();
          paramJsBridgeListener = paramJsBridgeListener.optString("groupID");
          paramJsBridgeListener = (HealthBusinessPlugin.UploadThread)jdField_b_of_type_JavaUtilHashMap.get(paramJsBridgeListener);
          if (paramJsBridgeListener != null)
          {
            paramJsBridgeListener.jdField_a_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              QLog.d("HealthBusinessPlugin", 2, "queue length before directly:" + jdField_a_of_type_JavaUtilList.size());
            }
            if (jdField_a_of_type_JavaUtilList.contains(paramJsBridgeListener.jdField_b_of_type_JavaLangString)) {
              jdField_a_of_type_JavaUtilList.remove(paramJsBridgeListener.jdField_b_of_type_JavaLangString);
            }
            if (jdField_c_of_type_JavaUtilHashMap.get(paramJsBridgeListener.jdField_b_of_type_JavaLangString) != null) {
              jdField_c_of_type_JavaUtilHashMap.remove(paramJsBridgeListener.jdField_b_of_type_JavaLangString);
            }
            if (jdField_b_of_type_JavaUtilHashMap.get(paramJsBridgeListener.jdField_b_of_type_JavaLangString) != null) {
              jdField_b_of_type_JavaUtilHashMap.remove(paramJsBridgeListener.jdField_b_of_type_JavaLangString);
            }
            if (QLog.isColorLevel()) {
              QLog.d("HealthBusinessPlugin", 2, "queue length after directly:" + jdField_a_of_type_JavaUtilList.size());
            }
            paramString1.put("retCode", 0);
          }
          for (;;)
          {
            super.callJs(paramString2, new String[] { paramString1.toString() });
            break;
            paramString1.put("retCode", -1);
          }
        }
        if ("pinVideo".equals(paramString3))
        {
          TVK_SDKMgr.initSdk(this.mRuntime.a().getApplication(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
          paramString1 = new JSONObject();
          paramString1.put("retCode", a(paramJsBridgeListener));
          callJs(paramString2, new String[] { paramString1.toString() });
        }
        else if ("pluckVideo".equals(paramString3))
        {
          paramString1 = new JSONObject();
          paramJsBridgeListener.optString("vid");
          paramString1.put("retCode", b(paramJsBridgeListener));
          callJs(paramString2, new String[] { paramString1.toString() });
        }
        else if ("playVideo".equals(paramString3))
        {
          paramString1 = new JSONObject();
          paramJsBridgeListener.optString("vid");
          paramString1.put("retCode", c(paramJsBridgeListener));
          callJs(paramString2, new String[] { paramString1.toString() });
        }
        else if ("pauseVideo".equals(paramString3))
        {
          paramString1 = new JSONObject();
          paramJsBridgeListener.optString("vid");
          paramString1.put("retCode", d(paramJsBridgeListener));
          callJs(paramString2, new String[] { paramString1.toString() });
        }
        else if ("stopVideo".equals(paramString3))
        {
          paramString1 = new JSONObject();
          paramJsBridgeListener = paramJsBridgeListener.optString("vid");
          if (paramJsBridgeListener == null)
          {
            paramString1.put("retCode", -1);
            callJs(paramString2, new String[] { paramString1.toString() });
            return false;
          }
          if (!this.d.containsKey(paramJsBridgeListener))
          {
            paramString1.put("retCode", -3);
            callJs(paramString2, new String[] { paramString1.toString() });
            return false;
          }
          ((TVK_IMediaPlayer)this.d.get(paramJsBridgeListener)).stop();
          paramString1.put("retCode", 0);
          callJs(paramString2, new String[] { paramString1.toString() });
        }
        else if ("wifiStatus".equals(paramString3))
        {
          paramJsBridgeListener = new JSONObject();
          if (((ConnectivityManager)this.mRuntime.a().getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.DISCONNECTED) {
            break label3171;
          }
        }
      }
    }
    label3095:
    label3101:
    label3103:
    label3105:
    label3114:
    label3116:
    label3118:
    label3127:
    label3138:
    label3150:
    label3156:
    label3162:
    label3169:
    label3171:
    for (boolean bool = false;; bool = true)
    {
      paramJsBridgeListener.put("retCode", bool);
      callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      break label3101;
      bool = "followUin".equals(paramString3);
      if (bool)
      {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("uin");
          paramString1 = paramString1.optString("callback");
          paramString2 = new NewIntent(this.mRuntime.a().getApplication(), ndt.class);
          akij.a(paramJsBridgeListener);
          paramString2.putExtra("cmd", "PubAccountFollowSvc.follow");
          paramString3 = new mobileqq_mp.FollowRequest();
          paramString3.uin.set((int)Long.parseLong(paramJsBridgeListener));
          paramString3.type.set(-1);
          paramString3.ext.set(String.valueOf(0));
          paramString2.setObserver(new barm(this, paramString1));
          paramString2.putExtra("data", paramString3.toByteArray());
          this.mRuntime.a().startServlet(paramString2);
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("HealthBusinessPlugin", 1, "[followUin] error=", paramJsBridgeListener);
        }
        m = 0;
        break;
      }
      return true;
      return true;
      m += 1;
      break label815;
      return true;
      return true;
      m += 1;
      break label1203;
      for (;;)
      {
        if (localObject1 == null) {
          break label3156;
        }
        n = 1;
        break;
        if (!bool) {
          break label3162;
        }
        paramJsBridgeListener = "success.";
        break label1524;
        m = 0;
      }
      n = 0;
      break label1494;
      paramJsBridgeListener = "group not found.";
      break label1524;
      return true;
    }
  }
  
  /* Error */
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 1648	com/tencent/mobileqq/webview/swift/WebViewPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpne +165 -> 174
    //   12: iload_3
    //   13: iconst_m1
    //   14: if_icmpne +123 -> 137
    //   17: aload_1
    //   18: ldc_w 1650
    //   21: invokevirtual 1654	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnonnull +4 -> 30
    //   29: return
    //   30: aload_0
    //   31: getfield 662	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   34: invokestatic 628	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne +13 -> 50
    //   40: aload_0
    //   41: getfield 664	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   44: invokestatic 628	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +13 -> 60
    //   50: ldc 213
    //   52: iconst_1
    //   53: ldc_w 1656
    //   56: invokestatic 668	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: return
    //   60: aload_0
    //   61: getfield 115	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lbbac;
    //   64: ifnull +8 -> 72
    //   67: aload_0
    //   68: aload_1
    //   69: invokevirtual 1658	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/util/List;)V
    //   72: new 154	org/json/JSONObject
    //   75: dup
    //   76: invokespecial 837	org/json/JSONObject:<init>	()V
    //   79: astore 4
    //   81: aload 4
    //   83: ldc_w 1660
    //   86: aload_0
    //   87: getfield 662	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: invokevirtual 844	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   93: pop
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 664	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   99: iconst_1
    //   100: anewarray 498	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: aload 4
    //   107: invokevirtual 853	org/json/JSONObject:toString	()Ljava/lang/String;
    //   110: aastore
    //   111: invokespecial 108	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   114: aload_0
    //   115: getfield 115	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lbbac;
    //   118: ifnull -89 -> 29
    //   121: new 1662	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$6
    //   124: dup
    //   125: aload_0
    //   126: aload_1
    //   127: invokespecial 1665	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$6:<init>	(Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;Ljava/util/List;)V
    //   130: iconst_5
    //   131: aconst_null
    //   132: iconst_1
    //   133: invokestatic 319	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   136: return
    //   137: iload_3
    //   138: bipush 16
    //   140: if_icmpne -111 -> 29
    //   143: aload_1
    //   144: ldc_w 1650
    //   147: invokevirtual 1654	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   150: astore_1
    //   151: aload_1
    //   152: ifnull +17 -> 169
    //   155: aload_1
    //   156: invokeinterface 1667 1 0
    //   161: ifne +8 -> 169
    //   164: aload_0
    //   165: aload_1
    //   166: invokevirtual 1658	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/util/List;)V
    //   169: aload_0
    //   170: invokevirtual 1390	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	()V
    //   173: return
    //   174: iload_2
    //   175: iconst_2
    //   176: if_icmpne +295 -> 471
    //   179: aload_0
    //   180: getfield 664	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   183: invokestatic 628	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: ifne +13 -> 199
    //   189: aload_0
    //   190: getfield 662	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   193: invokestatic 628	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifeq +13 -> 209
    //   199: ldc 213
    //   201: iconst_1
    //   202: ldc_w 1669
    //   205: invokestatic 668	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: return
    //   209: new 154	org/json/JSONObject
    //   212: dup
    //   213: invokespecial 837	org/json/JSONObject:<init>	()V
    //   216: astore 5
    //   218: iload_3
    //   219: iconst_m1
    //   220: if_icmpne +232 -> 452
    //   223: aload_0
    //   224: getfield 115	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lbbac;
    //   227: ifnull +162 -> 389
    //   230: aload_0
    //   231: getfield 115	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lbbac;
    //   234: invokevirtual 120	bbac:a	()Landroid/app/Activity;
    //   237: ifnull +152 -> 389
    //   240: aload_0
    //   241: getfield 115	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lbbac;
    //   244: invokevirtual 120	bbac:a	()Landroid/app/Activity;
    //   247: invokevirtual 1673	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   250: astore_1
    //   251: aload_1
    //   252: aload_0
    //   253: getfield 695	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   256: invokestatic 1678	bacm:b	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   259: astore 6
    //   261: aload_1
    //   262: aload 6
    //   264: invokestatic 1681	bacm:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   267: aload_0
    //   268: invokevirtual 1156	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	()Landroid/content/SharedPreferences;
    //   271: astore 7
    //   273: aload 7
    //   275: aload_0
    //   276: getfield 662	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   279: aconst_null
    //   280: invokeinterface 1160 3 0
    //   285: astore 4
    //   287: aload 4
    //   289: invokestatic 628	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   292: ifeq +135 -> 427
    //   295: new 154	org/json/JSONObject
    //   298: dup
    //   299: invokespecial 837	org/json/JSONObject:<init>	()V
    //   302: astore_1
    //   303: aload 4
    //   305: invokestatic 628	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   308: ifeq +132 -> 440
    //   311: new 1117	org/json/JSONArray
    //   314: dup
    //   315: invokespecial 1118	org/json/JSONArray:<init>	()V
    //   318: astore 4
    //   320: aload 4
    //   322: aload 6
    //   324: invokevirtual 1127	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   327: pop
    //   328: aload_1
    //   329: ldc_w 1168
    //   332: aload 4
    //   334: invokevirtual 844	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   337: pop
    //   338: aload 7
    //   340: invokeinterface 1172 1 0
    //   345: aload_0
    //   346: getfield 662	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   349: aload_1
    //   350: invokevirtual 853	org/json/JSONObject:toString	()Ljava/lang/String;
    //   353: invokeinterface 1178 3 0
    //   358: invokeinterface 1181 1 0
    //   363: pop
    //   364: aload 5
    //   366: ldc_w 1660
    //   369: aload_0
    //   370: getfield 662	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   373: invokevirtual 844	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   376: pop
    //   377: aload 5
    //   379: ldc_w 1399
    //   382: ldc_w 1683
    //   385: invokevirtual 844	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   388: pop
    //   389: aload_0
    //   390: getfield 115	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lbbac;
    //   393: ifnull -364 -> 29
    //   396: aload_0
    //   397: getfield 115	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lbbac;
    //   400: invokevirtual 120	bbac:a	()Landroid/app/Activity;
    //   403: ifnull -374 -> 29
    //   406: aload_0
    //   407: aload_0
    //   408: getfield 664	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   411: iconst_1
    //   412: anewarray 498	java/lang/String
    //   415: dup
    //   416: iconst_0
    //   417: aload 5
    //   419: invokevirtual 853	org/json/JSONObject:toString	()Ljava/lang/String;
    //   422: aastore
    //   423: invokespecial 108	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   426: return
    //   427: new 154	org/json/JSONObject
    //   430: dup
    //   431: aload 4
    //   433: invokespecial 836	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   436: astore_1
    //   437: goto -134 -> 303
    //   440: aload_1
    //   441: ldc_w 1168
    //   444: invokevirtual 1323	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   447: astore 4
    //   449: goto -129 -> 320
    //   452: aload 5
    //   454: ldc_w 1399
    //   457: ldc_w 1684
    //   460: invokevirtual 844	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   463: pop
    //   464: goto -75 -> 389
    //   467: astore_1
    //   468: goto -79 -> 389
    //   471: iload_2
    //   472: iconst_3
    //   473: if_icmpne -444 -> 29
    //   476: iload_3
    //   477: iconst_1
    //   478: if_icmpne -449 -> 29
    //   481: aload_1
    //   482: ldc_w 1460
    //   485: invokevirtual 1687	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   488: astore 4
    //   490: aload_1
    //   491: ldc_w 1467
    //   494: invokevirtual 1687	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   497: astore_1
    //   498: invokestatic 682	java/lang/System:currentTimeMillis	()J
    //   501: ldc2_w 816
    //   504: ldiv
    //   505: invokestatic 1319	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   508: astore 5
    //   510: aload_0
    //   511: getfield 664	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   514: invokestatic 628	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   517: ifne -488 -> 29
    //   520: new 154	org/json/JSONObject
    //   523: dup
    //   524: invokespecial 837	org/json/JSONObject:<init>	()V
    //   527: astore 6
    //   529: aload 6
    //   531: ldc_w 1660
    //   534: aload 5
    //   536: invokevirtual 844	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   539: pop
    //   540: aload_0
    //   541: aload_0
    //   542: getfield 664	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   545: iconst_1
    //   546: anewarray 498	java/lang/String
    //   549: dup
    //   550: iconst_0
    //   551: aload 6
    //   553: invokevirtual 853	org/json/JSONObject:toString	()Ljava/lang/String;
    //   556: aastore
    //   557: invokespecial 108	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   560: new 154	org/json/JSONObject
    //   563: dup
    //   564: invokespecial 837	org/json/JSONObject:<init>	()V
    //   567: astore 6
    //   569: aload 6
    //   571: ldc_w 1460
    //   574: aload 4
    //   576: invokevirtual 844	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   579: pop
    //   580: aload_1
    //   581: invokestatic 628	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   584: ifne +41 -> 625
    //   587: aload 6
    //   589: ldc_w 1467
    //   592: aload_1
    //   593: invokevirtual 844	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   596: pop
    //   597: aload_0
    //   598: invokevirtual 1156	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	()Landroid/content/SharedPreferences;
    //   601: invokeinterface 1172 1 0
    //   606: aload 5
    //   608: aload 6
    //   610: invokevirtual 853	org/json/JSONObject:toString	()Ljava/lang/String;
    //   613: invokeinterface 1178 3 0
    //   618: invokeinterface 1181 1 0
    //   623: pop
    //   624: return
    //   625: ldc 213
    //   627: iconst_1
    //   628: ldc_w 1689
    //   631: invokestatic 668	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   634: goto -37 -> 597
    //   637: astore_1
    //   638: goto -249 -> 389
    //   641: astore 5
    //   643: goto -549 -> 94
    //   646: astore_1
    //   647: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	HealthBusinessPlugin
    //   0	648	1	paramIntent	Intent
    //   0	648	2	paramByte	byte
    //   0	648	3	paramInt	int
    //   79	496	4	localObject1	Object
    //   216	391	5	localObject2	Object
    //   641	1	5	localException	Exception
    //   259	350	6	localObject3	Object
    //   271	68	7	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   452	464	467	java/lang/Exception
    //   287	303	637	java/lang/Exception
    //   303	320	637	java/lang/Exception
    //   320	389	637	java/lang/Exception
    //   427	437	637	java/lang/Exception
    //   440	449	637	java/lang/Exception
    //   81	94	641	java/lang/Exception
    //   520	597	646	java/lang/Exception
    //   597	624	646	java/lang/Exception
    //   625	634	646	java/lang/Exception
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "oncreated ......");
    }
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizUiRefreshView.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Baro);
    QLog.d("HealthBusinessPlugin", 1, "onDestroy");
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    paramCustomWebView = new FrameLayout.LayoutParams(-1, -1);
    paramCustomWebView.topMargin = 0;
    paramCustomWebView.leftMargin = 0;
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.mRuntime.a().findViewById(2131313572));
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "videoLayout id:" + this.jdField_a_of_type_ComTencentBizUiRefreshView.getResources());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.mRuntime.a());
    this.jdField_a_of_type_ComTencentBizUiRefreshView.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramCustomWebView);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)this.mRuntime.a());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.scrollBy(0, this.jdField_a_of_type_ComTencentBizUiTouchWebView.mTotalYoffset);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListener(new barc(this));
    QLog.d("HealthBusinessPlugin", 1, "onWebViewCreated");
    this.jdField_a_of_type_Baro = new baro(this, this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.mRuntime.a(), this.jdField_a_of_type_Baro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin
 * JD-Core Version:    0.7.0.1
 */