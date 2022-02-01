package tencent.im.msg.resv21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_resv_21$XtfSenderInfo
  extends MessageMicro<XtfSenderInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_lan_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lan_port = PBField.initUInt32(0);
  public final PBUInt64Field uint64_lan_srkey = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_lan_ip", "uint32_lan_port", "uint64_lan_srkey" }, new Object[] { localInteger, localInteger, Long.valueOf(0L) }, XtfSenderInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.resv21.hummer_resv_21.XtfSenderInfo
 * JD-Core Version:    0.7.0.1
 */