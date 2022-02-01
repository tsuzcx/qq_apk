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

class ExpandOldEditFragment$3
  extends TransProcessorHandler
{
  ExpandOldEditFragment$3(ExpandOldEditFragment paramExpandOldEditFragment) {}
  
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
      ExpandOldEditFragment.a(this.a).dismiss();
      QQToast.makeText(ExpandOldEditFragment.b(this.a), HardCodeUtil.a(2131902302), 0).show();
      ExtendFriendReport.a().d(false, 0);
      return;
    }
    if (localFileMsg.fileType == 23)
    {
      ExpandOldEditFragment.a(this.a, ((NearbyPeoplePhotoUploadProcessor)localFileMsg.processor).mUrl);
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("mFileUploadHandler.handleMessage(), upload success. url = ");
        paramMessage.append(ExpandOldEditFragment.e(this.a));
        QLog.i("ExtendFriendProfileEdit", 2, paramMessage.toString());
      }
      if (this.a.h != null)
      {
        this.a.h.b(ExpandOldEditFragment.e(this.a));
        paramMessage = this.a;
        ExpandOldEditFragment.a(paramMessage, paramMessage.h.b());
      }
    }
    ExtendFriendReport.a().d(true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandOldEditFragment.3
 * JD-Core Version:    0.7.0.1
 */