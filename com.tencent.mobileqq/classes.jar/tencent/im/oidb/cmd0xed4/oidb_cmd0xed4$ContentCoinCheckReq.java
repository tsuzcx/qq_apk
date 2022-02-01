package tencent.im.oidb.cmd0xed4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xed4$ContentCoinCheckReq
  extends MessageMicro<ContentCoinCheckReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin", "rowkey" }, new Object[] { Long.valueOf(0L), "" }, ContentCoinCheckReq.class);
  public final PBStringField rowkey = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ContentCoinCheckReq
 * JD-Core Version:    0.7.0.1
 */