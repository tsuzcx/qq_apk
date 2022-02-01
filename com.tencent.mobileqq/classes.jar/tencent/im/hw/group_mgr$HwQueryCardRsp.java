package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class group_mgr$HwQueryCardRsp
  extends MessageMicro<HwQueryCardRsp>
{
  public static final int CARD_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "card_info" }, new Object[] { null }, HwQueryCardRsp.class);
  public group_mgr.CardInfo card_info = new group_mgr.CardInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.hw.group_mgr.HwQueryCardRsp
 * JD-Core Version:    0.7.0.1
 */