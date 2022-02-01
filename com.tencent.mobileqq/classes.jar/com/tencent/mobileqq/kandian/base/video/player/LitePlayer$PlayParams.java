package com.tencent.mobileqq.kandian.base.video.player;

import org.jetbrains.annotations.NotNull;

class LitePlayer$PlayParams
{
  String a;
  String b;
  int c;
  long d;
  int e;
  
  LitePlayer$PlayParams(LitePlayer paramLitePlayer, String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramLong;
    this.e = paramInt2;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayParams{vid='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", playType=");
    String str;
    if (this.c == 101) {
      str = "VOD";
    } else {
      str = "LIVE";
    }
    localStringBuilder.append(str);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.LitePlayer.PlayParams
 * JD-Core Version:    0.7.0.1
 */