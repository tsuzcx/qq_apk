package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.FaceScoreCallBack;
import com.tencent.mobileqq.util.ProfileCardUtil;

class JumpAction$31
  extends FaceScoreCallBack
{
  JumpAction$31(JumpAction paramJumpAction, long paramLong) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Long == paramLong1) && (paramLong2 > 0L)) {
      ProfileCardUtil.a((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.a, paramLong2, this.jdField_a_of_type_Long + "", null, 20003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.31
 * JD-Core Version:    0.7.0.1
 */