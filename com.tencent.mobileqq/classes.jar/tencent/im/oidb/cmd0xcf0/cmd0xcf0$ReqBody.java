package tencent.im.oidb.cmd0xcf0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xcf0$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_expect_bind_contacts_frd_num" }, new Object[] { Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_expect_bind_contacts_frd_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcf0.cmd0xcf0.ReqBody
 * JD-Core Version:    0.7.0.1
 */