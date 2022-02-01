import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class ram
  extends bgod
{
  ram(ral paramral, BaseResData paramBaseResData, String paramString1, String paramString2) {}
  
  public void onCancel(bgoe parambgoe)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bgod)this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilArrayList.get(i)).onCancel(parambgoe);
      i += 1;
    }
    String str = parambgoe.a().getString("resId");
    this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilHashMap.remove(this.b + "_" + str);
    super.onCancel(parambgoe);
    this.jdField_a_of_type_Ral.a("onCancel", parambgoe);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onCancel");
    }
  }
  
  public void onDone(bgoe parambgoe)
  {
    Object localObject = parambgoe.a();
    String str1 = ((Bundle)localObject).getString("resId");
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData instanceof MaterialData)) && (pay.a() != null)) {
      ttv.a(pay.a()).a(parambgoe, (MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData, new File(this.jdField_a_of_type_JavaLangString));
    }
    do
    {
      return;
      String str2 = ((Bundle)localObject).getString("prefix");
      if (parambgoe.jdField_a_of_type_Int == 0)
      {
        localObject = new File(this.jdField_a_of_type_JavaLangString);
        if (!((File)localObject).exists()) {}
      }
      for (;;)
      {
        try
        {
          FileUtils.uncompressZip(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Ral.a(str2), false);
          this.jdField_a_of_type_Ral.a(this.jdField_a_of_type_Ral.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
          ((File)localObject).delete();
          this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilHashMap.remove(str2 + "_" + str1);
          this.jdField_a_of_type_Ral.a(str2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
          i = 0;
          if (i >= this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          ((bgod)this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilArrayList.get(i)).onDone(parambgoe);
          i += 1;
          continue;
          try
          {
            FileUtils.createDirectory(this.jdField_a_of_type_Ral.a(str2, str1));
            if (!FileUtils.fileExists((String)this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambgoe.jdField_a_of_type_JavaLangString))) {
              continue;
            }
            FileUtils.copyDirectory((String)this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambgoe.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Ral.a(str2, str1), false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ReadInJoyBaseResManager", 2, "it is the same url copy to another dir path from: " + (String)this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambgoe.jdField_a_of_type_JavaLangString) + " to :" + this.jdField_a_of_type_Ral.a(str2, str1));
          }
          catch (Exception localException) {}
        }
        catch (Exception parambgoe)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(parambgoe));
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
            FileUtils.deleteDirectory(this.jdField_a_of_type_Ral.a(str2, str1));
          }
        }
      }
      this.jdField_a_of_type_Ral.a("onDone", parambgoe);
      int i = parambgoe.jdField_a_of_type_Int;
      long l1 = parambgoe.h;
      long l2 = parambgoe.g;
      this.jdField_a_of_type_Ral.a(new String[] { String.valueOf(i), str1, String.valueOf(l1 - l2) });
    } while (!QLog.isColorLevel());
    QLog.d("readinjoy", 4, "mDownloader downLoadFinish");
  }
  
  public void onProgress(bgoe parambgoe)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bgod)this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilArrayList.get(i)).onProgress(parambgoe);
      i += 1;
    }
    super.onProgress(parambgoe);
    this.jdField_a_of_type_Ral.a("onProgress", parambgoe);
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bgod)this.jdField_a_of_type_Ral.jdField_a_of_type_JavaUtilArrayList.get(i)).onStart(parambgoe);
      i += 1;
    }
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData instanceof MaterialData)) && (pay.a() != null)) {
      ttv.a(pay.a()).a((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
    }
    this.jdField_a_of_type_Ral.a("onStart", parambgoe);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onStart");
    }
    return super.onStart(parambgoe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ram
 * JD-Core Version:    0.7.0.1
 */