package com.tencent.weiyun.poi;

import com.tencent.weiyun.data.PoiItem;
import java.util.List;

public abstract interface PoiManager$IFetchPoiListener
{
  public abstract void onError(int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void onSuccess(List<PoiItem> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.poi.PoiManager.IFetchPoiListener
 * JD-Core Version:    0.7.0.1
 */