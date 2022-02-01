package com.tencent.mobileqq.kandian.biz.ugc;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.utils.image.ImageUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.biu.BiuEditText;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.ugc.capture.ReadInJoyUgcVideoReportItem;
import com.tencent.mobileqq.kandian.biz.ugc.capture.ReadInJoyVideoCompositeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ReadInJoyDeliverVideoActivity
  extends ReadInJoyBaseDeliverActivity
  implements Handler.Callback, ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig
{
  protected Dialog a;
  private View aA;
  private CircleProgress aB;
  private TextView aC;
  private View aD;
  private TextView aE;
  private long aF = 0L;
  private boolean aG = false;
  private String aH = "";
  private boolean aI;
  private String aJ;
  private Bundle aK;
  private long aL;
  private boolean aM = false;
  private boolean aN = false;
  private boolean aO = false;
  private boolean aP = false;
  private ReadInJoyVideoCompositeManager aQ;
  private boolean aR = false;
  private boolean aS = false;
  private long aT;
  private long aU;
  private long aV;
  private String aW;
  private List<ReadInJoyUgcVideoReportItem> aX;
  private String ag = null;
  private int ah = 0;
  private int ai = 0;
  private long aj = 0L;
  private String ak = null;
  private String al = null;
  private String am = null;
  private String an = null;
  private String ao = null;
  private String ap = null;
  private int aq = 0;
  private int ar = 0;
  private String as;
  private ArrayList<TagInfo> at = new ArrayList();
  private boolean au = true;
  private PopupWindow av;
  private View aw;
  private KandianUrlImageView ax;
  private ImageView ay;
  private TextView az;
  ReadInJoyObserver b = new ReadInJoyDeliverVideoActivity.1(this);
  private final MqqHandler c = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private String d = null;
  
  private void A()
  {
    this.aM = VideoEnvironment.supportShortVideoRecordAndPlay();
    this.aN = VideoEnvironment.checkAndLoadAVCodec();
    if (!this.aM)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131910441), null);
      return;
    }
    if (this.aN)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件ready", null);
      return;
    }
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件not ready", null);
    if (NetworkUtil.isNetworkAvailable(null))
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131910399), null);
      ShortVideoResourceManager.b(this.app, this);
      this.aO = true;
      return;
    }
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131910439), null);
  }
  
  private void B()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(this.e.getWindowToken(), 0);
    }
  }
  
  private void C()
  {
    this.aE = ((TextView)findViewById(2131430186));
    this.aE.setOnClickListener(this);
    this.av = new PopupWindow(LayoutInflater.from(this).inflate(2131626353, (ViewGroup)this.mContentView, false), -2, -2);
    this.av.setAnimationStyle(2131952300);
    this.au = true;
  }
  
  private void D()
  {
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", this.at);
    localIntent.putExtra("EXTRA_TOPIC_ID", this.G);
    QPublicFragmentActivity.startForResult(this, localIntent, ReadInJoyVideoTagSelectionFragment.class, 1000);
    PublicAccountReportUtils.a(null, "", "0X80092F1", "0X80092F1", 0, 0, "", "", "", RIJTransMergeKanDianReport.e(), false);
  }
  
  private void a(float paramFloat)
  {
    if (this.aA.getVisibility() != 0) {
      this.aA.setVisibility(0);
    }
    if (this.aD.getVisibility() != 0) {
      this.aD.setVisibility(0);
    }
    this.aB.setProgress(paramFloat);
  }
  
  private void a(ArrayList<TagInfo> paramArrayList)
  {
    this.at = paramArrayList;
    String str = getString(2131915512);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localStringBuilder.append(paramArrayList.get(0));
      int j = paramArrayList.size();
      int i = 1;
      while (i < j)
      {
        localStringBuilder.append("，");
        localStringBuilder.append(paramArrayList.get(i));
        i += 1;
      }
      paramArrayList = localStringBuilder.toString();
      this.aE.setSelected(true);
    }
    else
    {
      this.aE.setSelected(false);
      paramArrayList = str;
    }
    this.aE.setText(paramArrayList);
  }
  
  private void c(String paramString)
  {
    Intent localIntent = new Intent(this, ShortVideoPreviewActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverVideoActivity.class.getName());
    localIntent.putExtra("file_send_path", paramString);
    localIntent.putExtra("preview_only", true);
    startActivity(localIntent);
    overridePendingTransition(2130772427, 2130772429);
    PublicAccountReportUtils.a(this.app, "", "0X80081D9", "0X80081D9", 0, 0, "", "2", "", VideoReporter.b(null), false);
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "king moment cover url is null");
      return;
    }
    ImageRequest localImageRequest = new ImageRequest();
    try
    {
      localImageRequest.a = new URL(paramString);
      localImageRequest.c = this.ax.getHeight();
      localImageRequest.b = this.ax.getWidth();
      this.ax.setImageForImageCollection(localImageRequest, new ReadInJoyDeliverVideoActivity.5(this));
      return;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void s()
  {
    this.aQ = new ReadInJoyVideoCompositeManager();
    this.aQ.a(new ReadInJoyDeliverVideoActivity.2(this));
    PublishParam localPublishParam = (PublishParam)getIntent().getParcelableExtra(PublishParam.a);
    if (localPublishParam != null)
    {
      this.as = localPublishParam.b;
      this.aQ.a(this.as, this.d);
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: performCompositeVideo");
      return;
    }
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: publish param is null, no need to composite");
    this.az.setVisibility(4);
    this.ay.setVisibility(0);
    this.aw.setClickable(true);
    a(true);
  }
  
  private void t()
  {
    Object localObject;
    if ((this.ah == 0) || (this.ai == 0))
    {
      localObject = ShortVideoTrimmer.getVideoProperty(this.d);
      if ((localObject != null) && (localObject.length == 5))
      {
        this.ah = localObject[1];
        this.ai = localObject[2];
        this.aj = localObject[4];
        getIntent().putExtra("arg_video_width", this.ah);
        getIntent().putExtra("arg_video_height", this.ai);
        getIntent().putExtra("arg_video_duration", this.aj);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("generateVideoInfo width=");
          ((StringBuilder)localObject).append(this.ah);
          ((StringBuilder)localObject).append(", height=");
          ((StringBuilder)localObject).append(this.ai);
          ((StringBuilder)localObject).append(", duration=");
          ((StringBuilder)localObject).append(this.aj);
          QLog.d("ReadInJoyDeliverVideoActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    if (TextUtils.isEmpty(this.ag))
    {
      if (this.aj >= 3000L) {
        localObject = ShortVideoUtils.getVideoThumbnail(this, this.d, 640, 3000000L);
      } else {
        localObject = ShortVideoUtils.getVideoThumbnail(this, this.d, 640);
      }
      this.ag = ShortVideoPreviewActivity.coverToLocalImage((Bitmap)localObject);
      getIntent().putExtra("arg_video_cover", this.ag);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("generateVideoInfo cover=");
        ((StringBuilder)localObject).append(this.ag);
        QLog.d("ReadInJoyDeliverVideoActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private Intent u()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("arg_video_path", this.d);
    localIntent.putExtra("arg_video_cover", this.aH);
    localIntent.putExtra("supportShortVideo", this.aM);
    localIntent.putExtra("shortVideoSoReady", this.aN);
    localIntent.putExtra("commentString", k());
    localIntent.putExtra("mFakeVidForComposition", this.as);
    localIntent.putParcelableArrayListExtra("mSelectedTagList", this.at);
    localIntent.putExtra("arg_visible_set_params", this.aa);
    if (this.aI)
    {
      localIntent.putExtra("arg_video_cover", this.ag);
      localIntent.putExtras(this.aK);
    }
    if (this.T != null) {
      localIntent.putExtra("location", this.T);
    }
    Bundle localBundle = localIntent.getExtras();
    localIntent.setClass(getApplicationContext(), KandianVideoUploadService.class);
    ArrayList localArrayList = new ArrayList();
    Utils.a(this.e, this.app.getCurrentAccountUin(), this.S, localArrayList);
    if (localBundle != null)
    {
      localBundle.putParcelableArrayList("multiBiuStruct", localArrayList);
      localIntent.putExtras(localBundle);
    }
    return localIntent;
  }
  
  private void v()
  {
    this.aB.setProgress(0.0F);
    this.aA.setVisibility(8);
    this.aD.setVisibility(8);
  }
  
  private int w()
  {
    if (TextUtils.isEmpty(k())) {
      return 1;
    }
    return 2;
  }
  
  private void x()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("business url is ");
      ((StringBuilder)localObject).append(this.aJ);
      QLog.d("ReadInJoyDeliverVideoActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.aJ)) {
      return;
    }
    Object localObject = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.aJ);
    startActivity((Intent)localObject);
  }
  
  private void y()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.c.post(new ReadInJoyDeliverVideoActivity.6(this));
      return;
    }
    if (this.a == null)
    {
      this.a = a(this, null, getString(2131915559), new ReadInJoyDeliverVideoActivity.7(this), getString(2131915560), new ReadInJoyDeliverVideoActivity.8(this), getString(2131915561));
      this.a.setCanceledOnTouchOutside(false);
    }
    if (!this.a.isShowing()) {
      this.a.show();
    }
  }
  
  private void z()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.c.post(new ReadInJoyDeliverVideoActivity.9(this));
      return;
    }
    Dialog localDialog = this.a;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.a.dismiss();
    }
  }
  
  protected void a()
  {
    this.E = 178;
    super.a();
    this.aw = findViewById(2131449037);
    this.aw.setOnClickListener(this);
    this.aw.setClickable(false);
    this.ax = ((KandianUrlImageView)findViewById(2131449038));
    this.ay = ((ImageView)findViewById(2131449039));
    this.az = ((TextView)findViewById(2131449036));
    this.aD = new View(this);
    this.aD.setBackgroundColor(1996488704);
    addContentView(this.aD, new ViewGroup.LayoutParams(-1, -1));
    this.aD.setVisibility(8);
    this.aA = View.inflate(this, 2131626358, null);
    addContentView(this.aA, new ViewGroup.LayoutParams(-1, -1));
    this.aB = ((CircleProgress)this.aA.findViewById(2131449136));
    this.aB.setStrokeWidth(5.0F);
    this.aB.setBgAndProgressColor(100, -1, 100, getResources().getColor(2131167836));
    this.aC = ((TextView)this.aA.findViewById(2131430286));
    this.aC.setOnClickListener(this);
    C();
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    setRightButton(2131915363, this);
    a(false);
  }
  
  protected void a(Editable paramEditable)
  {
    super.a(paramEditable);
    int i = paramEditable.length();
    if (this.i != null) {
      this.i.setText(String.valueOf(this.u - i));
    }
    if (i - this.u > 0)
    {
      if (this.i != null) {
        this.i.setTextColor(Color.parseColor("#FF4222"));
      }
      this.t = true;
      return;
    }
    if (this.i != null) {
      this.i.setTextColor(Color.parseColor("#BBBBBB"));
    }
    this.t = false;
  }
  
  protected void b()
  {
    this.L = true;
    this.R = true;
    this.S = true;
    this.z = true;
    super.b();
    this.ad = "0X800865E";
    Object localObject = getIntent();
    this.d = ((Intent)localObject).getStringExtra("arg_video_path");
    this.ag = ((Intent)localObject).getStringExtra("arg_video_cover");
    this.ah = ((Intent)localObject).getIntExtra("arg_video_width", 0);
    this.ai = ((Intent)localObject).getIntExtra("arg_video_height", 0);
    this.aj = ((Intent)localObject).getLongExtra("arg_video_duration", 0L);
    this.aI = ((Intent)localObject).getBooleanExtra("arg_is_from_wang_zhe", false);
    this.aL = ((Intent)localObject).getLongExtra("arg_wang_zhe_app_id", 0L);
    this.aR = ((Intent)localObject).getBooleanExtra("is_from_dian_dian", false);
    this.aS = ((Intent)localObject).getBooleanExtra("is_from_kan_dian", false);
    this.aW = ((Intent)localObject).getStringExtra("captureMode");
    this.aX = ((Intent)localObject).getParcelableArrayListExtra("key_read_in_joy_video_upload_report");
    ReadInJoyLogicEngineEventDispatcher.a().a(this.b);
    t();
    b(this.ag);
    int i = ((Intent)localObject).getIntExtra("arg_video_source", 0);
    if (TextUtils.isEmpty(this.G)) {
      localObject = "0";
    } else {
      localObject = String.valueOf(this.G);
    }
    String str;
    if (this.aR) {
      str = "1";
    } else {
      str = "2";
    }
    PublicAccountReportUtils.a(null, "", "0X8008241", "0X8008241", 0, 0, String.valueOf(i), (String)localObject, str, RIJTransMergeKanDianReport.e(), false);
    this.y = true;
    if ((!this.y) && (this.g != null)) {
      this.g.setVisibility(8);
    }
    if (this.aI)
    {
      setRightViewTextDisable(0);
      this.e.setHint(getString(2131915337));
      this.c.postDelayed(new ReadInJoyDeliverVideoActivity.3(this), 30000L);
    }
    A();
  }
  
  protected void b(String paramString)
  {
    Object localObject;
    int i;
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      this.aH = paramString;
      localObject = new BitmapFactory.Options();
      int j = 1;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.aH, (BitmapFactory.Options)localObject);
      i = AIOUtils.b(110.0F, getResources());
      int k = AIOUtils.b(110.0F, getResources());
      float f1 = ((BitmapFactory.Options)localObject).outWidth / i;
      float f2 = ((BitmapFactory.Options)localObject).outHeight / k;
      this.aq = ((BitmapFactory.Options)localObject).outWidth;
      this.ar = ((BitmapFactory.Options)localObject).outHeight;
      getIntent().putExtra("arg_video_cover_width", this.aq);
      getIntent().putExtra("arg_video_cover_height", this.ar);
      i = j;
      if (f1 >= 1.0F)
      {
        i = j;
        if (f2 >= 1.0F) {
          i = (int)Math.floor(Math.min(f1, f2));
        }
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = i;
    }
    try
    {
      localObject = BitmapFactory.decodeFile(this.aH, (BitmapFactory.Options)localObject);
      localObject = ImageUtils.a(ImageUtils.a(this.aH), (Bitmap)localObject);
      this.ax.setImageBitmap((Bitmap)localObject);
      this.ax.setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setSelectedImage sampleSize=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", path=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ReadInJoyDeliverVideoActivity", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      label298:
      break label298;
    }
    this.ax.setImageDrawable(new ColorDrawable(-16777216));
    this.ax.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return;
    this.ax.setImageDrawable(new ColorDrawable(-16777216));
    this.ax.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.aA.getVisibility() == 0) {
      y();
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if (this.aA.getVisibility() == 0) {
      y();
    }
  }
  
  protected boolean c()
  {
    this.aV = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "onDeliver!");
    }
    PublicAccountReportUtils.a(this.app, "", "0X80081D8", "0X80081D8", 0, 0, "1", "2", "", VideoReporter.b(null), false);
    PublicAccountReportUtils.a(null, "", "0X8008245", "0X8008245", 0, 0, String.valueOf(w()), "", "", i(), false);
    if ((this.aH.equals("")) && (!this.aI))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverVideoActivity", 2, "onDeliver no video!");
      }
      a(1, getString(2131915362));
      return false;
    }
    if (!super.c()) {
      return false;
    }
    B();
    if (KandianVideoUploadService.a() >= 2)
    {
      QQToast.makeText(this, 0, getString(2131915357), 0).show(getResources().getDimensionPixelSize(2131299920));
      return false;
    }
    Intent localIntent = u();
    try
    {
      startService(localIntent);
      QLog.d("ReadInJoyDeliverVideoActivity", 1, "start video upload Service!");
      label202:
      if (this.aS) {
        ((IKandianSubscribeManager)this.app.getRuntimeService(IKandianSubscribeManager.class)).lanuchKandianSubscribeActivity(this, 4);
      } else {
        ReadInJoyLogicEngine.a().b(true);
      }
      finish();
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label202;
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "onEmotionBtn!");
    }
    PublicAccountReportUtils.a(null, "", "0X8008244", "0X8008244", 0, 0, "", "", "", RIJTransMergeKanDianReport.e(), false);
    super.d();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.aT = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    super.setContentView(2131626221);
    a(2131915364);
    a();
    b();
    s();
    RIJDtReportHelper.a.a(getActivity());
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.b);
    this.c.removeCallbacksAndMessages(null);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnPostResume()
  {
    super.doOnPostResume();
    this.aU = System.currentTimeMillis();
    StatisticCollector.getInstance(this).collectPerformance(getAppRuntime().getAccount(), "actReadInJoyEnterVideoDeliverPage", true, this.aU - this.aT, 0L, null, "");
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void e(int paramInt)
  {
    this.ac = 2;
    super.e(paramInt);
    PublicAccountReportUtils.a(null, "", "0X8009577", "0X8009577", 0, 0, "", "", "", RIJTransMergeKanDianReport.e(), false);
  }
  
  protected void f()
  {
    super.f();
    PublicAccountReportUtils.a(this.app, "", "0X80081D8", "0X80081D8", 0, 0, "2", "2", "", VideoReporter.b(null), false);
    PublicAccountReportUtils.a(null, "", "0X8008242", "0X8008242", 0, 0, String.valueOf(w()), "", "", RIJTransMergeKanDianReport.e(), false);
  }
  
  public void finish()
  {
    super.finish();
    ReadInJoyVideoCompositeManager localReadInJoyVideoCompositeManager = this.aQ;
    if (localReadInJoyVideoCompositeManager != null) {
      localReadInJoyVideoCompositeManager.a(null);
    }
  }
  
  protected void g()
  {
    super.g();
    PublicAccountReportUtils.a(null, "", "0X8008243", "0X8008243", 0, 0, String.valueOf(w()), "", "", RIJTransMergeKanDianReport.e(), false);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      this.c.removeMessages(100);
      v();
      a(1, getString(2131915555));
      return true;
    }
    if (paramMessage.what == 101)
    {
      this.c.removeMessages(101);
      v();
      a(1, getString(2131916627));
      return true;
    }
    if (paramMessage.what == 102)
    {
      this.c.removeMessages(102);
      v();
      a(1, getString(2131915557));
      return true;
    }
    if (paramMessage.what == 103)
    {
      this.c.removeMessages(103);
      v();
      return true;
    }
    if (paramMessage.what == 104)
    {
      this.c.removeMessages(104);
      v();
      z();
      a(1, getString(2131915562));
      return true;
    }
    if (paramMessage.what == 105)
    {
      this.c.removeMessages(105);
      v();
      a(1, getString(2131915556));
      return true;
    }
    if (paramMessage.what == 106)
    {
      this.c.removeMessages(106);
      v();
      a(1, getString(2131915563));
      return true;
    }
    if (paramMessage.what == 107)
    {
      this.c.removeMessages(107);
      v();
      if (this.aO)
      {
        a(0, getString(2131915566));
        return true;
      }
      a(0, getString(2131915565));
      return true;
    }
    if (paramMessage.what == 108) {
      a(((Float)paramMessage.obj).floatValue());
    }
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == -1)) {
      a(paramIntent.getParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST"));
    }
  }
  
  protected boolean onBackEvent()
  {
    if (!this.aG)
    {
      if ((this.aI) && (!this.aP)) {
        return super.onBackEvent();
      }
      a(false, 0, this.aI, this.aL);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131430186)
    {
      if (i != 2131430286)
      {
        if (i != 2131449037)
        {
          super.onClick(paramView);
          return;
        }
        if (!this.aI) {
          c(this.d);
        }
      }
      else
      {
        this.c.sendEmptyMessage(103);
        PublicAccountReportUtils.a(this.app, "", "0X80081DA", "0X80081DA", 0, 0, "", "", "", VideoReporter.b(null), false);
      }
    }
    else {
      D();
    }
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onConfigResult result=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", serverError=");
    ((StringBuilder)localObject).append(paramInt2);
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131910330));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", ((StringBuilder)localObject).toString(), null);
      ShortVideoErrorReport.a(1, paramInt2);
      this.aO = false;
      return;
    }
    if (paramInt2 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131910440));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", ((StringBuilder)localObject).toString(), null);
      ShortVideoErrorReport.a(1, paramInt2);
      this.aO = false;
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = ShortVideoResourceManager.a(this.app, (List)localObject);
    if (paramInt1 == 0)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131910517), null);
      ShortVideoResourceManager.a(this.app, (List)localObject, this);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131910522));
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("]");
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", ((StringBuilder)localObject).toString(), null);
    ShortVideoErrorReport.a(1, paramInt1);
    this.aO = false;
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131910350));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", localStringBuilder.toString(), null);
        ShortVideoErrorReport.a(2, paramInt);
      }
      else
      {
        this.aN = true;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131910432));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", localStringBuilder.toString(), null);
      }
      this.aO = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadFinish name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", filePath=");
    localStringBuilder.append(paramString2);
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", localStringBuilder.toString(), null);
  }
  
  public void onNetWorkNone()
  {
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131910501), null);
    ShortVideoErrorReport.a(3, -1500);
    this.aO = false;
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverVideoActivity
 * JD-Core Version:    0.7.0.1
 */