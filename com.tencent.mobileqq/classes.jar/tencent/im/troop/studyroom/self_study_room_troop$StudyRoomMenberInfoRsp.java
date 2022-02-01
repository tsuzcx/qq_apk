package tencent.im.troop.studyroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class self_study_room_troop$StudyRoomMenberInfoRsp
  extends MessageMicro<StudyRoomMenberInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "member_count", "member_uins" }, new Object[] { Integer.valueOf(0), "" }, StudyRoomMenberInfoRsp.class);
  public final PBUInt32Field member_count = PBField.initUInt32(0);
  public final PBRepeatField<String> member_uins = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.troop.studyroom.self_study_room_troop.StudyRoomMenberInfoRsp
 * JD-Core Version:    0.7.0.1
 */