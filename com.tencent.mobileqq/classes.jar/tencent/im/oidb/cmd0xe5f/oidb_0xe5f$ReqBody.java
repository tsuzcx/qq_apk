package tencent.im.oidb.cmd0xe5f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe5f$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_praiseuin", "uint32_achievement_id", "uint32_actiontype" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_achievement_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_actiontype = PBField.initUInt32(0);
  public final PBUInt64Field uint64_praiseuin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5f.oidb_0xe5f.ReqBody
 * JD-Core Version:    0.7.0.1
 */