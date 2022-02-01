package com.tencent.mobileqq.writetogetherconfig;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

public class WriteTogetherTemplateConfBean$TemplateBean
{
  @SerializedName("seqList")
  public int[] a;
  @SerializedName("troopType")
  public long[] a;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TemplateBean{troopType=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfLong));
    localStringBuilder.append(", seqList=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfInt));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfBean.TemplateBean
 * JD-Core Version:    0.7.0.1
 */