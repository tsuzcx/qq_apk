package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.userdata.userdata.FaceScore;

public final class oidb_0x85f$ReadFaceScoreRsp
  extends MessageMicro<ReadFaceScoreRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint64_user_id", "uint32_score_of_mine", "msg_score", "uint32_show_user", "uint32_score_to_me" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReadFaceScoreRsp.class);
  public final PBRepeatMessageField<userdata.FaceScore> msg_score = PBField.initRepeatMessage(userdata.FaceScore.class);
  public final PBUInt32Field uint32_score_of_mine = PBField.initUInt32(0);
  public final PBUInt32Field uint32_score_to_me = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_user = PBField.initUInt32(0);
  public final PBUInt64Field uint64_user_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x85f.oidb_0x85f.ReadFaceScoreRsp
 * JD-Core Version:    0.7.0.1
 */