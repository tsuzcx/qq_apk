package com.tencent.mobileqq.richmedia.dc;

import aild;
import alpo;
import android.os.Environment;
import arof;
import axot;
import axoy;
import azav;
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
  public DCShortVideo$1(axot paramaxot, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    axoy localaxoy = new axoy();
    Object localObject3 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject3).exists()) {}
    for (;;)
    {
      return;
      localaxoy.jdField_a_of_type_Long = ((File)localObject3).length();
      if (localaxoy.jdField_a_of_type_Long <= 0L) {
        continue;
      }
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localaxoy);
      localaxoy.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localaxoy.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
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
        localaxoy.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
        localObject2 = arof.c(this.jdField_a_of_type_JavaLangString);
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
            localaxoy.j = 1002;
            localaxoy.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.jdField_c_of_type_Int != 0) {
                break label927;
              }
              localaxoy.jdField_a_of_type_Int = 0;
            }
          }
        }
        for (;;)
        {
          localaxoy.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
          localaxoy.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
          if (localaxoy.k == 0) {
            localaxoy.k = 1;
          }
          localaxoy.m = VideoEnvironment.jdField_a_of_type_Int;
          localaxoy.l = (VideoEnvironment.jdField_a_of_type_Azav.jdField_a_of_type_Int + 2000);
          if (QLog.isDevelopLevel()) {
            QLog.d("DCShortVideo", 4, "[reportSend]url=" + localaxoy.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localaxoy.f + ",shortVideoSourceType = " + localaxoy.j + ",uinType = " + localaxoy.jdField_b_of_type_Int + ",groupMemCount = " + localaxoy.jdField_c_of_type_Int + ",isForward = " + localaxoy.jdField_a_of_type_Boolean + ",isExsit = " + localaxoy.jdField_b_of_type_Boolean + ",age = " + localaxoy.d + ",gender = " + localaxoy.e + ",userType = " + localaxoy.l + ",reprotHour = " + localaxoy.g + ",fileInterval = " + localaxoy.k + ",netType = " + localaxoy.h + ",forwardSourceGroupMemCount = " + localaxoy.i + ",forwardSourceUinType = " + localaxoy.jdField_a_of_type_Int + ",duration = " + localaxoy.jdField_b_of_type_Long + ",fileSize = " + localaxoy.jdField_a_of_type_Long + ",md5 = " + localaxoy.jdField_b_of_type_JavaLangString + ", status=" + localaxoy.m);
          }
          localObject1 = new DataReport.ReportTask("ShortVideo.Send", localaxoy.a("ShortVideo.Send"));
          DataReport.a().a((DataReport.ReportTask)localObject1);
          return;
          if (((String)localObject1).contains("/qq_collection/"))
          {
            localaxoy.j = 1001;
            break;
          }
          if (((String)localObject1).contains("/qqfile_recv/"))
          {
            localaxoy.j = 1003;
            break;
          }
          if ((((String)localObject1).contains("/weixin/")) || (((String)localObject1).contains("/wechat/")) || (((String)localObject1).contains("/micromsg/")))
          {
            localaxoy.j = 1004;
            break;
          }
          if (aild.a((String)localObject1))
          {
            localaxoy.j = 1005;
            break;
          }
          localaxoy.j = 1006;
          break;
          if (((String)localObject1).equalsIgnoreCase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator))
          {
            localaxoy.j = 1002;
            break;
          }
          if ((((String)localObject2).contains("camera")) || (((String)localObject2).equals("dcim")) || (((String)localObject2).equals("100MEDIA")) || (((String)localObject2).equals("100ANDRO")) || (((String)localObject2).contains(alpo.a(2131703254))) || (((String)localObject2).contains(alpo.a(2131703253))) || (((String)localObject2).contains(alpo.a(2131703255))))
          {
            localaxoy.j = 1007;
            break;
          }
          if (aild.a((String)localObject1))
          {
            localaxoy.j = 1005;
            break;
          }
          localaxoy.j = 1006;
          break;
          if (this.jdField_c_of_type_Int == 3000)
          {
            localaxoy.jdField_a_of_type_Int = 3000;
          }
          else
          {
            if (this.jdField_c_of_type_Int == 1)
            {
              switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.d))
              {
              default: 
                localaxoy.jdField_a_of_type_Int = 1;
              }
              for (;;)
              {
                localaxoy.i = 0;
                localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                if (localObject1 == null) {
                  break;
                }
                localObject1 = ((TroopManager)localObject1).c(this.d);
                if (localObject1 == null) {
                  break;
                }
                localaxoy.i = ((TroopInfo)localObject1).wMemberNum;
                break;
                localaxoy.jdField_a_of_type_Int = 1;
                continue;
                localaxoy.jdField_a_of_type_Int = 3;
                continue;
                localaxoy.jdField_a_of_type_Int = 4;
                continue;
                localaxoy.jdField_a_of_type_Int = 2;
              }
            }
            localaxoy.jdField_a_of_type_Int = 9999;
          }
        }
        return;
      }
      catch (Exception localException1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.1
 * JD-Core Version:    0.7.0.1
 */