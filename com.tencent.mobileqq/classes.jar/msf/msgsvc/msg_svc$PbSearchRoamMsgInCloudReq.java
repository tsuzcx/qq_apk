package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class msg_svc$PbSearchRoamMsgInCloudReq
  extends MessageMicro<PbSearchRoamMsgInCloudReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField serialize_reqbody = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "serialize_reqbody" }, new Object[] { localByteStringMicro }, PbSearchRoamMsgInCloudReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbSearchRoamMsgInCloudReq
 * JD-Core Version:    0.7.0.1
 */