package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$PGCFeedsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pgc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_pgc_feeds_card_type = PBField.initEnum(0);
  public final PBEnumField enum_pgc_feeds_type = PBField.initEnum(0);
  public oidb_cmd0x68b.GalleryPGCFeedsInfo msg_gallery_feeds_info = new oidb_cmd0x68b.GalleryPGCFeedsInfo();
  public final PBRepeatMessageField msg_pgc_pic_info_list = PBField.initRepeatMessage(oidb_cmd0x68b.PGCPicInfo.class);
  public final PBRepeatMessageField msg_pgc_video_info_list = PBField.initRepeatMessage(oidb_cmd0x68b.PGCVideoInfo.class);
  public final PBUInt32Field uint32_follow_counts = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_follow_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 112, 120, 160, 170 }, new String[] { "enum_pgc_feeds_card_type", "uint64_puin", "msg_pgc_pic_info_list", "msg_pgc_video_info_list", "bytes_pgc_comments", "uint32_myself_follow_status", "uint32_follow_counts", "enum_pgc_feeds_type", "msg_gallery_feeds_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, PGCFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */