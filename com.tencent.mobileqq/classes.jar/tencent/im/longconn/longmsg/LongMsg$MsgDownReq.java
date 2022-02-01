package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LongMsg$MsgDownReq
  extends MessageMicro<MsgDownReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_cache = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_uin = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_src_uin", "bytes_msg_resid", "uint32_msg_type", "uint32_need_cache" }, new Object[] { localInteger, localByteStringMicro, localInteger, localInteger }, MsgDownReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.longconn.longmsg.LongMsg.MsgDownReq
 * JD-Core Version:    0.7.0.1
 */