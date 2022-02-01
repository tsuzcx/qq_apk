package tencent.im.oidb.cmd0xb36;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb36$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "group_id", "toast", "chain_list" }, new Object[] { Long.valueOf(0L), null, null }, RspBody.class);
  public oidb_cmd0xb36.ChainList chain_list = new oidb_cmd0xb36.ChainList();
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public oidb_cmd0xb36.ToastInfo toast = new oidb_cmd0xb36.ToastInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.RspBody
 * JD-Core Version:    0.7.0.1
 */