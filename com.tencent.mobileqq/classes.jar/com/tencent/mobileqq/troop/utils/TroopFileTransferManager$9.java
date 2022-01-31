package com.tencent.mobileqq.troop.utils;

import ayoq;
import java.util.Map;
import java.util.UUID;

class TroopFileTransferManager$9
  implements Runnable
{
  TroopFileTransferManager$9(TroopFileTransferManager paramTroopFileTransferManager, UUID paramUUID, ayoq paramayoq, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.this$0.c();
    TroopFileTransferManager.Item localItem2 = (TroopFileTransferManager.Item)this.this$0.a.get(this.jdField_a_of_type_JavaUtilUUID);
    TroopFileTransferManager.Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      localItem1 = new TroopFileTransferManager.Item(this.jdField_a_of_type_Ayoq);
      this.this$0.a(localItem1);
    }
    this.this$0.b(localItem1, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.9
 * JD-Core Version:    0.7.0.1
 */