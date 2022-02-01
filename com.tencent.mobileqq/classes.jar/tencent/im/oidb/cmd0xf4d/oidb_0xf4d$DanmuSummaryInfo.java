package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf4d$DanmuSummaryInfo
  extends MessageMicro<DanmuSummaryInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField danmu_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field danmu_total_nums = PBField.initUInt64(0L);
  public final PBStringField open_text = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "danmu_total_nums", "danmu_cookie", "open_text" }, new Object[] { Long.valueOf(0L), localByteStringMicro, "" }, DanmuSummaryInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf4d.oidb_0xf4d.DanmuSummaryInfo
 * JD-Core Version:    0.7.0.1
 */