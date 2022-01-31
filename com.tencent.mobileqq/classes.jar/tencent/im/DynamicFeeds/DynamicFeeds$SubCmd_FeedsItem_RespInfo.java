package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class DynamicFeeds$SubCmd_FeedsItem_RespInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "SubCmd_Resp" }, new Object[] { null }, SubCmd_FeedsItem_RespInfo.class);
  public final PBRepeatMessageField SubCmd_Resp = PBField.initRepeatMessage(DynamicFeeds.SubCmd_FeedsItem_Resp.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicFeeds.SubCmd_FeedsItem_RespInfo
 * JD-Core Version:    0.7.0.1
 */