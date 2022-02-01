package tencent.im.oidb.cmd0xbbd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xbbd$ReqPara
  extends MessageMicro<ReqPara>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_req_feeds_info" }, new Object[] { null }, ReqPara.class);
  public final PBRepeatMessageField<oidb_cmd0xbbd.ReqFeedsInfo> rpt_req_feeds_info = PBField.initRepeatMessage(oidb_cmd0xbbd.ReqFeedsInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.ReqPara
 * JD-Core Version:    0.7.0.1
 */