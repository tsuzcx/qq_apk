package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$SourceMsg
  extends MessageMicro<SourceMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_richMsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_src_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_troop_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<im_msg_body.Elem> elems = PBField.initRepeatMessage(im_msg_body.Elem.class);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBRepeatField<Integer> uint32_orig_seqs = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 74, 80, 90 }, new String[] { "uint32_orig_seqs", "uint64_sender_uin", "uint32_time", "uint32_flag", "elems", "uint32_type", "bytes_richMsg", "bytes_pb_reserve", "bytes_src_msg", "uint64_to_uin", "bytes_troop_name" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4 }, SourceMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.SourceMsg
 * JD-Core Version:    0.7.0.1
 */