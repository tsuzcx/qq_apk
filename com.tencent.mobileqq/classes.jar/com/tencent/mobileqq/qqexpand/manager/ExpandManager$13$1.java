package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class ExpandManager$13$1
  extends LbsManagerServiceOnLocationChangeListener
{
  ExpandManager$13$1(ExpandManager.13 param13, String paramString, boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.13.1
 * JD-Core Version:    0.7.0.1
 */