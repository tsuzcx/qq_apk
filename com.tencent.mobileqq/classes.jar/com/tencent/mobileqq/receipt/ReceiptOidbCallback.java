package com.tencent.mobileqq.receipt;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import java.lang.ref.WeakReference;

abstract class ReceiptOidbCallback<T>
  extends ProtoUtils.TroopProtocolObserver
{
  protected T a;
  private WeakReference<T> a;
  
  ReceiptOidbCallback(T paramT)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramT);
  }
  
  abstract void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle);
  
  public final void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.jdField_a_of_type_JavaLangObject == null) {
      return;
    }
    a(paramInt, paramArrayOfByte, paramBundle);
    this.jdField_a_of_type_JavaLangObject = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptOidbCallback
 * JD-Core Version:    0.7.0.1
 */