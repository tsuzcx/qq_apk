package com.tencent.mobileqq.fts.v2;

import com.tencent.mobileqq.fts.v2.entity.FTSEntityV2;

public class FTSQueryArgsV2$Builder
{
  private int jdField_a_of_type_Int;
  private Class<? extends FTSEntityV2> jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  FTSQueryArgsV2.MatchKey[] jdField_a_of_type_ArrayOfComTencentMobileqqFtsV2FTSQueryArgsV2$MatchKey;
  private String b;
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(Class<? extends FTSEntityV2> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder a(FTSQueryArgsV2.MatchKey... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFtsV2FTSQueryArgsV2$MatchKey = paramVarArgs;
    return this;
  }
  
  public FTSQueryArgsV2 a()
  {
    Class localClass = this.jdField_a_of_type_JavaLangClass;
    if (localClass != null) {
      return new FTSQueryArgsV2(localClass, this.jdField_a_of_type_ArrayOfComTencentMobileqqFtsV2FTSQueryArgsV2$MatchKey, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
    }
    throw new IllegalArgumentException("entityClazz must not be null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.FTSQueryArgsV2.Builder
 * JD-Core Version:    0.7.0.1
 */