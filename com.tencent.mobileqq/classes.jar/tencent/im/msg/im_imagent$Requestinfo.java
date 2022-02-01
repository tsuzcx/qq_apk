package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_imagent$Requestinfo
  extends MessageMicro<Requestinfo>
{
  public static final int REQ_FLAG_FIELD_NUMBER = 3;
  public static final int REQ_IP_FIELD_NUMBER = 1;
  public static final int REQ_PORT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field req_flag = PBField.initUInt32(0);
  public final PBFixed32Field req_ip = PBField.initFixed32(0);
  public final PBUInt32Field req_port = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 24 }, new String[] { "req_ip", "req_port", "req_flag" }, new Object[] { localInteger, localInteger, localInteger }, Requestinfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_imagent.Requestinfo
 * JD-Core Version:    0.7.0.1
 */