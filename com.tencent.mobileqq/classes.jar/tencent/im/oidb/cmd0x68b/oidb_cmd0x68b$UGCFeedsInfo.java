package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$UGCFeedsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_json_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_json_pic_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ugc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_ugc_feeds_card_type = PBField.initEnum(0);
  public oidb_cmd0x68b.BiuMultiLevel msg_at_multi_level = new oidb_cmd0x68b.BiuMultiLevel();
  public final PBRepeatMessageField msg_ugc_pic_info_list = PBField.initRepeatMessage(oidb_cmd0x68b.UGCPicInfo.class);
  public final PBRepeatMessageField msg_ugc_video_info_list = PBField.initRepeatMessage(oidb_cmd0x68b.UGCVideoInfo.class);
  public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 114, 122, 130, 138 }, new String[] { "enum_ugc_feeds_card_type", "uint64_cuin", "msg_ugc_pic_info_list", "msg_ugc_video_info_list", "bytes_ugc_comments", "bytes_json_pic_list", "bytes_json_video_list", "bytes_json_content", "msg_at_multi_level" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null }, UGCFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.UGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */