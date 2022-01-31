package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class MqqLbsPack$RspGetLBSPID
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
  public MqqLbsPack.RspHead msg_head = new MqqLbsPack.RspHead();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "bytes_pid" }, new Object[] { null, localByteStringMicro }, RspGetLBSPID.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.lbspack.MqqLbsPack.RspGetLBSPID
 * JD-Core Version:    0.7.0.1
 */