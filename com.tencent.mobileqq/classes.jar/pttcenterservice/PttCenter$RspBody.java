package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttCenter$RspBody
  extends MessageMicro<RspBody>
{
  public static final int MSG_PTTINTRODAPPLYUPLOAD_RESP_FIELD_NUMBER = 3;
  public static final int UINT32_CMD_FIELD_NUMBER = 1;
  public static final int UINT32_SEQ_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public PttCenter.PttIntrodApplyUploadResp msg_pttIntrodApplyUpload_resp = new PttCenter.PttIntrodApplyUploadResp();
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_cmd", "uint32_seq", "msg_pttIntrodApplyUpload_resp" }, new Object[] { localInteger, localInteger, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     pttcenterservice.PttCenter.RspBody
 * JD-Core Version:    0.7.0.1
 */