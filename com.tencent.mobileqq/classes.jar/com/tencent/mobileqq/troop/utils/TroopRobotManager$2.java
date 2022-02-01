package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.tofumsg.TofuHelper;

class TroopRobotManager$2
  extends FriendListObserver
{
  TroopRobotManager$2(TroopRobotManager paramTroopRobotManager) {}
  
  public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!this.a.b(paramString)) {}
    while (!paramBoolean1) {
      return;
    }
    TroopRobotManager.a(this.a, paramString);
  }
  
  public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    paramObject = "" + paramObject;
    if (!this.a.b(paramObject)) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      TroopRobotManager.a(this.a, paramObject);
    } while (!(this.a.a instanceof QQAppInterface));
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a;
    ((FriendsManager)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(paramObject);
    IceBreakingUtil.a(localQQAppInterface, paramObject);
    TofuHelper.a(localQQAppInterface, paramObject);
    localQQAppInterface.getProxyManager().a().a(paramObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager.2
 * JD-Core Version:    0.7.0.1
 */