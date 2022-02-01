package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class ExpandManager$12$1
  extends LbsManagerServiceOnLocationChangeListener
{
  ExpandManager$12$1(ExpandManager.12 param12, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append("getExtendFriendLocationInfoSync onLocationFinish ");
      paramSosoLbsInfo.append(paramInt);
      QLog.d("ExtendFriendManager", 2, paramSosoLbsInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.12.1
 * JD-Core Version:    0.7.0.1
 */