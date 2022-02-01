package com.tencent.mobileqq.together.writetogether.websocket.msg;

import beli;

public class NewChangesMsg$Data
  implements Comparable<Data>
{
  public beli apool;
  public String author;
  public String changeset;
  public long commitId;
  public boolean head;
  public boolean need;
  public int newRev;
  public boolean revert;
  public String subId;
  public String uuId;
  
  public int compareTo(Data paramData)
  {
    return this.newRev - paramData.newRev;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.NewChangesMsg.Data
 * JD-Core Version:    0.7.0.1
 */