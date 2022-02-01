package com.tencent.timi.game.databasecore.impl;

import com.tencent.timi.game.utils.Logger;

class YesDataBaseHelper$1
  implements Runnable
{
  YesDataBaseHelper$1(YesDataBaseHelper paramYesDataBaseHelper) {}
  
  public void run()
  {
    try
    {
      if (!YesDataBaseHelper.a(this.this$0).verifyAuthentication())
      {
        Logger.c("YesDataBaseHelper", "getEntityManagerFactory verify fail! ");
        return;
      }
    }
    catch (Exception localException)
    {
      Logger.a("YesDataBaseHelper", "getEntityManagerFactory verify error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.databasecore.impl.YesDataBaseHelper.1
 * JD-Core Version:    0.7.0.1
 */