package com.tencent.mobileqq.qqlive.api.impl.room;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.impl.room.report.AudienceRoomTechReporter;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import com.tencent.qphone.base.util.QLog;

class AudienceRoomImpl$3
  implements EnterAudienceRoomCallback
{
  AudienceRoomImpl$3(AudienceRoomImpl paramAudienceRoomImpl, EnterRoomInfo paramEnterRoomInfo, boolean paramBoolean, EnterAudienceRoomCallback paramEnterAudienceRoomCallback) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.val$roomInfo.getRoomId());
    localStringBuilder.append(" enterRoom Failed code is ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" :");
    localStringBuilder.append(paramString);
    QLog.e("AudienceRoomImpl", 1, localStringBuilder.toString());
    this.val$callback.onFailed(paramInt, paramString);
    this.this$0.techReporter.onFailed(paramInt, paramString);
  }
  
  public void onSuccess(LiveInfo paramLiveInfo)
  {
    String str = paramLiveInfo.watchMediaInfo.getMediaUrl();
    if (TextUtils.isEmpty(str))
    {
      onFailed(5107, "url is empty");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.val$roomInfo.getRoomId());
    localStringBuilder.append(" enterRoomSuccess url is ");
    localStringBuilder.append(str);
    QLog.i("AudienceRoomImpl", 1, localStringBuilder.toString());
    this.this$0.onEnterRoom();
    if (this.val$autoPlay) {
      this.this$0.startPlay(str);
    } else if ((this.this$0.playModule != null) && (TextUtils.isEmpty(this.this$0.playModule.getPlayUrl()))) {
      this.this$0.playModule.setPlayUrl(str);
    }
    this.val$callback.onSuccess(paramLiveInfo);
    this.this$0.techReporter.onSuccess(paramLiveInfo);
    AudienceRoomImpl.access$100(this.this$0, paramLiveInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomImpl.3
 * JD-Core Version:    0.7.0.1
 */