package com.tencent.mobileqq.fts.query;

import android.util.Pair;
import com.tencent.mobileqq.fts.api.IFTSQuery;
import java.util.List;
import mqq.app.AppRuntime;

public class QueryArgs
{
  public AppRuntime a;
  public int b;
  public String c;
  public Class d;
  public boolean e;
  public boolean f;
  public long g;
  public int h;
  public int i;
  public long j;
  public int k = -1;
  public String l = null;
  public Pair<CharSequence, CharSequence> m;
  
  private QueryArgs(AppRuntime paramAppRuntime, int paramInt1, String paramString1, Class paramClass, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, int paramInt2, int paramInt3, long paramLong2, Pair<CharSequence, CharSequence> paramPair, int paramInt4, String paramString2)
  {
    this.a = paramAppRuntime;
    this.b = paramInt1;
    this.c = paramString1;
    this.d = paramClass;
    this.e = paramBoolean1;
    this.f = paramBoolean2;
    this.g = paramLong1;
    this.h = paramInt2;
    this.j = paramLong2;
    this.i = paramInt3;
    this.m = paramPair;
    this.k = paramInt4;
    this.l = paramString2;
  }
  
  public <T> List<T> a()
  {
    return ((IFTSQuery)this.a.getRuntimeService(IFTSQuery.class, "")).query(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.query.QueryArgs
 * JD-Core Version:    0.7.0.1
 */