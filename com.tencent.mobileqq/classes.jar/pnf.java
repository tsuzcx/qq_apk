import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class pnf
  extends batl
{
  pnf(pne parampne, String paramString1, BaseResData paramBaseResData, String paramString2) {}
  
  public void onCancel(batm parambatm)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((batl)this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilArrayList.get(i)).onCancel(parambatm);
      i += 1;
    }
    String str = parambatm.a().getString("resId");
    this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilHashMap.remove(this.b + "_" + str);
    super.onCancel(parambatm);
    this.jdField_a_of_type_Pne.a("onCancel", parambatm);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onCancel");
    }
  }
  
  public void onDone(batm parambatm)
  {
    Object localObject = parambatm.a();
    String str1 = ((Bundle)localObject).getString("resId");
    String str2 = ((Bundle)localObject).getString("prefix");
    if (parambatm.jdField_a_of_type_Int == 0)
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
            if (!((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData).res_md5.equals(bace.c(((File)localObject).getPath()).toLowerCase()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData check file md5  failed: id = " + str1);
              }
              if ((!bace.d(((File)localObject).getPath())) && (QLog.isColorLevel())) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData deleteFile file   failed: id = " + str1);
              }
              nof.a((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData, false, "check file md5 failed");
              return;
            }
            bace.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Pne.b(str2, str1), false);
            this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(parambatm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Pne.b(str2, str1));
            this.jdField_a_of_type_Pne.a(this.jdField_a_of_type_Pne.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            ((File)localObject).delete();
            this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilHashMap.remove(str2 + "_" + str1);
            this.jdField_a_of_type_Pne.a(str2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            i = 0;
            if (i >= this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            ((batl)this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilArrayList.get(i)).onDone(parambatm);
            i += 1;
            continue;
          }
          bace.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Pne.a(str2), false);
          continue;
          try
          {
            bace.b(this.jdField_a_of_type_Pne.b(str2, str1));
            if (!bace.a((String)this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambatm.jdField_a_of_type_JavaLangString))) {
              continue;
            }
            bace.a((String)this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambatm.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Pne.b(str2, str1), false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ReadInJoyBaseResManager", 2, "it is the same url copy to another dir path from: " + (String)this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambatm.jdField_a_of_type_JavaLangString) + " to :" + this.jdField_a_of_type_Pne.b(str2, str1));
          }
          catch (Exception localException) {}
        }
        catch (Exception parambatm)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(parambatm));
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
      this.jdField_a_of_type_Pne.a("onDone", parambatm);
      int i = parambatm.jdField_a_of_type_Int;
      long l1 = parambatm.h;
      long l2 = parambatm.g;
      this.jdField_a_of_type_Pne.a(new String[] { String.valueOf(i), str1, String.valueOf(l1 - l2) });
    } while (!QLog.isColorLevel());
    QLog.d("readinjoy", 4, "mDownloader downLoadFinish");
  }
  
  public void onProgress(batm parambatm)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((batl)this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilArrayList.get(i)).onProgress(parambatm);
      i += 1;
    }
    super.onProgress(parambatm);
    this.jdField_a_of_type_Pne.a("onProgress", parambatm);
  }
  
  public boolean onStart(batm parambatm)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((batl)this.jdField_a_of_type_Pne.jdField_a_of_type_JavaUtilArrayList.get(i)).onStart(parambatm);
      i += 1;
    }
    this.jdField_a_of_type_Pne.a("onStart", parambatm);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onStart");
    }
    return super.onStart(parambatm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pnf
 * JD-Core Version:    0.7.0.1
 */