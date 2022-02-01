package com.tencent.mobileqq.kandian.biz.fastweb.event;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdReportService;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashSet;
import org.json.JSONObject;

public class ListAdExposeManager
{
  private HashSet<ListAdExposeData> a;
  private HashSet<ListAdExposeData> b;
  private HashSet<ListAdExposeData> c;
  
  private void a(ListAdExposeData paramListAdExposeData)
  {
    if (this.c.contains(paramListAdExposeData)) {
      return;
    }
    this.c.add(paramListAdExposeData);
    if ((this.b.contains(paramListAdExposeData)) && (!this.a.contains(paramListAdExposeData)))
    {
      this.a.add(paramListAdExposeData);
      b(paramListAdExposeData);
    }
  }
  
  private void b(ListAdExposeData paramListAdExposeData)
  {
    float f = paramListAdExposeData.jdField_a_of_type_Float;
    long l = paramListAdExposeData.b;
    paramListAdExposeData = paramListAdExposeData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (paramListAdExposeData == null) {
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("article_id", String.valueOf(paramListAdExposeData.mArticleID));
      localJSONObject1.put("rowkey", String.valueOf(paramListAdExposeData.mRowKey));
      paramListAdExposeData.mBusiJson = localJSONObject1;
      localJSONObject2.put("exposureArea", f);
      localJSONObject2.put("exposureTime", l);
      paramListAdExposeData.mReportDataJson = localJSONObject2;
    }
    catch (Exception localException)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ListAdExposeManager", localException.getMessage());
    }
    ((IRIJFastWebAdReportService)QRoute.api(IRIJFastWebAdReportService.class)).report(paramListAdExposeData, 38, 2, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.ListAdExposeManager
 * JD-Core Version:    0.7.0.1
 */