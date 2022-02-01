package tencent.im.oidb.cmd0xedb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xedb$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dstHeadInfos" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xedb.RspHeadInfo> dstHeadInfos = PBField.initRepeatMessage(oidb_0xedb.RspHeadInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xedb.oidb_0xedb.RspBody
 * JD-Core Version:    0.7.0.1
 */