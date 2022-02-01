package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.qqexpand.utils.ExtendFriendGetLocationListener;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class ExpandManager$12
  extends LbsManagerServiceOnLocationChangeListener
{
  ExpandManager$12(ExpandManager paramExpandManager, String paramString, boolean paramBoolean, ExtendFriendGetLocationListener paramExtendFriendGetLocationListener)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getExtendFriendLocationInfoAsync onLocationFinish ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ExtendFriendManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a != null)
    {
      localObject = this.b;
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ExpandManager.a((ExpandManager)localObject, bool, paramSosoLbsInfo, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.12
 * JD-Core Version:    0.7.0.1
 */