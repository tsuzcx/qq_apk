package com.tencent.mobileqq.minigame.jsapi.manager;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import biip;
import bmvj;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.minigame.data.FloatDragAdInfo;
import com.tencent.mobileqq.minigame.jsapi.widgets.DragImageView;
import com.tencent.mobileqq.minigame.utils.DpUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.concurrent.TimeUnit;

public class FloatDragAdManager
{
  private static final String TAG = "FloatDragAdManager";
  private Activity mContext;
  private DragImageView mDragImageView;
  private ViewGroup mGameContainer;
  
  public FloatDragAdManager(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.mContext = paramActivity;
    this.mGameContainer = paramViewGroup;
  }
  
  private void addAdView(FloatDragAdDataManager.DragAdListener paramDragAdListener, FloatDragAdInfo paramFloatDragAdInfo)
  {
    if (this.mDragImageView != null)
    {
      GameLog.getInstance().e("FloatDragAdManager", "addAdView fail, already exist");
      return;
    }
    this.mDragImageView = new DragImageView(this.mContext);
    Object localObject = ImageUtil.getDrawable(paramFloatDragAdInfo.getPictureUrl());
    this.mDragImageView.setImageDrawable((Drawable)localObject);
    this.mDragImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.mDragImageView.setScaleSize(DpUtil.dip2px(this.mContext, 65.0F), DpUtil.dip2px(this.mContext, 65.0F));
    localObject = new RelativeLayout.LayoutParams(DpUtil.dip2px(this.mContext, 55.0F), DpUtil.dip2px(this.mContext, 55.0F));
    ((RelativeLayout.LayoutParams)localObject).leftMargin = DpUtil.dip2px(this.mContext, 14.5F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = DpUtil.dip2px(this.mContext, 14.5F);
    ((RelativeLayout.LayoutParams)localObject).topMargin = DpUtil.dip2px(this.mContext, 92.5F);
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = DpUtil.dip2px(this.mContext, 92.5F);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.mGameContainer.addView(this.mDragImageView, (ViewGroup.LayoutParams)localObject);
    this.mDragImageView.setOnClickListener(new FloatDragAdManager.2(this, paramFloatDragAdInfo, paramDragAdListener));
    performReport(paramFloatDragAdInfo.getAdItem(), paramFloatDragAdInfo.getType(), 101);
  }
  
  private static bmvj newTianShuReportData(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    int i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    bmvj localbmvj = new bmvj();
    localbmvj.b = (String.valueOf(biip.a().a()) + '_' + i);
    localbmvj.d = paramInt;
    localbmvj.jdField_e_of_type_Int = 1;
    localbmvj.g = String.valueOf(paramAdItem.iAdId.get());
    localbmvj.n = paramString;
    localbmvj.jdField_a_of_type_Long = i;
    localbmvj.jdField_a_of_type_Int = 1;
    localbmvj.jdField_e_of_type_JavaLangString = "tianshu.81";
    localbmvj.i = "";
    return localbmvj;
  }
  
  private void onAdClick(FloatDragAdInfo paramFloatDragAdInfo)
  {
    if (paramFloatDragAdInfo.isSchema())
    {
      localObject = paramFloatDragAdInfo.getJumpUrl();
      if (MiniAppLauncher.isMiniAppScheme((String)localObject))
      {
        MiniAppLauncher.startMiniApp(this.mContext, (String)localObject, 2115, null);
        return;
      }
      localObject = new Intent(this.mContext, AppBrandLaunchUI.class);
      ((Intent)localObject).putExtra("from", "SchemeJsPlugin");
      ((Intent)localObject).putExtra("scheme", paramFloatDragAdInfo.getJumpUrl());
      this.mContext.startActivity((Intent)localObject);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("hide_more_button", true);
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    ((Intent)localObject).putExtra("url", paramFloatDragAdInfo.getJumpUrl());
    ((Intent)localObject).setComponent(new ComponentName(this.mContext, QQBrowserActivity.class));
    this.mContext.startActivity((Intent)localObject);
  }
  
  private void performReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    ThreadManagerV2.executeOnSubThread(new FloatDragAdManager.3(this, paramAdItem, paramString, paramInt));
  }
  
  public boolean removeDragAd()
  {
    if (this.mGameContainer == null) {
      return false;
    }
    this.mGameContainer.post(new FloatDragAdManager.4(this));
    return true;
  }
  
  public boolean showDragAd(FloatDragAdDataManager.DragAdListener paramDragAdListener, FloatDragAdInfo paramFloatDragAdInfo)
  {
    if ((this.mContext == null) || (this.mGameContainer == null))
    {
      GameLog.getInstance().e("FloatDragAdManager", "showDragAd fail");
      return false;
    }
    if (this.mDragImageView != null)
    {
      performReport(paramFloatDragAdInfo.getAdItem(), paramFloatDragAdInfo.getType(), 101);
      GameLog.getInstance().e("FloatDragAdManager", "showDragAd fail, already exist");
      return false;
    }
    this.mGameContainer.post(new FloatDragAdManager.1(this, paramDragAdListener, paramFloatDragAdInfo));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.FloatDragAdManager
 * JD-Core Version:    0.7.0.1
 */