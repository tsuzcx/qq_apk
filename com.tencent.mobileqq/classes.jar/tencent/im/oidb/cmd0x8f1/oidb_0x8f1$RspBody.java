package tencent.im.oidb.cmd0x8f1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.label.comm.PersonalityTagComm.LabelInfo;

public final class oidb_0x8f1$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_label_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public PersonalityTagComm.LabelInfo msg_label_info = new PersonalityTagComm.LabelInfo();
  public final PBUInt32Field uint32_complete_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_label_info", "uint32_complete_flag", "bytes_label_cookie" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f1.oidb_0x8f1.RspBody
 * JD-Core Version:    0.7.0.1
 */