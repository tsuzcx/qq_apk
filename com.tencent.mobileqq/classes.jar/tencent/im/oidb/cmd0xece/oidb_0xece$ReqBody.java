package tencent.im.oidb.cmd0xece;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xece$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0xece.ClientInfo client_info = new oidb_0xece.ClientInfo();
  public final PBUInt32Field from = PBField.initUInt32(0);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field miniapp_protect = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "group_id", "client_info", "from", "miniapp_protect" }, new Object[] { Long.valueOf(0L), null, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xece.oidb_0xece.ReqBody
 * JD-Core Version:    0.7.0.1
 */