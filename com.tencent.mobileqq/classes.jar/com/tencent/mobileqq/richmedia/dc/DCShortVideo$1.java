package com.tencent.mobileqq.richmedia.dc;

import ageh;
import ajjy;
import android.os.Environment;
import apdh;
import auxb;
import auxg;
import awgf;
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
  public DCShortVideo$1(auxb paramauxb, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    auxg localauxg = new auxg();
    Object localObject3 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject3).exists()) {}
    for (;;)
    {
      return;
      localauxg.jdField_a_of_type_Long = ((File)localObject3).length();
      if (localauxg.jdField_a_of_type_Long <= 0L) {
        continue;
      }
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localauxg);
      localauxg.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localauxg.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
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
        localauxg.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
        localObject2 = apdh.c(this.jdField_a_of_type_JavaLangString);
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
            localauxg.j = 1002;
            localauxg.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.jdField_c_of_type_Int != 0) {
                break label927;
              }
              localauxg.jdField_a_of_type_Int = 0;
            }
          }
        }
        for (;;)
        {
          localauxg.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
          localauxg.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
          if (localauxg.k == 0) {
            localauxg.k = 1;
          }
          localauxg.m = VideoEnvironment.jdField_a_of_type_Int;
          localauxg.l = (VideoEnvironment.jdField_a_of_type_Awgf.jdField_a_of_type_Int + 2000);
          if (QLog.isDevelopLevel()) {
            QLog.d("DCShortVideo", 4, "[reportSend]url=" + localauxg.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localauxg.f + ",shortVideoSourceType = " + localauxg.j + ",uinType = " + localauxg.jdField_b_of_type_Int + ",groupMemCount = " + localauxg.jdField_c_of_type_Int + ",isForward = " + localauxg.jdField_a_of_type_Boolean + ",isExsit = " + localauxg.jdField_b_of_type_Boolean + ",age = " + localauxg.d + ",gender = " + localauxg.e + ",userType = " + localauxg.l + ",reprotHour = " + localauxg.g + ",fileInterval = " + localauxg.k + ",netType = " + localauxg.h + ",forwardSourceGroupMemCount = " + localauxg.i + ",forwardSourceUinType = " + localauxg.jdField_a_of_type_Int + ",duration = " + localauxg.jdField_b_of_type_Long + ",fileSize = " + localauxg.jdField_a_of_type_Long + ",md5 = " + localauxg.jdField_b_of_type_JavaLangString + ", status=" + localauxg.m);
          }
          localObject1 = new DataReport.ReportTask("ShortVideo.Send", localauxg.a("ShortVideo.Send"));
          DataReport.a().a((DataReport.ReportTask)localObject1);
          return;
          if (((String)localObject1).contains("/qq_collection/"))
          {
            localauxg.j = 1001;
            break;
          }
          if (((String)localObject1).contains("/qqfile_recv/"))
          {
            localauxg.j = 1003;
            break;
          }
          if ((((String)localObject1).contains("/weixin/")) || (((String)localObject1).contains("/wechat/")) || (((String)localObject1).contains("/micromsg/")))
          {
            localauxg.j = 1004;
            break;
          }
          if (ageh.a((String)localObject1))
          {
            localauxg.j = 1005;
            break;
          }
          localauxg.j = 1006;
          break;
          if (((String)localObject1).equalsIgnoreCase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator))
          {
            localauxg.j = 1002;
            break;
          }
          if ((((String)localObject2).contains("camera")) || (((String)localObject2).equals("dcim")) || (((String)localObject2).equals("100MEDIA")) || (((String)localObject2).equals("100ANDRO")) || (((String)localObject2).contains(ajjy.a(2131637087))) || (((String)localObject2).contains(ajjy.a(2131637086))) || (((String)localObject2).contains(ajjy.a(2131637088))))
          {
            localauxg.j = 1007;
            break;
          }
          if (ageh.a((String)localObject1))
          {
            localauxg.j = 1005;
            break;
          }
          localauxg.j = 1006;
          break;
          if (this.jdField_c_of_type_Int == 3000)
          {
            localauxg.jdField_a_of_type_Int = 3000;
          }
          else
          {
            if (this.jdField_c_of_type_Int == 1)
            {
              switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.d))
              {
              default: 
                localauxg.jdField_a_of_type_Int = 1;
              }
              for (;;)
              {
                localauxg.i = 0;
                localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                if (localObject1 == null) {
                  break;
                }
                localObject1 = ((TroopManager)localObject1).c(this.d);
                if (localObject1 == null) {
                  break;
                }
                localauxg.i = ((TroopInfo)localObject1).wMemberNum;
                break;
                localauxg.jdField_a_of_type_Int = 1;
                continue;
                localauxg.jdField_a_of_type_Int = 3;
                continue;
                localauxg.jdField_a_of_type_Int = 4;
                continue;
                localauxg.jdField_a_of_type_Int = 2;
              }
            }
            localauxg.jdField_a_of_type_Int = 9999;
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