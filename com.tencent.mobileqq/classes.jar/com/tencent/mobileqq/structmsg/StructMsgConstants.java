package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;

public abstract interface StructMsgConstants
{
  public static final String an = HardCodeUtil.a(2131714409);
  public static final String ao = HardCodeUtil.a(2131714401);
  public static final String ap = HardCodeUtil.a(2131714394);
  public static final String aq = HardCodeUtil.a(2131714405);
  public static final String ar;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("photo");
    localStringBuilder.append("/temp/");
    ar = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgConstants
 * JD-Core Version:    0.7.0.1
 */