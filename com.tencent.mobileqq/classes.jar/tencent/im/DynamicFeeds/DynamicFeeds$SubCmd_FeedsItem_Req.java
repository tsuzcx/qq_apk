package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicFeeds$SubCmd_FeedsItem_Req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uiPluginID = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uiPluginID", "buffer" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, SubCmd_FeedsItem_Req.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicFeeds.SubCmd_FeedsItem_Req
 * JD-Core Version:    0.7.0.1
 */