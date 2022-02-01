import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.animation.LinearInterpolator;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.floatwindow.CommonGameFloatWindowLayout;
import com.tencent.avgame.floatwindow.FloatWindowController.1;
import com.tencent.avgame.floatwindow.FloatWindowController.6;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class mya
  implements mxy, mxz, nag, nah
{
  public int a;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new myf(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new myg(this);
  protected AVGameAppInterface a;
  private CommonGameFloatWindowLayout jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout;
  Runnable jdField_a_of_type_JavaLangRunnable = new FloatWindowController.1(this);
  private myi jdField_a_of_type_Myi = new myi();
  boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Runnable jdField_b_of_type_JavaLangRunnable = new FloatWindowController.6(this);
  public boolean b;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  private int d;
  public boolean d;
  private int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int h = 0;
  
  private mya()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  public static mya a()
  {
    return myh.a;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 1, "updateCommonGameState and state:  " + paramInt + " mCommonGameFloatWindowLayout " + this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout + " mIsFloatWindowShowing " + this.jdField_f_of_type_Boolean + " mFloatParams.isForeground " + this.jdField_a_of_type_Myi.jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout == null) || (!this.jdField_f_of_type_Boolean) || (!this.jdField_a_of_type_Myi.jdField_a_of_type_Boolean)) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.h = paramInt;
      return;
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a();
      continue;
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b();
      continue;
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.c();
    }
  }
  
  private void a(String paramString, RoomInfo paramRoomInfo, GameRecordInfo paramGameRecordInfo)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Intent localIntent = new Intent(localBaseApplication, AVGameActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("key_start_time", SystemClock.elapsedRealtime());
    localIntent.putExtra("enter_game_result", this.jdField_d_of_type_Boolean);
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FloatWindowController", 2, "enterAvGameActivity roomId " + paramString);
      }
      localIntent.putExtra("key_room_id", paramString);
      localIntent.putExtra("key_room_be_new_enter", false);
      if (paramRoomInfo != null)
      {
        paramString = new Bundle();
        paramString.putSerializable("key_room_info", paramRoomInfo);
        localIntent.putExtra("key_room_bundle", paramString);
        if (QLog.isColorLevel()) {
          QLog.d("FloatWindowController", 2, "enterAvGameActivity roomInfo " + paramRoomInfo.toString());
        }
      }
      if (paramGameRecordInfo != null) {
        localIntent.putExtra("key_game_record_info", paramGameRecordInfo);
      }
      localBaseApplication.startActivity(localIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("FloatWindowController", 2, "returnBackAvGameActivity roomId empty");
    }
    QQToast.a(localBaseApplication, 2131690343, 0).a();
    c();
  }
  
  private boolean a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout == null)
    {
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout = new CommonGameFloatWindowLayout(localBaseApplication);
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.setFloatPositionChangeCallback(this);
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.setOnFloatWindowClickListener(this);
    }
    this.jdField_a_of_type_Myi.jdField_a_of_type_Int = (this.jdField_f_of_type_Int + this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b() / 2);
    this.jdField_a_of_type_Myi.jdField_b_of_type_Int = (this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.c() / 2 + agej.a(115.0F, BaseApplicationImpl.getContext().getResources()));
    this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a(this.jdField_a_of_type_Myi), this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b(this.jdField_a_of_type_Myi));
    return this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a();
  }
  
  private void b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "showPermissionDialog in");
    }
    bhpc localbhpc = bhlq.a(paramActivity, 230).setMessage(2131690272).setNegativeButton(null, null).setPositiveButton(2131698383, new myb(this, paramActivity));
    localbhpc.setTitle(null);
    localbhpc.setCancelable(true);
    localbhpc.setCanceledOnTouchOutside(false);
    localbhpc.setOnDismissListener(new myc(this, paramActivity));
    localbhpc.show();
    bdll.b(null, "dc00898", "", "", "0X800B037", "0X800B037", 0, 0, "", "", "", "");
  }
  
  private void b(AVGameAppInterface paramAVGameAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "init()");
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    this.jdField_b_of_type_Int = bhtq.a();
    this.jdField_c_of_type_Int = bhtq.b();
    int i = agej.a(10.0F, localBaseApplication.getResources());
    this.jdField_f_of_type_Int = i;
    this.jdField_d_of_type_Int = i;
    i = agej.a(16.0F, localBaseApplication.getResources());
    this.jdField_g_of_type_Int = i;
    this.jdField_e_of_type_Int = i;
    this.jdField_a_of_type_Myi.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Myi.jdField_a_of_type_Int = -1000;
    this.jdField_a_of_type_Myi.jdField_b_of_type_Int = -1000;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    l();
  }
  
  private boolean b()
  {
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface == null) || (this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp() == null)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = FloatingScreenPermission.checkPermission(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp());
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("FloatWindowController", 2, "hasFloatPermission, isOpEnable: " + bool2);
    return bool2;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout != null) {
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b();
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  private void k()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i;
    int j;
    if (localBaseApplication != null)
    {
      i = localBaseApplication.getResources().getDisplayMetrics().widthPixels;
      j = localBaseApplication.getResources().getDisplayMetrics().heightPixels;
      if (i != this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = i;
      }
      if (j != this.jdField_c_of_type_Int) {
        this.jdField_c_of_type_Int = j;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "updateCommonGameFloatWindow mScreenWidth: " + this.jdField_b_of_type_Int + "  mScreenHeight: " + this.jdField_c_of_type_Int + " mIsFloatWindowShowing: " + this.jdField_f_of_type_Boolean);
    }
    int k;
    if (this.jdField_f_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FloatWindowController", 2, "updateCommonGameFloatWindow isForeground: " + this.jdField_a_of_type_Myi.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Myi.jdField_a_of_type_Boolean)
      {
        k = this.jdField_a_of_type_Myi.jdField_b_of_type_Int;
        if (this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a() >= this.jdField_b_of_type_Int / 2) {
          break label287;
        }
        i = 1;
        if (i == 0) {
          break label292;
        }
        j = this.jdField_f_of_type_Int + this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b() / 2;
        label221:
        if (k >= this.jdField_g_of_type_Int + this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.c() / 2) {
          break label315;
        }
        i = this.jdField_g_of_type_Int + this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.c() / 2;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Myi.jdField_a_of_type_Int = j;
      this.jdField_a_of_type_Myi.jdField_b_of_type_Int = i;
      d();
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a(this.jdField_a_of_type_Myi);
      return;
      label287:
      i = 0;
      break;
      label292:
      j = this.jdField_b_of_type_Int - this.jdField_d_of_type_Int - this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b() / 2;
      break label221;
      label315:
      i = k;
      if (k > this.jdField_c_of_type_Int - this.jdField_e_of_type_Int - this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.c() / 2) {
        i = this.jdField_c_of_type_Int - this.jdField_e_of_type_Int - this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.c() / 2;
      }
    }
  }
  
  private void l()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void m()
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.jdField_e_of_type_Boolean = true;
    }
  }
  
  private void n()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.jdField_e_of_type_Boolean = false;
    }
  }
  
  public int a(Player paramPlayer)
  {
    if (paramPlayer == null) {
      return 0;
    }
    switch (paramPlayer.status)
    {
    default: 
      return 0;
    }
    if (myk.a().a().a(paramPlayer.uin)) {
      return 2;
    }
    return 1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "onFloatWindowClick()");
    }
    mze localmze = myk.a().a();
    if (localmze.a() == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FloatWindowController", 2, "onFloatWindowClick() roomId == 0, can not return AVGameActivity");
      }
      return;
    }
    a(String.valueOf(localmze.a()), myk.a().a().a(), localmze.a());
    bdll.b(null, "dc00898", "", "", "0X800B036", "0X800B036", a(myk.a().a().a()) + 1, 0, "", "", "", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j;
    int k;
    if (this.jdField_f_of_type_Boolean)
    {
      j = this.jdField_a_of_type_Myi.jdField_a_of_type_Int;
      int m = this.jdField_a_of_type_Myi.jdField_b_of_type_Int;
      j -= paramInt1;
      k = this.jdField_b_of_type_Int;
      if (j >= 0) {
        break label111;
      }
      paramInt1 = 0;
      paramInt2 = m - paramInt2;
      if (paramInt2 >= 0) {
        break label127;
      }
      paramInt2 = i;
    }
    for (;;)
    {
      this.jdField_a_of_type_Myi.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_Myi.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a(this.jdField_a_of_type_Myi), this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b(this.jdField_a_of_type_Myi));
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a();
      return;
      label111:
      paramInt1 = j;
      if (j <= k) {
        break;
      }
      paramInt1 = k;
      break;
      label127:
      if (paramInt2 > this.jdField_c_of_type_Int) {
        paramInt2 = this.jdField_c_of_type_Int;
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "onRoomOtherMemberExit exitType: " + paramInt + " kickUin:" + paramString1 + " exitRoomTip:" + paramString2);
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2) {}
  
  public void a(long paramLong, String paramString1, String paramString2) {}
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt) {}
  
  public void a(Activity paramActivity)
  {
    if (!b())
    {
      m();
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      b(paramActivity);
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "showFloatWindow called mIsFloatWindowShowing: " + this.jdField_f_of_type_Boolean);
    }
    if (this.jdField_f_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = paramBoolean2;
      if (b()) {
        break;
      }
    } while (paramBoolean1);
    a(paramActivity);
    return;
    m();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    if (a())
    {
      this.jdField_f_of_type_Boolean = true;
      e();
      if ((paramActivity != null) && (!paramActivity.isFinishing()) && (!paramBoolean1)) {
        paramActivity.finish();
      }
      myk.a().a(this);
      myk.a().a(this);
      return;
    }
    QLog.e("FloatWindowController", 1, "showFloatWindowInner failed");
  }
  
  public void a(AVGameAppInterface paramAVGameAppInterface)
  {
    b(paramAVGameAppInterface);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "onChangeUserStatusFailed and errorMsg is " + paramString);
    }
  }
  
  public void a(String paramString, int paramInt, mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive pushOnChangeUserStatus");
    }
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "onGameStartFail");
    }
  }
  
  public void a(String paramString, mze parammze) {}
  
  public void a(HashMap<String, String> paramHashMap) {}
  
  public void a(mze parammze) {}
  
  public void a(mze parammze, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "onChangeUserStatusSuccess ");
    }
  }
  
  public void a(mze parammze, String paramString) {}
  
  public void a(mze parammze, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive onGameOverPush");
    }
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "updateFloatParamsIsForeGround isForeground:" + paramBoolean);
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (paramBoolean) {
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
    }
    do
    {
      return;
      this.jdField_a_of_type_Myi.jdField_a_of_type_Boolean = paramBoolean;
    } while (!this.jdField_f_of_type_Boolean);
    k();
  }
  
  public boolean a(int paramInt, String paramString, mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive onRoomSelfExit exitType:" + paramInt + " exitRoomTip:" + paramString);
    }
    c();
    return false;
  }
  
  public void b()
  {
    k();
  }
  
  public void b(long paramLong, String paramString1, String paramString2) {}
  
  public void b(String paramString, mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive pushOnRoomEnter");
    }
  }
  
  public void b(mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive pushOnGameChange");
    }
  }
  
  public void b(mze parammze, int paramInt) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "hideFloatWindow called");
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    j();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    n();
    myk.a().b(this);
    myk.a().b(this);
  }
  
  public void c(String paramString, mze parammze) {}
  
  public void c(mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "onGameStartSuc and engineData is " + parammze);
    }
    e();
  }
  
  public void c(mze parammze, int paramInt) {}
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    int i = this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a(this.jdField_a_of_type_Myi);
    int j = this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b(this.jdField_a_of_type_Myi);
    int k = this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.d();
    int m = this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.e();
    if ((Math.abs(k - i) < 10) && (Math.abs(m - j) < 10))
    {
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a(i, j);
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(250L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new myd(this, k, i, m, j));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new mye(this, i, j));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void d(String paramString, mze parammze) {}
  
  public void d(mze parammze) {}
  
  public void e()
  {
    Player localPlayer = myk.a().a().a();
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 1, String.format("updateState self= %s", new Object[] { localPlayer }));
    }
    a(a(localPlayer));
  }
  
  public void e(mze parammze) {}
  
  public void f()
  {
    c();
    if (this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout != null) {
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.e();
    }
    BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    n();
  }
  
  public void f(mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive onGameStartPush");
    }
    e();
  }
  
  public void g() {}
  
  public void g(mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive onPlayerChangePush");
    }
    e();
  }
  
  public void h() {}
  
  public void h(mze parammze) {}
  
  public void i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mya
 * JD-Core Version:    0.7.0.1
 */