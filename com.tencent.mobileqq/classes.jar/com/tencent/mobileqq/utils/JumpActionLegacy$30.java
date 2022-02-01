package com.tencent.mobileqq.utils;

import android.os.Bundle;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.nearby.FaceScoreCallBack;

class JumpActionLegacy$30
  extends FaceScoreCallBack
{
  JumpActionLegacy$30(JumpActionLegacy paramJumpActionLegacy, long paramLong) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Long == paramLong1) && (paramLong2 > 0L))
    {
      QBaseActivity localQBaseActivity = (QBaseActivity)this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("");
      NewReportPlugin.a(localQBaseActivity, paramLong2, localStringBuilder.toString(), null, 20003, "", new Bundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.30
 * JD-Core Version:    0.7.0.1
 */