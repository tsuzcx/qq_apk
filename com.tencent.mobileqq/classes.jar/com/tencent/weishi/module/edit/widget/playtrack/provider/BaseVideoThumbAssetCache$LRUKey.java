package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.text.TextUtils;
import java.util.Objects;

public class BaseVideoThumbAssetCache$LRUKey
{
  public String assetId;
  public long time;
  
  public BaseVideoThumbAssetCache$LRUKey(String paramString, long paramLong)
  {
    this.assetId = paramString;
    this.time = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (LRUKey)paramObject;
    } while ((this.time == paramObject.time) && (TextUtils.equals(this.assetId, paramObject.assetId)));
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.assetId, Long.valueOf(this.time) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache.LRUKey
 * JD-Core Version:    0.7.0.1
 */