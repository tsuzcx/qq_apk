package com.tencent.mobileqq.richmedia.dc;

import android.os.Environment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class DCShortVideo$1
  implements Runnable
{
  DCShortVideo$1(DCShortVideo paramDCShortVideo, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    DCShortVideo.DCShortVideoSendData localDCShortVideoSendData = new DCShortVideo.DCShortVideoSendData();
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return;
      localDCShortVideoSendData.jdField_a_of_type_Long = ((File)localObject1).length();
      if (localDCShortVideoSendData.jdField_a_of_type_Long > 0L)
      {
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
          if (DCShortVideo.a(this.this$0, localDCShortVideoSendData, this.jdField_a_of_type_JavaLangString))
          {
            DCShortVideo.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDCShortVideoSendData, this.jdField_a_of_type_Boolean, this.jdField_c_of_type_Int, this.d);
            localDCShortVideoSendData.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
            localDCShortVideoSendData.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
            if (localDCShortVideoSendData.k == 0) {
              localDCShortVideoSendData.k = 1;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("DCShortVideo", 4, "[reportSend]url=" + localDCShortVideoSendData.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localDCShortVideoSendData.f + ",shortVideoSourceType = " + localDCShortVideoSendData.j + ",uinType = " + localDCShortVideoSendData.jdField_b_of_type_Int + ",groupMemCount = " + localDCShortVideoSendData.jdField_c_of_type_Int + ",isForward = " + localDCShortVideoSendData.jdField_a_of_type_Boolean + ",isExsit = " + localDCShortVideoSendData.jdField_b_of_type_Boolean + ",age = " + localDCShortVideoSendData.d + ",gender = " + localDCShortVideoSendData.e + ",userType = " + localDCShortVideoSendData.l + ",reprotHour = " + localDCShortVideoSendData.g + ",fileInterval = " + localDCShortVideoSendData.k + ",netType = " + localDCShortVideoSendData.h + ",forwardSourceGroupMemCount = " + localDCShortVideoSendData.i + ",forwardSourceUinType = " + localDCShortVideoSendData.jdField_a_of_type_Int + ",duration = " + localDCShortVideoSendData.jdField_b_of_type_Long + ",fileSize = " + localDCShortVideoSendData.jdField_a_of_type_Long + ",md5 = " + localDCShortVideoSendData.jdField_b_of_type_JavaLangString);
            }
            localObject1 = new DataReport.ReportTask("ShortVideo.Send", localDCShortVideoSendData.a("ShortVideo.Send"));
            DataReport.a().a((DataReport.ReportTask)localObject1);
            return;
          }
        }
        catch (Exception localException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.1
 * JD-Core Version:    0.7.0.1
 */