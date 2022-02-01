package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class synclogic$FirstViewRsp
  extends MessageMicro<FirstViewRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field guild_count = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt64Field self_tinyid = PBField.initUInt64(0L);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt32Field udc_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48 }, new String[] { "result", "err_msg", "seq", "udc_flag", "guild_count", "self_tinyid" }, new Object[] { localInteger, localByteStringMicro, localInteger, localInteger, localInteger, Long.valueOf(0L) }, FirstViewRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.synclogic.synclogic.FirstViewRsp
 * JD-Core Version:    0.7.0.1
 */