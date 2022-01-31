package tencent.im.oidb.cmd0x58a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x58a$GetCommConfReq
  extends MessageMicro<GetCommConfReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_other_uin" }, new Object[] { Long.valueOf(0L) }, GetCommConfReq.class);
  public final PBUInt64Field uint64_other_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58a.cmd0x58a.GetCommConfReq
 * JD-Core Version:    0.7.0.1
 */