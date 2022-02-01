package dov.com.qq.im.capture.paster;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class QIMInformationPasterManager$InformationPasterResDownloader
{
  private QIMInformationPasterManager jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager;
  private ConcurrentHashMap<String, ArrayList<WeakReference<QIMInformationPasterManager.IInformationPasterResDownloaderCallback>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public QIMInformationPasterManager$InformationPasterResDownloader(QIMInformationPasterManager paramQIMInformationPasterManager)
  {
    this.jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager = paramQIMInformationPasterManager;
  }
  
  public void a(@NonNull InfomationFacePackage.Item paramItem, QIMInformationPasterManager.IInformationPasterResDownloaderCallback paramIInformationPasterResDownloaderCallback)
  {
    String str = paramItem.e;
    if ((str == null) || (TextUtils.isEmpty(str)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMInformationPasterManager", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMInformationPasterManager", 2, "startDownloadDynamicText res url: " + str);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if (localArrayList != null)
        {
          paramItem = localArrayList.iterator();
          if (!paramItem.hasNext()) {
            break label292;
          }
          if (((WeakReference)paramItem.next()).get() != paramIInformationPasterResDownloaderCallback) {
            continue;
          }
          i = 1;
          if (i == 0) {
            localArrayList.add(new WeakReference(paramIInformationPasterResDownloaderCallback));
          }
          if (QLog.isColorLevel()) {
            QLog.i("QIMInformationPasterManager", 2, "already put url " + str);
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(paramIInformationPasterResDownloaderCallback));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localArrayList);
      paramIInformationPasterResDownloaderCallback = new HttpNetReq();
      paramIInformationPasterResDownloaderCallback.mCallback = new QIMInformationPasterManager.InformationPasterResDownloader.1(this);
      paramIInformationPasterResDownloaderCallback.mReqUrl = str;
      paramIInformationPasterResDownloaderCallback.mHttpMethod = 0;
      paramIInformationPasterResDownloaderCallback.mOutPath = QIMInformationPasterManager.a(paramItem);
      paramIInformationPasterResDownloaderCallback.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      paramIInformationPasterResDownloaderCallback.setUserData(paramItem);
      AVNetEngine.a().sendReq(paramIInformationPasterResDownloaderCallback);
      return;
      label292:
      int i = 0;
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.InformationPasterResDownloader
 * JD-Core Version:    0.7.0.1
 */