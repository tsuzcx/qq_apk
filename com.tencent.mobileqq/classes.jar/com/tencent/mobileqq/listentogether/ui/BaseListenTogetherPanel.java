package com.tencent.mobileqq.listentogether.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.tips.ListenTogetherTipBar;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherObserver;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.listentogether.OnExistListenTogetherCallback;
import com.tencent.mobileqq.listentogether.OnJoinListenTogetherCallback;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.theme.ListenTogetherTheme.SkinDrawable.IVasSkinChangeCallback;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SweepGradientCircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

public abstract class BaseListenTogetherPanel
  implements Drawable.Callback, View.OnClickListener, ILifeCycleHelper, SkinDrawable.IVasSkinChangeCallback
{
  BaseChatPie a;
  BaseActivity b;
  ViewGroup c;
  FrameLayout d;
  BaseListenTogetherPanel.UiData e = new BaseListenTogetherPanel.UiData();
  PopupWindow f;
  long g = 0L;
  boolean h = false;
  boolean i = false;
  boolean j = true;
  boolean k = false;
  protected boolean l = false;
  BaseListenTogetherPanel.ReportInfo m;
  OnExistListenTogetherCallback n;
  OnJoinListenTogetherCallback o;
  AvatarObserver p = new BaseListenTogetherPanel.1(this);
  ListenTogetherObserver q = new BaseListenTogetherPanel.2(this);
  private ListenTogetherTipBar r;
  private Drawable s = null;
  private Runnable t = new BaseListenTogetherPanel.7(this);
  
  public BaseListenTogetherPanel(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "oncreate");
    }
    this.a = paramBaseChatPie;
    this.b = paramBaseChatPie.aX();
    this.c = this.a.aZ;
    AIOMusicSkin.a().a(b());
    AIOMusicSkin.a().a(this);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onListenTogetherJoinedCountChange");
    }
    if (!c(paramInt, paramString1)) {
      return;
    }
    this.e.l = paramString2;
    d();
    a(this.e);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    MusicPanelView localMusicPanelView = a();
    if (e())
    {
      if (localMusicPanelView == null) {
        return;
      }
      SweepGradientCircleProgress localSweepGradientCircleProgress = (SweepGradientCircleProgress)localMusicPanelView.findViewById(2131439067);
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
      {
        localMusicPanelView.setMusicProgressDefaultShow();
        return;
      }
      int i3 = (paramInt - 1) * 4;
      paramInt = com.tencent.mobileqq.listentogether.ListenTogetherConstants.b[i3];
      int i1 = com.tencent.mobileqq.listentogether.ListenTogetherConstants.b[(i3 + 1)];
      int i2 = com.tencent.mobileqq.listentogether.ListenTogetherConstants.b[(i3 + 2)];
      i3 = com.tencent.mobileqq.listentogether.ListenTogetherConstants.b[(i3 + 3)];
      localSweepGradientCircleProgress.setBgAndProgressColor(100, paramInt, 100, i1);
      localSweepGradientCircleProgress.setNeedSweepGradient(true, i1, i2);
      localSweepGradientCircleProgress.setmShadowColor(i3);
      localSweepGradientCircleProgress.setShadowRadius(AIOUtils.b(1.0F, this.b.getResources()));
    }
  }
  
  public static void a(View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2)
  {
    if ((paramView2 != null) && (Thread.currentThread() == Looper.getMainLooper().getThread()))
    {
      if ((VersionUtils.i()) && (!paramView2.isAttachedToWindow())) {
        return;
      }
      paramView2.post(new BaseListenTogetherPanel.5(paramView1, paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  public static void a(View paramView1, View paramView2)
  {
    if ((paramView2 != null) && (Thread.currentThread() == Looper.getMainLooper().getThread()))
    {
      if ((VersionUtils.i()) && (!paramView2.isAttachedToWindow())) {
        return;
      }
      paramView2.post(new BaseListenTogetherPanel.6(paramView1));
    }
  }
  
  private void b(BaseListenTogetherPanel.UiData paramUiData)
  {
    MusicPanelView localMusicPanelView = a();
    if (e())
    {
      if (localMusicPanelView == null) {
        return;
      }
      localMusicPanelView.b(0, paramUiData.i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ListenTogetherUtils.a(paramUiData.g));
      localStringBuilder.append(" / ");
      localStringBuilder.append(ListenTogetherUtils.a(paramUiData.h));
      localMusicPanelView.a(0, localStringBuilder.toString());
    }
  }
  
  private boolean b(ListenTogetherSession paramListenTogetherSession)
  {
    return (paramListenTogetherSession != null) && (paramListenTogetherSession.n.equals(this.e.b)) && (paramListenTogetherSession.m == this.e.a);
  }
  
  private void c(ListenTogetherSession paramListenTogetherSession)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "updateCurUiData");
    }
    MusicInfo localMusicInfo = null;
    if (this.e.q != null) {
      localMusicInfo = this.e.q.e();
    }
    Object localObject = paramListenTogetherSession.e();
    if ((localMusicInfo == null) || (localObject == null) || (localMusicInfo.a != ((MusicInfo)localObject).a))
    {
      localObject = this.e;
      ((BaseListenTogetherPanel.UiData)localObject).i = 0;
      ((BaseListenTogetherPanel.UiData)localObject).g = 0L;
      ((BaseListenTogetherPanel.UiData)localObject).h = 0L;
      ((BaseListenTogetherPanel.UiData)localObject).k = true;
    }
    this.e.c = paramListenTogetherSession.p;
    this.e.d = paramListenTogetherSession.q;
    localObject = this.e;
    ((BaseListenTogetherPanel.UiData)localObject).q = paramListenTogetherSession;
    ((BaseListenTogetherPanel.UiData)localObject).j = (paramListenTogetherSession.b ^ true);
    this.e.m = paramListenTogetherSession.r;
    this.e.n = paramListenTogetherSession.s;
    this.e.e = b();
    this.e.f = c();
    this.e.o = paramListenTogetherSession.j;
    this.e.p = paramListenTogetherSession.k;
    if (localMusicInfo != null)
    {
      if (localMusicInfo.h >= 0L) {
        this.e.g = localMusicInfo.h;
      }
      if ((this.e.h == 0L) && (localMusicInfo.k != 0L)) {
        this.e.k = true;
      }
      this.e.h = (localMusicInfo.k * 1000L);
    }
    AIOMusicSkin.a().a(this.e.e);
  }
  
  private boolean c(int paramInt, String paramString)
  {
    boolean bool;
    if ((this.e.b.equals(paramString)) && (this.e.a == paramInt)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkTypeAndUin, result=");
      localStringBuilder.append(bool);
      localStringBuilder.append(",type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",uin=");
      localStringBuilder.append(paramString);
      QLog.d("BaseListenTogetherPanel", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private CharSequence s()
  {
    Object localObject2 = a(16);
    Object localObject3 = this.e.n;
    Object localObject1 = this.e.l;
    int i1;
    if (this.e.a == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!HardCodeUtil.a(2131891239).equalsIgnoreCase((String)localObject1))) {
      if (i1 != 0) {
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject3);
          ((StringBuilder)localObject2).append("发起 | ");
          ((StringBuilder)localObject2).append((String)localObject1);
        }
      }
    }
    for (localObject1 = ((StringBuilder)localObject2).toString();; localObject1 = localObject2)
    {
      i1 = 1;
      break;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(" | ");
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject3).toString();
      do
      {
        do
        {
          i1 = 0;
          break;
          localObject1 = localObject2;
        } while (i1 == 0);
        localObject1 = localObject2;
      } while (TextUtils.isEmpty((CharSequence)localObject3));
    }
    if ((i1 != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject2 = FaceDrawable.getUserFaceDrawable(this.b.app, this.e.m, (byte)4);
      i1 = AIOUtils.b(11.0F, this.b.getResources());
      ((Drawable)localObject2).setBounds(0, 0, i1, i1);
      this.s = ((Drawable)localObject2);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[avatar]  ");
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = new SpannableString(((StringBuilder)localObject3).toString());
      ((SpannableString)localObject1).setSpan(new BaseListenTogetherPanel.AlignCenterImageSpan((Drawable)localObject2, 1), 0, 9, 18);
      return localObject1;
    }
    this.s = null;
    return localObject1;
  }
  
  private void t()
  {
    if (!NetworkUtil.isNetworkAvailable(this.b))
    {
      localObject = this.b;
      QQToast.makeText((Context)localObject, 1, ((BaseActivity)localObject).getString(2131892333), 0).show();
      return;
    }
    int i1 = this.e.a;
    Object localObject = this.e.b;
    this.o = new BaseListenTogetherPanel.4(this, i1, (String)localObject);
    ListenTogetherManager.a(this.a.d).a(this.b, i1, (String)localObject, this.o);
  }
  
  private ListenTogetherTipBar u()
  {
    if (this.r == null)
    {
      this.r = new ListenTogetherTipBar(this.a, this);
      if (this.a.J() != null) {
        this.a.J().b(this.r);
      }
    }
    return this.r;
  }
  
  private void v()
  {
    ListenTogetherManager.a(this.a.d, this.a.ah, this.a.hashCode());
  }
  
  private void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "destroyUI()");
    }
    if (this.a.aW() != null) {
      this.a.aW().removeCallbacks(this.t);
    }
    PopupWindow localPopupWindow = this.f;
    if (localPopupWindow != null)
    {
      localPopupWindow.dismiss();
      this.f = null;
    }
    this.a.bx().d().d().a(null);
    this.e.a();
    this.g = 0L;
    this.h = false;
    d();
  }
  
  private void x()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpWeb, isLaunchingWeb=");
      localStringBuilder.append(this.h);
      QLog.d("BaseListenTogetherPanel", 2, localStringBuilder.toString());
    }
    if (this.h) {
      return;
    }
    this.h = true;
    ListenTogetherUtils.b(this.a.d, this.b, this.e.a, this.e.b, 1);
  }
  
  private void y()
  {
    boolean bool = ListenTogetherUtils.a(this.b.app);
    Object localObject;
    if (!bool)
    {
      localObject = this.f;
      if (((localObject == null) || (!((PopupWindow)localObject).isShowing())) && (f()) && (this.a.aW() != null))
      {
        this.a.aW().postDelayed(this.t, 500L);
        ListenTogetherUtils.b(this.b.app);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showGuide, hasShow=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("BaseListenTogetherPanel", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public MusicPanelView a()
  {
    ListenTogetherTipBar localListenTogetherTipBar = this.r;
    if (localListenTogetherTipBar != null) {
      return (MusicPanelView)localListenTogetherTipBar.e();
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    String str = this.e.n;
    if (str == null) {
      return this.b.getResources().getString(2131891217);
    }
    if (TextUtils.isEmpty(str)) {
      return this.b.getResources().getString(2131891233);
    }
    str = TogetherUtils.a(paramInt, str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(this.b.getResources().getString(2131891256));
    return localStringBuilder.toString();
  }
  
  public String a(boolean paramBoolean)
  {
    String str;
    if (HardCodeUtil.a(2131891239).equals(this.e.l)) {
      str = a(16);
    } else {
      str = this.e.l;
    }
    if (paramBoolean) {
      str = HardCodeUtil.a(2131891260);
    }
    return str;
  }
  
  public void a(int paramInt, TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOtherTipsShow tip=");
      localStringBuilder.append(paramTipsBarTask);
      localStringBuilder.append(" type=");
      localStringBuilder.append(paramInt);
      QLog.d("BaseListenTogetherPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onExitListenTogetherFail");
    }
    if (!c(paramInt, paramString)) {
      return;
    }
    QQToast.makeText(this.b, HardCodeUtil.a(2131899243), 1).show();
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onJoinListenTogetherFail");
    }
    if (!c(paramInt, paramString)) {
      return;
    }
    QQToast.makeText(this.b, HardCodeUtil.a(2131899242), 1).show();
    paramString = this.e;
    paramString.d = 1;
    a(paramString);
  }
  
  public void a(ListenTogetherSession paramListenTogetherSession)
  {
    if (!b(paramListenTogetherSession))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "onUIModuleNeedRefresh, checkSession is false");
      }
      return;
    }
    c(paramListenTogetherSession);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUIModuleNeedRefresh, uidata=");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("BaseListenTogetherPanel", 2, ((StringBuilder)localObject).toString());
    }
    AIOMusicSkin.a().a(paramListenTogetherSession.n, paramListenTogetherSession.m);
    if (this.e.c == 3)
    {
      if (e())
      {
        localObject = this.m.a;
        if (f()) {
          paramListenTogetherSession = "clk_expand";
        } else {
          paramListenTogetherSession = "clk_fold";
        }
        String str = this.m.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.m.b);
        localStringBuilder.append("");
        ReportController.b(null, "dc00899", (String)localObject, "", "music_tab", paramListenTogetherSession, 0, 0, str, "", localStringBuilder.toString(), "");
      }
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BD", 0, 0, "", "", "", "");
      h();
      return;
    }
    AIOMusicSkin.a().a(b());
    boolean bool = this.e.j;
    if (f() != bool) {
      if (bool) {
        g();
      } else {
        h();
      }
    }
    a(this.e);
    d();
    if ((bool) && (!this.k) && (!this.j))
    {
      this.k = true;
      r();
    }
  }
  
  protected void a(BaseListenTogetherPanel.UiData paramUiData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("freshUI, isListenTogetherTime=");
      ((StringBuilder)localObject).append(e());
      ((StringBuilder)localObject).append(",isPanelShow=");
      ((StringBuilder)localObject).append(f());
      QLog.d("BaseListenTogetherPanel", 2, ((StringBuilder)localObject).toString());
    }
    MusicPanelView localMusicPanelView = a();
    if (e())
    {
      if (localMusicPanelView == null) {
        return;
      }
      localObject = paramUiData.q;
      int i3 = paramUiData.c;
      localObject = ((ListenTogetherSession)localObject).e();
      int i4 = paramUiData.d;
      int i1 = 0;
      int i2 = 0;
      if (i4 == 2)
      {
        if (i3 == 4)
        {
          localMusicPanelView.a(8, i3);
          localMusicPanelView.c(0);
          localMusicPanelView.a(0);
          localMusicPanelView.a("");
          localMusicPanelView.b(8);
          localMusicPanelView.a(this.b.getResources().getString(2131891238), 2131167974);
          localMusicPanelView.a(8, "");
          localMusicPanelView.b(0, 0);
          localMusicPanelView.b();
        }
        else
        {
          if (paramUiData.f) {
            localMusicPanelView.a(0, i3);
          } else {
            localMusicPanelView.a(8, i3);
          }
          if (localObject != null)
          {
            localMusicPanelView.a(((MusicInfo)localObject).g);
            localMusicPanelView.a(ListenTogetherUtils.a((MusicInfo)localObject), 2131167972);
          }
          else
          {
            localMusicPanelView.a("");
            localMusicPanelView.a(this.b.getResources().getString(2131891238), 2131167974);
            localMusicPanelView.a(8, "");
          }
          localMusicPanelView.a(0);
          localMusicPanelView.c(0);
          localMusicPanelView.e(0);
          if (i3 == 2) {
            localMusicPanelView.b(0);
          } else {
            localMusicPanelView.b(8);
          }
          if (this.e.k)
          {
            localMusicPanelView.b(0, paramUiData.i);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(ListenTogetherUtils.a(paramUiData.g));
            ((StringBuilder)localObject).append(" / ");
            ((StringBuilder)localObject).append(ListenTogetherUtils.a(paramUiData.h));
            localMusicPanelView.a(0, ((StringBuilder)localObject).toString());
            localMusicPanelView.b();
            this.e.k = false;
          }
          if (i3 == 1) {
            localMusicPanelView.a();
          } else if (i3 == 2) {
            localMusicPanelView.c();
          }
        }
        localMusicPanelView.d(8);
        if (i3 == 4) {
          localMusicPanelView.a(8, i3);
        }
        localMusicPanelView.postInvalidate();
      }
      else if ((paramUiData.d == 1) || (paramUiData.d == 3))
      {
        localMusicPanelView.b(8);
        localMusicPanelView.c(8);
        localMusicPanelView.a(8, i3);
        localMusicPanelView.d(0);
        localMusicPanelView.a(8);
        localMusicPanelView.b(0, 0);
        localMusicPanelView.b();
        if (i3 == 4)
        {
          localMusicPanelView.a("");
          localMusicPanelView.a(this.b.getResources().getString(2131891238), 2131167974);
          localMusicPanelView.a(8, "");
          i1 = i2;
        }
        else if (localObject != null)
        {
          localMusicPanelView.a(((MusicInfo)localObject).g);
          localMusicPanelView.a(ListenTogetherUtils.a((MusicInfo)localObject), 2131167972);
          localObject = s();
          paramUiData = (BaseListenTogetherPanel.UiData)localObject;
          if (localObject == null) {
            paramUiData = "";
          }
          localMusicPanelView.a(0, paramUiData);
          paramUiData = this.s;
          i1 = i2;
          if (paramUiData != null)
          {
            paramUiData.setCallback(this);
            i1 = 1;
          }
        }
        else
        {
          localMusicPanelView.a("");
          localMusicPanelView.a(this.b.getResources().getString(2131891238), 2131167974);
          localMusicPanelView.a(8, "");
          i1 = i2;
        }
        if (i3 == 4) {
          localMusicPanelView.a(8, i3);
        }
        localMusicPanelView.postInvalidate();
      }
      a(this.e.p, this.l);
      if (i1 == 0) {
        this.s = null;
      }
    }
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if (e())
    {
      if (this.e.d != 2) {
        return;
      }
      MusicInfo localMusicInfo = this.e.q.e();
      if ((localMusicInfo != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localMusicInfo.a)))
      {
        int i1 = paramInt1;
        try
        {
          if (this.e.i > 97)
          {
            i1 = paramInt1;
            if (paramInt1 < 0) {
              i1 = paramInt2;
            }
          }
          paramInt1 = (int)(i1 * 1.0F / paramInt2 * 100.0F);
          this.e.g = i1;
          this.e.h = paramInt2;
          this.e.i = paramInt1;
          b(this.e);
          return;
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.e("BaseListenTogetherPanel", 2, "onPlayProgressChange, exception:", paramString);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("BaseListenTogetherPanel", 2, "onPlayProgressChange, music id is not same");
      }
    }
  }
  
  public void b(int paramInt, TipsBarTask paramTipsBarTask)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onOtherTipsHide tip=");
      ((StringBuilder)localObject).append(paramTipsBarTask);
      ((StringBuilder)localObject).append(" type=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("BaseListenTogetherPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (!e())
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide mUIData is null or session is null");
      }
      return;
    }
    if (paramInt == 1)
    {
      localObject = this.r;
      if ((localObject != null) && (localObject != paramTipsBarTask))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide tip not equal TogetherTip");
        }
        if (QLog.isColorLevel())
        {
          paramTipsBarTask = new StringBuilder();
          paramTipsBarTask.append("onOtherTipsHide expand=");
          paramTipsBarTask.append(this.e.j);
          QLog.d("BaseListenTogetherPanel", 2, paramTipsBarTask.toString());
        }
        if (this.e.j) {
          g();
        }
        d();
      }
    }
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onLyricModuleCloseByFloat");
    }
    if (!c(paramInt, paramString)) {
      return;
    }
    y();
  }
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  public abstract void d();
  
  public boolean e()
  {
    return (this.e.c != 0) && (this.e.c != 3) && (this.e.q != null);
  }
  
  public boolean f()
  {
    if ((this.a.J() != null) && (this.r != null))
    {
      if (this.a.J().a() == this.r)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseListenTogetherPanel", 2, "curTip is togetherTip");
        }
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "tipManager is null or together is null");
    }
    return false;
  }
  
  public boolean g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "showTogetherTip");
    }
    u();
    if (this.a.J() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null");
      }
      return false;
    }
    TipsBarTask localTipsBarTask = this.a.J().a();
    if ((localTipsBarTask != null) && (localTipsBarTask != this.r))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "currTip is other");
      }
      return false;
    }
    this.a.J().a(this.r, new Object[0]);
    return true;
  }
  
  public boolean h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "dismissTogetherTip");
    }
    if ((this.r != null) && (this.a.J() != null))
    {
      TipsBarTask localTipsBarTask = this.a.J().a();
      if ((localTipsBarTask != null) && (localTipsBarTask == this.r))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseListenTogetherPanel", 2, "currTip is togetherTip");
        }
        this.a.J().c();
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "tipManager is null or together is null");
    }
    return false;
  }
  
  public void i()
  {
    if (e())
    {
      if (Math.abs(System.currentTimeMillis() - this.g) < 500L) {
        return;
      }
      boolean bool = f();
      if (bool) {
        h();
      } else {
        g();
      }
      d();
      ListenTogetherManager.a(this.a.d).a(bool, this.e.a, this.e.b);
      this.g = System.currentTimeMillis();
    }
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 7, 11, 12, 15, 14 };
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    a(this.e);
  }
  
  public void j()
  {
    BaseChatPie localBaseChatPie = this.a;
    ListenTogetherUtils.a(localBaseChatPie, localBaseChatPie.ah.a, this.a.ah.b);
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onCreate()");
    }
    this.a.d.addObserver(this.q);
    this.a.d.addObserver(this.p);
  }
  
  public void l()
  {
    this.i = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onResume()");
    }
    this.h = false;
    ListenTogetherManager.a(this.a.d).a(this.e.a, this.e.b, this.a.hashCode());
    ChatFragment localChatFragment = this.a.aX().getChatFragment();
    AIOMusicSkin.a().a(localChatFragment, String.valueOf(this.e.b), this.e.a);
  }
  
  public void m() {}
  
  public void n() {}
  
  public void o()
  {
    this.i = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onPause()");
    }
    TipsManager localTipsManager = this.a.J();
    if (localTipsManager != null) {
      localTipsManager.a(1003, new Object[0]);
    }
    ListenTogetherManager.a(this.a.d).b(this.e.a, this.e.b, this.a.hashCode());
  }
  
  public void onClick(View paramView)
  {
    int i3 = paramView.getId();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onClick, id = ");
      ((StringBuilder)localObject1).append(i3);
      QLog.i("BaseListenTogetherPanel", 2, ((StringBuilder)localObject1).toString());
    }
    if (!BaseChatItemLayout.ad)
    {
      int i2 = 0;
      int i1 = 1;
      Object localObject2;
      StringBuilder localStringBuilder;
      switch (i3)
      {
      default: 
        break;
      case 2131446327: 
        if ((this.e.d == 2) && (c())) {
          if (!NetworkUtil.isNetworkAvailable(this.b))
          {
            localObject1 = this.b;
            QQToast.makeText((Context)localObject1, 1, ((BaseActivity)localObject1).getString(2131892333), 0).show();
          }
          else
          {
            i2 = this.e.c;
            if (i2 == 1)
            {
              ListenTogetherManager.a(this.a.d).a(this.e.a, this.e.b);
              this.e.c = 2;
              localObject1 = this.m.a;
              localObject2 = this.m.c;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(this.m.b);
              localStringBuilder.append("");
              ReportController.b(null, "dc00899", (String)localObject1, "", "music_tab", "clk_pause", 0, 0, (String)localObject2, "", localStringBuilder.toString(), "");
            }
            else if (i2 == 2)
            {
              ListenTogetherManager.a(this.a.d).b(this.e.a, this.e.b);
              this.e.c = 1;
            }
            else
            {
              i1 = 0;
            }
            if (i1 != 0) {
              a(this.e);
            }
          }
        }
        break;
      case 2131442946: 
        if (!NetworkUtil.isNetworkAvailable(this.b))
        {
          localObject1 = this.b;
          QQToast.makeText((Context)localObject1, 1, ((BaseActivity)localObject1).getString(2131892333), 0).show();
        }
        else
        {
          this.n = new BaseListenTogetherPanel.3(this);
          ListenTogetherManager.a(this.a.d).a(this.e.a, this.e.b, this.n);
        }
        break;
      case 2131439051: 
        x();
        localObject1 = this.m.a;
        localObject2 = this.m.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.m.b);
        localStringBuilder.append("");
        ReportController.b(null, "dc00899", (String)localObject1, "", "music_tab", "clk_list", 0, 0, (String)localObject2, "", localStringBuilder.toString(), "");
        break;
      case 2131437326: 
        if (this.e.d == 2)
        {
          localObject1 = ListenTogetherManager.a(this.b.app).e(this.e.a, this.e.b);
          if (this.e.c != 1)
          {
            i1 = i2;
            if (this.e.c != 2) {}
          }
          else
          {
            i1 = 1;
          }
          if ((localObject1 != null) && (i1 != 0))
          {
            localObject2 = ((ListenTogetherSession)localObject1).e();
            ListenTogetherPlayFragment.a(this.b, (ListenTogetherSession)localObject1, (ISong)localObject2, this.e.e, null);
          }
          localObject1 = this.m.a;
          localObject2 = this.m.c;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.m.b);
          localStringBuilder.append("");
          ReportController.b(null, "dc00899", (String)localObject1, "", "music_tab", "clk_detail", 0, 0, (String)localObject2, "", localStringBuilder.toString(), "");
        }
        else if ((this.e.d == 1) || (this.e.d == 3))
        {
          t();
        }
        break;
      case 2131436679: 
        t();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 9)
        {
          if (paramInt != 11)
          {
            if (paramInt != 12)
            {
              if (paramInt != 14)
              {
                if (paramInt != 15) {
                  return;
                }
                q();
                return;
              }
              v();
              return;
            }
            p();
            return;
          }
          o();
          return;
        }
        j();
        return;
      }
      l();
      return;
    }
    k();
  }
  
  public void p()
  {
    this.i = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onStop()");
    }
    this.h = false;
    if (e())
    {
      String str2 = this.m.a;
      String str1;
      if (f()) {
        str1 = "clk_expand";
      } else {
        str1 = "clk_fold";
      }
      String str3 = this.m.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.m.b);
      localStringBuilder.append("");
      ReportController.b(null, "dc00899", str2, "", "music_tab", str1, 0, 0, str3, "", localStringBuilder.toString(), "");
    }
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onDestroy()");
    }
    AIOMusicSkin.a().f();
    this.a.d.removeObserver(this.q);
    ListenTogetherManager.a(this.a.d).d(this.e.a, this.e.b, this.a.hashCode());
    this.a.i().removeObserver(this.p);
    w();
  }
  
  protected void r() {}
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
 * JD-Core Version:    0.7.0.1
 */