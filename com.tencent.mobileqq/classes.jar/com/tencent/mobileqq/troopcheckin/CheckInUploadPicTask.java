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
    if (a(this.a.a)) {
      return;
    }
    e();
  }
  
  public void b()
  {
    if (this.e) {
      c();
    }
  }
  
  public void c()
  {
    Bundle localBundle = new Bundle();
    boolean bool = false;
    localBundle.putInt("isVideo", 0);
    if (this.d != null)
    {
      localBundle.putInt("result", 1);
      localBundle.putString("url", this.d);
      bool = true;
    }
    else
    {
      localBundle.putInt("result", 0);
      localBundle.putString("error", "");
    }
    CheckInServer.a().a(bool, this.c, localBundle);
  }
  
  public void d()
  {
    if (this.f != null) {
      this.f.cancelTransaction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopcheckin.CheckInUploadPicTask
 * JD-Core Version:    0.7.0.1
 */