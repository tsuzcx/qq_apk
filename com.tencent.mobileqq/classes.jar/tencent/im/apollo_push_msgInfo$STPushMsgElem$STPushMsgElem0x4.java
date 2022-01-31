package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class apollo_push_msgInfo$STPushMsgElem$STPushMsgElem0x4
  extends MessageMicro<STPushMsgElem0x4>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "appid", "name", "srcVer", "newVer" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, STPushMsgElem0x4.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field newVer = PBField.initUInt32(0);
  public final PBUInt32Field srcVer = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4
 * JD-Core Version:    0.7.0.1
 */