package com.tencent.mobileqq.utils.fts;

import android.util.Pair;

public class SQLiteFTSUtils$MsgSearchContactInfo
{
  public String a;
  public int b;
  public Pair<CharSequence, CharSequence> c;
  
  public SQLiteFTSUtils$MsgSearchContactInfo(String paramString, int paramInt, Pair<CharSequence, CharSequence> paramPair)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramPair;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("MsgSearchContactInfo{uin='");
    localStringBuilder1.append(this.a);
    localStringBuilder1.append('\'');
    localStringBuilder1.append(", uinType=");
    localStringBuilder1.append(this.b);
    localStringBuilder1.append(", matchTitle=[");
    Object localObject2 = this.c;
    Object localObject1 = "null";
    if (localObject2 != null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      if (this.c.first == null) {
        localObject2 = "null";
      } else {
        localObject2 = (CharSequence)this.c.first;
      }
      localStringBuilder2.append(localObject2);
      localStringBuilder2.append(", ");
      if (this.c.second != null) {
        localObject1 = (CharSequence)this.c.second;
      }
      localStringBuilder2.append(localObject1);
      localObject1 = localStringBuilder2.toString();
    }
    localStringBuilder1.append((String)localObject1);
    localStringBuilder1.append("]");
    localStringBuilder1.append('}');
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.MsgSearchContactInfo
 * JD-Core Version:    0.7.0.1
 */