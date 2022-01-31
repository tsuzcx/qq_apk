package tencent.im.oidb.searcher;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_c2c_searcher$MsgKey
  extends MessageMicro<MsgKey>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "time", "magic", "seq" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, MsgKey.class);
  public final PBUInt32Field magic = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt64Field time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.searcher.oidb_c2c_searcher.MsgKey
 * JD-Core Version:    0.7.0.1
 */