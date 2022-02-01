package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.applets.AppletsObserver;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class MiniAppUserAppInfoListManager$1
  extends AppletsObserver
{
  MiniAppUserAppInfoListManager$1(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager) {}
  
  protected void onGetAppletsPushUnreadInfo(Object paramObject)
  {
    if ((MiniAppConfProcessor.g()) && ((paramObject instanceof MiniAppRedDotEntity)))
    {
      paramObject = (MiniAppRedDotEntity)paramObject;
      this.this$0.setMiniAppPushRedDotData(paramObject);
    }
  }
  
  protected void onReceiveAppletsMessageUnreadInfo(Map<String, Integer> paramMap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveAppletsMessageUnreadInfo: ");
      localStringBuilder.append(paramMap);
      QLog.d("AppletsObserver", 1, localStringBuilder.toString());
    }
    this.this$0.setMiniAppNoticeRedDotData(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.1
 * JD-Core Version:    0.7.0.1
 */