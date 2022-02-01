package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x435$GetPKItemReqBody
  extends MessageMicro<GetPKItemReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_pk_item_id" }, new Object[] { Integer.valueOf(0) }, GetPKItemReqBody.class);
  public final PBUInt32Field uint32_pk_item_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x435.oidb_0x435.GetPKItemReqBody
 * JD-Core Version:    0.7.0.1
 */