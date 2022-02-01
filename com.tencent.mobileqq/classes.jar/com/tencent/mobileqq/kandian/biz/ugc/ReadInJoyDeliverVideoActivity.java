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
import android.widget.EditText;
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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
import com.tencent.mobileqq.qroute.QRoute;
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
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private ReadInJoyVideoCompositeManager jdField_a_of_type_ComTencentMobileqqKandianBizUgcCaptureReadInJoyVideoCompositeManager;
  ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyDeliverVideoActivity.1(this);
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  private String jdField_a_of_type_JavaLangString = null;
  private List<ReadInJoyUgcVideoReportItem> jdField_a_of_type_JavaUtilList;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ArrayList<TagInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private long jdField_c_of_type_Long = 0L;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private long jdField_d_of_type_Long;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private long e;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString = null;
  private long jdField_g_of_type_Long;
  private String jdField_g_of_type_JavaLangString = null;
  private String h;
  private String i;
  private String j = null;
  private int jdField_k_of_type_Int = 0;
  private String jdField_k_of_type_JavaLangString = null;
  private int jdField_l_of_type_Int = 0;
  private String jdField_l_of_type_JavaLangString = null;
  private int jdField_m_of_type_Int = 0;
  private String jdField_m_of_type_JavaLangString;
  private int jdField_n_of_type_Int = 0;
  private String jdField_n_of_type_JavaLangString = "";
  private String o;
  private String p;
  private boolean q = true;
  private boolean r = false;
  private boolean s;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  
  public ReadInJoyDeliverVideoActivity()
  {
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
  }
  
  private int a()
  {
    if (TextUtils.isEmpty(c())) {
      return 1;
    }
    return 2;
  }
  
  private Intent a()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("arg_video_path", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("arg_video_cover", this.jdField_n_of_type_JavaLangString);
    localIntent.putExtra("supportShortVideo", this.t);
    localIntent.putExtra("shortVideoSoReady", this.u);
    localIntent.putExtra("commentString", c());
    localIntent.putExtra("mFakeVidForComposition", this.jdField_m_of_type_JavaLangString);
    localIntent.putParcelableArrayListExtra("mSelectedTagList", this.jdField_b_of_type_JavaUtilArrayList);
    localIntent.putExtra("arg_visible_set_params", this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructVisibleSetParam);
    if (this.s)
    {
      localIntent.putExtra("arg_video_cover", this.jdField_f_of_type_JavaLangString);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI != null) {
      localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI);
    }
    Bundle localBundle = localIntent.getExtras();
    localIntent.setClass(getApplicationContext(), KandianVideoUploadService.class);
    ArrayList localArrayList = new ArrayList();
    Utils.a(this.jdField_a_of_type_AndroidWidgetEditText, this.app.getCurrentAccountUin(), this.jdField_o_of_type_Boolean, localArrayList);
    if (localBundle != null)
    {
      localBundle.putParcelableArrayList("multiBiuStruct", localArrayList);
      localIntent.putExtras(localBundle);
    }
    return localIntent;
  }
  
  private void a(float paramFloat)
  {
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(paramFloat);
  }
  
  private void a(ArrayList<TagInfo> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    String str = getString(2131718031);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localStringBuilder.append(paramArrayList.get(0));
      int i2 = paramArrayList.size();
      int i1 = 1;
      while (i1 < i2)
      {
        localStringBuilder.append("，");
        localStringBuilder.append(paramArrayList.get(i1));
        i1 += 1;
      }
      paramArrayList = localStringBuilder.toString();
      this.jdField_d_of_type_AndroidWidgetTextView.setSelected(true);
    }
    else
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setSelected(false);
      paramArrayList = str;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramArrayList);
  }
  
  private void c(String paramString)
  {
    Intent localIntent = new Intent(this, ShortVideoPreviewActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverVideoActivity.class.getName());
    localIntent.putExtra("file_send_path", paramString);
    localIntent.putExtra("preview_only", true);
    startActivity(localIntent);
    overridePendingTransition(2130772335, 2130772337);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.app, "", "0X80081D9", "0X80081D9", 0, 0, "", "2", "", VideoReporter.a(null), false);
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
      localImageRequest.jdField_a_of_type_JavaNetURL = new URL(paramString);
      localImageRequest.b = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getHeight();
      localImageRequest.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getWidth();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageForImageCollection(localImageRequest, new ReadInJoyDeliverVideoActivity.5(this));
      return;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCaptureReadInJoyVideoCompositeManager = new ReadInJoyVideoCompositeManager();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCaptureReadInJoyVideoCompositeManager.a(new ReadInJoyDeliverVideoActivity.2(this));
    PublishParam localPublishParam = (PublishParam)getIntent().getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
    if (localPublishParam != null)
    {
      this.jdField_m_of_type_JavaLangString = localPublishParam.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCaptureReadInJoyVideoCompositeManager.a(this.jdField_m_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: performCompositeVideo");
      return;
    }
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: publish param is null, no need to composite");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    a(true);
  }
  
  private void n()
  {
    Object localObject;
    if ((this.jdField_k_of_type_Int == 0) || (this.jdField_l_of_type_Int == 0))
    {
      localObject = ShortVideoTrimmer.getVideoProperty(this.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (localObject.length == 5))
      {
        this.jdField_k_of_type_Int = localObject[1];
        this.jdField_l_of_type_Int = localObject[2];
        this.jdField_b_of_type_Long = localObject[4];
        getIntent().putExtra("arg_video_width", this.jdField_k_of_type_Int);
        getIntent().putExtra("arg_video_height", this.jdField_l_of_type_Int);
        getIntent().putExtra("arg_video_duration", this.jdField_b_of_type_Long);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("generateVideoInfo width=");
          ((StringBuilder)localObject).append(this.jdField_k_of_type_Int);
          ((StringBuilder)localObject).append(", height=");
          ((StringBuilder)localObject).append(this.jdField_l_of_type_Int);
          ((StringBuilder)localObject).append(", duration=");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
          QLog.d("ReadInJoyDeliverVideoActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      if (this.jdField_b_of_type_Long >= 3000L) {
        localObject = ShortVideoUtils.getVideoThumbnail(this, this.jdField_a_of_type_JavaLangString, 640, 3000000L);
      } else {
        localObject = ShortVideoUtils.getVideoThumbnail(this, this.jdField_a_of_type_JavaLangString, 640);
      }
      this.jdField_f_of_type_JavaLangString = ShortVideoPreviewActivity.coverToLocalImage((Bitmap)localObject);
      getIntent().putExtra("arg_video_cover", this.jdField_f_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("generateVideoInfo cover=");
        ((StringBuilder)localObject).append(this.jdField_f_of_type_JavaLangString);
        QLog.d("ReadInJoyDeliverVideoActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void p()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("business url is ");
      ((StringBuilder)localObject).append(this.jdField_o_of_type_JavaLangString);
      QLog.d("ReadInJoyDeliverVideoActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)) {
      return;
    }
    Object localObject = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_o_of_type_JavaLangString);
    startActivity((Intent)localObject);
  }
  
  private void q()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ReadInJoyDeliverVideoActivity.6(this));
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = a(this, null, getString(2131718081), new ReadInJoyDeliverVideoActivity.7(this), getString(2131718082), new ReadInJoyDeliverVideoActivity.8(this), getString(2131718083));
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    }
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void r()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ReadInJoyDeliverVideoActivity.9(this));
      return;
    }
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void s()
  {
    this.t = VideoEnvironment.supportShortVideoRecordAndPlay();
    this.u = VideoEnvironment.checkAndLoadAVCodec();
    if (!this.t)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131712870), null);
      return;
    }
    if (this.u)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件ready", null);
      return;
    }
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件not ready", null);
    if (NetworkUtil.isNetworkAvailable(null))
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131712827), null);
      ShortVideoResourceManager.b(this.app, this);
      this.v = true;
      return;
    }
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131712868), null);
  }
  
  private void t()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
  }
  
  private void u()
  {
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364190));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(LayoutInflater.from(this).inflate(2131560307, (ViewGroup)this.mContentView, false), -2, -2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131755514);
    this.q = true;
  }
  
  private void v()
  {
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", this.jdField_b_of_type_JavaUtilArrayList);
    localIntent.putExtra("EXTRA_TOPIC_ID", this.jdField_b_of_type_JavaLangString);
    QPublicFragmentActivity.startForResult(this, localIntent, ReadInJoyVideoTagSelectionFragment.class, 1000);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092F1", "0X80092F1", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
  }
  
  protected void a()
  {
    this.jdField_f_of_type_Int = 178;
    super.a();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131380123);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)findViewById(2131380124));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380125));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380122));
    this.jdField_c_of_type_AndroidViewView = new View(this);
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(1996488704);
    addContentView(this.jdField_c_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = View.inflate(this, 2131560312, null);
    addContentView(this.jdField_b_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)this.jdField_b_of_type_AndroidViewView.findViewById(2131380218));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(5.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, -1, 100, getResources().getColor(2131166915));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364269));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    u();
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    setRightButton(2131717890, this);
    a(false);
  }
  
  protected void a(Editable paramEditable)
  {
    super.a(paramEditable);
    int i1 = paramEditable.length();
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int - i1));
    }
    if (i1 - this.jdField_c_of_type_Int > 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4222"));
      }
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#BBBBBB"));
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  protected boolean a()
  {
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "onDeliver!");
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.app, "", "0X80081D8", "0X80081D8", 0, 0, "1", "2", "", VideoReporter.a(null), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008245", "0X8008245", 0, 0, String.valueOf(a()), "", "", b(), false);
    if ((this.jdField_n_of_type_JavaLangString.equals("")) && (!this.s))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverVideoActivity", 2, "onDeliver no video!");
      }
      a(1, getString(2131717889));
      return false;
    }
    if (!super.a()) {
      return false;
    }
    t();
    if (KandianVideoUploadService.a() >= 2)
    {
      QQToast.a(this, 0, getString(2131717884), 0).b(getResources().getDimensionPixelSize(2131299168));
      return false;
    }
    Intent localIntent = a();
    try
    {
      startService(localIntent);
      QLog.d("ReadInJoyDeliverVideoActivity", 1, "start video upload Service!");
      label224:
      if (this.y) {
        ((IKandianSubscribeManager)this.app.getRuntimeService(IKandianSubscribeManager.class)).lanuchKandianSubscribeActivity(this, 4);
      } else {
        ReadInJoyLogicEngine.a().b(true);
      }
      finish();
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label224;
    }
  }
  
  protected void b()
  {
    this.jdField_l_of_type_Boolean = true;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_o_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    super.b();
    this.jdField_e_of_type_JavaLangString = "0X800865E";
    Object localObject = getIntent();
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("arg_video_path");
    this.jdField_f_of_type_JavaLangString = ((Intent)localObject).getStringExtra("arg_video_cover");
    this.jdField_k_of_type_Int = ((Intent)localObject).getIntExtra("arg_video_width", 0);
    this.jdField_l_of_type_Int = ((Intent)localObject).getIntExtra("arg_video_height", 0);
    this.jdField_b_of_type_Long = ((Intent)localObject).getLongExtra("arg_video_duration", 0L);
    this.s = ((Intent)localObject).getBooleanExtra("arg_is_from_wang_zhe", false);
    this.jdField_d_of_type_Long = ((Intent)localObject).getLongExtra("arg_wang_zhe_app_id", 0L);
    this.x = ((Intent)localObject).getBooleanExtra("is_from_dian_dian", false);
    this.y = ((Intent)localObject).getBooleanExtra("is_from_kan_dian", false);
    this.p = ((Intent)localObject).getStringExtra("captureMode");
    this.jdField_a_of_type_JavaUtilList = ((Intent)localObject).getParcelableArrayListExtra("key_read_in_joy_video_upload_report");
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    n();
    b(this.jdField_f_of_type_JavaLangString);
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    int i1 = ((Intent)localObject).getIntExtra("arg_video_source", 0);
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localObject = "0";
    } else {
      localObject = String.valueOf(this.jdField_b_of_type_JavaLangString);
    }
    String str;
    if (this.x) {
      str = "1";
    } else {
      str = "2";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X8008241", "0X8008241", 0, 0, String.valueOf(i1), (String)localObject, str, RIJTransMergeKanDianReport.c(), false);
    this.jdField_g_of_type_Boolean = true;
    if ((!this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.s)
    {
      setRightViewTextDisable(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(getString(2131717864));
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ReadInJoyDeliverVideoActivity.3(this), 30000L);
    }
    s();
  }
  
  protected void b(String paramString)
  {
    Object localObject;
    int i1;
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      this.jdField_n_of_type_JavaLangString = paramString;
      localObject = new BitmapFactory.Options();
      int i2 = 1;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.jdField_n_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      i1 = AIOUtils.b(110.0F, getResources());
      int i3 = AIOUtils.b(110.0F, getResources());
      float f1 = ((BitmapFactory.Options)localObject).outWidth / i1;
      float f2 = ((BitmapFactory.Options)localObject).outHeight / i3;
      this.jdField_m_of_type_Int = ((BitmapFactory.Options)localObject).outWidth;
      this.jdField_n_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      getIntent().putExtra("arg_video_cover_width", this.jdField_m_of_type_Int);
      getIntent().putExtra("arg_video_cover_height", this.jdField_n_of_type_Int);
      i1 = i2;
      if (f1 >= 1.0F)
      {
        i1 = i2;
        if (f2 >= 1.0F) {
          i1 = (int)Math.floor(Math.min(f1, f2));
        }
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = i1;
    }
    try
    {
      localObject = BitmapFactory.decodeFile(this.jdField_n_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      localObject = ImageUtils.a(ImageUtils.a(this.jdField_n_of_type_JavaLangString), (Bitmap)localObject);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setSelectedImage sampleSize=");
        ((StringBuilder)localObject).append(i1);
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageDrawable(new ColorDrawable(-16777216));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageDrawable(new ColorDrawable(-16777216));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
      q();
    }
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "onEmotionBtn!");
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008244", "0X8008244", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
    super.c();
  }
  
  protected void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
      q();
    }
  }
  
  protected void d(int paramInt)
  {
    this.jdField_i_of_type_Int = 2;
    super.d(paramInt);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009577", "0X8009577", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    super.setContentView(2131560174);
    a(2131717891);
    a();
    b();
    m();
    RIJDtReportHelper.a.a(getActivity());
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnPostResume()
  {
    super.doOnPostResume();
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    StatisticCollector.getInstance(this).collectPerformance(getAppRuntime().getAccount(), "actReadInJoyEnterVideoDeliverPage", true, this.jdField_f_of_type_Long - this.jdField_e_of_type_Long, 0L, null, "");
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void e()
  {
    super.e();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.app, "", "0X80081D8", "0X80081D8", 0, 0, "2", "2", "", VideoReporter.a(null), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008242", "0X8008242", 0, 0, String.valueOf(a()), "", "", RIJTransMergeKanDianReport.c(), false);
  }
  
  protected void f()
  {
    super.f();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008243", "0X8008243", 0, 0, String.valueOf(a()), "", "", RIJTransMergeKanDianReport.c(), false);
  }
  
  public void finish()
  {
    super.finish();
    ReadInJoyVideoCompositeManager localReadInJoyVideoCompositeManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCaptureReadInJoyVideoCompositeManager;
    if (localReadInJoyVideoCompositeManager != null) {
      localReadInJoyVideoCompositeManager.a(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      o();
      a(1, getString(2131718077));
      return true;
    }
    if (paramMessage.what == 101)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(101);
      o();
      a(1, getString(2131719091));
      return true;
    }
    if (paramMessage.what == 102)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(102);
      o();
      a(1, getString(2131718079));
      return true;
    }
    if (paramMessage.what == 103)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(103);
      o();
      return true;
    }
    if (paramMessage.what == 104)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(104);
      o();
      r();
      a(1, getString(2131718084));
      return true;
    }
    if (paramMessage.what == 105)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(105);
      o();
      a(1, getString(2131718078));
      return true;
    }
    if (paramMessage.what == 106)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(106);
      o();
      a(1, getString(2131718085));
      return true;
    }
    if (paramMessage.what == 107)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(107);
      o();
      if (this.v)
      {
        a(0, getString(2131718088));
        return true;
      }
      a(0, getString(2131718087));
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
    if (!this.r)
    {
      if ((this.s) && (!this.w)) {
        return super.onBackEvent();
      }
      a(false, 0, this.s, this.jdField_d_of_type_Long);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131364190)
    {
      if (i1 != 2131364269)
      {
        if (i1 != 2131380123)
        {
          super.onClick(paramView);
          return;
        }
        if (!this.s) {
          c(this.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(103);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.app, "", "0X80081DA", "0X80081DA", 0, 0, "", "", "", VideoReporter.a(null), false);
      }
    }
    else {
      v();
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
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131712756));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", ((StringBuilder)localObject).toString(), null);
      ShortVideoErrorReport.a(1, paramInt2);
      this.v = false;
      return;
    }
    if (paramInt2 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131712869));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", ((StringBuilder)localObject).toString(), null);
      ShortVideoErrorReport.a(1, paramInt2);
      this.v = false;
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = ShortVideoResourceManager.a(this.app, (List)localObject);
    if (paramInt1 == 0)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131712951), null);
      ShortVideoResourceManager.a(this.app, (List)localObject, this);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131712956));
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("]");
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", ((StringBuilder)localObject).toString(), null);
    ShortVideoErrorReport.a(1, paramInt1);
    this.v = false;
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131712777));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", localStringBuilder.toString(), null);
        ShortVideoErrorReport.a(2, paramInt);
      }
      else
      {
        this.u = true;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131712861));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", localStringBuilder.toString(), null);
      }
      this.v = false;
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
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131712935), null);
    ShortVideoErrorReport.a(3, -1500);
    this.v = false;
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverVideoActivity
 * JD-Core Version:    0.7.0.1
 */