package tencent.im.oidb.cmd0x5cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x5cf$RspBody
  extends MessageMicro<RspBody>
{
  public static final int MSG_FAILEDSYS_FIELD_NUMBER = 4;
  public static final int MSG_SUCCESSREAD_FIELD_NUMBER = 3;
  public static final int STR_RESERVE_FIELD_NUMBER = 5;
  public static final int UINT32_RESULT_FIELD_NUMBER = 2;
  public static final int UINT32_VERSION_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public Oidb_0x5cf.FailedSys msg_failedsys = new Oidb_0x5cf.FailedSys();
  public Oidb_0x5cf.SuccessRead msg_successread = new Oidb_0x5cf.SuccessRead();
  public final PBStringField str_reserve = PBField.initString("");
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint32_version", "uint32_result", "msg_successread", "msg_failedsys", "str_reserve" }, new Object[] { localInteger, localInteger, null, null, "" }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.RspBody
 * JD-Core Version:    0.7.0.1
 */