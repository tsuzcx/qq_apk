package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$QQGroupDigestSummaryInfo
  extends MessageMicro<QQGroupDigestSummaryInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field error_code = PBField.initUInt32(0);
  public final PBUInt32Field msg_random = PBField.initUInt32(0);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "msg_seq", "msg_random", "error_code" }, new Object[] { localInteger, localInteger, localInteger }, QQGroupDigestSummaryInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestSummaryInfo
 * JD-Core Version:    0.7.0.1
 */