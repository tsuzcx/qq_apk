package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8c8$UGCFeedsInfo
  extends MessageMicro<UGCFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_json_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_json_pic_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ugc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_ugc_feeds_card_type = PBField.initEnum(0);
  public final PBRepeatMessageField<oidb_cmd0x8c8.UGCPicInfo> msg_ugc_pic_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8.UGCPicInfo.class);
  public final PBRepeatMessageField<oidb_cmd0x8c8.UGCVideoInfo> msg_ugc_video_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8.UGCVideoInfo.class);
  public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 114, 122, 130 }, new String[] { "enum_ugc_feeds_card_type", "uint64_cuin", "msg_ugc_pic_info_list", "msg_ugc_video_info_list", "bytes_ugc_comments", "bytes_json_pic_list", "bytes_json_video_list", "bytes_json_content" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, UGCFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.UGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */