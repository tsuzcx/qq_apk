package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;

public class ImportantMsgInfo
  extends ShortcutBarInfo
{
  private String a;
  private long b;
  private long c;
  
  public ImportantMsgInfo()
  {
    super(0L, "", "", 0);
    this.b = 0L;
    this.a = "";
  }
  
  public ImportantMsgInfo(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, long paramLong3, int paramInt)
  {
    super(paramLong3, paramString1, paramString2, paramInt);
    this.b = paramLong2;
    this.a = paramString3;
    this.c = paramLong1;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public void b(long paramLong)
  {
    this.b = paramLong;
  }
  
  public int c()
  {
    return 1;
  }
  
  public void c(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void c(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgInfo
 * JD-Core Version:    0.7.0.1
 */