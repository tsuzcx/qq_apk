package com.tencent.mobileqq.guild.live.viewmodel;

import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGuildLiveRoomVmData$4
  implements IQQGiftListCallback
{
  QQGuildLiveRoomVmData$4(QQGuildLiveRoomVmData paramQQGuildLiveRoomVmData, IQQGiftSDK paramIQQGiftSDK) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGiftList onFailed, errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    QLog.e("QGL.QQGuildLiveRoomVmData", 1, localStringBuilder.toString());
  }
  
  public void a(List<GiftServiceData> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int[] arrayOfInt = new int[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        arrayOfInt[i] = ((GiftServiceData)paramList.get(i)).g;
        i += 1;
      }
      this.a.g().b(arrayOfInt, null);
      QLog.e("QGL.QQGuildLiveRoomVmData", 1, "getGiftList onReceive, downloadPanelResources.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveRoomVmData.4
 * JD-Core Version:    0.7.0.1
 */