package com.tencent.mobileqq.vas.updatesystem;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import mqq.app.MobileQQ;

public class VasUpdateConstants
{
  public static final String a;
  public static final String b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("quickupdate");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".vas_quickupdate_test/");
    b = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants
 * JD-Core Version:    0.7.0.1
 */