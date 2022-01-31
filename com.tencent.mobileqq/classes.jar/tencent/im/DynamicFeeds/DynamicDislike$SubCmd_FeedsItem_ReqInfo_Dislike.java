package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class DynamicDislike$SubCmd_FeedsItem_ReqInfo_Dislike
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "DislikeList" }, new Object[] { null }, SubCmd_FeedsItem_ReqInfo_Dislike.class);
  public final PBRepeatMessageField DislikeList = PBField.initRepeatMessage(DynamicDislike.FeedsItem_Dislike.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicDislike.SubCmd_FeedsItem_ReqInfo_Dislike
 * JD-Core Version:    0.7.0.1
 */