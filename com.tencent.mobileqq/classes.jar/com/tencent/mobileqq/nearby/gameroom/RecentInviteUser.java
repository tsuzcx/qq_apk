package com.tencent.mobileqq.nearby.gameroom;

import atmo;
import atoc;

public class RecentInviteUser
  extends atmo
  implements Comparable<RecentInviteUser>
{
  public String lastInviteId;
  public long lastInviteTime;
  public String uin;
  public int uinType;
  @atoc
  public String uniKey;
  
  public static String getKey(int paramInt, String paramString)
  {
    return paramInt + "_" + paramString;
  }
  
  public int compareTo(RecentInviteUser paramRecentInviteUser)
  {
    return (int)(paramRecentInviteUser.lastInviteTime - this.lastInviteTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentInviteUser
 * JD-Core Version:    0.7.0.1
 */