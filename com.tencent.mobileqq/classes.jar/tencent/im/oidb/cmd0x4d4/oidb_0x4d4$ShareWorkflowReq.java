package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x4d4$ShareWorkflowReq
  extends MessageMicro<ShareWorkflowReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x4d4.ShareReceiver msg_receiver = new oidb_0x4d4.ShareReceiver();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_workflow_id", "msg_receiver" }, new Object[] { localByteStringMicro, null }, ShareWorkflowReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.ShareWorkflowReq
 * JD-Core Version:    0.7.0.1
 */