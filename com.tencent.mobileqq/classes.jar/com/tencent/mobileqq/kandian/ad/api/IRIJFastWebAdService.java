package com.tencent.mobileqq.kandian.ad.api;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonAdBar;
import com.tencent.mobileqq.kandian.biz.fastweb.ResponseCallback;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IRIJFastWebAdService
  extends QRouteApi
{
  public abstract void addBottomAd(List<BaseData> paramList1, List<BaseData> paramList2);
  
  public abstract void addHotRecommend(List<BaseData> paramList1, List<BaseData> paramList2, BaseData paramBaseData);
  
  public abstract void addInnerAd(List<BaseData> paramList1, List<BaseData> paramList2);
  
  public abstract void cancelDisLikeAdPopWindow();
  
  public abstract void fixInnerAndBottmAd(List<BaseData> paramList);
  
  public abstract void getAdData(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, int paramInt1, long paramLong, ResponseCallback paramResponseCallback, int paramInt2);
  
  public abstract int getHotArticleRecommendGap();
  
  public abstract ViewBase.IBuilder getReadInJoyArticleBottomVideoViewBuilder();
  
  public abstract JSONObject getTelephoneSubmitInfo(int paramInt1, int paramInt2, String paramString, AdvertisementInfo paramAdvertisementInfo);
  
  public abstract Object[] getWebFastProteusAdCreators();
  
  public abstract boolean instanceofProteusBannerVideoItemData(Object paramObject);
  
  public abstract boolean isBottomAd(Object paramObject);
  
  public abstract boolean isGameComponentAndGetGiftType(AdData paramAdData);
  
  public abstract boolean isGameComponentType(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isInnerSoftAd(AdData paramAdData);
  
  public abstract void jumpAd(Activity paramActivity, AdData paramAdData);
  
  public abstract String processTextLength(String paramString, int paramInt);
  
  public abstract void removeBottomAd(List<BaseData> paramList);
  
  public abstract void removeInnerAd(List<BaseData> paramList);
  
  public abstract void resetRecommendAdData(BaseData paramBaseData, int paramInt);
  
  public abstract void setBannerVideoDataShowingGuide(Object paramObject, boolean paramBoolean);
  
  public abstract void setCommonBarData(Activity paramActivity, CommonAdBar paramCommonAdBar, List paramList);
  
  public abstract void updateSoftAdBar(CommonAdBar paramCommonAdBar, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService
 * JD-Core Version:    0.7.0.1
 */