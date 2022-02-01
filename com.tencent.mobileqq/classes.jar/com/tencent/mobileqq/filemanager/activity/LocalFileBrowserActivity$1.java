package com.tencent.mobileqq.filemanager.activity;

import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class LocalFileBrowserActivity$1
  implements AbsListView.OnScrollListener
{
  LocalFileBrowserActivity$1(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    int i = j;
    if (paramInt1 > 0) {
      if (paramInt1 + paramInt2 >= paramInt3 - 1) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i != 0) {
      URLDrawable.resume();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder();
      paramAbsListView.append(LocalFileBrowserActivity.F);
      paramAbsListView.append(",onScrollStateChanged() is called,scrollState is:");
      paramAbsListView.append(paramInt);
      paramAbsListView.append(",time is:");
      paramAbsListView.append(System.currentTimeMillis());
      QLog.d("SelectPhotoTrace", 2, paramAbsListView.toString());
    }
    if (paramInt == 0)
    {
      URLDrawable.resume();
      return;
    }
    URLDrawable.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.1
 * JD-Core Version:    0.7.0.1
 */