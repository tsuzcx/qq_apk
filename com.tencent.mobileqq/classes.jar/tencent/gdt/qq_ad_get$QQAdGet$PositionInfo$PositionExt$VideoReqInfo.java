package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGet$PositionInfo$PositionExt$VideoReqInfo
  extends MessageMicro<VideoReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field video_max_duration = PBField.initUInt32(0);
  public final PBUInt32Field video_min_duration = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "video_min_duration", "video_max_duration" }, new Object[] { localInteger, localInteger }, VideoReqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.VideoReqInfo
 * JD-Core Version:    0.7.0.1
 */