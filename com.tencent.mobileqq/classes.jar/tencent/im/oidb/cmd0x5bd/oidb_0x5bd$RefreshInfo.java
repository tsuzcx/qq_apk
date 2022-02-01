package tencent.im.oidb.cmd0x5bd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5bd$RefreshInfo
  extends MessageMicro<RefreshInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0x5bd.AdReport> msg_ad_click_report = PBField.initRepeatMessage(oidb_0x5bd.AdReport.class);
  public final PBRepeatMessageField<oidb_0x5bd.AdReport> msg_ad_exposure_report = PBField.initRepeatMessage(oidb_0x5bd.AdReport.class);
  public final PBUInt32Field uint32_begin_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_ad = PBField.initUInt32(0);
  public final PBUInt64Field uint64_ad_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66, 74, 80 }, new String[] { "bytes_id", "bytes_name", "uint32_begin_timestamp", "uint32_end_timestamp", "uint64_seq", "bytes_url", "uint32_is_ad", "msg_ad_click_report", "msg_ad_exposure_report", "uint64_ad_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), null, null, Long.valueOf(0L) }, RefreshInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo
 * JD-Core Version:    0.7.0.1
 */