package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView.HorizonListViewTouchListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;

class AIOEmoticonUIHelper$1
  implements EmotionKeywordHorizonListView.HorizonListViewTouchListener
{
  AIOEmoticonUIHelper$1(AIOEmoticonUIHelper paramAIOEmoticonUIHelper) {}
  
  public void touchEventActionChanged(int paramInt)
  {
    BaseChatPie localBaseChatPie = this.a.a();
    if (localBaseChatPie == null) {
      return;
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      localBaseChatPie.a().removeMessages(67);
      ReportController.b(localBaseChatPie.a(), "CliOper", "", "", "ep_mall", "slide", 0, 0, "", "", "", localBaseChatPie.a.getText().toString());
      return;
    }
    localBaseChatPie.a().sendEmptyMessageDelayed(67, 6000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.AIOEmoticonUIHelper.1
 * JD-Core Version:    0.7.0.1
 */