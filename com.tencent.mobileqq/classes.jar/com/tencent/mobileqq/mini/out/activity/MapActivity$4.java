package com.tencent.mobileqq.mini.out.activity;

import android.widget.TextView;
import java.util.List;

class MapActivity$4
  implements Runnable
{
  MapActivity$4(MapActivity paramMapActivity, List paramList, int paramInt) {}
  
  public void run()
  {
    int i = 0;
    Object localObject = this.this$0.poiAdapter;
    List localList = this.val$poiList;
    boolean bool;
    if (this.val$next > 0)
    {
      bool = true;
      ((POIAdapter)localObject).addPoiList(localList, bool);
      localObject = this.this$0.noResultView;
      if (this.this$0.poiAdapter.getCount() >= 1) {
        break label65;
      }
    }
    for (;;)
    {
      ((TextView)localObject).setVisibility(i);
      return;
      bool = false;
      break;
      label65:
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.MapActivity.4
 * JD-Core Version:    0.7.0.1
 */