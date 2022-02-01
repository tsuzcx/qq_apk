package com.tencent.mobileqq.studyroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studyroom.utils.StudyRoomUtils;
import mqq.app.AppRuntime;

public class ShareToQQActivity
  extends QBaseActivity
{
  static boolean a;
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = getIntent().getStringExtra("sourceFrom");
    if ((TextUtils.equals(str, "StudyRoom")) || (TextUtils.equals(str, "StudyRoomQzone"))) {
      StudyRoomUtils.a((QQAppInterface)getAppRuntime(), this, paramInt2, paramIntent, str);
    }
    a = false;
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (a) {
      finish();
    }
    a = true;
    String str = paramBundle.getStringExtra("sourceFrom");
    if (paramBundle.getBooleanExtra("isLandscape", false)) {
      setRequestedOrientation(0);
    }
    if (TextUtils.equals(str, "StudyRoom"))
    {
      StudyRoomUtils.a(this, paramBundle.getExtras(), 1001);
      return true;
    }
    if (TextUtils.equals(str, "StudyRoomQzone"))
    {
      StudyRoomUtils.a(this, getAppRuntime().getCurrentAccountUin(), paramBundle.getExtras(), 1001);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.ShareToQQActivity
 * JD-Core Version:    0.7.0.1
 */