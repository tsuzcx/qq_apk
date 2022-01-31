package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x519$GetNavigationMenuReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_puin", "uint64_uin", "uint32_ver_no" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GetNavigationMenuReqBody.class);
  public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x519.GetNavigationMenuReqBody
 * JD-Core Version:    0.7.0.1
 */