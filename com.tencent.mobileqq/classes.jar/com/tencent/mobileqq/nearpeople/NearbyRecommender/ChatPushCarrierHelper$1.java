package com.tencent.mobileqq.nearpeople.NearbyRecommender;

import EncounterSvc.RespEncounterInfo;
import com.tencent.mobileqq.app.face.IFaceDecoder;

class ChatPushCarrierHelper$1
  implements Runnable
{
  ChatPushCarrierHelper$1(ChatPushCarrierHelper paramChatPushCarrierHelper, String paramString, RespEncounterInfo paramRespEncounterInfo) {}
  
  public void run()
  {
    IFaceDecoder localIFaceDecoder = this.this$0.a;
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    if (this.jdField_a_of_type_EncounterSvcRespEncounterInfo.stranger_face_timestamp > 0) {
      i = this.jdField_a_of_type_EncounterSvcRespEncounterInfo.stranger_face_timestamp;
    } else {
      i = this.jdField_a_of_type_EncounterSvcRespEncounterInfo.common_face_timestamp;
    }
    localIFaceDecoder.refreshFaceWithTimeStamp(32, str, 202, i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper.1
 * JD-Core Version:    0.7.0.1
 */