package com.tencent.mobileqq.filemanager.activity.localfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileLocalFileBaseExpandableListAdapter$1
  implements View.OnClickListener
{
  QfileLocalFileBaseExpandableListAdapter$1(QfileLocalFileBaseExpandableListAdapter paramQfileLocalFileBaseExpandableListAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = FileManagerUtil.a((FileInfo)((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag()).a);
    localObject = new CommonFileBrowserParams(QfileLocalFileBaseExpandableListAdapter.a(this.a).app, QfileLocalFileBaseExpandableListAdapter.a(this.a), (FileManagerEntity)localObject, 10000);
    localObject = new FileBrowserCreator(QfileLocalFileBaseExpandableListAdapter.a(this.a), (IFileBrowserParams)localObject);
    ((FileBrowserCreator)localObject).a(8);
    ((FileBrowserCreator)localObject).a(AnimationUtils.a(paramView));
    ((FileBrowserCreator)localObject).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter.1
 * JD-Core Version:    0.7.0.1
 */