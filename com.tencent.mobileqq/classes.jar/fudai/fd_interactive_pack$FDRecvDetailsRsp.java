package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class fd_interactive_pack$FDRecvDetailsRsp
  extends MessageMicro<FDRecvDetailsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public fd_comm.BusiElement busi_elem = new fd_comm.BusiElement();
  public final PBBoolField ctnue_share = PBField.initBool(false);
  public final PBStringField fd_desc = PBField.initString("");
  public final PBStringField fd_recv_msg = PBField.initString("");
  public final PBUInt64Field host_uin = PBField.initUInt64(0L);
  public final PBBoolField is_over = PBField.initBool(false);
  public final PBRepeatMessageField<fd_interactive_pack.SingleRecvDetail> re_recv_list = PBField.initRepeatMessage(fd_interactive_pack.SingleRecvDetail.class);
  public fd_comm.GrabPack recv_info = new fd_comm.GrabPack();
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56, 170 }, new String[] { "host_uin", "busi_elem", "fd_desc", "is_over", "recv_info", "fd_recv_msg", "ctnue_share", "re_recv_list" }, new Object[] { Long.valueOf(0L), null, "", localBoolean, null, "", localBoolean, null }, FDRecvDetailsRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     fudai.fd_interactive_pack.FDRecvDetailsRsp
 * JD-Core Version:    0.7.0.1
 */