package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$PttShortVideoIpList
  extends MessageMicro<PttShortVideoIpList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_ip", "uint32_port" }, new Object[] { localInteger, localInteger }, PttShortVideoIpList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.PttShortVideoIpList
 * JD-Core Version:    0.7.0.1
 */