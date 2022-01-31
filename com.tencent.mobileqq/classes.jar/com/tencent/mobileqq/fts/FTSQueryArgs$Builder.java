package com.tencent.mobileqq.fts;

public class FTSQueryArgs$Builder
{
  private int jdField_a_of_type_Int;
  private Class jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  FTSQueryArgs.MatchKey[] jdField_a_of_type_ArrayOfComTencentMobileqqFtsFTSQueryArgs$MatchKey;
  private String b;
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(Class paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder a(FTSQueryArgs.MatchKey... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFtsFTSQueryArgs$MatchKey = paramVarArgs;
    return this;
  }
  
  public FTSQueryArgs a()
  {
    if (this.jdField_a_of_type_JavaLangClass == null) {
      throw new IllegalArgumentException("entityClazz must not be null.");
    }
    return new FTSQueryArgs(this.jdField_a_of_type_JavaLangClass, this.jdField_a_of_type_ArrayOfComTencentMobileqqFtsFTSQueryArgs$MatchKey, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.fts.FTSQueryArgs.Builder
 * JD-Core Version:    0.7.0.1
 */