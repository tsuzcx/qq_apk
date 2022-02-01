package com.tencent.mobileqq.filemanager.activity;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.SlideDetectListView;

class LocalFileBrowserActivity$5
  implements View.OnLongClickListener
{
  LocalFileBrowserActivity$5(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.a.p())
    {
      this.a.M.a(null);
      this.a.K.a();
      return false;
    }
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131431689, paramView.getContext().getString(2131889566));
    this.a.U = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).showAsDropDown(paramView, localQQCustomMenu, new LocalFileBrowserActivity.5.1(this, paramView), new LocalFileBrowserActivity.5.2(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.5
 * JD-Core Version:    0.7.0.1
 */