package com.tencent.weiyun.poi;

import com.tencent.weiyun.callback.FetchPOICallback;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.WyLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class PoiManager$3
  extends FetchPOICallback
{
  PoiManager$3(PoiManager paramPoiManager, PoiItem[] paramArrayOfPoiItem, PoiManager.IFetchPoiListener paramIFetchPoiListener, boolean paramBoolean) {}
  
  public void onError(int paramInt, String paramString)
  {
    PoiManager.IFetchPoiListener localIFetchPoiListener = this.val$listener;
    if (localIFetchPoiListener != null) {
      localIFetchPoiListener.onError(paramInt, paramString, this.val$reqCompleted);
    }
  }
  
  public void onSuccess(List<PoiItem> paramList)
  {
    int i = 0;
    Object localObject1 = paramList;
    if (paramList == null) {
      localObject1 = new ArrayList(0);
    }
    if (!((List)localObject1).isEmpty())
    {
      int j = this.val$singleReq.length;
      paramList = ((List)localObject1).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (PoiItem)paramList.next();
        if (i < j)
        {
          PoiItem localPoiItem = this.val$singleReq[i];
          ((PoiItem)localObject2).longitude = localPoiItem.longitude;
          ((PoiItem)localObject2).latitude = localPoiItem.latitude;
          i += 1;
        }
        else
        {
          paramList.remove();
          WyLog.w("PoiManager", "fetchPOI: server respond error.");
        }
      }
    }
    paramList = new ArrayList((Collection)localObject1);
    Object localObject2 = this.val$listener;
    if (localObject2 != null) {
      ((PoiManager.IFetchPoiListener)localObject2).onSuccess((List)localObject1, this.val$reqCompleted);
    }
    Collections.sort(paramList, PoiManager.access$100(this.this$0));
    PoiHelper.insertPoi(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.poi.PoiManager.3
 * JD-Core Version:    0.7.0.1
 */