package tencent.im.oidb.cmd0x64e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x64e$UGCFeedsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ugc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_ugc_feeds_card_type = PBField.initEnum(0);
  public final PBRepeatMessageField msg_ugc_pic_info_list = PBField.initRepeatMessage(oidb_cmd0x64e.UGCPicInfo.class);
  public final PBRepeatMessageField msg_ugc_video_info_list = PBField.initRepeatMessage(oidb_cmd0x64e.UGCVideoInfo.class);
  public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106 }, new String[] { "enum_ugc_feeds_card_type", "uint64_cuin", "msg_ugc_pic_info_list", "msg_ugc_video_info_list", "bytes_ugc_comments" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro }, UGCFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.UGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */