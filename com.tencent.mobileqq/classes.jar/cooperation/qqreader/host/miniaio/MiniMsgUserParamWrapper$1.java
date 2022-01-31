package cooperation.qqreader.host.miniaio;

import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;

class MiniMsgUserParamWrapper$1
  implements MiniMsgUser.IMiniMsgActionCallback
{
  MiniMsgUserParamWrapper$1(MiniMsgUserParamWrapper paramMiniMsgUserParamWrapper) {}
  
  public void onFromMiniAIOToAIO() {}
  
  public void onGoToConversation()
  {
    if (MiniMsgUserParamWrapper.a(this.a) != null) {
      MiniMsgUserParamWrapper.a(this.a).onGoToConversation();
    }
  }
  
  public void onOpenMiniAIOCallback()
  {
    if (MiniMsgUserParamWrapper.a(this.a) != null) {
      MiniMsgUserParamWrapper.a(this.a).onOpenMiniAIOCallback();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.miniaio.MiniMsgUserParamWrapper.1
 * JD-Core Version:    0.7.0.1
 */