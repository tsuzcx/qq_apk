package com.tencent.mobileqq.qwallet.transaction.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppActivity;

final class ToPayManagerImpl$5
  extends ResultReceiver
{
  ToPayManagerImpl$5(Handler paramHandler, WeakReference paramWeakReference, ResultReceiver paramResultReceiver, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 99999) {
      return;
    }
    AppActivity localAppActivity = (AppActivity)this.a.get();
    if (localAppActivity != null)
    {
      if (localAppActivity.isFinishing()) {
        return;
      }
      localAppActivity.runOnUiThread(new ToPayManagerImpl.5.1(this, paramInt, paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */