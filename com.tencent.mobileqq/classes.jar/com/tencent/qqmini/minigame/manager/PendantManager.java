package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.minigame.R.color;
import com.tencent.qqmini.minigame.widget.DragImageView;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.ArrayList;
import java.util.Date;

public class PendantManager
{
  public static final Handler AUTO_WEBVIEW_DELAY_HANDLER = new Handler(Looper.getMainLooper());
  public static final String OPERATE_TYPE_ADD = "add";
  public static final String OPERATE_TYPE_REMOVE = "remove";
  public static final Handler REMOVE_HANDLER;
  public static final Handler SHOW_HANDLER = new Handler(Looper.getMainLooper());
  public static final Handler STATIC_PENDANT = new Handler(Looper.getMainLooper());
  private static final String TAG = "PendantManager";
  private static Drawable defaultDrawable = null;
  private Activity mContext;
  private DragImageView mDragImageView;
  private ViewGroup mGameContainer;
  private IMiniAppContext mMiniAppContext;
  
  static
  {
    REMOVE_HANDLER = new Handler(Looper.getMainLooper());
  }
  
  public PendantManager(Activity paramActivity, IMiniAppContext paramIMiniAppContext, ViewGroup paramViewGroup)
  {
    this.mContext = paramActivity;
    this.mMiniAppContext = paramIMiniAppContext;
    this.mGameContainer = paramViewGroup;
    defaultDrawable = this.mContext.getResources().getDrawable(R.color.transparent);
  }
  
