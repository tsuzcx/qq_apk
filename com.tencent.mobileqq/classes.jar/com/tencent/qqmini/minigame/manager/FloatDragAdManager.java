package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.qqmini.minigame.widget.DragImageView;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import cooperation.vip.pb.TianShuAccess.AdItem;

public class FloatDragAdManager
{
  public static final String OPERATE_TYPE_ADD = "add";
  public static final String OPERATE_TYPE_REMOVE = "remove";
  private static final String TAG = "FloatDragAdManager";
  private Activity mContext;
  private DragImageView mDragImageView;
  private ViewGroup mGameContainer;
  private IMiniAppContext mMiniAppContext;
  
  public FloatDragAdManager(Activity paramActivity, IMiniAppContext paramIMiniAppContext, ViewGroup paramViewGroup)
  {
    this.mContext = paramActivity;
    this.mMiniAppContext = paramIMiniAppContext;
    this.mGameContainer = paramViewGroup;
  }
  
  private void addAdView(FloatDragAdInfo paramFloatDragAdInfo)
  {
    if (this.mDragImageView != null)
    {
      QMLog.e("FloatDragAdManager", "addAdView fail, already exist");
      return;
    }
    this.mDragImageView = new DragImageView(this.mContext);
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    Object localObject = localMiniAppProxy.getDrawable(this.mContext, paramFloatDragAdInfo.getPictureUrl(), 0, 0, null);
    this.mDragImageView.setImageDrawable((Drawable)localObject);
    this.mDragImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.mDragImageView.setScaleSize(DisplayUtil.dip2px(this.mContext, 65.0F), DisplayUtil.dip2px(this.mContext, 65.0F));
    localObject = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.mContext, 55.0F), DisplayUtil.dip2px(this.mContext, 55.0F));
    ((FrameLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(this.mContext, 14.5F);
    ((FrameLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(this.mContext, 14.5F);
    ((FrameLayout.LayoutParams)localObject).topMargin = DisplayUtil.dip2px(this.mContext, 92.5F);
    ((FrameLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.dip2px(this.mContext, 92.5F);
    ((FrameLayout.LayoutParams)localObject).gravity = 8388693;
    this.mGameContainer.addView(this.mDragImageView, (ViewGroup.LayoutParams)localObject);
    this.mDragImageView.setOnClickListener(new FloatDragAdManager.2(this, paramFloatDragAdInfo, localMiniAppProxy));
    performReport(paramFloatDragAdInfo.getAdItem(), paramFloatDragAdInfo.getType(), 101);
  }
  
  private void onAdClick(FloatDragAdInfo paramFloatDragAdInfo, MiniAppProxy paramMiniAppProxy)
  {
    if (paramFloatDragAdInfo.isSchema())
    {
      paramFloatDragAdInfo = paramFloatDragAdInfo.getJumpUrl();
      paramMiniAppProxy.openSchema(this.mContext, paramFloatDragAdInfo, 2115, null);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", paramFloatDragAdInfo.getJumpUrl());
    paramMiniAppProxy.startBrowserActivity(this.mContext, localIntent);
  }
  
  private void performReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new FloatDragAdManager.3(this, paramAdItem, paramString, paramInt));
  }
  
  public boolean removeDragAd()
  {
    ViewGroup localViewGroup = this.mGameContainer;
    if (localViewGroup == null) {
      return false;
    }
    localViewGroup.post(new FloatDragAdManager.4(this));
    return true;
  }
  
  public boolean showDragAd(FloatDragAdInfo paramFloatDragAdInfo)
  {
    if (this.mContext != null)
    {
      ViewGroup localViewGroup = this.mGameContainer;
      if (localViewGroup != null)
      {
        if (this.mDragImageView != null)
        {
          performReport(paramFloatDragAdInfo.getAdItem(), paramFloatDragAdInfo.getType(), 101);
          QMLog.e("FloatDragAdManager", "showDragAd fail, already exist");
          return false;
        }
        localViewGroup.post(new FloatDragAdManager.1(this, paramFloatDragAdInfo));
        return true;
      }
    }
    QMLog.e("FloatDragAdManager", "showDragAd fail");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.FloatDragAdManager
 * JD-Core Version:    0.7.0.1
 */