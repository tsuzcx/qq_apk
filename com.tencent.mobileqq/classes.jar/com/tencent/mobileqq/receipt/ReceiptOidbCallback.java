package com.tencent.mobileqq.receipt;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import java.lang.ref.WeakReference;

abstract class ReceiptOidbCallback<T>
  extends ProtoUtils.TroopProtocolObserver
{
  protected T a;
  private WeakReference<T> b;
  
  ReceiptOidbCallback(T paramT)
  {
    this.b = new WeakReference(paramT);
  }
  
  abstract void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle);
  
  public final void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.a = this.b.get();
    if (this.a == null) {
      return;
    }
    a(paramInt, paramArrayOfByte, paramBundle);
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptOidbCallback
 * JD-Core Version:    0.7.0.1
 */