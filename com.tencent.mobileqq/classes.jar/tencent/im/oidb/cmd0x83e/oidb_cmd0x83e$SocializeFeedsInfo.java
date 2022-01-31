package tencent.im.oidb.cmd0x83e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x83e$SocializeFeedsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0x83e.BuluoInfo buluo_info = new oidb_cmd0x83e.BuluoInfo();
  public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x83e.BiuMultiLevel msg_biu_mutli_level = new oidb_cmd0x83e.BiuMultiLevel();
  public oidb_cmd0x83e.SocializeFeedsInfoUser msg_master_uin = new oidb_cmd0x83e.SocializeFeedsInfoUser();
  public oidb_cmd0x83e.PGCFeedsInfo msg_pgc_topic_feeds_info = new oidb_cmd0x83e.PGCFeedsInfo();
  public oidb_cmd0x83e.SocializeFeedsExtInfo msg_socialize_feeds_ext_info = new oidb_cmd0x83e.SocializeFeedsExtInfo();
  public oidb_cmd0x83e.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new oidb_cmd0x83e.TopicRecommendFeedsInfo();
  public oidb_cmd0x83e.UGCFeedsInfo msg_ugc_topic_feeds_info = new oidb_cmd0x83e.UGCFeedsInfo();
  public oidb_cmd0x83e.VerifyResult msg_verify_result = new oidb_cmd0x83e.VerifyResult();
  public final PBRepeatMessageField rpt_recommend_list = PBField.initRepeatMessage(oidb_cmd0x83e.SocializeFeedsInfoUser.class);
  public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_biu_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 114, 120, 128, 136, 146, 152, 160, 168, 178, 186, 194, 202, 210, 242 }, new String[] { "uint64_feeds_id", "uint64_article_id", "msg_master_uin", "rpt_recommend_list", "bytes_comments", "bytes_recommend_reason", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "msg_socialize_feeds_ext_info", "uint32_biu_time", "uint32_myself_biu_status", "uint32_biu_count", "msg_biu_mutli_level", "msg_ugc_topic_feeds_info", "msg_pgc_topic_feeds_info", "msg_verify_result", "msg_topic_recommend_feeds_info", "buluo_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null }, SocializeFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */