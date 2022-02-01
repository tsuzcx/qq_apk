package com.tencent.mobileqq.profile.diy;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

public class VipDiyCardConstants
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(AppConstants.SDCARD_PATH);
    localStringBuilder2.append(".profilecard/");
    localStringBuilder1.append(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder2.toString()));
    localStringBuilder1.append("diyCardFonts/");
    a = localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.diy.VipDiyCardConstants
 * JD-Core Version:    0.7.0.1
 */