  private void addAdView(PendantAdInfo paramPendantAdInfo)
  {
    if (this.mDragImageView != null)
    {
      QMLog.e("PendantManager", "addAdView fail, already exist");
      return;
    }
    QMLog.d("PendantManager", "addAdViewing");
    this.mDragImageView = new DragImageView(this.mContext, 1);
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    Object localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (PendantDataManager.entranceStrategy == 1)
    {
      localObject = localMiniAppProxy.getDrawable(this.mContext, paramPendantAdInfo.getPendantUrl(), 0, 0, defaultDrawable);
      this.mDragImageView.setImageDrawable((Drawable)localObject);
      STATIC_PENDANT.postDelayed(new PendantManager.2(this, localMiniAppProxy, paramPendantAdInfo), 2000L);
    }
    for (;;)
    {
      localObject = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.mContext, 100.0F), DisplayUtil.dip2px(this.mContext, 100.0F));
      ((FrameLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(this.mContext, 29.0F);
      ((FrameLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(this.mContext, 87.0F);
      ((FrameLayout.LayoutParams)localObject).topMargin = DisplayUtil.dip2px(this.mContext, 0.0F);
      ((FrameLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.dip2px(this.mContext, 92.5F);
      ((FrameLayout.LayoutParams)localObject).gravity = 8388661;
      this.mGameContainer.addView(this.mDragImageView, (ViewGroup.LayoutParams)localObject);
      bookFlashingIcon(paramPendantAdInfo, this.mDragImageView, this.mContext);
      this.mDragImageView.setOnClickListener(new PendantManager.3(this, paramPendantAdInfo, localMiniAppProxy));
      return;
      localObject = localMiniAppProxy.getDrawable(this.mContext, paramPendantAdInfo.getPictureUrl(), 0, 0, defaultDrawable);
      this.mDragImageView.setImageDrawable((Drawable)localObject);
      setExpoResult((Drawable)localObject);
      PendantDataManager.reportExposure("1");
    }
  }
  
  public static void bookFlashingIcon(PendantAdInfo paramPendantAdInfo, DragImageView paramDragImageView, Activity paramActivity)
  {
    Object localObject = PendantDataManager.handleTianshuDateParsing(new Date(((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getServerTime()), paramPendantAdInfo);
    if (localObject == null) {
      return;
    }
    Date localDate = (Date)((ArrayList)localObject).get(0);
    localObject = (Date)((ArrayList)localObject).get(3);
    SHOW_HANDLER.postDelayed(new PendantManager.5(paramActivity, paramPendantAdInfo, paramDragImageView), ((Date)localObject).getTime() - localDate.getTime());
  }
  
  private void onAdClick(PendantAdInfo paramPendantAdInfo, MiniAppProxy paramMiniAppProxy)
  {
    if (paramPendantAdInfo == null)
    {
      QMLog.e("PendantManager", "pendantAdInfo is null");
      return;
    }
    if (paramPendantAdInfo.isSchema())
    {
      paramPendantAdInfo = paramPendantAdInfo.getJumpUrl();
      paramMiniAppProxy.openSchema(this.mContext, paramPendantAdInfo, 1037, null);
      return;
    }
    paramMiniAppProxy = paramPendantAdInfo.getJumpUrl();
    startRedPacketBrowserActivity(this.mContext, paramMiniAppProxy, this.mDragImageView, paramPendantAdInfo, this.mMiniAppContext);
    QMLog.i("PendantManager", "click to start transparentBrowser");
  }
  
  private static void setExpoResult(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      PendantDataManager.RESULT = 1;
    }
  }
  
  public static void showNewPendantIcon(PendantAdInfo paramPendantAdInfo, DragImageView paramDragImageView, Activity paramActivity)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    Drawable localDrawable = localMiniAppProxy.getDrawable(paramActivity, paramPendantAdInfo.getPendantUrl(), 0, 0, defaultDrawable);
    paramDragImageView.setImageDrawable(localDrawable);
    setExpoResult(localDrawable);
    STATIC_PENDANT.postDelayed(new PendantManager.4(localMiniAppProxy, paramActivity, paramPendantAdInfo, paramDragImageView), 2000L);
  }
  
  public static void startRedPacketBrowserActivity(Activity paramActivity, String paramString, DragImageView paramDragImageView, PendantAdInfo paramPendantAdInfo, IMiniAppContext paramIMiniAppContext)
  {
    ActivityResultManager.g().addActivityResultListener(new PendantManager.6(paramDragImageView, paramPendantAdInfo, paramActivity, paramIMiniAppContext));
    paramDragImageView = new Bundle();
    if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2) {}
    for (boolean bool = true;; bool = false)
    {
      QMLog.d("PendantManager", "activity isLandscape= " + bool);
      paramDragImageView.putBoolean("mini_game_orientation", bool);
      paramPendantAdInfo = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (paramPendantAdInfo != null) {
        break;
      }
      QMLog.e("PendantManager", "channelProxy null");
      return;
    }
    if (!paramPendantAdInfo.startRedpacketTranslucentBrowserActivityForResult(paramActivity, paramString, paramDragImageView, 11007)) {
      PendantDataManager.RESULT = 1;
    }
    if (PendantDataManager.entranceStrategy == 1) {
      PendantDataManager.reportClick("2");
    }
    for (;;)
    {
      QMLog.i("PendantManager", "startTransparentBrowserActivity, url=" + paramString);
      return;
      if (PendantDataManager.entranceStrategy == 0) {
        PendantDataManager.reportClick("1");
      }
    }
  }
  
  public boolean removePendantAd()
  {
    if (this.mGameContainer == null) {
      return false;
    }
    this.mGameContainer.post(new PendantManager.7(this));
    return true;
  }
  
  public boolean showPendantAd(PendantAdInfo paramPendantAdInfo)
  {
    if ((this.mContext == null) || (this.mGameContainer == null))
    {
      QMLog.e("PendantManager", "showDragAd fail");
      return false;
    }
    if (this.mDragImageView != null)
    {
      QMLog.e("PendantManager", "showPendantAd fail, already exist");
      return false;
    }
    this.mGameContainer.post(new PendantManager.1(this, paramPendantAdInfo));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantManager
 * JD-Core Version:    0.7.0.1
 */