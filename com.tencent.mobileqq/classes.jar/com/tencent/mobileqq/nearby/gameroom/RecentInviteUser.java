package com.tencent.mobileqq.nearby.gameroom;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class RecentInviteUser
  extends Entity
  implements Comparable<RecentInviteUser>
{
  public String lastInviteId;
  public long lastInviteTime;
  public String uin;
  public int uinType;
  @unique
  public String uniKey;
  
  public static String getKey(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public int compareTo(RecentInviteUser paramRecentInviteUser)
  {
    if (paramRecentInviteUser == null) {
      return -1;
    }
    long l1 = paramRecentInviteUser.lastInviteTime;
    long l2 = this.lastInviteTime;
    if (l1 > l2) {
      return 1;
    }
    if (l1 < l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentInviteUser
 * JD-Core Version:    0.7.0.1
 */