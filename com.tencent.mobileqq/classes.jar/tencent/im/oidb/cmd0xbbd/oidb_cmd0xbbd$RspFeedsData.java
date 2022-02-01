package tencent.im.oidb.cmd0xbbd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xbbd$RspFeedsData
  extends MessageMicro<RspFeedsData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90 }, new String[] { "rpt_feeds_info_list" }, new Object[] { null }, RspFeedsData.class);
  public final PBRepeatMessageField<oidb_cmd0xbbd.RspFeedsInfo> rpt_feeds_info_list = PBField.initRepeatMessage(oidb_cmd0xbbd.RspFeedsInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.RspFeedsData
 * JD-Core Version:    0.7.0.1
 */