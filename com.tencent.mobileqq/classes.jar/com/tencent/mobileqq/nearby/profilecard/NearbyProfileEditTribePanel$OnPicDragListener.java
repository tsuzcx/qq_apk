package com.tencent.mobileqq.nearby.profilecard;

import android.annotation.TargetApi;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
class NearbyProfileEditTribePanel$OnPicDragListener
  implements View.OnDragListener
{
  private int b;
  
  public NearbyProfileEditTribePanel$OnPicDragListener(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel, int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    if (paramDragEvent.getAction() != 1) {
      return true;
    }
    QLog.d("onDrag", 4, "ACTION_DRAG_STARTED");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.OnPicDragListener
 * JD-Core Version:    0.7.0.1
 */