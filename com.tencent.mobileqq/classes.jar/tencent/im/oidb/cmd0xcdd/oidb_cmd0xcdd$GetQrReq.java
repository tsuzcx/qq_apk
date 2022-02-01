package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xcdd$GetQrReq
  extends MessageMicro<GetQrReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "push", "user_data", "biz_type" }, new Object[] { Boolean.valueOf(false), null, Integer.valueOf(1) }, GetQrReq.class);
  public final PBEnumField biz_type = PBField.initEnum(1);
  public final PBBoolField push = PBField.initBool(false);
  public oidb_cmd0xcdd.UserData user_data = new oidb_cmd0xcdd.UserData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.GetQrReq
 * JD-Core Version:    0.7.0.1
 */