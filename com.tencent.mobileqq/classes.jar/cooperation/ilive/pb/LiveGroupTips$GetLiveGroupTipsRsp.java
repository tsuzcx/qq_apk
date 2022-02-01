package cooperation.ilive.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class LiveGroupTips$GetLiveGroupTipsRsp
  extends MessageMicro<GetLiveGroupTipsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field interval = PBField.initUInt32(0);
  public final PBUInt32Field is_living = PBField.initUInt32(0);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBStringField room_icon = PBField.initString("");
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBStringField room_schema = PBField.initString("");
  public final PBStringField room_title = PBField.initString("");
  public final PBUInt64Field room_viewer = PBField.initUInt64(0L);
  public final PBStringField viewer_text = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 66, 72 }, new String[] { "room_id", "room_title", "room_icon", "room_viewer", "room_schema", "is_living", "interval", "viewer_text", "puin" }, new Object[] { localLong, "", "", localLong, "", localInteger, localInteger, "", localLong }, GetLiveGroupTipsRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.pb.LiveGroupTips.GetLiveGroupTipsRsp
 * JD-Core Version:    0.7.0.1
 */