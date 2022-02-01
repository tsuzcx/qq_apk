package cooperation.liveroom;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class LiveRoomDownloadManager
{
  private static LiveRoomDownloadManager instance;
  
  public static LiveRoomDownloadManager getInstance()
  {
    if (instance == null) {
      instance = new LiveRoomDownloadManager();
    }
    return instance;
  }
  
  public void download(List<String> paramList, Map<String, File> paramMap, boolean paramBoolean, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback)
  {
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)((BrowserAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web")).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    if (localDownloaderInterface != null)
    {
      Bundle localBundle = new Bundle();
      paramDownloadCallback = new LiveRoomDownloadManager.1(this, paramDownloadCallback);
      if (paramBoolean)
      {
        paramList = paramMap.keySet().iterator();
        while (paramList.hasNext())
        {
          Object localObject = (String)paramList.next();
          localObject = new DownloadTask((String)localObject, (File)paramMap.get(localObject));
          ((DownloadTask)localObject).j = true;
          ((DownloadTask)localObject).p = false;
          localDownloaderInterface.a((DownloadTask)localObject, paramDownloadCallback, localBundle);
        }
      }
      paramList = new DownloadTask(paramList, paramMap, "LiveRoomDownloadManager");
      paramList.j = true;
      paramList.p = false;
      localDownloaderInterface.a(paramList, paramDownloadCallback, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager
 * JD-Core Version:    0.7.0.1
 */