package com.tencent.mobileqq.jumpcontroller;

import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.QQPermissionCallback;

class JumpControllerInject$2
  implements QQPermissionCallback
{
  JumpControllerInject$2(JumpControllerInject paramJumpControllerInject, JumpActivity paramJumpActivity, boolean paramBoolean) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("JumpControllerInject", 1, "system share.doShare denied sd grant");
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, new JumpControllerInject.2.1(this));
    paramArrayOfString = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareDeny", true, 0L, 0L, paramArrayOfString, "");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("JumpControllerInject", 1, "system share.doShare user grant");
    JumpActivityHelper.c(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, this.jdField_a_of_type_Boolean);
    paramArrayOfString = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareGrant", true, 0L, 0L, paramArrayOfString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jumpcontroller.JumpControllerInject.2
 * JD-Core Version:    0.7.0.1
 */