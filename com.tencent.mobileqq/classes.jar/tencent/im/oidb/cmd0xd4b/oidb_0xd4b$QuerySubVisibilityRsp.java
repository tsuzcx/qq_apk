package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd4b$QuerySubVisibilityRsp
  extends MessageMicro<QuerySubVisibilityRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_visibility" }, new Object[] { Integer.valueOf(0) }, QuerySubVisibilityRsp.class);
  public final PBUInt32Field uint32_visibility = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.QuerySubVisibilityRsp
 * JD-Core Version:    0.7.0.1
 */