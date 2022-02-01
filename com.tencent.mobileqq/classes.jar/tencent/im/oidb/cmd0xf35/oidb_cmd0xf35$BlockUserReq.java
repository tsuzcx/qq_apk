package tencent.im.oidb.cmd0xf35;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xf35$BlockUserReq
  extends MessageMicro<BlockUserReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "first_comment_id", "sub_comment_id", "comment_type", "comment_source" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, BlockUserReq.class);
  public final PBUInt32Field comment_source = PBField.initUInt32(0);
  public final PBUInt32Field comment_type = PBField.initUInt32(0);
  public final PBStringField first_comment_id = PBField.initString("");
  public final PBStringField sub_comment_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf35.oidb_cmd0xf35.BlockUserReq
 * JD-Core Version:    0.7.0.1
 */