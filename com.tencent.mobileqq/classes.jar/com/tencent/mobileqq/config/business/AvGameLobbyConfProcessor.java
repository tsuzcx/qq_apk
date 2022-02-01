package com.tencent.mobileqq.config.business;

import com.tencent.avgame.config.data.AvGameLobbyConfBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class AvGameLobbyConfProcessor
  extends IQConfigProcessor<AvGameLobbyConfBean>
{
  private final List<AvGameLobbyConfProcessor.OnGetConfigListener> a = new LinkedList();
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[notifyListeners]:");
      ((StringBuilder)???).append(this.a.size());
      QLog.d("AvGameLobbyConfProcessor", 2, ((StringBuilder)???).toString());
    }
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
    try
    {
      synchronized (this.a)
      {
        if (this.a.size() > 0)
        {
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
          this.a.clear();
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvGameLobbyConfProcessor", 1, localThrowable1, new Object[0]);
      }
    }
  }
  
  public AvGameLobbyConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AvGameLobbyConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new AvGameLobbyConfBean();
  }
  
  public AvGameLobbyConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameLobbyConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem.length);
        QLog.d("AvGameLobbyConfProcessor", 2, localStringBuilder.toString());
      }
      return AvGameLobbyConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(AvGameLobbyConfBean paramAvGameLobbyConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      if (paramAvGameLobbyConfBean != null) {
        paramAvGameLobbyConfBean = paramAvGameLobbyConfBean.toString();
      } else {
        paramAvGameLobbyConfBean = " empty";
      }
      localStringBuilder.append(paramAvGameLobbyConfBean);
      QLog.d("AvGameLobbyConfProcessor", 2, localStringBuilder.toString());
    }
    b(0);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.e("AvGameLobbyConfProcessor", 2, localStringBuilder.toString());
    }
    b(paramInt);
  }
  
  public int type()
  {
    return 713;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AvGameLobbyConfProcessor
 * JD-Core Version:    0.7.0.1
 */