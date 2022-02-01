package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import msf.msgcomm.msg_comm.Msg;

public final class msg_svc$PbSearchRoamMsgInCloudResp
  extends MessageMicro<PbSearchRoamMsgInCloudResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
  public final PBBytesField serialize_rspbody = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg", "serialize_rspbody" }, new Object[] { null, localByteStringMicro }, PbSearchRoamMsgInCloudResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbSearchRoamMsgInCloudResp
 * JD-Core Version:    0.7.0.1
 */