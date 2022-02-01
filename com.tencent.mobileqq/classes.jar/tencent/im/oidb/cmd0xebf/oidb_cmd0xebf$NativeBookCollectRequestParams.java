package tencent.im.oidb.cmd0xebf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xebf$NativeBookCollectRequestParams
  extends MessageMicro<NativeBookCollectRequestParams>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uin", "book_id", "op_type" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0) }, NativeBookCollectRequestParams.class);
  public final PBStringField book_id = PBField.initString("");
  public final PBUInt32Field op_type = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xebf.oidb_cmd0xebf.NativeBookCollectRequestParams
 * JD-Core Version:    0.7.0.1
 */