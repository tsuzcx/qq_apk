package com.tencent.mobileqq.widget.share;

import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;

class Validator$1
  implements Runnable
{
  Validator$1(Validator paramValidator, String paramString) {}
  
  public void run()
  {
    Context localContext = Validator.a(this.this$0).a;
    if (localContext != null) {
      QQToast.a(localContext, this.a, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.Validator.1
 * JD-Core Version:    0.7.0.1
 */