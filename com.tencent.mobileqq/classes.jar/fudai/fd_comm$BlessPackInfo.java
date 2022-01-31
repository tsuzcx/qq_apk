package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class fd_comm$BlessPackInfo
  extends MessageMicro<BlessPackInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bless_des", "jmp_url", "bless_id" }, new Object[] { "", "", Integer.valueOf(0) }, BlessPackInfo.class);
  public final PBStringField bless_des = PBField.initString("");
  public final PBUInt32Field bless_id = PBField.initUInt32(0);
  public final PBStringField jmp_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     fudai.fd_comm.BlessPackInfo
 * JD-Core Version:    0.7.0.1
 */