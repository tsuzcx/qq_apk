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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramJSONObject.optInt("ret", -30009);
    if ((this.jdField_a_of_type_Int == 0) && (paramJSONObject.optInt("flag", 0) == 1)) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public String toString()
  {
    return "LiangHaoStatusRsp{ret=" + this.jdField_a_of_type_Int + ", flag=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.data.LiangHaoStatusRsp
 * JD-Core Version:    0.7.0.1
 */