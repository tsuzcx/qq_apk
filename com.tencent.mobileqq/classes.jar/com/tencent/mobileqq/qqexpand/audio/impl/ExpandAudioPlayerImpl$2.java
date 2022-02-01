package com.tencent.mobileqq.qqexpand.audio.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqexpand.audio.IMethodCallback;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

class ExpandAudioPlayerImpl$2
  implements Runnable
{
  ExpandAudioPlayerImpl$2(ExpandAudioPlayerImpl paramExpandAudioPlayerImpl, String paramString, IMethodCallback paramIMethodCallback) {}
  
  public void run()
  {
    boolean bool = true;
    QLog.i("ExpandAudioPlayerImpl", 1, String.format("audioPreDownLoad: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    if (ExpandAudioPlayerImpl.access$200(this.this$0, this.jdField_a_of_type_JavaLangString) != null)
    {
      QLog.i("ExpandAudioPlayerImpl", 2, String.format("audioPreDownLoad: %s has downloaded", new Object[] { this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIMethodCallback.setResult(true);
      return;
    }
    Object localObject = new File(VFSAssistantUtils.getSDKPrivatePath(TransFileUtil.getTransferFilePath(BaseApplicationImpl.sApplication.getRuntime().getCurrentAccountUin(), MD5.toMD5(this.jdField_a_of_type_JavaLangString), 23, null)));
    int i = HttpDownloadUtil.downloadData(BaseApplicationImpl.sApplication.getRuntime(), this.jdField_a_of_type_JavaLangString, (File)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandAudioIMethodCallback;
    if (i != 0) {
      bool = false;
    }
    ((IMethodCallback)localObject).setResult(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.audio.impl.ExpandAudioPlayerImpl.2
 * JD-Core Version:    0.7.0.1
 */