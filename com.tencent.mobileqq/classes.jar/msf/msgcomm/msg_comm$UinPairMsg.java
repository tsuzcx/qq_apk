package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_comm$UinPairMsg
  extends MessageMicro<UinPairMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field c2c_type = PBField.initUInt32(0);
  public final PBUInt32Field last_read_time = PBField.initUInt32(0);
  public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
  public final PBUInt32Field msg_completed = PBField.initUInt32(0);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  public final PBUInt32Field service_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_to_tiny_id = PBField.initUInt64(0L);
  public final PBUInt32Field unread_msg_num = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 64, 72, 82, 88 }, new String[] { "last_read_time", "peer_uin", "msg_completed", "msg", "unread_msg_num", "c2c_type", "service_type", "bytes_pb_reserve", "uint64_to_tiny_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, UinPairMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msf.msgcomm.msg_comm.UinPairMsg
 * JD-Core Version:    0.7.0.1
 */