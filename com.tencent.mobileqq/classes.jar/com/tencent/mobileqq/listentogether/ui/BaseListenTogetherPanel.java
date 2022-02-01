package com.tencent.mobileqq.listentogether.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
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
    Object localObject1 = a(16);
    String str = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_JavaLangString;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int == 1)
    {
      i = 1;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!HardCodeUtil.a(2131693711).equalsIgnoreCase((String)localObject2))) {
        break label188;
      }
      if ((i == 0) || (TextUtils.isEmpty(str))) {
        break label183;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i == 0) || (TextUtils.isEmpty((CharSequence)localObject1))) {
        break label266;
      }
      localObject2 = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_JavaLangString, (byte)4);
      i = AIOUtils.a(11.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      ((Drawable)localObject2).setBounds(0, 0, i, i);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject2);
      localObject1 = new SpannableString("[avatar]  " + (String)localObject1);
      ((SpannableString)localObject1).setSpan(new BaseListenTogetherPanel.AlignCenterImageSpan((Drawable)localObject2, 1), 0, "[avatar]  ".length() - 1, 18);
      return localObject1;
      i = 0;
      break;
      label183:
      i = 0;
      continue;
      label188:
      if (i != 0)
      {
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = str + "发起 | " + (String)localObject2;
          i = 1;
        }
        else
        {
          localObject1 = (String)localObject2 + " | " + (String)localObject1;
          i = 0;
        }
      }
      else
      {
        i = 0;
        localObject1 = localObject2;
      }
    }
    label266:
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
    if (paramBoolean) {}
    MusicPanelView localMusicPanelView;
    do
    {
      return;
      localMusicPanelView = a();
    } while ((!c()) || (localMusicPanelView == null));
    SweepGradientCircleProgress localSweepGradientCircleProgress = (SweepGradientCircleProgress)localMusicPanelView.findViewById(2131372048);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3))
    {
      int k = (paramInt - 1) * 4;
      paramInt = com.tencent.mobileqq.listentogether.ListenTogetherConstants.a[k];
      int i = com.tencent.mobileqq.listentogether.ListenTogetherConstants.a[(k + 1)];
      int j = com.tencent.mobileqq.listentogether.ListenTogetherConstants.a[(k + 2)];
      k = com.tencent.mobileqq.listentogether.ListenTogetherConstants.a[(k + 3)];
      localSweepGradientCircleProgress.setBgAndProgressColor(100, paramInt, 100, i);
      localSweepGradientCircleProgress.setNeedSweepGradient(true, i, j);
      localSweepGradientCircleProgress.setmShadowColor(k);
      localSweepGradientCircleProgress.setShadowRadius(AIOUtils.a(1.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
      return;
    }
    localMusicPanelView.setMusicProgressDefaultShow();
  }
  
  public static void a(View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2)
  {
    if ((paramView2 == null) || (Thread.currentThread() != Looper.getMainLooper().getThread()) || ((VersionUtils.i()) && (!paramView2.isAttachedToWindow()))) {
      return;
    }
    paramView2.post(new BaseListenTogetherPanel.5(paramView1, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static void a(View paramView1, View paramView2)
  {
    if ((paramView2 == null) || (Thread.currentThread() != Looper.getMainLooper().getThread()) || ((VersionUtils.i()) && (!paramView2.isAttachedToWindow()))) {
      return;
    }
    paramView2.post(new BaseListenTogetherPanel.6(paramView1));
  }
  
  private boolean a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int == paramInt) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "checkTypeAndUin, result=" + bool1 + ",type=" + paramInt + ",uin=" + paramString);
    }
    return bool1;
  }
  
  private boolean a(ListenTogetherSession paramListenTogetherSession)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramListenTogetherSession != null)
    {
      bool1 = bool2;
      if (paramListenTogetherSession.e.equals(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (paramListenTogetherSession.jdField_f_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(ListenTogetherSession paramListenTogetherSession)
  {
    boolean bool = false;
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
      this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int = paramListenTogetherSession.h;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int = paramListenTogetherSession.i;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession = paramListenTogetherSession;
    localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData;
    if (!paramListenTogetherSession.jdField_a_of_type_Boolean) {
      bool = true;
    }
    ((BaseListenTogetherPanel.UiData)localObject).jdField_c_of_type_Boolean = bool;
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
    if ((!c()) || (localMusicPanelView == null)) {
      return;
    }
    localMusicPanelView.b(0, paramUiData.jdField_d_of_type_Int);
    localMusicPanelView.a(0, ListenTogetherUtils.a(paramUiData.jdField_a_of_type_Long) + " / " + ListenTogetherUtils.a(paramUiData.jdField_b_of_type_Long));
  }
  
  private void j()
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694678), 0).a();
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherOnJoinListenTogetherCallback = new BaseListenTogetherPanel.4(this, i, str);
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, i, str, this.jdField_a_of_type_ComTencentMobileqqListentogetherOnJoinListenTogetherCallback);
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "destroyUI()");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.a();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "jumpWeb, isLaunchingWeb=" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    ListenTogetherUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString, 1);
  }
  
  private void o()
  {
    boolean bool = ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    if ((!bool) && ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) && (d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "showGuide, hasShow=" + bool);
    }
  }
  
  public MusicPanelView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar != null) {
      return (MusicPanelView)this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar.a();
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_JavaLangString;
    if (str == null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693689);
    }
    if (TextUtils.isEmpty(str)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693705);
    }
    str = TogetherUtils.a(paramInt, str);
    return str + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693728);
  }
  
  public String a(boolean paramBoolean)
  {
    if (HardCodeUtil.a(2131693711).equals(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_JavaLangString)) {}
    for (String str = a(16);; str = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_JavaLangString)
    {
      if (paramBoolean) {
        str = HardCodeUtil.a(2131693732);
      }
      return str;
    }
  }
  
  public abstract void a();
  
  public void a(int paramInt, TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsShow tip=" + paramTipsBarTask + " type=" + paramInt);
    }
    if (paramInt == 1) {}
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onExitListenTogetherFail");
    }
    if (!a(paramInt, paramString)) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HardCodeUtil.a(2131701092), 1).a();
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onJoinListenTogetherFail");
    }
    if (!a(paramInt, paramString)) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HardCodeUtil.a(2131701091), 1).a();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int = 1;
    a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData);
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
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onUIModuleNeedRefresh, uidata=" + this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData);
    }
    AIOMusicSkin.a().a(paramListenTogetherSession.e, paramListenTogetherSession.jdField_f_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int == 3)
    {
      String str;
      if (c())
      {
        str = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString;
        if (!d()) {
          break label210;
        }
      }
      label210:
      for (paramListenTogetherSession = "clk_expand";; paramListenTogetherSession = "clk_fold")
      {
        ReportController.b(null, "dc00899", str, "", "music_tab", paramListenTogetherSession, 0, 0, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int + "", "");
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5BD", 0, 0, "", "", "", "");
        f();
        return;
      }
    }
    AIOMusicSkin.a().a(a());
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Boolean;
    if (d() != bool)
    {
      if (!bool) {
        break label292;
      }
      e();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData);
      a();
      if ((!bool) || (this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
        break;
      }
      this.jdField_d_of_type_Boolean = true;
      i();
      return;
      label292:
      f();
    }
  }
  
  protected void a(BaseListenTogetherPanel.UiData paramUiData)
  {
    int j = 0;
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "freshUI, isListenTogetherTime=" + c() + ",isPanelShow=" + d());
    }
    MusicPanelView localMusicPanelView = a();
    if ((!c()) || (localMusicPanelView == null)) {
      return;
    }
    Object localObject = paramUiData.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession;
    int k = paramUiData.jdField_b_of_type_Int;
    localObject = ((ListenTogetherSession)localObject).a();
    if (paramUiData.jdField_c_of_type_Int == 2) {
      if (k == 4)
      {
        localMusicPanelView.a(8, k);
        localMusicPanelView.c(0);
        localMusicPanelView.a(0);
        localMusicPanelView.a("");
        localMusicPanelView.b(8);
        localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693710), 2131167015);
        localMusicPanelView.a(8, "");
        localMusicPanelView.b(0, 0);
        localMusicPanelView.b();
        label183:
        localMusicPanelView.d(8);
        if (k == 4) {
          localMusicPanelView.a(8, k);
        }
        localMusicPanelView.postInvalidate();
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_f_of_type_Int, this.e);
      if (i != 0) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      return;
      if (paramUiData.jdField_b_of_type_Boolean)
      {
        localMusicPanelView.a(0, k);
        label250:
        if (localObject == null) {
          break label409;
        }
        localMusicPanelView.a(((MusicInfo)localObject).e);
        localMusicPanelView.a(ListenTogetherUtils.a((MusicInfo)localObject), 2131167013);
        label278:
        localMusicPanelView.a(0);
        localMusicPanelView.c(0);
        localMusicPanelView.e(0);
        if (k != 2) {
          break label451;
        }
        localMusicPanelView.b(0);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_Boolean)
        {
          localMusicPanelView.b(0, paramUiData.jdField_d_of_type_Int);
          localMusicPanelView.a(0, ListenTogetherUtils.a(paramUiData.jdField_a_of_type_Long) + " / " + ListenTogetherUtils.a(paramUiData.jdField_b_of_type_Long));
          localMusicPanelView.b();
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_d_of_type_Boolean = false;
        }
        if (k != 1) {
          break label461;
        }
        localMusicPanelView.a();
        break;
        localMusicPanelView.a(8, k);
        break label250;
        label409:
        localMusicPanelView.a("");
        localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693710), 2131167015);
        localMusicPanelView.a(8, "");
        break label278;
        label451:
        localMusicPanelView.b(8);
      }
      label461:
      if (k != 2) {
        break label183;
      }
      localMusicPanelView.c();
      break label183;
      if ((paramUiData.jdField_c_of_type_Int == 1) || (paramUiData.jdField_c_of_type_Int == 3))
      {
        localMusicPanelView.b(8);
        localMusicPanelView.c(8);
        localMusicPanelView.a(8, k);
        localMusicPanelView.d(0);
        localMusicPanelView.a(8);
        localMusicPanelView.b(0, 0);
        localMusicPanelView.b();
        if (k != 4) {
          break label609;
        }
        localMusicPanelView.a("");
        localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693710), 2131167015);
        localMusicPanelView.a(8, "");
        i = j;
        if (k == 4) {
          localMusicPanelView.a(8, k);
        }
        localMusicPanelView.postInvalidate();
      }
    }
    label609:
    if (localObject != null)
    {
      localMusicPanelView.a(((MusicInfo)localObject).e);
      localMusicPanelView.a(ListenTogetherUtils.a((MusicInfo)localObject), 2131167013);
      localObject = a();
      paramUiData = (BaseListenTogetherPanel.UiData)localObject;
      if (localObject == null) {
        paramUiData = "";
      }
      localMusicPanelView.a(0, paramUiData);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label726;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this);
    }
    label726:
    for (i = 1;; i = 0)
    {
      break;
      localMusicPanelView.a("");
      localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693710), 2131167015);
      localMusicPanelView.a(8, "");
      i = j;
      break;
    }
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!c()) || (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int != 2)) {}
    do
    {
      do
      {
        return;
        MusicInfo localMusicInfo = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.a();
        if ((localMusicInfo == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localMusicInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
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
        catch (Exception paramString) {}
      } while (!QLog.isColorLevel());
      QLog.e("BaseListenTogetherPanel", 2, "onPlayProgressChange, exception:", paramString);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("BaseListenTogetherPanel", 2, "onPlayProgressChange, music id is not same");
  }
  
  public abstract boolean a();
  
  public void b()
  {
    if ((!c()) || (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L)) {
      return;
    }
    boolean bool = d();
    if (bool) {
      f();
    }
    for (;;)
    {
      a();
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bool, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      e();
    }
  }
  
  public void b(int paramInt, TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide tip=" + paramTipsBarTask + " type=" + paramInt);
    }
    if (!c()) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide mUIData is null or session is null");
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar == paramTipsBarTask)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide tip not equal TogetherTip");
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide expand=" + this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Boolean) {
      e();
    }
    a();
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onLyricModuleCloseByFloat");
    }
    if (!a(paramInt, paramString)) {
      return;
    }
    o();
  }
  
  public abstract boolean b();
  
  public void c()
  {
    ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a() != this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "curTip is togetherTip");
    }
    return true;
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onResume()");
    }
    this.jdField_a_of_type_Boolean = false;
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a()).getChatFragment();
    AIOMusicSkin.a().a(localChatFragment, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int);
  }
  
  public boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "showTogetherTip");
    }
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null");
      }
    }
    do
    {
      return false;
      TipsBarTask localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
      if ((localTipsBarTask == null) || (localTipsBarTask == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BaseListenTogetherPanel", 2, "currTip is other");
    return false;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null or together is null");
      }
    }
    TipsBarTask localTipsBarTask;
    do
    {
      return false;
      localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
    } while ((localTipsBarTask == null) || (localTipsBarTask != this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsListenTogetherTipBar));
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "currTip is togetherTip");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
    return true;
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onStop()");
    }
    this.jdField_a_of_type_Boolean = false;
    String str2;
    if (c())
    {
      str2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString;
      if (!d()) {
        break label108;
      }
    }
    label108:
    for (String str1 = "clk_expand";; str1 = "clk_fold")
    {
      ReportController.b(null, "dc00899", str2, "", "music_tab", str1, 0, 0, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int + "", "");
      return;
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
    m();
  }
  
  protected void i() {}
  
  public int[] interestedIn()
  {
    return new int[] { 4, 8, 6, 10, 11, 14 };
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData);
  }
  
  public void k() {}
  
  public void l() {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "onClick, id = " + j);
    }
    if (BaseChatItemLayout.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (j)
      {
      default: 
        break;
      case 2131369890: 
        j();
        break;
      case 2131378437: 
        if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int == 2) && (b()))
        {
          if (NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
            break label168;
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694678), 0).a();
        }
        break;
      }
    }
    label168:
    j = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int;
    if (j == 1)
    {
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int = 2;
      ReportController.b(null, "dc00899", this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString, "", "music_tab", "clk_pause", 0, 0, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int + "", "");
    }
    while (i != 0)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData);
      break;
      if (j == 2)
      {
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int = 1;
        continue;
        if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694678), 0).a();
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherOnExistListenTogetherCallback = new BaseListenTogetherPanel.3(this);
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqListentogetherOnExistListenTogetherCallback);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int == 2)
        {
          ListenTogetherSession localListenTogetherSession = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString);
          if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_b_of_type_Int == 2)) {}
          for (i = 1;; i = 0)
          {
            if ((localListenTogetherSession != null) && (i != 0))
            {
              MusicInfo localMusicInfo = localListenTogetherSession.a();
              ListenTogetherPlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localListenTogetherSession, localMusicInfo, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Boolean, null);
            }
            ReportController.b(null, "dc00899", this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString, "", "music_tab", "clk_detail", 0, 0, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int + "", "");
            break;
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_c_of_type_Int != 3)) {
          break;
        }
        j();
        break;
        n();
        ReportController.b(null, "dc00899", this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString, "", "music_tab", "clk_list", 0, 0, this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int + "", "");
        break;
      }
      i = 0;
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 9: 
    case 12: 
    case 13: 
    default: 
      return;
    case 4: 
      d();
      return;
    case 8: 
      c();
      return;
    case 6: 
      e();
      return;
    case 10: 
      f();
      return;
    case 11: 
      g();
      return;
    }
    h();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
 * JD-Core Version:    0.7.0.1
 */