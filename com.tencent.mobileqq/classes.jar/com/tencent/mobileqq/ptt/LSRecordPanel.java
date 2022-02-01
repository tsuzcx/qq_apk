package com.tencent.mobileqq.ptt;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelCallback;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.PttUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;

public final class LSRecordPanel
  extends RelativeLayout
  implements Handler.Callback, AudioPanelCallback, IQQRecorder.OnQQRecorderListener, TouchProxyRelativeLayout.ITouchProxy
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  public Animation a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  private VolumeIndicateSquareView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IQQRecorder jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
  public LSRecordAnimations.TrackInfo a;
  private LSRecordPanel.IRecordPanelHandler jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$IRecordPanelHandler;
  private LSRecordTextView jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView;
  private TouchProxyRelativeLayout jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_b_of_type_AndroidViewView;
  public Animation b;
  public LSRecordAnimations.TrackInfo b;
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
  
  private RecordParams.RecorderParam a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
      return new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 8000, 0);
    }
    return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  private void a(RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS sendPtt");
    }
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(this.jdField_a_of_type_JavaLangString);
    MessageRecord localMessageRecord = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.c);
    if (localMessageRecord == null) {
      return;
    }
    ((MessageForPtt)localMessageRecord).c2cViaOffline = true;
    long l = localMessageRecord.uniseq;
    Bundle localBundle = new Bundle();
    localBundle.putInt("DiyTextId", localMessageRecord.vipBubbleDiyTextId);
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, l, false, this.jdField_a_of_type_Int, paramRecorderParam.c, true, 0, 3, true, localMessageRecord.vipSubBubbleId, localBundle);
    this.jdField_a_of_type_JavaLangString = null;
    PttUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 8, this.jdField_a_of_type_Int);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LS stopCheckingChick:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("LsRecord", 4, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
        int i = (int)(getResources().getDisplayMetrics().density * 4.0F);
        ((RelativeLayout.LayoutParams)localObject).height -= i;
        ((RelativeLayout.LayoutParams)localObject).width -= i;
        ((RelativeLayout.LayoutParams)localObject).rightMargin += i / 2;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      b(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$IRecordPanelHandler;
      if (localObject != null) {
        ((LSRecordPanel.IRecordPanelHandler)localObject).a(false, -1, HardCodeUtil.a(2131706471), true, false);
      }
    }
    else
    {
      l();
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LS close: ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(" done:");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("LsRecord", 4, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    if (this.jdField_b_of_type_Int != 0)
    {
      if ((!paramBoolean2) && (this.jdField_b_of_type_Int == 5)) {
        return;
      }
      this.jdField_c_of_type_Boolean = paramBoolean1;
      if (this.jdField_b_of_type_Int == 1)
      {
        a(false);
        return;
      }
      int i;
      if (paramBoolean2)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          b(5);
          this.jdField_c_of_type_AndroidViewView.clearAnimation();
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setAnimation(null);
          this.jdField_b_of_type_AndroidViewView.setVisibility(4);
          ((GradientDrawable)this.jdField_c_of_type_AndroidViewView.getBackground()).setColor(-15550475);
          this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
          f();
          m();
          this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo = null;
          this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
          localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
          i = (int)(getResources().getDisplayMetrics().density * 4.0F);
          ((RelativeLayout.LayoutParams)localObject).height -= i;
          ((RelativeLayout.LayoutParams)localObject).width -= i;
          ((RelativeLayout.LayoutParams)localObject).rightMargin += i / 2;
          this.jdField_b_of_type_Boolean = false;
          this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          d();
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo != null)
        {
          b(5);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setAnimation(null);
          this.jdField_b_of_type_AndroidViewView.setVisibility(4);
          localObject = (GradientDrawable)this.jdField_c_of_type_AndroidViewView.getBackground();
          i = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo.jdField_a_of_type_Int;
          ((GradientDrawable)localObject).setColor(i);
          float f = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo.jdField_a_of_type_Float;
          this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
          f();
          LSRecordAnimations.ChangeBgAndScaleAnimation localChangeBgAndScaleAnimation = new LSRecordAnimations.ChangeBgAndScaleAnimation(f, 1.0F, f, 1.0F, 1, 0.5F, 1, 0.5F, this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo);
          localChangeBgAndScaleAnimation.a((GradientDrawable)localObject, i, -15550475);
          localChangeBgAndScaleAnimation.setInterpolator(new LinearInterpolator());
          localChangeBgAndScaleAnimation.setDuration(500L);
          localChangeBgAndScaleAnimation.setFillAfter(true);
          localChangeBgAndScaleAnimation.setAnimationListener(new LSRecordPanel.6(this));
          this.jdField_b_of_type_AndroidViewAnimationAnimation = localChangeBgAndScaleAnimation;
          this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
          if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS startCloseAnimation");
          }
          d();
          return;
        }
        d(false);
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int) {
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LS setMode: ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d("LsRecord", 4, localStringBuilder.toString());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i = -43434;
    int j;
    if (paramBoolean) {
      j = -15550475;
    } else {
      j = -43434;
    }
    if (!paramBoolean) {
      i = -15550475;
    }
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo;
    if (localObject != null)
    {
      i = ((LSRecordAnimations.TrackInfo)localObject).jdField_a_of_type_Int;
    }
    else
    {
      this.jdField_b_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo = new LSRecordAnimations.TrackInfo();
      this.jdField_b_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo.jdField_a_of_type_Int = i;
    }
    localObject = new LSRecordAnimations.ChangeBgColorAnimation(this.jdField_b_of_type_AndroidViewView, i, j, this.jdField_b_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo);
    ((LSRecordAnimations.ChangeBgColorAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((LSRecordAnimations.ChangeBgColorAnimation)localObject).setDuration(300L);
    ((LSRecordAnimations.ChangeBgColorAnimation)localObject).setFillAfter(true);
    ((LSRecordAnimations.ChangeBgColorAnimation)localObject).setAnimationListener(new LSRecordPanel.5(this));
    this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startSideAnimation");
    }
  }
  
  private void c(int paramInt)
  {
    AudioUtil.b(paramInt, false);
  }
  
  private void c(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setText("-:--");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
    b(0);
    LSRecordPanel.IRecordPanelHandler localIRecordPanelHandler = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$IRecordPanelHandler;
    if (localIRecordPanelHandler != null) {
      localIRecordPanelHandler.a(this.jdField_c_of_type_Boolean, -1, this.jdField_b_of_type_JavaLangString, false, paramBoolean);
    }
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void h()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131380858);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131380857);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131380859);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      super.setContentDescription(null);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(null);
      this.jdField_b_of_type_AndroidViewView.setContentDescription(null);
      this.jdField_c_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131706470));
    }
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView = ((LSRecordTextView)super.findViewById(2131377746));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)super.findViewById(2131368765));
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setNotLayoutInSettingText(true);
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(4);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if ((int)(localDisplayMetrics.widthPixels / localDisplayMetrics.density) >= 320) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setCount(30);
    }
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setText("-:--");
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131376276);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(new LSRecordPanel.3(this));
    this.jdField_d_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131706467));
  }
  
  private void i() {}
  
  private void j() {}
  
  private void k()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startCheckingClick");
    }
    b(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 250L);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$IRecordPanelHandler;
    if (localObject != null) {
      ((LSRecordPanel.IRecordPanelHandler)localObject).a(false, false, this);
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    int i = (int)(getResources().getDisplayMetrics().density * 4.0F);
    ((RelativeLayout.LayoutParams)localObject).height += i;
    ((RelativeLayout.LayoutParams)localObject).width += i;
    ((RelativeLayout.LayoutParams)localObject).rightMargin -= i / 2;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void l()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS expand");
    }
    b(2);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo;
    float f1;
    if (localObject == null)
    {
      getGlobalVisibleRect(this.jdField_c_of_type_AndroidGraphicsRect);
      localObject = new Rect();
      this.jdField_c_of_type_AndroidViewView.getGlobalVisibleRect((Rect)localObject);
      f1 = ((Rect)localObject).width() * 0.5F;
      float f2 = ((Rect)localObject).left + f1 - this.jdField_c_of_type_AndroidGraphicsRect.left;
      float f3 = ((Rect)localObject).top + f1 - this.jdField_c_of_type_AndroidGraphicsRect.top;
      f3 = (float)Math.sqrt(f2 * f2 + f3 * f3);
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LS init dest bgTrack: ");
        ((StringBuilder)localObject).append(f2);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(f3);
        QLog.d("LsRecord", 4, ((StringBuilder)localObject).toString());
      }
      f1 = f3 / f1;
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo = new LSRecordAnimations.TrackInfo();
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo.jdField_a_of_type_Float = 1.0F;
    }
    else
    {
      f1 = ((LSRecordAnimations.TrackInfo)localObject).jdField_a_of_type_Float;
    }
    this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
    localObject = new LSRecordAnimations.ChangeBgAndScaleAnimation(1.0F, f1, 1.0F, f1, 1, 0.5F, 1, 0.5F, this.jdField_a_of_type_ComTencentMobileqqPttLSRecordAnimations$TrackInfo);
    ((LSRecordAnimations.ChangeBgAndScaleAnimation)localObject).setInterpolator(new LinearInterpolator());
    ((Animation)localObject).setDuration(450L);
    ((Animation)localObject).setFillAfter(true);
    ((Animation)localObject).setAnimationListener(new LSRecordPanel.4(this));
    this.jdField_a_of_type_AndroidViewAnimationAnimation = ((Animation)localObject);
    this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startExpandAnimation");
    }
    a();
  }
  
  private void m()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopRecord");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    boolean bool;
    if ((localObject != null) && (!((IQQRecorder)localObject).b()) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("stopRecord() is called,time is:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("LsRecord", 4, ((StringBuilder)localObject).toString());
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.c();
      c(2131230748);
      QQAudioUtils.a(BaseApplicationImpl.sApplication, false);
    }
    else
    {
      bool = false;
    }
    if ((!bool) || (!this.jdField_d_of_type_Boolean)) {
      d(true);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = null;
      PttUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8);
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startRecordingMark");
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = new AlphaAnimation(0.0F, 0.6F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(300L);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$IRecordPanelHandler;
    if (localObject != null) {
      ((LSRecordPanel.IRecordPanelHandler)localObject).i();
    }
  }
  
  public void a(int paramInt)
  {
    paramInt /= 1180;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, TouchProxyRelativeLayout paramTouchProxyRelativeLayout, LSRecordPanel.IRecordPanelHandler paramIRecordPanelHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout = paramTouchProxyRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$IRecordPanelHandler = paramIRecordPanelHandler;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS init");
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    localSessionInfo.jdField_a_of_type_Int = paramInt;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    localSessionInfo.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (getVisibility() != 0) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.getGlobalVisibleRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPoint);
    this.jdField_d_of_type_AndroidViewView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = this.jdField_a_of_type_AndroidGraphicsRect.right;
    int j = this.jdField_a_of_type_AndroidGraphicsRect.left;
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    ((Rect)localObject).left -= this.jdField_a_of_type_AndroidGraphicsPoint.x;
    localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    ((Rect)localObject).right = (((Rect)localObject).left + (i - j));
    i = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    j = this.jdField_a_of_type_AndroidGraphicsRect.top;
    localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    ((Rect)localObject).top -= this.jdField_a_of_type_AndroidGraphicsPoint.y;
    localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    ((Rect)localObject).bottom = (((Rect)localObject).top + (i - j));
    j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LS agent:");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("\n container: ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidGraphicsRect);
      ((StringBuilder)localObject).append("\n bg: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsRect);
      QLog.d("LsRecord", 4, ((StringBuilder)localObject).toString());
    }
    i = this.jdField_b_of_type_Int;
    boolean bool2 = true;
    if (i == 0)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_AndroidGraphicsRect.contains(j, k)))
      {
        this.jdField_a_of_type_Int = 0;
        k();
        return true;
      }
      return false;
    }
    if (this.jdField_b_of_type_Int == 5) {
      return true;
    }
    boolean bool1;
    if (this.jdField_b_of_type_Int == 1)
    {
      if (paramMotionEvent.getAction() != 2) {
        a(false);
      }
      i = 1;
      bool1 = true;
    }
    else
    {
      i = 0;
      bool1 = false;
    }
    if (i == 0)
    {
      if (paramMotionEvent.getAction() == 3)
      {
        c(false);
        return true;
      }
      if (paramMotionEvent.getAction() == 1)
      {
        if (QLog.isDevelopLevel())
        {
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("LS ACTION_UP: ");
          paramMotionEvent.append(this.jdField_b_of_type_Int);
          QLog.d("LsRecord", 4, paramMotionEvent.toString());
        }
        if ((this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 2))
        {
          bool1 = bool2;
          if (this.jdField_b_of_type_Int == 4)
          {
            c(false);
            return true;
          }
        }
        else
        {
          if (this.jdField_a_of_type_Int >= 500)
          {
            c(true);
            return true;
          }
          this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131706469);
          c(false);
          return true;
        }
      }
      else
      {
        bool1 = bool2;
        if (paramMotionEvent.getAction() == 2)
        {
          super.getGlobalVisibleRect(this.jdField_c_of_type_AndroidGraphicsRect);
          i = this.jdField_c_of_type_AndroidGraphicsRect.right;
          int m = this.jdField_c_of_type_AndroidGraphicsRect.left;
          paramMotionEvent = this.jdField_c_of_type_AndroidGraphicsRect;
          paramMotionEvent.left -= this.jdField_a_of_type_AndroidGraphicsPoint.x;
          paramMotionEvent = this.jdField_c_of_type_AndroidGraphicsRect;
          paramMotionEvent.right = (paramMotionEvent.left + (i - m));
          i = this.jdField_c_of_type_AndroidGraphicsRect.bottom;
          m = this.jdField_c_of_type_AndroidGraphicsRect.top;
          paramMotionEvent = this.jdField_c_of_type_AndroidGraphicsRect;
          paramMotionEvent.top -= this.jdField_a_of_type_AndroidGraphicsPoint.y;
          paramMotionEvent = this.jdField_c_of_type_AndroidGraphicsRect;
          paramMotionEvent.bottom = (paramMotionEvent.top + (i - m));
          if (this.jdField_c_of_type_AndroidGraphicsRect.contains(j, k))
          {
            if (this.jdField_b_of_type_Int == 4) {
              b(true);
            }
            bool1 = bool2;
            if (this.jdField_b_of_type_Int != 3)
            {
              b(3);
              paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$IRecordPanelHandler;
              bool1 = bool2;
              if (paramMotionEvent != null)
              {
                paramMotionEvent.a(true, false, this);
                return true;
              }
            }
          }
          else
          {
            if (this.jdField_b_of_type_Int == 3) {
              b(false);
            }
            bool1 = bool2;
            if (this.jdField_b_of_type_Int != 4)
            {
              b(4);
              paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$IRecordPanelHandler;
              bool1 = bool2;
              if (paramMotionEvent != null)
              {
                paramMotionEvent.a(false, true, this);
                return true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    a(false, true);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    } else if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < 75L) {
      return false;
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    return true;
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = new AlphaAnimation(0.6F, 0.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(300L);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$IRecordPanelHandler;
    if (localObject != null) {
      ((LSRecordPanel.IRecordPanelHandler)localObject).j();
    }
  }
  
  public void e()
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
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(new LSRecordPanel.1(this));
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
  }
  
  public void f()
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
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setAnimationListener(new LSRecordPanel.2(this));
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_Int != 5)
    {
      if (this.jdField_b_of_type_Int == 0) {
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS startRecord");
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel$IRecordPanelHandler;
      if (localObject1 != null) {
        ((LSRecordPanel.IRecordPanelHandler)localObject1).a(true, false, this);
      }
      this.jdField_c_of_type_AndroidViewView.setAnimation(null);
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      if (this.jdField_b_of_type_Int == 4) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-43434);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-15616011);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      b(3);
      Object localObject2 = a();
      if (!FileUtils.hasSDCardAndWritable()) {
        this.jdField_b_of_type_JavaLangString = getResources().getString(2131694487);
      } else if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkExternalStorageForRecord()) {
        this.jdField_b_of_type_JavaLangString = getResources().getString(2131718577);
      } else if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkIntenalStorageForRecord(((RecordParams.RecorderParam)localObject2).c)) {
        this.jdField_b_of_type_JavaLangString = getResources().getString(2131693398);
      } else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
        this.jdField_b_of_type_JavaLangString = getResources().getString(2131695163);
      } else if (AudioUtil.a(1)) {
        this.jdField_b_of_type_JavaLangString = getResources().getString(2131698521);
      } else {
        this.jdField_b_of_type_JavaLangString = null;
      }
      if (this.jdField_b_of_type_JavaLangString != null)
      {
        c(false);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder == null) {
        this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder(BaseApplicationImpl.sApplication);
      }
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a((RecordParams.RecorderParam)localObject2);
      localObject1 = TransFileUtil.getTransferFilePath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, 2, null, false);
      localObject2 = MessageForPtt.getLocalFilePath(((RecordParams.RecorderParam)localObject2).c, (String)localObject1);
      if ((localObject1 != null) && (!((String)localObject1).equals(localObject2)))
      {
        new File((String)localObject1).deleteOnExit();
        localObject1 = localObject2;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("path: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("QQRecorder", 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a(this);
      QQAudioUtils.a(BaseApplicationImpl.sApplication, true);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("QQRecorder start() is called,time is:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d("LsRecord", 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordTextView.setText("-:--");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a((String)localObject1, true);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 101)
    {
      switch (i)
      {
      default: 
        return true;
      case 16711687: 
        c(true);
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("QQRecorder stop() is called,time is:");
        paramMessage.append(System.currentTimeMillis());
        QLog.d("QQRecorder", 2, paramMessage.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.c();
      c(2131230748);
      QQAudioUtils.a(BaseApplicationImpl.sApplication, false);
      return true;
    }
    a(true);
    return true;
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onBeginReceiveData");
    }
    int i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000;
    int j = VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().getPrivilegeFlags(null);
    if ((j & 0x4) != 0) {}
    for (i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SVIP_MaxPtt");; i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "VIP_MaxPtt"))
    {
      i *= 1000;
      break;
      if ((j & 0x2) == 0) {
        break;
      }
    }
    i -= 200;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711687, i);
    return i + 200;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    h();
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onInitFailed");
    }
    n();
    this.jdField_a_of_type_AndroidOsHandler.post(new LSRecordPanel.11(this));
  }
  
  public void onInitSuccess()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onInitSuccess");
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LS onLayout: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("LsRecord", 4, localStringBuilder.toString());
    }
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderAbnormal");
    }
    n();
    this.jdField_a_of_type_AndroidOsHandler.post(new LSRecordPanel.12(this));
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderEnd");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int < 500)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131706468);
        n();
      }
      else
      {
        a(paramRecorderParam);
      }
    }
    else {
      n();
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new LSRecordPanel.9(this));
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderError");
    }
    n();
    this.jdField_a_of_type_AndroidOsHandler.post(new LSRecordPanel.10(this));
  }
  
  public void onRecorderNotReady(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderNotReady");
    }
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderPrepare");
    }
    paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramRecorderParam, paramRecorderParam.length);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler.post(new LSRecordPanel.7(this));
    if (this.jdField_a_of_type_JavaLangString != null) {
      c(2131230737);
    }
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramArrayOfByte, paramInt1);
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
  
  public int onRecorderStart()
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
  
  public void onRecorderVolumeStateChanged(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderVolumeStateChanged");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordPanel
 * JD-Core Version:    0.7.0.1
 */