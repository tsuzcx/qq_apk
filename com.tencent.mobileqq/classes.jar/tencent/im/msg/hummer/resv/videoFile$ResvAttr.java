package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class videoFile$ResvAttr
  extends MessageMicro<ResvAttr>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_animoji_modelId = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_camera_templateid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_dynamic_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hotvideo_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hotvideo_icon_sub = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hotvideo_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hotvideo_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_shortVideoId = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_long_video_kandian_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_tail_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_red_envelope_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_special_video_type = PBField.initUInt32(0);
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56, 64, 74, 82, 88, 96, 106 }, new String[] { "bytes_hotvideo_icon", "bytes_hotvideo_title", "bytes_hotvideo_url", "bytes_hotvideo_icon_sub", "uint32_special_video_type", "bytes_dynamic_text", "uint32_msg_tail_type", "uint32_red_envelope_type", "bytes_shortVideoId", "bytes_animoji_modelId", "uint32_long_video_kandian_type", "uint32_source", "bytes_camera_templateid" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8 }, ResvAttr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.resv.videoFile.ResvAttr
 * JD-Core Version:    0.7.0.1
 */