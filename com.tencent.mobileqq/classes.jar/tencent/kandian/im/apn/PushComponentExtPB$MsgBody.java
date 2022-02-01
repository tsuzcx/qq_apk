package tencent.kandian.im.apn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PushComponentExtPB$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField algoId = PBField.initString("");
  public final PBStringField articleIds = PBField.initString("");
  public final PBStringField foldStatus = PBField.initString("");
  public final PBBytesField pushExtData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField strategyId = PBField.initString("");
  public final PBStringField subscripts = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "articleIds", "foldStatus", "algoId", "strategyId", "subscripts", "pushExtData" }, new Object[] { "", "", "", "", "", localByteStringMicro }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.kandian.im.apn.PushComponentExtPB.MsgBody
 * JD-Core Version:    0.7.0.1
 */