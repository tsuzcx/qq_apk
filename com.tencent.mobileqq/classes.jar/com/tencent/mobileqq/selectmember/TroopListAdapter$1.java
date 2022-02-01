package com.tencent.mobileqq.selectmember;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;

class TroopListAdapter$1
  extends ProtoUtils.TroopProtocolObserver
{
  TroopListAdapter$1(TroopListAdapter paramTroopListAdapter) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    AppInterface localAppInterface = (AppInterface)this.mApp.get();
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      if (localAppInterface == null) {
        return;
      }
      ThreadManager.post(new TroopListAdapter.1.1(this, paramArrayOfByte, localAppInterface, paramBundle, new Handler(Looper.getMainLooper())), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopListAdapter.1
 * JD-Core Version:    0.7.0.1
 */