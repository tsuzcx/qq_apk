package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IQuicSoLoadApi;
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
    return ((IQuicSoLoadApi)QRoute.api(IQuicSoLoadApi.class)).loadQuicSo();
  }
  
  public void loadSo(ILoadSoCallback paramILoadSoCallback)
  {
    asyncLoadSo(paramILoadSoCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.LoadSoImp
 * JD-Core Version:    0.7.0.1
 */