package tencent.im.oidb.searcher;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_c2c_searcher$Iterator
  extends MessageMicro<Iterator>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "complete", "uin", "key" }, new Object[] { Boolean.valueOf(false), Long.valueOf(0L), null }, Iterator.class);
  public final PBBoolField complete = PBField.initBool(false);
  public oidb_c2c_searcher.MsgKey key = new oidb_c2c_searcher.MsgKey();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.searcher.oidb_c2c_searcher.Iterator
 * JD-Core Version:    0.7.0.1
 */