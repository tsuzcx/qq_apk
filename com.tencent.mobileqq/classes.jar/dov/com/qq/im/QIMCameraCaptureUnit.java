package dov.com.qq.im;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anql;
import anqm;
import anqn;
import anqo;
import anqp;
import anqq;
import anqs;
import anqt;
import anqu;
import anqv;
import anqw;
import anqx;
import anqy;
import anqz;
import anrb;
import anrc;
import anre;
import anrg;
import anrh;
import anri;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.biz.qqstory.utils.StoryIntentUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraSwitchGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker.DarkModeListener;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.statistics.QIMReportController;
import com.tencent.mobileqq.statistics.reportitem.QIMReadWriteReportItem;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.CaptureModeAdapter;
import dov.com.qq.im.capture.adapter.CaptureModeAdapter.CaptureMode;
import dov.com.qq.im.capture.adapter.CaptureModeAdapter.OnItemClickListener;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.util.QIMAnimationUtils;
import dov.com.qq.im.capture.util.QIMAnimationUtils.AnimatorParams;
import dov.com.qq.im.capture.view.PressScaleAnimDelegate;
import dov.com.qq.im.capture.view.WeiShiGuideView;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.qq.im.setting.IQIMCameraLifeCallback;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.mobileqq.activity.richmedia.FlowPanel;
import dov.com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.util.DovSVParamManager;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout.CaptureButtonListener;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@TargetApi(11)
public class QIMCameraCaptureUnit
  implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnTouchListener, MediaScanner.OnMediaInfoScannerListener, DarkModeChecker.DarkModeListener, CameraCaptureView.CaptureListener, CaptureModeAdapter.OnItemClickListener, IQIMCameraLifeCallback, QIMCameraCaptureButtonLayout.CaptureButtonListener
{
  public static long b;
  int jdField_a_of_type_Int = 0;
  protected long a;
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new anql(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
  public View a;
  protected ViewGroup a;
  protected Button a;
  protected FrameLayout a;
  protected ImageView a;
  protected LinearLayout a;
  protected CameraFocusView a;
  public QQStoryLoadingView a;
  public LocalMediaInfo a;
  protected CameraFocusGesture a;
  protected CameraSwitchGesture a;
  protected CameraZoomGesture a;
  public CameraCaptureView.VideoCaptureResult a;
  public CameraCaptureView a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  QIMSegmentCaptureManager jdField_a_of_type_DovComQqImQIMSegmentCaptureManager;
  private CaptureModeAdapter jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter;
  private QIMMusicConfigManager jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager;
  private WeiShiGuideView jdField_a_of_type_DovComQqImCaptureViewWeiShiGuideView;
  protected CaptureEntranceParams a;
  public ICameraEntrance a;
  public IQIMCameraContainer a;
  public QIMCameraCaptureButtonLayout a;
  protected QIMCameraSegmentCaptureButtonLayout a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  private Animator jdField_b_of_type_AndroidAnimationAnimator;
  private View jdField_b_of_type_AndroidViewView;
  protected Button b;
  public TextView b;
  private LocalMediaInfo jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  public CameraCaptureView.VideoCaptureResult b;
  protected QIMCameraCaptureButtonLayout b;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  private long jdField_c_of_type_Long = 3L;
  private Animator jdField_c_of_type_AndroidAnimationAnimator;
  private View jdField_c_of_type_AndroidViewView;
  public Button c;
  protected TextView c;
  protected List c;
  public boolean c;
  private Animator d;
  protected Button d;
  protected boolean d;
  public Button e;
  public boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  
  static
  {
    jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public QIMCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10000, 100, 2);
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer = paramIQIMCameraContainer;
    this.jdField_a_of_type_DovComQqImSettingICameraEntrance = paramICameraEntrance;
  }
  
