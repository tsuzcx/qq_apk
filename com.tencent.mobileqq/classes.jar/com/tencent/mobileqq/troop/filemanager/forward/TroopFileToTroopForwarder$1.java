package com.tencent.mobileqq.troop.filemanager.forward;

import android.os.Bundle;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import java.util.UUID;

class TroopFileToTroopForwarder$1
  extends TroopFileReqCopyToObserver
{
  TroopFileToTroopForwarder$1(TroopFileToTroopForwarder paramTroopFileToTroopForwarder) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != TroopFileToTroopForwarder.a(this.a)) {
      return;
    }
    paramBundle = paramBundle.getString("itemKey");
    if (paramBundle == null) {
      return;
    }
    if (!UUID.fromString(paramBundle).equals(this.a.b())) {
      return;
    }
    if (!paramBoolean)
    {
      int i = TroopFileTransferUtil.Log.b;
      paramBundle = new StringBuilder();
      paramBundle.append("[");
      paramBundle.append(TroopFileToTroopForwarder.b(this.a));
      paramBundle.append("] onFowardToTroopResult isSuccess:false ");
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", i, paramBundle.toString());
    }
    TroopFileToTroopForwarder.a(this.a, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.forward.TroopFileToTroopForwarder.1
 * JD-Core Version:    0.7.0.1
 */