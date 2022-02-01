package tencent.im.oidb.cmd0xb40;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb40$FavoriteExtInfo
  extends MessageMicro<FavoriteExtInfo>
{
  public static final int Article = 1;
  public static final int PictureCollection = 3;
  public static final int Video = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_type", "uint32_video_duration" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FavoriteExtInfo.class);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb40.oidb_0xb40.FavoriteExtInfo
 * JD-Core Version:    0.7.0.1
 */