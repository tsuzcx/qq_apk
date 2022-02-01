package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class apollo_push_msgInfo$STPushMsgElem$STPushMsgElem0x1
  extends MessageMicro<STPushMsgElem0x1>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field actionId = PBField.initInt32(0);
  public final PBInt32Field actionType = PBField.initInt32(0);
  public final PBInt32Field aioType = PBField.initInt32(0);
  public final PBStringField diyWords = PBField.initString("");
  public final PBUInt64Field rcvUin = PBField.initUInt64(0L);
  public final PBUInt64Field sendUin = PBField.initUInt64(0L);
  public final PBUInt64Field sessionId = PBField.initUInt64(0L);
  public final PBInt32Field wordType = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "actionId", "actionType", "sendUin", "rcvUin", "aioType", "sessionId", "wordType", "diyWords" }, new Object[] { localInteger, localInteger, localLong, localLong, localInteger, localLong, localInteger, "" }, STPushMsgElem0x1.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1
 * JD-Core Version:    0.7.0.1
 */