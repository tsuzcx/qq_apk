package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudEeveeBusiInterface$SingleBizMsgAnswer
  extends MessageMicro<SingleBizMsgAnswer>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field bizCode = PBField.initInt32(0);
  public final PBBytesField bufferData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField mainType = PBField.initEnum(101);
  public final PBStringField msgid = PBField.initString("");
  public FeedCloudCommon.Result result = new FeedCloudCommon.Result();
  public final PBEnumField subid = PBField.initEnum(1010001);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48 }, new String[] { "result", "msgid", "mainType", "subid", "bufferData", "bizCode" }, new Object[] { null, "", Integer.valueOf(101), Integer.valueOf(1010001), localByteStringMicro, Integer.valueOf(0) }, SingleBizMsgAnswer.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudEeveeBusiInterface.SingleBizMsgAnswer
 * JD-Core Version:    0.7.0.1
 */