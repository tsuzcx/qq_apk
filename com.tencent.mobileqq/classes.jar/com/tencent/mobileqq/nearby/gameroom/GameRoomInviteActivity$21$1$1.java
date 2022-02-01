package com.tencent.mobileqq.nearby.gameroom;

import android.widget.LinearLayout;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class GameRoomInviteActivity$21$1$1
  implements Runnable
{
  GameRoomInviteActivity$21$1$1(GameRoomInviteActivity.21.1 param1, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$21$1.a.a.mRecentInviteLayout;
    int j = 0;
    ((LinearLayout)localObject1).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$21$1.a.a.mRecentInvitePanel.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (InviteUser)((Iterator)localObject1).next();
        if (((InviteUser)localObject2).a == 1) {
          j += 1;
        } else if (((InviteUser)localObject2).a == 0) {
          i += 1;
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$21$1.a.a.app;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(j);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_wolf", "", "invite_page", "exp_invite", 0, 0, (String)localObject2, localStringBuilder.toString(), "", "");
    }
    if (this.jdField_a_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$21$1.a.a.app, "dc00899", "Grp_wolf", "", "invite_page", "exp_more", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.21.1.1
 * JD-Core Version:    0.7.0.1
 */