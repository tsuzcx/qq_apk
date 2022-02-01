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
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
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
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class HealthBusinessPlugin
  extends WebViewPlugin
{
  public static HashMap<String, JSONObject> e = new HashMap();
  static List<String> f = new ArrayList();
  public static HashMap<String, HealthBusinessPlugin.UploadThread> h = new HashMap();
  static HashMap<String, Double> i = new HashMap();
  boolean A;
  int B;
  int C;
  int D;
  int E;
  int F;
  int G;
  int H;
  boolean I;
  boolean J = false;
  Handler K;
  private String L;
  private List<String> M = new ArrayList();
  private QQPermission N = null;
  private String[] O = { "android.permission.CAMERA" };
  Uri a;
  QQProgressDialog b;
  String c;
  String d;
  boolean g;
  int j;
  int k;
  HashMap<String, ISuperPlayer> l = new HashMap();
  HashMap<String, FrameLayout> m = new HashMap();
  HashMap<String, HealthBusinessPlugin.SportVideoLayoutHolder> n = new HashMap();
  HashMap<String, Timer> o = new HashMap();
  HashMap<String, Long> p = new HashMap();
  FrameLayout q;
  RefreshView r;
  TouchWebView s;
  Point t = new Point();
  Point u = new Point();
  ProgressBar v;
  HealthBusinessPlugin.MyNetInfoHandler w = null;
  Runnable x;
  Runnable y;
  Handler z = new Handler();
  
  public HealthBusinessPlugin()
  {
    this.mPluginNameSpace = "healthSport";
  }
  
  public static String a(String paramString, int paramInt)
  {
    paramString = new CompressInfo(paramString, paramInt, 1035);
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(paramString);
    return paramString.l;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, new Object[] { "report  Click On HealthBusinessPluginFollow , UIN=", paramString });
    }
    ThreadManagerV2.executeOnSubThread(new HealthBusinessPlugin.5(paramString));
  }
  
  private void c()
  {
    Iterator localIterator = this.o.values().iterator();
    while (localIterator.hasNext()) {
      ((Timer)localIterator.next()).cancel();
    }
    this.o.clear();
  }
  
  private boolean d()
  {
    IModule localIModule = AVBizModuleFactory.getModuleByName("运动");
    if (!"true".equals(localIModule.checkAVFocus()))
    {
      QLog.e("HealthBusinessPlugin", 1, "preCheckAudioFocus is fail");
      ToastUtil.a().a(HardCodeUtil.a(2131903439), 1);
      return false;
    }
    return "true".equals(localIModule.requestAVFocus());
  }
  
  private void e()
  {
    AVBizModuleFactory.getModuleByName("运动").abandonAVFocus();
  }
  
  int a(JSONObject paramJSONObject)
  {
    Object localObject2 = this.mRuntime.d();
    this.g = false;
    this.v = new ProgressBar((Context)localObject2);
    this.v.setIndeterminateDrawable(((Context)localObject2).getResources().getDrawable(2130841254));
    this.v.setIndeterminate(true);
    try
    {
      d2 = paramJSONObject.getDouble("top");
      d3 = paramJSONObject.getDouble("left");
      d1 = paramJSONObject.getDouble("width");
      d4 = paramJSONObject.getDouble("height");
      localObject1 = paramJSONObject.getString("vid");
      localObject3 = this.mRuntime.d().getResources().getDisplayMetrics();
    }
    catch (Exception paramJSONObject)
    {
      double d2;
      double d3;
      double d1;
      double d4;
      Object localObject1;
      Object localObject3;
      int i1;
      int i3;
      int i4;
      int i2;
      label150:
      label161:
      label168:
      label171:
      label174:
      float f1;
      double d5;
      Object localObject6;
      Object localObject5;
      Object localObject4;
      Object localObject7;
      FrameLayout localFrameLayout;
      break label1471;
    }
    try
    {
      i1 = paramJSONObject.optInt("needCheckWiFi");
    }
    catch (Exception paramJSONObject)
    {
      break label168;
    }
    try
    {
      i3 = paramJSONObject.optInt("needMute");
    }
    catch (Exception paramJSONObject)
    {
      break label161;
    }
    try
    {
      i4 = paramJSONObject.optInt("needCountdown");
      i2 = i1;
      i1 = i4;
    }
    catch (Exception paramJSONObject)
    {
      break label150;
    }
    i2 = i1;
    i1 = i3;
    break label174;
    i2 = i1;
    break label171;
    i2 = 1;
    i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "optional Err");
    }
    i4 = 1;
    i3 = i1;
    i1 = i4;
    if ((NetworkUtil.isWifiConnected((Context)localObject2)) && (i2 == 1)) {
      return -5;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "addView Function");
    }
    f1 = this.mRuntime.d().getResources().getDisplayMetrics().density;
    d5 = f1;
    Double.isNaN(d5);
    i2 = (int)(d1 * d5);
    Double.isNaN(d5);
    localObject6 = new FrameLayout.LayoutParams(i2, (int)(d4 * d5));
    Double.isNaN(d5);
    ((FrameLayout.LayoutParams)localObject6).topMargin = ((int)(d2 * d5));
    Double.isNaN(d5);
    ((FrameLayout.LayoutParams)localObject6).leftMargin = ((int)(d3 * d5));
    if ((d1 != 0.0D) && (d4 != 0.0D))
    {
      if (this.l.containsKey(localObject1)) {
        return -2;
      }
      if (this.l.size() == 3) {
        return -4;
      }
      paramJSONObject = SuperPlayerFactory.createPlayerVideoView(this.mRuntime.d());
      localObject5 = SuperPlayerFactory.createMediaPlayer(this.mRuntime.d(), 117, paramJSONObject);
      ((ISuperPlayer)localObject5).setLoopback(false);
      this.x = new HealthBusinessPlugin.8(this);
      this.y = new HealthBusinessPlugin.9(this);
      a((ISuperPlayer)localObject5);
      localObject4 = SuperPlayerFactory.createVideoInfoForTVideo(4080303, (String)localObject1);
      ((ISuperPlayer)localObject5).openMediaPlayer(this.mRuntime.d(), (SuperPlayerVideoInfo)localObject4, 0L);
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("sDensity:");
        ((StringBuilder)localObject4).append(f1);
        QLog.d("HealthBusinessPlugin", 2, ((StringBuilder)localObject4).toString());
      }
      localObject7 = (FrameLayout)LayoutInflater.from((Context)localObject2).inflate(2131626440, null);
      localObject4 = new HealthBusinessPlugin.SportVideoLayoutHolder();
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).a = ((ImageView)((FrameLayout)localObject7).findViewById(2131442519));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).b = ((ImageView)((FrameLayout)localObject7).findViewById(2131442518));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).c = ((TextView)((FrameLayout)localObject7).findViewById(2131442517));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).d = ((TextView)((FrameLayout)localObject7).findViewById(2131442520));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).e = ((SeekBar)((FrameLayout)localObject7).findViewById(2131445496));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).f = ((TextView)((FrameLayout)localObject7).findViewById(2131442521));
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).g = ((ImageView)((FrameLayout)localObject7).findViewById(2131442516));
      localFrameLayout = new FrameLayout((Context)localObject2);
      localFrameLayout.addView((View)paramJSONObject);
      localFrameLayout.addView((View)localObject7);
      this.q.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject6);
      this.m.put(localObject1, localFrameLayout);
      this.n.put(localObject1, localObject4);
      if (this.l == null) {
        this.l = new HashMap();
      }
      localObject6 = this.l.keySet().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (String)((Iterator)localObject6).next();
        ((ISuperPlayer)this.l.get(localObject7)).pause();
      }
      this.l.put(localObject1, localObject5);
      this.p.put(localObject1, Long.valueOf(0L));
      this.K = new Handler();
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).b.setVisibility(4);
      if (i3 == 0)
      {
        ((ISuperPlayer)this.l.get(localObject1)).setOutputMute(false);
        ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).b.setVisibility(0);
        ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).b.setImageDrawable(((Context)localObject2).getResources().getDrawable(2130848167));
      }
      else
      {
        ((ISuperPlayer)this.l.get(localObject1)).setOutputMute(true);
        ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).b.setVisibility(0);
        ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).b.setImageDrawable(((Context)localObject2).getResources().getDrawable(2130848166));
      }
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).b.setOnClickListener(new HealthBusinessPlugin.10(this, (String)localObject1, (Context)localObject2));
      new FrameLayout.LayoutParams(ViewUtils.dip2px(45.0F), ViewUtils.dip2px(43.0F)).gravity = 85;
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).a.setOnClickListener(new HealthBusinessPlugin.11(this, (String)localObject1, (HealthBusinessPlugin.SportVideoLayoutHolder)localObject4));
      i2 = this.mRuntime.d().getResources().getDisplayMetrics().widthPixels;
      d2 = ((DisplayMetrics)localObject3).density;
      Double.isNaN(d2);
      i3 = (int)(d2 * d1 * 0.7D);
      d2 = ((DisplayMetrics)localObject3).density;
      Double.isNaN(d2);
      i4 = (int)(d1 * d2 * 0.15D);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("screen width:");
      ((StringBuilder)localObject2).append((i2 - 200) / 2);
      QLog.d("HealthBusinessPlugin", 1, ((StringBuilder)localObject2).toString());
      localObject2 = new FrameLayout.LayoutParams(i3, ViewUtils.dip2px(20.0F));
      localObject3 = new FrameLayout.LayoutParams(i4, ViewUtils.dip2px(20.0F));
      localObject5 = new FrameLayout.LayoutParams(i4, ViewUtils.dip2px(20.0F));
      localObject6 = new FrameLayout.LayoutParams(ViewUtils.dip2px(60.0F), ViewUtils.dip2px(60.0F));
      ((FrameLayout.LayoutParams)localObject2).gravity = 81;
      ((FrameLayout.LayoutParams)localObject3).gravity = 83;
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout.LayoutParams)localObject6).gravity = 17;
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setTimeTextForTextView(((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).d, ((ISuperPlayer)this.l.get(localObject1)).getCurrentPositionMs());
      localFrameLayout.setBackgroundColor(-16777216);
      localFrameLayout.addView(this.v, (ViewGroup.LayoutParams)localObject6);
      if (QLog.isColorLevel()) {
        QLog.d("HealthBusinessPlugin", 2, "add seekbar");
      }
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).a.setVisibility(4);
      this.J = false;
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).e.setOnSeekBarChangeListener(new HealthBusinessPlugin.12(this));
      new FrameLayout.LayoutParams(-2, ViewUtils.dip2px(43.0F)).gravity = 85;
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setTimeTextForTextView(((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).c, ((ISuperPlayer)this.l.get(localObject1)).getDurationMs());
      if (i1 == 1) {
        ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).c.setVisibility(0);
      } else {
        ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).c.setVisibility(8);
      }
      a(((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).c, (String)localObject1, ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).d, ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).f, ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).e);
      localObject1 = new HealthBusinessPlugin.13(this);
      this.mRuntime.a().setOnTouchListener((View.OnTouchListener)localObject1);
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).g.setVisibility(4);
      ((HealthBusinessPlugin.SportVideoLayoutHolder)localObject4).g.setOnClickListener(new HealthBusinessPlugin.14(this, (HealthBusinessPlugin.SportVideoLayoutHolder)localObject4, paramJSONObject, localFrameLayout));
      return 0;
    }
    return -1;
    label1471:
    QLog.d("HealthBusinessPlugin", 1, "AddView Err:");
    return -6;
  }
  
  void a()
  {
    if (QavCameraUsage.b(this.mRuntime.d())) {
      return;
    }
    Object localObject = new File(AppConstants.SDCARD_IMG_SAVE);
    int i1;
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    Activity localActivity = this.mRuntime.d();
    if ((i1 != 0) && (((File)localObject).canWrite()))
    {
      if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.d)))
      {
        if ((localActivity != null) && (!localActivity.isFinishing()))
        {
          localObject = new Intent();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(AppConstants.SDCARD_IMG_SAVE);
          localStringBuilder.append(System.currentTimeMillis());
          localStringBuilder.append(".jpg");
          this.a = FileProvider7Helper.setSystemCapture(localActivity, new File(localStringBuilder.toString()), (Intent)localObject);
          startActivityForResult((Intent)localObject, (byte)2);
        }
      }
      else {
        QLog.e("HealthBusinessPlugin", 1, "temp ids lost!");
      }
    }
    else if ((localActivity != null) && (!localActivity.isFinishing())) {
      QQToast.makeText(localActivity, 2131894040, 1).show(((QBaseActivity)localActivity).getTitleBarHeight());
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
    if (this.mRuntime.d() == null) {
      return;
    }
    Object localObject = new BusinessConfig("biz_src_qqsports", "health_community");
    if (this.N == null) {
      this.N = QQPermissionFactory.a(this.mRuntime.d(), (BusinessConfig)localObject);
    }
    if ((Build.VERSION.SDK_INT >= 23) && (this.N.a("android.permission.CAMERA") != 0))
    {
      this.N.a(this.O, 2, new HealthBusinessPlugin.7(this, paramInt1, paramInt2, paramInt3, paramInt4));
      return;
    }
    if (!d()) {
      return;
    }
    if (!Utils.b())
    {
      ToastUtil.a().a(2131916075);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("shortvideo/");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".mp4");
    this.L = ((StringBuilder)localObject).toString();
    localObject = new Intent("android.media.action.VIDEO_CAPTURE");
    ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 1);
    File localFile = new File(this.L);
    localFile.getParentFile().mkdirs();
    ((Intent)localObject).putExtra("output", Uri.fromFile(localFile));
    ((Intent)localObject).putExtra("android.intent.extra.durationLimit", paramInt2);
    ((Intent)localObject).putExtra("android.intent.extra.sizeLimit", paramInt3);
    ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_gzh_health");
    FileProvider7Helper.intentCompatForN(this.mRuntime.d(), (Intent)localObject);
    startActivityForResult((Intent)localObject, (byte)3);
  }
  
  void a(TextView paramTextView1, String paramString, TextView paramTextView2, TextView paramTextView3, SeekBar paramSeekBar)
  {
    if (paramTextView1 == null) {
      return;
    }
    Object localObject = this.z;
    if (localObject != null)
    {
      Runnable localRunnable = this.x;
      if (localRunnable != null) {
        ((Handler)localObject).post(localRunnable);
      }
    }
    paramTextView1 = new WeakReference(paramTextView1);
    localObject = new Timer();
    ((Timer)localObject).schedule(new HealthBusinessPlugin.17(this, paramTextView1, paramString, paramTextView2, paramTextView3, paramSeekBar), 0L, 1000L);
    this.o.put(paramString, localObject);
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
    //   0: ldc_w 826
    //   3: astore 26
    //   5: invokestatic 658	java/lang/System:currentTimeMillis	()J
    //   8: lstore 14
    //   10: aload 6
    //   12: aload_3
    //   13: aload 4
    //   15: ldc_w 828
    //   18: invokestatic 833	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp;
    //   21: astore 23
    //   23: aload 23
    //   25: ifnull +1264 -> 1289
    //   28: aload_2
    //   29: invokestatic 839	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   32: lstore 20
    //   34: lload 20
    //   36: ldc2_w 840
    //   39: invokestatic 847	java/lang/Math:min	(JJ)J
    //   42: lstore 18
    //   44: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +63 -> 110
    //   50: new 415	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   57: astore 6
    //   59: aload 6
    //   61: ldc_w 849
    //   64: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 6
    //   70: aload 23
    //   72: getfield 853	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:h	Ljava/lang/String;
    //   75: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 6
    //   81: ldc_w 855
    //   84: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 6
    //   90: aload 23
    //   92: getfield 856	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:d	Ljava/lang/String;
    //   95: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: ldc 165
    //   101: iconst_2
    //   102: aload 6
    //   104: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: ldc_w 858
    //   113: aload 23
    //   115: getfield 853	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:h	Ljava/lang/String;
    //   118: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: ifeq +20 -> 141
    //   124: aload 23
    //   126: getfield 860	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:f	Ljava/lang/String;
    //   129: astore_2
    //   130: ldc_w 826
    //   133: astore 7
    //   135: iconst_1
    //   136: istore 13
    //   138: goto +1163 -> 1301
    //   141: aload 23
    //   143: getfield 860	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:f	Ljava/lang/String;
    //   146: ifnull +1143 -> 1289
    //   149: aload 23
    //   151: getfield 861	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:c	Ljava/lang/String;
    //   154: invokestatic 867	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   157: astore 25
    //   159: aload_2
    //   160: invokestatic 871	com/tencent/mobileqq/filemanager/util/QQFileManagerUtil:o	(Ljava/lang/String;)[B
    //   163: astore 24
    //   165: new 415	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   172: astore 6
    //   174: aload 6
    //   176: ldc_w 873
    //   179: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 6
    //   185: aload 23
    //   187: getfield 875	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:a	Ljava/lang/String;
    //   190: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 6
    //   196: ldc_w 877
    //   199: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 6
    //   205: aload 23
    //   207: getfield 879	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:b	Ljava/lang/String;
    //   210: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 6
    //   216: ldc_w 881
    //   219: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 6
    //   225: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore 27
    //   230: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +63 -> 296
    //   236: new 415	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   243: astore 6
    //   245: aload 6
    //   247: ldc_w 883
    //   250: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 6
    //   256: aload 27
    //   258: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 6
    //   264: ldc_w 885
    //   267: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 6
    //   273: aload 23
    //   275: getfield 860	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:f	Ljava/lang/String;
    //   278: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: ldc 165
    //   284: iconst_2
    //   285: aload 6
    //   287: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: goto +3 -> 296
    //   296: new 887	java/io/RandomAccessFile
    //   299: dup
    //   300: aload_2
    //   301: ldc_w 888
    //   304: invokespecial 889	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   324: getfield 261	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   327: invokevirtual 266	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   330: invokestatic 894	com/tencent/biz/common/util/HttpUtil:isConnect	(Landroid/content/Context;)Z
    //   333: ifeq +1697 -> 2030
    //   336: aload 25
    //   338: aload 24
    //   340: aload 27
    //   342: lload 20
    //   344: aload_2
    //   345: lload 16
    //   347: iload 12
    //   349: invokestatic 897	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   352: lstore 16
    //   354: aload 7
    //   356: getfield 901	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:a	Z
    //   359: istore 22
    //   361: iload 22
    //   363: ifeq +137 -> 500
    //   366: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   369: ifeq +12 -> 381
    //   372: ldc 165
    //   374: iconst_2
    //   375: ldc_w 903
    //   378: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: getstatic 84	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   384: aload 7
    //   386: getfield 905	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   389: invokeinterface 910 2 0
    //   394: pop
    //   395: getstatic 88	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:i	Ljava/util/HashMap;
    //   398: aload 7
    //   400: getfield 905	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   403: invokevirtual 912	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   406: pop
    //   407: getstatic 86	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:h	Ljava/util/HashMap;
    //   410: aload 7
    //   412: getfield 905	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   415: invokevirtual 912	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   418: pop
    //   419: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +46 -> 468
    //   425: new 415	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   432: astore 7
    //   434: aload 7
    //   436: ldc_w 914
    //   439: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 7
    //   445: getstatic 84	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   448: invokeinterface 915 1 0
    //   453: invokevirtual 565	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: ldc 165
    //   459: iconst_2
    //   460: aload 7
    //   462: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aload_2
    //   469: invokevirtual 918	java/io/RandomAccessFile:close	()V
    //   472: return
    //   473: astore_1
    //   474: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +13 -> 490
    //   480: ldc 165
    //   482: iconst_2
    //   483: aload_1
    //   484: invokestatic 922	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   487: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: return
    //   491: astore_1
    //   492: goto +767 -> 1259
    //   495: astore 7
    //   497: goto +668 -> 1165
    //   500: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +1518 -> 2021
    //   506: new 415	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   513: astore 26
    //   515: aload 26
    //   517: ldc_w 924
    //   520: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: lload 16
    //   526: l2d
    //   527: dstore 8
    //   529: lload 20
    //   531: l2d
    //   532: dstore 10
    //   534: dload 8
    //   536: invokestatic 356	java/lang/Double:isNaN	(D)Z
    //   539: pop
    //   540: dload 10
    //   542: invokestatic 356	java/lang/Double:isNaN	(D)Z
    //   545: pop
    //   546: dload 8
    //   548: dload 10
    //   550: ddiv
    //   551: dstore 8
    //   553: aload 26
    //   555: dload 8
    //   557: invokevirtual 927	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 26
    //   563: ldc_w 929
    //   566: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 26
    //   572: getstatic 84	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   575: invokeinterface 915 1 0
    //   580: invokevirtual 565	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 26
    //   586: ldc_w 931
    //   589: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload 26
    //   595: getstatic 84	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   598: iconst_0
    //   599: invokeinterface 934 2 0
    //   604: checkcast 120	java/lang/String
    //   607: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: ldc 165
    //   613: iconst_2
    //   614: aload 26
    //   616: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: goto +3 -> 625
    //   625: getstatic 88	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:i	Ljava/util/HashMap;
    //   628: astore 26
    //   630: aload 7
    //   632: getfield 905	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   635: astore 28
    //   637: lload 16
    //   639: l2d
    //   640: dstore 8
    //   642: lload 20
    //   644: l2d
    //   645: dstore 10
    //   647: dload 8
    //   649: invokestatic 356	java/lang/Double:isNaN	(D)Z
    //   652: pop
    //   653: dload 10
    //   655: invokestatic 356	java/lang/Double:isNaN	(D)Z
    //   658: pop
    //   659: dload 8
    //   661: dload 10
    //   663: ddiv
    //   664: dstore 8
    //   666: aload 26
    //   668: aload 28
    //   670: dload 8
    //   672: invokestatic 937	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   675: invokevirtual 494	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   678: pop
    //   679: lload 16
    //   681: ldc2_w 938
    //   684: lcmp
    //   685: ifne +6 -> 691
    //   688: goto +1342 -> 2030
    //   691: new 300	org/json/JSONObject
    //   694: dup
    //   695: invokespecial 940	org/json/JSONObject:<init>	()V
    //   698: astore 26
    //   700: new 942	org/json/JSONArray
    //   703: dup
    //   704: invokespecial 943	org/json/JSONArray:<init>	()V
    //   707: astore 28
    //   709: iconst_0
    //   710: istore 12
    //   712: iload 12
    //   714: getstatic 84	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   717: invokeinterface 915 1 0
    //   722: if_icmpge +164 -> 886
    //   725: new 300	org/json/JSONObject
    //   728: dup
    //   729: invokespecial 940	org/json/JSONObject:<init>	()V
    //   732: astore 29
    //   734: aload 29
    //   736: ldc_w 945
    //   739: getstatic 84	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   742: iload 12
    //   744: invokeinterface 934 2 0
    //   749: invokevirtual 948	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   752: pop
    //   753: getstatic 88	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:i	Ljava/util/HashMap;
    //   756: getstatic 84	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   759: iload 12
    //   761: invokeinterface 934 2 0
    //   766: invokevirtual 505	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   769: astore 30
    //   771: aload 30
    //   773: ifnull +86 -> 859
    //   776: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq +1245 -> 2024
    //   782: new 415	java/lang/StringBuilder
    //   785: dup
    //   786: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   789: astore 30
    //   791: aload 30
    //   793: ldc_w 950
    //   796: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: pop
    //   800: aload 30
    //   802: getstatic 88	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:i	Ljava/util/HashMap;
    //   805: aload 7
    //   807: getfield 905	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   810: invokevirtual 505	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   813: invokevirtual 953	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: ldc 165
    //   819: iconst_2
    //   820: aload 30
    //   822: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   828: goto +3 -> 831
    //   831: aload 29
    //   833: ldc_w 955
    //   836: getstatic 88	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:i	Ljava/util/HashMap;
    //   839: getstatic 84	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   842: iload 12
    //   844: invokeinterface 934 2 0
    //   849: invokevirtual 505	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   852: invokevirtual 948	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   855: pop
    //   856: goto +13 -> 869
    //   859: aload 29
    //   861: ldc_w 955
    //   864: iconst_0
    //   865: invokevirtual 958	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   868: pop
    //   869: aload 28
    //   871: aload 29
    //   873: invokevirtual 961	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   876: pop
    //   877: iload 12
    //   879: iconst_1
    //   880: iadd
    //   881: istore 12
    //   883: goto -171 -> 712
    //   886: aload 26
    //   888: ldc_w 963
    //   891: iconst_0
    //   892: invokevirtual 958	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   895: pop
    //   896: aload 26
    //   898: ldc_w 965
    //   901: aload 28
    //   903: invokevirtual 948	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   906: pop
    //   907: aload_0
    //   908: aload 26
    //   910: invokevirtual 966	org/json/JSONObject:toString	()Ljava/lang/String;
    //   913: invokevirtual 968	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:b	(Ljava/lang/String;)V
    //   916: lload 16
    //   918: ldc2_w 840
    //   921: ladd
    //   922: lload 20
    //   924: invokestatic 847	java/lang/Math:min	(JJ)J
    //   927: lstore 18
    //   929: lload 16
    //   931: lload 20
    //   933: lcmp
    //   934: iflt +1093 -> 2027
    //   937: iconst_0
    //   938: istore 12
    //   940: aload 23
    //   942: astore 7
    //   944: goto +3 -> 947
    //   947: aload 6
    //   949: astore 23
    //   951: iload 12
    //   953: ifne +50 -> 1003
    //   956: new 415	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   963: astore 24
    //   965: aload 24
    //   967: ldc_w 970
    //   970: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: aload 24
    //   976: invokestatic 658	java/lang/System:currentTimeMillis	()J
    //   979: lload 14
    //   981: lsub
    //   982: invokevirtual 661	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   985: pop
    //   986: ldc 165
    //   988: iconst_1
    //   989: aload 24
    //   991: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   994: invokestatic 698	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   997: iconst_1
    //   998: istore 12
    //   1000: goto +63 -> 1063
    //   1003: new 415	java/lang/StringBuilder
    //   1006: dup
    //   1007: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   1010: astore 24
    //   1012: aload 24
    //   1014: ldc_w 972
    //   1017: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: aload 24
    //   1023: aload 27
    //   1025: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: aload 24
    //   1031: ldc_w 974
    //   1034: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: pop
    //   1038: aload 24
    //   1040: aload 7
    //   1042: getfield 860	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:f	Ljava/lang/String;
    //   1045: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: ldc 165
    //   1051: iconst_1
    //   1052: aload 24
    //   1054: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1060: iconst_0
    //   1061: istore 12
    //   1063: aload 7
    //   1065: getfield 860	com/tencent/mobileqq/vashealth/shortVideo/HealthShortVideoUtils$ApplyUploadRsp:f	Ljava/lang/String;
    //   1068: astore 24
    //   1070: aload_2
    //   1071: invokevirtual 918	java/io/RandomAccessFile:close	()V
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
    //   1101: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1104: ifeq +197 -> 1301
    //   1107: ldc 165
    //   1109: iconst_2
    //   1110: aload 6
    //   1112: invokestatic 922	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1115: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1158: ldc_w 826
    //   1161: astore 6
    //   1163: aconst_null
    //   1164: astore_2
    //   1165: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1168: ifeq +43 -> 1211
    //   1171: new 415	java/lang/StringBuilder
    //   1174: dup
    //   1175: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   1178: astore 23
    //   1180: aload 23
    //   1182: ldc_w 976
    //   1185: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: pop
    //   1189: aload 23
    //   1191: aload 7
    //   1193: invokestatic 922	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1196: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: pop
    //   1200: ldc 165
    //   1202: iconst_2
    //   1203: aload 23
    //   1205: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1211: aload 6
    //   1213: astore 7
    //   1215: aload_2
    //   1216: ifnull +78 -> 1294
    //   1219: aload_2
    //   1220: invokevirtual 918	java/io/RandomAccessFile:close	()V
    //   1223: aload 6
    //   1225: astore 7
    //   1227: goto +67 -> 1294
    //   1230: astore_2
    //   1231: aload 6
    //   1233: astore 7
    //   1235: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1238: ifeq +56 -> 1294
    //   1241: ldc 165
    //   1243: iconst_2
    //   1244: aload_2
    //   1245: invokestatic 922	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1248: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1251: aload 6
    //   1253: astore 7
    //   1255: goto +39 -> 1294
    //   1258: astore_1
    //   1259: aload_2
    //   1260: ifnull +27 -> 1287
    //   1263: aload_2
    //   1264: invokevirtual 918	java/io/RandomAccessFile:close	()V
    //   1267: goto +20 -> 1287
    //   1270: astore_2
    //   1271: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1274: ifeq +13 -> 1287
    //   1277: ldc 165
    //   1279: iconst_2
    //   1280: aload_2
    //   1281: invokestatic 922	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1284: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1287: aload_1
    //   1288: athrow
    //   1289: ldc_w 826
    //   1292: astore 7
    //   1294: ldc_w 978
    //   1297: astore_2
    //   1298: iconst_0
    //   1299: istore 13
    //   1301: iload 13
    //   1303: ifeq +685 -> 1988
    //   1306: new 980	java/net/URL
    //   1309: dup
    //   1310: aload_1
    //   1311: invokespecial 981	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1314: invokevirtual 985	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1317: checkcast 987	java/net/HttpURLConnection
    //   1320: astore_1
    //   1321: aload_1
    //   1322: astore 6
    //   1324: aload_1
    //   1325: sipush 5000
    //   1328: invokevirtual 990	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1331: aload_1
    //   1332: astore 6
    //   1334: aload_1
    //   1335: sipush 30000
    //   1338: invokevirtual 993	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1341: aload_1
    //   1342: astore 6
    //   1344: aload_1
    //   1345: iconst_1
    //   1346: invokevirtual 996	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1349: aload_1
    //   1350: astore 6
    //   1352: aload_1
    //   1353: iconst_1
    //   1354: invokevirtual 999	java/net/HttpURLConnection:setDoInput	(Z)V
    //   1357: aload_1
    //   1358: astore 6
    //   1360: aload_1
    //   1361: iconst_0
    //   1362: invokevirtual 1002	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   1365: aload_1
    //   1366: astore 6
    //   1368: aload_1
    //   1369: ldc_w 1004
    //   1372: invokevirtual 1007	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1375: aload_1
    //   1376: astore 6
    //   1378: aload_1
    //   1379: ldc_w 1009
    //   1382: ldc_w 1011
    //   1385: invokevirtual 1014	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1388: aload_1
    //   1389: astore 6
    //   1391: new 415	java/lang/StringBuilder
    //   1394: dup
    //   1395: ldc_w 1016
    //   1398: invokespecial 1017	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1401: astore 23
    //   1403: aload_1
    //   1404: astore 6
    //   1406: aload 23
    //   1408: aload 7
    //   1410: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: pop
    //   1414: aload_1
    //   1415: astore 6
    //   1417: aload 23
    //   1419: getstatic 1020	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   1422: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: pop
    //   1426: aload_1
    //   1427: astore 6
    //   1429: aload 23
    //   1431: aload 7
    //   1433: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: pop
    //   1437: aload_1
    //   1438: astore 6
    //   1440: aload 23
    //   1442: getstatic 1025	android/os/Build:DEVICE	Ljava/lang/String;
    //   1445: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: pop
    //   1449: aload_1
    //   1450: astore 6
    //   1452: aload 23
    //   1454: aload 7
    //   1456: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: aload_1
    //   1461: astore 6
    //   1463: aload 23
    //   1465: getstatic 1028	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   1468: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: pop
    //   1472: aload_1
    //   1473: astore 6
    //   1475: aload 23
    //   1477: aload 7
    //   1479: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1482: pop
    //   1483: aload_1
    //   1484: astore 6
    //   1486: aload 23
    //   1488: ldc_w 1030
    //   1491: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: pop
    //   1495: aload_1
    //   1496: astore 6
    //   1498: aload_1
    //   1499: ldc_w 1032
    //   1502: aload 23
    //   1504: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1507: invokevirtual 1014	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1510: aload_1
    //   1511: astore 6
    //   1513: aload_1
    //   1514: ldc_w 1034
    //   1517: ldc_w 1036
    //   1520: invokevirtual 1014	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1523: aload_1
    //   1524: astore 6
    //   1526: new 415	java/lang/StringBuilder
    //   1529: dup
    //   1530: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   1533: astore 7
    //   1535: aload_1
    //   1536: astore 6
    //   1538: aload 7
    //   1540: ldc_w 1038
    //   1543: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: pop
    //   1547: aload_1
    //   1548: astore 6
    //   1550: aload 7
    //   1552: aload_3
    //   1553: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: pop
    //   1557: aload_1
    //   1558: astore 6
    //   1560: aload 7
    //   1562: ldc_w 1040
    //   1565: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: pop
    //   1569: aload_1
    //   1570: astore 6
    //   1572: aload 7
    //   1574: aload 4
    //   1576: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1579: pop
    //   1580: aload_1
    //   1581: astore 6
    //   1583: aload_1
    //   1584: ldc_w 1042
    //   1587: aload 7
    //   1589: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1592: invokevirtual 1014	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1595: aload_1
    //   1596: astore 6
    //   1598: new 1044	java/lang/StringBuffer
    //   1601: dup
    //   1602: invokespecial 1045	java/lang/StringBuffer:<init>	()V
    //   1605: astore_3
    //   1606: aload_1
    //   1607: astore 6
    //   1609: aload_3
    //   1610: ldc_w 1047
    //   1613: invokevirtual 1050	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1616: pop
    //   1617: aload_1
    //   1618: astore 6
    //   1620: aload_3
    //   1621: aload_2
    //   1622: invokevirtual 1050	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1625: pop
    //   1626: aload_1
    //   1627: astore 6
    //   1629: aload_3
    //   1630: ldc_w 1052
    //   1633: invokevirtual 1050	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1636: pop
    //   1637: aload_1
    //   1638: astore 6
    //   1640: aload_3
    //   1641: aload 5
    //   1643: ldc_w 1054
    //   1646: invokeinterface 1057 2 0
    //   1651: checkcast 120	java/lang/String
    //   1654: invokevirtual 1050	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1657: pop
    //   1658: aload_1
    //   1659: astore 6
    //   1661: new 1059	java/io/DataOutputStream
    //   1664: dup
    //   1665: aload_1
    //   1666: invokevirtual 1063	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1669: invokespecial 1066	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1672: astore 4
    //   1674: aload_1
    //   1675: astore 6
    //   1677: aload 4
    //   1679: aload_3
    //   1680: invokevirtual 1067	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1683: invokevirtual 1071	java/lang/String:getBytes	()[B
    //   1686: invokevirtual 1077	java/io/OutputStream:write	([B)V
    //   1689: aload_1
    //   1690: astore 6
    //   1692: aload 4
    //   1694: invokevirtual 1080	java/io/OutputStream:flush	()V
    //   1697: aload_1
    //   1698: astore 6
    //   1700: aload 4
    //   1702: invokevirtual 1081	java/io/OutputStream:close	()V
    //   1705: aload_1
    //   1706: astore 6
    //   1708: new 1044	java/lang/StringBuffer
    //   1711: dup
    //   1712: invokespecial 1045	java/lang/StringBuffer:<init>	()V
    //   1715: astore 4
    //   1717: aload_1
    //   1718: astore 6
    //   1720: new 1083	java/io/BufferedReader
    //   1723: dup
    //   1724: new 1085	java/io/InputStreamReader
    //   1727: dup
    //   1728: aload_1
    //   1729: invokevirtual 1089	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1732: invokespecial 1092	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1735: invokespecial 1095	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1738: astore_3
    //   1739: aload_1
    //   1740: astore 6
    //   1742: aload_3
    //   1743: invokevirtual 1098	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1746: astore 7
    //   1748: aload 7
    //   1750: ifnull +29 -> 1779
    //   1753: aload_1
    //   1754: astore 6
    //   1756: aload 4
    //   1758: aload 7
    //   1760: invokevirtual 1050	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1763: pop
    //   1764: aload_1
    //   1765: astore 6
    //   1767: aload 4
    //   1769: ldc_w 1100
    //   1772: invokevirtual 1050	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1775: pop
    //   1776: goto -37 -> 1739
    //   1779: aload_1
    //   1780: astore 6
    //   1782: aload 4
    //   1784: invokevirtual 1067	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1787: astore 4
    //   1789: aload_1
    //   1790: astore 6
    //   1792: new 415	java/lang/StringBuilder
    //   1795: dup
    //   1796: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   1799: astore 7
    //   1801: aload_1
    //   1802: astore 6
    //   1804: aload 7
    //   1806: ldc_w 1102
    //   1809: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1812: pop
    //   1813: aload_1
    //   1814: astore 6
    //   1816: aload 7
    //   1818: aload_2
    //   1819: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1822: pop
    //   1823: aload_1
    //   1824: astore 6
    //   1826: aload 7
    //   1828: ldc_w 1104
    //   1831: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: pop
    //   1835: aload_1
    //   1836: astore 6
    //   1838: aload 7
    //   1840: aload 5
    //   1842: ldc_w 1054
    //   1845: invokeinterface 1057 2 0
    //   1850: checkcast 120	java/lang/String
    //   1853: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: pop
    //   1857: aload_1
    //   1858: astore 6
    //   1860: aload 7
    //   1862: ldc_w 1106
    //   1865: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1868: pop
    //   1869: aload_1
    //   1870: astore 6
    //   1872: aload 7
    //   1874: aload 4
    //   1876: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1879: pop
    //   1880: aload_1
    //   1881: astore 6
    //   1883: ldc 165
    //   1885: iconst_1
    //   1886: aload 7
    //   1888: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1891: invokestatic 698	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1894: aload_1
    //   1895: astore 6
    //   1897: aload_3
    //   1898: invokevirtual 1107	java/io/BufferedReader:close	()V
    //   1901: aload_1
    //   1902: ifnull +118 -> 2020
    //   1905: goto +65 -> 1970
    //   1908: astore_2
    //   1909: goto +13 -> 1922
    //   1912: astore_1
    //   1913: aconst_null
    //   1914: astore 6
    //   1916: goto +60 -> 1976
    //   1919: astore_2
    //   1920: aconst_null
    //   1921: astore_1
    //   1922: aload_1
    //   1923: astore 6
    //   1925: new 415	java/lang/StringBuilder
    //   1928: dup
    //   1929: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   1932: astore_3
    //   1933: aload_1
    //   1934: astore 6
    //   1936: aload_3
    //   1937: ldc_w 1109
    //   1940: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1943: pop
    //   1944: aload_1
    //   1945: astore 6
    //   1947: aload_3
    //   1948: aload_2
    //   1949: invokevirtual 953	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1952: pop
    //   1953: aload_1
    //   1954: astore 6
    //   1956: ldc 165
    //   1958: iconst_2
    //   1959: aload_3
    //   1960: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1963: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1966: aload_1
    //   1967: ifnull +53 -> 2020
    //   1970: aload_1
    //   1971: invokevirtual 1112	java/net/HttpURLConnection:disconnect	()V
    //   1974: return
    //   1975: astore_1
    //   1976: aload 6
    //   1978: ifnull +8 -> 1986
    //   1981: aload 6
    //   1983: invokevirtual 1112	java/net/HttpURLConnection:disconnect	()V
    //   1986: aload_1
    //   1987: athrow
    //   1988: new 415	java/lang/StringBuilder
    //   1991: dup
    //   1992: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   1995: astore_1
    //   1996: aload_1
    //   1997: ldc_w 1114
    //   2000: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2003: pop
    //   2004: aload_1
    //   2005: aload_2
    //   2006: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2009: pop
    //   2010: ldc 165
    //   2012: iconst_1
    //   2013: aload_1
    //   2014: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2017: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2020: return
    //   2021: goto -1396 -> 625
    //   2024: goto -1193 -> 831
    //   2027: goto -1712 -> 315
    //   2030: aload 23
    //   2032: astore 7
    //   2034: iconst_1
    //   2035: istore 12
    //   2037: goto -1090 -> 947
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2040	0	this	HealthBusinessPlugin
    //   0	2040	1	paramString1	String
    //   0	2040	2	paramString2	String
    //   0	2040	3	paramString3	String
    //   0	2040	4	paramString4	String
    //   0	2040	5	paramMap	java.util.Map<String, String>
    //   0	2040	6	paramBundle	android.os.Bundle
    //   0	2040	7	paramUploadThread	HealthBusinessPlugin.UploadThread
    //   527	144	8	d1	double
    //   532	130	10	d2	double
    //   321	1715	12	i1	int
    //   136	1166	13	i2	int
    //   8	972	14	l1	long
    //   309	621	16	l2	long
    //   42	886	18	l3	long
    //   32	900	20	l4	long
    //   359	3	22	bool	boolean
    //   21	2010	23	localObject1	Object
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
    //   1324	1331	1908	java/lang/Exception
    //   1334	1341	1908	java/lang/Exception
    //   1344	1349	1908	java/lang/Exception
    //   1352	1357	1908	java/lang/Exception
    //   1360	1365	1908	java/lang/Exception
    //   1368	1375	1908	java/lang/Exception
    //   1378	1388	1908	java/lang/Exception
    //   1391	1403	1908	java/lang/Exception
    //   1406	1414	1908	java/lang/Exception
    //   1417	1426	1908	java/lang/Exception
    //   1429	1437	1908	java/lang/Exception
    //   1440	1449	1908	java/lang/Exception
    //   1452	1460	1908	java/lang/Exception
    //   1463	1472	1908	java/lang/Exception
    //   1475	1483	1908	java/lang/Exception
    //   1486	1495	1908	java/lang/Exception
    //   1498	1510	1908	java/lang/Exception
    //   1513	1523	1908	java/lang/Exception
    //   1526	1535	1908	java/lang/Exception
    //   1538	1547	1908	java/lang/Exception
    //   1550	1557	1908	java/lang/Exception
    //   1560	1569	1908	java/lang/Exception
    //   1572	1580	1908	java/lang/Exception
    //   1583	1595	1908	java/lang/Exception
    //   1598	1606	1908	java/lang/Exception
    //   1609	1617	1908	java/lang/Exception
    //   1620	1626	1908	java/lang/Exception
    //   1629	1637	1908	java/lang/Exception
    //   1640	1658	1908	java/lang/Exception
    //   1661	1674	1908	java/lang/Exception
    //   1677	1689	1908	java/lang/Exception
    //   1692	1697	1908	java/lang/Exception
    //   1700	1705	1908	java/lang/Exception
    //   1708	1717	1908	java/lang/Exception
    //   1720	1739	1908	java/lang/Exception
    //   1742	1748	1908	java/lang/Exception
    //   1756	1764	1908	java/lang/Exception
    //   1767	1776	1908	java/lang/Exception
    //   1782	1789	1908	java/lang/Exception
    //   1792	1801	1908	java/lang/Exception
    //   1804	1813	1908	java/lang/Exception
    //   1816	1823	1908	java/lang/Exception
    //   1826	1835	1908	java/lang/Exception
    //   1838	1857	1908	java/lang/Exception
    //   1860	1869	1908	java/lang/Exception
    //   1872	1880	1908	java/lang/Exception
    //   1883	1894	1908	java/lang/Exception
    //   1897	1901	1908	java/lang/Exception
    //   1306	1321	1912	finally
    //   1306	1321	1919	java/lang/Exception
    //   1324	1331	1975	finally
    //   1334	1341	1975	finally
    //   1344	1349	1975	finally
    //   1352	1357	1975	finally
    //   1360	1365	1975	finally
    //   1368	1375	1975	finally
    //   1378	1388	1975	finally
    //   1391	1403	1975	finally
    //   1406	1414	1975	finally
    //   1417	1426	1975	finally
    //   1429	1437	1975	finally
    //   1440	1449	1975	finally
    //   1452	1460	1975	finally
    //   1463	1472	1975	finally
    //   1475	1483	1975	finally
    //   1486	1495	1975	finally
    //   1498	1510	1975	finally
    //   1513	1523	1975	finally
    //   1526	1535	1975	finally
    //   1538	1547	1975	finally
    //   1550	1557	1975	finally
    //   1560	1569	1975	finally
    //   1572	1580	1975	finally
    //   1583	1595	1975	finally
    //   1598	1606	1975	finally
    //   1609	1617	1975	finally
    //   1620	1626	1975	finally
    //   1629	1637	1975	finally
    //   1640	1658	1975	finally
    //   1661	1674	1975	finally
    //   1677	1689	1975	finally
    //   1692	1697	1975	finally
    //   1700	1705	1975	finally
    //   1708	1717	1975	finally
    //   1720	1739	1975	finally
    //   1742	1748	1975	finally
    //   1756	1764	1975	finally
    //   1767	1776	1975	finally
    //   1782	1789	1975	finally
    //   1792	1801	1975	finally
    //   1804	1813	1975	finally
    //   1816	1823	1975	finally
    //   1826	1835	1975	finally
    //   1838	1857	1975	finally
    //   1860	1869	1975	finally
    //   1872	1880	1975	finally
    //   1883	1894	1975	finally
    //   1897	1901	1975	finally
    //   1925	1933	1975	finally
    //   1936	1944	1975	finally
    //   1947	1953	1975	finally
    //   1956	1966	1975	finally
  }
  
  void a(List<String> paramList)
  {
    SharedPreferences localSharedPreferences = b();
    Object localObject = localSharedPreferences.getString(this.c, null);
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
      localSharedPreferences.edit().putString(this.c, ((JSONObject)localObject).toString()).commit();
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
    if (this.l != null)
    {
      if ("".equals(paramJSONObject))
      {
        paramJSONObject = this.l.keySet().iterator();
        while (paramJSONObject.hasNext())
        {
          localObject1 = (String)paramJSONObject.next();
          if (((ISuperPlayer)this.l.get(localObject1)).getCurrentPositionMs() >= 3L) {
            this.p.put(localObject1, Long.valueOf(((ISuperPlayer)this.l.get(localObject1)).getCurrentPositionMs()));
          }
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("time to upload:");
          ((StringBuilder)localObject2).append(((ISuperPlayer)this.l.get(localObject1)).getCurrentPositionMs());
          QLog.d("HealthBusinessPlugin", 1, ((StringBuilder)localObject2).toString());
          ReportController.b(null, "dc00899", "yundong", "", "yundong_shipin", "", 0, 0, String.valueOf((int)(((ISuperPlayer)this.l.get(localObject1)).getCurrentPositionMs() / 1000L)), "", (String)localObject1, "");
          this.p.remove(localObject1);
          ((Timer)this.o.get(localObject1)).cancel();
          localObject2 = (FrameLayout)this.m.get(localObject1);
          ((ViewGroup)((FrameLayout)localObject2).getParent()).removeView((View)localObject2);
          this.m.remove(localObject1);
          this.n.remove(localObject1);
          this.o.remove(localObject1);
          this.p.remove(localObject1);
        }
        this.l.clear();
        return 0;
      }
      if (!this.l.containsKey(paramJSONObject)) {
        return -3;
      }
      if (((ISuperPlayer)this.l.get(paramJSONObject)).getCurrentPositionMs() >= 3L) {
        this.p.put(paramJSONObject, Long.valueOf(((ISuperPlayer)this.l.get(paramJSONObject)).getCurrentPositionMs()));
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("time to upload:");
      ((StringBuilder)localObject1).append(String.valueOf((int)(((ISuperPlayer)this.l.get(paramJSONObject)).getCurrentPositionMs() / 1000L)));
      QLog.d("HealthBusinessPlugin", 1, ((StringBuilder)localObject1).toString());
      ReportController.b(null, "dc00899", "yundong", "", "yundong_shipin", "", 0, 0, String.valueOf((int)(((ISuperPlayer)this.l.get(paramJSONObject)).getCurrentPositionMs() / 1000L)), "", paramJSONObject, "");
      this.p.remove(paramJSONObject);
      ((Timer)this.o.get(paramJSONObject)).cancel();
      localObject1 = (FrameLayout)this.m.get(paramJSONObject);
      ((ViewGroup)((FrameLayout)localObject1).getParent()).removeView((View)localObject1);
      this.l.remove(paramJSONObject);
      this.m.remove(paramJSONObject);
      this.n.remove(paramJSONObject);
      this.o.remove(paramJSONObject);
      this.p.remove(paramJSONObject);
      return 0;
    }
    paramJSONObject = this.K;
    if (paramJSONObject != null)
    {
      paramJSONObject.removeCallbacksAndMessages(null);
      this.K = null;
    }
    return -6;
  }
  
  SharedPreferences b()
  {
    Object localObject2 = this.mRuntime.b().getAccount();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "nologin";
    }
    localObject2 = this.mRuntime.b().getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("_health");
    return ((MobileQQ)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
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
    this.A = false;
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
    if (!this.l.containsKey(paramJSONObject)) {
      return -3;
    }
    Object localObject = this.l.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      ImageView localImageView = (ImageView)((FrameLayout)this.m.get(str)).findViewById(2131442519);
      if (str.equals(paramJSONObject)) {
        ((ISuperPlayer)this.l.get(paramJSONObject)).start();
      } else {
        ((ISuperPlayer)this.l.get(paramJSONObject)).pause();
      }
      localImageView.setVisibility(4);
    }
    return 0;
  }
  
  int d(JSONObject paramJSONObject)
  {
    this.A = true;
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
    if (!this.l.containsKey(paramJSONObject)) {
      return -3;
    }
    Object localObject = (ImageView)((FrameLayout)this.m.get(paramJSONObject)).findViewById(2131442519);
    ((ImageView)localObject).setImageResource(2130851145);
    ((ImageView)localObject).setVisibility(0);
    ((ISuperPlayer)this.l.get(paramJSONObject)).pause();
    this.g = true;
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
    int i2;
    int i1;
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
        i2 = paramString1.optInt("opType", 0);
        paramJsBridgeListener = new ArrayList();
        if (TextUtils.isEmpty(str))
        {
          this.c = String.valueOf(System.currentTimeMillis() / 1000L);
        }
        else
        {
          this.c = str;
          paramString1 = b().getString(str, null);
          if (!TextUtils.isEmpty(paramString1))
          {
            paramString1 = new JSONObject(paramString1).getJSONArray("imgList");
            paramJsBridgeListener.clear();
            i1 = 0;
            while (i1 < paramString1.length())
            {
              paramJsBridgeListener.add(paramString1.getString(i1));
              i1 += 1;
            }
          }
        }
        this.M.clear();
        this.M.addAll(paramJsBridgeListener);
        this.d = paramString2;
        paramJsBridgeListener = this.mRuntime.d();
        if (paramJsBridgeListener == null) {
          return true;
        }
        if (i2 == 0)
        {
          paramString1 = new Intent("android.intent.action.PICK");
          paramString1.setType("image/*");
          paramString1.putExtra("big_brother_source_key", "biz_src_gzh_health");
          startActivityForResult(paramString1, (byte)1);
          QAlbumUtil.anim(paramJsBridgeListener, false, true);
        }
        else if (i2 == 1)
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
          paramString1 = this.mRuntime.b().getAccount();
          paramJsBridgeListener = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            paramJsBridgeListener = "nologin";
          }
          paramString1 = this.mRuntime.b().getApplication();
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
            if (this.b == null)
            {
              paramString1 = this.mRuntime.d();
              this.b = new QQProgressDialog(paramString1, paramString1.getResources().getDimensionPixelSize(2131299920));
              this.b.c(2131891516);
            }
            if (!this.b.isShowing()) {
              this.b.show();
            }
            ThreadManager.post(new HealthBusinessPlugin.2(this, paramJsBridgeListener, paramString2), 5, null, true);
          }
        }
        else if ("deletePicture".equals(paramString3))
        {
          paramJsBridgeListener = b();
          if (TextUtils.isEmpty(paramString2)) {
            return true;
          }
          paramString1 = paramString1.optString("path");
          if (TextUtils.isEmpty(paramString1)) {
            break label2904;
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
            i1 = 0;
            if (i1 < ((JSONArray)localObject).length())
            {
              if (paramString1.equals(((JSONArray)localObject).getString(i1))) {
                break label2895;
              }
              paramString3.put(((JSONArray)localObject).getString(i1));
              break label2895;
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
            paramString3 = paramString1.optString("tag", HardCodeUtil.a(2131903426));
            paramString1 = paramString1.optString("cat", HardCodeUtil.a(2131903427));
            paramVarArgs = this.mRuntime.b().getApplication().getSharedPreferences("groupid_feedid", 0).edit();
            paramVarArgs.putString(str, paramJsBridgeListener);
            paramVarArgs.commit();
            if (TextUtils.isEmpty(str)) {
              break label2917;
            }
            if (TextUtils.isEmpty(paramJsBridgeListener)) {
              return true;
            }
            if (f.contains(str))
            {
              if (!QLog.isColorLevel()) {
                break label2906;
              }
              QLog.i("HealthBusinessPlugin", 2, "group enqueued.");
              return true;
            }
            f.add(str);
            localObject = b().getString(str, null);
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
              i1 = 0;
              label1034:
              if (i1 < paramString2.length())
              {
                localObject = paramString2.getString(i1);
                if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).startsWith("http")) || (((String)localObject).equals("error"))) {
                  break label2908;
                }
                paramVarArgs.add(paramString2.getString(i1));
                break label2908;
              }
            }
            else
            {
              paramVarArgs.add(paramString2.getString("video_dir"));
            }
            if ((this.mRuntime.d() instanceof QBaseActivity))
            {
              paramJsBridgeListener = new HealthBusinessPlugin.UploadThread(this, (QBaseActivity)this.mRuntime.d(), paramVarArgs, paramJsBridgeListener, str, bool, paramString3, paramString1);
              h.put(str, paramJsBridgeListener);
              ThreadManager.post(paramJsBridgeListener, 5, null, false);
            }
          }
          else if ("deleteGroup".equals(paramString3))
          {
            if (TextUtils.isEmpty(paramString2)) {
              return true;
            }
            paramJsBridgeListener = b();
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
            paramJsBridgeListener = this.mRuntime.d().getApplication().getSharedPreferences("groupid_feedid", 0);
            if (paramJsBridgeListener == null) {
              break label2919;
            }
            i1 = 1;
            break label2922;
            label1327:
            if ((i1 & i2) == 0) {
              break label2939;
            }
            paramJsBridgeListener.edit().remove(str).commit();
            break label2939;
            label1357:
            paramString1.put("msg", paramJsBridgeListener);
            super.callJs(paramString2, new String[] { paramString1.toString() });
          }
          else if ("shortVideo".equals(paramString3))
          {
            if (!TextUtils.isEmpty(paramString2)) {
              this.d = paramString2;
            }
            a(paramString1.optInt("sizeBeforeCompress", 104857600), paramString1.optInt("durationMax", 180) * 1000, paramString1.optInt("sizeAfterCompress", 10485760), paramString1.optInt("durationRecord", 20));
          }
          else if ("getVideoInfo".equals(paramString3))
          {
            if (TextUtils.isEmpty(paramString2)) {
              break label2958;
            }
            if (TextUtils.isEmpty(str)) {
              return true;
            }
            paramJsBridgeListener = b().getString(str, null);
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
      QLog.e("HealthBusinessPlugin", 1, "[handleJsRequest] error=", paramJsBridgeListener);
      label2876:
      return true;
    }
    try
    {
      paramJsBridgeListener.put("retCode", 0);
      paramJsBridgeListener.put("videoCount", f.size());
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("videoCount:");
        paramString1.append(f.size());
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
    break label2876;
    if ("uploadVideoList".equals(paramString3))
    {
      paramString1 = new JSONObject();
      paramString3 = new JSONArray();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < f.size())
      {
        paramVarArgs = new JSONObject();
        paramVarArgs.put("groupID", f.get(i1));
        paramVarArgs.put("feedID", this.mRuntime.d().getApplication().getSharedPreferences("groupid_feedid", 0).getString((String)f.get(i1), ""));
        str = (String)f.get(i1);
        str = b().getString(str, null);
        if (TextUtils.isEmpty(str)) {
          break label2963;
        }
        localObject = new JSONObject(str);
        str = ((JSONObject)localObject).getString(paramJsBridgeListener);
        localObject = ((JSONObject)localObject).optString("thumb_dir");
        File localFile = new File(str);
        if ((!localFile.exists()) || (!localFile.isFile())) {
          break label2960;
        }
        paramVarArgs.put("videoSize", localFile.length() / 1024L);
      }
      label2958:
      label2960:
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
        break label2963;
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
        break label2876;
        if ("deleteUploadVideo".equals(paramString3))
        {
          paramJsBridgeListener = new JSONObject();
          paramString1 = paramString1.optString("groupID");
          paramString1 = (HealthBusinessPlugin.UploadThread)h.get(paramString1);
          if (paramString1 != null)
          {
            paramString1.a = true;
            if (QLog.isColorLevel())
            {
              paramString3 = new StringBuilder();
              paramString3.append("queue length before directly:");
              paramString3.append(f.size());
              QLog.d("HealthBusinessPlugin", 2, paramString3.toString());
            }
            f.remove(paramString1.e);
            i.remove(paramString1.e);
            h.remove(paramString1.e);
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("queue length after directly:");
              paramString1.append(f.size());
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
          if (!this.l.containsKey(paramString1))
          {
            paramJsBridgeListener.put("retCode", -3);
            callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
            return false;
          }
          ((ISuperPlayer)this.l.get(paramString1)).stop();
          paramJsBridgeListener.put("retCode", 0);
          callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
        }
        else if ("wifiStatus".equals(paramString3))
        {
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("retCode", NetworkUtil.isWifiConnected(this.mRuntime.d()));
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
              paramString2 = new NewIntent(this.mRuntime.b().getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
              a(paramJsBridgeListener);
              paramString2.putExtra("cmd", "PubAccountFollowSvc.follow");
              paramString3 = new mobileqq_mp.FollowRequest();
              paramString3.uin.set((int)Long.parseLong(paramJsBridgeListener));
              paramString3.type.set(-1);
              paramString3.ext.set(String.valueOf(0));
              paramString2.setObserver(new HealthBusinessPlugin.4(this, paramString1));
              paramString2.putExtra("data", paramString3.toByteArray());
              this.mRuntime.b().startServlet(paramString2);
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.e("HealthBusinessPlugin", 1, "[followUin] error=", paramJsBridgeListener);
            }
          }
        }
        return true;
        label2895:
        i1 += 1;
        break;
        label2904:
        return true;
        label2906:
        return true;
        label2908:
        i1 += 1;
        break label1034;
        label2917:
        return true;
        label2919:
        i1 = 0;
        label2922:
        if (str != null)
        {
          i2 = 1;
          break label1327;
        }
        i2 = 0;
        break label1327;
        label2939:
        if (bool)
        {
          paramJsBridgeListener = "success.";
          break label1357;
        }
        paramJsBridgeListener = "group not found.";
        break label1357;
        return true;
      }
      label2963:
      i1 += 1;
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
        localObject1 = new ArrayList(this.M);
        this.M.clear();
        paramIntent = FileProvider7Helper.getRealPathFromContentURI(this.mRuntime.d(), paramIntent.getData());
        if ((!TextUtils.isEmpty(paramIntent)) && (!((List)localObject1).contains(paramIntent))) {
          ((List)localObject1).add(paramIntent);
        }
        if (((List)localObject1).isEmpty()) {
          return;
        }
        if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.d)))
        {
          paramIntent = new JSONObject();
          try
          {
            paramIntent.put("group_id", this.c);
          }
          catch (Exception localException)
          {
            QLog.e("HealthBusinessPlugin", 1, localException, new Object[0]);
          }
          super.callJs(this.d, new String[] { paramIntent.toString() });
          a((List)localObject1);
          ThreadManager.post(new HealthBusinessPlugin.6(this, (List)localObject1), 5, null, true);
          return;
        }
        QLog.e("HealthBusinessPlugin", 1, "miss id parameter!");
        return;
      }
      if (paramInt == 16)
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
        if ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.c)))
        {
          localObject2 = new JSONObject();
          if (paramInt == -1)
          {
            if ((this.mRuntime != null) && (this.mRuntime.d() != null))
            {
              paramIntent = this.mRuntime.d().getApplicationContext();
              localObject3 = BaseImageUtil.b(paramIntent, this.a);
              BaseImageUtil.b(paramIntent, (String)localObject3);
              SharedPreferences localSharedPreferences = b();
              localObject1 = localSharedPreferences.getString(this.c, null);
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
                localSharedPreferences.edit().putString(this.c, paramIntent.toString()).commit();
                ((JSONObject)localObject2).put("group_id", this.c);
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
          if ((this.mRuntime != null) && (this.mRuntime.d() != null)) {
            super.callJs(this.d, new String[] { ((JSONObject)localObject2).toString() });
          }
        }
        else
        {
          QLog.e("HealthBusinessPlugin", 1, "value miss!");
        }
      }
      else if (paramByte == 3)
      {
        e();
        if (paramInt == -1)
        {
          localObject1 = this.L;
          paramIntent = paramIntent.getStringExtra("thumb_dir");
          localObject2 = String.valueOf(System.currentTimeMillis() / 1000L);
          if (!TextUtils.isEmpty(this.d)) {
            try
            {
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("group_id", localObject2);
              super.callJs(this.d, new String[] { ((JSONObject)localObject3).toString() });
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("video_dir", localObject1);
              if (!TextUtils.isEmpty(paramIntent)) {
                ((JSONObject)localObject3).put("thumb_dir", paramIntent);
              } else {
                QLog.e("HealthBusinessPlugin", 1, "video thumb path miss!");
              }
              b().edit().putString((String)localObject2, ((JSONObject)localObject3).toString()).commit();
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
  }
  
  protected void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "oncreated ......");
    }
    super.onCreate();
    if (!QQVideoPlaySDKManager.isSDKReady()) {
      QQVideoPlaySDKManager.initSDKAsync(this.mRuntime.c().getApplication(), null);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    c();
    this.r.removeView(this.q);
    AppNetConnInfo.unregisterNetInfoHandler(this.w);
    AVBizModuleFactory.removeModuleByName("运动");
    QLog.d("HealthBusinessPlugin", 1, "onDestroy");
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    paramCustomWebView = new FrameLayout.LayoutParams(-1, -1);
    paramCustomWebView.topMargin = 0;
    paramCustomWebView.leftMargin = 0;
    this.r = ((RefreshView)this.mRuntime.d().findViewById(2131450099));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("videoLayout id:");
      localStringBuilder.append(this.r.getResources());
      QLog.d("HealthBusinessPlugin", 2, localStringBuilder.toString());
    }
    this.q = new FrameLayout(this.mRuntime.d());
    this.r.addView(this.q, paramCustomWebView);
    this.s = ((TouchWebView)this.mRuntime.a());
    this.q.scrollBy(0, this.s.mTotalYoffset);
    this.s.setOnScrollChangedListenerForBiz(new HealthBusinessPlugin.1(this));
    QLog.d("HealthBusinessPlugin", 1, "onWebViewCreated");
    this.w = new HealthBusinessPlugin.MyNetInfoHandler(this, this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.mRuntime.d(), this.w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin
 * JD-Core Version:    0.7.0.1
 */