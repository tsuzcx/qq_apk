package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.ICreateChannelCallback;
import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetChannelInfoCallback;
import java.util.List;

class GPSAsynManagerEngine$7
  implements IGetChannelInfoCallback
{
  GPSAsynManagerEngine$7(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString, ICreateChannelCallback paramICreateChannelCallback) {}
  
  public void a(int paramInt, String paramString, GProChannelInfo paramGProChannelInfo, IGProSecurityResult paramIGProSecurityResult, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(paramGProChannelInfo);
    if (((StringBuilder)localObject).toString() != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", channelId:");
      ((StringBuilder)localObject).append(paramGProChannelInfo.getChannelUin());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    GProLog.a("【gpro_sdk】", false, "sdk callback", "createChannelWithId", "new id", paramInt, paramString, (String)localObject);
    if ((paramInt == 0) && (this.c.a(paramIGProSecurityResult)))
    {
      this.c.a(paramGProChannelInfo, paramCategoryChannelSortInfo, paramList);
      this.c.a(6, "createChannelWithId", paramGProChannelInfo);
    }
    this.b.a(paramInt, paramString, paramGProChannelInfo, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.7
 * JD-Core Version:    0.7.0.1
 */