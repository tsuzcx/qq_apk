package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

final class DownloadInfoReport$1
  implements Runnable
{
  DownloadInfoReport$1(int paramInt1, String paramString, Object paramObject, int paramInt2) {}
  
  public void run()
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      String str2;
      String str1;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 11) {
            break label220;
          }
          if (i != 12) {
            return;
          }
        }
        if (!(this.jdField_a_of_type_JavaLangObject instanceof DownloadInfo)) {
          return;
        }
        str2 = ((DownloadInfo)this.jdField_a_of_type_JavaLangObject).d;
        if (TextUtils.isEmpty(str2)) {
          return;
        }
        boolean bool = str2.contains("204002177");
        if (bool)
        {
          i = this.jdField_a_of_type_Int;
          j = this.b;
          if (TextUtils.isEmpty(((DownloadInfo)this.jdField_a_of_type_JavaLangObject).e)) {
            str1 = "empty";
          } else {
            str1 = ((DownloadInfo)this.jdField_a_of_type_JavaLangObject).e;
          }
          ReportController.b(null, "dc00898", "", "", "0X800A80D", "0X800A80D", i, j, "1", "1", str2, str1);
          return;
        }
        if (!str2.contains("weseeugg.qq.com/download")) {
          return;
        }
        i = this.jdField_a_of_type_Int;
        int j = this.b;
        if (TextUtils.isEmpty(((DownloadInfo)this.jdField_a_of_type_JavaLangObject).e)) {
          str1 = "empty";
        } else {
          str1 = ((DownloadInfo)this.jdField_a_of_type_JavaLangObject).e;
        }
        ReportController.b(null, "dc00898", "", "", "0X800A80D", "0X800A80D", i, j, "2", "1", str2, str1);
        return;
      }
      label220:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        str2 = this.jdField_a_of_type_JavaLangString;
        str1 = "";
        if ((str2 != null) && (this.jdField_a_of_type_JavaLangString.contains("204002177")))
        {
          if ((this.jdField_a_of_type_JavaLangObject instanceof DownloadInfo)) {
            str1 = ((DownloadInfo)this.jdField_a_of_type_JavaLangObject).e;
          }
          ReportController.b(null, "dc00898", "", "", "0X800A80C", "0X800A80C", this.jdField_a_of_type_Int, this.b, "1", "1", this.jdField_a_of_type_JavaLangString, str1);
          return;
        }
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.contains("weseeugg.qq.com/download")))
        {
          if ((this.jdField_a_of_type_JavaLangObject instanceof DownloadInfo)) {
            str1 = ((DownloadInfo)this.jdField_a_of_type_JavaLangObject).e;
          }
          ReportController.b(null, "dc00898", "", "", "0X800A80C", "0X800A80C", this.jdField_a_of_type_Int, this.b, "2", "1", this.jdField_a_of_type_JavaLangString, str1);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UniformDownloadEvent", 2, localThrowable, new Object[] { " in reportSpecialCareAPKDownloadInfo" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadInfoReport.1
 * JD-Core Version:    0.7.0.1
 */