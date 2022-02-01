package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class device$Device$IdInfo
  extends MessageMicro<IdInfo>
{
  public static final int DEVICE_ID = 1;
  public static final int DEVICE_ID_0 = 2;
  public static final int DEVICE_ID_1 = 4;
  public static final int IMEI = 8;
  public static final int IMEI_0 = 16;
  public static final int IMEI_1 = 32;
  public static final int MEID = 64;
  public static final int MEID_0 = 128;
  public static final int MEID_1 = 256;
  public static final int SUBSCRIBER_ID = 512;
  public static final int SUBSCRIBER_ID_0 = 1024;
  public static final int SUBSCRIBER_ID_1 = 2048;
  public static final int UNKNOWN = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "device_id", "bitmap" }, new Object[] { "", Integer.valueOf(0) }, IdInfo.class);
  public final PBUInt32Field bitmap = PBField.initUInt32(0);
  public final PBStringField device_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.gdt.device.Device.IdInfo
 * JD-Core Version:    0.7.0.1
 */