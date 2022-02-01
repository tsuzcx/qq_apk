package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class fd_comm$OfficialAccountInfo
  extends MessageMicro<OfficialAccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "official_uin", "official_nick" }, new Object[] { Long.valueOf(0L), "" }, OfficialAccountInfo.class);
  public final PBStringField official_nick = PBField.initString("");
  public final PBUInt64Field official_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     fudai.fd_comm.OfficialAccountInfo
 * JD-Core Version:    0.7.0.1
 */