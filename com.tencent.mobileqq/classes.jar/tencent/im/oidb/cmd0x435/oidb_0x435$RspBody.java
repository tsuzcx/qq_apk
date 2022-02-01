package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x435$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_topic_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public oidb_0x435.AddTopicRspBody msg_add_rsp_body = new oidb_0x435.AddTopicRspBody();
  public oidb_0x435.DeletePKItemRspBody msg_del_rsp_body = new oidb_0x435.DeletePKItemRspBody();
  public oidb_0x435.GetAllPKItemsRspBody msg_get_all_pk_items_rsp_body = new oidb_0x435.GetAllPKItemsRspBody();
  public oidb_0x435.GetPKItemRspBody msg_get_rsp_body = new oidb_0x435.GetPKItemRspBody();
  public oidb_0x435.AddVoteRspBody msg_vote_rsp_body = new oidb_0x435.AddVoteRspBody();
  public final PBUInt32Field uint32_interval_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 90, 98, 106, 114, 122 }, new String[] { "int32_ret_code", "bytes_error_msg", "uint32_subcmd", "bytes_topic_id", "uint32_interval_time", "msg_add_rsp_body", "msg_vote_rsp_body", "msg_del_rsp_body", "msg_get_rsp_body", "msg_get_all_pk_items_rsp_body" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localInteger, null, null, null, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x435.oidb_0x435.RspBody
 * JD-Core Version:    0.7.0.1
 */