  private void D()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131368965));
    int i1 = (ViewUtils.a() - ViewUtils.a(53.0F)) / 2;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setPadding(i1, 0, i1, 0);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter = new CaptureModeAdapter(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_c_of_type_JavaUtilList, 1);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(1));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this);
    this.jdField_a_of_type_DovComQqImCaptureViewWeiShiGuideView = ((WeiShiGuideView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368960));
    this.jdField_a_of_type_DovComQqImCaptureViewWeiShiGuideView.setCancelListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewWeiShiGuideView.setJumpWs(this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.b);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369203);
    anqx localanqx = new anqx(this);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(localanqx);
    this.jdField_a_of_type_DovComQqImCaptureViewWeiShiGuideView.setOnTouchListener(localanqx);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369204).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369205).setOnClickListener(this);
  }
  
  private static void E()
  {
    ThreadManager.post(new anrb(), 8, null, true);
  }
  
  private void G()
  {
    ThreadManager.post(new anrc(this), 5, null, true);
  }
  
  private void H()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), 230).setMessage(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getString(2131439250)).setPositiveButton(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getString(2131433030), new anqv(this)).setNegativeButton(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getString(2131433029), new anqu(this));
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VERSION_CODES", 2, "segment back dialog error:" + localThrowable);
    }
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator == null) {
      this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImCaptureViewWeiShiGuideView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(600L);
    }
    if ((this.jdField_c_of_type_AndroidAnimationAnimator != null) && (this.jdField_c_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_c_of_type_AndroidAnimationAnimator.cancel();
    }
    this.jdField_a_of_type_DovComQqImCaptureViewWeiShiGuideView.setVisibility(0);
    this.jdField_a_of_type_AndroidAnimationAnimator.start();
    B();
    boolean bool = WeishiGuideUtils.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a());
    this.jdField_a_of_type_DovComQqImCaptureViewWeiShiGuideView.a(bool);
    if (bool) {}
    for (int i1 = 0;; i1 = 1)
    {
      StoryReportor.a("weishi_share", "clk_ws_entry", 0, 0, new String[] { String.valueOf(i1) });
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      return;
    }
  }
  
  private void J()
  {
    if (this.jdField_c_of_type_AndroidAnimationAnimator == null)
    {
      this.jdField_c_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImCaptureViewWeiShiGuideView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(600L);
      this.jdField_c_of_type_AndroidAnimationAnimator.addListener(new anqw(this));
    }
    if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    this.jdField_c_of_type_AndroidAnimationAnimator.start();
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void K()
  {
    if (this.jdField_d_of_type_AndroidAnimationAnimator == null)
    {
      this.jdField_d_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(600L);
      this.jdField_d_of_type_AndroidAnimationAnimator.addListener(new anqy(this));
    }
    if ((this.jdField_b_of_type_AndroidAnimationAnimator != null) && (this.jdField_b_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationAnimator.cancel();
    }
    this.jdField_d_of_type_AndroidAnimationAnimator.start();
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void L()
  {
    if (this.jdField_b_of_type_AndroidAnimationAnimator == null) {
      this.jdField_b_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(600L);
    }
    if ((this.jdField_d_of_type_AndroidAnimationAnimator != null) && (this.jdField_d_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_d_of_type_AndroidAnimationAnimator.cancel();
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidAnimationAnimator.start();
    B();
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void M()
  {
    QimMusicPlayer localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
    if ((localQimMusicPlayer != null) && (localQimMusicPlayer.a()))
    {
      this.n = true;
      localQimMusicPlayer.d();
    }
  }
  
  private void N()
  {
    if (this.n)
    {
      this.n = false;
      QimMusicPlayer localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
      if (localQimMusicPlayer != null) {
        localQimMusicPlayer.c();
      }
    }
  }
  
  private void l(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_DovComQqImQIMSegmentCaptureManager = ((QIMSegmentCaptureManager)QIMManager.a().c(13));
      this.jdField_a_of_type_DovComQqImQIMSegmentCaptureManager.a(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setSegmentMode(paramBoolean);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof AppInterface)) {
        localAppRuntime.notifyObservers(CaptureConfigUpdateObserver.class, 7, false, null);
      }
      if (paramBoolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.f();
        this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.setVisibility(0);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout;
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
        g();
        e();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.setVisibility(8);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.f();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_c_of_type_Boolean) {
      h(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
      g();
      e();
    }
  }
  
  public static void p()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - jdField_b_of_type_Long > 300000L)
    {
      E();
      if (QLog.isColorLevel()) {
        QLog.d("VERSION_CODES", 2, "random tab shuffled");
      }
    }
    jdField_b_of_type_Long = l1;
  }
  
  protected void A() {}
  
  public void A_()
  {
    if (this.jdField_a_of_type_Long != -1L) {
      QLog.d("VERSION_CODES", 1, "(NEW)LaunchActivity to FirstFrameShown cost : " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms");
    }
    NewFlowCameraReporter.a();
  }
  
  protected void B() {}
  
  public void B_() {}
  
  protected void C() {}
  
  protected int a()
  {
    return 2130970090;
  }
  
  public View a()
  {
    NewFlowCameraReporter.a("onCreateView");
    View localView = b();
    if (localView == null) {
      localView = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getLayoutInflater().inflate(a(), null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131366249);
      NewFlowCameraReporter.a("onCreateView1");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366943));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(a());
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(true);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureListener(this);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeListener(this);
      if (MediaCodecDPC.n())
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDynamicResolutionMode(true);
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366953));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        if (!CameraAbility.c())
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131369012));
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
        this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131369014));
        this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetButton.setSelected(false);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131369013));
        this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_d_of_type_AndroidWidgetButton.setSelected(false);
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369015));
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = ((QIMCameraCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368957));
        this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout = ((QIMCameraSegmentCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368958));
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368956));
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366944));
        this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131369002));
        this.jdField_e_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture = new CameraZoomGesture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture = new CameraFocusGesture(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture = new CameraSwitchGesture(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a());
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368961));
        o();
        D();
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368959));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368962));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368963));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368964));
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365916);
        if (this.jdField_a_of_type_Int != 3) {
          break label665;
        }
      }
      label665:
      for (com.tencent.sveffects.SvEffectSdkInitor.jdField_a_of_type_Boolean = true;; com.tencent.sveffects.SvEffectSdkInitor.jdField_a_of_type_Boolean = false)
      {
        return this.jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDynamicResolutionMode(false);
        break;
      }
    }
  }
  
  protected CameraCaptureView.CaptureParam a()
  {
    if (MediaCodecDPC.n()) {
      return DovSVParamManager.a().a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a());
    }
    return DovSVParamManager.a().b(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a());
  }
  
  public FlowPanel a()
  {
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
    }
    return null;
  }
  
  protected List a()
  {
    return null;
  }
  
  public void a(int paramInt)
  {
    this.f = false;
    QLog.e("VERSION_CODES", 2, "onCaptureError. errorCode = " + paramInt);
    ThreadManager.getUIHandler().post(new anqn(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
  }
  
  public void a(Intent paramIntent) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getLongExtra("ACTIVITY_START_TIME", -1L);
    ReportUtil.a();
    new IntentFilter().addAction("tencent.av.v2q.StartVideoChat");
    if (paramBundle != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = ((CameraCaptureView.VideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.f = false;
    if (!paramBoolean) {
      a(101);
    }
    do
    {
      return;
      if (!this.jdField_b_of_type_Boolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, paramLocalMediaInfo);
        this.h = true;
        return;
      }
      paramBoolean = this.jdField_d_of_type_Boolean;
      this.jdField_a_of_type_JavaUtilList.add(paramLocalMediaInfo);
      this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      this.l = true;
      if (QLog.isColorLevel()) {
        QLog.d("VERSION_CODES", 2, "[segmentCapture] onMediaInfoChanged, mediaInfos size = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      ThreadManager.getUIHandler().post(new anqo(this, paramBoolean));
    } while (!this.jdField_d_of_type_Boolean);
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList);
    this.h = true;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    ThreadManager.getUIHandler().post(new anrg(this, paramPhotoCaptureResult));
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = paramVideoCaptureResult;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      this.f = false;
      ThreadManager.getUIHandler().post(new anrh(this));
      return;
    }
    if ((paramVideoCaptureResult.videoFrameCount < this.jdField_c_of_type_Long) || ((this.jdField_b_of_type_Boolean) && (ReportUtil.jdField_a_of_type_Long < 500L)))
    {
      this.f = false;
      ThreadManager.getUIHandler().post(new anri(this, paramVideoCaptureResult));
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      ThreadManager.getUIHandler().post(new anqm(this));
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramVideoCaptureResult.videoMp4FilePath;
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
    if (QLog.isColorLevel()) {
      QLog.d("VERSION_CODES", 2, "onVideoCaptured. result = " + paramVideoCaptureResult.toString());
    }
    MediaScanner.a(BaseApplicationImpl.getContext()).a(this, this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo) {}
  
  protected void a(List paramList1, List paramList2)
  {
    if ((paramList1 == null) || (paramList1.size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("VERSION_CODES", 2, "[segmentCapture] onSegmentVideoCaptured results empty");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      this.jdField_d_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("VERSION_CODES", 2, "[segmentCapture] onSegmentVideoCaptured segment not finish, wait");
    return;
    if ((!this.l) || (paramList1.size() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VERSION_CODES", 2, "[segmentCapture] onSegmentVideoCaptured segment need not merge, directly queryMediaInfoAsync");
      }
      if ((paramList1.size() == 1) && (this.l))
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = ((CameraCaptureView.VideoCaptureResult)paramList1.get(0)).videoMp4FilePath;
        this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = ((CameraCaptureView.VideoCaptureResult)paramList1.get(0));
      }
      MediaScanner.a(BaseApplicationImpl.getContext()).a(new anqp(this), this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      return;
    }
    ThreadManager.postImmediately(new anqq(this, paramList1), null, true);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new anre(this, paramString));
    }
    ReportUtil.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    }
    return true;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void al_() {}
  
  protected View b()
  {
    return null;
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidWidgetButton == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new anqs(this, paramBoolean));
  }
  
  public View c()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void d()
  {
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onResume();
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.h();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.h();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    e();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    if (this.jdField_e_of_type_AndroidWidgetButton.getVisibility() == 0) {
      G();
    }
    this.h = false;
    if (!this.k)
    {
      this.k = true;
      ThreadManager.post(new anqz(this), 8, null, true);
    }
    b(false);
    if (!this.i)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.i = true;
    }
    p();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = null;
    }
  }
  
  public void e()
  {
    if (CameraAbility.c())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      if (!GLVideoClipUtil.b()) {
        break label101;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      label36:
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
      if (this.jdField_b_of_type_Boolean) {
        break label134;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.f();
      this.jdField_e_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    for (;;)
    {
      if (this.j) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      break;
      label101:
      if ((this.jdField_c_of_type_AndroidWidgetButton == null) || (!this.g)) {
        break label36;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setSelected(false);
      break label36;
      label134:
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      } else {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setPreviewEnable(paramBoolean);
    }
  }
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
    if (this.j) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void g(boolean paramBoolean)
  {
    boolean bool = true;
    int i1 = this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(1);
    int i2 = this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(0);
    Object localObject = this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter;
    if (!paramBoolean)
    {
      ((CaptureModeAdapter)localObject).a(i1, bool);
      this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(i2, paramBoolean);
      localObject = this.jdField_a_of_type_AndroidSupportV4ViewViewPager;
      if (!paramBoolean) {
        break label74;
      }
      i1 = i2;
    }
    label74:
    for (;;)
    {
      ((ViewPager)localObject).setCurrentItem(i1, false);
      return;
      bool = false;
      break;
    }
  }
  
  public void h() {}
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
      }
    }
    else
    {
      return;
    }
    e();
    float f1 = UIUtils.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), 90.0F);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_a_of_type_AndroidWidgetFrameLayout, "translationY", 0.0F, f1, 450L, 0L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_a_of_type_AndroidWidgetFrameLayout, "alpha", 1.0F, 0.0F, 450L, 0L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", f1, 0.0F, 450L, 0L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_a_of_type_AndroidViewViewGroup, "alpha", 0.0F, 1.0F, 450L, 0L));
    this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(0.0F);
    Object localObject = a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        localArrayList.add(new QIMAnimationUtils.AnimatorParams(localView, "translationY", f1, 0.0F, 450L, 0L));
        localArrayList.add(new QIMAnimationUtils.AnimatorParams(localView, "alpha", 0.0F, 1.0F, 450L, 0L));
        localView.setAlpha(0.0F);
      }
    }
    QIMAnimationUtils.a(localArrayList, new anqt(this));
  }
  
  public void i() {}
  
  protected void i(boolean paramBoolean) {}
  
  public void k() {}
  
  public void l() {}
  
  public void m()
  {
    GLGestureProxy.a().a();
  }
  
  public void n()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      H();
      return;
    }
    g(false);
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
  }
  
  protected void o()
  {
    this.jdField_c_of_type_JavaUtilList.add(new CaptureModeAdapter.CaptureMode(0));
    this.jdField_c_of_type_JavaUtilList.add(new CaptureModeAdapter.CaptureMode(1));
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = ((QIMMusicConfigManager)QIMManager.a(2));
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a();
    this.m = this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.b();
    if (this.m) {
      this.jdField_c_of_type_JavaUtilList.add(new CaptureModeAdapter.CaptureMode(4));
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = false;
    int i2 = 1;
    boolean bool2 = true;
    boolean bool3 = true;
    int i1 = 1;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366953: 
      PressScaleAnimDelegate.a(this.jdField_a_of_type_AndroidWidgetButton, 200L, null);
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.h();
      ReportUtil.f();
      return;
    case 2131369012: 
      PressScaleAnimDelegate.a(this.jdField_b_of_type_AndroidWidgetButton, 200L, null);
      if (!this.jdField_b_of_type_AndroidWidgetButton.isSelected()) {
        bool1 = true;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(bool1);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.b(bool1);
      ReportUtil.d();
      if (bool1) {}
      for (;;)
      {
        CaptureReportUtil.d(i1);
        return;
        i1 = 2;
      }
    case 2131369014: 
      PressScaleAnimDelegate.a(this.jdField_c_of_type_AndroidWidgetButton, 200L, null);
      if (!this.jdField_c_of_type_AndroidWidgetButton.isSelected())
      {
        bool1 = true;
        this.jdField_c_of_type_AndroidWidgetButton.setSelected(bool1);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c(bool1);
        if (bool1) {
          break label300;
        }
        this.g = true;
        ReportUtil.a(bool1);
        if (!bool1) {
          break label308;
        }
      }
      for (i1 = i2;; i1 = 2)
      {
        CaptureReportUtil.c(i1);
        return;
        bool1 = false;
        break;
        this.g = false;
        break label277;
      }
    case 2131369013: 
      PressScaleAnimDelegate.a(this.jdField_d_of_type_AndroidWidgetButton, 200L, null);
      if (!this.jdField_d_of_type_AndroidWidgetButton.isSelected()) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.jdField_d_of_type_AndroidWidgetButton.setSelected(bool1);
        paramView = new Intent(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), ScannerActivity.class);
        paramView.putExtra("from", "QIMFlowCameraActivity");
        paramView.putExtra("leftViewText", this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getString(2131433712));
        paramView.putExtra("selfSet_leftViewText", this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getString(2131433712));
        paramView.setFlags(67108864);
        this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().startActivity(paramView);
        return;
      }
    case 2131364018: 
    case 2131369204: 
    case 2131372182: 
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().onBackPressed();
      ReportUtil.e();
      CaptureReportUtil.f();
      return;
    case 2131369002: 
      label277:
      label300:
      label308:
      PressScaleAnimDelegate.a(this.jdField_e_of_type_AndroidWidgetButton, 200L, null);
      paramView = new QIMReadWriteReportItem();
      paramView.d = "0X800822E";
      QIMReportController.b(null, paramView);
    }
    label1160:
    label1163:
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = QIMCameraCaptureActivity.class.getName();
        String str = LocalVideoSelectActivity.class.getName();
        Activity localActivity = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
        paramView = new Intent(localActivity, PhotoListActivity.class);
        StoryIntentUtils.a(paramView, localActivity.getIntent().getExtras());
        paramView.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
        paramView.putExtra("from_qqstory", true);
        paramView.putExtra("edit_video_type", this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a());
        paramView.putExtra("ALBUM_NAME", "最近照片");
        paramView.putExtra("ALBUM_ID", "$RecentAlbumId");
        paramView.putExtra("video_refer", this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a());
        paramView.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
        paramView.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
        paramView.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        paramView.putExtra("PhotoConst.ENABLE_MULTI_FRAGMENT_VIDEO", false);
        paramView.putExtra("entrance_type", this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.b());
        paramView.putExtra("story_default_label", localActivity.getIntent().getStringExtra("story_default_label"));
        paramView.putExtra("troop_uin", localActivity.getIntent().getLongExtra("troop_uin", 0L));
        if (localObject != null)
        {
          paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", (String)localObject);
          paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        }
        if (str != null)
        {
          paramView.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", str);
          paramView.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        }
        localObject = (QIMAIOEffectCameraCaptureUnit.Session)this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getSerializableExtra("ARG_SESSION_INFO");
        if (localObject == null) {
          break label1163;
        }
        paramView.putExtra("uin", ((QIMAIOEffectCameraCaptureUnit.Session)localObject).curFriendUin);
        paramView.putExtra("uintype", ((QIMAIOEffectCameraCaptureUnit.Session)localObject).curType);
        paramView.putExtra("troop_uin", ((QIMAIOEffectCameraCaptureUnit.Session)localObject).troopUin);
        paramView.putExtra("uinname", ((QIMAIOEffectCameraCaptureUnit.Session)localObject).curFriendNick);
        paramView = AIOUtils.a(paramView, null);
        localObject = SplashActivity.class.getName();
        str = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getStringExtra("f_a_a_n");
        if ((str == null) || (!str.equals(ChatActivity.class.getName()))) {
          break label1160;
        }
        localObject = str;
        paramView.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", (String)localObject);
        paramView.putExtra("key_activity_code", this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getStringExtra("key_activity_code"));
        paramView.putExtra("edit_video_way", this.jdField_a_of_type_Int);
        paramView.putExtra("from_camera_album", true);
        localActivity.startActivityForResult(paramView, 10006);
        return;
      }
      catch (Exception paramView)
      {
        SLog.b("VERSION_CODES", "QQStoryFlowCallback ", paramView);
        return;
      }
      if (!this.jdField_b_of_type_AndroidWidgetTextView.isSelected())
      {
        bool1 = bool3;
        this.jdField_b_of_type_AndroidWidgetTextView.setSelected(bool1);
        paramView = this.jdField_b_of_type_AndroidWidgetTextView;
        if (!bool1) {
          break label1051;
        }
        i1 = -1;
        label1018:
        paramView.setTextColor(i1);
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
        if (!bool1) {
          break label1058;
        }
      }
      label1051:
      label1058:
      for (paramView = "hdr";; paramView = "auto")
      {
        ((CameraCaptureView)localObject).setSceneMode(paramView);
        return;
        bool1 = false;
        break;
        i1 = -7829368;
        break label1018;
      }
      H();
      return;
      if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        g();
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
        a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList);
        this.h = true;
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("VERSION_CODES", 2, "segment video error: jump to edit with no videos");
      return;
      r();
      return;
      w();
      return;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(paramInt1, paramFloat);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(paramInt);
    CaptureModeAdapter.CaptureMode localCaptureMode = (CaptureModeAdapter.CaptureMode)this.jdField_c_of_type_JavaUtilList.get(paramInt);
    label100:
    boolean bool;
    switch (this.jdField_b_of_type_Int)
    {
    case 1: 
    case 3: 
    default: 
      paramInt = localCaptureMode.a();
      switch (paramInt)
      {
      case 3: 
      default: 
        bool = localCaptureMode.a();
        if (!bool) {
          N();
        }
        break;
      }
      break;
    }
    for (;;)
    {
      i(bool);
      this.jdField_b_of_type_Int = paramInt;
      StoryReportor.a("video_shoot_navi", "clk_mode", 0, 0, new String[] { String.valueOf(localCaptureMode.a()) });
      A();
      return;
      l(false);
      break;
      K();
      break;
      J();
      break;
      l(true);
      C();
      break label100;
      C();
      break label100;
      L();
      break label100;
      I();
      break label100;
      M();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    GLGestureProxy.a().a(paramMotionEvent, false, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    return true;
  }
  
  public void q()
  {
    this.k = false;
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onPause();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.i();
    if (this.i)
    {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.i = false;
    }
  }
  
  protected void r()
  {
    if (!a()) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaUtilList.size() <= 0) || (this.jdField_b_of_type_JavaUtilList.size() <= 0));
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      this.jdField_b_of_type_JavaUtilList.remove(this.jdField_b_of_type_JavaUtilList.size() - 1);
      this.l = true;
      if (QLog.isColorLevel()) {
        QLog.d("VERSION_CODES", 2, "[segmentCapture] onSegmentCaptureDelete, mediaInfos size = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.k();
      if ((this.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) {
        h(false);
      }
    } while ((this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mTransferPosList == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mTransferPosList.size() <= 0));
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mTransferPosList.remove(this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mTransferPosList.size() - 1);
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VERSION_CODES", 2, "onCaptureButtonPhoto!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.i();
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VERSION_CODES", 2, "onCaptureButtonVideoStart!");
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.j();
    g();
    this.f = true;
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VERSION_CODES", 2, "onCaptureButtonVideoStop!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.k();
  }
  
  public void v()
  {
    this.jdField_d_of_type_Boolean = true;
    g();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
  }
  
  public void w() {}
  
  public void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VERSION_CODES", 2, "[segmentCapture] onSegmentCaptureError, mediaInfos size = " + this.jdField_a_of_type_JavaUtilList.size());
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.k();
    y();
  }
  
  public void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VERSION_CODES", 2, "[segmentCapture] onSegmentError");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
  }
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */