package com.tencent.mobileqq.kandian.glue.viola.view;

import android.os.Looper;
import com.tencent.nativevue.NativeVueEngine.DomResult;

class ViolaBaseView$24
  implements NativeVueEngine.DomResult
{
  ViolaBaseView$24(ViolaBaseView paramViolaBaseView) {}
  
  public void onResult(String paramString)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ViolaBaseView.b(this.a, paramString);
      return;
    }
    this.a.post(new ViolaBaseView.24.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.24
 * JD-Core Version:    0.7.0.1
 */