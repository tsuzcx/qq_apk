package com.tencent.mobileqq.onlinestatus;

import anvk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OnlineStatusPermissionChecker$OnlineStatusPermissionItem
  implements Serializable
{
  private boolean allHasPermission;
  private long onlineStateType;
  private List<Long> permissionUins;
  
  private OnlineStatusPermissionChecker$OnlineStatusPermissionItem(long paramLong, boolean paramBoolean)
  {
    this.onlineStateType = paramLong;
    this.allHasPermission = paramBoolean;
  }
  
  public static OnlineStatusPermissionItem create(long paramLong, boolean paramBoolean, List<Long> paramList)
  {
    OnlineStatusPermissionItem localOnlineStatusPermissionItem = new OnlineStatusPermissionItem(paramLong, paramBoolean);
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    localOnlineStatusPermissionItem.permissionUins = ((List)localObject);
    return localOnlineStatusPermissionItem;
  }
  
  public List<Long> filterNotFriend()
  {
    ArrayList localArrayList = new ArrayList();
    anvk localanvk = (anvk)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (this.permissionUins != null)
    {
      Iterator localIterator = this.permissionUins.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if (localanvk.b(localLong.toString())) {
          localArrayList.add(localLong);
        } else if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusPermissionChecker", 2, new Object[] { "filterNotFriend: invoked. ", " uin: ", localLong });
        }
      }
    }
    this.permissionUins = localArrayList;
    return this.permissionUins;
  }
  
  public long getOnlineStateType()
  {
    return this.onlineStateType;
  }
  
  public List<Long> getPermissionUins()
  {
    return this.permissionUins;
  }
  
  public boolean isAllHasPermission()
  {
    return this.allHasPermission;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem
 * JD-Core Version:    0.7.0.1
 */