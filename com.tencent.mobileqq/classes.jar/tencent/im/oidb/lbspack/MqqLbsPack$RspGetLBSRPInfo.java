package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MqqLbsPack$RspGetLBSRPInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
  public MqqLbsPack.RspHead msg_head = new MqqLbsPack.RspHead();
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_head", "bytes_pid", "uint32_status" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0) }, RspGetLBSRPInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.lbspack.MqqLbsPack.RspGetLBSRPInfo
 * JD-Core Version:    0.7.0.1
 */