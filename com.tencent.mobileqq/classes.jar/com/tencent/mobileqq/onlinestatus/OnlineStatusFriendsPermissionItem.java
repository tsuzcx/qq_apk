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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" allHasPermission=");
    localStringBuilder.append(this.allHasPermission);
    localStringBuilder.append(" permissionUins");
    Object localObject = this.permissionUins;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = Integer.valueOf(((List)localObject).size());
    }
    localStringBuilder.append(localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem
 * JD-Core Version:    0.7.0.1
 */