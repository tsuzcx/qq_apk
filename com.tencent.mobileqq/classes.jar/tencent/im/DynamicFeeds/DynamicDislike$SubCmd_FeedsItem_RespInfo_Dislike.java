package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicDislike$SubCmd_FeedsItem_RespInfo_Dislike
  extends MessageMicro<SubCmd_FeedsItem_RespInfo_Dislike>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uiRetCode" }, new Object[] { Integer.valueOf(0) }, SubCmd_FeedsItem_RespInfo_Dislike.class);
  public final PBUInt32Field uiRetCode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicDislike.SubCmd_FeedsItem_RespInfo_Dislike
 * JD-Core Version:    0.7.0.1
 */