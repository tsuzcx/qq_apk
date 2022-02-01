package tencent.im.oidb.nowlive;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nowlive$AnchorInfo
  extends MessageMicro<AnchorInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "fans", "status" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, AnchorInfo.class);
  public final PBUInt64Field fans = PBField.initUInt64(0L);
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.nowlive.nowlive.AnchorInfo
 * JD-Core Version:    0.7.0.1
 */