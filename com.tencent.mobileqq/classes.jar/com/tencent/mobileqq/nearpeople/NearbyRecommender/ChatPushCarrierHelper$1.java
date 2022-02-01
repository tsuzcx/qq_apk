package com.tencent.mobileqq.nearpeople.NearbyRecommender;

import EncounterSvc.RespEncounterInfo;
import com.tencent.mobileqq.app.face.IFaceDecoder;

class ChatPushCarrierHelper$1
  implements Runnable
{
  ChatPushCarrierHelper$1(ChatPushCarrierHelper paramChatPushCarrierHelper, String paramString, RespEncounterInfo paramRespEncounterInfo) {}
  
  public void run()
  {
    IFaceDecoder localIFaceDecoder = this.this$0.k;
    String str = this.a;
    int i;
    if (this.b.stranger_face_timestamp > 0) {
      i = this.b.stranger_face_timestamp;
    } else {
      i = this.b.common_face_timestamp;
    }
    localIFaceDecoder.refreshFaceWithTimeStamp(32, str, 202, i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper.1
 * JD-Core Version:    0.7.0.1
 */