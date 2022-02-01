package com.tencent.mobileqq.register;

import java.util.HashMap;

public class QueryAccount$RegisterFaceResult
{
  private String a;
  private String b;
  private HashMap<String, Object> c;
  
  public QueryAccount$RegisterFaceResult(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = new HashMap();
    this.c.put("face_reg_sig", paramString1.getBytes());
    this.c.put("face_result", paramString2.getBytes());
  }
  
  public HashMap<String, Object> a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount.RegisterFaceResult
 * JD-Core Version:    0.7.0.1
 */