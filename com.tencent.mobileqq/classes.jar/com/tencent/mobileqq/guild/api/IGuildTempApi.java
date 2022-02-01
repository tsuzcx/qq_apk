package com.tencent.mobileqq.guild.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.live.IQQGuildLiveAIOListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IGuildTempApi
  extends QRouteApi
{
  public abstract void adjustTab(QBaseActivity paramQBaseActivity);
  
  public abstract void buildTeamShareForwardIntent(Intent paramIntent, QBaseActivity paramQBaseActivity);
  
  public abstract boolean checkChatPie(Object paramObject);
  
  public abstract boolean checkGuildMainFrameShow();
  
  public abstract void configLiveChannelGiftBgDrawable(QBaseFragment paramQBaseFragment, @DrawableRes int paramInt1, @StringRes int paramInt2);
  
  public abstract QBaseFragment createGuildChatFragment(FragmentManager paramFragmentManager, int paramInt);
  
  public abstract QBaseFragment createGuildLiveChannelChatFragment(FragmentActivity paramFragmentActivity, int paramInt);
  
  public abstract Activity getCurrentTopActivity();
  
  public abstract Class getGuildForwardListFragmentClass();
  
  public abstract FrameFragment getMainFragment();
  
  public abstract FrameFragment getMainFragment(QBaseActivity paramQBaseActivity);
  
  public abstract void hideGuildSoftInput(QBaseFragment paramQBaseFragment);
  
  public abstract boolean isChatFragmentShowing(Activity paramActivity);
  
  public abstract Intent jumpToCropActivity(Activity paramActivity, Intent paramIntent);
  
  public abstract void notifyGuildHiddenChanged(QBaseFragment paramQBaseFragment);
  
  public abstract Frame obtainGuildMainFrame();
  
  public abstract Frame obtainGuildMainFrame(Context paramContext);
  
  public abstract boolean onGuildChatFragmentBackEvent(QBaseFragment paramQBaseFragment);
  
  public abstract void onGuildChatNewIntent(QBaseFragment paramQBaseFragment, Intent paramIntent);
  
  public abstract boolean onLiveChannelBackEvent(QBaseFragment paramQBaseFragment);
  
  public abstract void onLiveChannelOnActivityResult(QBaseFragment paramQBaseFragment, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onNewIntentInLiveChannel(QBaseFragment paramQBaseFragment);
  
  public abstract void removeGuildChatFragment(FragmentManager paramFragmentManager, QBaseFragment paramQBaseFragment);
  
  public abstract void sendClientAuthSuccessToArk(String paramString1, String paramString2);
  
  public abstract void setDrawerFrameEnable(boolean paramBoolean);
  
  public abstract void setGuildTabIntent(Context paramContext, Intent paramIntent);
  
  public abstract void setLiveChannelAIOListener(QBaseFragment paramQBaseFragment, IQQGuildLiveAIOListener paramIQQGuildLiveAIOListener);
  
  public abstract void setSelectMember(String paramString1, String paramString2, Drawable paramDrawable);
  
  public abstract void setTabWidgetVisible(QBaseActivity paramQBaseActivity, boolean paramBoolean);
  
  public abstract void showGuildChatPanel(QBaseFragment paramQBaseFragment, int paramInt);
  
  public abstract void startAsyncStepLite(AppInterface paramAppInterface);
  
  public abstract void startDownloadPic(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean, AppInterface paramAppInterface);
  
  public abstract void startGuildLiveActivity(Class<? extends QPublicBaseFragment> paramClass, Intent paramIntent);
  
  public abstract void tabWidgetAnim(QBaseActivity paramQBaseActivity, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildTempApi
 * JD-Core Version:    0.7.0.1
 */