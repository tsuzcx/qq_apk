package cooperation.qqreader.host.miniaio;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;

public class MiniMsgUserParamWrapper
{
  private IMiniMsgActionCallbackWrapper a;
  public MiniMsgUserParam mParam = new MiniMsgUserParam();
  
  public MiniMsgUserParamWrapper(View paramView, TextView paramTextView)
  {
    this.mParam.businessName = 7;
    this.mParam.positionX = -1;
    this.mParam.positionY = -1;
    this.mParam.filterMsgType = 1;
    this.mParam.accessType = 1;
    this.mParam.entryType = 1;
    this.mParam.entryView = paramView;
    this.mParam.unreadView = paramTextView;
    this.mParam.actionCallback = new MiniMsgUserParamWrapper.1(this);
  }
  
  public void setActionCallback(IMiniMsgActionCallbackWrapper paramIMiniMsgActionCallbackWrapper)
  {
    this.a = paramIMiniMsgActionCallbackWrapper;
  }
  
  public void setBackConversationIntent(Intent paramIntent)
  {
    this.mParam.backConversationIntent = paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.host.miniaio.MiniMsgUserParamWrapper
 * JD-Core Version:    0.7.0.1
 */