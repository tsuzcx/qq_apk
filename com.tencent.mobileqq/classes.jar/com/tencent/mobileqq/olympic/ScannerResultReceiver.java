package com.tencent.mobileqq.olympic;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import augt;
import com.tencent.mobileqq.ocr.activity.ScanBaseActivity;
import com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity;

public class ScannerResultReceiver
  extends ResultReceiver
{
  private ScanBaseActivity jdField_a_of_type_ComTencentMobileqqOcrActivityScanBaseActivity;
  private OlympicToolBaseActivity jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicToolBaseActivity;
  
  public ScannerResultReceiver(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void a(ScanBaseActivity paramScanBaseActivity)
  {
    augt.b("ScannerResultReceiver", new Object[] { "setActivity activity:", paramScanBaseActivity, this });
    this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanBaseActivity = paramScanBaseActivity;
  }
  
  public void a(OlympicToolBaseActivity paramOlympicToolBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicToolBaseActivity = paramOlympicToolBaseActivity;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    augt.b("ScannerResultReceiver", new Object[] { "mResultReceiver.onReceiveResult, resultCode=", Integer.valueOf(paramInt), this });
    if (paramInt == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanBaseActivity.a)) {
        this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanBaseActivity.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicToolBaseActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicToolBaseActivity.f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.ScannerResultReceiver
 * JD-Core Version:    0.7.0.1
 */