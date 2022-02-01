package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.quic.open.ILoadSo;
import com.tencent.mobileqq.transfile.quic.open.ILoadSoCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class LoadSoImp
  implements ILoadSo
{
  public static void asyncLoadSo(ILoadSoCallback paramILoadSoCallback)
  {
    ThreadManager.getFileThreadHandler().post(new LoadSoImp.1(paramILoadSoCallback));
  }
  
  private static boolean realLoadQuicSo()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      QLog.e("quic", 4, "realLoadQuicSo,target version not support.");
      return false;
    }
    try
    {
      System.load(Utils.getAndromedaSoPath());
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          System.load(Utils.getQuicEngineSoPath());
          return true;
          localThrowable1 = localThrowable1;
          try
          {
            System.load(Utils.getAndromedaSoPath());
          }
          catch (Throwable localThrowable2)
          {
            QLog.e("quic", 4, "cannot load library quic_engine", localThrowable2);
            return false;
          }
        }
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          System.load(Utils.getQuicEngineSoPath());
        }
      }
    }
  }
  
  public void loadSo(ILoadSoCallback paramILoadSoCallback)
  {
    asyncLoadSo(paramILoadSoCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.LoadSoImp
 * JD-Core Version:    0.7.0.1
 */