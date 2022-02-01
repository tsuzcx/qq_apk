package com.tencent.mobileqq.kandian.ad.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRecommendAdHelper;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebRecommendAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdvertisementInfoModule;
import com.tencent.mobileqq.kandian.biz.feeds.api.IReadInJoyFixPosArticleManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.InsertArticle;

public class RIJFastWebRecommendAdServiceImpl
  implements IRIJFastWebRecommendAdService
{
  public List<Integer> getAdPos()
  {
    List localList = ((IReadInJoyFixPosArticleManager)QRoute.api(IReadInJoyFixPosArticleManager.class)).getFixPosArticleInfos(0);
    if (localList != null) {
      return localList;
    }
    return new ArrayList();
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara getAdRequestData()
  {
    AdRequestData localAdRequestData = new AdRequestData();
    localAdRequestData.a = true;
    return (oidb_cmd0x68b.ReqAdvertisePara)((IRIJAdvertisementInfoModule)((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().c()).a(null, 0, 1, 0, 10000, localAdRequestData);
  }
  
  public void onAdJump(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean, int paramInt)
  {
    FastWebRecommendAdHelper.a(paramContext, paramAdvertisementInfo, paramBoolean, paramInt);
  }
  
  public void onAdJump(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    FastWebRecommendAdHelper.a(paramContext, paramAdvertisementInfo, paramBoolean1, paramBoolean2, paramInt);
  }
  
  public void onAdJump(Context paramContext, BaseData paramBaseData, boolean paramBoolean, int paramInt)
  {
    FastWebRecommendAdHelper.a(paramContext, paramBaseData, paramBoolean, paramInt);
  }
  
  public void onDestroy() {}
  
  public void onResume() {}
  
  public List<AbsBaseArticleInfo> parseAdvertise(oidb_cmd0xf30.InsertArticle paramInsertArticle)
  {
    return ((IRIJAdvertisementInfoModule)((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().c()).a(paramInsertArticle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJFastWebRecommendAdServiceImpl
 * JD-Core Version:    0.7.0.1
 */