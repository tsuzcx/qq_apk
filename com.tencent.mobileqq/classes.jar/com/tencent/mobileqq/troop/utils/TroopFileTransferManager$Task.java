package com.tencent.mobileqq.troop.utils;

public abstract class TroopFileTransferManager$Task
  implements Runnable
{
  public int a;
  public TroopFileTransferManager.Item a;
  public boolean a;
  public boolean b;
  
  protected TroopFileTransferManager$Task(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Task
 * JD-Core Version:    0.7.0.1
 */