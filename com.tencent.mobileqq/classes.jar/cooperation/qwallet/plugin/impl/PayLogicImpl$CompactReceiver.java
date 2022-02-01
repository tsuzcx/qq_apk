package cooperation.qwallet.plugin.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

public class PayLogicImpl$CompactReceiver
  extends ResultReceiver
{
  private WeakReference<PayLogicImpl> mLogicRef;
  
  public PayLogicImpl$CompactReceiver(Handler paramHandler, PayLogicImpl paramPayLogicImpl)
  {
    super(paramHandler);
    this.mLogicRef = new WeakReference(paramPayLogicImpl);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    PayLogicImpl localPayLogicImpl = (PayLogicImpl)this.mLogicRef.get();
    if (localPayLogicImpl != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      localPayLogicImpl.onActivityResult(3001, -1, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.PayLogicImpl.CompactReceiver
 * JD-Core Version:    0.7.0.1
 */