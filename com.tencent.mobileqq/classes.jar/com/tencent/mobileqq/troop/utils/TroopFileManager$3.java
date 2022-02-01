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
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramBundle == null) {
      return;
    }
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299168);
    paramBundle = paramBundle.getString("fileId");
    int j = TroopFileTransferUtil.Log.a;
    paramString1 = new StringBuilder();
    paramString1.append("delete onActionResult: fileId:");
    paramString1.append(paramBundle);
    paramString1.append(" isSuccess:");
    paramString1.append(paramBoolean);
    paramString1.append(" errorCode:");
    paramString1.append(paramInt);
    TroopFileTransferUtil.Log.c("TroopFileManager", j, paramString1.toString());
    if (paramBoolean)
    {
      this.a.b(paramBundle);
      return;
    }
    if ((paramInt != -302) && (paramInt != -301)) {
      if (paramInt != -121)
      {
        if (paramInt != -103) {
          QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131715146), 0).b(i);
        }
      }
      else
      {
        QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131715127), 0).b(i);
        return;
      }
    }
    QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131715143), 0).b(i);
    this.a.a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.3
 * JD-Core Version:    0.7.0.1
 */