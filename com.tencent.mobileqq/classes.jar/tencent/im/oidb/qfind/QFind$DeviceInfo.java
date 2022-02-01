package tencent.im.oidb.qfind;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QFind$DeviceInfo
  extends MessageMicro<DeviceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public QFind.DeviceLoc dev_loc = new QFind.DeviceLoc();
  public final PBUInt64Field din = PBField.initUInt64(0L);
  public QFind.HistoryData msg_walking_history = new QFind.HistoryData();
  public final PBUInt32Field pid = PBField.initUInt32(0);
  public final PBUInt64Field service_uuid = PBField.initUInt64(0L);
  public final PBBytesField sn = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field timestamp = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_verify_dev = PBField.initUInt32(0);
  public final PBUInt32Field uint32_verify_dev_interval = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 58, 66, 72, 80, 162 }, new String[] { "service_uuid", "pid", "sn", "din", "timestamp", "type", "dev_loc", "bytes_sig", "uint32_need_verify_dev", "uint32_verify_dev_interval", "msg_walking_history" }, new Object[] { localLong, localInteger, localByteStringMicro1, localLong, localInteger, localInteger, null, localByteStringMicro2, localInteger, localInteger, null }, DeviceInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qfind.QFind.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */