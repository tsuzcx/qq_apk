package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$StudyRoomMemberChangePush
  extends MessageMicro<StudyRoomMemberChangePush>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "member_count" }, new Object[] { Integer.valueOf(0) }, StudyRoomMemberChangePush.class);
  public final PBUInt32Field member_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.StudyRoomMemberChangePush
 * JD-Core Version:    0.7.0.1
 */