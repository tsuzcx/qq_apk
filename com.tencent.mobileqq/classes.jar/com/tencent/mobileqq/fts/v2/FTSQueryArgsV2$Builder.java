package com.tencent.mobileqq.fts.v2;

import com.tencent.mobileqq.fts.v2.entity.FTSEntityV2;

public class FTSQueryArgsV2$Builder
{
  FTSQueryArgsV2.MatchKey[] a;
  private Class<? extends FTSEntityV2> b;
  private int c;
  private boolean d = false;
  private String e;
  private String f;
  
  public Builder a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder a(Class<? extends FTSEntityV2> paramClass)
  {
    this.b = paramClass;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public Builder a(FTSQueryArgsV2.MatchKey... paramVarArgs)
  {
    this.a = paramVarArgs;
    return this;
  }
  
  public FTSQueryArgsV2 a()
  {
    Class localClass = this.b;
    if (localClass != null) {
      return new FTSQueryArgsV2(localClass, this.a, this.d, this.c, this.e, this.f);
    }
    throw new IllegalArgumentException("entityClazz must not be null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.FTSQueryArgsV2.Builder
 * JD-Core Version:    0.7.0.1
 */