package com.tencent.mobileqq.fts.v2;

import com.tencent.mobileqq.fts.v2.entity.FTSEntityV2;
import java.util.Arrays;

public class FTSQueryArgsV2
{
  public int a;
  public Class<? extends FTSEntityV2> a;
  public String a;
  public boolean a;
  public FTSQueryArgsV2.MatchKey[] a;
  public String b;
  
  public FTSQueryArgsV2(Class<? extends FTSEntityV2> paramClass, FTSQueryArgsV2.MatchKey[] paramArrayOfMatchKey, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFtsV2FTSQueryArgsV2$MatchKey = paramArrayOfMatchKey;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FTSQueryArgs{entityClazz=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangClass);
    localStringBuilder.append(", matchKeys=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfComTencentMobileqqFtsV2FTSQueryArgsV2$MatchKey));
    localStringBuilder.append(", matchKeysOr=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", limit=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", selectionSql='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", orderBySql='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.FTSQueryArgsV2
 * JD-Core Version:    0.7.0.1
 */