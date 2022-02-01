package com.tencent.mobileqq.kandian.ad.api;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.InsertArticle;

@QAPI(process={"all"})
public abstract interface IRIJFastWebRecommendAdService
  extends QRouteApi
{
  public abstract List<Integer> getAdPos();
  
  public abstract oidb_cmd0x68b.ReqAdvertisePara getAdRequestData();
  
  public abstract void onAdJump(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean, int paramInt);
  
  public abstract void onAdJump(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  
  public abstract void onAdJump(Context paramContext, BaseData paramBaseData, boolean paramBoolean, int paramInt);
  
  public abstract void onDestroy();
  
  public abstract void onResume();
  
  public abstract List<AbsBaseArticleInfo> parseAdvertise(oidb_cmd0xf30.InsertArticle paramInsertArticle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJFastWebRecommendAdService
 * JD-Core Version:    0.7.0.1
 */