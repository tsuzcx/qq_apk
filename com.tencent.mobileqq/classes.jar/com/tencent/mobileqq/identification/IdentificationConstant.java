package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Arrays;
import java.util.List;

public abstract interface IdentificationConstant
{
  public static final String a;
  public static final List<String> a;
  public static final String b;
  public static final List<String> b;
  public static final String c;
  public static final List<String> c;
  public static final List<String> d;
  public static final List<String> e;
  
  static
  {
    jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "loginVerify", "changeSecureMobile" });
    jdField_b_of_type_JavaUtilList = Arrays.asList(new String[] { "setFaceData", "changeSecureMobile", "deleteFace", "identify" });
    jdField_c_of_type_JavaUtilList = Arrays.asList(new String[] { "identify", "identifyNoLogin" });
    d = Arrays.asList(new String[] { "loginVerify", "identifyNoLogin" });
    e = Arrays.asList(new String[] { "loginVerify", "identify", "changeSecureMobile", "identifyNoLogin" });
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705785);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705784);
    jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131705793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationConstant
 * JD-Core Version:    0.7.0.1
 */