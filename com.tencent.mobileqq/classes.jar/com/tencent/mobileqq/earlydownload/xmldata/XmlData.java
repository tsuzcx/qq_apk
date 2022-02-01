package com.tencent.mobileqq.earlydownload.xmldata;

import asdd;
import asej;
import com.tencent.mobileqq.persistence.Entity;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class XmlData
  extends Entity
{
  public static final int STATE_LOADING = 2;
  public static final int STATE_NONE = 0;
  public static final int STATE_SUCCESS = 1;
  @asej(a=true, b=false)
  public String MD5;
  @asej(a=true, b=true)
  public boolean StoreBackup;
  @asej(a=true, b=true)
  public int Version;
  public long downSize;
  @asej(a=false, b=true)
  public boolean hasResDownloaded;
  public boolean isUserClick;
  @asej(a=true, b=true)
  public boolean load2G;
  @asej(a=true, b=true)
  public boolean load3G;
  @asej(a=false, b=true)
  public int loadState;
  @asej(a=true, b=true)
  public boolean loadWifi;
  @asej(a=true, b=true)
  public boolean net_2_2G;
  @asej(a=true, b=true)
  public boolean net_2_3G;
  @asej(a=true, b=true)
  public boolean net_2_wifi;
  @asej(a=true, b=true)
  public boolean notPreDownloadInLowEndPhone;
  public int reqLoadCount;
  public String strLog;
  @asej(a=true, b=true)
  public String strPkgName;
  @asej(a=true, b=true)
  public String strResName;
  @asej(a=true, b=false)
  public String strResURL_big;
  @asej(a=true, b=false)
  public String strResURL_small;
  @asej(a=false, b=true)
  public long tLoadFail;
  public long tStart;
  public long totalSize;
  
  public abstract String getSharedPreferencesName();
  
  public abstract String getStrResName();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (Class localClass = getClass(); localClass != Entity.class; localClass = localClass.getSuperclass())
    {
      Field[] arrayOfField = localClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = arrayOfField[i];
        if (Modifier.isStatic(((Field)localObject).getModifiers())) {}
        for (;;)
        {
          i += 1;
          break;
          if (((Field)localObject).isAnnotationPresent(asej.class))
          {
            if (!((Field)localObject).isAccessible()) {
              ((Field)localObject).setAccessible(true);
            }
            String str = ((Field)localObject).getName();
            try
            {
              localObject = ((Field)localObject).get(this);
              localStringBuilder.append(',');
              localStringBuilder.append(str);
              localStringBuilder.append('=');
              localStringBuilder.append(localObject);
            }
            catch (Exception localException) {}
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void updateServerInfo(XmlData paramXmlData)
  {
    if (paramXmlData == null) {}
    Field[] arrayOfField;
    do
    {
      return;
      arrayOfField = asdd.a(paramXmlData.getClass());
    } while ((arrayOfField == null) || (arrayOfField.length == 0));
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      if ((localField.isAnnotationPresent(asej.class)) && (((asej)localField.getAnnotation(asej.class)).a())) {}
      try
      {
        localField.set(this, localField.get(paramXmlData));
        i += 1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          localIllegalArgumentException.printStackTrace();
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.XmlData
 * JD-Core Version:    0.7.0.1
 */