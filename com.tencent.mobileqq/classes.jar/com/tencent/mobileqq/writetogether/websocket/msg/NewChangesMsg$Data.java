package com.tencent.mobileqq.writetogether.websocket.msg;

import com.tencent.mobileqq.easysync2.AttribPool;

public class NewChangesMsg$Data
  implements Comparable<Data>
{
  public AttribPool apool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.NewChangesMsg.Data
 * JD-Core Version:    0.7.0.1
 */