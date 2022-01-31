package com.tencent.mobileqq.nearby.gameroom;

import android.widget.LinearLayout;
import atdd;
import atde;
import aten;
import axqy;
import java.util.Iterator;
import java.util.List;

public class GameRoomInviteActivity$21$1$1
  implements Runnable
{
  public GameRoomInviteActivity$21$1$1(atde paramatde, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Atde.a.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Atde.a.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Boolean);
    int j;
    int i;
    aten localaten;
    int k;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      j = 0;
      i = 0;
      if (localIterator.hasNext())
      {
        localaten = (aten)localIterator.next();
        if (localaten.a == 1)
        {
          k = j;
          j = i + 1;
          i = k;
        }
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break;
      if (localaten.a == 0)
      {
        k = j + 1;
        j = i;
        i = k;
        continue;
        axqy.b(this.jdField_a_of_type_Atde.a.a.app, "dc00899", "Grp_wolf", "", "invite_page", "exp_invite", 0, 0, "" + i, "" + j, "", "");
        if (this.jdField_a_of_type_Boolean) {
          axqy.b(this.jdField_a_of_type_Atde.a.a.app, "dc00899", "Grp_wolf", "", "invite_page", "exp_more", 0, 0, "", "", "", "");
        }
      }
      else
      {
        k = i;
        i = j;
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.21.1.1
 * JD-Core Version:    0.7.0.1
 */