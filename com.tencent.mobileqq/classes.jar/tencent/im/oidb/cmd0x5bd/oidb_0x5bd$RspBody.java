package tencent.im.oidb.cmd0x5bd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5bd$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98, 106, 114, 120 }, new String[] { "uint64_uin", "msg_now_skin_info", "msg_next_guide_info", "msg_operation_guide_info", "msg_operation_refresh_info", "uint32_source" }, new Object[] { Long.valueOf(0L), null, null, null, null, Integer.valueOf(0) }, RspBody.class);
  public oidb_0x5bd.GuideInfo msg_next_guide_info = new oidb_0x5bd.GuideInfo();
  public oidb_0x5bd.SkinInfo msg_now_skin_info = new oidb_0x5bd.SkinInfo();
  public oidb_0x5bd.GuideInfo msg_operation_guide_info = new oidb_0x5bd.GuideInfo();
  public oidb_0x5bd.RefreshInfo msg_operation_refresh_info = new oidb_0x5bd.RefreshInfo();
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RspBody
 * JD-Core Version:    0.7.0.1
 */