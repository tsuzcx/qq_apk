package tencent.im.oidb.cmd0x991;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.VideoFile;

public final class oidb_cmd0x991$Goods
  extends MessageMicro<Goods>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_animation_param = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_goods_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_goods_price = PBField.initInt32(0);
  public final PBInt32Field int32_product_id = PBField.initInt32(0);
  public im_msg_body.CustomFace msg_img = new im_msg_body.CustomFace();
  public im_msg_body.VideoFile msg_video = new im_msg_body.VideoFile();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "int32_product_id", "bytes_goods_name", "int32_goods_price", "bytes_animation_param", "msg_video", "msg_img" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, null, null }, Goods.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x991.oidb_cmd0x991.Goods
 * JD-Core Version:    0.7.0.1
 */