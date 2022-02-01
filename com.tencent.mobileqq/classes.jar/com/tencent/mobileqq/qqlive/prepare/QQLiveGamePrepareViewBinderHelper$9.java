package com.tencent.mobileqq.qqlive.prepare;

import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class QQLiveGamePrepareViewBinderHelper$9
  implements Observer<List<GameItem>>
{
  QQLiveGamePrepareViewBinderHelper$9(GameListAdapter paramGameListAdapter) {}
  
  public void a(List<GameItem> paramList)
  {
    if (paramList.size() > 0)
    {
      this.a.a(paramList);
      this.a.notifyDataSetChanged();
      return;
    }
    QLog.d("bindGameListDialogView", 1, "the game list is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLiveGamePrepareViewBinderHelper.9
 * JD-Core Version:    0.7.0.1
 */