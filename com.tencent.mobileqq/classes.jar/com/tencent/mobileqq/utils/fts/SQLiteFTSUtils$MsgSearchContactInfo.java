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
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("MsgSearchContactInfo{uin='");
    localStringBuilder1.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder1.append('\'');
    localStringBuilder1.append(", uinType=");
    localStringBuilder1.append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(", matchTitle=[");
    Object localObject2 = this.jdField_a_of_type_AndroidUtilPair;
    Object localObject1 = "null";
    if (localObject2 != null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      if (this.jdField_a_of_type_AndroidUtilPair.first == null) {
        localObject2 = "null";
      } else {
        localObject2 = (CharSequence)this.jdField_a_of_type_AndroidUtilPair.first;
      }
      localStringBuilder2.append(localObject2);
      localStringBuilder2.append(", ");
      if (this.jdField_a_of_type_AndroidUtilPair.second != null) {
        localObject1 = (CharSequence)this.jdField_a_of_type_AndroidUtilPair.second;
      }
      localStringBuilder2.append(localObject1);
      localObject1 = localStringBuilder2.toString();
    }
    localStringBuilder1.append((String)localObject1);
    localStringBuilder1.append("]");
    localStringBuilder1.append('}');
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.MsgSearchContactInfo
 * JD-Core Version:    0.7.0.1
 */