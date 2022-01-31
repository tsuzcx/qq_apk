package com.tencent.mobileqq.troop.logic;

import ajme;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import java.util.ArrayList;

public class TroopSearchLogic
{
  public QQAppInterface a;
  public TroopManager a;
  
  public TroopSearchLogic()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
  }
  
  public void a(ArrayList paramArrayList, TroopSearchLogic.TroopSearchCallback paramTroopSearchCallback)
  {
    ThreadManager.postImmediately(new ajme(this, paramTroopSearchCallback, paramArrayList), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopSearchLogic
 * JD-Core Version:    0.7.0.1
 */