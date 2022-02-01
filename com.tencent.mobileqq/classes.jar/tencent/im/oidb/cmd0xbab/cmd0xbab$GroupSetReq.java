package tencent.im.oidb.cmd0xbab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xbab$GroupSetReq
  extends MessageMicro<GroupSetReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48 }, new String[] { "group_code", "doc_url", "privilege_flag", "policy", "only", "exp_set_time" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, GroupSetReq.class);
  public final PBStringField doc_url = PBField.initString("");
  public final PBUInt32Field exp_set_time = PBField.initUInt32(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBBoolField only = PBField.initBool(false);
  public final PBUInt32Field policy = PBField.initUInt32(0);
  public final PBUInt32Field privilege_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbab.cmd0xbab.GroupSetReq
 * JD-Core Version:    0.7.0.1
 */