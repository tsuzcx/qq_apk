package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

public class ImportantMsgEntryConfig$EntryConfig
{
  public String a;
  public long b;
  public int c;
  public String d;
  
  public ImportantMsgEntryConfig$EntryConfig()
  {
    this.a = "";
    this.b = -1L;
    this.c = -1;
    this.d = "";
  }
  
  public ImportantMsgEntryConfig$EntryConfig(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    this.a = paramString1;
    this.b = paramLong;
    this.c = paramInt;
    this.d = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("iconUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", appid");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", titleType");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", defTitle");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgEntryConfig.EntryConfig
 * JD-Core Version:    0.7.0.1
 */