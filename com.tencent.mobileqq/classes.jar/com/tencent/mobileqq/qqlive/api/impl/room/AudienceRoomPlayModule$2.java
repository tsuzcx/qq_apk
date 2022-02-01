package com.tencent.mobileqq.qqlive.api.impl.room;

import android.content.Context;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class AudienceRoomPlayModule$2
  implements SDKInitListener
{
  AudienceRoomPlayModule$2(AudienceRoomPlayModule paramAudienceRoomPlayModule, Context paramContext, boolean paramBoolean) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoSdk init ");
    localStringBuilder.append(paramBoolean);
    QLog.i("AudienceRoomPlayModule", 1, localStringBuilder.toString());
    AudienceRoomPlayModule.access$102(this.this$0, false);
    if (paramBoolean)
    {
      AudienceRoomPlayModule.access$200(this.this$0, this.val$context, this.val$isMute);
      AudienceRoomPlayModule.access$300(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomPlayModule.2
 * JD-Core Version:    0.7.0.1
 */