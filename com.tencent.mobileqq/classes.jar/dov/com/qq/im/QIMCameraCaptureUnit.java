package dov.com.qq.im;

import amsd;
import amse;
import amsf;
import amsg;
import amsh;
import amsj;
import amsk;
import amsl;
import amsm;
import amsn;
import amsp;
import amsq;
import amss;
import amsu;
import amsv;
import amsw;
import amsx;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.biz.qqstory.utils.StoryIntentUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraSwitchGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker.DarkModeListener;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
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
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.util.QIMAnimationUtils;
import dov.com.qq.im.capture.util.QIMAnimationUtils.AnimatorParams;
import dov.com.qq.im.capture.view.PressScaleAnimDelegate;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.qq.im.setting.IQIMCameraLifeCallback;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.mobileqq.activity.richmedia.FlowPanel;
import dov.com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
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
  implements View.OnClickListener, View.OnTouchListener, MediaScanner.OnMediaInfoScannerListener, DarkModeChecker.DarkModeListener, CameraCaptureView.CaptureListener, IQIMCameraLifeCallback, QIMCameraCaptureButtonLayout.CaptureButtonListener
{
  public static long b;
  int jdField_a_of_type_Int = 0;
  protected long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new amsd(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
  public View a;
  protected ViewGroup a;
  protected Button a;
  protected FrameLayout a;
  protected ImageView a;
  protected LinearLayout a;
  protected CameraFocusView a;
  public QQStoryLoadingView a;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  protected CameraFocusGesture a;
  protected CameraSwitchGesture a;
  protected CameraZoomGesture a;
  public CameraCaptureView.VideoCaptureResult a;
  public CameraCaptureView a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  QIMSegmentCaptureManager jdField_a_of_type_DovComQqImQIMSegmentCaptureManager;
  protected CaptureEntranceParams a;
  public ICameraEntrance a;
  public IQIMCameraContainer a;
  public QIMCameraCaptureButtonLayout a;
  protected QIMCameraSegmentCaptureButtonLayout a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  public boolean a;
  protected Button b;
  public TextView b;
  protected QIMCameraCaptureButtonLayout b;
  List b;
  public boolean b;
  private long c;
  public Button c;
  protected TextView c;
  protected boolean c;
  protected Button d;
  protected TextView d;
  public boolean d;
  public Button e;
  protected TextView e;
  private boolean e;
  protected TextView f;
  private boolean f;
  protected TextView g;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  static
  {
    jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public QIMCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    this.jdField_c_of_type_Long = 3L;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10000, 100, 2);
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer = paramIQIMCameraContainer;
    this.jdField_a_of_type_DovComQqImSettingICameraEntrance = paramICameraEntrance;
  }
  
  private void A()
  {
    ThreadManager.post(new amsq(this), 5, null, true);
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), 230).setMessage(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getString(2131439190)).setPositiveButton(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getString(2131432999), new amsm(this)).setNegativeButton(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getString(2131432998), new amsl(this));
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
  
  public static void o()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_b_of_type_Long > 300000L)
    {
      z();
      if (QLog.isColorLevel()) {
        QLog.d("VERSION_CODES", 2, "random tab shuffled");
      }
    }
    jdField_b_of_type_Long = l;
  }
  
  private static void z()
  {
    ThreadManager.post(new amsp(), 8, null, true);
  }
  
  public void L_()
  {
    if (this.jdField_a_of_type_Long != -1L) {
      QLog.d("VERSION_CODES", 1, "(NEW)LaunchActivity to FirstFrameShown cost : " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms");
    }
    NewFlowCameraReporter.a();
  }
  
  protected int a()
  {
    return 2130970065;
  }
  
  public View a()
  {
    NewFlowCameraReporter.a("onCreateView");
    Object localObject = b();
    if (localObject == null) {
      localObject = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getLayoutInflater().inflate(a(), null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131366217);
      NewFlowCameraReporter.a("onCreateView1");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366903));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(a());
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(true);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureListener(this);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366913));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!CameraAbility.c())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131368945));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131368947));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton.setSelected(false);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131368946));
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetButton.setSelected(false);
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131368948));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setSelected(false);
      this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = ((QIMCameraCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368888));
      this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout = ((QIMCameraSegmentCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368889));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368887));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366904));
      this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131368944));
      this.jdField_e_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture = new CameraZoomGesture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture = new CameraFocusGesture(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture = new CameraSwitchGesture(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a());
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368890));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368895));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368897));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368896));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368898));
      this.jdField_d_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      this.jdField_f_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368891));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368892));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368893));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368894));
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      if (this.jdField_a_of_type_Int == 3) {}
      for (com.tencent.sveffects.SvEffectSdkInitor.jdField_a_of_type_Boolean = true;; com.tencent.sveffects.SvEffectSdkInitor.jdField_a_of_type_Boolean = false)
      {
        localObject = (QIMMusicConfigManager)QIMManager.a(2);
        ((QIMMusicConfigManager)localObject).a();
        if (((QIMMusicConfigManager)localObject).b()) {
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        return this.jdField_a_of_type_AndroidViewView;
      }
    }
  }
  
  protected CameraCaptureView.CaptureParam a()
  {
    int m = CameraHelper.a();
    Size localSize = SVParamManager.a().a(m);
    CameraCaptureView.CaptureParam localCaptureParam = new CameraCaptureView.CaptureParam();
    localCaptureParam.a(localSize.a());
    localCaptureParam.b(localSize.b());
    localCaptureParam.a(SVParamManager.a().a(m));
    int n = SVParamManager.a().a(m) * 1000;
    localCaptureParam.d(n);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.r = n;
    localCaptureParam.e(1);
    localCaptureParam.c(m);
    if ((MediaCodecDPC.f()) && (Build.VERSION.SDK_INT < 27)) {
      localCaptureParam.g(0);
    }
    return localCaptureParam;
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
    this.jdField_e_of_type_Boolean = false;
    QLog.e("VERSION_CODES", 2, "onCaptureError. errorCode = " + paramInt);
    ThreadManager.getUIHandler().post(new amse(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
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
    this.jdField_e_of_type_Boolean = false;
    if (!paramBoolean) {
      a(101);
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Boolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, paramLocalMediaInfo);
        this.jdField_g_of_type_Boolean = true;
        return;
      }
      paramBoolean = this.jdField_c_of_type_Boolean;
      this.jdField_a_of_type_JavaUtilList.add(paramLocalMediaInfo);
      this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      this.k = true;
      if (QLog.isColorLevel()) {
        QLog.d("VERSION_CODES", 2, "[segmentCapture] onMediaInfoChanged, mediaInfos size = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      ThreadManager.getUIHandler().post(new amsf(this, paramBoolean));
    } while (!this.jdField_c_of_type_Boolean);
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList);
    this.jdField_g_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    ThreadManager.getUIHandler().post(new amsu(this, paramPhotoCaptureResult));
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = paramVideoCaptureResult;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = false;
      ThreadManager.getUIHandler().post(new amsv(this));
      return;
    }
    if ((paramVideoCaptureResult.videoFrameCount < this.jdField_c_of_type_Long) || ((this.jdField_a_of_type_Boolean) && (ReportUtil.jdField_a_of_type_Long < 500L)))
    {
      this.jdField_e_of_type_Boolean = false;
      ThreadManager.getUIHandler().post(new amsw(this, paramVideoCaptureResult));
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      ThreadManager.getUIHandler().post(new amsx(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramVideoCaptureResult.videoMp4FilePath;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
    if (QLog.isColorLevel()) {
      QLog.d("VERSION_CODES", 2, "onVideoCaptured. result = " + paramVideoCaptureResult.toString());
    }
    MediaScanner.a(BaseApplicationImpl.getContext()).a(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
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
      this.jdField_c_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("VERSION_CODES", 2, "[segmentCapture] onSegmentVideoCaptured segment not finish, wait");
    return;
    if ((!this.k) || (paramList1.size() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VERSION_CODES", 2, "[segmentCapture] onSegmentVideoCaptured segment need not merge, directly queryMediaInfoAsync");
      }
      if ((paramList1.size() == 1) && (this.k))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = ((CameraCaptureView.VideoCaptureResult)paramList1.get(0)).videoMp4FilePath;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = ((CameraCaptureView.VideoCaptureResult)paramList1.get(0));
      }
      MediaScanner.a(BaseApplicationImpl.getContext()).a(new amsg(this), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      return;
    }
    ThreadManager.postImmediately(new amsh(this, paramList1), null, true);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new amss(this, paramString));
    }
    ReportUtil.b = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean) {
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
  
  public void ag_() {}
  
  public void ah_() {}
  
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
    ThreadManager.getUIHandler().post(new amsj(this, paramBoolean));
  }
  
  protected boolean b()
  {
    return this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0;
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
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    e();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    if (this.jdField_e_of_type_AndroidWidgetButton.getVisibility() == 0) {
      A();
    }
    this.jdField_g_of_type_Boolean = false;
    if (!this.j)
    {
      this.j = true;
      ThreadManager.post(new amsn(this), 8, null, true);
    }
    b(false);
    if (!this.h)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.h = true;
    }
    o();
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
      if (this.jdField_a_of_type_Boolean) {
        break label134;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.f();
      this.jdField_e_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    for (;;)
    {
      if (this.i) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      break;
      label101:
      if ((this.jdField_c_of_type_AndroidWidgetButton == null) || (!this.jdField_f_of_type_Boolean)) {
        break label36;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setSelected(false);
      break label36;
      label134:
      if (this.jdField_b_of_type_Boolean) {
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
    if (this.i) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void g(boolean paramBoolean)
  {
    float f1;
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_DovComQqImQIMSegmentCaptureManager = ((QIMSegmentCaptureManager)QIMManager.a().c(13));
      this.jdField_a_of_type_DovComQqImQIMSegmentCaptureManager.a(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setSegmentMode(paramBoolean);
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        ((AppRuntime)localObject).notifyObservers(CaptureConfigUpdateObserver.class, 7, false, null);
      }
      f1 = this.jdField_c_of_type_AndroidWidgetTextView.getX() - this.jdField_d_of_type_AndroidWidgetTextView.getX();
      if (paramBoolean)
      {
        this.jdField_a_of_type_Boolean = true;
        localObject = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetTextView, "translationX", new float[] { 0.0F, f1 }).setDuration(300L);
        localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetTextView, "translationX", new float[] { 0.0F, f1 }).setDuration(300L);
        ((ObjectAnimator)localObject).start();
        localObjectAnimator.start();
        this.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.5F);
        if ((this instanceof QIMStoryEffectCameraCaptureUnit))
        {
          ObjectAnimator.ofFloat(this.jdField_e_of_type_AndroidWidgetTextView, "translationX", new float[] { 0.0F, f1 }).setDuration(300L).start();
          this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(0.5F);
        }
        if (b()) {
          ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetTextView, "translationX", new float[] { 0.0F, f1 }).setDuration(300L).start();
        }
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
    this.jdField_a_of_type_Boolean = false;
    Object localObject = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetTextView, "translationX", new float[] { f1, 0.0F }).setDuration(300L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetTextView, "translationX", new float[] { f1, 0.0F }).setDuration(300L);
    ((ObjectAnimator)localObject).start();
    localObjectAnimator.start();
    this.jdField_d_of_type_AndroidWidgetTextView.setAlpha(0.5F);
    this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    if ((this instanceof QIMStoryEffectCameraCaptureUnit))
    {
      ObjectAnimator.ofFloat(this.jdField_e_of_type_AndroidWidgetTextView, "translationX", new float[] { f1, 0.0F }).setDuration(300L).start();
      this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(0.5F);
    }
    if (b()) {
      ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetTextView, "translationX", new float[] { f1, 0.0F }).setDuration(300L).start();
    }
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.setVisibility(8);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.f();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_b_of_type_Boolean) {
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
  
  public void g_(boolean paramBoolean) {}
  
  public void h() {}
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
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
    QIMAnimationUtils.a(localArrayList, new amsk(this));
  }
  
  public void i() {}
  
  public void k() {}
  
  public void l() {}
  
  public void m()
  {
    GLGestureProxy.a().a();
  }
  
  public void n()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      C();
      return;
    }
    g(false);
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = false;
    int n = 1;
    boolean bool2 = true;
    boolean bool3 = true;
    int m = 1;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366913: 
      PressScaleAnimDelegate.a(this.jdField_a_of_type_AndroidWidgetButton, 200L, null);
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.h();
      ReportUtil.f();
      return;
    case 2131368945: 
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
        CaptureReportUtil.d(m);
        return;
        m = 2;
      }
    case 2131368947: 
      PressScaleAnimDelegate.a(this.jdField_c_of_type_AndroidWidgetButton, 200L, null);
      if (!this.jdField_c_of_type_AndroidWidgetButton.isSelected())
      {
        bool1 = true;
        this.jdField_c_of_type_AndroidWidgetButton.setSelected(bool1);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c(bool1);
        if (bool1) {
          break label308;
        }
        this.jdField_f_of_type_Boolean = true;
        ReportUtil.a(bool1);
        if (!bool1) {
          break label316;
        }
      }
      for (m = n;; m = 2)
      {
        CaptureReportUtil.c(m);
        return;
        bool1 = false;
        break;
        this.jdField_f_of_type_Boolean = false;
        break label285;
      }
    case 2131368946: 
      PressScaleAnimDelegate.a(this.jdField_d_of_type_AndroidWidgetButton, 200L, null);
      if (!this.jdField_d_of_type_AndroidWidgetButton.isSelected()) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.jdField_d_of_type_AndroidWidgetButton.setSelected(bool1);
        paramView = new Intent(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), ScannerActivity.class);
        paramView.putExtra("from", "QIMFlowCameraActivity");
        paramView.putExtra("leftViewText", this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getString(2131433681));
        paramView.putExtra("selfSet_leftViewText", this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getString(2131433681));
        paramView.setFlags(67108864);
        this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().startActivity(paramView);
        return;
      }
    case 2131363969: 
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().onBackPressed();
      ReportUtil.e();
      CaptureReportUtil.f();
      return;
    case 2131368944: 
      label285:
      label308:
      label316:
      PressScaleAnimDelegate.a(this.jdField_e_of_type_AndroidWidgetButton, 200L, null);
      paramView = new QIMReadWriteReportItem();
      paramView.d = "0X800822E";
      QIMReportController.b(null, paramView);
    }
    label1025:
    label1058:
    label1065:
    label1193:
    label1196:
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
          break label1196;
        }
        paramView.putExtra("uin", ((QIMAIOEffectCameraCaptureUnit.Session)localObject).curFriendUin);
        paramView.putExtra("uintype", ((QIMAIOEffectCameraCaptureUnit.Session)localObject).curType);
        paramView.putExtra("troop_uin", ((QIMAIOEffectCameraCaptureUnit.Session)localObject).troopUin);
        paramView.putExtra("uinname", ((QIMAIOEffectCameraCaptureUnit.Session)localObject).curFriendNick);
        paramView = AIOUtils.a(paramView, null);
        localObject = SplashActivity.class.getName();
        str = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getStringExtra("f_a_a_n");
        if ((str == null) || (!str.equals(ChatActivity.class.getName()))) {
          break label1193;
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
          break label1058;
        }
        m = -1;
        paramView.setTextColor(m);
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
        if (!bool1) {
          break label1065;
        }
      }
      for (paramView = "hdr";; paramView = "auto")
      {
        ((CameraCaptureView)localObject).setSceneMode(paramView);
        return;
        bool1 = false;
        break;
        m = -7829368;
        break label1025;
      }
      g(false);
      return;
      g(true);
      return;
      v();
      return;
      WeishiGuideUtils.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), null);
      return;
      C();
      return;
      if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        g();
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
        a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList);
        this.jdField_g_of_type_Boolean = true;
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("VERSION_CODES", 2, "segment video error: jump to edit with no videos");
      return;
      q();
      return;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    GLGestureProxy.a().a(paramMotionEvent, false, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    return true;
  }
  
  public void p()
  {
    this.j = false;
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onPause();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.i();
    if (this.h)
    {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.h = false;
    }
  }
  
  protected void q()
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
      this.k = true;
      if (QLog.isColorLevel()) {
        QLog.d("VERSION_CODES", 2, "[segmentCapture] onSegmentCaptureDelete, mediaInfos size = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.k();
    } while ((this.jdField_a_of_type_JavaUtilList.size() != 0) && (this.jdField_b_of_type_JavaUtilList.size() != 0));
    h(false);
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VERSION_CODES", 2, "onCaptureButtonPhoto!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.i();
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VERSION_CODES", 2, "onCaptureButtonVideoStart!");
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.j();
    g();
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VERSION_CODES", 2, "onCaptureButtonVideoStop!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.k();
  }
  
  public void u()
  {
    this.jdField_c_of_type_Boolean = true;
    g();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
  }
  
  public void v() {}
  
  public void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VERSION_CODES", 2, "[segmentCapture] onSegmentCaptureError, mediaInfos size = " + this.jdField_a_of_type_JavaUtilList.size());
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.k();
    x();
  }
  
  public void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VERSION_CODES", 2, "[segmentCapture] onSegmentError");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
  }
  
  public void y() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */