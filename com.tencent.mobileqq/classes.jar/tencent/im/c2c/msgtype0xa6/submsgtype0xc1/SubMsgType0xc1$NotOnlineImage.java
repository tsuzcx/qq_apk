package tencent.im.c2c.msgtype0xa6.submsgtype0xc1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xc1$NotOnlineImage
  extends MessageMicro<NotOnlineImage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField download_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field file_len = PBField.initUInt32(0);
  public final PBBytesField file_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField flag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field img_type = PBField.initUInt32(0);
  public final PBBytesField old_ver_send_file = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field original = PBField.initUInt32(0);
  public final PBUInt32Field pic_height = PBField.initUInt32(0);
  public final PBBytesField pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field pic_width = PBField.initUInt32(0);
  public final PBBytesField previews_image = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField res_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_download_url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50, 58, 64, 72, 82, 90, 98, 104 }, new String[] { "file_path", "file_len", "download_path", "old_ver_send_file", "img_type", "previews_image", "pic_md5", "pic_height", "pic_width", "res_id", "flag", "str_download_url", "original" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, "", Integer.valueOf(0) }, NotOnlineImage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.c2c.msgtype0xa6.submsgtype0xc1.SubMsgType0xc1.NotOnlineImage
 * JD-Core Version:    0.7.0.1
 */