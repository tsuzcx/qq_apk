package com.tencent.qapmsdk.bigbitmap.datainfo;

import android.support.annotation.NonNull;
import com.tencent.qapmsdk.base.reporter.uploaddata.IMetaData;
import com.tencent.qapmsdk.common.util.Objects;
import java.util.Arrays;

public class ExceedBitmapInfo
  implements IMetaData
{
  public static final int SHOW_TYPE_BACKGROUND = 0;
  public static final int SHOW_TYPE_SOURCE = 1;
  public static final int SHOW_TYPE_UNKNOWN = -1;
  private String activityName;
  private long allocatedByteSize;
  private int bitmapHeight;
  private int bitmapWidth;
  private int showType;
  private long timestamp;
  public String url;
  private String viewChain;
  private int viewHeight;
  private String viewName;
  private int viewWidth;
  
  public ExceedBitmapInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, String paramString4, long paramLong2)
  {
    this.activityName = paramString1;
    this.viewName = paramString2;
    this.viewChain = paramString3;
    this.viewWidth = paramInt1;
    this.viewHeight = paramInt2;
    this.bitmapWidth = paramInt3;
    this.bitmapHeight = paramInt4;
    this.showType = paramInt5;
    this.allocatedByteSize = paramLong1;
    this.url = paramString4;
    this.timestamp = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ExceedBitmapInfo)paramObject;
      return (this.viewWidth == paramObject.viewWidth) && (this.viewHeight == paramObject.viewHeight) && (this.bitmapWidth == paramObject.bitmapWidth) && (this.bitmapHeight == paramObject.bitmapHeight) && (this.showType == paramObject.showType) && (Objects.equals(this.activityName, paramObject.activityName)) && (Objects.equals(this.viewChain, paramObject.viewChain)) && (Objects.equals(this.url, paramObject.url));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.activityName, this.viewChain, Integer.valueOf(this.viewWidth), Integer.valueOf(this.viewHeight), Integer.valueOf(this.bitmapWidth), Integer.valueOf(this.bitmapHeight), Integer.valueOf(this.showType), this.url });
  }
  
  @NonNull
  public String metaSerialize()
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append(this.timestamp);
    localStringBuffer.append(",");
    localStringBuffer.append(this.activityName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.bitmapWidth);
    localStringBuffer.append(",");
    localStringBuffer.append(this.bitmapHeight);
    localStringBuffer.append(",");
    localStringBuffer.append(this.viewWidth);
    localStringBuffer.append(",");
    localStringBuffer.append(this.viewHeight);
    localStringBuffer.append(",");
    localStringBuffer.append(this.viewChain);
    localStringBuffer.append(",");
    localStringBuffer.append(this.viewName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.showType);
    localStringBuffer.append(",");
    localStringBuffer.append(this.allocatedByteSize);
    localStringBuffer.append(",");
    localStringBuffer.append(this.url);
    localStringBuffer.append("\r\n");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.datainfo.ExceedBitmapInfo
 * JD-Core Version:    0.7.0.1
 */