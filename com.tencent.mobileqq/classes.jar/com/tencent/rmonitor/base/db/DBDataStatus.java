package com.tencent.rmonitor.base.db;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/db/DBDataStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TO_SEND", "SENT", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public enum DBDataStatus
{
  private final int value;
  
  static
  {
    DBDataStatus localDBDataStatus1 = new DBDataStatus("TO_SEND", 0, 1);
    TO_SEND = localDBDataStatus1;
    DBDataStatus localDBDataStatus2 = new DBDataStatus("SENT", 1, 2);
    SENT = localDBDataStatus2;
    $VALUES = new DBDataStatus[] { localDBDataStatus1, localDBDataStatus2 };
  }
  
  private DBDataStatus(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.db.DBDataStatus
 * JD-Core Version:    0.7.0.1
 */