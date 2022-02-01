package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.qphone.base.util.QLog;

class AudienceRoomPlayModule$1
  implements Runnable
{
  AudienceRoomPlayModule$1(AudienceRoomPlayModule paramAudienceRoomPlayModule) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("try play url is ");
    localStringBuilder.append(AudienceRoomPlayModule.access$000(this.this$0));
    QLog.e("AudienceRoomPlayModule", 1, localStringBuilder.toString());
    this.this$0.startPlay("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomPlayModule.1
 * JD-Core Version:    0.7.0.1
 */