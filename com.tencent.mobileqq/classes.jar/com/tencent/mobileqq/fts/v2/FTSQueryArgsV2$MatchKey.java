package com.tencent.mobileqq.fts.v2;

public class FTSQueryArgsV2$MatchKey
{
  public String a;
  public String b;
  public boolean c;
  @Deprecated
  public boolean d = true;
  
  public FTSQueryArgsV2$MatchKey(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MatchKey{column='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", keyword='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", or=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.FTSQueryArgsV2.MatchKey
 * JD-Core Version:    0.7.0.1
 */