package com.tencent.mobileqq.tianshu.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import java.util.List;

@Service(process={"all"})
public abstract interface ITianshuManager
  extends QRouteApi
{
  public abstract void report(TianShuReportData paramTianShuReportData);
  
  public abstract void requestAdv(List<TianShuAdPosItemData> paramList, TianShuGetAdvCallback paramTianShuGetAdvCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.ITianshuManager
 * JD-Core Version:    0.7.0.1
 */