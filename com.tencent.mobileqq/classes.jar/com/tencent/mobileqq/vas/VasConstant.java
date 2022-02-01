package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.app.AppOpenConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

public class VasConstant
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppOpenConstants.a);
    localStringBuilder.append("/Tencent/MobileQQ/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("vas/");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("lottie/");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("webso/offline/");
    d = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasConstant
 * JD-Core Version:    0.7.0.1
 */