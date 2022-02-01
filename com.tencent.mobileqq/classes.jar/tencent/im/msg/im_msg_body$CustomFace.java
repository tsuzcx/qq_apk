package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$CustomFace
  extends MessageMicro<CustomFace>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field biz_type = PBField.initUInt32(0);
  public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_flag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_old_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_signature = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field image_type = PBField.initUInt32(0);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBUInt32Field repeat_image = PBField.initUInt32(0);
  public final PBUInt32Field repeat_index = PBField.initUInt32(0);
  public final PBStringField str_400_url = PBField.initString("");
  public final PBStringField str_big_url = PBField.initString("");
  public final PBStringField str_file_path = PBField.initString("");
  public final PBStringField str_orig_url = PBField.initString("");
  public final PBStringField str_shortcut = PBField.initString("");
  public final PBStringField str_thumb_url = PBField.initString("");
  public final PBUInt32Field uint32_400_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_400_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_download_len = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_origin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_server_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_len = PBField.initUInt32(0);
  public final PBUInt32Field uint32_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_useful = PBField.initUInt32(0);
  public final PBUInt32Field uint32_width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64, 72, 80, 90, 96, 106, 114, 122, 130, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 250, 256, 264, 274 }, new String[] { "bytes_guid", "str_file_path", "str_shortcut", "bytes_buffer", "bytes_flag", "bytes_old_data", "uint32_file_id", "uint32_server_ip", "uint32_server_port", "uint32_file_type", "bytes_signature", "uint32_useful", "bytes_md5", "str_thumb_url", "str_big_url", "str_orig_url", "biz_type", "repeat_index", "repeat_image", "image_type", "index", "uint32_width", "uint32_height", "uint32_source", "uint32_size", "uint32_origin", "uint32_thumb_width", "uint32_thumb_height", "uint32_show_len", "uint32_download_len", "str_400_url", "uint32_400_width", "uint32_400_height", "bytes_pb_reserve" }, new Object[] { localByteStringMicro1, "", "", localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localInteger, localInteger, localInteger, localInteger, localByteStringMicro5, localInteger, localByteStringMicro6, "", "", "", localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, "", localInteger, localInteger, localByteStringMicro7 }, CustomFace.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.CustomFace
 * JD-Core Version:    0.7.0.1
 */