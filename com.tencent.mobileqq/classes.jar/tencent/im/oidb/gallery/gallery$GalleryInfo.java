package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class gallery$GalleryInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_comments_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gallery_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_publisher_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_publisher_openid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_report_exdata = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_source_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subject = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_summary_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_reason = PBField.initInt32(0);
  public gallery.PictureInfo msg_big_summary_pic = new gallery.PictureInfo();
  public gallery.ClassInfo msg_class_info = new gallery.ClassInfo();
  public gallery.PictureInfo msg_sig_summary_pic = new gallery.PictureInfo();
  public final PBRepeatMessageField msg_three_summary_pic = PBField.initRepeatMessage(gallery.PictureInfo.class);
  public final PBRepeatMessageField rpt_msg_pic_info = PBField.initRepeatMessage(gallery.PictureInfo.class);
  public final PBRepeatMessageField rpt_msg_summary_pic = PBField.initRepeatMessage(gallery.PictureInfo.class);
  public final PBRepeatMessageField rpt_msg_tag_info = PBField.initRepeatMessage(gallery.TagInfo.class);
  public final PBUInt32Field uint32_end_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_display_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_pic_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_publisher_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_source = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_source_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sub_source = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50, 58, 66, 72, 80, 88, 96, 106, 114, 120, 128, 242, 250, 258, 266, 274, 394, 402, 410, 416, 426, 482, 488 }, new String[] { "bytes_row_key", "uint64_article_id", "bytes_publisher_openid", "uint64_publisher_uin", "bytes_publisher_name", "bytes_subject", "bytes_summary_pic_url", "rpt_msg_summary_pic", "uint64_source", "uint64_sub_source", "uint64_create_time", "uint64_pic_count", "rpt_msg_pic_info", "bytes_report_exdata", "uint64_display_type", "uint64_source_article_id", "msg_class_info", "rpt_msg_tag_info", "msg_big_summary_pic", "msg_sig_summary_pic", "msg_three_summary_pic", "bytes_source_url", "bytes_gallery_url", "bytes_comments_url", "int32_reason", "bytes_reason", "bytes_cookies", "uint32_end_flag" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, localByteStringMicro6, Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, null, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), localByteStringMicro10, localByteStringMicro11, Integer.valueOf(0) }, GalleryInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.gallery.gallery.GalleryInfo
 * JD-Core Version:    0.7.0.1
 */