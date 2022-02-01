package com.tencent.mobileqq.highway.config;

import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.OpenUpConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.PTVConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class HwConfig
  implements Serializable, Cloneable
{
  public static final int NET_TYPE_2G = 2;
  public static final int NET_TYPE_3G = 3;
  public static final int NET_TYPE_4G = 4;
  public static final int NET_TYPE_DEFAULT = 0;
  public static final int NET_TYPE_WIFI = 1;
  private static final long serialVersionUID = 2113693234079222598L;
  public PBUInt32Field bdhIpv6Policy = null;
  public PBUInt32Field connAttemptDelay = null;
  public subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf dtConf = null;
  public PBUInt32Field fmtIpv6Policy = null;
  public subcmd0x501.SubCmd0x501Rspbody.IpLearnConf ipConf = null;
  public ArrayList<EndPoint> ipList;
  public ArrayList<EndPoint> ipv6List;
  public ArrayList<HwNetSegConf> netSegConfList;
  public subcmd0x501.SubCmd0x501Rspbody.OpenUpConf openUpConf = null;
  public subcmd0x501.SubCmd0x501Rspbody.PTVConf ptvCof = null;
  public ArrayList<HwNetSegConf> shortVideoSegConfList;
  public subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf videoConf = null;
  
  public HwConfig clone()
  {
    HwConfig localHwConfig = (HwConfig)super.clone();
    localHwConfig.ipList = new ArrayList();
    Iterator localIterator = this.ipList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (EndPoint)localIterator.next();
      localHwConfig.ipList.add(((EndPoint)localObject).clone());
    }
    localHwConfig.ipv6List = new ArrayList();
    localIterator = this.ipv6List.iterator();
    while (localIterator.hasNext())
    {
      localObject = (EndPoint)localIterator.next();
      localHwConfig.ipv6List.add(((EndPoint)localObject).clone());
    }
    localHwConfig.netSegConfList = new ArrayList();
    localIterator = this.netSegConfList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (HwNetSegConf)localIterator.next();
      localHwConfig.netSegConfList.add(((HwNetSegConf)localObject).clone());
    }
    localHwConfig.shortVideoSegConfList = new ArrayList();
    localIterator = this.shortVideoSegConfList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (HwNetSegConf)localIterator.next();
      localHwConfig.shortVideoSegConfList.add(((HwNetSegConf)localObject).clone());
    }
    return localHwConfig;
  }
  
  public String ipList2String()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("IP= ");
    Object localObject1 = this.ipList;
    Object localObject2;
    StringBuilder localStringBuilder2;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = this.ipList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EndPoint)((Iterator)localObject1).next();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(((EndPoint)localObject2).toString());
        localStringBuilder2.append("  ");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
    }
    localStringBuilder1.append("IPv6= ");
    localObject1 = this.ipv6List;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = this.ipv6List.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EndPoint)((Iterator)localObject1).next();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(((EndPoint)localObject2).toString());
        localStringBuilder2.append("  ");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
    }
    localStringBuilder1.append("   Segment Info= ");
    localObject1 = this.netSegConfList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (HwNetSegConf)((Iterator)localObject1).next();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" NetType= ");
      localStringBuilder2.append(((HwNetSegConf)localObject2).netType);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" SegSize= ");
      localStringBuilder2.append(((HwNetSegConf)localObject2).segSize);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" SegNum= ");
      localStringBuilder2.append(((HwNetSegConf)localObject2).segNum);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" CommNUm= ");
      localStringBuilder2.append(((HwNetSegConf)localObject2).curConnNum);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.HwConfig
 * JD-Core Version:    0.7.0.1
 */