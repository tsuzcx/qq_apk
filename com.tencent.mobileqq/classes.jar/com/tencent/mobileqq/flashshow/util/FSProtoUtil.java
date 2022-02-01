package com.tencent.mobileqq.flashshow.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qflash.QFlashBadge.QFlashBadgeInfo;

public class FSProtoUtil
{
  public static List<byte[]> a(List<QFlashBadge.QFlashBadgeInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((QFlashBadge.QFlashBadgeInfo)paramList.next()).toByteArray());
    }
    return localArrayList;
  }
  
  public static QFlashBadge.QFlashBadgeInfo a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = (QFlashBadge.QFlashBadgeInfo)new QFlashBadge.QFlashBadgeInfo().mergeFrom(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.util.FSProtoUtil
 * JD-Core Version:    0.7.0.1
 */