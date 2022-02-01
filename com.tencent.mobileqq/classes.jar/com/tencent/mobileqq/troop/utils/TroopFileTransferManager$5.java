package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqFeedsObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import java.util.Map;
import java.util.UUID;

class TroopFileTransferManager$5
  extends TroopFileReqFeedsObserver
{
  TroopFileTransferManager$5(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (!paramBoolean) {
      return;
    }
    paramString = paramBundle.getString("itemKey");
    if (paramString == null) {
      return;
    }
    paramString = UUID.fromString(paramString);
    paramBundle = paramBundle.getString("fileId");
    paramString = (TroopFileInfo)this.a.h().e.get(paramString);
    if (paramString == null) {
      return;
    }
    if (paramInt1 == 0)
    {
      TroopFileProtocol.a(this.a.j, this.a.k, paramString.f, paramString.c, TroopFileTransferManager.a(this.a));
      ThreadManager.executeOnSubThread(new TroopFileTransferManager.5.1(this, paramBundle, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.5
 * JD-Core Version:    0.7.0.1
 */