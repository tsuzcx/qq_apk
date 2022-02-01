package com.tencent.mobileqq.fts.query;

import android.util.Pair;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import mqq.app.AppRuntime;

public class QueryArgs$Builder
{
  int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private Pair<CharSequence, CharSequence> jdField_a_of_type_AndroidUtilPair;
  private Class jdField_a_of_type_JavaLangClass;
  String jdField_a_of_type_JavaLangString = null;
  private final AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  private int d = 0;
  
  public QueryArgs$Builder(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      return;
    }
    throw new RuntimeException("FTS query arg builder with a empty AppRuntime");
  }
  
  public Builder a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramLong);
    return this;
  }
  
  public Builder a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.c = paramInt;
    this.jdField_a_of_type_JavaLangString = FTSMessage.getExt1(paramLong, paramInt);
    this.jdField_a_of_type_Int = 1;
    return this;
  }
  
  public Builder a(Pair<CharSequence, CharSequence> paramPair)
  {
    this.jdField_a_of_type_AndroidUtilPair = new Pair(paramPair.first, paramPair.second);
    return this;
  }
  
  public Builder a(Class paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public QueryArgs a()
  {
    return new QueryArgs(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangClass, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Long, this.c, this.d, this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidUtilPair, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, null);
  }
  
  public Builder b(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.query.QueryArgs.Builder
 * JD-Core Version:    0.7.0.1
 */