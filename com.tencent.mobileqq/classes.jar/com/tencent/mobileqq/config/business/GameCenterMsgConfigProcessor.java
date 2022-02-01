package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GameCenterMsgConfigProcessor
  extends IQConfigProcessor<GameCenterMsgBean>
{
  public static final String a = GameCenterUnissoHandler.a + "GameCenterMsgConfigProcessor";
  
  public static GameCenterMsgBean a()
  {
    return (GameCenterMsgBean)QConfigManager.a().a(608);
  }
  
  @NonNull
  public GameCenterMsgBean a(int paramInt)
  {
    QLog.i(a, 1, "[migrateOldOrDefaultContent] type:" + paramInt);
    GameCenterMsgBean.a();
    return new GameCenterMsgBean();
  }
  
  @Nullable
  public GameCenterMsgBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "[onParsed]");
    }
    paramArrayOfQConfItem = GameCenterMsgBean.a(paramArrayOfQConfItem);
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && (paramArrayOfQConfItem != null)) {
      ((GameMsgManager)localAppRuntime.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(paramArrayOfQConfItem);
    }
    return paramArrayOfQConfItem;
  }
  
  public void a(GameCenterMsgBean paramGameCenterMsgBean)
  {
    QLog.i(a, 1, "[onUpdate]");
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
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onReqNoReceive: type=" + type());
    }
  }
  
  public int type()
  {
    return 608;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.GameCenterMsgConfigProcessor
 * JD-Core Version:    0.7.0.1
 */