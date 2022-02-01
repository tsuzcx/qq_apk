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
  private List<SucDownloadInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
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
      QLog.e("SucDownloadInfoMgr", 1, "[UniformDL] sucInfoOfString err,l=" + arrayOfString.length + " str=" + paramString);
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
    return String.valueOf(paramSucDownloadInfo.jdField_a_of_type_JavaLangString) + "^" + String.valueOf(paramSucDownloadInfo.jdField_a_of_type_Int);
  }
  
  public List<SucDownloadInfo> a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      a();
      this.jdField_a_of_type_Boolean = true;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    SucDownloadInfo localSucDownloadInfo;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localSucDownloadInfo = (SucDownloadInfo)localIterator.next();
        if ((localSucDownloadInfo != null) && (paramString.equalsIgnoreCase("package:" + localSucDownloadInfo.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localSucDownloadInfo);
        }
      }
    }
    if ((localArrayList.size() > 0) && (paramBoolean))
    {
      QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] getSucDownloadInfoOfPkg. remove before size:" + this.jdField_a_of_type_JavaUtilList.size());
      try
      {
        paramString = a().edit();
        localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          localSucDownloadInfo = (SucDownloadInfo)localIterator.next();
          this.jdField_a_of_type_JavaUtilList.remove(localSucDownloadInfo);
          paramString.remove(a(localSucDownloadInfo));
          continue;
          QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] getSucDownloadInfoOfPkg. remove after size:" + this.jdField_a_of_type_JavaUtilList.size());
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    for (;;)
    {
      return localArrayList;
      paramString.commit();
    }
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] initSucDownloadInfo...");
        ??? = a().getAll();
        if (??? != null) {
          QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] initSucDownloadInfo, size:[" + ((Map)???).size() + "]");
        }
        if ((??? != null) && (((Map)???).size() > 0))
        {
          Iterator localIterator = ((Map)???).entrySet().iterator();
          if (localIterator.hasNext())
          {
            SucDownloadInfo localSucDownloadInfo = a((String)((Map.Entry)localIterator.next()).getKey());
            if (localSucDownloadInfo == null) {
              break label196;
            }
            QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] initSucDownloadInfo, pkgName:[" + localSucDownloadInfo.jdField_a_of_type_JavaLangString + "]] nId:[" + localSucDownloadInfo.jdField_a_of_type_Int + "] ");
            synchronized (this.jdField_a_of_type_JavaUtilList)
            {
              this.jdField_a_of_type_JavaUtilList.add(localSucDownloadInfo);
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label196:
      QLog.e("SucDownloadInfoMgr", 1, "[UniformDL] initSucDownloadInfo, value error. ");
    }
  }
  
  public void a(SucDownloadInfo paramSucDownloadInfo)
  {
    if (paramSucDownloadInfo == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      a();
      this.jdField_a_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramSucDownloadInfo);
      QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] saveSucDownloadInfo. pkgName:" + paramSucDownloadInfo.jdField_a_of_type_JavaLangString + " notificationId:" + paramSucDownloadInfo.jdField_a_of_type_Int + " size:" + this.jdField_a_of_type_JavaUtilList.size());
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
  
  public void a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] removeSucDownloadInfo. pkgName:" + paramString + " notificationId:" + paramInt);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          localObject = (SucDownloadInfo)localIterator.next();
          if ((localObject == null) || (!paramString.equalsIgnoreCase(((SucDownloadInfo)localObject).jdField_a_of_type_JavaLangString)) || (paramInt != ((SucDownloadInfo)localObject).jdField_a_of_type_Int)) {
            continue;
          }
          if (localObject != null)
          {
            this.jdField_a_of_type_JavaUtilList.remove(localObject);
            QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] removeSucDownloadInfo done. pkgName:" + paramString + " notificationId:" + paramInt + " size:" + this.jdField_a_of_type_JavaUtilList.size());
          }
          try
          {
            localObject = a().edit();
            ((SharedPreferences.Editor)localObject).remove(a(new SucDownloadInfo(paramString, paramInt)));
            ((SharedPreferences.Editor)localObject).commit();
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
        }
      }
      Object localObject = null;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      this.jdField_a_of_type_JavaUtilList.clear();
      QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] clearSucDownloadInfo...size:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.data.SucDownloadInfoMgr
 * JD-Core Version:    0.7.0.1
 */