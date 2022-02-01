package com.tencent.mobileqq.msgbackup.util;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

public class MsgBackupConstant
{
  public static final String a;
  public static final String b;
  public static final String c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("msgbackup/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("multimsg/");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("db/");
    c = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupConstant
 * JD-Core Version:    0.7.0.1
 */