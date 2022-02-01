package com.tencent.mobileqq.conditionsearch;

import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

class ConditionSearchFriendActivity$10
  extends LBSObserver
{
  ConditionSearchFriendActivity$10(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    if (paramBoolean) {
      paramLBSInfo = paramLBSInfo.a();
    } else {
      paramLBSInfo = null;
    }
    Object localObject;
    if (paramLBSInfo != null)
    {
      localObject = paramLBSInfo;
      if (paramLBSInfo.length == 4) {}
    }
    else
    {
      localObject = new String[4];
      localObject[0] = "-1";
      localObject[1] = "-1";
      localObject[2] = "-1";
      localObject[3] = "-1";
    }
    if (!"-1".equals(localObject[0]))
    {
      localObject[3] = "0";
      this.a.a.a((String[])localObject);
      if (this.a.A)
      {
        paramLBSInfo = this.a.a.e((String[])localObject);
        this.a.a.a(0, paramLBSInfo);
        this.a.a.b((String[])localObject);
        this.a.m.setRightText(this.a.a.d(paramLBSInfo));
      }
      ConditionSearchFriendActivity.d(this.a, 1);
      ConditionSearchFriendActivity.d(this.a);
      paramLBSInfo = this.a;
      paramLBSInfo.B = true;
      paramLBSInfo.C = false;
    }
    if (QLog.isColorLevel())
    {
      paramLBSInfo = new StringBuilder();
      paramLBSInfo.append("onGetUserLocation|isSuccess : ");
      paramLBSInfo.append(paramBoolean);
      paramLBSInfo.append(", mIsFirstReqLocation : ");
      paramLBSInfo.append(this.a.A);
      paramLBSInfo.append(", locationCodes[0] : ");
      paramLBSInfo.append(localObject[0]);
      QLog.d("ConditionSearchFriendActivity", 2, paramLBSInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.10
 * JD-Core Version:    0.7.0.1
 */