package com.tencent.mobileqq.filebrowser;

import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class FileBrowserActivity$7
  implements ShareActionSheet.OnItemClickListener
{
  FileBrowserActivity$7(FileBrowserActivity paramFileBrowserActivity) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    paramShareActionSheet.dismiss();
    if (paramActionSheetItem.listener != null)
    {
      paramActionSheetItem.listener.onClick(null);
      return;
    }
    FileBrowserActivity.a(this.a).a(paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.FileBrowserActivity.7
 * JD-Core Version:    0.7.0.1
 */