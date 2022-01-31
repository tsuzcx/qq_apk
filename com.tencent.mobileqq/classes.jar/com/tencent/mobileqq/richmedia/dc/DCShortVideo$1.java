package com.tencent.mobileqq.richmedia.dc;

import agqd;
import ajya;
import android.os.Environment;
import apvd;
import avwu;
import avwz;
import axfp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

public class DCShortVideo$1
  implements Runnable
{
  public DCShortVideo$1(avwu paramavwu, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    avwz localavwz = new avwz();
    Object localObject3 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject3).exists()) {}
    for (;;)
    {
      return;
      localavwz.jdField_a_of_type_Long = ((File)localObject3).length();
      if (localavwz.jdField_a_of_type_Long <= 0L) {
        continue;
      }
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localavwz);
      localavwz.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localavwz.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      try
      {
        Object localObject2 = this.jdField_a_of_type_JavaLangString;
        String str = Environment.getExternalStorageDirectory().toString();
        Object localObject1 = localObject2;
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
        localavwz.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
        localObject2 = apvd.c(this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = ((String)localObject2).toLowerCase(Locale.US);
        }
        localObject2 = null;
        label927:
        try
        {
          localObject3 = ((File)localObject3).getParentFile().getName().toLowerCase(Locale.US);
          localObject2 = localObject3;
        }
        catch (Exception localException2)
        {
          label217:
          break label217;
        }
        if ((localObject1 == null) || (localObject2 == null)) {
          continue;
        }
        if (((String)localObject1).contains("/tencent/")) {
          if (((String)localObject1).contains("/mobileqq/shortvideo/"))
          {
            localavwz.j = 1002;
            localavwz.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.jdField_c_of_type_Int != 0) {
                break label927;
              }
              localavwz.jdField_a_of_type_Int = 0;
            }
          }
        }
        for (;;)
        {
          localavwz.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
          localavwz.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
          if (localavwz.k == 0) {
            localavwz.k = 1;
          }
          localavwz.m = VideoEnvironment.jdField_a_of_type_Int;
          localavwz.l = (VideoEnvironment.jdField_a_of_type_Axfp.jdField_a_of_type_Int + 2000);
          if (QLog.isDevelopLevel()) {
            QLog.d("DCShortVideo", 4, "[reportSend]url=" + localavwz.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localavwz.f + ",shortVideoSourceType = " + localavwz.j + ",uinType = " + localavwz.jdField_b_of_type_Int + ",groupMemCount = " + localavwz.jdField_c_of_type_Int + ",isForward = " + localavwz.jdField_a_of_type_Boolean + ",isExsit = " + localavwz.jdField_b_of_type_Boolean + ",age = " + localavwz.d + ",gender = " + localavwz.e + ",userType = " + localavwz.l + ",reprotHour = " + localavwz.g + ",fileInterval = " + localavwz.k + ",netType = " + localavwz.h + ",forwardSourceGroupMemCount = " + localavwz.i + ",forwardSourceUinType = " + localavwz.jdField_a_of_type_Int + ",duration = " + localavwz.jdField_b_of_type_Long + ",fileSize = " + localavwz.jdField_a_of_type_Long + ",md5 = " + localavwz.jdField_b_of_type_JavaLangString + ", status=" + localavwz.m);
          }
          localObject1 = new DataReport.ReportTask("ShortVideo.Send", localavwz.a("ShortVideo.Send"));
          DataReport.a().a((DataReport.ReportTask)localObject1);
          return;
          if (((String)localObject1).contains("/qq_collection/"))
          {
            localavwz.j = 1001;
            break;
          }
          if (((String)localObject1).contains("/qqfile_recv/"))
          {
            localavwz.j = 1003;
            break;
          }
          if ((((String)localObject1).contains("/weixin/")) || (((String)localObject1).contains("/wechat/")) || (((String)localObject1).contains("/micromsg/")))
          {
            localavwz.j = 1004;
            break;
          }
          if (agqd.a((String)localObject1))
          {
            localavwz.j = 1005;
            break;
          }
          localavwz.j = 1006;
          break;
          if (((String)localObject1).equalsIgnoreCase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator))
          {
            localavwz.j = 1002;
            break;
          }
          if ((((String)localObject2).contains("camera")) || (((String)localObject2).equals("dcim")) || (((String)localObject2).equals("100MEDIA")) || (((String)localObject2).equals("100ANDRO")) || (((String)localObject2).contains(ajya.a(2131702882))) || (((String)localObject2).contains(ajya.a(2131702881))) || (((String)localObject2).contains(ajya.a(2131702883))))
          {
            localavwz.j = 1007;
            break;
          }
          if (agqd.a((String)localObject1))
          {
            localavwz.j = 1005;
            break;
          }
          localavwz.j = 1006;
          break;
          if (this.jdField_c_of_type_Int == 3000)
          {
            localavwz.jdField_a_of_type_Int = 3000;
          }
          else
          {
            if (this.jdField_c_of_type_Int == 1)
            {
              switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.d))
              {
              default: 
                localavwz.jdField_a_of_type_Int = 1;
              }
              for (;;)
              {
                localavwz.i = 0;
                localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                if (localObject1 == null) {
                  break;
                }
                localObject1 = ((TroopManager)localObject1).c(this.d);
                if (localObject1 == null) {
                  break;
                }
                localavwz.i = ((TroopInfo)localObject1).wMemberNum;
                break;
                localavwz.jdField_a_of_type_Int = 1;
                continue;
                localavwz.jdField_a_of_type_Int = 3;
                continue;
                localavwz.jdField_a_of_type_Int = 4;
                continue;
                localavwz.jdField_a_of_type_Int = 2;
              }
            }
            localavwz.jdField_a_of_type_Int = 9999;
          }
        }
        return;
      }
      catch (Exception localException1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.1
 * JD-Core Version:    0.7.0.1
 */