package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class VideoFilePresenter$8
  implements Runnable
{
  public void run()
  {
    int i = this.a;
    if ((i != -6101) && (i != -7003) && (i != 201))
    {
      this.this$0.a.a(this.this$0.c.y(), this.this$0.d.getString(2131889820));
      return;
    }
    i = this.a;
    Object localObject;
    if ((i != -6101) && (i != -7003))
    {
      if (i == 201)
      {
        if (!this.this$0.c.K()) {
          localObject = this.this$0.d.getString(2131889821);
        } else {
          this.this$0.a.a(this.this$0.c.y(), this.this$0.d.getString(2131889820));
        }
      }
      else
      {
        String str = this.this$0.d.getString(2131889820);
        localObject = str;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("can not handle video error. rc=[");
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append("]  msg=[");
          ((StringBuilder)localObject).append(this.b);
          ((StringBuilder)localObject).append("]");
          QLog.i("FileBrowserPresenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
          localObject = str;
        }
      }
    }
    else
    {
      localObject = this.this$0.d.getString(2131889788);
      this.this$0.c.a(this.a, this.b);
    }
    if (BaseActivity.sTopActivity != null)
    {
      localObject = DialogUtil.a(BaseActivity.sTopActivity, 230, "", (CharSequence)localObject, null, HardCodeUtil.a(2131913467), new VideoFilePresenter.8.1(this), null);
      if (!((QQCustomDialog)localObject).isShowing()) {
        ((QQCustomDialog)localObject).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.8
 * JD-Core Version:    0.7.0.1
 */