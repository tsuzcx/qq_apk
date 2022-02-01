package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicLike$SubCmd_FeedsItem_RespInfo_Like
  extends MessageMicro<SubCmd_FeedsItem_RespInfo_Like>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uiRetCode" }, new Object[] { Integer.valueOf(0) }, SubCmd_FeedsItem_RespInfo_Like.class);
  public final PBUInt32Field uiRetCode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicLike.SubCmd_FeedsItem_RespInfo_Like
 * JD-Core Version:    0.7.0.1
 */