package tencent.im.oidb.cmd0x7bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x7bb$PageHistoryRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "historys", "over", "next_start" }, new Object[] { null, Boolean.valueOf(false), Integer.valueOf(0) }, PageHistoryRsp.class);
  public final PBRepeatMessageField historys = PBField.initRepeatMessage(oidb_0x7bb.HistoryInfo.class);
  public final PBUInt32Field next_start = PBField.initUInt32(0);
  public final PBBoolField over = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7bb.oidb_0x7bb.PageHistoryRsp
 * JD-Core Version:    0.7.0.1
 */