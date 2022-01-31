package dov.com.qq.im.capture.text;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import annu;
import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class DynamicTextConfigManager$DynamicTextResDownloader
{
  private DynamicTextConfigManager jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public DynamicTextConfigManager$DynamicTextResDownloader(DynamicTextConfigManager paramDynamicTextConfigManager)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = paramDynamicTextConfigManager;
  }
  
  private void a(DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    if ((paramDynamicTextFontInfo == null) || (TextUtils.isEmpty(paramDynamicTextFontInfo.jdField_c_of_type_JavaLangString))) {
      return;
    }
    File[] arrayOfFile = DynamicTextConfigManager.a.listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    label29:
    File localFile;
    if (i < j)
    {
      localFile = arrayOfFile[i];
      if (localFile != null) {
        break label52;
      }
    }
    for (;;)
    {
      i += 1;
      break label29;
      break;
      label52:
      String str1 = localFile.getName();
      if (TextUtils.isEmpty(str1)) {
        localFile.delete();
      }
      if (str1.contains("_"))
      {
        String str2 = str1.substring(0, str1.lastIndexOf("_"));
        if ((paramDynamicTextFontInfo.jdField_c_of_type_JavaLangString.equalsIgnoreCase(str2)) && (!str1.equalsIgnoreCase(paramDynamicTextFontInfo.a()))) {
          localFile.delete();
        }
      }
    }
  }
  
  public void a(@NonNull DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo, DynamicTextConfigManager.IDynamicTextResDownloadCallback paramIDynamicTextResDownloadCallback)
  {
    if ((paramDynamicTextFontInfo == null) || (TextUtils.isEmpty(paramDynamicTextFontInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
      }
      return;
    }
    Object localObject = paramDynamicTextFontInfo.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "startDownloadDynamicText res url: " + (String)localObject);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
        {
          paramDynamicTextFontInfo = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          localObject = paramDynamicTextFontInfo.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label268;
          }
          if (((WeakReference)((Iterator)localObject).next()).get() != paramIDynamicTextResDownloadCallback) {
            continue;
          }
          i = 1;
          if (i == 0) {
            paramDynamicTextFontInfo.add(new WeakReference(paramIDynamicTextResDownloadCallback));
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(paramIDynamicTextResDownloadCallback));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localArrayList);
      paramIDynamicTextResDownloadCallback = new HttpNetReq();
      paramIDynamicTextResDownloadCallback.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new annu(this);
      paramIDynamicTextResDownloadCallback.jdField_a_of_type_JavaLangString = ((String)localObject);
      paramIDynamicTextResDownloadCallback.jdField_a_of_type_Int = 0;
      paramIDynamicTextResDownloadCallback.jdField_c_of_type_JavaLangString = DynamicTextConfigManager.a(paramDynamicTextFontInfo);
      paramIDynamicTextResDownloadCallback.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
      paramIDynamicTextResDownloadCallback.a(paramDynamicTextFontInfo);
      AVNetEngine.a().a(paramIDynamicTextResDownloadCallback);
      return;
      label268:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextResDownloader
 * JD-Core Version:    0.7.0.1
 */