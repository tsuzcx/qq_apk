package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.avgame.util.AvGameLobbyConfBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class AvGameLobbyConfProcessor
  extends IQConfigProcessor<AvGameLobbyConfBean>
{
  private final List<AvGameLobbyConfProcessor.OnGetConfigListener> a = new LinkedList();
  
  public static AvGameLobbyConfBean a()
  {
    AvGameLobbyConfBean localAvGameLobbyConfBean = (AvGameLobbyConfBean)QConfigManager.a().a(713);
    if (localAvGameLobbyConfBean != null) {
      return localAvGameLobbyConfBean;
    }
    return new AvGameLobbyConfBean();
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameLobbyConfProcessor", 2, "[notifyListeners]:" + this.a.size());
    }
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
    try
    {
      synchronized (this.a)
      {
        if (this.a.size() <= 0) {
          break label162;
        }
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          AvGameLobbyConfProcessor.OnGetConfigListener localOnGetConfigListener = (AvGameLobbyConfProcessor.OnGetConfigListener)localIterator.next();
          try
          {
            localOnGetConfigListener.a(paramInt);
          }
          catch (Throwable localThrowable2) {}
          if (QLog.isColorLevel()) {
            QLog.e("AvGameLobbyConfProcessor", 1, localThrowable2, new Object[0]);
          }
        }
      }
      this.a.clear();
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvGameLobbyConfProcessor", 1, localThrowable1, new Object[0]);
      }
      return;
    }
    label162:
  }
  
  @NonNull
  public AvGameLobbyConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AvGameLobbyConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new AvGameLobbyConfBean();
  }
  
  @Nullable
  public AvGameLobbyConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameLobbyConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameLobbyConfProcessor", 2, "onParsed " + paramArrayOfQConfItem.length);
      }
      return AvGameLobbyConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(AvGameLobbyConfBean paramAvGameLobbyConfBean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramAvGameLobbyConfBean == null) {
        break label48;
      }
    }
    label48:
    for (paramAvGameLobbyConfBean = paramAvGameLobbyConfBean.toString();; paramAvGameLobbyConfBean = " empty")
    {
      QLog.d("AvGameLobbyConfProcessor", 2, paramAvGameLobbyConfBean);
      a(0);
      return;
    }
  }
  
  public Class clazz()
  {
    return AvGameLobbyConfBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AvGameLobbyConfProcessor", 2, "onReqFailed " + paramInt);
    }
    a(paramInt);
  }
  
  public int type()
  {
    return 713;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AvGameLobbyConfProcessor
 * JD-Core Version:    0.7.0.1
 */