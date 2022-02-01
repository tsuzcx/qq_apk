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
  long jdField_a_of_type_Long = 0L;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ListenTogetherTipBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new BaseListenTogetherPanel.1(this);
  ListenTogetherObserver jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherObserver = new BaseListenTogetherPanel.2(this);
  OnExistListenTogetherCallback jdField_a_of_type_ComTencentMobileqqListentogetherOnExistListenTogetherCallback;
  OnJoinListenTogetherCallback jdField_a_of_type_ComTencentMobileqqListentogetherOnJoinListenTogetherCallback;
  BaseListenTogetherPanel.ReportInfo jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo;
  BaseListenTogetherPanel.UiData jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData = new BaseListenTogetherPanel.UiData();
  private Runnable jdField_a_of_type_JavaLangRunnable = new BaseListenTogetherPanel.7(this);
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  boolean c;
  boolean d;
  protected boolean e = false;
  
  public BaseListenTogetherPanel(BaseChatPie paramBaseChatPie)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "oncreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c;
    AIOMusicSkin.a().a(a());
    AIOMusicSkin.a().a(this);
  }
  
  private ListenTogetherTipBar a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar = new ListenTogetherTipBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar;
  }
  
  private CharSequence a()
  {
    Object localObject2 = a(16);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_JavaLangString;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_JavaLangString;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!HardCodeUtil.a(2131693664).equalsIgnoreCase((String)localObject1))) {
      if (i != 0) {
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
      i = 1;
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
          i = 0;
          break;
          localObject1 = localObject2;
        } while (i == 0);
        localObject1 = localObject2;
      } while (TextUtils.isEmpty((CharSequence)localObject3));
    }
    if ((i != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject2 = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_JavaLangString, (byte)4);
      i = AIOUtils.b(11.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      ((Drawable)localObject2).setBounds(0, 0, i, i);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject2);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[avatar]  ");
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = new SpannableString(((StringBuilder)localObject3).toString());
      ((SpannableString)localObject1).setSpan(new BaseListenTogetherPanel.AlignCenterImageSpan((Drawable)localObject2, 1), 0, 9, 18);
      return localObject1;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    return localObject1;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onListenTogetherJoinedCountChange");
    }
    if (!a(paramInt, paramString1)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_JavaLangString = paramString2;
    a();
    a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    MusicPanelView localMusicPanelView = a();
    if (c())
    {
      if (localMusicPanelView == null) {
        return;
      }
      SweepGradientCircleProgress localSweepGradientCircleProgress = (SweepGradientCircleProgress)localMusicPanelView.findViewById(2131371647);
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
      {
        localMusicPanelView.setMusicProgressDefaultShow();
        return;
      }
      int k = (paramInt - 1) * 4;
      paramInt = com.tencent.mobileqq.listentogether.ListenTogetherConstants.a[k];
      int i = com.tencent.mobileqq.listentogether.ListenTogetherConstants.a[(k + 1)];
      int j = com.tencent.mobileqq.listentogether.ListenTogetherConstants.a[(k + 2)];
      k = com.tencent.mobileqq.listentogether.ListenTogetherConstants.a[(k + 3)];
      localSweepGradientCircleProgress.setBgAndProgressColor(100, paramInt, 100, i);
      localSweepGradientCircleProgress.setNeedSweepGradient(true, i, j);
      localSweepGradientCircleProgress.setmShadowColor(k);
      localSweepGradientCircleProgress.setShadowRadius(AIOUtils.b(1.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
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
  
  private boolean a(int paramInt, String paramString)
  {
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString.equals(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int == paramInt)) {
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
  
  private boolean a(ListenTogetherSession paramListenTogetherSession)
  {
    return (paramListenTogetherSession != null) && (paramListenTogetherSession.e.equals(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString)) && (paramListenTogetherSession.jdField_f_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int);
  }
  
  private void b(ListenTogetherSession paramListenTogetherSession)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "updateCurUiData");
    }
    MusicInfo localMusicInfo = null;
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null) {
      localMusicInfo = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.a();
    }
    Object localObject = paramListenTogetherSession.a();
    if ((localMusicInfo == null) || (localObject == null) || (localMusicInfo.jdField_a_of_type_JavaLangString != ((MusicInfo)localObject).jdField_a_of_type_JavaLangString))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData;
      ((BaseListenTogetherPanel.UiData)localObject).jdField_d_of_type_Int = 0;
      ((BaseListenTogetherPanel.UiData)localObject).jdField_a_of_type_Long = 0L;
      ((BaseListenTogetherPanel.UiData)localObject).jdField_b_of_type_Long = 0L;
      ((BaseListenTogetherPanel.UiData)localObject).jdField_d_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int = paramListenTogetherSession.h;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int = paramListenTogetherSession.i;
    localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData;
    ((BaseListenTogetherPanel.UiData)localObject).jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession = paramListenTogetherSession;
    ((BaseListenTogetherPanel.UiData)localObject).jdField_c_of_type_Boolean = (paramListenTogetherSession.jdField_a_of_type_Boolean ^ true);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_JavaLangString = paramListenTogetherSession.jdField_f_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_JavaLangString = paramListenTogetherSession.g;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Boolean = a();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Boolean = b();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.e = paramListenTogetherSession.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_f_of_type_Int = paramListenTogetherSession.jdField_d_of_type_Int;
    if (localMusicInfo != null)
    {
      if (localMusicInfo.jdField_a_of_type_Long >= 0L) {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Long = localMusicInfo.jdField_a_of_type_Long;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Long == 0L) && (localMusicInfo.d != 0L)) {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Long = (localMusicInfo.d * 1000L);
    }
    AIOMusicSkin.a().a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Boolean);
  }
  
  private void b(BaseListenTogetherPanel.UiData paramUiData)
  {
    MusicPanelView localMusicPanelView = a();
    if (c())
    {
      if (localMusicPanelView == null) {
        return;
      }
      localMusicPanelView.b(0, paramUiData.jdField_d_of_type_Int);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ListenTogetherUtils.a(paramUiData.jdField_a_of_type_Long));
      localStringBuilder.append(" / ");
      localStringBuilder.append(ListenTogetherUtils.a(paramUiData.jdField_b_of_type_Long));
      localMusicPanelView.a(0, localStringBuilder.toString());
    }
  }
  
  private void j()
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      QQToast.a((Context)localObject, 1, ((BaseActivity)localObject).getString(2131694647), 0).a();
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherOnJoinListenTogetherCallback = new BaseListenTogetherPanel.4(this, i, (String)localObject);
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, i, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqListentogetherOnJoinListenTogetherCallback);
  }
  
  private void m()
  {
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "destroyUI()");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null)
    {
      localPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a().a().a(null);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.a();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  private void o()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpWeb, isLaunchingWeb=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("BaseListenTogetherPanel", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    ListenTogetherUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString, 1);
  }
  
  private void p()
  {
    boolean bool = ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    Object localObject;
    if (!bool)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
      if (((localObject == null) || (!((PopupWindow)localObject).isShowing())) && (d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
        ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
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
    ListenTogetherTipBar localListenTogetherTipBar = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar;
    if (localListenTogetherTipBar != null) {
      return (MusicPanelView)localListenTogetherTipBar.a();
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_JavaLangString;
    if (str == null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693642);
    }
    if (TextUtils.isEmpty(str)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693658);
    }
    str = TogetherUtils.a(paramInt, str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693681));
    return localStringBuilder.toString();
  }
  
  public String a(boolean paramBoolean)
  {
    String str;
    if (HardCodeUtil.a(2131693664).equals(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_JavaLangString)) {
      str = a(16);
    } else {
      str = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_JavaLangString;
    }
    if (paramBoolean) {
      str = HardCodeUtil.a(2131693685);
    }
    return str;
  }
  
  public abstract void a();
  
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
    if (!a(paramInt, paramString)) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HardCodeUtil.a(2131701233), 1).a();
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onJoinListenTogetherFail");
    }
    if (!a(paramInt, paramString)) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HardCodeUtil.a(2131701232), 1).a();
    paramString = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData;
    paramString.jdField_c_of_type_Int = 1;
    a(paramString);
  }
  
  public void a(ListenTogetherSession paramListenTogetherSession)
  {
    if (!a(paramListenTogetherSession))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "onUIModuleNeedRefresh, checkSession is false");
      }
      return;
    }
    b(paramListenTogetherSession);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUIModuleNeedRefresh, uidata=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData);
      QLog.d("BaseListenTogetherPanel", 2, ((StringBuilder)localObject).toString());
    }
    AIOMusicSkin.a().a(paramListenTogetherSession.e, paramListenTogetherSession.jdField_f_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int == 3)
    {
      if (c())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString;
        if (d()) {
          paramListenTogetherSession = "clk_expand";
        } else {
          paramListenTogetherSession = "clk_fold";
        }
        String str = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int);
        localStringBuilder.append("");
        ReportController.b(null, "dc00899", (String)localObject, "", "music_tab", paramListenTogetherSession, 0, 0, str, "", localStringBuilder.toString(), "");
      }
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BD", 0, 0, "", "", "", "");
      f();
      return;
    }
    AIOMusicSkin.a().a(a());
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Boolean;
    if (d() != bool) {
      if (bool) {
        e();
      } else {
        f();
      }
    }
    a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData);
    a();
    if ((bool) && (!this.jdField_d_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      i();
    }
  }
  
  protected void a(BaseListenTogetherPanel.UiData paramUiData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("freshUI, isListenTogetherTime=");
      ((StringBuilder)localObject).append(c());
      ((StringBuilder)localObject).append(",isPanelShow=");
      ((StringBuilder)localObject).append(d());
      QLog.d("BaseListenTogetherPanel", 2, ((StringBuilder)localObject).toString());
    }
    MusicPanelView localMusicPanelView = a();
    if (c())
    {
      if (localMusicPanelView == null) {
        return;
      }
      localObject = paramUiData.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession;
      int k = paramUiData.jdField_b_of_type_Int;
      localObject = ((ListenTogetherSession)localObject).a();
      int m = paramUiData.jdField_c_of_type_Int;
      int i = 0;
      int j = 0;
      if (m == 2)
      {
        if (k == 4)
        {
          localMusicPanelView.a(8, k);
          localMusicPanelView.c(0);
          localMusicPanelView.a(0);
          localMusicPanelView.a("");
          localMusicPanelView.b(8);
          localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693663), 2131167038);
          localMusicPanelView.a(8, "");
          localMusicPanelView.b(0, 0);
          localMusicPanelView.b();
        }
        else
        {
          if (paramUiData.jdField_b_of_type_Boolean) {
            localMusicPanelView.a(0, k);
          } else {
            localMusicPanelView.a(8, k);
          }
          if (localObject != null)
          {
            localMusicPanelView.a(((MusicInfo)localObject).e);
            localMusicPanelView.a(ListenTogetherUtils.a((MusicInfo)localObject), 2131167036);
          }
          else
          {
            localMusicPanelView.a("");
            localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693663), 2131167038);
            localMusicPanelView.a(8, "");
          }
          localMusicPanelView.a(0);
          localMusicPanelView.c(0);
          localMusicPanelView.e(0);
          if (k == 2) {
            localMusicPanelView.b(0);
          } else {
            localMusicPanelView.b(8);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_Boolean)
          {
            localMusicPanelView.b(0, paramUiData.jdField_d_of_type_Int);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(ListenTogetherUtils.a(paramUiData.jdField_a_of_type_Long));
            ((StringBuilder)localObject).append(" / ");
            ((StringBuilder)localObject).append(ListenTogetherUtils.a(paramUiData.jdField_b_of_type_Long));
            localMusicPanelView.a(0, ((StringBuilder)localObject).toString());
            localMusicPanelView.b();
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_Boolean = false;
          }
          if (k == 1) {
            localMusicPanelView.a();
          } else if (k == 2) {
            localMusicPanelView.c();
          }
        }
        localMusicPanelView.d(8);
        if (k == 4) {
          localMusicPanelView.a(8, k);
        }
        localMusicPanelView.postInvalidate();
      }
      else if ((paramUiData.jdField_c_of_type_Int == 1) || (paramUiData.jdField_c_of_type_Int == 3))
      {
        localMusicPanelView.b(8);
        localMusicPanelView.c(8);
        localMusicPanelView.a(8, k);
        localMusicPanelView.d(0);
        localMusicPanelView.a(8);
        localMusicPanelView.b(0, 0);
        localMusicPanelView.b();
        if (k == 4)
        {
          localMusicPanelView.a("");
          localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693663), 2131167038);
          localMusicPanelView.a(8, "");
          i = j;
        }
        else if (localObject != null)
        {
          localMusicPanelView.a(((MusicInfo)localObject).e);
          localMusicPanelView.a(ListenTogetherUtils.a((MusicInfo)localObject), 2131167036);
          localObject = a();
          paramUiData = (BaseListenTogetherPanel.UiData)localObject;
          if (localObject == null) {
            paramUiData = "";
          }
          localMusicPanelView.a(0, paramUiData);
          paramUiData = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          i = j;
          if (paramUiData != null)
          {
            paramUiData.setCallback(this);
            i = 1;
          }
        }
        else
        {
          localMusicPanelView.a("");
          localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693663), 2131167038);
          localMusicPanelView.a(8, "");
          i = j;
        }
        if (k == 4) {
          localMusicPanelView.a(8, k);
        }
        localMusicPanelView.postInvalidate();
      }
      a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_f_of_type_Int, this.e);
      if (i == 0) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      }
    }
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if (c())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int != 2) {
        return;
      }
      MusicInfo localMusicInfo = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.a();
      if ((localMusicInfo != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localMusicInfo.jdField_a_of_type_JavaLangString)))
      {
        int i = paramInt1;
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_Int > 97)
          {
            i = paramInt1;
            if (paramInt1 < 0) {
              i = paramInt2;
            }
          }
          paramInt1 = (int)(i * 1.0F / paramInt2 * 100.0F);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Long = i;
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Long = paramInt2;
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_Int = paramInt1;
          b(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData);
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
  
  public abstract boolean a();
  
  public void b()
  {
    if (c())
    {
      if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L) {
        return;
      }
      boolean bool = d();
      if (bool) {
        f();
      } else {
        e();
      }
      a();
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bool, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
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
    if (!c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide mUIData is null or session is null");
      }
      return;
    }
    if (paramInt == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar;
      if ((localObject != null) && (localObject != paramTipsBarTask))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide tip not equal TogetherTip");
        }
        if (QLog.isColorLevel())
        {
          paramTipsBarTask = new StringBuilder();
          paramTipsBarTask.append("onOtherTipsHide expand=");
          paramTipsBarTask.append(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Boolean);
          QLog.d("BaseListenTogetherPanel", 2, paramTipsBarTask.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Boolean) {
          e();
        }
        a();
      }
    }
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onLyricModuleCloseByFloat");
    }
    if (!a(paramInt, paramString)) {
      return;
    }
    p();
  }
  
  public abstract boolean b();
  
  public void c()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    ListenTogetherUtils.a(localBaseChatPie, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int != 3) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onCreate()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a() == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar)
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
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onResume()");
    }
    this.jdField_a_of_type_Boolean = false;
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
    ChatFragment localChatFragment = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getChatFragment();
    AIOMusicSkin.a().a(localChatFragment, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int);
  }
  
  public boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "showTogetherTip");
    }
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null");
      }
      return false;
    }
    TipsBarTask localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
    if ((localTipsBarTask != null) && (localTipsBarTask != this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "currTip is other");
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar, new Object[0]);
    return true;
  }
  
  public void f()
  {
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onPause()");
    }
    TipsManager localTipsManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    if (localTipsManager != null) {
      localTipsManager.a(1003, new Object[0]);
    }
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null))
    {
      TipsBarTask localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
      if ((localTipsBarTask != null) && (localTipsBarTask == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseListenTogetherPanel", 2, "currTip is togetherTip");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "tipManager is null or together is null");
    }
    return false;
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onStop()");
    }
    this.jdField_a_of_type_Boolean = false;
    if (c())
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString;
      String str1;
      if (d()) {
        str1 = "clk_expand";
      } else {
        str1 = "clk_fold";
      }
      String str3 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int);
      localStringBuilder.append("");
      ReportController.b(null, "dc00899", str2, "", "music_tab", str1, 0, 0, str3, "", localStringBuilder.toString(), "");
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onDestroy()");
    }
    AIOMusicSkin.a().c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherObserver);
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).d(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    n();
  }
  
  protected void i() {}
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 7, 11, 12, 15, 14 };
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData);
  }
  
  public void k() {}
  
  public void l() {}
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onClick, id = ");
      ((StringBuilder)localObject1).append(k);
      QLog.i("BaseListenTogetherPanel", 2, ((StringBuilder)localObject1).toString());
    }
    if (!BaseChatItemLayout.jdField_a_of_type_Boolean)
    {
      int j = 0;
      int i = 1;
      Object localObject2;
      StringBuilder localStringBuilder;
      switch (k)
      {
      default: 
        break;
      case 2131377851: 
        if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int == 2) && (b())) {
          if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
            QQToast.a((Context)localObject1, 1, ((BaseActivity)localObject1).getString(2131694647), 0).a();
          }
          else
          {
            j = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int;
            if (j == 1)
            {
              ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int = 2;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString;
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_b_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int);
              localStringBuilder.append("");
              ReportController.b(null, "dc00899", (String)localObject1, "", "music_tab", "clk_pause", 0, 0, (String)localObject2, "", localStringBuilder.toString(), "");
            }
            else if (j == 2)
            {
              ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int = 1;
            }
            else
            {
              i = 0;
            }
            if (i != 0) {
              a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData);
            }
          }
        }
        break;
      case 2131374756: 
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          QQToast.a((Context)localObject1, 1, ((BaseActivity)localObject1).getString(2131694647), 0).a();
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherOnExistListenTogetherCallback = new BaseListenTogetherPanel.3(this);
          ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqListentogetherOnExistListenTogetherCallback);
        }
        break;
      case 2131371632: 
        o();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int);
        localStringBuilder.append("");
        ReportController.b(null, "dc00899", (String)localObject1, "", "music_tab", "clk_list", 0, 0, (String)localObject2, "", localStringBuilder.toString(), "");
        break;
      case 2131370162: 
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int == 2)
        {
          localObject1 = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int != 1)
          {
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int != 2) {}
          }
          else
          {
            i = 1;
          }
          if ((localObject1 != null) && (i != 0))
          {
            localObject2 = ((ListenTogetherSession)localObject1).a();
            ListenTogetherPlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (ListenTogetherSession)localObject1, (ISong)localObject2, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Boolean, null);
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_b_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int);
          localStringBuilder.append("");
          ReportController.b(null, "dc00899", (String)localObject1, "", "music_tab", "clk_detail", 0, 0, (String)localObject2, "", localStringBuilder.toString(), "");
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int == 3))
        {
          j();
        }
        break;
      case 2131369575: 
        j();
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
                h();
                return;
              }
              m();
              return;
            }
            g();
            return;
          }
          f();
          return;
        }
        c();
        return;
      }
      e();
      return;
    }
    d();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
 * JD-Core Version:    0.7.0.1
 */