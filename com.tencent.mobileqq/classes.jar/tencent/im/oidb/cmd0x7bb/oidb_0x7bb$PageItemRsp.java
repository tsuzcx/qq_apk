package tencent.im.oidb.cmd0x7bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x7bb$PageItemRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "items", "over", "next_start" }, new Object[] { null, Boolean.valueOf(false), Integer.valueOf(0) }, PageItemRsp.class);
  public final PBRepeatMessageField items = PBField.initRepeatMessage(oidb_0x7bb.ItemInfo.class);
  public final PBUInt32Field next_start = PBField.initUInt32(0);
  public final PBBoolField over = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7bb.oidb_0x7bb.PageItemRsp
 * JD-Core Version:    0.7.0.1
 */