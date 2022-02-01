package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class LocalFileBrowserActivity$2
  implements ActionSheet.OnButtonClickListener
{
  public void onClick(View paramView, int paramInt)
  {
    if ((paramInt == 0) && (this.b.P != -1))
    {
      paramView = (FileInfo)this.b.O.get(this.b.P);
      if ((FileUtils.fileExistsAndNotEmpty(paramView.d())) && (!((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteFile(paramView.d())))
      {
        FMToastUtil.a(2131889262);
      }
      else
      {
        QQFileManagerUtil.u(paramView.d());
        this.b.O.remove(this.b.P);
        LocalFileBrowserActivity.a(this.b);
      }
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.2
 * JD-Core Version:    0.7.0.1
 */