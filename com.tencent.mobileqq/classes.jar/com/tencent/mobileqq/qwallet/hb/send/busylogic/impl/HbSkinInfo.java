package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import Wallet.SkinInfo;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HbSkinInfo
{
  public static int d = 0;
  public static boolean e = false;
  public int a = -1;
  public int b = 0;
  public String c = "";
  public SkinInfo f = new SkinInfo();
  public RedPacketInfoBase g = new RedPacketInfoBase();
  public String h = "";
  
  public HbSkinInfo(SkinInfo paramSkinInfo)
  {
    this.c = paramSkinInfo.skin_name;
    this.f = paramSkinInfo;
  }
  
  public HbSkinInfo(String paramString)
  {
    this.c = paramString;
  }
  
  public static void a(List<HbSkinInfo> paramList)
  {
    Collections.sort(paramList, new HbSkinInfo.1());
  }
  
  public static int b(List<HbSkinInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      HbSkinInfo localHbSkinInfo = (HbSkinInfo)paramList.next();
      if (d == localHbSkinInfo.f.skin_id) {
        return localHbSkinInfo.f.skin_id;
      }
    }
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof HbSkinInfo)) {
      return this.f.skin_id == ((HbSkinInfo)paramObject).f.skin_id;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("background : ");
    localStringBuilder.append(this.g.background);
    localStringBuilder.append(" | ");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("icon : ");
    localStringBuilder.append(this.g.icon);
    localStringBuilder.append(" | ");
    localStringBuffer.append(localStringBuilder.toString());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinInfo
 * JD-Core Version:    0.7.0.1
 */