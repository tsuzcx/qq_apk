package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mobileqq.app.proxy.ProxyListener;
import java.util.UUID;

class TroopFileDataBaseProxy$3
  implements ProxyListener
{
  TroopFileDataBaseProxy$3(TroopFileDataBaseProxy paramTroopFileDataBaseProxy, UUID paramUUID) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish. table:" + paramString);
  }
  
  public void onInsertFinish(String paramString)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish[add]. table:" + paramString);
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish[up]. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileDataBaseProxy.3
 * JD-Core Version:    0.7.0.1
 */