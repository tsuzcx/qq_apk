package com.tencent.mobileqq.wink.edit.base;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;

public class AEPath
  extends AEPathBase
{
  private static final String f;
  private static final String g;
  private static final String h;
  private static final String i;
  private static final String j;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/DCIM/Video/");
    f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append(HardCodeUtil.a(2131898855));
    g = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append(HardCodeUtil.a(2131898856));
    h = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Camera/Video/");
    i = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/DCIM/Camera/");
    j = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.base.AEPath
 * JD-Core Version:    0.7.0.1
 */