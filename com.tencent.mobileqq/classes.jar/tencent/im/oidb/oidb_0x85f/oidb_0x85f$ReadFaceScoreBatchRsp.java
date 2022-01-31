package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x85f$ReadFaceScoreBatchRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_rsp_list" }, new Object[] { null }, ReadFaceScoreBatchRsp.class);
  public final PBRepeatMessageField msg_rsp_list = PBField.initRepeatMessage(oidb_0x85f.ReadFaceScoreRsp.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x85f.oidb_0x85f.ReadFaceScoreBatchRsp
 * JD-Core Version:    0.7.0.1
 */