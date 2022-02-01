package com.tencent.mobileqq.troop.utils;

public class UploadingFactory
{
  public static <T extends UploadingTask> T a(Class<T> paramClass)
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
  
  public static <T extends Thread> T a(Class<T> paramClass)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.UploadingFactory
 * JD-Core Version:    0.7.0.1
 */