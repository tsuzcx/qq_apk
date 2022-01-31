package com.tencent.mobileqq.richmedia.dc;

import ahsr;
import android.os.Handler;
import android.os.HandlerThread;

public class DataReport
{
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Reportor-Tasker");
  private static DataReport jdField_a_of_type_ComTencentMobileqqRichmediaDcDataReport = new DataReport();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  
  static
  {
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  public static DataReport a()
  {
    return jdField_a_of_type_ComTencentMobileqqRichmediaDcDataReport;
  }
  
  public void a(ahsr paramahsr)
  {
    if (paramahsr == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramahsr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DataReport
 * JD-Core Version:    0.7.0.1
 */