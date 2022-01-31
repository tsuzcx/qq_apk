package com.tencent.mobileqq.nearby.gameroom;

import android.widget.LinearLayout;
import auuc;
import auud;
import auvm;
import azmj;
import java.util.Iterator;
import java.util.List;

public class GameRoomInviteActivity$21$1$1
  implements Runnable
{
  public GameRoomInviteActivity$21$1$1(auud paramauud, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Auud.a.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Auud.a.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Boolean);
    int j;
    int i;
    auvm localauvm;
    int k;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      j = 0;
      i = 0;
      if (localIterator.hasNext())
      {
        localauvm = (auvm)localIterator.next();
        if (localauvm.a == 1)
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
      if (localauvm.a == 0)
      {
        k = j + 1;
        j = i;
        i = k;
        continue;
        azmj.b(this.jdField_a_of_type_Auud.a.a.app, "dc00899", "Grp_wolf", "", "invite_page", "exp_invite", 0, 0, "" + i, "" + j, "", "");
        if (this.jdField_a_of_type_Boolean) {
          azmj.b(this.jdField_a_of_type_Auud.a.a.app, "dc00899", "Grp_wolf", "", "invite_page", "exp_more", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.21.1.1
 * JD-Core Version:    0.7.0.1
 */