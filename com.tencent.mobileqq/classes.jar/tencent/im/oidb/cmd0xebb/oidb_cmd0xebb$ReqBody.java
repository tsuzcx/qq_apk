package tencent.im.oidb.cmd0xebb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xebb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sso_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xebb.ReqRecommendPara msg_req_recommend_para = new oidb_cmd0xebb.ReqRecommendPara();
  public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_os_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_source = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 90, 194, 1600 }, new String[] { "uint32_network_type", "uint32_os_type", "msg_req_recommend_para", "bytes_sso_client_version", "uint32_req_source" }, new Object[] { localInteger, localInteger, null, localByteStringMicro, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.ReqBody
 * JD-Core Version:    0.7.0.1
 */