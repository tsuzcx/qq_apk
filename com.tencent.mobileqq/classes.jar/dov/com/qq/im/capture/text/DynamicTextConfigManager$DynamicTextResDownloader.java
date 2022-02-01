package dov.com.qq.im.capture.text;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
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
  private ConcurrentHashMap<String, ArrayList<WeakReference<DynamicTextConfigManager.IDynamicTextResDownloadCallback>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public DynamicTextConfigManager$DynamicTextResDownloader(DynamicTextConfigManager paramDynamicTextConfigManager)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = paramDynamicTextConfigManager;
  }
  
  private void a(DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    if ((paramDynamicTextFontInfo == null) || (TextUtils.isEmpty(paramDynamicTextFontInfo.c))) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = DynamicTextConfigManager.a.listFiles();
    } while ((arrayOfFile == null) || (arrayOfFile.length == 0));
    int j = arrayOfFile.length;
    int i = 0;
    label40:
    File localFile;
    if (i < j)
    {
      localFile = arrayOfFile[i];
      if (localFile != null) {
        break label63;
      }
    }
    for (;;)
    {
      i += 1;
      break label40;
      break;
      label63:
      String str1 = localFile.getName();
      if (TextUtils.isEmpty(str1)) {
        localFile.delete();
      }
      if (str1.contains("_"))
      {
        String str2 = str1.substring(0, str1.lastIndexOf("_"));
        if ((paramDynamicTextFontInfo.c.equalsIgnoreCase(str2)) && (!str1.equalsIgnoreCase(paramDynamicTextFontInfo.a()))) {
          localFile.delete();
        }
      }
    }
  }
  
  public void a(@NonNull DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo, DynamicTextConfigManager.IDynamicTextResDownloadCallback paramIDynamicTextResDownloadCallback)
  {
    if ((paramDynamicTextFontInfo == null) || (TextUtils.isEmpty(paramDynamicTextFontInfo.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
      }
      return;
    }
    Object localObject = paramDynamicTextFontInfo.a;
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
      paramIDynamicTextResDownloadCallback.mCallback = new DynamicTextConfigManager.DynamicTextResDownloader.1(this);
      paramIDynamicTextResDownloadCallback.mReqUrl = ((String)localObject);
      paramIDynamicTextResDownloadCallback.mHttpMethod = 0;
      paramIDynamicTextResDownloadCallback.mOutPath = DynamicTextConfigManager.a(paramDynamicTextFontInfo);
      paramIDynamicTextResDownloadCallback.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      paramIDynamicTextResDownloadCallback.setUserData(paramDynamicTextFontInfo);
      AVNetEngine.a().sendReq(paramIDynamicTextResDownloadCallback);
      return;
      label268:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextResDownloader
 * JD-Core Version:    0.7.0.1
 */