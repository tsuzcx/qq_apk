package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudEeveeBusiInterface$SingleBizMsgAsk
  extends MessageMicro<SingleBizMsgAsk>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField mainType = PBField.initEnum(101);
  public final PBStringField msgid = PBField.initString("");
  public final PBEnumField subid = PBField.initEnum(1010001);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "mainType", "subid", "busiData", "msgid" }, new Object[] { Integer.valueOf(101), Integer.valueOf(1010001), localByteStringMicro, "" }, SingleBizMsgAsk.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudEeveeBusiInterface.SingleBizMsgAsk
 * JD-Core Version:    0.7.0.1
 */