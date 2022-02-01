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
  private Rect A = new Rect();
  private IQQRecorder B;
  private volatile boolean C;
  private String D;
  private boolean E = true;
  public Animation a;
  public LSRecordAnimations.TrackInfo b;
  public Animation c;
  public Animation d;
  public Animation e;
  public LSRecordAnimations.TrackInfo f;
  private QQAppInterface g;
  private LSRecordPanel.IRecordPanelHandler h;
  private SessionInfo i = new SessionInfo();
  private Handler j;
  private boolean k;
  private String l;
  private int m;
  private long n = 0L;
  private View o;
  private View p;
  private View q;
  private boolean r;
  private VolumeIndicateSquareView s;
  private LSRecordTextView t;
  private Rect u = new Rect();
  private View v;
  private TouchProxyRelativeLayout w;
  private Rect x = new Rect();
  private Point y = new Point();
  private volatile int z;
  
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
  
  private void a(RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS sendPtt");
    }
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(this.l);
    MessageRecord localMessageRecord = ChatActivityFacade.a(this.g, this.l, this.i, -2, paramRecorderParam.c);
    if (localMessageRecord == null) {
      return;
    }
    ((MessageForPtt)localMessageRecord).c2cViaOffline = true;
    long l1 = localMessageRecord.uniseq;
    Bundle localBundle = new Bundle();
    localBundle.putInt("DiyTextId", localMessageRecord.vipBubbleDiyTextId);
    ChatActivityFacade.a(this.g, this.i.a, this.i.b, this.l, l1, false, this.m, paramRecorderParam.c, true, 0, 3, true, localMessageRecord.vipSubBubbleId, localBundle);
    this.l = null;
    PttUtils.a(this.g, this.i.a, 8, this.m);
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
      if (this.r)
      {
        localObject = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
        int i1 = (int)(getResources().getDisplayMetrics().density * 4.0F);
        ((RelativeLayout.LayoutParams)localObject).height -= i1;
        ((RelativeLayout.LayoutParams)localObject).width -= i1;
        ((RelativeLayout.LayoutParams)localObject).rightMargin += i1 / 2;
        this.r = false;
        this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.j.removeMessages(101);
      setMode(0);
      localObject = this.h;
      if (localObject != null) {
        ((LSRecordPanel.IRecordPanelHandler)localObject).a(false, -1, HardCodeUtil.a(2131904330), true, false);
      }
    }
    else
    {
      n();
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LS close: ");
      ((StringBuilder)localObject).append(this.z);
      ((StringBuilder)localObject).append(" done:");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("LsRecord", 4, ((StringBuilder)localObject).toString());
    }
    this.j.removeMessages(101);
    if (this.z != 0)
    {
      if ((!paramBoolean2) && (this.z == 5)) {
        return;
      }
      this.C = paramBoolean1;
      if (this.z == 1)
      {
        a(false);
        return;
      }
      int i1;
      if (paramBoolean2)
      {
        if (this.r)
        {
          setMode(5);
          this.q.clearAnimation();
          this.q.setVisibility(0);
          this.p.setAnimation(null);
          this.p.setVisibility(4);
          ((GradientDrawable)this.q.getBackground()).setColor(-15550475);
          this.a = null;
          g();
          p();
          this.b = null;
          this.c = null;
          localObject = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
          i1 = (int)(getResources().getDisplayMetrics().density * 4.0F);
          ((RelativeLayout.LayoutParams)localObject).height -= i1;
          ((RelativeLayout.LayoutParams)localObject).width -= i1;
          ((RelativeLayout.LayoutParams)localObject).rightMargin += i1 / 2;
          this.r = false;
          this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
          e();
        }
      }
      else
      {
        if (this.b != null)
        {
          setMode(5);
          this.q.setVisibility(0);
          this.p.setAnimation(null);
          this.p.setVisibility(4);
          localObject = (GradientDrawable)this.q.getBackground();
          i1 = this.b.b;
          ((GradientDrawable)localObject).setColor(i1);
          float f1 = this.b.a;
          this.a = null;
          g();
          LSRecordAnimations.ChangeBgAndScaleAnimation localChangeBgAndScaleAnimation = new LSRecordAnimations.ChangeBgAndScaleAnimation(f1, 1.0F, f1, 1.0F, 1, 0.5F, 1, 0.5F, this.b);
          localChangeBgAndScaleAnimation.a((GradientDrawable)localObject, i1, -15550475);
          localChangeBgAndScaleAnimation.setInterpolator(new LinearInterpolator());
          localChangeBgAndScaleAnimation.setDuration(500L);
          localChangeBgAndScaleAnimation.setFillAfter(true);
          localChangeBgAndScaleAnimation.setAnimationListener(new LSRecordPanel.6(this));
          this.c = localChangeBgAndScaleAnimation;
          this.q.startAnimation(this.c);
          if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS startCloseAnimation");
          }
          e();
          return;
        }
        d(false);
      }
    }
  }
  
  private void b(int paramInt)
  {
    AudioUtil.b(paramInt, false);
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = -43434;
    int i2;
    if (paramBoolean) {
      i2 = -15550475;
    } else {
      i2 = -43434;
    }
    if (!paramBoolean) {
      i1 = -15550475;
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      i1 = ((LSRecordAnimations.TrackInfo)localObject).b;
    }
    else
    {
      this.f = new LSRecordAnimations.TrackInfo();
      this.f.b = i1;
    }
    localObject = new LSRecordAnimations.ChangeBgColorAnimation(this.p, i1, i2, this.f);
    ((LSRecordAnimations.ChangeBgColorAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((LSRecordAnimations.ChangeBgColorAnimation)localObject).setDuration(300L);
    ((LSRecordAnimations.ChangeBgColorAnimation)localObject).setFillAfter(true);
    ((LSRecordAnimations.ChangeBgColorAnimation)localObject).setAnimationListener(new LSRecordPanel.5(this));
    this.p.startAnimation((Animation)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startSideAnimation");
    }
  }
  
  private void c(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  private void d(boolean paramBoolean)
  {
    this.t.setText("-:--");
    this.s.a();
    setMode(0);
    LSRecordPanel.IRecordPanelHandler localIRecordPanelHandler = this.h;
    if (localIRecordPanelHandler != null) {
      localIRecordPanelHandler.a(this.C, -1, this.D, false, paramBoolean);
    }
    this.D = null;
    this.C = false;
  }
  
  private void j()
  {
    this.z = 0;
    this.o = super.findViewById(2131449839);
    this.o.setVisibility(4);
    this.p = super.findViewById(2131449838);
    this.p.setVisibility(4);
    this.q = super.findViewById(2131449840);
    if (AppSetting.e)
    {
      super.setContentDescription(null);
      this.o.setContentDescription(null);
      this.p.setContentDescription(null);
      this.q.setContentDescription(HardCodeUtil.a(2131904329));
    }
    this.t = ((LSRecordTextView)super.findViewById(2131446204));
    this.s = ((VolumeIndicateSquareView)super.findViewById(2131435683));
    this.t.setNotLayoutInSettingText(true);
    this.t.setVisibility(4);
    this.s.setVisibility(4);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if ((int)(localDisplayMetrics.widthPixels / localDisplayMetrics.density) >= 320) {
      this.s.setCount(30);
    }
    this.t.setText("-:--");
    this.v = super.findViewById(2131444485);
    this.v.setOnClickListener(new LSRecordPanel.3(this));
    this.v.setContentDescription(HardCodeUtil.a(2131904326));
  }
  
  private void k() {}
  
  private void l() {}
  
  private void m()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startCheckingClick");
    }
    setMode(1);
    this.j.sendEmptyMessageDelayed(101, 250L);
    Object localObject = this.h;
    if (localObject != null) {
      ((LSRecordPanel.IRecordPanelHandler)localObject).a(false, false, this);
    }
    localObject = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
    int i1 = (int)(getResources().getDisplayMetrics().density * 4.0F);
    ((RelativeLayout.LayoutParams)localObject).height += i1;
    ((RelativeLayout.LayoutParams)localObject).width += i1;
    ((RelativeLayout.LayoutParams)localObject).rightMargin -= i1 / 2;
    this.r = true;
    this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void n()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS expand");
    }
    setMode(2);
    Object localObject = this.b;
    float f1;
    if (localObject == null)
    {
      getGlobalVisibleRect(this.A);
      localObject = new Rect();
      this.q.getGlobalVisibleRect((Rect)localObject);
      f1 = ((Rect)localObject).width() * 0.5F;
      float f2 = ((Rect)localObject).left + f1 - this.A.left;
      float f3 = ((Rect)localObject).top + f1 - this.A.top;
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
      this.b = new LSRecordAnimations.TrackInfo();
      this.b.a = 1.0F;
    }
    else
    {
      f1 = ((LSRecordAnimations.TrackInfo)localObject).a;
    }
    this.c = null;
    localObject = new LSRecordAnimations.ChangeBgAndScaleAnimation(1.0F, f1, 1.0F, f1, 1, 0.5F, 1, 0.5F, this.b);
    ((LSRecordAnimations.ChangeBgAndScaleAnimation)localObject).setInterpolator(new LinearInterpolator());
    ((Animation)localObject).setDuration(450L);
    ((Animation)localObject).setFillAfter(true);
    ((Animation)localObject).setAnimationListener(new LSRecordPanel.4(this));
    this.a = ((Animation)localObject);
    this.q.startAnimation(this.a);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startExpandAnimation");
    }
    a();
  }
  
  private RecordParams.RecorderParam o()
  {
    if ((this.i.a != 0) && (this.i.a != 3000)) {
      return new RecordParams.RecorderParam(RecordParams.a, 8000, 0);
    }
    return RecordParams.b(this.g, false);
  }
  
  private void p()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopRecord");
    }
    Object localObject = this.B;
    boolean bool;
    if ((localObject != null) && (!((IQQRecorder)localObject).b()) && (!this.j.hasMessages(16711686)))
    {
      this.j.removeMessages(16711688);
      this.j.removeMessages(16711686);
      this.j.removeMessages(16711687);
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("stopRecord() is called,time is:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("LsRecord", 4, ((StringBuilder)localObject).toString());
      }
      bool = this.B.c();
      b(2131230816);
      QQAudioUtils.a(BaseApplicationImpl.sApplication, false);
    }
    else
    {
      bool = false;
    }
    if ((!bool) || (!this.E)) {
      d(true);
    }
  }
  
  private void q()
  {
    if (this.l != null)
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(this.l);
      this.l = null;
      PttUtils.a(this.g, 8);
    }
  }
  
  private void setMode(int paramInt)
  {
    if (paramInt == this.z) {
      return;
    }
    this.z = paramInt;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LS setMode: ");
      localStringBuilder.append(this.z);
      QLog.d("LsRecord", 4, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startRecordingMark");
    }
    this.o.setBackgroundColor(-16777216);
    this.o.setVisibility(0);
    Object localObject = new AlphaAnimation(0.0F, 0.6F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(300L);
    this.o.startAnimation((Animation)localObject);
    localObject = this.h;
    if (localObject != null) {
      ((LSRecordPanel.IRecordPanelHandler)localObject).j();
    }
  }
  
  public void a(int paramInt)
  {
    paramInt /= 1180;
    this.s.a(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, TouchProxyRelativeLayout paramTouchProxyRelativeLayout, LSRecordPanel.IRecordPanelHandler paramIRecordPanelHandler)
  {
    this.g = paramQQAppInterface;
    this.w = paramTouchProxyRelativeLayout;
    this.h = paramIRecordPanelHandler;
    this.j = new WeakReferenceHandler(Looper.getMainLooper(), this);
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS init");
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = this.i;
    localSessionInfo.a = paramInt;
    localSessionInfo.b = paramString1;
    localSessionInfo.c = paramString2;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (getVisibility() != 0) {
      return false;
    }
    this.w.getGlobalVisibleRect(this.x, this.y);
    this.v.getGlobalVisibleRect(this.u);
    int i1 = this.u.right;
    int i2 = this.u.left;
    Object localObject = this.u;
    ((Rect)localObject).left -= this.y.x;
    localObject = this.u;
    ((Rect)localObject).right = (((Rect)localObject).left + (i1 - i2));
    i1 = this.u.bottom;
    i2 = this.u.top;
    localObject = this.u;
    ((Rect)localObject).top -= this.y.y;
    localObject = this.u;
    ((Rect)localObject).bottom = (((Rect)localObject).top + (i1 - i2));
    i2 = (int)paramMotionEvent.getX();
    int i3 = (int)paramMotionEvent.getY();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LS agent:");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("\n container: ");
      ((StringBuilder)localObject).append(this.x);
      ((StringBuilder)localObject).append("\n bg: ");
      ((StringBuilder)localObject).append(this.u);
      QLog.d("LsRecord", 4, ((StringBuilder)localObject).toString());
    }
    i1 = this.z;
    boolean bool2 = true;
    if (i1 == 0)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.u.contains(i2, i3)))
      {
        this.m = 0;
        m();
        return true;
      }
      return false;
    }
    if (this.z == 5) {
      return true;
    }
    boolean bool1;
    if (this.z == 1)
    {
      if (paramMotionEvent.getAction() != 2) {
        a(false);
      }
      i1 = 1;
      bool1 = true;
    }
    else
    {
      i1 = 0;
      bool1 = false;
    }
    if (i1 == 0)
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
          paramMotionEvent.append(this.z);
          QLog.d("LsRecord", 4, paramMotionEvent.toString());
        }
        if ((this.z != 3) && (this.z != 2))
        {
          bool1 = bool2;
          if (this.z == 4)
          {
            c(false);
            return true;
          }
        }
        else
        {
          if (this.m >= 500)
          {
            c(true);
            return true;
          }
          this.D = HardCodeUtil.a(2131904328);
          c(false);
          return true;
        }
      }
      else
      {
        bool1 = bool2;
        if (paramMotionEvent.getAction() == 2)
        {
          super.getGlobalVisibleRect(this.A);
          i1 = this.A.right;
          int i4 = this.A.left;
          paramMotionEvent = this.A;
          paramMotionEvent.left -= this.y.x;
          paramMotionEvent = this.A;
          paramMotionEvent.right = (paramMotionEvent.left + (i1 - i4));
          i1 = this.A.bottom;
          i4 = this.A.top;
          paramMotionEvent = this.A;
          paramMotionEvent.top -= this.y.y;
          paramMotionEvent = this.A;
          paramMotionEvent.bottom = (paramMotionEvent.top + (i1 - i4));
          if (this.A.contains(i2, i3))
          {
            if (this.z == 4) {
              b(true);
            }
            bool1 = bool2;
            if (this.z != 3)
            {
              setMode(3);
              paramMotionEvent = this.h;
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
            if (this.z == 3) {
              b(false);
            }
            bool1 = bool2;
            if (this.z != 4)
            {
              setMode(4);
              paramMotionEvent = this.h;
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
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    a(false, true);
  }
  
  public void d() {}
  
  public void e()
  {
    this.o.setBackgroundColor(-16777216);
    this.o.setVisibility(0);
    Object localObject = new AlphaAnimation(0.6F, 0.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(300L);
    this.o.startAnimation((Animation)localObject);
    localObject = this.h;
    if (localObject != null) {
      ((LSRecordPanel.IRecordPanelHandler)localObject).k();
    }
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startRecordingBarAnimation");
    }
    this.e = null;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(200L);
    this.s.setVisibility(0);
    this.s.startAnimation(localAlphaAnimation);
    this.d = new AlphaAnimation(0.0F, 1.0F);
    this.d.setDuration(200L);
    this.d.setFillAfter(true);
    this.d.setAnimationListener(new LSRecordPanel.1(this));
    this.t.setVisibility(0);
    this.t.startAnimation(this.d);
  }
  
  public void g()
  {
    if (this.s.getVisibility() != 0) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopRecordingBarAnimation");
    }
    this.d = null;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(200L);
    this.s.startAnimation(localAlphaAnimation);
    this.e = new AlphaAnimation(1.0F, 0.0F);
    this.e.setDuration(200L);
    this.e.setFillAfter(true);
    this.e.setAnimationListener(new LSRecordPanel.2(this));
    this.t.startAnimation(this.e);
  }
  
  public boolean h()
  {
    if (this.n == 0L) {
      this.n = SystemClock.uptimeMillis();
    } else if (SystemClock.uptimeMillis() - this.n < 75L) {
      return false;
    }
    this.n = SystemClock.uptimeMillis();
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 101)
    {
      switch (i1)
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
      this.B.c();
      b(2131230816);
      QQAudioUtils.a(BaseApplicationImpl.sApplication, false);
      return true;
    }
    a(true);
    return true;
  }
  
  public void i()
  {
    if (this.z != 5)
    {
      if (this.z == 0) {
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS startRecord");
      }
      Object localObject1 = this.h;
      if (localObject1 != null) {
        ((LSRecordPanel.IRecordPanelHandler)localObject1).a(true, false, this);
      }
      this.q.setAnimation(null);
      this.q.setVisibility(4);
      if (this.z == 4) {
        this.p.setBackgroundColor(-43434);
      } else {
        this.p.setBackgroundColor(-15616011);
      }
      this.p.setVisibility(0);
      setMode(3);
      Object localObject2 = o();
      if (!FileUtils.hasSDCardAndWritable()) {
        this.D = getResources().getString(2131892169);
      } else if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkExternalStorageForRecord()) {
        this.D = getResources().getString(2131916078);
      } else if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkIntenalStorageForRecord(((RecordParams.RecorderParam)localObject2).c)) {
        this.D = getResources().getString(2131890947);
      } else if (this.g.isVideoChatting()) {
        this.D = getResources().getString(2131892896);
      } else if (AudioUtil.b(1)) {
        this.D = getResources().getString(2131896467);
      } else {
        this.D = null;
      }
      if (this.D != null)
      {
        c(false);
        return;
      }
      if (this.B == null) {
        this.B = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder(BaseApplicationImpl.sApplication);
      }
      this.B.a((RecordParams.RecorderParam)localObject2);
      localObject1 = TransFileUtil.getTransferFilePath(this.g.getCurrentAccountUin(), null, 2, null, false);
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
      this.B.a(this);
      QQAudioUtils.a(BaseApplicationImpl.sApplication, true);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("QQRecorder start() is called,time is:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d("LsRecord", 2, ((StringBuilder)localObject2).toString());
      }
      this.t.setText("-:--");
      this.s.a();
      this.B.a((String)localObject1, true);
    }
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onBeginReceiveData");
    }
    int i1 = PttItemBuilder.a(this.g, "Normal_MaxPtt") * 1000;
    int i2 = VasUtil.b(this.g).getVipStatus().getPrivilegeFlags(null);
    if ((i2 & 0x4) != 0) {}
    for (i1 = PttItemBuilder.a(this.g, "SVIP_MaxPtt");; i1 = PttItemBuilder.a(this.g, "VIP_MaxPtt"))
    {
      i1 *= 1000;
      break;
      if ((i2 & 0x2) == 0) {
        break;
      }
    }
    i1 -= 200;
    this.j.sendEmptyMessageDelayed(16711687, i1);
    return i1 + 200;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    j();
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onInitFailed");
    }
    q();
    this.j.post(new LSRecordPanel.11(this));
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
    q();
    this.j.post(new LSRecordPanel.12(this));
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderEnd");
    }
    this.j.removeMessages(1);
    if (this.C)
    {
      if (this.m < 500)
      {
        this.C = false;
        this.D = HardCodeUtil.a(2131904327);
        q();
      }
      else
      {
        a(paramRecorderParam);
      }
    }
    else {
      q();
    }
    this.j.post(new LSRecordPanel.9(this));
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderError");
    }
    q();
    this.j.post(new LSRecordPanel.10(this));
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
    paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.a);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramRecorderParam, paramRecorderParam.length);
    this.l = paramString;
    this.j.post(new LSRecordPanel.7(this));
    if (this.l != null) {
      b(2131230805);
    }
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramArrayOfByte, paramInt1);
    if (this.k)
    {
      this.k = false;
      this.j.removeMessages(1);
    }
    if ((h()) && (this.z != 5)) {
      this.j.post(new LSRecordPanel.13(this, paramInt2, paramDouble));
    }
    this.m = ((int)paramDouble);
  }
  
  public int onRecorderStart()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS onRecorderStart");
    }
    this.m = 0;
    this.j.post(new LSRecordPanel.8(this));
    this.j.removeMessages(1);
    this.j.sendEmptyMessageDelayed(1, 2000L);
    this.k = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordPanel
 * JD-Core Version:    0.7.0.1
 */