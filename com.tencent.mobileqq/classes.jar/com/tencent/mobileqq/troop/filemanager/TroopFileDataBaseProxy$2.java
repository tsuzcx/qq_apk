package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import java.util.UUID;

class TroopFileDataBaseProxy$2
  implements ProxyListener
{
  TroopFileDataBaseProxy$2(TroopFileDataBaseProxy paramTroopFileDataBaseProxy, TroopFileTansferItemEntity paramTroopFileTansferItemEntity) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] updateItem finish[del]. table:" + paramString);
  }
  
  public void onInsertFinish(String paramString)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] updateItem finish[add]. table:" + paramString);
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] updateItem finish. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileDataBaseProxy.2
 * JD-Core Version:    0.7.0.1
 */