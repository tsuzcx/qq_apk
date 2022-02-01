package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$FusionInfo
  extends MessageMicro<FusionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "str_comment_id", "str_comment_key", "uint32_comment_src" }, new Object[] { "", "", Integer.valueOf(0) }, FusionInfo.class);
  public final PBStringField str_comment_id = PBField.initString("");
  public final PBStringField str_comment_key = PBField.initString("");
  public final PBUInt32Field uint32_comment_src = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.FusionInfo
 * JD-Core Version:    0.7.0.1
 */