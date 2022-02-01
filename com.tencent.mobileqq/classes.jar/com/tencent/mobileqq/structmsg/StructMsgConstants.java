package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;

public abstract interface StructMsgConstants
{
  public static final String aH = HardCodeUtil.a(2131911920);
  public static final String aI = HardCodeUtil.a(2131911912);
  public static final String aJ = HardCodeUtil.a(2131911906);
  public static final String aK = HardCodeUtil.a(2131911916);
  public static final String aL;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("photo");
    localStringBuilder.append("/temp/");
    aL = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgConstants
 * JD-Core Version:    0.7.0.1
 */