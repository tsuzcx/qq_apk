package com.tencent.mobileqq.troop.troopgame;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class TroopGameCardConfigProcessor$2
  implements TroopGameCardResDownloadManager.IStatusListener
{
  TroopGameCardConfigProcessor$2(TroopGameCardConfigProcessor paramTroopGameCardConfigProcessor) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopGameCardConfigProcessor", 2, "onResDownloadStart");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResDownloadProgress and percent is ");
      localStringBuilder.append(paramInt);
      QLog.i("TroopGameCardConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopGameCardConfigProcessor", 2, "onResDownloadReady");
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("troop_game_card_sp", 4).edit().putString("resPath", paramString).commit();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopGameCardConfigProcessor", 1, "onResDownloadFailed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardConfigProcessor.2
 * JD-Core Version:    0.7.0.1
 */