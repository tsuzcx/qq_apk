package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xc05$GetCreateAppListReq
  extends MessageMicro<GetCreateAppListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field limit = PBField.initUInt32(0);
  public final PBUInt32Field start = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start", "limit" }, new Object[] { localInteger, localInteger }, GetCreateAppListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc05.GetCreateAppListReq
 * JD-Core Version:    0.7.0.1
 */