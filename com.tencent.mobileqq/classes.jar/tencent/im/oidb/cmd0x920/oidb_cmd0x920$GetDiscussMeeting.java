package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x920$GetDiscussMeeting
  extends MessageMicro<GetDiscussMeeting>
{
  public static final int UINT64_DISCUSS_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_discuss_uin" }, new Object[] { Long.valueOf(0L) }, GetDiscussMeeting.class);
  public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x920.oidb_cmd0x920.GetDiscussMeeting
 * JD-Core Version:    0.7.0.1
 */