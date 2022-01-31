package com.tencent.mobileqq.data;

import atmo;
import atnz;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Timer;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="time,msgid")
public class PrinterItemMsgRecord
  extends MessageRecord
  implements Cloneable
{
  public static final String sTagleName = "mr_dataline_printer";
  public static final int status_New = 1;
  public static final int status_print_fail = 11;
  public static final int status_print_suc = 10;
  public static final int status_running = 2;
  public static final int status_transfer_fail = 12;
  public String filename;
  @atnz
  public Timer mTimer_for_Print;
  public double progress;
  public int status = 1;
  public long uSessionID;
  
  public PrinterItemMsgRecord()
  {
    this.versionCode = 0;
  }
  
  public PrinterItemMsgRecord(long paramLong)
  {
    this.versionCode = 0;
    this.msgId = paramLong;
  }
  
  public static String tableName()
  {
    return "mr_dataline_printer";
  }
  
  public PrinterItemMsgRecord clone()
  {
    try
    {
      PrinterItemMsgRecord localPrinterItemMsgRecord = (PrinterItemMsgRecord)super.clone();
      return localPrinterItemMsgRecord;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public Class<? extends atmo> getClassForTable()
  {
    return PrinterItemMsgRecord.class;
  }
  
  public String getTableName()
  {
    return "mr_dataline_printer";
  }
  
  public void postRead() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.PrinterItemMsgRecord
 * JD-Core Version:    0.7.0.1
 */