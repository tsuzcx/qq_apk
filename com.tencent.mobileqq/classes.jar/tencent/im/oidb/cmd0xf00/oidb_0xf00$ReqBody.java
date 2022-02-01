package tencent.im.oidb.cmd0xf00;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf00$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_group_code", "msg_group_info_ext" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public oidb_0xf00.GroupInfoExt msg_group_info_ext = new oidb_0xf00.GroupInfoExt();
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf00.oidb_0xf00.ReqBody
 * JD-Core Version:    0.7.0.1
 */