package com.tencent.ttpic.openapi.model;

public class WMEditItem
{
  public static int ITEM_TYPE_COUNTDOWN = 3;
  public static int ITEM_TYPE_SINCE;
  public static int ITEM_TYPE_TEXT = 1;
  public int itemType;
  public String value;
  
  static
  {
    ITEM_TYPE_SINCE = 2;
  }
  
  public WMEditItem(String paramString, int paramInt)
  {
    this.value = paramString;
    this.itemType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.WMEditItem
 * JD-Core Version:    0.7.0.1
 */