package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class fd_aio_msgs$GrabFDGrayMsg
  extends MessageMicro<GrabFDGrayMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "host_uin", "grab_uin", "fdid", "msg_type", "high_light_des" }, new Object[] { null, null, "", Integer.valueOf(1), null }, GrabFDGrayMsg.class);
  public final PBStringField fdid = PBField.initString("");
  public fd_comm.UinProf grab_uin = new fd_comm.UinProf();
  public fd_comm.TxtAndUrl high_light_des = new fd_comm.TxtAndUrl();
  public fd_comm.UinProf host_uin = new fd_comm.UinProf();
  public final PBEnumField msg_type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     fudai.fd_aio_msgs.GrabFDGrayMsg
 * JD-Core Version:    0.7.0.1
 */