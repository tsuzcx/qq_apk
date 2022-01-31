package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$PttShortVideoIpList
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_ip", "uint32_port" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, PttShortVideoIpList.class);
  public final PBUInt32Field uint32_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.PttShortVideoIpList
 * JD-Core Version:    0.7.0.1
 */