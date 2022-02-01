package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseCloudFileTabView$10$1
  implements View.OnClickListener
{
  QfileBaseCloudFileTabView$10$1(QfileBaseCloudFileTabView.10 param10, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a.getTag();
    if ((localObject instanceof ImageHolder))
    {
      localObject = (WeiYunFileInfo)((ImageHolder)this.a.getTag()).i;
    }
    else
    {
      if (!(localObject instanceof QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)) {
        break label133;
      }
      localObject = (WeiYunFileInfo)((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)this.a.getTag()).k;
    }
    if ((((IWeiyunApi)QRoute.api(IWeiyunApi.class)).isDeletingCloudFile(((WeiYunFileInfo)localObject).a)) && (QLog.isColorLevel())) {
      QLog.d(QfileBaseCloudFileTabView.c, 2, "there is a bug ");
    }
    ((IQQFileEngine)QfileBaseCloudFileTabView.f(this.b.a).getRuntimeService(IQQFileEngine.class, "")).deleteWeiYunFile((WeiYunFileInfo)localObject);
    this.b.a.cg_();
    break label148;
    label133:
    if (QLog.isColorLevel()) {
      QLog.e(QfileBaseCloudFileTabView.c, 2, "unknow Object");
    }
    label148:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.10.1
 * JD-Core Version:    0.7.0.1
 */