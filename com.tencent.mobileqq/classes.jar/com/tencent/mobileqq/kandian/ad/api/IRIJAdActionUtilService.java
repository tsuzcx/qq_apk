package com.tencent.mobileqq.kandian.ad.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJAdActionUtilService
  extends QRouteApi
{
  public abstract Integer JumpToGdtAdPageOrNotQqbPage(Context paramContext, AdvertisementInfo paramAdvertisementInfo, Object paramObject, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams);
  
  public abstract void addVideoCeilingParameter(Object paramObject, boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, Context paramContext);
  
  public abstract String appendUrlParameter(String paramString);
  
  public abstract boolean checkConditionForJumpToGdt(AdvertisementInfo paramAdvertisementInfo, int paramInt);
  
  public abstract void closeFloatWindow(Context paramContext);
  
  public abstract Integer doActionAndReport(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, Object paramObject, int paramInt, boolean paramBoolean1, boolean paramBoolean2, AdJumpParams paramAdJumpParams);
  
  public abstract void doActionAndReport(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, Object paramObject, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams);
  
  public abstract void doAppADJump(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract String getAdExtParam(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString);
  
  public abstract Object getAdInfoParams(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams);
  
  public abstract Object getAdInfoParams(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract Object getAdInfoParams(AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter);
  
  public abstract Integer gotoAdvVideoCellPage(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, Object paramObject, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams);
  
  public abstract boolean isUgcAd(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract Integer jumpToGdtAdPage(Context paramContext, AdvertisementInfo paramAdvertisementInfo, Object paramObject, int paramInt, boolean paramBoolean);
  
  public abstract Integer jumpToGdtAdPage(Context paramContext, AdvertisementInfo paramAdvertisementInfo, Object paramObject, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Integer jumpToGdtAdPage(Object paramObject, Context paramContext, AdvertisementInfo paramAdvertisementInfo);
  
  public abstract Object obtainGdtParams(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, Object paramObject);
  
  public abstract Object obtainGdtParams(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, Object paramObject, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter);
  
  public abstract Integer openAppFromGdtApi(Context paramContext, AdvertisementInfo paramAdvertisementInfo, Object paramObject, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams);
  
  public abstract boolean openAppFromGdtApi(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean);
  
  public abstract void processAdClickWithPos(ViewBase paramViewBase1, ViewBase paramViewBase2, Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, Object paramObject, int paramInt1, int paramInt2);
  
  public abstract void reportDataWhenClick(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt);
  
  public abstract void reportDataWhenClickForAdOrigin(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, Integer paramInteger);
  
  public abstract void setAdapterMonitorClickAdParams(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, Object paramObject, int paramInt);
  
  public abstract void setAdapterMonitorClickAdParams(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, Object paramObject, int paramInt, boolean paramBoolean);
  
  public abstract void showPopSheetDialog(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract void startImaxNativeLoadingPage(Activity paramActivity, String paramString, AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean startMiniApp(Context paramContext, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract void unRegisterReceiver();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService
 * JD-Core Version:    0.7.0.1
 */