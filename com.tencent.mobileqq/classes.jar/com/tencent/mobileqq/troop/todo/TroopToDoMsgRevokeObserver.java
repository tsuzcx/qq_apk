package com.tencent.mobileqq.troop.todo;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopMsgObserver;
import com.tencent.mobileqq.activity.aio.helper.ITroopToDoMsgRevoke;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class TroopToDoMsgRevokeObserver
  extends BaseTroopMsgObserver
{
  private ITroopToDoMsgRevoke d = null;
  
  public TroopToDoMsgRevokeObserver(BaseChatPie paramBaseChatPie, ITroopToDoMsgRevoke paramITroopToDoMsgRevoke)
  {
    super(paramBaseChatPie);
    this.d = paramITroopToDoMsgRevoke;
  }
  
  public void onLocalMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    this.d.a(paramBoolean1, paramList);
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    this.d.a(paramBoolean1, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.todo.TroopToDoMsgRevokeObserver
 * JD-Core Version:    0.7.0.1
 */