package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x435$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_topic_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x435.AddTopicReqBody msg_add_req_body = new oidb_0x435.AddTopicReqBody();
  public oidb_0x435.DeletePKItemReqBody msg_del_req_body = new oidb_0x435.DeletePKItemReqBody();
  public oidb_0x435.GetAllPKItemsReqBody msg_get_all_pk_items_req_body = new oidb_0x435.GetAllPKItemsReqBody();
  public oidb_0x435.GetPKItemReqBody msg_get_req_body = new oidb_0x435.GetPKItemReqBody();
  public oidb_0x435.AddVoteReqBody msg_vote_req_body = new oidb_0x435.AddVoteReqBody();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 90, 98, 106, 114, 122 }, new String[] { "uint32_subcmd", "bytes_topic_id", "msg_add_req_body", "msg_vote_req_body", "msg_del_req_body", "msg_get_req_body", "msg_get_all_pk_items_req_body" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null, null, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x435.oidb_0x435.ReqBody
 * JD-Core Version:    0.7.0.1
 */