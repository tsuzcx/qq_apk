package com.tencent.mobileqq.register;

import java.util.HashMap;

public class QueryAccount$RegisterFaceResult
{
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap;
  private String b;
  
  public QueryAccount$RegisterFaceResult(QueryAccount paramQueryAccount, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("face_reg_sig", paramString1.getBytes());
    this.jdField_a_of_type_JavaUtilHashMap.put("face_result", paramString2.getBytes());
  }
  
  public HashMap<String, Object> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount.RegisterFaceResult
 * JD-Core Version:    0.7.0.1
 */