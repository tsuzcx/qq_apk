package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

class QfileBaseLocalFileTabView$4$1$1
  implements ActionSheet.OnButtonClickListener
{
  QfileBaseLocalFileTabView$4$1$1(QfileBaseLocalFileTabView.4.1 param1, FileInfo paramFileInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if ((((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isFileExists(this.a.d())) && (!((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteFile(this.a.d())))
    {
      FMToastUtil.a(2131889262);
      return;
    }
    QQFileManagerUtil.u(this.a.d());
    this.c.b.a.c(this.a);
    try
    {
      paramView = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramView.setData(Uri.fromFile(new File(this.a.d())));
      this.c.b.a.C.sendBroadcast(paramView);
      label133:
      this.c.b.a.e();
      if (this.b.isShowing()) {
        this.b.dismiss();
      }
      return;
    }
    catch (Exception paramView)
    {
      break label133;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.4.1.1
 * JD-Core Version:    0.7.0.1
 */