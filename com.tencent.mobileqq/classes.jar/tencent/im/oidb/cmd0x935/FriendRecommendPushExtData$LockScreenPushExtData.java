package tencent.im.oidb.cmd0x935;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.oidb_0xc26.MayKnowPerson;

public final class FriendRecommendPushExtData$LockScreenPushExtData
  extends MessageMicro<LockScreenPushExtData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_msg_persons", "uint32_push_timestamp" }, new Object[] { null, Integer.valueOf(0) }, LockScreenPushExtData.class);
  public final PBRepeatMessageField<oidb_0xc26.MayKnowPerson> rpt_msg_persons = PBField.initRepeatMessage(oidb_0xc26.MayKnowPerson.class);
  public final PBUInt32Field uint32_push_timestamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x935.FriendRecommendPushExtData.LockScreenPushExtData
 * JD-Core Version:    0.7.0.1
 */