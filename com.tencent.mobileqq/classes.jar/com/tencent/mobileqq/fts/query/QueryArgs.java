package com.tencent.mobileqq.fts.query;

import android.util.Pair;
import com.tencent.mobileqq.fts.api.IFTSQuery;
import java.util.List;
import mqq.app.AppRuntime;

public class QueryArgs
{
  public int a;
  public long a;
  public Pair<CharSequence, CharSequence> a;
  public Class a;
  public String a;
  public AppRuntime a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public int d = -1;
  
  private QueryArgs(AppRuntime paramAppRuntime, int paramInt1, String paramString1, Class paramClass, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, int paramInt2, int paramInt3, long paramLong2, Pair<CharSequence, CharSequence> paramPair, int paramInt4, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_Long = paramLong2;
    this.c = paramInt3;
    this.jdField_a_of_type_AndroidUtilPair = paramPair;
    this.d = paramInt4;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public <T> List<T> a()
  {
    return ((IFTSQuery)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IFTSQuery.class, "")).query(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.query.QueryArgs
 * JD-Core Version:    0.7.0.1
 */