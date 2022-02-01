package com.tencent.mobileqq.search.searchengine;

import android.text.TextUtils;

public class SearchRespData
{
  public int a;
  public String a;
  
  public SearchRespData(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_a_of_type_JavaLangString.equals(paramString);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("keyword:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" status:").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.SearchRespData
 * JD-Core Version:    0.7.0.1
 */