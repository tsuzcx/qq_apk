package tencent.im.oidb.cmd0xf26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0xf26$QueryReq
  extends MessageMicro<QueryReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "show_unchangeable_auth" }, new Object[] { Boolean.valueOf(false) }, QueryReq.class);
  public final PBBoolField show_unchangeable_auth = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf26.oidb_0xf26.QueryReq
 * JD-Core Version:    0.7.0.1
 */