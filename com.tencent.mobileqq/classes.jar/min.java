import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.EGL14;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.QavVideoRecordUICtrl.1;
import com.tencent.av.ui.QavVideoRecordUICtrl.2;
import com.tencent.av.ui.QavVideoRecordUICtrl.3;
import com.tencent.av.ui.QavVideoRecordUICtrl.4;
import com.tencent.av.ui.QavVideoRecordUICtrl.7;
import com.tencent.av.ui.QavVideoRecordUICtrl.8;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Locale;

@TargetApi(18)
public class min
  implements Handler.Callback, View.OnClickListener, mnl, mno, mnu
{
  public static String a;
  public static boolean a;
  public static boolean b;
  public int a;
  public long a;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private DoubleVideoCtrlUI jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
  private VideoNetStateBar jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
  private QavRecordButtonView jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView;
  private File jdField_a_of_type_JavaIoFile;
  private WeakReference<AVActivity> jdField_a_of_type_JavaLangRefWeakReference;
  public mnm a;
  private mns jdField_a_of_type_Mns;
  public int b;
  public long b;
  private Animator.AnimatorListener jdField_b_of_type_AndroidAnimationAnimator$AnimatorListener;
  private ValueAnimator.AnimatorUpdateListener jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  public long c;
  private View jdField_c_of_type_AndroidViewView;
  private RelativeLayout.LayoutParams jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private String jdField_c_of_type_JavaLangString;
  public boolean c;
  private int jdField_d_of_type_Int = 1;
  private long jdField_d_of_type_Long;
  private RelativeLayout.LayoutParams jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private String jdField_d_of_type_JavaLangString;
  public boolean d;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private RelativeLayout.LayoutParams jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  private volatile long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean;
  private volatile long jdField_h_of_type_Long;
  private volatile boolean jdField_h_of_type_Boolean;
  private volatile boolean i;
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getFilesDir() + "/qav_record_test_switch.dat";
  }
  
  public min(AVActivity paramAVActivity, RelativeLayout paramRelativeLayout1, VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, RelativeLayout paramRelativeLayout2, VideoControlUI paramVideoControlUI)
  {
    this.jdField_a_of_type_Long = 60000L;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout2;
    if ((paramVideoControlUI instanceof DoubleVideoCtrlUI)) {
      paramAVActivity = (DoubleVideoCtrlUI)paramVideoControlUI;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI = paramAVActivity;
      if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null)
      {
        paramAVActivity = null;
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = paramAVActivity;
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.e(true);
        }
        a(paramVideoAppInterface);
        this.jdField_a_of_type_Mnm = mnm.a();
        this.jdField_a_of_type_Long = (this.jdField_a_of_type_Mnm.h * 60 * 1000L);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long < 0L) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long = this.jdField_a_of_type_Long;
        }
      }
      try
      {
        if (f()) {
          this.jdField_a_of_type_Mns = new mns();
        }
        paramAVActivity = bbdh.h();
        QLog.i("QavVideoRecordUICtrl", 1, "QavVideoRecordUICtrl manufacture=" + paramAVActivity);
        if (("OPPO".equalsIgnoreCase(paramAVActivity)) || ("vivo".equalsIgnoreCase(paramAVActivity))) {
          this.jdField_e_of_type_Boolean = true;
        }
        return;
        paramAVActivity = null;
        continue;
        paramAVActivity = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
      }
      catch (OutOfMemoryError paramAVActivity)
      {
        for (;;)
        {
          this.jdField_a_of_type_Mns = null;
          QLog.e("QavVideoRecordUICtrl", 1, "oom " + paramAVActivity, paramAVActivity);
        }
      }
    }
  }
  
  private int a(int paramInt)
  {
    int j = paramInt;
    if (paramInt != 0)
    {
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
        break label24;
      }
      j = 0;
    }
    label24:
    do
    {
      do
      {
        return j;
        j = paramInt;
      } while (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null);
      j = paramInt;
    } while (!this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.h());
    return 0;
  }
  
  private void a(long paramLong)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onRecordEnd time=" + paramLong);
    if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvVideoController.a().A = false;
    if ((paramLong > 1000L) || (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).i))
    {
      a(3, true);
      this.jdField_a_of_type_ComTencentAvVideoController.a().u = 0;
    }
    for (;;)
    {
      n();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
      return;
      if (paramLong >= 0L)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QavVideoRecordUICtrl.7(this), 1000L);
        mao.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131696082);
        mnp.a("0X8008AB0");
      }
      else if (paramLong < 0L)
      {
        a(3, true);
        mao.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131696057);
        this.jdField_a_of_type_ComTencentAvVideoController.F();
      }
    }
  }
  
  public static void a(VideoController paramVideoController)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoRecordUICtrl", 2, "sendSupportMsg, controller=" + paramVideoController);
    }
    if ((!f()) || (k())) {
      QLog.d("QavVideoRecordUICtrl", 1, "sendSupportMsg, not support");
    }
    while (paramVideoController == null) {
      return;
    }
    paramVideoController.a(8, "SUPPORT_TRUE");
    paramVideoController.a(8, "SUPPORT_TRUE");
    paramVideoController.a(8, "SUPPORT_TRUE_7.3.5#" + mnm.a().h);
    paramVideoController.a(8, "SUPPORT_TRUE_7.3.5#" + mnm.a().h);
  }
  
  private void a(VideoAppInterface paramVideoAppInterface)
  {
    LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).inflate(2131559602, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379076));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375016));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375015));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377124));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375001));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374998);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374997);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374996);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams());
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetRelativeLayout.getLayoutParams());
    this.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams());
    this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams());
    if (AudioHelper.a(0) == 1)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(1602735851);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2142109487);
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setWillNotDraw(false);
    this.jdField_a_of_type_Int = actj.a(51.0F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
    this.jdField_b_of_type_JavaLangString = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131696070);
    this.jdField_c_of_type_JavaLangString = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131696066);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131374988));
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131375004));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131375003));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (AudioHelper.a(0) == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-273627938);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(-65281);
    }
  }
  
  private int b(int paramInt)
  {
    return ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDimensionPixelSize(paramInt);
  }
  
  private void b(long paramLong)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onForceStop time=" + paramLong);
    if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().A = false;
    mao.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131696058);
    this.jdField_a_of_type_ComTencentAvVideoController.F();
    n();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
  }
  
  private long c()
  {
    return Math.max(0L, System.currentTimeMillis() - this.jdField_f_of_type_Long);
  }
  
  public static boolean f()
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoRecordUICtrl", 2, "isDeviceSupport, apiSupport=" + bool);
      }
      return bool;
    }
  }
  
  private void h(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).i);
      if (this.jdField_e_of_type_Boolean) {}
      for (paramInt = 2131696072;; paramInt = 2131696071)
      {
        bcql.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(paramInt), 0).a();
        return;
      }
    } while (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).i);
    mao.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131696057);
  }
  
  public static boolean k()
  {
    lpd locallpd = lpd.a();
    if ((locallpd == null) || (locallpd.d())) {}
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        QLog.d("QavVideoRecordUICtrl", 1, "isInBlackList device not support");
      }
      if (j != 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void o()
  {
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    a(false);
    c(false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) || (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI == null)) {}
    while (!b()) {
      return;
    }
    if (c())
    {
      if (d())
      {
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a(true);
        return;
      }
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a(true);
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "doExpandAnim");
    }
    this.jdField_h_of_type_Boolean = true;
    actj.a(7.5F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
    actj.a(64.0F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
    b(2131297713);
    b(2131297710);
    b(2131297710);
    b(2131297712);
    b(2131297717);
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener == null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new mio(this);
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener == null) {
      this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new mip(this);
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 260 });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(260L);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 1, "clearAnim mAnimExpanding=" + this.jdField_h_of_type_Boolean + ", mAnimFolding=" + this.i);
    }
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {}
    while ((!this.i) || (this.jdField_b_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {
      try
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("QavVideoRecordUICtrl", 1, "clearAnim exception:" + localException1, localException1);
        this.jdField_h_of_type_Boolean = false;
        return;
      }
      finally
      {
        this.jdField_h_of_type_Boolean = false;
        b(3, false);
      }
    }
    try
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("QavVideoRecordUICtrl", 1, "clearAnim exception:" + localException2, localException2);
      return;
    }
    finally
    {
      this.i = false;
      b(3, false);
    }
  }
  
  private void s()
  {
    if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    this.jdField_e_of_type_Int = 0;
    QLog.d("QavVideoRecordUICtrl", 1, "onRecordBegin");
    this.jdField_a_of_type_ComTencentAvVideoController.a().A = true;
    a(1, true);
    n();
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setProgress(0L, this.jdField_a_of_type_Long);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(0L));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
  }
  
  private void t()
  {
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAVActivity == null) {}
    do
    {
      return;
      if ((localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QavVideoRecordUICtrl", 2, "record activity.mApp == null  || mVideoController == null");
    return;
    mnp.a("0X8008AAE");
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().w)
    {
      localAVActivity.jdField_a_of_type_Mcf.c(2);
      QLog.d("QavVideoRecordUICtrl", 1, "start record, child lock");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().A)
    {
      c();
      long l = (System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L;
      axqy.b(null, "CliOper", "", "", "0X800863B", "0X800863B", 0, 0, String.valueOf(l), "", "", "");
      axrn.a(BaseApplicationImpl.getContext()).a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "av_record_click_end", true, l, 0L, null, "", false);
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a.clear();
    int j;
    if (!f())
    {
      if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        mao.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696052);
      }
      j = 0;
      QLog.d("QavVideoRecordUICtrl", 1, "start record, api not support");
    }
    for (;;)
    {
      if (j != 0)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().G = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a().H = b();
        b();
        Object localObject;
        if ((j()) && (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)))
        {
          localObject = (lhr)localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
          if (((FaceItem)((lhr)localObject).a() != null) && (((lhr)localObject).a()) && (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
            mao.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696062);
          }
        }
        mnp.a("0X800863A");
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().B) {
          mnp.a("0X8008ACC");
        }
        if (b()) {
          mnp.a("0X8008AB9");
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().a.size() != 0) {
            break label1183;
          }
          mnp.a("0X8008ABB");
          return;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().z)
          {
            QLog.d("QavVideoRecordUICtrl", 1, "start record, friend not support");
            if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString) == 5) {
              mnp.a("0X8008AB6");
            }
            for (j = 2131696060;; j = 2131696059)
            {
              if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
                break label1192;
              }
              mao.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, j);
              j = 0;
              break;
              mnp.a("0X8008AB5");
            }
          }
          if (!i())
          {
            if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
              mao.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696065);
            }
            j = 0;
            QLog.d("QavVideoRecordUICtrl", 1, "start record, isPerformanceSupport==false");
            mnp.a("0X8008AB4");
            break;
          }
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().B) && (this.jdField_a_of_type_ComTencentAvVideoController.a().t < 735))
          {
            QLog.d("QavVideoRecordUICtrl", 1, "start record, friend's old version not support record in same time");
            mao.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696063);
            j = 0;
            break;
          }
          if (!e())
          {
            QLog.d("QavVideoRecordUICtrl", 1, "start record, last encode not stop");
            if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
              mao.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696061);
            }
            j = 0;
            break;
          }
          if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3))
          {
            localObject = (lhr)localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
            FaceItem localFaceItem = (FaceItem)((lhr)localObject).a();
            if (localFaceItem != null)
            {
              boolean bool1 = ((lhr)localObject).a();
              boolean bool2 = localFaceItem.isSameType("pendant");
              boolean bool3 = localFaceItem.isSameType("face");
              boolean bool4 = localFaceItem.isSameType("voicesticker");
              if ((bool1) && ((bool3) || (bool4)))
              {
                j = 1;
                label741:
                if (j == 0) {
                  break label817;
                }
                localObject = localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
                if (!bool4) {
                  break label801;
                }
              }
              label801:
              for (j = 2131696085;; j = 2131696084)
              {
                mao.a((VideoAppInterface)localObject, 1022, j);
                j = 0;
                QLog.d("QavVideoRecordUICtrl", 1, "start record, isDoubleScreen");
                if (!bool4) {
                  break label808;
                }
                mnp.a("0X8009852");
                break;
                j = 0;
                break label741;
              }
              label808:
              mnp.a("0X8008AC3");
              break;
              label817:
              if (bool2) {
                mnp.a("0X8008ABE");
              }
            }
          }
          if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
          {
            localObject = (ljp)localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
            if (localObject != null)
            {
              localObject = (ZimuItem)((ljp)localObject).a();
              if (localObject != null)
              {
                if (!TextUtils.isEmpty(((ZimuItem)localObject).getId())) {}
                for (j = 1;; j = 0)
                {
                  if (j == 0) {
                    break label931;
                  }
                  mao.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696086);
                  j = 0;
                  QLog.d("QavVideoRecordUICtrl", 1, "start record, usingZimu");
                  mnp.a("0X8008AD2");
                  break;
                }
              }
            }
          }
          label931:
          if ((localAVActivity.jdField_a_of_type_Mmk != null) && (localAVActivity.jdField_a_of_type_Mmk.a()))
          {
            j = 0;
            mao.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696083);
            break;
          }
          if (mnc.a() < 31457280L)
          {
            if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
              mao.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696077);
            }
            j = 0;
            QLog.d("QavVideoRecordUICtrl", 1, "start record, STORAGE_LEFT_MIN_SIZE not enough");
            break;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().T != 0)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a().a.add(Integer.valueOf(0));
            mnp.a("0X8008AC1");
          }
          if ((mpv.a()) && (mpv.a(localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface).c()))
          {
            QLog.d("QavVideoRecordUICtrl", 1, "start record, redbag PeerInSendMode");
            this.jdField_a_of_type_ComTencentAvVideoController.a().a.add(Integer.valueOf(2));
            mnp.a("0X8008AC0");
          }
          if (localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2))
          {
            localObject = (liq)localAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
            if ((localObject != null) && (((liq)localObject).a() != null))
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a().a.add(Integer.valueOf(6));
              mnp.a("0X8008ABC");
            }
          }
          j = 1;
          break;
          mnp.a("0X8008AB8");
        }
        label1183:
        break;
      }
      mnp.a("0X8008AAF");
      return;
      label1192:
      j = 0;
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {}
    while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.h())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (d())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.a() == 3) || (c()))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.a() == 3) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    while (c())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.e(this.jdField_c_of_type_Int);
    if ((this.jdField_c_of_type_Int != 90) && (this.jdField_c_of_type_Int != 270) && (c()))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(b() + b(2131297672));
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(b(2131297672));
  }
  
  private void w()
  {
    this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationAnimator$AnimatorListener = null;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = null;
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = null;
  }
  
  int a()
  {
    int j = 0;
    boolean bool = bkvi.b();
    if (c())
    {
      if (bool) {
        j = bkvi.b((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      }
    }
    else {
      return j;
    }
    return this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.c();
  }
  
  public int a(boolean paramBoolean)
  {
    int k = 0;
    int j = k;
    if (paramBoolean)
    {
      j = k;
      if (!b())
      {
        j = k;
        if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
        {
          j = k;
          if (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getRotation() == 0.0F) {
            j = b(2131297720);
          }
        }
      }
    }
    return j;
  }
  
  public long a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFile == null) {}
      for (l = this.jdField_g_of_type_Long;; l = mnc.a(this.jdField_a_of_type_JavaIoFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoRecordUICtrl", 2, "getCurrentRecordSize=" + l);
        }
        return l;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = this.jdField_g_of_type_Long;
        QLog.d("QavVideoRecordUICtrl", 2, "getCurrentRecordSize Exception=" + localException.getMessage());
      }
    }
  }
  
  public String a(long paramLong)
  {
    if (paramLong == 0L) {
      return this.jdField_c_of_type_JavaLangString;
    }
    int j = (int)(paramLong / 1000L);
    int k = j / 60;
    return String.format(Locale.getDefault(), "%s (%02d:%02d)", new Object[] { this.jdField_b_of_type_JavaLangString, Integer.valueOf(k), Integer.valueOf(j - k * 60) });
  }
  
  public void a()
  {
    b(2);
  }
  
  public void a(int paramInt)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "removeTimeoutMsg" + paramInt);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Mns != null) {
      this.jdField_a_of_type_Mns.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
    }
    mnp.b();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onEncodeError " + paramInt + ", e=" + paramThrowable);
    if (QLog.isColorLevel())
    {
      paramThrowable.printStackTrace();
      QLog.e("QavVideoRecordUICtrl", 1, "onEncodeError ", paramThrowable);
    }
    mnp.a(paramInt, paramThrowable);
    this.jdField_f_of_type_Boolean = true;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 5)) {}
    do
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new QavVideoRecordUICtrl.3(this));
      do
      {
        return;
      } while (paramInt != 4);
      this.jdField_g_of_type_Boolean = true;
    } while (b() < 1000L);
    this.jdField_a_of_type_AndroidOsHandler.post(new QavVideoRecordUICtrl.4(this));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, 3);
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "sendRecordMsg " + paramInt1 + ", " + paramBoolean + ", " + paramInt2);
    this.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(paramInt1));
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt1, paramInt2, 0), 3000L);
    }
  }
  
  public void a(VideoControlUI paramVideoControlUI, int paramInt)
  {
    if ((paramVideoControlUI == null) || (!(paramVideoControlUI instanceof DoubleVideoCtrlUI))) {}
    for (;;)
    {
      return;
      if ((paramInt == 90) || (paramInt == 270)) {}
      for (paramInt = 1; (paramInt != 0) && (this.jdField_d_of_type_Int != 1); paramInt = 0)
      {
        b(2131297720);
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    boolean bool2 = false;
    QLog.w("QavVideoRecordUICtrl", 1, "onEncodeFinish, filePath[" + paramString + "], mDeleteThisVideo[" + this.jdField_g_of_type_Boolean + "]");
    mnp.d();
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_g_of_type_Boolean = false;
    }
    for (;;)
    {
      try
      {
        bool1 = new File(paramString).delete();
        QLog.d("QavVideoRecordUICtrl", 1, "onEncodeFinish delete=" + bool1);
        this.jdField_f_of_type_Boolean = true;
        return;
      }
      catch (Exception paramString)
      {
        boolean bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QavVideoRecordUICtrl", 2, "onEncodeFinish", paramString);
        bool1 = bool2;
        continue;
      }
      mnc.a(paramString, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      this.jdField_a_of_type_AndroidOsHandler.post(new QavVideoRecordUICtrl.2(this));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoRecordUICtrl", 1, "onReceiveRecordMsg, fromUin[" + paramString1 + "], data[" + paramString2 + "], seq[" + l + "]");
    }
    int k;
    do
    {
      try
      {
        j = Integer.parseInt(paramString2);
        if (j == -1)
        {
          QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, parse int failed, try parse SUPPORT, data=" + paramString2);
          if (TextUtils.isEmpty(paramString2)) {
            return;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        do
        {
          for (;;)
          {
            QLog.i("QavVideoRecordUICtrl", 1, "Qav.Record, onChangeUi_ReceiveRecordMsg, " + localNumberFormatException.getMessage());
            j = -1;
          }
          if ("SUPPORT_TRUE".equals(paramString2))
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a().z = true;
            this.jdField_a_of_type_ComTencentAvVideoController.a().t = Math.max(this.jdField_a_of_type_ComTencentAvVideoController.a().t, 730);
            n();
            return;
          }
        } while (!paramString2.startsWith("SUPPORT_TRUE_7.3.5"));
        this.jdField_a_of_type_ComTencentAvVideoController.a().z = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a().t = Math.max(this.jdField_a_of_type_ComTencentAvVideoController.a().t, 735);
        j = mnq.a(paramString2, this.jdField_a_of_type_Mnm.h);
        QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=" + j);
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long = (j * 60 * 1000L);
        n();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface == null))
      {
        QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, mVideoController == null || mActivity.get().mApp == null");
        return;
      }
      k = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("QavVideoRecordUICtrl", 2, "onChangeUi_ReceiveRecordMsg, session type=" + k);
      }
    } while ((k != 2) && (k != 1));
    switch (j)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentAvVideoController.a().B = true;
      c(3);
      n();
      b(b());
      a(b(), this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, true);
      a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, this.jdField_c_of_type_Int);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      c(true);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).g(l);
      if (!"self".equalsIgnoreCase(paramString1))
      {
        a(2, false);
        if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isResume()) {
          break label675;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.F();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().T != 0) {
          mnp.a("0X8008AC2");
        }
        if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2))
        {
          paramString1 = (liq)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
          if ((paramString1 != null) && (paramString1.a() != null)) {
            mnp.a("0X8008ABC");
          }
        }
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.E();
      }
    case 2: 
      a(1);
      return;
    case 3: 
    case 8: 
      this.jdField_a_of_type_ComTencentAvVideoController.a().B = false;
      if (j == 3)
      {
        a(4, false);
        mao.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696056);
      }
      for (;;)
      {
        m();
        return;
        a(9, false);
        mao.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696055);
      }
    case 4: 
      a(3);
      return;
    case 5: 
      label675:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().A) {
        a();
      }
      break;
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0) {}
      for (j = 6;; j = 7)
      {
        a(j, false);
        return;
      }
      a(5);
      return;
      a(8);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    f();
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {
      return;
    }
    Object localObject;
    int j;
    if ((this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && (!b()) && (!bkvi.b()))
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
      j = c();
      int k = a();
      if ((!paramBoolean) || (b())) {
        bool1 = true;
      }
      ((DoubleVideoCtrlUI)localObject).a(j + k, bool1);
    }
    for (;;)
    {
      localObject = (RedPacketGameView)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131372450);
      if (localObject != null) {
        ((RedPacketGameView)localObject).setScoreMarginTop(a(paramBoolean));
      }
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).g(-1034L);
      v();
      return;
      localObject = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
      j = c();
      if (paramBoolean)
      {
        bool1 = bool2;
        if (!b()) {}
      }
      else
      {
        bool1 = true;
      }
      ((DoubleVideoCtrlUI)localObject).a(j, bool1);
    }
  }
  
  public void a(boolean paramBoolean1, VideoControlUI paramVideoControlUI, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoRecordUICtrl", 2, "setDoubleScreenStatusBar doubleScreen=" + paramBoolean1 + ", controlUI=" + paramVideoControlUI + ", showBar=" + paramBoolean2);
    }
    p();
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Mns != null) && (paramInt1 == 100)) {
      this.jdField_a_of_type_Mns.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
    }
  }
  
  public boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  @TargetApi(17)
  public int[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Mns == null) {}
    try
    {
      if (f()) {
        this.jdField_a_of_type_Mns = new mns();
      }
      if (paramBoolean)
      {
        j = miu.b(paramInt1);
        this.jdField_d_of_type_JavaLangString = mnc.a();
        this.jdField_a_of_type_JavaIoFile = new File(this.jdField_d_of_type_JavaLangString);
        this.jdField_g_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoRecordUICtrl", 2, "doNeedStartRecord path=" + this.jdField_d_of_type_JavaLangString + ", w=" + paramInt1 + ", h=" + paramInt2 + ", rh=" + j);
        }
        paramInt2 = this.jdField_a_of_type_Mnm.f;
        if (paramInt1 > paramInt2)
        {
          float f1 = 1.0F * paramInt2 / paramInt1;
          int k = (int)(j * f1);
          j = k;
          paramInt1 = paramInt2;
          if (QLog.isColorLevel())
          {
            QLog.d("QavVideoRecordUICtrl", 2, "doNeedStartRecord calc size, maxWidth=" + paramInt2 + ", realWidth=" + paramInt2 + ", realHeight=" + k);
            paramInt1 = paramInt2;
            j = k;
          }
          if (j % 2 == 1)
          {
            paramInt2 = j + 1;
            QLog.d("QavVideoRecordUICtrl", 1, "doNeedStartRecord height+1");
            QLog.d("QavVideoRecordUICtrl", 1, "doNeedStartRecord rW=" + paramInt1 + ", rH=" + paramInt2);
            avza localavza = new avza(this.jdField_d_of_type_JavaLangString, paramInt1, paramInt2, 5120000, 1, false, 0);
            localavza.a(EGL14.eglGetCurrentContext());
            if (this.jdField_a_of_type_Mns != null)
            {
              this.jdField_a_of_type_Mns.a(localavza, this);
              mnp.a();
              return new int[] { paramInt1, paramInt2 };
            }
          }
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.jdField_a_of_type_Mns = null;
        QLog.e("QavVideoRecordUICtrl", 1, "oom " + localOutOfMemoryError, localOutOfMemoryError);
        continue;
        a(5, null);
        continue;
        paramInt2 = j;
        continue;
        continue;
        int j = paramInt2;
      }
    }
  }
  
  int b()
  {
    if (c()) {
      return a() + c();
    }
    return 0;
  }
  
  public long b()
  {
    long l = this.jdField_e_of_type_Long - this.jdField_f_of_type_Long;
    QLog.w("QavVideoRecordUICtrl", 1, "getRealDuration, dur[" + l + "], UITime[" + (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long) + "]");
    return Math.max(0L, l);
  }
  
  public void b()
  {
    jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Long = (System.currentTimeMillis() - 200L);
    this.jdField_f_of_type_Long = (this.jdField_d_of_type_Long + 99999999L);
    QLog.w("QavVideoRecordUICtrl", 1, "startRecord, mStartTime[" + this.jdField_d_of_type_Long + "], mRealStartTime[" + this.jdField_f_of_type_Long + "]");
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 31457380L;
    s();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 500L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(11, 500L);
    this.jdField_a_of_type_ComTencentAvVideoController.a(0, this);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.a(2, true);
    int k = this.jdField_a_of_type_ComTencentAvVideoController.a(4, true);
    int m = this.jdField_a_of_type_ComTencentAvVideoController.a(2, 48000, 1, 16);
    int n = this.jdField_a_of_type_ComTencentAvVideoController.a(4, 48000, 1, 16);
    QLog.i("QavVideoRecordUICtrl", 1, "startRecord, after registerDAudioDataCallback, ret2=" + j + ", ret4=" + k + ", set2=" + m + ", set4=" + n);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().E)
    {
      j = this.jdField_a_of_type_ComTencentAvVideoController.a(3, true);
      k = this.jdField_a_of_type_ComTencentAvVideoController.a(3, 48000, 1, 16);
      QLog.d("QavVideoRecordUICtrl", 1, "startRecord, registerDAudioDataCallback, mix = true, ret3=" + j + ", set3=" + k);
      this.jdField_a_of_type_ComTencentAvVideoController.a().C = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().D = true;
    }
  }
  
  public void b(int paramInt)
  {
    jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    QLog.w("QavVideoRecordUICtrl", 1, "endRecord, stopType[" + paramInt + "], mStartTime[" + this.jdField_d_of_type_Long + "], mRealStartTime[" + this.jdField_f_of_type_Long + "], mEndTime[" + this.jdField_e_of_type_Long + "]");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(15);
    if (paramInt == 1)
    {
      a(b());
      if ((b() >= 1000L) && (paramInt == 1)) {
        break label376;
      }
    }
    label376:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Mns != null) {
        this.jdField_a_of_type_Mns.a();
      }
      this.jdField_a_of_type_JavaIoFile = null;
      this.jdField_a_of_type_ComTencentAvVideoController.a(0, null);
      int j = this.jdField_a_of_type_ComTencentAvVideoController.b(2, true);
      int k = this.jdField_a_of_type_ComTencentAvVideoController.b(4, true);
      QLog.i("QavVideoRecordUICtrl", 1, "endRecord, after unregisterDAudioDataCallbackAll, ret2=" + j + ", ret4=" + k);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().E)
      {
        j = this.jdField_a_of_type_ComTencentAvVideoController.a(3, false);
        k = this.jdField_a_of_type_ComTencentAvVideoController.a(3, 48000, 1, 16);
        this.jdField_a_of_type_ComTencentAvVideoController.a().C = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a().D = false;
        QLog.i("QavVideoRecordUICtrl", 1, "endRecord, registerDAudioDataCallback, mix = true, ret3=" + j + ", set3=" + k);
      }
      mnp.a(this.jdField_a_of_type_Mnm.r, this.jdField_a_of_type_Mnm.s, paramInt, b());
      return;
      if (paramInt == 2)
      {
        b(b());
        break;
      }
      a(-1L);
      break;
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "setShowState=" + paramInt);
    switch (paramInt)
    {
    default: 
      o();
      u();
      return;
    }
    this.jdField_d_of_type_Int = 3;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidWidgetImageButton.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.setMargins(b(2131297713), 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.height = -2;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = -2;
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setLayoutParams(this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    }
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.requestLayout();
    }
    if (paramBoolean) {
      d();
    }
    for (;;)
    {
      p();
      a(c());
      return;
      u();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.n(paramBoolean);
  }
  
  public boolean b()
  {
    return (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.i());
  }
  
  public int c()
  {
    return b(2131297720);
  }
  
  public void c()
  {
    b(1);
  }
  
  public void c(int paramInt)
  {
    b(paramInt, true);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(14);
    } while (!paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long);
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Int == 3;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) || (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.g())) {}
    do
    {
      return;
      this.jdField_c_of_type_Int = a(this.jdField_c_of_type_Int);
      f(this.jdField_c_of_type_Int);
      u();
      v();
    } while (!c());
    int j;
    if ((this.jdField_c_of_type_Int == 90) || (this.jdField_c_of_type_Int == 270))
    {
      j = 1;
      if ((j == 0) || (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) || (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.h())) {
        break label296;
      }
      if (d() != 3) {
        break label238;
      }
      j = b(2131297709);
      label111:
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.height = j;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = j;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = actj.a(15.0F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
      if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setLayoutParams(this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      }
      if (this.jdField_c_of_type_Int != 90) {
        break label249;
      }
      if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setRotation(-90.0F);
      }
      if (this.jdField_e_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
      }
    }
    for (;;)
    {
      p();
      a(c());
      return;
      j = 0;
      break;
      label238:
      j = b(2131297715);
      break label111;
      label249:
      if (this.jdField_e_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleX(-1.0F);
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleY(-1.0F);
      }
      if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setRotation(-90.0F);
        continue;
        label296:
        this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.height = -2;
        this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = -2;
        this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = 0;
        if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setLayoutParams(this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
        }
        if (this.jdField_e_of_type_AndroidWidgetRelativeLayout != null)
        {
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
        }
        if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setRotation(this.jdField_c_of_type_Int);
        }
      }
    }
  }
  
  public void d(int paramInt)
  {
    paramInt = a(paramInt);
    if (this.jdField_c_of_type_Int != paramInt)
    {
      this.jdField_c_of_type_Int = paramInt;
      a(c());
      r();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_c_of_type_Int == 90) || (this.jdField_c_of_type_Int == 270);
  }
  
  public int e()
  {
    return a(c());
  }
  
  public void e()
  {
    jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
    if (this.jdField_a_of_type_Mns != null) {
      this.jdField_a_of_type_Mns.b();
    }
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidViewView = null;
  }
  
  public void e(int paramInt)
  {
    u();
  }
  
  public boolean e()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) || (!c())) {
      return;
    }
    int j = a();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.topMargin = j;
    QLog.i("QavVideoRecordUICtrl", 1, "iveswu statusBar:density=" + ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDisplayMetrics().density);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
  }
  
  public void f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 180: 
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.setMargins(actj.a(10.0F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources()), 0, 0, 0);
      localLayoutParams.addRule(2, 0);
      localLayoutParams.addRule(1, 2131374988);
      localLayoutParams.addRule(6, 2131374988);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      if (paramInt == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(19);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(0.0F);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setRotation(paramInt);
        return;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(21);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(180.0F);
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.setMargins(actj.a(-12.5F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources()), 0, 0, actj.a(32.5F, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources()));
    localLayoutParams.addRule(2, 2131374988);
    localLayoutParams.addRule(1, 0);
    localLayoutParams.addRule(6, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    if (paramInt == 90)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(19);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(270.0F);
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setRotation(270.0F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(21);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(90.0F);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setRotation(90.0F);
  }
  
  public void g()
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onEncodeStart");
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void g(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {}
    int j;
    do
    {
      boolean bool;
      do
      {
        return;
        bool = this.jdField_a_of_type_ComTencentAvVideoController.a().A;
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoRecordUICtrl", 2, "onChangeUI_RecordReceiveEffect " + paramInt + ", recording=" + bool);
        }
      } while ((!bool) || (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
      j = 1 << paramInt - 1;
      if ((this.jdField_e_of_type_Int & j) != j) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QavVideoRecordUICtrl", 2, "onChangeUI_RecordReceiveEffect return, type=" + paramInt);
    return;
    this.jdField_e_of_type_Int = (j | this.jdField_e_of_type_Int);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      FaceItem localFaceItem = (FaceItem)((lhr)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a();
      if ((localFaceItem == null) || (!localFaceItem.getId().equalsIgnoreCase("daquan"))) {
        break;
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QavVideoRecordUICtrl.8(this), 2000L);
      }
      for (;;)
      {
        mnp.a("0X8008AC8");
        return;
        mao.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696068);
      }
      mao.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696067);
      mnp.a("0X8008AC9");
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(15, 2000L);
      mnp.a("0X8008ACA");
      return;
    }
  }
  
  public boolean g()
  {
    if ((k()) || (!f()) || (!i()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().z)) {}
    for (boolean bool = false;; bool = true)
    {
      QLog.i("QavVideoRecordUICtrl", 1, "isSupportRecord. isSupport = " + bool);
      return bool;
    }
  }
  
  public void h() {}
  
  public boolean h()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {}
    boolean bool1;
    boolean bool6;
    boolean bool7;
    do
    {
      return false;
      bool1 = this.jdField_a_of_type_ComTencentAvVideoController.a().A;
      bool6 = this.jdField_a_of_type_ComTencentAvVideoController.a().B;
      bool7 = this.jdField_a_of_type_ComTencentAvVideoController.a().w;
    } while (!g());
    if (bool1) {
      return true;
    }
    Object localObject;
    boolean bool4;
    boolean bool3;
    boolean bool2;
    if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3))
    {
      localObject = (lhr)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
      FaceItem localFaceItem = (FaceItem)((lhr)localObject).a();
      if (localFaceItem != null)
      {
        bool4 = ((lhr)localObject).a();
        bool3 = localFaceItem.isSameType("face");
        bool2 = localFaceItem.isSameType("voicesticker");
      }
    }
    for (boolean bool5 = true;; bool5 = false)
    {
      if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
      {
        localObject = (ljp)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
        if (localObject != null)
        {
          localObject = (ZimuItem)((ljp)localObject).a();
          if (localObject != null) {
            if (!TextUtils.isEmpty(((ZimuItem)localObject).getId())) {
              bool1 = true;
            }
          }
        }
      }
      for (;;)
      {
        QLog.i("QavVideoRecordUICtrl", 1, "isEnableRecord. isPlayingMagicFace " + bool5 + ", isUsingZimu=" + bool1 + ", isSender=" + bool4);
        if ((bool7) || (bool1) || ((bool5) && (bool4) && ((bool3) || (bool2))) || ((bool6) && (this.jdField_a_of_type_ComTencentAvVideoController.a().t < 735))) {
          break;
        }
        return true;
        bool1 = false;
        continue;
        bool1 = false;
      }
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      if (!jdField_b_of_type_Boolean) {
        return true;
      }
      long l = c();
      if (l > this.jdField_a_of_type_Long)
      {
        c();
        l = this.jdField_a_of_type_Long / 1000L;
        axqy.b(null, "CliOper", "", "", "0X800863C", "0X800863C", 0, 0, String.valueOf(l), "", "", "");
        axrn.a(BaseApplicationImpl.getContext()).a("", "av_record_timeout", true, l, 0L, null, "", false);
        return true;
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setProgress(l, this.jdField_a_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(l));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 500L);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
      if (!jdField_b_of_type_Boolean) {
        return true;
      }
      ThreadManager.postImmediately(new QavVideoRecordUICtrl.1(this), null, false);
      continue;
      QLog.d("QavVideoRecordUICtrl", 1, "on msg time, msg=" + paramMessage.what);
      a(paramMessage.what, false, paramMessage.arg1 - 1);
      continue;
      if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).i)
      {
        m();
        continue;
        if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          mao.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696069);
        }
      }
    }
  }
  
  public void i() {}
  
  public boolean i()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_Mnm.r <= this.jdField_a_of_type_Mnm.jdField_d_of_type_Int) {
        break label111;
      }
      this.jdField_b_of_type_Int = 2;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mnm.jdField_a_of_type_Int != 1) {
        this.jdField_b_of_type_Int = 4;
      }
      if (jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Int = 5;
      }
      QLog.d("QavVideoRecordUICtrl", 1, "isPerformanceSupport=" + this.jdField_b_of_type_Int);
      if ((this.jdField_b_of_type_Int != 2) && (this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 5)) {
        break;
      }
      return true;
      label111:
      if ((this.jdField_a_of_type_Mnm.r == this.jdField_a_of_type_Mnm.jdField_d_of_type_Int) && (this.jdField_a_of_type_Mnm.s >= this.jdField_a_of_type_Mnm.jdField_e_of_type_Int)) {
        this.jdField_b_of_type_Int = 2;
      } else if (this.jdField_a_of_type_Mnm.r > this.jdField_a_of_type_Mnm.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = 1;
      } else if ((this.jdField_a_of_type_Mnm.r == this.jdField_a_of_type_Mnm.jdField_b_of_type_Int) && (this.jdField_a_of_type_Mnm.s >= this.jdField_a_of_type_Mnm.jdField_c_of_type_Int)) {
        this.jdField_b_of_type_Int = 1;
      } else {
        this.jdField_b_of_type_Int = 3;
      }
    }
    return false;
  }
  
  public void j()
  {
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    QLog.w("QavVideoRecordUICtrl", 1, "onEncodeRealStart, mRealStartTime[" + this.jdField_f_of_type_Long + "], StartOffset[" + (this.jdField_f_of_type_Long - this.jdField_d_of_type_Long) + "]");
  }
  
  public boolean j()
  {
    if (this.jdField_b_of_type_Int == 0) {
      i();
    }
    return this.jdField_b_of_type_Int == 1;
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "animExpandBar, cur=" + this.jdField_d_of_type_Int + ", mAnimExpanding=" + this.jdField_h_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QavVideoRecordUICtrl", 2, "animExpandBar, isRunning");
      }
      return;
    }
    q();
  }
  
  public void l()
  {
    a(5, true);
    a(b(), this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, false);
    b(true);
    if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      mao.a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131696088);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().B = false;
    n();
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
    long l = (System.currentTimeMillis() - this.jdField_c_of_type_Long) / 1000L;
    axqy.b(null, "CliOper", "", "", "0X800863E", "0X800863E", 0, 0, "", String.valueOf(l), "", "");
    axrn.a(BaseApplicationImpl.getContext()).a(((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "av_record_cancel", true, l, 0L, null, "", false);
    c(1);
  }
  
  public void m()
  {
    long l = AudioHelper.b();
    QLog.w("QavVideoRecordUICtrl", 1, "endBeenRecordedState, seq[" + l + "]");
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI != null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().B = false;
      c(1);
      a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, this.jdField_c_of_type_Int);
      b(true);
      a(b(), this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, false);
      c(false);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a(true);
    }
    for (;;)
    {
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).g(l);
      n();
      if (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(163) });
      }
      w();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QavVideoRecordUICtrl", 2, "endBeenRecordedState something is null: mControlUI=" + this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI);
      }
    }
  }
  
  public void n()
  {
    long l = AudioHelper.b();
    QLog.w("QavVideoRecordUICtrl", 1, "updateRecordButton, seq[" + l + "]");
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView == null)) {
      return;
    }
    if (h())
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().A) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(3, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.f());
      }
      for (;;)
      {
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoControlUI.f(l, 65535);
        return;
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(2, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.f());
      }
    }
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(1, ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvAppVideoAppInterface.f());
  }
  
  public void onClick(View paramView)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onClick");
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton) {
      l();
    }
    while (paramView != this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView) {
      return;
    }
    t();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     min
 * JD-Core Version:    0.7.0.1
 */