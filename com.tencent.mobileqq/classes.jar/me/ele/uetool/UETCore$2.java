package me.ele.uetool;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import me.ele.uetool.util.ChangePool;
import me.ele.uetool.util.Util;

class UETCore$2
  implements View.OnClickListener
{
  UETCore$2(UETCore paramUETCore) {}
  
  public void onClick(View paramView)
  {
    ChangePool.getInstance().getAllChange();
    Util.sendToMyFriend(ChangePool.getInstance().getChangePool());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.UETCore.2
 * JD-Core Version:    0.7.0.1
 */