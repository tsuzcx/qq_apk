package com.tencent.mobileqq.widget.share;

import android.content.Context;
import bhmw;
import com.tencent.mobileqq.widget.QQToast;

public class Validator$1
  implements Runnable
{
  public Validator$1(bhmw parambhmw, String paramString) {}
  
  public void run()
  {
    Context localContext = bhmw.a(this.this$0).mOutAct;
    if (localContext != null) {
      QQToast.a(localContext, this.a, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.Validator.1
 * JD-Core Version:    0.7.0.1
 */