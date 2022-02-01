package com.tencent.mobileqq.nearby.profilecard;

import android.annotation.TargetApi;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
class NearbyProfileEditPanel$OnPicDragListener
  implements View.OnDragListener
{
  private int b;
  
  public NearbyProfileEditPanel$OnPicDragListener(NearbyProfileEditPanel paramNearbyProfileEditPanel, int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    int i = paramDragEvent.getAction();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4) {
          return true;
        }
        this.a.i.post(new NearbyProfileEditPanel.OnPicDragListener.1(this));
        return true;
      }
      RelativeLayout localRelativeLayout = NearbyProfileEditPanel.h(this.a);
      i = this.a.i.indexOfChild(paramView);
      int j = this.a.i.indexOfChild(localRelativeLayout);
      if ((i != -1) && (j != -1) && (((i > j) && (paramDragEvent.getX() > this.b / 2)) || ((i < j) && (paramDragEvent.getX() < this.b / 2))))
      {
        try
        {
          this.a.i.removeView(localRelativeLayout);
          this.a.i.addView(localRelativeLayout, i);
          this.a.o();
          return true;
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            break label216;
          }
        }
        paramDragEvent = new StringBuilder();
        paramDragEvent.append("drag between small pics exception");
        paramDragEvent.append(paramView.getMessage());
        QLog.d("Q.nearby_people_card.", 2, paramDragEvent.toString());
        return true;
      }
    }
    else
    {
      QLog.d("onDrag", 4, "ACTION_DRAG_STARTED");
    }
    label216:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.OnPicDragListener
 * JD-Core Version:    0.7.0.1
 */