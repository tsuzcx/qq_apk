package com.tencent.mobileqq.qqlive.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback;
import com.tencent.mobileqq.qqlive.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQLiveUtil
  extends QRouteApi
{
  public static final String COVER_INFO_KEY = "COVER_INFO_KEY";
  public static final String UPLOAD_ERROR_CODE = "upload_error_code";
  public static final String UPLOAD_ERROR_MESSAGE = "upload_error_message";
  
  public abstract boolean checkAvEnable(Context paramContext);
  
  public abstract void enterAnchorPrepareFragment(Context paramContext, boolean paramBoolean, Intent paramIntent);
  
  public abstract void enterCropFragment(Activity paramActivity, String paramString1, String paramString2, int paramInt);
  
  public abstract void enterLiveEndFragment(Context paramContext, boolean paramBoolean, Intent paramIntent, QQLiveEndPageInfo paramQQLiveEndPageInfo);
  
  public abstract IQQLiveEndView getAudienceEndLiveView(Context paramContext, IQQLiveSDK paramIQQLiveSDK, QQLiveEndPageInfo paramQQLiveEndPageInfo, EndLiveClickCallback paramEndLiveClickCallback);
  
  public abstract IQQLiveEndView getEndLiveView(QBaseActivity paramQBaseActivity, IQQLiveSDK paramIQQLiveSDK, QQLiveEndPageInfo paramQQLiveEndPageInfo, EndLiveClickCallback paramEndLiveClickCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.IQQLiveUtil
 * JD-Core Version:    0.7.0.1
 */