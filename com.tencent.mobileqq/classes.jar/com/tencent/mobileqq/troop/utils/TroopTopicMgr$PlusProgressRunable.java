package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class TroopTopicMgr$PlusProgressRunable
  implements Runnable
{
  TroopChatPie a;
  
  public TroopTopicMgr$PlusProgressRunable(TroopChatPie paramTroopChatPie)
  {
    this.a = paramTroopChatPie;
  }
  
  public void run()
  {
    this.a.bn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopTopicMgr.PlusProgressRunable
 * JD-Core Version:    0.7.0.1
 */