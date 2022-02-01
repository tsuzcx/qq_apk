import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class rms
  extends bhyn
{
  rms(rmr paramrmr, BaseResData paramBaseResData, String paramString1, String paramString2) {}
  
  public void onCancel(bhyo parambhyo)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Rmr.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bhyn)this.jdField_a_of_type_Rmr.jdField_a_of_type_JavaUtilArrayList.get(i)).onCancel(parambhyo);
      i += 1;
    }
    String str = parambhyo.a().getString("resId");
    this.jdField_a_of_type_Rmr.jdField_a_of_type_JavaUtilHashMap.remove(this.b + "_" + str);
    super.onCancel(parambhyo);
    this.jdField_a_of_type_Rmr.a("onCancel", parambhyo);
    QLog.d("readinjoy", 2, "mDownloader onCancel");
  }
  
  public void onDone(bhyo parambhyo)
  {
    Object localObject = parambhyo.a();
    String str = ((Bundle)localObject).getString("resId");
    if (rmr.a(this.jdField_a_of_type_Rmr, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData, parambhyo, this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      localObject = ((Bundle)localObject).getString("prefix");
      if (parambhyo.a != 0) {
        break;
      }
    } while (rmr.a(this.jdField_a_of_type_Rmr, this.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData, str, parambhyo));
    for (;;)
    {
      this.jdField_a_of_type_Rmr.jdField_a_of_type_JavaUtilHashMap.remove((String)localObject + "_" + str);
      this.jdField_a_of_type_Rmr.a((String)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
      i = 0;
      while (i < this.jdField_a_of_type_Rmr.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((bhyn)this.jdField_a_of_type_Rmr.jdField_a_of_type_JavaUtilArrayList.get(i)).onDone(parambhyo);
        i += 1;
      }
      QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide failed: id = " + str);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData instanceof MaterialData)) {
        FileUtils.deleteDirectory(this.jdField_a_of_type_Rmr.a((String)localObject, str));
      }
    }
    this.jdField_a_of_type_Rmr.a("onDone", parambhyo);
    int i = parambhyo.a;
    long l1 = parambhyo.h;
    long l2 = parambhyo.g;
    this.jdField_a_of_type_Rmr.a(new String[] { String.valueOf(i), str, String.valueOf(l1 - l2) });
    QLog.d("readinjoy", 2, "mDownloader downLoadFinish");
  }
  
  public void onProgress(bhyo parambhyo)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Rmr.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bhyn)this.jdField_a_of_type_Rmr.jdField_a_of_type_JavaUtilArrayList.get(i)).onProgress(parambhyo);
      i += 1;
    }
    super.onProgress(parambhyo);
    this.jdField_a_of_type_Rmr.a("onProgress", parambhyo);
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Rmr.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((bhyn)this.jdField_a_of_type_Rmr.jdField_a_of_type_JavaUtilArrayList.get(i)).onStart(parambhyo);
      i += 1;
    }
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData instanceof MaterialData)) && (pnn.a() != null)) {
      uic.a(pnn.a()).a((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
    }
    this.jdField_a_of_type_Rmr.a("onStart", parambhyo);
    QLog.d("readinjoy", 2, "mDownloader onStart");
    return super.onStart(parambhyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rms
 * JD-Core Version:    0.7.0.1
 */