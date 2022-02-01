package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class MsgProcessConstant
{
  public String a;
  
  public MsgProcessConstant()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgBackup.");
    localStringBuilder.append(getClass().getSimpleName());
    this.a = localStringBuilder.toString();
  }
  
  protected boolean a(String paramString)
  {
    return FileUtils.fileExists(paramString);
  }
  
  public void b(String paramString)
  {
    if (MsgBackupUtil.a) {
      QLog.d(this.a, 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessConstant
 * JD-Core Version:    0.7.0.1
 */