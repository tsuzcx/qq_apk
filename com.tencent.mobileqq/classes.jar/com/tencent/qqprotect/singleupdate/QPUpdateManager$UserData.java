package com.tencent.qqprotect.singleupdate;

class QPUpdateManager$UserData
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  
  public QPUpdateManager$UserData(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong, int paramInt5)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
    this.e = paramInt5;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("filePath=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",fileName=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",fileId=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",fileUrl=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(",fileHash=");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(",fileVersion=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(",zipFlag=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",startTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",tryTimes=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(",downloadFlag=");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPUpdateManager.UserData
 * JD-Core Version:    0.7.0.1
 */