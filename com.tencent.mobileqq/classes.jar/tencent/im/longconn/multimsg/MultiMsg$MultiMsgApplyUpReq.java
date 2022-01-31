package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MultiMsg$MultiMsgApplyUpReq
  extends MessageMicro<MultiMsgApplyUpReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_apply_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_msg_size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint64_dst_uin", "uint64_msg_size", "bytes_msg_md5", "uint32_msg_type", "uint32_apply_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, MultiMsgApplyUpReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyUpReq
 * JD-Core Version:    0.7.0.1
 */