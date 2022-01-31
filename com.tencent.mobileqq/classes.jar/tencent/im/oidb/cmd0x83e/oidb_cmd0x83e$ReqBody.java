package tencent.im.oidb.cmd0x83e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x83e$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_master = PBField.initBool(false);
  public final PBBytesField bytes_comment = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_gif_thumbnail_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_gif_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_pic_type = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_inner_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_parent_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_biu_src = PBField.initEnum(1);
  public final PBEnumField enum_ugc_src = PBField.initEnum(0);
  public oidb_cmd0x83e.FeedsInfo msg_feeds_info = new oidb_cmd0x83e.FeedsInfo();
  public oidb_cmd0x83e.PGCSubmitPara msg_pgc_submit_para = new oidb_cmd0x83e.PGCSubmitPara();
  public final PBUInt32Field resend_times = PBField.initUInt32(0);
  public final PBRepeatField rpt_bytes_comment_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField rpt_second_level_comment_list = PBField.initRepeatMessage(oidb_cmd0x83e.SecondLevelComment.class);
  public final PBUInt32Field uint32_op_new_comment_system = PBField.initUInt32(0);
  public final PBUInt32Field uint32_operation = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_reply_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 64, 72, 82, 88, 98, 106, 114, 128, 138, 146, 154, 162, 170, 240 }, new String[] { "uint64_uin", "uint32_operation", "uint64_feeds_id", "bytes_comment", "bytes_parent_id", "uint64_reply_uin", "rpt_bytes_comment_id", "resend_times", "bool_is_master", "msg_feeds_info", "enum_biu_src", "bytes_inner_uniq_id", "msg_pgc_submit_para", "rpt_second_level_comment_list", "uint32_op_new_comment_system", "bytes_comment_gif_url", "bytes_comment_gif_thumbnail_url", "bytes_comment_pic_type", "bytes_comment_id", "bytes_sub_comment_id", "enum_ugc_src" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), Boolean.valueOf(false), null, Integer.valueOf(1), localByteStringMicro4, null, null, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody
 * JD-Core Version:    0.7.0.1
 */