package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_lbs_share$PushExtInfo
  extends MessageMicro<PushExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "peer_uin", "client_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1) }, PushExtInfo.class);
  public final PBEnumField client_type = PBField.initEnum(1);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.location.qq_lbs_share.PushExtInfo
 * JD-Core Version:    0.7.0.1
 */