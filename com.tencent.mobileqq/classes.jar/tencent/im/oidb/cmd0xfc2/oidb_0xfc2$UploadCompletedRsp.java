package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xfc2$UploadCompletedRsp
  extends MessageMicro<UploadCompletedRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_file_info" }, new Object[] { null }, UploadCompletedRsp.class);
  public oidb_0xfc2.FileInfo msg_file_info = new oidb_0xfc2.FileInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfc2.oidb_0xfc2.UploadCompletedRsp
 * JD-Core Version:    0.7.0.1
 */