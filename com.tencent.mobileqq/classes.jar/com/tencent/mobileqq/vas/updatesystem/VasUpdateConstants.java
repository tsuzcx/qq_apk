package com.tencent.mobileqq.vas.updatesystem;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import mqq.app.MobileQQ;

public class VasUpdateConstants
{
  public static final String a = MobileQQ.getContext().getFilesDir().getAbsolutePath() + File.separator + "quickupdate";
  public static final String b = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".vas_quickupdate_test/");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants
 * JD-Core Version:    0.7.0.1
 */