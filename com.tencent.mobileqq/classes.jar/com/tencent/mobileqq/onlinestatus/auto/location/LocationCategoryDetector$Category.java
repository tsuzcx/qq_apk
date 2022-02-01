package com.tencent.mobileqq.onlinestatus.auto.location;

import androidx.annotation.NonNull;

public class LocationCategoryDetector$Category
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public LocationCategoryDetector$Category(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    String str = null;
    if (paramArrayOfString.length >= this.jdField_b_of_type_Int) {
      str = paramArrayOfString[(this.jdField_b_of_type_Int - 1)];
    }
    return (str != null) && (str.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NonNull
  public String toString()
  {
    return "Category [statusId=" + this.jdField_a_of_type_Int + ", displayName=" + this.jdField_b_of_type_JavaLangString + ", detectName=" + this.jdField_a_of_type_JavaLangString + ", level=" + this.jdField_b_of_type_Int + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationCategoryDetector.Category
 * JD-Core Version:    0.7.0.1
 */