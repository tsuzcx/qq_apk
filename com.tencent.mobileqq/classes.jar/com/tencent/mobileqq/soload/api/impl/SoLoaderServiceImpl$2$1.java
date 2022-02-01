package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;

class SoLoaderServiceImpl$2$1
  implements OnLoadListener
{
  SoLoaderServiceImpl$2$1(SoLoaderServiceImpl.2 param2) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (this.a.b != null)
    {
      LoadExtResult localLoadExtResult = paramLoadExtResult;
      if (paramLoadExtResult == null) {
        localLoadExtResult = new LoadExtResult();
      }
      this.a.b.onLoadResult(paramInt, localLoadExtResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderServiceImpl.2.1
 * JD-Core Version:    0.7.0.1
 */