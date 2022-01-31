package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcMsgPush
  extends JceStruct
{
  static ArrayList cache_vecMsgInfos;
  public byte cMore = 0;
  public int iUnread = 0;
  public ArrayList vecMsgInfos = null;
  
  public SvcMsgPush() {}
  
  public SvcMsgPush(byte paramByte, int paramInt, ArrayList paramArrayList)
  {
    this.cMore = paramByte;
    this.iUnread = paramInt;
    this.vecMsgInfos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cMore = paramJceInputStream.read(this.cMore, 0, true);
    this.iUnread = paramJceInputStream.read(this.iUnread, 1, true);
    if (cache_vecMsgInfos == null)
    {
      cache_vecMsgInfos = new ArrayList();
      SvcMsgInfo localSvcMsgInfo = new SvcMsgInfo();
      cache_vecMsgInfos.add(localSvcMsgInfo);
    }
    this.vecMsgInfos = ((ArrayList)paramJceInputStream.read(cache_vecMsgInfos, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cMore, 0);
    paramJceOutputStream.write(this.iUnread, 1);
    paramJceOutputStream.write(this.vecMsgInfos, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.SvcMsgPush
 * JD-Core Version:    0.7.0.1
 */