package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xcd5$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "service_type", "getdata_req", "setdata_req", "check_req" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
  public oidb_cmd0xcd5.CheckReplyReq check_req = new oidb_cmd0xcd5.CheckReplyReq();
  public oidb_cmd0xcd5.GetDataReq getdata_req = new oidb_cmd0xcd5.GetDataReq();
  public final PBUInt32Field service_type = PBField.initUInt32(0);
  public oidb_cmd0xcd5.SetDataReq setdata_req = new oidb_cmd0xcd5.SetDataReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.ReqBody
 * JD-Core Version:    0.7.0.1
 */