package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicFeeds$FeedsItem_Req
  extends MessageMicro<FeedsItem_Req>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uiResID", "uiOpenFlag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FeedsItem_Req.class);
  public final PBUInt32Field uiOpenFlag = PBField.initUInt32(0);
  public final PBUInt32Field uiResID = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicFeeds.FeedsItem_Req
 * JD-Core Version:    0.7.0.1
 */