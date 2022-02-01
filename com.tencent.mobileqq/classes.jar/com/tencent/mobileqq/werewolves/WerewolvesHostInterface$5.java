package com.tencent.mobileqq.werewolves;

import com.tencent.mobileqq.app.GVideoObserver;
import com.tencent.mobileqq.app.QQAppInterface;

class WerewolvesHostInterface$5
  extends GVideoObserver
{
  WerewolvesHostInterface$5(WerewolvesHostInterface paramWerewolvesHostInterface, QQAppInterface paramQQAppInterface) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    this.f.manager.c().a(6, new Object[] { Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2) });
    this.a.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHostInterface.5
 * JD-Core Version:    0.7.0.1
 */