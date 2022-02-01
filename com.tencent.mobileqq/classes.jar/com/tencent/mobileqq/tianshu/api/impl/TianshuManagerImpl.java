package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import cooperation.vip.tianshu.TianShuManager;
import java.util.List;

public class TianshuManagerImpl
  implements ITianshuManager
{
  public void report(TianShuReportData paramTianShuReportData)
  {
    TianShuManager.getInstance().report(paramTianShuReportData);
  }
  
  public void requestAdv(List<TianShuAdPosItemData> paramList, TianShuGetAdvCallback paramTianShuGetAdvCallback)
  {
    TianShuManager.getInstance().requestAdv(paramList, paramTianShuGetAdvCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.TianshuManagerImpl
 * JD-Core Version:    0.7.0.1
 */