package com.tencent.mobileqq.mini.entry.desktop.item;

import akwr;
import amtc;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class DesktopDataManager$27
  extends akwr
{
  DesktopDataManager$27(DesktopDataManager paramDesktopDataManager) {}
  
  public void onGetAppletsPushUnreadInfo(Object paramObject)
  {
    if ((amtc.h()) && ((paramObject instanceof MiniAppRedDotEntity)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.27
 * JD-Core Version:    0.7.0.1
 */