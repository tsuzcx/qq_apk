package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="md5")
public class HotPicSendData
  extends HotPicData
  implements Comparable<HotPicSendData>
{
  public long sendTime;
  
  public static HotPicSendData build(HotPicData paramHotPicData)
  {
    HotPicSendData localHotPicSendData = new HotPicSendData();
    localHotPicSendData.md5 = paramHotPicData.md5;
    localHotPicSendData.fileType = paramHotPicData.fileType;
    localHotPicSendData.fileSize = paramHotPicData.fileSize;
    localHotPicSendData.width = paramHotPicData.width;
    localHotPicSendData.height = paramHotPicData.height;
    localHotPicSendData.url = paramHotPicData.url;
    localHotPicSendData.picIndex = paramHotPicData.picIndex;
    localHotPicSendData.sourceType = paramHotPicData.sourceType;
    localHotPicSendData.appid = paramHotPicData.appid;
    localHotPicSendData.iconUrl = paramHotPicData.iconUrl;
    localHotPicSendData.name = paramHotPicData.name;
    localHotPicSendData.filePath = paramHotPicData.filePath;
    localHotPicSendData.version = paramHotPicData.version;
    localHotPicSendData.originalMD5 = paramHotPicData.originalMD5;
    localHotPicSendData.oringinalSize = paramHotPicData.oringinalSize;
    localHotPicSendData.originalWidth = paramHotPicData.originalWidth;
    localHotPicSendData.originalHeight = paramHotPicData.originalHeight;
    localHotPicSendData.originalUrl = paramHotPicData.originalUrl;
    localHotPicSendData.tag = -20;
    return localHotPicSendData;
  }
  
  public int compareTo(HotPicSendData paramHotPicSendData)
  {
    if (this.sendTime > paramHotPicSendData.sendTime) {
      return 1;
    }
    if (this.sendTime == paramHotPicSendData.sendTime) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicSendData
 * JD-Core Version:    0.7.0.1
 */