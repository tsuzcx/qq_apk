package tencent.im.oidb.cmd0xe9c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xe9c$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public oidb_0xe9c.RelatedFaceRsp relatedFaceRspBody = new oidb_0xe9c.RelatedFaceRsp();
  public final PBStringField str_ret_msg = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 82 }, new String[] { "bytes_session_id", "int32_ret_code", "str_ret_msg", "relatedFaceRspBody" }, new Object[] { localByteStringMicro, Integer.valueOf(0), "", null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe9c.oidb_0xe9c.RspBody
 * JD-Core Version:    0.7.0.1
 */