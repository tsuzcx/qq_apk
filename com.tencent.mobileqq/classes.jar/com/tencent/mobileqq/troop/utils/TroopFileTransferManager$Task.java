package com.tencent.mobileqq.troop.utils;

public abstract class TroopFileTransferManager$Task
  implements Runnable
{
  public TroopFileTransferManager.Item a;
  public int b;
  public boolean c = false;
  public boolean d = false;
  
  protected TroopFileTransferManager$Task(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    this.a = paramItem;
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Task
 * JD-Core Version:    0.7.0.1
 */