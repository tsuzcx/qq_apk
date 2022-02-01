package com.tencent.mobileqq.troop.filemanager.forward;

import android.os.Bundle;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Map;
import java.util.UUID;

class TroopFileMultiForwarder$1
  extends TroopFileReqCopyToObserver
{
  TroopFileMultiForwarder$1(TroopFileMultiForwarder paramTroopFileMultiForwarder) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != this.a.jdField_a_of_type_Long) {
      return;
    }
    paramBundle = paramBundle.getString("itemKey");
    if (paramBundle == null) {
      return;
    }
    paramBundle = UUID.fromString(paramBundle);
    paramBundle = (TroopFileTransferManager.Item)this.a.jdField_a_of_type_JavaUtilMap.get(paramBundle);
    if (paramBundle == null) {
      return;
    }
    TroopFileMultiForwarder.a(this.a, paramBundle, paramBoolean, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.forward.TroopFileMultiForwarder.1
 * JD-Core Version:    0.7.0.1
 */