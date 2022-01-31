import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class pyx
  extends bbwt
{
  pyx(pyw parampyw, String paramString1, BaseResData paramBaseResData, String paramString2) {}
  
  public void onCancel(bbwu parambbwu)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bbwt)this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilArrayList.get(i)).onCancel(parambbwu);
      i += 1;
    }
    String str = parambbwu.a().getString("resId");
    this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilHashMap.remove(this.b + "_" + str);
    super.onCancel(parambbwu);
    this.jdField_a_of_type_Pyw.a("onCancel", parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onCancel");
    }
  }
  
  public void onDone(bbwu parambbwu)
  {
    Object localObject = parambbwu.a();
    String str1 = ((Bundle)localObject).getString("resId");
    String str2 = ((Bundle)localObject).getString("prefix");
    if (parambbwu.jdField_a_of_type_Int == 0)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (!((File)localObject).exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData instanceof MaterialData))
          {
            if (!((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData).res_md5.equals(bbdx.c(((File)localObject).getPath()).toLowerCase()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData check file md5  failed: id = " + str1);
              }
              if ((!bbdx.d(((File)localObject).getPath())) && (QLog.isColorLevel())) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData deleteFile file   failed: id = " + str1);
              }
              nzn.a((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData, false, "check file md5 failed");
              return;
            }
            bbdx.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Pyw.b(str2, str1), false);
            this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(parambbwu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Pyw.b(str2, str1));
            this.jdField_a_of_type_Pyw.a(this.jdField_a_of_type_Pyw.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            ((File)localObject).delete();
            this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilHashMap.remove(str2 + "_" + str1);
            this.jdField_a_of_type_Pyw.a(str2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            i = 0;
            if (i >= this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            ((bbwt)this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilArrayList.get(i)).onDone(parambbwu);
            i += 1;
            continue;
          }
          bbdx.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Pyw.a(str2), false);
          continue;
          try
          {
            bbdx.b(this.jdField_a_of_type_Pyw.b(str2, str1));
            if (!bbdx.a((String)this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambbwu.jdField_a_of_type_JavaLangString))) {
              continue;
            }
            bbdx.a((String)this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambbwu.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Pyw.b(str2, str1), false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ReadInJoyBaseResManager", 2, "it is the same url copy to another dir path from: " + (String)this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambbwu.jdField_a_of_type_JavaLangString) + " to :" + this.jdField_a_of_type_Pyw.b(str2, str1));
          }
          catch (Exception localException) {}
        }
        catch (Exception parambbwu)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(parambbwu));
          }
          return;
        }
        finally
        {
          ((File)localObject).delete();
        }
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyBaseResManager", 2, "t is the same url copy to another dir path failed: id = " + str1 + ", " + QLog.getStackTraceString(localException));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide failed: id = " + str1);
          }
        }
      }
      this.jdField_a_of_type_Pyw.a("onDone", parambbwu);
      int i = parambbwu.jdField_a_of_type_Int;
      long l1 = parambbwu.h;
      long l2 = parambbwu.g;
      this.jdField_a_of_type_Pyw.a(new String[] { String.valueOf(i), str1, String.valueOf(l1 - l2) });
    } while (!QLog.isColorLevel());
    QLog.d("readinjoy", 4, "mDownloader downLoadFinish");
  }
  
  public void onProgress(bbwu parambbwu)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bbwt)this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilArrayList.get(i)).onProgress(parambbwu);
      i += 1;
    }
    super.onProgress(parambbwu);
    this.jdField_a_of_type_Pyw.a("onProgress", parambbwu);
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bbwt)this.jdField_a_of_type_Pyw.jdField_a_of_type_JavaUtilArrayList.get(i)).onStart(parambbwu);
      i += 1;
    }
    this.jdField_a_of_type_Pyw.a("onStart", parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onStart");
    }
    return super.onStart(parambbwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pyx
 * JD-Core Version:    0.7.0.1
 */