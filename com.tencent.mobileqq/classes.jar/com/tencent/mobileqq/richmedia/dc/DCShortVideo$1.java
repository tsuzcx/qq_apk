package com.tencent.mobileqq.richmedia.dc;

import android.os.Environment;
import bbkg;
import bbkl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class DCShortVideo$1
  implements Runnable
{
  public DCShortVideo$1(bbkg parambbkg, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    bbkl localbbkl = new bbkl();
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return;
      localbbkl.jdField_a_of_type_Long = ((File)localObject1).length();
      if (localbbkl.jdField_a_of_type_Long > 0L)
      {
        this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localbbkl);
        localbbkl.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        localbbkl.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
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
          localbbkl.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
          if (bbkg.a(this.this$0, localbbkl, this.jdField_a_of_type_JavaLangString))
          {
            bbkg.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbbkl, this.jdField_a_of_type_Boolean, this.jdField_c_of_type_Int, this.d);
            localbbkl.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
            localbbkl.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
            if (localbbkl.k == 0) {
              localbbkl.k = 1;
            }
            localbbkl.m = VideoEnvironment.SV_FONFIG_STATUS;
            localbbkl.l = (VideoEnvironment.configParam.mIndex + 2000);
            if (QLog.isDevelopLevel()) {
              QLog.d("DCShortVideo", 4, "[reportSend]url=" + localbbkl.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localbbkl.f + ",shortVideoSourceType = " + localbbkl.j + ",uinType = " + localbbkl.jdField_b_of_type_Int + ",groupMemCount = " + localbbkl.jdField_c_of_type_Int + ",isForward = " + localbbkl.jdField_a_of_type_Boolean + ",isExsit = " + localbbkl.jdField_b_of_type_Boolean + ",age = " + localbbkl.d + ",gender = " + localbbkl.e + ",userType = " + localbbkl.l + ",reprotHour = " + localbbkl.g + ",fileInterval = " + localbbkl.k + ",netType = " + localbbkl.h + ",forwardSourceGroupMemCount = " + localbbkl.i + ",forwardSourceUinType = " + localbbkl.jdField_a_of_type_Int + ",duration = " + localbbkl.jdField_b_of_type_Long + ",fileSize = " + localbbkl.jdField_a_of_type_Long + ",md5 = " + localbbkl.jdField_b_of_type_JavaLangString + ", status=" + localbbkl.m);
            }
            localObject1 = new DataReport.ReportTask("ShortVideo.Send", localbbkl.a("ShortVideo.Send"));
            DataReport.a().a((DataReport.ReportTask)localObject1);
            return;
          }
        }
        catch (Exception localException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.1
 * JD-Core Version:    0.7.0.1
 */