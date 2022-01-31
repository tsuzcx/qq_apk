package com.tencent.weiyun.callback;

import com.tencent.weiyun.data.CBundleReader;
import com.tencent.weiyun.data.PoiItem;
import java.util.ArrayList;
import java.util.List;

public abstract class FetchPOICallback
  extends WeiyunCallback
{
  public abstract void onError(int paramInt, String paramString);
  
  protected void onNativeCallback(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (paramInt2 == 0)
    {
      if (paramLong == 0L)
      {
        onSuccess(new ArrayList(0));
        return;
      }
      paramString = CBundleReader.getLongArray(paramLong, "poi_list");
      CBundleReader.deleteBundle(paramLong);
      if (paramString == null) {}
      ArrayList localArrayList;
      for (paramInt1 = 0;; paramInt1 = paramString.length)
      {
        localArrayList = new ArrayList(paramInt1);
        if (paramString == null) {
          break;
        }
        paramInt2 = paramString.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          paramLong = paramString[paramInt1];
          if (paramLong != 0L)
          {
            PoiItem localPoiItem = PoiItem.newInstance(paramLong);
            if (localPoiItem != null) {
              localArrayList.add(localPoiItem);
            }
          }
          paramInt1 += 1;
        }
      }
      onSuccess(localArrayList);
      return;
    }
    onError(paramInt2, paramString);
  }
  
  public abstract void onSuccess(List<PoiItem> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.callback.FetchPOICallback
 * JD-Core Version:    0.7.0.1
 */