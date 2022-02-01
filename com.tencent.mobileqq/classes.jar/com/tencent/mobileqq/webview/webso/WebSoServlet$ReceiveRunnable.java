package com.tencent.mobileqq.webview.webso;

import android.os.Bundle;
import bhrs;

class WebSoServlet$ReceiveRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private boolean jdField_a_of_type_Boolean;
  
  public WebSoServlet$ReceiveRunnable(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void run()
  {
    bhrs.a().onReceive(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoServlet.ReceiveRunnable
 * JD-Core Version:    0.7.0.1
 */