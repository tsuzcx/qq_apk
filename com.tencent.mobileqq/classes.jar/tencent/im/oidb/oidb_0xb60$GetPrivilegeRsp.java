package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb60$GetPrivilegeRsp
  extends MessageMicro<GetPrivilegeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> api_groups = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<String> api_names = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "api_groups", "next_req_duration", "api_names" }, new Object[] { localInteger, localInteger, "" }, GetPrivilegeRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb60.GetPrivilegeRsp
 * JD-Core Version:    0.7.0.1
 */