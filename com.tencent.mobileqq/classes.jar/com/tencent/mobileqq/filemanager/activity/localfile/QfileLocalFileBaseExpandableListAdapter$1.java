package com.tencent.mobileqq.filemanager.activity.localfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileLocalFileBaseExpandableListAdapter$1
  implements View.OnClickListener
{
  QfileLocalFileBaseExpandableListAdapter$1(QfileLocalFileBaseExpandableListAdapter paramQfileLocalFileBaseExpandableListAdapter) {}
  
  public void onClick(View paramView)
  {
    QfileLocalFileBaseExpandableListAdapter.LocalItemHolder localLocalItemHolder = (QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag();
    FileManagerEntity localFileManagerEntity = QQFileManagerUtil.a((FileInfo)localLocalItemHolder.a);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openLocalFileViewBrowser(QfileLocalFileBaseExpandableListAdapter.a(this.a), null, (FileInfo)localLocalItemHolder.a, paramView, localFileManagerEntity);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter.1
 * JD-Core Version:    0.7.0.1
 */