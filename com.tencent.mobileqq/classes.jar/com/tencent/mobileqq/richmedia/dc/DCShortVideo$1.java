package com.tencent.mobileqq.richmedia.dc;

import android.os.Environment;
import bbjw;
import bbkb;
import bcyw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class DCShortVideo$1
  implements Runnable
{
  public DCShortVideo$1(bbjw parambbjw, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    bbkb localbbkb = new bbkb();
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return;
      localbbkb.jdField_a_of_type_Long = ((File)localObject1).length();
      if (localbbkb.jdField_a_of_type_Long > 0L)
      {
        this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localbbkb);
        localbbkb.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        localbbkb.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
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
          localbbkb.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
          if (bbjw.a(this.this$0, localbbkb, this.jdField_a_of_type_JavaLangString))
          {
            bbjw.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbbkb, this.jdField_a_of_type_Boolean, this.jdField_c_of_type_Int, this.d);
            localbbkb.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
            localbbkb.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
            if (localbbkb.k == 0) {
              localbbkb.k = 1;
            }
            localbbkb.m = VideoEnvironment.jdField_a_of_type_Int;
            localbbkb.l = (VideoEnvironment.jdField_a_of_type_Bcyw.jdField_a_of_type_Int + 2000);
            if (QLog.isDevelopLevel()) {
              QLog.d("DCShortVideo", 4, "[reportSend]url=" + localbbkb.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localbbkb.f + ",shortVideoSourceType = " + localbbkb.j + ",uinType = " + localbbkb.jdField_b_of_type_Int + ",groupMemCount = " + localbbkb.jdField_c_of_type_Int + ",isForward = " + localbbkb.jdField_a_of_type_Boolean + ",isExsit = " + localbbkb.jdField_b_of_type_Boolean + ",age = " + localbbkb.d + ",gender = " + localbbkb.e + ",userType = " + localbbkb.l + ",reprotHour = " + localbbkb.g + ",fileInterval = " + localbbkb.k + ",netType = " + localbbkb.h + ",forwardSourceGroupMemCount = " + localbbkb.i + ",forwardSourceUinType = " + localbbkb.jdField_a_of_type_Int + ",duration = " + localbbkb.jdField_b_of_type_Long + ",fileSize = " + localbbkb.jdField_a_of_type_Long + ",md5 = " + localbbkb.jdField_b_of_type_JavaLangString + ", status=" + localbbkb.m);
            }
            localObject1 = new DataReport.ReportTask("ShortVideo.Send", localbbkb.a("ShortVideo.Send"));
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