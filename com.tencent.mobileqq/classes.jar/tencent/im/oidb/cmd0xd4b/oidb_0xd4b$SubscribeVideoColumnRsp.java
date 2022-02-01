package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd4b$SubscribeVideoColumnRsp
  extends MessageMicro<SubscribeVideoColumnRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 88 }, new String[] { "uint32_guide_type" }, new Object[] { Integer.valueOf(0) }, SubscribeVideoColumnRsp.class);
  public final PBUInt32Field uint32_guide_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeVideoColumnRsp
 * JD-Core Version:    0.7.0.1
 */