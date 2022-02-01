package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class LocalFileBrowserActivity$5$1
  implements View.OnClickListener
{
  LocalFileBrowserActivity$5$1(LocalFileBrowserActivity.5 param5, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (LocalFileAdapter.LocalFileItemHolder)this.a.getTag();
    this.b.a.P = ((LocalFileAdapter.LocalFileItemHolder)localObject).k;
    localObject = (FileInfo)this.b.a.O.get(this.b.a.P);
    if ((FileUtils.fileExistsAndNotEmpty(((FileInfo)localObject).d())) && (!((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteFile(((FileInfo)localObject).d())))
    {
      FMToastUtil.a(2131889262);
    }
    else
    {
      QQFileManagerUtil.u(((FileInfo)localObject).d());
      this.b.a.O.remove(this.b.a.P);
      LocalFileBrowserActivity.a(this.b.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.5.1
 * JD-Core Version:    0.7.0.1
 */