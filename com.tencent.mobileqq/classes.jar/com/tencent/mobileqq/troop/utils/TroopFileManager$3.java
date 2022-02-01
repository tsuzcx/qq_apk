package com.tencent.mobileqq.troop.utils;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.biz.troop.file.protocol.TroopFileDeleteFileObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.widget.QQToast;

class TroopFileManager$3
  extends TroopFileDeleteFileObserver
{
  TroopFileManager$3(TroopFileManager paramTroopFileManager) {}
  
  public void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramBundle == null) {
      return;
    }
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299166);
    paramBundle = paramBundle.getString("fileId");
    TroopFileTransferUtil.Log.c("TroopFileManager", TroopFileTransferUtil.Log.a, "delete onActionResult: fileId:" + paramBundle + " isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    if (paramBoolean)
    {
      this.a.b(paramBundle);
      return;
    }
    switch (paramInt)
    {
    default: 
      QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131715223), 0).b(i);
      return;
    case -302: 
    case -301: 
    case -103: 
      QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131715220), 0).b(i);
      this.a.a(paramBundle);
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131715204), 0).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.3
 * JD-Core Version:    0.7.0.1
 */