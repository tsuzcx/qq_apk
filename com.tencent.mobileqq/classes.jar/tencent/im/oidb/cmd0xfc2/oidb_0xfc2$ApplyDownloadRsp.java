package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xfc2$ApplyDownloadRsp
  extends MessageMicro<ApplyDownloadRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "msg_download_info", "msg_file_info", "msg_chacha20_param", "uint32_use_encrypt" }, new Object[] { null, null, null, Integer.valueOf(0) }, ApplyDownloadRsp.class);
  public oidb_0xfc2.ChaCha20EncryptParam msg_chacha20_param = new oidb_0xfc2.ChaCha20EncryptParam();
  public oidb_0xfc2.DownloadInfo msg_download_info = new oidb_0xfc2.DownloadInfo();
  public oidb_0xfc2.FileInfo msg_file_info = new oidb_0xfc2.FileInfo();
  public final PBUInt32Field uint32_use_encrypt = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ApplyDownloadRsp
 * JD-Core Version:    0.7.0.1
 */