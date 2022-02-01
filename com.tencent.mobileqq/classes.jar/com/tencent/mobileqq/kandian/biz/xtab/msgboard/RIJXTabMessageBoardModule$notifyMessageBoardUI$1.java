package com.tencent.mobileqq.kandian.biz.xtab.msgboard;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJXTabMessageBoardModule$notifyMessageBoardUI$1
  implements Runnable
{
  RIJXTabMessageBoardModule$notifyMessageBoardUI$1(RIJXTabMessageBoardRedUtil.MessageBoardRedInfo paramMessageBoardRedInfo) {}
  
  public final void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardModule.notifyMessageBoardUI.1
 * JD-Core Version:    0.7.0.1
 */