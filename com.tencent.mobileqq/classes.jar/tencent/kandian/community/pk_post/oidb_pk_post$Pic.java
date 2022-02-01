package tencent.kandian.community.pk_post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_pk_post$Pic
  extends MessageMicro<Pic>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "string_url", "uint32_width", "uint32_high" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, Pic.class);
  public final PBStringField string_url = PBField.initString("");
  public final PBUInt32Field uint32_high = PBField.initUInt32(0);
  public final PBUInt32Field uint32_width = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.kandian.community.pk_post.oidb_pk_post.Pic
 * JD-Core Version:    0.7.0.1
 */