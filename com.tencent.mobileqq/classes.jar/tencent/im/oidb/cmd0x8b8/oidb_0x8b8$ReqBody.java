package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8b8$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0x8b8.DelPicReq msg_del_pic = new oidb_0x8b8.DelPicReq();
  public oidb_0x8b8.ModifyOrderReq msg_modify_order = new oidb_0x8b8.ModifyOrderReq();
  public oidb_0x8b8.SetDefaultReq msg_set_default = new oidb_0x8b8.SetDefaultReq();
  public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 64 }, new String[] { "uint64_group_uin", "uint32_sequence", "uint32_subcmd", "msg_modify_order", "msg_set_default", "msg_del_pic", "uint32_client_ver" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, null, null, null, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b8.oidb_0x8b8.ReqBody
 * JD-Core Version:    0.7.0.1
 */