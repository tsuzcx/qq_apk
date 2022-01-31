package com.tencent.mobileqq.nearpeople.NearbyRecommender;

import EncounterSvc.RespEncounterInfo;
import avud;
import bdbb;

public class ChatPushCarrierHelper$2
  implements Runnable
{
  public ChatPushCarrierHelper$2(avud paramavud, String paramString, RespEncounterInfo paramRespEncounterInfo) {}
  
  public void run()
  {
    bdbb localbdbb = this.this$0.a;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_EncounterSvcRespEncounterInfo.stranger_face_timestamp > 0) {}
    for (long l = this.jdField_a_of_type_EncounterSvcRespEncounterInfo.stranger_face_timestamp;; l = this.jdField_a_of_type_EncounterSvcRespEncounterInfo.common_face_timestamp)
    {
      localbdbb.a(32, str, 200, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper.2
 * JD-Core Version:    0.7.0.1
 */