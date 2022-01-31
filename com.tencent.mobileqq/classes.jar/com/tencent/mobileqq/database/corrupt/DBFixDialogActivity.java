package com.tencent.mobileqq.database.corrupt;

import android.content.Intent;
import android.os.Bundle;
import ankn;
import com.tencent.mobileqq.app.BaseActivity;

public class DBFixDialogActivity
  extends BaseActivity
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    new ankn(this, this.app).b();
    return true;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogActivity
 * JD-Core Version:    0.7.0.1
 */