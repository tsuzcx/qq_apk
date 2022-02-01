package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseRecentFileTabView$4
  implements View.OnClickListener
{
  QfileBaseRecentFileTabView$4(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseRecentFileTabView.a, 2, "qfilebaserecenttabview del error, tag is null");
      }
    }
    else
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.getTag();
      if (localFileManagerEntity != null)
      {
        if (this.a.l != null) {
          this.a.l.a(null);
        }
        this.a.i = localFileManagerEntity.nSessionId;
        if (((IQQFileEngine)QfileBaseRecentFileTabView.f(this.a).getRuntimeService(IQQFileEngine.class)).delete(this.a.i)) {
          this.a.b(localFileManagerEntity);
        }
      }
      this.a.l.a(Integer.valueOf(-1));
      paramView.setVisibility(4);
      this.a.f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.4
 * JD-Core Version:    0.7.0.1
 */