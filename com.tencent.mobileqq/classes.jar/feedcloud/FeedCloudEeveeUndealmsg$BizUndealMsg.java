package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudEeveeUndealmsg$BizUndealMsg
  extends MessageMicro<BizUndealMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bufferData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field mainType = PBField.initInt32(0);
  public final PBStringField msgid = PBField.initString("");
  public FeedCloudCommon.Result result = new FeedCloudCommon.Result();
  public final PBInt32Field subid = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "result", "msgid", "mainType", "subid", "bufferData" }, new Object[] { null, "", localInteger, localInteger, localByteStringMicro }, BizUndealMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudEeveeUndealmsg.BizUndealMsg
 * JD-Core Version:    0.7.0.1
 */