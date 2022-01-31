package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class apollo_push_msgInfo$STPushMsgElem$STPushMsgElem0x2
  extends MessageMicro<STPushMsgElem0x2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "toUin", "actionId", "endTs", "wordType", "diyWords" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "" }, STPushMsgElem0x2.class);
  public final PBInt32Field actionId = PBField.initInt32(0);
  public final PBStringField diyWords = PBField.initString("");
  public final PBUInt64Field endTs = PBField.initUInt64(0L);
  public final PBUInt64Field toUin = PBField.initUInt64(0L);
  public final PBInt32Field wordType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2
 * JD-Core Version:    0.7.0.1
 */