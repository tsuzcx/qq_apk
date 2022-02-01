package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_mgr$HwQueryCardReq
  extends MessageMicro<HwQueryCardReq>
{
  public static final int GID_FIELD_NUMBER = 1;
  public static final int TARGET_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field gid = PBField.initUInt64(0L);
  public final PBUInt64Field target_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "gid", "target_uin" }, new Object[] { localLong, localLong }, HwQueryCardReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.hw.group_mgr.HwQueryCardReq
 * JD-Core Version:    0.7.0.1
 */