package com.tencent.mobileqq.kandian.biz.account.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;

class ReadInJoyUploadAvatarFragment$1$1
  implements DialogInterface.OnCancelListener
{
  ReadInJoyUploadAvatarFragment$1$1(ReadInJoyUploadAvatarFragment.1 param1) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a.a.getIntent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("retCode", 1);
    localBundle.putString("msg", HardCodeUtil.a(2131910586));
    paramDialogInterface.putExtra("Bundle", localBundle);
    this.a.a.setResult(-1, paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.activity.ReadInJoyUploadAvatarFragment.1.1
 * JD-Core Version:    0.7.0.1
 */