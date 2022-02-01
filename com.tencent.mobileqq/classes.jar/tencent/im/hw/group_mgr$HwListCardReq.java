package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_mgr$HwListCardReq
  extends MessageMicro<HwListCardReq>
{
  public static final int GID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "gid" }, new Object[] { Long.valueOf(0L) }, HwListCardReq.class);
  public final PBUInt64Field gid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.hw.group_mgr.HwListCardReq
 * JD-Core Version:    0.7.0.1
 */