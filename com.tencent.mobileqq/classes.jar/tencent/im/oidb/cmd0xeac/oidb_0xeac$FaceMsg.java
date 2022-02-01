package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xeac$FaceMsg
  extends MessageMicro<FaceMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "index", "text" }, new Object[] { Integer.valueOf(0), "" }, FaceMsg.class);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBStringField text = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.FaceMsg
 * JD-Core Version:    0.7.0.1
 */