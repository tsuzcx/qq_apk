package com.tencent.mobileqq.database.corrupt;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;

public class DBFixDialogActivity
  extends BaseActivity
{
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    new DBFixDialogUI(this, this.app).b();
    return true;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogActivity
 * JD-Core Version:    0.7.0.1
 */