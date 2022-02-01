package com.tencent.mobileqq.richmedia.dc;

import android.os.Environment;
import bard;
import bari;
import bcge;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class DCShortVideo$1
  implements Runnable
{
  public DCShortVideo$1(bard parambard, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    bari localbari = new bari();
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return;
      localbari.jdField_a_of_type_Long = ((File)localObject1).length();
      if (localbari.jdField_a_of_type_Long > 0L)
      {
        this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localbari);
        localbari.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        localbari.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
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
          localbari.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
          if (bard.a(this.this$0, localbari, this.jdField_a_of_type_JavaLangString))
          {
            bard.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbari, this.jdField_a_of_type_Boolean, this.jdField_c_of_type_Int, this.d);
            localbari.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
            localbari.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
            if (localbari.k == 0) {
              localbari.k = 1;
            }
            localbari.m = VideoEnvironment.jdField_a_of_type_Int;
            localbari.l = (VideoEnvironment.jdField_a_of_type_Bcge.jdField_a_of_type_Int + 2000);
            if (QLog.isDevelopLevel()) {
              QLog.d("DCShortVideo", 4, "[reportSend]url=" + localbari.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localbari.f + ",shortVideoSourceType = " + localbari.j + ",uinType = " + localbari.jdField_b_of_type_Int + ",groupMemCount = " + localbari.jdField_c_of_type_Int + ",isForward = " + localbari.jdField_a_of_type_Boolean + ",isExsit = " + localbari.jdField_b_of_type_Boolean + ",age = " + localbari.d + ",gender = " + localbari.e + ",userType = " + localbari.l + ",reprotHour = " + localbari.g + ",fileInterval = " + localbari.k + ",netType = " + localbari.h + ",forwardSourceGroupMemCount = " + localbari.i + ",forwardSourceUinType = " + localbari.jdField_a_of_type_Int + ",duration = " + localbari.jdField_b_of_type_Long + ",fileSize = " + localbari.jdField_a_of_type_Long + ",md5 = " + localbari.jdField_b_of_type_JavaLangString + ", status=" + localbari.m);
            }
            localObject1 = new DataReport.ReportTask("ShortVideo.Send", localbari.a("ShortVideo.Send"));
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