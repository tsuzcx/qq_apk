package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;

public class ImportantMsgInfo
  extends ShortcutBarInfo
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  
  public ImportantMsgInfo()
  {
    super(0L, "", "", 0);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public ImportantMsgInfo(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, long paramLong3, int paramInt)
  {
    super(paramLong3, paramString1, paramString2, paramInt);
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString3;
    this.b = paramLong1;
  }
  
  public int a()
  {
    return 1;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void c(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgInfo
 * JD-Core Version:    0.7.0.1
 */