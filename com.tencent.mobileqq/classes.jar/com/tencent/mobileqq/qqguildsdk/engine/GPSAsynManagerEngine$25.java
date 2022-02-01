package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IGetChannelCategoryCallback;
import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.manager.ChannelListMgr;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetChannelCategoryWithListCallback;
import java.util.List;

class GPSAsynManagerEngine$25
  implements IGetChannelCategoryWithListCallback
{
  GPSAsynManagerEngine$25(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString, IGetChannelCategoryCallback paramIGetChannelCategoryCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    if (paramInt == 0) {
      this.c.d().a(this.a, paramCategoryChannelSortInfo, paramList);
    }
    this.b.a(paramInt, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.25
 * JD-Core Version:    0.7.0.1
 */