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
    int i = paramArrayOfString.length;
    int j = this.jdField_b_of_type_Int;
    if (i >= j) {
      paramArrayOfString = paramArrayOfString[(j - 1)];
    } else {
      paramArrayOfString = null;
    }
    return (paramArrayOfString != null) && (paramArrayOfString.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Category [statusId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", displayName=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", detectName=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", level=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationCategoryDetector.Category
 * JD-Core Version:    0.7.0.1
 */