package tencent.im.oidb.cmd0xedb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xedb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "dstUsrType", "dstUsrInfos" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public final PBRepeatMessageField<oidb_0xedb.ReqUsrInfo> dstUsrInfos = PBField.initRepeatMessage(oidb_0xedb.ReqUsrInfo.class);
  public final PBUInt32Field dstUsrType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xedb.oidb_0xedb.ReqBody
 * JD-Core Version:    0.7.0.1
 */