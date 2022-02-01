package com.tencent.mobileqq.filemanager.activity.favfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileFavFileTabView$2
  implements View.OnClickListener
{
  QfileFavFileTabView$2(QfileFavFileTabView paramQfileFavFileTabView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)) {}
    for (FavFileInfo localFavFileInfo = (FavFileInfo)((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)paramView.getTag()).a;; localFavFileInfo = null)
    {
      QfileFavFileTabView localQfileFavFileTabView;
      if (localFavFileInfo != null)
      {
        localQfileFavFileTabView = this.a;
        if (paramView.getId() != 2131366919) {
          break label60;
        }
      }
      label60:
      for (boolean bool = true;; bool = false)
      {
        localQfileFavFileTabView.a(localFavFileInfo, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView.2
 * JD-Core Version:    0.7.0.1
 */