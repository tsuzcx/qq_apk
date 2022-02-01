package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf4d$DanmuLikeInfo
  extends MessageMicro<DanmuLikeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "like_total_nums", "is_like" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, DanmuLikeInfo.class);
  public final PBUInt32Field is_like = PBField.initUInt32(0);
  public final PBUInt64Field like_total_nums = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf4d.oidb_0xf4d.DanmuLikeInfo
 * JD-Core Version:    0.7.0.1
 */