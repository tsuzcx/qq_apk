package com.tencent.mobileqq.soload.config;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.soload.biz.entity.SoLoadConfBean;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class SoLoaderConfProcessor
  extends IQConfigProcessor<SoLoadConfBean>
{
  private final List<SoLoaderConfProcessor.OnGetConfigListener> a = new LinkedList();
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[notifyListeners]:");
      ((StringBuilder)???).append(this.a.size());
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, ((StringBuilder)???).toString());
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
            SoLoaderConfProcessor.OnGetConfigListener localOnGetConfigListener = (SoLoaderConfProcessor.OnGetConfigListener)localIterator.next();
            try
            {
              localOnGetConfigListener.a(paramInt);
            }
            catch (Throwable localThrowable2) {}
            if (QLog.isColorLevel()) {
              QLog.e("SoLoadWidget.SoLoadConfProcessor", 1, localThrowable2, new Object[0]);
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
        QLog.e("SoLoadWidget.SoLoadConfProcessor", 1, localThrowable1, new Object[0]);
      }
    }
  }
  
  private void b(int paramInt)
  {
    SoDataUtil.a();
    a(paramInt);
  }
  
  @NonNull
  public SoLoadConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new SoLoadConfBean();
  }
  
  @Nullable
  public SoLoadConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onParsed]");
    }
    SoLoadConfBean localSoLoadConfBean = new SoLoadConfBean();
    localSoLoadConfBean.confFiles = paramArrayOfQConfItem;
    return localSoLoadConfBean;
  }
  
  public void a(SoLoadConfBean paramSoLoadConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onUpdate] newConf:");
      localStringBuilder.append(paramSoLoadConfBean);
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, localStringBuilder.toString());
    }
    SoConfigManager.a().a(paramSoLoadConfBean);
    b(0);
  }
  
  public void a(SoLoaderConfProcessor.OnGetConfigListener paramOnGetConfigListener)
  {
    a(paramOnGetConfigListener, true);
  }
  
  public void a(SoLoaderConfProcessor.OnGetConfigListener paramOnGetConfigListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[getConfig]");
    }
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        this.a.add(paramOnGetConfigListener);
        return;
      }
      this.a.add(paramOnGetConfigListener);
      QConfigManager.a().a(526, 0);
      QConfigManager.a().a(new int[] { 526 });
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      ThreadManager.getSubThreadHandler().postAtTime(new SoLoaderConfProcessor.1(this), this, SystemClock.uptimeMillis() + 35000L);
      return;
    }
  }
  
  public Class<SoLoadConfBean> clazz()
  {
    return SoLoadConfBean.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[get migrateOldVersion]");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReqFailed] failCode=");
      localStringBuilder.append(paramInt);
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, localStringBuilder.toString());
    }
    b(paramInt);
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqNoReceive: type=");
      localStringBuilder.append(type());
      localStringBuilder.append("curContent:");
      localStringBuilder.append(QConfigManager.a().a(526));
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, localStringBuilder.toString());
    }
    b(0);
  }
  
  public int onSend(int paramInt)
  {
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 526;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.config.SoLoaderConfProcessor
 * JD-Core Version:    0.7.0.1
 */