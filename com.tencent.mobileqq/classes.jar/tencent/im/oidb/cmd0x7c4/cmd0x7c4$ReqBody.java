package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7c4$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_get_recommend_sn_frd_list_req", "msg_get_sn_frd_list_req", "uint32_client_ver" }, new Object[] { null, null, Integer.valueOf(0) }, ReqBody.class);
  public cmd0x7c4.GetRecommendSNFrdListReq msg_get_recommend_sn_frd_list_req = new cmd0x7c4.GetRecommendSNFrdListReq();
  public cmd0x7c4.GetSNFrdListReq msg_get_sn_frd_list_req = new cmd0x7c4.GetSNFrdListReq();
  public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c4.cmd0x7c4.ReqBody
 * JD-Core Version:    0.7.0.1
 */