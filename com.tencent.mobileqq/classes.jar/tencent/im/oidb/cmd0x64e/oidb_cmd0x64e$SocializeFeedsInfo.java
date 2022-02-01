package tencent.im.oidb.cmd0x64e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x64e$SocializeFeedsInfo
  extends MessageMicro<SocializeFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x64e.BiuMultiLevel msg_biu_mutli_level = new oidb_cmd0x64e.BiuMultiLevel();
  public oidb_cmd0x64e.SocializeFeedsInfoUser msg_master_uin = new oidb_cmd0x64e.SocializeFeedsInfoUser();
  public oidb_cmd0x64e.PGCFeedsInfo msg_pgc_topic_feeds_info = new oidb_cmd0x64e.PGCFeedsInfo();
  public oidb_cmd0x64e.SocializeFeedsExtInfo msg_socialize_feeds_ext_info = new oidb_cmd0x64e.SocializeFeedsExtInfo();
  public oidb_cmd0x64e.UGCFeedsInfo msg_ugc_topic_feeds_info = new oidb_cmd0x64e.UGCFeedsInfo();
  public oidb_cmd0x64e.VerifyResult msg_verify_result = new oidb_cmd0x64e.VerifyResult();
  public final PBRepeatMessageField<oidb_cmd0x64e.SocializeFeedsInfoUser> rpt_recommend_list = PBField.initRepeatMessage(oidb_cmd0x64e.SocializeFeedsInfoUser.class);
  public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_biu_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114, 120, 128, 136, 146, 152, 160, 168, 178, 186, 194, 202 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_article_id", "msg_master_uin", "rpt_recommend_list", "bytes_comments", "bytes_recommend_reason", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "msg_socialize_feeds_ext_info", "uint32_biu_time", "uint32_myself_biu_status", "uint32_biu_count", "msg_biu_mutli_level", "msg_ugc_topic_feeds_info", "msg_pgc_topic_feeds_info", "msg_verify_result" }, new Object[] { Long.valueOf(0L), localInteger, Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localInteger, null, localInteger, localInteger, localInteger, null, null, null, null }, SocializeFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */