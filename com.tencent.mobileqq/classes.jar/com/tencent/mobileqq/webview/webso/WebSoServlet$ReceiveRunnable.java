package com.tencent.mobileqq.webview.webso;

import android.os.Bundle;

class WebSoServlet$ReceiveRunnable
  implements Runnable
{
  private int a;
  private boolean b;
  private Bundle c;
  
  public WebSoServlet$ReceiveRunnable(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a = paramInt;
    this.b = paramBoolean;
    this.c = paramBundle;
  }
  
  public void run()
  {
    WebSoCgiService.a().onReceive(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoServlet.ReceiveRunnable
 * JD-Core Version:    0.7.0.1
 */