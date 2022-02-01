package com.tencent.mobileqq.guild.api.impl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.TabWidget;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.handler.PreDownloadMsg;
import com.tencent.mobileqq.ark.api.notify.GuildClientAuthNotify;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.fragment.QQGuildForwardGuildListFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.chatpie.GuildChatFragment;
import com.tencent.mobileqq.guild.chatpie.GuildChatPie;
import com.tencent.mobileqq.guild.chatpie.GuildLiveChannelChatFragment;
import com.tencent.mobileqq.guild.chatpie.GuildLiveChannelChatPie;
import com.tencent.mobileqq.guild.chatpie.helper.GuildAtHelper;
import com.tencent.mobileqq.guild.live.IQQGuildLiveAIOListener;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomActivity;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomActivity.Launcher;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.vas.GuildGiftManager;
import com.tencent.mobileqq.guild.vas.IGuildGiftManager;
import com.tencent.mobileqq.qqalbum.impl.PhotoTempUtilsImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.ProcessUtils;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class GuildTempApiImpl
  implements IGuildTempApi
{
  private static final int REMOVE_OBSERVER_TIME_OUT = 3000;
  public static final String TAG = "GuildTempApiImpl";
  private ViewTreeObserver.OnGlobalLayoutListener mLayoutListener;
  private AnimatorSet mTabHideAnim;
  private AnimatorSet mTabShowAnim;
  private boolean mTabVisible = true;
  
  private void checkTabState(TabWidget paramTabWidget, QQBlurView paramQQBlurView, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkTabState, mTabVisible = ");
    localStringBuilder.append(this.mTabVisible);
    localStringBuilder.append(", currentVisible = ");
    localStringBuilder.append(paramBoolean);
    QLog.d("GuildTempApiImpl", 2, localStringBuilder.toString());
    boolean bool = this.mTabVisible;
    if (bool == paramBoolean) {
      return;
    }
    if (bool)
    {
      paramTabWidget.setTranslationY(0.0F);
      paramQQBlurView.setTranslationY(0.0F);
      return;
    }
    paramTabWidget.setTranslationY(paramTabWidget.getHeight());
    paramQQBlurView.setTranslationY(paramTabWidget.getHeight());
  }
  
  private void dismissTabWidget(QBaseActivity paramQBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildTempApiImpl", 4, "dismissTabWidget");
    }
    setTabVisibleState(false);
    if (isDoingTabAnim()) {
      return;
    }
    paramQBaseActivity = (MainFragment)paramQBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    TabWidget localTabWidget = paramQBaseActivity.s.getTabWidget();
    if (localTabWidget.getTranslationY() == localTabWidget.getHeight())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildTempApiImpl", 4, "tab is invisible do not need anim");
      }
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localTabWidget, "translationY", new float[] { 0.0F, localTabWidget.getHeight() });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramQBaseActivity.K, "translationY", new float[] { 0.0F, localTabWidget.getHeight() });
    this.mTabHideAnim = new AnimatorSet();
    this.mTabHideAnim.setDuration(300L);
    this.mTabHideAnim.setInterpolator(new AccelerateInterpolator());
    this.mTabHideAnim.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    this.mTabHideAnim.start();
    resetTabHostDivider(paramQBaseActivity.s, 8);
    this.mTabHideAnim.addListener(new GuildTempApiImpl.2(this, localTabWidget, paramQBaseActivity));
  }
  
  private void hideTabWidgetInstantly(QBaseActivity paramQBaseActivity)
  {
    setTabVisibleState(false);
    if (isDoingTabAnim()) {
      return;
    }
    paramQBaseActivity = (MainFragment)paramQBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    TabWidget localTabWidget = paramQBaseActivity.s.getTabWidget();
    int i = localTabWidget.getHeight();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hideTabWidgetInstantly, height = ");
    ((StringBuilder)localObject).append(i);
    QLog.d("GuildTempApiImpl", 2, ((StringBuilder)localObject).toString());
    float f = i;
    localTabWidget.setTranslationY(f);
    paramQBaseActivity.K.setTranslationY(f);
    if (i == 0)
    {
      localObject = localTabWidget.getViewTreeObserver();
      if (localObject != null)
      {
        this.mLayoutListener = new GuildTempApiImpl.3(this, localTabWidget, paramQBaseActivity);
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this.mLayoutListener);
        ThreadManager.getUIHandler().postDelayed(new GuildTempApiImpl.4(this, localTabWidget), 3000L);
      }
    }
    resetTabHostDivider(paramQBaseActivity.s, 8);
  }
  
  private boolean isDoingTabAnim()
  {
    AnimatorSet localAnimatorSet = this.mTabShowAnim;
    if ((localAnimatorSet != null) && (localAnimatorSet.isRunning()))
    {
      if (QLog.isDebugVersion()) {
        QLog.d("GuildTempApiImpl", 4, "isDoingTabShowAnim");
      }
      return true;
    }
    localAnimatorSet = this.mTabHideAnim;
    if ((localAnimatorSet != null) && (localAnimatorSet.isRunning()))
    {
      if (QLog.isDebugVersion()) {
        QLog.d("GuildTempApiImpl", 4, "isDoingTabHidAnim");
      }
      return true;
    }
    return false;
  }
  
  private void resetTabHostDivider(QQTabHost paramQQTabHost, int paramInt)
  {
    if (paramQQTabHost == null) {
      return;
    }
    if (QQTheme.isNowSimpleUI())
    {
      if (QQTheme.isNowThemeSimpleNight()) {
        return;
      }
      paramQQTabHost = paramQQTabHost.findViewById(2131446748);
      if (paramQQTabHost != null) {
        paramQQTabHost.setVisibility(paramInt);
      }
    }
  }
  
  private void setTabVisibleState(boolean paramBoolean)
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      QLog.e("GuildTempApiImpl", 1, "check here. it must be called on main thread!!!");
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTabVisibleState ");
      localStringBuilder.append(paramBoolean);
      QLog.d("GuildTempApiImpl", 4, localStringBuilder.toString());
    }
    this.mTabVisible = paramBoolean;
  }
  
  private void showTabWidget(QBaseActivity paramQBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildTempApiImpl", 4, "showTabWidget");
    }
    setTabVisibleState(true);
    if (isDoingTabAnim()) {
      return;
    }
    paramQBaseActivity = (MainFragment)paramQBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    TabWidget localTabWidget = paramQBaseActivity.s.getTabWidget();
    if (localTabWidget.getTranslationY() == 0.0F)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildTempApiImpl", 4, "tab is visible do not need anim");
      }
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localTabWidget, "translationY", new float[] { localTabWidget.getTranslationY(), 0.0F }).setDuration(300L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramQBaseActivity.K, "translationY", new float[] { paramQBaseActivity.K.getHeight(), 0.0F });
    this.mTabShowAnim = new AnimatorSet();
    this.mTabShowAnim.setDuration(300L);
    this.mTabShowAnim.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    this.mTabShowAnim.setInterpolator(new AccelerateInterpolator());
    this.mTabShowAnim.start();
    resetTabHostDivider(paramQBaseActivity.s, 0);
    this.mTabShowAnim.addListener(new GuildTempApiImpl.1(this, localTabWidget, paramQBaseActivity));
  }
  
  private void showTabWidgetInstantly(QBaseActivity paramQBaseActivity)
  {
    setTabVisibleState(true);
    if (isDoingTabAnim()) {
      return;
    }
    paramQBaseActivity = (MainFragment)paramQBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    paramQBaseActivity.s.getTabWidget().setTranslationY(0.0F);
    paramQBaseActivity.K.setTranslationY(0.0F);
    resetTabHostDivider(paramQBaseActivity.s, 0);
  }
  
  public void adjustTab(QBaseActivity paramQBaseActivity)
  {
    MainFragment localMainFragment = (MainFragment)paramQBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (checkGuildMainFrameShow())
    {
      if (((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).isAioFullyOpen(localMainFragment))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuildTempApiImpl", 1, "adjustTab. dismissTabWidget");
        }
        dismissTabWidget(paramQBaseActivity);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuildTempApiImpl", 1, "adjustTab. showTabWidget");
      }
      showTabWidget(paramQBaseActivity);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildTempApiImpl", 1, "adjustTab. showTabWidgetInstantly");
    }
    if (!localMainFragment.isVisible()) {
      showTabWidgetInstantly(paramQBaseActivity);
    }
  }
  
  public void buildTeamShareForwardIntent(Intent paramIntent, QBaseActivity paramQBaseActivity)
  {
    paramIntent.putExtra("forward_type", 1002);
    paramIntent.putExtra("call_by_forward", true);
  }
  
  public boolean checkChatPie(Object paramObject)
  {
    return paramObject instanceof GuildLiveChannelChatPie;
  }
  
  public boolean checkGuildMainFrameShow()
  {
    Object localObject = QBaseActivity.sTopActivity;
    boolean bool3 = localObject instanceof SplashActivity;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      localObject = ((QBaseActivity)localObject).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      bool1 = bool2;
      if ((localObject instanceof MainFragment))
      {
        localObject = (MainFragment)localObject;
        bool1 = bool2;
        if (((MainFragment)localObject).a(((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass()) != null)
        {
          bool1 = bool2;
          if (((MainFragment)localObject).w() == FrameControllerUtil.k)
          {
            bool1 = bool2;
            if (SplashActivity.currentFragment == 1) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void configLiveChannelGiftBgDrawable(QBaseFragment paramQBaseFragment, @DrawableRes int paramInt1, @StringRes int paramInt2)
  {
    if (paramQBaseFragment == null) {
      return;
    }
    if ((paramQBaseFragment instanceof GuildLiveChannelChatFragment)) {
      ((GuildLiveChannelChatFragment)paramQBaseFragment).a(paramInt1, paramInt2);
    }
  }
  
  public QBaseFragment createGuildChatFragment(FragmentManager paramFragmentManager, int paramInt)
  {
    if (paramFragmentManager == null) {
      return null;
    }
    paramFragmentManager = paramFragmentManager.beginTransaction();
    GuildChatFragment localGuildChatFragment = GuildChatFragment.s();
    paramFragmentManager.add(paramInt, localGuildChatFragment, GuildChatFragment.class.getName());
    paramFragmentManager.commitAllowingStateLoss();
    return localGuildChatFragment;
  }
  
  public QBaseFragment createGuildLiveChannelChatFragment(FragmentActivity paramFragmentActivity, int paramInt)
  {
    if (paramFragmentActivity == null) {
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().beginTransaction();
    GuildLiveChannelChatFragment localGuildLiveChannelChatFragment = GuildLiveChannelChatFragment.s();
    paramFragmentActivity.add(paramInt, localGuildLiveChannelChatFragment, GuildLiveChannelChatFragment.class.getName());
    paramFragmentActivity.commitAllowingStateLoss();
    return localGuildLiveChannelChatFragment;
  }
  
  public Activity getCurrentTopActivity()
  {
    Object localObject1;
    if (2 == BaseApplicationImpl.sProcessId)
    {
      localObject1 = ProcessUtils.getTopActivity();
    }
    else
    {
      localObject2 = QBaseActivity.sTopActivity;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = BaseActivity.sTopActivity;
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((Activity)localObject1).isFinishing()) {
        localObject2 = null;
      }
    }
    return localObject2;
  }
  
  public Class getGuildForwardListFragmentClass()
  {
    return QQGuildForwardGuildListFragment.class;
  }
  
  public FrameFragment getMainFragment()
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity != null) && ((localQBaseActivity instanceof SplashActivity))) {
      return (FrameFragment)localQBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    }
    return null;
  }
  
  public FrameFragment getMainFragment(QBaseActivity paramQBaseActivity)
  {
    return (FrameFragment)paramQBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
  }
  
  public void hideGuildSoftInput(QBaseFragment paramQBaseFragment)
  {
    if ((paramQBaseFragment instanceof GuildChatFragment))
    {
      paramQBaseFragment = ((GuildChatFragment)paramQBaseFragment).k();
      if ((paramQBaseFragment instanceof GuildChatPie)) {
        paramQBaseFragment.as();
      }
    }
  }
  
  public boolean isChatFragmentShowing(Activity paramActivity)
  {
    return ((paramActivity instanceof SplashActivity)) && (SplashActivity.currentFragment == 2);
  }
  
  public Intent jumpToCropActivity(Activity paramActivity, Intent paramIntent)
  {
    return new PhotoTempUtilsImpl().toCropActivity(paramActivity, paramIntent);
  }
  
  public void notifyGuildHiddenChanged(QBaseFragment paramQBaseFragment)
  {
    if ((paramQBaseFragment instanceof GuildChatFragment)) {
      ((GuildChatFragment)paramQBaseFragment).a(true, GuildMainFrameConstants.z);
    }
  }
  
  public Frame obtainGuildMainFrame()
  {
    return obtainGuildMainFrame(QBaseActivity.sTopActivity);
  }
  
  public Frame obtainGuildMainFrame(Context paramContext)
  {
    if ((paramContext instanceof SplashActivity))
    {
      paramContext = ((SplashActivity)paramContext).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if ((paramContext instanceof MainFragment)) {
        return ((MainFragment)paramContext).a(((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass());
      }
      QLog.e("GuildTempApiImpl", 1, "obtainGuildMainFrame can't find MainFragment!");
    }
    return null;
  }
  
  public boolean onGuildChatFragmentBackEvent(QBaseFragment paramQBaseFragment)
  {
    if ((paramQBaseFragment instanceof GuildChatFragment)) {
      return ((GuildChatFragment)paramQBaseFragment).i();
    }
    return false;
  }
  
  public void onGuildChatNewIntent(QBaseFragment paramQBaseFragment, Intent paramIntent)
  {
    if ((paramQBaseFragment instanceof GuildChatFragment))
    {
      int j = GuildMainFrameConstants.A;
      Intent localIntent;
      if (paramIntent == null) {
        localIntent = paramQBaseFragment.getActivity().getIntent();
      } else {
        localIntent = paramIntent;
      }
      int i = j;
      if (localIntent != null)
      {
        i = j;
        if (localIntent.getBooleanExtra("forceStartActivity", false)) {
          i = GuildMainFrameConstants.B;
        }
      }
      GuildChatFragment localGuildChatFragment = (GuildChatFragment)paramQBaseFragment;
      boolean bool = localGuildChatFragment.a(localIntent);
      if (!bool) {
        localGuildChatFragment.a(true, i);
      }
      if (paramIntent != null) {
        paramQBaseFragment.getActivity().setIntent(paramIntent);
      }
      localGuildChatFragment.l();
      if ((localIntent != null) && (localIntent.getBooleanExtra("openGuildAioUpdateSession", false))) {
        ((GuildChatPie)localGuildChatFragment.c).d(localIntent);
      }
      if (!bool) {
        localGuildChatFragment.a(false, i);
      }
    }
  }
  
  public boolean onLiveChannelBackEvent(QBaseFragment paramQBaseFragment)
  {
    if (paramQBaseFragment == null) {
      return false;
    }
    if ((paramQBaseFragment instanceof GuildLiveChannelChatFragment)) {
      return ((GuildLiveChannelChatFragment)paramQBaseFragment).i();
    }
    return false;
  }
  
  public void onLiveChannelOnActivityResult(QBaseFragment paramQBaseFragment, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramQBaseFragment instanceof GuildLiveChannelChatFragment)) {
      paramQBaseFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onNewIntentInLiveChannel(QBaseFragment paramQBaseFragment)
  {
    if ((paramQBaseFragment instanceof GuildLiveChannelChatFragment)) {
      ((GuildLiveChannelChatFragment)paramQBaseFragment).l();
    }
  }
  
  public void removeGuildChatFragment(FragmentManager paramFragmentManager, QBaseFragment paramQBaseFragment)
  {
    if (paramFragmentManager != null)
    {
      if (paramQBaseFragment == null) {
        return;
      }
      paramFragmentManager.beginTransaction().remove(paramQBaseFragment).commitAllowingStateLoss();
    }
  }
  
  public void sendClientAuthSuccessToArk(String paramString1, String paramString2)
  {
    GuildClientAuthNotify.a(paramString1, paramString2);
  }
  
  public void setDrawerFrameEnable(boolean paramBoolean)
  {
    FrameHelperActivity.c(paramBoolean);
  }
  
  public void setGuildTabIntent(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramContext == null) {
        return;
      }
      int i = FrameControllerUtil.k;
      paramIntent.setClass(paramContext, SplashActivity.class);
      paramIntent.setFlags(335544320);
      paramIntent.putExtra("fragment_id", 1);
    }
  }
  
  public void setLiveChannelAIOListener(QBaseFragment paramQBaseFragment, IQQGuildLiveAIOListener paramIQQGuildLiveAIOListener)
  {
    if (paramQBaseFragment == null) {
      return;
    }
    if ((paramQBaseFragment instanceof GuildLiveChannelChatFragment)) {
      ((GuildLiveChannelChatFragment)paramQBaseFragment).a(paramIQQGuildLiveAIOListener);
    }
  }
  
  public void setSelectMember(String paramString1, String paramString2, Drawable paramDrawable)
  {
    GuildGiftManager.a().a(paramString1, paramString2, paramDrawable);
  }
  
  public void setTabWidgetVisible(QBaseActivity paramQBaseActivity, boolean paramBoolean)
  {
    if ((paramQBaseActivity instanceof SplashActivity))
    {
      if (paramBoolean) {
        showTabWidgetInstantly(paramQBaseActivity);
      } else {
        hideTabWidgetInstantly(paramQBaseActivity);
      }
      if (QLog.isColorLevel())
      {
        paramQBaseActivity = new StringBuilder();
        paramQBaseActivity.append("setTabWidgetVisible, visible = ");
        paramQBaseActivity.append(paramBoolean);
        QLog.d("GuildTempApiImpl", 2, paramQBaseActivity.toString());
      }
    }
  }
  
  public void showGuildChatPanel(QBaseFragment paramQBaseFragment, int paramInt)
  {
    if (!(paramQBaseFragment instanceof GuildLiveChannelChatFragment)) {
      return;
    }
    paramQBaseFragment = ((GuildLiveChannelChatFragment)paramQBaseFragment).k().bv();
    ((GuildAtHelper)paramQBaseFragment.a(144)).a();
    paramQBaseFragment.a(paramInt, true);
  }
  
  public void startAsyncStepLite(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return;
      }
      ((QQAppInterface)paramAppInterface).mAutomator.d();
    }
  }
  
  public void startDownloadPic(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean, AppInterface paramAppInterface)
  {
    PreDownloadMsg.a(paramArrayList, paramBoolean, paramAppInterface);
  }
  
  public void startGuildLiveActivity(Class<? extends QPublicBaseFragment> paramClass, Intent paramIntent)
  {
    QQGuildLiveRoomActivity.Launcher.a(paramIntent, QQGuildLiveRoomActivity.class, paramClass);
  }
  
  public void tabWidgetAnim(QBaseActivity paramQBaseActivity, boolean paramBoolean)
  {
    if (((paramQBaseActivity instanceof SplashActivity)) && (SplashActivity.currentFragment == 1))
    {
      if (paramBoolean)
      {
        showTabWidget(paramQBaseActivity);
        return;
      }
      dismissTabWidget(paramQBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildTempApiImpl
 * JD-Core Version:    0.7.0.1
 */