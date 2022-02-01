package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6d8$GetFileListRspBody
  extends MessageMicro<GetFileListRspBody>
{
  public static final int TYPE_FILE = 1;
  public static final int TYPE_FOLDER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_end = PBField.initBool(false);
  public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
  public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public oidb_0x6d8.FileTimeStamp msg_max_timestamp = new oidb_0x6d8.FileTimeStamp();
  public final PBRepeatMessageField<oidb_0x6d8.GetFileListRspBody.Item> rpt_item_list = PBField.initRepeatMessage(oidb_0x6d8.GetFileListRspBody.Item.class);
  public final PBStringField str_client_wording = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_open_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_role = PBField.initUInt32(0);
  public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56, 64, 88, 96, 104, 114, 120, 128 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "bool_is_end", "rpt_item_list", "msg_max_timestamp", "uint32_all_file_count", "uint32_filter_code", "bool_safe_check_flag", "uint32_safe_check_res", "uint32_next_index", "bytes_context", "uint32_role", "uint32_open_flag" }, new Object[] { localInteger, "", "", localBoolean, null, null, localInteger, localInteger, localBoolean, localInteger, localInteger, localByteStringMicro, localInteger, localInteger }, GetFileListRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListRspBody
 * JD-Core Version:    0.7.0.1
 */