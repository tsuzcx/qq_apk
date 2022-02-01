package com.tencent.mobileqq.uniformdownload.data;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.uniformdownload.util.SucDownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SucDownloadInfoMgr
{
  private boolean a = false;
  private List<SucDownloadInfo> b = new ArrayList();
  
  private SucDownloadInfo a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("SucDownloadInfoMgr", 1, "[UniformDL] sucInfoOfString err, str=null");
      return null;
    }
    String[] arrayOfString = paramString.split("\\^");
    if (arrayOfString.length < 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] sucInfoOfString err,l=");
      localStringBuilder.append(arrayOfString.length);
      localStringBuilder.append(" str=");
      localStringBuilder.append(paramString);
      QLog.e("SucDownloadInfoMgr", 1, localStringBuilder.toString());
      return null;
    }
    return new SucDownloadInfo(arrayOfString[0], Integer.parseInt(arrayOfString[1]));
  }
  
  public SharedPreferences a()
  {
    return BaseApplication.getContext().getSharedPreferences("download_suc_info", 0);
  }
  
  public String a(SucDownloadInfo paramSucDownloadInfo)
  {
    if (paramSucDownloadInfo == null)
    {
      QLog.e("SucDownloadInfoMgr", 1, "[UniformDL] stringOfSucInfo err, obj=null");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramSucDownloadInfo.a));
    localStringBuilder.append("^");
    localStringBuilder.append(String.valueOf(paramSucDownloadInfo.b));
    return localStringBuilder.toString();
  }
  
  public List<SucDownloadInfo> a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    if (!this.a)
    {
      b();
      this.a = true;
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      SucDownloadInfo localSucDownloadInfo;
      while (localIterator.hasNext())
      {
        localSucDownloadInfo = (SucDownloadInfo)localIterator.next();
        if (localSucDownloadInfo != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("package:");
          localStringBuilder.append(localSucDownloadInfo.a);
          if (paramString.equalsIgnoreCase(localStringBuilder.toString())) {
            localArrayList.add(localSucDownloadInfo);
          }
        }
      }
      if ((localArrayList.size() > 0) && (paramBoolean))
      {
        paramString = new StringBuilder();
        paramString.append("[UniformDL] getSucDownloadInfoOfPkg. remove before size:");
        paramString.append(this.b.size());
        QLog.i("SucDownloadInfoMgr", 1, paramString.toString());
        try
        {
          paramString = a().edit();
          localIterator = localArrayList.iterator();
          while (localIterator.hasNext())
          {
            localSucDownloadInfo = (SucDownloadInfo)localIterator.next();
            this.b.remove(localSucDownloadInfo);
            paramString.remove(a(localSucDownloadInfo));
          }
          paramString.commit();
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = new StringBuilder();
        paramString.append("[UniformDL] getSucDownloadInfoOfPkg. remove after size:");
        paramString.append(this.b.size());
        QLog.i("SucDownloadInfoMgr", 1, paramString.toString());
      }
      return localArrayList;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[UniformDL] removeSucDownloadInfo. pkgName:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" notificationId:");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.i("SucDownloadInfoMgr", 1, ((StringBuilder)localObject1).toString());
    Object localObject2 = null;
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (SucDownloadInfo)localIterator.next();
      } while ((localObject1 == null) || (!paramString.equalsIgnoreCase(((SucDownloadInfo)localObject1).a)) || (paramInt != ((SucDownloadInfo)localObject1).b));
      if (localObject1 != null)
      {
        this.b.remove(localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[UniformDL] removeSucDownloadInfo done. pkgName:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" notificationId:");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(" size:");
        ((StringBuilder)localObject1).append(this.b.size());
        QLog.i("SucDownloadInfoMgr", 1, ((StringBuilder)localObject1).toString());
      }
      try
      {
        localObject1 = a().edit();
        ((SharedPreferences.Editor)localObject1).remove(a(new SucDownloadInfo(paramString, paramInt)));
        ((SharedPreferences.Editor)localObject1).commit();
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void b()
  {
    try
    {
      QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] initSucDownloadInfo...");
      Object localObject1 = a().getAll();
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[UniformDL] initSucDownloadInfo, size:[");
        ((StringBuilder)localObject3).append(((Map)localObject1).size());
        ((StringBuilder)localObject3).append("]");
        QLog.i("SucDownloadInfoMgr", 1, ((StringBuilder)localObject3).toString());
      }
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = a((String)((Map.Entry)((Iterator)localObject1).next()).getKey());
          if (localObject3 != null)
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("[UniformDL] initSucDownloadInfo, pkgName:[");
            ((StringBuilder)???).append(((SucDownloadInfo)localObject3).a);
            ((StringBuilder)???).append("]] nId:[");
            ((StringBuilder)???).append(((SucDownloadInfo)localObject3).b);
            ((StringBuilder)???).append("] ");
            QLog.i("SucDownloadInfoMgr", 1, ((StringBuilder)???).toString());
            synchronized (this.b)
            {
              this.b.add(localObject3);
            }
          }
          QLog.e("SucDownloadInfoMgr", 1, "[UniformDL] initSucDownloadInfo, value error. ");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(SucDownloadInfo paramSucDownloadInfo)
  {
    if (paramSucDownloadInfo == null) {
      return;
    }
    if (!this.a)
    {
      b();
      this.a = true;
    }
    synchronized (this.b)
    {
      this.b.add(paramSucDownloadInfo);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] saveSucDownloadInfo. pkgName:");
      localStringBuilder.append(paramSucDownloadInfo.a);
      localStringBuilder.append(" notificationId:");
      localStringBuilder.append(paramSucDownloadInfo.b);
      localStringBuilder.append(" size:");
      localStringBuilder.append(this.b.size());
      QLog.i("SucDownloadInfoMgr", 1, localStringBuilder.toString());
      try
      {
        ??? = a().edit();
        ((SharedPreferences.Editor)???).putString(a(paramSucDownloadInfo), "-");
        ((SharedPreferences.Editor)???).commit();
        return;
      }
      catch (Exception paramSucDownloadInfo)
      {
        paramSucDownloadInfo.printStackTrace();
        return;
      }
    }
  }
  
  public void c()
  {
    synchronized (this.b)
    {
      int i = this.b.size();
      this.b.clear();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] clearSucDownloadInfo...size:");
      localStringBuilder.append(i);
      QLog.i("SucDownloadInfoMgr", 1, localStringBuilder.toString());
      try
      {
        ??? = a().edit();
        ((SharedPreferences.Editor)???).clear();
        ((SharedPreferences.Editor)???).commit();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.data.SucDownloadInfoMgr
 * JD-Core Version:    0.7.0.1
 */