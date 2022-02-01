package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x388$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_extension = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<cmd0x388.DelImgReq> rpt_msg_del_img_req = PBField.initRepeatMessage(cmd0x388.DelImgReq.class);
  public final PBRepeatMessageField<cmd0x388.GetImgUrlReq> rpt_msg_getimg_url_req = PBField.initRepeatMessage(cmd0x388.GetImgUrlReq.class);
  public final PBRepeatMessageField<cmd0x388.GetPttUrlReq> rpt_msg_getptt_url_req = PBField.initRepeatMessage(cmd0x388.GetPttUrlReq.class);
  public final PBRepeatMessageField<cmd0x388.TryUpImgReq> rpt_msg_tryup_img_req = PBField.initRepeatMessage(cmd0x388.TryUpImgReq.class);
  public final PBRepeatMessageField<cmd0x388.TryUpPttReq> rpt_msg_tryup_ptt_req = PBField.initRepeatMessage(cmd0x388.TryUpPttReq.class);
  public final PBUInt32Field uint32_command_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 66, 8010 }, new String[] { "uint32_net_type", "uint32_subcmd", "rpt_msg_tryup_img_req", "rpt_msg_getimg_url_req", "rpt_msg_tryup_ptt_req", "rpt_msg_getptt_url_req", "uint32_command_id", "rpt_msg_del_img_req", "bytes_extension" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.ReqBody
 * JD-Core Version:    0.7.0.1
 */