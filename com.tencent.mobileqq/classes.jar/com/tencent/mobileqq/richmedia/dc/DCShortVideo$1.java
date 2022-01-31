package com.tencent.mobileqq.richmedia.dc;

import agqf;
import ajyc;
import android.os.Environment;
import apvb;
import avws;
import avwx;
import axfn;
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
  public DCShortVideo$1(avws paramavws, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    avwx localavwx = new avwx();
    Object localObject3 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject3).exists()) {}
    for (;;)
    {
      return;
      localavwx.jdField_a_of_type_Long = ((File)localObject3).length();
      if (localavwx.jdField_a_of_type_Long <= 0L) {
        continue;
      }
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localavwx);
      localavwx.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localavwx.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
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
        localavwx.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
        localObject2 = apvb.c(this.jdField_a_of_type_JavaLangString);
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
            localavwx.j = 1002;
            localavwx.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.jdField_c_of_type_Int != 0) {
                break label927;
              }
              localavwx.jdField_a_of_type_Int = 0;
            }
          }
        }
        for (;;)
        {
          localavwx.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
          localavwx.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
          if (localavwx.k == 0) {
            localavwx.k = 1;
          }
          localavwx.m = VideoEnvironment.jdField_a_of_type_Int;
          localavwx.l = (VideoEnvironment.jdField_a_of_type_Axfn.jdField_a_of_type_Int + 2000);
          if (QLog.isDevelopLevel()) {
            QLog.d("DCShortVideo", 4, "[reportSend]url=" + localavwx.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localavwx.f + ",shortVideoSourceType = " + localavwx.j + ",uinType = " + localavwx.jdField_b_of_type_Int + ",groupMemCount = " + localavwx.jdField_c_of_type_Int + ",isForward = " + localavwx.jdField_a_of_type_Boolean + ",isExsit = " + localavwx.jdField_b_of_type_Boolean + ",age = " + localavwx.d + ",gender = " + localavwx.e + ",userType = " + localavwx.l + ",reprotHour = " + localavwx.g + ",fileInterval = " + localavwx.k + ",netType = " + localavwx.h + ",forwardSourceGroupMemCount = " + localavwx.i + ",forwardSourceUinType = " + localavwx.jdField_a_of_type_Int + ",duration = " + localavwx.jdField_b_of_type_Long + ",fileSize = " + localavwx.jdField_a_of_type_Long + ",md5 = " + localavwx.jdField_b_of_type_JavaLangString + ", status=" + localavwx.m);
          }
          localObject1 = new DataReport.ReportTask("ShortVideo.Send", localavwx.a("ShortVideo.Send"));
          DataReport.a().a((DataReport.ReportTask)localObject1);
          return;
          if (((String)localObject1).contains("/qq_collection/"))
          {
            localavwx.j = 1001;
            break;
          }
          if (((String)localObject1).contains("/qqfile_recv/"))
          {
            localavwx.j = 1003;
            break;
          }
          if ((((String)localObject1).contains("/weixin/")) || (((String)localObject1).contains("/wechat/")) || (((String)localObject1).contains("/micromsg/")))
          {
            localavwx.j = 1004;
            break;
          }
          if (agqf.a((String)localObject1))
          {
            localavwx.j = 1005;
            break;
          }
          localavwx.j = 1006;
          break;
          if (((String)localObject1).equalsIgnoreCase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator))
          {
            localavwx.j = 1002;
            break;
          }
          if ((((String)localObject2).contains("camera")) || (((String)localObject2).equals("dcim")) || (((String)localObject2).equals("100MEDIA")) || (((String)localObject2).equals("100ANDRO")) || (((String)localObject2).contains(ajyc.a(2131702871))) || (((String)localObject2).contains(ajyc.a(2131702870))) || (((String)localObject2).contains(ajyc.a(2131702872))))
          {
            localavwx.j = 1007;
            break;
          }
          if (agqf.a((String)localObject1))
          {
            localavwx.j = 1005;
            break;
          }
          localavwx.j = 1006;
          break;
          if (this.jdField_c_of_type_Int == 3000)
          {
            localavwx.jdField_a_of_type_Int = 3000;
          }
          else
          {
            if (this.jdField_c_of_type_Int == 1)
            {
              switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.d))
              {
              default: 
                localavwx.jdField_a_of_type_Int = 1;
              }
              for (;;)
              {
                localavwx.i = 0;
                localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                if (localObject1 == null) {
                  break;
                }
                localObject1 = ((TroopManager)localObject1).c(this.d);
                if (localObject1 == null) {
                  break;
                }
                localavwx.i = ((TroopInfo)localObject1).wMemberNum;
                break;
                localavwx.jdField_a_of_type_Int = 1;
                continue;
                localavwx.jdField_a_of_type_Int = 3;
                continue;
                localavwx.jdField_a_of_type_Int = 4;
                continue;
                localavwx.jdField_a_of_type_Int = 2;
              }
            }
            localavwx.jdField_a_of_type_Int = 9999;
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