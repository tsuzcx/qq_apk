package com.tencent.mobileqq.richmedia.dc;

import aips;
import alud;
import android.os.Environment;
import arso;
import axtc;
import axth;
import azfe;
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
  public DCShortVideo$1(axtc paramaxtc, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    axth localaxth = new axth();
    Object localObject3 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject3).exists()) {}
    for (;;)
    {
      return;
      localaxth.jdField_a_of_type_Long = ((File)localObject3).length();
      if (localaxth.jdField_a_of_type_Long <= 0L) {
        continue;
      }
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localaxth);
      localaxth.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localaxth.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
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
        localaxth.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
        localObject2 = arso.c(this.jdField_a_of_type_JavaLangString);
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
            localaxth.j = 1002;
            localaxth.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.jdField_c_of_type_Int != 0) {
                break label927;
              }
              localaxth.jdField_a_of_type_Int = 0;
            }
          }
        }
        for (;;)
        {
          localaxth.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
          localaxth.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
          if (localaxth.k == 0) {
            localaxth.k = 1;
          }
          localaxth.m = VideoEnvironment.jdField_a_of_type_Int;
          localaxth.l = (VideoEnvironment.jdField_a_of_type_Azfe.jdField_a_of_type_Int + 2000);
          if (QLog.isDevelopLevel()) {
            QLog.d("DCShortVideo", 4, "[reportSend]url=" + localaxth.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localaxth.f + ",shortVideoSourceType = " + localaxth.j + ",uinType = " + localaxth.jdField_b_of_type_Int + ",groupMemCount = " + localaxth.jdField_c_of_type_Int + ",isForward = " + localaxth.jdField_a_of_type_Boolean + ",isExsit = " + localaxth.jdField_b_of_type_Boolean + ",age = " + localaxth.d + ",gender = " + localaxth.e + ",userType = " + localaxth.l + ",reprotHour = " + localaxth.g + ",fileInterval = " + localaxth.k + ",netType = " + localaxth.h + ",forwardSourceGroupMemCount = " + localaxth.i + ",forwardSourceUinType = " + localaxth.jdField_a_of_type_Int + ",duration = " + localaxth.jdField_b_of_type_Long + ",fileSize = " + localaxth.jdField_a_of_type_Long + ",md5 = " + localaxth.jdField_b_of_type_JavaLangString + ", status=" + localaxth.m);
          }
          localObject1 = new DataReport.ReportTask("ShortVideo.Send", localaxth.a("ShortVideo.Send"));
          DataReport.a().a((DataReport.ReportTask)localObject1);
          return;
          if (((String)localObject1).contains("/qq_collection/"))
          {
            localaxth.j = 1001;
            break;
          }
          if (((String)localObject1).contains("/qqfile_recv/"))
          {
            localaxth.j = 1003;
            break;
          }
          if ((((String)localObject1).contains("/weixin/")) || (((String)localObject1).contains("/wechat/")) || (((String)localObject1).contains("/micromsg/")))
          {
            localaxth.j = 1004;
            break;
          }
          if (aips.a((String)localObject1))
          {
            localaxth.j = 1005;
            break;
          }
          localaxth.j = 1006;
          break;
          if (((String)localObject1).equalsIgnoreCase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator))
          {
            localaxth.j = 1002;
            break;
          }
          if ((((String)localObject2).contains("camera")) || (((String)localObject2).equals("dcim")) || (((String)localObject2).equals("100MEDIA")) || (((String)localObject2).equals("100ANDRO")) || (((String)localObject2).contains(alud.a(2131703266))) || (((String)localObject2).contains(alud.a(2131703265))) || (((String)localObject2).contains(alud.a(2131703267))))
          {
            localaxth.j = 1007;
            break;
          }
          if (aips.a((String)localObject1))
          {
            localaxth.j = 1005;
            break;
          }
          localaxth.j = 1006;
          break;
          if (this.jdField_c_of_type_Int == 3000)
          {
            localaxth.jdField_a_of_type_Int = 3000;
          }
          else
          {
            if (this.jdField_c_of_type_Int == 1)
            {
              switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.d))
              {
              default: 
                localaxth.jdField_a_of_type_Int = 1;
              }
              for (;;)
              {
                localaxth.i = 0;
                localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                if (localObject1 == null) {
                  break;
                }
                localObject1 = ((TroopManager)localObject1).c(this.d);
                if (localObject1 == null) {
                  break;
                }
                localaxth.i = ((TroopInfo)localObject1).wMemberNum;
                break;
                localaxth.jdField_a_of_type_Int = 1;
                continue;
                localaxth.jdField_a_of_type_Int = 3;
                continue;
                localaxth.jdField_a_of_type_Int = 4;
                continue;
                localaxth.jdField_a_of_type_Int = 2;
              }
            }
            localaxth.jdField_a_of_type_Int = 9999;
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