package com.tencent.mobileqq.richmedia.dc;

import android.os.Environment;
import badr;
import badw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class DCShortVideo$1
  implements Runnable
{
  public DCShortVideo$1(badr parambadr, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    badw localbadw = new badw();
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return;
      localbadw.jdField_a_of_type_Long = ((File)localObject1).length();
      if (localbadw.jdField_a_of_type_Long > 0L)
      {
        this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localbadw);
        localbadw.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        localbadw.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
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
          localbadw.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
          if (badr.a(this.this$0, localbadw, this.jdField_a_of_type_JavaLangString))
          {
            badr.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbadw, this.jdField_a_of_type_Boolean, this.jdField_c_of_type_Int, this.d);
            localbadw.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
            localbadw.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
            if (localbadw.k == 0) {
              localbadw.k = 1;
            }
            localbadw.m = VideoEnvironment.SV_FONFIG_STATUS;
            localbadw.l = (VideoEnvironment.configParam.mIndex + 2000);
            if (QLog.isDevelopLevel()) {
              QLog.d("DCShortVideo", 4, "[reportSend]url=" + localbadw.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localbadw.f + ",shortVideoSourceType = " + localbadw.j + ",uinType = " + localbadw.jdField_b_of_type_Int + ",groupMemCount = " + localbadw.jdField_c_of_type_Int + ",isForward = " + localbadw.jdField_a_of_type_Boolean + ",isExsit = " + localbadw.jdField_b_of_type_Boolean + ",age = " + localbadw.d + ",gender = " + localbadw.e + ",userType = " + localbadw.l + ",reprotHour = " + localbadw.g + ",fileInterval = " + localbadw.k + ",netType = " + localbadw.h + ",forwardSourceGroupMemCount = " + localbadw.i + ",forwardSourceUinType = " + localbadw.jdField_a_of_type_Int + ",duration = " + localbadw.jdField_b_of_type_Long + ",fileSize = " + localbadw.jdField_a_of_type_Long + ",md5 = " + localbadw.jdField_b_of_type_JavaLangString + ", status=" + localbadw.m);
            }
            localObject1 = new DataReport.ReportTask("ShortVideo.Send", localbadw.a("ShortVideo.Send"));
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