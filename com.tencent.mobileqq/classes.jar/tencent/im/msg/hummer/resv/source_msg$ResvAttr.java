package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class source_msg$ResvAttr
  extends MessageMicro<ResvAttr>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_richMsg2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_ori_msgtype = PBField.initUInt32(0);
  public final PBRepeatField<Long> uint64_orig_uids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_richMsg2", "uint32_ori_msgtype", "uint64_orig_uids" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L) }, ResvAttr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.resv.source_msg.ResvAttr
 * JD-Core Version:    0.7.0.1
 */