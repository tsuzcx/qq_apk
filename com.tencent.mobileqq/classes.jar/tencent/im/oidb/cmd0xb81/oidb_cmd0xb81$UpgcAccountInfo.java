package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb81$UpgcAccountInfo
  extends MessageMicro<UpgcAccountInfo>
{
  public static final int NoSubmit = 0;
  public static final int SubmiFail = 3;
  public static final int SubmitPass = 1;
  public static final int Submiting = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBInt64Field status_timestamp = PBField.initInt64(0L);
  public final PBInt64Field timestamp = PBField.initInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field upgc_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 120 }, new String[] { "uin", "puin", "status", "status_timestamp", "upgc_flag", "timestamp" }, new Object[] { localLong, localLong, localInteger, localLong, localInteger, localLong }, UpgcAccountInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UpgcAccountInfo
 * JD-Core Version:    0.7.0.1
 */