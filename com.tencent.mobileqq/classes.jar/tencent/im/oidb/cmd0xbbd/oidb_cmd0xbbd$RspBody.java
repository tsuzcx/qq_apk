package tencent.im.oidb.cmd0xbbd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbbd$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_uin", "msg_rsp_feeds_data" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
  public oidb_cmd0xbbd.RspFeedsData msg_rsp_feeds_data = new oidb_cmd0xbbd.RspFeedsData();
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.RspBody
 * JD-Core Version:    0.7.0.1
 */