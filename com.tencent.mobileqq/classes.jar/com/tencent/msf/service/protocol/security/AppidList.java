package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AppidList
  extends JceStruct
{
  static ArrayList cache_AppidVector;
  public ArrayList AppidVector = null;
  public long nReserved = 0L;
  
  public AppidList() {}
  
  public AppidList(long paramLong, ArrayList paramArrayList)
  {
    this.nReserved = paramLong;
    this.AppidVector = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nReserved = paramJceInputStream.read(this.nReserved, 0, true);
    if (cache_AppidVector == null)
    {
      cache_AppidVector = new ArrayList();
      cache_AppidVector.add(Long.valueOf(0L));
    }
    this.AppidVector = ((ArrayList)paramJceInputStream.read(cache_AppidVector, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nReserved, 0);
    paramJceOutputStream.write(this.AppidVector, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.AppidList
 * JD-Core Version:    0.7.0.1
 */