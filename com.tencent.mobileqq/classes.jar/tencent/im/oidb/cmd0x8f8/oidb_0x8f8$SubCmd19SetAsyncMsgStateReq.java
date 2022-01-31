package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8f8$SubCmd19SetAsyncMsgStateReq
  extends MessageMicro<SubCmd19SetAsyncMsgStateReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> rpt_bytes_feeds_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_set_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_bytes_feeds_id", "uint32_set_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, SubCmd19SetAsyncMsgStateReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f8.oidb_0x8f8.SubCmd19SetAsyncMsgStateReq
 * JD-Core Version:    0.7.0.1
 */