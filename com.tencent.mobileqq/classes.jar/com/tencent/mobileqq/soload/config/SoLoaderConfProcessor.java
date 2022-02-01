package com.tencent.mobileqq.soload.config;

import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.soload.biz.entity.SoLoadConfBean;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SoLoaderConfProcessor
  extends IQConfigProcessor<SoLoadConfBean>
{
  private static final Handler a = new Handler(ThreadManagerV2.getSubThreadLooper());
  private final List<SoLoaderConfProcessor.OnGetConfigListener> b = new LinkedList();
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[notifyListeners]:");
      ((StringBuilder)???).append(this.b.size());
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, ((StringBuilder)???).toString());
    }
    a.removeCallbacksAndMessages(this);
    try
    {
      synchronized (this.b)
      {
        if (this.b.size() > 0)
        {
          Iterator localIterator = this.b.iterator();
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
          this.b.clear();
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
  
  private void c(int paramInt)
  {
    SoDataUtil.b();
    b(paramInt);
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
    c(0);
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
    synchronized (this.b)
    {
      if (this.b.size() > 0)
      {
        this.b.add(paramOnGetConfigListener);
        return;
      }
      this.b.add(paramOnGetConfigListener);
      QConfigManager.b().a(526, 0);
      QConfigManager.b().a(new int[] { 526 });
      a.removeCallbacksAndMessages(this);
      a.postAtTime(new SoLoaderConfProcessor.1(this), this, SystemClock.uptimeMillis() + 35000L);
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
    c(paramInt);
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqNoReceive: type=");
      localStringBuilder.append(type());
      localStringBuilder.append("curContent:");
      localStringBuilder.append(QConfigManager.b().b(526));
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, localStringBuilder.toString());
    }
    c(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.config.SoLoaderConfProcessor
 * JD-Core Version:    0.7.0.1
 */