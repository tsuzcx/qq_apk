package com.tencent.smtt.sdk;

public enum TbsLogReport$EventType
{
  int a;
  
  static
  {
    TYPE_DOWNLOAD_DECOUPLE = new EventType("TYPE_DOWNLOAD_DECOUPLE", 3, 3);
    TYPE_INSTALL_DECOUPLE = new EventType("TYPE_INSTALL_DECOUPLE", 4, 4);
  }
  
  private TbsLogReport$EventType(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.EventType
 * JD-Core Version:    0.7.0.1
 */