package com.tencent.mobileqq.qqexpand.fragment;

import android.os.Message;
import com.tencent.mobileqq.qqexpand.widget.PhotoWallListView.PhotoPath;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ExtendFriendNewEditFragment$2
  extends TransProcessorHandler
{
  ExtendFriendNewEditFragment$2(ExtendFriendNewEditFragment paramExtendFriendNewEditFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    int i = paramMessage.what;
    if (i != 1003)
    {
      if (i != 1005) {
        return;
      }
      if (localFileMsg.fileType == 67)
      {
        QLog.e("ExtendFriendNewEditFragment", 1, "mFileUploadHandler upload photo fail");
        this.a.a(1, "图片上传失败", true);
        return;
      }
      if (localFileMsg.fileType == 68)
      {
        QLog.e("ExtendFriendNewEditFragment", 1, "mFileUploadHandler upload avatar fail");
        this.a.a(1, "头像上传失败", true);
      }
    }
    else
    {
      if (localFileMsg.fileType == 67)
      {
        paramMessage = ((NearbyPeoplePhotoUploadProcessor)localFileMsg.processor).mUrl;
        if ((ExtendFriendNewEditFragment.d(this.a) != null) && (ExtendFriendNewEditFragment.e(this.a) >= 0) && (ExtendFriendNewEditFragment.d(this.a).size() > ExtendFriendNewEditFragment.e(this.a)))
        {
          QLog.d("ExtendFriendNewEditFragment", 1, "mFileUploadHandler upload photo success");
          ((PhotoWallListView.PhotoPath)ExtendFriendNewEditFragment.d(this.a).get(ExtendFriendNewEditFragment.e(this.a))).a = paramMessage;
          ExtendFriendNewEditFragment.f(this.a);
          return;
        }
        QLog.e("ExtendFriendNewEditFragment", 1, "mFileUploadHandler upload photo cancel");
        return;
      }
      if (localFileMsg.fileType == 68)
      {
        QLog.d("ExtendFriendNewEditFragment", 1, "mFileUploadHandler upload avatar success");
        paramMessage = ((NearbyPeoplePhotoUploadProcessor)localFileMsg.processor).mUrl;
        ExtendFriendNewEditFragment.g(this.a).a = paramMessage;
        this.a.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.2
 * JD-Core Version:    0.7.0.1
 */