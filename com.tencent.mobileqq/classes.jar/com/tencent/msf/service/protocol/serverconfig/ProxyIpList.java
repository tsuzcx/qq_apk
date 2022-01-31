package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ProxyIpList
  extends JceStruct
{
  static ArrayList cache_vIplist;
  public long uService_type = 0L;
  public ArrayList vIplist = null;
  
  public ProxyIpList() {}
  
  public ProxyIpList(long paramLong, ArrayList paramArrayList)
  {
    this.uService_type = paramLong;
    this.vIplist = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uService_type = paramJceInputStream.read(this.uService_type, 0, true);
    if (cache_vIplist == null)
    {
      cache_vIplist = new ArrayList();
      ProxyIpInfo localProxyIpInfo = new ProxyIpInfo();
      cache_vIplist.add(localProxyIpInfo);
    }
    this.vIplist = ((ArrayList)paramJceInputStream.read(cache_vIplist, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uService_type, 0);
    paramJceOutputStream.write(this.vIplist, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.ProxyIpList
 * JD-Core Version:    0.7.0.1
 */