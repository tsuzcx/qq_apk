package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class VideoFilePresenter$4
  implements ShareActionSheet.OnItemClickListener
{
  VideoFilePresenter$4(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    VideoFilePresenter.g(this.a).dismiss();
    if (paramActionSheetItem.listener != null)
    {
      paramActionSheetItem.listener.onClick(null);
      return;
    }
    if (this.a.c != null) {
      this.a.c.a(paramActionSheetItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.4
 * JD-Core Version:    0.7.0.1
 */