package tencent.im.oidb.cmd0xbd3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xbd3$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_feed_param" }, new Object[] { null }, ReqBody.class);
  public final PBRepeatMessageField<oidb_cmd0xbd3.FeedParam> rpt_feed_param = PBField.initRepeatMessage(oidb_cmd0xbd3.FeedParam.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd3.oidb_cmd0xbd3.ReqBody
 * JD-Core Version:    0.7.0.1
 */