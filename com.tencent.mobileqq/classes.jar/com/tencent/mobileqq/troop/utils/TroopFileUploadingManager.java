package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopFileUploadingManager
{
  public static TroopFileUploadingManager a;
  public QQAppInterface b;
  public BizTroopObserver c = new TroopFileUploadingManager.1(this);
  
  public static TroopFileUploadingManager a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (a == null)
      {
        c(paramQQAppInterface);
      }
      else if (a.b != paramQQAppInterface)
      {
        if (a.b != null)
        {
          a.b.removeObserver(a.c);
          a.b = null;
        }
        a = null;
        c(paramQQAppInterface);
      }
      paramQQAppInterface = a;
      return paramQQAppInterface;
    }
    finally {}
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    TroopFileUploadingManager localTroopFileUploadingManager = a;
    if (localTroopFileUploadingManager != null)
    {
      paramQQAppInterface.removeObserver(localTroopFileUploadingManager.c);
      a.b = null;
      a = null;
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    a = new TroopFileUploadingManager();
    TroopFileUploadingManager localTroopFileUploadingManager = a;
    localTroopFileUploadingManager.b = paramQQAppInterface;
    paramQQAppInterface.addObserver(localTroopFileUploadingManager.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileUploadingManager
 * JD-Core Version:    0.7.0.1
 */