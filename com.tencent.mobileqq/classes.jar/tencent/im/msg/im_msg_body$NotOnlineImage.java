package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$NotOnlineImage
  extends MessageMicro<NotOnlineImage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field biz_type = PBField.initUInt32(0);
  public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField download_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field file_len = PBField.initUInt32(0);
  public final PBBytesField file_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField flag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field img_type = PBField.initUInt32(0);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBBoolField old_pic_md5 = PBField.initBool(false);
  public final PBBytesField old_ver_send_file = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField op_face_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field original = PBField.initUInt32(0);
  public final PBUInt32Field pic_height = PBField.initUInt32(0);
  public final PBBytesField pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field pic_width = PBField.initUInt32(0);
  public final PBBytesField previews_image = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField res_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBStringField str_400_url = PBField.initString("");
  public final PBStringField str_big_url = PBField.initString("");
  public final PBStringField str_orig_url = PBField.initString("");
  public final PBStringField str_thumb_url = PBField.initString("");
  public final PBUInt32Field uint32_400_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_400_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_download_len = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_len = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50, 58, 64, 72, 82, 90, 98, 104, 114, 122, 128, 136, 144, 154, 160, 168, 176, 184, 192, 200, 210, 216, 224, 234 }, new String[] { "file_path", "file_len", "download_path", "old_ver_send_file", "img_type", "previews_image", "pic_md5", "pic_height", "pic_width", "res_id", "flag", "str_thumb_url", "original", "str_big_url", "str_orig_url", "biz_type", "result", "index", "op_face_buf", "old_pic_md5", "uint32_thumb_width", "uint32_thumb_height", "uint32_file_id", "uint32_show_len", "uint32_download_len", "str_400_url", "uint32_400_width", "uint32_400_height", "bytes_pb_reserve" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, "", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8, Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro9 }, NotOnlineImage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.NotOnlineImage
 * JD-Core Version:    0.7.0.1
 */