package tencent.im.troop.studyroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class self_study_room_troop$StudyRoomMemberInfoReq
  extends MessageMicro<StudyRoomMemberInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "troop_uin" }, new Object[] { "" }, StudyRoomMemberInfoReq.class);
  public final PBStringField troop_uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.troop.studyroom.self_study_room_troop.StudyRoomMemberInfoReq
 * JD-Core Version:    0.7.0.1
 */