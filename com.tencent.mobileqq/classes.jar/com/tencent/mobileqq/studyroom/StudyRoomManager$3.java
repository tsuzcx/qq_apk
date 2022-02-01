package com.tencent.mobileqq.studyroom;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studyroom.channel.StudyRoomObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.troop.studyroom.self_study_room_troop.StudyRoomMenberInfoRsp;

class StudyRoomManager$3
  extends StudyRoomObserver
{
  StudyRoomManager$3(StudyRoomManager paramStudyRoomManager) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.w("studyroom.proto.StudyRoomObserver", 2, "onGetStudyRoomMemberCount error. troop:" + paramString1 + " rsp:" + paramInt + " msg:" + paramString2);
  }
  
  public void a(String paramString, self_study_room_troop.StudyRoomMenberInfoRsp paramStudyRoomMenberInfoRsp)
  {
    int i = Math.max(paramStudyRoomMenberInfoRsp.member_count.get(), 0);
    StudyRoomManager.a(this.a, paramString, i);
    QLog.d("studyroom.proto.StudyRoomObserver", 2, "onGetStudyRoomMemberCountSucc troop:" + paramString + " member_count:" + paramStudyRoomMenberInfoRsp.member_count.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.StudyRoomManager.3
 * JD-Core Version:    0.7.0.1
 */