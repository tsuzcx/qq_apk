package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class QfileBaseRecentFileTabView$RecentFileItemLongClickListener$1
  implements View.OnClickListener
{
  QfileBaseRecentFileTabView$RecentFileItemLongClickListener$1(QfileBaseRecentFileTabView.RecentFileItemLongClickListener paramRecentFileItemLongClickListener, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a.getTag();
    if ((localObject instanceof ImageHolder)) {
      localObject = (FileManagerEntity)((ImageHolder)localObject).i;
    } else {
      localObject = (FileManagerEntity)((RecentItemHolder)localObject).i;
    }
    if (paramView.getId() == 2131431689)
    {
      ActionSheet localActionSheet = ActionSheet.create(this.b.a.C);
      localActionSheet.setMainTitle(HardCodeUtil.a(2131896082));
      localActionSheet.addButton(HardCodeUtil.a(2131896078), 3);
      localActionSheet.addCancelButton(HardCodeUtil.a(2131889250));
      localActionSheet.setOnButtonClickListener(new QfileBaseRecentFileTabView.RecentFileItemLongClickListener.1.1(this, (FileManagerEntity)localObject, localActionSheet));
      localActionSheet.show();
    }
    else if (paramView.getId() == 2131433639)
    {
      this.b.a.e((FileManagerEntity)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.RecentFileItemLongClickListener.1
 * JD-Core Version:    0.7.0.1
 */