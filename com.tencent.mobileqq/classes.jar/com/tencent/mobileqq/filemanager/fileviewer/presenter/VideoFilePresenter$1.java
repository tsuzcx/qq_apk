package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.FileUtil;

class VideoFilePresenter$1
  implements View.OnLongClickListener
{
  VideoFilePresenter$1(VideoFilePresenter paramVideoFilePresenter) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.a.c.n();
    VideoFilePresenter.a(this.a, paramView);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.q());
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(FileUtil.a(this.a.c.x()));
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    this.a.a(paramView, (String)localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.1
 * JD-Core Version:    0.7.0.1
 */