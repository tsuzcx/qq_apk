package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class fd_comm$TxtAndUrl
  extends MessageMicro<TxtAndUrl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "txt_des", "jmp_url" }, new Object[] { "", "" }, TxtAndUrl.class);
  public final PBStringField jmp_url = PBField.initString("");
  public final PBStringField txt_des = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     fudai.fd_comm.TxtAndUrl
 * JD-Core Version:    0.7.0.1
 */