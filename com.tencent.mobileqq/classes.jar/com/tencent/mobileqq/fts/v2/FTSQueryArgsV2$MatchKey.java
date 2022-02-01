package com.tencent.mobileqq.fts.v2;

public class FTSQueryArgsV2$MatchKey
{
  public String a;
  public boolean a;
  public String b;
  @Deprecated
  public boolean b;
  
  public FTSQueryArgsV2$MatchKey(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MatchKey{column='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", keyword='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", or=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.FTSQueryArgsV2.MatchKey
 * JD-Core Version:    0.7.0.1
 */