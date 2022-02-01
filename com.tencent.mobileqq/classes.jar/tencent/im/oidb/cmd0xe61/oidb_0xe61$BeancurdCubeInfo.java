package tencent.im.oidb.cmd0xe61;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe61$BeancurdCubeInfo
  extends MessageMicro<BeancurdCubeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_busi_data_req = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_busi_data_rsp = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_event_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_flag = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_frd_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_pull_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_pull_interval_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_valid_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 8002, 8010 }, new String[] { "uint64_busi_id", "uint64_uin", "uint64_frd_uin", "uint64_event_time", "uint64_pull_interval_time", "uint64_last_pull_time", "uint64_valid_time", "uint64_flag", "bytes_busi_data_req", "bytes_busi_data_rsp" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, BeancurdCubeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo
 * JD-Core Version:    0.7.0.1
 */