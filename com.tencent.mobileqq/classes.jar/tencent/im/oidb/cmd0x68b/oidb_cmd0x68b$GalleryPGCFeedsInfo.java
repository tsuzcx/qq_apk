package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$GalleryPGCFeedsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_gallery_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField msg_pgc_pic_info_list = PBField.initRepeatMessage(oidb_cmd0x68b.PGCPicInfo.class);
  public final PBUInt64Field uint64_pic_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_source = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sub_source = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 402 }, new String[] { "uint64_pic_count", "msg_pgc_pic_info_list", "uint64_source", "uint64_sub_source", "bytes_gallery_url" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, GalleryPGCFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.GalleryPGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */