package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x51d$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_errinfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x51d.GetAppNoticeRsp opt_msg_app_notice_rsp = new oidb_0x51d.GetAppNoticeRsp();
  public oidb_0x51d.GetOfficeNoticeRsp opt_msg_office_notice_rsp = new oidb_0x51d.GetOfficeNoticeRsp();
  public oidb_0x51d.GetSubItemNoticeRsp opt_msg_subitem_notice_rsp = new oidb_0x51d.GetSubItemNoticeRsp();
  public final PBUInt32Field opt_uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "opt_uint32_result", "opt_bytes_errinfo", "opt_msg_office_notice_rsp", "opt_msg_app_notice_rsp", "opt_msg_subitem_notice_rsp" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x51d.oidb_0x51d.RspBody
 * JD-Core Version:    0.7.0.1
 */