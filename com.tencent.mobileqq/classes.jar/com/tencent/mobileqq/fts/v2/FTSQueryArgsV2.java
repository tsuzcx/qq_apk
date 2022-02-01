package com.tencent.mobileqq.fts.v2;

import com.tencent.mobileqq.fts.v2.entity.FTSEntityV2;
import java.util.Arrays;

public class FTSQueryArgsV2
{
  public Class<? extends FTSEntityV2> a;
  public FTSQueryArgsV2.MatchKey[] b;
  public boolean c;
  public int d;
  public String e;
  public String f;
  
  public FTSQueryArgsV2(Class<? extends FTSEntityV2> paramClass, FTSQueryArgsV2.MatchKey[] paramArrayOfMatchKey, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.a = paramClass;
    this.b = paramArrayOfMatchKey;
    this.c = paramBoolean;
    this.d = paramInt;
    this.e = paramString1;
    this.f = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FTSQueryArgs{entityClazz=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", matchKeys=");
    localStringBuilder.append(Arrays.toString(this.b));
    localStringBuilder.append(", matchKeysOr=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", limit=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", selectionSql='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", orderBySql='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.FTSQueryArgsV2
 * JD-Core Version:    0.7.0.1
 */