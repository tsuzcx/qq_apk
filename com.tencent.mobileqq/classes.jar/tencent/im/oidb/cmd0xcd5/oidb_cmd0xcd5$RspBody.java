package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xcd5$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "servicetype", "getdata_rsp", "setdata_rsp", "check_rsp" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
  public oidb_cmd0xcd5.CheckReplyRsp check_rsp = new oidb_cmd0xcd5.CheckReplyRsp();
  public oidb_cmd0xcd5.GetDataRsp getdata_rsp = new oidb_cmd0xcd5.GetDataRsp();
  public final PBUInt32Field servicetype = PBField.initUInt32(0);
  public oidb_cmd0xcd5.SetDataRsp setdata_rsp = new oidb_cmd0xcd5.SetDataRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.RspBody
 * JD-Core Version:    0.7.0.1
 */