package tencent.im.oidb.cmd0x7bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7bb$HistoryInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "op_type", "item", "ctime", "task" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), null }, HistoryInfo.class);
  public final PBUInt64Field ctime = PBField.initUInt64(0L);
  public oidb_0x7bb.ItemInfo item = new oidb_0x7bb.ItemInfo();
  public final PBUInt32Field op_type = PBField.initUInt32(0);
  public oidb_0x7bb.TaskInfo task = new oidb_0x7bb.TaskInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7bb.oidb_0x7bb.HistoryInfo
 * JD-Core Version:    0.7.0.1
 */