package com.tencent.mobileqq.vip.lianghao.data;

import org.json.JSONObject;

public class LiangHaoStatusRsp
{
  public int a = -30009;
  public boolean b;
  
  public LiangHaoStatusRsp()
  {
    this.b = false;
  }
  
  public LiangHaoStatusRsp(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    this.b = false;
    this.a = paramJSONObject.optInt("ret", -30009);
    boolean bool1 = bool2;
    if (this.a == 0)
    {
      bool1 = bool2;
      if (paramJSONObject.optInt("flag", 0) == 1) {
        bool1 = true;
      }
    }
    this.b = bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LiangHaoStatusRsp{ret=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", flag=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.data.LiangHaoStatusRsp
 * JD-Core Version:    0.7.0.1
 */