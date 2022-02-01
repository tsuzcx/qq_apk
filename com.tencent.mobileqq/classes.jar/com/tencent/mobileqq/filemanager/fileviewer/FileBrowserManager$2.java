package com.tencent.mobileqq.filemanager.fileviewer;

import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class FileBrowserManager$2
  implements ShareActionSheet.OnItemClickListener
{
  FileBrowserManager$2(FileBrowserManager paramFileBrowserManager) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    FileBrowserManager.a(this.a).dismiss();
    if (paramActionSheetItem.listener != null)
    {
      paramActionSheetItem.listener.onClick(null);
      return;
    }
    if (FileBrowserManager.b(this.a) != null) {
      FileBrowserManager.b(this.a).a(paramActionSheetItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager.2
 * JD-Core Version:    0.7.0.1
 */