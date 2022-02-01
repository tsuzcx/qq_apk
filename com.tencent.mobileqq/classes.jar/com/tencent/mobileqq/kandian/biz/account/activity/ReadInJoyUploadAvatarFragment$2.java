package com.tencent.mobileqq.kandian.biz.account.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;

class ReadInJoyUploadAvatarFragment$2
  extends Handler
{
  ReadInJoyUploadAvatarFragment$2(ReadInJoyUploadAvatarFragment paramReadInJoyUploadAvatarFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    BaseActivity localBaseActivity = this.a.getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    Intent localIntent = localBaseActivity.getIntent();
    Bundle localBundle = new Bundle();
    if (paramMessage.what != 1003)
    {
      localBundle.putString("msg", HardCodeUtil.a(2131712962));
      localBundle.putInt("retCode", 3);
      localIntent.putExtra("Bundle", localBundle);
      localBaseActivity.setResult(-1, localIntent);
    }
    else
    {
      localBundle.putString("url", (String)paramMessage.obj);
      localBundle.putInt("retCode", 0);
      localBundle.putString("msg", HardCodeUtil.a(2131713020));
      localIntent.putExtra("Bundle", localBundle);
      localBaseActivity.setResult(-1, localIntent);
    }
    localBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.activity.ReadInJoyUploadAvatarFragment.2
 * JD-Core Version:    0.7.0.1
 */