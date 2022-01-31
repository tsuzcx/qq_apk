package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class group_mgr$HwListCardRsp
  extends MessageMicro
{
  public static final int CARD_INFO_FIELD_NUMBER = 1;
  public static final int LEVEL_INFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "card_info", "level_info" }, new Object[] { null, null }, HwListCardRsp.class);
  public final PBRepeatMessageField card_info = PBField.initRepeatMessage(group_mgr.CardInfo.class);
  public group_mgr.LevelInfo level_info = new group_mgr.LevelInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.hw.group_mgr.HwListCardRsp
 * JD-Core Version:    0.7.0.1
 */