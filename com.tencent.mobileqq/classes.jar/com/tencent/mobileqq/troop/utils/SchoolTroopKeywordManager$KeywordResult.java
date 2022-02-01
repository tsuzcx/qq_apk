package com.tencent.mobileqq.troop.utils;

public class SchoolTroopKeywordManager$KeywordResult
{
  public long a;
  public String b;
  public int c;
  public int d;
  public String e;
  public int f;
  public int g;
  public boolean h = false;
  private String i;
  
  public String a()
  {
    int j = this.c;
    if ((j & 0x4) == 4) {
      return "classteacher";
    }
    if ((j & 0x8) == 8) {
      return "teacher";
    }
    if ((j & 0x1) == 1) {
      return "owner";
    }
    if ((j & 0x2) == 2) {
      return "admin";
    }
    return "other";
  }
  
  public void a(String paramString)
  {
    this.i = SchoolTroopKeywordManager.a(paramString, "").trim().replaceAll("\\s+", " ");
  }
  
  public String b()
  {
    return this.i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeywordResult{msgId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", troopUin='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", userRole=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", action=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", keyword='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", startPos=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", endPos=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", content=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.KeywordResult
 * JD-Core Version:    0.7.0.1
 */