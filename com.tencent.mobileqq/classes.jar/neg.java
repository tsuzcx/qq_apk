import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class neg
  implements ISPlayerPreDownloader.Listener
{
  ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private final ConcurrentHashMap<Integer, neh> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public void a()
  {
    QLog.d("AVGameVideoPreLoadMgr", 1, "destroy");
    b();
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.destory();
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = null;
    }
  }
  
  public void a(String paramString)
  {
    QLog.d("AVGameVideoPreLoadMgr", 1, "stopPreLoad url:=" + paramString);
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      neh localneh;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localneh = (neh)((Map.Entry)localIterator.next()).getValue();
      } while (!localneh.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString));
      for (paramString = localneh; paramString != null; paramString = null)
      {
        this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.stopPreDownload(paramString.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramString.jdField_a_of_type_Int));
        return;
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    QLog.d("AVGameVideoPreLoadMgr", 1, "preLoadUrl url:=" + paramString);
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getApplication(), 107);
    }
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(paramString, 101, bita.d(paramString));
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.setOnPreDownloadListener(this);
    int i = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.startPreDownload(localSuperPlayerVideoInfo, paramLong1, paramLong2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), new neh(i, paramString));
  }
  
  public void b()
  {
    QLog.d("AVGameVideoPreLoadMgr", 1, "cancelALLPreDoload");
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.stopPreDownload(i);
      }
    }
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {}
  
  public void onPrepareError(int paramInt)
  {
    Object localObject = (neh)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder().append("onPrepareSuccess content:=");
    if (localObject != null) {}
    for (localObject = ((neh)localObject).toString();; localObject = null)
    {
      QLog.d("AVGameVideoPreLoadMgr", 1, (String)localObject);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
      return;
    }
  }
  
  public void onPrepareSuccess(int paramInt)
  {
    Object localObject = (neh)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder().append("onPrepareSuccess content:=");
    if (localObject != null) {}
    for (localObject = ((neh)localObject).toString();; localObject = null)
    {
      QLog.d("AVGameVideoPreLoadMgr", 1, (String)localObject);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     neg
 * JD-Core Version:    0.7.0.1
 */