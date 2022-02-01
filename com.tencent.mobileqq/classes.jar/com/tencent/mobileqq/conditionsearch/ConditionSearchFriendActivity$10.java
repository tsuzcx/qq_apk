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
  
  public void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Object localObject = null;
    if (paramBoolean) {
      localObject = paramLBSInfo.a();
    }
    if (localObject != null)
    {
      paramLBSInfo = (LBSInfo)localObject;
      if (localObject.length == 4) {}
    }
    else
    {
      paramLBSInfo = new String[4];
      paramLBSInfo[0] = "-1";
      paramLBSInfo[1] = "-1";
      paramLBSInfo[2] = "-1";
      paramLBSInfo[3] = "-1";
    }
    if (!"-1".equals(paramLBSInfo[0]))
    {
      paramLBSInfo[3] = "0";
      this.a.a.a(paramLBSInfo);
      if (this.a.jdField_b_of_type_Boolean)
      {
        localObject = this.a.a.b(paramLBSInfo);
        this.a.a.a(0, (String)localObject);
        this.a.a.b(paramLBSInfo);
        this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.a.a.c((String)localObject));
      }
      ConditionSearchFriendActivity.a(this.a, 1);
      ConditionSearchFriendActivity.b(this.a);
      this.a.c = true;
      this.a.d = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onGetUserLocation|isSuccess : " + paramBoolean + ", mIsFirstReqLocation : " + this.a.jdField_b_of_type_Boolean + ", locationCodes[0] : " + paramLBSInfo[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.10
 * JD-Core Version:    0.7.0.1
 */