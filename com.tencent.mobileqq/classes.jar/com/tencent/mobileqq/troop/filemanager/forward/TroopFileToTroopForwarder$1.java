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
    if (paramBundle.getLong("troopUin") != TroopFileToTroopForwarder.a(this.a)) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())));
    if (!paramBoolean) {
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "[" + TroopFileToTroopForwarder.a(this.a) + "] onFowardToTroopResult isSuccess:false ");
    }
    TroopFileToTroopForwarder.a(this.a, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.forward.TroopFileToTroopForwarder.1
 * JD-Core Version:    0.7.0.1
 */