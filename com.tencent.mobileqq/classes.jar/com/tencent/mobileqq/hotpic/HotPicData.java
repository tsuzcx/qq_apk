package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="url,tag,picIndex")
public class HotPicData
  extends Entity
{
  public static final int DATA_GIF = 1;
  public static final int DATA_VIDEO = 2;
  public static final String HOT_PIC_HAS_EXTRA = "HOT_PIC_HAS_EXTRA";
  public static final String HOT_PIC_TRANS_FILESIZE = "HOT_PIC_TRANS_FILESIZE";
  public static final String HOT_PIC_TRANS_MD5 = "HOT_PIC_TRANS_MD5";
  public static final String HOT_PIC_TRANS_THUMB_MD5 = "HOT_PIC_TRANS_THUMB_MD5";
  public String appid;
  public String filePath;
  public long fileSize;
  public int fileType;
  public int height;
  public String iconUrl;
  public String jumpUrl;
  public String md5;
  public String name;
  public int originalHeight;
  public String originalMD5;
  public String originalUrl;
  public int originalWidth;
  public long oringinalSize;
  public int picIndex;
  public int sourceType;
  public int tag;
  public String url;
  public int version;
  public int width;
  
  public int getDataType()
  {
    return 1;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("hotpic:");
    localStringBuffer.append(this.version).append(',').append(this.picIndex).append(",").append(this.tag).append(",").append(this.sourceType).append(",");
    localStringBuffer.append(this.url).append(',').append(this.md5).append(',').append(this.width).append('x').append(this.height);
    localStringBuffer.append(this.originalUrl).append(',').append(this.originalMD5).append(',').append(this.originalWidth).append('x').append(this.originalHeight);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicData
 * JD-Core Version:    0.7.0.1
 */