package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x345$RspBody$SubCmd0x9RspBody
  extends MessageMicro<SubCmd0x9RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<cmd0x345.RspBody.FileAttr> rpt_msg_file_list = PBField.initRepeatMessage(cmd0x345.RspBody.FileAttr.class);
  public final PBUInt32Field uint32_begin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_file_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_begin", "uint32_total_file_num", "uint32_file_num", "rpt_msg_file_list" }, new Object[] { localInteger, localInteger, localInteger, null }, SubCmd0x9RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x9RspBody
 * JD-Core Version:    0.7.0.1
 */