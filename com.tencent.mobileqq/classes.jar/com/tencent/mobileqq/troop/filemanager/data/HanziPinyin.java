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
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaLangString != null) {
      localStringBuilder.append(", hanzi = " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.b != null) {
      localStringBuilder.append(", pinyin = " + this.b);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.HanziPinyin
 * JD-Core Version:    0.7.0.1
 */