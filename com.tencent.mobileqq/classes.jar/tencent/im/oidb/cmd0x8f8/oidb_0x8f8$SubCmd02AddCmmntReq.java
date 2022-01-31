package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;

public final class oidb_0x8f8$SubCmd02AddCmmntReq
  extends MessageMicro<SubCmd02AddCmmntReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public group_feeds.GroupFeedsMessage msg_comment = new group_feeds.GroupFeedsMessage();
  public final PBRepeatField<Long> rpt_concern_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_cmmnt_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "bytes_feeds_id", "msg_comment", "uint32_cmmnt_id", "rpt_concern_uin" }, new Object[] { localByteStringMicro, null, Integer.valueOf(0), Long.valueOf(0L) }, SubCmd02AddCmmntReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f8.oidb_0x8f8.SubCmd02AddCmmntReq
 * JD-Core Version:    0.7.0.1
 */