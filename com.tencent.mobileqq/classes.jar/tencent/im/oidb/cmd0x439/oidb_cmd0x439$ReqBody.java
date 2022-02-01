package tencent.im.oidb.cmd0x439;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x439$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 80, 88, 96 }, new String[] { "uint32_want_count", "uint32_req_article_info", "uint32_req_subscribe_info", "uint32_last_req_time", "uint32_comefrom", "uint32_version", "uint32_network_type", "uint32_pic_size" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_comefrom = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_req_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_article_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_subscribe_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_want_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x439.oidb_cmd0x439.ReqBody
 * JD-Core Version:    0.7.0.1
 */