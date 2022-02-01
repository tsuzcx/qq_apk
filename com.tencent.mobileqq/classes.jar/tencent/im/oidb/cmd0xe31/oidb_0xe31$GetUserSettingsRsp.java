package tencent.im.oidb.cmd0xe31;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe31$GetUserSettingsRsp
  extends MessageMicro<GetUserSettingsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field column_count = PBField.initUInt32(0);
  public final PBUInt32Field subscribe_count = PBField.initUInt32(0);
  public final PBUInt32Field video_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "video_count", "column_count", "subscribe_count" }, new Object[] { localInteger, localInteger, localInteger }, GetUserSettingsRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe31.oidb_0xe31.GetUserSettingsRsp
 * JD-Core Version:    0.7.0.1
 */