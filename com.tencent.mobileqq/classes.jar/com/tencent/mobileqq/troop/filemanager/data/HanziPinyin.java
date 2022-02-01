package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;

public class HanziPinyin
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public HanziPinyin(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramString2.length();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", hanzi = ");
      localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.b != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", pinyin = ");
      localStringBuilder2.append(this.b);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.HanziPinyin
 * JD-Core Version:    0.7.0.1
 */