package com.tencent.mobileqq.writetogetherconfig;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

public class WriteTogetherTemplateConfBean$TemplateBean
{
  @SerializedName("troopType")
  public long[] a;
  @SerializedName("seqList")
  public int[] b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TemplateBean{troopType=");
    localStringBuilder.append(Arrays.toString(this.a));
    localStringBuilder.append(", seqList=");
    localStringBuilder.append(Arrays.toString(this.b));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfBean.TemplateBean
 * JD-Core Version:    0.7.0.1
 */