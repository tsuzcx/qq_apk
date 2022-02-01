package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$QQGroupDigestMsgSummary
  extends MessageMicro<QQGroupDigestMsgSummary>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField digest_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field digest_oper = PBField.initUInt64(0L);
  public final PBUInt32Field op_time = PBField.initUInt32(0);
  public final PBInt32Field op_type = PBField.initInt32(0);
  public final PBInt32Field succ_cnt = PBField.initInt32(0);
  public final PBRepeatMessageField<TroopTips0x857.QQGroupDigestSummaryInfo> summary_info = PBField.initRepeatMessage(TroopTips0x857.QQGroupDigestSummaryInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50 }, new String[] { "digest_oper", "op_type", "op_time", "digest_nick", "succ_cnt", "summary_info" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localByteStringMicro, localInteger, null }, QQGroupDigestMsgSummary.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestMsgSummary
 * JD-Core Version:    0.7.0.1
 */