package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import axqw;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

public final class DownloadInfoReport$1
  implements Runnable
{
  public DownloadInfoReport$1(int paramInt1, String paramString, Object paramObject, int paramInt2) {}
  
  public void run()
  {
    try
    {
      switch (this.jdField_a_of_type_Int)
      {
      case 1: 
      case 11: 
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.contains("204002177")))
          {
            String str1 = "";
            if ((this.jdField_a_of_type_JavaLangObject instanceof DownloadInfo)) {
              str1 = ((DownloadInfo)this.jdField_a_of_type_JavaLangObject).e;
            }
            axqw.b(null, "dc00898", "", "", "0X800A80C", "0X800A80C", this.jdField_a_of_type_Int, this.b, "1", "1", this.jdField_a_of_type_JavaLangString, str1);
            return;
          }
        }
        break;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("UniformDownloadEvent", 2, localThrowable, new Object[] { " in reportSpecialCareAPKDownloadInfo" });
        return;
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.contains("weseeugg.qq.com/download")))
        {
          String str2 = "";
          if ((this.jdField_a_of_type_JavaLangObject instanceof DownloadInfo)) {
            str2 = ((DownloadInfo)this.jdField_a_of_type_JavaLangObject).e;
          }
          axqw.b(null, "dc00898", "", "", "0X800A80C", "0X800A80C", this.jdField_a_of_type_Int, this.b, "2", "1", this.jdField_a_of_type_JavaLangString, str2);
          return;
          if ((this.jdField_a_of_type_JavaLangObject instanceof DownloadInfo))
          {
            String str3 = ((DownloadInfo)this.jdField_a_of_type_JavaLangObject).d;
            if (!TextUtils.isEmpty(str3))
            {
              int i;
              int j;
              if (str3.contains("204002177"))
              {
                i = this.jdField_a_of_type_Int;
                j = this.b;
                if (TextUtils.isEmpty(((DownloadInfo)this.jdField_a_of_type_JavaLangObject).e)) {}
                for (str2 = "empty";; str2 = ((DownloadInfo)this.jdField_a_of_type_JavaLangObject).e)
                {
                  axqw.b(null, "dc00898", "", "", "0X800A80D", "0X800A80D", i, j, "1", "1", str3, str2);
                  return;
                }
              }
              if (str3.contains("weseeugg.qq.com/download"))
              {
                i = this.jdField_a_of_type_Int;
                j = this.b;
                if (TextUtils.isEmpty(((DownloadInfo)this.jdField_a_of_type_JavaLangObject).e)) {}
                for (str2 = "empty";; str2 = ((DownloadInfo)this.jdField_a_of_type_JavaLangObject).e)
                {
                  axqw.b(null, "dc00898", "", "", "0X800A80D", "0X800A80D", i, j, "2", "1", str3, str2);
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadInfoReport.1
 * JD-Core Version:    0.7.0.1
 */