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
    FavFileInfo localFavFileInfo;
    if ((paramView.getTag() instanceof QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)) {
      localFavFileInfo = (FavFileInfo)((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)paramView.getTag()).k;
    } else {
      localFavFileInfo = null;
    }
    if (localFavFileInfo != null)
    {
      QfileFavFileTabView localQfileFavFileTabView = this.a;
      boolean bool;
      if (paramView.getId() == 2131433103) {
        bool = true;
      } else {
        bool = false;
      }
      localQfileFavFileTabView.a(localFavFileInfo, bool);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView.2
 * JD-Core Version:    0.7.0.1
 */