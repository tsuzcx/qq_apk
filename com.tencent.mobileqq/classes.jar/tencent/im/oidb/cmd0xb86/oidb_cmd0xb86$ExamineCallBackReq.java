package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb86$ExamineCallBackReq
  extends MessageMicro<ExamineCallBackReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_examine_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xb86.ExamineDesc msg_desc = new oidb_cmd0xb86.ExamineDesc();
  public oidb_cmd0xb86.ExamineHead msg_head = new oidb_cmd0xb86.ExamineHead();
  public oidb_cmd0xb86.ExamineNick msg_nick = new oidb_cmd0xb86.ExamineNick();
  public final PBUInt64Field uint64_ret = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "msg_nick", "msg_head", "msg_desc", "uint64_ret", "bytes_examine_reason" }, new Object[] { null, null, null, Long.valueOf(0L), localByteStringMicro }, ExamineCallBackReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.ExamineCallBackReq
 * JD-Core Version:    0.7.0.1
 */