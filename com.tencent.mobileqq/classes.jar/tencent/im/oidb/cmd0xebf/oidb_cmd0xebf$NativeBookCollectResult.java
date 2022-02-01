package tencent.im.oidb.cmd0xebf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xebf$NativeBookCollectResult
  extends MessageMicro<NativeBookCollectResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "book_id", "is_collected" }, new Object[] { "", Integer.valueOf(0) }, NativeBookCollectResult.class);
  public final PBStringField book_id = PBField.initString("");
  public final PBUInt32Field is_collected = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xebf.oidb_cmd0xebf.NativeBookCollectResult
 * JD-Core Version:    0.7.0.1
 */