package com.tencent.timi.game.liveroom.impl;

import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.timi.game.utils.Logger;
import java.util.List;

class TimiAnchorView$9
  implements IQQGiftListCallback
{
  TimiAnchorView$9(TimiAnchorView paramTimiAnchorView, IQQGiftSDK paramIQQGiftSDK) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg: ");
    localStringBuilder.append(paramString);
    Logger.c("TimiAnchorView", localStringBuilder.toString());
  }
  
  public void a(List<GiftServiceData> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      int[] arrayOfInt = new int[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        arrayOfInt[i] = ((GiftServiceData)paramList.get(i)).g;
        i += 1;
      }
      this.a.g().a(arrayOfInt, TimiAnchorView.r(this.b));
      return;
    }
    Logger.c("TimiAnchorView", "getGiftList#onReceive empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAnchorView.9
 * JD-Core Version:    0.7.0.1
 */