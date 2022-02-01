package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xc0c$VideoSrcType
  extends MessageMicro<VideoSrcType>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
  public final PBInt32Field video_from_type = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_source_type", "video_from_type" }, new Object[] { localInteger, localInteger }, VideoSrcType.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc0c.VideoSrcType
 * JD-Core Version:    0.7.0.1
 */