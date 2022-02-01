package com.tencent.mobileqq.studyroom.api.impl;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studyroom.channel.StudyRoomObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.troop.studyroom.self_study_room_troop.StudyRoomMenberInfoRsp;

class StudyRoomManagerImpl$1
  extends StudyRoomObserver
{
  StudyRoomManagerImpl$1(StudyRoomManagerImpl paramStudyRoomManagerImpl) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetStudyRoomMemberCount error. troop:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" rsp:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString2);
    QLog.w("studyroom.proto.StudyRoomObserver", 2, localStringBuilder.toString());
  }
  
  public void a(String paramString, self_study_room_troop.StudyRoomMenberInfoRsp paramStudyRoomMenberInfoRsp)
  {
    int i = Math.max(paramStudyRoomMenberInfoRsp.member_count.get(), 0);
    StudyRoomManagerImpl.a(this.a, paramString, i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetStudyRoomMemberCountSucc troop:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" member_count:");
    localStringBuilder.append(paramStudyRoomMenberInfoRsp.member_count.get());
    QLog.d("studyroom.proto.StudyRoomObserver", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.impl.StudyRoomManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */