package cooperation.qwallet.plugin.pay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

public class PayLogic$CompactReceiver
  extends ResultReceiver
{
  private WeakReference<PayLogic> mLogicRef;
  
  public PayLogic$CompactReceiver(Handler paramHandler, PayLogic paramPayLogic)
  {
    super(paramHandler);
    this.mLogicRef = new WeakReference(paramPayLogic);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    PayLogic localPayLogic = (PayLogic)this.mLogicRef.get();
    if (localPayLogic != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      localPayLogic.onActivityResult(3001, -1, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qwallet.plugin.pay.PayLogic.CompactReceiver
 * JD-Core Version:    0.7.0.1
 */