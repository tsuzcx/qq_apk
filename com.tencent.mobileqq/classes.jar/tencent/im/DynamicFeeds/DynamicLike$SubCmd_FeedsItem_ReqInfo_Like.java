package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class DynamicLike$SubCmd_FeedsItem_ReqInfo_Like
  extends MessageMicro<SubCmd_FeedsItem_ReqInfo_Like>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "LikeList" }, new Object[] { null }, SubCmd_FeedsItem_ReqInfo_Like.class);
  public final PBRepeatMessageField<DynamicLike.FeedsItem_Like> LikeList = PBField.initRepeatMessage(DynamicLike.FeedsItem_Like.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicLike.SubCmd_FeedsItem_ReqInfo_Like
 * JD-Core Version:    0.7.0.1
 */