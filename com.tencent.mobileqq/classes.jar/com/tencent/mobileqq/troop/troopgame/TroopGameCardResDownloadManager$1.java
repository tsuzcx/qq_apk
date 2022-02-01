package com.tencent.mobileqq.troop.troopgame;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class TroopGameCardResDownloadManager$1
  implements TroopGameCardConfigProcessor.OnGetConfigListener
{
  TroopGameCardResDownloadManager$1(TroopGameCardResDownloadManager paramTroopGameCardResDownloadManager) {}
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetConfigFinished result:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("TroopGameCardResDownloadManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0)
    {
      localObject = TroopGameCardConfigProcessor.a().a();
      String str = TroopGameCardConfigProcessor.a().b();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetConfigFinished url:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" md5:");
        localStringBuilder.append(str);
        QLog.i("TroopGameCardResDownloadManager", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
      {
        this.a.a(new TroopGameCardResDownloadManager.ResInfo((String)localObject, str));
        return;
      }
      TroopGameCardResDownloadManager.a(this.a).b(110);
      return;
    }
    TroopGameCardResDownloadManager.a(this.a).b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardResDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */