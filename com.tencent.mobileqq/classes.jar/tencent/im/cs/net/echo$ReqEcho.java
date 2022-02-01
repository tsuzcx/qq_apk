package tencent.im.cs.net;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class echo$ReqEcho
  extends MessageMicro<ReqEcho>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uid" }, new Object[] { Long.valueOf(0L) }, ReqEcho.class);
  public final PBUInt64Field uint64_uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.net.echo.ReqEcho
 * JD-Core Version:    0.7.0.1
 */