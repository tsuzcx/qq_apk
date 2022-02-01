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
    if (this.val$listener != null) {
      this.val$listener.onError(paramInt, paramString, this.val$reqCompleted);
    }
  }
  
  public void onSuccess(List<PoiItem> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList(0);
    }
    if (!((List)localObject).isEmpty())
    {
      int j = this.val$singleReq.length;
      paramList = ((List)localObject).iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        PoiItem localPoiItem1 = (PoiItem)paramList.next();
        if (i < j)
        {
          PoiItem localPoiItem2 = this.val$singleReq[i];
          localPoiItem1.longitude = localPoiItem2.longitude;
          localPoiItem1.latitude = localPoiItem2.latitude;
          i += 1;
        }
        for (;;)
        {
          break;
          paramList.remove();
          WyLog.w("PoiManager", "fetchPOI: server respond error.");
        }
      }
    }
    paramList = new ArrayList((Collection)localObject);
    if (this.val$listener != null) {
      this.val$listener.onSuccess((List)localObject, this.val$reqCompleted);
    }
    Collections.sort(paramList, PoiManager.access$100(this.this$0));
    PoiHelper.insertPoi(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.poi.PoiManager.3
 * JD-Core Version:    0.7.0.1
 */