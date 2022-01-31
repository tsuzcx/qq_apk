import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class pza
  extends bbwf
{
  pza(pyz parampyz, String paramString1, BaseResData paramBaseResData, String paramString2) {}
  
  public void onCancel(bbwg parambbwg)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bbwf)this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilArrayList.get(i)).onCancel(parambbwg);
      i += 1;
    }
    String str = parambbwg.a().getString("resId");
    this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilHashMap.remove(this.b + "_" + str);
    super.onCancel(parambbwg);
    this.jdField_a_of_type_Pyz.a("onCancel", parambbwg);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onCancel");
    }
  }
  
  public void onDone(bbwg parambbwg)
  {
    Object localObject = parambbwg.a();
    String str1 = ((Bundle)localObject).getString("resId");
    String str2 = ((Bundle)localObject).getString("prefix");
    if (parambbwg.jdField_a_of_type_Int == 0)
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
            if (!((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData).res_md5.equals(bbdj.c(((File)localObject).getPath()).toLowerCase()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData check file md5  failed: id = " + str1);
              }
              if ((!bbdj.d(((File)localObject).getPath())) && (QLog.isColorLevel())) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData deleteFile file   failed: id = " + str1);
              }
              nzq.a((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData, false, "check file md5 failed");
              return;
            }
            bbdj.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Pyz.b(str2, str1), false);
            this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(parambbwg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Pyz.b(str2, str1));
            this.jdField_a_of_type_Pyz.a(this.jdField_a_of_type_Pyz.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            ((File)localObject).delete();
            this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilHashMap.remove(str2 + "_" + str1);
            this.jdField_a_of_type_Pyz.a(str2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            i = 0;
            if (i >= this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            ((bbwf)this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilArrayList.get(i)).onDone(parambbwg);
            i += 1;
            continue;
          }
          bbdj.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Pyz.a(str2), false);
          continue;
          try
          {
            bbdj.b(this.jdField_a_of_type_Pyz.b(str2, str1));
            if (!bbdj.a((String)this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambbwg.jdField_a_of_type_JavaLangString))) {
              continue;
            }
            bbdj.a((String)this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambbwg.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Pyz.b(str2, str1), false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ReadInJoyBaseResManager", 2, "it is the same url copy to another dir path from: " + (String)this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambbwg.jdField_a_of_type_JavaLangString) + " to :" + this.jdField_a_of_type_Pyz.b(str2, str1));
          }
          catch (Exception localException) {}
        }
        catch (Exception parambbwg)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(parambbwg));
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
      this.jdField_a_of_type_Pyz.a("onDone", parambbwg);
      int i = parambbwg.jdField_a_of_type_Int;
      long l1 = parambbwg.h;
      long l2 = parambbwg.g;
      this.jdField_a_of_type_Pyz.a(new String[] { String.valueOf(i), str1, String.valueOf(l1 - l2) });
    } while (!QLog.isColorLevel());
    QLog.d("readinjoy", 4, "mDownloader downLoadFinish");
  }
  
  public void onProgress(bbwg parambbwg)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bbwf)this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilArrayList.get(i)).onProgress(parambbwg);
      i += 1;
    }
    super.onProgress(parambbwg);
    this.jdField_a_of_type_Pyz.a("onProgress", parambbwg);
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bbwf)this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilArrayList.get(i)).onStart(parambbwg);
      i += 1;
    }
    this.jdField_a_of_type_Pyz.a("onStart", parambbwg);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onStart");
    }
    return super.onStart(parambbwg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pza
 * JD-Core Version:    0.7.0.1
 */