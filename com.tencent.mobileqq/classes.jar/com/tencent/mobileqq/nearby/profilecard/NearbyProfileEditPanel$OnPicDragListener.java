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
  private int jdField_a_of_type_Int;
  
  public NearbyProfileEditPanel$OnPicDragListener(NearbyProfileEditPanel paramNearbyProfileEditPanel, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a.post(new NearbyProfileEditPanel.OnPicDragListener.1(this));
        return true;
      }
      RelativeLayout localRelativeLayout = NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
      i = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a.indexOfChild(paramView);
      int j = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a.indexOfChild(localRelativeLayout);
      if ((i != -1) && (j != -1) && (((i > j) && (paramDragEvent.getX() > this.jdField_a_of_type_Int / 2)) || ((i < j) && (paramDragEvent.getX() < this.jdField_a_of_type_Int / 2))))
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a.removeView(localRelativeLayout);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a.addView(localRelativeLayout, i);
          NearbyProfileEditPanel.e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.OnPicDragListener
 * JD-Core Version:    0.7.0.1
 */