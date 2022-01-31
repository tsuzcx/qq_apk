package dov.com.qq.im.capture.paster;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import anvq;
import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
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
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public QIMInformationPasterManager$InformationPasterResDownloader(QIMInformationPasterManager paramQIMInformationPasterManager)
  {
    this.jdField_a_of_type_DovComQqImCapturePasterQIMInformationPasterManager = paramQIMInformationPasterManager;
  }
  
  public void a(@NonNull InfomationFacePackage.Item paramItem, QIMInformationPasterManager.IInformationPasterResDownloaderCallback paramIInformationPasterResDownloaderCallback)
  {
    String str = paramItem.d;
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
      paramIInformationPasterResDownloaderCallback.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new anvq(this);
      paramIInformationPasterResDownloaderCallback.jdField_a_of_type_JavaLangString = str;
      paramIInformationPasterResDownloaderCallback.jdField_a_of_type_Int = 0;
      paramIInformationPasterResDownloaderCallback.jdField_c_of_type_JavaLangString = QIMInformationPasterManager.a(paramItem);
      paramIInformationPasterResDownloaderCallback.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
      paramIInformationPasterResDownloaderCallback.a(paramItem);
      AVNetEngine.a().a(paramIInformationPasterResDownloaderCallback);
      return;
      label292:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.InformationPasterResDownloader
 * JD-Core Version:    0.7.0.1
 */