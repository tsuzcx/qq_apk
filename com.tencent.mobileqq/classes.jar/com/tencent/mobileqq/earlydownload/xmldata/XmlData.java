package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.persistence.Entity;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class XmlData
  extends Entity
{
  public static final int STATE_LOADING = 2;
  public static final int STATE_NONE = 0;
  public static final int STATE_SUCCESS = 1;
  @saveInSP(a=true, b=false)
  public String MD5;
  @saveInSP(a=true, b=true)
  public boolean StoreBackup;
  @saveInSP(a=true, b=true)
  public int Version;
  public long downSize;
  @saveInSP(a=false, b=true)
  public boolean hasResDownloaded;
  public boolean isUserClick;
  @saveInSP(a=true, b=true)
  public boolean load2G;
  @saveInSP(a=true, b=true)
  public boolean load3G;
  @saveInSP(a=false, b=true)
  public int loadState;
  @saveInSP(a=true, b=true)
  public boolean loadWifi;
  @saveInSP(a=true, b=true)
  public boolean net_2_2G;
  @saveInSP(a=true, b=true)
  public boolean net_2_3G;
  @saveInSP(a=true, b=true)
  public boolean net_2_wifi;
  @saveInSP(a=true, b=true)
  public boolean notPreDownloadInLowEndPhone;
  public int reqLoadCount;
  public String strLog;
  @saveInSP(a=true, b=true)
  public String strPkgName;
  @saveInSP(a=true, b=true)
  public String strResName;
  @saveInSP(a=true, b=false)
  public String strResURL_big;
  @saveInSP(a=true, b=false)
  public String strResURL_small;
  @saveInSP(a=false, b=true)
  public long tLoadFail;
  public long tStart;
  public long totalSize;
  
  public static String packageNameOf(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = ((IEarlyDownloadService)paramAppInterface.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler(paramString);
    if ((paramAppInterface != null) && (paramAppInterface.h() != null)) {
      return paramAppInterface.h().strPkgName;
    }
    return "(null)";
  }
  
  public abstract String getSharedPreferencesName();
  
  public abstract String getStrResName();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Class localClass = getClass();
    for (;;)
    {
      int i;
      label32:
      Object localObject;
      String str;
      if (localClass != Entity.class)
      {
        Field[] arrayOfField = localClass.getDeclaredFields();
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          localObject = arrayOfField[i];
          if ((!Modifier.isStatic(((Field)localObject).getModifiers())) && (((Field)localObject).isAnnotationPresent(saveInSP.class)))
          {
            if (!((Field)localObject).isAccessible()) {
              ((Field)localObject).setAccessible(true);
            }
            str = ((Field)localObject).getName();
          }
        }
      }
      try
      {
        localObject = ((Field)localObject).get(this);
        localStringBuilder.append(',');
        localStringBuilder.append(str);
        localStringBuilder.append('=');
        localStringBuilder.append(localObject);
        label128:
        i += 1;
        break label32;
        localClass = localClass.getSuperclass();
        continue;
        return localStringBuilder.toString();
      }
      catch (Exception localException)
      {
        break label128;
      }
    }
  }
  
  public void updateServerInfo(XmlData paramXmlData)
  {
    if (paramXmlData == null) {
      return;
    }
    Field[] arrayOfField = EarlyDataFactory.b(paramXmlData.getClass());
    if (arrayOfField != null)
    {
      if (arrayOfField.length == 0) {
        return;
      }
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        if ((localField.isAnnotationPresent(saveInSP.class)) && (((saveInSP)localField.getAnnotation(saveInSP.class)).a())) {
          try
          {
            localField.set(this, localField.get(paramXmlData));
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            localIllegalArgumentException.printStackTrace();
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.XmlData
 * JD-Core Version:    0.7.0.1
 */