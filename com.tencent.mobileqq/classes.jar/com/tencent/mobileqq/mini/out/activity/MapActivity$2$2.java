package com.tencent.mobileqq.mini.out.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MapActivity$2$2
  implements DialogInterface.OnClickListener
{
  MapActivity$2$2(MapActivity.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.this$1.this$0;
    boolean bool;
    if (this.this$1.this$0.type == 2) {
      bool = true;
    } else {
      bool = false;
    }
    MapActivity.access$300(paramDialogInterface, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.MapActivity.2.2
 * JD-Core Version:    0.7.0.1
 */