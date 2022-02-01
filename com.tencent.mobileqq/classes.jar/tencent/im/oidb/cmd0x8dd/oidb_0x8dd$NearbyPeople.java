package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8dd$NearbyPeople
  extends MessageMicro<NearbyPeople>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_online = PBField.initBool(false);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_picture_face = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_face = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0x8dd.FeedInfo> feed_info = PBField.initRepeatMessage(oidb_0x8dd.FeedInfo.class);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBInt32Field int32_lat = PBField.initInt32(0);
  public final PBInt32Field int32_lon = PBField.initInt32(0);
  public final PBInt32Field is_authen = PBField.initInt32(0);
  public final PBUInt32Field logo_level = PBField.initUInt32(0);
  public oidb_0x8dd.Anchor1v1Info msg_anchor_1v1_info = new oidb_0x8dd.Anchor1v1Info();
  public oidb_0x8dd.AnchorInfo msg_anchor_info = new oidb_0x8dd.AnchorInfo();
  public oidb_0x8dd.ThirdLineInfo msg_third_line_info = new oidb_0x8dd.ThirdLineInfo();
  public final PBUInt64Field now_id = PBField.initUInt64(0L);
  public final PBStringField str_description = PBField.initString("");
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm_shown = PBField.initUInt32(0);
  public final PBUInt32Field uint32_constellation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_god_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_marriage = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
  public final PBUInt32Field uint32_real_video_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vip_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 72, 80, 88, 96, 104, 112, 120, 128, 136, 146, 154, 162, 170, 176, 184, 194, 200, 208, 224, 232, 240, 250 }, new String[] { "uint64_uin", "uint64_tinyid", "uint32_distance", "uint64_timestamp", "int32_lat", "int32_lon", "str_description", "bytes_nick", "uint32_gender", "uint32_age", "uint32_charm", "uint32_charm_level", "uint32_charm_shown", "uint32_profession", "uint32_constellation", "uint32_god_flag", "uint32_vip_type", "msg_third_line_info", "msg_anchor_info", "bytes_video_face", "bytes_picture_face", "uint32_real_video_flag", "bool_online", "msg_anchor_1v1_info", "is_authen", "index", "now_id", "logo_level", "uint32_marriage", "feed_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Boolean.valueOf(false), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, NearbyPeople.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyPeople
 * JD-Core Version:    0.7.0.1
 */