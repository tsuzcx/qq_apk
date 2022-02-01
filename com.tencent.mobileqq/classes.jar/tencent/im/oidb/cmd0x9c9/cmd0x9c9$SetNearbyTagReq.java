package tencent.im.oidb.cmd0x9c9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x9c9$SetNearbyTagReq
  extends MessageMicro<SetNearbyTagReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tag_id" }, new Object[] { "" }, SetNearbyTagReq.class);
  public final PBRepeatField<String> tag_id = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9c9.cmd0x9c9.SetNearbyTagReq
 * JD-Core Version:    0.7.0.1
 */