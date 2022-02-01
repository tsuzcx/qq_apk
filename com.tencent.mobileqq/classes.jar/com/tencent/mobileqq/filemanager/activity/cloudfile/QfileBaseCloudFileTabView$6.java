package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QfileBaseCloudFileTabView$6
  implements ActionSheet.OnButtonClickListener
{
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (((IQQFileEngine)QfileBaseCloudFileTabView.b(this.b).getRuntimeService(IQQFileEngine.class, "")).delete(this.b.g))
      {
        this.b.d.setVisible();
        this.b.setListFooter();
      }
      this.b.cg_();
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.6
 * JD-Core Version:    0.7.0.1
 */