package com.tencent.mobileqq.troop.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.tofumsg.TofuHelper;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;

class TroopRobotManager$1
  extends FriendListObserver
{
  TroopRobotManager$1(TroopRobotManager paramTroopRobotManager) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    Object localObject = (ITroopRobotService)this.a.g.getRuntimeService(ITroopRobotService.class, "all");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramObject);
    paramObject = localStringBuilder.toString();
    if (!((ITroopRobotService)localObject).isRobotUin(paramObject)) {
      return;
    }
    if (paramBoolean)
    {
      TroopRobotManager.a(this.a, paramObject);
      if ((this.a.g instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)this.a.g;
        ((FriendsManager)this.a.g.getManager(QQManagerFactory.FRIENDS_MANAGER)).s(paramObject);
        IceBreakingUtil.a((QQAppInterface)localObject, paramObject);
        TofuHelper.a((QQAppInterface)localObject, paramObject);
        ((QQAppInterface)localObject).getProxyManager().g().a(paramObject, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager.1
 * JD-Core Version:    0.7.0.1
 */