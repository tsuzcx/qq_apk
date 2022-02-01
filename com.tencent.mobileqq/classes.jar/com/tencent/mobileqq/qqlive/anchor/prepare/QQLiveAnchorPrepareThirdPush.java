package com.tencent.mobileqq.qqlive.anchor.prepare;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperThirdPush;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorThirdPushChecker;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.view.TPPlayerVideoView;
import com.tencent.qphone.base.util.QLog;

public class QQLiveAnchorPrepareThirdPush
  implements IQQLiveAnchorPrepareThirdPush
{
  private IQQLiveSDK a;
  private ViewGroup b;
  private QQLiveAnchorHelperThirdPush c = new QQLiveAnchorHelperThirdPush();
  private QQLiveAnchorThirdPushChecker d;
  private TPPlayerVideoView e;
  private boolean f = false;
  
  public void destroy()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("destroy, isDestroy:");
      localStringBuilder.append(this.f);
      QLog.d("QQLiveAnchor_PT", 1, localStringBuilder.toString());
    }
    this.f = true;
    stopCheck();
  }
  
  public void getPullInfo(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPullInfo, isDestory:");
      localStringBuilder.append(this.f);
      QLog.d("QQLiveAnchor_PT", 1, localStringBuilder.toString());
    }
    if (this.f) {
      return;
    }
    this.c.b(this.a, paramQQLiveAnchorRoomInfo, paramQQLiveAnchorAutoCheckPullPlayParams, new QQLiveAnchorPrepareThirdPush.1(this, paramIQQLiveAnchorRoomThirdPushCallback, paramQQLiveAnchorAutoCheckPullPlayParams));
  }
  
  public void getPushInfo(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPushInfo, isDestroy:");
      localStringBuilder.append(this.f);
      QLog.d("QQLiveAnchor_PT", 1, localStringBuilder.toString());
    }
    if (this.f) {
      return;
    }
    this.c.a(this.a, paramQQLiveAnchorRoomInfo, paramQQLiveAnchorAutoCheckPullPlayParams, paramIQQLiveAnchorRoomThirdPushCallback);
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.a = paramIQQLiveSDK;
  }
  
  public void onSelected(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelected: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", isDestroy:");
      localStringBuilder.append(this.f);
      QLog.d("QQLiveAnchor_PT", 1, localStringBuilder.toString());
    }
    if (!paramBoolean) {
      stopCheck();
    }
  }
  
  public void setPreViewContainer(ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setPreViewContainer, isDestroy:");
      ((StringBuilder)localObject).append(this.f);
      QLog.d("QQLiveAnchor_PT", 1, ((StringBuilder)localObject).toString());
    }
    if (this.f) {
      return;
    }
    Object localObject = this.b;
    int k = 0;
    int j = 0;
    int i = k;
    if (localObject != null)
    {
      TPPlayerVideoView localTPPlayerVideoView = this.e;
      i = k;
      if (localTPPlayerVideoView != null)
      {
        i = j;
        if (((ViewGroup)localObject).indexOfChild(localTPPlayerVideoView) != -1) {
          i = 1;
        }
        this.b.removeView(this.e);
      }
    }
    this.b = paramViewGroup;
    if (i != 0) {
      this.b.addView(this.e, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void startCheck(String paramString, QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startCheck, isDestroy:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", url:");
      localStringBuilder.append(paramString);
      QLog.d("QQLiveAnchor_PT", 1, localStringBuilder.toString());
    }
    if (this.f) {
      return;
    }
    if (this.d != null) {
      stopCheck();
    }
    this.d = new QQLiveAnchorThirdPushChecker(paramString, null, paramQQLiveAnchorAutoCheckPullPlayParams, paramIQQLiveAnchorRoomThirdPushCallback);
    this.e = this.d.a();
    paramString = this.b;
    if (paramString != null) {
      paramString.addView(this.e, new ViewGroup.LayoutParams(-1, -1));
    }
    this.d.a(paramQQLiveAnchorAutoCheckPullPlayParams.isMute);
  }
  
  public void stopCheck()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopCheck, isDestroy:");
      ((StringBuilder)localObject).append(this.f);
      QLog.d("QQLiveAnchor_PT", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(this.e);
    }
    this.e = null;
    localObject = this.d;
    if (localObject != null) {
      ((QQLiveAnchorThirdPushChecker)localObject).b(true);
    }
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.prepare.QQLiveAnchorPrepareThirdPush
 * JD-Core Version:    0.7.0.1
 */