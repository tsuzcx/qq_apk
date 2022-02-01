package com.tencent.mobileqq.troop.utils;

import java.util.Comparator;

final class TroopBatchAddFriendMgr$5
  implements Comparator<TroopBatchAddFriendMgr.FlagMsgInfo>
{
  public int a(TroopBatchAddFriendMgr.FlagMsgInfo paramFlagMsgInfo1, TroopBatchAddFriendMgr.FlagMsgInfo paramFlagMsgInfo2)
  {
    return Long.signum(paramFlagMsgInfo2.b - paramFlagMsgInfo1.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.5
 * JD-Core Version:    0.7.0.1
 */