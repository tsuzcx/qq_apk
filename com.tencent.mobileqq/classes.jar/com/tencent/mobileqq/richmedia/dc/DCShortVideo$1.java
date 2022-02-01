package com.tencent.mobileqq.richmedia.dc;

import android.os.Environment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class DCShortVideo$1
  implements Runnable
{
  public void run()
  {
    DCShortVideo.DCShortVideoSendData localDCShortVideoSendData = new DCShortVideo.DCShortVideoSendData();
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject1).exists()) {
      return;
    }
    localDCShortVideoSendData.jdField_a_of_type_Long = ((File)localObject1).length();
    if (localDCShortVideoSendData.jdField_a_of_type_Long <= 0L) {
      return;
    }
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localDCShortVideoSendData);
    localDCShortVideoSendData.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    localDCShortVideoSendData.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    try
    {
      Object localObject2 = this.jdField_a_of_type_JavaLangString;
      String str = Environment.getExternalStorageDirectory().toString();
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaLangString.contains(str)) {
          localObject1 = this.jdField_a_of_type_JavaLangString.replace(str, "");
        }
      }
      int i = ((String)localObject1).lastIndexOf("/");
      localObject2 = localObject1;
      if (i != -1) {
        localObject2 = ((String)localObject1).substring(0, i);
      }
      localDCShortVideoSendData.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
      if (!DCShortVideo.a(this.this$0, localDCShortVideoSendData, this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      DCShortVideo.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDCShortVideoSendData, this.jdField_a_of_type_Boolean, this.jdField_c_of_type_Int, this.d);
      localDCShortVideoSendData.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localDCShortVideoSendData.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
      if (localDCShortVideoSendData.k == 0) {
        localDCShortVideoSendData.k = 1;
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[reportSend]url=");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(",shortVideoType=");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.f);
        ((StringBuilder)localObject1).append(",shortVideoSourceType = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.j);
        ((StringBuilder)localObject1).append(",uinType = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.jdField_b_of_type_Int);
        ((StringBuilder)localObject1).append(",groupMemCount = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.jdField_c_of_type_Int);
        ((StringBuilder)localObject1).append(",isForward = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.jdField_a_of_type_Boolean);
        ((StringBuilder)localObject1).append(",isExsit = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.jdField_b_of_type_Boolean);
        ((StringBuilder)localObject1).append(",age = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.d);
        ((StringBuilder)localObject1).append(",gender = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.e);
        ((StringBuilder)localObject1).append(",userType = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.l);
        ((StringBuilder)localObject1).append(",reprotHour = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.g);
        ((StringBuilder)localObject1).append(",fileInterval = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.k);
        ((StringBuilder)localObject1).append(",netType = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.h);
        ((StringBuilder)localObject1).append(",forwardSourceGroupMemCount = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.i);
        ((StringBuilder)localObject1).append(",forwardSourceUinType = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(",duration = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.jdField_b_of_type_Long);
        ((StringBuilder)localObject1).append(",fileSize = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.jdField_a_of_type_Long);
        ((StringBuilder)localObject1).append(",md5 = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.jdField_b_of_type_JavaLangString);
        QLog.d("DCShortVideo", 4, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new DataReport.ReportTask("ShortVideo.Send", localDCShortVideoSendData.a("ShortVideo.Send"));
      DataReport.a().a((DataReport.ReportTask)localObject1);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.1
 * JD-Core Version:    0.7.0.1
 */