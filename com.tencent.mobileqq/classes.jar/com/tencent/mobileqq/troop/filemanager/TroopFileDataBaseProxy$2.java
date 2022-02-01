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
    paramInt = TroopFileTransferUtil.Log.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a.Id.toString());
    localStringBuilder.append("] updateItem finish[del]. table:");
    localStringBuilder.append(paramString);
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", paramInt, localStringBuilder.toString());
  }
  
  public void onInsertFinish(String paramString)
  {
    int i = TroopFileTransferUtil.Log.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a.Id.toString());
    localStringBuilder.append("] updateItem finish[add]. table:");
    localStringBuilder.append(paramString);
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", i, localStringBuilder.toString());
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    paramInt = TroopFileTransferUtil.Log.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a.Id.toString());
    localStringBuilder.append("] updateItem finish. table:");
    localStringBuilder.append(paramString);
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", paramInt, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileDataBaseProxy.2
 * JD-Core Version:    0.7.0.1
 */