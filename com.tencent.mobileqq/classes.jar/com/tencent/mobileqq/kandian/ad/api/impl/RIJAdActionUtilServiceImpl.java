package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyGdtAdParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class RIJAdActionUtilServiceImpl
  implements IRIJAdActionUtilService
{
  public Integer JumpToGdtAdPageOrNotQqbPage(Context paramContext, AdvertisementInfo paramAdvertisementInfo, Object paramObject, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    return ReadinJoyActionUtil.b(paramContext, paramAdvertisementInfo, (IReadInJoyBaseAdapter)paramObject, paramInt, paramBoolean, paramAdJumpParams);
  }
  
  public void addVideoCeilingParameter(Object paramObject, boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    ReadinJoyActionUtil.a((GdtHandler.Params)paramObject, paramBoolean, paramAdvertisementInfo, paramContext);
  }
  
  public String appendUrlParameter(String paramString)
  {
    return ReadinJoyActionUtil.a(paramString);
  }
  
  public boolean checkConditionForJumpToGdt(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    return ReadinJoyActionUtil.a(paramAdvertisementInfo, paramInt);
  }
  
  public void closeFloatWindow(Context paramContext)
  {
    ReadinJoyActionUtil.a(paramContext);
  }
  
  public Integer doActionAndReport(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, Object paramObject, int paramInt, boolean paramBoolean1, boolean paramBoolean2, AdJumpParams paramAdJumpParams)
  {
    return ReadinJoyActionUtil.a(paramActivity, paramAbsBaseArticleInfo, (IReadInJoyBaseAdapter)paramObject, paramInt, paramBoolean1, paramBoolean2, paramAdJumpParams);
  }
  
  public void doActionAndReport(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, Object paramObject, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    ReadinJoyActionUtil.a(paramActivity, paramAbsBaseArticleInfo, (IReadInJoyBaseAdapter)paramObject, paramInt, paramBoolean, paramAdJumpParams);
  }
  
  public void doAppADJump(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ReadinJoyActionUtil.a(paramContext, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public String getAdExtParam(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    return ReadinJoyActionUtil.a(paramAbsBaseArticleInfo, paramString);
  }
  
  public Object getAdInfoParams(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    return ReadinJoyActionUtil.a(paramContext, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean, paramAdJumpParams);
  }
  
  public Object getAdInfoParams(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadinJoyActionUtil.a(paramAdvertisementInfo);
  }
  
  public Integer gotoAdvVideoCellPage(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, Object paramObject, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    return ReadinJoyActionUtil.a(paramActivity, paramAdvertisementInfo, (IReadInJoyBaseAdapter)paramObject, paramInt, paramBoolean, paramAdJumpParams);
  }
  
  public boolean isUgcAd(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadinJoyActionUtil.a(paramAbsBaseArticleInfo);
  }
  
  public Integer jumpToGdtAdPage(Context paramContext, AdvertisementInfo paramAdvertisementInfo, Object paramObject, int paramInt, boolean paramBoolean)
  {
    return ReadinJoyActionUtil.a(paramContext, paramAdvertisementInfo, (IReadInJoyBaseAdapter)paramObject, paramInt, paramBoolean);
  }
  
  public Integer jumpToGdtAdPage(Context paramContext, AdvertisementInfo paramAdvertisementInfo, Object paramObject, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return ReadinJoyActionUtil.a(paramContext, paramAdvertisementInfo, (IReadInJoyBaseAdapter)paramObject, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public Integer jumpToGdtAdPage(Object paramObject, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadinJoyActionUtil.a((GdtHandler.Params)paramObject, paramContext, paramAdvertisementInfo);
  }
  
  public Object obtainGdtParams(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, Object paramObject)
  {
    return ReadinJoyActionUtil.a(paramAdvertisementInfo, paramActivity, (ReadInJoyGdtAdParams)paramObject);
  }
  
  public Integer openAppFromGdtApi(Context paramContext, AdvertisementInfo paramAdvertisementInfo, Object paramObject, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    return ReadinJoyActionUtil.d(paramContext, paramAdvertisementInfo, (IReadInJoyBaseAdapter)paramObject, paramInt, paramBoolean, paramAdJumpParams);
  }
  
  public boolean openAppFromGdtApi(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean)
  {
    return ReadinJoyActionUtil.a(paramContext, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean);
  }
  
  public void processAdClickWithPos(ViewBase paramViewBase1, ViewBase paramViewBase2, Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, Object paramObject, int paramInt1, int paramInt2)
  {
    ReadinJoyActionUtil.a(paramViewBase1, paramViewBase2, paramActivity, paramAbsBaseArticleInfo, (IReadInJoyBaseAdapter)paramObject, paramInt1, paramInt2);
  }
  
  public void reportDataWhenClick(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    ReadinJoyActionUtil.a(paramContext, paramAbsBaseArticleInfo, paramInt);
  }
  
  public void reportDataWhenClickForAdOrigin(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, Integer paramInteger)
  {
    ReadinJoyActionUtil.a(paramContext, paramAbsBaseArticleInfo, paramInt1, paramInt2, paramInteger);
  }
  
  public void setAdapterMonitorClickAdParams(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, Object paramObject, int paramInt)
  {
    ReadinJoyActionUtil.a(paramContext, paramAbsBaseArticleInfo, (IReadInJoyBaseAdapter)paramObject, paramInt);
  }
  
  public void setAdapterMonitorClickAdParams(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, Object paramObject, int paramInt, boolean paramBoolean)
  {
    ReadinJoyActionUtil.a(paramContext, paramAbsBaseArticleInfo, (IReadInJoyBaseAdapter)paramObject, paramInt, paramBoolean);
  }
  
  public void showPopSheetDialog(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    ReadinJoyActionUtil.a(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void startImaxNativeLoadingPage(Activity paramActivity, String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    ReadinJoyActionUtil.a(paramActivity, paramString, paramAdvertisementInfo);
  }
  
  public boolean startMiniApp(Context paramContext, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadinJoyActionUtil.a(paramContext, paramInt, paramAbsBaseArticleInfo);
  }
  
  public void unRegisterReceiver() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdActionUtilServiceImpl
 * JD-Core Version:    0.7.0.1
 */