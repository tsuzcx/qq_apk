package tencent.im.oidb.cmd0xedb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xedb$ReqUsrInfo
  extends MessageMicro<ReqUsrInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "dstUin", "timestamp" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqUsrInfo.class);
  public final PBUInt64Field dstUin = PBField.initUInt64(0L);
  public final PBUInt32Field timestamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xedb.oidb_0xedb.ReqUsrInfo
 * JD-Core Version:    0.7.0.1
 */