package com.tencent.mobileqq.vip.lianghao.data;

import org.json.JSONObject;

public class LiangHaoStatusRsp
{
  public int a;
  public boolean a;
  
  public LiangHaoStatusRsp()
  {
    this.jdField_a_of_type_Int = -30009;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public LiangHaoStatusRsp(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = -30009;
    boolean bool2 = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramJSONObject.optInt("ret", -30009);
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Int == 0)
    {
      bool1 = bool2;
      if (paramJSONObject.optInt("flag", 0) == 1) {
        bool1 = true;
      }
    }
    this.jdField_a_of_type_Boolean = bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LiangHaoStatusRsp{ret=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", flag=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.data.LiangHaoStatusRsp
 * JD-Core Version:    0.7.0.1
 */