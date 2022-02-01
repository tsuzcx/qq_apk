package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class feeds_info$BiuOneLevelItem
  extends MessageMicro<BiuOneLevelItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_biu_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field feeds_type = PBField.initUInt32(0);
  public feeds_info.JumpInfo msg_jump_info = new feeds_info.JumpInfo();
  public feeds_info.UGCVoiceInfo msg_voice_info = new feeds_info.UGCVoiceInfo();
  public final PBEnumField op_type = PBField.initEnum(0);
  public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 66 }, new String[] { "uint64_feeds_id", "uint64_uin", "uint32_biu_time", "bytes_biu_comments", "feeds_type", "op_type", "msg_jump_info", "msg_voice_info" }, new Object[] { localLong, localLong, localInteger, localByteStringMicro, localInteger, localInteger, null, null }, BiuOneLevelItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.BiuOneLevelItem
 * JD-Core Version:    0.7.0.1
 */