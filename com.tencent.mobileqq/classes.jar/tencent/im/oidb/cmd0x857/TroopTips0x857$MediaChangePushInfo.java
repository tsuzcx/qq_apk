package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$MediaChangePushInfo
  extends MessageMicro<MediaChangePushInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gray_tips = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_version_ctrl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField is_join_when_start = PBField.initBool(false);
  public TroopTips0x857.MediaChangePushInfo.PersonalSetting msg_per_setting = new TroopTips0x857.MediaChangePushInfo.PersonalSetting();
  public final PBUInt32Field uint32_join_nums = PBField.initUInt32(0);
  public final PBUInt32Field uint32_media_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_play_mode = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_oper_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 64, 74, 80, 88, 792, 802 }, new String[] { "uint32_msg_type", "bytes_msg_info", "bytes_version_ctrl", "uint64_group_id", "uint64_oper_uin", "bytes_gray_tips", "uint64_msg_seq", "uint32_join_nums", "msg_per_setting", "uint32_play_mode", "is_join_when_start", "uint32_media_type", "bytes_ext_info" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localLong, localLong, localByteStringMicro3, localLong, localInteger, null, localInteger, Boolean.valueOf(false), localInteger, localByteStringMicro4 }, MediaChangePushInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.MediaChangePushInfo
 * JD-Core Version:    0.7.0.1
 */