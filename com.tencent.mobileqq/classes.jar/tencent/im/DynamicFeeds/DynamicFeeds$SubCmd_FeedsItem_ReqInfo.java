package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicFeeds$SubCmd_FeedsItem_ReqInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField SubCmd_Req = PBField.initRepeatMessage(DynamicFeeds.SubCmd_FeedsItem_Req.class);
  public final PBStringField qua = PBField.initString("");
  public final PBUInt32Field reqEvent = PBField.initUInt32(0);
  public final PBBytesField skey = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "skey", "qua", "reqEvent", "SubCmd_Req" }, new Object[] { localByteStringMicro, "", Integer.valueOf(0), null }, SubCmd_FeedsItem_ReqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicFeeds.SubCmd_FeedsItem_ReqInfo
 * JD-Core Version:    0.7.0.1
 */