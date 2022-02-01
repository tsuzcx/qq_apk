package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$GalleryPGCFeedsInfo
  extends MessageMicro<GalleryPGCFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_gallery_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_report_exdata = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<articlesummary.PGCPicInfo> msg_pgc_pic_info_list = PBField.initRepeatMessage(articlesummary.PGCPicInfo.class);
  public final PBUInt64Field uint64_pic_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_source = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sub_source = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 402 }, new String[] { "uint64_pic_count", "msg_pgc_pic_info_list", "uint64_source", "uint64_sub_source", "bytes_report_exdata", "bytes_gallery_url" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, GalleryPGCFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.GalleryPGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */