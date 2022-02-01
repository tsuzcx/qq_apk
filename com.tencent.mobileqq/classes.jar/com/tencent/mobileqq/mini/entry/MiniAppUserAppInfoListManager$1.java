package com.tencent.mobileqq.mini.entry;

import anxo;
import apyt;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class MiniAppUserAppInfoListManager$1
  extends anxo
{
  MiniAppUserAppInfoListManager$1(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager) {}
  
  public void onGetAppletsPushUnreadInfo(Object paramObject)
  {
    if ((apyt.d()) && ((paramObject instanceof MiniAppRedDotEntity)))
    {
      paramObject = (MiniAppRedDotEntity)paramObject;
      this.this$0.setMiniAppPushRedDotData(paramObject);
    }
  }
  
  public void onReceiveAppletsMessageUnreadInfo(Map<String, Integer> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsObserver", 1, "onReceiveAppletsMessageUnreadInfo: " + paramMap);
    }
    this.this$0.setMiniAppNoticeRedDotData(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.1
 * JD-Core Version:    0.7.0.1
 */