package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Arrays;
import java.util.List;

public abstract interface IdentificationConstant
{
  public static final List<String> a = Arrays.asList(new String[] { "loginVerify", "changeSecureMobile" });
  public static final List<String> b = Arrays.asList(new String[] { "setFaceData", "changeSecureMobile", "deleteFace", "identify", "studyModeIdentify" });
  public static final List<String> c = Arrays.asList(new String[] { "identify", "identifyNoLogin", "studyModeIdentify" });
  public static final List<String> d = Arrays.asList(new String[] { "loginVerify", "identifyNoLogin" });
  public static final List<String> e = Arrays.asList(new String[] { "loginVerify", "identify", "changeSecureMobile", "identifyNoLogin", "studyModeIdentify" });
  public static final String f = HardCodeUtil.a(2131903670);
  public static final String g = HardCodeUtil.a(2131903669);
  public static final String h = HardCodeUtil.a(2131903678);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationConstant
 * JD-Core Version:    0.7.0.1
 */