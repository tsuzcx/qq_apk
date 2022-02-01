package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyGetFileListV2RspBody
  extends MessageMicro<ApplyGetFileListV2RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_end = PBField.initBool(false);
  public cmd0x383.FileTimestamp msg_max_timestamp = new cmd0x383.FileTimestamp();
  public final PBRepeatMessageField<cmd0x383.ApplyGetFileListRspBody.FileInfo> rpt_msg_file_info_list = PBField.initRepeatMessage(cmd0x383.ApplyGetFileListRspBody.FileInfo.class);
  public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "bool_is_end", "rpt_msg_file_info_list", "msg_max_timestamp", "uint32_all_file_count", "uint32_filter_code" }, new Object[] { Boolean.valueOf(false), null, null, localInteger, localInteger }, ApplyGetFileListV2RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListV2RspBody
 * JD-Core Version:    0.7.0.1
 */