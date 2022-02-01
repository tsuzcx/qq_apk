package com.tencent.mobileqq.troop.troopgame;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class TroopGameCardResDownloadManager$1
  implements TroopGameCardConfigProcessor.OnGetConfigListener
{
  TroopGameCardResDownloadManager$1(TroopGameCardResDownloadManager paramTroopGameCardResDownloadManager) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopGameCardResDownloadManager", 2, "onGetConfigFinished result:" + paramInt);
    }
    if (paramInt == 0)
    {
      String str1 = TroopGameCardConfigProcessor.a().a();
      String str2 = TroopGameCardConfigProcessor.a().b();
      if (QLog.isColorLevel()) {
        QLog.i("TroopGameCardResDownloadManager", 2, "onGetConfigFinished url:" + str1 + " md5:" + str2);
      }
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        TroopGameCardResDownloadManager.a(this.a).b(110);
        return;
      }
      this.a.a(new TroopGameCardResDownloadManager.ResInfo(str1, str2));
      return;
    }
    TroopGameCardResDownloadManager.a(this.a).b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardResDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */