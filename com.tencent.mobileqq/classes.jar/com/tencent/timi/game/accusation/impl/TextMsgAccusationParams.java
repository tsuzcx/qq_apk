package com.tencent.timi.game.accusation.impl;

import android.text.TextUtils;

public class TextMsgAccusationParams
  extends AccusationParams
{
  public String t = "";
  public String u = "";
  
  public TextMsgAccusationParams(String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      this.t = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      this.u = paramString3;
    }
    a();
  }
  
  private void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("roomID=");
    localStringBuilder.append(this.t);
    localStringBuilder.append("|msgID=");
    localStringBuilder.append(this.u);
    this.j = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.accusation.impl.TextMsgAccusationParams
 * JD-Core Version:    0.7.0.1
 */