package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QfileBaseRecentFileTabView$RecentFileItemLongClickListener$1$1
  implements ActionSheet.OnButtonClickListener
{
  QfileBaseRecentFileTabView$RecentFileItemLongClickListener$1$1(QfileBaseRecentFileTabView.RecentFileItemLongClickListener.1 param1, FileManagerEntity paramFileManagerEntity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    ((IQQFileEngine)QfileBaseRecentFileTabView.h(this.c.b.a).getRuntimeService(IQQFileEngine.class)).delete(this.a.nSessionId);
    this.c.b.a.b(this.a);
    if ((!TextUtils.isEmpty(this.a.Uuid)) && (3000 != this.a.peerType)) {
      ((IQQFileEngine)QfileBaseRecentFileTabView.i(this.c.b.a).getRuntimeService(IQQFileEngine.class)).deleteOfflineFile(String.valueOf(this.a.peerUin), this.a.fileName, this.a.Uuid, this.a.fileIdCrc, this.a.bSend);
    }
    this.a.bDelInFM = true;
    ((IQQFileDataCenter)QfileBaseRecentFileTabView.j(this.c.b.a).getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(this.a);
    this.c.b.a.f();
    if (this.b.isShowing()) {
      this.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.RecentFileItemLongClickListener.1.1
 * JD-Core Version:    0.7.0.1
 */