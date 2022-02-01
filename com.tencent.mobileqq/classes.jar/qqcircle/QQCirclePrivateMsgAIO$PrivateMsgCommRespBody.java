package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCirclePrivateMsgAIO$PrivateMsgCommRespBody
  extends MessageMicro<PrivateMsgCommRespBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_token = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_trans_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBSInt32Field sint32_result = PBField.initSInt32(0);
  public final PBUInt32Field uint32_freq_check = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_callback_after_send = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 58, 64 }, new String[] { "sint32_result", "bytes_err_msg", "uint64_from_uin", "uint64_to_uin", "bytes_token", "uint32_freq_check", "bytes_trans_info", "uint32_need_callback_after_send" }, new Object[] { localInteger, localByteStringMicro1, localLong, localLong, localByteStringMicro2, localInteger, localByteStringMicro3, localInteger }, PrivateMsgCommRespBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgAIO.PrivateMsgCommRespBody
 * JD-Core Version:    0.7.0.1
 */