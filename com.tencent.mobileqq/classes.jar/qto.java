import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class qto
  extends biht
{
  qto(qtn paramqtn, String paramString1, BaseResData paramBaseResData, String paramString2) {}
  
  public void onCancel(bihu parambihu)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((biht)this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilArrayList.get(i)).onCancel(parambihu);
      i += 1;
    }
    String str = parambihu.a().getString("resId");
    this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilHashMap.remove(this.b + "_" + str);
    super.onCancel(parambihu);
    this.jdField_a_of_type_Qtn.a("onCancel", parambihu);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onCancel");
    }
  }
  
  public void onDone(bihu parambihu)
  {
    Object localObject = parambihu.a();
    String str1 = ((Bundle)localObject).getString("resId");
    String str2 = ((Bundle)localObject).getString("prefix");
    if (parambihu.jdField_a_of_type_Int == 0)
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
            if (!((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData).res_md5.equals(bhmi.c(((File)localObject).getPath()).toLowerCase()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData check file md5  failed: id = " + str1);
              }
              if ((!bhmi.d(((File)localObject).getPath())) && (QLog.isColorLevel())) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData deleteFile file   failed: id = " + str1);
              }
              tny.a((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData, false, "check file md5 failed");
              return;
            }
            bhmi.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Qtn.a(str2, str1), false);
            this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(parambihu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Qtn.a(str2, str1));
            this.jdField_a_of_type_Qtn.a(this.jdField_a_of_type_Qtn.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            ((File)localObject).delete();
            this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilHashMap.remove(str2 + "_" + str1);
            this.jdField_a_of_type_Qtn.a(str2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            i = 0;
            if (i >= this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            ((biht)this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilArrayList.get(i)).onDone(parambihu);
            i += 1;
            continue;
          }
          bhmi.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Qtn.a(str2), false);
          continue;
          try
          {
            bhmi.b(this.jdField_a_of_type_Qtn.a(str2, str1));
            if (!bhmi.a((String)this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambihu.jdField_a_of_type_JavaLangString))) {
              continue;
            }
            bhmi.a((String)this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambihu.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Qtn.a(str2, str1), false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ReadInJoyBaseResManager", 2, "it is the same url copy to another dir path from: " + (String)this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambihu.jdField_a_of_type_JavaLangString) + " to :" + this.jdField_a_of_type_Qtn.a(str2, str1));
          }
          catch (Exception localException) {}
        }
        catch (Exception parambihu)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(parambihu));
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
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData instanceof MaterialData)) {
            bhmi.a(this.jdField_a_of_type_Qtn.a(str2, str1));
          }
        }
      }
      this.jdField_a_of_type_Qtn.a("onDone", parambihu);
      int i = parambihu.jdField_a_of_type_Int;
      long l1 = parambihu.h;
      long l2 = parambihu.g;
      this.jdField_a_of_type_Qtn.a(new String[] { String.valueOf(i), str1, String.valueOf(l1 - l2) });
    } while (!QLog.isColorLevel());
    QLog.d("readinjoy", 4, "mDownloader downLoadFinish");
  }
  
  public void onProgress(bihu parambihu)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((biht)this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilArrayList.get(i)).onProgress(parambihu);
      i += 1;
    }
    super.onProgress(parambihu);
    this.jdField_a_of_type_Qtn.a("onProgress", parambihu);
  }
  
  public boolean onStart(bihu parambihu)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((biht)this.jdField_a_of_type_Qtn.jdField_a_of_type_JavaUtilArrayList.get(i)).onStart(parambihu);
      i += 1;
    }
    this.jdField_a_of_type_Qtn.a("onStart", parambihu);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onStart");
    }
    return super.onStart(parambihu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qto
 * JD-Core Version:    0.7.0.1
 */