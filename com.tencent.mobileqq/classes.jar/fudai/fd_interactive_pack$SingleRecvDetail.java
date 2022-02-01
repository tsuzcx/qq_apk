package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class fd_interactive_pack$SingleRecvDetail
  extends MessageMicro<SingleRecvDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uin", "nick", "ctime", "re_info" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), null }, SingleRecvDetail.class);
  public final PBUInt32Field ctime = PBField.initUInt32(0);
  public final PBStringField nick = PBField.initString("");
  public fd_comm.GrabPack re_info = new fd_comm.GrabPack();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     fudai.fd_interactive_pack.SingleRecvDetail
 * JD-Core Version:    0.7.0.1
 */