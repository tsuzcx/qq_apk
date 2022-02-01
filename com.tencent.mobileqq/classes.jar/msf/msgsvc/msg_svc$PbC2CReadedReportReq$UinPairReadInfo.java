package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbC2CReadedReportReq$UinPairReadInfo
  extends MessageMicro<UinPairReadInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field aio_type = PBField.initUInt32(0);
  public final PBUInt32Field chat_type = PBField.initUInt32(0);
  public final PBUInt64Field cpid = PBField.initUInt64(0L);
  public final PBBytesField crm_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field last_read_time = PBField.initUInt32(0);
  public final PBEnumField peer_type = PBField.initEnum(1);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_tiny_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 72 }, new String[] { "peer_uin", "last_read_time", "crm_sig", "peer_type", "chat_type", "cpid", "aio_type", "uint64_to_tiny_id" }, new Object[] { localLong, localInteger, localByteStringMicro, Integer.valueOf(1), localInteger, localLong, localInteger, localLong }, UinPairReadInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo
 * JD-Core Version:    0.7.0.1
 */