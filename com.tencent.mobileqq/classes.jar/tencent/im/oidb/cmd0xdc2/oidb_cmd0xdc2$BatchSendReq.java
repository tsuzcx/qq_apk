package tencent.im.oidb.cmd0xdc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ImageInfo;

public final class oidb_cmd0xdc2$BatchSendReq
  extends MessageMicro<BatchSendReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0xb77.ImageInfo image_info = new oidb_cmd0xb77.ImageInfo();
  public final PBUInt64Field recv_guild_id = PBField.initUInt64(0L);
  public final PBStringField recv_openid = PBField.initString("");
  public final PBUInt64Field recv_uin = PBField.initUInt64(0L);
  public final PBUInt32Field send_type = PBField.initUInt32(0);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "send_type", "recv_uin", "recv_openid", "image_info", "recv_guild_id" }, new Object[] { Integer.valueOf(0), localLong, "", null, localLong }, BatchSendReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendReq
 * JD-Core Version:    0.7.0.1
 */