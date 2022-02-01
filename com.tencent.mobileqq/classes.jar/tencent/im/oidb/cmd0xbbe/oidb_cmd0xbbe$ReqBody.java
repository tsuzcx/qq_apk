package tencent.im.oidb.cmd0xbbe;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbbe$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_info_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xbbe.GetRecommendAccountReq msg_get_recommend_account_req = new oidb_cmd0xbbe.GetRecommendAccountReq();
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_get_recommend_account_req", "uint64_article_id", "bytes_info_cookie" }, new Object[] { null, Long.valueOf(0L), localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe.ReqBody
 * JD-Core Version:    0.7.0.1
 */