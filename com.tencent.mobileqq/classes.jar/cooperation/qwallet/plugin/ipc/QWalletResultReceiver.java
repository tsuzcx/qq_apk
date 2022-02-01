package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;

public class QWalletResultReceiver
  extends ResultReceiver
{
  private static Handler handler;
  private static QWalletResultReceiver instance;
  
  public QWalletResultReceiver(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public static void clear()
  {
    instance = null;
    handler = null;
  }
  
  public static QWalletResultReceiver getInstance()
  {
    if (instance == null)
    {
      if (Looper.myLooper() != null) {
        handler = new Handler(Looper.myLooper());
      }
      instance = new QWalletResultReceiver(handler);
    }
    return instance;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    paramBundle = BaseReq.getReq(paramBundle);
    if (paramBundle != null) {
      paramBundle.onReceive();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.QWalletResultReceiver
 * JD-Core Version:    0.7.0.1
 */