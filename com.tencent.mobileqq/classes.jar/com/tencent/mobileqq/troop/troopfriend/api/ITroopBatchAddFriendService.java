package com.tencent.mobileqq.troop.troopfriend.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopBatchAddFriendService
  extends IRuntimeService
{
  public abstract TroopBatchAddFriendMgr getTroopBatchAddFriendMgr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService
 * JD-Core Version:    0.7.0.1
 */