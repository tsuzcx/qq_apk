package cooperation.liveroom;

import android.os.Bundle;
import batm;
import bato;
import batr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
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
    batr localbatr = ((bato)((BrowserAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web")).getManager(47)).a(1);
    if (localbatr != null)
    {
      Bundle localBundle = new Bundle();
      paramDownloadCallback = new LiveRoomDownloadManager.1(this, paramDownloadCallback);
      if (paramBoolean)
      {
        paramList = paramMap.keySet().iterator();
        while (paramList.hasNext())
        {
          Object localObject = (String)paramList.next();
          localObject = new batm((String)localObject, (File)paramMap.get(localObject));
          ((batm)localObject).j = true;
          ((batm)localObject).p = false;
          localbatr.a((batm)localObject, paramDownloadCallback, localBundle);
        }
      }
      paramList = new batm(paramList, paramMap, "LiveRoomDownloadManager");
      paramList.j = true;
      paramList.p = false;
      localbatr.a(paramList, paramDownloadCallback, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager
 * JD-Core Version:    0.7.0.1
 */