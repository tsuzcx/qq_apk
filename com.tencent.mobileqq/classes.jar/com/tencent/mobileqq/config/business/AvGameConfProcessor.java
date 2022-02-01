package com.tencent.mobileqq.config.business;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.avgame.util.AvGameConfBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class AvGameConfProcessor
  extends IQConfigProcessor<AvGameConfBean>
{
  private final List<AvGameConfProcessor.OnGetConfigListener> a = new LinkedList();
  
  public static AvGameConfBean a()
  {
    AvGameConfBean localAvGameConfBean = (AvGameConfBean)QConfigManager.a().a(642);
    if (localAvGameConfBean != null) {
      return localAvGameConfBean;
    }
    return new AvGameConfBean();
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameConfProcessor", 2, "[notifyListeners]:" + this.a.size());
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
          AvGameConfProcessor.OnGetConfigListener localOnGetConfigListener = (AvGameConfProcessor.OnGetConfigListener)localIterator.next();
          try
          {
            localOnGetConfigListener.a(paramInt);
          }
          catch (Throwable localThrowable2) {}
          if (QLog.isColorLevel()) {
            QLog.e("AvGameConfProcessor", 1, localThrowable2, new Object[0]);
          }
        }
      }
      this.a.clear();
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvGameConfProcessor", 1, localThrowable1, new Object[0]);
      }
      return;
    }
    label162:
  }
  
  @NonNull
  public AvGameConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AvGameConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new AvGameConfBean();
  }
  
  @Nullable
  public AvGameConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameConfProcessor", 2, "onParsed " + paramArrayOfQConfItem.length);
      }
      return AvGameConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(AvGameConfBean paramAvGameConfBean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramAvGameConfBean == null) {
        break label48;
      }
    }
    label48:
    for (paramAvGameConfBean = paramAvGameConfBean.toString();; paramAvGameConfBean = " empty")
    {
      QLog.d("AvGameConfProcessor", 2, paramAvGameConfBean);
      a(0);
      return;
    }
  }
  
  public void a(AvGameConfProcessor.OnGetConfigListener paramOnGetConfigListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameConfProcessor", 2, "[getConfig]");
    }
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        this.a.add(paramOnGetConfigListener);
        return;
      }
      this.a.add(paramOnGetConfigListener);
      QConfigManager.a().a(new int[] { 642 });
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      ThreadManager.getSubThreadHandler().postAtTime(new AvGameConfProcessor.1(this), this, SystemClock.uptimeMillis() + 10000L);
      return;
    }
  }
  
  public Class clazz()
  {
    return AvGameConfBean.class;
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
      QLog.e("AvGameConfProcessor", 2, "onReqFailed " + paramInt);
    }
    a(paramInt);
  }
  
  public int type()
  {
    return 642;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AvGameConfProcessor
 * JD-Core Version:    0.7.0.1
 */