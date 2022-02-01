package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x346$ApplyListDownloadRsp
  extends MessageMicro<ApplyListDownloadRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 400, 480, 562 }, new String[] { "int32_ret_code", "str_ret_msg", "uint32_total_count", "uint32_begin_index", "uint32_rsp_count", "uint32_is_end", "rpt_msg_file_list" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ApplyListDownloadRsp.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBRepeatMessageField<cmd0x346.FileInfo> rpt_msg_file_list = PBField.initRepeatMessage(cmd0x346.FileInfo.class);
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rsp_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyListDownloadRsp
 * JD-Core Version:    0.7.0.1
 */