package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class MsgProcessConstant
{
  public String a = "MsgBackup." + getClass().getSimpleName();
  
  public void a(String paramString)
  {
    if (MsgBackupUtil.a) {
      QLog.d(this.a, 2, paramString);
    }
  }
  
  protected boolean a(String paramString)
  {
    return FileUtils.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessConstant
 * JD-Core Version:    0.7.0.1
 */