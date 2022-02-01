package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x85f$ReadFaceScoreBatchReq
  extends MessageMicro<ReadFaceScoreBatchReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_req_list" }, new Object[] { null }, ReadFaceScoreBatchReq.class);
  public final PBRepeatMessageField<oidb_0x85f.ReadFaceScoreReq> msg_req_list = PBField.initRepeatMessage(oidb_0x85f.ReadFaceScoreReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x85f.oidb_0x85f.ReadFaceScoreBatchReq
 * JD-Core Version:    0.7.0.1
 */