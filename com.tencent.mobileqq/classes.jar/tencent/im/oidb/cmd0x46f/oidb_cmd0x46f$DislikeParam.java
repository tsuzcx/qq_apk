package tencent.im.oidb.cmd0x46f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x46f$DislikeParam
  extends MessageMicro<DislikeParam>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> rpt_tag_name = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_tagid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<oidb_cmd0x46f.UserDisLike> rpt_user_dislike_list = PBField.initRepeatMessage(oidb_cmd0x46f.UserDisLike.class);
  public final PBUInt32Field uint32_reasonid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_articleid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_biu_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 88, 98, 104, 112, 122, 200 }, new String[] { "uint64_articleid", "uint32_reasonid", "bytes_rowkey", "rpt_uint64_tagid", "rpt_user_dislike_list", "uint64_feeds_id", "uint64_biu_uin", "rpt_tag_name", "uint64_topic_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, Long.valueOf(0L) }, DislikeParam.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.DislikeParam
 * JD-Core Version:    0.7.0.1
 */