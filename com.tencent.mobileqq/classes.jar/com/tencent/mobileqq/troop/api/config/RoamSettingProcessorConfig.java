package com.tencent.mobileqq.troop.api.config;

import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class RoamSettingProcessorConfig
{
  private static ArrayList<AbsRoamSettingProcessor> a = new ArrayList();
  private static RoamSettingProcessorConfig b;
  
  private RoamSettingProcessorConfig()
  {
    b();
  }
  
  public static RoamSettingProcessorConfig a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new RoamSettingProcessorConfig();
        }
      }
      finally {}
    }
    return b;
  }
  
  public int a(String paramString)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      int i = ((AbsRoamSettingProcessor)localIterator.next()).a(paramString);
      if (i != -1) {
        return i;
      }
    }
    return -1;
  }
  
  public String a(int paramInt)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      String str = ((AbsRoamSettingProcessor)localIterator.next()).a(paramInt);
      if (str != null) {
        return str;
      }
    }
    return "";
  }
  
  public void a(String paramString1, String paramString2)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsRoamSettingProcessor)localIterator.next()).a(paramString1, paramString2);
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsRoamSettingProcessor)localIterator.next()).a(paramArrayList);
    }
  }
  
  public String b(int paramInt)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      String str = ((AbsRoamSettingProcessor)localIterator.next()).b(paramInt);
      if (str != null) {
        return str;
      }
    }
    return "0";
  }
  
  public void b()
  {
    if (BizTroopCustomizedProcessorRegister.a != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsRoamSettingProcessor)((Class)localObject).newInstance();
          a.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("RoamSettingProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.RoamSettingProcessorConfig
 * JD-Core Version:    0.7.0.1
 */