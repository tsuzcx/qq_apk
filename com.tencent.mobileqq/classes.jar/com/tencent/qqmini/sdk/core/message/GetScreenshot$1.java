package com.tencent.qqmini.sdk.core.message;

import android.app.ProgressDialog;
import bekg;

public class GetScreenshot$1
  implements Runnable
{
  public void run()
  {
    if (this.a != null)
    {
      bekg.a(this.this$0, new ProgressDialog(this.a));
      bekg.a(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.message.GetScreenshot.1
 * JD-Core Version:    0.7.0.1
 */