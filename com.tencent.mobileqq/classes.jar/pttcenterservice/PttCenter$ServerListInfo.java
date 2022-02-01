package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttCenter$ServerListInfo
  extends MessageMicro<ServerListInfo>
{
  public static final int UINT32_UP_IP_FIELD_NUMBER = 1;
  public static final int UINT32_UP_PORT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_up_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_up_port = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_up_ip", "uint32_up_port" }, new Object[] { localInteger, localInteger }, ServerListInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     pttcenterservice.PttCenter.ServerListInfo
 * JD-Core Version:    0.7.0.1
 */