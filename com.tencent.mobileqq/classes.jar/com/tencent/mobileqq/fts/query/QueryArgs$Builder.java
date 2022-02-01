package com.tencent.mobileqq.fts.query;

import android.util.Pair;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import mqq.app.AppRuntime;

public class QueryArgs$Builder
{
  int a = -1;
  String b = null;
  private final AppRuntime c;
  private int d;
  private String e;
  private Class f;
  private boolean g = false;
  private boolean h = false;
  private long i;
  private int j;
  private long k;
  private int l = 0;
  private Pair<CharSequence, CharSequence> m;
  
  public QueryArgs$Builder(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      this.c = paramAppRuntime;
      return;
    }
    throw new RuntimeException("FTS query arg builder with a empty AppRuntime");
  }
  
  public Builder a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.k = paramLong;
    this.a = 2;
    this.b = String.valueOf(paramLong);
    return this;
  }
  
  public Builder a(long paramLong, int paramInt)
  {
    this.i = paramLong;
    this.j = paramInt;
    this.b = FTSMessage.getExt1(paramLong, paramInt);
    this.a = 1;
    return this;
  }
  
  public Builder a(Pair<CharSequence, CharSequence> paramPair)
  {
    this.m = new Pair(paramPair.first, paramPair.second);
    return this;
  }
  
  public Builder a(Class paramClass)
  {
    this.f = paramClass;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public QueryArgs a()
  {
    return new QueryArgs(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.l, this.k, this.m, this.a, this.b, null);
  }
  
  public Builder b(int paramInt)
  {
    this.l = paramInt;
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.query.QueryArgs.Builder
 * JD-Core Version:    0.7.0.1
 */