package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7f5$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_req_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<cmd0x7f5.GroupInfo> rpt_group_info = PBField.initRepeatMessage(cmd0x7f5.GroupInfo.class);
  public final PBUInt32Field uint32_completed_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recruit_number = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_completed_flag", "uint32_recruit_number", "rpt_group_info", "bytes_req_context" }, new Object[] { localInteger, localInteger, null, localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7f5.cmd0x7f5.RspBody
 * JD-Core Version:    0.7.0.1
 */