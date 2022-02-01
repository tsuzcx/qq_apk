package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseRecentFileTabView$5
  implements View.OnClickListener
{
  QfileBaseRecentFileTabView$5(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    boolean bool = localObject1 instanceof RecentItemHolder;
    AsyncImageView localAsyncImageView = null;
    Object localObject2;
    int i;
    if (bool)
    {
      localObject2 = (RecentItemHolder)paramView.getTag();
      localAsyncImageView = ((RecentItemHolder)localObject2).f;
      localObject1 = (FileManagerEntity)((RecentItemHolder)localObject2).i;
      i = ((RecentItemHolder)localObject2).j;
      i = ((RecentItemHolder)localObject2).k;
    }
    else if ((localObject1 instanceof ImageHolder))
    {
      localObject2 = (ImageHolder)paramView.getTag();
      localAsyncImageView = ((ImageHolder)localObject2).a;
      localObject1 = (FileManagerEntity)((ImageHolder)localObject2).i;
      i = ((ImageHolder)localObject2).h;
      i = ((ImageHolder)localObject2).g;
    }
    else
    {
      localObject1 = null;
    }
    if ((paramView.getId() == 2131433103) && (QfileBaseRecentFileTabView.k(this.a))) {
      ReportController.b(QfileBaseRecentFileTabView.l(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
    }
    if (localObject1 != null)
    {
      localObject2 = this.a;
      if (paramView.getId() == 2131433103) {
        bool = true;
      } else {
        bool = false;
      }
      ((QfileBaseRecentFileTabView)localObject2).a((FileManagerEntity)localObject1, localAsyncImageView, bool);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.5
 * JD-Core Version:    0.7.0.1
 */