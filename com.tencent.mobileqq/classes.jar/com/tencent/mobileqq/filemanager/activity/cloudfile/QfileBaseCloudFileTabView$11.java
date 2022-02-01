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
    boolean bool2 = localObject instanceof QfileCloudFileBaseExpandableListAdapter.CloudItemHolder;
    boolean bool1 = false;
    int i;
    if (bool2)
    {
      localObject = (QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)paramView.getTag();
      i = ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject).e;
      localObject = (WeiYunFileInfo)((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject).k;
    }
    else if ((localObject instanceof ImageHolder))
    {
      localObject = (ImageHolder)paramView.getTag();
      i = -1;
      localObject = (WeiYunFileInfo)((ImageHolder)localObject).i;
    }
    else
    {
      localObject = null;
      i = 0;
    }
    if (localObject != null)
    {
      if ((paramView.getId() == 2131433103) && (QfileBaseCloudFileTabView.g(this.a))) {
        ReportController.b(QfileBaseCloudFileTabView.h(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      QfileBaseCloudFileTabView localQfileBaseCloudFileTabView = this.a;
      if (paramView.getId() == 2131433103) {
        bool1 = true;
      }
      localQfileBaseCloudFileTabView.a((WeiYunFileInfo)localObject, i, bool1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.11
 * JD-Core Version:    0.7.0.1
 */