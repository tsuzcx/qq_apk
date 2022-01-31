import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyBaseResManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class mai
  extends DownloadListener
{
  public mai(ReadInJoyBaseResManager paramReadInJoyBaseResManager, String paramString1, BaseResData paramBaseResData, String paramString2) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((DownloadListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.get(i)).onCancel(paramDownloadTask);
      i += 1;
    }
    String str = paramDownloadTask.a().getString("resId");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilHashMap.remove(this.b + "_" + str);
    super.onCancel(paramDownloadTask);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a("onCancel", paramDownloadTask);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Object localObject = paramDownloadTask.a();
    String str1 = ((Bundle)localObject).getString("resId");
    String str2 = ((Bundle)localObject).getString("prefix");
    if (paramDownloadTask.a == 0)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (!((File)localObject).exists()) {}
    }
    for (;;)
    {
      try
      {
        FileUtils.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a(str2), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
        ((File)localObject).delete();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilHashMap.remove(str2 + "_" + str1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a(str2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
        i = 0;
        if (i >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        ((DownloadListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.get(i)).onDone(paramDownloadTask);
        i += 1;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (Exception paramDownloadTask)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(paramDownloadTask));
        }
        return;
      }
      finally
      {
        ((File)localObject).delete();
      }
      QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide failed: id = " + str1);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a("onDone", paramDownloadTask);
    int i = paramDownloadTask.a;
    long l1 = paramDownloadTask.h;
    long l2 = paramDownloadTask.g;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a(new String[] { String.valueOf(i), str1, String.valueOf(l1 - l2) });
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((DownloadListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.get(i)).onProgress(paramDownloadTask);
      i += 1;
    }
    super.onProgress(paramDownloadTask);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a("onProgress", paramDownloadTask);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((DownloadListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.get(i)).onStart(paramDownloadTask);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a("onStart", paramDownloadTask);
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mai
 * JD-Core Version:    0.7.0.1
 */