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
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
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
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
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
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
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
  static HashMap<String, Double> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  int jdField_a_of_type_Int;
  Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  Uri jdField_a_of_type_AndroidNetUri;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
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
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
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
  }
  
  public HealthBusinessPlugin()
  {
    this.e = new HashMap();
    this.f = new HashMap();
    this.g = new HashMap();
    this.h = new HashMap();
    this.mPluginNameSpace = "healthSport";
  }
  
  public static String a(String paramString, int paramInt)
  {
    paramString = new CompressInfo(paramString, paramInt, 1035);
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(paramString);
    return paramString.e;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, new Object[] { "report  Click On HealthBusinessPluginFollow , UIN=", paramString });
    }
    ThreadManagerV2.executeOnSubThread(new HealthBusinessPlugin.5(paramString));
  }
  
  private boolean a(Activity paramActivity, String paramString)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (paramActivity.checkSelfPermission(paramString) != 0) && ((paramActivity instanceof AppActivity)))
    {
      ((AppActivity)paramActivity).requestPermissions(new HealthBusinessPlugin.7(this, paramString, paramActivity), 3, new String[] { paramString });
      return false;
    }
    return true;
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
    Object localObject2 = this.mRuntime.a();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar((Context)localObject2);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(((Context)localObject2).getResources().getDrawable(2130840492));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
    try
    {
      d2 = paramJSONObject.getDouble("top");
      d3 = paramJSONObject.getDouble("left");
      d1 = paramJSONObject.getDouble("width");
      d4 = paramJSONObject.getDouble("height");
      localObject1 = paramJSONObject.getString("vid");
      localObject3 = this.mRuntime.a().getResources().getDisplayMetrics();
    }
    catch (Exception paramJSONObject)
    {
      double d2;
      double d3;
      double d1;
      double d4;
      Object localObject1;
      Object localObject3;
      int j;
      int m;
      int n;
      int k;
      label144:
      label155:
      label162:
      label165:
      label168:
      float f1;
      double d5;
      Object localObject6;
      Object localObject5;
      Object localObject4;
      Object localObject7;
      FrameLayout localFrameLayout;
      break label1465;
    }
    try
    {
      j = paramJSONObject.optInt("needCheckWiFi");
    }
    catch (Exception paramJSONObject)
    {
      break label162;
    }
    try
    {
      m = paramJSONObject.optInt("needMute");
    }
    catch (Exception paramJSONObject)
    {
      break label155;
    }
    try
    {
      n = paramJSONObject.optInt("needCountdown");
      k = j;
      j = n;
    }
    catch (Exception paramJSONObject)
    {
      break label144;
    }
    k = j;
    j = m;
    break label168;
    k = j;
    break label165;
    k = 1;
    j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "optional Err");
    }
    n = 1;
    m = j;
    j = n;
    if ((NetworkUtil.isWifiConnected((Context)localObject2)) && (k == 1)) {
      return -5;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "addView Function");
    }
    f1 = this.mRuntime.a().getResources().getDisplayMetrics().density;
    d5 = f1;
    Double.isNaN(d5);
    k = (int)(d1 * d5);
    Double.isNaN(d5);
    localObject6 = new FrameLayout.LayoutParams(k, (int)(d4 * d5));
    Double.isNaN(d5);
    ((FrameLayout.LayoutParams)localObject6).topMargin = ((int)(d2 * d5));
    Double.isNaN(d5);
    ((FrameLayout.LayoutParams)localObject6).leftMargin = ((int)(d3 * d5));
    if ((d1 != 0.0D) && (d4 != 0.0D))
    {
      if (this.jdField_d_of_type_JavaUtilHashMap.containsKey(localObject1)) {
        return -2;
      }
      if (this.jdField_d_of_type_JavaUtilHashMap.size() == 3) {
        return -4;
      }
      paramJSONObject = SuperPlayerFactory.createPlayerVideoView(this.mRuntime.a());
      localObject5 = SuperPlayerFactory.createMediaPlayer(this.mRuntime.a(), 117, paramJSONObject);
      ((ISuperPlayer)localObject5).setLoopback(false);
      this.jdField_a_of_type_JavaLangRunnable = new HealthBusinessPlugin.8(this);
      this.jdField_b_of_type_JavaLangRunnable = new HealthBusinessPlugin.9(this);
      a((ISuperPlayer)localObject5);
      localObject4 = SuperPlayerFactory.createVideoInfoForTVideo(4080303, (String)localObject1);
      ((ISuperPlayer)localObject5).openMediaPlayer(this.mRuntime.a(), (SuperPlayerVideoInfo)localObject4, 0L);
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("sDensity:");
        ((StringBuilder)localObject4).append(f1);
        QLog.d("HealthBusinessPlugin", 2, ((StringBuilder)localObject4).toString());
      }
      localObject7 = (FrameLayout)LayoutInflater.from((Context)localObject2).inflate(2131560395, null);
      localObject4 = new HealthBusinessPlugin.SportVideoLayoutHolder();
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((FrameLayout)localObject7).findViewById(2131374357));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((FrameLayout)localObject7).findViewById(2131374356));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)localObject7).findViewById(2131374355));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)localObject7).findViewById(2131374358));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)((FrameLayout)localObject7).findViewById(2131377124));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)localObject7).findViewById(2131374359));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((FrameLayout)localObject7).findViewById(2131374354));
      localFrameLayout = new FrameLayout((Context)localObject2);
      localFrameLayout.addView((View)paramJSONObject);
      localFrameLayout.addView((View)localObject7);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject6);
      this.e.put(localObject1, localFrameLayout);
      this.f.put(localObject1, localObject4);
      if (this.jdField_d_of_type_JavaUtilHashMap == null) {
        this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
      }
      localObject6 = this.jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (String)((Iterator)localObject6).next();
        ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject7)).pause();
      }
      this.jdField_d_of_type_JavaUtilHashMap.put(localObject1, localObject5);
      this.h.put(localObject1, Long.valueOf(0L));
      this.jdField_b_of_type_AndroidOsHandler = new Handler();
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      if (m == 0)
      {
        ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject1)).setOutputMute(false);
        ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(((Context)localObject2).getResources().getDrawable(2130846615));
      }
      else
      {
        ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject1)).setOutputMute(true);
        ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(((Context)localObject2).getResources().getDrawable(2130846614));
      }
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new HealthBusinessPlugin.10(this, (String)localObject1, (Context)localObject2));
      new FrameLayout.LayoutParams(ViewUtils.a(45.0F), ViewUtils.a(43.0F)).gravity = 85;
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new HealthBusinessPlugin.11(this, (String)localObject1, (HealthBusinessPlugin.SportVideoLayoutHolder)localObject4));
      k = this.mRuntime.a().getResources().getDisplayMetrics().widthPixels;
      d2 = ((DisplayMetrics)localObject3).density;
      Double.isNaN(d2);
      m = (int)(d2 * d1 * 0.7D);
      d2 = ((DisplayMetrics)localObject3).density;
      Double.isNaN(d2);
      n = (int)(d1 * d2 * 0.15D);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("screen width:");
      ((StringBuilder)localObject2).append((k - 200) / 2);
      QLog.d("HealthBusinessPlugin", 1, ((StringBuilder)localObject2).toString());
      localObject2 = new FrameLayout.LayoutParams(m, ViewUtils.a(20.0F));
      localObject3 = new FrameLayout.LayoutParams(n, ViewUtils.a(20.0F));
      localObject5 = new FrameLayout.LayoutParams(n, ViewUtils.a(20.0F));
      localObject6 = new FrameLayout.LayoutParams(ViewUtils.a(60.0F), ViewUtils.a(60.0F));
      ((FrameLayout.LayoutParams)localObject2).gravity = 81;
      ((FrameLayout.LayoutParams)localObject3).gravity = 83;
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout.LayoutParams)localObject6).gravity = 17;
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setTimeTextForTextView(((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView, ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject1)).getCurrentPositionMs());
      localFrameLayout.setBackgroundColor(-16777216);
      localFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetProgressBar, (ViewGroup.LayoutParams)localObject6);
      if (QLog.isColorLevel()) {
        QLog.d("HealthBusinessPlugin", 2, "add seekbar");
      }
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_d_of_type_Boolean = false;
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new HealthBusinessPlugin.12(this));
      new FrameLayout.LayoutParams(-2, ViewUtils.a(43.0F)).gravity = 85;
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setTimeTextForTextView(((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_a_of_type_AndroidWidgetTextView, ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject1)).getDurationMs());
      if (j == 1) {
        ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      } else {
        ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      a(((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_a_of_type_AndroidWidgetTextView, (String)localObject1, ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView, ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_c_of_type_AndroidWidgetTextView, ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_a_of_type_AndroidWidgetSeekBar);
      localObject1 = new HealthBusinessPlugin.13(this);
      this.mRuntime.a().setOnTouchListener((View.OnTouchListener)localObject1);
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new HealthBusinessPlugin.14(this, (HealthBusinessPlugin.SportVideoLayoutHolder)localObject4, paramJSONObject, localFrameLayout));
      return 0;
    }
    return -1;
    label1465:
    QLog.d("HealthBusinessPlugin", 1, "AddView Err:");
    return -6;
  }
  
  SharedPreferences a()
  {
    Object localObject2 = this.mRuntime.a().getAccount();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "nologin";
    }
    localObject2 = this.mRuntime.a().getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("_health");
    return ((MobileQQ)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  void a()
  {
    if (QavCameraUsage.b(this.mRuntime.a())) {
      return;
    }
    Object localObject2 = new File(AppConstants.SDCARD_IMG_SAVE);
    int j;
    if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs())) {
      j = 0;
    } else {
      j = 1;
    }
    Intent localIntent = null;
    Object localObject1 = null;
    if ((j != 0) && (((File)localObject2).canWrite()))
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
      {
        if (this.mRuntime != null) {
          localObject1 = this.mRuntime.a();
        }
        if ((localObject1 != null) && (!((Activity)localObject1).isFinishing()))
        {
          localIntent = new Intent();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(AppConstants.SDCARD_IMG_SAVE);
          ((StringBuilder)localObject2).append(System.currentTimeMillis());
          ((StringBuilder)localObject2).append(".jpg");
          this.jdField_a_of_type_AndroidNetUri = FileProvider7Helper.setSystemCapture((Context)localObject1, new File(((StringBuilder)localObject2).toString()), localIntent);
          startActivityForResult(localIntent, (byte)2);
        }
      }
      else
      {
        QLog.e("HealthBusinessPlugin", 1, "temp ids lost!");
      }
    }
    else
    {
      if (this.mRuntime == null) {
        localObject1 = localIntent;
      } else {
        localObject1 = this.mRuntime.a();
      }
      if ((localObject1 != null) && (!((Activity)localObject1).isFinishing())) {
        QQToast.a((Context)localObject1, 2131696274, 1).b(((QBaseActivity)localObject1).getTitleBarHeight());
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.i("HealthBusinessPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (!a(this.mRuntime.a(), "android.permission.CAMERA")) {
      return;
    }
    if (QavCameraUsage.b(this.mRuntime.a())) {
      return;
    }
    if (!Utils.a())
    {
      ToastUtil.a().a(2131718574);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("shortvideo/");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".mp4");
    this.jdField_c_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new Intent("android.media.action.VIDEO_CAPTURE");
    ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 1);
    File localFile = new File(this.jdField_c_of_type_JavaLangString);
    localFile.getParentFile().mkdirs();
    ((Intent)localObject).putExtra("output", Uri.fromFile(localFile));
    ((Intent)localObject).putExtra("android.intent.extra.durationLimit", paramInt2);
    ((Intent)localObject).putExtra("android.intent.extra.sizeLimit", paramInt3);
    ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_gzh_health");
    FileProvider7Helper.intentCompatForN(this.mRuntime.a(), (Intent)localObject);
    startActivityForResult((Intent)localObject, (byte)3);
  }
  
  void a(TextView paramTextView1, String paramString, TextView paramTextView2, TextView paramTextView3, SeekBar paramSeekBar)
  {
    if (paramTextView1 == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
      if (localRunnable != null) {
        ((Handler)localObject).post(localRunnable);
      }
    }
    paramTextView1 = new WeakReference(paramTextView1);
    localObject = new Timer();
    ((Timer)localObject).schedule(new HealthBusinessPlugin.17(this, paramTextView1, paramString, paramTextView2, paramTextView3, paramSeekBar), 0L, 1000L);
    this.g.put(paramString, localObject);
  }
  
  void a(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer.setOnVideoPreparedListener(new HealthBusinessPlugin.15(this));
    paramISuperPlayer.setOnCompletionListener(new HealthBusinessPlugin.16(this));
  }
  
  /* Error */
  void a(String paramString1, String paramString2, String paramString3, String paramString4, java.util.Map<String, String> paramMap, android.os.Bundle paramBundle, HealthBusinessPlugin.UploadThread paramUploadThread)
  {
    // Byte code:
    //   0: ldc_w 764
    //   3: astore 26
    //   5: invokestatic 620	java/lang/System:currentTimeMillis	()J
    //   8: lstore 14
    //   10: aload 6
    //   12: aload_3
    //   13: aload 4
    //   15: ldc_w 766
    //   18: invokestatic 771	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp;
    //   21: astore 23
    //   23: aload 23
    //   25: ifnull +1264 -> 1289
    //   28: aload_2
    //   29: invokestatic 777	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   32: lstore 20
    //   34: lload 20
    //   36: ldc2_w 778
    //   39: invokestatic 785	java/lang/Math:min	(JJ)J
    //   42: lstore 18
    //   44: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +63 -> 110
    //   50: new 354	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   57: astore 6
    //   59: aload 6
    //   61: ldc_w 787
    //   64: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 6
    //   70: aload 23
    //   72: getfield 791	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:h	Ljava/lang/String;
    //   75: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 6
    //   81: ldc_w 793
    //   84: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 6
    //   90: aload 23
    //   92: getfield 795	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:d	Ljava/lang/String;
    //   95: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: ldc 124
    //   101: iconst_2
    //   102: aload 6
    //   104: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: ldc_w 797
    //   113: aload 23
    //   115: getfield 791	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:h	Ljava/lang/String;
    //   118: invokevirtual 800	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: ifeq +20 -> 141
    //   124: aload 23
    //   126: getfield 802	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:f	Ljava/lang/String;
    //   129: astore_2
    //   130: ldc_w 764
    //   133: astore 7
    //   135: iconst_1
    //   136: istore 13
    //   138: goto +1163 -> 1301
    //   141: aload 23
    //   143: getfield 802	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:f	Ljava/lang/String;
    //   146: ifnull +1143 -> 1289
    //   149: aload 23
    //   151: getfield 803	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   154: invokestatic 809	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   157: astore 25
    //   159: aload_2
    //   160: invokestatic 813	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil:d	(Ljava/lang/String;)[B
    //   163: astore 24
    //   165: new 354	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   172: astore 6
    //   174: aload 6
    //   176: ldc_w 815
    //   179: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 6
    //   185: aload 23
    //   187: getfield 816	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 6
    //   196: ldc_w 818
    //   199: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 6
    //   205: aload 23
    //   207: getfield 819	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   210: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 6
    //   216: ldc_w 821
    //   219: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 6
    //   225: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore 27
    //   230: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +63 -> 296
    //   236: new 354	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   243: astore 6
    //   245: aload 6
    //   247: ldc_w 823
    //   250: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 6
    //   256: aload 27
    //   258: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 6
    //   264: ldc_w 825
    //   267: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 6
    //   273: aload 23
    //   275: getfield 802	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:f	Ljava/lang/String;
    //   278: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: ldc 124
    //   284: iconst_2
    //   285: aload 6
    //   287: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: goto +3 -> 296
    //   296: new 827	java/io/RandomAccessFile
    //   299: dup
    //   300: aload_2
    //   301: ldc_w 829
    //   304: invokespecial 832	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: astore_2
    //   308: lconst_0
    //   309: lstore 16
    //   311: aload 26
    //   313: astore 6
    //   315: lload 18
    //   317: lload 16
    //   319: lsub
    //   320: l2i
    //   321: istore 12
    //   323: aload_0
    //   324: getfield 200	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   327: invokevirtual 205	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   330: invokestatic 837	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   333: ifeq +1699 -> 2032
    //   336: aload 25
    //   338: aload 24
    //   340: aload 27
    //   342: lload 20
    //   344: aload_2
    //   345: lload 16
    //   347: iload 12
    //   349: invokestatic 840	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   352: lstore 16
    //   354: aload 7
    //   356: getfield 843	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_Boolean	Z
    //   359: istore 22
    //   361: iload 22
    //   363: ifeq +137 -> 500
    //   366: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   369: ifeq +12 -> 381
    //   372: ldc 124
    //   374: iconst_2
    //   375: ldc_w 845
    //   378: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: getstatic 51	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   384: aload 7
    //   386: getfield 846	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   389: invokeinterface 851 2 0
    //   394: pop
    //   395: getstatic 55	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   398: aload 7
    //   400: getfield 846	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   403: invokevirtual 853	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   406: pop
    //   407: getstatic 53	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   410: aload 7
    //   412: getfield 846	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   415: invokevirtual 853	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   418: pop
    //   419: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +46 -> 468
    //   425: new 354	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   432: astore 7
    //   434: aload 7
    //   436: ldc_w 855
    //   439: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 7
    //   445: getstatic 51	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   448: invokeinterface 856 1 0
    //   453: invokevirtual 504	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: ldc 124
    //   459: iconst_2
    //   460: aload 7
    //   462: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aload_2
    //   469: invokevirtual 859	java/io/RandomAccessFile:close	()V
    //   472: return
    //   473: astore_1
    //   474: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +13 -> 490
    //   480: ldc 124
    //   482: iconst_2
    //   483: aload_1
    //   484: invokestatic 863	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   487: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: return
    //   491: astore_1
    //   492: goto +767 -> 1259
    //   495: astore 7
    //   497: goto +668 -> 1165
    //   500: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +1520 -> 2023
    //   506: new 354	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   513: astore 26
    //   515: aload 26
    //   517: ldc_w 865
    //   520: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: lload 16
    //   526: l2d
    //   527: dstore 8
    //   529: lload 20
    //   531: l2d
    //   532: dstore 10
    //   534: dload 8
    //   536: invokestatic 294	java/lang/Double:isNaN	(D)Z
    //   539: pop
    //   540: dload 10
    //   542: invokestatic 294	java/lang/Double:isNaN	(D)Z
    //   545: pop
    //   546: dload 8
    //   548: dload 10
    //   550: ddiv
    //   551: dstore 8
    //   553: aload 26
    //   555: dload 8
    //   557: invokevirtual 868	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 26
    //   563: ldc_w 870
    //   566: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 26
    //   572: getstatic 51	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   575: invokeinterface 856 1 0
    //   580: invokevirtual 504	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 26
    //   586: ldc_w 872
    //   589: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload 26
    //   595: getstatic 51	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   598: iconst_0
    //   599: invokeinterface 875 2 0
    //   604: checkcast 162	java/lang/String
    //   607: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: ldc 124
    //   613: iconst_2
    //   614: aload 26
    //   616: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: goto +3 -> 625
    //   625: getstatic 55	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   628: astore 26
    //   630: aload 7
    //   632: getfield 846	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   635: astore 28
    //   637: lload 16
    //   639: l2d
    //   640: dstore 8
    //   642: lload 20
    //   644: l2d
    //   645: dstore 10
    //   647: dload 8
    //   649: invokestatic 294	java/lang/Double:isNaN	(D)Z
    //   652: pop
    //   653: dload 10
    //   655: invokestatic 294	java/lang/Double:isNaN	(D)Z
    //   658: pop
    //   659: dload 8
    //   661: dload 10
    //   663: ddiv
    //   664: dstore 8
    //   666: aload 26
    //   668: aload 28
    //   670: dload 8
    //   672: invokestatic 878	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   675: invokevirtual 434	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   678: pop
    //   679: lload 16
    //   681: ldc2_w 879
    //   684: lcmp
    //   685: ifne +6 -> 691
    //   688: goto +1344 -> 2032
    //   691: new 239	org/json/JSONObject
    //   694: dup
    //   695: invokespecial 881	org/json/JSONObject:<init>	()V
    //   698: astore 26
    //   700: new 883	org/json/JSONArray
    //   703: dup
    //   704: invokespecial 884	org/json/JSONArray:<init>	()V
    //   707: astore 28
    //   709: iconst_0
    //   710: istore 12
    //   712: iload 12
    //   714: getstatic 51	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   717: invokeinterface 856 1 0
    //   722: if_icmpge +164 -> 886
    //   725: new 239	org/json/JSONObject
    //   728: dup
    //   729: invokespecial 881	org/json/JSONObject:<init>	()V
    //   732: astore 29
    //   734: aload 29
    //   736: ldc_w 886
    //   739: getstatic 51	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   742: iload 12
    //   744: invokeinterface 875 2 0
    //   749: invokevirtual 889	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   752: pop
    //   753: getstatic 55	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   756: getstatic 51	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   759: iload 12
    //   761: invokeinterface 875 2 0
    //   766: invokevirtual 445	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   769: astore 30
    //   771: aload 30
    //   773: ifnull +86 -> 859
    //   776: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq +1247 -> 2026
    //   782: new 354	java/lang/StringBuilder
    //   785: dup
    //   786: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   789: astore 30
    //   791: aload 30
    //   793: ldc_w 891
    //   796: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: pop
    //   800: aload 30
    //   802: getstatic 55	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   805: aload 7
    //   807: getfield 846	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   810: invokevirtual 445	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   813: invokevirtual 894	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: ldc 124
    //   819: iconst_2
    //   820: aload 30
    //   822: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   828: goto +3 -> 831
    //   831: aload 29
    //   833: ldc_w 896
    //   836: getstatic 55	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   839: getstatic 51	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   842: iload 12
    //   844: invokeinterface 875 2 0
    //   849: invokevirtual 445	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   852: invokevirtual 889	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   855: pop
    //   856: goto +13 -> 869
    //   859: aload 29
    //   861: ldc_w 896
    //   864: iconst_0
    //   865: invokevirtual 899	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   868: pop
    //   869: aload 28
    //   871: aload 29
    //   873: invokevirtual 902	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   876: pop
    //   877: iload 12
    //   879: iconst_1
    //   880: iadd
    //   881: istore 12
    //   883: goto -171 -> 712
    //   886: aload 26
    //   888: ldc_w 904
    //   891: iconst_0
    //   892: invokevirtual 899	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   895: pop
    //   896: aload 26
    //   898: ldc_w 906
    //   901: aload 28
    //   903: invokevirtual 889	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   906: pop
    //   907: aload_0
    //   908: aload 26
    //   910: invokevirtual 907	org/json/JSONObject:toString	()Ljava/lang/String;
    //   913: invokevirtual 909	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:b	(Ljava/lang/String;)V
    //   916: lload 16
    //   918: ldc2_w 778
    //   921: ladd
    //   922: lload 20
    //   924: invokestatic 785	java/lang/Math:min	(JJ)J
    //   927: lstore 18
    //   929: lload 16
    //   931: lload 20
    //   933: lcmp
    //   934: iflt +1095 -> 2029
    //   937: iconst_0
    //   938: istore 12
    //   940: aload 23
    //   942: astore 7
    //   944: goto +3 -> 947
    //   947: aload 6
    //   949: astore 23
    //   951: iload 12
    //   953: ifne +50 -> 1003
    //   956: new 354	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   963: astore 24
    //   965: aload 24
    //   967: ldc_w 911
    //   970: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: aload 24
    //   976: invokestatic 620	java/lang/System:currentTimeMillis	()J
    //   979: lload 14
    //   981: lsub
    //   982: invokevirtual 623	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   985: pop
    //   986: ldc 124
    //   988: iconst_1
    //   989: aload 24
    //   991: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   994: invokestatic 660	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   997: iconst_1
    //   998: istore 12
    //   1000: goto +63 -> 1063
    //   1003: new 354	java/lang/StringBuilder
    //   1006: dup
    //   1007: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   1010: astore 24
    //   1012: aload 24
    //   1014: ldc_w 913
    //   1017: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: aload 24
    //   1023: aload 27
    //   1025: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: aload 24
    //   1031: ldc_w 915
    //   1034: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: pop
    //   1038: aload 24
    //   1040: aload 7
    //   1042: getfield 802	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:f	Ljava/lang/String;
    //   1045: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: ldc 124
    //   1051: iconst_1
    //   1052: aload 24
    //   1054: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: invokestatic 641	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1060: iconst_0
    //   1061: istore 12
    //   1063: aload 7
    //   1065: getfield 802	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:f	Ljava/lang/String;
    //   1068: astore 24
    //   1070: aload_2
    //   1071: invokevirtual 859	java/io/RandomAccessFile:close	()V
    //   1074: iload 12
    //   1076: istore 13
    //   1078: aload 24
    //   1080: astore_2
    //   1081: aload 23
    //   1083: astore 7
    //   1085: goto +216 -> 1301
    //   1088: astore 6
    //   1090: iload 12
    //   1092: istore 13
    //   1094: aload 24
    //   1096: astore_2
    //   1097: aload 23
    //   1099: astore 7
    //   1101: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1104: ifeq +197 -> 1301
    //   1107: ldc 124
    //   1109: iconst_2
    //   1110: aload 6
    //   1112: invokestatic 863	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1115: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1118: iload 12
    //   1120: istore 13
    //   1122: aload 24
    //   1124: astore_2
    //   1125: aload 23
    //   1127: astore 7
    //   1129: goto +172 -> 1301
    //   1132: astore_1
    //   1133: goto +9 -> 1142
    //   1136: astore 7
    //   1138: goto +9 -> 1147
    //   1141: astore_1
    //   1142: goto +117 -> 1259
    //   1145: astore 7
    //   1147: goto +18 -> 1165
    //   1150: astore_1
    //   1151: aconst_null
    //   1152: astore_2
    //   1153: goto +106 -> 1259
    //   1156: astore 7
    //   1158: ldc_w 764
    //   1161: astore 6
    //   1163: aconst_null
    //   1164: astore_2
    //   1165: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1168: ifeq +43 -> 1211
    //   1171: new 354	java/lang/StringBuilder
    //   1174: dup
    //   1175: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   1178: astore 23
    //   1180: aload 23
    //   1182: ldc_w 917
    //   1185: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: pop
    //   1189: aload 23
    //   1191: aload 7
    //   1193: invokestatic 863	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1196: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: pop
    //   1200: ldc 124
    //   1202: iconst_2
    //   1203: aload 23
    //   1205: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1211: aload 6
    //   1213: astore 7
    //   1215: aload_2
    //   1216: ifnull +78 -> 1294
    //   1219: aload_2
    //   1220: invokevirtual 859	java/io/RandomAccessFile:close	()V
    //   1223: aload 6
    //   1225: astore 7
    //   1227: goto +67 -> 1294
    //   1230: astore_2
    //   1231: aload 6
    //   1233: astore 7
    //   1235: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1238: ifeq +56 -> 1294
    //   1241: ldc 124
    //   1243: iconst_2
    //   1244: aload_2
    //   1245: invokestatic 863	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1248: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1251: aload 6
    //   1253: astore 7
    //   1255: goto +39 -> 1294
    //   1258: astore_1
    //   1259: aload_2
    //   1260: ifnull +27 -> 1287
    //   1263: aload_2
    //   1264: invokevirtual 859	java/io/RandomAccessFile:close	()V
    //   1267: goto +20 -> 1287
    //   1270: astore_2
    //   1271: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1274: ifeq +13 -> 1287
    //   1277: ldc 124
    //   1279: iconst_2
    //   1280: aload_2
    //   1281: invokestatic 863	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1284: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1287: aload_1
    //   1288: athrow
    //   1289: ldc_w 764
    //   1292: astore 7
    //   1294: ldc_w 919
    //   1297: astore_2
    //   1298: iconst_0
    //   1299: istore 13
    //   1301: iload 13
    //   1303: ifeq +687 -> 1990
    //   1306: new 921	java/net/URL
    //   1309: dup
    //   1310: aload_1
    //   1311: invokespecial 922	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1314: invokevirtual 926	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1317: checkcast 928	java/net/HttpURLConnection
    //   1320: astore_1
    //   1321: aload_1
    //   1322: astore 6
    //   1324: aload_1
    //   1325: sipush 5000
    //   1328: invokevirtual 931	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1331: aload_1
    //   1332: astore 6
    //   1334: aload_1
    //   1335: sipush 30000
    //   1338: invokevirtual 934	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1341: aload_1
    //   1342: astore 6
    //   1344: aload_1
    //   1345: iconst_1
    //   1346: invokevirtual 937	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1349: aload_1
    //   1350: astore 6
    //   1352: aload_1
    //   1353: iconst_1
    //   1354: invokevirtual 940	java/net/HttpURLConnection:setDoInput	(Z)V
    //   1357: aload_1
    //   1358: astore 6
    //   1360: aload_1
    //   1361: iconst_0
    //   1362: invokevirtual 943	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   1365: aload_1
    //   1366: astore 6
    //   1368: aload_1
    //   1369: ldc_w 945
    //   1372: invokevirtual 948	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1375: aload_1
    //   1376: astore 6
    //   1378: aload_1
    //   1379: ldc_w 950
    //   1382: ldc_w 952
    //   1385: invokevirtual 955	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1388: aload_1
    //   1389: astore 6
    //   1391: new 354	java/lang/StringBuilder
    //   1394: dup
    //   1395: ldc_w 957
    //   1398: invokespecial 958	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1401: astore 23
    //   1403: aload_1
    //   1404: astore 6
    //   1406: aload 23
    //   1408: aload 7
    //   1410: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: pop
    //   1414: aload_1
    //   1415: astore 6
    //   1417: aload 23
    //   1419: getstatic 961	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   1422: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: pop
    //   1426: aload_1
    //   1427: astore 6
    //   1429: aload 23
    //   1431: aload 7
    //   1433: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: pop
    //   1437: aload_1
    //   1438: astore 6
    //   1440: aload 23
    //   1442: getstatic 966	android/os/Build:DEVICE	Ljava/lang/String;
    //   1445: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: pop
    //   1449: aload_1
    //   1450: astore 6
    //   1452: aload 23
    //   1454: aload 7
    //   1456: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: aload_1
    //   1461: astore 6
    //   1463: aload 23
    //   1465: getstatic 969	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   1468: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: pop
    //   1472: aload_1
    //   1473: astore 6
    //   1475: aload 23
    //   1477: aload 7
    //   1479: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1482: pop
    //   1483: aload_1
    //   1484: astore 6
    //   1486: aload 23
    //   1488: ldc_w 971
    //   1491: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: pop
    //   1495: aload_1
    //   1496: astore 6
    //   1498: aload_1
    //   1499: ldc_w 973
    //   1502: aload 23
    //   1504: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1507: invokevirtual 955	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1510: aload_1
    //   1511: astore 6
    //   1513: aload_1
    //   1514: ldc_w 975
    //   1517: ldc_w 977
    //   1520: invokevirtual 955	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1523: aload_1
    //   1524: astore 6
    //   1526: new 354	java/lang/StringBuilder
    //   1529: dup
    //   1530: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   1533: astore 7
    //   1535: aload_1
    //   1536: astore 6
    //   1538: aload 7
    //   1540: ldc_w 979
    //   1543: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: pop
    //   1547: aload_1
    //   1548: astore 6
    //   1550: aload 7
    //   1552: aload_3
    //   1553: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: pop
    //   1557: aload_1
    //   1558: astore 6
    //   1560: aload 7
    //   1562: ldc_w 981
    //   1565: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: pop
    //   1569: aload_1
    //   1570: astore 6
    //   1572: aload 7
    //   1574: aload 4
    //   1576: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1579: pop
    //   1580: aload_1
    //   1581: astore 6
    //   1583: aload_1
    //   1584: ldc_w 983
    //   1587: aload 7
    //   1589: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1592: invokevirtual 955	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1595: aload_1
    //   1596: astore 6
    //   1598: new 985	java/io/DataOutputStream
    //   1601: dup
    //   1602: aload_1
    //   1603: invokevirtual 989	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1606: invokespecial 992	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1609: astore_3
    //   1610: aload_1
    //   1611: astore 6
    //   1613: new 994	java/lang/StringBuffer
    //   1616: dup
    //   1617: invokespecial 995	java/lang/StringBuffer:<init>	()V
    //   1620: astore 4
    //   1622: aload_1
    //   1623: astore 6
    //   1625: aload 4
    //   1627: ldc_w 997
    //   1630: invokevirtual 1000	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1633: pop
    //   1634: aload_1
    //   1635: astore 6
    //   1637: aload 4
    //   1639: aload_2
    //   1640: invokevirtual 1000	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1643: pop
    //   1644: aload_1
    //   1645: astore 6
    //   1647: aload 4
    //   1649: ldc_w 1002
    //   1652: invokevirtual 1000	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1655: pop
    //   1656: aload_1
    //   1657: astore 6
    //   1659: aload 4
    //   1661: aload 5
    //   1663: ldc_w 1004
    //   1666: invokeinterface 1007 2 0
    //   1671: checkcast 162	java/lang/String
    //   1674: invokevirtual 1000	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1677: pop
    //   1678: aload_1
    //   1679: astore 6
    //   1681: aload_3
    //   1682: aload 4
    //   1684: invokevirtual 1008	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1687: invokevirtual 1012	java/lang/String:getBytes	()[B
    //   1690: invokevirtual 1018	java/io/OutputStream:write	([B)V
    //   1693: aload_1
    //   1694: astore 6
    //   1696: aload_3
    //   1697: invokevirtual 1021	java/io/OutputStream:flush	()V
    //   1700: aload_1
    //   1701: astore 6
    //   1703: aload_3
    //   1704: invokevirtual 1022	java/io/OutputStream:close	()V
    //   1707: aload_1
    //   1708: astore 6
    //   1710: new 994	java/lang/StringBuffer
    //   1713: dup
    //   1714: invokespecial 995	java/lang/StringBuffer:<init>	()V
    //   1717: astore 4
    //   1719: aload_1
    //   1720: astore 6
    //   1722: new 1024	java/io/BufferedReader
    //   1725: dup
    //   1726: new 1026	java/io/InputStreamReader
    //   1729: dup
    //   1730: aload_1
    //   1731: invokevirtual 1030	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1734: invokespecial 1033	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1737: invokespecial 1036	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1740: astore_3
    //   1741: aload_1
    //   1742: astore 6
    //   1744: aload_3
    //   1745: invokevirtual 1039	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1748: astore 7
    //   1750: aload 7
    //   1752: ifnull +29 -> 1781
    //   1755: aload_1
    //   1756: astore 6
    //   1758: aload 4
    //   1760: aload 7
    //   1762: invokevirtual 1000	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1765: pop
    //   1766: aload_1
    //   1767: astore 6
    //   1769: aload 4
    //   1771: ldc_w 1041
    //   1774: invokevirtual 1000	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1777: pop
    //   1778: goto -37 -> 1741
    //   1781: aload_1
    //   1782: astore 6
    //   1784: aload 4
    //   1786: invokevirtual 1008	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1789: astore 4
    //   1791: aload_1
    //   1792: astore 6
    //   1794: new 354	java/lang/StringBuilder
    //   1797: dup
    //   1798: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   1801: astore 7
    //   1803: aload_1
    //   1804: astore 6
    //   1806: aload 7
    //   1808: ldc_w 1043
    //   1811: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: pop
    //   1815: aload_1
    //   1816: astore 6
    //   1818: aload 7
    //   1820: aload_2
    //   1821: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: pop
    //   1825: aload_1
    //   1826: astore 6
    //   1828: aload 7
    //   1830: ldc_w 1045
    //   1833: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: pop
    //   1837: aload_1
    //   1838: astore 6
    //   1840: aload 7
    //   1842: aload 5
    //   1844: ldc_w 1004
    //   1847: invokeinterface 1007 2 0
    //   1852: checkcast 162	java/lang/String
    //   1855: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1858: pop
    //   1859: aload_1
    //   1860: astore 6
    //   1862: aload 7
    //   1864: ldc_w 1047
    //   1867: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1870: pop
    //   1871: aload_1
    //   1872: astore 6
    //   1874: aload 7
    //   1876: aload 4
    //   1878: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1881: pop
    //   1882: aload_1
    //   1883: astore 6
    //   1885: ldc 124
    //   1887: iconst_1
    //   1888: aload 7
    //   1890: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1893: invokestatic 660	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1896: aload_1
    //   1897: astore 6
    //   1899: aload_3
    //   1900: invokevirtual 1048	java/io/BufferedReader:close	()V
    //   1903: aload_1
    //   1904: ifnull +118 -> 2022
    //   1907: goto +65 -> 1972
    //   1910: astore_2
    //   1911: goto +13 -> 1924
    //   1914: astore_1
    //   1915: aconst_null
    //   1916: astore 6
    //   1918: goto +60 -> 1978
    //   1921: astore_2
    //   1922: aconst_null
    //   1923: astore_1
    //   1924: aload_1
    //   1925: astore 6
    //   1927: new 354	java/lang/StringBuilder
    //   1930: dup
    //   1931: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   1934: astore_3
    //   1935: aload_1
    //   1936: astore 6
    //   1938: aload_3
    //   1939: ldc_w 1050
    //   1942: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1945: pop
    //   1946: aload_1
    //   1947: astore 6
    //   1949: aload_3
    //   1950: aload_2
    //   1951: invokevirtual 894	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1954: pop
    //   1955: aload_1
    //   1956: astore 6
    //   1958: ldc 124
    //   1960: iconst_2
    //   1961: aload_3
    //   1962: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1965: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1968: aload_1
    //   1969: ifnull +53 -> 2022
    //   1972: aload_1
    //   1973: invokevirtual 1053	java/net/HttpURLConnection:disconnect	()V
    //   1976: return
    //   1977: astore_1
    //   1978: aload 6
    //   1980: ifnull +8 -> 1988
    //   1983: aload 6
    //   1985: invokevirtual 1053	java/net/HttpURLConnection:disconnect	()V
    //   1988: aload_1
    //   1989: athrow
    //   1990: new 354	java/lang/StringBuilder
    //   1993: dup
    //   1994: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   1997: astore_1
    //   1998: aload_1
    //   1999: ldc_w 1055
    //   2002: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2005: pop
    //   2006: aload_1
    //   2007: aload_2
    //   2008: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: pop
    //   2012: ldc 124
    //   2014: iconst_1
    //   2015: aload_1
    //   2016: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2019: invokestatic 641	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2022: return
    //   2023: goto -1398 -> 625
    //   2026: goto -1195 -> 831
    //   2029: goto -1714 -> 315
    //   2032: aload 23
    //   2034: astore 7
    //   2036: iconst_1
    //   2037: istore 12
    //   2039: goto -1092 -> 947
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2042	0	this	HealthBusinessPlugin
    //   0	2042	1	paramString1	String
    //   0	2042	2	paramString2	String
    //   0	2042	3	paramString3	String
    //   0	2042	4	paramString4	String
    //   0	2042	5	paramMap	java.util.Map<String, String>
    //   0	2042	6	paramBundle	android.os.Bundle
    //   0	2042	7	paramUploadThread	HealthBusinessPlugin.UploadThread
    //   527	144	8	d1	double
    //   532	130	10	d2	double
    //   321	1717	12	j	int
    //   136	1166	13	k	int
    //   8	972	14	l1	long
    //   309	621	16	l2	long
    //   42	886	18	l3	long
    //   32	900	20	l4	long
    //   359	3	22	bool	boolean
    //   21	2012	23	localObject1	Object
    //   163	960	24	localObject2	Object
    //   157	180	25	arrayOfByte	byte[]
    //   3	906	26	localObject3	Object
    //   228	796	27	str	String
    //   635	267	28	localObject4	Object
    //   732	140	29	localJSONObject	JSONObject
    //   769	52	30	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   468	472	473	java/io/IOException
    //   366	381	491	finally
    //   381	468	491	finally
    //   366	381	495	java/lang/Exception
    //   381	468	495	java/lang/Exception
    //   1070	1074	1088	java/io/IOException
    //   553	622	1132	finally
    //   625	637	1132	finally
    //   666	679	1132	finally
    //   691	709	1132	finally
    //   712	771	1132	finally
    //   776	828	1132	finally
    //   831	856	1132	finally
    //   859	869	1132	finally
    //   869	877	1132	finally
    //   886	929	1132	finally
    //   956	997	1132	finally
    //   1003	1060	1132	finally
    //   1063	1070	1132	finally
    //   553	622	1136	java/lang/Exception
    //   625	637	1136	java/lang/Exception
    //   666	679	1136	java/lang/Exception
    //   691	709	1136	java/lang/Exception
    //   712	771	1136	java/lang/Exception
    //   776	828	1136	java/lang/Exception
    //   831	856	1136	java/lang/Exception
    //   859	869	1136	java/lang/Exception
    //   869	877	1136	java/lang/Exception
    //   886	929	1136	java/lang/Exception
    //   956	997	1136	java/lang/Exception
    //   1003	1060	1136	java/lang/Exception
    //   1063	1070	1136	java/lang/Exception
    //   323	361	1141	finally
    //   500	524	1141	finally
    //   323	361	1145	java/lang/Exception
    //   500	524	1145	java/lang/Exception
    //   296	308	1150	finally
    //   296	308	1156	java/lang/Exception
    //   1219	1223	1230	java/io/IOException
    //   1165	1211	1258	finally
    //   1263	1267	1270	java/io/IOException
    //   1324	1331	1910	java/lang/Exception
    //   1334	1341	1910	java/lang/Exception
    //   1344	1349	1910	java/lang/Exception
    //   1352	1357	1910	java/lang/Exception
    //   1360	1365	1910	java/lang/Exception
    //   1368	1375	1910	java/lang/Exception
    //   1378	1388	1910	java/lang/Exception
    //   1391	1403	1910	java/lang/Exception
    //   1406	1414	1910	java/lang/Exception
    //   1417	1426	1910	java/lang/Exception
    //   1429	1437	1910	java/lang/Exception
    //   1440	1449	1910	java/lang/Exception
    //   1452	1460	1910	java/lang/Exception
    //   1463	1472	1910	java/lang/Exception
    //   1475	1483	1910	java/lang/Exception
    //   1486	1495	1910	java/lang/Exception
    //   1498	1510	1910	java/lang/Exception
    //   1513	1523	1910	java/lang/Exception
    //   1526	1535	1910	java/lang/Exception
    //   1538	1547	1910	java/lang/Exception
    //   1550	1557	1910	java/lang/Exception
    //   1560	1569	1910	java/lang/Exception
    //   1572	1580	1910	java/lang/Exception
    //   1583	1595	1910	java/lang/Exception
    //   1598	1610	1910	java/lang/Exception
    //   1613	1622	1910	java/lang/Exception
    //   1625	1634	1910	java/lang/Exception
    //   1637	1644	1910	java/lang/Exception
    //   1647	1656	1910	java/lang/Exception
    //   1659	1678	1910	java/lang/Exception
    //   1681	1693	1910	java/lang/Exception
    //   1696	1700	1910	java/lang/Exception
    //   1703	1707	1910	java/lang/Exception
    //   1710	1719	1910	java/lang/Exception
    //   1722	1741	1910	java/lang/Exception
    //   1744	1750	1910	java/lang/Exception
    //   1758	1766	1910	java/lang/Exception
    //   1769	1778	1910	java/lang/Exception
    //   1784	1791	1910	java/lang/Exception
    //   1794	1803	1910	java/lang/Exception
    //   1806	1815	1910	java/lang/Exception
    //   1818	1825	1910	java/lang/Exception
    //   1828	1837	1910	java/lang/Exception
    //   1840	1859	1910	java/lang/Exception
    //   1862	1871	1910	java/lang/Exception
    //   1874	1882	1910	java/lang/Exception
    //   1885	1896	1910	java/lang/Exception
    //   1899	1903	1910	java/lang/Exception
    //   1306	1321	1914	finally
    //   1306	1321	1921	java/lang/Exception
    //   1324	1331	1977	finally
    //   1334	1341	1977	finally
    //   1344	1349	1977	finally
    //   1352	1357	1977	finally
    //   1360	1365	1977	finally
    //   1368	1375	1977	finally
    //   1378	1388	1977	finally
    //   1391	1403	1977	finally
    //   1406	1414	1977	finally
    //   1417	1426	1977	finally
    //   1429	1437	1977	finally
    //   1440	1449	1977	finally
    //   1452	1460	1977	finally
    //   1463	1472	1977	finally
    //   1475	1483	1977	finally
    //   1486	1495	1977	finally
    //   1498	1510	1977	finally
    //   1513	1523	1977	finally
    //   1526	1535	1977	finally
    //   1538	1547	1977	finally
    //   1550	1557	1977	finally
    //   1560	1569	1977	finally
    //   1572	1580	1977	finally
    //   1583	1595	1977	finally
    //   1598	1610	1977	finally
    //   1613	1622	1977	finally
    //   1625	1634	1977	finally
    //   1637	1644	1977	finally
    //   1647	1656	1977	finally
    //   1659	1678	1977	finally
    //   1681	1693	1977	finally
    //   1696	1700	1977	finally
    //   1703	1707	1977	finally
    //   1710	1719	1977	finally
    //   1722	1741	1977	finally
    //   1744	1750	1977	finally
    //   1758	1766	1977	finally
    //   1769	1778	1977	finally
    //   1784	1791	1977	finally
    //   1794	1803	1977	finally
    //   1806	1815	1977	finally
    //   1818	1825	1977	finally
    //   1828	1837	1977	finally
    //   1840	1859	1977	finally
    //   1862	1871	1977	finally
    //   1874	1882	1977	finally
    //   1885	1896	1977	finally
    //   1899	1903	1977	finally
    //   1927	1935	1977	finally
    //   1938	1946	1977	finally
    //   1949	1955	1977	finally
    //   1958	1968	1977	finally
  }
  
  void a(List<String> paramList)
  {
    SharedPreferences localSharedPreferences = a();
    Object localObject = localSharedPreferences.getString(this.jdField_a_of_type_JavaLangString, null);
    if (localObject == null) {}
    try
    {
      localObject = new JSONObject();
      break label41;
      localObject = new JSONObject((String)localObject);
      label41:
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str)) {
          localJSONArray.put(str);
        }
      }
      ((JSONObject)localObject).put("imgList", localJSONArray);
      localSharedPreferences.edit().putString(this.jdField_a_of_type_JavaLangString, ((JSONObject)localObject).toString()).commit();
      return;
    }
    catch (Exception paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HealthBusinessPlugin", 2, paramList, new Object[0]);
      }
    }
  }
  
  int b(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "Video pluck...");
    }
    Object localObject1;
    try
    {
      paramJSONObject = paramJSONObject.optString("vid");
    }
    catch (Exception paramJSONObject)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pluckVideo Err:");
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      QLog.d("HealthBusinessPlugin", 1, ((StringBuilder)localObject1).toString());
      paramJSONObject = null;
    }
    if (paramJSONObject == null) {
      return -1;
    }
    if (this.jdField_d_of_type_JavaUtilHashMap != null)
    {
      if ("".equals(paramJSONObject))
      {
        paramJSONObject = this.jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
        while (paramJSONObject.hasNext())
        {
          localObject1 = (String)paramJSONObject.next();
          if (((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject1)).getCurrentPositionMs() >= 3L) {
            this.h.put(localObject1, Long.valueOf(((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject1)).getCurrentPositionMs()));
          }
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("time to upload:");
          ((StringBuilder)localObject2).append(((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject1)).getCurrentPositionMs());
          QLog.d("HealthBusinessPlugin", 1, ((StringBuilder)localObject2).toString());
          ReportController.b(null, "dc00899", "yundong", "", "yundong_shipin", "", 0, 0, String.valueOf((int)(((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(localObject1)).getCurrentPositionMs() / 1000L)), "", (String)localObject1, "");
          this.h.remove(localObject1);
          ((Timer)this.g.get(localObject1)).cancel();
          localObject2 = (FrameLayout)this.e.get(localObject1);
          ((ViewGroup)((FrameLayout)localObject2).getParent()).removeView((View)localObject2);
          this.e.remove(localObject1);
          this.f.remove(localObject1);
          this.g.remove(localObject1);
          this.h.remove(localObject1);
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("time to upload:");
      ((StringBuilder)localObject1).append(String.valueOf((int)(((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJSONObject)).getCurrentPositionMs() / 1000L)));
      QLog.d("HealthBusinessPlugin", 1, ((StringBuilder)localObject1).toString());
      ReportController.b(null, "dc00899", "yundong", "", "yundong_shipin", "", 0, 0, String.valueOf((int)(((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJSONObject)).getCurrentPositionMs() / 1000L)), "", paramJSONObject, "");
      this.h.remove(paramJSONObject);
      ((Timer)this.g.get(paramJSONObject)).cancel();
      localObject1 = (FrameLayout)this.e.get(paramJSONObject);
      ((ViewGroup)((FrameLayout)localObject1).getParent()).removeView((View)localObject1);
      this.jdField_d_of_type_JavaUtilHashMap.remove(paramJSONObject);
      this.e.remove(paramJSONObject);
      this.f.remove(paramJSONObject);
      this.g.remove(paramJSONObject);
      this.h.remove(paramJSONObject);
      return 0;
    }
    paramJSONObject = this.jdField_b_of_type_AndroidOsHandler;
    if (paramJSONObject != null)
    {
      paramJSONObject.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
    return -6;
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("source", "none");
      dispatchJsEvent("healthSport_uploadProgress", paramString, (JSONObject)localObject);
      if (!QLog.isColorLevel()) {
        break label94;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("UploadProgress:");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.i("HealthBusinessPlugin", 2, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString)
    {
      label79:
      label94:
      break label79;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HealthBusinessPlugin", 2, "UploadProgress Err");
    }
  }
  
  int c(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_Boolean = false;
    try
    {
      paramJSONObject = paramJSONObject.getString("vid");
    }
    catch (Exception paramJSONObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playVideo Err:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("HealthBusinessPlugin", 1, ((StringBuilder)localObject).toString());
      paramJSONObject = null;
    }
    if (paramJSONObject == null) {
      return -1;
    }
    if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramJSONObject)) {
      return -3;
    }
    Object localObject = this.jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      ImageView localImageView = (ImageView)((FrameLayout)this.e.get(str)).findViewById(2131374357);
      if (str.equals(paramJSONObject)) {
        ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJSONObject)).start();
      } else {
        ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJSONObject)).pause();
      }
      localImageView.setVisibility(4);
    }
    return 0;
  }
  
  int d(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_Boolean = true;
    try
    {
      paramJSONObject = paramJSONObject.getString("vid");
    }
    catch (Exception paramJSONObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pauseVideo Err:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("HealthBusinessPlugin", 1, ((StringBuilder)localObject).toString());
      paramJSONObject = null;
    }
    if (paramJSONObject == null) {
      return -1;
    }
    if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramJSONObject)) {
      return -3;
    }
    Object localObject = (ImageView)((FrameLayout)this.e.get(paramJSONObject)).findViewById(2131374357);
    ((ImageView)localObject).setImageResource(2130849461);
    ((ImageView)localObject).setVisibility(0);
    ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramJSONObject)).pause();
    this.jdField_a_of_type_Boolean = true;
    return 0;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8L;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (this.mRuntime.a().getUrl().contains("qq.com"))
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if ((paramLong == 8L) && ((paramString.startsWith("http://qqsport/")) || (paramString.startsWith("https://qqsport/"))) && (paramString.length() > 16))
      {
        paramString = paramString.substring(15);
        try
        {
          paramString = new File(URLDecoder.decode(paramString, "utf-8"));
          if ((!paramString.exists()) && (!paramString.isFile())) {
            return null;
          }
          paramString = new WebResourceResponse("image/*", "utf-8", new FileInputStream(paramString));
          return paramString;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return null;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    String str;
    boolean bool;
    int k;
    int j;
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      paramString2 = paramString1.optString("callback");
      str = paramString1.optString("groupID");
      bool = "openPhoto".equals(paramString3);
      if (bool)
      {
        if (TextUtils.isEmpty(paramString2)) {
          return true;
        }
        paramString1.optInt("maxSelect");
        paramString1.optInt("min_width", 200);
        paramString1.optInt("min_height", 200);
        paramString1.optInt("max_gif_size", 8388608);
        k = paramString1.optInt("opType", 0);
        paramJsBridgeListener = new ArrayList();
        if (TextUtils.isEmpty(str))
        {
          this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis() / 1000L);
        }
        else
        {
          this.jdField_a_of_type_JavaLangString = str;
          paramString1 = a().getString(str, null);
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
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_b_of_type_JavaUtilList.addAll(paramJsBridgeListener);
        this.jdField_b_of_type_JavaLangString = paramString2;
        paramJsBridgeListener = this.mRuntime.a();
        if (paramJsBridgeListener == null) {
          return true;
        }
        if (k == 0)
        {
          paramString1 = new Intent("android.intent.action.PICK");
          paramString1.setType("image/*");
          paramString1.putExtra("big_brother_source_key", "biz_src_gzh_health");
          startActivityForResult(paramString1, (byte)1);
          QAlbumUtil.anim(paramJsBridgeListener, false, true);
        }
        else if (k == 1)
        {
          a();
        }
      }
      else
      {
        bool = "getPicture".equals(paramString3);
        if (bool)
        {
          if (TextUtils.isEmpty(paramString2)) {
            return true;
          }
          paramString1 = this.mRuntime.a().getAccount();
          paramJsBridgeListener = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            paramJsBridgeListener = "nologin";
          }
          paramString1 = this.mRuntime.a().getApplication();
          paramString3 = new StringBuilder();
          paramString3.append(paramJsBridgeListener);
          paramString3.append("_health");
          paramJsBridgeListener = paramString1.getSharedPreferences(paramString3.toString(), 0).getString(str, null);
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
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramString1, paramString1.getResources().getDimensionPixelSize(2131299168));
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
            }
            if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            }
            ThreadManager.post(new HealthBusinessPlugin.2(this, paramJsBridgeListener, paramString2), 5, null, true);
          }
        }
        else if ("deletePicture".equals(paramString3))
        {
          paramJsBridgeListener = a();
          if (TextUtils.isEmpty(paramString2)) {
            return true;
          }
          paramString1 = paramString1.optString("path");
          if (TextUtils.isEmpty(paramString1)) {
            break label2894;
          }
          if (TextUtils.isEmpty(str)) {
            return true;
          }
          paramVarArgs = paramJsBridgeListener.getString(str, null);
          paramString3 = new JSONArray();
          if (!TextUtils.isEmpty(paramVarArgs))
          {
            paramVarArgs = new JSONObject(paramVarArgs);
            localObject = paramVarArgs.getJSONArray("imgList");
            j = 0;
            if (j < ((JSONArray)localObject).length())
            {
              if (paramString1.equals(((JSONArray)localObject).getString(j))) {
                break label2885;
              }
              paramString3.put(((JSONArray)localObject).getString(j));
              break label2885;
            }
            paramVarArgs.put("imgList", paramString3);
            paramJsBridgeListener.edit().putString(str, paramVarArgs.toString()).commit();
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("msg", "success.");
            super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
          }
        }
        else
        {
          bool = "uploadGroup".equals(paramString3);
          paramJsBridgeListener = "video_dir";
          if (bool)
          {
            if (TextUtils.isEmpty(paramString2)) {
              return true;
            }
            paramJsBridgeListener = paramString1.optString("feedID");
            paramString3 = paramString1.optString("tag", HardCodeUtil.a(2131705540));
            paramString1 = paramString1.optString("cat", HardCodeUtil.a(2131705541));
            paramVarArgs = this.mRuntime.a().getApplication().getSharedPreferences("groupid_feedid", 0).edit();
            paramVarArgs.putString(str, paramJsBridgeListener);
            paramVarArgs.commit();
            if (TextUtils.isEmpty(str)) {
              break label2907;
            }
            if (TextUtils.isEmpty(paramJsBridgeListener)) {
              return true;
            }
            if (jdField_a_of_type_JavaUtilList.contains(str))
            {
              if (!QLog.isColorLevel()) {
                break label2896;
              }
              QLog.i("HealthBusinessPlugin", 2, "group enqueued.");
              return true;
            }
            jdField_a_of_type_JavaUtilList.add(str);
            localObject = a().getString(str, null);
            paramVarArgs = new ArrayList();
            if (TextUtils.isEmpty((CharSequence)localObject))
            {
              paramJsBridgeListener = new JSONObject();
              paramJsBridgeListener.put("msg", "group id not found.");
              super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
              return true;
            }
            paramString2 = new JSONObject((String)localObject);
            bool = paramString2.has("imgList");
            if (bool)
            {
              paramString2 = paramString2.getJSONArray("imgList");
              j = 0;
              label1034:
              if (j < paramString2.length())
              {
                localObject = paramString2.getString(j);
                if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).startsWith("http")) || (((String)localObject).equals("error"))) {
                  break label2898;
                }
                paramVarArgs.add(paramString2.getString(j));
                break label2898;
              }
            }
            else
            {
              paramVarArgs.add(paramString2.getString("video_dir"));
            }
            if ((this.mRuntime.a() instanceof QBaseActivity))
            {
              paramJsBridgeListener = new HealthBusinessPlugin.UploadThread(this, (QBaseActivity)this.mRuntime.a(), paramVarArgs, paramJsBridgeListener, str, bool, paramString3, paramString1);
              jdField_b_of_type_JavaUtilHashMap.put(str, paramJsBridgeListener);
              ThreadManager.post(paramJsBridgeListener, 5, null, false);
            }
          }
          else if ("deleteGroup".equals(paramString3))
          {
            if (TextUtils.isEmpty(paramString2)) {
              return true;
            }
            paramJsBridgeListener = a();
            paramString1 = paramJsBridgeListener.getString(str, null);
            if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("video_dir")))
            {
              paramString1 = new File(new JSONObject(paramString1).getString("thumb_dir"));
              if ((paramString1.exists()) && (paramString1.isFile())) {
                paramString1.delete();
              }
            }
            paramString1 = new JSONObject();
            bool = paramJsBridgeListener.edit().remove(str).commit();
            paramJsBridgeListener = this.mRuntime.a().getApplication().getSharedPreferences("groupid_feedid", 0);
            if (paramJsBridgeListener == null) {
              break label2909;
            }
            j = 1;
            break label2912;
            label1327:
            if ((j & k) == 0) {
              break label2929;
            }
            paramJsBridgeListener.edit().remove(str).commit();
            break label2929;
            label1357:
            paramString1.put("msg", paramJsBridgeListener);
            super.callJs(paramString2, new String[] { paramString1.toString() });
          }
          else if ("shortVideo".equals(paramString3))
          {
            if (!TextUtils.isEmpty(paramString2)) {
              this.jdField_b_of_type_JavaLangString = paramString2;
            }
            a(paramString1.optInt("sizeBeforeCompress", 104857600), paramString1.optInt("durationMax", 180) * 1000, paramString1.optInt("sizeAfterCompress", 10485760), paramString1.optInt("durationRecord", 20));
          }
          else if ("getVideoInfo".equals(paramString3))
          {
            if (TextUtils.isEmpty(paramString2)) {
              break label2948;
            }
            if (TextUtils.isEmpty(str)) {
              return true;
            }
            paramJsBridgeListener = a().getString(str, null);
            if (paramJsBridgeListener == null) {
              return true;
            }
            ThreadManager.post(new HealthBusinessPlugin.3(this, paramJsBridgeListener, paramString2), 5, null, true);
          }
          else
          {
            bool = "uploadVideoCount".equals(paramString3);
            if (bool) {
              paramJsBridgeListener = new JSONObject();
            }
          }
        }
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      Object localObject;
      label1620:
      File localFile;
      label1688:
      label2866:
      QLog.e("HealthBusinessPlugin", 1, "[handleJsRequest] error=", paramJsBridgeListener);
      return true;
    }
    try
    {
      paramJsBridgeListener.put("retCode", 0);
      paramJsBridgeListener.put("videoCount", jdField_a_of_type_JavaUtilList.size());
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("videoCount:");
        paramString1.append(jdField_a_of_type_JavaUtilList.size());
        QLog.i("HealthBusinessPlugin", 2, paramString1.toString());
      }
    }
    catch (Exception paramString1)
    {
      break label1620;
    }
    paramJsBridgeListener.put("retCode", -1);
    paramJsBridgeListener.put("videoCount", 0);
    super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
    break label2866;
    if ("uploadVideoList".equals(paramString3))
    {
      paramString1 = new JSONObject();
      paramString3 = new JSONArray();
      j = 0;
      if (j < jdField_a_of_type_JavaUtilList.size())
      {
        paramVarArgs = new JSONObject();
        paramVarArgs.put("groupID", jdField_a_of_type_JavaUtilList.get(j));
        paramVarArgs.put("feedID", this.mRuntime.a().getApplication().getSharedPreferences("groupid_feedid", 0).getString((String)jdField_a_of_type_JavaUtilList.get(j), ""));
        str = (String)jdField_a_of_type_JavaUtilList.get(j);
        localObject = new JSONObject(a().getString(str, null));
        str = ((JSONObject)localObject).getString(paramJsBridgeListener);
        localObject = ((JSONObject)localObject).optString("thumb_dir");
        localFile = new File(str);
        if ((!localFile.exists()) || (!localFile.isFile())) {
          break label2950;
        }
        paramVarArgs.put("videoSize", localFile.length() / 1024L);
      }
    }
    label2948:
    label2950:
    for (;;)
    {
      paramVarArgs.put("videoPath", str);
      paramVarArgs.put("thumbData", localObject);
      paramVarArgs.put("videoID", str);
      if (Build.VERSION.SDK_INT >= 10)
      {
        localObject = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject).setDataSource(str);
        str = ((MediaMetadataRetriever)localObject).extractMetadata(9);
        ((MediaMetadataRetriever)localObject).release();
        paramVarArgs.put("videoDuration", String.valueOf(Long.parseLong(str) / 1000L));
      }
      paramString3.put(paramVarArgs);
      j += 1;
      break label1688;
      paramString1.put("retCode", 0);
      paramString1.put("data", paramString3);
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("uploadVideoList:");
        paramJsBridgeListener.append(paramString1.toString());
        QLog.d("HealthBusinessPlugin", 2, paramJsBridgeListener.toString());
      }
      super.callJs(paramString2, new String[] { paramString1.toString() });
      break label2866;
      if ("deleteUploadVideo".equals(paramString3))
      {
        paramJsBridgeListener = new JSONObject();
        paramString1 = paramString1.optString("groupID");
        paramString1 = (HealthBusinessPlugin.UploadThread)jdField_b_of_type_JavaUtilHashMap.get(paramString1);
        if (paramString1 != null)
        {
          paramString1.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel())
          {
            paramString3 = new StringBuilder();
            paramString3.append("queue length before directly:");
            paramString3.append(jdField_a_of_type_JavaUtilList.size());
            QLog.d("HealthBusinessPlugin", 2, paramString3.toString());
          }
          jdField_a_of_type_JavaUtilList.remove(paramString1.jdField_b_of_type_JavaLangString);
          jdField_c_of_type_JavaUtilHashMap.remove(paramString1.jdField_b_of_type_JavaLangString);
          jdField_b_of_type_JavaUtilHashMap.remove(paramString1.jdField_b_of_type_JavaLangString);
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("queue length after directly:");
            paramString1.append(jdField_a_of_type_JavaUtilList.size());
            QLog.d("HealthBusinessPlugin", 2, paramString1.toString());
          }
          paramJsBridgeListener.put("retCode", 0);
        }
        else
        {
          paramJsBridgeListener.put("retCode", -1);
        }
        super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      }
      else if ("pinVideo".equals(paramString3))
      {
        paramJsBridgeListener = new JSONObject();
        paramJsBridgeListener.put("retCode", a(paramString1));
        callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      }
      else if ("pluckVideo".equals(paramString3))
      {
        paramJsBridgeListener = new JSONObject();
        paramJsBridgeListener.put("retCode", b(paramString1));
        callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      }
      else if ("playVideo".equals(paramString3))
      {
        paramJsBridgeListener = new JSONObject();
        paramJsBridgeListener.put("retCode", c(paramString1));
        callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      }
      else if ("pauseVideo".equals(paramString3))
      {
        paramJsBridgeListener = new JSONObject();
        paramJsBridgeListener.put("retCode", d(paramString1));
        callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      }
      else if ("stopVideo".equals(paramString3))
      {
        paramJsBridgeListener = new JSONObject();
        paramString1 = paramString1.optString("vid");
        if (paramString1 == null)
        {
          paramJsBridgeListener.put("retCode", -1);
          callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
          return false;
        }
        if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramString1))
        {
          paramJsBridgeListener.put("retCode", -3);
          callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
          return false;
        }
        ((ISuperPlayer)this.jdField_d_of_type_JavaUtilHashMap.get(paramString1)).stop();
        paramJsBridgeListener.put("retCode", 0);
        callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      }
      else if ("wifiStatus".equals(paramString3))
      {
        paramJsBridgeListener = new JSONObject();
        paramJsBridgeListener.put("retCode", NetworkUtil.isWifiConnected(this.mRuntime.a()));
        callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      }
      else
      {
        bool = "followUin".equals(paramString3);
        if (bool) {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("uin");
            paramString1 = paramString1.optString("callback");
            paramString2 = new NewIntent(this.mRuntime.a().getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
            a(paramJsBridgeListener);
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
      }
      return true;
      label2885:
      j += 1;
      break;
      label2894:
      return true;
      label2896:
      return true;
      label2898:
      j += 1;
      break label1034;
      label2907:
      return true;
      label2909:
      j = 0;
      label2912:
      if (str != null)
      {
        k = 1;
        break label1327;
      }
      k = 0;
      break label1327;
      label2929:
      if (bool)
      {
        paramJsBridgeListener = "success.";
        break label1357;
      }
      paramJsBridgeListener = "group not found.";
      break label1357;
      return true;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    Object localObject1;
    if (paramByte == 1)
    {
      if (paramInt == -1)
      {
        localObject1 = new ArrayList(this.jdField_b_of_type_JavaUtilList);
        this.jdField_b_of_type_JavaUtilList.clear();
        paramIntent = FileProvider7Helper.getRealPathFromContentURI(this.mRuntime.a(), paramIntent.getData());
        if ((!TextUtils.isEmpty(paramIntent)) && (!((List)localObject1).contains(paramIntent))) {
          ((List)localObject1).add(paramIntent);
        }
        if (((List)localObject1).isEmpty()) {
          return;
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
        {
          if (this.mRuntime != null) {
            a((List)localObject1);
          }
          paramIntent = new JSONObject();
          try
          {
            paramIntent.put("group_id", this.jdField_a_of_type_JavaLangString);
          }
          catch (Exception localException)
          {
            QLog.e("HealthBusinessPlugin", 1, localException, new Object[0]);
          }
          super.callJs(this.jdField_b_of_type_JavaLangString, new String[] { paramIntent.toString() });
          if (this.mRuntime != null) {
            ThreadManager.post(new HealthBusinessPlugin.6(this, (List)localObject1), 5, null, true);
          }
        }
        else
        {
          QLog.e("HealthBusinessPlugin", 1, "miss id parameter!");
        }
      }
      else if (paramInt == 16)
      {
        paramIntent = paramIntent.getStringArrayListExtra("img_list");
        if ((paramIntent != null) && (!paramIntent.isEmpty())) {
          a(paramIntent);
        }
        a();
      }
    }
    else
    {
      Object localObject2;
      Object localObject3;
      if (paramByte == 2)
      {
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
        {
          localObject2 = new JSONObject();
          if (paramInt == -1)
          {
            if ((this.mRuntime != null) && (this.mRuntime.a() != null))
            {
              paramIntent = this.mRuntime.a().getApplicationContext();
              localObject3 = BaseImageUtil.b(paramIntent, this.jdField_a_of_type_AndroidNetUri);
              BaseImageUtil.a(paramIntent, (String)localObject3);
              SharedPreferences localSharedPreferences = a();
              localObject1 = localSharedPreferences.getString(this.jdField_a_of_type_JavaLangString, null);
              try
              {
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramIntent = new JSONObject();
                } else {
                  paramIntent = new JSONObject((String)localObject1);
                }
                boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
                if (bool) {
                  localObject1 = new JSONArray();
                } else {
                  localObject1 = paramIntent.getJSONArray("imgList");
                }
                ((JSONArray)localObject1).put(localObject3);
                paramIntent.put("imgList", localObject1);
                localSharedPreferences.edit().putString(this.jdField_a_of_type_JavaLangString, paramIntent.toString()).commit();
                ((JSONObject)localObject2).put("group_id", this.jdField_a_of_type_JavaLangString);
                ((JSONObject)localObject2).put("msg", "ok");
              }
              catch (Exception paramIntent)
              {
                QLog.e("HealthBusinessPlugin", 1, paramIntent, new Object[0]);
              }
            }
          }
          else {
            try
            {
              ((JSONObject)localObject2).put("msg", "cancel");
            }
            catch (Exception paramIntent)
            {
              QLog.e("HealthBusinessPlugin", 1, paramIntent, new Object[0]);
            }
          }
          if ((this.mRuntime != null) && (this.mRuntime.a() != null)) {
            super.callJs(this.jdField_b_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
          }
        }
        else
        {
          QLog.e("HealthBusinessPlugin", 1, "value miss!");
        }
      }
      else if ((paramByte == 3) && (paramInt == -1))
      {
        localObject1 = this.jdField_c_of_type_JavaLangString;
        paramIntent = paramIntent.getStringExtra("thumb_dir");
        localObject2 = String.valueOf(System.currentTimeMillis() / 1000L);
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          try
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("group_id", localObject2);
            super.callJs(this.jdField_b_of_type_JavaLangString, new String[] { ((JSONObject)localObject3).toString() });
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("video_dir", localObject1);
            if (!TextUtils.isEmpty(paramIntent)) {
              ((JSONObject)localObject3).put("thumb_dir", paramIntent);
            } else {
              QLog.e("HealthBusinessPlugin", 1, "video thumb path miss!");
            }
            a().edit().putString((String)localObject2, ((JSONObject)localObject3).toString()).commit();
            return;
          }
          catch (Exception paramIntent)
          {
            QLog.e("HealthBusinessPlugin", 1, paramIntent, new Object[0]);
          }
        }
      }
    }
  }
  
  protected void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "oncreated ......");
    }
    super.onCreate();
    if (!QQVideoPlaySDKManager.a()) {
      QQVideoPlaySDKManager.a(this.mRuntime.a().getApplication(), null);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    b();
    this.jdField_a_of_type_ComTencentBizUiRefreshView.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$MyNetInfoHandler);
    QLog.d("HealthBusinessPlugin", 1, "onDestroy");
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    paramCustomWebView = new FrameLayout.LayoutParams(-1, -1);
    paramCustomWebView.topMargin = 0;
    paramCustomWebView.leftMargin = 0;
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.mRuntime.a().findViewById(2131381085));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("videoLayout id:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizUiRefreshView.getResources());
      QLog.d("HealthBusinessPlugin", 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin
 * JD-Core Version:    0.7.0.1
 */