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
      if (this.a.jdField_b_of_type_Boolean)
      {
        paramLBSInfo = this.a.a.b((String[])localObject);
        this.a.a.a(0, paramLBSInfo);
        this.a.a.b((String[])localObject);
        this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.a.a.c(paramLBSInfo));
      }
      ConditionSearchFriendActivity.a(this.a, 1);
      ConditionSearchFriendActivity.b(this.a);
      paramLBSInfo = this.a;
      paramLBSInfo.c = true;
      paramLBSInfo.d = false;
    }
    if (QLog.isColorLevel())
    {
      paramLBSInfo = new StringBuilder();
      paramLBSInfo.append("onGetUserLocation|isSuccess : ");
      paramLBSInfo.append(paramBoolean);
      paramLBSInfo.append(", mIsFirstReqLocation : ");
      paramLBSInfo.append(this.a.jdField_b_of_type_Boolean);
      paramLBSInfo.append(", locationCodes[0] : ");
      paramLBSInfo.append(localObject[0]);
      QLog.d("ConditionSearchFriendActivity", 2, paramLBSInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.10
 * JD-Core Version:    0.7.0.1
 */