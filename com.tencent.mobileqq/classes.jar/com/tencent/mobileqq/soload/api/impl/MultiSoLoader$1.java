package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import java.util.List;

class MultiSoLoader$1
  implements OnLoadListener
{
  MultiSoLoader$1(MultiSoLoader paramMultiSoLoader, int paramInt, LoadParam paramLoadParam, OnLoadListener paramOnLoadListener) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    LoadExtResult localLoadExtResult = LoadExtResult.mergeExtResult(paramLoadExtResult, MultiSoLoader.a(this.d));
    MultiSoLoader.a(this.d, localLoadExtResult);
    if (paramInt == 0)
    {
      if (this.a >= this.b.mLoadItems.size() - 1)
      {
        paramLoadExtResult = this.c;
        if (paramLoadExtResult != null) {
          paramLoadExtResult.onLoadResult(paramInt, localLoadExtResult);
        }
      }
      else
      {
        MultiSoLoader.a(this.d, this.b, this.c, this.a + 1);
      }
    }
    else
    {
      if (localLoadExtResult != null) {
        localLoadExtResult.setFailIndex(this.a + 1);
      }
      if (this.c != null)
      {
        paramLoadExtResult = localLoadExtResult;
        if (localLoadExtResult == null) {
          paramLoadExtResult = new LoadExtResult();
        }
        this.c.onLoadResult(paramInt, paramLoadExtResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.MultiSoLoader.1
 * JD-Core Version:    0.7.0.1
 */