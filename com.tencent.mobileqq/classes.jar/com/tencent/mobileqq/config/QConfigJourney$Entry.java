package com.tencent.mobileqq.config;

final class QConfigJourney$Entry
{
  public int a;
  public String b;
  public long c;
  public String d;
  private final String e;
  
  public QConfigJourney$Entry(int paramInt, String paramString1, long paramLong, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramLong;
    this.d = paramString2;
    paramString1 = new StringBuilder();
    paramString1.append(this.a);
    paramString1.append("-");
    paramString1.append(this.b);
    paramString1.append("-");
    paramString1.append(this.c);
    this.e = paramString1.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Entry;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Entry)paramObject;
    bool1 = bool2;
    if (this.a == paramObject.a)
    {
      bool1 = bool2;
      if (this.b.equals(paramObject.b))
      {
        bool1 = bool2;
        if (this.c == paramObject.c) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.e.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Entry{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", key='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigJourney.Entry
 * JD-Core Version:    0.7.0.1
 */