package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;

class SoLoaderServiceImpl$ReportListener
  implements OnLoadListener
{
  public long a;
  public OnLoadListener b;
  public LoadParam c;
  
  SoLoaderServiceImpl$ReportListener(OnLoadListener paramOnLoadListener, long paramLong, LoadParam paramLoadParam)
  {
    this.a = paramLong;
    this.b = paramOnLoadListener;
    this.c = paramLoadParam;
  }
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    SoLoaderServiceImpl.access$200(paramInt, paramLoadExtResult, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderServiceImpl.ReportListener
 * JD-Core Version:    0.7.0.1
 */