package com.tencent.mobileqq.fts;

import java.util.Arrays;

public class FTSQueryArgs
{
  public int a;
  public Class a;
  public String a;
  public boolean a;
  public FTSQueryArgs.MatchKey[] a;
  public String b;
  
  public FTSQueryArgs(Class paramClass, FTSQueryArgs.MatchKey[] paramArrayOfMatchKey, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFtsFTSQueryArgs$MatchKey = paramArrayOfMatchKey;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    return "FTSQueryArgs{entityClazz=" + this.jdField_a_of_type_JavaLangClass + ", matchKeys=" + Arrays.toString(this.jdField_a_of_type_ArrayOfComTencentMobileqqFtsFTSQueryArgs$MatchKey) + ", matchKeysOr=" + this.jdField_a_of_type_Boolean + ", limit=" + this.jdField_a_of_type_Int + ", selectionSql='" + this.jdField_a_of_type_JavaLangString + '\'' + ", orderBySql='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.fts.FTSQueryArgs
 * JD-Core Version:    0.7.0.1
 */