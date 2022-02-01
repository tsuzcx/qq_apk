package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class ForwardBaseOption$8
  extends UiCallBack.DownAdapter
{
  ForwardBaseOption$8(ForwardBaseOption paramForwardBaseOption, ForwardBaseOption.IPicDownloadCallback paramIPicDownloadCallback, MessageForPic paramMessageForPic, String paramString) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    paramPicResult = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption$IPicDownloadCallback;
    if (paramPicResult != null) {
      paramPicResult.b();
    }
    AbsDownloader.getFilePath(URLDrawableHelper.getURL(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 1, null).toString().toString());
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "DownloadBigPic finish");
    }
    paramPicResult = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
    if (paramPicResult != null) {
      ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption, AIOGalleryUtils.a(paramPicResult), this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.8
 * JD-Core Version:    0.7.0.1
 */