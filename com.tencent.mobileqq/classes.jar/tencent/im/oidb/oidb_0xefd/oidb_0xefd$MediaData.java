package tencent.im.oidb.oidb_0xefd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xefd$MediaData
  extends MessageMicro<MediaData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field media_type = PBField.initUInt32(0);
  public final PBUInt32Field pic_length = PBField.initUInt32(0);
  public final PBStringField pic_url = PBField.initString("");
  public final PBUInt32Field pic_width = PBField.initUInt32(0);
  public final PBUInt32Field sound_duration = PBField.initUInt32(0);
  public final PBStringField sound_url = PBField.initString("");
  public final PBStringField text = PBField.initString("");
  public final PBStringField thumbnail_url = PBField.initString("");
  public final PBUInt32Field video_duration = PBField.initUInt32(0);
  public final PBStringField video_url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 64, 72, 82 }, new String[] { "text", "pic_url", "pic_width", "pic_length", "sound_url", "sound_duration", "video_url", "video_duration", "media_type", "thumbnail_url" }, new Object[] { "", "", localInteger, localInteger, "", localInteger, "", localInteger, localInteger, "" }, MediaData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xefd.oidb_0xefd.MediaData
 * JD-Core Version:    0.7.0.1
 */