package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class apollo_game_status$STGameStateMsgList
  extends MessageMicro<STGameStateMsgList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_list" }, new Object[] { null }, STGameStateMsgList.class);
  public final PBRepeatMessageField<apollo_game_status.STCMGameMessage> rpt_msg_list = PBField.initRepeatMessage(apollo_game_status.STCMGameMessage.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.apollo_game_status.STGameStateMsgList
 * JD-Core Version:    0.7.0.1
 */