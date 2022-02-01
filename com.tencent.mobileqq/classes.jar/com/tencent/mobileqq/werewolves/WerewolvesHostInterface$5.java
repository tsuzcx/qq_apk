package com.tencent.mobileqq.werewolves;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;

class WerewolvesHostInterface$5
  extends TroopBusinessObserver
{
  WerewolvesHostInterface$5(WerewolvesHostInterface paramWerewolvesHostInterface, QQAppInterface paramQQAppInterface) {}
  
  public void onGetFollowStatus(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHostInterface.manager.a().a(6, new Object[] { Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2) });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHostInterface.5
 * JD-Core Version:    0.7.0.1
 */