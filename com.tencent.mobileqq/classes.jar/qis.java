import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class qis
  extends bead
{
  qis(qir paramqir, String paramString1, BaseResData paramBaseResData, String paramString2) {}
  
  public void onCancel(beae parambeae)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bead)this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilArrayList.get(i)).onCancel(parambeae);
      i += 1;
    }
    String str = parambeae.a().getString("resId");
    this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilHashMap.remove(this.b + "_" + str);
    super.onCancel(parambeae);
    this.jdField_a_of_type_Qir.a("onCancel", parambeae);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onCancel");
    }
  }
  
  public void onDone(beae parambeae)
  {
    Object localObject = parambeae.a();
    String str1 = ((Bundle)localObject).getString("resId");
    String str2 = ((Bundle)localObject).getString("prefix");
    if (parambeae.jdField_a_of_type_Int == 0)
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
            if (!((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData).res_md5.equals(bdhb.c(((File)localObject).getPath()).toLowerCase()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData check file md5  failed: id = " + str1);
              }
              if ((!bdhb.d(((File)localObject).getPath())) && (QLog.isColorLevel())) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData deleteFile file   failed: id = " + str1);
              }
              ocx.a((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData, false, "check file md5 failed");
              return;
            }
            bdhb.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Qir.b(str2, str1), false);
            this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(parambeae.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Qir.b(str2, str1));
            this.jdField_a_of_type_Qir.a(this.jdField_a_of_type_Qir.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            ((File)localObject).delete();
            this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilHashMap.remove(str2 + "_" + str1);
            this.jdField_a_of_type_Qir.a(str2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            i = 0;
            if (i >= this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            ((bead)this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilArrayList.get(i)).onDone(parambeae);
            i += 1;
            continue;
          }
          bdhb.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Qir.a(str2), false);
          continue;
          try
          {
            bdhb.b(this.jdField_a_of_type_Qir.b(str2, str1));
            if (!bdhb.a((String)this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambeae.jdField_a_of_type_JavaLangString))) {
              continue;
            }
            bdhb.a((String)this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambeae.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Qir.b(str2, str1), false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ReadInJoyBaseResManager", 2, "it is the same url copy to another dir path from: " + (String)this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambeae.jdField_a_of_type_JavaLangString) + " to :" + this.jdField_a_of_type_Qir.b(str2, str1));
          }
          catch (Exception localException) {}
        }
        catch (Exception parambeae)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(parambeae));
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
      this.jdField_a_of_type_Qir.a("onDone", parambeae);
      int i = parambeae.jdField_a_of_type_Int;
      long l1 = parambeae.h;
      long l2 = parambeae.g;
      this.jdField_a_of_type_Qir.a(new String[] { String.valueOf(i), str1, String.valueOf(l1 - l2) });
    } while (!QLog.isColorLevel());
    QLog.d("readinjoy", 4, "mDownloader downLoadFinish");
  }
  
  public void onProgress(beae parambeae)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bead)this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilArrayList.get(i)).onProgress(parambeae);
      i += 1;
    }
    super.onProgress(parambeae);
    this.jdField_a_of_type_Qir.a("onProgress", parambeae);
  }
  
  public boolean onStart(beae parambeae)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bead)this.jdField_a_of_type_Qir.jdField_a_of_type_JavaUtilArrayList.get(i)).onStart(parambeae);
      i += 1;
    }
    this.jdField_a_of_type_Qir.a("onStart", parambeae);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onStart");
    }
    return super.onStart(parambeae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qis
 * JD-Core Version:    0.7.0.1
 */