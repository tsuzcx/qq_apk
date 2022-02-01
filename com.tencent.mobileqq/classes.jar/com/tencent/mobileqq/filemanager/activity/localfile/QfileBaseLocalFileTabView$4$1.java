package com.tencent.mobileqq.filemanager.activity.localfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class QfileBaseLocalFileTabView$4$1
  implements View.OnClickListener
{
  QfileBaseLocalFileTabView$4$1(QfileBaseLocalFileTabView.4 param4, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a.getTag();
    if ((localObject instanceof ImageHolder))
    {
      localObject = (FileInfo)((ImageHolder)this.a.getTag()).i;
    }
    else
    {
      if (!(localObject instanceof QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)) {
        break label172;
      }
      localObject = (FileInfo)((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)this.a.getTag()).j;
    }
    if (paramView.getId() == 2131431689)
    {
      ActionSheet localActionSheet = ActionSheet.create(this.b.a.C);
      localActionSheet.setMainTitle(HardCodeUtil.a(2131896085));
      localActionSheet.addButton(HardCodeUtil.a(2131896078), 3);
      localActionSheet.addCancelButton(HardCodeUtil.a(2131889250));
      localActionSheet.setOnButtonClickListener(new QfileBaseLocalFileTabView.4.1.1(this, (FileInfo)localObject, localActionSheet));
      localActionSheet.show();
    }
    else if (paramView.getId() == 2131433639)
    {
      localObject = QQFileManagerUtil.a((FileInfo)localObject);
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).forwardFile(this.b.a.C, (FileManagerEntity)localObject);
      break label187;
      label172:
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseLocalFileTabView.o, 2, "unknow Object");
      }
    }
    label187:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.4.1
 * JD-Core Version:    0.7.0.1
 */