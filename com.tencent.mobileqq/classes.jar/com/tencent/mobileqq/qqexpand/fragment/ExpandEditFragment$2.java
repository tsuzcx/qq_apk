package com.tencent.mobileqq.qqexpand.fragment;

import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ExpandEditFragment$2
  extends TransProcessorHandler
{
  ExpandEditFragment$2(ExpandEditFragment paramExpandEditFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    int i = paramMessage.what;
    if (i != 1003)
    {
      if (i != 1005) {
        return;
      }
      if ((localFileMsg.fileType == 23) && (QLog.isColorLevel())) {
        QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload fail.");
      }
      ExpandEditFragment.c(this.a).dismiss();
      QQToast.makeText(ExpandEditFragment.d(this.a), HardCodeUtil.a(2131902302), 0).show();
      ExtendFriendReport.a().d(false, 0);
      return;
    }
    if (localFileMsg.fileType == 23)
    {
      ExpandEditFragment.a(this.a, ((NearbyPeoplePhotoUploadProcessor)localFileMsg.processor).mUrl);
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("mFileUploadHandler.handleMessage(), upload success. url = ");
        paramMessage.append(ExpandEditFragment.b(this.a));
        QLog.i("ExtendFriendProfileEdit", 2, paramMessage.toString());
      }
      if (this.a.f != null)
      {
        this.a.f.b(ExpandEditFragment.b(this.a));
        paramMessage = this.a;
        ExpandEditFragment.a(paramMessage, paramMessage.f.b());
      }
    }
    ExtendFriendReport.a().d(true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandEditFragment.2
 * JD-Core Version:    0.7.0.1
 */