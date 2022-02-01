package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import com.tencent.mobileqq.soload.api.SoLoadManager;

public class TensorFlowlibManager
{
  private static volatile TensorFlowlibManager a;
  private boolean b = false;
  
  public static TensorFlowlibManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TensorFlowlibManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(TensorFlowlibManager.OnInitLibListener paramOnInitLibListener)
  {
    if (this.b)
    {
      if (paramOnInitLibListener != null) {
        paramOnInitLibListener.a(true);
      }
      return;
    }
    SoLoadManager.getInstance().load("tensorflowlite_jni", new TensorFlowlibManager.1(this, paramOnInitLibListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.TensorFlowlibManager
 * JD-Core Version:    0.7.0.1
 */