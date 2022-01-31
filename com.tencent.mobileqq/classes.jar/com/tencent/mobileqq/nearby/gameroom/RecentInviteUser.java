package com.tencent.mobileqq.nearby.gameroom;

import awbv;
import awdj;

public class RecentInviteUser
  extends awbv
  implements Comparable<RecentInviteUser>
{
  public String lastInviteId;
  public long lastInviteTime;
  public String uin;
  public int uinType;
  @awdj
  public String uniKey;
  
  public static String getKey(int paramInt, String paramString)
  {
    return paramInt + "_" + paramString;
  }
  
  public int compareTo(RecentInviteUser paramRecentInviteUser)
  {
    if (paramRecentInviteUser == null) {}
    do
    {
      return -1;
      if (paramRecentInviteUser.lastInviteTime > this.lastInviteTime) {
        return 1;
      }
    } while (paramRecentInviteUser.lastInviteTime < this.lastInviteTime);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentInviteUser
 * JD-Core Version:    0.7.0.1
 */