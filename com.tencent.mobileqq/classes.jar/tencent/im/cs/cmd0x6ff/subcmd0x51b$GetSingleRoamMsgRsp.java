package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm.Msg;

public final class subcmd0x51b$GetSingleRoamMsgRsp
  extends MessageMicro<GetSingleRoamMsgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
  public final PBEnumField ret_code = PBField.initEnum(0);
  public final PBRepeatMessageField<msg_comm.Msg> rpt_msg_msg_list = PBField.initRepeatMessage(msg_comm.Msg.class);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8("");
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "ret_code", "bytes_error_msg", "uint64_puin", "rpt_msg_msg_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), null }, GetSingleRoamMsgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x51b.GetSingleRoamMsgRsp
 * JD-Core Version:    0.7.0.1
 */