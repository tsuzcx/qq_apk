package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xeac$ImageMsg
  extends MessageMicro<ImageMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field file_id = PBField.initUInt32(0);
  public final PBUInt32Field file_size = PBField.initUInt32(0);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBUInt32Field img_type = PBField.initUInt32(0);
  public final PBStringField md5 = PBField.initString("");
  public final PBStringField original_url = PBField.initString("");
  public final PBStringField resave_url = PBField.initString("");
  public final PBUInt32Field server_ip = PBField.initUInt32(0);
  public final PBUInt32Field server_port = PBField.initUInt32(0);
  public final PBStringField str_file_path = PBField.initString("");
  public final PBStringField thumb_url = PBField.initString("");
  public final PBStringField uuid = PBField.initString("");
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 808, 816, 824, 834, 1610, 1618, 1626 }, new String[] { "md5", "uuid", "img_type", "file_size", "width", "height", "file_id", "server_ip", "server_port", "str_file_path", "thumb_url", "original_url", "resave_url" }, new Object[] { "", "", localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, "", "", "", "" }, ImageMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.ImageMsg
 * JD-Core Version:    0.7.0.1
 */