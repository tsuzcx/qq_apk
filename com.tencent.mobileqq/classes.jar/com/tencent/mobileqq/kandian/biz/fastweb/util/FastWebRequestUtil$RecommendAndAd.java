package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.detail.web.RecommendAndAdCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;

public class FastWebRequestUtil$RecommendAndAd
{
  private List<BaseData> a = new ArrayList();
  private List<BaseData> b = new ArrayList();
  private RecommendAndAdCallback c;
  private final String d;
  private boolean e;
  private int f;
  
  public FastWebRequestUtil$RecommendAndAd(String paramString, RecommendAndAdCallback paramRecommendAndAdCallback)
  {
    this.c = paramRecommendAndAdCallback;
    this.d = paramString;
  }
  
  private void a()
  {
    try
    {
      if ((this.b != null) && (this.a != null) && (this.c != null)) {
        this.c.a(true, this.d, this.a, this.b, this.f, this.e);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(List<BaseData> paramList)
  {
    this.b = paramList;
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("REPORT_LINK", "requestAdData adDatas callback");
    a();
  }
  
  public void a(List<BaseData> paramList, boolean paramBoolean, int paramInt)
  {
    this.a = paramList;
    this.e = paramBoolean;
    this.f = paramInt;
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("REPORT_LINK", "requestAdData recommendDatas callback");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil.RecommendAndAd
 * JD-Core Version:    0.7.0.1
 */