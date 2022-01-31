package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg$ContentHead
  extends MessageMicro<ContentHead>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "pkg_num", "pkg_index", "seq", "date_time", "msg_type", "div_seq", "msgdb_uin", "msgdb_seq", "word_msg_seq", "msg_rand" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ContentHead.class);
  public final PBUInt32Field date_time = PBField.initUInt32(0);
  public final PBUInt32Field div_seq = PBField.initUInt32(0);
  public final PBUInt32Field msg_rand = PBField.initUInt32(0);
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBUInt32Field msgdb_seq = PBField.initUInt32(0);
  public final PBUInt64Field msgdb_uin = PBField.initUInt64(0L);
  public final PBUInt32Field pkg_index = PBField.initUInt32(0);
  public final PBUInt32Field pkg_num = PBField.initUInt32(1);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt32Field word_msg_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg.ContentHead
 * JD-Core Version:    0.7.0.1
 */