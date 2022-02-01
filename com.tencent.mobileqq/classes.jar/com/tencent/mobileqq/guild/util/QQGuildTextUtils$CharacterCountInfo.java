package com.tencent.mobileqq.guild.util;

public class QQGuildTextUtils$CharacterCountInfo
{
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  
  QQGuildTextUtils$CharacterCountInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramInt4;
    this.c = paramInt3;
  }
  
  public int a()
  {
    return this.a + this.b + this.d + (this.c + 1) / 2;
  }
  
  public float b()
  {
    return this.a + this.b + this.d + this.c / 2.0F;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CharacterCountInfo{emojiCount=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", emoticonCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", asciiCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", textCount=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildTextUtils.CharacterCountInfo
 * JD-Core Version:    0.7.0.1
 */