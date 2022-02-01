package com.tencent.mobileqq.qqgamepub.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class GameCenterEnterConfProcessor
  extends IQConfigProcessor<GameCenterEnterConfBean>
{
  @NonNull
  public GameCenterEnterConfBean a(int paramInt)
  {
    return new GameCenterEnterConfBean();
  }
  
  @Nullable
  public GameCenterEnterConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_GameCenterEnterConfProc", 2, "GameCenterEnterConfProcessor onParsed ");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return GameCenterEnterConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(GameCenterEnterConfBean paramGameCenterEnterConfBean) {}
  
  public Class<GameCenterEnterConfBean> clazz()
  {
    return GameCenterEnterConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 660;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.GameCenterEnterConfProcessor
 * JD-Core Version:    0.7.0.1
 */