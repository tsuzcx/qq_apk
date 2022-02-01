package com.tencent.mobileqq.onlinestatus;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OnlineStatusFriendsPermissionItem
  implements Serializable
{
  public static final String TAG = "OnlineStatusPermissionItem";
  public boolean allHasPermission = true;
  public List<Long> permissionUins = new ArrayList(0);
  
  public OnlineStatusFriendsPermissionItem(boolean paramBoolean, List<Long> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.allHasPermission = paramBoolean;
    this.permissionUins = ((List)localObject);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" allHasPermission=").append(this.allHasPermission).append(" permissionUins");
    if (this.permissionUins == null) {}
    for (Object localObject = "";; localObject = Integer.valueOf(this.permissionUins.size()))
    {
      localStringBuilder2.append(localObject);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem
 * JD-Core Version:    0.7.0.1
 */