package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendEditFragment$2
  extends TransProcessorHandler
{
  ExtendFriendEditFragment$2(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1003: 
      if (localFileMsg.fileType == 23)
      {
        ExtendFriendEditFragment.a(this.a, ((NearbyPeoplePhotoUploadProcessor)localFileMsg.processor).mUrl);
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload success. url = " + ExtendFriendEditFragment.a(this.a));
        }
        if (this.a.a != null)
        {
          this.a.a.a(ExtendFriendEditFragment.a(this.a));
          ExtendFriendEditFragment.a(this.a, this.a.a.a());
        }
      }
      ExtendFriendReport.a().d(true, 0);
      return;
    }
    if ((localFileMsg.fileType == 23) && (QLog.isColorLevel())) {
      QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload fail.");
    }
    ExtendFriendEditFragment.a(this.a).dismiss();
    QQToast.a(ExtendFriendEditFragment.a(this.a), HardCodeUtil.a(2131704298), 0).a();
    ExtendFriendReport.a().d(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment.2
 * JD-Core Version:    0.7.0.1
 */