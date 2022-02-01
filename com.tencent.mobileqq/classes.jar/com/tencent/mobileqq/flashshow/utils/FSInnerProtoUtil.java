package com.tencent.mobileqq.flashshow.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qflash.QFlashBadge.QFlashBadgeInfo;

public class FSInnerProtoUtil
{
  public static List<QFlashBadge.QFlashBadgeInfo> a(List<byte[]> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (byte[])paramList.next();
      if (localObject != null)
      {
        localObject = a((byte[])localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public static QFlashBadge.QFlashBadgeInfo a(byte[] paramArrayOfByte)
  {
    QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = new QFlashBadge.QFlashBadgeInfo();
    try
    {
      paramArrayOfByte = (QFlashBadge.QFlashBadgeInfo)localQFlashBadgeInfo.mergeFrom(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localQFlashBadgeInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSInnerProtoUtil
 * JD-Core Version:    0.7.0.1
 */