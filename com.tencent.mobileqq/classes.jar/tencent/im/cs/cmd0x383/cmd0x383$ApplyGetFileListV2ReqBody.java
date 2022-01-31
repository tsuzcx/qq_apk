package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyGetFileListV2ReqBody
  extends MessageMicro<ApplyGetFileListV2ReqBody>
{
  public static final int REQ_FROM_MB_FILE_LIST_BY_FILETYPE = 2;
  public static final int REQ_FROM_MB_FILE_LIST_BY_TIMESTAMP = 1;
  public static final int REQ_FROM_MB_FILE_LIST_BY_UPLOADER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "msg_start_timestamp", "uint32_file_count", "msg_max_timestamp", "uint32_all_file_count", "uint32_req_from" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ApplyGetFileListV2ReqBody.class);
  public cmd0x383.FileTimestamp msg_max_timestamp = new cmd0x383.FileTimestamp();
  public cmd0x383.FileTimestamp msg_start_timestamp = new cmd0x383.FileTimestamp();
  public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_from = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListV2ReqBody
 * JD-Core Version:    0.7.0.1
 */