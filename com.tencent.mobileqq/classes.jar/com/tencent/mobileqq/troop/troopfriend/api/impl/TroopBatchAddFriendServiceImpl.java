package com.tencent.mobileqq.troop.troopfriend.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import mqq.app.AppRuntime;

public class TroopBatchAddFriendServiceImpl
  implements ITroopBatchAddFriendService
{
  private static final String TAG = "TroopBatchAddFriendServiceImpl";
  private AppRuntime app;
  TroopBatchAddFriendMgr mTroopBatchAddFriendMgr;
  
  public TroopBatchAddFriendMgr getTroopBatchAddFriendMgr()
  {
    return this.mTroopBatchAddFriendMgr;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    this.mTroopBatchAddFriendMgr = new TroopBatchAddFriendMgr((QQAppInterface)this.app);
  }
  
  public void onDestroy()
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = this.mTroopBatchAddFriendMgr;
    if (localTroopBatchAddFriendMgr != null) {
      localTroopBatchAddFriendMgr.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopfriend.api.impl.TroopBatchAddFriendServiceImpl
 * JD-Core Version:    0.7.0.1
 */