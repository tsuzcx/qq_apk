package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.qphone.base.util.QLog;

class TroopFileTransferManager$5$1
  implements Runnable
{
  TroopFileTransferManager$5$1(TroopFileTransferManager.5 param5, String paramString, TroopFileInfo paramTroopFileInfo) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (!TextUtils.isEmpty(this.b.c)) {
      localObject = this.b.c;
    }
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)FileOperaterUtils.a(this.c.a.j.getMessageFacade(), String.valueOf(this.c.a.k), 1, (String)localObject);
    if (localMessageForTroopFile != null) {
      localObject = localMessageForTroopFile.fileName;
    } else {
      localObject = "";
    }
    long l = FileManagerUtil.v((String)localObject);
    if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l))
    {
      ((AIOMessageSpreadManager)this.c.a.j.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a(localMessageForTroopFile);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("can't find troopFile Msg, troop[");
      ((StringBuilder)localObject).append(this.c.a.k);
      ((StringBuilder)localObject).append("], id:");
      ((StringBuilder)localObject).append(this.b.c);
      QLog.e("AIOMessageSpreadManager", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.5.1
 * JD-Core Version:    0.7.0.1
 */