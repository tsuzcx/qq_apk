package tencent.im.oidb.cmd0xd46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xd46$KsGetSubscribedListReq
  extends MessageMicro<KsGetSubscribedListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_result_type" }, new Object[] { Integer.valueOf(0) }, KsGetSubscribedListReq.class);
  public final PBUInt32Field uint32_result_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd46.oidb_cmd0xd46.KsGetSubscribedListReq
 * JD-Core Version:    0.7.0.1
 */