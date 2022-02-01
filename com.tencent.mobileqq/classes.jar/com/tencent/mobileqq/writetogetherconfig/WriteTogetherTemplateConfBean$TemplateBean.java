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
    return "TemplateBean{troopType=" + Arrays.toString(this.jdField_a_of_type_ArrayOfLong) + ", seqList=" + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfBean.TemplateBean
 * JD-Core Version:    0.7.0.1
 */