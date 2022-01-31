package com.tencent.mobileqq.troop.logic;

import azcw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import java.util.ArrayList;

public class TroopSearchLogic
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
  
  public void a(ArrayList<ResultRecord> paramArrayList, azcw paramazcw)
  {
    ThreadManager.postImmediately(new TroopSearchLogic.TroopSearchTask(this, paramazcw, paramArrayList), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopSearchLogic
 * JD-Core Version:    0.7.0.1
 */