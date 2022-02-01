package dov.com.qq.im.capture.paster;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class QIMInformationPasterManager$InformationPasterResDownloader$1
  implements INetEngineListener
{
  QIMInformationPasterManager$InformationPasterResDownloader$1(QIMInformationPasterManager.InformationPasterResDownloader paramInformationPasterResDownloader) {}
  
  public void onResp(NetResp paramNetResp)
  {
    InfomationFacePackage.Item localItem = (InfomationFacePackage.Item)paramNetResp.mReq.getUserData();
    String str1 = localItem.e;
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str1 + " http status:" + paramNetResp.mHttpCode);
    }
    Object localObject;
    String str2;
    if (paramNetResp.mHttpCode == 200)
    {
      localObject = QIMInformationPasterManager.a(localItem);
      QLog.d("QIMInformationPasterManager", 1, "info paster path:" + (String)localObject);
      str2 = FileUtils.c((String)localObject);
      if ((localItem.f == null) || (!localItem.f.equalsIgnoreCase(str2))) {}
    }
    for (boolean bool = QIMInformationPasterManager.InformationPasterResDownloader.a(this.a).c(localItem);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "onResp:" + paramNetResp.mHttpCode + ",isSuccess:" + bool);
      }
      paramNetResp = ((ArrayList)QIMInformationPasterManager.InformationPasterResDownloader.a(this.a).get(str1)).iterator();
      while (paramNetResp.hasNext())
      {
        localObject = (WeakReference)paramNetResp.next();
        if (((WeakReference)localObject).get() != null) {
          ((QIMInformationPasterManager.IInformationPasterResDownloaderCallback)((WeakReference)localObject).get()).a(bool, str1, localItem);
        }
      }
      FileUtils.a((String)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "info paster res md5 error, res md5:" + localItem.f + ",file md5:" + str2);
      }
    }
    QIMInformationPasterManager.InformationPasterResDownloader.a(this.a).remove(str1);
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    String str = ((InfomationFacePackage.Item)???.getUserData()).e;
    float f = (float)(100L * paramLong1 / paramLong2);
    synchronized (QIMInformationPasterManager.InformationPasterResDownloader.a(this.a))
    {
      Iterator localIterator = ((ArrayList)QIMInformationPasterManager.InformationPasterResDownloader.a(this.a).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((QIMInformationPasterManager.IInformationPasterResDownloaderCallback)localWeakReference.get()).a(f, str, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.InformationPasterResDownloader.1
 * JD-Core Version:    0.7.0.1
 */