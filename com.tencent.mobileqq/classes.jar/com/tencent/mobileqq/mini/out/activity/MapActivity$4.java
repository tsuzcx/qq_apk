package com.tencent.mobileqq.mini.out.activity;

import android.widget.TextView;
import java.util.List;

class MapActivity$4
  implements Runnable
{
  MapActivity$4(MapActivity paramMapActivity, List paramList, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0.poiAdapter;
    List localList = this.val$poiList;
    int j = this.val$next;
    int i = 0;
    boolean bool;
    if (j > 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((POIAdapter)localObject).addPoiList(localList, bool);
    localObject = this.this$0.noResultView;
    if (this.this$0.poiAdapter.getCount() >= 1) {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.MapActivity.4
 * JD-Core Version:    0.7.0.1
 */