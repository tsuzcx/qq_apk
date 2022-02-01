package com.tencent.mobileqq.ptt;

import acvv;
import afgv;
import agkm;
import amtj;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import azbh;
import azbi;
import azbk;
import azbl;
import azbm;
import azbn;
import azbo;
import azbp;
import azbq;
import azbr;
import azbu;
import azcf;
import bftt;
import bfxf;
import bfyc;
import bfyl;
import bjng;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class LSRecordPanel
  extends RelativeLayout
  implements afgv, Handler.Callback, azcf, bfyc
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  public Animation a;
  public azbk a;
  private azbr jdField_a_of_type_Azbr;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  private VolumeIndicateSquareView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LSRecordTextView jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView;
  private TouchProxyRelativeLayout jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout;
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_b_of_type_AndroidViewView;
  public Animation b;
  public azbk b;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_c_of_type_AndroidViewView;
  public Animation c;
  private volatile boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  public Animation d;
  private boolean jdField_d_of_type_Boolean = true;
  
  public LSRecordPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public LSRecordPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LSRecordPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private QQRecorder.RecorderParam a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000)) {
      return bfyl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
    return new QQRecorder.RecorderParam(bfyl.jdField_a_of_type_Int, 8000, 0);
  }
  
  private void a(QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS sendPtt");
    }
    azbu.b(this.jdField_a_of_type_JavaLangString);
    MessageRecord localMessageRecord = acvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.c);
    if (localMessageRecord == null) {
      return;
    }
    ((MessageForPtt)localMessageRecord).c2cViaOffline = true;
    long l = localMessageRecord.uniseq;
    Bundle localBundle = new Bundle();
    localBundle.putInt("DiyTextId", localMessageRecord.vipBubbleDiyTextId);
    acvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_JavaLangString, l, false, this.jdField_a_of_type_Int, paramRecorderParam.c, true, 0, 3, true, localMessageRecord.vipSubBubbleId, localBundle);
    this.jdField_a_of_type_JavaLangString = null;
    bfxf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, 8, this.jdField_a_of_type_Int);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopCheckingChick:" + paramBoolean);
    }
    if (!paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
        int i = (int)(getResources().getDisplayMetrics().density * 4.0F);
        localLayoutParams.height -= i;
        localLayoutParams.width -= i;
        int j = localLayoutParams.rightMargin;
        localLayoutParams.rightMargin = (i / 2 + j);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      c(0);
      if (this.jdField_a_of_type_Azbr != null) {
        this.jdField_a_of_type_Azbr.a(false, -1, amtj.a(2131705529), true, false);
      }
      return;
    }
    m();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS close: " + this.jdField_b_of_type_Int + " done:" + paramBoolean1);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    if ((this.jdField_b_of_type_Int == 0) || ((!paramBoolean2) && (this.jdField_b_of_type_Int == 5))) {}
    do
    {
      return;
      this.jdField_c_of_type_Boolean = paramBoolean1;
      if (this.jdField_b_of_type_Int == 1)
      {
        a(false);
        return;
      }
      if (!paramBoolean2) {
        break;
      }
    } while (!this.jdField_b_of_type_Boolean);
    c(5);
    this.jdField_c_of_type_AndroidViewView.clearAnimation();
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setAnimation(null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    ((GradientDrawable)this.jdField_c_of_type_AndroidViewView.getBackground()).setColor(-15550475);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    g();
    n();
    this.jdField_a_of_type_Azbk = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    int i = (int)(getResources().getDisplayMetrics().density * 4.0F);
    ((RelativeLayout.LayoutParams)localObject).height -= i;
    ((RelativeLayout.LayoutParams)localObject).width -= i;
    int j = ((RelativeLayout.LayoutParams)localObject).rightMargin;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = (i / 2 + j);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    e();
    return;
    if (this.jdField_a_of_type_Azbk != null)
    {
      c(5);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setAnimation(null);
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      localObject = (GradientDrawable)this.jdField_c_of_type_AndroidViewView.getBackground();
      i = this.jdField_a_of_type_Azbk.jdField_a_of_type_Int;
      ((GradientDrawable)localObject).setColor(i);
      float f = this.jdField_a_of_type_Azbk.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
      g();
      azbh localazbh = new azbh(f, 1.0F, f, 1.0F, 1, 0.5F, 1, 0.5F, this.jdField_a_of_type_Azbk);
      localazbh.a((GradientDrawable)localObject, i, -15550475);
      localazbh.setInterpolator(new LinearInterpolator());
      localazbh.setDuration(500L);
      localazbh.setFillAfter(true);
      localazbh.setAnimationListener(new azbq(this));
      this.jdField_b_of_type_AndroidViewAnimationAnimation = localazbh;
      this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS startCloseAnimation");
      }
      e();
      return;
    }
    d(false);
  }
  
  private void b(boolean paramBoolean)
  {
    int i = -43434;
    int j;
    if (paramBoolean)
    {
      j = -15550475;
      if (!paramBoolean) {
        break label121;
      }
      label16:
      if (this.jdField_b_of_type_Azbk == null) {
        break label128;
      }
      i = this.jdField_b_of_type_Azbk.jdField_a_of_type_Int;
    }
    for (;;)
    {
      azbi localazbi = new azbi(this.jdField_b_of_type_AndroidViewView, i, j, this.jdField_b_of_type_Azbk);
      localazbi.setInterpolator(new AccelerateDecelerateInterpolator());
      localazbi.setDuration(300L);
      localazbi.setFillAfter(true);
      localazbi.setAnimationListener(new azbp(this));
      this.jdField_b_of_type_AndroidViewView.startAnimation(localazbi);
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS startSideAnimation");
      }
      return;
      j = -43434;
      break;
      label121:
      i = -15550475;
      break label16;
      label128:
      this.jdField_b_of_type_Azbk = new azbk();
      this.jdField_b_of_type_Azbk.jdField_a_of_type_Int = i;
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int) {}
    do
    {
      return;
      this.jdField_b_of_type_Int = paramInt;
    } while (!QLog.isDevelopLevel());
    QLog.d("LsRecord", 4, "LS setMode: " + this.jdField_b_of_type_Int);
  }
  
  private void c(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  private void d(int paramInt)
  {
    bftt.b(paramInt, false);
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setText("-:--");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
    c(0);
    if (this.jdField_a_of_type_Azbr != null) {
      this.jdField_a_of_type_Azbr.a(this.jdField_c_of_type_Boolean, -1, this.jdField_b_of_type_JavaLangString, false, paramBoolean);
    }
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void i()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131380807);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131380806);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131380808);
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      super.setContentDescription(null);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(null);
      this.jdField_b_of_type_AndroidViewView.setContentDescription(null);
      this.jdField_c_of_type_AndroidViewView.setContentDescription(amtj.a(2131705528));
    }
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView = ((LSRecordTextView)super.findViewById(2131377648));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)super.findViewById(2131368652));
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setNotLayoutInSettingText(true);
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(4);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if ((int)(localDisplayMetrics.widthPixels / localDisplayMetrics.density) >= 320) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setCount(30);
    }
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setText("-:--");
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131376138);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(new azbn(this));
    this.jdField_d_of_type_AndroidViewView.setContentDescription(amtj.a(2131705525));
  }
  
  private void j() {}
  
  private void k() {}
  
  private void l()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startCheckingClick");
    }
    c(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 250L);
    if (this.jdField_a_of_type_Azbr != null) {
      this.jdField_a_of_type_Azbr.a(false, false, this);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    int i = (int)(getResources().getDisplayMetrics().density * 4.0F);
    localLayoutParams.height += i;
    localLayoutParams.width += i;
    localLayoutParams.rightMargin -= i / 2;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void m()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS expand");
    }
    c(2);
    Object localObject;
    float f1;
    if (this.jdField_a_of_type_Azbk == null)
    {
      getGlobalVisibleRect(this.jdField_c_of_type_AndroidGraphicsRect);
      localObject = new Rect();
      this.jdField_c_of_type_AndroidViewView.getGlobalVisibleRect((Rect)localObject);
      f1 = ((Rect)localObject).width() * 0.5F;
      float f2 = ((Rect)localObject).left + f1 - this.jdField_c_of_type_AndroidGraphicsRect.left;
      float f3 = ((Rect)localObject).top + f1 - this.jdField_c_of_type_AndroidGraphicsRect.top;
      f3 = (float)Math.sqrt(f3 * f3 + f2 * f2);
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS init dest bgTrack: " + f2 + ", " + f3);
      }
      f1 = f3 / f1;
      this.jdField_a_of_type_Azbk = new azbk();
      this.jdField_a_of_type_Azbk.jdField_a_of_type_Float = 1.0F;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
      localObject = new azbh(1.0F, f1, 1.0F, f1, 1, 0.5F, 1, 0.5F, this.jdField_a_of_type_Azbk);
      ((azbh)localObject).setInterpolator(new LinearInterpolator());
      ((Animation)localObject).setDuration(450L);
      ((Animation)localObject).setFillAfter(true);
      ((Animation)localObject).setAnimationListener(new azbo(this));
      this.jdField_a_of_type_AndroidViewAnimationAnimation = ((Animation)localObject);
      this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS startExpandAnimation");
      }
      d();
      return;
      f1 = this.jdField_a_of_type_Azbk.jdField_a_of_type_Float;
    }
  }
  
  private void n()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopRecord");
    }
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      d(2131230744);
      bftt.a(BaseApplicationImpl.sApplication, false);
    }
    for (;;)
    {
      if ((!bool) || (!this.jdField_d_of_type_Boolean)) {
        d(true);
      }
      return;
      bool = false;
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      azbu.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = null;
      bfxf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8);
    }
  }
  
  public int a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderStart");
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler.post(new LSRecordPanel.8(this));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
    this.jdField_a_of_type_Boolean = true;
    return 350;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onBeginReceiveData");
    }
    int i = agkm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000;
    int j = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    if ((j & 0x4) != 0) {
      i = agkm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SVIP_MaxPtt") * 1000;
    }
    for (;;)
    {
      i -= 200;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711687, i);
      return i + 200;
      if ((j & 0x2) != 0) {
        i = agkm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "VIP_MaxPtt") * 1000;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onInitSuccess");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderVolumeStateChanged");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, TouchProxyRelativeLayout paramTouchProxyRelativeLayout, azbr paramazbr)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout = paramTouchProxyRelativeLayout;
    this.jdField_a_of_type_Azbr = paramazbr;
    this.jdField_a_of_type_AndroidOsHandler = new bjng(Looper.getMainLooper(), this);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS init");
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderNotReady");
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin = paramString2;
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderPrepare");
    }
    paramRecorderParam = bfyl.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    azbu.a(paramString);
    azbu.a(paramString, paramRecorderParam, paramRecorderParam.length);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler.post(new LSRecordPanel.7(this));
    if (this.jdField_a_of_type_JavaLangString != null) {
      d(2131230733);
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderEnd");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (this.jdField_c_of_type_Boolean) {
      if (this.jdField_a_of_type_Int < 500)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_b_of_type_JavaLangString = amtj.a(2131705526);
        o();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new LSRecordPanel.9(this));
      return;
      a(paramRecorderParam);
      continue;
      o();
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderError");
    }
    o();
    this.jdField_a_of_type_AndroidOsHandler.post(new LSRecordPanel.10(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    azbu.a(paramString, paramArrayOfByte, paramInt1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    if ((b()) && (this.jdField_b_of_type_Int != 5)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new LSRecordPanel.13(this, paramInt2, paramDouble));
    }
    this.jdField_a_of_type_Int = ((int)paramDouble);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if (getVisibility() != 0) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.getGlobalVisibleRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPoint);
    this.jdField_d_of_type_AndroidViewView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = this.jdField_a_of_type_AndroidGraphicsRect.right;
    int j = this.jdField_a_of_type_AndroidGraphicsRect.left;
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    localRect.left -= this.jdField_a_of_type_AndroidGraphicsPoint.x;
    this.jdField_a_of_type_AndroidGraphicsRect.right = (i - j + this.jdField_a_of_type_AndroidGraphicsRect.left);
    i = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    j = this.jdField_a_of_type_AndroidGraphicsRect.top;
    localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    localRect.top -= this.jdField_a_of_type_AndroidGraphicsPoint.y;
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = (i - j + this.jdField_a_of_type_AndroidGraphicsRect.top);
    j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS agent:" + paramMotionEvent + "\n container: " + this.jdField_b_of_type_AndroidGraphicsRect + "\n bg: " + this.jdField_a_of_type_AndroidGraphicsRect);
    }
    boolean bool1;
    if (this.jdField_b_of_type_Int == 0)
    {
      if ((paramMotionEvent.getAction() != 0) || (!this.jdField_a_of_type_AndroidGraphicsRect.contains(j, k))) {
        break label738;
      }
      this.jdField_a_of_type_Int = 0;
      l();
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (this.jdField_b_of_type_Int != 5)
      {
        if (this.jdField_b_of_type_Int == 1)
        {
          if (paramMotionEvent.getAction() != 2) {
            a(false);
          }
          i = 1;
        }
        for (bool1 = true;; bool1 = false)
        {
          if (i == 0)
          {
            if (paramMotionEvent.getAction() == 3)
            {
              c(false);
              bool1 = bool2;
              break;
            }
            if (paramMotionEvent.getAction() == 1)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("LsRecord", 4, "LS ACTION_UP: " + this.jdField_b_of_type_Int);
              }
              if ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 2))
              {
                if (this.jdField_a_of_type_Int >= 500)
                {
                  c(true);
                  bool1 = bool2;
                  break;
                }
                this.jdField_b_of_type_JavaLangString = amtj.a(2131705527);
                c(false);
                bool1 = bool2;
                break;
              }
              bool1 = bool2;
              if (this.jdField_b_of_type_Int != 4) {
                break;
              }
              c(false);
              bool1 = bool2;
              break;
            }
            bool1 = bool2;
            if (paramMotionEvent.getAction() != 2) {
              break;
            }
            super.getGlobalVisibleRect(this.jdField_c_of_type_AndroidGraphicsRect);
            i = this.jdField_c_of_type_AndroidGraphicsRect.right;
            int m = this.jdField_c_of_type_AndroidGraphicsRect.left;
            paramMotionEvent = this.jdField_c_of_type_AndroidGraphicsRect;
            paramMotionEvent.left -= this.jdField_a_of_type_AndroidGraphicsPoint.x;
            this.jdField_c_of_type_AndroidGraphicsRect.right = (i - m + this.jdField_c_of_type_AndroidGraphicsRect.left);
            i = this.jdField_c_of_type_AndroidGraphicsRect.bottom;
            m = this.jdField_c_of_type_AndroidGraphicsRect.top;
            paramMotionEvent = this.jdField_c_of_type_AndroidGraphicsRect;
            paramMotionEvent.top -= this.jdField_a_of_type_AndroidGraphicsPoint.y;
            this.jdField_c_of_type_AndroidGraphicsRect.bottom = (i - m + this.jdField_c_of_type_AndroidGraphicsRect.top);
            if (this.jdField_c_of_type_AndroidGraphicsRect.contains(j, k))
            {
              if (this.jdField_b_of_type_Int == 4) {
                b(true);
              }
              bool1 = bool2;
              if (this.jdField_b_of_type_Int == 3) {
                break;
              }
              c(3);
              bool1 = bool2;
              if (this.jdField_a_of_type_Azbr == null) {
                break;
              }
              this.jdField_a_of_type_Azbr.a(true, false, this);
              bool1 = bool2;
              break;
            }
            if (this.jdField_b_of_type_Int == 3) {
              b(false);
            }
            bool1 = bool2;
            if (this.jdField_b_of_type_Int == 4) {
              break;
            }
            c(4);
            bool1 = bool2;
            if (this.jdField_a_of_type_Azbr == null) {
              break;
            }
            this.jdField_a_of_type_Azbr.a(false, true, this);
            bool1 = bool2;
            break;
          }
          break;
          i = 0;
        }
        label738:
        bool1 = false;
      }
    }
  }
  
  public void b()
  {
    a(false, true);
  }
  
  public void b(int paramInt)
  {
    paramInt /= 1180;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderAbnormal");
    }
    o();
    this.jdField_a_of_type_AndroidOsHandler.post(new LSRecordPanel.12(this));
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long >= 75L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      return true;
    }
    return false;
  }
  
  public void c() {}
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onInitFailed");
    }
    o();
    this.jdField_a_of_type_AndroidOsHandler.post(new LSRecordPanel.11(this));
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startRecordingMark");
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.6F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    if (this.jdField_a_of_type_Azbr != null) {
      this.jdField_a_of_type_Azbr.g();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.6F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    if (this.jdField_a_of_type_Azbr != null) {
      this.jdField_a_of_type_Azbr.h();
    }
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startRecordingBarAnimation");
    }
    this.jdField_d_of_type_AndroidViewAnimationAnimation = null;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(200L);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.startAnimation(localAlphaAnimation);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(200L);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(new azbl(this));
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.getVisibility() != 0) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopRecordingBarAnimation");
    }
    this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(200L);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.startAnimation(localAlphaAnimation);
    this.jdField_d_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setDuration(200L);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setAnimationListener(new azbm(this));
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
  }
  
  public void h()
  {
    if ((this.jdField_b_of_type_Int == 5) || (this.jdField_b_of_type_Int == 0)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startRecord");
    }
    if (this.jdField_a_of_type_Azbr != null) {
      this.jdField_a_of_type_Azbr.a(true, false, this);
    }
    this.jdField_c_of_type_AndroidViewView.setAnimation(null);
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    if (this.jdField_b_of_type_Int == 4)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-43434);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      c(3);
      localObject2 = a();
      if (FileUtils.hasSDCardAndWritable()) {
        break label148;
      }
      this.jdField_b_of_type_JavaLangString = getResources().getString(2131694120);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_JavaLangString == null) {
        break label257;
      }
      c(false);
      return;
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-15616011);
      break;
      label148:
      if (!QQRecorder.d()) {
        this.jdField_b_of_type_JavaLangString = getResources().getString(2131717958);
      } else if (!QQRecorder.a(((QQRecorder.RecorderParam)localObject2).c)) {
        this.jdField_b_of_type_JavaLangString = getResources().getString(2131693124);
      } else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
        this.jdField_b_of_type_JavaLangString = getResources().getString(2131694732);
      } else if (AudioHelper.b(1)) {
        this.jdField_b_of_type_JavaLangString = getResources().getString(2131697896);
      } else {
        this.jdField_b_of_type_JavaLangString = null;
      }
    }
    label257:
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(BaseApplicationImpl.sApplication);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a((QQRecorder.RecorderParam)localObject2);
    Object localObject1 = BuddyTransfileProcessor.getTransferFilePath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, 2, null, false);
    Object localObject2 = MessageForPtt.getLocalFilePath(((QQRecorder.RecorderParam)localObject2).c, (String)localObject1);
    if ((localObject1 != null) && (!((String)localObject1).equals(localObject2)))
    {
      new File((String)localObject1).deleteOnExit();
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "path: " + (String)localObject1);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
      bftt.a(BaseApplicationImpl.sApplication, true);
      if (QLog.isColorLevel()) {
        QLog.d("LsRecord", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setText("-:--");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a((String)localObject1, true);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 16711687: 
      c(true);
      return true;
    case 16711686: 
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      d(2131230744);
      bftt.a(BaseApplicationImpl.sApplication, false);
      return true;
    }
    a(true);
    return true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    i();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onLayout: " + paramBoolean);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS requestLayout");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordPanel
 * JD-Core Version:    0.7.0.1
 */