package com.tencent.mobileqq.utils.fts;

import android.util.Pair;

public class SQLiteFTSUtils$MsgSearchContactInfo
{
  public int a;
  public Pair<CharSequence, CharSequence> a;
  public String a;
  
  public SQLiteFTSUtils$MsgSearchContactInfo(String paramString, int paramInt, Pair<CharSequence, CharSequence> paramPair)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidUtilPair = paramPair;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("MsgSearchContactInfo{uin='").append(this.jdField_a_of_type_JavaLangString).append('\'').append(", uinType=").append(this.jdField_a_of_type_Int).append(", matchTitle=[");
    if (this.jdField_a_of_type_AndroidUtilPair == null)
    {
      localObject = "null";
      return (String)localObject + "]" + '}';
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (this.jdField_a_of_type_AndroidUtilPair.first == null)
    {
      localObject = "null";
      label92:
      localStringBuilder2 = localStringBuilder2.append(localObject).append(", ");
      if (this.jdField_a_of_type_AndroidUtilPair.second != null) {
        break label142;
      }
    }
    label142:
    for (Object localObject = "null";; localObject = (CharSequence)this.jdField_a_of_type_AndroidUtilPair.second)
    {
      localObject = localObject;
      break;
      localObject = (CharSequence)this.jdField_a_of_type_AndroidUtilPair.first;
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.MsgSearchContactInfo
 * JD-Core Version:    0.7.0.1
 */