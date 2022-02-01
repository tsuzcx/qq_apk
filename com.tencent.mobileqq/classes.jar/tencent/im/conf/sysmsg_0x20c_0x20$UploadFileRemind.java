package tencent.im.conf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sysmsg_0x20c_0x20$UploadFileRemind
  extends MessageMicro<UploadFileRemind>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "u64_discuss_code" }, new Object[] { Long.valueOf(0L) }, UploadFileRemind.class);
  public final PBUInt64Field u64_discuss_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.conf.sysmsg_0x20c_0x20.UploadFileRemind
 * JD-Core Version:    0.7.0.1
 */