package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import android.util.SparseArray;

public abstract class BaseIpc
{
  protected static SparseArray a = new SparseArray();
  protected static SparseArray b = new SparseArray();
  
  static
  {
    a.put(1, GetRedPointInfoReq.class);
  }
  
  public void a(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.BaseIpc
 * JD-Core Version:    0.7.0.1
 */