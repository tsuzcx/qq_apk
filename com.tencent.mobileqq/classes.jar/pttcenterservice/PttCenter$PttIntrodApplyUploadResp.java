package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PttCenter$PttIntrodApplyUploadResp
  extends MessageMicro<PttIntrodApplyUploadResp>
{
  public static final int BYTES_UP_FILEKEY_FIELD_NUMBER = 4;
  public static final int BYTES_UP_UKEY_FIELD_NUMBER = 5;
  public static final int INT32_RET_CODE_FIELD_NUMBER = 1;
  public static final int RPT_MSG_TRYUP_IPLIST_FIELD_NUMBER = 3;
  public static final int STR_RET_MSG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_up_filekey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_up_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBRepeatMessageField<PttCenter.ServerListInfo> rpt_msg_tryup_iplist = PBField.initRepeatMessage(PttCenter.ServerListInfo.class);
  public final PBStringField str_ret_msg = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "int32_ret_code", "str_ret_msg", "rpt_msg_tryup_iplist", "bytes_up_filekey", "bytes_up_ukey" }, new Object[] { Integer.valueOf(0), "", null, localByteStringMicro1, localByteStringMicro2 }, PttIntrodApplyUploadResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pttcenterservice.PttCenter.PttIntrodApplyUploadResp
 * JD-Core Version:    0.7.0.1
 */