package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseCloudFileTabView$11
  implements View.OnClickListener
{
  QfileBaseCloudFileTabView$11(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    int i;
    if ((localObject instanceof QfileCloudFileBaseExpandableListAdapter.CloudItemHolder))
    {
      localObject = (QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)paramView.getTag();
      i = ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject).c;
      localObject = (WeiYunFileInfo)((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject).a;
    }
    for (;;)
    {
      QfileBaseCloudFileTabView localQfileBaseCloudFileTabView;
      if (localObject != null)
      {
        if ((paramView.getId() == 2131366919) && (QfileBaseCloudFileTabView.c(this.a))) {
          ReportController.b(QfileBaseCloudFileTabView.d(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
        }
        localQfileBaseCloudFileTabView = this.a;
        if (paramView.getId() != 2131366919) {
          break label155;
        }
      }
      label155:
      for (boolean bool = true;; bool = false)
      {
        localQfileBaseCloudFileTabView.a((WeiYunFileInfo)localObject, i, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!(localObject instanceof ImageHolder)) {
          break label160;
        }
        localObject = (WeiYunFileInfo)((ImageHolder)paramView.getTag()).a;
        i = -1;
        break;
      }
      label160:
      i = 0;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.11
 * JD-Core Version:    0.7.0.1
 */