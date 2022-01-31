package com.tencent.mobileqq.troop.utils;

public class UploadingFactory
{
  public static UploadingTask a(Class paramClass)
  {
    try
    {
      paramClass = (UploadingTask)Class.forName(paramClass.getName()).newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Thread a(Class paramClass)
  {
    try
    {
      paramClass = (TroopUploadingThread)Class.forName(paramClass.getName()).newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.UploadingFactory
 * JD-Core Version:    0.7.0.1
 */