package tencent.im.oidb.cmd0xe72;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe72$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_join_group_auth = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_edu_support_no_verify = PBField.initUInt32(0);
  public final PBUInt64Field uint64_grp_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_grp_code", "uint64_uin", "bytes_join_group_auth", "uint32_edu_support_no_verify" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe72.oidb_0xe72.ReqBody
 * JD-Core Version:    0.7.0.1
 */