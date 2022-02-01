package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

final class TeamWorkConvertUtils$2
  implements DialogInterface.OnClickListener
{
  TeamWorkConvertUtils$2(Context paramContext, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      FileManagerUtil.c(this.jdField_a_of_type_AndroidContentContext, TencentDocConvertConfigProcessor.a().a());
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, paramDialogInterface.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkConvertUtils.2
 * JD-Core Version:    0.7.0.1
 */