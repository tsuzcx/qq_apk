package com.tencent.mobileqq.gamecenter.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GameCenterMsgConfigProcessor
  extends IQConfigProcessor<GameCenterMsgBean>
{
  public static GameCenterMsgBean a()
  {
    return (GameCenterMsgBean)QConfigManager.a().a(608);
  }
  
  @NonNull
  public GameCenterMsgBean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[migrateOldOrDefaultContent] type:");
    localStringBuilder.append(paramInt);
    QLog.i("GameCenterMsgConfigProcessor", 1, localStringBuilder.toString());
    GameCenterMsgBean.a();
    return new GameCenterMsgBean();
  }
  
  @Nullable
  public GameCenterMsgBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameCenterMsgConfigProcessor", 2, "[onParsed]");
    }
    paramArrayOfQConfItem = GameCenterMsgBean.a(paramArrayOfQConfItem);
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && (paramArrayOfQConfItem != null)) {
      ((IGameMsgManagerService)localAppRuntime.getRuntimeService(IGameMsgManagerService.class, "all")).updateMgrConfig(paramArrayOfQConfItem);
    }
    return paramArrayOfQConfItem;
  }
  
  public void a(GameCenterMsgBean paramGameCenterMsgBean)
  {
    QLog.i("GameCenterMsgConfigProcessor", 1, "[onUpdate]");
  }
  
  public Class<GameCenterMsgBean> clazz()
  {
    return GameCenterMsgBean.class;
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
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqNoReceive: type=");
      localStringBuilder.append(type());
      QLog.d("GameCenterMsgConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 608;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.config.GameCenterMsgConfigProcessor
 * JD-Core Version:    0.7.0.1
 */