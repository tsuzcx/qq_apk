package com.tencent.mobileqq.flutter.channel.model;

import com.tencent.mobileqq.flutter.utils.ModelUtils;
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
    return (CardCoverData)ModelUtils.a(paramMap, CardCoverData.class);
  }
  
  public static Map toMap(CardCoverData paramCardCoverData)
  {
    return ModelUtils.a(paramCardCoverData);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CardCoverData{type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", text='");
    String str2 = this.text;
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.model.CardCoverData
 * JD-Core Version:    0.7.0.1
 */