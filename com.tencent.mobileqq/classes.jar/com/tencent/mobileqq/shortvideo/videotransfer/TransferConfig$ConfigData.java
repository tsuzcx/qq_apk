package com.tencent.mobileqq.shortvideo.videotransfer;

import org.json.JSONObject;

public class TransferConfig$ConfigData
{
  public int a;
  public long a;
  public String a;
  public String b;
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("id", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("duration", this.jdField_a_of_type_Long);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.b = null;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(String paramString)
  {
    a();
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Int = paramString.optInt("id");
      ConfigData localConfigData = TransferConfig.a(this.jdField_a_of_type_Int);
      if (localConfigData != null)
      {
        this.jdField_a_of_type_JavaLangString = localConfigData.jdField_a_of_type_JavaLangString;
        this.b = localConfigData.b;
      }
      this.jdField_a_of_type_Long = paramString.optLong("duration");
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int != -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig.ConfigData
 * JD-Core Version:    0.7.0.1
 */