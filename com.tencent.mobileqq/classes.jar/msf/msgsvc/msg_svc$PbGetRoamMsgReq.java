package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbGetRoamMsgReq
  extends MessageMicro<PbGetRoamMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field begin_msgtime = PBField.initUInt64(0L);
  public final PBUInt32Field check_pwd = PBField.initUInt32(0);
  public final PBUInt64Field last_msgtime = PBField.initUInt64(0L);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  public final PBBytesField pwd = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field random = PBField.initUInt64(0L);
  public final PBUInt32Field read_cnt = PBField.initUInt32(0);
  public final PBUInt32Field req_type = PBField.initUInt32(0);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field subcmd = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64, 72, 80 }, new String[] { "peer_uin", "last_msgtime", "random", "read_cnt", "check_pwd", "sig", "pwd", "subcmd", "begin_msgtime", "req_type" }, new Object[] { localLong, localLong, localLong, localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, localLong, localInteger }, PbGetRoamMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetRoamMsgReq
 * JD-Core Version:    0.7.0.1
 */