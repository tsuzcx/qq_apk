import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class rcv
  extends bhhe
{
  rcv(rcu paramrcu, String paramString1, BaseResData paramBaseResData, String paramString2) {}
  
  public void onCancel(bhhf parambhhf)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bhhe)this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilArrayList.get(i)).onCancel(parambhhf);
      i += 1;
    }
    String str = parambhhf.a().getString("resId");
    this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilHashMap.remove(this.b + "_" + str);
    super.onCancel(parambhhf);
    this.jdField_a_of_type_Rcu.a("onCancel", parambhhf);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onCancel");
    }
  }
  
  public void onDone(bhhf parambhhf)
  {
    Object localObject = parambhhf.a();
    String str1 = ((Bundle)localObject).getString("resId");
    String str2 = ((Bundle)localObject).getString("prefix");
    if (parambhhf.jdField_a_of_type_Int == 0)
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
            if (!((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData).res_md5.equals(bgmg.c(((File)localObject).getPath()).toLowerCase()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData check file md5  failed: id = " + str1);
              }
              if ((!bgmg.d(((File)localObject).getPath())) && (QLog.isColorLevel())) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData deleteFile file   failed: id = " + str1);
              }
              oon.a((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData, false, "check file md5 failed");
              return;
            }
            bgmg.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Rcu.b(str2, str1), false);
            this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(parambhhf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Rcu.b(str2, str1));
            this.jdField_a_of_type_Rcu.a(this.jdField_a_of_type_Rcu.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            ((File)localObject).delete();
            this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilHashMap.remove(str2 + "_" + str1);
            this.jdField_a_of_type_Rcu.a(str2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            i = 0;
            if (i >= this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            ((bhhe)this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilArrayList.get(i)).onDone(parambhhf);
            i += 1;
            continue;
          }
          bgmg.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Rcu.a(str2), false);
          continue;
          try
          {
            bgmg.b(this.jdField_a_of_type_Rcu.b(str2, str1));
            if (!bgmg.a((String)this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambhhf.jdField_a_of_type_JavaLangString))) {
              continue;
            }
            bgmg.a((String)this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambhhf.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Rcu.b(str2, str1), false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ReadInJoyBaseResManager", 2, "it is the same url copy to another dir path from: " + (String)this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambhhf.jdField_a_of_type_JavaLangString) + " to :" + this.jdField_a_of_type_Rcu.b(str2, str1));
          }
          catch (Exception localException) {}
        }
        catch (Exception parambhhf)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(parambhhf));
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
            bgmg.a(this.jdField_a_of_type_Rcu.b(str2, str1));
          }
        }
      }
      this.jdField_a_of_type_Rcu.a("onDone", parambhhf);
      int i = parambhhf.jdField_a_of_type_Int;
      long l1 = parambhhf.h;
      long l2 = parambhhf.g;
      this.jdField_a_of_type_Rcu.a(new String[] { String.valueOf(i), str1, String.valueOf(l1 - l2) });
    } while (!QLog.isColorLevel());
    QLog.d("readinjoy", 4, "mDownloader downLoadFinish");
  }
  
  public void onProgress(bhhf parambhhf)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bhhe)this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilArrayList.get(i)).onProgress(parambhhf);
      i += 1;
    }
    super.onProgress(parambhhf);
    this.jdField_a_of_type_Rcu.a("onProgress", parambhhf);
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bhhe)this.jdField_a_of_type_Rcu.jdField_a_of_type_JavaUtilArrayList.get(i)).onStart(parambhhf);
      i += 1;
    }
    this.jdField_a_of_type_Rcu.a("onStart", parambhhf);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onStart");
    }
    return super.onStart(parambhhf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rcv
 * JD-Core Version:    0.7.0.1
 */