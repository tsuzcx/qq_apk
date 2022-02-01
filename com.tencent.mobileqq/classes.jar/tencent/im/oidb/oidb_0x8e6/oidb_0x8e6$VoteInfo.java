package tencent.im.oidb.oidb_0x8e6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8e6$VoteInfo
  extends MessageMicro<VoteInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_free_vote_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pay_vote_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_tinyid", "uint64_uin", "uint32_free_vote_count", "uint32_pay_vote_count", "uint32_source" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger }, VoteInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.VoteInfo
 * JD-Core Version:    0.7.0.1
 */