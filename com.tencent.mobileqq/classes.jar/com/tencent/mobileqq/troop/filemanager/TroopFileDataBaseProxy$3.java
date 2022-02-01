package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mobileqq.app.proxy.ProxyListener;
import java.util.UUID;

class TroopFileDataBaseProxy$3
  implements ProxyListener
{
  TroopFileDataBaseProxy$3(TroopFileDataBaseProxy paramTroopFileDataBaseProxy, UUID paramUUID) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    paramInt = TroopFileTransferUtil.Log.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a.toString());
    localStringBuilder.append("] deleteItem finish. table:");
    localStringBuilder.append(paramString);
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", paramInt, localStringBuilder.toString());
  }
  
  public void onInsertFinish(String paramString)
  {
    int i = TroopFileTransferUtil.Log.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a.toString());
    localStringBuilder.append("] deleteItem finish[add]. table:");
    localStringBuilder.append(paramString);
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", i, localStringBuilder.toString());
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    paramInt = TroopFileTransferUtil.Log.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a.toString());
    localStringBuilder.append("] deleteItem finish[up]. table:");
    localStringBuilder.append(paramString);
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", paramInt, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileDataBaseProxy.3
 * JD-Core Version:    0.7.0.1
 */