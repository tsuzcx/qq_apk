package com.tencent.mobileqq.troop.troopgame;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import mqq.os.MqqHandler;

public class TroopGameCardConfigProcessor
  extends IQConfigProcessor<TroopGameCardConfig>
{
  private final List<TroopGameCardConfigProcessor.OnGetConfigListener> a = new LinkedList();
  
  public static TroopGameCardConfig a()
  {
    TroopGameCardConfig localTroopGameCardConfig = (TroopGameCardConfig)QConfigManager.a().a(695);
    if (localTroopGameCardConfig != null) {
      return localTroopGameCardConfig;
    }
    return new TroopGameCardConfig();
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardConfigProcessor", 2, "[notifyListeners]:" + this.a.size());
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
          TroopGameCardConfigProcessor.OnGetConfigListener localOnGetConfigListener = (TroopGameCardConfigProcessor.OnGetConfigListener)localIterator.next();
          try
          {
            localOnGetConfigListener.a(paramInt);
          }
          catch (Throwable localThrowable2) {}
          if (QLog.isColorLevel()) {
            QLog.e("TroopGameCardConfigProcessor", 1, localThrowable2, new Object[0]);
          }
        }
      }
      this.a.clear();
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGameCardConfigProcessor", 1, localThrowable1, new Object[0]);
      }
      return;
    }
    label162:
  }
  
  private void b(TroopGameCardConfig paramTroopGameCardConfig)
  {
    if (paramTroopGameCardConfig == null) {
      return;
    }
    new TroopGameCardResDownloadManager((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(new TroopGameCardResDownloadManager.ResInfo(paramTroopGameCardConfig.a(), paramTroopGameCardConfig.b()), new TroopGameCardConfigProcessor.2(this));
  }
  
  @NonNull
  public TroopGameCardConfig a(int paramInt)
  {
    QLog.d("TroopGameCardConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new TroopGameCardConfig();
  }
  
  @Nullable
  public TroopGameCardConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = TroopGameCardConfig.a(paramArrayOfQConfItem[0].a);
      ThreadManager.getSubThreadHandler().post(new TroopGameCardConfigProcessor.1(this, paramArrayOfQConfItem));
      return paramArrayOfQConfItem;
    }
    return null;
  }
  
  public void a(TroopGameCardConfig paramTroopGameCardConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardConfigProcessor", 1, "onUpdate, newConf = " + paramTroopGameCardConfig);
    }
    ThreadManager.getSubThreadHandler().post(new TroopGameCardConfigProcessor.3(this, paramTroopGameCardConfig));
  }
  
  public void a(TroopGameCardConfigProcessor.OnGetConfigListener paramOnGetConfigListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardConfigProcessor", 2, "[getConfig]");
    }
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        this.a.add(paramOnGetConfigListener);
        return;
      }
      this.a.add(paramOnGetConfigListener);
      QConfigManager.a().a(new int[] { 695 });
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      ThreadManager.getSubThreadHandler().postAtTime(new TroopGameCardConfigProcessor.4(this), this, SystemClock.uptimeMillis() + 10000L);
      return;
    }
  }
  
  public Class<TroopGameCardConfig> clazz()
  {
    return TroopGameCardConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
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
    QLog.d("TroopGameCardConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 695;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardConfigProcessor
 * JD-Core Version:    0.7.0.1
 */