package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc46$ReqParam
  extends MessageMicro<ReqParam>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "with_sub_comments", "platform", "with_author_reply", "with_style_data", "req_advertise_para" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ReqParam.class);
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public oidb_cmd0xc46.ReqAdvertisePara req_advertise_para = new oidb_cmd0xc46.ReqAdvertisePara();
  public final PBUInt32Field with_author_reply = PBField.initUInt32(0);
  public final PBUInt32Field with_style_data = PBField.initUInt32(0);
  public final PBUInt32Field with_sub_comments = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqParam
 * JD-Core Version:    0.7.0.1
 */