package com.tencent.mobileqq.qqlive.api.verified;

import android.app.Activity;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.verified.QQLiveVerifyCallback;

public abstract interface IQQLiveVerifyService
  extends IQQLiveModule
{
  public static final String ACTION_FACE_VERIFY = "qqlive.faceverify";
  public static final String KEY_APP_ID = "app_id";
  public static final String KEY_CALLBACK_KEY = "callback_key";
  public static final String KEY_RESULT_CODE = "result_code";
  public static final String KEY_RESULT_FLAG = "result_flag";
  public static final String KEY_RESULT_MSG = "result_msg";
  public static final String MSG_TYPE = "msg_type";
  public static final int MSG_TYPE_FRAGMENT_DESTROY = 1000;
  public static final int MSG_TYPE_RESULT = 1001;
  
  public abstract void goToVerified(Activity paramActivity, QQLiveVerifyCallback paramQQLiveVerifyCallback);
  
  public abstract void notifyVerifyResult(int paramInt1, boolean paramBoolean, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyService
 * JD-Core Version:    0.7.0.1
 */