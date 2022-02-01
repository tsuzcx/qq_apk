package com.tencent.mobileqq.filemanager.bubble;

import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class OfflineFileBubbleModel$2
  implements ActionSheet.OnButtonClickListener
{
  OfflineFileBubbleModel$2(OfflineFileBubbleModel paramOfflineFileBubbleModel, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.b.b.getFileManagerRSCenter().a(OfflineFileBubbleModel.a(this.b).uniseq, this.b.d.b, this.b.d.a, -1L);
    paramView = FileManagerUtil.a(this.b.b, OfflineFileBubbleModel.a(this.b));
    if (paramView.status == 16)
    {
      FMToastUtil.a(2131889788);
      this.a.cancel();
      return;
    }
    OfflineFileBubbleModel.a(this.b).status = 1002;
    FileManagerUtil.a(this.b.c, paramView, this.b.b, true);
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.2
 * JD-Core Version:    0.7.0.1
 */