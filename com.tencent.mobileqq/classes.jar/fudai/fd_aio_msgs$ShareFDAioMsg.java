package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class fd_aio_msgs$ShareFDAioMsg
  extends MessageMicro<ShareFDAioMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField aio_tails = PBField.initString("");
  public final PBUInt32Field busi_id = PBField.initUInt32(0);
  public final PBUInt32Field expire_time = PBField.initUInt32(0);
  public final PBStringField fd_txt = PBField.initString("");
  public final PBStringField fdid = PBField.initString("");
  public final PBStringField high_light_msg = PBField.initString("");
  public final PBUInt64Field host_uin = PBField.initUInt64(0L);
  public fd_comm.FDShareMeta share_meta = new fd_comm.FDShareMeta();
  public final PBUInt32Field theme_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 90, 96, 104, 170, 178 }, new String[] { "host_uin", "fdid", "share_meta", "expire_time", "fd_txt", "busi_id", "theme_id", "aio_tails", "high_light_msg" }, new Object[] { Long.valueOf(0L), "", null, localInteger, "", localInteger, localInteger, "", "" }, ShareFDAioMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     fudai.fd_aio_msgs.ShareFDAioMsg
 * JD-Core Version:    0.7.0.1
 */