package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x85f$ReadScoreListRsp
  extends MessageMicro<ReadScoreListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_rsp_list", "uint32_index_end" }, new Object[] { null, Integer.valueOf(0) }, ReadScoreListRsp.class);
  public final PBRepeatMessageField<oidb_0x85f.ReadFaceScoreRsp> msg_rsp_list = PBField.initRepeatMessage(oidb_0x85f.ReadFaceScoreRsp.class);
  public final PBUInt32Field uint32_index_end = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x85f.oidb_0x85f.ReadScoreListRsp
 * JD-Core Version:    0.7.0.1
 */