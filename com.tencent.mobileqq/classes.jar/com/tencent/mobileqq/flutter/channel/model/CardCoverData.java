package com.tencent.mobileqq.flutter.channel.model;

import aupm;
import java.util.Map;

public class CardCoverData
{
  public static final int TYPE_DEFAULT = 3;
  public static final int TYPE_FILEPATH = 2;
  public static final int TYPE_URL = 1;
  public String text;
  public Integer type;
  
  public CardCoverData(int paramInt, String paramString)
  {
    this.type = Integer.valueOf(paramInt);
    this.text = paramString;
  }
  
  public static CardCoverData fromMap(Map paramMap)
  {
    return (CardCoverData)aupm.a(paramMap, CardCoverData.class);
  }
  
  public static Map toMap(CardCoverData paramCardCoverData)
  {
    return aupm.a(paramCardCoverData);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("CardCoverData{type=").append(this.type).append(", text='");
    if (this.text == null) {}
    for (String str = "null";; str = this.text) {
      return str + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.model.CardCoverData
 * JD-Core Version:    0.7.0.1
 */