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
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299920);
    paramBundle = paramBundle.getString("fileId");
    int j = TroopFileTransferUtil.Log.b;
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
      this.a.d(paramBundle);
      return;
    }
    if ((paramInt != -302) && (paramInt != -301)) {
      if (paramInt != -121)
      {
        if (paramInt != -103) {
          QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131912634), 0).show(i);
        }
      }
      else
      {
        QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131912615), 0).show(i);
        return;
      }
    }
    QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131912631), 0).show(i);
    this.a.c(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.3
 * JD-Core Version:    0.7.0.1
 */