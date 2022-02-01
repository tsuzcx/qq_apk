package com.tencent.mobileqq.vashealth;

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
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.richmedia.MX3FlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class HealthBusinessPlugin
  extends WebViewPlugin
{
  public static HashMap<String, JSONObject> a;
  static List<String> jdField_a_of_type_JavaUtilList;
  public static HashMap<String, HealthBusinessPlugin.UploadThread> b;
  static HashMap<String, Double> jdField_c_of_type_JavaUtilHashMap;
  int jdField_a_of_type_Int;
  Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  Uri jdField_a_of_type_AndroidNetUri;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  VideoPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
  VideoPlayerWrapper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
  RefreshView jdField_a_of_type_ComTencentBizUiRefreshView;
  TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  HealthBusinessPlugin.MyNetInfoHandler jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$MyNetInfoHandler = null;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  Point jdField_b_of_type_AndroidGraphicsPoint = new Point();
  Handler jdField_b_of_type_AndroidOsHandler;
  Runnable jdField_b_of_type_JavaLangRunnable;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  HashMap<String, ISuperPlayer> jdField_d_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  HashMap<String, FrameLayout> jdField_e_of_type_JavaUtilHashMap;
  int jdField_f_of_type_Int;
  HashMap<String, HealthBusinessPlugin.SportVideoLayoutHolder> jdField_f_of_type_JavaUtilHashMap;
  int jdField_g_of_type_Int;
  HashMap<String, Timer> jdField_g_of_type_JavaUtilHashMap;
  int jdField_h_of_type_Int;
  HashMap<String, Long> jdField_h_of_type_JavaUtilHashMap;
  int i;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    c = new HashMap();
  }
  
  public HealthBusinessPlugin()
  {
    this.e = new HashMap();
    this.f = new HashMap();
    this.g = new HashMap();
    this.h = new HashMap();
    this.mPluginNameSpace = "healthSport";
  }
  
  private void b()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((Timer)localIterator.next()).cancel();
    }
    this.g.clear();
  }
  
  int a(JSONObject paramJSONObject)
  {
    Object localObject1 = this.mRuntime.a();
    int k = 1;
    int n = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar((Context)localObject1);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(((Context)localObject1).getResources().getDrawable(2130840617));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
    double d1;
    double d2;
    double d3;
    double d4;
    String str;
    int j;
    try
    {
      d1 = paramJSONObject.getDouble("top");
      d2 = paramJSONObject.getDouble("left");
      d3 = paramJSONObject.getDouble("width");
      d4 = paramJSONObject.getDouble("height");
      str = paramJSONObject.getString("vid");
      localObject3 = this.mRuntime.a().getResources().getDisplayMetrics();
      j = n;
    }
    catch (Exception paramJSONObject)
    {
      int i1;
      label164:
      QLog.d("HealthBusinessPlugin", 1, "AddView Err:");
      return -6;
    }
    try
    {
      m = paramJSONObject.optInt("needCheckWiFi");
      j = n;
      k = m;
      n = paramJSONObject.optInt("needMute");
      j = n;
      k = m;
      i1 = paramJSONObject.optInt("needCountdown");
      j = i1;
      k = m;
    }
    catch (Exception paramJSONObject)
    {
      if (!QLog.isColorLevel()) {
        break label229;
      }
      QLog.d("HealthBusinessPlugin", 2, "optional Err");
      m = j;
      j = 1;
      n = m;
      break label164;
      if (!QLog.isColorLevel()) {
        break label257;
      }
      QLog.d("HealthBusinessPlugin", 2, "addView Function");
      float f1 = this.mRuntime.a().getResources().getDisplayMetrics().density;
      localObject5 = new FrameLayout.LayoutParams((int)(f1 * d3), (int)(f1 * d4));
      ((FrameLayout.LayoutParams)localObject5).topMargin = ((int)(d1 * f1));
      ((FrameLayout.LayoutParams)localObject5).leftMargin = ((int)(f1 * d2));
      if ((d3 != 0.0D) && (d4 != 0.0D)) {
        break label337;
      }
      return -1;
      if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(str)) {
        break label352;
      }
      return -2;
      if (this.jdField_d_of_type_JavaUtilHashMap.size() != 3) {
        break label366;
      }
      return -4;
      paramJSONObject = SuperPlayerFactory.createPlayerVideoView(this.mRuntime.a());
      localObject4 = SuperPlayerFactory.createMediaPlayer(this.mRuntime.a(), 117, paramJSONObject);
      ((ISuperPlayer)localObject4).setLoopback(false);
      this.jdField_a_of_type_JavaLangRunnable = new HealthBusinessPlugin.6(this);
      this.jdField_b_of_type_JavaLangRunnable = new HealthBusinessPlugin.7(this);
      a((ISuperPlayer)localObject4);
      localObject2 = SuperPlayerFactory.createVideoInfoForTVideo(4080303, str);
      ((ISuperPlayer)localObject4).openMediaPlayer(this.mRuntime.a(), (SuperPlayerVideoInfo)localObject2, 0L);
      if (!QLog.isColorLevel()) {
        break label490;
      }
      QLog.d("HealthBusinessPlugin", 2, "sDensity:" + f1);
      localObject6 = (FrameLayout)LayoutInflater.from((Context)localObject1).inflate(2131560508, null);
      localObject2 = new HealthBusinessPlugin.SportVideoLayoutHolder();
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((FrameLayout)localObject6).findViewById(2131374812));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((FrameLayout)localObject6).findViewById(2131374811));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)localObject6).findViewById(2131374810));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)localObject6).findViewById(2131374813));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)((FrameLayout)localObject6).findViewById(2131377688));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)localObject6).findViewById(2131374814));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((FrameLayout)localObject6).findViewById(2131374809));
      localFrameLayout = new FrameLayout((Context)localObject1);
      localFrameLayout.addView((View)paramJSONObject);
      localFrameLayout.addView((View)localObject6);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject5);
      this.e.put(str, localFrameLayout);
      this.f.put(str, localObject2);
      if (this.jdField_d_of_type_JavaUtilHashMap != null) {
        break label708;
      }
      this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
      localObject5 = this.jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (String)((Iterator)localObject5).next();
        ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject6)).pause();
      }
      this.jdField_d_of_type_JavaUtilHashMap.put(str, localObject4);
      this.h.put(str, Long.valueOf(0L));
      this.jdField_b_of_type_AndroidOsHandler = new Handler();
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      if (n != 0) {
        break label1401;
      }
    }
    paramJSONObject = ((ConnectivityManager)((Context)localObject1).getSystemService("connectivity")).getNetworkInfo(1);
    if ((paramJSONObject != null) && (paramJSONObject.getState() == NetworkInfo.State.DISCONNECTED) && (k == 1)) {
      return -5;
    }
    label229:
    label366:
    Object localObject2;
    label257:
    label337:
    label352:
    label490:
    FrameLayout localFrameLayout;
    label708:
    ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(str)).setOutputMute(false);
    ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(((Context)localObject1).getResources().getDrawable(2130846735));
    ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new HealthBusinessPlugin.8(this, str, (Context)localObject1));
    new FrameLayout.LayoutParams(AIOUtils.a(45.0F, ((Context)localObject1).getResources()), AIOUtils.a(43.0F, ((Context)localObject1).getResources())).gravity = 85;
    ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new HealthBusinessPlugin.9(this, str, (HealthBusinessPlugin.SportVideoLayoutHolder)localObject2));
    k = this.mRuntime.a().getResources().getDisplayMetrics().widthPixels;
    int m = (int)(((DisplayMetrics)localObject3).density * d3 * 0.7D);
    n = (int)(d3 * ((DisplayMetrics)localObject3).density * 0.15D);
    QLog.d("HealthBusinessPlugin", 1, "screen width:" + (k - 200) / 2);
    Object localObject3 = new FrameLayout.LayoutParams(m, AIOUtils.a(20.0F, ((Context)localObject1).getResources()));
    Object localObject4 = new FrameLayout.LayoutParams(n, AIOUtils.a(20.0F, ((Context)localObject1).getResources()));
    Object localObject5 = new FrameLayout.LayoutParams(n, AIOUtils.a(20.0F, ((Context)localObject1).getResources()));
    Object localObject6 = new FrameLayout.LayoutParams(AIOUtils.a(60.0F, ((Context)localObject1).getResources()), AIOUtils.a(60.0F, ((Context)localObject1).getResources()));
    ((FrameLayout.LayoutParams)localObject3).gravity = 81;
    ((FrameLayout.LayoutParams)localObject4).gravity = 83;
    ((FrameLayout.LayoutParams)localObject5).gravity = 85;
    ((FrameLayout.LayoutParams)localObject6).gravity = 17;
    VideoFeedsHelper.a(((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView, ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(str)).getCurrentPositionMs());
    localFrameLayout.setBackgroundColor(-16777216);
    localFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetProgressBar, (ViewGroup.LayoutParams)localObject6);
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "add seekbar");
    }
    ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_d_of_type_Boolean = false;
    ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new HealthBusinessPlugin.10(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = new VideoPlayManager.VideoPlayParam();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = new VideoPlayerWrapper((Context)localObject1);
    new FrameLayout.LayoutParams(-2, AIOUtils.a(43.0F, ((Context)localObject1).getResources())).gravity = 85;
    VideoFeedsHelper.a(((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView, ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(str)).getDurationMs());
    if (j == 1) {
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      a(((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView, str, ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView, ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView, ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_a_of_type_AndroidWidgetSeekBar);
      localObject1 = new HealthBusinessPlugin.11(this);
      this.mRuntime.a().setOnTouchListener((View.OnTouchListener)localObject1);
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new HealthBusinessPlugin.12(this, (HealthBusinessPlugin.SportVideoLayoutHolder)localObject2, paramJSONObject, localFrameLayout));
      return 0;
      label1401:
      ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(str)).setOutputMute(true);
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(((Context)localObject1).getResources().getDrawable(2130846734));
      break;
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
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
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {}
    for (;;)
    {
      return;
      File localFile = new File(AppConstants.SDCARD_IMG_SAVE);
      int j;
      if ((localFile.exists()) || (localFile.mkdirs())) {
        j = 1;
      }
      for (;;)
      {
        if ((j != 0) && (localFile.canWrite())) {
          if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
          {
            QLog.e("HealthBusinessPlugin", 1, "temp ids lost!");
            return;
            j = 0;
          }
          else
          {
            if (this.mRuntime == null) {}
            while ((localObject != null) && (!((Activity)localObject).isFinishing()))
            {
              localIntent = new Intent();
              this.jdField_a_of_type_AndroidNetUri = FileProvider7Helper.setSystemCapture((Context)localObject, new File(AppConstants.SDCARD_IMG_SAVE + System.currentTimeMillis() + ".jpg"), localIntent);
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
        QQToast.a((Context)localObject, 2131696255, 1).b(((BaseActivity)localObject).getTitleBarHeight());
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
    if (CameraCompatibleList.d(CameraCompatibleList.c)) {
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
    ((Intent)localObject).putExtra("sv_config", ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.SV658Cfg.name(), null));
    ((Intent)localObject).putExtra("size_before_compress", paramInt1);
    ((Intent)localObject).putExtra("size_after_compress", paramInt3);
    ((Intent)localObject).putExtra("duration_max", paramInt2);
    ((Intent)localObject).putExtra("activity_start_time", SystemClock.elapsedRealtime());
    ((Intent)localObject).putExtra("from_health", true);
    ((Intent)localObject).putExtra("enter_from", 46);
    startActivityForResult((Intent)localObject, (byte)3);
  }
  
  void a(TextView paramTextView1, String paramString, TextView paramTextView2, TextView paramTextView3, SeekBar paramSeekBar)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper == null) || (paramTextView1 == null)) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
    paramTextView1 = new WeakReference(paramTextView1);
    Timer localTimer = new Timer();
    localTimer.schedule(new HealthBusinessPlugin.15(this, paramTextView1, paramString, paramTextView2, paramTextView3, paramSeekBar), 0L, 1000L);
    this.g.put(paramString, localTimer);
  }
  
  void a(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer.setOnVideoPreparedListener(new HealthBusinessPlugin.13(this));
    paramISuperPlayer.setOnCompletionListener(new HealthBusinessPlugin.14(this));
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
  void a(String paramString1, String paramString2, String paramString3, String paramString4, java.util.Map<String, String> paramMap, Bundle paramBundle, HealthBusinessPlugin.UploadThread paramUploadThread)
  {
    // Byte code:
    //   0: invokestatic 596	java/lang/System:currentTimeMillis	()J
    //   3: lstore 13
    //   5: aload 6
    //   7: aload_3
    //   8: aload 4
    //   10: ldc_w 781
    //   13: iconst_0
    //   14: invokestatic 786	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   17: astore 6
    //   19: aload 6
    //   21: ifnull +1618 -> 1639
    //   24: aload_2
    //   25: invokestatic 791	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)J
    //   28: lstore 15
    //   30: lload 15
    //   32: ldc2_w 792
    //   35: invokestatic 799	java/lang/Math:min	(JJ)J
    //   38: lstore 9
    //   40: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +47 -> 90
    //   46: ldc 230
    //   48: iconst_2
    //   49: new 310	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 801
    //   59: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 6
    //   64: getfield 805	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   67: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc_w 807
    //   73: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 6
    //   78: getfield 809	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:d	Ljava/lang/String;
    //   81: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: ldc_w 811
    //   93: aload 6
    //   95: getfield 805	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   98: invokevirtual 814	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: ifeq +380 -> 481
    //   104: aload 6
    //   106: getfield 816	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   109: astore_2
    //   110: iconst_1
    //   111: istore 8
    //   113: iload 8
    //   115: ifeq +1455 -> 1570
    //   118: aconst_null
    //   119: astore 6
    //   121: aconst_null
    //   122: astore 7
    //   124: new 818	java/net/URL
    //   127: dup
    //   128: aload_1
    //   129: invokespecial 819	java/net/URL:<init>	(Ljava/lang/String;)V
    //   132: invokevirtual 823	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   135: checkcast 825	java/net/HttpURLConnection
    //   138: astore_1
    //   139: aload_1
    //   140: sipush 5000
    //   143: invokevirtual 828	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   146: aload_1
    //   147: sipush 30000
    //   150: invokevirtual 831	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   153: aload_1
    //   154: iconst_1
    //   155: invokevirtual 834	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   158: aload_1
    //   159: iconst_1
    //   160: invokevirtual 837	java/net/HttpURLConnection:setDoInput	(Z)V
    //   163: aload_1
    //   164: iconst_0
    //   165: invokevirtual 840	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   168: aload_1
    //   169: ldc_w 842
    //   172: invokevirtual 845	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   175: aload_1
    //   176: ldc_w 847
    //   179: ldc_w 849
    //   182: invokevirtual 853	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload_1
    //   186: ldc_w 855
    //   189: new 310	java/lang/StringBuilder
    //   192: dup
    //   193: ldc_w 857
    //   196: invokespecial 858	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: ldc_w 860
    //   202: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: getstatic 865	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   208: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc_w 860
    //   214: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: getstatic 870	android/os/Build:DEVICE	Ljava/lang/String;
    //   220: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc_w 860
    //   226: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: getstatic 873	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   232: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 860
    //   238: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc_w 875
    //   244: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokevirtual 853	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_1
    //   254: ldc_w 877
    //   257: ldc_w 879
    //   260: invokevirtual 853	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_1
    //   264: ldc_w 881
    //   267: new 310	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 883
    //   277: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_3
    //   281: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc_w 885
    //   287: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 4
    //   292: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokevirtual 853	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: new 887	java/io/DataOutputStream
    //   304: dup
    //   305: aload_1
    //   306: invokevirtual 891	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   309: invokespecial 894	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   312: astore_3
    //   313: new 896	java/lang/StringBuffer
    //   316: dup
    //   317: invokespecial 897	java/lang/StringBuffer:<init>	()V
    //   320: astore 4
    //   322: aload 4
    //   324: ldc_w 899
    //   327: invokevirtual 902	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   330: pop
    //   331: aload 4
    //   333: aload_2
    //   334: invokevirtual 902	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   337: pop
    //   338: aload 4
    //   340: ldc_w 904
    //   343: invokevirtual 902	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   346: pop
    //   347: aload 4
    //   349: aload 5
    //   351: ldc_w 906
    //   354: invokeinterface 909 2 0
    //   359: checkcast 399	java/lang/String
    //   362: invokevirtual 902	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   365: pop
    //   366: aload_3
    //   367: aload 4
    //   369: invokevirtual 910	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   372: invokevirtual 914	java/lang/String:getBytes	()[B
    //   375: invokevirtual 920	java/io/OutputStream:write	([B)V
    //   378: aload_3
    //   379: invokevirtual 923	java/io/OutputStream:flush	()V
    //   382: aload_3
    //   383: invokevirtual 926	java/io/OutputStream:close	()V
    //   386: new 896	java/lang/StringBuffer
    //   389: dup
    //   390: invokespecial 897	java/lang/StringBuffer:<init>	()V
    //   393: astore 4
    //   395: new 928	java/io/BufferedReader
    //   398: dup
    //   399: new 930	java/io/InputStreamReader
    //   402: dup
    //   403: aload_1
    //   404: invokevirtual 934	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   407: invokespecial 937	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   410: invokespecial 940	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   413: astore_3
    //   414: aload_3
    //   415: invokevirtual 943	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   418: astore 6
    //   420: aload 6
    //   422: ifnull +1055 -> 1477
    //   425: aload 4
    //   427: aload 6
    //   429: invokevirtual 902	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   432: ldc_w 945
    //   435: invokevirtual 902	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   438: pop
    //   439: goto -25 -> 414
    //   442: astore_2
    //   443: aload_1
    //   444: astore 6
    //   446: ldc 230
    //   448: iconst_2
    //   449: new 310	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 947
    //   459: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload_2
    //   463: invokevirtual 950	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: aload_1
    //   473: ifnull +7 -> 480
    //   476: aload_1
    //   477: invokevirtual 953	java/net/HttpURLConnection:disconnect	()V
    //   480: return
    //   481: aload 6
    //   483: getfield 816	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   486: ifnull +1153 -> 1639
    //   489: aload 6
    //   491: getfield 954	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:c	Ljava/lang/String;
    //   494: invokestatic 960	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   497: astore 18
    //   499: aload_2
    //   500: invokestatic 964	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
    //   503: astore 19
    //   505: new 310	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   512: ldc_w 966
    //   515: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload 6
    //   520: getfield 967	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   523: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: ldc_w 969
    //   529: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload 6
    //   534: getfield 970	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   537: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: ldc_w 972
    //   543: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: astore 20
    //   551: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq +44 -> 598
    //   557: ldc 230
    //   559: iconst_2
    //   560: new 310	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   567: ldc_w 974
    //   570: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload 20
    //   575: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: ldc_w 976
    //   581: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: aload 6
    //   586: getfield 816	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   589: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: new 978	java/io/RandomAccessFile
    //   601: dup
    //   602: aload_2
    //   603: ldc_w 980
    //   606: invokespecial 982	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   609: astore 17
    //   611: lconst_0
    //   612: lstore 11
    //   614: lload 9
    //   616: lload 11
    //   618: lsub
    //   619: l2i
    //   620: istore 8
    //   622: aload 17
    //   624: astore_2
    //   625: invokestatic 553	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   628: invokestatic 987	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   631: ifeq +1018 -> 1649
    //   634: aload 17
    //   636: astore_2
    //   637: aload 18
    //   639: aload 19
    //   641: aload 20
    //   643: lload 15
    //   645: aload 17
    //   647: lload 11
    //   649: iload 8
    //   651: invokestatic 992	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   654: lstore 11
    //   656: aload 17
    //   658: astore_2
    //   659: aload 7
    //   661: getfield 995	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_Boolean	Z
    //   664: ifeq +145 -> 809
    //   667: aload 17
    //   669: astore_2
    //   670: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   673: ifeq +15 -> 688
    //   676: aload 17
    //   678: astore_2
    //   679: ldc 230
    //   681: iconst_2
    //   682: ldc_w 997
    //   685: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   688: aload 17
    //   690: astore_2
    //   691: getstatic 53	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   694: aload 7
    //   696: getfield 998	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   699: invokeinterface 1003 2 0
    //   704: pop
    //   705: aload 17
    //   707: astore_2
    //   708: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:c	Ljava/util/HashMap;
    //   711: aload 7
    //   713: getfield 998	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   716: invokevirtual 1005	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   719: pop
    //   720: aload 17
    //   722: astore_2
    //   723: getstatic 55	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   726: aload 7
    //   728: getfield 998	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   731: invokevirtual 1005	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   734: pop
    //   735: aload 17
    //   737: astore_2
    //   738: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   741: ifeq +39 -> 780
    //   744: aload 17
    //   746: astore_2
    //   747: ldc 230
    //   749: iconst_2
    //   750: new 310	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   757: ldc_w 1007
    //   760: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: getstatic 53	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   766: invokeinterface 1008 1 0
    //   771: invokevirtual 461	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   774: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   777: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   780: aload 17
    //   782: ifnull -302 -> 480
    //   785: aload 17
    //   787: invokevirtual 1009	java/io/RandomAccessFile:close	()V
    //   790: return
    //   791: astore_1
    //   792: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   795: ifeq -315 -> 480
    //   798: ldc 230
    //   800: iconst_2
    //   801: aload_1
    //   802: invokestatic 1013	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   805: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: return
    //   809: aload 17
    //   811: astore_2
    //   812: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   815: ifeq +76 -> 891
    //   818: aload 17
    //   820: astore_2
    //   821: ldc 230
    //   823: iconst_2
    //   824: new 310	java/lang/StringBuilder
    //   827: dup
    //   828: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   831: ldc_w 1015
    //   834: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: lload 11
    //   839: l2d
    //   840: lload 15
    //   842: l2d
    //   843: ddiv
    //   844: invokevirtual 1018	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   847: ldc_w 1020
    //   850: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: getstatic 53	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   856: invokeinterface 1008 1 0
    //   861: invokevirtual 461	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   864: ldc_w 1022
    //   867: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: getstatic 53	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   873: iconst_0
    //   874: invokeinterface 1025 2 0
    //   879: checkcast 399	java/lang/String
    //   882: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   888: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: aload 17
    //   893: astore_2
    //   894: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:c	Ljava/util/HashMap;
    //   897: aload 7
    //   899: getfield 998	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   902: lload 11
    //   904: l2d
    //   905: lload 15
    //   907: l2d
    //   908: ddiv
    //   909: invokestatic 1030	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   912: invokevirtual 390	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   915: pop
    //   916: lload 11
    //   918: ldc2_w 1031
    //   921: lcmp
    //   922: ifne +74 -> 996
    //   925: iconst_1
    //   926: istore 8
    //   928: iload 8
    //   930: ifne +414 -> 1344
    //   933: aload 17
    //   935: astore_2
    //   936: ldc 230
    //   938: iconst_1
    //   939: new 310	java/lang/StringBuilder
    //   942: dup
    //   943: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   946: ldc_w 1034
    //   949: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: invokestatic 596	java/lang/System:currentTimeMillis	()J
    //   955: lload 13
    //   957: lsub
    //   958: invokevirtual 599	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   961: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokestatic 632	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   967: iconst_1
    //   968: istore 8
    //   970: aload 17
    //   972: astore_2
    //   973: aload 6
    //   975: getfield 816	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   978: astore 6
    //   980: aload 17
    //   982: ifnull +648 -> 1630
    //   985: aload 17
    //   987: invokevirtual 1009	java/io/RandomAccessFile:close	()V
    //   990: aload 6
    //   992: astore_2
    //   993: goto -880 -> 113
    //   996: aload 17
    //   998: astore_2
    //   999: new 171	org/json/JSONObject
    //   1002: dup
    //   1003: invokespecial 758	org/json/JSONObject:<init>	()V
    //   1006: astore 21
    //   1008: aload 17
    //   1010: astore_2
    //   1011: new 1036	org/json/JSONArray
    //   1014: dup
    //   1015: invokespecial 1037	org/json/JSONArray:<init>	()V
    //   1018: astore 22
    //   1020: iconst_0
    //   1021: istore 8
    //   1023: aload 17
    //   1025: astore_2
    //   1026: iload 8
    //   1028: getstatic 53	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1031: invokeinterface 1008 1 0
    //   1036: if_icmpge +239 -> 1275
    //   1039: aload 17
    //   1041: astore_2
    //   1042: new 171	org/json/JSONObject
    //   1045: dup
    //   1046: invokespecial 758	org/json/JSONObject:<init>	()V
    //   1049: astore 23
    //   1051: aload 17
    //   1053: astore_2
    //   1054: aload 23
    //   1056: ldc_w 1039
    //   1059: getstatic 53	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1062: iload 8
    //   1064: invokeinterface 1025 2 0
    //   1069: invokevirtual 765	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1072: pop
    //   1073: aload 17
    //   1075: astore_2
    //   1076: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:c	Ljava/util/HashMap;
    //   1079: getstatic 53	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1082: iload 8
    //   1084: invokeinterface 1025 2 0
    //   1089: invokevirtual 403	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1092: ifnull +99 -> 1191
    //   1095: aload 17
    //   1097: astore_2
    //   1098: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1101: ifeq +42 -> 1143
    //   1104: aload 17
    //   1106: astore_2
    //   1107: ldc 230
    //   1109: iconst_2
    //   1110: new 310	java/lang/StringBuilder
    //   1113: dup
    //   1114: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1117: ldc_w 1041
    //   1120: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:c	Ljava/util/HashMap;
    //   1126: aload 7
    //   1128: getfield 998	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1131: invokevirtual 403	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1134: invokevirtual 950	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1137: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1140: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1143: aload 17
    //   1145: astore_2
    //   1146: aload 23
    //   1148: ldc_w 1043
    //   1151: getstatic 57	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:c	Ljava/util/HashMap;
    //   1154: getstatic 53	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1157: iload 8
    //   1159: invokeinterface 1025 2 0
    //   1164: invokevirtual 403	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1167: invokevirtual 765	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1170: pop
    //   1171: aload 17
    //   1173: astore_2
    //   1174: aload 22
    //   1176: aload 23
    //   1178: invokevirtual 1046	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1181: pop
    //   1182: iload 8
    //   1184: iconst_1
    //   1185: iadd
    //   1186: istore 8
    //   1188: goto -165 -> 1023
    //   1191: aload 17
    //   1193: astore_2
    //   1194: aload 23
    //   1196: ldc_w 1043
    //   1199: iconst_0
    //   1200: invokevirtual 1049	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1203: pop
    //   1204: goto -33 -> 1171
    //   1207: astore 7
    //   1209: aload 17
    //   1211: astore 6
    //   1213: aload 6
    //   1215: astore_2
    //   1216: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1219: ifeq +36 -> 1255
    //   1222: aload 6
    //   1224: astore_2
    //   1225: ldc 230
    //   1227: iconst_2
    //   1228: new 310	java/lang/StringBuilder
    //   1231: dup
    //   1232: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1235: ldc_w 1051
    //   1238: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: aload 7
    //   1243: invokestatic 1013	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1246: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1252: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1255: aload 6
    //   1257: ifnull +363 -> 1620
    //   1260: aload 6
    //   1262: invokevirtual 1009	java/io/RandomAccessFile:close	()V
    //   1265: ldc_w 1053
    //   1268: astore_2
    //   1269: iconst_0
    //   1270: istore 8
    //   1272: goto -1159 -> 113
    //   1275: aload 17
    //   1277: astore_2
    //   1278: aload 21
    //   1280: ldc_w 1055
    //   1283: iconst_0
    //   1284: invokevirtual 1049	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1287: pop
    //   1288: aload 17
    //   1290: astore_2
    //   1291: aload 21
    //   1293: ldc_w 1057
    //   1296: aload 22
    //   1298: invokevirtual 765	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1301: pop
    //   1302: aload 17
    //   1304: astore_2
    //   1305: aload_0
    //   1306: aload 21
    //   1308: invokevirtual 774	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1311: invokevirtual 1059	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/lang/String;)V
    //   1314: aload 17
    //   1316: astore_2
    //   1317: ldc2_w 792
    //   1320: lload 11
    //   1322: ladd
    //   1323: lload 15
    //   1325: invokestatic 799	java/lang/Math:min	(JJ)J
    //   1328: lstore 9
    //   1330: lload 11
    //   1332: lload 15
    //   1334: lcmp
    //   1335: iflt +301 -> 1636
    //   1338: iconst_0
    //   1339: istore 8
    //   1341: goto -413 -> 928
    //   1344: aload 17
    //   1346: astore_2
    //   1347: ldc 230
    //   1349: iconst_1
    //   1350: new 310	java/lang/StringBuilder
    //   1353: dup
    //   1354: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1357: ldc_w 1061
    //   1360: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: aload 20
    //   1365: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: ldc_w 1063
    //   1371: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: aload 6
    //   1376: getfield 816	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   1379: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1382: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1385: invokestatic 585	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1388: iconst_0
    //   1389: istore 8
    //   1391: goto -421 -> 970
    //   1394: astore_2
    //   1395: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1398: ifeq +13 -> 1411
    //   1401: ldc 230
    //   1403: iconst_2
    //   1404: aload_2
    //   1405: invokestatic 1013	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1408: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1411: aload 6
    //   1413: astore_2
    //   1414: goto -1301 -> 113
    //   1417: astore_2
    //   1418: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1421: ifeq +13 -> 1434
    //   1424: ldc 230
    //   1426: iconst_2
    //   1427: aload_2
    //   1428: invokestatic 1013	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1431: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1434: ldc_w 1053
    //   1437: astore_2
    //   1438: iconst_0
    //   1439: istore 8
    //   1441: goto -1328 -> 113
    //   1444: astore_1
    //   1445: aconst_null
    //   1446: astore_2
    //   1447: aload_2
    //   1448: ifnull +7 -> 1455
    //   1451: aload_2
    //   1452: invokevirtual 1009	java/io/RandomAccessFile:close	()V
    //   1455: aload_1
    //   1456: athrow
    //   1457: astore_2
    //   1458: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1461: ifeq -6 -> 1455
    //   1464: ldc 230
    //   1466: iconst_2
    //   1467: aload_2
    //   1468: invokestatic 1013	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1471: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1474: goto -19 -> 1455
    //   1477: aload 4
    //   1479: invokevirtual 910	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1482: astore 4
    //   1484: ldc 230
    //   1486: iconst_1
    //   1487: new 310	java/lang/StringBuilder
    //   1490: dup
    //   1491: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1494: ldc_w 1065
    //   1497: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: aload_2
    //   1501: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: ldc_w 1067
    //   1507: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: aload 5
    //   1512: ldc_w 906
    //   1515: invokeinterface 909 2 0
    //   1520: checkcast 399	java/lang/String
    //   1523: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: ldc_w 1069
    //   1529: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: aload 4
    //   1534: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1540: invokestatic 632	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1543: aload_3
    //   1544: invokevirtual 1070	java/io/BufferedReader:close	()V
    //   1547: aload_1
    //   1548: ifnull -1068 -> 480
    //   1551: aload_1
    //   1552: invokevirtual 953	java/net/HttpURLConnection:disconnect	()V
    //   1555: return
    //   1556: astore_2
    //   1557: aload 6
    //   1559: astore_1
    //   1560: aload_1
    //   1561: ifnull +7 -> 1568
    //   1564: aload_1
    //   1565: invokevirtual 953	java/net/HttpURLConnection:disconnect	()V
    //   1568: aload_2
    //   1569: athrow
    //   1570: ldc 230
    //   1572: iconst_1
    //   1573: new 310	java/lang/StringBuilder
    //   1576: dup
    //   1577: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1580: ldc_w 1072
    //   1583: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1586: aload_2
    //   1587: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1593: invokestatic 585	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1596: return
    //   1597: astore_2
    //   1598: goto -38 -> 1560
    //   1601: astore_2
    //   1602: aload 7
    //   1604: astore_1
    //   1605: goto -1162 -> 443
    //   1608: astore_1
    //   1609: goto -162 -> 1447
    //   1612: astore 7
    //   1614: aconst_null
    //   1615: astore 6
    //   1617: goto -404 -> 1213
    //   1620: ldc_w 1053
    //   1623: astore_2
    //   1624: iconst_0
    //   1625: istore 8
    //   1627: goto -1514 -> 113
    //   1630: aload 6
    //   1632: astore_2
    //   1633: goto -1520 -> 113
    //   1636: goto -1022 -> 614
    //   1639: ldc_w 1053
    //   1642: astore_2
    //   1643: iconst_0
    //   1644: istore 8
    //   1646: goto -1533 -> 113
    //   1649: iconst_1
    //   1650: istore 8
    //   1652: goto -724 -> 928
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1655	0	this	HealthBusinessPlugin
    //   0	1655	1	paramString1	String
    //   0	1655	2	paramString2	String
    //   0	1655	3	paramString3	String
    //   0	1655	4	paramString4	String
    //   0	1655	5	paramMap	java.util.Map<String, String>
    //   0	1655	6	paramBundle	Bundle
    //   0	1655	7	paramUploadThread	HealthBusinessPlugin.UploadThread
    //   111	1540	8	j	int
    //   38	1291	9	l1	long
    //   612	719	11	l2	long
    //   3	953	13	l3	long
    //   28	1305	15	l4	long
    //   609	736	17	localRandomAccessFile	java.io.RandomAccessFile
    //   497	141	18	arrayOfByte1	byte[]
    //   503	137	19	arrayOfByte2	byte[]
    //   549	815	20	str	String
    //   1006	301	21	localJSONObject1	JSONObject
    //   1018	279	22	localJSONArray	JSONArray
    //   1049	146	23	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   139	414	442	java/lang/Exception
    //   414	420	442	java/lang/Exception
    //   425	439	442	java/lang/Exception
    //   1477	1547	442	java/lang/Exception
    //   785	790	791	java/io/IOException
    //   625	634	1207	java/lang/Exception
    //   637	656	1207	java/lang/Exception
    //   659	667	1207	java/lang/Exception
    //   670	676	1207	java/lang/Exception
    //   679	688	1207	java/lang/Exception
    //   691	705	1207	java/lang/Exception
    //   708	720	1207	java/lang/Exception
    //   723	735	1207	java/lang/Exception
    //   738	744	1207	java/lang/Exception
    //   747	780	1207	java/lang/Exception
    //   812	818	1207	java/lang/Exception
    //   821	891	1207	java/lang/Exception
    //   894	916	1207	java/lang/Exception
    //   936	967	1207	java/lang/Exception
    //   973	980	1207	java/lang/Exception
    //   999	1008	1207	java/lang/Exception
    //   1011	1020	1207	java/lang/Exception
    //   1026	1039	1207	java/lang/Exception
    //   1042	1051	1207	java/lang/Exception
    //   1054	1073	1207	java/lang/Exception
    //   1076	1095	1207	java/lang/Exception
    //   1098	1104	1207	java/lang/Exception
    //   1107	1143	1207	java/lang/Exception
    //   1146	1171	1207	java/lang/Exception
    //   1174	1182	1207	java/lang/Exception
    //   1194	1204	1207	java/lang/Exception
    //   1278	1288	1207	java/lang/Exception
    //   1291	1302	1207	java/lang/Exception
    //   1305	1314	1207	java/lang/Exception
    //   1317	1330	1207	java/lang/Exception
    //   1347	1388	1207	java/lang/Exception
    //   985	990	1394	java/io/IOException
    //   1260	1265	1417	java/io/IOException
    //   598	611	1444	finally
    //   1451	1455	1457	java/io/IOException
    //   124	139	1556	finally
    //   446	472	1556	finally
    //   139	414	1597	finally
    //   414	420	1597	finally
    //   425	439	1597	finally
    //   1477	1547	1597	finally
    //   124	139	1601	java/lang/Exception
    //   625	634	1608	finally
    //   637	656	1608	finally
    //   659	667	1608	finally
    //   670	676	1608	finally
    //   679	688	1608	finally
    //   691	705	1608	finally
    //   708	720	1608	finally
    //   723	735	1608	finally
    //   738	744	1608	finally
    //   747	780	1608	finally
    //   812	818	1608	finally
    //   821	891	1608	finally
    //   894	916	1608	finally
    //   936	967	1608	finally
    //   973	980	1608	finally
    //   999	1008	1608	finally
    //   1011	1020	1608	finally
    //   1026	1039	1608	finally
    //   1042	1051	1608	finally
    //   1054	1073	1608	finally
    //   1076	1095	1608	finally
    //   1098	1104	1608	finally
    //   1107	1143	1608	finally
    //   1146	1171	1608	finally
    //   1174	1182	1608	finally
    //   1194	1204	1608	finally
    //   1216	1222	1608	finally
    //   1225	1255	1608	finally
    //   1278	1288	1608	finally
    //   1291	1302	1608	finally
    //   1305	1314	1608	finally
    //   1317	1330	1608	finally
    //   1347	1388	1608	finally
    //   598	611	1612	java/lang/Exception
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
      if (this.jdField_d_of_type_JavaUtilHashMap != null)
      {
        if ("".equals(paramJSONObject))
        {
          paramJSONObject = this.jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
          while (paramJSONObject.hasNext())
          {
            localObject = (String)paramJSONObject.next();
            if (((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject)).getCurrentPositionMs() >= 3L) {
              this.h.put(localObject, Long.valueOf(((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject)).getCurrentPositionMs()));
            }
            QLog.d("HealthBusinessPlugin", 1, "time to upload:" + ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject)).getCurrentPositionMs());
            ReportController.b(null, "dc00899", "yundong", "", "yundong_shipin", "", 0, 0, String.valueOf((int)(((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject)).getCurrentPositionMs() / 1000L)), "", (String)localObject, "");
            this.h.remove(localObject);
            ((Timer)this.g.get(localObject)).cancel();
            FrameLayout localFrameLayout = (FrameLayout)this.e.get(localObject);
            ((ViewGroup)localFrameLayout.getParent()).removeView(localFrameLayout);
            this.e.remove(localObject);
            this.f.remove(localObject);
            this.g.remove(localObject);
            this.h.remove(localObject);
          }
          this.jdField_d_of_type_JavaUtilHashMap.clear();
          return 0;
        }
        if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramJSONObject)) {
          return -3;
        }
        if (((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJSONObject)).getCurrentPositionMs() >= 3L) {
          this.h.put(paramJSONObject, Long.valueOf(((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJSONObject)).getCurrentPositionMs()));
        }
        QLog.d("HealthBusinessPlugin", 1, "time to upload:" + String.valueOf((int)(((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJSONObject)).getCurrentPositionMs() / 1000L)));
        ReportController.b(null, "dc00899", "yundong", "", "yundong_shipin", "", 0, 0, String.valueOf((int)(((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJSONObject)).getCurrentPositionMs() / 1000L)), "", paramJSONObject, "");
        this.h.remove(paramJSONObject);
        ((Timer)this.g.get(paramJSONObject)).cancel();
        localObject = (FrameLayout)this.e.get(paramJSONObject);
        ((ViewGroup)((FrameLayout)localObject).getParent()).removeView((View)localObject);
        this.jdField_d_of_type_JavaUtilHashMap.remove(paramJSONObject);
        this.e.remove(paramJSONObject);
        this.f.remove(paramJSONObject);
        this.g.remove(paramJSONObject);
        this.h.remove(paramJSONObject);
        return 0;
      }
      if (this.jdField_b_of_type_AndroidOsHandler != null)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_b_of_type_AndroidOsHandler = null;
      }
    }
    return -6;
  }
  
  int c(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_Boolean = false;
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
      if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramJSONObject)) {
        return -3;
      }
      Iterator localIterator = this.jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ImageView localImageView = (ImageView)((FrameLayout)this.e.get(str)).findViewById(2131374812);
        if (str.equals(paramJSONObject)) {
          ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJSONObject)).start();
        }
        for (;;)
        {
          localImageView.setVisibility(4);
          break;
          ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJSONObject)).pause();
        }
      }
    }
    return 0;
  }
  
  int d(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_Boolean = true;
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
      if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramJSONObject)) {
        return -3;
      }
      localImageView = (ImageView)((FrameLayout)this.e.get(paramJSONObject)).findViewById(2131374812);
      localImageView.setImageResource(2130849563);
      localImageView.setVisibility(0);
      ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJSONObject)).pause();
      this.jdField_a_of_type_Boolean = true;
    }
    return 0;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8L;
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if ((!this.mRuntime.a().getUrl().contains("qq.com")) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return null;
      if ((paramLong == 8L) && ((paramString.startsWith("http://qqsport/")) || (paramString.startsWith("https://qqsport/"))) && (paramString.length() > 16))
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
    int k;
    int j;
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
        k = paramJsBridgeListener.optInt("maxSelect");
        int m = paramJsBridgeListener.optInt("min_width", 200);
        int n = paramJsBridgeListener.optInt("min_height", 200);
        int i1 = paramJsBridgeListener.optInt("max_gif_size", 8388608);
        int i2 = paramJsBridgeListener.optInt("opType", 0);
        paramJsBridgeListener = new ArrayList();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis() / 1000L);
        }
        for (;;)
        {
          this.jdField_b_of_type_JavaLangString = paramString2;
          j = k;
          if (k == 0) {
            j = 6;
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
            j = 0;
            while (j < paramString1.length())
            {
              paramJsBridgeListener.add(paramString1.getString(j));
              j += 1;
            }
          }
        }
        if (i2 == 0)
        {
          paramString3 = new Intent();
          paramString3.setClass(paramString2, NewPhotoListActivity.class);
          paramString3.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramJsBridgeListener);
          paramString3.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString2.getClass().getName());
          paramString3.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          paramString3.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
          paramString3.putExtra("PhotoConst.MAXUM_SELECTED_NUM", j);
          paramString3.getExtras().remove("forward_type");
          paramString3.putExtra("album_enter_directly", true);
          paramString3.putExtra("ALBUM_ID", AlbumUtil.sLastAlbumId);
          paramString3.putExtra("ALBUM_NAME", AlbumUtil.sLastAlbumName);
          paramString1 = this.mRuntime.a().getAccount();
          paramJsBridgeListener = paramString1;
          if (paramString1 == null) {
            paramJsBridgeListener = "";
          }
          paramString3.putExtra("PhotoConst.MY_UIN", paramJsBridgeListener);
          paramString3.putExtra("from_health", true);
          paramString3.putExtra("enter_from", 46);
          paramString3.putExtra("min_height", n);
          paramString3.putExtra("min_width", m);
          paramString3.putExtra("max_gif_size", i1);
          startActivityForResult(paramString3, (byte)1);
          AlbumUtil.anim(paramString2, false, true);
        }
        else if (i2 == 1)
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
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          paramString1 = this.mRuntime.a();
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramString1, paramString1.getResources().getDimensionPixelSize(2131299166));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693940);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        ThreadManager.post(new HealthBusinessPlugin.2(this, paramJsBridgeListener, paramString2), 5, null, true);
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
          break label3028;
        }
        paramVarArgs = paramString1.getString((String)localObject1, null);
        paramString3 = new JSONArray();
        if (!TextUtils.isEmpty(paramVarArgs))
        {
          paramVarArgs = new JSONObject(paramVarArgs);
          localObject2 = paramVarArgs.getJSONArray("imgList");
          j = 0;
          if (j < ((JSONArray)localObject2).length())
          {
            if (paramJsBridgeListener.equals(((JSONArray)localObject2).getString(j))) {
              break label3030;
            }
            paramString3.put(((JSONArray)localObject2).getString(j));
            break label3030;
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
        paramString3 = paramJsBridgeListener.optString("tag", HardCodeUtil.a(2131705467));
        paramJsBridgeListener = paramJsBridgeListener.optString("cat", HardCodeUtil.a(2131705468));
        paramVarArgs = this.mRuntime.a().getApplication().getSharedPreferences("groupid_feedid", 0).edit();
        paramVarArgs.putString((String)localObject1, paramString1);
        paramVarArgs.commit();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramString1))) {
          break label3039;
        }
        if (jdField_a_of_type_JavaUtilList.contains(localObject1))
        {
          if (!QLog.isColorLevel()) {
            break label3041;
          }
          QLog.i("HealthBusinessPlugin", 2, "group enqueued.");
          break label3041;
        }
        jdField_a_of_type_JavaUtilList.add(localObject1);
        localObject2 = a().getString((String)localObject1, null);
        paramVarArgs = new ArrayList();
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
          j = 0;
          label1196:
          if (j < paramString2.length())
          {
            localObject2 = paramString2.getString(j);
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).startsWith("http")) || (((String)localObject2).equals("error"))) {
              break label3043;
            }
            paramVarArgs.add(paramString2.getString(j));
            break label3043;
          }
        }
        else
        {
          paramVarArgs.add(paramString2.getString("video_dir"));
        }
        if ((this.mRuntime.a() instanceof BaseActivity))
        {
          paramJsBridgeListener = new HealthBusinessPlugin.UploadThread(this, (BaseActivity)this.mRuntime.a(), paramVarArgs, paramString1, (String)localObject1, bool, paramString3, paramJsBridgeListener);
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
          break label3075;
        }
        j = 1;
        break label3052;
        label1489:
        if ((k & j) == 0) {
          break label3063;
        }
        paramJsBridgeListener.edit().remove((String)localObject1).commit();
        break label3063;
        label1519:
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
          break label3094;
        }
        paramJsBridgeListener = a().getString((String)localObject1, null);
        if (paramJsBridgeListener == null) {
          return true;
        }
        ThreadManager.post(new HealthBusinessPlugin.3(this, paramJsBridgeListener, paramString2), 5, null, true);
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
        j = 0;
        while (j < jdField_a_of_type_JavaUtilList.size())
        {
          paramString3 = new JSONObject();
          paramString3.put("groupID", jdField_a_of_type_JavaUtilList.get(j));
          paramString3.put("feedID", this.mRuntime.a().getApplication().getSharedPreferences("groupid_feedid", 0).getString((String)jdField_a_of_type_JavaUtilList.get(j), ""));
          paramVarArgs = (String)jdField_a_of_type_JavaUtilList.get(j);
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
          j += 1;
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
            jdField_a_of_type_JavaUtilList.remove(paramJsBridgeListener.jdField_b_of_type_JavaLangString);
            c.remove(paramJsBridgeListener.jdField_b_of_type_JavaLangString);
            jdField_b_of_type_JavaUtilHashMap.remove(paramJsBridgeListener.jdField_b_of_type_JavaLangString);
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
          paramString1 = new JSONObject();
          paramString1.put("retCode", a(paramJsBridgeListener));
          callJs(paramString2, new String[] { paramString1.toString() });
        }
        else if ("pluckVideo".equals(paramString3))
        {
          paramString1 = new JSONObject();
          paramString1.put("retCode", b(paramJsBridgeListener));
          callJs(paramString2, new String[] { paramString1.toString() });
        }
        else if ("playVideo".equals(paramString3))
        {
          paramString1 = new JSONObject();
          paramString1.put("retCode", c(paramJsBridgeListener));
          callJs(paramString2, new String[] { paramString1.toString() });
        }
        else if ("pauseVideo".equals(paramString3))
        {
          paramString1 = new JSONObject();
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
          if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramJsBridgeListener))
          {
            paramString1.put("retCode", -3);
            callJs(paramString2, new String[] { paramString1.toString() });
            return false;
          }
          ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJsBridgeListener)).stop();
          paramString1.put("retCode", 0);
          callJs(paramString2, new String[] { paramString1.toString() });
        }
        else if ("wifiStatus".equals(paramString3))
        {
          paramJsBridgeListener = new JSONObject();
          paramString1 = ((ConnectivityManager)this.mRuntime.a().getSystemService("connectivity")).getNetworkInfo(1);
          if ((paramString1 == null) || (paramString1.getState() == NetworkInfo.State.DISCONNECTED)) {
            break label3096;
          }
        }
      }
    }
    label3075:
    label3081:
    label3087:
    label3094:
    label3096:
    for (boolean bool = true;; bool = false)
    {
      paramJsBridgeListener.put("retCode", bool);
      callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      break label3026;
      bool = "followUin".equals(paramString3);
      if (bool) {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("uin");
          paramString1 = paramString1.optString("callback");
          paramString2 = new NewIntent(this.mRuntime.a().getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
          PublicAccountEventReport.a(paramJsBridgeListener);
          paramString2.putExtra("cmd", "PubAccountFollowSvc.follow");
          paramString3 = new mobileqq_mp.FollowRequest();
          paramString3.uin.set((int)Long.parseLong(paramJsBridgeListener));
          paramString3.type.set(-1);
          paramString3.ext.set(String.valueOf(0));
          paramString2.setObserver(new HealthBusinessPlugin.4(this, paramString1));
          paramString2.putExtra("data", paramString3.toByteArray());
          this.mRuntime.a().startServlet(paramString2);
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("HealthBusinessPlugin", 1, "[followUin] error=", paramJsBridgeListener);
        }
      }
      label3026:
      return true;
      label3028:
      return true;
      label3030:
      j += 1;
      break;
      label3039:
      return true;
      label3041:
      return true;
      label3043:
      j += 1;
      break label1196;
      for (;;)
      {
        label3052:
        if (localObject1 == null) {
          break label3081;
        }
        k = 1;
        break;
        label3063:
        if (!bool) {
          break label3087;
        }
        paramJsBridgeListener = "success.";
        break label1519;
        j = 0;
      }
      k = 0;
      break label1489;
      paramJsBridgeListener = "group not found.";
      break label1519;
      return true;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 1) {
      if (paramInt == -1)
      {
        paramIntent = paramIntent.getStringArrayListExtra("img_list");
        if (paramIntent != null) {}
      }
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
            {
              QLog.e("HealthBusinessPlugin", 1, "miss id parameter!");
              return;
            }
            if (this.mRuntime != null) {
              a(paramIntent);
            }
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("group_id", this.jdField_a_of_type_JavaLangString);
              super.callJs(this.jdField_b_of_type_JavaLangString, new String[] { ((JSONObject)localObject1).toString() });
              if (this.mRuntime != null)
              {
                ThreadManager.post(new HealthBusinessPlugin.5(this, paramIntent), 5, null, true);
                return;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("HealthBusinessPlugin", 1, localException, new Object[0]);
              }
            }
          }
        } while (paramInt != 16);
        paramIntent = paramIntent.getStringArrayListExtra("img_list");
        if ((paramIntent != null) && (!paramIntent.isEmpty())) {
          a(paramIntent);
        }
        a();
        return;
        if (paramByte == 2)
        {
          if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
          {
            QLog.e("HealthBusinessPlugin", 1, "value miss!");
            return;
          }
          localObject2 = new JSONObject();
          SharedPreferences localSharedPreferences;
          if (paramInt == -1) {
            if ((this.mRuntime != null) && (this.mRuntime.a() != null))
            {
              paramIntent = this.mRuntime.a().getApplicationContext();
              localObject3 = ImageUtil.b(paramIntent, this.jdField_a_of_type_AndroidNetUri);
              ImageUtil.a(paramIntent, (String)localObject3);
              localSharedPreferences = a();
              localObject1 = localSharedPreferences.getString(this.jdField_a_of_type_JavaLangString, null);
            }
          }
          for (;;)
          {
            try
            {
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              paramIntent = new JSONObject();
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              localObject1 = new JSONArray();
              ((JSONArray)localObject1).put(localObject3);
              paramIntent.put("imgList", localObject1);
              localSharedPreferences.edit().putString(this.jdField_a_of_type_JavaLangString, paramIntent.toString()).commit();
              ((JSONObject)localObject2).put("group_id", this.jdField_a_of_type_JavaLangString);
              ((JSONObject)localObject2).put("msg", "ok");
            }
            catch (Exception paramIntent)
            {
              QLog.e("HealthBusinessPlugin", 1, paramIntent, new Object[0]);
              continue;
            }
            if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
              break;
            }
            super.callJs(this.jdField_b_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
            return;
            paramIntent = new JSONObject((String)localObject1);
            continue;
            localObject1 = paramIntent.getJSONArray("imgList");
            continue;
            try
            {
              ((JSONObject)localObject2).put("msg", "cancel");
            }
            catch (Exception paramIntent)
            {
              QLog.e("HealthBusinessPlugin", 1, paramIntent, new Object[0]);
            }
          }
        }
      } while ((paramByte != 3) || (paramInt != 1));
      localObject1 = paramIntent.getStringExtra("video_dir");
      paramIntent = paramIntent.getStringExtra("thumb_dir");
      localObject2 = String.valueOf(System.currentTimeMillis() / 1000L);
    } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    for (;;)
    {
      try
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("group_id", localObject2);
        super.callJs(this.jdField_b_of_type_JavaLangString, new String[] { ((JSONObject)localObject3).toString() });
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("video_dir", localObject1);
        if (!TextUtils.isEmpty(paramIntent))
        {
          ((JSONObject)localObject3).put("thumb_dir", paramIntent);
          a().edit().putString((String)localObject2, ((JSONObject)localObject3).toString()).commit();
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("HealthBusinessPlugin", 1, paramIntent, new Object[0]);
        return;
      }
      QLog.e("HealthBusinessPlugin", 1, "video thumb path miss!");
    }
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "oncreated ......");
    }
    super.onCreate();
    if (!QQVideoPlaySDKManager.a()) {
      QQVideoPlaySDKManager.a(BaseApplicationImpl.getApplication(), null);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
    this.jdField_a_of_type_ComTencentBizUiRefreshView.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$MyNetInfoHandler);
    QLog.d("HealthBusinessPlugin", 1, "onDestroy");
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    paramCustomWebView = new FrameLayout.LayoutParams(-1, -1);
    paramCustomWebView.topMargin = 0;
    paramCustomWebView.leftMargin = 0;
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.mRuntime.a().findViewById(2131381873));
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "videoLayout id:" + this.jdField_a_of_type_ComTencentBizUiRefreshView.getResources());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.mRuntime.a());
    this.jdField_a_of_type_ComTencentBizUiRefreshView.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramCustomWebView);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)this.mRuntime.a());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.scrollBy(0, this.jdField_a_of_type_ComTencentBizUiTouchWebView.mTotalYoffset);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListenerForBiz(new HealthBusinessPlugin.1(this));
    QLog.d("HealthBusinessPlugin", 1, "onWebViewCreated");
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$MyNetInfoHandler = new HealthBusinessPlugin.MyNetInfoHandler(this, this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.mRuntime.a(), this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$MyNetInfoHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin
 * JD-Core Version:    0.7.0.1
 */