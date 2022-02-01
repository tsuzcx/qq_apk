package com.tencent.mobileqq.troopcheckin;

import android.os.Bundle;
import com.tencent.mobileqq.highway.transaction.Transaction;

public class CheckInUploadPicTask
  extends CheckInUploadTask
{
  public CheckInUploadPicTask(CheckInResEntity paramCheckInResEntity, int paramInt)
  {
    super(paramCheckInResEntity, paramInt);
  }
  
  public void a()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqTroopcheckinCheckInResEntity.a)) {
      return;
    }
    e();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    boolean bool = false;
    localBundle.putInt("isVideo", 0);
    if (this.b != null)
    {
      localBundle.putInt("result", 1);
      localBundle.putString("url", this.b);
      bool = true;
    }
    else
    {
      localBundle.putInt("result", 0);
      localBundle.putString("error", "");
    }
    CheckInServer.a().a(bool, this.jdField_a_of_type_Int, localBundle);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopcheckin.CheckInUploadPicTask
 * JD-Core Version:    0.7.0.1
 */