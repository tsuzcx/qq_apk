package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class im_msg$C2CRelation
  extends MessageMicro<C2CRelation>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "c2c_type", "group_info", "token" }, new Object[] { Integer.valueOf(0), null, null }, C2CRelation.class);
  public final PBEnumField c2c_type = PBField.initEnum(0);
  public im_common.GroupInfo group_info = new im_common.GroupInfo();
  public im_common.Token token = new im_common.Token();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg.C2CRelation
 * JD-Core Version:    0.7.0.1
 */