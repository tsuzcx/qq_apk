package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class group_mgr$CardInfo
  extends MessageMicro<CardInfo>
{
  public static final int COMMON_FIELD_NUMBER = 1;
  public static final int HWINFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "common", "hwinfo" }, new Object[] { null, null }, CardInfo.class);
  public group_mgr.CardCommInfo common = new group_mgr.CardCommInfo();
  public group_mgr.CardHomeworkInfo hwinfo = new group_mgr.CardHomeworkInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.hw.group_mgr.CardInfo
 * JD-Core Version:    0.7.0.1
 */