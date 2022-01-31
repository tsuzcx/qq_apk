package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyGetFileListReqBody
  extends MessageMicro<ApplyGetFileListReqBody>
{
  public static final int REQ_FROM_ANPING_SVR = 21;
  public static final int REQ_FROM_MB_FILE_LIST = 3;
  public static final int REQ_FROM_MB_GROUP_CARD = 2;
  public static final int REQ_FROM_PC_CLIENT_INNERWEB = 11;
  public static final int REQ_FROM_PC_CLIENT_INNERWEB_PAGE = 12;
  public static final int REQ_FROM_PC_GROUP_CARD = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_start_index", "uint32_file_count", "uint32_req_from", "str_parent_folder_path" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, ApplyGetFileListReqBody.class);
  public final PBStringField str_parent_folder_path = PBField.initString("");
  public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_from = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListReqBody
 * JD-Core Version:    0.7.0.1
 */