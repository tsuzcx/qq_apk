package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xbcb$CheckUrlRsp
  extends MessageMicro<CheckUrlRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "results", "next_req_duration" }, new Object[] { null, Integer.valueOf(0) }, CheckUrlRsp.class);
  public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xbcb.UrlCheckResult> results = PBField.initRepeatMessage(oidb_0xbcb.UrlCheckResult.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xbcb.CheckUrlRsp
 * JD-Core Version:    0.7.0.1
 */