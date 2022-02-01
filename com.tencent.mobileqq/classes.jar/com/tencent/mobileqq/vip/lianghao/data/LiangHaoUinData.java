package com.tencent.mobileqq.vip.lianghao.data;

public class LiangHaoUinData
{
  public String a;
  public String b;
  
  public LiangHaoUinData(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LiangHaoUinData{");
    localStringBuilder.append("hide");
    localStringBuilder.append(", light='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.data.LiangHaoUinData
 * JD-Core Version:    0.7.0.1
 */