package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.mobileqq.teamwork.PadInfo;
import java.util.Comparator;

class GroupTeamWorkListActivity$9
  implements Comparator<PadInfo>
{
  GroupTeamWorkListActivity$9(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public int a(PadInfo paramPadInfo1, PadInfo paramPadInfo2)
  {
    long l = paramPadInfo2.lastEditTime - paramPadInfo1.lastEditTime;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.9
 * JD-Core Version:    0.7.0.1
 */